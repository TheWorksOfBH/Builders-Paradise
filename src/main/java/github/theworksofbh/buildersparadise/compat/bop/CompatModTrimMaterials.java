package github.theworksofbh.buildersparadise.compat.bop;

import biomesoplenty.api.BOPAPI;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class CompatModTrimMaterials {
    public static ResourceKey<TrimMaterial> registerMaterial(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(BOPAPI.MOD_ID, name));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> resourceKey, Style style, MaterialAssetGroup assetGroup) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.identifier())).withStyle(style);
        context.register(resourceKey, new TrimMaterial(assetGroup, component));
    }

    public static final ResourceKey<TrimMaterial> ROSE_QUARTZ = registerMaterial("rose_quartz");
    public static final ResourceKey<TrimMaterial> GLOWWORM_SILK = registerMaterial("glowworm_silk");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ROSE_QUARTZ, Style.EMPTY.withColor(14891617), CompatModMaterialAssetGroups.ROSE_QUARTZ);
        register(context, GLOWWORM_SILK, Style.EMPTY.withColor(5422818), CompatModMaterialAssetGroups.GLOWWORM_SILK);
    }
}
