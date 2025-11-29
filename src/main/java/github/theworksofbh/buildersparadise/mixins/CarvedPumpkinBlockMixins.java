package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixins {
    @Definition(id = "hasState", method = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;")
    @Definition(id = "forBlock", method = "Lnet/minecraft/world/level/block/state/predicate/BlockStatePredicate;forBlock(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/world/level/block/state/predicate/BlockStatePredicate;")
    @Definition(id = "IRON_BLOCK", field = "Lnet/minecraft/world/level/block/Blocks;IRON_BLOCK:Lnet/minecraft/world/level/block/Block;")
    @Expression("hasState(forBlock(IRON_BLOCK))")
    @ModifyExpressionValue(method = "getOrCreateIronGolemBase", at = @At(value = "MIXINEXTRAS:EXPRESSION", target = "forBlock(IRON_BLOCK)"))
    private Predicate<BlockInWorld> modifyGetOrCreateIronGolemBase(Predicate<BlockInWorld> original) {
        return original.or(BlockInWorld.hasState((blockState -> blockState.is(ModBlockTags.IRON))));
    }

    @Definition(id = "hasState", method = "Lnet/minecraft/world/level/block/state/pattern/BlockInWorld;hasState(Ljava/util/function/Predicate;)Ljava/util/function/Predicate;")
    @Definition(id = "forBlock", method = "Lnet/minecraft/world/level/block/state/predicate/BlockStatePredicate;forBlock(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/world/level/block/state/predicate/BlockStatePredicate;")
    @Definition(id = "IRON_BLOCK", field = "Lnet/minecraft/world/level/block/Blocks;IRON_BLOCK:Lnet/minecraft/world/level/block/Block;")
    @Expression("hasState(forBlock(IRON_BLOCK))")
    @ModifyExpressionValue(method = "getOrCreateIronGolemFull", at = @At(value = "MIXINEXTRAS:EXPRESSION", target = "forBlock(IRON_BLOCK)"))
    private Predicate<BlockInWorld> modifyGetOrCreateIronGolemFull(Predicate<BlockInWorld> original) {
        return original.or(BlockInWorld.hasState((blockState -> blockState.is(ModBlockTags.IRON))));
    }
}
