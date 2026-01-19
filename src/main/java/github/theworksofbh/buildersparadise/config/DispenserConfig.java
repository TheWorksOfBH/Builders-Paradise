package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.level.block.DispenserBlock;

public class DispenserConfig {
    public static void addItemsToDispenser() {
        DispenserBlock.registerProjectileBehavior(ModItems.EXPLOSIVE_ARROW.get());
        DispenserBlock.registerProjectileBehavior(ModItems.SHARPENED_ARROW.get());
        DispenserBlock.registerProjectileBehavior(ModItems.STREAMLINED_ARROW.get());

    }
}
