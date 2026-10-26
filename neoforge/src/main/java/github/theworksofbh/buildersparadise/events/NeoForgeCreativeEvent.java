package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.collections.CorrodingZincCollection;
import github.theworksofbh.buildersparadise.blocks.collections.RustingIronCollection;
import github.theworksofbh.buildersparadise.blocks.types.CorrodingZinc;
import github.theworksofbh.buildersparadise.blocks.types.RustingIron;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;

public class NeoForgeCreativeEvent {


    public static void addItemsToCreative(BuildCreativeModeTabContentsEvent event) {
        List<DyeColor> gameplayColorOrder = List.of(DyeColor.WHITE, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.BLACK, DyeColor.BROWN, DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW, DyeColor.LIME, DyeColor.GREEN, DyeColor.CYAN, DyeColor.LIGHT_BLUE, DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA, DyeColor.PINK);
        List<RustingIron.WeatherState> gameplayRustOrder = List.of(RustingIron.WeatherState.UNAFFECTED, RustingIron.WeatherState.EXPOSED, RustingIron.WeatherState.WEATHERED, RustingIron.WeatherState.RUSTED);
        List<CorrodingZinc.WeatherState> gameplayCorrosionOrder = List.of(CorrodingZinc.WeatherState.UNAFFECTED, CorrodingZinc.WeatherState.EXPOSED, CorrodingZinc.WeatherState.WEATHERED, CorrodingZinc.WeatherState.CORRODED);
        List<WeatheringCopper.WeatherState> gameplayWeatheringOrder = List.of(WeatheringCopper.WeatherState.UNAFFECTED, WeatheringCopper.WeatherState.EXPOSED, WeatheringCopper.WeatherState.WEATHERED, WeatheringCopper.WeatherState.OXIDIZED);

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(Blocks.STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.STONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.STONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COBBLESTONE_WALL.asItem().getDefaultInstance(), ModBlocks.COBBLESTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MOSSY_COBBLESTONE_WALL.asItem().getDefaultInstance(), ModBlocks.MOSSY_COBBLESTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_STONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_STONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.SMOOTH_STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_STONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.STONE_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.STONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MOSSY_STONE_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GRANITE_WALL.asItem().getDefaultInstance(), ModBlocks.GRANITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_GRANITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_GRANITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DIORITE_WALL.asItem().getDefaultInstance(), ModBlocks.DIORITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_DIORITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_DIORITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ANDESITE_WALL.asItem().getDefaultInstance(), ModBlocks.ANDESITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_ANDESITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_ANDESITE_SLAB.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COBBLED_DEEPSLATE_WALL.asItem().getDefaultInstance(), ModBlocks.COBBLED_DEEPSLATE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_DEEPSLATE_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_DEEPSLATE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_TILE_WALL.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_TILE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TUFF_WALL.asItem().getDefaultInstance(), ModBlocks.TUFF_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_TUFF_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_TUFF_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TUFF_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MUD_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.MUD_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RESIN_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.RESIN_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SANDSTONE_WALL.asItem().getDefaultInstance(), ModBlocks.SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CUT_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CUT_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.CUT_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_SANDSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RED_SANDSTONE_WALL.asItem().getDefaultInstance(), ModBlocks.RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_RED_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_RED_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_RED_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CUT_RED_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CUT_RED_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_RED_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.CUT_RED_SANDSTONE_SLAB.asItem().getDefaultInstance(), ModBlocks.CUT_RED_SANDSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CINNABAR_WALL.asItem().getDefaultInstance(), ModBlocks.CINNABAR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_CINNABAR_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_CINNABAR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CINNABAR_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.CINNABAR_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SULFUR_WALL.asItem().getDefaultInstance(), ModBlocks.SULFUR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_SULFUR_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_SULFUR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SULFUR_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.SULFUR_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PRISMARINE_WALL.asItem().getDefaultInstance(), ModBlocks.PRISMARINE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PRISMARINE_BRICK_SLAB.asItem().getDefaultInstance(), ModBlocks.PRISMARINE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PRISMARINE_BRICK_SLAB.asItem().getDefaultInstance(), ModBlocks.PRISMARINE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_PRISMARINE_SLAB.asItem().getDefaultInstance(), ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_PRISMARINE_SLAB.asItem().getDefaultInstance(), ModBlocks.DARK_PRISMARINE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLACKSTONE_WALL.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BLACKSTONE_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_BLACKSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BLACKSTONE_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.POLISHED_BLACKSTONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE_BRICK_WALL.asItem().getDefaultInstance(), ModBlocks.END_STONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PURPUR_SLAB.asItem().getDefaultInstance(), ModBlocks.PURPUR_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PURPUR_SLAB.asItem().getDefaultInstance(), ModBlocks.PURPUR_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_SLAB.asItem().getDefaultInstance(), ModBlocks.QUARTZ_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_SLAB.asItem().getDefaultInstance(), ModBlocks.QUARTZ_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_QUARTZ_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_QUARTZ_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_QUARTZ_SLAB.asItem().getDefaultInstance(), ModBlocks.SMOOTH_QUARTZ_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.PURPUR_PILLAR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.STONE_BRICK_FENCE.asItem().getDefaultInstance(), Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DEEPSLATE_BRICK_FENCE.asItem().getDefaultInstance(), Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DEEPSLATE_TILE_FENCE.asItem().getDefaultInstance(), Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHER_BRICK_FENCE.asItem().getDefaultInstance(), Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_FENCE.asItem().getDefaultInstance(), Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_BLACKSTONE_BRICK_FENCE.asItem().getDefaultInstance(), Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PURPUR_FENCE.asItem().getDefaultInstance(), Blocks.PURPUR_PILLAR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_FENCE.asItem().getDefaultInstance(), Blocks.DRIPSTONE_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_FENCE.asItem().getDefaultInstance(), Blocks.CALCITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.PACKED_MUD.asItem().getDefaultInstance(), Blocks.BLUE_ICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.PACKED_MUD.asItem().getDefaultInstance(), Blocks.PACKED_ICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.PACKED_MUD.asItem().getDefaultInstance(), Blocks.ICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.PACKED_MUD.asItem().getDefaultInstance(), Blocks.SNOW_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), Blocks.CRYING_OBSIDIAN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), Blocks.OBSIDIAN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MUD_BRICK_FENCE.asItem().getDefaultInstance(), Blocks.RESIN_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHISELED_RESIN_BRICKS.asItem().getDefaultInstance(), Blocks.SCULK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_STONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_TILE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_DEEPSLATE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CALCITE.asItem().getDefaultInstance(), ModBlocks.CALCITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CALCITE.asItem().getDefaultInstance(), ModBlocks.CALCITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CALCITE.asItem().getDefaultInstance(), ModBlocks.CALCITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CALCITE.asItem().getDefaultInstance(), ModBlocks.CALCITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DRIPSTONE_BLOCK.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DRIPSTONE_BLOCK.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DRIPSTONE_BLOCK.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DRIPSTONE_BLOCK.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_MUD.asItem().getDefaultInstance(), ModBlocks.PACKED_MUD_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_MUD.asItem().getDefaultInstance(), ModBlocks.PACKED_MUD_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_MUD.asItem().getDefaultInstance(), ModBlocks.PACKED_MUD_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_MUD.asItem().getDefaultInstance(), ModBlocks.PACKED_MUD_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RESIN_BLOCK.asItem().getDefaultInstance(), ModBlocks.RESIN_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RESIN_BLOCK.asItem().getDefaultInstance(), ModBlocks.RESIN_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RESIN_BLOCK.asItem().getDefaultInstance(), ModBlocks.RESIN_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RESIN_BLOCK.asItem().getDefaultInstance(), ModBlocks.RESIN_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SCULK.asItem().getDefaultInstance(), ModBlocks.SCULK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SCULK.asItem().getDefaultInstance(), ModBlocks.SCULK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SCULK.asItem().getDefaultInstance(), ModBlocks.SCULK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SCULK.asItem().getDefaultInstance(), ModBlocks.SCULK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SNOW_BLOCK.asItem().getDefaultInstance(), ModBlocks.SNOW_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SNOW_BLOCK.asItem().getDefaultInstance(), ModBlocks.SNOW_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SNOW_BLOCK.asItem().getDefaultInstance(), ModBlocks.SNOW_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SNOW_BLOCK.asItem().getDefaultInstance(), ModBlocks.SNOW_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ICE.asItem().getDefaultInstance(), ModBlocks.ICE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ICE.asItem().getDefaultInstance(), ModBlocks.ICE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ICE.asItem().getDefaultInstance(), ModBlocks.ICE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ICE.asItem().getDefaultInstance(), ModBlocks.ICE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_ICE.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_ICE.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_ICE.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PACKED_ICE.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLUE_ICE.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLUE_ICE.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLUE_ICE.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLUE_ICE.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERRACK.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERRACK.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERRACK.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERRACK.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BASALT.asItem().getDefaultInstance(), ModBlocks.BASALT_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BASALT.asItem().getDefaultInstance(), ModBlocks.BASALT_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BASALT.asItem().getDefaultInstance(), ModBlocks.BASALT_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BASALT.asItem().getDefaultInstance(), ModBlocks.BASALT_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_BASALT.asItem().getDefaultInstance(), ModBlocks.SMOOTH_BASALT_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_BASALT.asItem().getDefaultInstance(), ModBlocks.SMOOTH_BASALT_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_BASALT.asItem().getDefaultInstance(), ModBlocks.SMOOTH_BASALT_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_BASALT.asItem().getDefaultInstance(), ModBlocks.SMOOTH_BASALT_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BASALT.asItem().getDefaultInstance(), ModBlocks.POLISHED_BASALT_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BASALT.asItem().getDefaultInstance(), ModBlocks.POLISHED_BASALT_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BASALT.asItem().getDefaultInstance(), ModBlocks.POLISHED_BASALT_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.POLISHED_BASALT.asItem().getDefaultInstance(), ModBlocks.POLISHED_BASALT_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_NETHER_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_NETHER_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_NETHER_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_NETHER_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_NETHER_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), ModBlocks.GILDED_BLACKSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), ModBlocks.GILDED_BLACKSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), ModBlocks.GILDED_BLACKSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GILDED_BLACKSTONE.asItem().getDefaultInstance(), ModBlocks.GILDED_BLACKSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.END_STONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.END_STONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.END_STONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.END_STONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRYING_OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRYING_OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRYING_OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRYING_OBSIDIAN.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.COAL_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.COAL_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.COAL_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.COAL_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LAPIS_BLOCK.asItem().getDefaultInstance(), ModBlocks.LAPIS_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LAPIS_BLOCK.asItem().getDefaultInstance(), ModBlocks.LAPIS_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LAPIS_BLOCK.asItem().getDefaultInstance(), ModBlocks.LAPIS_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LAPIS_BLOCK.asItem().getDefaultInstance(), ModBlocks.LAPIS_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_BRICKS.asItem().getDefaultInstance(), ModBlocks.QUARTZ_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_BRICKS.asItem().getDefaultInstance(), ModBlocks.QUARTZ_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_BRICKS.asItem().getDefaultInstance(), ModBlocks.QUARTZ_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.QUARTZ_BRICKS.asItem().getDefaultInstance(), ModBlocks.QUARTZ_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.SMOOTH_STONE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_STONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_TILES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_TILES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.STONE_TILES.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRANITE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DIORITE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_ANDESITE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COBBLED_DEEPSLATE_FENCE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_DEEPSLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_FENCE.asItem().getDefaultInstance(), ModBlocks.CALCITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_CALCITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DRIPSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.BIG_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_SCULK_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_FENCE.asItem().getDefaultInstance(), ModBlocks.SCULK_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SNOW_FENCE.asItem().getDefaultInstance(), ModBlocks.SNOW_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ICE_FENCE.asItem().getDefaultInstance(), ModBlocks.ICE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PACKED_ICE_FENCE.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLUE_ICE_FENCE.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_PRISMARINE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PRISMARINE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_PRISMARINE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_FENCE.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_BASALT_FENCE.asItem().getDefaultInstance(), ModBlocks.BASALT_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OBSIDIAN_FENCE.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRYING_OBSIDIAN_FENCE.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_FENCE.asItem().getDefaultInstance(), ModBlocks.COAL_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_FENCE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_LAPIS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_FENCE.asItem().getDefaultInstance(), ModBlocks.LAPIS_PILLAR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_FENCE.asItem().getDefaultInstance(), ModBlocks.LAPIS_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_LAPIS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.POLISHED_STONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_STONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_STONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_STONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_STONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_STONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_STONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_STONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STONE_TILES.asItem().getDefaultInstance(), ModBlocks.STONE_TILE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STONE_TILES.asItem().getDefaultInstance(), ModBlocks.STONE_TILE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STONE_TILES.asItem().getDefaultInstance(), ModBlocks.STONE_TILE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.STONE_TILES.asItem().getDefaultInstance(), ModBlocks.STONE_TILE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_TILE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_TILE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_TILE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MOSSY_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.MOSSY_STONE_TILE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRACKED_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_TILE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRACKED_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_TILE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRACKED_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_TILE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRACKED_STONE_TILES.asItem().getDefaultInstance(), ModBlocks.CRACKED_STONE_TILE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRANITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRANITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRANITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRANITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRANITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DIORITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DIORITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DIORITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DIORITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_DIORITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_ANDESITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_ANDESITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_ANDESITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_ANDESITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_DEEPSLATE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_DEEPSLATE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_DEEPSLATE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_DEEPSLATE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_DEEPSLATE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_CALCITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_CALCITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_CALCITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_CALCITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_CALCITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_CALCITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_CALCITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_CALCITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CALCITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CALCITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CALCITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CALCITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.CALCITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DRIPSTONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DRIPSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DRIPSTONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DRIPSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DRIPSTONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DRIPSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_DRIPSTONE.asItem().getDefaultInstance(), ModBlocks.POLISHED_DRIPSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DRIPSTONE_BRICKS.asItem().getDefaultInstance(), ModBlocks.DRIPSTONE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIG_BRICKS.asItem().getDefaultInstance(), ModBlocks.BIG_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIG_BRICKS.asItem().getDefaultInstance(), ModBlocks.BIG_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIG_BRICKS.asItem().getDefaultInstance(), ModBlocks.BIG_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIG_BRICKS.asItem().getDefaultInstance(), ModBlocks.BIG_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_BRICKS.asItem().getDefaultInstance(), ModBlocks.SCULK_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_BRICKS.asItem().getDefaultInstance(), ModBlocks.SCULK_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_BRICKS.asItem().getDefaultInstance(), ModBlocks.SCULK_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SCULK_BRICKS.asItem().getDefaultInstance(), ModBlocks.SCULK_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SNOW_BRICKS.asItem().getDefaultInstance(), ModBlocks.SNOW_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SNOW_BRICKS.asItem().getDefaultInstance(), ModBlocks.SNOW_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SNOW_BRICKS.asItem().getDefaultInstance(), ModBlocks.SNOW_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SNOW_BRICKS.asItem().getDefaultInstance(), ModBlocks.SNOW_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ICE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ICE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ICE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ICE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PACKED_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PACKED_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PACKED_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PACKED_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PACKED_ICE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLUE_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLUE_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLUE_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLUE_ICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.BLUE_ICE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICKS.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICKS.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICKS.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICKS.asItem().getDefaultInstance(), ModBlocks.NETHERRACK_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICKS.asItem().getDefaultInstance(), ModBlocks.BASALT_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICKS.asItem().getDefaultInstance(), ModBlocks.BASALT_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICKS.asItem().getDefaultInstance(), ModBlocks.BASALT_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICKS.asItem().getDefaultInstance(), ModBlocks.BASALT_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.OBSIDIAN_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRYING_OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRYING_OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRYING_OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRYING_OBSIDIAN_BRICKS.asItem().getDefaultInstance(), ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.COAL_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.COAL_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.COAL_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_BRICKS.asItem().getDefaultInstance(), ModBlocks.LAPIS_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_BRICKS.asItem().getDefaultInstance(), ModBlocks.LAPIS_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_BRICKS.asItem().getDefaultInstance(), ModBlocks.LAPIS_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.LAPIS_BRICKS.asItem().getDefaultInstance(), ModBlocks.LAPIS_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_LAPIS.asItem().getDefaultInstance(), ModBlocks.SMOOTH_LAPIS_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_LAPIS.asItem().getDefaultInstance(), ModBlocks.SMOOTH_LAPIS_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_LAPIS.asItem().getDefaultInstance(), ModBlocks.SMOOTH_LAPIS_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_LAPIS.asItem().getDefaultInstance(), ModBlocks.SMOOTH_LAPIS_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.OAK_PLANKS.asItem().getDefaultInstance(), ModBlocks.OAK_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SPRUCE_PLANKS.asItem().getDefaultInstance(), ModBlocks.SPRUCE_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BIRCH_PLANKS.asItem().getDefaultInstance(), ModBlocks.BIRCH_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.JUNGLE_PLANKS.asItem().getDefaultInstance(), ModBlocks.JUNGLE_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ACACIA_PLANKS.asItem().getDefaultInstance(), ModBlocks.ACACIA_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_OAK_PLANKS.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MANGROVE_PLANKS.asItem().getDefaultInstance(), ModBlocks.MANGROVE_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHERRY_PLANKS.asItem().getDefaultInstance(), ModBlocks.CHERRY_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PALE_OAK_PLANKS.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRIMSON_PLANKS.asItem().getDefaultInstance(), ModBlocks.CRIMSON_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_PLANKS.asItem().getDefaultInstance(), ModBlocks.WARPED_MOSAIC.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OAK_STAIRS.asItem().getDefaultInstance(), ModBlocks.OAK_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SPRUCE_STAIRS.asItem().getDefaultInstance(), ModBlocks.SPRUCE_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BIRCH_STAIRS.asItem().getDefaultInstance(), ModBlocks.BIRCH_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.JUNGLE_STAIRS.asItem().getDefaultInstance(), ModBlocks.JUNGLE_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ACACIA_STAIRS.asItem().getDefaultInstance(), ModBlocks.ACACIA_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_OAK_STAIRS.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MANGROVE_STAIRS.asItem().getDefaultInstance(), ModBlocks.MANGROVE_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHERRY_STAIRS.asItem().getDefaultInstance(), ModBlocks.CHERRY_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PALE_OAK_STAIRS.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRIMSON_STAIRS.asItem().getDefaultInstance(), ModBlocks.CRIMSON_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_STAIRS.asItem().getDefaultInstance(), ModBlocks.WARPED_MOSAIC_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OAK_SLAB.asItem().getDefaultInstance(), ModBlocks.OAK_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SPRUCE_SLAB.asItem().getDefaultInstance(), ModBlocks.SPRUCE_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BIRCH_SLAB.asItem().getDefaultInstance(), ModBlocks.BIRCH_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.JUNGLE_SLAB.asItem().getDefaultInstance(), ModBlocks.JUNGLE_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.ACACIA_SLAB.asItem().getDefaultInstance(), ModBlocks.ACACIA_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DARK_OAK_SLAB.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.MANGROVE_SLAB.asItem().getDefaultInstance(), ModBlocks.MANGROVE_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHERRY_SLAB.asItem().getDefaultInstance(), ModBlocks.CHERRY_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PALE_OAK_SLAB.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRIMSON_SLAB.asItem().getDefaultInstance(), ModBlocks.CRIMSON_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_SLAB.asItem().getDefaultInstance(), ModBlocks.WARPED_MOSAIC_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Blocks.IRON_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.IRON_BARS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.IRON_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.IRON_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.IRON_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_CHAIN, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_BULB, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_TRAPDOOR, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_DOOR, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_BARS, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON_SLAB, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON_STAIRS, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_GRATE, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_BLOCK, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_CHAIN, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_BULB, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_TRAPDOOR, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_DOOR, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_BARS, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON_SLAB, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON_STAIRS, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.CUT_IRON, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_GRATE, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_BLOCK, ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance());

            registerWeatheringCopperItems(event, gameplayWeatheringOrder, ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE, Blocks.COPPER_TRAPDOOR.weathering().oxidized().asItem().getDefaultInstance());
            registerWaxedCopperItems(event, gameplayWeatheringOrder, ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE, Blocks.COPPER_TRAPDOOR.waxed().oxidized().asItem().getDefaultInstance());

            event.insertAfter(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.GOLD_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.GOLD_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_GOLD_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_GOLD_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_GOLD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.GOLD_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.NETHERITE_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.NETHERITE_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.NETHERITE_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.NETHERITE_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_NETHERITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_NETHERITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_NETHERITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHERITE_BLOCK.asItem().getDefaultInstance(), ModBlocks.NETHERITE_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.DIAMOND_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_DIAMOND_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DIAMOND_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_DIAMOND_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DIAMOND_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_DIAMOND.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.EMERALD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_EMERALD_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.EMERALD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_EMERALD_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.EMERALD_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_EMERALD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.AMETHYST_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_AMETHYST_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.AMETHYST_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_AMETHYST_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.AMETHYST_BLOCK.asItem().getDefaultInstance(), ModBlocks.CUT_AMETHYST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COAL_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.CUT_SOUL_SANDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_SOUL_SANDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_RED_SANDSTONE_FENCE.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.DARK_ELDER_PRISMARINE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.CHISELED_ELDER_PRISMARINE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_PRISMARINE_FENCE.asItem().getDefaultInstance(), ModBlocks.ELDER_SEA_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_RHYOLITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.GABBRO_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GABBRO.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TUFF_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.GABBRO.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.PUMICE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_PUMICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BASALT_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.PUMICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.END_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.END_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRAPHITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.END_STONE_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.SILICITE_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.POLISHED_SILICITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.NETHERRACK_BRICK_FENCE.asItem().getDefaultInstance(), ModBlocks.SILICITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.CHARCOAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BLOCK.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHARCOAL_BRICKS.asItem().getDefaultInstance(), ModBlocks.CHARCOAL_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SOUL_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.CUT_SOUL_SANDSTONE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.CUT_SOUL_SANDSTONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.CUT_SOUL_SANDSTONE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CUT_SOUL_SANDSTONE.asItem().getDefaultInstance(), ModBlocks.CUT_SOUL_SANDSTONE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ELDER_PRISMARINE_BRICKS.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.DARK_ELDER_PRISMARINE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.DARK_ELDER_PRISMARINE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.DARK_ELDER_PRISMARINE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_ELDER_PRISMARINE.asItem().getDefaultInstance(), ModBlocks.DARK_ELDER_PRISMARINE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO.asItem().getDefaultInstance(), ModBlocks.GABBRO_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO.asItem().getDefaultInstance(), ModBlocks.GABBRO_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO.asItem().getDefaultInstance(), ModBlocks.GABBRO_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO.asItem().getDefaultInstance(), ModBlocks.GABBRO_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GABBRO.asItem().getDefaultInstance(), ModBlocks.POLISHED_GABBRO_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GABBRO.asItem().getDefaultInstance(), ModBlocks.POLISHED_GABBRO_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GABBRO.asItem().getDefaultInstance(), ModBlocks.POLISHED_GABBRO_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GABBRO.asItem().getDefaultInstance(), ModBlocks.POLISHED_GABBRO_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO_BRICKS.asItem().getDefaultInstance(), ModBlocks.GABBRO_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO_BRICKS.asItem().getDefaultInstance(), ModBlocks.GABBRO_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO_BRICKS.asItem().getDefaultInstance(), ModBlocks.GABBRO_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GABBRO_BRICKS.asItem().getDefaultInstance(), ModBlocks.GABBRO_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_RHYOLITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_RHYOLITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_RHYOLITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_RHYOLITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_RHYOLITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_RHYOLITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_RHYOLITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_RHYOLITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.RHYOLITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.RHYOLITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE.asItem().getDefaultInstance(), ModBlocks.PUMICE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE.asItem().getDefaultInstance(), ModBlocks.PUMICE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE.asItem().getDefaultInstance(), ModBlocks.PUMICE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE.asItem().getDefaultInstance(), ModBlocks.PUMICE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_PUMICE.asItem().getDefaultInstance(), ModBlocks.POLISHED_PUMICE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_PUMICE.asItem().getDefaultInstance(), ModBlocks.POLISHED_PUMICE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_PUMICE.asItem().getDefaultInstance(), ModBlocks.POLISHED_PUMICE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_PUMICE.asItem().getDefaultInstance(), ModBlocks.POLISHED_PUMICE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PUMICE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PUMICE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PUMICE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PUMICE_BRICKS.asItem().getDefaultInstance(), ModBlocks.PUMICE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRAPHITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRAPHITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRAPHITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRAPHITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRAPHITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRAPHITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_GRAPHITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_GRAPHITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GRAPHITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.GRAPHITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE.asItem().getDefaultInstance(), ModBlocks.SILICITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE.asItem().getDefaultInstance(), ModBlocks.SILICITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE.asItem().getDefaultInstance(), ModBlocks.SILICITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE.asItem().getDefaultInstance(), ModBlocks.SILICITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_SILICITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_SILICITE_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_SILICITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_SILICITE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_SILICITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_SILICITE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.POLISHED_SILICITE.asItem().getDefaultInstance(), ModBlocks.POLISHED_SILICITE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.SILICITE_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.SILICITE_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.SILICITE_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SILICITE_BRICKS.asItem().getDefaultInstance(), ModBlocks.SILICITE_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BLOCK);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_GRATE);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC_STAIRS);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC_SLAB);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_DOOR);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_TRAPDOOR);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BULB);
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_CHAIN);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BLOCK);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_GRATE);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC_STAIRS);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.CUT_ZINC_SLAB);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_DOOR);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_TRAPDOOR);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BULB);
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_CHAIN);

            event.accept(ModBlocks.SILVER_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.SILVER_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SILVER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SILVER_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SILVER_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.SILVER_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.SILVER_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.SILVER_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.SILVER_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.TIN_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TIN_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TIN_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TIN_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TIN_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TIN_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TIN_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TIN_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.TUNGSTEN_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TUNGSTEN_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TUNGSTEN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TUNGSTEN_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_TUNGSTEN_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TUNGSTEN_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TUNGSTEN_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TUNGSTEN_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.TUNGSTEN_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.PLATINUM_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PLATINUM_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_PLATINUM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_PLATINUM_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_PLATINUM_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PLATINUM_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PLATINUM_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PLATINUM_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PLATINUM_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.LEAD_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.LEAD_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_LEAD.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_LEAD_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_LEAD_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.LEAD_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.LEAD_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.LEAD_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.LEAD_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.BISMUTH_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BISMUTH_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BISMUTH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BISMUTH_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BISMUTH_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BISMUTH_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BISMUTH_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.VEHEMENT_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BISMUTH_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BISMUTH_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.URANIUM_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.URANIUM_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_URANIUM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_URANIUM_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_URANIUM_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.URANIUM_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.URANIUM_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.URANIUM_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.URANIUM_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.BRONZE_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRONZE_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRONZE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRONZE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRONZE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRONZE_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRONZE_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRONZE_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRONZE_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.BRASS_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRASS_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRASS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRASS_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_BRASS_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRASS_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRASS_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRASS_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.BRASS_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.STEEL_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.STEEL_GRATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_STEEL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_STEEL_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_STEEL_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.STEEL_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.STEEL_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.STEEL_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.STEEL_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.MONOCRYSTAL_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_MONOCRYSTAL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_MONOCRYSTAL_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_MONOCRYSTAL_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.RUBY_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_RUBY.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_RUBY_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_RUBY_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModBlocks.SAPPHIRE_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SAPPHIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SAPPHIRE_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModBlocks.CUT_SAPPHIRE_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.insertAfter(Blocks.TERRACOTTA.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TERRACOTTA.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TERRACOTTA.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TERRACOTTA.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_FENCE, Blocks.DYED_TERRACOTTA.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_WALL, Blocks.DYED_TERRACOTTA.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_SLAB, Blocks.DYED_TERRACOTTA.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_STAIRS, Blocks.DYED_TERRACOTTA.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_FENCE, Blocks.CONCRETE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_WALL, Blocks.CONCRETE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_SLAB, Blocks.CONCRETE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_STAIRS, Blocks.CONCRETE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());

            event.insertAfter(ModBlocks.TERRACOTTA_FENCE.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_BRICKS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_BRICKS, ModBlocks.DYED_TERRACOTTA_FENCE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_BRICKS, ModBlocks.CONCRETE_FENCE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());

            event.insertAfter(ModBlocks.TERRACOTTA_BRICKS.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_BRICK_FENCE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TERRACOTTA_BRICKS.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_BRICK_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TERRACOTTA_BRICKS.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_BRICK_SLAB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.TERRACOTTA_BRICKS.asItem().getDefaultInstance(), ModBlocks.TERRACOTTA_BRICK_STAIRS.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_BRICK_FENCE, ModBlocks.DYED_TERRACOTTA_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_BRICK_WALL, ModBlocks.DYED_TERRACOTTA_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_BRICK_SLAB, ModBlocks.DYED_TERRACOTTA_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS, ModBlocks.DYED_TERRACOTTA_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_BRICK_FENCE, ModBlocks.CONCRETE_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_BRICK_WALL, ModBlocks.CONCRETE_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_BRICK_SLAB, ModBlocks.CONCRETE_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.CONCRETE_BRICK_STAIRS, ModBlocks.CONCRETE_BRICKS.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance());

            event.insertAfter(Blocks.GLASS_PANE.asItem().getDefaultInstance(), ModBlocks.TINTED_GLASS_PANE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.STAINED_GLASS_PANE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance(), ModBlocks.TINTED_GLASS_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.STAINED_GLASS_PANE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance(), ModBlocks.TINTED_GLASS_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.STAINED_GLASS_PANE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance(), ModBlocks.GLASS_TRAPDOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.STAINED_GLASS_PANE.pick(gameplayColorOrder.getLast()).asItem().getDefaultInstance(), ModBlocks.GLASS_DOOR.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerColoredItems(event, gameplayColorOrder, ModBlocks.STAINED_GLASS_DOOR, ModBlocks.TINTED_GLASS_DOOR.asItem().getDefaultInstance());
            registerColoredItems(event, gameplayColorOrder, ModBlocks.STAINED_GLASS_TRAPDOOR, ModBlocks.TINTED_GLASS_TRAPDOOR.asItem().getDefaultInstance());

        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.remove(Blocks.LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Blocks.IRON_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_FIRE_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_SOUL_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_CHAIN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedIronItems(event, gameplayRustOrder, ModBlocks.IRON_BULB, Blocks.REDSTONE_LAMP.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_FIRE_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_SOUL_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_LANTERN, Blocks.REDSTONE_TORCH.asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_CHAIN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerRustingIronItems(event, gameplayRustOrder, ModBlocks.IRON_BULB, Blocks.REDSTONE_LAMP.asItem().getDefaultInstance());

            event.insertAfter(Blocks.SOUL_TORCH.asItem().getDefaultInstance(), ModBlocks.IRON_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.URANIUM_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.BISMUTH_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.LEAD_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.GOLD_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.PLATINUM_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.TIN_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.SILVER_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_TORCH.asItem().getDefaultInstance(), ModBlocks.ZINC_TORCH.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerWaxedCopperItems(event, gameplayWeatheringOrder, ModBlocks.COPPER_FIRE_LANTERN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWeatheringCopperItems(event, gameplayWeatheringOrder, ModBlocks.COPPER_FIRE_LANTERN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedCopperItems(event, gameplayWeatheringOrder, ModBlocks.COPPER_SOUL_LANTERN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWeatheringCopperItems(event, gameplayWeatheringOrder, ModBlocks.COPPER_SOUL_LANTERN, Blocks.COPPER_LANTERN.waxed().oxidized().asItem().getDefaultInstance());

            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.GOLD_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.GOLD_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.PLATINUM_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.PLATINUM_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.PLATINUM_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.PLATINUM_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.PLATINUM_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TIN_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TIN_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TIN_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TIN_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.TIN_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.SILVER_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.SILVER_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.SILVER_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.SILVER_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance(), ModBlocks.SILVER_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_FIRE_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_FIRE_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_SOUL_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_SOUL_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_LANTERN, ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_CHAIN, Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance());
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_CHAIN, Blocks.COPPER_CHAIN.waxed().oxidized().asItem().getDefaultInstance());
            registerWaxedZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BULB, Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance());
            registerCorrodingZincItems(event, gameplayCorrosionOrder, ModBlocks.ZINC_BULB, Blocks.COPPER_BULB.waxed().oxidized().asItem().getDefaultInstance());

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.STEEL_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.STEEL_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.STEEL_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.STEEL_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BRASS_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BRASS_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.BRASS_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.BRASS_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BRONZE_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BRONZE_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.BRONZE_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.BRONZE_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.NETHERITE_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.NETHERITE_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.NETHERITE_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.NETHERITE_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.URANIUM_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.URANIUM_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.URANIUM_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.URANIUM_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.URANIUM_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BISMUTH_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BISMUTH_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.BISMUTH_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.BISMUTH_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.BISMUTH_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.LEAD_FIRE_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.LEAD_SOUL_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_FIRE_LANTERN.asItem().getDefaultInstance(), ModBlocks.LEAD_LANTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_CHAIN.asItem().getDefaultInstance(), ModBlocks.LEAD_CHAIN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.GOLD_BULB.asItem().getDefaultInstance(), ModBlocks.LEAD_BULB.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


            event.remove(Items.CRAFTING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.MAGMA_BLOCK.getDefaultInstance(), Blocks.CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.BIRCH_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.ACACIA_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.CHERRY_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_CRAFTING_TABLE.asItem().getDefaultInstance(), ModBlocks.WARPED_CRAFTING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.CARTOGRAPHY_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.STONECUTTER.getDefaultInstance(), ModBlocks.OAK_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.BIRCH_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.ACACIA_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), Blocks.CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.CHERRY_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.WARPED_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.FLETCHING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_CARTOGRAPHY_TABLE.asItem().getDefaultInstance(), ModBlocks.OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_FLETCHING_TABLE.asItem().getDefaultInstance(), Blocks.FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.ACACIA_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.CHERRY_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.WARPED_FLETCHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.SMITHING_TABLE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_FLETCHING_TABLE.asItem().getDefaultInstance(), ModBlocks.OAK_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.BIRCH_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.ACACIA_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_SMITHING_TABLE.asItem().getDefaultInstance(), Blocks.SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.CHERRY_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.WARPED_SMITHING_TABLE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.GRINDSTONE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.OAK_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.BIRCH_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.ACACIA_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_GRINDSTONE.asItem().getDefaultInstance(), Blocks.GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.CHERRY_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_GRINDSTONE.asItem().getDefaultInstance(), ModBlocks.WARPED_GRINDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.LOOM.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_GRINDSTONE.asItem().getDefaultInstance(), Blocks.LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LOOM.asItem().getDefaultInstance(), ModBlocks.SPRUCE_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_LOOM.asItem().getDefaultInstance(), ModBlocks.BIRCH_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_LOOM.asItem().getDefaultInstance(), ModBlocks.JUNGLE_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_LOOM.asItem().getDefaultInstance(), ModBlocks.ACACIA_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_LOOM.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_LOOM.asItem().getDefaultInstance(), ModBlocks.MANGROVE_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_LOOM.asItem().getDefaultInstance(), ModBlocks.CHERRY_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_LOOM.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_LOOM.asItem().getDefaultInstance(), ModBlocks.BAMBOO_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_LOOM.asItem().getDefaultInstance(), ModBlocks.CRIMSON_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_LOOM.asItem().getDefaultInstance(), ModBlocks.WARPED_LOOM.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.FURNACE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_LOOM.asItem().getDefaultInstance(), Blocks.FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.FURNACE.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_FURNACE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.SMOKER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DEEPSLATE_FURNACE.asItem().getDefaultInstance(), Blocks.SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOKER.asItem().getDefaultInstance(), ModBlocks.SPRUCE_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BIRCH_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.JUNGLE_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.ACACIA_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.MANGROVE_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CHERRY_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BAMBOO_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CRIMSON_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.WARPED_STONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_STONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.SPRUCE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BIRCH_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.JUNGLE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.ACACIA_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.MANGROVE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CHERRY_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BAMBOO_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CRIMSON_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.WARPED_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_BLACKSTONE_SMOKER.asItem().getDefaultInstance(), ModBlocks.OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.SPRUCE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BIRCH_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.JUNGLE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.ACACIA_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.MANGROVE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CHERRY_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.BAMBOO_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.CRIMSON_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), ModBlocks.WARPED_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.BLAST_FURNACE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_DEEPSLATE_SMOKER.asItem().getDefaultInstance(), Blocks.BLAST_FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BLAST_FURNACE.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_BLAST_FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_BLAST_FURNACE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_BLAST_FURNACE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.CAMPFIRE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Items.SOUL_CAMPFIRE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DEEPSLATE_BLAST_FURNACE.asItem().getDefaultInstance(), Blocks.CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.BIRCH_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.ACACIA_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.CHERRY_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.WARPED_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.WARPED_CAMPFIRE.asItem().getDefaultInstance(), Blocks.SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.BIRCH_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.ACACIA_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.CHERRY_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_SOUL_CAMPFIRE.asItem().getDefaultInstance(), ModBlocks.WARPED_SOUL_CAMPFIRE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.BEEHIVE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.BEE_NEST.getDefaultInstance(), Blocks.BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BEEHIVE.asItem().getDefaultInstance(), ModBlocks.SPRUCE_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.BIRCH_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.JUNGLE_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.ACACIA_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.MANGROVE_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.CHERRY_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.BAMBOO_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.CRIMSON_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_BEEHIVE.asItem().getDefaultInstance(), ModBlocks.WARPED_BEEHIVE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.CHISELED_BOOKSHELF.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.remove(Items.BOOKSHELF.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Items.OAK_SHELF.getDefaultInstance(), ModBlocks.WARPED_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.WARPED_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.CRIMSON_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.BAMBOO_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.PALE_OAK_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.CHERRY_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.CHERRY_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.MANGROVE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.DARK_OAK_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.ACACIA_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.ACACIA_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.JUNGLE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.BIRCH_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.BIRCH_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.SPRUCE_CHISELED_BOOKSHELF.asItem().getDefaultInstance(), Blocks.CHISELED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(Blocks.CHISELED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.WARPED_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.WARPED_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.CRIMSON_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.CRIMSON_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.BAMBOO_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.BAMBOO_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.PALE_OAK_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.CHERRY_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.CHERRY_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.MANGROVE_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.MANGROVE_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.DARK_OAK_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.ACACIA_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.ACACIA_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.JUNGLE_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.JUNGLE_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.BIRCH_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.BIRCH_BOOKSHELF.asItem().getDefaultInstance(), ModBlocks.SPRUCE_BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertBefore(ModBlocks.SPRUCE_BOOKSHELF.asItem().getDefaultInstance(), Blocks.BOOKSHELF.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.LECTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.WARPED_SHELF.getDefaultInstance(), Blocks.LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.LECTERN.asItem().getDefaultInstance(), ModBlocks.SPRUCE_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_LECTERN.asItem().getDefaultInstance(), ModBlocks.BIRCH_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_LECTERN.asItem().getDefaultInstance(), ModBlocks.JUNGLE_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_LECTERN.asItem().getDefaultInstance(), ModBlocks.ACACIA_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_LECTERN.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_LECTERN.asItem().getDefaultInstance(), ModBlocks.MANGROVE_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_LECTERN.asItem().getDefaultInstance(), ModBlocks.CHERRY_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_LECTERN.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_LECTERN.asItem().getDefaultInstance(), ModBlocks.BAMBOO_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_LECTERN.asItem().getDefaultInstance(), ModBlocks.CRIMSON_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_LECTERN.asItem().getDefaultInstance(), ModBlocks.WARPED_LECTERN.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.BREWING_STAND.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.END_CRYSTAL.getDefaultInstance(), Blocks.BREWING_STAND.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BREWING_STAND.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_BREWING_STAND.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_BREWING_STAND.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_BREWING_STAND.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.BARREL.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_CHEST.waxed().oxidized().getDefaultInstance(), ModBlocks.OAK_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.OAK_BARREL.asItem().getDefaultInstance(), Blocks.BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.BARREL.asItem().getDefaultInstance(), ModBlocks.BIRCH_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_BARREL.asItem().getDefaultInstance(), ModBlocks.JUNGLE_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_BARREL.asItem().getDefaultInstance(), ModBlocks.ACACIA_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_BARREL.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_BARREL.asItem().getDefaultInstance(), ModBlocks.MANGROVE_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_BARREL.asItem().getDefaultInstance(), ModBlocks.CHERRY_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_BARREL.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_BARREL.asItem().getDefaultInstance(), ModBlocks.BAMBOO_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_BARREL.asItem().getDefaultInstance(), ModBlocks.CRIMSON_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_BARREL.asItem().getDefaultInstance(), ModBlocks.WARPED_BARREL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.CHEST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.WARPED_HANGING_SIGN.getDefaultInstance(), Blocks.CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CHEST.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_CHEST.asItem().getDefaultInstance(), ModBlocks.BIRCH_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_CHEST.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_CHEST.asItem().getDefaultInstance(), ModBlocks.ACACIA_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_CHEST.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_CHEST.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_CHEST.asItem().getDefaultInstance(), ModBlocks.CHERRY_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_CHEST.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_CHEST.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_CHEST.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_CHEST.asItem().getDefaultInstance(), ModBlocks.WARPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_CHEST.waxed().oxidized().getDefaultInstance(), Blocks.TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.SPRUCE_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.BIRCH_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.JUNGLE_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.ACACIA_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.MANGROVE_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.CHERRY_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.BAMBOO_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.CRIMSON_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_TRAPPED_CHEST.asItem().getDefaultInstance(), ModBlocks.WARPED_TRAPPED_CHEST.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.insertAfter(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE.asItem().getDefaultInstance(), ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TNT.asItem().getDefaultInstance(), ModBlocks.NUKE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.DISPENSER.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_DISPENSER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_DISPENSER.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_DISPENSER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DROPPER.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_DROPPER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_DROPPER.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_DROPPER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.OBSERVER.asItem().getDefaultInstance(), ModBlocks.BLACKSTONE_OBSERVER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BLACKSTONE_OBSERVER.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_OBSERVER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.CRAFTER.asItem().getDefaultInstance(), ModBlocks.SPRUCE_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.SPRUCE_CRAFTER.asItem().getDefaultInstance(), ModBlocks.BIRCH_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BIRCH_CRAFTER.asItem().getDefaultInstance(), ModBlocks.JUNGLE_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.JUNGLE_CRAFTER.asItem().getDefaultInstance(), ModBlocks.ACACIA_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.ACACIA_CRAFTER.asItem().getDefaultInstance(), ModBlocks.DARK_OAK_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.DARK_OAK_CRAFTER.asItem().getDefaultInstance(), ModBlocks.MANGROVE_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.MANGROVE_CRAFTER.asItem().getDefaultInstance(), ModBlocks.CHERRY_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CHERRY_CRAFTER.asItem().getDefaultInstance(), ModBlocks.PALE_OAK_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.PALE_OAK_CRAFTER.asItem().getDefaultInstance(), ModBlocks.BAMBOO_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.BAMBOO_CRAFTER.asItem().getDefaultInstance(), ModBlocks.CRIMSON_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModBlocks.CRIMSON_CRAFTER.asItem().getDefaultInstance(), ModBlocks.WARPED_CRAFTER.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.PRISMARINE_CRYSTALS.getDefaultInstance(), ModItems.ELDER_PRISMARINE_SHARD.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ELDER_PRISMARINE_SHARD.getDefaultInstance(), ModItems.ELDER_PRISMARINE_CRYSTALS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE.getDefaultInstance(), ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.GUSTER_BANNER_PATTERN.getDefaultInstance(), ModItems.CLUB_BANNER_PATTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GUSTER_BANNER_PATTERN.getDefaultInstance(), ModItems.SPADE_BANNER_PATTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GUSTER_BANNER_PATTERN.getDefaultInstance(), ModItems.DIAMOND_BANNER_PATTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GUSTER_BANNER_PATTERN.getDefaultInstance(), ModItems.HEART_BANNER_PATTERN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            
            event.insertAfter(Items.SNOWBALL.getDefaultInstance(), ModItems.ICE_SHARD.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GUNPOWDER.getDefaultInstance(), ModItems.SILICON_DUST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DIAMOND.getDefaultInstance(), ModItems.MONOCRYSTAL.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.EMERALD.getDefaultInstance(), ModItems.RUBY.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.DIAMOND.getDefaultInstance(), ModItems.SAPPHIRE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GUNPOWDER.getDefaultInstance(), ModItems.CARBON_DUST.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.STICK.getDefaultInstance(), ModItems.STONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(ModItems.STONE_BATON.getDefaultInstance(), ModItems.GRANITE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.GRANITE_BATON.getDefaultInstance(), ModItems.DIORITE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.DIORITE_BATON.getDefaultInstance(), ModItems.ANDESITE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ANDESITE_BATON.getDefaultInstance(), ModItems.DEEPSLATE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.DEEPSLATE_BATON.getDefaultInstance(), ModItems.TUFF_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TUFF_BATON.getDefaultInstance(), ModItems.GABBRO_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.GABBRO_BATON.getDefaultInstance(), ModItems.RHYOLITE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RHYOLITE_BATON.getDefaultInstance(), ModItems.CALCITE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CALCITE_BATON.getDefaultInstance(), ModItems.PACKED_MUD_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PACKED_MUD_BATON.getDefaultInstance(), ModItems.SANDSTONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SANDSTONE_BATON.getDefaultInstance(), ModItems.RED_SANDSTONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RED_SANDSTONE_BATON.getDefaultInstance(), ModItems.SOUL_SANDSTONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SOUL_SANDSTONE_BATON.getDefaultInstance(), ModItems.CINNABAR_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CINNABAR_BATON.getDefaultInstance(), ModItems.NETHERRACK_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.NETHERRACK_BATON.getDefaultInstance(), ModItems.BASALT_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BASALT_BATON.getDefaultInstance(), ModItems.PUMICE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PUMICE_BATON.getDefaultInstance(), ModItems.BLACKSTONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BLACKSTONE_BATON.getDefaultInstance(), ModItems.END_STONE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.END_STONE_BATON.getDefaultInstance(), ModItems.OBSIDIAN_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.OBSIDIAN_BATON.getDefaultInstance(), ModItems.TERRACOTTA_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TERRACOTTA_BATON.getDefaultInstance(), ModItems.CONCRETE_BATON.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RESIN_BRICK.getDefaultInstance(), ModItems.SCULK_BRICK.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.RAW_COPPER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RAW_IRON.getDefaultInstance(), Items.RAW_COPPER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RAW_COPPER.getDefaultInstance(), ModItems.RAW_ZINC.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_ZINC.getDefaultInstance(), ModItems.RAW_SILVER.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_SILVER.getDefaultInstance(), ModItems.RAW_TIN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_TIN.getDefaultInstance(), ModItems.RAW_TUNGSTEN.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_TUNGSTEN.getDefaultInstance(), ModItems.RAW_PLATINUM.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.RAW_GOLD.getDefaultInstance(), ModItems.RAW_LEAD.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_LEAD.getDefaultInstance(), ModItems.RAW_BISMUTH.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.RAW_BISMUTH.getDefaultInstance(), ModItems.RAW_URANIUM.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.COPPER_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.IRON_INGOT.getDefaultInstance(), Items.COPPER_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_INGOT.getDefaultInstance(), ModItems.ZINC_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ZINC_INGOT.getDefaultInstance(), ModItems.SILVER_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SILVER_INGOT.getDefaultInstance(), ModItems.TIN_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TIN_INGOT.getDefaultInstance(), ModItems.TUNGSTEN_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TUNGSTEN_INGOT.getDefaultInstance(), ModItems.PLATINUM_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GOLD_INGOT.getDefaultInstance(), ModItems.LEAD_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.LEAD_INGOT.getDefaultInstance(), ModItems.BISMUTH_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BISMUTH_INGOT.getDefaultInstance(), ModItems.URANIUM_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.NETHERITE_INGOT.getDefaultInstance(), ModItems.BRONZE_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_INGOT.getDefaultInstance(), ModItems.BRASS_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRASS_INGOT.getDefaultInstance(), ModItems.STEEL_INGOT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.remove(Items.COPPER_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.IRON_NUGGET.getDefaultInstance(), Items.COPPER_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_NUGGET.getDefaultInstance(), ModItems.ZINC_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ZINC_NUGGET.getDefaultInstance(), ModItems.SILVER_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SILVER_NUGGET.getDefaultInstance(), ModItems.TIN_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TIN_NUGGET.getDefaultInstance(), ModItems.TUNGSTEN_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.TUNGSTEN_NUGGET.getDefaultInstance(), ModItems.PLATINUM_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.GOLD_NUGGET.getDefaultInstance(), ModItems.LEAD_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.LEAD_NUGGET.getDefaultInstance(), ModItems.BISMUTH_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BISMUTH_NUGGET.getDefaultInstance(), ModItems.URANIUM_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.URANIUM_NUGGET.getDefaultInstance(), ModItems.NETHERITE_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.NETHERITE_NUGGET.getDefaultInstance(), ModItems.BRONZE_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_NUGGET.getDefaultInstance(), ModItems.BRASS_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRASS_NUGGET.getDefaultInstance(), ModItems.STEEL_NUGGET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.LAVA_BUCKET.getDefaultInstance(), ModItems.NUCLEAR_WASTE_BUCKET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModItems.MUSIC_DISC_ANGRY_BOYFRIENDS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.BAMBOO_CHEST_RAFT.getDefaultInstance(), ModItems.CRIMSON_BOAT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CRIMSON_BOAT.getDefaultInstance(), ModItems.CRIMSON_CHEST_BOAT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CRIMSON_CHEST_BOAT.getDefaultInstance(), ModItems.WARPED_BOAT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.WARPED_BOAT.getDefaultInstance(), ModItems.WARPED_CHEST_BOAT.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.FURNACE_MINECART.getDefaultInstance(), ModItems.BLACKSTONE_FURNACE_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BLACKSTONE_FURNACE_MINECART.getDefaultInstance(), ModItems.DEEPSLATE_FURNACE_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.CHEST_MINECART.getDefaultInstance(), ModItems.SPRUCE_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.SPRUCE_CHEST_MINECART.getDefaultInstance(), ModItems.BIRCH_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BIRCH_CHEST_MINECART.getDefaultInstance(), ModItems.JUNGLE_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.JUNGLE_CHEST_MINECART.getDefaultInstance(), ModItems.ACACIA_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.ACACIA_CHEST_MINECART.getDefaultInstance(), ModItems.DARK_OAK_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.DARK_OAK_CHEST_MINECART.getDefaultInstance(), ModItems.MANGROVE_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.MANGROVE_CHEST_MINECART.getDefaultInstance(), ModItems.CHERRY_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CHERRY_CHEST_MINECART.getDefaultInstance(), ModItems.PALE_OAK_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.PALE_OAK_CHEST_MINECART.getDefaultInstance(), ModItems.BAMBOO_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BAMBOO_CHEST_MINECART.getDefaultInstance(), ModItems.CRIMSON_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.CRIMSON_CHEST_MINECART.getDefaultInstance(), ModItems.WARPED_CHEST_MINECART.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.COPPER_HOE.getDefaultInstance(), ModItems.BRONZE_SHOVEL.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_SHOVEL.getDefaultInstance(), ModItems.BRONZE_PICKAXE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_PICKAXE.getDefaultInstance(), ModItems.BRONZE_AXE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_AXE.getDefaultInstance(), ModItems.BRONZE_HOE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.insertAfter(Blocks.TNT.asItem().getDefaultInstance(), ModBlocks.NUKE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.STREAMLINED_ARROW.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.SHARPENED_ARROW.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.SPECTRAL_ARROW.getDefaultInstance(), ModItems.EXPLOSIVE_ARROW.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.COPPER_SWORD.getDefaultInstance(), ModItems.BRONZE_SWORD.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_AXE.getDefaultInstance(), ModItems.BRONZE_AXE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_SPEAR.getDefaultInstance(), ModItems.BRONZE_SPEAR.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_HORSE_ARMOR.getDefaultInstance(), ModItems.BRONZE_HORSE_ARMOR.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.COPPER_NAUTILUS_ARMOR.getDefaultInstance(), ModItems.BRONZE_NAUTILUS_ARMOR.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.COPPER_BOOTS.getDefaultInstance(), ModItems.BRONZE_HELMET.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_HELMET.getDefaultInstance(), ModItems.BRONZE_CHESTPLATE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_CHESTPLATE.getDefaultInstance(), ModItems.BRONZE_LEGGINGS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(ModItems.BRONZE_LEGGINGS.getDefaultInstance(), ModItems.BRONZE_BOOTS.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.insertAfter(Blocks.SOUL_SAND.asItem().getDefaultInstance(), ModBlocks.SOUL_SANDSTONE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.PRISMARINE.asItem().getDefaultInstance(), ModBlocks.ELDER_PRISMARINE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TUFF.asItem().getDefaultInstance(), ModBlocks.RHYOLITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.TUFF.asItem().getDefaultInstance(), ModBlocks.GABBRO.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.SMOOTH_BASALT.asItem().getDefaultInstance(), ModBlocks.PUMICE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.GRAPHENE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.GRAPHITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.END_STONE.asItem().getDefaultInstance(), ModBlocks.CARBON_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_NYLIUM.asItem().getDefaultInstance(), ModBlocks.SILICENE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_NYLIUM.asItem().getDefaultInstance(), ModBlocks.SILICITE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.WARPED_NYLIUM.asItem().getDefaultInstance(), ModBlocks.SILICON_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_PLATINUM_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.PLATINUM_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_TUNGSTEN_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.TUNGSTEN_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_TIN_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.TIN_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_SILVER_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.SILVER_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_ZINC_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_COPPER_ORE.asItem().getDefaultInstance(), ModBlocks.ZINC_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_URANIUM_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.URANIUM_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_BISMUTH_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.BISMUTH_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_LEAD_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_GOLD_ORE.asItem().getDefaultInstance(), ModBlocks.LEAD_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_DIAMOND_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_DIAMOND_ORE.asItem().getDefaultInstance(), ModBlocks.SAPPHIRE_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_DIAMOND_ORE.asItem().getDefaultInstance(), ModBlocks.DEEPSLATE_RUBY_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.DEEPSLATE_DIAMOND_ORE.asItem().getDefaultInstance(), ModBlocks.RUBY_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.NETHER_QUARTZ_ORE.asItem().getDefaultInstance(), ModBlocks.NETHER_MONOCRYSTAL_ORE.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Blocks.RAW_COPPER_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_PLATINUM_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_COPPER_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_TUNGSTEN_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_COPPER_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_TIN_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_COPPER_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_SILVER_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_COPPER_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_ZINC_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_URANIUM_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_BISMUTH_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Blocks.RAW_GOLD_BLOCK.asItem().getDefaultInstance(), ModBlocks.RAW_LEAD_BLOCK.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
    }

    private static void registerColoredItems(BuildCreativeModeTabContentsEvent event, List<DyeColor> gameplayColorOrder, ColorCollection<Block> items, ItemStack itemBefore) {
        gameplayColorOrder.reversed().forEach((color) -> event.insertAfter(itemBefore, items.pick(color).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerRustingIronItems(BuildCreativeModeTabContentsEvent event, List<RustingIron.WeatherState> gameplayRustOrder, RustingIronCollection<Block> items, ItemStack itemBefore) {
        gameplayRustOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.weathering().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerWaxedIronItems(BuildCreativeModeTabContentsEvent event, List<RustingIron.WeatherState> gameplayRustOrder, RustingIronCollection<Block> items, ItemStack itemBefore) {
        gameplayRustOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.waxed().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerCorrodingZincItems(BuildCreativeModeTabContentsEvent event, List<CorrodingZinc.WeatherState> gameplayCorrosionOrder, CorrodingZincCollection<Block> items, ItemStack itemBefore) {
        gameplayCorrosionOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.weathering().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerWaxedZincItems(BuildCreativeModeTabContentsEvent event, List<CorrodingZinc.WeatherState> gameplayCorrosionOrder, CorrodingZincCollection<Block> items, ItemStack itemBefore) {
        gameplayCorrosionOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.waxed().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerCorrodingZincItems(BuildCreativeModeTabContentsEvent event, List<CorrodingZinc.WeatherState> gameplayCorrosionOrder, CorrodingZincCollection<Block> items) {
        gameplayCorrosionOrder.forEach((state) -> event.accept(items.weathering().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerWaxedZincItems(BuildCreativeModeTabContentsEvent event, List<CorrodingZinc.WeatherState> gameplayCorrosionOrder, CorrodingZincCollection<Block> items) {
        gameplayCorrosionOrder.forEach((state) -> event.accept(items.waxed().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerWeatheringCopperItems(BuildCreativeModeTabContentsEvent event, List<WeatheringCopper.WeatherState> gameplayCorrosionOrder, WeatheringCopperCollection<Block> items, ItemStack itemBefore) {
        gameplayCorrosionOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.weathering().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }

    private static void registerWaxedCopperItems(BuildCreativeModeTabContentsEvent event, List<WeatheringCopper.WeatherState> gameplayCorrosionOrder, WeatheringCopperCollection<Block> items, ItemStack itemBefore) {
        gameplayCorrosionOrder.reversed().forEach((state) -> event.insertAfter(itemBefore, items.waxed().pick(state).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }
}
