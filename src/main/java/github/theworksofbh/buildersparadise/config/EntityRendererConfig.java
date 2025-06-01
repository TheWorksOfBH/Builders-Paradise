package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.entity.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.TntRenderer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class EntityRendererConfig {
    public static void addEntityRenderers(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.NUKE.get(), TntRenderer::new);

        });
    }
}
