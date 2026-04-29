package github.theworksofbh.buildersparadise.mixins.compat.bop;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.init.ModItems;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import github.theworksofbh.buildersparadise.compat.bop.CompatModTrimMaterials;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Mixin(ModItems.class)
public class BOPItemsMixins {

    @Definition(id = "ROSE_QUARTZ_CHUNK", field = "Lbiomesoplenty/api/item/BOPItems;ROSE_QUARTZ_CHUNK:Lnet/minecraft/world/item/Item;")
    @Definition(id = "registerItem", method = "Lbiomesoplenty/init/ModItems;registerItem(Ljava/util/function/BiConsumer;Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/Item;")
    @Expression("ROSE_QUARTZ_CHUNK = @(registerItem(?, ?, ?, ?))")
    @ModifyArg(method = "registerItems", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static Item.Properties modifyRoseQuartzProperties(Item.Properties properties) {
        return properties.trimMaterial(CompatModTrimMaterials.ROSE_QUARTZ);
    }

    @WrapMethod(method = "registerBlock(Ljava/util/function/BiConsumer;Lnet/minecraft/world/level/block/Block;Ljava/util/function/BiFunction;)Lnet/minecraft/world/item/Item;")
    private static Item modifyBlockItem(BiConsumer<Identifier, Item> func, Block block, BiFunction<Block, Item.Properties, Item> factory, Operation<Item> original) {
        if (block == BOPBlocks.GLOWWORM_SILK) {
            return ModItems.registerBlock(func, block, factory, new Item.Properties().trimMaterial(CompatModTrimMaterials.GLOWWORM_SILK));
        } else {
            return original.call(func, block, factory);
        }
    }
}
