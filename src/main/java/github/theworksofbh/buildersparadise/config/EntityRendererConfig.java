package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModEntities;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import github.theworksofbh.buildersparadise.renderers.ExplosiveArrowRenderer;
import github.theworksofbh.buildersparadise.renderers.SharpenedArrowRenderer;
import github.theworksofbh.buildersparadise.renderers.StreamlinedArrowRenderer;
import net.minecraft.client.renderer.entity.*;
import net.neoforged.fml.ModList;
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
            EntityRenderers.register(ModEntities.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
            EntityRenderers.register(ModEntities.SHARPENED_ARROW.get(), SharpenedArrowRenderer::new);
            EntityRenderers.register(ModEntities.STREAMLINED_ARROW.get(), StreamlinedArrowRenderer::new);
            EntityRenderers.register(ModEntities.RISING_BLOCK.get(), FallingBlockRenderer::new);

            if (ModList.get().isLoaded("biomesoplenty")) {
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
            }
        });
    }
}
