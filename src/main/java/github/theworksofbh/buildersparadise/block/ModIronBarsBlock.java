package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModIronBarsBlock extends IronBarsBlock {
    public ModIronBarsBlock(Properties p_54198_) {
        super(p_54198_);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.random.nextFloat() < 0.05296323F) {
            if (state.is(Blocks.IRON_BARS)) {
                level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_BARS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.MILDLY_RUSTED_IRON_BARS.get())) {
                level.setBlock(pos, ModBlocks.MODERATELY_RUSTED_IRON_BARS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(ModBlocks.MODERATELY_RUSTED_IRON_BARS.get())) {
                level.setBlock(pos, ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }
}
