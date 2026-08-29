package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class NeoForgeCreativeEvent {
    public static void addItemsToCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.insertAfter(Blocks.STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.STONE_WALL.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
