package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.entity.PrimedNuke;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class NukeBlock extends TntBlock {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;


    public NukeBlock(Properties p_57422_) {
        super(p_57422_);
        this.registerDefaultState(this.defaultBlockState().setValue(UNSTABLE, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public void wasExploded(ServerLevel p_364953_, BlockPos p_57442_, Explosion p_57443_) {
        PrimedNuke primedNuke = new PrimedNuke(p_364953_, (double)p_57442_.getX() + (double)0.5F, (double)p_57442_.getY(), (double)p_57442_.getZ() + (double)0.5F, p_57443_.getIndirectSourceEntity());
        int i = primedNuke.getFuse();
        primedNuke.setFuse((short)(p_364953_.random.nextInt(i / 4) + i / 8));
        p_364953_.addFreshEntity(primedNuke);
    }

    @Deprecated
    private static boolean prime(Level level, BlockPos pos, @Nullable LivingEntity entity) {
        if (level instanceof ServerLevel serverlevel) {
            if (serverlevel.getGameRules().getBoolean(GameRules.RULE_TNT_EXPLODES)) {
                PrimedNuke primedNuke = new PrimedNuke(level, (double)pos.getX() + (double)0.5F, (double)pos.getY(), (double)pos.getZ() + (double)0.5F, entity);
                level.addFreshEntity(primedNuke);
                level.playSound((Entity)null, primedNuke.getX(), primedNuke.getY(), primedNuke.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(entity, GameEvent.PRIME_FUSE, pos);
                return true;
            }
        }

        return false;
    }

    public static boolean prime(Level level, BlockPos pos) {
        return prime(level, pos, (LivingEntity)null);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack p_316149_, BlockState p_316217_, Level p_316520_, BlockPos p_316601_, Player p_316770_, InteractionHand p_316393_, BlockHitResult p_316532_) {
        if (!p_316149_.is(Items.FLINT_AND_STEEL) && !p_316149_.is(Items.FIRE_CHARGE)) {
            return super.useItemOn(p_316149_, p_316217_, p_316520_, p_316601_, p_316770_, p_316393_, p_316532_);
        } else {
            this.onCaughtFire(p_316217_, p_316520_, p_316601_, p_316532_.getDirection(), p_316770_);
            p_316520_.setBlock(p_316601_, Blocks.AIR.defaultBlockState(), 11);
            Item item = p_316149_.getItem();
            if (p_316149_.is(Items.FLINT_AND_STEEL)) {
                p_316149_.hurtAndBreak(1, p_316770_, LivingEntity.getSlotForHand(p_316393_));
            } else {
                p_316149_.consume(1, p_316770_);
            }

            p_316770_.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return super.isEnabled(enabledFeatures);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, UNSTABLE});
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public boolean onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        return prime(world, pos, igniter);
    }
}
