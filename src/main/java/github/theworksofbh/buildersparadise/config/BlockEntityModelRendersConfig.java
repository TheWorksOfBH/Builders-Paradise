package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.renderer.block.BuiltInBlockModels;
import net.neoforged.neoforge.client.event.RegisterBlockModelsEvent;

public class BlockEntityModelRendersConfig {
    public static void registerBlockEntities(RegisterBlockModelsEvent event) {
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.SPRUCE_CHEST_TEXTURE), ModBlocks.SPRUCE_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.BIRCH_CHEST_TEXTURE), ModBlocks.BIRCH_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.JUNGLE_CHEST_TEXTURE), ModBlocks.JUNGLE_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.ACACIA_CHEST_TEXTURE), ModBlocks.ACACIA_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.DARK_OAK_CHEST_TEXTURE), ModBlocks.DARK_OAK_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.CRIMSON_CHEST_TEXTURE), ModBlocks.CRIMSON_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.WARPED_CHEST_TEXTURE), ModBlocks.WARPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MANGROVE_CHEST_TEXTURE), ModBlocks.MANGROVE_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.CHERRY_CHEST_TEXTURE), ModBlocks.CHERRY_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.BAMBOO_CHEST_TEXTURE), ModBlocks.BAMBOO_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PALE_OAK_CHEST_TEXTURE), ModBlocks.PALE_OAK_CHEST.get());

        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.SPRUCE_TRAPPED_CHEST_TEXTURE), ModBlocks.SPRUCE_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.BIRCH_TRAPPED_CHEST_TEXTURE), ModBlocks.BIRCH_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.JUNGLE_TRAPPED_CHEST_TEXTURE), ModBlocks.JUNGLE_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.ACACIA_TRAPPED_CHEST_TEXTURE), ModBlocks.ACACIA_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.DARK_OAK_TRAPPED_CHEST_TEXTURE), ModBlocks.DARK_OAK_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.CRIMSON_TRAPPED_CHEST_TEXTURE), ModBlocks.CRIMSON_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.WARPED_TRAPPED_CHEST_TEXTURE), ModBlocks.WARPED_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.MANGROVE_TRAPPED_CHEST_TEXTURE), ModBlocks.MANGROVE_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.CHERRY_TRAPPED_CHEST_TEXTURE), ModBlocks.CHERRY_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.BAMBOO_TRAPPED_CHEST_TEXTURE), ModBlocks.BAMBOO_TRAPPED_CHEST.get());
        event.register(BuiltInBlockModels.createXmasChest(ModChestSpecialRenderers.PALE_OAK_TRAPPED_CHEST_TEXTURE), ModBlocks.PALE_OAK_TRAPPED_CHEST.get());
    }
}
