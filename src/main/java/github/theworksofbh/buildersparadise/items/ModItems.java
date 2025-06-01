package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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

    public static final DeferredItem<Item> COPPER_NUGGET = registerCustomItem("copper_nugget");
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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
