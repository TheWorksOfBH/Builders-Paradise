package github.theworksofbh.buildersparadise.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModDataGenerators {
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(ModEntityLootTableProvider::new, LootContextParamSets.ENTITY)
                ), lookupProvider));

        event.createProvider(ModBlockTagsProvider::new);
        event.createProvider(ModItemTagsProvider::new);

        event.createProvider(ModModelProvider::new);

        event.createProvider(ModLanguageProvider::new);
        event.createProvider(ModUKLanguageProvider::new);
        event.createProvider(ModAustraliaLanguageProvider::new);
        event.createProvider(ModNewZealandLanguageProvider::new);
        event.createProvider(ModCanadaLanguageProvider::new);

        event.createProvider(ModSoundDefinitionsProvider::new);

        event.createProvider(ModDataMapProvider::new);

        event.createProvider(ModRecipesProvider.Runner::new);

        event.createDatapackRegistryObjects(ModDataPackEntries.BUILDER);

        event.createProvider(ModDamageTypeTagsProvider::new);

        event.createProvider(ModFluidTagsProvider::new);

        event.createProvider(ModEntityTagsProvider::new);

        event.createProvider(ModEquipmentAssetProvider::new);
        event.createProvider(ModChestLootModifierProvider::new);
        event.createProvider(ModAtlasProvider::new);
        event.createProvider(ModParticleDescriptionProvider::new);

        event.createProvider(ModBannerPatternTagsProvider::new);

    }
}
