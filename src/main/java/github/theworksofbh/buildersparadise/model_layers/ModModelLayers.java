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
    public static final ModelLayerLocation SPRUCE_CHEST_MINECART = register("spruce_chest_minecart");
    public static final ModelLayerLocation BIRCH_CHEST_MINECART = register("birch_chest_minecart");
    public static final ModelLayerLocation JUNGLE_CHEST_MINECART = register("jungle_chest_minecart");
    public static final ModelLayerLocation ACACIA_CHEST_MINECART = register("acacia_chest_minecart");
    public static final ModelLayerLocation DARK_OAK_CHEST_MINECART = register("dark_oak_chest_minecart");
    public static final ModelLayerLocation CRIMSON_CHEST_MINECART = register("crimson_chest_minecart");
    public static final ModelLayerLocation WARPED_CHEST_MINECART = register("warped_chest_minecart");
    public static final ModelLayerLocation MANGROVE_CHEST_MINECART = register("mangrove_chest_minecart");
    public static final ModelLayerLocation CHERRY_CHEST_MINECART = register("cherry_chest_minecart");
    public static final ModelLayerLocation BAMBOO_CHEST_MINECART = register("bamboo_chest_minecart");
    public static final ModelLayerLocation PALE_OAK_CHEST_MINECART = register("pale_oak_chest_minecart");


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
