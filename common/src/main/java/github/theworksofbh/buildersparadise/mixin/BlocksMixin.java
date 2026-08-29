package github.theworksofbh.buildersparadise.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import github.theworksofbh.buildersparadise.blocks.types.*;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Function;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Shadow
    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @WrapMethod(method = "register(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block changeBlockTypes(ResourceKey<Block> id, BlockBehaviour.Properties properties, Operation<Block> original) {
        if (id == BlockItemIds.IRON_BLOCK.block()) {
            return register(id, (props) -> new RustingIronFullBlock(RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else {
            return original.call(id, properties);
        }
    }

    @WrapMethod(method = "register(Lnet/minecraft/references/BlockItemId;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block changeBlockTypes(BlockItemId id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties, Operation<Block> original) {
        if (id == BlockItemIds.IRON_BARS) {
            return register(id.block(), (props) -> new RustingIronBarsBlock(RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else if (id == BlockItemIds.IRON_DOOR) {
            return register(id.block(), (props) -> new RustingIronDoorBlock(BlockSetType.IRON, RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else if (id == BlockItemIds.IRON_TRAPDOOR) {
            return register(id.block(), (props) -> new RustingIronTrapDoorBlock(BlockSetType.IRON, RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else if (id == BlockItemIds.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            return register(id.block(), (props) -> new RustingIronWeightedPressurePlateBlock(150, RustingIron.WeatherState.UNAFFECTED, BlockSetType.IRON, props), properties);
        } else if (id == BlockItemIds.IRON_CHAIN) {
            return register(id.block(), (props) -> new RustingIronChainBlock(RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else if (id == BlockItemIds.LANTERN || id == BlockItemIds.SOUL_LANTERN) {
            return register(id.block(), (props) -> new RustingIronLanternBlock(RustingIron.WeatherState.UNAFFECTED, props), properties);
        } else {
            return original.call(id, factory, properties);
        }
    }
}
