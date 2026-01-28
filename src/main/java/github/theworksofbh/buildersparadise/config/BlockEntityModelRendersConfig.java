package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
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

    }
}
