package github.theworksofbh.buildersparadise.compat.bop.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;

public class BOPBlockEntityModelRendersConfig {
    public static void registerBlockEntities(RegisterSpecialBlockModelRendererEvent event) {
        event.register(CompatModBlocks.DEAD_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.DEAD_CHEST_TEXTURE));
        event.register(CompatModBlocks.EMPYREAL_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.EMPYREAL_CHEST_TEXTURE));
        event.register(CompatModBlocks.FIR_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.FIR_CHEST_TEXTURE));
        event.register(CompatModBlocks.HELLBARK_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.HELLBARK_CHEST_TEXTURE));
        event.register(CompatModBlocks.JACARANDA_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.JACARANDA_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAGIC_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAGIC_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAHOGANY_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAHOGANY_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAPLE_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAPLE_CHEST_TEXTURE));
        event.register(CompatModBlocks.PALM_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PALM_CHEST_TEXTURE));
        event.register(CompatModBlocks.PINE_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PINE_CHEST_TEXTURE));
        event.register(CompatModBlocks.REDWOOD_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.REDWOOD_CHEST_TEXTURE));
        event.register(CompatModBlocks.UMBRAN_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.UMBRAN_CHEST_TEXTURE));
        event.register(CompatModBlocks.WILLOW_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.WILLOW_CHEST_TEXTURE));

        event.register(CompatModBlocks.DEAD_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.DEAD_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.EMPYREAL_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.EMPYREAL_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.FIR_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.FIR_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.HELLBARK_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.HELLBARK_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.JACARANDA_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.JACARANDA_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAGIC_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAGIC_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAHOGANY_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAHOGANY_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.MAPLE_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MAPLE_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.PALM_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PALM_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.PINE_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PINE_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.REDWOOD_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.REDWOOD_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.UMBRAN_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.UMBRAN_TRAPPED_CHEST_TEXTURE));
        event.register(CompatModBlocks.WILLOW_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.WILLOW_TRAPPED_CHEST_TEXTURE));

    }
}
