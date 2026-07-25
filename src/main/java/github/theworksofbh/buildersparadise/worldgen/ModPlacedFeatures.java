package github.theworksofbh.buildersparadise.worldgen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZINC_ORE_KEY),
                ModOrePlacements.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(120))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY),
                ModOrePlacements.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-34), VerticalAnchor.absolute(79))));
        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacements.commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-29), VerticalAnchor.absolute(127))));
        register(context, TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TUNGSTEN_ORE_KEY),
                ModOrePlacements.rareOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0))));
        register(context, DEEP_TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEEP_TUNGSTEN_ORE_KEY),
                ModOrePlacements.rareOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(120), VerticalAnchor.top())));
        register(context, PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLATINUM_ORE_KEY),
                ModOrePlacements.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-47), VerticalAnchor.absolute(12))));
        register(context, LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LEAD_ORE_KEY),
                ModOrePlacements.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.absolute(-13), VerticalAnchor.absolute(123))));
        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BISMUTH_ORE_KEY),
                ModOrePlacements.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(43))));
        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY),
                ModOrePlacements.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(128))));
        register(context, GABBRO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GABBRO_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0))));
        register(context, RHYOLITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RHYOLITE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0))));
        register(context, PUMICE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PUMICE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(71))));
        register(context, SOUL_SANDSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_SANDSTONE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(124))));
        register(context, GRAPHITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAPHITE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, END_GRAPHITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_GRAPHITE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(124))));
        register(context, CARBON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CARBON_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, SILICITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICITE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, SILICON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICON_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, NETHER_MONOCRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_MONOCRYSTAL_ORE_KEY),
                ModOrePlacements.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(54))));
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacements.commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacements.commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-43), VerticalAnchor.absolute(34))));
    }

    public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEP_TUNGSTEN_ORE_PLACED_KEY = registerKey("deep_tungsten_ore_placed");
    public static final ResourceKey<PlacedFeature> PLATINUM_ORE_PLACED_KEY = registerKey("platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore_placed");
    public static final ResourceKey<PlacedFeature> GABBRO_PLACED_KEY = registerKey("gabbro_placed");
    public static final ResourceKey<PlacedFeature> RHYOLITE_PLACED_KEY = registerKey("rhyolite_placed");
    public static final ResourceKey<PlacedFeature> PUMICE_PLACED_KEY = registerKey("pumice_placed");
    public static final ResourceKey<PlacedFeature> SOUL_SANDSTONE_PLACED_KEY = registerKey("soul_sandstone_placed");
    public static final ResourceKey<PlacedFeature> GRAPHITE_PLACED_KEY = registerKey("graphite_placed");
    public static final ResourceKey<PlacedFeature> END_GRAPHITE_PLACED_KEY = registerKey("end_graphite_placed");
    public static final ResourceKey<PlacedFeature> CARBON_PLACED_KEY = registerKey("carbon_placed");
    public static final ResourceKey<PlacedFeature> SILICITE_PLACED_KEY = registerKey("silicite_placed");
    public static final ResourceKey<PlacedFeature> SILICON_PLACED_KEY = registerKey("silicon_placed");
    public static final ResourceKey<PlacedFeature> NETHER_MONOCRYSTAL_ORE_PLACED_KEY = registerKey("nether_monocrystal_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");


}
