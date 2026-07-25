package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.loot.ModLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModChestLootModifierProvider extends GlobalLootModifierProvider {


    public ModChestLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BuildersParadise.MODID);
    }

    @Override
    protected void start() {
        this.add(
                "dungeon_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/simple_dungeon")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET.get(), 2, Optional.empty(), Optional.empty()),
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "mineshaft_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/abandoned_mineshaft")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "stronghold_corridor_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/stronghold_corridor")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "stronghold_crossing_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/stronghold_crossing")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "stronghold_library_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/stronghold_library")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "buried_treasure_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/buried_treasure")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 20, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 20, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 20, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "shipwreck_treasure_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/shipwreck_treasure")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 80, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  10, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 60, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 30, Optional.of(1), Optional.of(5))
                        )
                )
        );
        this.add(
                "nether_bridge_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/nether_bridge")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 5, Optional.of(1), Optional.of(3))
                        )
                )
        );
        this.add(
                "end_city_treasure_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/end_city_treasure")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(2), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(2), Optional.of(7)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(2), Optional.of(3))
                        )
                )
        );
        this.add(
                "desert_pyramid_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/desert_pyramid")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 15, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 15, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  15, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 15, Optional.of(1), Optional.of(7)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 15, Optional.of(2), Optional.of(7))
                        )
                )
        );
        this.add(
                "jungle_temple_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/jungle_temple")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 15, Optional.of(1), Optional.of(5)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 15, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  15, Optional.of(2), Optional.of(3)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 15, Optional.of(1), Optional.of(7)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 15, Optional.of(2), Optional.of(7))
                        )
                )
        );
        this.add(
                "woodland_mansion_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/woodland_mansion")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.ZINC_INGOT.get(), 10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 5, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(),  5, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.LEAD_INGOT.get(), 10, Optional.of(1), Optional.of(4)),
                                new ModLootModifier.Entry(ModItems.BRONZE_INGOT.get(), 10, Optional.of(1), Optional.of(4))
                        )
                )
        );
        this.add(
                "bastion_bridge_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/bastion_bridge")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 1, Optional.of(1), Optional.of(6)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(), 1, Optional.of(1), Optional.of(6))
                        )
                )
        );
        this.add(
                "bastion_other_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/bastion_other")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.SILVER_INGOT.get(), 1, Optional.of(1), Optional.of(6)),
                                new ModLootModifier.Entry(ModItems.PLATINUM_INGOT.get(), 1, Optional.of(1), Optional.of(6))
                        )
                )
        );
        this.add(
                "ancient_city_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/ancient_city")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET.get(), 2, Optional.empty(), Optional.empty()),
                                new ModLootModifier.Entry(ModItems.MUSIC_DISC_ANGRY_BOYFRIENDS.get(), 2, Optional.empty(), Optional.empty())
                        )
                )
        );
        this.add(
                "village_weaponsmith_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/village/village_weaponsmith")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), 1, Optional.empty(), Optional.empty())
                        )
                )
        );
        this.add(
                "village_toolsmith_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/village/village_toolsmith")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), 1, Optional.empty(), Optional.empty())
                        )
                )
        );
        this.add(
                "village_fisher_loot_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("chests/village/village_fisher")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                                new ModLootModifier.Entry(ModItems.OAK_BARREL.get(), 0, Optional.of(1), Optional.of(3))
                        )
                )
        );
        this.add(
                "piglin_bartering_modifier", new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(Identifier.withDefaultNamespace("gameplay/piglin_bartering")).build()
                        }, IGlobalLootModifier.DEFAULT_PRIORITY, List.of(
                            new ModLootModifier.Entry(ModItems.PUMICE.get(), 40, Optional.of(8), Optional.of(16)),
                            new ModLootModifier.Entry(ModItems.SILICON_DUST.get(), 20, Optional.of(10), Optional.of(24))
                        )
                )
        );
    }
}
