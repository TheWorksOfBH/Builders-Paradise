package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModGrateBlock extends WaterloggedTransparentBlock {

    public ModGrateBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRandom().nextFloat() < BlockOxidationValues.IRON) {
            if (isGalvanized(level, pos)) {

            } else {
                if (state.is(ModBlocks.IRON_GRATE.get())) {
                    level.setBlock(pos, ModBlocks.EXPOSED_IRON_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.EXPOSED_IRON_GRATE.get())) {
                    level.setBlock(pos, ModBlocks.WEATHERED_IRON_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.WEATHERED_IRON_GRATE.get())) {
                    level.setBlock(pos, ModBlocks.RUSTED_IRON_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
                }
            }
        } else if (level.getRandom().nextFloat() < BlockOxidationValues.ZINC) {
            if (state.is(ModBlocks.ZINC_GRATE.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_ZINC_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_ZINC_GRATE.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_ZINC_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_ZINC_GRATE.get())) {
                level.setBlock(pos, ModBlocks.CORRODED_ZINC_GRATE.get().defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }

    private static boolean isGalvanized(LevelReader levelReader, BlockPos blockPos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighbourPos = blockPos.relative(direction);
            BlockState neighbourState = levelReader.getBlockState(neighbourPos);

            if (neighbourState.is(ModBlockTags.GALVANIZES_IRON)) {
                return true;
            }
        }
        return false;
    }
}
