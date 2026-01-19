package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import github.theworksofbh.buildersparadise.entity.RisingBlockEntity;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class PumiceBlock extends Block {

    public PumiceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {super.onPlace(state, level, pos, oldState, isMoving);

        if (level.isClientSide()) return;

        if (level.getFluidState(pos.above()).is(Fluids.WATER)) {
            spawnEntity(level, pos, state);
        }
    }

    private void spawnEntity(Level level, BlockPos pos, BlockState state) {
        RisingBlockEntity entity = new RisingBlockEntity(
                level,
                pos.getX() + 0.5,
                pos.getY(),
                pos.getZ() + 0.5,
                state
        );

        level.addFreshEntity(entity);
        level.removeBlock(pos, false);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, orientation, movedByPiston);

        if (level.isClientSide()) return;
        if (!level.getFluidState(pos.above()).is(Fluids.WATER)) return;
        spawnEntity(level, pos, state);
    }
}
