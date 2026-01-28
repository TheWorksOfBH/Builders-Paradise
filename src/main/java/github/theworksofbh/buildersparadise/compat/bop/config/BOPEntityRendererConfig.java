package github.theworksofbh.buildersparadise.compat.bop.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModEntities;
import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class BOPEntityRendererConfig {
    public static void addEntityRenderers(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(CompatModEntities.DEAD_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.DEAD_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.EMPYREAL_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.EMPYREAL_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.FIR_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.FIR_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.HELLBARK_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.HELLBARK_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.JACARANDA_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.JACARANDA_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.MAGIC_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.MAGIC_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.MAHOGANY_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.MAHOGANY_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.MAPLE_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.MAPLE_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.PALM_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.PALM_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.PINE_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.PINE_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.REDWOOD_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.REDWOOD_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.UMBRAN_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.UMBRAN_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.WILLOW_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.WILLOW_CHEST_MINECART));
            EntityRenderers.register(CompatModEntities.ORIGIN_OAK_CHEST_MINECART.get(), (context) -> new MinecartRenderer(context, ModModelLayers.ORIGIN_OAK_CHEST_MINECART));
        });
    }
}
