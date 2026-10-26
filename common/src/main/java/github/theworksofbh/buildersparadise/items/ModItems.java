package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.entities.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.id.ModBlockItemIds;
import github.theworksofbh.buildersparadise.id.ModItemIds;
import github.theworksofbh.buildersparadise.items.types.*;
import github.theworksofbh.buildersparadise.sounds.ModJukeboxSongs;
import github.theworksofbh.buildersparadise.tags.ModBannerPatternTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    // Items of blocks with standing and wall variants

    public static final Item IRON_TORCH = register(ModBlockItemIds.IRON_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.IRON_TORCH, ModBlocks.IRON_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item ZINC_TORCH = register(ModBlockItemIds.ZINC_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.ZINC_TORCH, ModBlocks.ZINC_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item SILVER_TORCH = register(ModBlockItemIds.SILVER_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.SILVER_TORCH, ModBlocks.SILVER_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item TIN_TORCH = register(ModBlockItemIds.TIN_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.TIN_TORCH, ModBlocks.TIN_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item TUNGSTEN_TORCH = register(ModBlockItemIds.TUNGSTEN_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.TUNGSTEN_TORCH, ModBlocks.TUNGSTEN_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item PLATINUM_TORCH = register(ModBlockItemIds.PLATINUM_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.PLATINUM_TORCH, ModBlocks.PLATINUM_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item GOLD_TORCH = register(ModBlockItemIds.GOLD_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.GOLD_TORCH, ModBlocks.GOLD_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item LEAD_TORCH = register(ModBlockItemIds.LEAD_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.LEAD_TORCH, ModBlocks.LEAD_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item BISMUTH_TORCH = register(ModBlockItemIds.BISMUTH_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.BISMUTH_TORCH, ModBlocks.BISMUTH_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final Item URANIUM_TORCH = register(ModBlockItemIds.URANIUM_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.URANIUM_TORCH, ModBlocks.URANIUM_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());

    // Simple items

    public static final Item NETHERITE_NUGGET = register(ModItemIds.NETHERITE_NUGGET, Item::new, new Item.Properties().fireResistant());
    public static final Item RAW_ZINC = register(ModItemIds.RAW_ZINC, Item::new, new Item.Properties());
    public static final Item ZINC_INGOT = register(ModItemIds.ZINC_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.ZINC));
    public static final Item ZINC_NUGGET = register(ModItemIds.ZINC_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_SILVER = register(ModItemIds.RAW_SILVER, Item::new, new Item.Properties());
    public static final Item SILVER_INGOT = register(ModItemIds.SILVER_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.SILVER));
    public static final Item SILVER_NUGGET = register(ModItemIds.SILVER_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_TIN = register(ModItemIds.RAW_TIN, Item::new, new Item.Properties());
    public static final Item TIN_INGOT = register(ModItemIds.TIN_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.TIN));
    public static final Item TIN_NUGGET = register(ModItemIds.TIN_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_TUNGSTEN = register(ModItemIds.RAW_TUNGSTEN, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_INGOT = register(ModItemIds.TUNGSTEN_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.TUNGSTEN));
    public static final Item TUNGSTEN_NUGGET = register(ModItemIds.TUNGSTEN_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_PLATINUM = register(ModItemIds.RAW_PLATINUM, Item::new, new Item.Properties());
    public static final Item PLATINUM_INGOT = register(ModItemIds.PLATINUM_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.PLATINUM));
    public static final Item PLATINUM_NUGGET = register(ModItemIds.PLATINUM_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_LEAD = register(ModItemIds.RAW_LEAD, Item::new, new Item.Properties());
    public static final Item LEAD_INGOT = register(ModItemIds.LEAD_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.LEAD));
    public static final Item LEAD_NUGGET = register(ModItemIds.LEAD_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_BISMUTH = register(ModItemIds.RAW_BISMUTH, Item::new, new Item.Properties());
    public static final Item BISMUTH_INGOT = register(ModItemIds.BISMUTH_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.BISMUTH));
    public static final Item BISMUTH_NUGGET = register(ModItemIds.BISMUTH_NUGGET, Item::new, new Item.Properties());
    public static final Item RAW_URANIUM = register(ModItemIds.RAW_URANIUM, Item::new, new Item.Properties());
    public static final Item URANIUM_INGOT = register(ModItemIds.URANIUM_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.URANIUM));
    public static final Item URANIUM_NUGGET = register(ModItemIds.URANIUM_NUGGET, Item::new, new Item.Properties());
    public static final Item BRONZE_INGOT = register(ModItemIds.BRONZE_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.BRONZE));
    public static final Item BRONZE_NUGGET = register(ModItemIds.BRONZE_NUGGET, Item::new, new Item.Properties());
    public static final Item BRASS_INGOT = register(ModItemIds.BRASS_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.BRASS));
    public static final Item BRASS_NUGGET = register(ModItemIds.BRASS_NUGGET, Item::new, new Item.Properties());
    public static final Item STEEL_INGOT = register(ModItemIds.STEEL_INGOT, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.STEEL));
    public static final Item STEEL_NUGGET = register(ModItemIds.STEEL_NUGGET, Item::new, new Item.Properties());
    public static final Item MONOCRYSTAL = register(ModItemIds.MONOCRYSTAL, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.MONOCRYSTAL));
    public static final Item RUBY = register(ModItemIds.RUBY, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.RUBY));
    public static final Item SAPPHIRE = register(ModItemIds.SAPPHIRE, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.SAPPHIRE));
    public static final Item SCULK_BRICK = register(ModItemIds.SCULK_BRICK, Item::new, new Item.Properties().trimMaterial(ModTrimMaterials.SCULK));
    public static final Item STONE_BATON = register(ModItemIds.STONE_BATON, Item::new, new Item.Properties());
    public static final Item GRANITE_BATON = register(ModItemIds.GRANITE_BATON, Item::new, new Item.Properties());
    public static final Item DIORITE_BATON = register(ModItemIds.DIORITE_BATON, Item::new, new Item.Properties());
    public static final Item ANDESITE_BATON = register(ModItemIds.ANDESITE_BATON, Item::new, new Item.Properties());
    public static final Item DEEPSLATE_BATON = register(ModItemIds.DEEPSLATE_BATON, Item::new, new Item.Properties());
    public static final Item TUFF_BATON = register(ModItemIds.TUFF_BATON, Item::new, new Item.Properties());
    public static final Item GABBRO_BATON = register(ModItemIds.GABBRO_BATON, Item::new, new Item.Properties());
    public static final Item RHYOLITE_BATON = register(ModItemIds.RHYOLITE_BATON, Item::new, new Item.Properties());
    public static final Item CALCITE_BATON = register(ModItemIds.CALCITE_BATON, Item::new, new Item.Properties());
    public static final Item PACKED_MUD_BATON = register(ModItemIds.PACKED_MUD_BATON, Item::new, new Item.Properties());
    public static final Item SANDSTONE_BATON = register(ModItemIds.SANDSTONE_BATON, Item::new, new Item.Properties());
    public static final Item RED_SANDSTONE_BATON = register(ModItemIds.RED_SANDSTONE_BATON, Item::new, new Item.Properties());
    public static final Item SOUL_SANDSTONE_BATON = register(ModItemIds.SOUL_SANDSTONE_BATON, Item::new, new Item.Properties());
    public static final Item CINNABAR_BATON = register(ModItemIds.CINNABAR_BATON, Item::new, new Item.Properties());
    public static final Item NETHERRACK_BATON = register(ModItemIds.NETHERRACK_BATON, Item::new, new Item.Properties());
    public static final Item BLACKSTONE_BATON = register(ModItemIds.BLACKSTONE_BATON, Item::new, new Item.Properties());
    public static final Item BASALT_BATON = register(ModItemIds.BASALT_BATON, Item::new, new Item.Properties());
    public static final Item PUMICE_BATON = register(ModItemIds.PUMICE_BATON, Item::new, new Item.Properties());
    public static final Item END_STONE_BATON = register(ModItemIds.END_STONE_BATON, Item::new, new Item.Properties());
    public static final Item OBSIDIAN_BATON = register(ModItemIds.OBSIDIAN_BATON, Item::new, new Item.Properties());
    public static final Item TERRACOTTA_BATON = register(ModItemIds.TERRACOTTA_BATON, Item::new, new Item.Properties());
    public static final Item CONCRETE_BATON = register(ModItemIds.CONCRETE_BATON, Item::new, new Item.Properties());
    public static final Item ICE_SHARD = register(ModItemIds.ICE_SHARD, Item::new, new Item.Properties());
    public static final Item ELDER_PRISMARINE_SHARD = register(ModItemIds.ELDER_PRISMARINE_SHARD, Item::new, new Item.Properties());
    public static final Item ELDER_PRISMARINE_CRYSTALS = register(ModItemIds.ELDER_PRISMARINE_CRYSTALS, Item::new, new Item.Properties());
    public static final Item CARBON_DUST = register(ModItemIds.CARBON_DUST, Item::new, new Item.Properties());
    public static final Item SILICON_DUST = register(ModItemIds.SILICON_DUST, Item::new, new Item.Properties());

    // Entity and fluid items

    public static final Item EXPLOSIVE_ARROW = register(ModItemIds.EXPLOSIVE_ARROW, ExplosiveArrowItem::new, new Item.Properties());
    public static final Item SHARPENED_ARROW = register(ModItemIds.SHARPENED_ARROW, SharpenedArrowItem::new, new Item.Properties());
    public static final Item STREAMLINED_ARROW = register(ModItemIds.STREAMLINED_ARROW, StreamlinedArrowItem::new, new Item.Properties());
    public static final Item NUCLEAR_WASTE_BUCKET = register(ModItemIds.NUCLEAR_WASTE_BUCKET, (properties) -> new BucketItem(ModFluids.NUCLEAR_WASTE, properties), new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET));
    public static final Item CRIMSON_BOAT = register(ModItemIds.CRIMSON_BOAT, (properties) -> new BoatItem(ModEntities.CRIMSON_BOAT, properties), new Item.Properties().stacksTo(1));
    public static final Item WARPED_BOAT = register(ModItemIds.WARPED_BOAT, (properties) -> new BoatItem(ModEntities.WARPED_BOAT, properties), new Item.Properties().stacksTo(1));
    public static final Item CRIMSON_CHEST_BOAT = register(ModItemIds.CRIMSON_CHEST_BOAT, (properties) -> new BoatItem(ModEntities.CRIMSON_CHEST_BOAT, properties), new Item.Properties().stacksTo(1));
    public static final Item WARPED_CHEST_BOAT = register(ModItemIds.WARPED_CHEST_BOAT, (properties) -> new BoatItem(ModEntities.WARPED_CHEST_BOAT, properties), new Item.Properties().stacksTo(1));
    public static final Item BLACKSTONE_FURNACE_MINECART = register(ModItemIds.BLACKSTONE_FURNACE_MINECART, (properties) -> new MinecartItem(ModEntities.BLACKSTONE_FURNACE_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item DEEPSLATE_FURNACE_MINECART = register(ModItemIds.DEEPSLATE_FURNACE_MINECART, (properties) -> new MinecartItem(ModEntities.DEEPSLATE_FURNACE_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item SPRUCE_CHEST_MINECART = register(ModItemIds.SPRUCE_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.SPRUCE_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item BIRCH_CHEST_MINECART = register(ModItemIds.BIRCH_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.BIRCH_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item JUNGLE_CHEST_MINECART = register(ModItemIds.JUNGLE_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.JUNGLE_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item ACACIA_CHEST_MINECART = register(ModItemIds.ACACIA_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.ACACIA_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item DARK_OAK_CHEST_MINECART = register(ModItemIds.DARK_OAK_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.DARK_OAK_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item CRIMSON_CHEST_MINECART = register(ModItemIds.CRIMSON_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.CRIMSON_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item WARPED_CHEST_MINECART = register(ModItemIds.WARPED_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.WARPED_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item MANGROVE_CHEST_MINECART = register(ModItemIds.MANGROVE_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.MANGROVE_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item CHERRY_CHEST_MINECART = register(ModItemIds.CHERRY_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.CHERRY_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item BAMBOO_CHEST_MINECART = register(ModItemIds.BAMBOO_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.BAMBOO_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));
    public static final Item PALE_OAK_CHEST_MINECART = register(ModItemIds.PALE_OAK_CHEST_MINECART, (properties) -> new MinecartItem(ModEntities.PALE_OAK_CHEST_MINECART, properties), new Item.Properties().stacksTo(1));

    // Miscellaneous

    public static final Item BRONZE_SWORD = register(ModItemIds.BRONZE_SWORD, Item::new, new Item.Properties().sword(ModToolMaterials.BRONZE, 3.0F, -2.4F));
    public static final Item BRONZE_SPEAR = register(ModItemIds.BRONZE_SPEAR, Item::new, new Item.Properties().spear(ModToolMaterials.BRONZE, 0.9F, 0.87F, 0.625F, 3.0F, 8.0F, 7.5F, 5.1F, 11.75F, 4.6F));
    public static final Item BRONZE_AXE = register(ModItemIds.BRONZE_AXE, Item::new, new Item.Properties().axe(ModToolMaterials.BRONZE, 7.0F, -3.2F));
    public static final Item BRONZE_SHOVEL = register(ModItemIds.BRONZE_SHOVEL, Item::new, new Item.Properties().shovel(ModToolMaterials.BRONZE, 1.5F, -3.0F));
    public static final Item BRONZE_PICKAXE = register(ModItemIds.BRONZE_PICKAXE, Item::new, new Item.Properties().pickaxe(ModToolMaterials.BRONZE, 7.0F, -3.2F));
    public static final Item BRONZE_HOE = register(ModItemIds.BRONZE_HOE, Item::new, new Item.Properties().hoe(ModToolMaterials.BRONZE, -1.0F, -2.0F));
    public static final Item BRONZE_HELMET = register(ModItemIds.BRONZE_HELMET, Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.HELMET));
    public static final Item BRONZE_CHESTPLATE = register(ModItemIds.BRONZE_CHESTPLATE, Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.CHESTPLATE));
    public static final Item BRONZE_LEGGINGS = register(ModItemIds.BRONZE_LEGGINGS, Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.LEGGINGS));
    public static final Item BRONZE_BOOTS = register(ModItemIds.BRONZE_BOOTS, Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BRONZE, ArmorType.BOOTS));
    public static final Item BRONZE_HORSE_ARMOR = register(ModItemIds.BRONZE_HORSE_ARMOR, Item::new, new Item.Properties().horseArmor(ModArmorMaterials.BRONZE));
    public static final Item BRONZE_NAUTILUS_ARMOR = register(ModItemIds.BRONZE_NAUTILUS_ARMOR, Item::new, new Item.Properties().nautilusArmor(ModArmorMaterials.BRONZE));
    public static final Item BRONZE_UPGRADE_SMITHING_TEMPLATE = register(ModItemIds.BRONZE_UPGRADE_SMITHING_TEMPLATE, ModSmithingTemplateItemConfig::createBronzeUpgradeTemplate, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item HEART_BANNER_PATTERN = register(ModItemIds.HEART_BANNER_PATTERN, Item::new, new Item.Properties().stacksTo(1).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, (context) -> context.getOrThrow(ModBannerPatternTags.PATTERN_ITEM_HEART)));
    public static final Item DIAMOND_BANNER_PATTERN = register(ModItemIds.DIAMOND_BANNER_PATTERN, Item::new, new Item.Properties().stacksTo(1).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, (context) -> context.getOrThrow(ModBannerPatternTags.PATTERN_ITEM_DIAMOND)));
    public static final Item SPADE_BANNER_PATTERN = register(ModItemIds.SPADE_BANNER_PATTERN, Item::new, new Item.Properties().stacksTo(1).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, (context) -> context.getOrThrow(ModBannerPatternTags.PATTERN_ITEM_SPADE)));
    public static final Item CLUB_BANNER_PATTERN = register(ModItemIds.CLUB_BANNER_PATTERN, Item::new, new Item.Properties().stacksTo(1).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, (context) -> context.getOrThrow(ModBannerPatternTags.PATTERN_ITEM_CLUB)));
    public static final Item MUSIC_DISC_CIRCUITRIC_MAGNET = register(ModItemIds.MUSIC_DISC_CIRCUITRIC_MAGNET, Item::new, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.CIRCUITRIC_MAGNET));
    public static final Item MUSIC_DISC_ANGRY_BOYFRIENDS = register(ModItemIds.MUSIC_DISC_ANGRY_BOYFRIENDS, Item::new, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.ANGRY_BOYFRIENDS));

    private static Item register(ResourceKey<Item> id, Function<Item.Properties, Item> function, Item.Properties properties) {
        Item item = function.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {

    }
}
