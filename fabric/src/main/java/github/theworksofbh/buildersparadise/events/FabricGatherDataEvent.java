package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBannerPatterns;
import github.theworksofbh.buildersparadise.damage.ModDamageTypes;
import github.theworksofbh.buildersparadise.datagen.*;
import github.theworksofbh.buildersparadise.items.types.ModTrimMaterials;
import github.theworksofbh.buildersparadise.sounds.ModJukeboxSongs;
import github.theworksofbh.buildersparadise.worldgen.ModConfiguredFeatures;
import github.theworksofbh.buildersparadise.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class FabricGatherDataEvent implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModEntityLootTableProvider::new);

        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModDamageTypeTagsProvider::new);
        pack.addProvider(ModFluidTagsProvider::new);
        pack.addProvider(ModEntityTagsProvider::new);
        pack.addProvider(ModBannerPatternTagsProvider::new);

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModLanguageProvider::new);
        pack.addProvider(ModUKLanguageProvider::new);
        pack.addProvider(ModAustraliaLanguageProvider::new);
        pack.addProvider(ModNewZealandLanguageProvider::new);
        pack.addProvider(ModCanadaLanguageProvider::new);

        pack.addProvider(ModSoundDefinitionsProvider::new);
        pack.addProvider(ModParticleDescriptionProvider::new);

        pack.addProvider(ModRecipesProvider.Runner::new);

        pack.addProvider(ModDataPackEntries::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder
                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                .add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap)
                .add(Registries.JUKEBOX_SONG, ModJukeboxSongs::bootstrap)
                .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
                .add(Registries.BANNER_PATTERN, ModBannerPatterns::bootstrap);
    }
}
