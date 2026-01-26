package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;

public class BlockEntityModelRendersConfig {
    public static void registerBlockEntities(RegisterSpecialBlockModelRendererEvent event) {
        event.register(ModBlocks.SPRUCE_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.SPRUCE_CHEST_TEXTURE));
        event.register(ModBlocks.BIRCH_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.BIRCH_CHEST_TEXTURE));
        event.register(ModBlocks.JUNGLE_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.JUNGLE_CHEST_TEXTURE));
        event.register(ModBlocks.ACACIA_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.ACACIA_CHEST_TEXTURE));
        event.register(ModBlocks.DARK_OAK_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.DARK_OAK_CHEST_TEXTURE));
        event.register(ModBlocks.CRIMSON_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.CRIMSON_CHEST_TEXTURE));
        event.register(ModBlocks.WARPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.WARPED_CHEST_TEXTURE));
        event.register(ModBlocks.MANGROVE_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MANGROVE_CHEST_TEXTURE));
        event.register(ModBlocks.CHERRY_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.CHERRY_CHEST_TEXTURE));
        event.register(ModBlocks.BAMBOO_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.BAMBOO_CHEST_TEXTURE));
        event.register(ModBlocks.PALE_OAK_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PALE_OAK_CHEST_TEXTURE));
        
        event.register(ModBlocks.SPRUCE_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.SPRUCE_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.BIRCH_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.BIRCH_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.JUNGLE_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.JUNGLE_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.ACACIA_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.ACACIA_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.DARK_OAK_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.DARK_OAK_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.CRIMSON_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.CRIMSON_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.WARPED_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.WARPED_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.MANGROVE_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.MANGROVE_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.CHERRY_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.CHERRY_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.BAMBOO_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.BAMBOO_TRAPPED_CHEST_TEXTURE));
        event.register(ModBlocks.PALE_OAK_TRAPPED_CHEST.get(), new ChestSpecialRenderer.Unbaked(ModChestSpecialRenderers.PALE_OAK_TRAPPED_CHEST_TEXTURE));

        if (ModList.get().isLoaded("biomesoplenty")) {
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
}
