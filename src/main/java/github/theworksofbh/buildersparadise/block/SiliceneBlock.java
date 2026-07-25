package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class SiliceneBlock extends GrapheneBlock{
    public SiliceneBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.defaultBlockState()
                        .setValue(LAYERS, 1)
                        .setValue(WATERLOGGED, false)
                        .setValue(AXIS, Direction.Axis.X)
                        .setValue(POWER, 0)
        );
    }

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final IntegerProperty POWER = BlockStateProperties.POWER;

    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        Direction.Axis axis = state.getValue(AXIS);

        if (direction.getAxis() != axis) {
            return 0;
        }

        return state.getValue(POWER);
    }

    @Override
    protected int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return direction != null;
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AXIS, POWER);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());

        if (state.is(this)) {
            int layers = state.getValue(LAYERS);
            return state.setValue(LAYERS, Math.min(8, layers + 1));
        }

        return this.defaultBlockState()
                .setValue(LAYERS, 1)
                .setValue(WATERLOGGED, false)
                .setValue(AXIS, context.getHorizontalDirection().getAxis());
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
        if (level.isClientSide()) {
            return;
        }

        boolean west = level.getBlockState(pos.west()).is(Blocks.REDSTONE_WIRE)
                || level.getBlockState(pos.west()).is(this);

        boolean east = level.getBlockState(pos.east()).is(Blocks.REDSTONE_WIRE)
                || level.getBlockState(pos.east()).is(this);

        boolean north = level.getBlockState(pos.north()).is(Blocks.REDSTONE_WIRE)
                || level.getBlockState(pos.north()).is(this);

        boolean south = level.getBlockState(pos.south()).is(Blocks.REDSTONE_WIRE)
                || level.getBlockState(pos.south()).is(this);

        BlockState newState = state;

        if (north && south && !(east || west)) {
            newState = newState.setValue(AXIS, Direction.Axis.Z);
        }
        else if (east && west && !(north || south)) {
            newState = newState.setValue(AXIS, Direction.Axis.X);
        }

        if (newState != state) {
            level.setBlock(pos, newState, Block.UPDATE_ALL);
            state = newState;
        }

        Direction.Axis axis = state.getValue(AXIS);

        int incoming;

        if (axis == Direction.Axis.X) {
            incoming = Math.max(
                    level.getSignal(pos.west(), Direction.WEST),
                    level.getSignal(pos.east(), Direction.EAST)
            );
        } else if (axis == Direction.Axis.Z) {
            incoming = Math.max(
                    level.getSignal(pos.north(), Direction.NORTH),
                    level.getSignal(pos.south(), Direction.SOUTH)
            );
        } else {
            incoming = Math.max(
                    level.getSignal(pos.north(), Direction.NORTH),
                    level.getSignal(pos.south(), Direction.SOUTH)
            );
        }

        int newPower = Math.max(0, incoming - state.getValue(LAYERS));

        if (newPower != state.getValue(POWER)) {
            level.setBlock(
                    pos,
                    state.setValue(POWER, newPower),
                    Block.UPDATE_ALL
            );
        }

        super.neighborChanged(state, level, pos, neighborBlock, orientation, movedByPiston);
    }
}
