package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.sounds.ModJukeboxSongs;
import github.theworksofbh.buildersparadise.tags.ModBannerPatternTags;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BuildersParadise.MODID);

    public static final DeferredItem<BlockItem> POLISHED_GRANITE_WALL = registerBlockItem("polished_granite_wall", () -> ModBlocks.POLISHED_GRANITE_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_WALL = registerBlockItem("polished_diorite_wall", () -> ModBlocks.POLISHED_DIORITE_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_WALL = registerBlockItem("polished_andesite_wall", () -> ModBlocks.POLISHED_ANDESITE_WALL.get());
    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_WALL = registerBlockItem("prismarine_brick_wall", () -> ModBlocks.PRISMARINE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> DARK_PRISMARINE_WALL = registerBlockItem("dark_prismarine_wall", () -> ModBlocks.DARK_PRISMARINE_WALL.get());
    public static final DeferredItem<BlockItem> STONE_WALL = registerBlockItem("stone_wall", () -> ModBlocks.STONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_SANDSTONE_WALL = registerBlockItem("smooth_sandstone_wall", () -> ModBlocks.SMOOTH_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_RED_SANDSTONE_WALL = registerBlockItem("smooth_red_sandstone_wall", () -> ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> QUARTZ_WALL = registerBlockItem("quartz_wall", () -> ModBlocks.QUARTZ_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_QUARTZ_WALL = registerBlockItem("smooth_quartz_wall", () -> ModBlocks.SMOOTH_QUARTZ_WALL.get());
    public static final DeferredItem<BlockItem> PURPUR_WALL = registerBlockItem("purpur_wall", () -> ModBlocks.PURPUR_WALL.get());
    
    public static final DeferredItem<BlockItem> SMOOTH_STONE_STAIRS = registerBlockItem("smooth_stone_stairs", () -> ModBlocks.SMOOTH_STONE_STAIRS.get());
    public static final DeferredItem<BlockItem> SMOOTH_STONE_WALL = registerBlockItem("smooth_stone_wall", () -> ModBlocks.SMOOTH_STONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_SANDSTONE_STAIRS = registerBlockItem("cut_sandstone_stairs", () -> ModBlocks.CUT_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_SANDSTONE_WALL = registerBlockItem("cut_sandstone_wall", () -> ModBlocks.CUT_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_RED_SANDSTONE_STAIRS = registerBlockItem("cut_red_sandstone_stairs", () -> ModBlocks.CUT_RED_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_RED_SANDSTONE_WALL = registerBlockItem("cut_red_sandstone_wall", () -> ModBlocks.CUT_RED_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_STONE_BRICK_SLAB = registerBlockItem("cracked_stone_brick_slab", () -> ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_BRICK_STAIRS = registerBlockItem("cracked_stone_brick_stairs", () -> ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_BRICK_WALL = registerBlockItem("cracked_stone_brick_wall", () -> ModBlocks.CRACKED_STONE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> BASALT_SLAB = registerBlockItem("basalt_slab", () -> ModBlocks.BASALT_SLAB.get());
    public static final DeferredItem<BlockItem> BASALT_STAIRS = registerBlockItem("basalt_stairs", () -> ModBlocks.BASALT_STAIRS.get());
    public static final DeferredItem<BlockItem> BASALT_WALL = registerBlockItem("basalt_wall", () -> ModBlocks.BASALT_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_BASALT_SLAB = registerBlockItem("polished_basalt_slab", () -> ModBlocks.POLISHED_BASALT_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_BASALT_STAIRS = registerBlockItem("polished_basalt_stairs", () -> ModBlocks.POLISHED_BASALT_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_BASALT_WALL = registerBlockItem("polished_basalt_wall", () -> ModBlocks.POLISHED_BASALT_WALL.get());

    public static final DeferredItem<BlockItem> SMOOTH_BASALT_SLAB = registerBlockItem("smooth_basalt_slab", () -> ModBlocks.SMOOTH_BASALT_SLAB.get());
    public static final DeferredItem<BlockItem> SMOOTH_BASALT_STAIRS = registerBlockItem("smooth_basalt_stairs", () -> ModBlocks.SMOOTH_BASALT_STAIRS.get());
    public static final DeferredItem<BlockItem> SMOOTH_BASALT_WALL = registerBlockItem("smooth_basalt_wall", () -> ModBlocks.SMOOTH_BASALT_WALL.get());

    public static final DeferredItem<BlockItem> DEEPSLATE_SLAB = registerBlockItem("deepslate_slab", () -> ModBlocks.DEEPSLATE_SLAB.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_STAIRS = registerBlockItem("deepslate_stairs", () -> ModBlocks.DEEPSLATE_STAIRS.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_WALL = registerBlockItem("deepslate_wall", () -> ModBlocks.DEEPSLATE_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_BRICK_SLAB = registerBlockItem("cracked_deepslate_brick_slab", () -> ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_BRICK_STAIRS = registerBlockItem("cracked_deepslate_brick_stairs", () -> ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_BRICK_WALL = registerBlockItem("cracked_deepslate_brick_wall", () -> ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_TILE_SLAB = registerBlockItem("cracked_deepslate_tile_slab", () -> ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_TILE_STAIRS = registerBlockItem("cracked_deepslate_tile_stairs", () -> ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_TILE_WALL = registerBlockItem("cracked_deepslate_tile_wall", () -> ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_NETHER_BRICK_SLAB = registerBlockItem("cracked_nether_brick_slab", () -> ModBlocks.CRACKED_NETHER_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_NETHER_BRICK_STAIRS = registerBlockItem("cracked_nether_brick_stairs", () -> ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_NETHER_BRICK_WALL = registerBlockItem("cracked_nether_brick_wall", () -> ModBlocks.CRACKED_NETHER_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlockItem("cracked_polished_blackstone_brick_slab", () -> ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlockItem("cracked_polished_blackstone_brick_stairs", () -> ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = registerBlockItem("cracked_polished_blackstone_brick_wall", () -> ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> NETHERRACK_SLAB = registerBlockItem("netherrack_slab", () -> ModBlocks.NETHERRACK_SLAB.get());
    public static final DeferredItem<BlockItem> NETHERRACK_STAIRS = registerBlockItem("netherrack_stairs", () -> ModBlocks.NETHERRACK_STAIRS.get());
    public static final DeferredItem<BlockItem> NETHERRACK_WALL = registerBlockItem("netherrack_wall", () -> ModBlocks.NETHERRACK_WALL.get());

    public static final DeferredItem<BlockItem> CALCITE_SLAB = registerBlockItem("calcite_slab", () -> ModBlocks.CALCITE_SLAB.get());
    public static final DeferredItem<BlockItem> CALCITE_STAIRS = registerBlockItem("calcite_stairs", () -> ModBlocks.CALCITE_STAIRS.get());
    public static final DeferredItem<BlockItem> CALCITE_WALL = registerBlockItem("calcite_wall", () -> ModBlocks.CALCITE_WALL.get());

    public static final DeferredItem<BlockItem> DRIPSTONE_SLAB = registerBlockItem("dripstone_slab", () -> ModBlocks.DRIPSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_STAIRS = registerBlockItem("dripstone_stairs", () -> ModBlocks.DRIPSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_WALL = registerBlockItem("dripstone_wall", () -> ModBlocks.DRIPSTONE_WALL.get());

    public static final DeferredItem<BlockItem> END_STONE_SLAB = registerBlockItem("end_stone_slab", () -> ModBlocks.END_STONE_SLAB.get());
    public static final DeferredItem<BlockItem> END_STONE_STAIRS = registerBlockItem("end_stone_stairs", () -> ModBlocks.END_STONE_STAIRS.get());
    public static final DeferredItem<BlockItem> END_STONE_WALL = registerBlockItem("end_stone_wall", () -> ModBlocks.END_STONE_WALL.get());

    public static final DeferredItem<BlockItem> QUARTZ_BRICK_SLAB = registerBlockItem("quartz_brick_slab", () -> ModBlocks.QUARTZ_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> QUARTZ_BRICK_STAIRS = registerBlockItem("quartz_brick_stairs", () -> ModBlocks.QUARTZ_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> QUARTZ_BRICK_WALL = registerBlockItem("quartz_brick_wall", () -> ModBlocks.QUARTZ_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> PACKED_MUD_SLAB = registerBlockItem("packed_mud_slab", () -> ModBlocks.PACKED_MUD_SLAB.get());
    public static final DeferredItem<BlockItem> PACKED_MUD_STAIRS = registerBlockItem("packed_mud_stairs", () -> ModBlocks.PACKED_MUD_STAIRS.get());
    public static final DeferredItem<BlockItem> PACKED_MUD_WALL = registerBlockItem("packed_mud_wall", () -> ModBlocks.PACKED_MUD_WALL.get());

    public static final DeferredItem<BlockItem> RESIN_SLAB = registerBlockItem("resin_slab", () -> ModBlocks.RESIN_SLAB.get());
    public static final DeferredItem<BlockItem> RESIN_STAIRS = registerBlockItem("resin_stairs", () -> ModBlocks.RESIN_STAIRS.get());
    public static final DeferredItem<BlockItem> RESIN_WALL = registerBlockItem("resin_wall", () -> ModBlocks.RESIN_WALL.get());

    public static final DeferredItem<BlockItem> CUT_IRON = registerBlockItem("cut_iron", () -> ModBlocks.CUT_IRON.get());
    public static final DeferredItem<BlockItem> CUT_IRON_SLAB = registerBlockItem("cut_iron_slab", () -> ModBlocks.CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_IRON_STAIRS = registerBlockItem("cut_iron_stairs", () -> ModBlocks.CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> EXPOSED_CUT_IRON = registerBlockItem("exposed_cut_iron", () -> ModBlocks.EXPOSED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> EXPOSED_CUT_IRON_SLAB = registerBlockItem("exposed_cut_iron_slab", () -> ModBlocks.EXPOSED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> EXPOSED_CUT_IRON_STAIRS = registerBlockItem("exposed_cut_iron_stairs", () -> ModBlocks.EXPOSED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> WEATHERED_CUT_IRON = registerBlockItem("weathered_cut_iron", () -> ModBlocks.WEATHERED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> WEATHERED_CUT_IRON_SLAB = registerBlockItem("weathered_cut_iron_slab", () -> ModBlocks.WEATHERED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> WEATHERED_CUT_IRON_STAIRS = registerBlockItem("weathered_cut_iron_stairs", () -> ModBlocks.WEATHERED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> RUSTED_CUT_IRON = registerBlockItem("rusted_cut_iron", () -> ModBlocks.RUSTED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> RUSTED_CUT_IRON_SLAB = registerBlockItem("rusted_cut_iron_slab", () -> ModBlocks.RUSTED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> RUSTED_CUT_IRON_STAIRS = registerBlockItem("rusted_cut_iron_stairs", () -> ModBlocks.RUSTED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_CUT_IRON = registerBlockItem("waxed_cut_iron", () -> ModBlocks.WAXED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_CUT_IRON_SLAB = registerBlockItem("waxed_cut_iron_slab", () -> ModBlocks.WAXED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_CUT_IRON_STAIRS = registerBlockItem("waxed_cut_iron_stairs", () -> ModBlocks.WAXED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_IRON = registerBlockItem("waxed_exposed_cut_iron", () -> ModBlocks.WAXED_EXPOSED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_IRON_SLAB = registerBlockItem("waxed_exposed_cut_iron_slab", () -> ModBlocks.WAXED_EXPOSED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_IRON_STAIRS = registerBlockItem("waxed_exposed_cut_iron_stairs", () -> ModBlocks.WAXED_EXPOSED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_IRON = registerBlockItem("waxed_weathered_cut_iron", () -> ModBlocks.WAXED_WEATHERED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_IRON_SLAB = registerBlockItem("waxed_weathered_cut_iron_slab", () -> ModBlocks.WAXED_WEATHERED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_IRON_STAIRS = registerBlockItem("waxed_weathered_cut_iron_stairs", () -> ModBlocks.WAXED_WEATHERED_CUT_IRON_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_RUSTED_CUT_IRON = registerBlockItem("waxed_rusted_cut_iron", () -> ModBlocks.WAXED_RUSTED_CUT_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_CUT_IRON_SLAB = registerBlockItem("waxed_rusted_cut_iron_slab", () -> ModBlocks.WAXED_RUSTED_CUT_IRON_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_CUT_IRON_STAIRS = registerBlockItem("waxed_rusted_cut_iron_stairs", () -> ModBlocks.WAXED_RUSTED_CUT_COPPER_STAIRS.get());

    public static final DeferredItem<BlockItem> CUT_GOLD = registerBlockItem("cut_gold", () -> ModBlocks.CUT_GOLD.get());
    public static final DeferredItem<BlockItem> CUT_GOLD_SLAB = registerBlockItem("cut_gold_slab", () -> ModBlocks.CUT_GOLD_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_GOLD_STAIRS = registerBlockItem("cut_gold_stairs", () -> ModBlocks.CUT_GOLD_STAIRS.get());

    public static final DeferredItem<BlockItem> CUT_DIAMOND = registerBlockItem("cut_diamond", () -> ModBlocks.CUT_DIAMOND.get());
    public static final DeferredItem<BlockItem> CUT_DIAMOND_SLAB = registerBlockItem("cut_diamond_slab", () -> ModBlocks.CUT_DIAMOND_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_DIAMOND_STAIRS = registerBlockItem("cut_diamond_stairs", () -> ModBlocks.CUT_DIAMOND_STAIRS.get());

    public static final DeferredItem<BlockItem> CUT_EMERALD = registerBlockItem("cut_emerald", () -> ModBlocks.CUT_EMERALD.get());
    public static final DeferredItem<BlockItem> CUT_EMERALD_SLAB = registerBlockItem("cut_emerald_slab", () -> ModBlocks.CUT_EMERALD_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_EMERALD_STAIRS = registerBlockItem("cut_emerald_stairs", () -> ModBlocks.CUT_EMERALD_SLAB.get());

    public static final DeferredItem<BlockItem> CUT_NETHERITE = registerBlockItem("cut_netherite", () -> ModBlocks.CUT_NETHERITE.get());
    public static final DeferredItem<BlockItem> CUT_NETHERITE_SLAB = registerBlockItem("cut_netherite_slab", () -> ModBlocks.CUT_NETHERITE_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_NETHERITE_STAIRS = registerBlockItem("cut_netherite_stairs", () -> ModBlocks.CUT_NETHERITE_STAIRS.get());

    public static final DeferredItem<BlockItem> MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("medium_weighted_pressure_plate", () -> ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("exposed_medium_weighted_pressure_plate", () -> ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("weathered_medium_weighted_pressure_plate", () -> ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("oxidized_medium_weighted_pressure_plate", () -> ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_exposed_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_weathered_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_oxidized_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON = registerBlockItem("exposed_iron", () -> ModBlocks.EXPOSED_IRON.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON = registerBlockItem("weathered_iron", () -> ModBlocks.WEATHERED_IRON.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON = registerBlockItem("rusted_iron", () -> ModBlocks.RUSTED_IRON.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_BLOCK = registerBlockItem("waxed_iron_block", () -> ModBlocks.WAXED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON = registerBlockItem("waxed_exposed_iron", () -> ModBlocks.WAXED_EXPOSED_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON = registerBlockItem("waxed_weathered_iron", () -> ModBlocks.WAXED_WEATHERED_IRON.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON = registerBlockItem("waxed_rusted_iron", () -> ModBlocks.WAXED_RUSTED_IRON.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_DOOR = registerBlockItem("exposed_iron_door", () -> ModBlocks.EXPOSED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_DOOR = registerBlockItem("weathered_iron_door", () -> ModBlocks.WEATHERED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_DOOR = registerBlockItem("rusted_iron_door", () -> ModBlocks.RUSTED_IRON_DOOR.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_DOOR = registerBlockItem("waxed_iron_door", () -> ModBlocks.WAXED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_DOOR = registerBlockItem("waxed_exposed_iron_door", () -> ModBlocks.WAXED_EXPOSED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_DOOR = registerBlockItem("waxed_weathered_iron_door", () -> ModBlocks.WAXED_WEATHERED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_DOOR = registerBlockItem("waxed_rusted_iron_door", () -> ModBlocks.WAXED_RUSTED_IRON_DOOR.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_TRAPDOOR = registerBlockItem("exposed_iron_trapdoor", () -> ModBlocks.EXPOSED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_TRAPDOOR = registerBlockItem("weathered_iron_trapdoor", () -> ModBlocks.WEATHERED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_TRAPDOOR = registerBlockItem("rusted_iron_trapdoor", () -> ModBlocks.RUSTED_IRON_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_TRAPDOOR = registerBlockItem("waxed_iron_trapdoor", () -> ModBlocks.WAXED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_TRAPDOOR = registerBlockItem("waxed_exposed_iron_trapdoor", () -> ModBlocks.WAXED_EXPOSED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_TRAPDOOR = registerBlockItem("waxed_weathered_iron_trapdoor", () -> ModBlocks.WAXED_WEATHERED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_TRAPDOOR = registerBlockItem("waxed_rusted_iron_trapdoor", () -> ModBlocks.WAXED_RUSTED_IRON_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("exposed_heavy_weighted_pressure_plate", () -> ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("weathered_heavy_weighted_pressure_plate", () -> ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("rusted_heavy_weighted_pressure_plate", () -> ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_exposed_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_weathered_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_BARS = registerBlockItem("exposed_iron_bars", () -> ModBlocks.EXPOSED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_BARS = registerBlockItem("weathered_iron_bars", () -> ModBlocks.WEATHERED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_BARS = registerBlockItem("rusted_iron_bars", () -> ModBlocks.RUSTED_IRON_BARS.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_BARS = registerBlockItem("waxed_iron_bars", () -> ModBlocks.WAXED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_BARS = registerBlockItem("waxed_exposed_iron_bars", () -> ModBlocks.WAXED_EXPOSED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_BARS = registerBlockItem("waxed_weathered_iron_bars", () -> ModBlocks.WAXED_WEATHERED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_BARS = registerBlockItem("waxed_rusted_iron_bars", () -> ModBlocks.WAXED_RUSTED_IRON_BARS.get());

    public static final DeferredItem<BlockItem> GOLD_DOOR = registerBlockItem("gold_door", () -> ModBlocks.GOLD_DOOR.get());
    public static final DeferredItem<BlockItem> GOLD_TRAPDOOR = registerBlockItem("gold_trapdoor", () -> ModBlocks.GOLD_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> NETHERITE_DOOR = registerBlockItem("netherite_door", () -> ModBlocks.NETHERITE_DOOR.get());
    public static final DeferredItem<BlockItem> NETHERITE_TRAPDOOR = registerBlockItem("netherite_trapdoor", () -> ModBlocks.NETHERITE_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> PLAYER_ONLY_PRESSURE_PLATE = registerBlockItem("player_only_pressure_plate", () -> ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> POLISHED_CALCITE = registerBlockItem("polished_calcite", () -> ModBlocks.POLISHED_CALCITE.get());
    public static final DeferredItem<BlockItem> POLISHED_CALCITE_SLAB = registerBlockItem("polished_calcite_slab", () -> ModBlocks.POLISHED_CALCITE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_CALCITE_STAIRS = registerBlockItem("polished_calcite_stairs", () -> ModBlocks.POLISHED_CALCITE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_CALCITE_WALL = registerBlockItem("polished_calcite_wall", () -> ModBlocks.POLISHED_CALCITE_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_DRIPSTONE = registerBlockItem("polished_dripstone", () -> ModBlocks.POLISHED_DRIPSTONE.get());
    public static final DeferredItem<BlockItem> POLISHED_DRIPSTONE_SLAB = registerBlockItem("polished_dripstone_slab", () -> ModBlocks.POLISHED_DRIPSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_DRIPSTONE_STAIRS = registerBlockItem("polished_dripstone_stairs", () -> ModBlocks.POLISHED_DRIPSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_DRIPSTONE_WALL = registerBlockItem("polished_dripstone_wall", () -> ModBlocks.POLISHED_DRIPSTONE_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_GRANITE_BRICKS = registerBlockItem("polished_granite_bricks", () -> ModBlocks.POLISHED_GRANITE_BRICKS.get());
    public static final DeferredItem<BlockItem> POLISHED_GRANITE_BRICK_SLAB = registerBlockItem("polished_granite_brick_slab", () -> ModBlocks.POLISHED_GRANITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_GRANITE_BRICK_STAIRS = registerBlockItem("polished_granite_brick_stairs", () -> ModBlocks.POLISHED_GRANITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_GRANITE_BRICK_WALL = registerBlockItem("polished_granite_brick_wall", () -> ModBlocks.POLISHED_GRANITE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_DIORITE_BRICKS = registerBlockItem("polished_diorite_bricks", () -> ModBlocks.POLISHED_DIORITE_BRICKS.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_BRICK_SLAB = registerBlockItem("polished_diorite_brick_slab", () -> ModBlocks.POLISHED_DIORITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_BRICK_STAIRS = registerBlockItem("polished_diorite_brick_stairs", () -> ModBlocks.POLISHED_DIORITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_BRICK_WALL = registerBlockItem("polished_diorite_brick_wall", () -> ModBlocks.POLISHED_DIORITE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_BRICKS = registerBlockItem("polished_andesite_bricks", () -> ModBlocks.POLISHED_ANDESITE_BRICKS.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_BRICK_SLAB = registerBlockItem("polished_andesite_brick_slab", () -> ModBlocks.POLISHED_ANDESITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_BRICK_STAIRS = registerBlockItem("polished_andesite_brick_stairs", () -> ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_BRICK_WALL = registerBlockItem("polished_andesite_brick_wall", () -> ModBlocks.POLISHED_ANDESITE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CALCITE_BRICKS = registerBlockItem("calcite_bricks", () -> ModBlocks.CALCITE_BRICKS.get());
    public static final DeferredItem<BlockItem> CALCITE_BRICK_SLAB = registerBlockItem("calcite_brick_slab", () -> ModBlocks.CALCITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CALCITE_BRICK_STAIRS = registerBlockItem("calcite_brick_stairs", () -> ModBlocks.CALCITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CALCITE_BRICK_WALL = registerBlockItem("calcite_brick_wall", () -> ModBlocks.CALCITE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> DRIPSTONE_BRICKS = registerBlockItem("dripstone_bricks", () -> ModBlocks.DRIPSTONE_BRICKS.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_BRICK_SLAB = registerBlockItem("dripstone_brick_slab", () -> ModBlocks.DRIPSTONE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_BRICK_STAIRS = registerBlockItem("dripstone_brick_stairs", () -> ModBlocks.DRIPSTONE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_BRICK_WALL = registerBlockItem("dripstone_brick_wall", () -> ModBlocks.DRIPSTONE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> BASALT_BRICKS = registerBlockItem("basalt_bricks", () -> ModBlocks.BASALT_BRICKS.get());
    public static final DeferredItem<BlockItem> BASALT_BRICK_SLAB = registerBlockItem("basalt_brick_slab", () -> ModBlocks.BASALT_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BASALT_BRICK_STAIRS = registerBlockItem("basalt_brick_stairs", () -> ModBlocks.BASALT_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BASALT_BRICK_WALL = registerBlockItem("basalt_brick_wall", () -> ModBlocks.BASALT_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CHARCOAL_BLOCK = registerBlockItem("charcoal_block", () -> ModBlocks.CHARCOAL_BLOCK.get());

    public static final DeferredItem<BlockItem> SOUL_SANDSTONE = registerBlockItem("soul_sandstone", () -> ModBlocks.SOUL_SANDSTONE.get());
    public static final DeferredItem<BlockItem> SOUL_SANDSTONE_SLAB = registerBlockItem("soul_sandstone_slab", () -> ModBlocks.SOUL_SANDSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> SOUL_SANDSTONE_STAIRS = registerBlockItem("soul_sandstone_stairs", () -> ModBlocks.SOUL_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> SOUL_SANDSTONE_WALL = registerBlockItem("soul_sandstone_wall", () -> ModBlocks.SOUL_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_SOUL_SANDSTONE = registerBlockItem("cut_soul_sandstone", () -> ModBlocks.CUT_SOUL_SANDSTONE.get());
    public static final DeferredItem<BlockItem> CUT_SOUL_SANDSTONE_SLAB = registerBlockItem("cut_soul_sandstone_slab", () -> ModBlocks.CUT_SOUL_SANDSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_SOUL_SANDSTONE_STAIRS = registerBlockItem("cut_soul_sandstone_stairs", () -> ModBlocks.CUT_SOUL_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_SOUL_SANDSTONE_WALL = registerBlockItem("cut_soul_sandstone_wall", () -> ModBlocks.CUT_SOUL_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> SMOOTH_SOUL_SANDSTONE = registerBlockItem("smooth_soul_sandstone", () -> ModBlocks.SMOOTH_SOUL_SANDSTONE.get());
    public static final DeferredItem<BlockItem> SMOOTH_SOUL_SANDSTONE_SLAB = registerBlockItem("smooth_soul_sandstone_slab", () -> ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> SMOOTH_SOUL_SANDSTONE_STAIRS = registerBlockItem("smooth_soul_sandstone_stairs", () -> ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> SMOOTH_SOUL_SANDSTONE_WALL = registerBlockItem("smooth_soul_sandstone_wall", () -> ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CHISELED_SOUL_SANDSTONE = registerBlockItem("chiseled_soul_sandstone", () -> ModBlocks.CHISELED_SOUL_SANDSTONE.get());

    public static final DeferredItem<BlockItem> ELDER_PRISMARINE = registerBlockItem("elder_prismarine", () -> ModBlocks.ELDER_PRISMARINE.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_SLAB = registerBlockItem("elder_prismarine_slab", () -> ModBlocks.ELDER_PRISMARINE_SLAB.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_STAIRS = registerBlockItem("elder_prismarine_stairs", () -> ModBlocks.ELDER_PRISMARINE_STAIRS.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_WALL = registerBlockItem("elder_prismarine_wall", () -> ModBlocks.ELDER_PRISMARINE_WALL.get());

    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_BRICKS = registerBlockItem("elder_prismarine_bricks", () -> ModBlocks.ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_BRICK_SLAB = registerBlockItem("elder_prismarine_brick_slab", () -> ModBlocks.ELDER_PRISMARINE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_BRICK_STAIRS = registerBlockItem("elder_prismarine_brick_stairs", () -> ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_BRICK_WALL = registerBlockItem("elder_prismarine_brick_wall", () -> ModBlocks.ELDER_PRISMARINE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> DARK_ELDER_PRISMARINE = registerBlockItem("dark_elder_prismarine", () -> ModBlocks.DARK_ELDER_PRISMARINE.get());
    public static final DeferredItem<BlockItem> DARK_ELDER_PRISMARINE_SLAB = registerBlockItem("dark_elder_prismarine_slab", () -> ModBlocks.DARK_ELDER_PRISMARINE_SLAB.get());
    public static final DeferredItem<BlockItem> DARK_ELDER_PRISMARINE_STAIRS = registerBlockItem("dark_elder_prismarine_stairs", () -> ModBlocks.DARK_ELDER_PRISMARINE_STAIRS.get());
    public static final DeferredItem<BlockItem> DARK_ELDER_PRISMARINE_WALL = registerBlockItem("dark_elder_prismarine_wall", () -> ModBlocks.DARK_ELDER_PRISMARINE_WALL.get());

    public static final DeferredItem<BlockItem> ELDER_SEA_LANTERN = registerBlockItem("elder_sea_lantern", () -> ModBlocks.ELDER_SEA_LANTERN.get());

    public static final DeferredItem<Item> ELDER_PRISMARINE_SHARD = registerCustomItem("elder_prismarine_shard");
    public static final DeferredItem<Item> ELDER_PRISMARINE_CRYSTALS = registerCustomItem("elder_prismarine_crystals");

//    public static final DeferredItem<Item> COPPER_NUGGET = registerCustomItem("copper_nugget"); Got added to vanilla, ripbozo
    public static final DeferredItem<Item> NETHERITE_NUGGET = registerCustomItem("netherite_nugget");

    public static final DeferredItem<BlockItem> ZINC_ORE = registerBlockItem("zinc_ore", () -> ModBlocks.ZINC_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_ZINC_ORE = registerBlockItem("deepslate_zinc_ore", () -> ModBlocks.DEEPSLATE_ZINC_ORE.get());
    public static final DeferredItem<BlockItem> RAW_ZINC_BLOCK = registerBlockItem("raw_zinc_block", () -> ModBlocks.RAW_ZINC_BLOCK.get());
    public static final DeferredItem<Item> RAW_ZINC = registerCustomItem("raw_zinc");
    public static final DeferredItem<Item> ZINC_INGOT = registerTrimmableItem("zinc_ingot", ModTrimMaterials.ZINC);
    public static final DeferredItem<Item> ZINC_NUGGET = registerCustomItem("zinc_nugget");

    public static final DeferredItem<BlockItem> ZINC_BLOCK = registerBlockItem("zinc_block", () -> ModBlocks.ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_ZINC = registerBlockItem("cut_zinc", () -> ModBlocks.CUT_ZINC.get());
    public static final DeferredItem<BlockItem> CUT_ZINC_SLAB = registerBlockItem("cut_zinc_slab", () -> ModBlocks.CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_ZINC_STAIRS = registerBlockItem("cut_zinc_stairs", () -> ModBlocks.CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> ZINC_DOOR = registerBlockItem("zinc_door", () -> ModBlocks.ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> ZINC_TRAPDOOR = registerBlockItem("zinc_trapdoor", () -> ModBlocks.ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("barely_heavy_weighted_pressure_plate", () -> ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> EXPOSED_ZINC = registerBlockItem("exposed_zinc", () -> ModBlocks.EXPOSED_ZINC.get());
    public static final DeferredItem<BlockItem> EXPOSED_CUT_ZINC = registerBlockItem("exposed_cut_zinc", () -> ModBlocks.EXPOSED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> EXPOSED_CUT_ZINC_SLAB = registerBlockItem("exposed_cut_zinc_slab", () -> ModBlocks.EXPOSED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> EXPOSED_CUT_ZINC_STAIRS = registerBlockItem("exposed_cut_zinc_stairs", () -> ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> EXPOSED_ZINC_DOOR = registerBlockItem("exposed_zinc_door", () -> ModBlocks.EXPOSED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> EXPOSED_ZINC_TRAPDOOR = registerBlockItem("exposed_zinc_trapdoor", () -> ModBlocks.EXPOSED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("exposed_barely_heavy_weighted_pressure_plate", () -> ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WEATHERED_ZINC = registerBlockItem("weathered_zinc", () -> ModBlocks.WEATHERED_ZINC.get());
    public static final DeferredItem<BlockItem> WEATHERED_CUT_ZINC = registerBlockItem("weathered_cut_zinc", () -> ModBlocks.WEATHERED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> WEATHERED_CUT_ZINC_SLAB = registerBlockItem("weathered_cut_zinc_slab", () -> ModBlocks.WEATHERED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> WEATHERED_CUT_ZINC_STAIRS = registerBlockItem("weathered_cut_zinc_stairs", () -> ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> WEATHERED_ZINC_DOOR = registerBlockItem("weathered_zinc_door", () -> ModBlocks.WEATHERED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WEATHERED_ZINC_TRAPDOOR = registerBlockItem("weathered_zinc_trapdoor", () -> ModBlocks.WEATHERED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("weathered_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> CORRODED_ZINC = registerBlockItem("corroded_zinc", () -> ModBlocks.CORRODED_ZINC.get());
    public static final DeferredItem<BlockItem> CORRODED_CUT_ZINC = registerBlockItem("corroded_cut_zinc", () -> ModBlocks.CORRODED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> CORRODED_CUT_ZINC_SLAB = registerBlockItem("corroded_cut_zinc_slab", () -> ModBlocks.CORRODED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> CORRODED_CUT_ZINC_STAIRS = registerBlockItem("corroded_cut_zinc_stairs", () -> ModBlocks.CORRODED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> CORRODED_ZINC_DOOR = registerBlockItem("corroded_zinc_door", () -> ModBlocks.CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> CORRODED_ZINC_TRAPDOOR = registerBlockItem("corroded_zinc_trapdoor", () -> ModBlocks.CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_ZINC_BLOCK = registerBlockItem("waxed_zinc_block", () -> ModBlocks.WAXED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_CUT_ZINC = registerBlockItem("waxed_cut_zinc", () -> ModBlocks.WAXED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_CUT_ZINC_SLAB = registerBlockItem("waxed_cut_zinc_slab", () -> ModBlocks.WAXED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_CUT_ZINC_STAIRS = registerBlockItem("waxed_cut_zinc_stairs", () -> ModBlocks.WAXED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_DOOR = registerBlockItem("waxed_zinc_door", () -> ModBlocks.WAXED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_TRAPDOOR = registerBlockItem("waxed_zinc_trapdoor", () -> ModBlocks.WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC = registerBlockItem("waxed_exposed_zinc", () -> ModBlocks.WAXED_EXPOSED_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_ZINC = registerBlockItem("waxed_exposed_cut_zinc", () -> ModBlocks.WAXED_EXPOSED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_ZINC_SLAB = registerBlockItem("waxed_exposed_cut_zinc_slab", () -> ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_CUT_ZINC_STAIRS = registerBlockItem("waxed_exposed_cut_zinc_stairs", () -> ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC_DOOR = registerBlockItem("waxed_exposed_zinc_door", () -> ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC_TRAPDOOR = registerBlockItem("waxed_exposed_zinc_trapdoor", () -> ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_exposed_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC = registerBlockItem("waxed_weathered_zinc", () -> ModBlocks.WAXED_WEATHERED_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_ZINC = registerBlockItem("waxed_weathered_cut_zinc", () -> ModBlocks.WAXED_WEATHERED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_ZINC_SLAB = registerBlockItem("waxed_weathered_cut_zinc_slab", () -> ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_CUT_ZINC_STAIRS = registerBlockItem("waxed_weathered_cut_zinc_stairs", () -> ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC_DOOR = registerBlockItem("waxed_weathered_zinc_door", () -> ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC_TRAPDOOR = registerBlockItem("waxed_weathered_zinc_trapdoor", () -> ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_weathered_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC = registerBlockItem("waxed_corroded_zinc", () -> ModBlocks.WAXED_CORRODED_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_CUT_ZINC = registerBlockItem("waxed_corroded_cut_zinc", () -> ModBlocks.WAXED_CORRODED_CUT_ZINC.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_CUT_ZINC_SLAB = registerBlockItem("waxed_corroded_cut_zinc_slab", () -> ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_CUT_ZINC_STAIRS = registerBlockItem("waxed_corroded_cut_zinc_stairs", () -> ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC_DOOR = registerBlockItem("waxed_corroded_zinc_door", () -> ModBlocks.WAXED_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC_TRAPDOOR = registerBlockItem("waxed_corroded_zinc_trapdoor", () -> ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> SILVER_ORE = registerBlockItem("silver_ore", () -> ModBlocks.SILVER_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE = registerBlockItem("deepslate_silver_ore", () -> ModBlocks.DEEPSLATE_SILVER_ORE.get());
    public static final DeferredItem<BlockItem> RAW_SILVER_BLOCK = registerBlockItem("raw_silver_block", () -> ModBlocks.RAW_SILVER_BLOCK.get());
    public static final DeferredItem<Item> RAW_SILVER = registerCustomItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = registerTrimmableItem("silver_ingot", ModTrimMaterials.SILVER);
    public static final DeferredItem<Item> SILVER_NUGGET = registerCustomItem("silver_nugget");

    public static final DeferredItem<BlockItem> SILVER_BLOCK = registerBlockItem("silver_block", () -> ModBlocks.SILVER_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_SILVER = registerBlockItem("cut_silver", () -> ModBlocks.CUT_SILVER.get());
    public static final DeferredItem<BlockItem> CUT_SILVER_SLAB = registerBlockItem("cut_silver_slab", () -> ModBlocks.CUT_SILVER_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_SILVER_STAIRS = registerBlockItem("cut_silver_stairs", () -> ModBlocks.CUT_SILVER_STAIRS.get());
    public static final DeferredItem<BlockItem> SILVER_DOOR = registerBlockItem("silver_door", () -> ModBlocks.SILVER_DOOR.get());
    public static final DeferredItem<BlockItem> SILVER_TRAPDOOR = registerBlockItem("silver_trapdoor", () -> ModBlocks.SILVER_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerBlockItem("noticeably_light_weighted_pressure_plate", () -> ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> TIN_ORE = registerBlockItem("tin_ore", () -> ModBlocks.TIN_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE = registerBlockItem("deepslate_tin_ore", () -> ModBlocks.DEEPSLATE_TIN_ORE.get());
    public static final DeferredItem<BlockItem> RAW_TIN_BLOCK = registerBlockItem("raw_tin_block", () -> ModBlocks.RAW_TIN_BLOCK.get());
    public static final DeferredItem<Item> RAW_TIN = registerCustomItem("raw_tin");
    public static final DeferredItem<Item> TIN_INGOT = registerTrimmableItem("tin_ingot", ModTrimMaterials.TIN);
    public static final DeferredItem<Item> TIN_NUGGET = registerCustomItem("tin_nugget");

    public static final DeferredItem<BlockItem> TIN_BLOCK = registerBlockItem("tin_block", () -> ModBlocks.TIN_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_TIN = registerBlockItem("cut_tin", () -> ModBlocks.CUT_TIN.get());
    public static final DeferredItem<BlockItem> CUT_TIN_SLAB = registerBlockItem("cut_tin_slab", () -> ModBlocks.CUT_TIN_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_TIN_STAIRS = registerBlockItem("cut_tin_stairs", () -> ModBlocks.CUT_TIN_STAIRS.get());
    public static final DeferredItem<BlockItem> TIN_DOOR = registerBlockItem("tin_door", () -> ModBlocks.TIN_DOOR.get());
    public static final DeferredItem<BlockItem> TIN_TRAPDOOR = registerBlockItem("tin_trapdoor", () -> ModBlocks.TIN_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerBlockItem("barely_light_weighted_pressure_plate", () -> ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> TUNGSTEN_ORE = registerBlockItem("tungsten_ore", () -> ModBlocks.TUNGSTEN_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_TUNGSTEN_ORE = registerBlockItem("deepslate_tungsten_ore", () -> ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
    public static final DeferredItem<BlockItem> RAW_TUNGSTEN_BLOCK = registerBlockItem("raw_tungsten_block", () -> ModBlocks.RAW_TUNGSTEN_BLOCK.get());
    public static final DeferredItem<Item> RAW_TUNGSTEN = registerCustomItem("raw_tungsten");
    public static final DeferredItem<Item> TUNGSTEN_INGOT = registerTrimmableItem("tungsten_ingot", ModTrimMaterials.TUNGSTEN);
    public static final DeferredItem<Item> TUNGSTEN_NUGGET = registerCustomItem("tungsten_nugget");

    public static final DeferredItem<BlockItem> TUNGSTEN_BLOCK = registerBlockItem("tungsten_block", () -> ModBlocks.TUNGSTEN_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_TUNGSTEN = registerBlockItem("cut_tungsten", () -> ModBlocks.CUT_TUNGSTEN.get());
    public static final DeferredItem<BlockItem> CUT_TUNGSTEN_SLAB = registerBlockItem("cut_tungsten_slab", () -> ModBlocks.CUT_TUNGSTEN_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_TUNGSTEN_STAIRS = registerBlockItem("cut_tungsten_stairs", () -> ModBlocks.CUT_TUNGSTEN_STAIRS.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_DOOR = registerBlockItem("tungsten_door", () -> ModBlocks.TUNGSTEN_DOOR.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_TRAPDOOR = registerBlockItem("tungsten_trapdoor", () -> ModBlocks.TUNGSTEN_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("extraordinarily_heavy_weighted_pressure_plate", () -> ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> PLATINUM_ORE = registerBlockItem("platinum_ore", () -> ModBlocks.PLATINUM_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_PLATINUM_ORE = registerBlockItem("deepslate_platinum_ore", () -> ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
    public static final DeferredItem<BlockItem> RAW_PLATINUM_BLOCK = registerBlockItem("raw_platinum_block", () -> ModBlocks.RAW_PLATINUM_BLOCK.get());
    public static final DeferredItem<Item> RAW_PLATINUM = registerCustomItem("raw_platinum");
    public static final DeferredItem<Item> PLATINUM_INGOT = registerTrimmableItem("platinum_ingot", ModTrimMaterials.PLATINUM);
    public static final DeferredItem<Item> PLATINUM_NUGGET = registerCustomItem("platinum_nugget");

    public static final DeferredItem<BlockItem> PLATINUM_BLOCK = registerBlockItem("platinum_block", () -> ModBlocks.PLATINUM_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_PLATINUM = registerBlockItem("cut_platinum", () -> ModBlocks.CUT_PLATINUM.get());
    public static final DeferredItem<BlockItem> CUT_PLATINUM_SLAB = registerBlockItem("cut_platinum_slab", () -> ModBlocks.CUT_PLATINUM_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_PLATINUM_STAIRS = registerBlockItem("cut_platinum_stairs", () -> ModBlocks.CUT_PLATINUM_STAIRS.get());
    public static final DeferredItem<BlockItem> PLATINUM_DOOR = registerBlockItem("platinum_door", () -> ModBlocks.PLATINUM_DOOR.get());
    public static final DeferredItem<BlockItem> PLATINUM_TRAPDOOR = registerBlockItem("platinum_trapdoor", () -> ModBlocks.PLATINUM_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerBlockItem("extraordinarily_light_weighted_pressure_plate", () -> ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> LEAD_ORE = registerBlockItem("lead_ore", () -> ModBlocks.LEAD_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_LEAD_ORE = registerBlockItem("deepslate_lead_ore", () -> ModBlocks.DEEPSLATE_LEAD_ORE.get());
    public static final DeferredItem<BlockItem> RAW_LEAD_BLOCK = registerBlockItem("raw_lead_block", () -> ModBlocks.RAW_LEAD_BLOCK.get());
    public static final DeferredItem<Item> RAW_LEAD = registerCustomItem("raw_lead");
    public static final DeferredItem<Item> LEAD_INGOT = registerTrimmableItem("lead_ingot", ModTrimMaterials.LEAD);
    public static final DeferredItem<Item> LEAD_NUGGET = registerCustomItem("lead_nugget");

    public static final DeferredItem<BlockItem> LEAD_BLOCK = registerBlockItem("lead_block", () -> ModBlocks.LEAD_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_LEAD = registerBlockItem("cut_lead", () -> ModBlocks.CUT_LEAD.get());
    public static final DeferredItem<BlockItem> CUT_LEAD_SLAB = registerBlockItem("cut_lead_slab", () -> ModBlocks.CUT_LEAD_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_LEAD_STAIRS = registerBlockItem("cut_lead_stairs", () -> ModBlocks.CUT_LEAD_STAIRS.get());
    public static final DeferredItem<BlockItem> LEAD_DOOR = registerBlockItem("lead_door", () -> ModBlocks.LEAD_DOOR.get());
    public static final DeferredItem<BlockItem> LEAD_TRAPDOOR = registerBlockItem("lead_trapdoor", () -> ModBlocks.LEAD_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("noticeably_heavy_weighted_pressure_plate", () -> ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> URANIUM_ORE = registerBlockItem("uranium_ore", () -> ModBlocks.URANIUM_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_URANIUM_ORE = registerBlockItem("deepslate_uranium_ore", () -> ModBlocks.DEEPSLATE_URANIUM_ORE.get());
    public static final DeferredItem<BlockItem> RAW_URANIUM_BLOCK = registerBlockItem("raw_uranium_block", () -> ModBlocks.RAW_URANIUM_BLOCK.get());
    public static final DeferredItem<Item> RAW_URANIUM = registerCustomItem("raw_uranium");
    public static final DeferredItem<Item> URANIUM_INGOT = registerTrimmableItem("uranium_ingot", ModTrimMaterials.URANIUM);
    public static final DeferredItem<Item> URANIUM_NUGGET = registerCustomItem("uranium_nugget");

    public static final DeferredItem<BlockItem> URANIUM_BLOCK = registerBlockItem("uranium_block", () -> ModBlocks.URANIUM_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_URANIUM = registerBlockItem("cut_uranium", () -> ModBlocks.CUT_URANIUM.get());
    public static final DeferredItem<BlockItem> CUT_URANIUM_SLAB = registerBlockItem("cut_uranium_slab", () -> ModBlocks.CUT_URANIUM_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_URANIUM_STAIRS = registerBlockItem("cut_uranium_stairs", () -> ModBlocks.CUT_URANIUM_STAIRS.get());
    public static final DeferredItem<BlockItem> URANIUM_DOOR = registerBlockItem("uranium_door", () -> ModBlocks.URANIUM_DOOR.get());
    public static final DeferredItem<BlockItem> URANIUM_TRAPDOOR = registerBlockItem("uranium_trapdoor", () -> ModBlocks.URANIUM_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE = registerBlockItem("negligible_weighted_pressure_plate", () -> ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> BRONZE_INGOT = registerTrimmableItem("bronze_ingot", ModTrimMaterials.BRONZE);
    public static final DeferredItem<Item> BRONZE_NUGGET = registerCustomItem("bronze_nugget");

    public static final DeferredItem<BlockItem> BRONZE_BLOCK = registerBlockItem("bronze_block", () -> ModBlocks.BRONZE_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE = registerBlockItem("cut_bronze", () -> ModBlocks.CUT_BRONZE.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE_SLAB = registerBlockItem("cut_bronze_slab", () -> ModBlocks.CUT_BRONZE_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE_STAIRS = registerBlockItem("cut_bronze_stairs", () -> ModBlocks.CUT_BRONZE_STAIRS.get());
    public static final DeferredItem<BlockItem> BRONZE_DOOR = registerBlockItem("bronze_door", () -> ModBlocks.BRONZE_DOOR.get());
    public static final DeferredItem<BlockItem> BRONZE_TRAPDOOR = registerBlockItem("bronze_trapdoor", () -> ModBlocks.BRONZE_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> PASSIVE_MOB_ONLY_PRESSURE_PLATE = registerBlockItem("passive_mob_only_pressure_plate", () -> ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> BRASS_INGOT = registerTrimmableItem("brass_ingot", ModTrimMaterials.BRASS);
    public static final DeferredItem<Item> BRASS_NUGGET = registerCustomItem("brass_nugget");

    public static final DeferredItem<BlockItem> BRASS_BLOCK = registerBlockItem("brass_block", () -> ModBlocks.BRASS_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_BRASS = registerBlockItem("cut_brass", () -> ModBlocks.CUT_BRASS.get());
    public static final DeferredItem<BlockItem> CUT_BRASS_SLAB = registerBlockItem("cut_brass_slab", () -> ModBlocks.CUT_BRASS_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_BRASS_STAIRS = registerBlockItem("cut_brass_stairs", () -> ModBlocks.CUT_BRASS_STAIRS.get());
    public static final DeferredItem<BlockItem> BRASS_DOOR = registerBlockItem("brass_door", () -> ModBlocks.BRASS_DOOR.get());
    public static final DeferredItem<BlockItem> BRASS_TRAPDOOR = registerBlockItem("brass_trapdoor", () -> ModBlocks.BRASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> HOSTILE_MOB_ONLY_PRESSURE_PLATE = registerBlockItem("hostile_mob_only_pressure_plate", () -> ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> STEEL_INGOT = registerTrimmableItem("steel_ingot", ModTrimMaterials.STEEL);
    public static final DeferredItem<Item> STEEL_NUGGET = registerCustomItem("steel_nugget");

    public static final DeferredItem<BlockItem> STEEL_BLOCK = registerBlockItem("steel_block", () -> ModBlocks.STEEL_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_STEEL = registerBlockItem("cut_steel", () -> ModBlocks.CUT_STEEL.get());
    public static final DeferredItem<BlockItem> CUT_STEEL_SLAB = registerBlockItem("cut_steel_slab", () -> ModBlocks.CUT_STEEL_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_STEEL_STAIRS = registerBlockItem("cut_steel_stairs", () -> ModBlocks.CUT_STEEL_STAIRS.get());
    public static final DeferredItem<BlockItem> STEEL_DOOR = registerBlockItem("steel_door", () -> ModBlocks.STEEL_DOOR.get());
    public static final DeferredItem<BlockItem> STEEL_TRAPDOOR = registerBlockItem("steel_trapdoor", () -> ModBlocks.STEEL_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> VILLAGER_ONLY_PRESSURE_PLATE = registerBlockItem("villager_only_pressure_plate", () -> ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<BucketItem> NUCLEAR_WASTE_BUCKET = registerBucketItem("nuclear_waste_bucket", () -> ModFluids.NUCLEAR_WASTE.get());
    public static final DeferredItem<BlockItem> NUKE = registerBlockItem("nuke", () -> ModBlocks.NUKE.get());

    public static final DeferredItem<BlockItem> OAK_CRAFTING_TABLE = registerBlockItem("oak_crafting_table", () -> Blocks.CRAFTING_TABLE);
    public static final DeferredItem<BlockItem> SPRUCE_CRAFTING_TABLE = registerBlockItem("spruce_crafting_table", () -> ModBlocks.SPRUCE_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> BIRCH_CRAFTING_TABLE = registerBlockItem("birch_crafting_table", () -> ModBlocks.BIRCH_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> JUNGLE_CRAFTING_TABLE = registerBlockItem("jungle_crafting_table", () -> ModBlocks.JUNGLE_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> ACACIA_CRAFTING_TABLE = registerBlockItem("acacia_crafting_table", () -> ModBlocks.ACACIA_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CRAFTING_TABLE = registerBlockItem("dark_oak_crafting_table", () -> ModBlocks.DARK_OAK_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> CRIMSON_CRAFTING_TABLE = registerBlockItem("crimson_crafting_table", () -> ModBlocks.CRIMSON_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> WARPED_CRAFTING_TABLE = registerBlockItem("warped_crafting_table", () -> ModBlocks.WARPED_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> MANGROVE_CRAFTING_TABLE = registerBlockItem("mangrove_crafting_table", () -> ModBlocks.MANGROVE_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> CHERRY_CRAFTING_TABLE = registerBlockItem("cherry_crafting_table", () -> ModBlocks.CHERRY_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> BAMBOO_CRAFTING_TABLE = registerBlockItem("bamboo_crafting_table", () -> ModBlocks.BAMBOO_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CRAFTING_TABLE = registerBlockItem("pale_oak_crafting_table", () -> ModBlocks.PALE_OAK_CRAFTING_TABLE.get());

    public static final DeferredItem<BlockItem> OAK_CARTOGRAPHY_TABLE = registerBlockItem("oak_cartography_table", () -> ModBlocks.OAK_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> SPRUCE_CARTOGRAPHY_TABLE = registerBlockItem("spruce_cartography_table", () -> ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> BIRCH_CARTOGRAPHY_TABLE = registerBlockItem("birch_cartography_table", () -> ModBlocks.BIRCH_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> JUNGLE_CARTOGRAPHY_TABLE = registerBlockItem("jungle_cartography_table", () -> ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> ACACIA_CARTOGRAPHY_TABLE = registerBlockItem("acacia_cartography_table", () -> ModBlocks.ACACIA_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CARTOGRAPHY_TABLE = registerBlockItem("dark_oak_cartography_table", () -> Blocks.CARTOGRAPHY_TABLE);
    public static final DeferredItem<BlockItem> CRIMSON_CARTOGRAPHY_TABLE = registerBlockItem("crimson_cartography_table", () -> ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> WARPED_CARTOGRAPHY_TABLE = registerBlockItem("warped_cartography_table", () -> ModBlocks.WARPED_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> MANGROVE_CARTOGRAPHY_TABLE = registerBlockItem("mangrove_cartography_table", () -> ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> CHERRY_CARTOGRAPHY_TABLE = registerBlockItem("cherry_cartography_table", () -> ModBlocks.CHERRY_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> BAMBOO_CARTOGRAPHY_TABLE = registerBlockItem("bamboo_cartography_table", () -> ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CARTOGRAPHY_TABLE = registerBlockItem("pale_oak_cartography_table", () -> ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.get());

    public static final DeferredItem<BlockItem> OAK_FLETCHING_TABLE = registerBlockItem("oak_fletching_table", () -> ModBlocks.OAK_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> SPRUCE_FLETCHING_TABLE = registerBlockItem("spruce_fletching_table", () -> ModBlocks.SPRUCE_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> BIRCH_FLETCHING_TABLE = registerBlockItem("birch_fletching_table", () -> ModBlocks.BIRCH_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> JUNGLE_FLETCHING_TABLE = registerBlockItem("jungle_fletching_table", () -> ModBlocks.JUNGLE_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> ACACIA_FLETCHING_TABLE = registerBlockItem("acacia_fletching_table", () -> ModBlocks.ACACIA_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_FLETCHING_TABLE = registerBlockItem("dark_oak_fletching_table", () -> ModBlocks.DARK_OAK_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> CRIMSON_FLETCHING_TABLE = registerBlockItem("crimson_fletching_table", () -> ModBlocks.CRIMSON_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> WARPED_FLETCHING_TABLE = registerBlockItem("warped_fletching_table", () -> ModBlocks.WARPED_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> MANGROVE_FLETCHING_TABLE = registerBlockItem("mangrove_fletching_table", () -> ModBlocks.MANGROVE_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> CHERRY_FLETCHING_TABLE = registerBlockItem("cherry_fletching_table", () -> ModBlocks.CHERRY_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> BAMBOO_FLETCHING_TABLE = registerBlockItem("bamboo_fletching_table", () -> ModBlocks.BAMBOO_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_FLETCHING_TABLE = registerBlockItem("pale_oak_fletching_table", () -> ModBlocks.PALE_OAK_FLETCHING_TABLE.get());

    public static final DeferredItem<BlockItem> OAK_SMITHING_TABLE = registerBlockItem("oak_smithing_table", () -> ModBlocks.OAK_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> SPRUCE_SMITHING_TABLE = registerBlockItem("spruce_smithing_table", () -> ModBlocks.SPRUCE_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> BIRCH_SMITHING_TABLE = registerBlockItem("birch_smithing_table", () -> ModBlocks.BIRCH_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> JUNGLE_SMITHING_TABLE = registerBlockItem("jungle_smithing_table", () -> ModBlocks.JUNGLE_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> ACACIA_SMITHING_TABLE = registerBlockItem("acacia_smithing_table", () -> ModBlocks.ACACIA_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_SMITHING_TABLE = registerBlockItem("dark_oak_smithing_table", () -> ModBlocks.DARK_OAK_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> CRIMSON_SMITHING_TABLE = registerBlockItem("crimson_smithing_table", () -> ModBlocks.CRIMSON_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> WARPED_SMITHING_TABLE = registerBlockItem("warped_smithing_table", () -> ModBlocks.WARPED_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> MANGROVE_SMITHING_TABLE = registerBlockItem("mangrove_smithing_table", () -> Blocks.SMITHING_TABLE);
    public static final DeferredItem<BlockItem> CHERRY_SMITHING_TABLE = registerBlockItem("cherry_smithing_table", () -> ModBlocks.CHERRY_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> BAMBOO_SMITHING_TABLE = registerBlockItem("bamboo_smithing_table", () -> ModBlocks.BAMBOO_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_SMITHING_TABLE = registerBlockItem("pale_oak_smithing_table", () -> ModBlocks.PALE_OAK_SMITHING_TABLE.get());

    public static final DeferredItem<BlockItem> OAK_GRINDSTONE = registerBlockItem("oak_grindstone", () -> ModBlocks.OAK_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> SPRUCE_GRINDSTONE = registerBlockItem("spruce_grindstone", () -> ModBlocks.SPRUCE_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> BIRCH_GRINDSTONE = registerBlockItem("birch_grindstone", () -> ModBlocks.BIRCH_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> JUNGLE_GRINDSTONE = registerBlockItem("jungle_grindstone", () -> ModBlocks.JUNGLE_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> ACACIA_GRINDSTONE = registerBlockItem("acacia_grindstone", () -> ModBlocks.ACACIA_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_GRINDSTONE = registerBlockItem("dark_oak_grindstone", () -> Blocks.GRINDSTONE);
    public static final DeferredItem<BlockItem> CRIMSON_GRINDSTONE = registerBlockItem("crimson_grindstone", () -> ModBlocks.CRIMSON_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> WARPED_GRINDSTONE = registerBlockItem("warped_grindstone", () -> ModBlocks.WARPED_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> MANGROVE_GRINDSTONE = registerBlockItem("mangrove_grindstone", () -> ModBlocks.MANGROVE_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> CHERRY_GRINDSTONE = registerBlockItem("cherry_grindstone", () -> ModBlocks.CHERRY_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> BAMBOO_GRINDSTONE = registerBlockItem("bamboo_grindstone", () -> ModBlocks.BAMBOO_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_GRINDSTONE = registerBlockItem("pale_oak_grindstone", () -> ModBlocks.PALE_OAK_GRINDSTONE.get());

    public static final DeferredItem<BlockItem> OAK_LOOM = registerBlockItem("oak_loom", () -> Blocks.LOOM);
    public static final DeferredItem<BlockItem> SPRUCE_LOOM = registerBlockItem("spruce_loom", () -> ModBlocks.SPRUCE_LOOM.get());
    public static final DeferredItem<BlockItem> BIRCH_LOOM = registerBlockItem("birch_loom", () -> ModBlocks.BIRCH_LOOM.get());
    public static final DeferredItem<BlockItem> JUNGLE_LOOM = registerBlockItem("jungle_loom", () -> ModBlocks.JUNGLE_LOOM.get());
    public static final DeferredItem<BlockItem> ACACIA_LOOM = registerBlockItem("acacia_loom", () -> ModBlocks.ACACIA_LOOM.get());
    public static final DeferredItem<BlockItem> DARK_OAK_LOOM = registerBlockItem("dark_oak_loom", () -> ModBlocks.DARK_OAK_LOOM.get());
    public static final DeferredItem<BlockItem> CRIMSON_LOOM = registerBlockItem("crimson_loom", () -> ModBlocks.CRIMSON_LOOM.get());
    public static final DeferredItem<BlockItem> WARPED_LOOM = registerBlockItem("warped_loom", () -> ModBlocks.WARPED_LOOM.get());
    public static final DeferredItem<BlockItem> MANGROVE_LOOM = registerBlockItem("mangrove_loom", () -> ModBlocks.MANGROVE_LOOM.get());
    public static final DeferredItem<BlockItem> CHERRY_LOOM = registerBlockItem("cherry_loom", () -> ModBlocks.CHERRY_LOOM.get());
    public static final DeferredItem<BlockItem> BAMBOO_LOOM = registerBlockItem("bamboo_loom", () -> ModBlocks.BAMBOO_LOOM.get());
    public static final DeferredItem<BlockItem> PALE_OAK_LOOM = registerBlockItem("pale_oak_loom", () -> ModBlocks.PALE_OAK_LOOM.get());

    public static final DeferredItem<BlockItem> STONE_FURNACE = registerBlockItem("stone_furnace", () -> Blocks.FURNACE);
    public static final DeferredItem<BlockItem> BLACKSTONE_FURNACE = registerBlockItem("blackstone_furnace", () -> ModBlocks.BLACKSTONE_FURNACE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_FURNACE = registerBlockItem("deepslate_furnace", () -> ModBlocks.DEEPSLATE_FURNACE.get());

    public static final DeferredItem<BlockItem> OAK_STONE_SMOKER = registerBlockItem("oak_stone_smoker", () -> Blocks.SMOKER);
    public static final DeferredItem<BlockItem> SPRUCE_STONE_SMOKER = registerBlockItem("spruce_stone_smoker", () -> ModBlocks.SPRUCE_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> BIRCH_STONE_SMOKER = registerBlockItem("birch_stone_smoker", () -> ModBlocks.BIRCH_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> JUNGLE_STONE_SMOKER = registerBlockItem("jungle_stone_smoker", () -> ModBlocks.JUNGLE_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> ACACIA_STONE_SMOKER = registerBlockItem("acacia_stone_smoker", () -> ModBlocks.ACACIA_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> DARK_OAK_STONE_SMOKER = registerBlockItem("dark_oak_stone_smoker", () -> ModBlocks.DARK_OAK_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> CRIMSON_STONE_SMOKER = registerBlockItem("crimson_stone_smoker", () -> ModBlocks.CRIMSON_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> WARPED_STONE_SMOKER = registerBlockItem("warped_stone_smoker", () -> ModBlocks.WARPED_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MANGROVE_STONE_SMOKER = registerBlockItem("mangrove_stone_smoker", () -> ModBlocks.MANGROVE_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> CHERRY_STONE_SMOKER = registerBlockItem("cherry_stone_smoker", () -> ModBlocks.CHERRY_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> BAMBOO_STONE_SMOKER = registerBlockItem("bamboo_stone_smoker", () -> ModBlocks.BAMBOO_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALE_OAK_STONE_SMOKER = registerBlockItem("pale_oak_stone_smoker", () -> ModBlocks.PALE_OAK_STONE_SMOKER.get());

    public static final DeferredItem<BlockItem> OAK_BLACKSTONE_SMOKER = registerBlockItem("oak_blackstone_smoker", () -> ModBlocks.OAK_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> SPRUCE_BLACKSTONE_SMOKER = registerBlockItem("spruce_blackstone_smoker", () -> ModBlocks.SPRUCE_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> BIRCH_BLACKSTONE_SMOKER = registerBlockItem("birch_blackstone_smoker", () -> ModBlocks.BIRCH_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> JUNGLE_BLACKSTONE_SMOKER = registerBlockItem("jungle_blackstone_smoker", () -> ModBlocks.JUNGLE_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> ACACIA_BLACKSTONE_SMOKER = registerBlockItem("acacia_blackstone_smoker", () -> ModBlocks.ACACIA_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> DARK_OAK_BLACKSTONE_SMOKER = registerBlockItem("dark_oak_blackstone_smoker", () -> ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> CRIMSON_BLACKSTONE_SMOKER = registerBlockItem("crimson_blackstone_smoker", () -> ModBlocks.CRIMSON_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> WARPED_BLACKSTONE_SMOKER = registerBlockItem("warped_blackstone_smoker", () -> ModBlocks.WARPED_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MANGROVE_BLACKSTONE_SMOKER = registerBlockItem("mangrove_blackstone_smoker", () -> ModBlocks.MANGROVE_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> CHERRY_BLACKSTONE_SMOKER = registerBlockItem("cherry_blackstone_smoker", () -> ModBlocks.CHERRY_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> BAMBOO_BLACKSTONE_SMOKER = registerBlockItem("bamboo_blackstone_smoker", () -> ModBlocks.BAMBOO_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALE_OAK_BLACKSTONE_SMOKER = registerBlockItem("pale_oak_blackstone_smoker", () -> ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.get());

    public static final DeferredItem<BlockItem> OAK_DEEPSLATE_SMOKER = registerBlockItem("oak_deepslate_smoker", () -> ModBlocks.OAK_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> SPRUCE_DEEPSLATE_SMOKER = registerBlockItem("spruce_deepslate_smoker", () -> ModBlocks.SPRUCE_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> BIRCH_DEEPSLATE_SMOKER = registerBlockItem("birch_deepslate_smoker", () -> ModBlocks.BIRCH_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> JUNGLE_DEEPSLATE_SMOKER = registerBlockItem("jungle_deepslate_smoker", () -> ModBlocks.JUNGLE_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> ACACIA_DEEPSLATE_SMOKER = registerBlockItem("acacia_deepslate_smoker", () -> ModBlocks.ACACIA_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> DARK_OAK_DEEPSLATE_SMOKER = registerBlockItem("dark_oak_deepslate_smoker", () -> ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> CRIMSON_DEEPSLATE_SMOKER = registerBlockItem("crimson_deepslate_smoker", () -> ModBlocks.CRIMSON_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> WARPED_DEEPSLATE_SMOKER = registerBlockItem("warped_deepslate_smoker", () -> ModBlocks.WARPED_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> MANGROVE_DEEPSLATE_SMOKER = registerBlockItem("mangrove_deepslate_smoker", () -> ModBlocks.MANGROVE_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> CHERRY_DEEPSLATE_SMOKER = registerBlockItem("cherry_deepslate_smoker", () -> ModBlocks.CHERRY_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> BAMBOO_DEEPSLATE_SMOKER = registerBlockItem("bamboo_deepslate_smoker", () -> ModBlocks.BAMBOO_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALE_OAK_DEEPSLATE_SMOKER = registerBlockItem("pale_oak_deepslate_smoker", () -> ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.get());

    public static final DeferredItem<BlockItem> STONE_BLAST_FURNACE = registerBlockItem("stone_blast_furnace", () -> Blocks.BLAST_FURNACE);
    public static final DeferredItem<BlockItem> BLACKSTONE_BLAST_FURNACE = registerBlockItem("blackstone_blast_furnace", () -> ModBlocks.BLACKSTONE_BLAST_FURNACE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_BLAST_FURNACE = registerBlockItem("deepslate_blast_furnace", () -> ModBlocks.DEEPSLATE_BLAST_FURNACE.get());

    public static final DeferredItem<BlockItem> OAK_CAMPFIRE = registerBlockItem("oak_campfire", () -> Blocks.CAMPFIRE);
    public static final DeferredItem<BlockItem> SPRUCE_CAMPFIRE = registerBlockItem("spruce_campfire", () -> ModBlocks.SPRUCE_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> BIRCH_CAMPFIRE = registerBlockItem("birch_campfire", () -> ModBlocks.BIRCH_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> JUNGLE_CAMPFIRE = registerBlockItem("jungle_campfire", () -> ModBlocks.JUNGLE_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> ACACIA_CAMPFIRE = registerBlockItem("acacia_campfire", () -> ModBlocks.ACACIA_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CAMPFIRE = registerBlockItem("dark_oak_campfire", () -> ModBlocks.DARK_OAK_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> CRIMSON_CAMPFIRE = registerBlockItem("crimson_campfire", () -> ModBlocks.CRIMSON_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> WARPED_CAMPFIRE = registerBlockItem("warped_campfire", () -> ModBlocks.WARPED_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MANGROVE_CAMPFIRE = registerBlockItem("mangrove_campfire", () -> ModBlocks.MANGROVE_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> CHERRY_CAMPFIRE = registerBlockItem("cherry_campfire", () -> ModBlocks.CHERRY_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> BAMBOO_CAMPFIRE = registerBlockItem("bamboo_campfire", () -> ModBlocks.BAMBOO_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CAMPFIRE = registerBlockItem("pale_oak_campfire", () -> ModBlocks.PALE_OAK_CAMPFIRE.get());

    public static final DeferredItem<BlockItem> OAK_SOUL_CAMPFIRE = registerBlockItem("oak_soul_campfire", () -> Blocks.SOUL_CAMPFIRE);
    public static final DeferredItem<BlockItem> SPRUCE_SOUL_CAMPFIRE = registerBlockItem("spruce_soul_campfire", () -> ModBlocks.SPRUCE_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> BIRCH_SOUL_CAMPFIRE = registerBlockItem("birch_soul_campfire", () -> ModBlocks.BIRCH_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> JUNGLE_SOUL_CAMPFIRE = registerBlockItem("jungle_soul_campfire", () -> ModBlocks.JUNGLE_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> ACACIA_SOUL_CAMPFIRE = registerBlockItem("acacia_soul_campfire", () -> ModBlocks.ACACIA_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_SOUL_CAMPFIRE = registerBlockItem("dark_oak_soul_campfire", () -> ModBlocks.DARK_OAK_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> CRIMSON_SOUL_CAMPFIRE = registerBlockItem("crimson_soul_campfire", () -> ModBlocks.CRIMSON_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> WARPED_SOUL_CAMPFIRE = registerBlockItem("warped_soul_campfire", () -> ModBlocks.WARPED_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MANGROVE_SOUL_CAMPFIRE = registerBlockItem("mangrove_soul_campfire", () -> ModBlocks.MANGROVE_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> CHERRY_SOUL_CAMPFIRE = registerBlockItem("cherry_soul_campfire", () -> ModBlocks.CHERRY_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> BAMBOO_SOUL_CAMPFIRE = registerBlockItem("bamboo_soul_campfire", () -> ModBlocks.BAMBOO_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_SOUL_CAMPFIRE = registerBlockItem("pale_oak_soul_campfire", () -> ModBlocks.PALE_OAK_SOUL_CAMPFIRE.get());

    public static final DeferredItem<BlockItem> OAK_BEEHIVE = registerBlockItem("oak_beehive", () -> Blocks.BEEHIVE);
    public static final DeferredItem<BlockItem> SPRUCE_BEEHIVE = registerBlockItem("spruce_beehive", () -> ModBlocks.SPRUCE_BEEHIVE.get());
    public static final DeferredItem<BlockItem> BIRCH_BEEHIVE = registerBlockItem("birch_beehive", () -> ModBlocks.BIRCH_BEEHIVE.get());
    public static final DeferredItem<BlockItem> JUNGLE_BEEHIVE = registerBlockItem("jungle_beehive", () -> ModBlocks.JUNGLE_BEEHIVE.get());
    public static final DeferredItem<BlockItem> ACACIA_BEEHIVE = registerBlockItem("acacia_beehive", () -> ModBlocks.ACACIA_BEEHIVE.get());
    public static final DeferredItem<BlockItem> DARK_OAK_BEEHIVE = registerBlockItem("dark_oak_beehive", () -> ModBlocks.DARK_OAK_BEEHIVE.get());
    public static final DeferredItem<BlockItem> CRIMSON_BEEHIVE = registerBlockItem("crimson_beehive", () -> ModBlocks.CRIMSON_BEEHIVE.get());
    public static final DeferredItem<BlockItem> WARPED_BEEHIVE = registerBlockItem("warped_beehive", () -> ModBlocks.WARPED_BEEHIVE.get());
    public static final DeferredItem<BlockItem> MANGROVE_BEEHIVE = registerBlockItem("mangrove_beehive", () -> ModBlocks.MANGROVE_BEEHIVE.get());
    public static final DeferredItem<BlockItem> CHERRY_BEEHIVE = registerBlockItem("cherry_beehive", () -> ModBlocks.CHERRY_BEEHIVE.get());
    public static final DeferredItem<BlockItem> BAMBOO_BEEHIVE = registerBlockItem("bamboo_beehive", () -> ModBlocks.BAMBOO_BEEHIVE.get());
    public static final DeferredItem<BlockItem> PALE_OAK_BEEHIVE = registerBlockItem("pale_oak_beehive", () -> ModBlocks.PALE_OAK_BEEHIVE.get());

    public static final DeferredItem<BlockItem> OAK_BOOKSHELF = registerBlockItem("oak_bookshelf", () -> Blocks.BOOKSHELF);
    public static final DeferredItem<BlockItem> SPRUCE_BOOKSHELF = registerBlockItem("spruce_bookshelf", () -> ModBlocks.SPRUCE_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> BIRCH_BOOKSHELF = registerBlockItem("birch_bookshelf", () -> ModBlocks.BIRCH_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> JUNGLE_BOOKSHELF = registerBlockItem("jungle_bookshelf", () -> ModBlocks.JUNGLE_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> ACACIA_BOOKSHELF = registerBlockItem("acacia_bookshelf", () -> ModBlocks.ACACIA_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> DARK_OAK_BOOKSHELF = registerBlockItem("dark_oak_bookshelf", () -> ModBlocks.DARK_OAK_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> CRIMSON_BOOKSHELF = registerBlockItem("crimson_bookshelf", () -> ModBlocks.CRIMSON_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> WARPED_BOOKSHELF = registerBlockItem("warped_bookshelf", () -> ModBlocks.WARPED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MANGROVE_BOOKSHELF = registerBlockItem("mangrove_bookshelf", () -> ModBlocks.MANGROVE_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> CHERRY_BOOKSHELF = registerBlockItem("cherry_bookshelf", () -> ModBlocks.CHERRY_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> BAMBOO_BOOKSHELF = registerBlockItem("bamboo_bookshelf", () -> ModBlocks.BAMBOO_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PALE_OAK_BOOKSHELF = registerBlockItem("pale_oak_bookshelf", () -> ModBlocks.PALE_OAK_BOOKSHELF.get());

    public static final DeferredItem<BlockItem> OAK_CHISELED_BOOKSHELF = registerBlockItem("oak_chiseled_bookshelf", () -> Blocks.CHISELED_BOOKSHELF);
    public static final DeferredItem<BlockItem> SPRUCE_CHISELED_BOOKSHELF = registerBlockItem("spruce_chiseled_bookshelf", () -> ModBlocks.SPRUCE_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> BIRCH_CHISELED_BOOKSHELF = registerBlockItem("birch_chiseled_bookshelf", () -> ModBlocks.BIRCH_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> JUNGLE_CHISELED_BOOKSHELF = registerBlockItem("jungle_chiseled_bookshelf", () -> ModBlocks.JUNGLE_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> ACACIA_CHISELED_BOOKSHELF = registerBlockItem("acacia_chiseled_bookshelf", () -> ModBlocks.ACACIA_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CHISELED_BOOKSHELF = registerBlockItem("dark_oak_chiseled_bookshelf", () -> ModBlocks.DARK_OAK_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> CRIMSON_CHISELED_BOOKSHELF = registerBlockItem("crimson_chiseled_bookshelf", () -> ModBlocks.CRIMSON_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> WARPED_CHISELED_BOOKSHELF = registerBlockItem("warped_chiseled_bookshelf", () -> ModBlocks.WARPED_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MANGROVE_CHISELED_BOOKSHELF = registerBlockItem("mangrove_chiseled_bookshelf", () -> ModBlocks.MANGROVE_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> CHERRY_CHISELED_BOOKSHELF = registerBlockItem("cherry_chiseled_bookshelf", () -> ModBlocks.CHERRY_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> BAMBOO_CHISELED_BOOKSHELF = registerBlockItem("bamboo_chiseled_bookshelf", () -> ModBlocks.BAMBOO_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CHISELED_BOOKSHELF = registerBlockItem("pale_oak_chiseled_bookshelf", () -> ModBlocks.PALE_OAK_CHISELED_BOOKSHELF.get());

    public static final DeferredItem<BlockItem> OAK_LECTERN = registerBlockItem("oak_lectern", () -> Blocks.LECTERN);
    public static final DeferredItem<BlockItem> SPRUCE_LECTERN = registerBlockItem("spruce_lectern", () -> ModBlocks.SPRUCE_LECTERN.get());
    public static final DeferredItem<BlockItem> BIRCH_LECTERN = registerBlockItem("birch_lectern", () -> ModBlocks.BIRCH_LECTERN.get());
    public static final DeferredItem<BlockItem> JUNGLE_LECTERN = registerBlockItem("jungle_lectern", () -> ModBlocks.JUNGLE_LECTERN.get());
    public static final DeferredItem<BlockItem> ACACIA_LECTERN = registerBlockItem("acacia_lectern", () -> ModBlocks.ACACIA_LECTERN.get());
    public static final DeferredItem<BlockItem> DARK_OAK_LECTERN = registerBlockItem("dark_oak_lectern", () -> ModBlocks.DARK_OAK_LECTERN.get());
    public static final DeferredItem<BlockItem> CRIMSON_LECTERN = registerBlockItem("crimson_lectern", () -> ModBlocks.CRIMSON_LECTERN.get());
    public static final DeferredItem<BlockItem> WARPED_LECTERN = registerBlockItem("warped_lectern", () -> ModBlocks.WARPED_LECTERN.get());
    public static final DeferredItem<BlockItem> MANGROVE_LECTERN = registerBlockItem("mangrove_lectern", () -> ModBlocks.MANGROVE_LECTERN.get());
    public static final DeferredItem<BlockItem> CHERRY_LECTERN = registerBlockItem("cherry_lectern", () -> ModBlocks.CHERRY_LECTERN.get());
    public static final DeferredItem<BlockItem> BAMBOO_LECTERN = registerBlockItem("bamboo_lectern", () -> ModBlocks.BAMBOO_LECTERN.get());
    public static final DeferredItem<BlockItem> PALE_OAK_LECTERN = registerBlockItem("pale_oak_lectern", () -> ModBlocks.PALE_OAK_LECTERN.get());

    public static final DeferredItem<BlockItem> STONE_BREWING_STAND = registerBlockItem("stone_brewing_stand", () -> Blocks.BREWING_STAND);
    public static final DeferredItem<BlockItem> BLACKSTONE_BREWING_STAND = registerBlockItem("blackstone_brewing_stand", () -> ModBlocks.BLACKSTONE_BREWING_STAND.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_BREWING_STAND = registerBlockItem("deepslate_brewing_stand", () -> ModBlocks.DEEPSLATE_BREWING_STAND.get());

    public static final DeferredItem<BlockItem> OAK_BARREL = registerBlockItem("oak_barrel", () -> ModBlocks.OAK_BARREL.get());
    public static final DeferredItem<BlockItem> SPRUCE_BARREL = registerBlockItem("spruce_barrel", () -> Blocks.BARREL);
    public static final DeferredItem<BlockItem> BIRCH_BARREL = registerBlockItem("birch_barrel", () -> ModBlocks.BIRCH_BARREL.get());
    public static final DeferredItem<BlockItem> JUNGLE_BARREL = registerBlockItem("jungle_barrel", () -> ModBlocks.JUNGLE_BARREL.get());
    public static final DeferredItem<BlockItem> ACACIA_BARREL = registerBlockItem("acacia_barrel", () -> ModBlocks.ACACIA_BARREL.get());
    public static final DeferredItem<BlockItem> DARK_OAK_BARREL = registerBlockItem("dark_oak_barrel", () -> ModBlocks.DARK_OAK_BARREL.get());
    public static final DeferredItem<BlockItem> CRIMSON_BARREL = registerBlockItem("crimson_barrel", () -> ModBlocks.CRIMSON_BARREL.get());
    public static final DeferredItem<BlockItem> WARPED_BARREL = registerBlockItem("warped_barrel", () -> ModBlocks.WARPED_BARREL.get());
    public static final DeferredItem<BlockItem> MANGROVE_BARREL = registerBlockItem("mangrove_barrel", () -> ModBlocks.MANGROVE_BARREL.get());
    public static final DeferredItem<BlockItem> CHERRY_BARREL = registerBlockItem("cherry_barrel", () -> ModBlocks.CHERRY_BARREL.get());
    public static final DeferredItem<BlockItem> BAMBOO_BARREL = registerBlockItem("bamboo_barrel", () -> ModBlocks.BAMBOO_BARREL.get());
    public static final DeferredItem<BlockItem> PALE_OAK_BARREL = registerBlockItem("pale_oak_barrel", () -> ModBlocks.PALE_OAK_BARREL.get());

    public static final DeferredItem<BlockItem> STONE_DISPENSER = registerBlockItem("stone_dispenser", () -> Blocks.DISPENSER);
    public static final DeferredItem<BlockItem> BLACKSTONE_DISPENSER = registerBlockItem("blackstone_dispenser", () -> ModBlocks.BLACKSTONE_DISPENSER.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_DISPENSER = registerBlockItem("deepslate_dispenser", () -> ModBlocks.DEEPSLATE_DISPENSER.get());

    public static final DeferredItem<BlockItem> STONE_DROPPER = registerBlockItem("stone_dropper", () -> Blocks.DROPPER);
    public static final DeferredItem<BlockItem> BLACKSTONE_DROPPER = registerBlockItem("blackstone_dropper", () -> ModBlocks.BLACKSTONE_DROPPER.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_DROPPER = registerBlockItem("deepslate_dropper", () -> ModBlocks.DEEPSLATE_DROPPER.get());

    public static final DeferredItem<BlockItem> STONE_OBSERVER = registerBlockItem("stone_observer", () -> Blocks.OBSERVER);
    public static final DeferredItem<BlockItem> BLACKSTONE_OBSERVER = registerBlockItem("blackstone_observer", () -> ModBlocks.BLACKSTONE_OBSERVER.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_OBSERVER = registerBlockItem("deepslate_observer", () -> ModBlocks.DEEPSLATE_OBSERVER.get());

    public static final DeferredItem<Item> MUSIC_DISC_CIRCUITRIC_MAGNET = registerMusicDisc("music_disc_circuitric_magnet", ModJukeboxSongs.CIRCUITRIC_MAGNET);
    public static final DeferredItem<Item> MUSIC_DISC_ANGRY_BOYFRIENDS = registerMusicDisc("music_disc_angry_boyfriends", ModJukeboxSongs.ANGRY_BOYFRIENDS);

    public static final DeferredItem<BoatItem> CRIMSON_BOAT = registerBoatItem("crimson_boat", () -> ModEntities.CRIMSON_BOAT.get());
    public static final DeferredItem<BoatItem> WARPED_BOAT = registerBoatItem("warped_boat", () -> ModEntities.WARPED_BOAT.get());
    public static final DeferredItem<BoatItem> CRIMSON_CHEST_BOAT = registerBoatItem("crimson_chest_boat", () -> ModEntities.CRIMSON_CHEST_BOAT.get());
    public static final DeferredItem<BoatItem> WARPED_CHEST_BOAT = registerBoatItem("warped_chest_boat", () -> ModEntities.WARPED_CHEST_BOAT.get());

    public static final DeferredItem<BlockItem> OAK_CRAFTER = registerBlockItem("oak_crafter", () -> Blocks.CRAFTER);
    public static final DeferredItem<BlockItem> SPRUCE_CRAFTER = registerBlockItem("spruce_crafter", () -> ModBlocks.SPRUCE_CRAFTER.get());
    public static final DeferredItem<BlockItem> BIRCH_CRAFTER = registerBlockItem("birch_crafter", () -> ModBlocks.BIRCH_CRAFTER.get());
    public static final DeferredItem<BlockItem> JUNGLE_CRAFTER = registerBlockItem("jungle_crafter", () -> ModBlocks.JUNGLE_CRAFTER.get());
    public static final DeferredItem<BlockItem> ACACIA_CRAFTER = registerBlockItem("acacia_crafter", () -> ModBlocks.ACACIA_CRAFTER.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CRAFTER = registerBlockItem("dark_oak_crafter", () -> ModBlocks.DARK_OAK_CRAFTER.get());
    public static final DeferredItem<BlockItem> CRIMSON_CRAFTER = registerBlockItem("crimson_crafter", () -> ModBlocks.CRIMSON_CRAFTER.get());
    public static final DeferredItem<BlockItem> WARPED_CRAFTER = registerBlockItem("warped_crafter", () -> ModBlocks.WARPED_CRAFTER.get());
    public static final DeferredItem<BlockItem> MANGROVE_CRAFTER = registerBlockItem("mangrove_crafter", () -> ModBlocks.MANGROVE_CRAFTER.get());
    public static final DeferredItem<BlockItem> CHERRY_CRAFTER = registerBlockItem("cherry_crafter", () -> ModBlocks.CHERRY_CRAFTER.get());
    public static final DeferredItem<BlockItem> BAMBOO_CRAFTER = registerBlockItem("bamboo_crafter", () -> ModBlocks.BAMBOO_CRAFTER.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CRAFTER = registerBlockItem("pale_oak_crafter", () -> ModBlocks.PALE_OAK_CRAFTER.get());

    public static final DeferredItem<MinecartItem> STONE_FURNACE_MINECART = registerMinecartItem("stone_furnace_minecart", () -> EntityTypes.FURNACE_MINECART);
    public static final DeferredItem<MinecartItem> BLACKSTONE_FURNACE_MINECART = registerMinecartItem("blackstone_furnace_minecart", () -> ModEntities.BLACKSTONE_FURNACE_MINECART.get());
    public static final DeferredItem<MinecartItem> DEEPSLATE_FURNACE_MINECART = registerMinecartItem("deepslate_furnace_minecart", () -> ModEntities.DEEPSLATE_FURNACE_MINECART.get());

    public static final DeferredItem<BlockItem> OAK_CHEST = registerBlockItem("oak_chest", () -> Blocks.CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST = registerBlockItem("spruce_chest", () -> ModBlocks.SPRUCE_CHEST.get());
    public static final DeferredItem<BlockItem> BIRCH_CHEST = registerBlockItem("birch_chest", () -> ModBlocks.BIRCH_CHEST.get());
    public static final DeferredItem<BlockItem> JUNGLE_CHEST = registerBlockItem("jungle_chest", () -> ModBlocks.JUNGLE_CHEST.get());
    public static final DeferredItem<BlockItem> ACACIA_CHEST = registerBlockItem("acacia_chest", () -> ModBlocks.ACACIA_CHEST.get());
    public static final DeferredItem<BlockItem> DARK_OAK_CHEST = registerBlockItem("dark_oak_chest", () -> ModBlocks.DARK_OAK_CHEST.get());
    public static final DeferredItem<BlockItem> CRIMSON_CHEST = registerBlockItem("crimson_chest", () -> ModBlocks.CRIMSON_CHEST.get());
    public static final DeferredItem<BlockItem> WARPED_CHEST = registerBlockItem("warped_chest", () -> ModBlocks.WARPED_CHEST.get());
    public static final DeferredItem<BlockItem> MANGROVE_CHEST = registerBlockItem("mangrove_chest", () -> ModBlocks.MANGROVE_CHEST.get());
    public static final DeferredItem<BlockItem> CHERRY_CHEST = registerBlockItem("cherry_chest", () -> ModBlocks.CHERRY_CHEST.get());
    public static final DeferredItem<BlockItem> BAMBOO_CHEST = registerBlockItem("bamboo_chest", () -> ModBlocks.BAMBOO_CHEST.get());
    public static final DeferredItem<BlockItem> PALE_OAK_CHEST = registerBlockItem("pale_oak_chest", () -> ModBlocks.PALE_OAK_CHEST.get());

    public static final DeferredItem<BlockItem> OAK_TRAPPED_CHEST = registerBlockItem("oak_trapped_chest", () -> Blocks.TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_TRAPPED_CHEST = registerBlockItem("spruce_trapped_chest", () -> ModBlocks.SPRUCE_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> BIRCH_TRAPPED_CHEST = registerBlockItem("birch_trapped_chest", () -> ModBlocks.BIRCH_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> JUNGLE_TRAPPED_CHEST = registerBlockItem("jungle_trapped_chest", () -> ModBlocks.JUNGLE_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> ACACIA_TRAPPED_CHEST = registerBlockItem("acacia_trapped_chest", () -> ModBlocks.ACACIA_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> DARK_OAK_TRAPPED_CHEST = registerBlockItem("dark_oak_trapped_chest", () -> ModBlocks.DARK_OAK_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> CRIMSON_TRAPPED_CHEST = registerBlockItem("crimson_trapped_chest", () -> ModBlocks.CRIMSON_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> WARPED_TRAPPED_CHEST = registerBlockItem("warped_trapped_chest", () -> ModBlocks.WARPED_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> MANGROVE_TRAPPED_CHEST = registerBlockItem("mangrove_trapped_chest", () -> ModBlocks.MANGROVE_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> CHERRY_TRAPPED_CHEST = registerBlockItem("cherry_trapped_chest", () -> ModBlocks.CHERRY_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> BAMBOO_TRAPPED_CHEST = registerBlockItem("bamboo_trapped_chest", () -> ModBlocks.BAMBOO_TRAPPED_CHEST.get());
    public static final DeferredItem<BlockItem> PALE_OAK_TRAPPED_CHEST = registerBlockItem("pale_oak_trapped_chest", () -> ModBlocks.PALE_OAK_TRAPPED_CHEST.get());

    public static final DeferredItem<MinecartItem> OAK_CHEST_MINECART = registerMinecartItem("oak_chest_minecart", () -> EntityTypes.CHEST_MINECART);
    public static final DeferredItem<MinecartItem> SPRUCE_CHEST_MINECART = registerMinecartItem("spruce_chest_minecart", () -> ModEntities.SPRUCE_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> BIRCH_CHEST_MINECART = registerMinecartItem("birch_chest_minecart", () -> ModEntities.BIRCH_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> JUNGLE_CHEST_MINECART = registerMinecartItem("jungle_chest_minecart", () -> ModEntities.JUNGLE_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> ACACIA_CHEST_MINECART = registerMinecartItem("acacia_chest_minecart", () -> ModEntities.ACACIA_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> DARK_OAK_CHEST_MINECART = registerMinecartItem("dark_oak_chest_minecart", () -> ModEntities.DARK_OAK_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> CRIMSON_CHEST_MINECART = registerMinecartItem("crimson_chest_minecart", () -> ModEntities.CRIMSON_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> WARPED_CHEST_MINECART = registerMinecartItem("warped_chest_minecart", () -> ModEntities.WARPED_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> MANGROVE_CHEST_MINECART = registerMinecartItem("mangrove_chest_minecart", () -> ModEntities.MANGROVE_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> CHERRY_CHEST_MINECART = registerMinecartItem("cherry_chest_minecart", () -> ModEntities.CHERRY_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> BAMBOO_CHEST_MINECART = registerMinecartItem("bamboo_chest_minecart", () -> ModEntities.BAMBOO_CHEST_MINECART.get());
    public static final DeferredItem<MinecartItem> PALE_OAK_CHEST_MINECART = registerMinecartItem("pale_oak_chest_minecart", () -> ModEntities.PALE_OAK_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> OAK_MOSAIC = registerBlockItem("oak_mosaic", () -> ModBlocks.OAK_MOSAIC.get());
    public static final DeferredItem<BlockItem> SPRUCE_MOSAIC = registerBlockItem("spruce_mosaic", () -> ModBlocks.SPRUCE_MOSAIC.get());
    public static final DeferredItem<BlockItem> BIRCH_MOSAIC = registerBlockItem("birch_mosaic", () -> ModBlocks.BIRCH_MOSAIC.get());
    public static final DeferredItem<BlockItem> JUNGLE_MOSAIC = registerBlockItem("jungle_mosaic", () -> ModBlocks.JUNGLE_MOSAIC.get());
    public static final DeferredItem<BlockItem> ACACIA_MOSAIC = registerBlockItem("acacia_mosaic", () -> ModBlocks.ACACIA_MOSAIC.get());
    public static final DeferredItem<BlockItem> DARK_OAK_MOSAIC = registerBlockItem("dark_oak_mosaic", () -> ModBlocks.DARK_OAK_MOSAIC.get());
    public static final DeferredItem<BlockItem> CRIMSON_MOSAIC = registerBlockItem("crimson_mosaic", () -> ModBlocks.CRIMSON_MOSAIC.get());
    public static final DeferredItem<BlockItem> WARPED_MOSAIC = registerBlockItem("warped_mosaic", () -> ModBlocks.WARPED_MOSAIC.get());
    public static final DeferredItem<BlockItem> MANGROVE_MOSAIC = registerBlockItem("mangrove_mosaic", () -> ModBlocks.MANGROVE_MOSAIC.get());
    public static final DeferredItem<BlockItem> CHERRY_MOSAIC = registerBlockItem("cherry_mosaic", () -> ModBlocks.CHERRY_MOSAIC.get());
    public static final DeferredItem<BlockItem> PALE_OAK_MOSAIC = registerBlockItem("pale_oak_mosaic", () -> ModBlocks.PALE_OAK_MOSAIC.get());

    public static final DeferredItem<BlockItem> OAK_MOSAIC_SLAB = registerBlockItem("oak_mosaic_slab", () -> ModBlocks.OAK_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> SPRUCE_MOSAIC_SLAB = registerBlockItem("spruce_mosaic_slab", () -> ModBlocks.SPRUCE_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> BIRCH_MOSAIC_SLAB = registerBlockItem("birch_mosaic_slab", () -> ModBlocks.BIRCH_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> JUNGLE_MOSAIC_SLAB = registerBlockItem("jungle_mosaic_slab", () -> ModBlocks.JUNGLE_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> ACACIA_MOSAIC_SLAB = registerBlockItem("acacia_mosaic_slab", () -> ModBlocks.ACACIA_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> DARK_OAK_MOSAIC_SLAB = registerBlockItem("dark_oak_mosaic_slab", () -> ModBlocks.DARK_OAK_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> CRIMSON_MOSAIC_SLAB = registerBlockItem("crimson_mosaic_slab", () -> ModBlocks.CRIMSON_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> WARPED_MOSAIC_SLAB = registerBlockItem("warped_mosaic_slab", () -> ModBlocks.WARPED_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> MANGROVE_MOSAIC_SLAB = registerBlockItem("mangrove_mosaic_slab", () -> ModBlocks.MANGROVE_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> CHERRY_MOSAIC_SLAB = registerBlockItem("cherry_mosaic_slab", () -> ModBlocks.CHERRY_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> PALE_OAK_MOSAIC_SLAB = registerBlockItem("pale_oak_mosaic_slab", () -> ModBlocks.PALE_OAK_MOSAIC_SLAB.get());

    public static final DeferredItem<BlockItem> OAK_MOSAIC_STAIRS = registerBlockItem("oak_mosaic_stairs", () -> ModBlocks.OAK_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> SPRUCE_MOSAIC_STAIRS = registerBlockItem("spruce_mosaic_stairs", () -> ModBlocks.SPRUCE_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> BIRCH_MOSAIC_STAIRS = registerBlockItem("birch_mosaic_stairs", () -> ModBlocks.BIRCH_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> JUNGLE_MOSAIC_STAIRS = registerBlockItem("jungle_mosaic_stairs", () -> ModBlocks.JUNGLE_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> ACACIA_MOSAIC_STAIRS = registerBlockItem("acacia_mosaic_stairs", () -> ModBlocks.ACACIA_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> DARK_OAK_MOSAIC_STAIRS = registerBlockItem("dark_oak_mosaic_stairs", () -> ModBlocks.DARK_OAK_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> CRIMSON_MOSAIC_STAIRS = registerBlockItem("crimson_mosaic_stairs", () -> ModBlocks.CRIMSON_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> WARPED_MOSAIC_STAIRS = registerBlockItem("warped_mosaic_stairs", () -> ModBlocks.WARPED_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> MANGROVE_MOSAIC_STAIRS = registerBlockItem("mangrove_mosaic_stairs", () -> ModBlocks.MANGROVE_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> CHERRY_MOSAIC_STAIRS = registerBlockItem("cherry_mosaic_stairs", () -> ModBlocks.CHERRY_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> PALE_OAK_MOSAIC_STAIRS = registerBlockItem("pale_oak_mosaic_stairs", () -> ModBlocks.PALE_OAK_MOSAIC_STAIRS.get());

    public static final DeferredItem<Item> STONE_BATON = registerCustomItem("stone_baton");
    public static final DeferredItem<Item> GRANITE_BATON = registerCustomItem("granite_baton");
    public static final DeferredItem<Item> DIORITE_BATON = registerCustomItem("diorite_baton");
    public static final DeferredItem<Item> ANDESITE_BATON = registerCustomItem("andesite_baton");
    public static final DeferredItem<Item> DEEPSLATE_BATON = registerCustomItem("deepslate_baton");
    public static final DeferredItem<Item> TUFF_BATON = registerCustomItem("tuff_baton");
    public static final DeferredItem<Item> CALCITE_BATON = registerCustomItem("calcite_baton");
    public static final DeferredItem<Item> PACKED_MUD_BATON = registerCustomItem("packed_mud_baton");
    public static final DeferredItem<Item> SANDSTONE_BATON = registerCustomItem("sandstone_baton");
    public static final DeferredItem<Item> RED_SANDSTONE_BATON = registerCustomItem("red_sandstone_baton");
    public static final DeferredItem<Item> SOUL_SANDSTONE_BATON = registerCustomItem("soul_sandstone_baton");
    public static final DeferredItem<Item> END_STONE_BATON = registerCustomItem("end_stone_baton");
    public static final DeferredItem<Item> NETHERRACK_BATON = registerCustomItem("netherrack_baton");
    public static final DeferredItem<Item> BLACKSTONE_BATON = registerCustomItem("blackstone_baton");
    public static final DeferredItem<Item> BASALT_BATON = registerCustomItem("basalt_baton");
    public static final DeferredItem<Item> OBSIDIAN_BATON = registerCustomItem("obsidian_baton");
    public static final DeferredItem<Item> TERRACOTTA_BATON = registerCustomItem("terracotta_baton");
    public static final DeferredItem<Item> CONCRETE_BATON = registerCustomItem("concrete_baton");
    public static final DeferredItem<Item> ICE_SHARD = registerCustomItem("ice_shard");

    public static final DeferredItem<BlockItem> OBSIDIAN_SLAB = registerBlockItem("obsidian_slab", () -> ModBlocks.OBSIDIAN_SLAB.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_STAIRS = registerBlockItem("obsidian_stairs", () -> ModBlocks.OBSIDIAN_STAIRS.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_WALL = registerBlockItem("obsidian_wall", () -> ModBlocks.OBSIDIAN_WALL.get());

    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_SLAB = registerBlockItem("crying_obsidian_slab", () -> ModBlocks.CRYING_OBSIDIAN_SLAB.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_STAIRS = registerBlockItem("crying_obsidian_stairs", () -> ModBlocks.CRYING_OBSIDIAN_STAIRS.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_WALL = registerBlockItem("crying_obsidian_wall", () -> ModBlocks.CRYING_OBSIDIAN_WALL.get());

    public static final DeferredItem<BlockItem> COAL_SLAB = registerBlockItem("coal_slab", () -> ModBlocks.COAL_SLAB.get());
    public static final DeferredItem<BlockItem> COAL_STAIRS = registerBlockItem("coal_stairs", () -> ModBlocks.COAL_STAIRS.get());
    public static final DeferredItem<BlockItem> COAL_WALL = registerBlockItem("coal_wall", () -> ModBlocks.COAL_WALL.get());

    public static final DeferredItem<BlockItem> CHARCOAL_SLAB = registerBlockItem("charcoal_slab", () -> ModBlocks.CHARCOAL_SLAB.get());
    public static final DeferredItem<BlockItem> CHARCOAL_STAIRS = registerBlockItem("charcoal_stairs", () -> ModBlocks.CHARCOAL_STAIRS.get());
    public static final DeferredItem<BlockItem> CHARCOAL_WALL = registerBlockItem("charcoal_wall", () -> ModBlocks.CHARCOAL_WALL.get());

    public static final DeferredItem<BlockItem> LAPIS_SLAB = registerBlockItem("lapis_slab", () -> ModBlocks.LAPIS_SLAB.get());
    public static final DeferredItem<BlockItem> LAPIS_STAIRS = registerBlockItem("lapis_stairs", () -> ModBlocks.LAPIS_STAIRS.get());
    public static final DeferredItem<BlockItem> LAPIS_WALL = registerBlockItem("lapis_wall", () -> ModBlocks.LAPIS_WALL.get());

    public static final DeferredItem<BlockItem> SNOW_SLAB = registerBlockItem("snow_slab", () -> ModBlocks.SNOW_SLAB.get());
    public static final DeferredItem<BlockItem> SNOW_STAIRS = registerBlockItem("snow_stairs", () -> ModBlocks.SNOW_STAIRS.get());
    public static final DeferredItem<BlockItem> SNOW_WALL = registerBlockItem("snow_wall", () -> ModBlocks.SNOW_WALL.get());

    public static final DeferredItem<BlockItem> ICE_SLAB = registerBlockItem("ice_slab", () -> ModBlocks.ICE_SLAB.get());
    public static final DeferredItem<BlockItem> ICE_STAIRS = registerBlockItem("ice_stairs", () -> ModBlocks.ICE_STAIRS.get());
    public static final DeferredItem<BlockItem> ICE_WALL = registerBlockItem("ice_wall", () -> ModBlocks.ICE_WALL.get());

    public static final DeferredItem<BlockItem> PACKED_ICE_SLAB = registerBlockItem("packed_ice_slab", () -> ModBlocks.PACKED_ICE_SLAB.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_STAIRS = registerBlockItem("packed_ice_stairs", () -> ModBlocks.PACKED_ICE_STAIRS.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_WALL = registerBlockItem("packed_ice_wall", () -> ModBlocks.PACKED_ICE_WALL.get());

    public static final DeferredItem<BlockItem> BLUE_ICE_SLAB = registerBlockItem("blue_ice_slab", () -> ModBlocks.BLUE_ICE_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_STAIRS = registerBlockItem("blue_ice_stairs", () -> ModBlocks.BLUE_ICE_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_WALL = registerBlockItem("blue_ice_wall", () -> ModBlocks.BLUE_ICE_WALL.get());

    public static final DeferredItem<BlockItem> TERRACOTTA_SLAB = registerBlockItem("terracotta_slab", () -> ModBlocks.TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_STAIRS = registerBlockItem("terracotta_stairs", () -> ModBlocks.TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_WALL = registerBlockItem("terracotta_wall", () -> ModBlocks.TERRACOTTA_WALL.get());

    public static final DeferredItem<BlockItem> SCULK_SLAB = registerBlockItem("sculk_slab", () -> ModBlocks.SCULK_SLAB.get());
    public static final DeferredItem<BlockItem> SCULK_STAIRS = registerBlockItem("sculk_stairs", () -> ModBlocks.SCULK_STAIRS.get());
    public static final DeferredItem<BlockItem> SCULK_WALL = registerBlockItem("sculk_wall", () -> ModBlocks.SCULK_WALL.get());

    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_SLAB = registerBlockItem("white_terracotta_slab", () -> ModBlocks.WHITE_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_STAIRS = registerBlockItem("white_terracotta_stairs", () -> ModBlocks.WHITE_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_WALL = registerBlockItem("white_terracotta_wall", () -> ModBlocks.WHITE_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_SLAB = registerBlockItem("orange_terracotta_slab", () -> ModBlocks.ORANGE_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_STAIRS = registerBlockItem("orange_terracotta_stairs", () -> ModBlocks.ORANGE_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_WALL = registerBlockItem("orange_terracotta_wall", () -> ModBlocks.ORANGE_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_SLAB = registerBlockItem("magenta_terracotta_slab", () -> ModBlocks.MAGENTA_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_STAIRS = registerBlockItem("magenta_terracotta_stairs", () -> ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_WALL = registerBlockItem("magenta_terracotta_wall", () -> ModBlocks.MAGENTA_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlockItem("light_blue_terracotta_slab", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlockItem("light_blue_terracotta_stairs", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_WALL = registerBlockItem("light_blue_terracotta_wall", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_SLAB = registerBlockItem("yellow_terracotta_slab", () -> ModBlocks.YELLOW_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_STAIRS = registerBlockItem("yellow_terracotta_stairs", () -> ModBlocks.YELLOW_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_WALL = registerBlockItem("yellow_terracotta_wall", () -> ModBlocks.YELLOW_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_SLAB = registerBlockItem("lime_terracotta_slab", () -> ModBlocks.LIME_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_STAIRS = registerBlockItem("lime_terracotta_stairs", () -> ModBlocks.LIME_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_WALL = registerBlockItem("lime_terracotta_wall", () -> ModBlocks.LIME_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_SLAB = registerBlockItem("pink_terracotta_slab", () -> ModBlocks.PINK_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_STAIRS = registerBlockItem("pink_terracotta_stairs", () -> ModBlocks.PINK_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_WALL = registerBlockItem("pink_terracotta_wall", () -> ModBlocks.PINK_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_SLAB = registerBlockItem("gray_terracotta_slab", () -> ModBlocks.GRAY_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_STAIRS = registerBlockItem("gray_terracotta_stairs", () -> ModBlocks.GRAY_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_WALL = registerBlockItem("gray_terracotta_wall", () -> ModBlocks.GRAY_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlockItem("light_gray_terracotta_slab", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlockItem("light_gray_terracotta_stairs", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_WALL = registerBlockItem("light_gray_terracotta_wall", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_SLAB = registerBlockItem("cyan_terracotta_slab", () -> ModBlocks.CYAN_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_STAIRS = registerBlockItem("cyan_terracotta_stairs", () -> ModBlocks.CYAN_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_WALL = registerBlockItem("cyan_terracotta_wall", () -> ModBlocks.CYAN_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_SLAB = registerBlockItem("purple_terracotta_slab", () -> ModBlocks.PURPLE_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_STAIRS = registerBlockItem("purple_terracotta_stairs", () -> ModBlocks.PURPLE_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_WALL = registerBlockItem("purple_terracotta_wall", () -> ModBlocks.PURPLE_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_SLAB = registerBlockItem("blue_terracotta_slab", () -> ModBlocks.BLUE_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_STAIRS = registerBlockItem("blue_terracotta_stairs", () -> ModBlocks.BLUE_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_WALL = registerBlockItem("blue_terracotta_wall", () -> ModBlocks.BLUE_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_SLAB = registerBlockItem("brown_terracotta_slab", () -> ModBlocks.BROWN_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_STAIRS = registerBlockItem("brown_terracotta_stairs", () -> ModBlocks.BROWN_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_WALL = registerBlockItem("brown_terracotta_wall", () -> ModBlocks.BROWN_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_SLAB = registerBlockItem("green_terracotta_slab", () -> ModBlocks.GREEN_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_STAIRS = registerBlockItem("green_terracotta_stairs", () -> ModBlocks.GREEN_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_WALL = registerBlockItem("green_terracotta_wall", () -> ModBlocks.GREEN_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_SLAB = registerBlockItem("red_terracotta_slab", () -> ModBlocks.RED_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_STAIRS = registerBlockItem("red_terracotta_stairs", () -> ModBlocks.RED_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_WALL = registerBlockItem("red_terracotta_wall", () -> ModBlocks.RED_TERRACOTTA_WALL.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_SLAB = registerBlockItem("black_terracotta_slab", () -> ModBlocks.BLACK_TERRACOTTA_SLAB.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_STAIRS = registerBlockItem("black_terracotta_stairs", () -> ModBlocks.BLACK_TERRACOTTA_STAIRS.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_WALL = registerBlockItem("black_terracotta_wall", () -> ModBlocks.BLACK_TERRACOTTA_WALL.get());

    public static final DeferredItem<BlockItem> WHITE_CONCRETE_SLAB = registerBlockItem("white_concrete_slab", () -> ModBlocks.WHITE_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_STAIRS = registerBlockItem("white_concrete_stairs", () -> ModBlocks.WHITE_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_WALL = registerBlockItem("white_concrete_wall", () -> ModBlocks.WHITE_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_SLAB = registerBlockItem("orange_concrete_slab", () -> ModBlocks.ORANGE_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_STAIRS = registerBlockItem("orange_concrete_stairs", () -> ModBlocks.ORANGE_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_WALL = registerBlockItem("orange_concrete_wall", () -> ModBlocks.ORANGE_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_SLAB = registerBlockItem("magenta_concrete_slab", () -> ModBlocks.MAGENTA_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_STAIRS = registerBlockItem("magenta_concrete_stairs", () -> ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_WALL = registerBlockItem("magenta_concrete_wall", () -> ModBlocks.MAGENTA_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_SLAB = registerBlockItem("light_blue_concrete_slab", () -> ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_STAIRS = registerBlockItem("light_blue_concrete_stairs", () -> ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_WALL = registerBlockItem("light_blue_concrete_wall", () -> ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_SLAB = registerBlockItem("yellow_concrete_slab", () -> ModBlocks.YELLOW_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_STAIRS = registerBlockItem("yellow_concrete_stairs", () -> ModBlocks.YELLOW_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_WALL = registerBlockItem("yellow_concrete_wall", () -> ModBlocks.YELLOW_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_SLAB = registerBlockItem("lime_concrete_slab", () -> ModBlocks.LIME_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_STAIRS = registerBlockItem("lime_concrete_stairs", () -> ModBlocks.LIME_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_WALL = registerBlockItem("lime_concrete_wall", () -> ModBlocks.LIME_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_SLAB = registerBlockItem("pink_concrete_slab", () -> ModBlocks.PINK_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_STAIRS = registerBlockItem("pink_concrete_stairs", () -> ModBlocks.PINK_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_WALL = registerBlockItem("pink_concrete_wall", () -> ModBlocks.PINK_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_SLAB = registerBlockItem("gray_concrete_slab", () -> ModBlocks.GRAY_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_STAIRS = registerBlockItem("gray_concrete_stairs", () -> ModBlocks.GRAY_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_WALL = registerBlockItem("gray_concrete_wall", () -> ModBlocks.GRAY_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_SLAB = registerBlockItem("light_gray_concrete_slab", () -> ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_STAIRS = registerBlockItem("light_gray_concrete_stairs", () -> ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_WALL = registerBlockItem("light_gray_concrete_wall", () -> ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_SLAB = registerBlockItem("cyan_concrete_slab", () -> ModBlocks.CYAN_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_STAIRS = registerBlockItem("cyan_concrete_stairs", () -> ModBlocks.CYAN_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_WALL = registerBlockItem("cyan_concrete_wall", () -> ModBlocks.CYAN_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_SLAB = registerBlockItem("purple_concrete_slab", () -> ModBlocks.PURPLE_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_STAIRS = registerBlockItem("purple_concrete_stairs", () -> ModBlocks.PURPLE_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_WALL = registerBlockItem("purple_concrete_wall", () -> ModBlocks.PURPLE_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_SLAB = registerBlockItem("blue_concrete_slab", () -> ModBlocks.BLUE_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_STAIRS = registerBlockItem("blue_concrete_stairs", () -> ModBlocks.BLUE_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_WALL = registerBlockItem("blue_concrete_wall", () -> ModBlocks.BLUE_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_SLAB = registerBlockItem("brown_concrete_slab", () -> ModBlocks.BROWN_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_STAIRS = registerBlockItem("brown_concrete_stairs", () -> ModBlocks.BROWN_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_WALL = registerBlockItem("brown_concrete_wall", () -> ModBlocks.BROWN_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_SLAB = registerBlockItem("green_concrete_slab", () -> ModBlocks.GREEN_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_STAIRS = registerBlockItem("green_concrete_stairs", () -> ModBlocks.GREEN_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_WALL = registerBlockItem("green_concrete_wall", () -> ModBlocks.GREEN_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_SLAB = registerBlockItem("red_concrete_slab", () -> ModBlocks.RED_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_STAIRS = registerBlockItem("red_concrete_stairs", () -> ModBlocks.RED_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_WALL = registerBlockItem("red_concrete_wall", () -> ModBlocks.RED_CONCRETE_WALL.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_SLAB = registerBlockItem("black_concrete_slab", () -> ModBlocks.BLACK_CONCRETE_SLAB.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_STAIRS = registerBlockItem("black_concrete_stairs", () -> ModBlocks.BLACK_CONCRETE_STAIRS.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_WALL = registerBlockItem("black_concrete_wall", () -> ModBlocks.BLACK_CONCRETE_WALL.get());

    public static final DeferredItem<BlockItem> STONE_TILES = registerBlockItem("stone_tiles", () -> ModBlocks.STONE_TILES.get());
    public static final DeferredItem<BlockItem> STONE_TILE_SLAB = registerBlockItem("stone_tile_slab", () -> ModBlocks.STONE_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> STONE_TILE_STAIRS = registerBlockItem("stone_tile_stairs", () -> ModBlocks.STONE_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> STONE_TILE_WALL = registerBlockItem("stone_tile_wall", () -> ModBlocks.STONE_TILE_WALL.get());

    public static final DeferredItem<BlockItem> MOSSY_STONE_TILES = registerBlockItem("mossy_stone_tiles", () -> ModBlocks.MOSSY_STONE_TILES.get());
    public static final DeferredItem<BlockItem> MOSSY_STONE_TILE_SLAB = registerBlockItem("mossy_stone_tile_slab", () -> ModBlocks.MOSSY_STONE_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> MOSSY_STONE_TILE_STAIRS = registerBlockItem("mossy_stone_tile_stairs", () -> ModBlocks.MOSSY_STONE_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> MOSSY_STONE_TILE_WALL = registerBlockItem("mossy_stone_tile_wall", () -> ModBlocks.MOSSY_STONE_TILE_WALL.get());

    public static final DeferredItem<BlockItem> CRACKED_STONE_TILES = registerBlockItem("cracked_stone_tiles", () -> ModBlocks.CRACKED_STONE_TILES.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_TILE_SLAB = registerBlockItem("cracked_stone_tile_slab", () -> ModBlocks.CRACKED_STONE_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_TILE_STAIRS = registerBlockItem("cracked_stone_tile_stairs", () -> ModBlocks.CRACKED_STONE_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_TILE_WALL = registerBlockItem("cracked_stone_tile_wall", () -> ModBlocks.CRACKED_STONE_TILE_WALL.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_CHAIN = registerBlockItem("exposed_iron_chain", () -> ModBlocks.EXPOSED_IRON_CHAIN.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_CHAIN = registerBlockItem("weathered_iron_chain", () -> ModBlocks.WEATHERED_IRON_CHAIN.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_CHAIN = registerBlockItem("rusted_iron_chain", () -> ModBlocks.RUSTED_IRON_CHAIN.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_CHAIN = registerBlockItem("waxed_iron_chain", () -> ModBlocks.WAXED_IRON_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_CHAIN = registerBlockItem("waxed_exposed_iron_chain", () -> ModBlocks.WAXED_EXPOSED_IRON_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_CHAIN = registerBlockItem("waxed_weathered_iron_chain", () -> ModBlocks.WAXED_WEATHERED_IRON_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_CHAIN = registerBlockItem("waxed_rusted_iron_chain", () -> ModBlocks.WAXED_RUSTED_IRON_CHAIN.get());

    public static final DeferredItem<BlockItem> OBSIDIAN_BRICKS = registerBlockItem("obsidian_bricks", () -> ModBlocks.OBSIDIAN_BRICKS.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_SLAB = registerBlockItem("obsidian_brick_slab", () -> ModBlocks.OBSIDIAN_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_STAIRS = registerBlockItem("obsidian_brick_stairs", () -> ModBlocks.OBSIDIAN_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_WALL = registerBlockItem("obsidian_brick_wall", () -> ModBlocks.OBSIDIAN_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_BRICKS = registerBlockItem("crying_obsidian_bricks", () -> ModBlocks.CRYING_OBSIDIAN_BRICKS.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_BRICK_SLAB = registerBlockItem("crying_obsidian_brick_slab", () -> ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_BRICK_STAIRS = registerBlockItem("crying_obsidian_brick_stairs", () -> ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_BRICK_WALL = registerBlockItem("crying_obsidian_brick_wall", () -> ModBlocks.CRYING_OBSIDIAN_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> COAL_BRICKS = registerBlockItem("coal_bricks", () -> ModBlocks.COAL_BRICKS.get());
    public static final DeferredItem<BlockItem> COAL_BRICK_SLAB = registerBlockItem("coal_brick_slab", () -> ModBlocks.COAL_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> COAL_BRICK_STAIRS = registerBlockItem("coal_brick_stairs", () -> ModBlocks.COAL_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> COAL_BRICK_WALL = registerBlockItem("coal_brick_wall", () -> ModBlocks.COAL_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CHARCOAL_BRICKS = registerBlockItem("charcoal_bricks", () -> ModBlocks.CHARCOAL_BRICKS.get());
    public static final DeferredItem<BlockItem> CHARCOAL_BRICK_SLAB = registerBlockItem("charcoal_brick_slab", () -> ModBlocks.CHARCOAL_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CHARCOAL_BRICK_STAIRS = registerBlockItem("charcoal_brick_stairs", () -> ModBlocks.CHARCOAL_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CHARCOAL_BRICK_WALL = registerBlockItem("charcoal_brick_wall", () -> ModBlocks.CHARCOAL_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> LAPIS_BRICKS = registerBlockItem("lapis_bricks", () -> ModBlocks.LAPIS_BRICKS.get());
    public static final DeferredItem<BlockItem> LAPIS_BRICK_SLAB = registerBlockItem("lapis_brick_slab", () -> ModBlocks.LAPIS_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LAPIS_BRICK_STAIRS = registerBlockItem("lapis_brick_stairs", () -> ModBlocks.LAPIS_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LAPIS_BRICK_WALL = registerBlockItem("lapis_brick_wall", () -> ModBlocks.LAPIS_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> SMOOTH_LAPIS = registerBlockItem("smooth_lapis", () -> ModBlocks.SMOOTH_LAPIS.get());
    public static final DeferredItem<BlockItem> SMOOTH_LAPIS_SLAB = registerBlockItem("smooth_lapis_slab", () -> ModBlocks.SMOOTH_LAPIS_SLAB.get());
    public static final DeferredItem<BlockItem> SMOOTH_LAPIS_STAIRS = registerBlockItem("smooth_lapis_stairs", () -> ModBlocks.SMOOTH_LAPIS_STAIRS.get());
    public static final DeferredItem<BlockItem> SMOOTH_LAPIS_WALL = registerBlockItem("smooth_lapis_wall", () -> ModBlocks.SMOOTH_LAPIS_WALL.get());

    public static final DeferredItem<BlockItem> SNOW_BRICKS = registerBlockItem("snow_bricks", () -> ModBlocks.SNOW_BRICKS.get());
    public static final DeferredItem<BlockItem> SNOW_BRICK_SLAB = registerBlockItem("snow_brick_slab", () -> ModBlocks.SNOW_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> SNOW_BRICK_STAIRS = registerBlockItem("snow_brick_stairs", () -> ModBlocks.SNOW_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> SNOW_BRICK_WALL = registerBlockItem("snow_brick_wall", () -> ModBlocks.SNOW_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> ICE_BRICKS = registerBlockItem("ice_bricks", () -> ModBlocks.ICE_BRICKS.get());
    public static final DeferredItem<BlockItem> ICE_BRICK_SLAB = registerBlockItem("ice_brick_slab", () -> ModBlocks.ICE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> ICE_BRICK_STAIRS = registerBlockItem("ice_brick_stairs", () -> ModBlocks.ICE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> ICE_BRICK_WALL = registerBlockItem("ice_brick_wall", () -> ModBlocks.ICE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> PACKED_ICE_BRICKS = registerBlockItem("packed_ice_bricks", () -> ModBlocks.PACKED_ICE_BRICKS.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_BRICK_SLAB = registerBlockItem("packed_ice_brick_slab", () -> ModBlocks.PACKED_ICE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_BRICK_STAIRS = registerBlockItem("packed_ice_brick_stairs", () -> ModBlocks.PACKED_ICE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_BRICK_WALL = registerBlockItem("packed_ice_brick_wall", () -> ModBlocks.PACKED_ICE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> BLUE_ICE_BRICKS = registerBlockItem("blue_ice_bricks", () -> ModBlocks.BLUE_ICE_BRICKS.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_BRICK_SLAB = registerBlockItem("blue_ice_brick_slab", () -> ModBlocks.BLUE_ICE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_BRICK_STAIRS = registerBlockItem("blue_ice_brick_stairs", () -> ModBlocks.BLUE_ICE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_BRICK_WALL = registerBlockItem("blue_ice_brick_wall", () -> ModBlocks.BLUE_ICE_BRICK_WALL.get());

    public static final DeferredItem<Item> SCULK_BRICK = registerTrimmableItem("sculk_brick", ModTrimMaterials.SCULK);
    public static final DeferredItem<BlockItem> SCULK_BRICKS = registerBlockItem("sculk_bricks", () -> ModBlocks.SCULK_BRICKS.get());
    public static final DeferredItem<BlockItem> SCULK_BRICK_SLAB = registerBlockItem("sculk_brick_slab", () -> ModBlocks.SCULK_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> SCULK_BRICK_STAIRS = registerBlockItem("sculk_brick_stairs", () -> ModBlocks.SCULK_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> SCULK_BRICK_WALL = registerBlockItem("sculk_brick_wall", () -> ModBlocks.SCULK_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> CHISELED_SCULK_BRICKS = registerBlockItem("chiseled_sculk_bricks", () -> ModBlocks.CHISELED_SCULK_BRICKS.get());

    public static final DeferredItem<Item> BRONZE_SWORD = registerSword("bronze_sword", ModToolMaterials.BRONZE, 3.0F, -2.4F);
    public static final DeferredItem<Item> BRONZE_SPEAR = registerSpear("bronze_spear", ModToolMaterials.BRONZE, 0.9F, 0.87F, 0.625F, 3.0F, 8.0F, 7.5F, 5.1F, 11.75F, 4.6F);
    public static final DeferredItem<Item> BRONZE_AXE = registerAxe("bronze_axe", ModToolMaterials.BRONZE, 7.0F, -3.2F);
    public static final DeferredItem<Item> BRONZE_SHOVEL = registerShovel("bronze_shovel", ModToolMaterials.BRONZE, 1.5F, -3.0F);
    public static final DeferredItem<Item> BRONZE_PICKAXE = registerPickAxe("bronze_pickaxe", ModToolMaterials.BRONZE, 7.0F, -3.2F);
    public static final DeferredItem<Item> BRONZE_HOE = registerHoe("bronze_hoe", ModToolMaterials.BRONZE, -1.0F, -2.0F);
    public static final DeferredItem<Item> BRONZE_HELMET = registerArmor("bronze_helmet", ModArmorMaterials.BRONZE, ArmorType.HELMET);
    public static final DeferredItem<Item> BRONZE_CHESTPLATE = registerArmor("bronze_chestplate", ModArmorMaterials.BRONZE, ArmorType.CHESTPLATE);
    public static final DeferredItem<Item> BRONZE_LEGGINGS = registerArmor("bronze_leggings", ModArmorMaterials.BRONZE, ArmorType.LEGGINGS);
    public static final DeferredItem<Item> BRONZE_BOOTS = registerArmor("bronze_boots", ModArmorMaterials.BRONZE, ArmorType.BOOTS);
    public static final DeferredItem<Item> BRONZE_HORSE_ARMOR = registerHorseArmor("bronze_horse_armor", ModArmorMaterials.BRONZE);
    public static final DeferredItem<Item> BRONZE_NAUTILUS_ARMOR = registerNautilusArmor("bronze_nautilus_armor", ModArmorMaterials.BRONZE);
    public static final DeferredItem<SmithingTemplateItem> BRONZE_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate("bronze_upgrade_smithing_template");

    public static final DeferredItem<BlockItem> STONE_FENCE = registerBlockItem("stone_fence", () -> ModBlocks.STONE_FENCE.get());
    public static final DeferredItem<BlockItem> COBBLESTONE_FENCE = registerBlockItem("cobblestone_fence", () -> ModBlocks.COBBLESTONE_FENCE.get());
    public static final DeferredItem<BlockItem> MOSSY_COBBLESTONE_FENCE = registerBlockItem("mossy_cobblestone_fence", () -> ModBlocks.MOSSY_COBBLESTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_STONE_FENCE = registerBlockItem("smooth_stone_fence", () -> ModBlocks.SMOOTH_STONE_FENCE.get());
    public static final DeferredItem<BlockItem> STONE_BRICK_FENCE = registerBlockItem("stone_brick_fence", () -> ModBlocks.STONE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> MOSSY_STONE_BRICK_FENCE = registerBlockItem("mossy_stone_brick_fence", () -> ModBlocks.MOSSY_STONE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_BRICK_FENCE = registerBlockItem("cracked_stone_brick_fence", () -> ModBlocks.CRACKED_STONE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> STONE_TILE_FENCE = registerBlockItem("stone_tile_fence", () -> ModBlocks.STONE_TILE_FENCE.get());
    public static final DeferredItem<BlockItem> MOSSY_STONE_TILE_FENCE = registerBlockItem("mossy_stone_tile_fence", () -> ModBlocks.MOSSY_STONE_TILE_FENCE.get());
    public static final DeferredItem<BlockItem> CRACKED_STONE_TILE_FENCE = registerBlockItem("cracked_stone_tile_fence", () -> ModBlocks.CRACKED_STONE_TILE_FENCE.get());

    public static final DeferredItem<BlockItem> GRANITE_FENCE = registerBlockItem("granite_fence", () -> ModBlocks.GRANITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_GRANITE_FENCE = registerBlockItem("polished_granite_fence", () -> ModBlocks.POLISHED_GRANITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_GRANITE_BRICK_FENCE = registerBlockItem("polished_granite_brick_fence", () -> ModBlocks.POLISHED_GRANITE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> DIORITE_FENCE = registerBlockItem("diorite_fence", () -> ModBlocks.DIORITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_FENCE = registerBlockItem("polished_diorite_fence", () -> ModBlocks.POLISHED_DIORITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_DIORITE_BRICK_FENCE = registerBlockItem("polished_diorite_brick_fence", () -> ModBlocks.POLISHED_DIORITE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> ANDESITE_FENCE = registerBlockItem("andesite_fence", () -> ModBlocks.ANDESITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_FENCE = registerBlockItem("polished_andesite_fence", () -> ModBlocks.POLISHED_ANDESITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_ANDESITE_BRICK_FENCE = registerBlockItem("polished_andesite_brick_fence", () -> ModBlocks.POLISHED_ANDESITE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> DEEPSLATE_FENCE = registerBlockItem("deepslate_fence", () -> ModBlocks.DEEPSLATE_FENCE.get());
    public static final DeferredItem<BlockItem> COBBLED_DEEPSLATE_FENCE = registerBlockItem("cobbled_deepslate_fence", () -> ModBlocks.COBBLED_DEEPSLATE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_DEEPSLATE_FENCE = registerBlockItem("polished_deepslate_fence", () -> ModBlocks.POLISHED_DEEPSLATE_FENCE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_BRICK_FENCE = registerBlockItem("deepslate_brick_fence", () -> ModBlocks.DEEPSLATE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_BRICK_FENCE = registerBlockItem("cracked_deepslate_brick_fence", () -> ModBlocks.CRACKED_DEEPSLATE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_TILE_FENCE = registerBlockItem("deepslate_tile_fence", () -> ModBlocks.DEEPSLATE_TILE_FENCE.get());
    public static final DeferredItem<BlockItem> CRACKED_DEEPSLATE_TILE_FENCE = registerBlockItem("cracked_deepslate_tile_fence", () -> ModBlocks.CRACKED_DEEPSLATE_TILE_FENCE.get());

    public static final DeferredItem<BlockItem> TUFF_FENCE = registerBlockItem("tuff_fence", () -> ModBlocks.TUFF_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_TUFF_FENCE = registerBlockItem("polished_tuff_fence", () -> ModBlocks.POLISHED_TUFF_FENCE.get());
    public static final DeferredItem<BlockItem> TUFF_BRICK_FENCE = registerBlockItem("tuff_brick_fence", () -> ModBlocks.TUFF_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CALCITE_FENCE = registerBlockItem("calcite_fence", () -> ModBlocks.CALCITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_CALCITE_FENCE = registerBlockItem("polished_calcite_fence", () -> ModBlocks.POLISHED_CALCITE_FENCE.get());
    public static final DeferredItem<BlockItem> CALCITE_BRICK_FENCE = registerBlockItem("calcite_brick_fence", () -> ModBlocks.CALCITE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> DRIPSTONE_FENCE = registerBlockItem("dripstone_fence", () -> ModBlocks.DRIPSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_DRIPSTONE_FENCE = registerBlockItem("polished_dripstone_fence", () -> ModBlocks.POLISHED_DRIPSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> DRIPSTONE_BRICK_FENCE = registerBlockItem("dripstone_brick_fence", () -> ModBlocks.DRIPSTONE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BRICK_FENCE = registerBlockItem("brick_fence", () -> ModBlocks.BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PACKED_MUD_FENCE = registerBlockItem("packed_mud_fence", () -> ModBlocks.PACKED_MUD_FENCE.get());
    public static final DeferredItem<BlockItem> MUD_BRICK_FENCE = registerBlockItem("mud_brick_fence", () -> ModBlocks.MUD_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> RESIN_FENCE = registerBlockItem("resin_fence", () -> ModBlocks.RESIN_FENCE.get());
    public static final DeferredItem<BlockItem> RESIN_BRICK_FENCE = registerBlockItem("resin_brick_fence", () -> ModBlocks.RESIN_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> SANDSTONE_FENCE = registerBlockItem("sandstone_fence", () -> ModBlocks.SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_SANDSTONE_FENCE = registerBlockItem("cut_sandstone_fence", () -> ModBlocks.CUT_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_SANDSTONE_FENCE = registerBlockItem("smooth_sandstone_fence", () -> ModBlocks.SMOOTH_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> RED_SANDSTONE_FENCE = registerBlockItem("red_sandstone_fence", () -> ModBlocks.RED_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_RED_SANDSTONE_FENCE = registerBlockItem("cut_red_sandstone_fence", () -> ModBlocks.CUT_RED_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_RED_SANDSTONE_FENCE = registerBlockItem("smooth_red_sandstone_fence", () -> ModBlocks.SMOOTH_RED_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> SOUL_SANDSTONE_FENCE = registerBlockItem("soul_sandstone_fence", () -> ModBlocks.SOUL_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_SOUL_SANDSTONE_FENCE = registerBlockItem("cut_soul_sandstone_fence", () -> ModBlocks.CUT_SOUL_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_SOUL_SANDSTONE_FENCE = registerBlockItem("smooth_soul_sandstone_fence", () -> ModBlocks.SMOOTH_SOUL_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> END_STONE_FENCE = registerBlockItem("end_stone_fence", () -> ModBlocks.END_STONE_FENCE.get());
    public static final DeferredItem<BlockItem> END_STONE_BRICK_FENCE = registerBlockItem("end_stone_brick_fence", () -> ModBlocks.END_STONE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PURPUR_FENCE = registerBlockItem("purpur_fence", () -> ModBlocks.PURPUR_FENCE.get());

    public static final DeferredItem<BlockItem> NETHERRACK_FENCE = registerBlockItem("netherrack_fence", () -> ModBlocks.NETHERRACK_FENCE.get());

    public static final DeferredItem<BlockItem> CRACKED_NETHER_BRICK_FENCE = registerBlockItem("cracked_nether_brick_fence", () -> ModBlocks.CRACKED_NETHER_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> RED_NETHER_BRICK_FENCE = registerBlockItem("red_nether_brick_fence", () -> ModBlocks.RED_NETHER_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BASALT_FENCE = registerBlockItem("basalt_fence", () -> ModBlocks.BASALT_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_BASALT_FENCE = registerBlockItem("polished_basalt_fence", () -> ModBlocks.POLISHED_BASALT_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_BASALT_FENCE = registerBlockItem("smooth_basalt_fence", () -> ModBlocks.SMOOTH_BASALT_FENCE.get());
    public static final DeferredItem<BlockItem> BASALT_BRICK_FENCE = registerBlockItem("basalt_brick_fence", () -> ModBlocks.BASALT_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PRISMARINE_FENCE = registerBlockItem("prismarine_fence", () -> ModBlocks.PRISMARINE_FENCE.get());
    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_FENCE = registerBlockItem("prismarine_brick_fence", () -> ModBlocks.PRISMARINE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> DARK_PRISMARINE_FENCE = registerBlockItem("dark_prismarine_fence", () -> ModBlocks.DARK_PRISMARINE_FENCE.get());

    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_FENCE = registerBlockItem("elder_prismarine_fence", () -> ModBlocks.ELDER_PRISMARINE_FENCE.get());
    public static final DeferredItem<BlockItem> ELDER_PRISMARINE_BRICK_FENCE = registerBlockItem("elder_prismarine_brick_fence", () -> ModBlocks.ELDER_PRISMARINE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> DARK_ELDER_PRISMARINE_FENCE = registerBlockItem("dark_elder_prismarine_fence", () -> ModBlocks.DARK_ELDER_PRISMARINE_FENCE.get());

    public static final DeferredItem<BlockItem> BLACKSTONE_FENCE = registerBlockItem("blackstone_fence", () -> ModBlocks.BLACKSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_BLACKSTONE_FENCE = registerBlockItem("polished_blackstone_fence", () -> ModBlocks.POLISHED_BLACKSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_BLACKSTONE_BRICK_FENCE = registerBlockItem("polished_blackstone_brick_fence", () -> ModBlocks.POLISHED_BLACKSTONE_BRICK_FENCE.get());
    public static final DeferredItem<BlockItem> CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE = registerBlockItem("cracked_polished_blackstone_brick_fence", () -> ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> QUARTZ_FENCE = registerBlockItem("quartz_fence", () -> ModBlocks.QUARTZ_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_QUARTZ_FENCE = registerBlockItem("smooth_quartz_fence", () -> ModBlocks.SMOOTH_QUARTZ_FENCE.get());
    public static final DeferredItem<BlockItem> QUARTZ_BRICK_FENCE = registerBlockItem("quartz_brick_fence", () -> ModBlocks.QUARTZ_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> OBSIDIAN_FENCE = registerBlockItem("obsidian_fence", () -> ModBlocks.OBSIDIAN_FENCE.get());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_FENCE = registerBlockItem("obsidian_brick_fence", () -> ModBlocks.OBSIDIAN_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_FENCE = registerBlockItem("crying_obsidian_fence", () -> ModBlocks.CRYING_OBSIDIAN_FENCE.get());
    public static final DeferredItem<BlockItem> CRYING_OBSIDIAN_BRICK_FENCE = registerBlockItem("crying_obsidian_brick_fence", () -> ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> COAL_FENCE = registerBlockItem("coal_fence", () -> ModBlocks.COAL_FENCE.get());
    public static final DeferredItem<BlockItem> COAL_BRICK_FENCE = registerBlockItem("coal_brick_fence", () -> ModBlocks.COAL_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CHARCOAL_FENCE = registerBlockItem("charcoal_fence", () -> ModBlocks.CHARCOAL_FENCE.get());
    public static final DeferredItem<BlockItem> CHARCOAL_BRICK_FENCE = registerBlockItem("charcoal_brick_fence", () -> ModBlocks.CHARCOAL_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LAPIS_FENCE = registerBlockItem("lapis_fence", () -> ModBlocks.LAPIS_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_LAPIS_FENCE = registerBlockItem("smooth_lapis_fence", () -> ModBlocks.SMOOTH_LAPIS_FENCE.get());
    public static final DeferredItem<BlockItem> LAPIS_BRICK_FENCE = registerBlockItem("lapis_brick_fence", () -> ModBlocks.LAPIS_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> SNOW_FENCE = registerBlockItem("snow_fence", () -> ModBlocks.SNOW_FENCE.get());
    public static final DeferredItem<BlockItem> SNOW_BRICK_FENCE = registerBlockItem("snow_brick_fence", () -> ModBlocks.SNOW_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> ICE_FENCE = registerBlockItem("ice_fence", () -> ModBlocks.ICE_FENCE.get());
    public static final DeferredItem<BlockItem> ICE_BRICK_FENCE = registerBlockItem("ice_brick_fence", () -> ModBlocks.ICE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PACKED_ICE_FENCE = registerBlockItem("packed_ice_fence", () -> ModBlocks.PACKED_ICE_FENCE.get());
    public static final DeferredItem<BlockItem> PACKED_ICE_BRICK_FENCE = registerBlockItem("packed_ice_brick_fence", () -> ModBlocks.PACKED_ICE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BLUE_ICE_FENCE = registerBlockItem("blue_ice_fence", () -> ModBlocks.BLUE_ICE_FENCE.get());
    public static final DeferredItem<BlockItem> BLUE_ICE_BRICK_FENCE = registerBlockItem("blue_ice_brick_fence", () -> ModBlocks.BLUE_ICE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> SCULK_FENCE = registerBlockItem("sculk_fence", () -> ModBlocks.SCULK_FENCE.get());
    public static final DeferredItem<BlockItem> SCULK_BRICK_FENCE = registerBlockItem("sculk_brick_fence", () -> ModBlocks.SCULK_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> TERRACOTTA_FENCE = registerBlockItem("terracotta_fence", () -> ModBlocks.TERRACOTTA_FENCE.get());

    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_FENCE = registerBlockItem("white_terracotta_fence", () -> ModBlocks.WHITE_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_FENCE = registerBlockItem("orange_terracotta_fence", () -> ModBlocks.ORANGE_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_FENCE = registerBlockItem("magenta_terracotta_fence", () -> ModBlocks.MAGENTA_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_FENCE = registerBlockItem("light_blue_terracotta_fence", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_FENCE = registerBlockItem("yellow_terracotta_fence", () -> ModBlocks.YELLOW_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_FENCE = registerBlockItem("lime_terracotta_fence", () -> ModBlocks.LIME_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_FENCE = registerBlockItem("pink_terracotta_fence", () -> ModBlocks.PINK_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_FENCE = registerBlockItem("gray_terracotta_fence", () -> ModBlocks.GRAY_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_FENCE = registerBlockItem("light_gray_terracotta_fence", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_FENCE = registerBlockItem("cyan_terracotta_fence", () -> ModBlocks.CYAN_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_FENCE = registerBlockItem("purple_terracotta_fence", () -> ModBlocks.PURPLE_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_FENCE = registerBlockItem("blue_terracotta_fence", () -> ModBlocks.BLUE_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_FENCE = registerBlockItem("brown_terracotta_fence", () -> ModBlocks.BROWN_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_FENCE = registerBlockItem("green_terracotta_fence", () -> ModBlocks.GREEN_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_FENCE = registerBlockItem("red_terracotta_fence", () -> ModBlocks.RED_TERRACOTTA_FENCE.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_FENCE = registerBlockItem("black_terracotta_fence", () -> ModBlocks.BLACK_TERRACOTTA_FENCE.get());

    public static final DeferredItem<BlockItem> WHITE_CONCRETE_FENCE = registerBlockItem("white_concrete_fence", () -> ModBlocks.WHITE_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_FENCE = registerBlockItem("orange_concrete_fence", () -> ModBlocks.ORANGE_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_FENCE = registerBlockItem("magenta_concrete_fence", () -> ModBlocks.MAGENTA_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_FENCE = registerBlockItem("light_blue_concrete_fence", () -> ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_FENCE = registerBlockItem("yellow_concrete_fence", () -> ModBlocks.YELLOW_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_FENCE = registerBlockItem("lime_concrete_fence", () -> ModBlocks.LIME_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_FENCE = registerBlockItem("pink_concrete_fence", () -> ModBlocks.PINK_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_FENCE = registerBlockItem("gray_concrete_fence", () -> ModBlocks.GRAY_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_FENCE = registerBlockItem("light_gray_concrete_fence", () -> ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_FENCE = registerBlockItem("cyan_concrete_fence", () -> ModBlocks.CYAN_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_FENCE = registerBlockItem("purple_concrete_fence", () -> ModBlocks.PURPLE_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_FENCE = registerBlockItem("blue_concrete_fence", () -> ModBlocks.BLUE_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_FENCE = registerBlockItem("brown_concrete_fence", () -> ModBlocks.BROWN_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_FENCE = registerBlockItem("green_concrete_fence", () -> ModBlocks.GREEN_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_FENCE = registerBlockItem("red_concrete_fence", () -> ModBlocks.RED_CONCRETE_FENCE.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_FENCE = registerBlockItem("black_concrete_fence", () -> ModBlocks.BLACK_CONCRETE_FENCE.get());

    public static final DeferredItem<StandingAndWallBlockItem> IRON_TORCH = registerTorch("iron_torch", () -> ModBlocks.IRON_TORCH.get(), () -> ModBlocks.IRON_WALL_TORCH.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_LANTERN = registerBlockItem("exposed_iron_lantern", () -> ModBlocks.EXPOSED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_LANTERN = registerBlockItem("weathered_iron_lantern", () -> ModBlocks.WEATHERED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_LANTERN = registerBlockItem("rusted_iron_lantern", () -> ModBlocks.RUSTED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_IRON_LANTERN = registerBlockItem("waxed_iron_lantern", () -> ModBlocks.WAXED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_LANTERN = registerBlockItem("waxed_exposed_iron_lantern", () -> ModBlocks.WAXED_EXPOSED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_LANTERN = registerBlockItem("waxed_weathered_iron_lantern", () -> ModBlocks.WAXED_WEATHERED_IRON_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_LANTERN = registerBlockItem("waxed_rusted_iron_lantern", () -> ModBlocks.WAXED_RUSTED_IRON_LANTERN.get());

    public static final DeferredItem<BlockItem> EXPOSED_IRON_SOUL_LANTERN = registerBlockItem("exposed_iron_soul_lantern", () -> ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_SOUL_LANTERN = registerBlockItem("weathered_iron_soul_lantern", () -> ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_SOUL_LANTERN = registerBlockItem("rusted_iron_soul_lantern", () -> ModBlocks.RUSTED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_IRON_SOUL_LANTERN = registerBlockItem("waxed_iron_soul_lantern", () -> ModBlocks.WAXED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_SOUL_LANTERN = registerBlockItem("waxed_exposed_iron_soul_lantern", () -> ModBlocks.WAXED_EXPOSED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_SOUL_LANTERN = registerBlockItem("waxed_weathered_iron_soul_lantern", () -> ModBlocks.WAXED_WEATHERED_IRON_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_SOUL_LANTERN = registerBlockItem("waxed_rusted_iron_soul_lantern", () -> ModBlocks.WAXED_RUSTED_IRON_SOUL_LANTERN.get());

    public static final DeferredItem<BlockItem> IRON_FIRE_LANTERN = registerBlockItem("iron_fire_lantern", () -> ModBlocks.IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> EXPOSED_IRON_FIRE_LANTERN = registerBlockItem("exposed_iron_fire_lantern", () -> ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_FIRE_LANTERN = registerBlockItem("weathered_iron_fire_lantern", () -> ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_FIRE_LANTERN = registerBlockItem("rusted_iron_fire_lantern", () -> ModBlocks.RUSTED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_IRON_FIRE_LANTERN = registerBlockItem("waxed_iron_fire_lantern", () -> ModBlocks.WAXED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_FIRE_LANTERN = registerBlockItem("waxed_exposed_iron_fire_lantern", () -> ModBlocks.WAXED_EXPOSED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_FIRE_LANTERN = registerBlockItem("waxed_weathered_iron_fire_lantern", () -> ModBlocks.WAXED_WEATHERED_IRON_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_FIRE_LANTERN = registerBlockItem("waxed_rusted_iron_fire_lantern", () -> ModBlocks.WAXED_RUSTED_IRON_FIRE_LANTERN.get());

    public static final DeferredItem<BlockItem> COPPER_SOUL_LANTERN = registerBlockItem("copper_soul_lantern", () -> ModBlocks.COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_SOUL_LANTERN = registerBlockItem("exposed_copper_soul_lantern", () -> ModBlocks.EXPOSED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_SOUL_LANTERN = registerBlockItem("weathered_copper_soul_lantern", () -> ModBlocks.WEATHERED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_SOUL_LANTERN = registerBlockItem("oxidized_copper_soul_lantern", () -> ModBlocks.OXIDIZED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_COPPER_SOUL_LANTERN = registerBlockItem("waxed_copper_soul_lantern", () -> ModBlocks.WAXED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_SOUL_LANTERN = registerBlockItem("waxed_exposed_copper_soul_lantern", () -> ModBlocks.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_SOUL_LANTERN = registerBlockItem("waxed_weathered_copper_soul_lantern", () -> ModBlocks.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_SOUL_LANTERN = registerBlockItem("waxed_oxidized_copper_soul_lantern", () -> ModBlocks.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get());

    public static final DeferredItem<BlockItem> COPPER_FIRE_LANTERN = registerBlockItem("copper_fire_lantern", () -> ModBlocks.COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_FIRE_LANTERN = registerBlockItem("exposed_copper_fire_lantern", () -> ModBlocks.EXPOSED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_FIRE_LANTERN = registerBlockItem("weathered_copper_fire_lantern", () -> ModBlocks.WEATHERED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_FIRE_LANTERN = registerBlockItem("oxidized_copper_fire_lantern", () -> ModBlocks.OXIDIZED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_COPPER_FIRE_LANTERN = registerBlockItem("waxed_copper_fire_lantern", () -> ModBlocks.WAXED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_FIRE_LANTERN = registerBlockItem("waxed_exposed_copper_fire_lantern", () -> ModBlocks.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_FIRE_LANTERN = registerBlockItem("waxed_weathered_copper_fire_lantern", () -> ModBlocks.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get());
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_FIRE_LANTERN = registerBlockItem("waxed_oxidized_copper_fire_lantern", () -> ModBlocks.WAXED_OXIDIZED_COPPER_FIRE_LANTERN.get());

    public static final DeferredItem<BlockItem> ZINC_CHAIN = registerBlockItem("zinc_chain", () -> ModBlocks.ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> EXPOSED_ZINC_CHAIN = registerBlockItem("exposed_zinc_chain", () -> ModBlocks.EXPOSED_ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> WEATHERED_ZINC_CHAIN = registerBlockItem("weathered_zinc_chain", () -> ModBlocks.WEATHERED_ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> CORRODED_ZINC_CHAIN = registerBlockItem("corroded_zinc_chain", () -> ModBlocks.CORRODED_ZINC_CHAIN.get());

    public static final DeferredItem<BlockItem> WAXED_ZINC_CHAIN = registerBlockItem("waxed_zinc_chain", () -> ModBlocks.WAXED_ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC_CHAIN = registerBlockItem("waxed_exposed_zinc_chain", () -> ModBlocks.WAXED_EXPOSED_ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC_CHAIN = registerBlockItem("waxed_weathered_zinc_chain", () -> ModBlocks.WAXED_WEATHERED_ZINC_CHAIN.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC_CHAIN = registerBlockItem("waxed_corroded_zinc_chain", () -> ModBlocks.WAXED_CORRODED_ZINC_CHAIN.get());

    public static final DeferredItem<BlockItem> GOLD_CHAIN = registerBlockItem("gold_chain", () -> ModBlocks.GOLD_CHAIN.get());
    public static final DeferredItem<BlockItem> NETHERITE_CHAIN = registerBlockItem("netherite_chain", () -> ModBlocks.NETHERITE_CHAIN.get());
    public static final DeferredItem<BlockItem> SILVER_CHAIN = registerBlockItem("silver_chain", () -> ModBlocks.SILVER_CHAIN.get());
    public static final DeferredItem<BlockItem> TIN_CHAIN = registerBlockItem("tin_chain", () -> ModBlocks.TIN_CHAIN.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_CHAIN = registerBlockItem("tungsten_chain", () -> ModBlocks.TUNGSTEN_CHAIN.get());
    public static final DeferredItem<BlockItem> PLATINUM_CHAIN = registerBlockItem("platinum_chain", () -> ModBlocks.PLATINUM_CHAIN.get());
    public static final DeferredItem<BlockItem> LEAD_CHAIN = registerBlockItem("lead_chain", () -> ModBlocks.LEAD_CHAIN.get());
    public static final DeferredItem<BlockItem> URANIUM_CHAIN = registerBlockItem("uranium_chain", () -> ModBlocks.URANIUM_CHAIN.get());
    public static final DeferredItem<BlockItem> BRONZE_CHAIN = registerBlockItem("bronze_chain", () -> ModBlocks.BRONZE_CHAIN.get());
    public static final DeferredItem<BlockItem> BRASS_CHAIN = registerBlockItem("brass_chain", () -> ModBlocks.BRASS_CHAIN.get());
    public static final DeferredItem<BlockItem> STEEL_CHAIN = registerBlockItem("steel_chain", () -> ModBlocks.STEEL_CHAIN.get());

    public static final DeferredItem<StandingAndWallBlockItem> ZINC_TORCH = registerTorch("zinc_torch", () -> ModBlocks.ZINC_TORCH.get(), () -> ModBlocks.ZINC_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> SILVER_TORCH = registerTorch("silver_torch", () -> ModBlocks.SILVER_TORCH.get(), () -> ModBlocks.SILVER_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> TIN_TORCH = registerTorch("tin_torch", () -> ModBlocks.TIN_TORCH.get(), () -> ModBlocks.TIN_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> TUNGSTEN_TORCH = registerTorch("tungsten_torch", () -> ModBlocks.TUNGSTEN_TORCH.get(), () -> ModBlocks.TUNGSTEN_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> PLATINUM_TORCH = registerTorch("platinum_torch", () -> ModBlocks.PLATINUM_TORCH.get(), () -> ModBlocks.PLATINUM_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> GOLD_TORCH = registerTorch("gold_torch", () -> ModBlocks.GOLD_TORCH.get(), () -> ModBlocks.GOLD_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> LEAD_TORCH = registerTorch("lead_torch", () -> ModBlocks.LEAD_TORCH.get(), () -> ModBlocks.LEAD_WALL_TORCH.get());
    public static final DeferredItem<StandingAndWallBlockItem> URANIUM_TORCH = registerTorch("uranium_torch", () -> ModBlocks.URANIUM_TORCH.get(), () -> ModBlocks.URANIUM_WALL_TORCH.get());

    public static final DeferredItem<BlockItem> CUT_AMETHYST = registerBlockItem("cut_amethyst", () -> ModBlocks.CUT_AMETHYST.get());
    public static final DeferredItem<BlockItem> CUT_AMETHYST_SLAB = registerBlockItem("cut_amethyst_slab", () -> ModBlocks.CUT_AMETHYST_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_AMETHYST_STAIRS = registerBlockItem("cut_amethyst_stairs", () -> ModBlocks.CUT_AMETHYST_STAIRS.get());

    public static final DeferredItem<ExplosiveArrowItem> EXPLOSIVE_ARROW = registerExplosiveArrowItem("explosive_arrow");
    public static final DeferredItem<SharpenedArrowItem> SHARPENED_ARROW = registerSharpenedArrowItem("sharpened_arrow");
    public static final DeferredItem<StreamlinedArrowItem> STREAMLINED_ARROW = registerStreamlinedArrowItem("streamlined_arrow");

    public static final DeferredItem<BlockItem> GABBRO = registerBlockItem("gabbro", () -> ModBlocks.GABBRO.get());
    public static final DeferredItem<BlockItem> GABBRO_SLAB = registerBlockItem("gabbro_slab", () -> ModBlocks.GABBRO_SLAB.get());
    public static final DeferredItem<BlockItem> GABBRO_STAIRS = registerBlockItem("gabbro_stairs", () -> ModBlocks.GABBRO_STAIRS.get());
    public static final DeferredItem<BlockItem> GABBRO_WALL = registerBlockItem("gabbro_wall", () -> ModBlocks.GABBRO_WALL.get());
    public static final DeferredItem<BlockItem> GABBRO_FENCE = registerBlockItem("gabbro_fence", () -> ModBlocks.GABBRO_FENCE.get());

    public static final DeferredItem<BlockItem> POLISHED_GABBRO = registerBlockItem("polished_gabbro", () -> ModBlocks.POLISHED_GABBRO.get());
    public static final DeferredItem<BlockItem> POLISHED_GABBRO_SLAB = registerBlockItem("polished_gabbro_slab", () -> ModBlocks.POLISHED_GABBRO_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_GABBRO_STAIRS = registerBlockItem("polished_gabbro_stairs", () -> ModBlocks.POLISHED_GABBRO_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_GABBRO_WALL = registerBlockItem("polished_gabbro_wall", () -> ModBlocks.POLISHED_GABBRO_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_GABBRO_FENCE = registerBlockItem("polished_gabbro_fence", () -> ModBlocks.POLISHED_GABBRO_FENCE.get());

    public static final DeferredItem<BlockItem> GABBRO_BRICKS = registerBlockItem("gabbro_bricks", () -> ModBlocks.GABBRO_BRICKS.get());
    public static final DeferredItem<BlockItem> GABBRO_BRICK_SLAB = registerBlockItem("gabbro_brick_slab", () -> ModBlocks.GABBRO_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> GABBRO_BRICK_STAIRS = registerBlockItem("gabbro_brick_stairs", () -> ModBlocks.GABBRO_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> GABBRO_BRICK_WALL = registerBlockItem("gabbro_brick_wall", () -> ModBlocks.GABBRO_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> GABBRO_BRICK_FENCE = registerBlockItem("gabbro_brick_fence", () -> ModBlocks.GABBRO_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> RHYOLITE = registerBlockItem("rhyolite", () -> ModBlocks.RHYOLITE.get());
    public static final DeferredItem<BlockItem> RHYOLITE_SLAB = registerBlockItem("rhyolite_slab", () -> ModBlocks.RHYOLITE_SLAB.get());
    public static final DeferredItem<BlockItem> RHYOLITE_STAIRS = registerBlockItem("rhyolite_stairs", () -> ModBlocks.RHYOLITE_STAIRS.get());
    public static final DeferredItem<BlockItem> RHYOLITE_WALL = registerBlockItem("rhyolite_wall", () -> ModBlocks.RHYOLITE_WALL.get());
    public static final DeferredItem<BlockItem> RHYOLITE_FENCE = registerBlockItem("rhyolite_fence", () -> ModBlocks.RHYOLITE_FENCE.get());

    public static final DeferredItem<BlockItem> POLISHED_RHYOLITE = registerBlockItem("polished_rhyolite", () -> ModBlocks.POLISHED_RHYOLITE.get());
    public static final DeferredItem<BlockItem> POLISHED_RHYOLITE_SLAB = registerBlockItem("polished_rhyolite_slab", () -> ModBlocks.POLISHED_RHYOLITE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_RHYOLITE_STAIRS = registerBlockItem("polished_rhyolite_stairs", () -> ModBlocks.POLISHED_RHYOLITE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_RHYOLITE_WALL = registerBlockItem("polished_rhyolite_wall", () -> ModBlocks.POLISHED_RHYOLITE_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_RHYOLITE_FENCE = registerBlockItem("polished_rhyolite_fence", () -> ModBlocks.POLISHED_RHYOLITE_FENCE.get());

    public static final DeferredItem<BlockItem> RHYOLITE_BRICKS = registerBlockItem("rhyolite_bricks", () -> ModBlocks.RHYOLITE_BRICKS.get());
    public static final DeferredItem<BlockItem> RHYOLITE_BRICK_SLAB = registerBlockItem("rhyolite_brick_slab", () -> ModBlocks.RHYOLITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> RHYOLITE_BRICK_STAIRS = registerBlockItem("rhyolite_brick_stairs", () -> ModBlocks.RHYOLITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> RHYOLITE_BRICK_WALL = registerBlockItem("rhyolite_brick_wall", () -> ModBlocks.RHYOLITE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> RHYOLITE_BRICK_FENCE = registerBlockItem("rhyolite_brick_fence", () -> ModBlocks.RHYOLITE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PUMICE = registerBlockItem("pumice", () -> ModBlocks.PUMICE.get());
    public static final DeferredItem<BlockItem> PUMICE_SLAB = registerBlockItem("pumice_slab", () -> ModBlocks.PUMICE_SLAB.get());
    public static final DeferredItem<BlockItem> PUMICE_STAIRS = registerBlockItem("pumice_stairs", () -> ModBlocks.PUMICE_STAIRS.get());
    public static final DeferredItem<BlockItem> PUMICE_WALL = registerBlockItem("pumice_wall", () -> ModBlocks.PUMICE_WALL.get());
    public static final DeferredItem<BlockItem> PUMICE_FENCE = registerBlockItem("pumice_fence", () -> ModBlocks.PUMICE_FENCE.get());

    public static final DeferredItem<BlockItem> POLISHED_PUMICE = registerBlockItem("polished_pumice", () -> ModBlocks.POLISHED_PUMICE.get());
    public static final DeferredItem<BlockItem> POLISHED_PUMICE_SLAB = registerBlockItem("polished_pumice_slab", () -> ModBlocks.POLISHED_PUMICE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_PUMICE_STAIRS = registerBlockItem("polished_pumice_stairs", () -> ModBlocks.POLISHED_PUMICE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_PUMICE_WALL = registerBlockItem("polished_pumice_wall", () -> ModBlocks.POLISHED_PUMICE_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_PUMICE_FENCE = registerBlockItem("polished_pumice_fence", () -> ModBlocks.POLISHED_PUMICE_FENCE.get());

    public static final DeferredItem<BlockItem> PUMICE_BRICKS = registerBlockItem("pumice_bricks", () -> ModBlocks.PUMICE_BRICKS.get());
    public static final DeferredItem<BlockItem> PUMICE_BRICK_SLAB = registerBlockItem("pumice_brick_slab", () -> ModBlocks.PUMICE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PUMICE_BRICK_STAIRS = registerBlockItem("pumice_brick_stairs", () -> ModBlocks.PUMICE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PUMICE_BRICK_WALL = registerBlockItem("pumice_brick_wall", () -> ModBlocks.PUMICE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> PUMICE_BRICK_FENCE = registerBlockItem("pumice_brick_fence", () -> ModBlocks.PUMICE_BRICK_FENCE.get());

    public static final DeferredItem<Item> GABBRO_BATON = registerCustomItem("gabbro_baton");
    public static final DeferredItem<Item> RHYOLITE_BATON = registerCustomItem("rhyolite_baton");
    public static final DeferredItem<Item> PUMICE_BATON = registerCustomItem("pumice_baton");

    public static final DeferredItem<BlockItem> POLISHED_STONE = registerBlockItem("polished_stone", () -> ModBlocks.POLISHED_STONE.get());
    public static final DeferredItem<BlockItem> POLISHED_STONE_SLAB = registerBlockItem("polished_stone_slab", () -> ModBlocks.POLISHED_STONE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_STONE_STAIRS = registerBlockItem("polished_stone_stairs", () -> ModBlocks.POLISHED_STONE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_STONE_WALL = registerBlockItem("polished_stone_wall", () -> ModBlocks.POLISHED_STONE_WALL.get());
    public static final DeferredItem<BlockItem> POLISHED_STONE_FENCE = registerBlockItem("polished_stone_fence", () -> ModBlocks.POLISHED_STONE_FENCE.get());

    public static final DeferredItem<BlockItem> SMOOTH_DEEPSLATE = registerBlockItem("smooth_deepslate", () -> ModBlocks.SMOOTH_DEEPSLATE.get());
    public static final DeferredItem<BlockItem> SMOOTH_DEEPSLATE_SLAB = registerBlockItem("smooth_deepslate_slab", () -> ModBlocks.SMOOTH_DEEPSLATE_SLAB.get());
    public static final DeferredItem<BlockItem> SMOOTH_DEEPSLATE_STAIRS = registerBlockItem("smooth_deepslate_stairs", () -> ModBlocks.SMOOTH_DEEPSLATE_STAIRS.get());
    public static final DeferredItem<BlockItem> SMOOTH_DEEPSLATE_WALL = registerBlockItem("smooth_deepslate_wall", () -> ModBlocks.SMOOTH_DEEPSLATE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_DEEPSLATE_FENCE = registerBlockItem("smooth_deepslate_fence", () -> ModBlocks.SMOOTH_DEEPSLATE_FENCE.get());

    public static final DeferredItem<BlockItem> NETHERRACK_BRICKS = registerBlockItem("netherrack_bricks", () -> ModBlocks.NETHERRACK_BRICKS.get());
    public static final DeferredItem<BlockItem> NETHERRACK_BRICK_SLAB = registerBlockItem("netherrack_brick_slab", () -> ModBlocks.NETHERRACK_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> NETHERRACK_BRICK_STAIRS = registerBlockItem("netherrack_brick_stairs", () -> ModBlocks.NETHERRACK_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> NETHERRACK_BRICK_WALL = registerBlockItem("netherrack_brick_wall", () -> ModBlocks.NETHERRACK_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> NETHERRACK_BRICK_FENCE = registerBlockItem("netherrack_brick_fence", () -> ModBlocks.NETHERRACK_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> TERRACOTTA_BRICKS = registerBlockItem("terracotta_bricks", () -> ModBlocks.TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_BRICK_SLAB = registerBlockItem("terracotta_brick_slab", () -> ModBlocks.TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_BRICK_STAIRS = registerBlockItem("terracotta_brick_stairs", () -> ModBlocks.TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_BRICK_WALL = registerBlockItem("terracotta_brick_wall", () -> ModBlocks.TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> TERRACOTTA_BRICK_FENCE = registerBlockItem("terracotta_brick_fence", () -> ModBlocks.TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_BRICKS = registerBlockItem("white_terracotta_bricks", () -> ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_BRICK_SLAB = registerBlockItem("white_terracotta_brick_slab", () -> ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_BRICK_STAIRS = registerBlockItem("white_terracotta_brick_stairs", () -> ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_BRICK_WALL = registerBlockItem("white_terracotta_brick_wall", () -> ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> WHITE_TERRACOTTA_BRICK_FENCE = registerBlockItem("white_terracotta_brick_fence", () -> ModBlocks.WHITE_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_BRICKS = registerBlockItem("orange_terracotta_bricks", () -> ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_BRICK_SLAB = registerBlockItem("orange_terracotta_brick_slab", () -> ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_BRICK_STAIRS = registerBlockItem("orange_terracotta_brick_stairs", () -> ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_BRICK_WALL = registerBlockItem("orange_terracotta_brick_wall", () -> ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> ORANGE_TERRACOTTA_BRICK_FENCE = registerBlockItem("orange_terracotta_brick_fence", () -> ModBlocks.ORANGE_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_BRICKS = registerBlockItem("magenta_terracotta_bricks", () -> ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_BRICK_SLAB = registerBlockItem("magenta_terracotta_brick_slab", () -> ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_BRICK_STAIRS = registerBlockItem("magenta_terracotta_brick_stairs", () -> ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_BRICK_WALL = registerBlockItem("magenta_terracotta_brick_wall", () -> ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> MAGENTA_TERRACOTTA_BRICK_FENCE = registerBlockItem("magenta_terracotta_brick_fence", () -> ModBlocks.MAGENTA_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlockItem("light_blue_terracotta_bricks", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = registerBlockItem("light_blue_terracotta_brick_slab", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = registerBlockItem("light_blue_terracotta_brick_stairs", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = registerBlockItem("light_blue_terracotta_brick_wall", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TERRACOTTA_BRICK_FENCE = registerBlockItem("light_blue_terracotta_brick_fence", () -> ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_BRICKS = registerBlockItem("yellow_terracotta_bricks", () -> ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_BRICK_SLAB = registerBlockItem("yellow_terracotta_brick_slab", () -> ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_BRICK_STAIRS = registerBlockItem("yellow_terracotta_brick_stairs", () -> ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_BRICK_WALL = registerBlockItem("yellow_terracotta_brick_wall", () -> ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> YELLOW_TERRACOTTA_BRICK_FENCE = registerBlockItem("yellow_terracotta_brick_fence", () -> ModBlocks.YELLOW_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_BRICKS = registerBlockItem("lime_terracotta_bricks", () -> ModBlocks.LIME_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_BRICK_SLAB = registerBlockItem("lime_terracotta_brick_slab", () -> ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_BRICK_STAIRS = registerBlockItem("lime_terracotta_brick_stairs", () -> ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_BRICK_WALL = registerBlockItem("lime_terracotta_brick_wall", () -> ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIME_TERRACOTTA_BRICK_FENCE = registerBlockItem("lime_terracotta_brick_fence", () -> ModBlocks.LIME_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_BRICKS = registerBlockItem("pink_terracotta_bricks", () -> ModBlocks.PINK_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_BRICK_SLAB = registerBlockItem("pink_terracotta_brick_slab", () -> ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_BRICK_STAIRS = registerBlockItem("pink_terracotta_brick_stairs", () -> ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_BRICK_WALL = registerBlockItem("pink_terracotta_brick_wall", () -> ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> PINK_TERRACOTTA_BRICK_FENCE = registerBlockItem("pink_terracotta_brick_fence", () -> ModBlocks.PINK_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_BRICKS = registerBlockItem("gray_terracotta_bricks", () -> ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_BRICK_SLAB = registerBlockItem("gray_terracotta_brick_slab", () -> ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_BRICK_STAIRS = registerBlockItem("gray_terracotta_brick_stairs", () -> ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_BRICK_WALL = registerBlockItem("gray_terracotta_brick_wall", () -> ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> GRAY_TERRACOTTA_BRICK_FENCE = registerBlockItem("gray_terracotta_brick_fence", () -> ModBlocks.GRAY_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlockItem("light_gray_terracotta_bricks", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = registerBlockItem("light_gray_terracotta_brick_slab", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = registerBlockItem("light_gray_terracotta_brick_stairs", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = registerBlockItem("light_gray_terracotta_brick_wall", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TERRACOTTA_BRICK_FENCE = registerBlockItem("light_gray_terracotta_brick_fence", () -> ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_BRICKS = registerBlockItem("cyan_terracotta_bricks", () -> ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_BRICK_SLAB = registerBlockItem("cyan_terracotta_brick_slab", () -> ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_BRICK_STAIRS = registerBlockItem("cyan_terracotta_brick_stairs", () -> ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_BRICK_WALL = registerBlockItem("cyan_terracotta_brick_wall", () -> ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> CYAN_TERRACOTTA_BRICK_FENCE = registerBlockItem("cyan_terracotta_brick_fence", () -> ModBlocks.CYAN_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_BRICKS = registerBlockItem("purple_terracotta_bricks", () -> ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_BRICK_SLAB = registerBlockItem("purple_terracotta_brick_slab", () -> ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_BRICK_STAIRS = registerBlockItem("purple_terracotta_brick_stairs", () -> ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_BRICK_WALL = registerBlockItem("purple_terracotta_brick_wall", () -> ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> PURPLE_TERRACOTTA_BRICK_FENCE = registerBlockItem("purple_terracotta_brick_fence", () -> ModBlocks.PURPLE_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_BRICKS = registerBlockItem("blue_terracotta_bricks", () -> ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_BRICK_SLAB = registerBlockItem("blue_terracotta_brick_slab", () -> ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_BRICK_STAIRS = registerBlockItem("blue_terracotta_brick_stairs", () -> ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_BRICK_WALL = registerBlockItem("blue_terracotta_brick_wall", () -> ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BLUE_TERRACOTTA_BRICK_FENCE = registerBlockItem("blue_terracotta_brick_fence", () -> ModBlocks.BLUE_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_BRICKS = registerBlockItem("brown_terracotta_bricks", () -> ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_BRICK_SLAB = registerBlockItem("brown_terracotta_brick_slab", () -> ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_BRICK_STAIRS = registerBlockItem("brown_terracotta_brick_stairs", () -> ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_BRICK_WALL = registerBlockItem("brown_terracotta_brick_wall", () -> ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BROWN_TERRACOTTA_BRICK_FENCE = registerBlockItem("brown_terracotta_brick_fence", () -> ModBlocks.BROWN_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_BRICKS = registerBlockItem("green_terracotta_bricks", () -> ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_BRICK_SLAB = registerBlockItem("green_terracotta_brick_slab", () -> ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_BRICK_STAIRS = registerBlockItem("green_terracotta_brick_stairs", () -> ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_BRICK_WALL = registerBlockItem("green_terracotta_brick_wall", () -> ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> GREEN_TERRACOTTA_BRICK_FENCE = registerBlockItem("green_terracotta_brick_fence", () -> ModBlocks.GREEN_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> RED_TERRACOTTA_BRICKS = registerBlockItem("red_terracotta_bricks", () -> ModBlocks.RED_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_BRICK_SLAB = registerBlockItem("red_terracotta_brick_slab", () -> ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_BRICK_STAIRS = registerBlockItem("red_terracotta_brick_stairs", () -> ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_BRICK_WALL = registerBlockItem("red_terracotta_brick_wall", () -> ModBlocks.RED_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> RED_TERRACOTTA_BRICK_FENCE = registerBlockItem("red_terracotta_brick_fence", () -> ModBlocks.RED_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_BRICKS = registerBlockItem("black_terracotta_bricks", () -> ModBlocks.BLACK_TERRACOTTA_BRICKS.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_BRICK_SLAB = registerBlockItem("black_terracotta_brick_slab", () -> ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_BRICK_STAIRS = registerBlockItem("black_terracotta_brick_stairs", () -> ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_BRICK_WALL = registerBlockItem("black_terracotta_brick_wall", () -> ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BLACK_TERRACOTTA_BRICK_FENCE = registerBlockItem("black_terracotta_brick_fence", () -> ModBlocks.BLACK_TERRACOTTA_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BIG_BRICKS = registerBlockItem("big_bricks", () -> ModBlocks.BIG_BRICKS.get());
    public static final DeferredItem<BlockItem> BIG_BRICK_SLAB = registerBlockItem("big_brick_slab", () -> ModBlocks.BIG_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BIG_BRICK_STAIRS = registerBlockItem("big_brick_stairs", () -> ModBlocks.BIG_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BIG_BRICK_WALL = registerBlockItem("big_brick_wall", () -> ModBlocks.BIG_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BIG_BRICK_FENCE = registerBlockItem("big_brick_fence", () -> ModBlocks.BIG_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> WHITE_CONCRETE_BRICKS = registerBlockItem("white_concrete_bricks", () -> ModBlocks.WHITE_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_BRICK_SLAB = registerBlockItem("white_concrete_brick_slab", () -> ModBlocks.WHITE_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_BRICK_STAIRS = registerBlockItem("white_concrete_brick_stairs", () -> ModBlocks.WHITE_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_BRICK_WALL = registerBlockItem("white_concrete_brick_wall", () -> ModBlocks.WHITE_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> WHITE_CONCRETE_BRICK_FENCE = registerBlockItem("white_concrete_brick_fence", () -> ModBlocks.WHITE_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_BRICKS = registerBlockItem("orange_concrete_bricks", () -> ModBlocks.ORANGE_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_BRICK_SLAB = registerBlockItem("orange_concrete_brick_slab", () -> ModBlocks.ORANGE_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_BRICK_STAIRS = registerBlockItem("orange_concrete_brick_stairs", () -> ModBlocks.ORANGE_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_BRICK_WALL = registerBlockItem("orange_concrete_brick_wall", () -> ModBlocks.ORANGE_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> ORANGE_CONCRETE_BRICK_FENCE = registerBlockItem("orange_concrete_brick_fence", () -> ModBlocks.ORANGE_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_BRICKS = registerBlockItem("magenta_concrete_bricks", () -> ModBlocks.MAGENTA_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_BRICK_SLAB = registerBlockItem("magenta_concrete_brick_slab", () -> ModBlocks.MAGENTA_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_BRICK_STAIRS = registerBlockItem("magenta_concrete_brick_stairs", () -> ModBlocks.MAGENTA_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_BRICK_WALL = registerBlockItem("magenta_concrete_brick_wall", () -> ModBlocks.MAGENTA_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> MAGENTA_CONCRETE_BRICK_FENCE = registerBlockItem("magenta_concrete_brick_fence", () -> ModBlocks.MAGENTA_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_BRICKS = registerBlockItem("light_blue_concrete_bricks", () -> ModBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_BRICK_SLAB = registerBlockItem("light_blue_concrete_brick_slab", () -> ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_BRICK_STAIRS = registerBlockItem("light_blue_concrete_brick_stairs", () -> ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_BRICK_WALL = registerBlockItem("light_blue_concrete_brick_wall", () -> ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CONCRETE_BRICK_FENCE = registerBlockItem("light_blue_concrete_brick_fence", () -> ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_BRICKS = registerBlockItem("yellow_concrete_bricks", () -> ModBlocks.YELLOW_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_BRICK_SLAB = registerBlockItem("yellow_concrete_brick_slab", () -> ModBlocks.YELLOW_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_BRICK_STAIRS = registerBlockItem("yellow_concrete_brick_stairs", () -> ModBlocks.YELLOW_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_BRICK_WALL = registerBlockItem("yellow_concrete_brick_wall", () -> ModBlocks.YELLOW_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> YELLOW_CONCRETE_BRICK_FENCE = registerBlockItem("yellow_concrete_brick_fence", () -> ModBlocks.YELLOW_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIME_CONCRETE_BRICKS = registerBlockItem("lime_concrete_bricks", () -> ModBlocks.LIME_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_BRICK_SLAB = registerBlockItem("lime_concrete_brick_slab", () -> ModBlocks.LIME_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_BRICK_STAIRS = registerBlockItem("lime_concrete_brick_stairs", () -> ModBlocks.LIME_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_BRICK_WALL = registerBlockItem("lime_concrete_brick_wall", () -> ModBlocks.LIME_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIME_CONCRETE_BRICK_FENCE = registerBlockItem("lime_concrete_brick_fence", () -> ModBlocks.LIME_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PINK_CONCRETE_BRICKS = registerBlockItem("pink_concrete_bricks", () -> ModBlocks.PINK_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_BRICK_SLAB = registerBlockItem("pink_concrete_brick_slab", () -> ModBlocks.PINK_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_BRICK_STAIRS = registerBlockItem("pink_concrete_brick_stairs", () -> ModBlocks.PINK_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_BRICK_WALL = registerBlockItem("pink_concrete_brick_wall", () -> ModBlocks.PINK_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> PINK_CONCRETE_BRICK_FENCE = registerBlockItem("pink_concrete_brick_fence", () -> ModBlocks.PINK_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> GRAY_CONCRETE_BRICKS = registerBlockItem("gray_concrete_bricks", () -> ModBlocks.GRAY_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_BRICK_SLAB = registerBlockItem("gray_concrete_brick_slab", () -> ModBlocks.GRAY_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_BRICK_STAIRS = registerBlockItem("gray_concrete_brick_stairs", () -> ModBlocks.GRAY_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_BRICK_WALL = registerBlockItem("gray_concrete_brick_wall", () -> ModBlocks.GRAY_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> GRAY_CONCRETE_BRICK_FENCE = registerBlockItem("gray_concrete_brick_fence", () -> ModBlocks.GRAY_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_BRICKS = registerBlockItem("light_gray_concrete_bricks", () -> ModBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_BRICK_SLAB = registerBlockItem("light_gray_concrete_brick_slab", () -> ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_BRICK_STAIRS = registerBlockItem("light_gray_concrete_brick_stairs", () -> ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_BRICK_WALL = registerBlockItem("light_gray_concrete_brick_wall", () -> ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CONCRETE_BRICK_FENCE = registerBlockItem("light_gray_concrete_brick_fence", () -> ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CYAN_CONCRETE_BRICKS = registerBlockItem("cyan_concrete_bricks", () -> ModBlocks.CYAN_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_BRICK_SLAB = registerBlockItem("cyan_concrete_brick_slab", () -> ModBlocks.CYAN_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_BRICK_STAIRS = registerBlockItem("cyan_concrete_brick_stairs", () -> ModBlocks.CYAN_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_BRICK_WALL = registerBlockItem("cyan_concrete_brick_wall", () -> ModBlocks.CYAN_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> CYAN_CONCRETE_BRICK_FENCE = registerBlockItem("cyan_concrete_brick_fence", () -> ModBlocks.CYAN_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_BRICKS = registerBlockItem("purple_concrete_bricks", () -> ModBlocks.PURPLE_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_BRICK_SLAB = registerBlockItem("purple_concrete_brick_slab", () -> ModBlocks.PURPLE_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_BRICK_STAIRS = registerBlockItem("purple_concrete_brick_stairs", () -> ModBlocks.PURPLE_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_BRICK_WALL = registerBlockItem("purple_concrete_brick_wall", () -> ModBlocks.PURPLE_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> PURPLE_CONCRETE_BRICK_FENCE = registerBlockItem("purple_concrete_brick_fence", () -> ModBlocks.PURPLE_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BLUE_CONCRETE_BRICKS = registerBlockItem("blue_concrete_bricks", () -> ModBlocks.BLUE_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_BRICK_SLAB = registerBlockItem("blue_concrete_brick_slab", () -> ModBlocks.BLUE_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_BRICK_STAIRS = registerBlockItem("blue_concrete_brick_stairs", () -> ModBlocks.BLUE_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_BRICK_WALL = registerBlockItem("blue_concrete_brick_wall", () -> ModBlocks.BLUE_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BLUE_CONCRETE_BRICK_FENCE = registerBlockItem("blue_concrete_brick_fence", () -> ModBlocks.BLUE_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BROWN_CONCRETE_BRICKS = registerBlockItem("brown_concrete_bricks", () -> ModBlocks.BROWN_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_BRICK_SLAB = registerBlockItem("brown_concrete_brick_slab", () -> ModBlocks.BROWN_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_BRICK_STAIRS = registerBlockItem("brown_concrete_brick_stairs", () -> ModBlocks.BROWN_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_BRICK_WALL = registerBlockItem("brown_concrete_brick_wall", () -> ModBlocks.BROWN_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BROWN_CONCRETE_BRICK_FENCE = registerBlockItem("brown_concrete_brick_fence", () -> ModBlocks.BROWN_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> GREEN_CONCRETE_BRICKS = registerBlockItem("green_concrete_bricks", () -> ModBlocks.GREEN_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_BRICK_SLAB = registerBlockItem("green_concrete_brick_slab", () -> ModBlocks.GREEN_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_BRICK_STAIRS = registerBlockItem("green_concrete_brick_stairs", () -> ModBlocks.GREEN_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_BRICK_WALL = registerBlockItem("green_concrete_brick_wall", () -> ModBlocks.GREEN_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> GREEN_CONCRETE_BRICK_FENCE = registerBlockItem("green_concrete_brick_fence", () -> ModBlocks.GREEN_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> RED_CONCRETE_BRICKS = registerBlockItem("red_concrete_bricks", () -> ModBlocks.RED_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_BRICK_SLAB = registerBlockItem("red_concrete_brick_slab", () -> ModBlocks.RED_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_BRICK_STAIRS = registerBlockItem("red_concrete_brick_stairs", () -> ModBlocks.RED_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_BRICK_WALL = registerBlockItem("red_concrete_brick_wall", () -> ModBlocks.RED_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> RED_CONCRETE_BRICK_FENCE = registerBlockItem("red_concrete_brick_fence", () -> ModBlocks.RED_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> BLACK_CONCRETE_BRICKS = registerBlockItem("black_concrete_bricks", () -> ModBlocks.BLACK_CONCRETE_BRICKS.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_BRICK_SLAB = registerBlockItem("black_concrete_brick_slab", () -> ModBlocks.BLACK_CONCRETE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_BRICK_STAIRS = registerBlockItem("black_concrete_brick_stairs", () -> ModBlocks.BLACK_CONCRETE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_BRICK_WALL = registerBlockItem("black_concrete_brick_wall", () -> ModBlocks.BLACK_CONCRETE_BRICK_WALL.get());
    public static final DeferredItem<BlockItem> BLACK_CONCRETE_BRICK_FENCE = registerBlockItem("black_concrete_brick_fence", () -> ModBlocks.BLACK_CONCRETE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> GILDED_BLACKSTONE_SLAB = registerBlockItem("gilded_blackstone_slab", () -> ModBlocks.GILDED_BLACKSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> GILDED_BLACKSTONE_STAIRS = registerBlockItem("gilded_blackstone_stairs", () -> ModBlocks.GILDED_BLACKSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> GILDED_BLACKSTONE_WALL = registerBlockItem("gilded_blackstone_wall", () -> ModBlocks.GILDED_BLACKSTONE_WALL.get());
    public static final DeferredItem<BlockItem> GILDED_BLACKSTONE_FENCE = registerBlockItem("gilded_blackstone_fence", () -> ModBlocks.GILDED_BLACKSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> TINTED_GLASS_PANE = registerBlockItem("tinted_glass_pane", () -> ModBlocks.TINTED_GLASS_PANE.get());

    public static final DeferredItem<BlockItem> GLASS_DOOR = registerBlockItem("glass_door", () -> ModBlocks.GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> TINTED_GLASS_DOOR = registerBlockItem("tinted_glass_door", () -> ModBlocks.TINTED_GLASS_DOOR.get());

    public static final DeferredItem<BlockItem> WHITE_STAINED_GLASS_DOOR = registerBlockItem("white_stained_glass_door", () -> ModBlocks.WHITE_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> ORANGE_STAINED_GLASS_DOOR = registerBlockItem("orange_stained_glass_door", () -> ModBlocks.ORANGE_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> MAGENTA_STAINED_GLASS_DOOR = registerBlockItem("magenta_stained_glass_door", () -> ModBlocks.MAGENTA_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_STAINED_GLASS_DOOR = registerBlockItem("light_blue_stained_glass_door", () -> ModBlocks.LIGHT_BLUE_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> YELLOW_STAINED_GLASS_DOOR = registerBlockItem("yellow_stained_glass_door", () -> ModBlocks.YELLOW_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> LIME_STAINED_GLASS_DOOR = registerBlockItem("lime_stained_glass_door", () -> ModBlocks.LIME_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> PINK_STAINED_GLASS_DOOR = registerBlockItem("pink_stained_glass_door", () -> ModBlocks.PINK_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> GRAY_STAINED_GLASS_DOOR = registerBlockItem("gray_stained_glass_door", () -> ModBlocks.GRAY_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_STAINED_GLASS_DOOR = registerBlockItem("light_gray_stained_glass_door", () -> ModBlocks.LIGHT_GRAY_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> CYAN_STAINED_GLASS_DOOR = registerBlockItem("cyan_stained_glass_door", () -> ModBlocks.CYAN_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> PURPLE_STAINED_GLASS_DOOR = registerBlockItem("purple_stained_glass_door", () -> ModBlocks.PURPLE_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> BLUE_STAINED_GLASS_DOOR = registerBlockItem("blue_stained_glass_door", () -> ModBlocks.BLUE_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> BROWN_STAINED_GLASS_DOOR = registerBlockItem("brown_stained_glass_door", () -> ModBlocks.BROWN_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> GREEN_STAINED_GLASS_DOOR = registerBlockItem("green_stained_glass_door", () -> ModBlocks.GREEN_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> RED_STAINED_GLASS_DOOR = registerBlockItem("red_stained_glass_door", () -> ModBlocks.RED_STAINED_GLASS_DOOR.get());
    public static final DeferredItem<BlockItem> BLACK_STAINED_GLASS_DOOR = registerBlockItem("black_stained_glass_door", () -> ModBlocks.BLACK_STAINED_GLASS_DOOR.get());

    public static final DeferredItem<BlockItem> GLASS_TRAPDOOR = registerBlockItem("glass_trapdoor", () -> ModBlocks.GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> TINTED_GLASS_TRAPDOOR = registerBlockItem("tinted_glass_trapdoor", () -> ModBlocks.TINTED_GLASS_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> WHITE_STAINED_GLASS_TRAPDOOR = registerBlockItem("white_stained_glass_trapdoor", () -> ModBlocks.WHITE_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> ORANGE_STAINED_GLASS_TRAPDOOR = registerBlockItem("orange_stained_glass_trapdoor", () -> ModBlocks.ORANGE_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> MAGENTA_STAINED_GLASS_TRAPDOOR = registerBlockItem("magenta_stained_glass_trapdoor", () -> ModBlocks.MAGENTA_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = registerBlockItem("light_blue_stained_glass_trapdoor", () -> ModBlocks.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> YELLOW_STAINED_GLASS_TRAPDOOR = registerBlockItem("yellow_stained_glass_trapdoor", () -> ModBlocks.YELLOW_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> LIME_STAINED_GLASS_TRAPDOOR = registerBlockItem("lime_stained_glass_trapdoor", () -> ModBlocks.LIME_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> PINK_STAINED_GLASS_TRAPDOOR = registerBlockItem("pink_stained_glass_trapdoor", () -> ModBlocks.PINK_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> GRAY_STAINED_GLASS_TRAPDOOR = registerBlockItem("gray_stained_glass_trapdoor", () -> ModBlocks.GRAY_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = registerBlockItem("light_gray_stained_glass_trapdoor", () -> ModBlocks.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> CYAN_STAINED_GLASS_TRAPDOOR = registerBlockItem("cyan_stained_glass_trapdoor", () -> ModBlocks.CYAN_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> PURPLE_STAINED_GLASS_TRAPDOOR = registerBlockItem("purple_stained_glass_trapdoor", () -> ModBlocks.PURPLE_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BLUE_STAINED_GLASS_TRAPDOOR = registerBlockItem("blue_stained_glass_trapdoor", () -> ModBlocks.BLUE_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BROWN_STAINED_GLASS_TRAPDOOR = registerBlockItem("brown_stained_glass_trapdoor", () -> ModBlocks.BROWN_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> GREEN_STAINED_GLASS_TRAPDOOR = registerBlockItem("green_stained_glass_trapdoor", () -> ModBlocks.GREEN_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> RED_STAINED_GLASS_TRAPDOOR = registerBlockItem("red_stained_glass_trapdoor", () -> ModBlocks.RED_STAINED_GLASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BLACK_STAINED_GLASS_TRAPDOOR = registerBlockItem("black_stained_glass_trapdoor", () -> ModBlocks.BLACK_STAINED_GLASS_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> CHISELED_PRISMARINE = registerBlockItem("chiseled_prismarine", () -> ModBlocks.CHISELED_PRISMARINE.get());
    public static final DeferredItem<BlockItem> CHISELED_PRISMARINE_BRICKS = registerBlockItem("chiseled_prismarine_bricks", () -> ModBlocks.CHISELED_PRISMARINE_BRICKS.get());

    public static final DeferredItem<BlockItem> CHISELED_ELDER_PRISMARINE = registerBlockItem("chiseled_elder_prismarine", () -> ModBlocks.CHISELED_ELDER_PRISMARINE.get());
    public static final DeferredItem<BlockItem> CHISELED_ELDER_PRISMARINE_BRICKS = registerBlockItem("chiseled_elder_prismarine_bricks", () -> ModBlocks.CHISELED_ELDER_PRISMARINE_BRICKS.get());

    public static final DeferredItem<Item> HEART_BANNER_PATTERN = registerBannerTemplate("heart_banner_pattern", ModBannerPatternTags.PATTERN_ITEM_HEART);
    public static final DeferredItem<Item> DIAMOND_BANNER_PATTERN = registerBannerTemplate("diamond_banner_pattern", ModBannerPatternTags.PATTERN_ITEM_DIAMOND);
    public static final DeferredItem<Item> SPADE_BANNER_PATTERN = registerBannerTemplate("spade_banner_pattern", ModBannerPatternTags.PATTERN_ITEM_SPADE);
    public static final DeferredItem<Item> CLUB_BANNER_PATTERN = registerBannerTemplate("club_banner_pattern", ModBannerPatternTags.PATTERN_ITEM_CLUB);

    public static final DeferredItem<BlockItem> LAPIS_PILLAR = registerBlockItem("lapis_pillar", () -> ModBlocks.LAPIS_PILLAR.get());
    public static final DeferredItem<BlockItem> CHISELED_LAPIS = registerBlockItem("chiseled_lapis", () -> ModBlocks.CHISELED_LAPIS.get());

    public static final DeferredItem<BlockItem> IRON_GRATE = registerBlockItem("iron_grate", () -> ModBlocks.IRON_GRATE.get());
    public static final DeferredItem<BlockItem> EXPOSED_IRON_GRATE = registerBlockItem("exposed_iron_grate", () -> ModBlocks.EXPOSED_IRON_GRATE.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_GRATE = registerBlockItem("weathered_iron_grate", () -> ModBlocks.WEATHERED_IRON_GRATE.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_GRATE = registerBlockItem("rusted_iron_grate", () -> ModBlocks.RUSTED_IRON_GRATE.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_GRATE = registerBlockItem("waxed_iron_grate", () -> ModBlocks.WAXED_IRON_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_GRATE = registerBlockItem("waxed_exposed_iron_grate", () -> ModBlocks.WAXED_EXPOSED_IRON_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_GRATE = registerBlockItem("waxed_weathered_iron_grate", () -> ModBlocks.WAXED_WEATHERED_IRON_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_GRATE = registerBlockItem("waxed_rusted_iron_grate", () -> ModBlocks.WAXED_RUSTED_IRON_GRATE.get());

    public static final DeferredItem<BlockItem> ZINC_GRATE = registerBlockItem("zinc_grate", () -> ModBlocks.ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> EXPOSED_ZINC_GRATE = registerBlockItem("exposed_zinc_grate", () -> ModBlocks.EXPOSED_ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> WEATHERED_ZINC_GRATE = registerBlockItem("weathered_zinc_grate", () -> ModBlocks.WEATHERED_ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> CORRODED_ZINC_GRATE = registerBlockItem("corroded_zinc_grate", () -> ModBlocks.CORRODED_ZINC_GRATE.get());

    public static final DeferredItem<BlockItem> WAXED_ZINC_GRATE = registerBlockItem("waxed_zinc_grate", () -> ModBlocks.WAXED_ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC_GRATE = registerBlockItem("waxed_exposed_zinc_grate", () -> ModBlocks.WAXED_EXPOSED_ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC_GRATE = registerBlockItem("waxed_weathered_zinc_grate", () -> ModBlocks.WAXED_WEATHERED_ZINC_GRATE.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC_GRATE = registerBlockItem("waxed_corroded_zinc_grate", () -> ModBlocks.WAXED_CORRODED_ZINC_GRATE.get());

    public static final DeferredItem<BlockItem> SILVER_GRATE = registerBlockItem("silver_grate", () -> ModBlocks.SILVER_GRATE.get());
    public static final DeferredItem<BlockItem> TIN_GRATE = registerBlockItem("tin_grate", () -> ModBlocks.TIN_GRATE.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_GRATE = registerBlockItem("tungsten_grate", () -> ModBlocks.TUNGSTEN_GRATE.get());
    public static final DeferredItem<BlockItem> PLATINUM_GRATE = registerBlockItem("platinum_grate", () -> ModBlocks.PLATINUM_GRATE.get());
    public static final DeferredItem<BlockItem> GOLD_GRATE = registerBlockItem("gold_grate", () -> ModBlocks.GOLD_GRATE.get());
    public static final DeferredItem<BlockItem> LEAD_GRATE = registerBlockItem("lead_grate", () -> ModBlocks.LEAD_GRATE.get());
    public static final DeferredItem<BlockItem> URANIUM_GRATE = registerBlockItem("uranium_grate", () -> ModBlocks.URANIUM_GRATE.get());

    public static final DeferredItem<BlockItem> NETHERITE_GRATE = registerBlockItem("netherite_grate", () -> ModBlocks.NETHERITE_GRATE.get());
    public static final DeferredItem<BlockItem> BRONZE_GRATE = registerBlockItem("bronze_grate", () -> ModBlocks.BRONZE_GRATE.get());
    public static final DeferredItem<BlockItem> BRASS_GRATE = registerBlockItem("brass_grate", () -> ModBlocks.BRASS_GRATE.get());
    public static final DeferredItem<BlockItem> STEEL_GRATE = registerBlockItem("steel_grate", () -> ModBlocks.STEEL_GRATE.get());

    public static final DeferredItem<BlockItem> IRON_BULB = registerBlockItem("iron_bulb", () -> ModBlocks.IRON_BULB.get());
    public static final DeferredItem<BlockItem> EXPOSED_IRON_BULB = registerBlockItem("exposed_iron_bulb", () -> ModBlocks.EXPOSED_IRON_BULB.get());
    public static final DeferredItem<BlockItem> WEATHERED_IRON_BULB = registerBlockItem("weathered_iron_bulb", () -> ModBlocks.WEATHERED_IRON_BULB.get());
    public static final DeferredItem<BlockItem> RUSTED_IRON_BULB = registerBlockItem("rusted_iron_bulb", () -> ModBlocks.RUSTED_IRON_BULB.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_BULB = registerBlockItem("waxed_iron_bulb", () -> ModBlocks.WAXED_IRON_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_IRON_BULB = registerBlockItem("waxed_exposed_iron_bulb", () -> ModBlocks.WAXED_EXPOSED_IRON_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_IRON_BULB = registerBlockItem("waxed_weathered_iron_bulb", () -> ModBlocks.WAXED_WEATHERED_IRON_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_RUSTED_IRON_BULB = registerBlockItem("waxed_rusted_iron_bulb", () -> ModBlocks.WAXED_RUSTED_IRON_BULB.get());

    public static final DeferredItem<BlockItem> ZINC_BULB = registerBlockItem("zinc_bulb", () -> ModBlocks.ZINC_BULB.get());
    public static final DeferredItem<BlockItem> EXPOSED_ZINC_BULB = registerBlockItem("exposed_zinc_bulb", () -> ModBlocks.EXPOSED_ZINC_BULB.get());
    public static final DeferredItem<BlockItem> WEATHERED_ZINC_BULB = registerBlockItem("weathered_zinc_bulb", () -> ModBlocks.WEATHERED_ZINC_BULB.get());
    public static final DeferredItem<BlockItem> CORRODED_ZINC_BULB = registerBlockItem("corroded_zinc_bulb", () -> ModBlocks.CORRODED_ZINC_BULB.get());

    public static final DeferredItem<BlockItem> WAXED_ZINC_BULB = registerBlockItem("waxed_zinc_bulb", () -> ModBlocks.WAXED_ZINC_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_ZINC_BULB = registerBlockItem("waxed_exposed_zinc_bulb", () -> ModBlocks.WAXED_EXPOSED_ZINC_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_ZINC_BULB = registerBlockItem("waxed_weathered_zinc_bulb", () -> ModBlocks.WAXED_WEATHERED_ZINC_BULB.get());
    public static final DeferredItem<BlockItem> WAXED_CORRODED_ZINC_BULB = registerBlockItem("waxed_corroded_zinc_bulb", () -> ModBlocks.WAXED_CORRODED_ZINC_BULB.get());

    public static final DeferredItem<BlockItem> SILVER_BULB = registerBlockItem("silver_bulb", () -> ModBlocks.SILVER_BULB.get());
    public static final DeferredItem<BlockItem> TIN_BULB = registerBlockItem("tin_bulb", () -> ModBlocks.TIN_BULB.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_BULB = registerBlockItem("tungsten_bulb", () -> ModBlocks.TUNGSTEN_BULB.get());
    public static final DeferredItem<BlockItem> PLATINUM_BULB = registerBlockItem("platinum_bulb", () -> ModBlocks.PLATINUM_BULB.get());
    public static final DeferredItem<BlockItem> GOLD_BULB = registerBlockItem("gold_bulb", () -> ModBlocks.GOLD_BULB.get());
    public static final DeferredItem<BlockItem> LEAD_BULB = registerBlockItem("lead_bulb", () -> ModBlocks.LEAD_BULB.get());
    public static final DeferredItem<BlockItem> URANIUM_BULB = registerBlockItem("uranium_bulb", () -> ModBlocks.URANIUM_BULB.get());

    public static final DeferredItem<BlockItem> NETHERITE_BULB = registerBlockItem("netherite_bulb", () -> ModBlocks.NETHERITE_BULB.get());
    public static final DeferredItem<BlockItem> BRONZE_BULB = registerBlockItem("bronze_bulb", () -> ModBlocks.BRONZE_BULB.get());
    public static final DeferredItem<BlockItem> BRASS_BULB = registerBlockItem("brass_bulb", () -> ModBlocks.BRASS_BULB.get());
    public static final DeferredItem<BlockItem> STEEL_BULB = registerBlockItem("steel_bulb", () -> ModBlocks.STEEL_BULB.get());

    public static final DeferredItem<BlockItem> SULFUR_FENCE = registerBlockItem("sulfur_fence", () -> ModBlocks.SULFUR_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_SULFUR_FENCE = registerBlockItem("polished_sulfur_fence", () -> ModBlocks.POLISHED_SULFUR_FENCE.get());
    public static final DeferredItem<BlockItem> SULFUR_BRICK_FENCE = registerBlockItem("sulfur_brick_fence", () -> ModBlocks.SULFUR_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> CINNABAR_FENCE = registerBlockItem("cinnabar_fence", () -> ModBlocks.CINNABAR_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_CINNABAR_FENCE = registerBlockItem("polished_cinnabar_fence", () -> ModBlocks.POLISHED_CINNABAR_FENCE.get());
    public static final DeferredItem<BlockItem> CINNABAR_BRICK_FENCE = registerBlockItem("cinnabar_brick_fence", () -> ModBlocks.CINNABAR_BRICK_FENCE.get());

    public static final DeferredItem<Item> CINNABAR_BATON = registerCustomItem("cinnabar_baton");

    private static DeferredItem<Item> registerCustomItem(String registryName) {
        if (registryName.contains("netherite")) {
            return ITEMS.register(
                    registryName, () -> new Item(
                            new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).fireResistant()
                    )
            );
        } else {
            return ITEMS.register(
                    registryName, () -> new Item(
                            new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        }
    }

    private static DeferredItem<Item> registerTrimmableItem(String registryName, ResourceKey<TrimMaterial> trimMaterial) {
        return ITEMS.register(
                registryName, () -> new Item(
                        new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).trimMaterial(trimMaterial)
                )
        );
    }

    private static DeferredItem<BlockItem> registerBlockItem(String registryName, Supplier<Block> block){
        if (registryName.contains("netherite") || registryName.contains("player_only")) {
            return ITEMS.register(
                    registryName, () -> new BlockItem(
                            block.get(), new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).fireResistant()
                    )
            );
        } else {
            return ITEMS.register(
                    registryName, () -> new BlockItem(
                            block.get(), new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        }


    }

    private static DeferredItem<StandingAndWallBlockItem> registerTorch(String registryName, Supplier<Block> groundBlock, Supplier<Block> wallBlock) {
        return ITEMS.register(registryName, () -> new StandingAndWallBlockItem(
                groundBlock.get(),
                wallBlock.get(),
                Direction.DOWN,
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<BucketItem> registerBucketItem(String registryName, Supplier<FlowingFluid> fluid){
        return ITEMS.register(
                registryName, () -> new BucketItem(
                        fluid.get(),
                        new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredItem<Item> registerMusicDisc(String registryName, ResourceKey<JukeboxSong> jukeboxSong){
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(jukeboxSong).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerBannerTemplate(String registryName, TagKey<BannerPattern> tag){
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().stacksTo(1)
                        .delayedComponent(
                                DataComponents.PROVIDES_BANNER_PATTERNS, (context) -> context.getOrThrow(tag)
                        ).setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                        )
                )
        ));
    }

    private static DeferredItem<ExplosiveArrowItem> registerExplosiveArrowItem(String registryName) {
        return ITEMS.register(registryName, () -> new ExplosiveArrowItem(
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<SharpenedArrowItem> registerSharpenedArrowItem(String registryName) {
        return ITEMS.register(registryName, () -> new SharpenedArrowItem(
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<StreamlinedArrowItem> registerStreamlinedArrowItem(String registryName) {
        return ITEMS.register(registryName, () -> new StreamlinedArrowItem(
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<BoatItem> registerBoatItem(String registryName, Supplier<? extends EntityType<? extends AbstractBoat>> entityType) {
        return ITEMS.register(registryName, () -> new BoatItem(
                entityType.get(),
                new Item.Properties().stacksTo(1).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<MinecartItem> registerMinecartItem(String registryName, Supplier<? extends EntityType<? extends AbstractMinecart>> entityType) {
        return ITEMS.register(registryName, () -> new MinecartItem(
                entityType.get(),
                new Item.Properties().stacksTo(1).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerSword(String registryName, ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().sword(toolMaterial, attackDamage, attackSpeed).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerSpear(String registryName, ToolMaterial toolMaterial, float attackDuration, float damageMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float knockbackThreshold, float damageTime, float damageThreshold) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().spear(toolMaterial, attackDuration, damageMultiplier, delay, dismountTime, dismountThreshold, knockbackTime, knockbackThreshold, damageTime, damageThreshold).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerAxe(String registryName, ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().axe(toolMaterial, attackDamage, attackSpeed).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerPickAxe(String registryName, ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().pickaxe(toolMaterial, attackDamage, attackSpeed).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerShovel(String registryName, ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().shovel(toolMaterial, attackDamage, attackSpeed).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerHoe(String registryName, ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().hoe(toolMaterial, attackDamage, attackSpeed).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerArmor(String registryName, ArmorMaterial armorMaterial, ArmorType armorType) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().humanoidArmor(armorMaterial, armorType).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerHorseArmor(String registryName, ArmorMaterial armorMaterial) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().horseArmor(armorMaterial).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<Item> registerNautilusArmor(String registryName, ArmorMaterial armorMaterial) {
        return ITEMS.register(registryName, () -> new Item(
                new Item.Properties().nautilusArmor(armorMaterial).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    private static DeferredItem<SmithingTemplateItem> registerSmithingTemplate(String registryName) {
        return ITEMS.register(registryName,
                () -> ModSmithingTemplateItemConfig.createBronzeUpgradeTemplate(new Item.Properties().rarity(Rarity.UNCOMMON).setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )));
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
