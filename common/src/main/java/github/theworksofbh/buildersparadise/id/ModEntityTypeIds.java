package github.theworksofbh.buildersparadise.id;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeIds {
    public static final ResourceKey<EntityType<?>> NUKE = create("nuke");
    public static final ResourceKey<EntityType<?>> EXPLOSIVE_ARROW = create("explosive_arrow");
    public static final ResourceKey<EntityType<?>> SHARPENED_ARROW = create("sharpened_arrow");
    public static final ResourceKey<EntityType<?>> STREAMLINED_ARROW = create("streamlined_arrow");
    public static final ResourceKey<EntityType<?>> RISING_BLOCK = create("rising_block");
    public static final ResourceKey<EntityType<?>> CRIMSON_BOAT = create("crimson_boat");
    public static final ResourceKey<EntityType<?>> WARPED_BOAT = create("warped_boat");
    public static final ResourceKey<EntityType<?>> CRIMSON_CHEST_BOAT = create("crimson_chest_boat");
    public static final ResourceKey<EntityType<?>> WARPED_CHEST_BOAT = create("warped_chest_boat");
    public static final ResourceKey<EntityType<?>> BLACKSTONE_FURNACE_MINECART = create("blackstone_furnace_minecart");
    public static final ResourceKey<EntityType<?>> DEEPSLATE_FURNACE_MINECART = create("deepslate_furnace_minecart");
    public static final ResourceKey<EntityType<?>> SPRUCE_CHEST_MINECART = create("spruce_chest_minecart");
    public static final ResourceKey<EntityType<?>> BIRCH_CHEST_MINECART = create("birch_chest_minecart");
    public static final ResourceKey<EntityType<?>> JUNGLE_CHEST_MINECART = create("jungle_chest_minecart");
    public static final ResourceKey<EntityType<?>> ACACIA_CHEST_MINECART = create("acacia_chest_minecart");
    public static final ResourceKey<EntityType<?>> DARK_OAK_CHEST_MINECART = create("dark_oak_chest_minecart");
    public static final ResourceKey<EntityType<?>> CRIMSON_CHEST_MINECART = create("crimson_chest_minecart");
    public static final ResourceKey<EntityType<?>> WARPED_CHEST_MINECART = create("warped_chest_minecart");
    public static final ResourceKey<EntityType<?>> MANGROVE_CHEST_MINECART = create("mangrove_chest_minecart");
    public static final ResourceKey<EntityType<?>> CHERRY_CHEST_MINECART = create("cherry_chest_minecart");
    public static final ResourceKey<EntityType<?>> BAMBOO_CHEST_MINECART = create("bamboo_chest_minecart");
    public static final ResourceKey<EntityType<?>> PALE_OAK_CHEST_MINECART = create("pale_oak_chest_minecart");

    private static ResourceKey<EntityType<?>> create(final String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }
}
