package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeInvConfig {
    public static void addModItemsToVanillaTabs(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            tabData.remove(Items.CRACKED_STONE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CRACKED_DEEPSLATE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CRACKED_DEEPSLATE_TILES.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CRACKED_NETHER_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.STONE_BRICK_WALL.getDefaultInstance(), Items.CRACKED_STONE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_BRICK_WALL.getDefaultInstance(), Items.CRACKED_DEEPSLATE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_TILE_WALL.getDefaultInstance(), Items.CRACKED_DEEPSLATE_TILES.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.NETHER_BRICK_FENCE.getDefaultInstance(), Items.CRACKED_NETHER_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL.getDefaultInstance(), Items.CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.POLISHED_GRANITE_SLAB.getDefaultInstance(), ModItems.POLISHED_GRANITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_DIORITE_SLAB.getDefaultInstance(), ModItems.POLISHED_DIORITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_ANDESITE_SLAB.getDefaultInstance(), ModItems.POLISHED_ANDESITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PRISMARINE_BRICK_SLAB.getDefaultInstance(), ModItems.PRISMARINE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DARK_PRISMARINE_SLAB.getDefaultInstance(), ModItems.DARK_PRISMARINE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.STONE_SLAB.getDefaultInstance(), ModItems.STONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SMOOTH_SANDSTONE_SLAB.getDefaultInstance(), ModItems.SMOOTH_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SMOOTH_RED_SANDSTONE_SLAB.getDefaultInstance(), ModItems.SMOOTH_RED_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.QUARTZ_SLAB.getDefaultInstance(), ModItems.QUARTZ_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SMOOTH_QUARTZ_SLAB.getDefaultInstance(), ModItems.SMOOTH_QUARTZ_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PURPUR_SLAB.getDefaultInstance(), ModItems.PURPUR_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SMOOTH_STONE.getDefaultInstance(), ModItems.SMOOTH_STONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SMOOTH_STONE_SLAB.getDefaultInstance(), ModItems.SMOOTH_STONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CUT_SANDSTONE.getDefaultInstance(), ModItems.CUT_SANDSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CUT_STANDSTONE_SLAB.getDefaultInstance(), ModItems.CUT_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CUT_RED_SANDSTONE.getDefaultInstance(), ModItems.CUT_RED_SANDSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CUT_RED_SANDSTONE_SLAB.getDefaultInstance(), ModItems.CUT_RED_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRACKED_STONE_BRICKS.getDefaultInstance(), ModItems.CRACKED_STONE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_STONE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_BRICK_SLAB.get().getDefaultInstance(), ModItems.CRACKED_STONE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BASALT.getDefaultInstance(), ModItems.BASALT_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_STAIRS.get().getDefaultInstance(), ModItems.BASALT_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_SLAB.get().getDefaultInstance(), ModItems.BASALT_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.POLISHED_BASALT.getDefaultInstance(), ModItems.POLISHED_BASALT_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_BASALT_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_BASALT_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_BASALT_SLAB.get().getDefaultInstance(), ModItems.POLISHED_BASALT_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SMOOTH_BASALT.getDefaultInstance(), ModItems.SMOOTH_BASALT_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_BASALT_STAIRS.get().getDefaultInstance(), ModItems.SMOOTH_BASALT_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_BASALT_SLAB.get().getDefaultInstance(), ModItems.SMOOTH_BASALT_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.DEEPSLATE.getDefaultInstance(), ModItems.DEEPSLATE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_STAIRS.get().getDefaultInstance(), ModItems.DEEPSLATE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_SLAB.get().getDefaultInstance(), ModItems.DEEPSLATE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRACKED_DEEPSLATE_BRICKS.getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_BRICK_SLAB.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRACKED_DEEPSLATE_TILES.getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_TILE_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_TILE_SLAB.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_TILE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRACKED_NETHER_BRICKS.getDefaultInstance(), ModItems.CRACKED_NETHER_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_NETHER_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_NETHER_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_NETHER_BRICK_SLAB.get().getDefaultInstance(), ModItems.CRACKED_NETHER_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultInstance(), ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get().getDefaultInstance(), ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.NETHERRACK.getDefaultInstance(), ModItems.NETHERRACK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_STAIRS.get().getDefaultInstance(), ModItems.NETHERRACK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_SLAB.get().getDefaultInstance(), ModItems.NETHERRACK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CHISELED_TUFF_BRICKS.getDefaultInstance(), Items.CALCITE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CALCITE.getDefaultInstance(), ModItems.CALCITE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_STAIRS.get().getDefaultInstance(), ModItems.CALCITE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_SLAB.get().getDefaultInstance(), ModItems.CALCITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CALCITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_CALCITE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_CALCITE.get().getDefaultInstance(), ModItems.POLISHED_CALCITE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_CALCITE_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_CALCITE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_CALCITE_SLAB.get().getDefaultInstance(), ModItems.POLISHED_CALCITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_CALCITE_WALL.get().getDefaultInstance(), ModItems.CALCITE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_BRICKS.get().getDefaultInstance(), ModItems.CALCITE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CALCITE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_BRICK_SLAB.get().getDefaultInstance(), ModItems.CALCITE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CALCITE_BRICK_WALL.get().getDefaultInstance(), Items.DRIPSTONE_BLOCK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DRIPSTONE_BLOCK.getDefaultInstance(), ModItems.DRIPSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_STAIRS.get().getDefaultInstance(), ModItems.DRIPSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_SLAB.get().getDefaultInstance(), ModItems.DRIPSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.DRIPSTONE_WALL.get().getDefaultInstance(), ModItems.POLISHED_DRIPSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DRIPSTONE.get().getDefaultInstance(), ModItems.POLISHED_DRIPSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DRIPSTONE_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_DRIPSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DRIPSTONE_SLAB.get().getDefaultInstance(), ModItems.POLISHED_DRIPSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_DRIPSTONE_WALL.get().getDefaultInstance(), ModItems.DRIPSTONE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_BRICKS.get().getDefaultInstance(), ModItems.DRIPSTONE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.DRIPSTONE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_BRICK_SLAB.get().getDefaultInstance(), ModItems.DRIPSTONE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.END_STONE.getDefaultInstance(), ModItems.END_STONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.END_STONE_STAIRS.get().getDefaultInstance(), ModItems.END_STONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.END_STONE_SLAB.get().getDefaultInstance(), ModItems.END_STONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.QUARTZ_BRICKS.getDefaultInstance(), ModItems.QUARTZ_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.QUARTZ_BRICK_STAIRS.get().getDefaultInstance(), ModItems.QUARTZ_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.QUARTZ_BRICK_SLAB.get().getDefaultInstance(), ModItems.QUARTZ_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PACKED_MUD.getDefaultInstance(), ModItems.PACKED_MUD_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_MUD_STAIRS.get().getDefaultInstance(), ModItems.PACKED_MUD_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_MUD_SLAB.get().getDefaultInstance(), ModItems.PACKED_MUD_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.MUD_BRICK_WALL.getDefaultInstance(), Items.RESIN_BLOCK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RESIN_BLOCK.getDefaultInstance(), ModItems.RESIN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RESIN_STAIRS.get().getDefaultInstance(), ModItems.RESIN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RESIN_SLAB.get().getDefaultInstance(), ModItems.RESIN_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.IRON_BARS.getDefaultInstance(), ModItems.CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_IRON.get().getDefaultInstance(), ModItems.CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GOLD_BLOCK.getDefaultInstance(), ModItems.CUT_GOLD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_GOLD.get().getDefaultInstance(), ModItems.CUT_GOLD_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_GOLD_STAIRS.get().getDefaultInstance(), ModItems.CUT_GOLD_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.DIAMOND_BLOCK.getDefaultInstance(), ModItems.CUT_DIAMOND.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_DIAMOND.get().getDefaultInstance(), ModItems.CUT_DIAMOND_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_DIAMOND_STAIRS.get().getDefaultInstance(), ModItems.CUT_DIAMOND_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.EMERALD_BLOCK.getDefaultInstance(), ModItems.CUT_EMERALD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_EMERALD.get().getDefaultInstance(), ModItems.CUT_EMERALD_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_EMERALD_STAIRS.get().getDefaultInstance(), ModItems.CUT_EMERALD_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.AMETHYST_BLOCK.getDefaultInstance(), ModItems.CUT_AMETHYST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_AMETHYST.get().getDefaultInstance(), ModItems.CUT_AMETHYST_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_AMETHYST_STAIRS.get().getDefaultInstance(), ModItems.CUT_AMETHYST_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.NETHERITE_BLOCK.getDefaultInstance(), ModItems.CUT_NETHERITE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_NETHERITE.get().getDefaultInstance(), ModItems.CUT_NETHERITE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_NETHERITE_STAIRS.get().getDefaultInstance(), ModItems.CUT_NETHERITE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_TRAPDOOR.getDefaultInstance(), ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.EXPOSED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WEATHERED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.OXIDIZED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WAXED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_EXPOSED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_WEATHERED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_OXIDIZED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.IRON_CHAIN.getDefaultInstance(), ModItems.EXPOSED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON.get().getDefaultInstance(), ModItems.EXPOSED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_BARS.get().getDefaultInstance(), ModItems.EXPOSED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_CUT_IRON.get().getDefaultInstance(), ModItems.EXPOSED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.EXPOSED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.EXPOSED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_DOOR.get().getDefaultInstance(), ModItems.EXPOSED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.EXPOSED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.EXPOSED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WEATHERED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON.get().getDefaultInstance(), ModItems.WEATHERED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_BARS.get().getDefaultInstance(), ModItems.WEATHERED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_CUT_IRON.get().getDefaultInstance(), ModItems.WEATHERED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.WEATHERED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.WEATHERED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_DOOR.get().getDefaultInstance(), ModItems.WEATHERED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WEATHERED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WEATHERED_IRON_CHAIN.get().getDefaultInstance(), ModItems.RUSTED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON.get().getDefaultInstance(), ModItems.RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.RUSTED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_CUT_IRON.get().getDefaultInstance(), ModItems.RUSTED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.RUSTED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.RUSTED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RUSTED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_BLOCK.get().getDefaultInstance(), ModItems.WAXED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_CUT_IRON.get().getDefaultInstance(), ModItems.WAXED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.WAXED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.WAXED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_CUT_IRON.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_CUT_IRON.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_IRON.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_RUSTED_CUT_IRON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_CUT_IRON.get().getDefaultInstance(), ModItems.WAXED_RUSTED_CUT_IRON_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_CUT_IRON_STAIRS.get().getDefaultInstance(), ModItems.WAXED_RUSTED_CUT_IRON_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_CUT_IRON_SLAB.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CUT_GOLD_SLAB.get().getDefaultInstance(), ModItems.GOLD_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_DOOR.get().getDefaultInstance(), ModItems.GOLD_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIGHT_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(), ModItems.GOLD_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CUT_NETHERITE_SLAB.get().getDefaultInstance(), ModItems.NETHERITE_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_DOOR.get().getDefaultInstance(), ModItems.NETHERITE_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_TRAPDOOR.get().getDefaultInstance(), ModItems.PLAYER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PLAYER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.NETHERITE_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_GRANITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GRANITE_BRICKS.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GRANITE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GRANITE_BRICK_SLAB.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_DIORITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DIORITE_BRICKS.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DIORITE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DIORITE_BRICK_SLAB.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_ANDESITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_ANDESITE_BRICKS.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_ANDESITE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_ANDESITE_BRICK_SLAB.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_BASALT_WALL.get().getDefaultInstance(), ModItems.BASALT_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_BRICKS.get().getDefaultInstance(), ModItems.BASALT_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BASALT_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_BRICK_SLAB.get().getDefaultInstance(), ModItems.BASALT_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COAL_BLOCK.getDefaultInstance(), ModItems.CHARCOAL_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CUT_RED_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SOUL_SANDSTONE.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SOUL_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.CHISELED_SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CHISELED_SOUL_SANDSTONE.get().getDefaultInstance(), ModItems.SMOOTH_SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_SOUL_SANDSTONE.get().getDefaultInstance(), ModItems.SMOOTH_SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), ModItems.SMOOTH_SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), ModItems.SMOOTH_SOUL_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SMOOTH_SOUL_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.CUT_SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_SOUL_SANDSTONE.get().getDefaultInstance(), ModItems.CUT_SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_SOUL_SANDSTONE_STAIRS.get().getDefaultInstance(), ModItems.CUT_SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_SOUL_SANDSTONE_SLAB.get().getDefaultInstance(), ModItems.CUT_SOUL_SANDSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.DARK_PRISMARINE_WALL.get().getDefaultInstance(), ModItems.ELDER_SEA_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_SEA_LANTERN.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_STAIRS.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_SLAB.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ELDER_PRISMARINE_WALL.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_BRICKS.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_BRICK_SLAB.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ELDER_PRISMARINE_BRICK_WALL.get().getDefaultInstance(), ModItems.DARK_ELDER_PRISMARINE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_ELDER_PRISMARINE.get().getDefaultInstance(), ModItems.DARK_ELDER_PRISMARINE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_ELDER_PRISMARINE_STAIRS.get().getDefaultInstance(), ModItems.DARK_ELDER_PRISMARINE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_ELDER_PRISMARINE_SLAB.get().getDefaultInstance(), ModItems.DARK_ELDER_PRISMARINE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.EXPOSED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WEATHERED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.CORRODED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CORRODED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_EXPOSED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_WEATHERED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_CORRODED_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_CUT_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_CUT_ZINC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_CUT_ZINC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_CORRODED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.SILVER_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_SILVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_SILVER_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_SILVER_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.TIN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TIN_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TIN_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TIN_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.TUNGSTEN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TUNGSTEN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TUNGSTEN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TUNGSTEN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.PLATINUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_PLATINUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_PLATINUM_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_PLATINUM_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.LEAD_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_LEAD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_LEAD_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_LEAD_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.URANIUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_URANIUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_URANIUM_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_URANIUM_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.BRONZE_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRONZE_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRONZE_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRONZE_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.BRASS_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRASS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRASS_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRASS_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.STEEL_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_STEEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_STEEL_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_STEEL_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.VILLAGER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.OAK_PLANKS.getDefaultInstance(), ModItems.OAK_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.OAK_SLAB.getDefaultInstance(), ModItems.OAK_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.OAK_STAIRS.getDefaultInstance(), ModItems.OAK_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SPRUCE_PLANKS.getDefaultInstance(), ModItems.SPRUCE_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SPRUCE_SLAB.getDefaultInstance(), ModItems.SPRUCE_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SPRUCE_STAIRS.getDefaultInstance(), ModItems.SPRUCE_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BIRCH_PLANKS.getDefaultInstance(), ModItems.BIRCH_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BIRCH_SLAB.getDefaultInstance(), ModItems.BIRCH_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BIRCH_STAIRS.getDefaultInstance(), ModItems.BIRCH_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.JUNGLE_PLANKS.getDefaultInstance(), ModItems.JUNGLE_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.JUNGLE_SLAB.getDefaultInstance(), ModItems.JUNGLE_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.JUNGLE_STAIRS.getDefaultInstance(), ModItems.JUNGLE_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.ACACIA_PLANKS.getDefaultInstance(), ModItems.ACACIA_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.ACACIA_SLAB.getDefaultInstance(), ModItems.ACACIA_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.ACACIA_STAIRS.getDefaultInstance(), ModItems.ACACIA_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.DARK_OAK_PLANKS.getDefaultInstance(), ModItems.DARK_OAK_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DARK_OAK_SLAB.getDefaultInstance(), ModItems.DARK_OAK_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DARK_OAK_STAIRS.getDefaultInstance(), ModItems.DARK_OAK_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CRIMSON_PLANKS.getDefaultInstance(), ModItems.CRIMSON_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CRIMSON_SLAB.getDefaultInstance(), ModItems.CRIMSON_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CRIMSON_STAIRS.getDefaultInstance(), ModItems.CRIMSON_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WARPED_PLANKS.getDefaultInstance(), ModItems.WARPED_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WARPED_SLAB.getDefaultInstance(), ModItems.WARPED_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WARPED_STAIRS.getDefaultInstance(), ModItems.WARPED_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.MANGROVE_PLANKS.getDefaultInstance(), ModItems.MANGROVE_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MANGROVE_SLAB.getDefaultInstance(), ModItems.MANGROVE_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MANGROVE_STAIRS.getDefaultInstance(), ModItems.MANGROVE_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CHERRY_PLANKS.getDefaultInstance(), ModItems.CHERRY_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CHERRY_SLAB.getDefaultInstance(), ModItems.CHERRY_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CHERRY_STAIRS.getDefaultInstance(), ModItems.CHERRY_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PALE_OAK_PLANKS.getDefaultInstance(), ModItems.PALE_OAK_MOSAIC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PALE_OAK_SLAB.getDefaultInstance(), ModItems.PALE_OAK_MOSAIC_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PALE_OAK_STAIRS.getDefaultInstance(), ModItems.PALE_OAK_MOSAIC_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertBefore(Items.COAL_BLOCK.getDefaultInstance(), Items.OBSIDIAN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.OBSIDIAN.getDefaultInstance(), ModItems.OBSIDIAN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_STAIRS.get().getDefaultInstance(), ModItems.OBSIDIAN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_SLAB.get().getDefaultInstance(), ModItems.OBSIDIAN_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.OBSIDIAN_WALL.get().getDefaultInstance(), Items.CRYING_OBSIDIAN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CRYING_OBSIDIAN.getDefaultInstance(), ModItems.CRYING_OBSIDIAN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_STAIRS.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_SLAB.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COAL_BLOCK.getDefaultInstance(), ModItems.COAL_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_STAIRS.get().getDefaultInstance(), ModItems.COAL_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_SLAB.get().getDefaultInstance(), ModItems.COAL_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LAPIS_BLOCK.getDefaultInstance(), ModItems.LAPIS_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_STAIRS.get().getDefaultInstance(), ModItems.LAPIS_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_SLAB.get().getDefaultInstance(), ModItems.LAPIS_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CHARCOAL_BLOCK.get().getDefaultInstance(), ModItems.CHARCOAL_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_STAIRS.get().getDefaultInstance(), ModItems.CHARCOAL_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_SLAB.get().getDefaultInstance(), ModItems.CHARCOAL_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertBefore(Items.PACKED_MUD.getDefaultInstance(), Items.SNOW_BLOCK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SNOW_BLOCK.getDefaultInstance(), ModItems.SNOW_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_STAIRS.get().getDefaultInstance(), ModItems.SNOW_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_SLAB.get().getDefaultInstance(), ModItems.SNOW_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SNOW_WALL.get().getDefaultInstance(), Items.ICE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.ICE.getDefaultInstance(), ModItems.ICE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_STAIRS.get().getDefaultInstance(), ModItems.ICE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_SLAB.get().getDefaultInstance(), ModItems.ICE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ICE_WALL.get().getDefaultInstance(), Items.PACKED_ICE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PACKED_ICE.getDefaultInstance(), ModItems.PACKED_ICE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_STAIRS.get().getDefaultInstance(), ModItems.PACKED_ICE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_SLAB.get().getDefaultInstance(), ModItems.PACKED_ICE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PACKED_ICE_WALL.get().getDefaultInstance(), Items.BLUE_ICE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BLUE_ICE.getDefaultInstance(), ModItems.BLUE_ICE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_STAIRS.get().getDefaultInstance(), ModItems.BLUE_ICE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_SLAB.get().getDefaultInstance(), ModItems.BLUE_ICE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLUE_ICE_WALL.get().getDefaultInstance(), Items.SCULK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SCULK.getDefaultInstance(), ModItems.SCULK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_STAIRS.get().getDefaultInstance(), ModItems.SCULK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_SLAB.get().getDefaultInstance(), ModItems.SCULK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.MOSSY_STONE_BRICK_WALL.getDefaultInstance(), ModItems.STONE_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_TILES.get().getDefaultInstance(), ModItems.STONE_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_TILE_STAIRS.get().getDefaultInstance(), ModItems.STONE_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_TILE_SLAB.get().getDefaultInstance(), ModItems.STONE_TILE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.STONE_TILE_WALL.get().getDefaultInstance(), ModItems.CRACKED_STONE_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_TILES.get().getDefaultInstance(), ModItems.CRACKED_STONE_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_TILE_STAIRS.get().getDefaultInstance(), ModItems.CRACKED_STONE_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_TILE_SLAB.get().getDefaultInstance(), ModItems.CRACKED_STONE_TILE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CRACKED_STONE_TILE_WALL.get().getDefaultInstance(), ModItems.MOSSY_STONE_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MOSSY_STONE_TILES.get().getDefaultInstance(), ModItems.MOSSY_STONE_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MOSSY_STONE_TILE_STAIRS.get().getDefaultInstance(), ModItems.MOSSY_STONE_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MOSSY_STONE_TILE_SLAB.get().getDefaultInstance(), ModItems.MOSSY_STONE_TILE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.OBSIDIAN_WALL.get().getDefaultInstance(), ModItems.OBSIDIAN_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_BRICKS.get().getDefaultInstance(), ModItems.OBSIDIAN_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_BRICK_STAIRS.get().getDefaultInstance(), ModItems.OBSIDIAN_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_BRICK_SLAB.get().getDefaultInstance(), ModItems.OBSIDIAN_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_WALL.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_BRICKS.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_BRICK_SLAB.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.COAL_WALL.get().getDefaultInstance(), ModItems.COAL_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_BRICKS.get().getDefaultInstance(), ModItems.COAL_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_BRICK_STAIRS.get().getDefaultInstance(), ModItems.COAL_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_BRICK_SLAB.get().getDefaultInstance(), ModItems.COAL_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CHARCOAL_WALL.get().getDefaultInstance(), ModItems.CHARCOAL_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_BRICKS.get().getDefaultInstance(), ModItems.CHARCOAL_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CHARCOAL_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_BRICK_SLAB.get().getDefaultInstance(), ModItems.CHARCOAL_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LAPIS_WALL.get().getDefaultInstance(), ModItems.LAPIS_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_BRICKS.get().getDefaultInstance(), ModItems.LAPIS_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LAPIS_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_BRICK_SLAB.get().getDefaultInstance(), ModItems.LAPIS_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LAPIS_BRICK_WALL.get().getDefaultInstance(), ModItems.SMOOTH_LAPIS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_LAPIS.get().getDefaultInstance(), ModItems.SMOOTH_LAPIS_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_LAPIS_STAIRS.get().getDefaultInstance(), ModItems.SMOOTH_LAPIS_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_LAPIS_SLAB.get().getDefaultInstance(), ModItems.SMOOTH_LAPIS_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SNOW_WALL.get().getDefaultInstance(), ModItems.SNOW_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_BRICKS.get().getDefaultInstance(), ModItems.SNOW_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_BRICK_STAIRS.get().getDefaultInstance(), ModItems.SNOW_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_BRICK_SLAB.get().getDefaultInstance(), ModItems.SNOW_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ICE_WALL.get().getDefaultInstance(), ModItems.ICE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_BRICKS.get().getDefaultInstance(), ModItems.ICE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.ICE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_BRICK_SLAB.get().getDefaultInstance(), ModItems.ICE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PACKED_ICE_WALL.get().getDefaultInstance(), ModItems.PACKED_ICE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_BRICKS.get().getDefaultInstance(), ModItems.PACKED_ICE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PACKED_ICE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_BRICK_SLAB.get().getDefaultInstance(), ModItems.PACKED_ICE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLUE_ICE_WALL.get().getDefaultInstance(), ModItems.BLUE_ICE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_BRICKS.get().getDefaultInstance(), ModItems.BLUE_ICE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BLUE_ICE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_BRICK_SLAB.get().getDefaultInstance(), ModItems.BLUE_ICE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SCULK_WALL.get().getDefaultInstance(), ModItems.SCULK_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_BRICKS.get().getDefaultInstance(), ModItems.SCULK_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_BRICK_STAIRS.get().getDefaultInstance(), ModItems.SCULK_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_BRICK_SLAB.get().getDefaultInstance(), ModItems.SCULK_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_BRICK_WALL.get().getDefaultInstance(), ModItems.CHISELED_SCULK_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.STONE_WALL.get().getDefaultInstance(), ModItems.STONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COBBLESTONE_WALL.getDefaultInstance(), ModItems.COBBLESTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MOSSY_COBBLESTONE_WALL.getDefaultInstance(), ModItems.MOSSY_COBBLESTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_STONE_WALL.get().getDefaultInstance(), ModItems.SMOOTH_STONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.STONE_BRICK_WALL.getDefaultInstance(), ModItems.STONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MOSSY_STONE_BRICK_WALL.getDefaultInstance(), ModItems.MOSSY_STONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_BRICK_WALL.get().getDefaultInstance(), ModItems.CRACKED_STONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_TILE_WALL.get().getDefaultInstance(), ModItems.STONE_TILE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MOSSY_STONE_TILE_WALL.get().getDefaultInstance(), ModItems.MOSSY_STONE_TILE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_STONE_TILE_WALL.get().getDefaultInstance(), ModItems.CRACKED_STONE_TILE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GRANITE_WALL.getDefaultInstance(), ModItems.GRANITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GRANITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GRANITE_BRICK_WALL.get().getDefaultInstance(), ModItems.POLISHED_GRANITE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.DIORITE_WALL.getDefaultInstance(), ModItems.DIORITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DIORITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DIORITE_BRICK_WALL.get().getDefaultInstance(), ModItems.POLISHED_DIORITE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.ANDESITE_WALL.getDefaultInstance(), ModItems.ANDESITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_ANDESITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_ANDESITE_BRICK_WALL.get().getDefaultInstance(), ModItems.POLISHED_ANDESITE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.DEEPSLATE_WALL.get().getDefaultInstance(), ModItems.DEEPSLATE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COBBLED_DEEPSLATE_WALL.getDefaultInstance(), ModItems.COBBLED_DEEPSLATE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_DEEPSLATE_WALL.getDefaultInstance(), ModItems.POLISHED_DEEPSLATE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_BRICK_WALL.getDefaultInstance(), ModItems.DEEPSLATE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_BRICK_WALL.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_TILE_WALL.getDefaultInstance(), ModItems.DEEPSLATE_TILE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_DEEPSLATE_TILE_WALL.get().getDefaultInstance(), ModItems.CRACKED_DEEPSLATE_TILE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.TUFF_WALL.getDefaultInstance(), ModItems.TUFF_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_TUFF_WALL.getDefaultInstance(), ModItems.POLISHED_TUFF_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TUFF_BRICK_WALL.getDefaultInstance(), ModItems.TUFF_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CALCITE_WALL.get().getDefaultInstance(), ModItems.CALCITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_CALCITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_CALCITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_BRICK_WALL.get().getDefaultInstance(), ModItems.CALCITE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.DRIPSTONE_WALL.get().getDefaultInstance(), ModItems.DRIPSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_DRIPSTONE_WALL.get().getDefaultInstance(), ModItems.POLISHED_DRIPSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DRIPSTONE_BRICK_WALL.get().getDefaultInstance(), ModItems.DRIPSTONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BRICK_WALL.getDefaultInstance(), ModItems.BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PACKED_MUD_WALL.get().getDefaultInstance(), ModItems.PACKED_MUD_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MUD_BRICK_WALL.getDefaultInstance(), ModItems.MUD_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RESIN_WALL.get().getDefaultInstance(), ModItems.RESIN_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RESIN_BRICK_WALL.getDefaultInstance(), ModItems.RESIN_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SANDSTONE_WALL.getDefaultInstance(), ModItems.SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.CUT_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.SMOOTH_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RED_SANDSTONE_WALL.getDefaultInstance(), ModItems.RED_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_RED_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.CUT_RED_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_RED_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.SMOOTH_RED_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SOUL_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CUT_SOUL_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.CUT_SOUL_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_SOUL_SANDSTONE_WALL.get().getDefaultInstance(), ModItems.SMOOTH_SOUL_SANDSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.END_STONE_WALL.get().getDefaultInstance(), ModItems.END_STONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.END_STONE_BRICK_WALL.getDefaultInstance(), ModItems.END_STONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PURPUR_WALL.get().getDefaultInstance(), ModItems.PURPUR_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.NETHERRACK_WALL.get().getDefaultInstance(), ModItems.NETHERRACK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CRACKED_NETHER_BRICK_WALL.get().getDefaultInstance(), ModItems.CRACKED_NETHER_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RED_NETHER_BRICK_WALL.getDefaultInstance(), ModItems.RED_NETHER_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BASALT_WALL.get().getDefaultInstance(), ModItems.BASALT_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_BASALT_WALL.get().getDefaultInstance(), ModItems.POLISHED_BASALT_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_BASALT_WALL.get().getDefaultInstance(), ModItems.SMOOTH_BASALT_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_BRICK_WALL.get().getDefaultInstance(), ModItems.BASALT_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PRISMARINE_WALL.getDefaultInstance(), ModItems.PRISMARINE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PRISMARINE_BRICK_WALL.get().getDefaultInstance(), ModItems.PRISMARINE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_PRISMARINE_WALL.get().getDefaultInstance(), ModItems.DARK_PRISMARINE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ELDER_PRISMARINE_WALL.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_BRICK_WALL.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_ELDER_PRISMARINE_WALL.get().getDefaultInstance(), ModItems.DARK_ELDER_PRISMARINE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BLACKSTONE_WALL.getDefaultInstance(), ModItems.BLACKSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_BLACKSTONE_WALL.getDefaultInstance(), ModItems.POLISHED_BLACKSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL.getDefaultInstance(), ModItems.POLISHED_BLACKSTONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get().getDefaultInstance(), ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.QUARTZ_WALL.get().getDefaultInstance(), ModItems.QUARTZ_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.QUARTZ_BRICK_WALL.get().getDefaultInstance(), ModItems.QUARTZ_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_QUARTZ_WALL.get().getDefaultInstance(), ModItems.SMOOTH_QUARTZ_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.OBSIDIAN_WALL.get().getDefaultInstance(), ModItems.OBSIDIAN_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_BRICK_WALL.get().getDefaultInstance(), ModItems.OBSIDIAN_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_WALL.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRYING_OBSIDIAN_BRICK_WALL.get().getDefaultInstance(), ModItems.CRYING_OBSIDIAN_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.COAL_WALL.get().getDefaultInstance(), ModItems.COAL_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COAL_BRICK_WALL.get().getDefaultInstance(), ModItems.COAL_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CHARCOAL_WALL.get().getDefaultInstance(), ModItems.CHARCOAL_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHARCOAL_BRICK_WALL.get().getDefaultInstance(), ModItems.CHARCOAL_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LAPIS_WALL.get().getDefaultInstance(), ModItems.LAPIS_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LAPIS_BRICK_WALL.get().getDefaultInstance(), ModItems.LAPIS_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_LAPIS_WALL.get().getDefaultInstance(), ModItems.SMOOTH_LAPIS_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SNOW_WALL.get().getDefaultInstance(), ModItems.SNOW_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SNOW_BRICK_WALL.get().getDefaultInstance(), ModItems.SNOW_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ICE_WALL.get().getDefaultInstance(), ModItems.ICE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ICE_BRICK_WALL.get().getDefaultInstance(), ModItems.ICE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PACKED_ICE_WALL.get().getDefaultInstance(), ModItems.PACKED_ICE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_ICE_BRICK_WALL.get().getDefaultInstance(), ModItems.PACKED_ICE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLUE_ICE_WALL.get().getDefaultInstance(), ModItems.BLUE_ICE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_ICE_BRICK_WALL.get().getDefaultInstance(), ModItems.BLUE_ICE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.SCULK_WALL.get().getDefaultInstance(), ModItems.SCULK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SCULK_BRICK_WALL.get().getDefaultInstance(), ModItems.SCULK_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CHISELED_TUFF_BRICKS.getDefaultInstance(), ModItems.GABBRO.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO.get().getDefaultInstance(), ModItems.GABBRO_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_STAIRS.get().getDefaultInstance(), ModItems.GABBRO_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_SLAB.get().getDefaultInstance(), ModItems.GABBRO_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_WALL.get().getDefaultInstance(), ModItems.GABBRO_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GABBRO_FENCE.get().getDefaultInstance(), ModItems.POLISHED_GABBRO.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GABBRO.get().getDefaultInstance(), ModItems.POLISHED_GABBRO_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GABBRO_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_GABBRO_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GABBRO_SLAB.get().getDefaultInstance(), ModItems.POLISHED_GABBRO_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_GABBRO_WALL.get().getDefaultInstance(), ModItems.POLISHED_GABBRO_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_GABBRO_FENCE.get().getDefaultInstance(), ModItems.GABBRO_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_BRICKS.get().getDefaultInstance(), ModItems.GABBRO_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_BRICK_STAIRS.get().getDefaultInstance(), ModItems.GABBRO_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_BRICK_SLAB.get().getDefaultInstance(), ModItems.GABBRO_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_BRICK_WALL.get().getDefaultInstance(), ModItems.GABBRO_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GABBRO_BRICK_FENCE.get().getDefaultInstance(), ModItems.RHYOLITE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE.get().getDefaultInstance(), ModItems.RHYOLITE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_STAIRS.get().getDefaultInstance(), ModItems.RHYOLITE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_SLAB.get().getDefaultInstance(), ModItems.RHYOLITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_WALL.get().getDefaultInstance(), ModItems.RHYOLITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RHYOLITE_FENCE.get().getDefaultInstance(), ModItems.POLISHED_RHYOLITE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_RHYOLITE.get().getDefaultInstance(), ModItems.POLISHED_RHYOLITE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_RHYOLITE_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_RHYOLITE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_RHYOLITE_SLAB.get().getDefaultInstance(), ModItems.POLISHED_RHYOLITE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_RHYOLITE_WALL.get().getDefaultInstance(), ModItems.POLISHED_RHYOLITE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_RHYOLITE_FENCE.get().getDefaultInstance(), ModItems.RHYOLITE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_BRICKS.get().getDefaultInstance(), ModItems.RHYOLITE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.RHYOLITE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_BRICK_SLAB.get().getDefaultInstance(), ModItems.RHYOLITE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_BRICK_WALL.get().getDefaultInstance(), ModItems.RHYOLITE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BASALT_BRICK_FENCE.get().getDefaultInstance(), ModItems.PUMICE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE.get().getDefaultInstance(), ModItems.PUMICE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_STAIRS.get().getDefaultInstance(), ModItems.PUMICE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_SLAB.get().getDefaultInstance(), ModItems.PUMICE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_WALL.get().getDefaultInstance(), ModItems.PUMICE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PUMICE_FENCE.get().getDefaultInstance(), ModItems.POLISHED_PUMICE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_PUMICE.get().getDefaultInstance(), ModItems.POLISHED_PUMICE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_PUMICE_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_PUMICE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_PUMICE_SLAB.get().getDefaultInstance(), ModItems.POLISHED_PUMICE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_PUMICE_WALL.get().getDefaultInstance(), ModItems.POLISHED_PUMICE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_PUMICE_FENCE.get().getDefaultInstance(), ModItems.PUMICE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_BRICKS.get().getDefaultInstance(), ModItems.PUMICE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PUMICE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_BRICK_SLAB.get().getDefaultInstance(), ModItems.PUMICE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_BRICK_WALL.get().getDefaultInstance(), ModItems.PUMICE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.MOSSY_COBBLESTONE_FENCE.get().getDefaultInstance(), ModItems.POLISHED_STONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_STONE.get().getDefaultInstance(), ModItems.POLISHED_STONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_STONE_STAIRS.get().getDefaultInstance(), ModItems.POLISHED_STONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_STONE_SLAB.get().getDefaultInstance(), ModItems.POLISHED_STONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.POLISHED_STONE_WALL.get().getDefaultInstance(), ModItems.POLISHED_STONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.POLISHED_DEEPSLATE_FENCE.get().getDefaultInstance(), ModItems.SMOOTH_DEEPSLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_DEEPSLATE.get().getDefaultInstance(), ModItems.SMOOTH_DEEPSLATE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_DEEPSLATE_STAIRS.get().getDefaultInstance(), ModItems.SMOOTH_DEEPSLATE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_DEEPSLATE_SLAB.get().getDefaultInstance(), ModItems.SMOOTH_DEEPSLATE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SMOOTH_DEEPSLATE_WALL.get().getDefaultInstance(), ModItems.SMOOTH_DEEPSLATE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.NETHERRACK_FENCE.get().getDefaultInstance(), ModItems.NETHERRACK_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_BRICKS.get().getDefaultInstance(), ModItems.NETHERRACK_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_BRICK_STAIRS.get().getDefaultInstance(), ModItems.NETHERRACK_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_BRICK_SLAB.get().getDefaultInstance(), ModItems.NETHERRACK_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_BRICK_WALL.get().getDefaultInstance(), ModItems.NETHERRACK_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BRICK_FENCE.get().getDefaultInstance(), ModItems.BIG_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIG_BRICKS.get().getDefaultInstance(), ModItems.BIG_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIG_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BIG_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIG_BRICK_SLAB.get().getDefaultInstance(), ModItems.BIG_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIG_BRICK_WALL.get().getDefaultInstance(), ModItems.BIG_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.GILDED_BLACKSTONE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_FENCE.get().getDefaultInstance(), Items.GILDED_BLACKSTONE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GILDED_BLACKSTONE.getDefaultInstance(), ModItems.GILDED_BLACKSTONE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GILDED_BLACKSTONE_STAIRS.get().getDefaultInstance(), ModItems.GILDED_BLACKSTONE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GILDED_BLACKSTONE_SLAB.get().getDefaultInstance(), ModItems.GILDED_BLACKSTONE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GILDED_BLACKSTONE_WALL.get().getDefaultInstance(), ModItems.GILDED_BLACKSTONE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.PURPUR_PILLAR.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPUR_FENCE.get().getDefaultInstance(), Items.PURPUR_PILLAR.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (tabData.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            tabData.insertAfter(Items.TERRACOTTA.getDefaultInstance(), ModItems.TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WHITE_TERRACOTTA.getDefaultInstance(), ModItems.WHITE_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.ORANGE_TERRACOTTA.getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.MAGENTA_TERRACOTTA.getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIGHT_BLUE_TERRACOTTA.getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.YELLOW_TERRACOTTA.getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIME_TERRACOTTA.getDefaultInstance(), ModItems.LIME_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PINK_TERRACOTTA.getDefaultInstance(), ModItems.PINK_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GRAY_TERRACOTTA.getDefaultInstance(), ModItems.GRAY_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIGHT_GRAY_TERRACOTTA.getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CYAN_TERRACOTTA.getDefaultInstance(), ModItems.CYAN_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PURPLE_TERRACOTTA.getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BLUE_TERRACOTTA.getDefaultInstance(), ModItems.BLUE_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BROWN_TERRACOTTA.getDefaultInstance(), ModItems.BROWN_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GREEN_TERRACOTTA.getDefaultInstance(), ModItems.GREEN_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RED_TERRACOTTA.getDefaultInstance(), ModItems.RED_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BLACK_TERRACOTTA.getDefaultInstance(), ModItems.BLACK_TERRACOTTA_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_STAIRS.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_SLAB.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WHITE_CONCRETE.getDefaultInstance(), ModItems.WHITE_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.ORANGE_CONCRETE.getDefaultInstance(), ModItems.ORANGE_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.MAGENTA_CONCRETE.getDefaultInstance(), ModItems.MAGENTA_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIGHT_BLUE_CONCRETE.getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.YELLOW_CONCRETE.getDefaultInstance(), ModItems.YELLOW_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIME_CONCRETE.getDefaultInstance(), ModItems.LIME_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.LIME_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.LIME_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PINK_CONCRETE.getDefaultInstance(), ModItems.PINK_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.PINK_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.PINK_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GRAY_CONCRETE.getDefaultInstance(), ModItems.GRAY_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LIGHT_GRAY_CONCRETE.getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.CYAN_CONCRETE.getDefaultInstance(), ModItems.CYAN_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.PURPLE_CONCRETE.getDefaultInstance(), ModItems.PURPLE_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BLUE_CONCRETE.getDefaultInstance(), ModItems.BLUE_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BROWN_CONCRETE.getDefaultInstance(), ModItems.BROWN_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GREEN_CONCRETE.getDefaultInstance(), ModItems.GREEN_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RED_CONCRETE.getDefaultInstance(), ModItems.RED_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.RED_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.RED_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BLACK_CONCRETE.getDefaultInstance(), ModItems.BLACK_CONCRETE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_STAIRS.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_SLAB.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_WALL.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WHITE_CONCRETE_WALL.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_WALL.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_WALL.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_WALL.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_WALL.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_WALL.get().getDefaultInstance(), ModItems.LIME_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_WALL.get().getDefaultInstance(), ModItems.PINK_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_WALL.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_WALL.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_WALL.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_WALL.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_WALL.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_WALL.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_WALL.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_WALL.get().getDefaultInstance(), ModItems.RED_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_WALL.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.WHITE_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.ORANGE_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.MAGENTA_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.YELLOW_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIME_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.LIME_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PINK_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.PINK_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.GRAY_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.CYAN_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.PURPLE_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.BLUE_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.BROWN_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.GREEN_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RED_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.RED_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_FENCE.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_BRICKS.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_TERRACOTTA_BRICK_WALL.get().getDefaultInstance(), ModItems.BLACK_TERRACOTTA_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WHITE_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WHITE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.WHITE_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.ORANGE_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.ORANGE_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.MAGENTA_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.LIGHT_BLUE_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.YELLOW_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.YELLOW_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIME_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.LIME_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.LIME_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIME_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIME_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.LIME_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PINK_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.PINK_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.PINK_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PINK_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.PINK_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.PINK_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GRAY_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.GRAY_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.LIGHT_GRAY_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.CYAN_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.CYAN_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.PURPLE_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.PURPLE_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLUE_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.BLUE_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BROWN_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.BROWN_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GREEN_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.GREEN_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RED_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.RED_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.RED_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.RED_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.RED_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.RED_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.BLACK_CONCRETE_FENCE.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_BRICKS.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_BRICK_STAIRS.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_BRICK_SLAB.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_CONCRETE_BRICK_WALL.get().getDefaultInstance(), ModItems.BLACK_CONCRETE_BRICK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.WHITE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.ORANGE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.MAGENTA_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.LIGHT_BLUE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.YELLOW_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.LIME_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.PINK_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.GRAY_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.LIGHT_GRAY_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CYAN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.PURPLE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.BLUE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.BROWN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.GREEN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.RED_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.BLACK_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GLASS.getDefaultInstance(), Items.GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TINTED_GLASS.getDefaultInstance(), ModItems.TINTED_GLASS_PANE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WHITE_STAINED_GLASS.getDefaultInstance(), Items.WHITE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.ORANGE_STAINED_GLASS.getDefaultInstance(), Items.ORANGE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MAGENTA_STAINED_GLASS.getDefaultInstance(), Items.MAGENTA_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIGHT_BLUE_STAINED_GLASS.getDefaultInstance(), Items.LIGHT_BLUE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.YELLOW_STAINED_GLASS.getDefaultInstance(), Items.YELLOW_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIME_STAINED_GLASS.getDefaultInstance(), Items.LIME_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PINK_STAINED_GLASS.getDefaultInstance(), Items.PINK_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GRAY_STAINED_GLASS.getDefaultInstance(), Items.GRAY_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIGHT_GRAY_STAINED_GLASS.getDefaultInstance(), Items.LIGHT_GRAY_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CYAN_STAINED_GLASS.getDefaultInstance(), Items.CYAN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PURPLE_STAINED_GLASS.getDefaultInstance(), Items.PURPLE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BLUE_STAINED_GLASS.getDefaultInstance(), Items.BLUE_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BROWN_STAINED_GLASS.getDefaultInstance(), Items.BROWN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GREEN_STAINED_GLASS.getDefaultInstance(), Items.GREEN_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RED_STAINED_GLASS.getDefaultInstance(), Items.RED_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BLACK_STAINED_GLASS.getDefaultInstance(), Items.BLACK_STAINED_GLASS_PANE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GLASS_PANE.getDefaultInstance(), ModItems.GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TINTED_GLASS_PANE.get().getDefaultInstance(), ModItems.TINTED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WHITE_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.WHITE_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.ORANGE_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.ORANGE_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MAGENTA_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.MAGENTA_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIGHT_BLUE_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.LIGHT_BLUE_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.YELLOW_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.YELLOW_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIME_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.LIME_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PINK_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.PINK_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GRAY_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.GRAY_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.LIGHT_GRAY_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.LIGHT_GRAY_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CYAN_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.CYAN_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.PURPLE_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.PURPLE_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BLUE_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.BLUE_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BROWN_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.BROWN_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GREEN_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.GREEN_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RED_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.RED_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BLACK_STAINED_GLASS_PANE.getDefaultInstance(), ModItems.BLACK_STAINED_GLASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GLASS_DOOR.get().getDefaultInstance(), ModItems.GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TINTED_GLASS_DOOR.get().getDefaultInstance(), ModItems.TINTED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WHITE_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.WHITE_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ORANGE_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.ORANGE_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MAGENTA_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.MAGENTA_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_BLUE_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.YELLOW_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.YELLOW_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIME_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.LIME_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PINK_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.PINK_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRAY_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.GRAY_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LIGHT_GRAY_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CYAN_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.CYAN_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PURPLE_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.PURPLE_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLUE_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.BLUE_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BROWN_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.BROWN_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GREEN_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.GREEN_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.RED_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACK_STAINED_GLASS_DOOR.get().getDefaultInstance(), ModItems.BLACK_STAINED_GLASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            tabData.insertAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(), ModItems.PLAYER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TNT.getDefaultInstance(), ModItems.NUKE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.FURNACE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CHISELED_BOOKSHELF.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BARREL.getDefaultInstance(), ModItems.OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.STONE_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.LECTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.STRING.getDefaultInstance(), ModItems.OAK_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.BARREL.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CHEST.getDefaultInstance(), ModItems.OAK_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CHEST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.HOPPER.getDefaultInstance(), ModItems.OAK_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.TRAPPED_CHEST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_FURNACE.get().getDefaultInstance(), ModItems.OAK_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.DISPENSER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.DROPPER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.HONEY_BLOCK.getDefaultInstance(), ModItems.STONE_DISPENSER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_DISPENSER.get().getDefaultInstance(), ModItems.BLACKSTONE_DISPENSER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_DISPENSER.get().getDefaultInstance(), ModItems.DEEPSLATE_DISPENSER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_DISPENSER.get().getDefaultInstance(), ModItems.STONE_DROPPER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_DROPPER.get().getDefaultInstance(), ModItems.BLACKSTONE_DROPPER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_DROPPER.get().getDefaultInstance(), ModItems.DEEPSLATE_DROPPER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.OBSERVER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DECORATED_POT.getDefaultInstance(), ModItems.STONE_OBSERVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_OBSERVER.get().getDefaultInstance(), ModItems.BLACKSTONE_OBSERVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_OBSERVER.get().getDefaultInstance(), ModItems.DEEPSLATE_OBSERVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CRAFTER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_DROPPER.get().getDefaultInstance(), ModItems.OAK_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CRAFTER.get().getDefaultInstance(), ModItems.SPRUCE_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CRAFTER.get().getDefaultInstance(), ModItems.BIRCH_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CRAFTER.get().getDefaultInstance(), ModItems.JUNGLE_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CRAFTER.get().getDefaultInstance(), ModItems.ACACIA_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CRAFTER.get().getDefaultInstance(), ModItems.DARK_OAK_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CRAFTER.get().getDefaultInstance(), ModItems.MANGROVE_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CRAFTER.get().getDefaultInstance(), ModItems.CHERRY_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CRAFTER.get().getDefaultInstance(), ModItems.PALE_OAK_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CRAFTER.get().getDefaultInstance(), ModItems.BAMBOO_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CRAFTER.get().getDefaultInstance(), ModItems.CRIMSON_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CRAFTER.get().getDefaultInstance(), ModItems.WARPED_CRAFTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.FURNACE_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CHEST_MINECART.getDefaultInstance(), ModItems.STONE_FURNACE_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.HOPPER_MINECART.getDefaultInstance(), ModItems.OAK_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            tabData.insertAfter(Items.PRISMARINE.getDefaultInstance(), ModItems.ELDER_PRISMARINE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SOUL_SAND.getDefaultInstance(), ModItems.SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TUFF.getDefaultInstance(), ModItems.RHYOLITE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TUFF.getDefaultInstance(), ModItems.GABBRO.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SMOOTH_BASALT.getDefaultInstance(), ModItems.PUMICE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RAW_COPPER_BLOCK.getDefaultInstance(), ModItems.RAW_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_COPPER_ORE.getDefaultInstance(), ModItems.ZINC_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ZINC_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_ZINC_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RAW_ZINC_BLOCK.get().getDefaultInstance(), ModItems.RAW_SILVER_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_ZINC_ORE.get().getDefaultInstance(), ModItems.SILVER_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SILVER_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_SILVER_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RAW_SILVER_BLOCK.get().getDefaultInstance(), ModItems.RAW_TIN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_SILVER_ORE.get().getDefaultInstance(), ModItems.TIN_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TIN_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_TIN_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RAW_TIN_BLOCK.get().getDefaultInstance(), ModItems.RAW_TUNGSTEN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_TIN_ORE.get().getDefaultInstance(), ModItems.TUNGSTEN_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUNGSTEN_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_TUNGSTEN_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RAW_TUNGSTEN_BLOCK.get().getDefaultInstance(), ModItems.RAW_PLATINUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_TUNGSTEN_ORE.get().getDefaultInstance(), ModItems.PLATINUM_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PLATINUM_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_PLATINUM_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RAW_GOLD_BLOCK.getDefaultInstance(), ModItems.RAW_LEAD_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.DEEPSLATE_GOLD_ORE.getDefaultInstance(), ModItems.LEAD_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LEAD_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_LEAD_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.RAW_LEAD_BLOCK.get().getDefaultInstance(), ModItems.RAW_URANIUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_LEAD_ORE.get().getDefaultInstance(), ModItems.URANIUM_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.URANIUM_ORE.get().getDefaultInstance(), ModItems.DEEPSLATE_URANIUM_ORE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


        } else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            tabData.remove(Items.CRAFTING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.MAGMA_BLOCK.getDefaultInstance(), ModItems.OAK_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.SPRUCE_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.BIRCH_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.JUNGLE_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.ACACIA_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.DARK_OAK_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.MANGROVE_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.CHERRY_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.PALE_OAK_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.BAMBOO_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.CRIMSON_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CRAFTING_TABLE.get().getDefaultInstance(), ModItems.WARPED_CRAFTING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CARTOGRAPHY_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.STONECUTTER.getDefaultInstance(), ModItems.OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.SPRUCE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.BIRCH_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.JUNGLE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.ACACIA_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.DARK_OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.MANGROVE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.CHERRY_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.PALE_OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.BAMBOO_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.CRIMSON_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.WARPED_CARTOGRAPHY_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.FLETCHING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_CARTOGRAPHY_TABLE.get().getDefaultInstance(), ModItems.OAK_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.SPRUCE_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.BIRCH_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.JUNGLE_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.ACACIA_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.DARK_OAK_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.MANGROVE_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.CHERRY_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.PALE_OAK_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.BAMBOO_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.CRIMSON_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.WARPED_FLETCHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.SMITHING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_FLETCHING_TABLE.get().getDefaultInstance(), ModItems.OAK_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_SMITHING_TABLE.get().getDefaultInstance(), ModItems.SPRUCE_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_SMITHING_TABLE.get().getDefaultInstance(), ModItems.BIRCH_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_SMITHING_TABLE.get().getDefaultInstance(), ModItems.JUNGLE_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_SMITHING_TABLE.get().getDefaultInstance(), ModItems.ACACIA_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_SMITHING_TABLE.get().getDefaultInstance(), ModItems.DARK_OAK_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_SMITHING_TABLE.get().getDefaultInstance(), ModItems.MANGROVE_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_SMITHING_TABLE.get().getDefaultInstance(), ModItems.CHERRY_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_SMITHING_TABLE.get().getDefaultInstance(), ModItems.PALE_OAK_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_SMITHING_TABLE.get().getDefaultInstance(), ModItems.BAMBOO_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_SMITHING_TABLE.get().getDefaultInstance(), ModItems.CRIMSON_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_SMITHING_TABLE.get().getDefaultInstance(), ModItems.WARPED_SMITHING_TABLE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.GRINDSTONE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_SMITHING_TABLE.get().getDefaultInstance(), ModItems.OAK_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_GRINDSTONE.get().getDefaultInstance(), ModItems.SPRUCE_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_GRINDSTONE.get().getDefaultInstance(), ModItems.BIRCH_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_GRINDSTONE.get().getDefaultInstance(), ModItems.JUNGLE_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_GRINDSTONE.get().getDefaultInstance(), ModItems.ACACIA_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_GRINDSTONE.get().getDefaultInstance(), ModItems.DARK_OAK_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_GRINDSTONE.get().getDefaultInstance(), ModItems.MANGROVE_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_GRINDSTONE.get().getDefaultInstance(), ModItems.CHERRY_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_GRINDSTONE.get().getDefaultInstance(), ModItems.PALE_OAK_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_GRINDSTONE.get().getDefaultInstance(), ModItems.BAMBOO_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_GRINDSTONE.get().getDefaultInstance(), ModItems.CRIMSON_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_GRINDSTONE.get().getDefaultInstance(), ModItems.WARPED_GRINDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.LOOM.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_GRINDSTONE.get().getDefaultInstance(), ModItems.OAK_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_LOOM.get().getDefaultInstance(), ModItems.SPRUCE_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_LOOM.get().getDefaultInstance(), ModItems.BIRCH_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_LOOM.get().getDefaultInstance(), ModItems.JUNGLE_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_LOOM.get().getDefaultInstance(), ModItems.ACACIA_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_LOOM.get().getDefaultInstance(), ModItems.DARK_OAK_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_LOOM.get().getDefaultInstance(), ModItems.MANGROVE_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_LOOM.get().getDefaultInstance(), ModItems.CHERRY_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_LOOM.get().getDefaultInstance(), ModItems.PALE_OAK_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_LOOM.get().getDefaultInstance(), ModItems.BAMBOO_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_LOOM.get().getDefaultInstance(), ModItems.CRIMSON_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_LOOM.get().getDefaultInstance(), ModItems.WARPED_LOOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.FURNACE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_LOOM.get().getDefaultInstance(), ModItems.STONE_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_FURNACE.get().getDefaultInstance(), ModItems.BLACKSTONE_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_FURNACE.get().getDefaultInstance(), ModItems.DEEPSLATE_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.SMOKER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_FURNACE.get().getDefaultInstance(), ModItems.OAK_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_STONE_SMOKER.get().getDefaultInstance(), ModItems.SPRUCE_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_STONE_SMOKER.get().getDefaultInstance(), ModItems.BIRCH_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_STONE_SMOKER.get().getDefaultInstance(), ModItems.JUNGLE_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_STONE_SMOKER.get().getDefaultInstance(), ModItems.ACACIA_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_STONE_SMOKER.get().getDefaultInstance(), ModItems.DARK_OAK_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_STONE_SMOKER.get().getDefaultInstance(), ModItems.MANGROVE_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_STONE_SMOKER.get().getDefaultInstance(), ModItems.CHERRY_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_STONE_SMOKER.get().getDefaultInstance(), ModItems.PALE_OAK_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_STONE_SMOKER.get().getDefaultInstance(), ModItems.BAMBOO_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_STONE_SMOKER.get().getDefaultInstance(), ModItems.CRIMSON_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_STONE_SMOKER.get().getDefaultInstance(), ModItems.WARPED_STONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_STONE_SMOKER.get().getDefaultInstance(), ModItems.OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.SPRUCE_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.BIRCH_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.JUNGLE_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.ACACIA_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.DARK_OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.MANGROVE_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.CHERRY_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.PALE_OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.BAMBOO_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.CRIMSON_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.WARPED_BLACKSTONE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_BLACKSTONE_SMOKER.get().getDefaultInstance(), ModItems.OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.SPRUCE_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.BIRCH_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.JUNGLE_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.ACACIA_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.DARK_OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.MANGROVE_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.CHERRY_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.PALE_OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.BAMBOO_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.CRIMSON_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.WARPED_DEEPSLATE_SMOKER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.BLAST_FURNACE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_DEEPSLATE_SMOKER.get().getDefaultInstance(), ModItems.STONE_BLAST_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_BLAST_FURNACE.get().getDefaultInstance(), ModItems.BLACKSTONE_BLAST_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_BLAST_FURNACE.get().getDefaultInstance(), ModItems.DEEPSLATE_BLAST_FURNACE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CAMPFIRE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.SOUL_CAMPFIRE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_BLAST_FURNACE.get().getDefaultInstance(), ModItems.OAK_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CAMPFIRE.get().getDefaultInstance(), ModItems.SPRUCE_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CAMPFIRE.get().getDefaultInstance(), ModItems.BIRCH_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CAMPFIRE.get().getDefaultInstance(), ModItems.JUNGLE_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CAMPFIRE.get().getDefaultInstance(), ModItems.ACACIA_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CAMPFIRE.get().getDefaultInstance(), ModItems.DARK_OAK_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CAMPFIRE.get().getDefaultInstance(), ModItems.MANGROVE_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CAMPFIRE.get().getDefaultInstance(), ModItems.CHERRY_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CAMPFIRE.get().getDefaultInstance(), ModItems.PALE_OAK_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CAMPFIRE.get().getDefaultInstance(), ModItems.BAMBOO_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CAMPFIRE.get().getDefaultInstance(), ModItems.CRIMSON_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CAMPFIRE.get().getDefaultInstance(), ModItems.WARPED_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_CAMPFIRE.get().getDefaultInstance(), ModItems.OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.SPRUCE_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.BIRCH_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.JUNGLE_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.ACACIA_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.DARK_OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.MANGROVE_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.CHERRY_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.PALE_OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.BAMBOO_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.CRIMSON_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_SOUL_CAMPFIRE.get().getDefaultInstance(), ModItems.WARPED_SOUL_CAMPFIRE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.BEEHIVE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.BEE_NEST.getDefaultInstance(), ModItems.OAK_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_BEEHIVE.get().getDefaultInstance(), ModItems.SPRUCE_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_BEEHIVE.get().getDefaultInstance(), ModItems.BIRCH_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_BEEHIVE.get().getDefaultInstance(), ModItems.JUNGLE_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_BEEHIVE.get().getDefaultInstance(), ModItems.ACACIA_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_BEEHIVE.get().getDefaultInstance(), ModItems.DARK_OAK_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_BEEHIVE.get().getDefaultInstance(), ModItems.MANGROVE_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_BEEHIVE.get().getDefaultInstance(), ModItems.CHERRY_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_BEEHIVE.get().getDefaultInstance(), ModItems.PALE_OAK_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_BEEHIVE.get().getDefaultInstance(), ModItems.BAMBOO_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_BEEHIVE.get().getDefaultInstance(), ModItems.CRIMSON_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_BEEHIVE.get().getDefaultInstance(), ModItems.WARPED_BEEHIVE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CHISELED_BOOKSHELF.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.remove(Items.BOOKSHELF.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(Items.OAK_SHELF.getDefaultInstance(), ModItems.WARPED_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.WARPED_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.CRIMSON_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.CRIMSON_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.BAMBOO_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.BAMBOO_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.PALE_OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.PALE_OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.CHERRY_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.CHERRY_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.MANGROVE_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.MANGROVE_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.DARK_OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.DARK_OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.ACACIA_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.ACACIA_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.JUNGLE_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.JUNGLE_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.BIRCH_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.BIRCH_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.SPRUCE_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.SPRUCE_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.OAK_CHISELED_BOOKSHELF.get().getDefaultInstance(), ModItems.WARPED_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.WARPED_BOOKSHELF.get().getDefaultInstance(), ModItems.CRIMSON_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.CRIMSON_BOOKSHELF.get().getDefaultInstance(), ModItems.BAMBOO_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.BAMBOO_BOOKSHELF.get().getDefaultInstance(), ModItems.PALE_OAK_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.PALE_OAK_BOOKSHELF.get().getDefaultInstance(), ModItems.CHERRY_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.CHERRY_BOOKSHELF.get().getDefaultInstance(), ModItems.MANGROVE_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.MANGROVE_BOOKSHELF.get().getDefaultInstance(), ModItems.DARK_OAK_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.DARK_OAK_BOOKSHELF.get().getDefaultInstance(), ModItems.ACACIA_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.ACACIA_BOOKSHELF.get().getDefaultInstance(), ModItems.JUNGLE_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.JUNGLE_BOOKSHELF.get().getDefaultInstance(), ModItems.BIRCH_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.BIRCH_BOOKSHELF.get().getDefaultInstance(), ModItems.SPRUCE_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertBefore(ModItems.SPRUCE_BOOKSHELF.get().getDefaultInstance(), ModItems.OAK_BOOKSHELF.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.LECTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WARPED_SHELF.getDefaultInstance(), ModItems.OAK_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_LECTERN.get().getDefaultInstance(), ModItems.SPRUCE_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_LECTERN.get().getDefaultInstance(), ModItems.BIRCH_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_LECTERN.get().getDefaultInstance(), ModItems.JUNGLE_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_LECTERN.get().getDefaultInstance(), ModItems.ACACIA_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_LECTERN.get().getDefaultInstance(), ModItems.DARK_OAK_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_LECTERN.get().getDefaultInstance(), ModItems.MANGROVE_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_LECTERN.get().getDefaultInstance(), ModItems.CHERRY_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_LECTERN.get().getDefaultInstance(), ModItems.PALE_OAK_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_LECTERN.get().getDefaultInstance(), ModItems.BAMBOO_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_LECTERN.get().getDefaultInstance(), ModItems.CRIMSON_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_LECTERN.get().getDefaultInstance(), ModItems.WARPED_LECTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.BREWING_STAND.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.END_CRYSTAL.getDefaultInstance(), ModItems.STONE_BREWING_STAND.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_BREWING_STAND.get().getDefaultInstance(), ModItems.BLACKSTONE_BREWING_STAND.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_BREWING_STAND.get().getDefaultInstance(), ModItems.DEEPSLATE_BREWING_STAND.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.BARREL.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_OXIDIZED_COPPER_CHEST.getDefaultInstance(), ModItems.OAK_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_BARREL.get().getDefaultInstance(), ModItems.SPRUCE_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_BARREL.get().getDefaultInstance(), ModItems.BIRCH_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_BARREL.get().getDefaultInstance(), ModItems.JUNGLE_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_BARREL.get().getDefaultInstance(), ModItems.ACACIA_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_BARREL.get().getDefaultInstance(), ModItems.DARK_OAK_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_BARREL.get().getDefaultInstance(), ModItems.MANGROVE_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_BARREL.get().getDefaultInstance(), ModItems.CHERRY_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_BARREL.get().getDefaultInstance(), ModItems.PALE_OAK_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_BARREL.get().getDefaultInstance(), ModItems.BAMBOO_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_BARREL.get().getDefaultInstance(), ModItems.CRIMSON_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_BARREL.get().getDefaultInstance(), ModItems.WARPED_BARREL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CHEST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), ModItems.OAK_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CHEST.get().getDefaultInstance(), ModItems.SPRUCE_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CHEST.get().getDefaultInstance(), ModItems.BIRCH_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CHEST.get().getDefaultInstance(), ModItems.JUNGLE_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CHEST.get().getDefaultInstance(), ModItems.ACACIA_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CHEST.get().getDefaultInstance(), ModItems.DARK_OAK_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CHEST.get().getDefaultInstance(), ModItems.MANGROVE_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CHEST.get().getDefaultInstance(), ModItems.CHERRY_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CHEST.get().getDefaultInstance(), ModItems.PALE_OAK_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CHEST.get().getDefaultInstance(), ModItems.BAMBOO_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CHEST.get().getDefaultInstance(), ModItems.CRIMSON_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CHEST.get().getDefaultInstance(), ModItems.WARPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_OXIDIZED_COPPER_CHEST.getDefaultInstance(), ModItems.OAK_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.SPRUCE_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.BIRCH_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.JUNGLE_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.ACACIA_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.DARK_OAK_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.MANGROVE_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.CHERRY_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.PALE_OAK_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.BAMBOO_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.CRIMSON_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_TRAPPED_CHEST.get().getDefaultInstance(), ModItems.WARPED_TRAPPED_CHEST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.IRON_CHAIN.getDefaultInstance(), ModItems.EXPOSED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WEATHERED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_CHAIN.get().getDefaultInstance(), ModItems.RUSTED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_CHAIN.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_CHAIN.waxedOxidized().getDefaultInstance(), ModItems.ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ZINC_CHAIN.get().getDefaultInstance(), ModItems.EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.CORRODED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CORRODED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.WAXED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.WAXED_CORRODED_ZINC_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_CORRODED_ZINC_CHAIN.get().getDefaultInstance(), ModItems.SILVER_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SILVER_CHAIN.get().getDefaultInstance(), ModItems.TIN_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TIN_CHAIN.get().getDefaultInstance(), ModItems.TUNGSTEN_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUNGSTEN_CHAIN.get().getDefaultInstance(), ModItems.PLATINUM_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PLATINUM_CHAIN.get().getDefaultInstance(), ModItems.GOLD_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_CHAIN.get().getDefaultInstance(), ModItems.LEAD_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LEAD_CHAIN.get().getDefaultInstance(), ModItems.URANIUM_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.URANIUM_CHAIN.get().getDefaultInstance(), ModItems.NETHERITE_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_CHAIN.get().getDefaultInstance(), ModItems.BRONZE_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_CHAIN.get().getDefaultInstance(), ModItems.BRASS_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRASS_CHAIN.get().getDefaultInstance(), ModItems.STEEL_CHAIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SEA_LANTERN.getDefaultInstance(), ModItems.ELDER_SEA_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SOUL_TORCH.getDefaultInstance(), ModItems.IRON_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_TORCH.getDefaultInstance(), ModItems.ZINC_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ZINC_TORCH.get().getDefaultInstance(), ModItems.SILVER_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SILVER_TORCH.get().getDefaultInstance(), ModItems.TIN_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TIN_TORCH.get().getDefaultInstance(), ModItems.TUNGSTEN_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUNGSTEN_TORCH.get().getDefaultInstance(), ModItems.PLATINUM_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PLATINUM_TORCH.get().getDefaultInstance(), ModItems.GOLD_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_TORCH.get().getDefaultInstance(), ModItems.LEAD_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LEAD_TORCH.get().getDefaultInstance(), ModItems.URANIUM_TORCH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.LANTERN.getDefaultInstance(), ModItems.EXPOSED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_LANTERN.get().getDefaultInstance(), ModItems.WEATHERED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_LANTERN.get().getDefaultInstance(), ModItems.RUSTED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_LANTERN.get().getDefaultInstance(), ModItems.WAXED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_LANTERN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_LANTERN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_LANTERN.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.SOUL_LANTERN.getDefaultInstance(), ModItems.EXPOSED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WEATHERED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.RUSTED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_RUSTED_IRON_SOUL_LANTERN.get().getDefaultInstance(), ModItems.IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.EXPOSED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WEATHERED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.RUSTED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RUSTED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_IRON_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_RUSTED_IRON_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_LANTERN.waxedOxidized().getDefaultInstance(), ModItems.COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OXIDIZED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get().getDefaultInstance(), ModItems.COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXPOSED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WEATHERED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OXIDIZED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_FIRE_LANTERN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            tabData.insertAfter(Items.PRISMARINE_CRYSTALS.getDefaultInstance(), ModItems.ELDER_PRISMARINE_SHARD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_SHARD.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_CRYSTALS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE.getDefaultInstance(), ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


            tabData.insertAfter(Items.SNOWBALL.getDefaultInstance(), ModItems.ICE_SHARD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.STICK.getDefaultInstance(), ModItems.STONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_BATON.get().getDefaultInstance(), ModItems.GRANITE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GRANITE_BATON.get().getDefaultInstance(), ModItems.DIORITE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DIORITE_BATON.get().getDefaultInstance(), ModItems.ANDESITE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ANDESITE_BATON.get().getDefaultInstance(), ModItems.DEEPSLATE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DEEPSLATE_BATON.get().getDefaultInstance(), ModItems.TUFF_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUFF_BATON.get().getDefaultInstance(), ModItems.GABBRO_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GABBRO_BATON.get().getDefaultInstance(), ModItems.RHYOLITE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RHYOLITE_BATON.get().getDefaultInstance(), ModItems.CALCITE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CALCITE_BATON.get().getDefaultInstance(), ModItems.PACKED_MUD_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PACKED_MUD_BATON.get().getDefaultInstance(), ModItems.SANDSTONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SANDSTONE_BATON.get().getDefaultInstance(), ModItems.RED_SANDSTONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RED_SANDSTONE_BATON.get().getDefaultInstance(), ModItems.SOUL_SANDSTONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SOUL_SANDSTONE_BATON.get().getDefaultInstance(), ModItems.NETHERRACK_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERRACK_BATON.get().getDefaultInstance(), ModItems.BASALT_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BASALT_BATON.get().getDefaultInstance(), ModItems.PUMICE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PUMICE_BATON.get().getDefaultInstance(), ModItems.BLACKSTONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_BATON.get().getDefaultInstance(), ModItems.END_STONE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.END_STONE_BATON.get().getDefaultInstance(), ModItems.OBSIDIAN_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OBSIDIAN_BATON.get().getDefaultInstance(), ModItems.TERRACOTTA_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TERRACOTTA_BATON.get().getDefaultInstance(), ModItems.CONCRETE_BATON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RESIN_BRICK.getDefaultInstance(), ModItems.SCULK_BRICK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.RAW_COPPER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RAW_IRON.getDefaultInstance(), Items.RAW_COPPER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RAW_COPPER.getDefaultInstance(), ModItems.RAW_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_ZINC.get().getDefaultInstance(), ModItems.RAW_SILVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_SILVER.get().getDefaultInstance(), ModItems.RAW_TIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_TIN.get().getDefaultInstance(), ModItems.RAW_TUNGSTEN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_TUNGSTEN.get().getDefaultInstance(), ModItems.RAW_PLATINUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RAW_GOLD.getDefaultInstance(), ModItems.RAW_LEAD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_LEAD.get().getDefaultInstance(), ModItems.RAW_URANIUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.COPPER_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.IRON_INGOT.getDefaultInstance(), Items.COPPER_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_INGOT.getDefaultInstance(), ModItems.ZINC_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ZINC_INGOT.get().getDefaultInstance(), ModItems.SILVER_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SILVER_INGOT.get().getDefaultInstance(), ModItems.TIN_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TIN_INGOT.get().getDefaultInstance(), ModItems.TUNGSTEN_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUNGSTEN_INGOT.get().getDefaultInstance(), ModItems.PLATINUM_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GOLD_INGOT.getDefaultInstance(), ModItems.LEAD_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LEAD_INGOT.get().getDefaultInstance(), ModItems.URANIUM_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.NETHERITE_INGOT.getDefaultInstance(), ModItems.BRONZE_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_INGOT.get().getDefaultInstance(), ModItems.BRASS_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRASS_INGOT.get().getDefaultInstance(), ModItems.STEEL_INGOT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.COPPER_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.IRON_NUGGET.getDefaultInstance(), Items.COPPER_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_NUGGET.getDefaultInstance(), ModItems.ZINC_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ZINC_NUGGET.get().getDefaultInstance(), ModItems.SILVER_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SILVER_NUGGET.get().getDefaultInstance(), ModItems.TIN_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TIN_NUGGET.get().getDefaultInstance(), ModItems.TUNGSTEN_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.TUNGSTEN_NUGGET.get().getDefaultInstance(), ModItems.PLATINUM_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.GOLD_NUGGET.getDefaultInstance(), ModItems.LEAD_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.LEAD_NUGGET.get().getDefaultInstance(), ModItems.URANIUM_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.URANIUM_NUGGET.get().getDefaultInstance(), ModItems.NETHERITE_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_NUGGET.get().getDefaultInstance(), ModItems.BRONZE_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_NUGGET.get().getDefaultInstance(), ModItems.BRASS_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRASS_NUGGET.get().getDefaultInstance(), ModItems.STEEL_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            tabData.insertAfter(Items.LAVA_BUCKET.getDefaultInstance(), ModItems.NUCLEAR_WASTE_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.MUSIC_DISC_ANGRY_BOYFRIENDS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.BAMBOO_CHEST_RAFT.getDefaultInstance(), ModItems.CRIMSON_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_BOAT.get().getDefaultInstance(), ModItems.CRIMSON_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CHEST_BOAT.get().getDefaultInstance(), ModItems.WARPED_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WARPED_BOAT.get().getDefaultInstance(), ModItems.WARPED_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.FURNACE_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.CHEST_MINECART.getDefaultInstance(), ModItems.STONE_FURNACE_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.STONE_FURNACE_MINECART.get().getDefaultInstance(), ModItems.BLACKSTONE_FURNACE_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BLACKSTONE_FURNACE_MINECART.get().getDefaultInstance(), ModItems.DEEPSLATE_FURNACE_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.remove(Items.CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.HOPPER_MINECART.getDefaultInstance(), ModItems.OAK_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.OAK_CHEST_MINECART.get().getDefaultInstance(), ModItems.SPRUCE_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.SPRUCE_CHEST_MINECART.get().getDefaultInstance(), ModItems.BIRCH_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BIRCH_CHEST_MINECART.get().getDefaultInstance(), ModItems.JUNGLE_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.JUNGLE_CHEST_MINECART.get().getDefaultInstance(), ModItems.ACACIA_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ACACIA_CHEST_MINECART.get().getDefaultInstance(), ModItems.DARK_OAK_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DARK_OAK_CHEST_MINECART.get().getDefaultInstance(), ModItems.MANGROVE_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MANGROVE_CHEST_MINECART.get().getDefaultInstance(), ModItems.CHERRY_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CHERRY_CHEST_MINECART.get().getDefaultInstance(), ModItems.PALE_OAK_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.PALE_OAK_CHEST_MINECART.get().getDefaultInstance(), ModItems.BAMBOO_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BAMBOO_CHEST_MINECART.get().getDefaultInstance(), ModItems.CRIMSON_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.CRIMSON_CHEST_MINECART.get().getDefaultInstance(), ModItems.WARPED_CHEST_MINECART.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_HOE.getDefaultInstance(), ModItems.BRONZE_SHOVEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_SHOVEL.get().getDefaultInstance(), ModItems.BRONZE_PICKAXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_PICKAXE.get().getDefaultInstance(), ModItems.BRONZE_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_AXE.get().getDefaultInstance(), ModItems.BRONZE_HOE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
            tabData.insertAfter(Items.TNT.getDefaultInstance(), ModItems.NUKE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.STREAMLINED_ARROW.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.SHARPENED_ARROW.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.EXPLOSIVE_ARROW.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_SWORD.getDefaultInstance(), ModItems.BRONZE_SWORD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_AXE.getDefaultInstance(), ModItems.BRONZE_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_SPEAR.getDefaultInstance(), ModItems.BRONZE_SPEAR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_HORSE_ARMOR.getDefaultInstance(), ModItems.BRONZE_HORSE_ARMOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.COPPER_NAUTILUS_ARMOR.getDefaultInstance(), ModItems.BRONZE_NAUTILUS_ARMOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_BOOTS.getDefaultInstance(), ModItems.BRONZE_HELMET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_HELMET.get().getDefaultInstance(), ModItems.BRONZE_CHESTPLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_CHESTPLATE.get().getDefaultInstance(), ModItems.BRONZE_LEGGINGS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.BRONZE_LEGGINGS.get().getDefaultInstance(), ModItems.BRONZE_BOOTS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
    }
}
