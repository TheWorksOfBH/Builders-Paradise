package github.theworksofbh.buildersparadise.compat.bop;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.block.ThermalCalciteBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

import java.util.OptionalInt;

public class ThermalCalciteFenceBlock extends FenceBlock {
    public static final IntegerProperty DISTANCE = ThermalCalciteBlock.DISTANCE;

    public ThermalCalciteFenceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand)
    {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (worldIn.getBlockState(pos.above()).getFluidState().getType() == Fluids.WATER && worldIn.getBlockState(pos.above()).getFluidState().getAmount() == 8)
        {
            worldIn.addAlwaysVisibleParticle(ParticleTypes.BUBBLE_COLUMN_UP, (double) (pos.getX() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 2.0D)), (double) (pos.getY() + 1.0D), (double) (pos.getZ() + 0.5D + ((rand.nextDouble() - rand.nextDouble()) / 2.0D)), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void tick(BlockState p_221369_, ServerLevel p_221370_, BlockPos p_221371_, RandomSource p_221372_) {
        p_221370_.setBlock(p_221371_, updateDistance(p_221369_, p_221370_, p_221371_), 3);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        if (stack.is(ItemTags.PICKAXES) && state.getBlock() == BOPBlocks.THERMAL_CALCITE)
        {
            if (!level.isClientSide())
            {
                int distance = state.getValue(DISTANCE);
                level.playSound((Player)null, pos, SoundEvents.CALCITE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlock(pos, BOPBlocks.THERMAL_CALCITE_VENT.defaultBlockState().setValue(DISTANCE, distance), 11);
                stack.hurtAndBreak(1, player, hand);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            }

            return InteractionResult.SUCCESS;
        }
        else
        {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction dir, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        BlockState updated =
                dir.getAxis().isHorizontal()
                        ? state.setValue(
                        PROPERTY_BY_DIRECTION.get(dir),
                        this.connectsTo(
                                neighbourState,
                                neighbourState.isFaceSturdy(level, neighbourPos, dir.getOpposite()),
                                dir.getOpposite()
                        )
                )
                        : super.updateShape(state, level, ticks, pos, dir, neighbourPos, neighbourState, random);

        return withUpdatedDistance(updated, (LevelAccessor) level, pos);
    }


    protected BlockState withUpdatedDistance(BlockState state, LevelAccessor level, BlockPos pos) {
        return updateDistance(state, level, pos);
    }

    private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
        int i = 5;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            blockpos$mutableblockpos.setWithOffset(p_54438_, direction);
            i = Math.min(i, getDistanceAt(p_54437_.getBlockState(blockpos$mutableblockpos)) + 1);
            if (i == 1) {
                break;
            }
        }

        return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
    }

    private static int getDistanceAt(BlockState p_54464_) {
        return getOptionalDistanceAt(p_54464_).orElse(5);
    }

    public static OptionalInt getOptionalDistanceAt(BlockState p_277868_) {
        if (p_277868_.getFluidState().getType() == Fluids.WATER || p_277868_.getFluidState().getType() == Fluids.LAVA || p_277868_.getBlock() instanceof IceBlock || p_277868_.getBlock() instanceof MagmaBlock) {
            return OptionalInt.of(0);
        } else {
            return p_277868_.hasProperty(DISTANCE) ? OptionalInt.of(p_277868_.getValue(DISTANCE)) : OptionalInt.empty();
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{NORTH, EAST, WEST, SOUTH, WATERLOGGED, DISTANCE});
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluid = level.getFluidState(pos);

        BlockPos north = pos.north();
        BlockPos east  = pos.east();
        BlockPos south = pos.south();
        BlockPos west  = pos.west();

        BlockState northState = level.getBlockState(north);
        BlockState eastState  = level.getBlockState(east);
        BlockState southState = level.getBlockState(south);
        BlockState westState  = level.getBlockState(west);

        BlockState state = this.defaultBlockState()
                .setValue(NORTH, this.connectsTo(northState, northState.isFaceSturdy(level, north, Direction.SOUTH), Direction.SOUTH))
                .setValue(EAST,  this.connectsTo(eastState,  eastState.isFaceSturdy(level, east,  Direction.WEST),  Direction.WEST))
                .setValue(SOUTH, this.connectsTo(southState, southState.isFaceSturdy(level, south, Direction.NORTH), Direction.NORTH))
                .setValue(WEST,  this.connectsTo(westState,  westState.isFaceSturdy(level, west,  Direction.EAST),  Direction.EAST))
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);

        return updateDistance(state, context.getLevel(), context.getClickedPos());
    }

}
