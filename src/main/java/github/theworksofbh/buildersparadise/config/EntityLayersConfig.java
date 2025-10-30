package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.MinecartModel;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class EntityLayersConfig {
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.CRIMSON_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.WARPED_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.CRIMSON_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.WARPED_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.BLACKSTONE_FURNACE_MINECART, MinecartModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DEEPSLATE_FURNACE_MINECART, MinecartModel::createBodyLayer);

    }
}
