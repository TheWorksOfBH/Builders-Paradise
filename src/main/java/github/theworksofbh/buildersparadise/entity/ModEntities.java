package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(BuildersParadise.MODID);

    public static final Supplier<EntityType<PrimedNuke>> NUKE = register("nuke", PrimedNuke::new, MobCategory.MISC, 0.98F, 0.98F);
    public static final Supplier<EntityType<FireproofBoat>> CRIMSON_BOAT = register("crimson_boat", (fireproofBoat, level) -> new FireproofBoat(fireproofBoat, level, () -> ModItems.CRIMSON_BOAT.get()), MobCategory.MISC, 1.375F, 0.5625F);
    public static final Supplier<EntityType<FireproofBoat>> WARPED_BOAT = register("warped_boat", (fireproofBoat, level) -> new FireproofBoat(fireproofBoat, level, () -> ModItems.WARPED_BOAT.get()), MobCategory.MISC, 1.375F, 0.5625F);
    public static final Supplier<EntityType<FireproofChestBoat>> CRIMSON_CHEST_BOAT = register("crimson_chest_boat", (fireproofChestBoat, level) -> new FireproofChestBoat(fireproofChestBoat, level, () -> ModItems.CRIMSON_CHEST_BOAT.get()), MobCategory.MISC, 1.375F, 0.5625F);
    public static final Supplier<EntityType<FireproofChestBoat>> WARPED_CHEST_BOAT = register("warped_chest_boat", (fireproofChestBoat, level) -> new FireproofChestBoat(fireproofChestBoat, level, () -> ModItems.WARPED_CHEST_BOAT.get()), MobCategory.MISC, 1.375F, 0.5625F);
    public static final Supplier<EntityType<MinecartCustomFurnace>> BLACKSTONE_FURNACE_MINECART = register("blackstone_furnace_minecart", (customFurnaceMinecart, level) -> new MinecartCustomFurnace(customFurnaceMinecart, level, ModBlocks.BLACKSTONE_FURNACE.get(), ModItems.BLACKSTONE_FURNACE_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomFurnace>> DEEPSLATE_FURNACE_MINECART = register("deepslate_furnace_minecart", (customFurnaceMinecart, level) -> new MinecartCustomFurnace(customFurnaceMinecart, level, ModBlocks.DEEPSLATE_FURNACE.get(), ModItems.DEEPSLATE_FURNACE_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> SPRUCE_CHEST_MINECART = register("spruce_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.SPRUCE_CHEST.get(), ModItems.SPRUCE_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> BIRCH_CHEST_MINECART = register("birch_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.BIRCH_CHEST.get(), ModItems.BIRCH_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> JUNGLE_CHEST_MINECART = register("jungle_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.JUNGLE_CHEST.get(), ModItems.JUNGLE_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> ACACIA_CHEST_MINECART = register("acacia_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.ACACIA_CHEST.get(), ModItems.ACACIA_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> DARK_OAK_CHEST_MINECART = register("dark_oak_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.DARK_OAK_CHEST.get(), ModItems.DARK_OAK_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> CRIMSON_CHEST_MINECART = register("crimson_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.CRIMSON_CHEST.get(), ModItems.CRIMSON_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> WARPED_CHEST_MINECART = register("warped_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.WARPED_CHEST.get(), ModItems.WARPED_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> MANGROVE_CHEST_MINECART = register("mangrove_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.MANGROVE_CHEST.get(), ModItems.MANGROVE_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> CHERRY_CHEST_MINECART = register("cherry_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.CHERRY_CHEST.get(), ModItems.CHERRY_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> BAMBOO_CHEST_MINECART = register("bamboo_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.BAMBOO_CHEST.get(), ModItems.BAMBOO_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> PALE_OAK_CHEST_MINECART = register("pale_oak_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, ModBlocks.PALE_OAK_CHEST.get(), ModItems.PALE_OAK_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);

    public static <T extends Entity> Supplier<EntityType<T>> register(String registryName, EntityFactory<T> entityFactory, MobCategory mobCategory, float width, float height) {
        return ENTITIES.register(
                registryName,
                () -> Builder.of(
                        entityFactory,
                        mobCategory
                ).sized(
                        width,
                        height
                ).noLootTable().build(
                        ResourceKey.create(
                                Registries.ENTITY_TYPE,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        );
    }


    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }

}
