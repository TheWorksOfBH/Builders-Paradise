package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.client.renderer.entity.TntRenderer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class EntityRendererConfig {
    public static void addEntityRenderers(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.NUKE.get(), TntRenderer::new);
            EntityRenderers.register(ModEntities.CRIMSON_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.CRIMSON_BOAT));
            EntityRenderers.register(ModEntities.WARPED_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.WARPED_BOAT));
            EntityRenderers.register(ModEntities.CRIMSON_CHEST_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.CRIMSON_CHEST_BOAT));
            EntityRenderers.register(ModEntities.WARPED_CHEST_BOAT.get(), (context) -> new BoatRenderer(context, ModModelLayers.WARPED_CHEST_BOAT));
            EntityRenderers.register(ModEntities.BLACKSTONE_FURNACE_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.BLACKSTONE_FURNACE_MINECART));
            EntityRenderers.register(ModEntities.DEEPSLATE_FURNACE_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.DEEPSLATE_FURNACE_MINECART));
            EntityRenderers.register(ModEntities.SPRUCE_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.SPRUCE_CHEST_MINECART));
            EntityRenderers.register(ModEntities.BIRCH_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.BIRCH_CHEST_MINECART));
            EntityRenderers.register(ModEntities.JUNGLE_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.JUNGLE_CHEST_MINECART));
            EntityRenderers.register(ModEntities.ACACIA_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.ACACIA_CHEST_MINECART));
            EntityRenderers.register(ModEntities.DARK_OAK_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.DARK_OAK_CHEST_MINECART));
            EntityRenderers.register(ModEntities.CRIMSON_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.CRIMSON_CHEST_MINECART));
            EntityRenderers.register(ModEntities.WARPED_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.WARPED_CHEST_MINECART));
            EntityRenderers.register(ModEntities.MANGROVE_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.MANGROVE_CHEST_MINECART));
            EntityRenderers.register(ModEntities.CHERRY_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.CHERRY_CHEST_MINECART));
            EntityRenderers.register(ModEntities.BAMBOO_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.BAMBOO_CHEST_MINECART));
            EntityRenderers.register(ModEntities.PALE_OAK_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.PALE_OAK_CHEST_MINECART));
        });
    }
}
