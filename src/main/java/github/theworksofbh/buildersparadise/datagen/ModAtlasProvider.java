package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModMaterialAssetGroups;
import github.theworksofbh.buildersparadise.items.ModTrimMaterials;
import net.minecraft.client.data.AtlasProvider;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SpriteMapper;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.AtlasIds;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.item.equipment.trim.TrimPatterns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModAtlasProvider extends AtlasProvider {
    private final PackOutput.PathProvider pathProvider;
    public static final List<ModTrimMaterialData> MOD_TRIM_MATERIAL_MODELS = List.of(
            new ModTrimMaterialData(ModMaterialAssetGroups.ZINC, ModTrimMaterials.ZINC),
            new ModTrimMaterialData(ModMaterialAssetGroups.SILVER, ModTrimMaterials.SILVER),
            new ModTrimMaterialData(ModMaterialAssetGroups.TIN, ModTrimMaterials.TIN),
            new ModTrimMaterialData(ModMaterialAssetGroups.TUNGSTEN, ModTrimMaterials.TUNGSTEN),
            new ModTrimMaterialData(ModMaterialAssetGroups.PLATINUM, ModTrimMaterials.PLATINUM),
            new ModTrimMaterialData(ModMaterialAssetGroups.LEAD, ModTrimMaterials.LEAD),
            new ModTrimMaterialData(ModMaterialAssetGroups.BISMUTH, ModTrimMaterials.BISMUTH),
            new ModTrimMaterialData(ModMaterialAssetGroups.URANIUM, ModTrimMaterials.URANIUM),
            new ModTrimMaterialData(ModMaterialAssetGroups.BRONZE, ModTrimMaterials.BRONZE),
            new ModTrimMaterialData(ModMaterialAssetGroups.BRASS, ModTrimMaterials.BRASS),
            new ModTrimMaterialData(ModMaterialAssetGroups.STEEL, ModTrimMaterials.STEEL),
            new ModTrimMaterialData(ModMaterialAssetGroups.SCULK, ModTrimMaterials.SCULK)
    );

    public ModAtlasProvider(PackOutput output) {
        super(output);
        this.pathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "atlases");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return CompletableFuture.allOf(
                storeAtlas(cachedOutput, AtlasIds.ARMOR_TRIMS, List.of(new PalettedPermutations(patternTextures(), Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"), TRIM_PALETTE_VALUES))),
                storeAtlas(cachedOutput, AtlasIds.ITEMS, itemsList())
        );
    }

    private static List<Identifier> patternTextures() {
        List<Identifier> list = new ArrayList<>(VANILLA_PATTERNS.size() * HUMANOID_LAYERS.size());

        for (ResourceKey<TrimPattern> resourcekey : VANILLA_PATTERNS) {
            Identifier identifier = TrimPatterns.defaultAssetId(resourcekey);

            for (EquipmentClientInfo.LayerType equipmentclientinfo$layertype : HUMANOID_LAYERS) {
                list.add(identifier.withPath(p_399824_ -> equipmentclientinfo$layertype.trimAssetPrefix() + "/" + p_399824_));
            }
        }

        return list;
    }

    private static SpriteSource forMapper(SpriteMapper mapper) {
        return new DirectoryLister(mapper.prefix(), mapper.prefix() + "/");
    }

    private static List<SpriteSource> itemsList() {
        return List.of(forMapper(Sheets.ITEMS_MAPPER), new PalettedPermutations(List.of(ItemModelGenerators.TRIM_PREFIX_HELMET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, ItemModelGenerators.TRIM_PREFIX_BOOTS), Identifier.withDefaultNamespace("trims/color_palettes/trim_palette"), TRIM_PALETTE_VALUES));
    }

    private static Stream<MaterialAssetGroup.AssetInfo> extractAllMaterialAssets() {
        return ItemModelGenerators.TRIM_MATERIAL_MODELS
                .stream()
                .map(ItemModelGenerators.TrimMaterialData::assets)
                .flatMap(p_400261_ -> Stream.concat(Stream.of(p_400261_.base()), p_400261_.overrides().values().stream()))
                .sorted(Comparator.comparing(MaterialAssetGroup.AssetInfo::suffix));
    }
    private static Stream<MaterialAssetGroup.AssetInfo> extractModMaterialAssets() {
        return MOD_TRIM_MATERIAL_MODELS
                .stream()
                .map(ModTrimMaterialData::assets)
                .flatMap(p_400261_ -> Stream.concat(Stream.of(p_400261_.base()), p_400261_.overrides().values().stream()))
                .sorted(Comparator.comparing(MaterialAssetGroup.AssetInfo::suffix));
    }

    private static final Map<String, Identifier> TRIM_PALETTE_VALUES =
            Stream.concat(
                            extractAllMaterialAssets().map(info -> Map.entry("minecraft", info)),
                            extractModMaterialAssets().map(info -> Map.entry(BuildersParadise.MODID, info))
                    )
                    .collect(Collectors.toMap(
                            e -> e.getValue().suffix(),
                            e -> Identifier.fromNamespaceAndPath(e.getKey(), "trims/color_palettes/" + e.getValue().suffix())
                    ));

    private static final List<ResourceKey<TrimPattern>> VANILLA_PATTERNS = List.of(
            TrimPatterns.SENTRY,
            TrimPatterns.DUNE,
            TrimPatterns.COAST,
            TrimPatterns.WILD,
            TrimPatterns.WARD,
            TrimPatterns.EYE,
            TrimPatterns.VEX,
            TrimPatterns.TIDE,
            TrimPatterns.SNOUT,
            TrimPatterns.RIB,
            TrimPatterns.SPIRE,
            TrimPatterns.WAYFINDER,
            TrimPatterns.SHAPER,
            TrimPatterns.SILENCE,
            TrimPatterns.RAISER,
            TrimPatterns.HOST,
            TrimPatterns.FLOW,
            TrimPatterns.BOLT
    );
    private static final List<EquipmentClientInfo.LayerType> HUMANOID_LAYERS = List.of(
            EquipmentClientInfo.LayerType.HUMANOID, EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS
    );



    public static record ModTrimMaterialData(MaterialAssetGroup assets, ResourceKey<TrimMaterial> materialKey) {
    }

    private CompletableFuture<?> storeAtlas(CachedOutput p_399787_, Identifier p_468894_, List<SpriteSource> p_399735_) {
        return DataProvider.saveStable(p_399787_, SpriteSources.FILE_CODEC, p_399735_, this.pathProvider.json(p_468894_));
    }


}
