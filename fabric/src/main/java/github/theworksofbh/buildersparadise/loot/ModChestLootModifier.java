
package github.theworksofbh.buildersparadise.loot;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ModChestLootModifier {

    private ModChestLootModifier() {
    }

    private record Entry(
            Item item,
            int weight,
            int minimum,
            int maximum
    ) {
    }

    private static final Map<Identifier, List<Entry>> LOOT = new HashMap<>();

    private static Entry item(Item item, int weight, int minimum, int maximum) {
        return new Entry(item, weight, minimum, maximum);
    }

    private static Entry item(Item item, int weight) {
        return item(item, weight, 1, 1);
    }

    private static void add(String table, Entry... entries) {
        LOOT.put(
                Identifier.withDefaultNamespace(table),
                List.of(entries)
        );
    }

    private static void registerLoot() {
        add("chests/simple_dungeon",
                item(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET, 2),
                item(ModItems.ZINC_INGOT, 10, 1, 4),
                item(ModItems.SILVER_INGOT, 5, 1, 4),
                item(ModItems.PLATINUM_INGOT, 5, 1, 4),
                item(ModItems.LEAD_INGOT, 10, 1, 4),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/abandoned_mineshaft",
                item(ModItems.ZINC_INGOT, 10, 1, 5),
                item(ModItems.SILVER_INGOT, 5, 1, 3),
                item(ModItems.PLATINUM_INGOT, 5, 1, 3),
                item(ModItems.LEAD_INGOT, 10, 1, 5),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/stronghold_corridor",
                item(ModItems.ZINC_INGOT, 10, 1, 5),
                item(ModItems.SILVER_INGOT, 5, 1, 3),
                item(ModItems.PLATINUM_INGOT, 5, 1, 3),
                item(ModItems.LEAD_INGOT, 10, 1, 5),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/stronghold_crossing",
                item(ModItems.ZINC_INGOT, 10, 1, 5),
                item(ModItems.SILVER_INGOT, 5, 1, 3),
                item(ModItems.PLATINUM_INGOT, 5, 1, 3),
                item(ModItems.LEAD_INGOT, 10, 1, 5),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/stronghold_library",
                item(ModItems.ZINC_INGOT, 10, 1, 5),
                item(ModItems.SILVER_INGOT, 5, 1, 3),
                item(ModItems.PLATINUM_INGOT, 5, 1, 3),
                item(ModItems.LEAD_INGOT, 10, 1, 5),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/buried_treasure",
                item(ModItems.ZINC_INGOT, 20, 1, 4),
                item(ModItems.SILVER_INGOT, 10, 1, 4),
                item(ModItems.PLATINUM_INGOT, 10, 1, 4),
                item(ModItems.LEAD_INGOT, 20, 1, 4),
                item(ModItems.BRONZE_INGOT, 20, 1, 4)
        );

        add("chests/shipwreck_treasure",
                item(ModItems.ZINC_INGOT, 80, 1, 5),
                item(ModItems.SILVER_INGOT, 10, 1, 5),
                item(ModItems.PLATINUM_INGOT, 10, 1, 5),
                item(ModItems.LEAD_INGOT, 60, 1, 5),
                item(ModItems.BRONZE_INGOT, 30, 1, 5)
        );

        add("chests/nether_bridge",
                item(ModItems.ZINC_INGOT, 5, 1, 3),
                item(ModItems.SILVER_INGOT, 5, 1, 3),
                item(ModItems.PLATINUM_INGOT, 5, 1, 3),
                item(ModItems.LEAD_INGOT, 5, 1, 3)
        );

        add("chests/end_city_treasure",
                item(ModItems.ZINC_INGOT, 10, 2, 5),
                item(ModItems.SILVER_INGOT, 5, 2, 3),
                item(ModItems.PLATINUM_INGOT, 5, 2, 3),
                item(ModItems.LEAD_INGOT, 10, 2, 7),
                item(ModItems.BRONZE_INGOT, 10, 2, 3)
        );

        add("chests/desert_pyramid",
                item(ModItems.ZINC_INGOT, 15, 1, 5),
                item(ModItems.SILVER_INGOT, 15, 2, 3),
                item(ModItems.PLATINUM_INGOT, 15, 2, 3),
                item(ModItems.LEAD_INGOT, 15, 1, 7),
                item(ModItems.BRONZE_INGOT, 15, 2, 7)
        );

        add("chests/jungle_temple",
                item(ModItems.ZINC_INGOT, 15, 1, 5),
                item(ModItems.SILVER_INGOT, 15, 2, 3),
                item(ModItems.PLATINUM_INGOT, 15, 2, 3),
                item(ModItems.LEAD_INGOT, 15, 1, 7),
                item(ModItems.BRONZE_INGOT, 15, 2, 7)
        );

        add("chests/woodland_mansion",
                item(ModItems.ZINC_INGOT, 10, 1, 4),
                item(ModItems.SILVER_INGOT, 5, 1, 4),
                item(ModItems.PLATINUM_INGOT, 5, 1, 4),
                item(ModItems.LEAD_INGOT, 10, 1, 4),
                item(ModItems.BRONZE_INGOT, 10, 1, 4)
        );

        add("chests/bastion_bridge",
                item(ModItems.SILVER_INGOT, 1, 1, 6),
                item(ModItems.PLATINUM_INGOT, 1, 1, 6)
        );

        add("chests/bastion_other",
                item(ModItems.SILVER_INGOT, 1, 1, 6),
                item(ModItems.PLATINUM_INGOT, 1, 1, 6)
        );

        add("chests/ancient_city",
                item(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET, 2),
                item(ModItems.MUSIC_DISC_ANGRY_BOYFRIENDS, 2)
        );

        add("chests/village/village_weaponsmith",
                item(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE, 1)
        );

        add("chests/village/village_toolsmith",
                item(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE, 1)
        );

        add("chests/village/village_fisher",
                item(ModBlocks.OAK_BARREL.asItem(), 0, 1, 3)
        );

        add("gameplay/piglin_bartering",
                item(ModBlocks.PUMICE.asItem(), 40, 8, 16),
                item(ModItems.SILICON_DUST, 20, 10, 24)
        );
    }

    public static void register() {
        registerLoot();

        LootTableEvents.MODIFY_DROPS.register(
                (table, context, drops) -> {
                    Identifier tableId = table.unwrapKey()
                            .map(ResourceKey::identifier)
                            .orElse(null);

                    if (tableId == null || !LOOT.containsKey(tableId)) {
                        return;
                    }

                    RandomSource random = context.getRandom();

                    List<Holder<Item>> barrels = BuiltInRegistries.ITEM
                            .get(ModItemTags.BARRELS)
                            .map(holders -> holders.stream().toList())
                            .orElse(List.of());

                    if (!barrels.isEmpty()) {
                        for (int i = 0; i < drops.size(); i++) {
                            ItemStack stack = drops.get(i);

                            if (stack.is(Items.BARREL)) {
                                Item replacement = barrels.get(
                                        random.nextInt(barrels.size())
                                ).value();

                                drops.set(i, new ItemStack(
                                        replacement,
                                        stack.getCount()
                                ));
                            }
                        }
                    }

                    for (Entry entry : LOOT.get(tableId)) {
                        if (random.nextInt(100) >= entry.weight()) {
                            continue;
                        }

                        int count = entry.minimum() == entry.maximum()
                                ? entry.minimum()
                                : random.nextIntBetweenInclusive(
                                entry.minimum(),
                                entry.maximum()
                        );

                        drops.add(new ItemStack(entry.item(), count));
                    }
                }
        );
    }
}
