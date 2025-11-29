package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

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
        if (level.random.nextFloat() < BlockOxidationValues.IRON) {
            if (state.is(Blocks.IRON_DOOR)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_IRON_DOOR.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_IRON_DOOR.get())) {
                level.setBlock(pos, ModBlocks.RUSTED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        } else if (level.random.nextFloat() < BlockOxidationValues.ZINC) {
            if (state.is(ModBlocks.ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.EXPOSED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.EXPOSED_ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.WEATHERED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.WEATHERED_ZINC_DOOR.get())) {
                level.setBlock(pos, ModBlocks.CORRODED_ZINC_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }
}
