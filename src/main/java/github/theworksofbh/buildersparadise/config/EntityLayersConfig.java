package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.cart.MinecartModel;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class EntityLayersConfig {
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.CRIMSON_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.WARPED_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.CRIMSON_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.WARPED_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.BLACKSTONE_FURNACE_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DEEPSLATE_FURNACE_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SPRUCE_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BIRCH_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JUNGLE_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ACACIA_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DARK_OAK_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CRIMSON_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WARPED_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MANGROVE_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHERRY_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BAMBOO_CHEST_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PALE_OAK_CHEST_MINECART, MinecartModel::createBodyLayer);

        if (ModList.get().isLoaded("biomesoplenty")) {
            event.registerLayerDefinition(ModModelLayers.DEAD_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.EMPYREAL_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.FIR_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.HELLBARK_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.JACARANDA_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.MAGIC_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.MAHOGANY_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.MAPLE_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.PALM_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.PINE_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.REDWOOD_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.UMBRAN_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.WILLOW_CHEST_MINECART, MinecartModel::createBodyLayer);
            event.registerLayerDefinition(ModModelLayers.ORIGIN_OAK_CHEST_MINECART, MinecartModel::createBodyLayer);
        }
    }
}
