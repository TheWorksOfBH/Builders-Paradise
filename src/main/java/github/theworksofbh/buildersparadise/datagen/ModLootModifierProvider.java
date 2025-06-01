package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.loot.ModLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModLootModifierProvider extends GlobalLootModifierProvider {

    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BuildersParadise.MODID);
    }

    @Override
    protected void start() {
        this.add("elder_prismarine_shard_to_elder_guardian",
                new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("entities/elder_guardian")).build(),
                                LootItemRandomChanceCondition.randomChance(1.0F).build()
                        }, 0, 2, ModItems.ELDER_PRISMARINE_SHARD.get()
                ));

        this.add("elder_prismarine_crystals_to_elder_guardian",
                new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("entities/elder_guardian")).build(),
                                LootItemRandomChanceCondition.randomChance(0.3333333333333F).build()
                        }, 0, 1, ModItems.ELDER_PRISMARINE_CRYSTALS.get()
                ));
    }
}
