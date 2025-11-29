package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModPressurePlateBlock extends WeightedPressurePlateBlock {

    public ModPressurePlateBlock(int maxWeight, BlockSetType type, Properties properties) {
        super(maxWeight, type, properties);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.random.nextFloat() < BlockOxidationValues.IRON) {
            if (state.is(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
                level.setBlock(pos, ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get())) {
                level.setBlock(pos, ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        } else if (level.random.nextFloat() < BlockOxidationValues.ZINC) {
            if (state.is(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())) {
                level.setBlock(pos, ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }
}
