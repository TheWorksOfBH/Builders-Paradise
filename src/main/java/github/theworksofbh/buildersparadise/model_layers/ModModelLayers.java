package github.theworksofbh.buildersparadise.model_layers;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CRIMSON_BOAT = register("boat/crimson");
    public static final ModelLayerLocation WARPED_BOAT = register("boat/warped");
    public static final ModelLayerLocation CRIMSON_CHEST_BOAT = register("chest_boat/crimson");
    public static final ModelLayerLocation WARPED_CHEST_BOAT = register("chest_boat/warped");
    public static final ModelLayerLocation BLACKSTONE_FURNACE_MINECART = register("blackstone_furnace_minecart");
    public static final ModelLayerLocation DEEPSLATE_FURNACE_MINECART = register("deepslate_furnace_minecart");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String layer) {
        return createLocation(name, layer);
    }

    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name), layer);
    }
}
