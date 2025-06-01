package github.theworksofbh.buildersparadise.mixins;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixins {



    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (state.is(Blocks.IRON_BLOCK)) {
            level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get().defaultBlockState(), Block.UPDATE_ALL);
        } else if (state.is(Blocks.IRON_DOOR)) {
            level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
        } else if (state.is(Blocks.IRON_TRAPDOOR)) {
            level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
        } else if (state.is(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
            level.setBlock(pos, ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
        } else if (state.is(Blocks.IRON_BARS)) {
            level.setBlock(pos, ModBlocks.MILDLY_RUSTED_IRON_BARS.get().withPropertiesOf(state), Block.UPDATE_ALL);
        }
    }

}
