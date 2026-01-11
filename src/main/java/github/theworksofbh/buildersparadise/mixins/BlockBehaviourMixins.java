package github.theworksofbh.buildersparadise.mixins;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixins {

    @Unique
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

    @Unique
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


    @Inject(at = @At("HEAD"), method = "randomTick", cancellable = true)
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (isGalvanized(level, pos, state)) {

        } else {
            if (state.is(Blocks.IRON_BLOCK)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON.get().defaultBlockState(), Block.UPDATE_ALL);
            } else if (state.is(Blocks.IRON_DOOR)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_DOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.IRON_TRAPDOOR)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_TRAPDOOR.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
                level.setBlock(pos, ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.IRON_BARS)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_BARS.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.IRON_CHAIN)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_CHAIN.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.LANTERN)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
            } else if (state.is(Blocks.SOUL_LANTERN)) {
                level.setBlock(pos, ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get().withPropertiesOf(state), Block.UPDATE_ALL);
            }
        }
    }

}
