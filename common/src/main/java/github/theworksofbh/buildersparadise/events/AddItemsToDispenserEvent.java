package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.level.block.DispenserBlock;

public class AddItemsToDispenserEvent {
    public static void addItemsToDispenser() {
        DispenserBlock.registerProjectileBehavior(ModItems.EXPLOSIVE_ARROW);
        DispenserBlock.registerProjectileBehavior(ModItems.SHARPENED_ARROW);
        DispenserBlock.registerProjectileBehavior(ModItems.STREAMLINED_ARROW);

    }
}
