package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;

public class FabricCreativeEvent {
    public static void addItemsToCreative() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((creativeTab) -> {
            creativeTab.insertAfter(Blocks.STONE_SLAB.asItem().getDefaultInstance(), ModBlocks.STONE_WALL.asItem().getDefaultInstance());
        });
    }

    public static void initialize(){
        addItemsToCreative();
    }
}
