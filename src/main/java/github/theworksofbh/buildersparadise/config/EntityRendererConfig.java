package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
        });
    }
}
