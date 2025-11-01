package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.sounds.ModJukeboxSongs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final DeferredItem<BlockItem> IRON_TILES = registerBlockItem("iron_tiles", () -> ModBlocks.IRON_TILES.get());
    public static final DeferredItem<BlockItem> IRON_TILE_SLAB = registerBlockItem("iron_tile_slab", () -> ModBlocks.IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> IRON_TILE_STAIRS = registerBlockItem("iron_tile_stairs", () -> ModBlocks.IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_TILES = registerBlockItem("mildly_rusted_iron_tiles", () -> ModBlocks.MILDLY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_TILE_SLAB = registerBlockItem("mildly_rusted_iron_tile_slab", () -> ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("mildly_rusted_iron_tile_stairs", () -> ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_TILES = registerBlockItem("moderately_rusted_iron_tiles", () -> ModBlocks.MODERATELY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_TILE_SLAB = registerBlockItem("moderately_rusted_iron_tile_slab", () -> ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("moderately_rusted_iron_tile_stairs", () -> ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_TILES = registerBlockItem("extremely_rusted_iron_tiles", () -> ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_TILE_SLAB = registerBlockItem("extremely_rusted_iron_tile_slab", () -> ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("extremely_rusted_iron_tile_stairs", () -> ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_TILES = registerBlockItem("waxed_iron_tiles", () -> ModBlocks.WAXED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_IRON_TILE_SLAB = registerBlockItem("waxed_iron_tile_slab", () -> ModBlocks.WAXED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_IRON_TILE_STAIRS = registerBlockItem("waxed_iron_tile_stairs", () -> ModBlocks.WAXED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_TILES = registerBlockItem("waxed_mildly_rusted_iron_tiles", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_TILE_SLAB = registerBlockItem("waxed_mildly_rusted_iron_tile_slab", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("waxed_mildly_rusted_iron_tile_stairs", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_TILES = registerBlockItem("waxed_moderately_rusted_iron_tiles", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB = registerBlockItem("waxed_moderately_rusted_iron_tile_slab", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("waxed_moderately_rusted_iron_tile_stairs", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_TILES = registerBlockItem("waxed_extremely_rusted_iron_tiles", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB = registerBlockItem("waxed_extremely_rusted_iron_tile_slab", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS = registerBlockItem("waxed_extremely_rusted_iron_tile_stairs", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> GOLD_TILES = registerBlockItem("gold_tiles", () -> ModBlocks.GOLD_TILES.get());
    public static final DeferredItem<BlockItem> GOLD_TILE_SLAB = registerBlockItem("gold_tile_slab", () -> ModBlocks.GOLD_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> GOLD_TILE_STAIRS = registerBlockItem("gold_tile_stairs", () -> ModBlocks.GOLD_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> DIAMOND_TILES = registerBlockItem("diamond_tiles", () -> ModBlocks.DIAMOND_TILES.get());
    public static final DeferredItem<BlockItem> DIAMOND_TILE_SLAB = registerBlockItem("diamond_tile_slab", () -> ModBlocks.DIAMOND_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> DIAMOND_TILE_STAIRS = registerBlockItem("diamond_tile_stairs", () -> ModBlocks.DIAMOND_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> EMERALD_TILES = registerBlockItem("emerald_tiles", () -> ModBlocks.EMERALD_TILES.get());
    public static final DeferredItem<BlockItem> EMERALD_TILE_SLAB = registerBlockItem("emerald_tile_slab", () -> ModBlocks.EMERALD_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> EMERALD_TILE_STAIRS = registerBlockItem("emerald_tile_stairs", () -> ModBlocks.EMERALD_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> NETHERITE_TILES = registerBlockItem("netherite_tiles", () -> ModBlocks.NETHERITE_TILES.get());
    public static final DeferredItem<BlockItem> NETHERITE_TILE_SLAB = registerBlockItem("netherite_tile_slab", () -> ModBlocks.NETHERITE_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> NETHERITE_TILE_STAIRS = registerBlockItem("netherite_tile_stairs", () -> ModBlocks.NETHERITE_TILE_STAIRS.get());

    public static final DeferredItem<BlockItem> MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("medium_weighted_pressure_plate", () -> ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("exposed_medium_weighted_pressure_plate", () -> ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("weathered_medium_weighted_pressure_plate", () -> ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("oxidized_medium_weighted_pressure_plate", () -> ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_exposed_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_weathered_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_oxidized_medium_weighted_pressure_plate", () -> ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_BLOCK = registerBlockItem("mildly_rusted_iron_block", () -> ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_BLOCK = registerBlockItem("moderately_rusted_iron_block", () -> ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_BLOCK = registerBlockItem("extremely_rusted_iron_block", () -> ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_BLOCK = registerBlockItem("waxed_iron_block", () -> ModBlocks.WAXED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_BLOCK = registerBlockItem("waxed_mildly_rusted_iron_block", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_BLOCK = registerBlockItem("waxed_moderately_rusted_iron_block", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_BLOCK = registerBlockItem("waxed_extremely_rusted_iron_block", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_DOOR = registerBlockItem("mildly_rusted_iron_door", () -> ModBlocks.MILDLY_RUSTED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_DOOR = registerBlockItem("moderately_rusted_iron_door", () -> ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_DOOR = registerBlockItem("extremely_rusted_iron_door", () -> ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_DOOR = registerBlockItem("waxed_iron_door", () -> ModBlocks.WAXED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_DOOR = registerBlockItem("waxed_mildly_rusted_iron_door", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_DOOR = registerBlockItem("waxed_moderately_rusted_iron_door", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_DOOR = registerBlockItem("waxed_extremely_rusted_iron_door", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_TRAPDOOR = registerBlockItem("mildly_rusted_iron_trapdoor", () -> ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_TRAPDOOR = registerBlockItem("moderately_rusted_iron_trapdoor", () -> ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_TRAPDOOR = registerBlockItem("extremely_rusted_iron_trapdoor", () -> ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_TRAPDOOR = registerBlockItem("waxed_iron_trapdoor", () -> ModBlocks.WAXED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_TRAPDOOR = registerBlockItem("waxed_mildly_rusted_iron_trapdoor", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR = registerBlockItem("waxed_moderately_rusted_iron_trapdoor", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR = registerBlockItem("waxed_extremely_rusted_iron_trapdoor", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("mildly_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("moderately_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("extremely_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_mildly_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_moderately_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_extremely_rusted_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> MILDLY_RUSTED_IRON_BARS = registerBlockItem("mildly_rusted_iron_bars", () -> ModBlocks.MILDLY_RUSTED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> MODERATELY_RUSTED_IRON_BARS = registerBlockItem("moderately_rusted_iron_bars", () -> ModBlocks.MODERATELY_RUSTED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> EXTREMELY_RUSTED_IRON_BARS = registerBlockItem("extremely_rusted_iron_bars", () -> ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get());

    public static final DeferredItem<BlockItem> WAXED_IRON_BARS = registerBlockItem("waxed_iron_bars", () -> ModBlocks.WAXED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_MILDLY_RUSTED_IRON_BARS = registerBlockItem("waxed_mildly_rusted_iron_bars", () -> ModBlocks.WAXED_MILDLY_RUSTED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_MODERATELY_RUSTED_IRON_BARS = registerBlockItem("waxed_moderately_rusted_iron_bars", () -> ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BARS.get());
    public static final DeferredItem<BlockItem> WAXED_EXTREMELY_RUSTED_IRON_BARS = registerBlockItem("waxed_extremely_rusted_iron_bars", () -> ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BARS.get());

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
    public static final DeferredItem<Item> ZINC_INGOT = registerCustomItem("zinc_ingot");
    public static final DeferredItem<Item> ZINC_NUGGET = registerCustomItem("zinc_nugget");

    public static final DeferredItem<BlockItem> ZINC_BLOCK = registerBlockItem("zinc_block", () -> ModBlocks.ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> ZINC_TILES = registerBlockItem("zinc_tiles", () -> ModBlocks.ZINC_TILES.get());
    public static final DeferredItem<BlockItem> ZINC_TILE_SLAB = registerBlockItem("zinc_tile_slab", () -> ModBlocks.ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> ZINC_TILE_STAIRS = registerBlockItem("zinc_tile_stairs", () -> ModBlocks.ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> ZINC_DOOR = registerBlockItem("zinc_door", () -> ModBlocks.ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> ZINC_TRAPDOOR = registerBlockItem("zinc_trapdoor", () -> ModBlocks.ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("barely_heavy_weighted_pressure_plate", () -> ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_BLOCK = registerBlockItem("slightly_corroded_zinc_block", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_TILES = registerBlockItem("slightly_corroded_zinc_tiles", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_TILE_SLAB = registerBlockItem("slightly_corroded_zinc_tile_slab", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("slightly_corroded_zinc_tile_stairs", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_DOOR = registerBlockItem("slightly_corroded_zinc_door", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_ZINC_TRAPDOOR = registerBlockItem("slightly_corroded_zinc_trapdoor", () -> ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("slightly_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_BLOCK = registerBlockItem("somewhat_corroded_zinc_block", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_TILES = registerBlockItem("somewhat_corroded_zinc_tiles", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_TILE_SLAB = registerBlockItem("somewhat_corroded_zinc_tile_slab", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("somewhat_corroded_zinc_tile_stairs", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_DOOR = registerBlockItem("somewhat_corroded_zinc_door", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_ZINC_TRAPDOOR = registerBlockItem("somewhat_corroded_zinc_trapdoor", () -> ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("somewhat_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_BLOCK = registerBlockItem("really_corroded_zinc_block", () -> ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_TILES = registerBlockItem("really_corroded_zinc_tiles", () -> ModBlocks.REALLY_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_TILE_SLAB = registerBlockItem("really_corroded_zinc_tile_slab", () -> ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("really_corroded_zinc_tile_stairs", () -> ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_DOOR = registerBlockItem("really_corroded_zinc_door", () -> ModBlocks.REALLY_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_ZINC_TRAPDOOR = registerBlockItem("really_corroded_zinc_trapdoor", () -> ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("really_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_ZINC_BLOCK = registerBlockItem("waxed_zinc_block", () -> ModBlocks.WAXED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_TILES = registerBlockItem("waxed_zinc_tiles", () -> ModBlocks.WAXED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_TILE_SLAB = registerBlockItem("waxed_zinc_tile_slab", () -> ModBlocks.WAXED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_TILE_STAIRS = registerBlockItem("waxed_zinc_tile_stairs", () -> ModBlocks.WAXED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_DOOR = registerBlockItem("waxed_zinc_door", () -> ModBlocks.WAXED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_ZINC_TRAPDOOR = registerBlockItem("waxed_zinc_trapdoor", () -> ModBlocks.WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK = registerBlockItem("waxed_slightly_corroded_zinc_block", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_TILES = registerBlockItem("waxed_slightly_corroded_zinc_tiles", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB = registerBlockItem("waxed_slightly_corroded_zinc_tile_slab", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("waxed_slightly_corroded_zinc_tile_stairs", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_DOOR = registerBlockItem("waxed_slightly_corroded_zinc_door", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR = registerBlockItem("waxed_slightly_corroded_zinc_trapdoor", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_slightly_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK = registerBlockItem("waxed_somewhat_corroded_zinc_block", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_TILES = registerBlockItem("waxed_somewhat_corroded_zinc_tiles", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB = registerBlockItem("waxed_somewhat_corroded_zinc_tile_slab", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("waxed_somewhat_corroded_zinc_tile_stairs", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_DOOR = registerBlockItem("waxed_somewhat_corroded_zinc_door", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR = registerBlockItem("waxed_somewhat_corroded_zinc_trapdoor", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_somewhat_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_BLOCK = registerBlockItem("waxed_really_corroded_zinc_block", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_TILES = registerBlockItem("waxed_really_corroded_zinc_tiles", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_TILE_SLAB = registerBlockItem("waxed_really_corroded_zinc_tile_slab", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS = registerBlockItem("waxed_really_corroded_zinc_tile_stairs", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_DOOR = registerBlockItem("waxed_really_corroded_zinc_door", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_DOOR.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_ZINC_TRAPDOOR = registerBlockItem("waxed_really_corroded_zinc_trapdoor", () -> ModBlocks.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("waxed_really_corroded_barely_heavy_weighted_pressure_plate", () -> ModBlocks.WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> SILVER_ORE = registerBlockItem("silver_ore", () -> ModBlocks.SILVER_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE = registerBlockItem("deepslate_silver_ore", () -> ModBlocks.DEEPSLATE_SILVER_ORE.get());
    public static final DeferredItem<BlockItem> RAW_SILVER_BLOCK = registerBlockItem("raw_silver_block", () -> ModBlocks.RAW_SILVER_BLOCK.get());
    public static final DeferredItem<Item> RAW_SILVER = registerCustomItem("raw_silver");
    public static final DeferredItem<Item> SILVER_INGOT = registerCustomItem("silver_ingot");
    public static final DeferredItem<Item> SILVER_NUGGET = registerCustomItem("silver_nugget");

    public static final DeferredItem<BlockItem> SILVER_BLOCK = registerBlockItem("silver_block", () -> ModBlocks.SILVER_BLOCK.get());
    public static final DeferredItem<BlockItem> SILVER_TILES = registerBlockItem("silver_tiles", () -> ModBlocks.SILVER_TILES.get());
    public static final DeferredItem<BlockItem> SILVER_TILE_SLAB = registerBlockItem("silver_tile_slab", () -> ModBlocks.SILVER_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> SILVER_TILE_STAIRS = registerBlockItem("silver_tile_stairs", () -> ModBlocks.SILVER_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> SILVER_DOOR = registerBlockItem("silver_door", () -> ModBlocks.SILVER_DOOR.get());
    public static final DeferredItem<BlockItem> SILVER_TRAPDOOR = registerBlockItem("silver_trapdoor", () -> ModBlocks.SILVER_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerBlockItem("noticeably_light_weighted_pressure_plate", () -> ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> TIN_ORE = registerBlockItem("tin_ore", () -> ModBlocks.TIN_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_TIN_ORE = registerBlockItem("deepslate_tin_ore", () -> ModBlocks.DEEPSLATE_TIN_ORE.get());
    public static final DeferredItem<BlockItem> RAW_TIN_BLOCK = registerBlockItem("raw_tin_block", () -> ModBlocks.RAW_TIN_BLOCK.get());
    public static final DeferredItem<Item> RAW_TIN = registerCustomItem("raw_tin");
    public static final DeferredItem<Item> TIN_INGOT = registerCustomItem("tin_ingot");
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
    public static final DeferredItem<Item> TUNGSTEN_INGOT = registerCustomItem("tungsten_ingot");
    public static final DeferredItem<Item> TUNGSTEN_NUGGET = registerCustomItem("tungsten_nugget");

    public static final DeferredItem<BlockItem> TUNGSTEN_BLOCK = registerBlockItem("tungsten_block", () -> ModBlocks.TUNGSTEN_BLOCK.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_TILES = registerBlockItem("tungsten_tiles", () -> ModBlocks.TUNGSTEN_TILES.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_TILE_SLAB = registerBlockItem("tungsten_tile_slab", () -> ModBlocks.TUNGSTEN_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_TILE_STAIRS = registerBlockItem("tungsten_tile_stairs", () -> ModBlocks.TUNGSTEN_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_DOOR = registerBlockItem("tungsten_door", () -> ModBlocks.TUNGSTEN_DOOR.get());
    public static final DeferredItem<BlockItem> TUNGSTEN_TRAPDOOR = registerBlockItem("tungsten_trapdoor", () -> ModBlocks.TUNGSTEN_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("extraordinarily_heavy_weighted_pressure_plate", () -> ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> PLATINUM_ORE = registerBlockItem("platinum_ore", () -> ModBlocks.PLATINUM_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_PLATINUM_ORE = registerBlockItem("deepslate_platinum_ore", () -> ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
    public static final DeferredItem<BlockItem> RAW_PLATINUM_BLOCK = registerBlockItem("raw_platinum_block", () -> ModBlocks.RAW_PLATINUM_BLOCK.get());
    public static final DeferredItem<Item> RAW_PLATINUM = registerCustomItem("raw_platinum");
    public static final DeferredItem<Item> PLATINUM_INGOT = registerCustomItem("platinum_ingot");
    public static final DeferredItem<Item> PLATINUM_NUGGET = registerCustomItem("platinum_nugget");

    public static final DeferredItem<BlockItem> PLATINUM_BLOCK = registerBlockItem("platinum_block", () -> ModBlocks.PLATINUM_BLOCK.get());
    public static final DeferredItem<BlockItem> PLATINUM_TILES = registerBlockItem("platinum_tiles", () -> ModBlocks.PLATINUM_TILES.get());
    public static final DeferredItem<BlockItem> PLATINUM_TILE_SLAB = registerBlockItem("platinum_tile_slab", () -> ModBlocks.PLATINUM_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> PLATINUM_TILE_STAIRS = registerBlockItem("platinum_tile_stairs", () -> ModBlocks.PLATINUM_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> PLATINUM_DOOR = registerBlockItem("platinum_door", () -> ModBlocks.PLATINUM_DOOR.get());
    public static final DeferredItem<BlockItem> PLATINUM_TRAPDOOR = registerBlockItem("platinum_trapdoor", () -> ModBlocks.PLATINUM_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerBlockItem("extraordinarily_light_weighted_pressure_plate", () -> ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> LEAD_ORE = registerBlockItem("lead_ore", () -> ModBlocks.LEAD_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_LEAD_ORE = registerBlockItem("deepslate_lead_ore", () -> ModBlocks.DEEPSLATE_LEAD_ORE.get());
    public static final DeferredItem<BlockItem> RAW_LEAD_BLOCK = registerBlockItem("raw_lead_block", () -> ModBlocks.RAW_LEAD_BLOCK.get());
    public static final DeferredItem<Item> RAW_LEAD = registerCustomItem("raw_lead");
    public static final DeferredItem<Item> LEAD_INGOT = registerCustomItem("lead_ingot");
    public static final DeferredItem<Item> LEAD_NUGGET = registerCustomItem("lead_nugget");

    public static final DeferredItem<BlockItem> LEAD_BLOCK = registerBlockItem("lead_block", () -> ModBlocks.LEAD_BLOCK.get());
    public static final DeferredItem<BlockItem> LEAD_TILES = registerBlockItem("lead_tiles", () -> ModBlocks.LEAD_TILES.get());
    public static final DeferredItem<BlockItem> LEAD_TILE_SLAB = registerBlockItem("lead_tile_slab", () -> ModBlocks.LEAD_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> LEAD_TILE_STAIRS = registerBlockItem("lead_tile_stairs", () -> ModBlocks.LEAD_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> LEAD_DOOR = registerBlockItem("lead_door", () -> ModBlocks.LEAD_DOOR.get());
    public static final DeferredItem<BlockItem> LEAD_TRAPDOOR = registerBlockItem("lead_trapdoor", () -> ModBlocks.LEAD_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerBlockItem("noticeably_heavy_weighted_pressure_plate", () -> ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<BlockItem> URANIUM_ORE = registerBlockItem("uranium_ore", () -> ModBlocks.URANIUM_ORE.get());
    public static final DeferredItem<BlockItem> DEEPSLATE_URANIUM_ORE = registerBlockItem("deepslate_uranium_ore", () -> ModBlocks.DEEPSLATE_URANIUM_ORE.get());
    public static final DeferredItem<BlockItem> RAW_URANIUM_BLOCK = registerBlockItem("raw_uranium_block", () -> ModBlocks.RAW_URANIUM_BLOCK.get());
    public static final DeferredItem<Item> RAW_URANIUM = registerCustomItem("raw_uranium");
    public static final DeferredItem<Item> URANIUM_INGOT = registerCustomItem("uranium_ingot");
    public static final DeferredItem<Item> URANIUM_NUGGET = registerCustomItem("uranium_nugget");

    public static final DeferredItem<BlockItem> URANIUM_BLOCK = registerBlockItem("uranium_block", () -> ModBlocks.URANIUM_BLOCK.get());
    public static final DeferredItem<BlockItem> URANIUM_TILES = registerBlockItem("uranium_tiles", () -> ModBlocks.URANIUM_TILES.get());
    public static final DeferredItem<BlockItem> URANIUM_TILE_SLAB = registerBlockItem("uranium_tile_slab", () -> ModBlocks.URANIUM_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> URANIUM_TILE_STAIRS = registerBlockItem("uranium_tile_stairs", () -> ModBlocks.URANIUM_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> URANIUM_DOOR = registerBlockItem("uranium_door", () -> ModBlocks.URANIUM_DOOR.get());
    public static final DeferredItem<BlockItem> URANIUM_TRAPDOOR = registerBlockItem("uranium_trapdoor", () -> ModBlocks.URANIUM_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE = registerBlockItem("negligible_weighted_pressure_plate", () -> ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> BRONZE_INGOT = registerCustomItem("bronze_ingot");
    public static final DeferredItem<Item> BRONZE_NUGGET = registerCustomItem("bronze_nugget");

    public static final DeferredItem<BlockItem> BRONZE_BLOCK = registerBlockItem("bronze_block", () -> ModBlocks.BRONZE_BLOCK.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE = registerBlockItem("cut_bronze", () -> ModBlocks.CUT_BRONZE.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE_SLAB = registerBlockItem("cut_bronze_slab", () -> ModBlocks.CUT_BRONZE_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_BRONZE_STAIRS = registerBlockItem("cut_bronze_stairs", () -> ModBlocks.CUT_BRONZE_STAIRS.get());
    public static final DeferredItem<BlockItem> BRONZE_DOOR = registerBlockItem("bronze_door", () -> ModBlocks.BRONZE_DOOR.get());
    public static final DeferredItem<BlockItem> BRONZE_TRAPDOOR = registerBlockItem("bronze_trapdoor", () -> ModBlocks.BRONZE_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> PASSIVE_MOB_ONLY_PRESSURE_PLATE = registerBlockItem("passive_mob_only_pressure_plate", () -> ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> BRASS_INGOT = registerCustomItem("brass_ingot");
    public static final DeferredItem<Item> BRASS_NUGGET = registerCustomItem("brass_nugget");

    public static final DeferredItem<BlockItem> BRASS_BLOCK = registerBlockItem("brass_block", () -> ModBlocks.BRASS_BLOCK.get());
    public static final DeferredItem<BlockItem> BRASS_TILES = registerBlockItem("brass_tiles", () -> ModBlocks.BRASS_TILES.get());
    public static final DeferredItem<BlockItem> BRASS_TILE_SLAB = registerBlockItem("brass_tile_slab", () -> ModBlocks.BRASS_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> BRASS_TILE_STAIRS = registerBlockItem("brass_tile_stairs", () -> ModBlocks.BRASS_TILE_STAIRS.get());
    public static final DeferredItem<BlockItem> BRASS_DOOR = registerBlockItem("brass_door", () -> ModBlocks.BRASS_DOOR.get());
    public static final DeferredItem<BlockItem> BRASS_TRAPDOOR = registerBlockItem("brass_trapdoor", () -> ModBlocks.BRASS_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> HOSTILE_MOB_ONLY_PRESSURE_PLATE = registerBlockItem("hostile_mob_only_pressure_plate", () -> ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get());

    public static final DeferredItem<Item> STEEL_INGOT = registerCustomItem("steel_ingot");
    public static final DeferredItem<Item> STEEL_NUGGET = registerCustomItem("steel_nugget");

    public static final DeferredItem<BlockItem> STEEL_BLOCK = registerBlockItem("steel_block", () -> ModBlocks.STEEL_BLOCK.get());
    public static final DeferredItem<BlockItem> STEEL_TILES = registerBlockItem("steel_tiles", () -> ModBlocks.STEEL_TILES.get());
    public static final DeferredItem<BlockItem> STEEL_TILE_SLAB = registerBlockItem("steel_tile_slab", () -> ModBlocks.STEEL_TILE_SLAB.get());
    public static final DeferredItem<BlockItem> STEEL_TILE_STAIRS = registerBlockItem("steel_tile_stairs", () -> ModBlocks.STEEL_TILE_STAIRS.get());
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

    public static final DeferredItem<MinecartItem> STONE_FURNACE_MINECART = registerMinecartItem("stone_furnace_minecart", () -> EntityType.FURNACE_MINECART);
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

    public static final DeferredItem<MinecartItem> OAK_CHEST_MINECART = registerMinecartItem("oak_chest_minecart", () -> EntityType.CHEST_MINECART);
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

    private static DeferredItem<Item> registerCustomItem(String registryName) {
        if (registryName == "netherite_nugget") {
            return ITEMS.register(
                    registryName, () -> new Item(
                            new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            ResourceLocation.fromNamespaceAndPath(
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
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        }
    }

    private static DeferredItem<BlockItem> registerBlockItem(String registryName, Supplier<Block> block){
        if (registryName == "netherite_door" | registryName == "netherite_trapdoor" | registryName == "player_only_pressure_plate" | registryName == "netherite_tiles" | registryName == "netherite_tile_slab" | registryName == "netherite_tile_stairs") {
            return ITEMS.register(
                    registryName, () -> new BlockItem(
                            block.get(), new Item.Properties().setId(
                                    ResourceKey.create(
                                            Registries.ITEM,
                                            ResourceLocation.fromNamespaceAndPath(
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
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        }


    }

    private static DeferredItem<BucketItem> registerBucketItem(String registryName, Supplier<FlowingFluid> fluid){
        return ITEMS.register(
                registryName, () -> new BucketItem(
                        fluid.get(),
                        new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        ResourceLocation.fromNamespaceAndPath(
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
                                ResourceLocation.fromNamespaceAndPath(
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
                                ResourceLocation.fromNamespaceAndPath(
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
                                ResourceLocation.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        ));
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
