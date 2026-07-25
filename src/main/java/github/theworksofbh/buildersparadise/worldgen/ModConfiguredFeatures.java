package github.theworksofbh.buildersparadise.worldgen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> zincOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState())
                );

        List<OreConfiguration.TargetBlockState> silverOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> tinOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> tungstenOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> platinumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> leadOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> bismuthOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.BISMUTH_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_BISMUTH_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> uraniumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.URANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> gabbro = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.GABBRO.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> rhyolite = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RHYOLITE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> pumice = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.PUMICE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> soulSandstone = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.SOUL_SANDSTONE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> graphite = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.GRAPHITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.GRAPHITE.get().defaultBlockState()),
                OreConfiguration.target(endStoneReplaceables, ModBlocks.GRAPHITE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> carbon = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CARBON_BLOCK.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> silicite = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.SILICITE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> silicon = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.SILICON_BLOCK.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> monocrystal = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.NETHER_MONOCRYSTAL_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> rubyOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> sapphireOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())
        );

        register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(zincOres, 8));
        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 8));
        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 9));
        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(tungstenOres, 8));
        register(context, DEEP_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(tungstenOres, 8));
        register(context, PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(platinumOres, 8));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(leadOres, 9));
        register(context, BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(bismuthOres, 8));
        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(uraniumOres, 9));
        register(context, GABBRO_KEY, Feature.ORE, new OreConfiguration(gabbro, 64));
        register(context, RHYOLITE_KEY, Feature.ORE, new OreConfiguration(rhyolite, 64));
        register(context, PUMICE_KEY, Feature.ORE, new OreConfiguration(pumice, 33));
        register(context, SOUL_SANDSTONE_KEY, Feature.ORE, new OreConfiguration(soulSandstone, 33));
        register(context, GRAPHITE_KEY, Feature.ORE, new OreConfiguration(graphite, 33));
        register(context, END_GRAPHITE_KEY, Feature.ORE, new OreConfiguration(graphite, 33));
        register(context, CARBON_KEY, Feature.ORE, new OreConfiguration(carbon, 33));
        register(context, SILICITE_KEY, Feature.ORE, new OreConfiguration(silicite, 33));
        register(context, SILICON_KEY, Feature.ORE, new OreConfiguration(silicon, 33));
        register(context, NETHER_MONOCRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(monocrystal, 8));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubyOres, 3));
        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(sapphireOres, 5));


    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEP_TUNGSTEN_ORE_KEY = registerKey("deep_tungsten_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLATINUM_ORE_KEY = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("uranium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GABBRO_KEY = registerKey("gabbro");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RHYOLITE_KEY = registerKey("rhyolite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PUMICE_KEY = registerKey("pumice");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SANDSTONE_KEY = registerKey("soul_sandstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAPHITE_KEY = registerKey("graphite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_GRAPHITE_KEY = registerKey("end_graphite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CARBON_KEY = registerKey("carbon");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILICITE_KEY = registerKey("silicite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILICON_KEY = registerKey("silicon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_MONOCRYSTAL_ORE_KEY = registerKey("nether_monocrystal_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");



}
