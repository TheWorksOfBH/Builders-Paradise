package github.theworksofbh.buildersparadise.compat.bop.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.renderer.block.BuiltInBlockModels;
import net.neoforged.neoforge.client.event.RegisterBlockModelsEvent;

public class BOPBlockEntityModelRendersConfig {
    public static void registerBlockEntities(RegisterBlockModelsEvent event) {
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.DEAD_CHEST_TEXTURE), CompatModBlocks.DEAD_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.EMPYREAL_CHEST_TEXTURE), CompatModBlocks.EMPYREAL_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.FIR_CHEST_TEXTURE), CompatModBlocks.FIR_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.HELLBARK_CHEST_TEXTURE), CompatModBlocks.HELLBARK_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.JACARANDA_CHEST_TEXTURE), CompatModBlocks.JACARANDA_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAGIC_CHEST_TEXTURE), CompatModBlocks.MAGIC_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAHOGANY_CHEST_TEXTURE), CompatModBlocks.MAHOGANY_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAPLE_CHEST_TEXTURE), CompatModBlocks.MAPLE_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PALM_CHEST_TEXTURE), CompatModBlocks.PALM_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PINE_CHEST_TEXTURE), CompatModBlocks.PINE_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.REDWOOD_CHEST_TEXTURE), CompatModBlocks.REDWOOD_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.UMBRAN_CHEST_TEXTURE), CompatModBlocks.UMBRAN_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.WILLOW_CHEST_TEXTURE), CompatModBlocks.WILLOW_CHEST.get());

        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.DEAD_TRAPPED_CHEST_TEXTURE), CompatModBlocks.DEAD_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.EMPYREAL_TRAPPED_CHEST_TEXTURE), CompatModBlocks.EMPYREAL_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.FIR_TRAPPED_CHEST_TEXTURE), CompatModBlocks.FIR_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.HELLBARK_TRAPPED_CHEST_TEXTURE), CompatModBlocks.HELLBARK_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.JACARANDA_TRAPPED_CHEST_TEXTURE), CompatModBlocks.JACARANDA_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAGIC_TRAPPED_CHEST_TEXTURE), CompatModBlocks.MAGIC_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAHOGANY_TRAPPED_CHEST_TEXTURE), CompatModBlocks.MAHOGANY_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MAPLE_TRAPPED_CHEST_TEXTURE), CompatModBlocks.MAPLE_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PALM_TRAPPED_CHEST_TEXTURE), CompatModBlocks.PALM_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PINE_TRAPPED_CHEST_TEXTURE), CompatModBlocks.PINE_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.REDWOOD_TRAPPED_CHEST_TEXTURE), CompatModBlocks.REDWOOD_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.UMBRAN_TRAPPED_CHEST_TEXTURE), CompatModBlocks.UMBRAN_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.WILLOW_TRAPPED_CHEST_TEXTURE), CompatModBlocks.WILLOW_TRAPPED_CHEST.get());
    }
}
