package github.theworksofbh.buildersparadise.id;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.sounds.ModJukeboxSongs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.function.UnaryOperator;

public class ModItemIds {

    public static final ResourceKey<Item> NETHERITE_NUGGET = create("netherite_nugget");
    public static final ResourceKey<Item> RAW_ZINC = create("raw_zinc");
    public static final ResourceKey<Item> ZINC_INGOT = create("zinc_ingot");
    public static final ResourceKey<Item> ZINC_NUGGET = create("zinc_nugget");
    public static final ResourceKey<Item> RAW_SILVER = create("raw_silver");
    public static final ResourceKey<Item> SILVER_INGOT = create("silver_ingot");
    public static final ResourceKey<Item> SILVER_NUGGET = create("silver_nugget");
    public static final ResourceKey<Item> RAW_TIN = create("raw_tin");
    public static final ResourceKey<Item> TIN_INGOT = create("tin_ingot");
    public static final ResourceKey<Item> TIN_NUGGET = create("tin_nugget");
    public static final ResourceKey<Item> RAW_TUNGSTEN = create("raw_tungsten");
    public static final ResourceKey<Item> TUNGSTEN_INGOT = create("tungsten_ingot");
    public static final ResourceKey<Item> TUNGSTEN_NUGGET = create("tungsten_nugget");
    public static final ResourceKey<Item> RAW_PLATINUM = create("raw_platinum");
    public static final ResourceKey<Item> PLATINUM_INGOT = create("platinum_ingot");
    public static final ResourceKey<Item> PLATINUM_NUGGET = create("platinum_nugget");
    public static final ResourceKey<Item> RAW_LEAD = create("raw_lead");
    public static final ResourceKey<Item> LEAD_INGOT = create("lead_ingot");
    public static final ResourceKey<Item> LEAD_NUGGET = create("lead_nugget");
    public static final ResourceKey<Item> RAW_BISMUTH = create("raw_bismuth");
    public static final ResourceKey<Item> BISMUTH_INGOT = create("bismuth_ingot");
    public static final ResourceKey<Item> BISMUTH_NUGGET = create("bismuth_nugget");
    public static final ResourceKey<Item> RAW_URANIUM = create("raw_uranium");
    public static final ResourceKey<Item> URANIUM_INGOT = create("uranium_ingot");
    public static final ResourceKey<Item> URANIUM_NUGGET = create("uranium_nugget");
    public static final ResourceKey<Item> BRONZE_INGOT = create("bronze_ingot");
    public static final ResourceKey<Item> BRONZE_NUGGET = create("bronze_nugget");
    public static final ResourceKey<Item> BRASS_INGOT = create("brass_ingot");
    public static final ResourceKey<Item> BRASS_NUGGET = create("brass_nugget");
    public static final ResourceKey<Item> STEEL_INGOT = create("steel_ingot");
    public static final ResourceKey<Item> STEEL_NUGGET = create("steel_nugget");
    public static final ResourceKey<Item> MONOCRYSTAL = create("monocrystal");
    public static final ResourceKey<Item> RUBY = create("ruby");
    public static final ResourceKey<Item> SAPPHIRE = create("sapphire");
    public static final ResourceKey<Item> SCULK_BRICK = create("sculk_brick");
    public static final ResourceKey<Item> STONE_BATON = create("stone_baton");
    public static final ResourceKey<Item> GRANITE_BATON = create("granite_baton");
    public static final ResourceKey<Item> DIORITE_BATON = create("diorite_baton");
    public static final ResourceKey<Item> ANDESITE_BATON = create("andesite_baton");
    public static final ResourceKey<Item> DEEPSLATE_BATON = create("deepslate_baton");
    public static final ResourceKey<Item> TUFF_BATON = create("tuff_baton");
    public static final ResourceKey<Item> GABBRO_BATON = create("gabbro_baton");
    public static final ResourceKey<Item> RHYOLITE_BATON = create("rhyolite_baton");
    public static final ResourceKey<Item> CALCITE_BATON = create("calcite_baton");
    public static final ResourceKey<Item> PACKED_MUD_BATON = create("packed_mud_baton");
    public static final ResourceKey<Item> SANDSTONE_BATON = create("sandstone_baton");
    public static final ResourceKey<Item> RED_SANDSTONE_BATON = create("red_sandstone_baton");
    public static final ResourceKey<Item> SOUL_SANDSTONE_BATON = create("soul_sandstone_baton");
    public static final ResourceKey<Item> CINNABAR_BATON = create("cinnabar_baton");
    public static final ResourceKey<Item> NETHERRACK_BATON = create("netherrack_baton");
    public static final ResourceKey<Item> BLACKSTONE_BATON = create("blackstone_baton");
    public static final ResourceKey<Item> BASALT_BATON = create("blackstone_baton");
    public static final ResourceKey<Item> PUMICE_BATON = create("pumice_baton");
    public static final ResourceKey<Item> END_STONE_BATON = create("end_stone_baton");
    public static final ResourceKey<Item> OBSIDIAN_BATON = create("obsidian_baton");
    public static final ResourceKey<Item> TERRACOTTA_BATON = create("terracotta_baton");
    public static final ResourceKey<Item> CONCRETE_BATON = create("concrete_baton");
    public static final ResourceKey<Item> ICE_SHARD = create("ice_shard");
    public static final ResourceKey<Item> ELDER_PRISMARINE_SHARD = create("elder_prismarine_shard");
    public static final ResourceKey<Item> ELDER_PRISMARINE_CRYSTALS = create("elder_prismarine_crystals");
    public static final ResourceKey<Item> CARBON_DUST = create("carbon_dust");
    public static final ResourceKey<Item> SILICON_DUST = create("silicon_dust");
    public static final ResourceKey<Item> EXPLOSIVE_ARROW = create("explosive_arrow");
    public static final ResourceKey<Item> SHARPENED_ARROW = create("sharpened_arrow");
    public static final ResourceKey<Item> STREAMLINED_ARROW = create("streamlined_arrow");
    public static final ResourceKey<Item> NUCLEAR_WASTE_BUCKET = create("nuclear_waste_bucket");
    public static final ResourceKey<Item> CRIMSON_BOAT = create("crimson_boat");
    public static final ResourceKey<Item> WARPED_BOAT = create("warped_boat");
    public static final ResourceKey<Item> CRIMSON_CHEST_BOAT = create("crimson_chest_boat");
    public static final ResourceKey<Item> WARPED_CHEST_BOAT = create("warped_chest_boat");
    public static final ResourceKey<Item> BLACKSTONE_FURNACE_MINECART = create("blackstone_furnace_minecart");
    public static final ResourceKey<Item> DEEPSLATE_FURNACE_MINECART = create("deepslate_furnace_minecart");
    public static final ResourceKey<Item> SPRUCE_CHEST_MINECART = create("spruce_chest_minecart");
    public static final ResourceKey<Item> BIRCH_CHEST_MINECART = create("birch_chest_minecart");
    public static final ResourceKey<Item> JUNGLE_CHEST_MINECART = create("jungle_chest_minecart");
    public static final ResourceKey<Item> ACACIA_CHEST_MINECART = create("acacia_chest_minecart");
    public static final ResourceKey<Item> DARK_OAK_CHEST_MINECART = create("dark_oak_chest_minecart");
    public static final ResourceKey<Item> CRIMSON_CHEST_MINECART = create("crimson_chest_minecart");
    public static final ResourceKey<Item> WARPED_CHEST_MINECART = create("warped_chest_minecart");
    public static final ResourceKey<Item> MANGROVE_CHEST_MINECART = create("mangrove_chest_minecart");
    public static final ResourceKey<Item> CHERRY_CHEST_MINECART = create("cherry_chest_minecart");
    public static final ResourceKey<Item> BAMBOO_CHEST_MINECART = create("bamboo_chest_minecart");
    public static final ResourceKey<Item> PALE_OAK_CHEST_MINECART = create("pale_oak_chest_minecart");
    public static final ResourceKey<Item> BRONZE_SWORD = create("bronze_sword");
    public static final ResourceKey<Item> BRONZE_SPEAR = create("bronze_spear");
    public static final ResourceKey<Item> BRONZE_AXE = create("bronze_axe");
    public static final ResourceKey<Item> BRONZE_SHOVEL = create("bronze_shovel");
    public static final ResourceKey<Item> BRONZE_PICKAXE = create("bronze_pickaxe");
    public static final ResourceKey<Item> BRONZE_HOE = create("bronze_how");
    public static final ResourceKey<Item> BRONZE_HELMET = create("bronze_helmet");
    public static final ResourceKey<Item> BRONZE_CHESTPLATE = create("bronze_chestplate");
    public static final ResourceKey<Item> BRONZE_LEGGINGS = create("bronze_leggings");
    public static final ResourceKey<Item> BRONZE_BOOTS = create("bronze_boots");
    public static final ResourceKey<Item> BRONZE_HORSE_ARMOR = create("bronze_horse_armor");
    public static final ResourceKey<Item> BRONZE_NAUTILUS_ARMOR = create("bronze_nautilus_armor");
    public static final ResourceKey<Item> BRONZE_UPGRADE_SMITHING_TEMPLATE = create("bronze_upgrade_smithing_template");
    public static final ResourceKey<Item> HEART_BANNER_PATTERN = create("heart_banner_pattern");
    public static final ResourceKey<Item> DIAMOND_BANNER_PATTERN = create("diamond_banner_pattern");
    public static final ResourceKey<Item> SPADE_BANNER_PATTERN = create("spade_banner_pattern");
    public static final ResourceKey<Item> CLUB_BANNER_PATTERN = create("club_banner_pattern");
    public static final ResourceKey<Item> MUSIC_DISC_CIRCUITRIC_MAGNET = createMusicDisc(ModJukeboxSongs.CIRCUITRIC_MAGNET);
    public static final ResourceKey<Item> MUSIC_DISC_ANGRY_BOYFRIENDS = createMusicDisc(ModJukeboxSongs.ANGRY_BOYFRIENDS);

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }

    private static ResourceKey<Item> createPotterySherd(final ResourceKey<DecoratedPotPattern> sherd) {
        return sherd.dependent(Registries.ITEM, "_pottery_sherd");
    }

    private static ResourceKey<Item> createArmorTrimSmithingTemplate(final ResourceKey<TrimPattern> template) {
        return template.dependent(Registries.ITEM, "_armor_trim_smithing_template");
    }

    private static ResourceKey<Item> createMusicDisc(final ResourceKey<JukeboxSong> music) {
        return music.dependent(Registries.ITEM, (UnaryOperator<String>)(path -> "music_disc_" + path));
    }

    private static ResourceKey<Item> createSpawnEgg(final ResourceKey<EntityType<?>> entity) {
        return entity.dependent(Registries.ITEM, "_spawn_egg");
    }

    private static ColorCollection<ResourceKey<Item>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModItemIds::create);
    }
}
