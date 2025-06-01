package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeInvConfig {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildersParadise.MODID);

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

            tabData.insertAfter(Items.IRON_BARS.getDefaultInstance(), ModItems.IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.IRON_TILES.get().getDefaultInstance(), ModItems.IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.GOLD_BLOCK.getDefaultInstance(), ModItems.GOLD_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_TILES.get().getDefaultInstance(), ModItems.GOLD_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_TILE_STAIRS.get().getDefaultInstance(), ModItems.GOLD_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.DIAMOND_BLOCK.getDefaultInstance(), ModItems.DIAMOND_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DIAMOND_TILES.get().getDefaultInstance(), ModItems.DIAMOND_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.DIAMOND_TILE_STAIRS.get().getDefaultInstance(), ModItems.DIAMOND_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.EMERALD_BLOCK.getDefaultInstance(), ModItems.EMERALD_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EMERALD_TILES.get().getDefaultInstance(), ModItems.EMERALD_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EMERALD_TILE_STAIRS.get().getDefaultInstance(), ModItems.EMERALD_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.NETHERITE_BLOCK.getDefaultInstance(), ModItems.NETHERITE_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_TILES.get().getDefaultInstance(), ModItems.NETHERITE_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_TILE_STAIRS.get().getDefaultInstance(), ModItems.NETHERITE_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.COPPER_TRAPDOOR.getDefaultInstance(), ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.EXPOSED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WEATHERED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.OXIDIZED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.WAXED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_EXPOSED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_WEATHERED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.WAXED_OXIDIZED_COPPER_TRAPDOOR.getDefaultInstance(), ModItems.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MILDLY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.MODERATELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_BLOCK.get().getDefaultInstance(), ModItems.WAXED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_TILES.get().getDefaultInstance(), ModItems.WAXED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.WAXED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.WAXED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_BARS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_BARS.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get().getDefaultInstance(), ModItems.WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.GOLD_TILE_SLAB.get().getDefaultInstance(), ModItems.GOLD_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.GOLD_DOOR.get().getDefaultInstance(), ModItems.GOLD_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(ModItems.NETHERITE_TILE_SLAB.get().getDefaultInstance(), ModItems.NETHERITE_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_DOOR.get().getDefaultInstance(), ModItems.NETHERITE_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.NETHERITE_TRAPDOOR.get().getDefaultInstance(), ModItems.PLAYER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

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
            tabData.accept(ModItems.ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.REALLY_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.SILVER_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.SILVER_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.TIN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_TIN_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TIN_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TIN_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.TUNGSTEN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.TUNGSTEN_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.PLATINUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PLATINUM_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.LEAD_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.LEAD_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.URANIUM_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.URANIUM_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.BRONZE_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.CUT_BRONZE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRONZE_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRONZE_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.BRASS_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.BRASS_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.accept(ModItems.STEEL_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_TILES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_TILE_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_TILE_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.STEEL_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.accept(ModItems.VILLAGER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            tabData.insertAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(), ModItems.PLAYER_ONLY_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.TNT.getDefaultInstance(), ModItems.NUKE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            tabData.insertAfter(Items.PRISMARINE.getDefaultInstance(), ModItems.ELDER_PRISMARINE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.SOUL_SAND.getDefaultInstance(), ModItems.SOUL_SANDSTONE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

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


        } else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            tabData.insertAfter(Items.PRISMARINE_CRYSTALS.getDefaultInstance(), ModItems.ELDER_PRISMARINE_SHARD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.ELDER_PRISMARINE_SHARD.get().getDefaultInstance(), ModItems.ELDER_PRISMARINE_CRYSTALS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            tabData.insertAfter(Items.RAW_COPPER.getDefaultInstance(), ModItems.RAW_ZINC.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_ZINC.get().getDefaultInstance(), ModItems.RAW_SILVER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_SILVER.get().getDefaultInstance(), ModItems.RAW_TIN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_TIN.get().getDefaultInstance(), ModItems.RAW_TUNGSTEN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_TUNGSTEN.get().getDefaultInstance(), ModItems.RAW_PLATINUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(Items.RAW_GOLD.getDefaultInstance(), ModItems.RAW_LEAD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.RAW_LEAD.get().getDefaultInstance(), ModItems.RAW_URANIUM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


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

            tabData.insertAfter(Items.IRON_NUGGET.getDefaultInstance(), ModItems.COPPER_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            tabData.insertAfter(ModItems.COPPER_NUGGET.get().getDefaultInstance(), ModItems.ZINC_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
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
        } else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
            tabData.insertAfter(Items.TNT.getDefaultInstance(), ModItems.NUKE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
