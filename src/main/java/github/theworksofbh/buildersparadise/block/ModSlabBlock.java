package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModSlabBlock extends SlabBlock {

    public ModSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.random.nextFloat() < BlockOxidationValues.IRON) {
            if (state.is(ModBlocks.CUT_IRON_SLAB.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_CUT_IRON_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_CUT_IRON_SLAB.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_CUT_IRON_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_CUT_IRON_SLAB.get())) {
                level.setBlock(pos, ModBlocks.RUSTED_CUT_IRON_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        } else if (level.random.nextFloat() < BlockOxidationValues.ZINC) {
            if (state.is(ModBlocks.CUT_ZINC_SLAB.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_CUT_ZINC_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_CUT_ZINC_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get())) {
                level.setBlock(pos, ModBlocks.CORRODED_CUT_ZINC_SLAB.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }
}
