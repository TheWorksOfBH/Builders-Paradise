package github.theworksofbh.buildersparadise.entities;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.entities.types.*;
import github.theworksofbh.buildersparadise.id.ModEntityTypeIds;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModEntities {

    public static final EntityType<PrimedNuke> NUKE = register(ModEntityTypeIds.NUKE, Builder.<PrimedNuke>of(PrimedNuke::new, MobCategory.MISC).sized(0.98F, 0.98F).noLootTable().fireImmune().eyeHeight(0.15F).clientTrackingRange(10).updateInterval(10));
    public static final EntityType<ExplosiveArrow> EXPLOSIVE_ARROW =  register(ModEntityTypeIds.EXPLOSIVE_ARROW, Builder.<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).noLootTable().eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20));
    public static final EntityType<SharpenedArrow> SHARPENED_ARROW =  register(ModEntityTypeIds.SHARPENED_ARROW, Builder.<SharpenedArrow>of(SharpenedArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).noLootTable().eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20));
    public static final EntityType<StreamlinedArrow> STREAMLINED_ARROW =  register(ModEntityTypeIds.STREAMLINED_ARROW, Builder.<StreamlinedArrow>of(StreamlinedArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).noLootTable().eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20));
    public static final EntityType<RisingBlockEntity> RISING_BLOCK = register(ModEntityTypeIds.RISING_BLOCK, Builder.<RisingBlockEntity>of(RisingBlockEntity::new, MobCategory.MISC).sized(0.98F, 0.98F).noLootTable().clientTrackingRange(10).updateInterval(20));
    public static final EntityType<FireproofBoat> CRIMSON_BOAT = register(ModEntityTypeIds.CRIMSON_BOAT, Builder.<FireproofBoat>of(fireproofBoatFactory(() -> ModItems.CRIMSON_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    public static final EntityType<FireproofBoat> WARPED_BOAT = register(ModEntityTypeIds.WARPED_BOAT, Builder.<FireproofBoat>of(fireproofBoatFactory(() -> ModItems.WARPED_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    public static final EntityType<FireproofChestBoat> CRIMSON_CHEST_BOAT = register(ModEntityTypeIds.CRIMSON_CHEST_BOAT, Builder.<FireproofChestBoat>of(fireproofChestBoatFactory(() -> ModItems.CRIMSON_CHEST_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    public static final EntityType<FireproofChestBoat> WARPED_CHEST_BOAT = register(ModEntityTypeIds.WARPED_CHEST_BOAT, Builder.<FireproofChestBoat>of(fireproofChestBoatFactory(() -> ModItems.WARPED_CHEST_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    public static final EntityType<MinecartCustomFurnace> BLACKSTONE_FURNACE_MINECART = register(ModEntityTypeIds.BLACKSTONE_FURNACE_MINECART, Builder.<MinecartCustomFurnace>of(furnaceMinecartFactory(() -> ModBlocks.BLACKSTONE_FURNACE, () -> ModItems.BLACKSTONE_FURNACE_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomFurnace> DEEPSLATE_FURNACE_MINECART = register(ModEntityTypeIds.DEEPSLATE_FURNACE_MINECART, Builder.<MinecartCustomFurnace>of(furnaceMinecartFactory(() -> ModBlocks.DEEPSLATE_FURNACE, () -> ModItems.DEEPSLATE_FURNACE_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> SPRUCE_CHEST_MINECART = register(ModEntityTypeIds.SPRUCE_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.SPRUCE_CHEST, () -> ModItems.SPRUCE_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> BIRCH_CHEST_MINECART = register(ModEntityTypeIds.BIRCH_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.BIRCH_CHEST, () -> ModItems.BIRCH_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> JUNGLE_CHEST_MINECART = register(ModEntityTypeIds.JUNGLE_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.JUNGLE_CHEST, () -> ModItems.JUNGLE_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> ACACIA_CHEST_MINECART = register(ModEntityTypeIds.ACACIA_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.ACACIA_CHEST, () -> ModItems.ACACIA_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> DARK_OAK_CHEST_MINECART = register(ModEntityTypeIds.DARK_OAK_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.DARK_OAK_CHEST, () -> ModItems.DARK_OAK_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> CRIMSON_CHEST_MINECART = register(ModEntityTypeIds.CRIMSON_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.CRIMSON_CHEST, () -> ModItems.CRIMSON_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> WARPED_CHEST_MINECART = register(ModEntityTypeIds.WARPED_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.WARPED_CHEST, () -> ModItems.WARPED_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> MANGROVE_CHEST_MINECART = register(ModEntityTypeIds.MANGROVE_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.MANGROVE_CHEST, () -> ModItems.MANGROVE_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> CHERRY_CHEST_MINECART = register(ModEntityTypeIds.CHERRY_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.CHERRY_CHEST, () -> ModItems.CHERRY_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> BAMBOO_CHEST_MINECART = register(ModEntityTypeIds.BAMBOO_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.BAMBOO_CHEST, () -> ModItems.BAMBOO_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));
    public static final EntityType<MinecartCustomChest> PALE_OAK_CHEST_MINECART = register(ModEntityTypeIds.PALE_OAK_CHEST_MINECART, Builder.<MinecartCustomChest>of(chestMinecartFactory(() -> ModBlocks.PALE_OAK_CHEST, () -> ModItems.PALE_OAK_CHEST_MINECART), MobCategory.MISC).noLootTable().sized(0.98F, 0.7F).passengerAttachments(0.1875F).clientTrackingRange(8));

    private static EntityType.EntityFactory<FireproofBoat> fireproofBoatFactory(final Supplier<Item> boatItem) {
        return (entityType, level) -> new FireproofBoat(entityType, level, boatItem);
    }

    private static EntityType.EntityFactory<FireproofChestBoat> fireproofChestBoatFactory(final Supplier<Item> dropItem) {
        return (entityType, level) -> new FireproofChestBoat(entityType, level, dropItem);
    }

    private static EntityType.EntityFactory<MinecartCustomFurnace> furnaceMinecartFactory(final Supplier<Block> blockInside, final Supplier<Item> dropItem) {
        return (entityType, level) -> new MinecartCustomFurnace(entityType, level, blockInside.get(), dropItem.get());
    }

    private static EntityType.EntityFactory<MinecartCustomChest> chestMinecartFactory(final Supplier<Block> blockInside, final Supplier<Item> dropItem) {
        return (entityType, level) -> new MinecartCustomChest(entityType, level, blockInside.get(), dropItem.get());
    }

    private static <T extends Entity> EntityType<T> register(final ResourceKey<EntityType<?>> id, final EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(id));
    }

    public static void initialize() {

    }
}
