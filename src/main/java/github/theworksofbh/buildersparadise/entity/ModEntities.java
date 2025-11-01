package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.entity.vehicle.MinecartFurnace;
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
    public static final Supplier<EntityType<MinecartFurnace>> BLACKSTONE_FURNACE_MINECART = register("blackstone_furnace_minecart", BlackstoneMinecartFurnace::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartFurnace>> DEEPSLATE_FURNACE_MINECART = register("deepslate_furnace_minecart", DeepslateMinecartFurnace::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> SPRUCE_CHEST_MINECART = register("spruce_chest_minecart", MinecartSpruceChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> BIRCH_CHEST_MINECART = register("birch_chest_minecart", MinecartBirchChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> JUNGLE_CHEST_MINECART = register("jungle_chest_minecart", MinecartJungleChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> ACACIA_CHEST_MINECART = register("acacia_chest_minecart", MinecartAcaciaChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> DARK_OAK_CHEST_MINECART = register("dark_oak_chest_minecart", MinecartDarkOakChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> CRIMSON_CHEST_MINECART = register("crimson_chest_minecart", MinecartCrimsonChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> WARPED_CHEST_MINECART = register("warped_chest_minecart", MinecartWarpedChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> MANGROVE_CHEST_MINECART = register("mangrove_chest_minecart", MinecartMangroveChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> CHERRY_CHEST_MINECART = register("cherry_chest_minecart", MinecartCherryChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> BAMBOO_CHEST_MINECART = register("bamboo_chest_minecart", MinecartBambooChest::new, MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartChest>> PALE_OAK_CHEST_MINECART = register("pale_oak_chest_minecart", MinecartPaleOakChest::new, MobCategory.MISC, 0.98F, 0.7F);

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
                                ResourceLocation.fromNamespaceAndPath(
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
