
package github.theworksofbh.buildersparadise.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

public final class ModBiomeModifiers {
    private ModBiomeModifiers() {
    }

    public static void register() {
        addOverworldOre(ModPlacedFeatures.ZINC_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.SILVER_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.TIN_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.TUNGSTEN_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.DEEP_TUNGSTEN_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.PLATINUM_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.LEAD_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.URANIUM_ORE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.GABBRO_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.RHYOLITE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.GRAPHITE_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.CARBON_PLACED_KEY);
        addOverworldOre(ModPlacedFeatures.SAPPHIRE_ORE_PLACED_KEY);

        addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), ModPlacedFeatures.PUMICE_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), ModPlacedFeatures.SOUL_SANDSTONE_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), ModPlacedFeatures.SILICITE_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), ModPlacedFeatures.SILICON_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), ModPlacedFeatures.NETHER_MONOCRYSTAL_ORE_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_END), ModPlacedFeatures.END_GRAPHITE_PLACED_KEY);
        addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), ModPlacedFeatures.RUBY_ORE_PLACED_KEY);
    }

    private static void addOverworldOre(ResourceKey<PlacedFeature> feature) {
        addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), feature);
    }

    private static void addFeature(
            java.util.function.Predicate<BiomeSelectionContext> selector, ResourceKey<PlacedFeature> feature) {
        BiomeModifications.addFeature(selector, GenerationStep.Decoration.UNDERGROUND_ORES, feature);
    }
}
