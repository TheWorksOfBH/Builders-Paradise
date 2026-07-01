package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class ModTrimMaterials {
    public static ResourceKey<TrimMaterial> registerMaterial(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> resourceKey, Style style, MaterialAssetGroup assetGroup) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.identifier())).withStyle(style);
        context.register(resourceKey, new TrimMaterial(assetGroup, component));
    }

    public static final ResourceKey<TrimMaterial> ZINC = registerMaterial("zinc");
    public static final ResourceKey<TrimMaterial> SILVER = registerMaterial("silver");
    public static final ResourceKey<TrimMaterial> TIN = registerMaterial("tin");
    public static final ResourceKey<TrimMaterial> TUNGSTEN = registerMaterial("tungsten");
    public static final ResourceKey<TrimMaterial> PLATINUM = registerMaterial("platinum");
    public static final ResourceKey<TrimMaterial> LEAD = registerMaterial("lead");
    public static final ResourceKey<TrimMaterial> BISMUTH = registerMaterial("bismuth");
    public static final ResourceKey<TrimMaterial> URANIUM = registerMaterial("uranium");
    public static final ResourceKey<TrimMaterial> BRONZE = registerMaterial("bronze");
    public static final ResourceKey<TrimMaterial> BRASS = registerMaterial("brass");
    public static final ResourceKey<TrimMaterial> STEEL = registerMaterial("steel");
    public static final ResourceKey<TrimMaterial> SCULK = registerMaterial("sculk");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ZINC, Style.EMPTY.withColor(9079434), ModMaterialAssetGroups.ZINC);
        register(context, SILVER, Style.EMPTY.withColor(14606046), ModMaterialAssetGroups.SILVER);
        register(context, TIN, Style.EMPTY.withColor(11776930), ModMaterialAssetGroups.TIN);
        register(context, TUNGSTEN, Style.EMPTY.withColor(5528675), ModMaterialAssetGroups.TUNGSTEN);
        register(context, PLATINUM, Style.EMPTY.withColor(13292510), ModMaterialAssetGroups.PLATINUM);
        register(context, LEAD, Style.EMPTY.withColor(2039583), ModMaterialAssetGroups.LEAD);
        register(context, BISMUTH, Style.EMPTY.withColor(2513239), ModMaterialAssetGroups.BISMUTH);
        register(context, URANIUM, Style.EMPTY.withColor(12446638), ModMaterialAssetGroups.URANIUM);
        register(context, BRONZE, Style.EMPTY.withColor(4337440), ModMaterialAssetGroups.BRONZE);
        register(context, BRASS, Style.EMPTY.withColor(14930086), ModMaterialAssetGroups.BRASS);
        register(context, STEEL, Style.EMPTY.withColor(4671303), ModMaterialAssetGroups.STEEL);
        register(context, SCULK, Style.EMPTY.withColor(11813), ModMaterialAssetGroups.SCULK);
    }
}
