package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class ModDoorBlock extends DoorBlock {
    public ModDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRandom().nextFloat() < BlockOxidationValues.IRON) {
            if (isGalvanized(level, pos, state)) {

            } else {
                if (state.is(Blocks.IRON_DOOR)) {
                    level.setBlock(pos, ModBlocks.EXPOSED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.EXPOSED_IRON_DOOR.get())) {
                    level.setBlock(pos, ModBlocks.WEATHERED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
                } else if (state.is(ModBlocks.WEATHERED_IRON_DOOR.get())) {
                    level.setBlock(pos, ModBlocks.RUSTED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
                }
            }
        } else if (level.getRandom().nextFloat() < BlockOxidationValues.ZINC) {
            if (state.is(ModBlocks.ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.CORRODED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }

    private static boolean hasGalvanizingNeighbor(LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);

            if (neighborState.is(ModBlockTags.GALVANIZES_IRON)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isGalvanized(LevelReader level, BlockPos pos, BlockState state) {
        if (hasGalvanizingNeighbor(level, pos)) {
            return true;
        }

        if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
            DoubleBlockHalf half = state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
            BlockPos otherHalfPos = (half == DoubleBlockHalf.LOWER)
                    ? pos.above()
                    : pos.below();

            if (hasGalvanizingNeighbor(level, otherHalfPos)) {
                return true;
            }
        }

        return false;
    }
}
