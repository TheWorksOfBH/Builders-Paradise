package github.theworksofbh.buildersparadise.mixins;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Set;

@Deprecated // Don't expect this shit to work
@Mixin(PoiTypes.class)
public abstract class PoiTypesMixins {

    @Unique
    private static final Set<BlockState> CARTOGRAPHY_TABLES = ImmutableList.of(
            ModBlocks.OAK_CARTOGRAPHY_TABLE.get(),
            ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.BIRCH_CARTOGRAPHY_TABLE.get(),
            ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.ACACIA_CARTOGRAPHY_TABLE.get(),
            Blocks.CARTOGRAPHY_TABLE,
            ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.get(),
            ModBlocks.WARPED_CARTOGRAPHY_TABLE.get(),
            ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.CHERRY_CARTOGRAPHY_TABLE.get(),
            ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.get(),
            ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    @Unique
    private static final Set<BlockState> FLETCHING_TABLES = ImmutableList.of(
            ModBlocks.OAK_FLETCHING_TABLE.get(),
            ModBlocks.SPRUCE_FLETCHING_TABLE.get(),
            ModBlocks.BIRCH_FLETCHING_TABLE.get(),
            ModBlocks.JUNGLE_FLETCHING_TABLE.get(),
            ModBlocks.ACACIA_FLETCHING_TABLE.get(),
            ModBlocks.DARK_OAK_FLETCHING_TABLE.get(),
            ModBlocks.CRIMSON_FLETCHING_TABLE.get(),
            ModBlocks.WARPED_FLETCHING_TABLE.get(),
            ModBlocks.MANGROVE_FLETCHING_TABLE.get(),
            ModBlocks.CHERRY_FLETCHING_TABLE.get(),
            ModBlocks.BAMBOO_FLETCHING_TABLE.get(),
            ModBlocks.PALE_OAK_FLETCHING_TABLE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());


    @Definition(id = "register", method = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;register(Lnet/minecraft/core/Registry;Lnet/minecraft/resources/ResourceKey;Ljava/util/Set;II)Lnet/minecraft/world/entity/ai/village/poi/PoiType;")
    @Definition(id = "registry", local = @Local(type = Registry.class, argsOnly = true))
    @Definition(id = "CARTOGRAPHER", field = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;CARTOGRAPHER:Lnet/minecraft/resources/ResourceKey;")
    @Definition(id = "getBlockStates", method = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;getBlockStates(Lnet/minecraft/world/level/block/Block;)Ljava/util/Set;")
    @Definition(id = "CARTOGRAPHY_TABLE", field = "Lnet/minecraft/world/level/block/Blocks;CARTOGRAPHY_TABLE:Lnet/minecraft/world/level/block/Block;")
    @Expression("register(registry, CARTOGRAPHER, getBlockStates(CARTOGRAPHY_TABLE), ?, ?)")
    @ModifyArg(method = "bootstrap", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static Set<BlockState> modifyCartographerPOI(Set<BlockState> blockState) {
        return CARTOGRAPHY_TABLES;
    }

    @Definition(id = "register", method = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;register(Lnet/minecraft/core/Registry;Lnet/minecraft/resources/ResourceKey;Ljava/util/Set;II)Lnet/minecraft/world/entity/ai/village/poi/PoiType;")
    @Definition(id = "registry", local = @Local(type = Registry.class, argsOnly = true))
    @Definition(id = "FLETCHER", field = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;FLETCHER:Lnet/minecraft/resources/ResourceKey;")
    @Definition(id = "FLETCHING_TABLE", field = "Lnet/minecraft/world/level/block/Blocks;FLETCHING_TABLE:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "getBlockStates", method = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;getBlockStates(Lnet/minecraft/world/level/block/Block;)Ljava/util/Set;")
    @Expression("register(registry, FLETCHER, getBlockStates(FLETCHING_TABLE), ?, ?)")
    @ModifyArg(method = "bootstrap", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static Set<BlockState> modifyFletcherPOI(Set<BlockState> blockState) {
        return FLETCHING_TABLES;
    }
}
