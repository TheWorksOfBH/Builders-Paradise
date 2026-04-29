package github.theworksofbh.buildersparadise.model_layers;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

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
    public static final ModelLayerLocation BOAT_LAVA_PATCH = register("boat", "lava_patch");

    // BOP

    public static final ModelLayerLocation DEAD_CHEST_MINECART = register("dead_chest_minecart");
    public static final ModelLayerLocation EMPYREAL_CHEST_MINECART = register("empyreal_chest_minecart");
    public static final ModelLayerLocation FIR_CHEST_MINECART = register("fir_chest_minecart");
    public static final ModelLayerLocation HELLBARK_CHEST_MINECART = register("hellbark_chest_minecart");
    public static final ModelLayerLocation JACARANDA_CHEST_MINECART = register("jacaranda_chest_minecart");
    public static final ModelLayerLocation MAGIC_CHEST_MINECART = register("magic_chest_minecart");
    public static final ModelLayerLocation MAHOGANY_CHEST_MINECART = register("mahogany_chest_minecart");
    public static final ModelLayerLocation MAPLE_CHEST_MINECART = register("maple_chest_minecart");
    public static final ModelLayerLocation PALM_CHEST_MINECART = register("palm_chest_minecart");
    public static final ModelLayerLocation PINE_CHEST_MINECART = register("pine_chest_minecart");
    public static final ModelLayerLocation REDWOOD_CHEST_MINECART = register("redwood_chest_minecart");
    public static final ModelLayerLocation UMBRAN_CHEST_MINECART = register("umbran_chest_minecart");
    public static final ModelLayerLocation WILLOW_CHEST_MINECART = register("willow_chest_minecart");
    public static final ModelLayerLocation ORIGIN_OAK_CHEST_MINECART = register("origin_oak_chest_minecart");

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String layer) {
        return createLocation(name, layer);
    }

    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name), layer);
    }
}
