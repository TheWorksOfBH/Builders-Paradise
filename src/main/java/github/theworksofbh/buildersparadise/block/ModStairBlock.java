package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModStairBlock extends StairBlock {


    public ModStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.random.nextFloat() < 0.05296323F) {
            if (state.is(ModBlocks.IRON_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        } else if (level.random.nextFloat() < 0.06347294F) {
            if (state.is(ModBlocks.ZINC_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get())) {
                level.setBlock(pos, ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }
}
