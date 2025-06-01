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
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        event.createBlockAndItemTags(ModBlockTagsProvider::new, ModItemTagsProvider::new);

        event.createProvider(ModModelProvider::new);

        event.createProvider(ModLanguageProvider::new);
        event.createProvider(ModUKLanguageProvider::new);


        event.createProvider(ModDataMapProvider::new);

        event.createProvider(ModLootModifierProvider::new);

        event.createProvider(ModRecipesProvider.Runner::new);

        event.createProvider(ModDataPackEntries::new);

        event.createProvider(ModDamageTypeTagsProvider::new);

        event.createProvider(ModFluidTagsProvider::new);
    }
}
