package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModLanternBlock extends LanternBlock {
    public ModLanternBlock(Properties p_153465_) {
        super(p_153465_);
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
                if (state.is(Blocks.LANTERN)) {
                    level.setBlock(pos, ModBlocks.EXPOSED_IRON_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.EXPOSED_IRON_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.WEATHERED_IRON_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.WEATHERED_IRON_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.RUSTED_IRON_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                }

                if (state.is(Blocks.SOUL_LANTERN)) {
                    level.setBlock(pos, ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.RUSTED_IRON_SOUL_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                }

                if (state.is(ModBlocks.IRON_FIRE_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get())) {
                    level.setBlock(pos, ModBlocks.RUSTED_IRON_FIRE_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
                }
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
