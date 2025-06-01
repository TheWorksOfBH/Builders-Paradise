package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildersParadise.MODID);

    public static final DeferredBlock<WallBlock> POLISHED_GRANITE_WALL = registerWallBlock("polished_granite_wall", () -> Blocks.POLISHED_GRANITE);
    public static final DeferredBlock<WallBlock> POLISHED_DIORITE_WALL = registerWallBlock("polished_diorite_wall", () -> Blocks.POLISHED_DIORITE);
    public static final DeferredBlock<WallBlock> POLISHED_ANDESITE_WALL = registerWallBlock("polished_andesite_wall", () -> Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<WallBlock> PRISMARINE_BRICK_WALL = registerWallBlock("prismarine_brick_wall", () -> Blocks.PRISMARINE_BRICKS);
    public static final DeferredBlock<WallBlock> DARK_PRISMARINE_WALL = registerWallBlock("dark_prismarine_wall", () -> Blocks.DARK_PRISMARINE);
    public static final DeferredBlock<WallBlock> STONE_WALL = registerWallBlock("stone_wall", () -> Blocks.STONE);
    public static final DeferredBlock<WallBlock> SMOOTH_SANDSTONE_WALL = registerWallBlock("smooth_sandstone_wall", () -> Blocks.SMOOTH_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_RED_SANDSTONE_WALL = registerWallBlock("smooth_red_sandstone_wall", () -> Blocks.SMOOTH_RED_SANDSTONE);
    public static final DeferredBlock<WallBlock> QUARTZ_WALL = registerWallBlock("quartz_wall", () -> Blocks.QUARTZ_BLOCK);
    public static final DeferredBlock<WallBlock> SMOOTH_QUARTZ_WALL = registerWallBlock("smooth_quartz_wall", () -> Blocks.SMOOTH_QUARTZ);
    public static final DeferredBlock<WallBlock> PURPUR_WALL = registerWallBlock("purpur_wall", () -> Blocks.PURPUR_BLOCK);

    public static final DeferredBlock<StairBlock> SMOOTH_STONE_STAIRS = registerStairBlock("smooth_stone_stairs", () -> Blocks.SMOOTH_STONE);
    public static final DeferredBlock<WallBlock> SMOOTH_STONE_WALL = registerWallBlock("smooth_stone_wall", () -> Blocks.SMOOTH_STONE);

    public static final DeferredBlock<StairBlock> CUT_SANDSTONE_STAIRS = registerStairBlock("cut_sandstone_stairs", () -> Blocks.CUT_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_SANDSTONE_WALL = registerWallBlock("cut_sandstone_wall", () -> Blocks.CUT_SANDSTONE);

    public static final DeferredBlock<StairBlock> CUT_RED_SANDSTONE_STAIRS = registerStairBlock("cut_red_sandstone_stairs", () -> Blocks.CUT_RED_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_RED_SANDSTONE_WALL = registerWallBlock("cut_red_sandstone_wall", () -> Blocks.CUT_RED_SANDSTONE);

    public static final DeferredBlock<SlabBlock> CRACKED_STONE_BRICK_SLAB = registerSlabBlock("cracked_stone_brick_slab", () -> Blocks.CRACKED_STONE_BRICKS);
    public static final DeferredBlock<StairBlock> CRACKED_STONE_BRICK_STAIRS = registerStairBlock("cracked_stone_brick_stairs", () -> Blocks.CRACKED_STONE_BRICKS);
    public static final DeferredBlock<WallBlock> CRACKED_STONE_BRICK_WALL = registerWallBlock("cracked_stone_brick_wall", () -> Blocks.CRACKED_STONE_BRICKS);

    public static final DeferredBlock<SlabBlock> BASALT_SLAB = registerSlabBlock("basalt_slab", () -> Blocks.BASALT);
    public static final DeferredBlock<StairBlock> BASALT_STAIRS = registerStairBlock("basalt_stairs", () -> Blocks.BASALT);
    public static final DeferredBlock<WallBlock> BASALT_WALL = registerWallBlock("basalt_wall", () -> Blocks.BASALT);

    public static final DeferredBlock<SlabBlock> POLISHED_BASALT_SLAB = registerSlabBlock("polished_basalt_slab", () -> Blocks.POLISHED_BASALT);
    public static final DeferredBlock<StairBlock> POLISHED_BASALT_STAIRS = registerStairBlock("polished_basalt_stairs", () -> Blocks.POLISHED_BASALT);
    public static final DeferredBlock<WallBlock> POLISHED_BASALT_WALL = registerWallBlock("polished_basalt_wall", () -> Blocks.POLISHED_BASALT);

    public static final DeferredBlock<SlabBlock> SMOOTH_BASALT_SLAB = registerSlabBlock("smooth_basalt_slab", () -> Blocks.SMOOTH_BASALT);
    public static final DeferredBlock<StairBlock> SMOOTH_BASALT_STAIRS = registerStairBlock("smooth_basalt_stairs", () -> Blocks.SMOOTH_BASALT);
    public static final DeferredBlock<WallBlock> SMOOTH_BASALT_WALL = registerWallBlock("smooth_basalt_wall", () -> Blocks.SMOOTH_BASALT);

    public static final DeferredBlock<SlabBlock> DEEPSLATE_SLAB = registerSlabBlock("deepslate_slab", () -> Blocks.DEEPSLATE);
    public static final DeferredBlock<StairBlock> DEEPSLATE_STAIRS = registerStairBlock("deepslate_stairs", () -> Blocks.DEEPSLATE);
    public static final DeferredBlock<WallBlock> DEEPSLATE_WALL = registerWallBlock("deepslate_wall", () -> Blocks.DEEPSLATE);

    public static final DeferredBlock<SlabBlock> CRACKED_DEEPSLATE_BRICK_SLAB = registerSlabBlock("cracked_deepslate_brick_slab", () -> Blocks.CRACKED_DEEPSLATE_BRICKS);
    public static final DeferredBlock<StairBlock> CRACKED_DEEPSLATE_BRICK_STAIRS = registerStairBlock("cracked_deepslate_brick_stairs", () -> Blocks.CRACKED_DEEPSLATE_BRICKS);
    public static final DeferredBlock<WallBlock> CRACKED_DEEPSLATE_BRICK_WALL = registerWallBlock("cracked_deepslate_brick_wall", () -> Blocks.CRACKED_DEEPSLATE_BRICKS);

    public static final DeferredBlock<SlabBlock> CRACKED_DEEPSLATE_TILE_SLAB = registerSlabBlock("cracked_deepslate_tile_slab", () -> Blocks.CRACKED_DEEPSLATE_TILES);
    public static final DeferredBlock<StairBlock> CRACKED_DEEPSLATE_TILE_STAIRS = registerStairBlock("cracked_deepslate_tile_stairs", () -> Blocks.CRACKED_DEEPSLATE_TILES);
    public static final DeferredBlock<WallBlock> CRACKED_DEEPSLATE_TILE_WALL = registerWallBlock("cracked_deepslate_tile_wall", () -> Blocks.CRACKED_DEEPSLATE_TILES);

    public static final DeferredBlock<SlabBlock> CRACKED_NETHER_BRICK_SLAB = registerSlabBlock("cracked_nether_brick_slab", () -> Blocks.CRACKED_NETHER_BRICKS);
    public static final DeferredBlock<StairBlock> CRACKED_NETHER_BRICK_STAIRS = registerStairBlock("cracked_nether_brick_stairs", () -> Blocks.CRACKED_NETHER_BRICKS);
    public static final DeferredBlock<WallBlock> CRACKED_NETHER_BRICK_WALL = registerWallBlock("cracked_nether_brick_wall", () -> Blocks.CRACKED_NETHER_BRICKS);

    public static final DeferredBlock<SlabBlock> CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = registerSlabBlock("cracked_polished_blackstone_brick_slab", () -> Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
    public static final DeferredBlock<StairBlock> CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerStairBlock("cracked_polished_blackstone_brick_stairs", () -> Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
    public static final DeferredBlock<WallBlock> CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = registerWallBlock("cracked_polished_blackstone_brick_wall", () -> Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);

    public static final DeferredBlock<SlabBlock> NETHERRACK_SLAB = registerSlabBlock("netherrack_slab", () -> Blocks.NETHERRACK);
    public static final DeferredBlock<StairBlock> NETHERRACK_STAIRS = registerStairBlock("netherrack_stairs", () -> Blocks.NETHERRACK);
    public static final DeferredBlock<WallBlock> NETHERRACK_WALL = registerWallBlock("netherrack_wall", () -> Blocks.NETHERRACK);

    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerSlabBlock("calcite_slab", () -> Blocks.CALCITE);
    public static final DeferredBlock<StairBlock> CALCITE_STAIRS = registerStairBlock("calcite_stairs", () -> Blocks.CALCITE);
    public static final DeferredBlock<WallBlock> CALCITE_WALL = registerWallBlock("calcite_wall", () -> Blocks.CALCITE);

    public static final DeferredBlock<SlabBlock> DRIPSTONE_SLAB = registerSlabBlock("dripstone_slab", () -> Blocks.DRIPSTONE_BLOCK);
    public static final DeferredBlock<StairBlock> DRIPSTONE_STAIRS = registerStairBlock("dripstone_stairs", () -> Blocks.DRIPSTONE_BLOCK);
    public static final DeferredBlock<WallBlock> DRIPSTONE_WALL = registerWallBlock("dripstone_wall", () -> Blocks.DRIPSTONE_BLOCK);

    public static final DeferredBlock<SlabBlock> END_STONE_SLAB = registerSlabBlock("end_stone_slab", () -> Blocks.END_STONE);
    public static final DeferredBlock<StairBlock> END_STONE_STAIRS = registerStairBlock("end_stone_stairs", () -> Blocks.END_STONE);
    public static final DeferredBlock<WallBlock> END_STONE_WALL = registerWallBlock("end_stone_wall", () -> Blocks.END_STONE);

    public static final DeferredBlock<SlabBlock> QUARTZ_BRICK_SLAB = registerSlabBlock("quartz_brick_slab", () -> Blocks.QUARTZ_BRICKS);
    public static final DeferredBlock<StairBlock> QUARTZ_BRICK_STAIRS = registerStairBlock("quartz_brick_stairs", () -> Blocks.QUARTZ_BRICKS);
    public static final DeferredBlock<WallBlock> QUARTZ_BRICK_WALL = registerWallBlock("quartz_brick_wall", () -> Blocks.QUARTZ_BRICKS);

    public static final DeferredBlock<SlabBlock> PACKED_MUD_SLAB = registerSlabBlock("packed_mud_slab", () -> Blocks.PACKED_MUD);
    public static final DeferredBlock<StairBlock> PACKED_MUD_STAIRS = registerStairBlock("packed_mud_stairs", () -> Blocks.PACKED_MUD);
    public static final DeferredBlock<WallBlock> PACKED_MUD_WALL = registerWallBlock("packed_mud_wall", () -> Blocks.PACKED_MUD);

    public static final DeferredBlock<SlabBlock> RESIN_SLAB = registerSlabBlock("resin_slab", () -> Blocks.RESIN_BLOCK);
    public static final DeferredBlock<StairBlock> RESIN_STAIRS = registerStairBlock("resin_stairs", () -> Blocks.RESIN_BLOCK);
    public static final DeferredBlock<WallBlock> RESIN_WALL = registerWallBlock("resin_wall", () -> Blocks.RESIN_BLOCK);

    public static final DeferredBlock<ModBlock> IRON_TILES = registerRustingBlock("iron_tiles", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModSlabBlock> IRON_TILE_SLAB = registerRustingSlabBlock("iron_tile_slab", () -> IRON_TILES.get());
    public static final DeferredBlock<ModStairBlock> IRON_TILE_STAIRS = registerRustingStairBlock("iron_tile_stairs", () -> IRON_TILES.get());

    public static final DeferredBlock<Block> GOLD_TILES = registerBlockVariant("gold_tiles", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<SlabBlock> GOLD_TILE_SLAB = registerSlabBlock("gold_tile_slab", () -> GOLD_TILES.get());
    public static final DeferredBlock<StairBlock> GOLD_TILE_STAIRS = registerStairBlock("gold_tile_stairs", () -> GOLD_TILES.get());

    public static final DeferredBlock<Block> DIAMOND_TILES = registerBlockVariant("diamond_tiles", () -> Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<SlabBlock> DIAMOND_TILE_SLAB = registerSlabBlock("diamond_tile_slab", () -> DIAMOND_TILES.get());
    public static final DeferredBlock<StairBlock> DIAMOND_TILE_STAIRS = registerStairBlock("diamond_tile_stairs", () -> DIAMOND_TILES.get());

    public static final DeferredBlock<Block> EMERALD_TILES = registerBlockVariant("emerald_tiles", () -> Blocks.EMERALD_BLOCK);
    public static final DeferredBlock<SlabBlock> EMERALD_TILE_SLAB = registerSlabBlock("emerald_tile_slab", () -> EMERALD_TILES.get());
    public static final DeferredBlock<StairBlock> EMERALD_TILE_STAIRS = registerStairBlock("emerald_tile_stairs", () -> EMERALD_TILES.get());

    public static final DeferredBlock<Block> NETHERITE_TILES = registerBlockVariant("netherite_tiles", () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<SlabBlock> NETHERITE_TILE_SLAB = registerSlabBlock("netherite_tile_slab", () -> NETHERITE_TILES.get());
    public static final DeferredBlock<StairBlock> NETHERITE_TILE_STAIRS = registerStairBlock("netherite_tile_stairs", () -> NETHERITE_TILES.get());

    public static final DeferredBlock<WeatheringCopperPressurePlateBlock> MEDIUM_WEIGHTED_PRESSURE_PLATE = registerOxidizingPressurePlate(
            "medium_weighted_pressure_plate", 88, BlockSetType.COPPER, WeatheringCopper.WeatherState.UNAFFECTED, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeatheringCopperPressurePlateBlock> EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerOxidizingPressurePlate(
            "exposed_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, WeatheringCopper.WeatherState.EXPOSED, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeatheringCopperPressurePlateBlock> WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerOxidizingPressurePlate(
            "weathered_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, WeatheringCopper.WeatherState.WEATHERED, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeatheringCopperPressurePlateBlock> OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerOxidizingPressurePlate(
            "oxidized_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, WeatheringCopper.WeatherState.OXIDIZED, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate(
            "waxed_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate(
            "waxed_exposed_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate(
            "waxed_weathered_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate(
            "waxed_oxidized_medium_weighted_pressure_plate", 88, BlockSetType.COPPER, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<ModBlock> MILDLY_RUSTED_IRON_BLOCK = registerRustingBlock("mildly_rusted_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModBlock> MODERATELY_RUSTED_IRON_BLOCK = registerRustingBlock("moderately_rusted_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModBlock> EXTREMELY_RUSTED_IRON_BLOCK = registerRustingBlock("extremely_rusted_iron_block", () -> Blocks.IRON_BLOCK);

    public static final DeferredBlock<Block> WAXED_IRON_BLOCK = registerBlockVariant("waxed_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> WAXED_MILDLY_RUSTED_IRON_BLOCK = registerBlockVariant("waxed_mildly_rusted_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> WAXED_MODERATELY_RUSTED_IRON_BLOCK = registerBlockVariant("waxed_moderately_rusted_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> WAXED_EXTREMELY_RUSTED_IRON_BLOCK = registerBlockVariant("waxed_extremely_rusted_iron_block", () -> Blocks.IRON_BLOCK);

    public static final DeferredBlock<ModBlock> MILDLY_RUSTED_IRON_TILES = registerRustingBlock("mildly_rusted_iron_tiles", () -> MILDLY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> MILDLY_RUSTED_IRON_TILE_SLAB = registerRustingSlabBlock("mildly_rusted_iron_tile_slab", () -> MILDLY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<ModStairBlock> MILDLY_RUSTED_IRON_TILE_STAIRS = registerRustingStairBlock("mildly_rusted_iron_tile_stairs", () -> MILDLY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<ModBlock> MODERATELY_RUSTED_IRON_TILES = registerRustingBlock("moderately_rusted_iron_tiles", () -> MODERATELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> MODERATELY_RUSTED_IRON_TILE_SLAB = registerRustingSlabBlock("moderately_rusted_iron_tile_slab", () -> MODERATELY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<ModStairBlock> MODERATELY_RUSTED_IRON_TILE_STAIRS = registerRustingStairBlock("moderately_rusted_iron_tile_stairs", () -> MODERATELY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<ModBlock> EXTREMELY_RUSTED_IRON_TILES = registerRustingBlock("extremely_rusted_iron_tiles", () -> EXTREMELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> EXTREMELY_RUSTED_IRON_TILE_SLAB = registerRustingSlabBlock("extremely_rusted_iron_tile_slab", () -> EXTREMELY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<ModStairBlock> EXTREMELY_RUSTED_IRON_TILE_STAIRS = registerRustingStairBlock("extremely_rusted_iron_tile_stairs", () -> EXTREMELY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<Block> WAXED_IRON_TILES = registerBlockVariant("waxed_iron_tiles", () -> WAXED_IRON_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_IRON_TILE_SLAB = registerSlabBlock("waxed_iron_tile_slab", () -> WAXED_IRON_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_IRON_TILE_STAIRS = registerStairBlock("waxed_iron_tile_stairs", () -> WAXED_IRON_TILES.get());

    public static final DeferredBlock<Block> WAXED_MILDLY_RUSTED_IRON_TILES = registerBlockVariant("waxed_mildly_rusted_iron_tiles", () -> WAXED_MILDLY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_MILDLY_RUSTED_IRON_TILE_SLAB = registerSlabBlock("waxed_mildly_rusted_iron_tile_slab", () -> WAXED_MILDLY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS = registerStairBlock("waxed_mildly_rusted_iron_tile_stairs", () -> WAXED_MILDLY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<Block> WAXED_MODERATELY_RUSTED_IRON_TILES = registerBlockVariant("waxed_moderately_rusted_iron_tiles", () -> WAXED_MODERATELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB = registerSlabBlock("waxed_moderately_rusted_iron_tile_slab", () -> WAXED_MODERATELY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS = registerStairBlock("waxed_moderately_rusted_iron_tile_stairs", () -> WAXED_MODERATELY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<Block> WAXED_EXTREMELY_RUSTED_IRON_TILES = registerBlockVariant("waxed_extremely_rusted_iron_tiles", () -> WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB = registerSlabBlock("waxed_extremely_rusted_iron_tile_slab", () -> WAXED_EXTREMELY_RUSTED_IRON_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS = registerStairBlock("waxed_extremely_rusted_iron_tile_stairs", () -> WAXED_EXTREMELY_RUSTED_IRON_TILES.get());

    public static final DeferredBlock<ModDoorBlock> MILDLY_RUSTED_IRON_DOOR = registerRustingDoorBlock("mildly_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModDoorBlock> MODERATELY_RUSTED_IRON_DOOR = registerRustingDoorBlock("moderately_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModDoorBlock> EXTREMELY_RUSTED_IRON_DOOR = registerRustingDoorBlock("extremely_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);

    public static final DeferredBlock<DoorBlock> WAXED_IRON_DOOR = registerDoorBlock("waxed_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_MILDLY_RUSTED_IRON_DOOR = registerDoorBlock("waxed_mildly_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_MODERATELY_RUSTED_IRON_DOOR = registerDoorBlock("waxed_moderately_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_EXTREMELY_RUSTED_IRON_DOOR = registerDoorBlock("waxed_extremely_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);

    public static final DeferredBlock<ModTrapdoorBlock> MILDLY_RUSTED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("mildly_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModTrapdoorBlock> MODERATELY_RUSTED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("moderately_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModTrapdoorBlock> EXTREMELY_RUSTED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("extremely_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);

    public static final DeferredBlock<TrapDoorBlock> WAXED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_MILDLY_RUSTED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_mildly_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_moderately_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_extremely_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);

    public static final DeferredBlock<ModPressurePlateBlock> MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("mildly_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<ModPressurePlateBlock> MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("moderately_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<ModPressurePlateBlock> EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("extremely_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_heavy_weighted_pressure_plate",150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_mildly_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_moderately_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_extremely_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<ModIronBarsBlock> MILDLY_RUSTED_IRON_BARS = registerRustingBarsBlock("mildly_rusted_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<ModIronBarsBlock> MODERATELY_RUSTED_IRON_BARS = registerRustingBarsBlock("moderately_rusted_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<ModIronBarsBlock> EXTREMELY_RUSTED_IRON_BARS = registerRustingBarsBlock("extremely_rusted_iron_bars", () -> Blocks.IRON_BARS);

    public static final DeferredBlock<IronBarsBlock> WAXED_IRON_BARS = registerBarsBlock("waxed_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_MILDLY_RUSTED_IRON_BARS = registerBarsBlock("waxed_mildly_rusted_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_MODERATELY_RUSTED_IRON_BARS = registerBarsBlock("waxed_moderately_rusted_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_EXTREMELY_RUSTED_IRON_BARS = registerBarsBlock("waxed_extremely_rusted_iron_bars", () -> Blocks.IRON_BARS);

    public static final DeferredBlock<DoorBlock> GOLD_DOOR = registerDoorBlock("gold_door", BlockSetType.GOLD, () -> Blocks.COPPER_DOOR);
    public static final DeferredBlock<TrapDoorBlock> GOLD_TRAPDOOR = registerTrapdoorBlock("gold_trapdoor", BlockSetType.GOLD, () -> Blocks.COPPER_DOOR);

    public static final DeferredBlock<KeyOnlyDoorBlock> NETHERITE_DOOR = registerLockableDoorBlock("netherite_door", ModBlockSetTypes.NETHERITE, () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<KeyOnlyTrapdoorBlock> NETHERITE_TRAPDOOR = registerLockableTrapdoorBlock("netherite_trapdoor", ModBlockSetTypes.NETHERITE, () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<PlayerOnlyPressurePlateBlock> PLAYER_ONLY_PRESSURE_PLATE = registerPlayerPressurePlate("player_only_pressure_plate", ModBlockSetTypes.NETHERITE, () -> Blocks.NETHERITE_BLOCK);

    public static final DeferredBlock<Block> POLISHED_CALCITE = registerBlockVariant("polished_calcite", () -> Blocks.CALCITE);
    public static final DeferredBlock<SlabBlock> POLISHED_CALCITE_SLAB = registerSlabBlock("polished_calcite_slab", () -> POLISHED_CALCITE.get());
    public static final DeferredBlock<StairBlock> POLISHED_CALCITE_STAIRS = registerStairBlock("polished_calcite_stairs", () -> POLISHED_CALCITE.get());
    public static final DeferredBlock<WallBlock> POLISHED_CALCITE_WALL = registerWallBlock("polished_calcite_wall", () -> POLISHED_CALCITE.get());

    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = registerBlockVariant("polished_dripstone", () -> Blocks.DRIPSTONE_BLOCK);
    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_SLAB = registerSlabBlock("polished_dripstone_slab", () -> POLISHED_DRIPSTONE.get());
    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_STAIRS = registerStairBlock("polished_dripstone_stairs", () -> POLISHED_DRIPSTONE.get());
    public static final DeferredBlock<WallBlock> POLISHED_DRIPSTONE_WALL = registerWallBlock("polished_dripstone_wall", () -> POLISHED_DRIPSTONE.get());

    public static final DeferredBlock<Block> POLISHED_GRANITE_BRICKS = registerBlockVariant("polished_granite_bricks", () -> Blocks.POLISHED_GRANITE);
    public static final DeferredBlock<SlabBlock> POLISHED_GRANITE_BRICK_SLAB = registerSlabBlock("polished_granite_brick_slab", () -> POLISHED_GRANITE_BRICKS.get());
    public static final DeferredBlock<StairBlock> POLISHED_GRANITE_BRICK_STAIRS = registerStairBlock("polished_granite_brick_stairs", () -> POLISHED_GRANITE_BRICKS.get());
    public static final DeferredBlock<WallBlock> POLISHED_GRANITE_BRICK_WALL = registerWallBlock("polished_granite_brick_wall", () -> POLISHED_GRANITE_BRICKS.get());

    public static final DeferredBlock<Block> POLISHED_DIORITE_BRICKS = registerBlockVariant("polished_diorite_bricks", () -> Blocks.POLISHED_DIORITE);
    public static final DeferredBlock<SlabBlock> POLISHED_DIORITE_BRICK_SLAB = registerSlabBlock("polished_diorite_brick_slab", () -> POLISHED_DIORITE_BRICKS.get());
    public static final DeferredBlock<StairBlock> POLISHED_DIORITE_BRICK_STAIRS = registerStairBlock("polished_diorite_brick_stairs", () -> POLISHED_DIORITE_BRICKS.get());
    public static final DeferredBlock<WallBlock> POLISHED_DIORITE_BRICK_WALL = registerWallBlock("polished_diorite_brick_wall", () -> POLISHED_DIORITE_BRICKS.get());

    public static final DeferredBlock<Block> POLISHED_ANDESITE_BRICKS = registerBlockVariant("polished_andesite_bricks", () -> Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<SlabBlock> POLISHED_ANDESITE_BRICK_SLAB = registerSlabBlock("polished_andesite_brick_slab", () -> POLISHED_ANDESITE_BRICKS.get());
    public static final DeferredBlock<StairBlock> POLISHED_ANDESITE_BRICK_STAIRS = registerStairBlock("polished_andesite_brick_stairs", () -> POLISHED_ANDESITE_BRICKS.get());
    public static final DeferredBlock<WallBlock> POLISHED_ANDESITE_BRICK_WALL = registerWallBlock("polished_andesite_brick_wall", () -> POLISHED_ANDESITE_BRICKS.get());

    public static final DeferredBlock<Block> CALCITE_BRICKS = registerBlockVariant("calcite_bricks", () -> POLISHED_CALCITE.get());
    public static final DeferredBlock<SlabBlock> CALCITE_BRICK_SLAB = registerSlabBlock("calcite_brick_slab", () -> CALCITE_BRICKS.get());
    public static final DeferredBlock<StairBlock> CALCITE_BRICK_STAIRS = registerStairBlock("calcite_brick_stairs", () -> CALCITE_BRICKS.get());
    public static final DeferredBlock<WallBlock> CALCITE_BRICK_WALL = registerWallBlock("calcite_brick_wall", () -> CALCITE_BRICKS.get());

    public static final DeferredBlock<Block> DRIPSTONE_BRICKS = registerBlockVariant("dripstone_bricks", () -> POLISHED_DRIPSTONE.get());
    public static final DeferredBlock<SlabBlock> DRIPSTONE_BRICK_SLAB = registerSlabBlock("dripstone_brick_slab", () -> DRIPSTONE_BRICKS.get());
    public static final DeferredBlock<StairBlock> DRIPSTONE_BRICK_STAIRS = registerStairBlock("dripstone_brick_stairs", () -> DRIPSTONE_BRICKS.get());
    public static final DeferredBlock<WallBlock> DRIPSTONE_BRICK_WALL = registerWallBlock("dripstone_brick_wall", () -> DRIPSTONE_BRICKS.get());

    public static final DeferredBlock<Block> BASALT_BRICKS = registerBlockVariant("basalt_bricks", () -> Blocks.POLISHED_BASALT);
    public static final DeferredBlock<SlabBlock> BASALT_BRICK_SLAB = registerSlabBlock("basalt_brick_slab", () -> BASALT_BRICKS.get());
    public static final DeferredBlock<StairBlock> BASALT_BRICK_STAIRS = registerStairBlock("basalt_brick_stairs", () -> BASALT_BRICKS.get());
    public static final DeferredBlock<WallBlock> BASALT_BRICK_WALL = registerWallBlock("basalt_brick_wall", () -> BASALT_BRICKS.get());

    public static final DeferredBlock<Block> CHARCOAL_BLOCK = registerBlockVariant("charcoal_block", () -> Blocks.COAL_BLOCK);

    public static final DeferredBlock<Block> SOUL_SANDSTONE = registerBlockVariant("soul_sandstone", () -> Blocks.SANDSTONE);
    public static final DeferredBlock<SlabBlock> SOUL_SANDSTONE_SLAB = registerSlabBlock("soul_sandstone_slab", () -> SOUL_SANDSTONE.get());
    public static final DeferredBlock<StairBlock> SOUL_SANDSTONE_STAIRS = registerStairBlock("soul_sandstone_stairs", () -> SOUL_SANDSTONE.get());
    public static final DeferredBlock<WallBlock> SOUL_SANDSTONE_WALL = registerWallBlock("soul_sandstone_wall", () -> SOUL_SANDSTONE.get());

    public static final DeferredBlock<Block> CUT_SOUL_SANDSTONE = registerBlockVariant("cut_soul_sandstone", () -> SOUL_SANDSTONE.get());
    public static final DeferredBlock<SlabBlock> CUT_SOUL_SANDSTONE_SLAB = registerSlabBlock("cut_soul_sandstone_slab", () -> CUT_SOUL_SANDSTONE.get());
    public static final DeferredBlock<StairBlock> CUT_SOUL_SANDSTONE_STAIRS = registerStairBlock("cut_soul_sandstone_stairs", () -> CUT_SOUL_SANDSTONE.get());
    public static final DeferredBlock<WallBlock> CUT_SOUL_SANDSTONE_WALL = registerWallBlock("cut_soul_sandstone_wall", () -> CUT_SOUL_SANDSTONE.get());

    public static final DeferredBlock<Block> SMOOTH_SOUL_SANDSTONE = registerBlockVariant("smooth_soul_sandstone", () -> SOUL_SANDSTONE.get());
    public static final DeferredBlock<SlabBlock> SMOOTH_SOUL_SANDSTONE_SLAB = registerSlabBlock("smooth_soul_sandstone_slab", () -> SMOOTH_SOUL_SANDSTONE.get());
    public static final DeferredBlock<StairBlock> SMOOTH_SOUL_SANDSTONE_STAIRS = registerStairBlock("smooth_soul_sandstone_stairs", () -> SMOOTH_SOUL_SANDSTONE.get());
    public static final DeferredBlock<WallBlock> SMOOTH_SOUL_SANDSTONE_WALL = registerWallBlock("smooth_soul_sandstone_wall", () -> SMOOTH_SOUL_SANDSTONE.get());

    public static final DeferredBlock<Block> CHISELED_SOUL_SANDSTONE = registerBlockVariant("chiseled_soul_sandstone", () -> SOUL_SANDSTONE.get());

    public static final DeferredBlock<Block> ELDER_PRISMARINE = registerBlockVariant("elder_prismarine", () -> Blocks.PRISMARINE);
    public static final DeferredBlock<SlabBlock> ELDER_PRISMARINE_SLAB = registerSlabBlock("elder_prismarine_slab", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<StairBlock> ELDER_PRISMARINE_STAIRS = registerStairBlock("elder_prismarine_stairs", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<WallBlock> ELDER_PRISMARINE_WALL = registerWallBlock("elder_prismarine_wall", () -> ELDER_PRISMARINE.get());

    public static final DeferredBlock<Block> ELDER_PRISMARINE_BRICKS = registerBlockVariant("elder_prismarine_bricks", () -> Blocks.PRISMARINE_BRICKS);
    public static final DeferredBlock<SlabBlock> ELDER_PRISMARINE_BRICK_SLAB = registerSlabBlock("elder_prismarine_brick_slab", () -> ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredBlock<StairBlock> ELDER_PRISMARINE_BRICK_STAIRS = registerStairBlock("elder_prismarine_brick_stairs", () -> ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredBlock<WallBlock> ELDER_PRISMARINE_BRICK_WALL = registerWallBlock("elder_prismarine_brick_wall", () -> ELDER_PRISMARINE_BRICKS.get());

    public static final DeferredBlock<Block> DARK_ELDER_PRISMARINE = registerBlockVariant("dark_elder_prismarine", () -> Blocks.DARK_PRISMARINE);
    public static final DeferredBlock<SlabBlock> DARK_ELDER_PRISMARINE_SLAB = registerSlabBlock("dark_elder_prismarine_slab", () -> DARK_ELDER_PRISMARINE.get());
    public static final DeferredBlock<StairBlock> DARK_ELDER_PRISMARINE_STAIRS = registerStairBlock("dark_elder_prismarine_stairs", () -> DARK_ELDER_PRISMARINE.get());
    public static final DeferredBlock<WallBlock> DARK_ELDER_PRISMARINE_WALL = registerWallBlock("dark_elder_prismarine_wall", () -> DARK_ELDER_PRISMARINE.get());

    public static final DeferredBlock<Block> ELDER_SEA_LANTERN = registerBlockVariant("elder_sea_lantern", () -> Blocks.SEA_LANTERN);

    public static final DeferredBlock<DropExperienceBlock> ZINC_ORE = registerOreBlock("zinc_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ZINC_ORE = registerDeepslateOreBlock("deepslate_zinc_ore");
    public static final DeferredBlock<Block> RAW_ZINC_BLOCK = registerBlockVariant("raw_zinc_block", () -> Blocks.RAW_IRON_BLOCK);

    public static final DeferredBlock<ModBlock> ZINC_BLOCK = registerRustingBlock("zinc_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModBlock> ZINC_TILES = registerRustingBlock("zinc_tiles", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> ZINC_TILE_SLAB = registerRustingSlabBlock("zinc_tile_slab", () -> ZINC_TILES.get());
    public static final DeferredBlock<ModStairBlock> ZINC_TILE_STAIRS = registerRustingStairBlock("zinc_tile_stairs", () -> ZINC_TILES.get());
    public static final DeferredBlock<ModDoorBlock> ZINC_DOOR = registerRustingDoorBlock("zinc_door", ModBlockSetTypes.ZINC, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModTrapdoorBlock> ZINC_TRAPDOOR = registerRustingTrapdoorBlock("zinc_trapdoor", ModBlockSetTypes.ZINC, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModPressurePlateBlock> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<ModBlock> SLIGHTLY_CORRODED_ZINC_BLOCK = registerRustingBlock("slightly_corroded_zinc_block", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModBlock> SLIGHTLY_CORRODED_ZINC_TILES = registerRustingBlock("slightly_corroded_zinc_tiles", () -> SLIGHTLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> SLIGHTLY_CORRODED_ZINC_TILE_SLAB = registerRustingSlabBlock("slightly_corroded_zinc_tile_slab", () -> SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModStairBlock> SLIGHTLY_CORRODED_ZINC_TILE_STAIRS = registerRustingStairBlock("slightly_corroded_zinc_tile_stairs", () -> SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModDoorBlock> SLIGHTLY_CORRODED_ZINC_DOOR = registerRustingDoorBlock("slightly_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> SLIGHTLY_CORRODED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("slightly_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("slightly_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<ModBlock> SOMEWHAT_CORRODED_ZINC_BLOCK = registerRustingBlock("somewhat_corroded_zinc_block", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModBlock> SOMEWHAT_CORRODED_ZINC_TILES = registerRustingBlock("somewhat_corroded_zinc_tiles", () -> SOMEWHAT_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> SOMEWHAT_CORRODED_ZINC_TILE_SLAB = registerRustingSlabBlock("somewhat_corroded_zinc_tile_slab", () -> SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModStairBlock> SOMEWHAT_CORRODED_ZINC_TILE_STAIRS = registerRustingStairBlock("somewhat_corroded_zinc_tile_stairs", () -> SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModDoorBlock> SOMEWHAT_CORRODED_ZINC_DOOR = registerRustingDoorBlock("somewhat_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> SOMEWHAT_CORRODED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("somewhat_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("somewhat_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<ModBlock> REALLY_CORRODED_ZINC_BLOCK = registerRustingBlock("really_corroded_zinc_block", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModBlock> REALLY_CORRODED_ZINC_TILES = registerRustingBlock("really_corroded_zinc_tiles", () -> REALLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> REALLY_CORRODED_ZINC_TILE_SLAB = registerRustingSlabBlock("really_corroded_zinc_tile_slab", () -> REALLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModStairBlock> REALLY_CORRODED_ZINC_TILE_STAIRS = registerRustingStairBlock("really_corroded_zinc_tile_stairs", () -> REALLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<ModDoorBlock> REALLY_CORRODED_ZINC_DOOR = registerRustingDoorBlock("really_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> REALLY_CORRODED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("really_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("really_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_ZINC_BLOCK = registerBlockVariant("waxed_zinc_block", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<Block> WAXED_ZINC_TILES = registerBlockVariant("waxed_zinc_tiles", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_ZINC_TILE_SLAB = registerSlabBlock("waxed_zinc_tile_slab", () -> WAXED_ZINC_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_ZINC_TILE_STAIRS = registerStairBlock("waxed_zinc_tile_stairs", () -> WAXED_ZINC_TILES.get());
    public static final DeferredBlock<DoorBlock> WAXED_ZINC_DOOR = registerDoorBlock("waxed_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK = registerBlockVariant("waxed_slightly_corroded_zinc_block", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<Block> WAXED_SLIGHTLY_CORRODED_ZINC_TILES = registerBlockVariant("waxed_slightly_corroded_zinc_tiles", () -> WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB = registerSlabBlock("waxed_slightly_corroded_zinc_tile_slab", () -> WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS = registerStairBlock("waxed_slightly_corroded_zinc_tile_stairs", () -> WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<DoorBlock> WAXED_SLIGHTLY_CORRODED_ZINC_DOOR = registerDoorBlock("waxed_slightly_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_slightly_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_slightly_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK = registerBlockVariant("waxed_somewhat_corroded_zinc_block", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<Block> WAXED_SOMEWHAT_CORRODED_ZINC_TILES = registerBlockVariant("waxed_somewhat_corroded_zinc_tiles", () -> WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB = registerSlabBlock("waxed_somewhat_corroded_zinc_tile_slab", () -> WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS = registerStairBlock("waxed_somewhat_corroded_zinc_tile_stairs", () -> WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<DoorBlock> WAXED_SOMEWHAT_CORRODED_ZINC_DOOR = registerDoorBlock("waxed_somewhat_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_somewhat_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_somewhat_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_REALLY_CORRODED_ZINC_BLOCK = registerBlockVariant("waxed_really_corroded_zinc_block", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<Block> WAXED_REALLY_CORRODED_ZINC_TILES = registerBlockVariant("waxed_really_corroded_zinc_tiles", () -> WAXED_REALLY_CORRODED_ZINC_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_REALLY_CORRODED_ZINC_TILE_SLAB = registerSlabBlock("waxed_really_corroded_zinc_tile_slab", () -> WAXED_REALLY_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<StairBlock> WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS = registerStairBlock("waxed_really_corroded_zinc_tile_stairs", () -> WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
    public static final DeferredBlock<DoorBlock> WAXED_REALLY_CORRODED_ZINC_DOOR = registerDoorBlock("waxed_really_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_REALLY_CORRODED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_really_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_really_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<DropExperienceBlock> SILVER_ORE = registerOreBlock("silver_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILVER_ORE = registerDeepslateOreBlock("deepslate_silver_ore");
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlockVariant("raw_silver_block", () -> Blocks.RAW_GOLD_BLOCK);

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlockVariant("silver_block", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> SILVER_TILES = registerBlockVariant("silver_tiles", () -> SILVER_BLOCK.get());
    public static final DeferredBlock<SlabBlock> SILVER_TILE_SLAB = registerSlabBlock("silver_tile_slab", () -> SILVER_TILES.get());
    public static final DeferredBlock<StairBlock> SILVER_TILE_STAIRS = registerStairBlock("silver_tile_stairs", () -> SILVER_TILES.get());
    public static final DeferredBlock<DoorBlock> SILVER_DOOR = registerDoorBlock("silver_door", ModBlockSetTypes.SILVER, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> SILVER_TRAPDOOR = registerTrapdoorBlock("silver_trapdoor", ModBlockSetTypes.SILVER, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("noticeably_light_weighted_pressure_plate", 40, ModBlockSetTypes.SILVER, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> TIN_ORE = registerOreBlock("tin_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TIN_ORE = registerDeepslateOreBlock("deepslate_tin_ore");
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlockVariant("raw_tin_block", () -> Blocks.RAW_COPPER_BLOCK);

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlockVariant("tin_block", () -> Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> CUT_TIN = registerBlockVariant("cut_tin", () -> TIN_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_TIN_SLAB = registerSlabBlock("cut_tin_slab", () -> CUT_TIN.get());
    public static final DeferredBlock<StairBlock> CUT_TIN_STAIRS = registerStairBlock("cut_tin_stairs", () -> CUT_TIN.get());
    public static final DeferredBlock<DoorBlock> TIN_DOOR = registerDoorBlock("tin_door", ModBlockSetTypes.TIN, () -> Blocks.COPPER_DOOR);
    public static final DeferredBlock<TrapDoorBlock> TIN_TRAPDOOR = registerTrapdoorBlock("tin_trapdoor", ModBlockSetTypes.TIN, () -> Blocks.COPPER_TRAPDOOR);
    public static final DeferredBlock<WeightedPressurePlateBlock> BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("barely_light_weighted_pressure_plate", 75, ModBlockSetTypes.TIN, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> TUNGSTEN_ORE = registerOreBlock("tungsten_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TUNGSTEN_ORE = registerDeepslateOreBlock("deepslate_tungsten_ore");
    public static final DeferredBlock<Block> RAW_TUNGSTEN_BLOCK = registerBlockVariant("raw_tungsten_block", () -> Blocks.RAW_GOLD_BLOCK);

    public static final DeferredBlock<Block> TUNGSTEN_BLOCK = registerBlockVariant("tungsten_block", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> TUNGSTEN_TILES = registerBlockVariant("tungsten_tiles", () -> TUNGSTEN_BLOCK.get());
    public static final DeferredBlock<SlabBlock> TUNGSTEN_TILE_SLAB = registerSlabBlock("tungsten_tile_slab", () -> TUNGSTEN_TILES.get());
    public static final DeferredBlock<StairBlock> TUNGSTEN_TILE_STAIRS = registerStairBlock("tungsten_tile_stairs", () -> TUNGSTEN_TILES.get());
    public static final DeferredBlock<DoorBlock> TUNGSTEN_DOOR = registerDoorBlock("tungsten_door", ModBlockSetTypes.TUNGSTEN, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> TUNGSTEN_TRAPDOOR = registerTrapdoorBlock("tungsten_trapdoor", ModBlockSetTypes.TUNGSTEN, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("extraordinarily_heavy_weighted_pressure_plate", 1500, ModBlockSetTypes.TUNGSTEN, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> PLATINUM_ORE = registerOreBlock("platinum_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_PLATINUM_ORE = registerDeepslateOreBlock("deepslate_platinum_ore");
    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = registerBlockVariant("raw_platinum_block", () -> Blocks.RAW_GOLD_BLOCK);

    public static final DeferredBlock<Block> PLATINUM_BLOCK = registerBlockVariant("platinum_block", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> PLATINUM_TILES = registerBlockVariant("platinum_tiles", () -> PLATINUM_BLOCK.get());
    public static final DeferredBlock<SlabBlock> PLATINUM_TILE_SLAB = registerSlabBlock("platinum_tile_slab", () -> PLATINUM_TILES.get());
    public static final DeferredBlock<StairBlock> PLATINUM_TILE_STAIRS = registerStairBlock("platinum_tile_stairs", () -> PLATINUM_TILES.get());
    public static final DeferredBlock<DoorBlock> PLATINUM_DOOR = registerDoorBlock("platinum_door", ModBlockSetTypes.PLATINUM, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> PLATINUM_TRAPDOOR = registerTrapdoorBlock("platinum_trapdoor", ModBlockSetTypes.PLATINUM, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("extraordinarily_light_weighted_pressure_plate", 2, ModBlockSetTypes.PLATINUM, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> LEAD_ORE = registerOreBlock("lead_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_LEAD_ORE = registerDeepslateOreBlock("deepslate_lead_ore");
    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = registerBlockVariant("raw_lead_block", () -> Blocks.RAW_COPPER_BLOCK);

    public static final DeferredBlock<Block> LEAD_BLOCK = registerBlockVariant("lead_block", () -> Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> LEAD_TILES = registerBlockVariant("lead_tiles", () -> LEAD_BLOCK.get());
    public static final DeferredBlock<SlabBlock> LEAD_TILE_SLAB = registerSlabBlock("lead_tile_slab", () -> LEAD_TILES.get());
    public static final DeferredBlock<StairBlock> LEAD_TILE_STAIRS = registerStairBlock("lead_tile_stairs", () -> LEAD_TILES.get());
    public static final DeferredBlock<DoorBlock> LEAD_DOOR = registerDoorBlock("lead_door", ModBlockSetTypes.LEAD, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> LEAD_TRAPDOOR = registerTrapdoorBlock("lead_trapdoor", ModBlockSetTypes.LEAD, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("noticeably_heavy_weighted_pressure_plate", 125, ModBlockSetTypes.LEAD, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> URANIUM_ORE = registerOreBlock("uranium_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_URANIUM_ORE = registerDeepslateOreBlock("deepslate_uranium_ore");
    public static final DeferredBlock<Block> RAW_URANIUM_BLOCK = registerBlockVariant("raw_uranium_block", () -> Blocks.RAW_GOLD_BLOCK);

    public static final DeferredBlock<Block> URANIUM_BLOCK = registerBlockVariant("uranium_block", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<Block> URANIUM_TILES = registerBlockVariant("uranium_tiles", () -> URANIUM_BLOCK.get());
    public static final DeferredBlock<SlabBlock> URANIUM_TILE_SLAB = registerSlabBlock("uranium_tile_slab", () -> URANIUM_TILES.get());
    public static final DeferredBlock<StairBlock> URANIUM_TILE_STAIRS = registerStairBlock("uranium_tile_stairs", () -> URANIUM_TILES.get());
    public static final DeferredBlock<DoorBlock> URANIUM_DOOR = registerDoorBlock("uranium_door", ModBlockSetTypes.URANIUM, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> URANIUM_TRAPDOOR = registerTrapdoorBlock("uranium_trapdoor", ModBlockSetTypes.URANIUM, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("negligible_weighted_pressure_plate", 1, ModBlockSetTypes.URANIUM, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlockVariant("bronze_block", () -> Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> CUT_BRONZE = registerBlockVariant("cut_bronze", () -> BRONZE_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_BRONZE_SLAB = registerSlabBlock("cut_bronze_slab", () -> CUT_BRONZE.get());
    public static final DeferredBlock<StairBlock> CUT_BRONZE_STAIRS = registerStairBlock("cut_bronze_stairs", () -> CUT_BRONZE.get());
    public static final DeferredBlock<DoorBlock> BRONZE_DOOR = registerDoorBlock("bronze_door", ModBlockSetTypes.BRONZE, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> BRONZE_TRAPDOOR = registerTrapdoorBlock("bronze_trapdoor", ModBlockSetTypes.BRONZE, () -> Blocks.COPPER_TRAPDOOR);
    public static final DeferredBlock<AnimalOnlyPressurePlateBlock> PASSIVE_MOB_ONLY_PRESSURE_PLATE = registerAnimalPressurePlate("passive_mob_only_pressure_plate",  ModBlockSetTypes.BRONZE, () -> BRONZE_BLOCK.get());

    public static final DeferredBlock<Block> BRASS_BLOCK = registerBlockVariant("brass_block", () -> Blocks.COPPER_BLOCK);
    public static final DeferredBlock<Block> BRASS_TILES = registerBlockVariant("brass_tiles", () -> BRASS_BLOCK.get());
    public static final DeferredBlock<SlabBlock> BRASS_TILE_SLAB = registerSlabBlock("brass_tile_slab", () -> BRASS_TILES.get());
    public static final DeferredBlock<StairBlock> BRASS_TILE_STAIRS = registerStairBlock("brass_tile_stairs", () -> BRASS_TILES.get());
    public static final DeferredBlock<DoorBlock> BRASS_DOOR = registerDoorBlock("brass_door", ModBlockSetTypes.BRASS, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> BRASS_TRAPDOOR = registerTrapdoorBlock("brass_trapdoor", ModBlockSetTypes.BRASS, () -> Blocks.COPPER_TRAPDOOR);
    public static final DeferredBlock<MonsterOnlyPressurePlateBlock> HOSTILE_MOB_ONLY_PRESSURE_PLATE = registerMonsterPressurePlate("hostile_mob_only_pressure_plate",  ModBlockSetTypes.BRASS, () -> BRASS_BLOCK.get());

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlockVariant("steel_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> STEEL_TILES = registerBlockVariant("steel_tiles", () -> STEEL_BLOCK.get());
    public static final DeferredBlock<SlabBlock> STEEL_TILE_SLAB = registerSlabBlock("steel_tile_slab", () -> STEEL_TILES.get());
    public static final DeferredBlock<StairBlock> STEEL_TILE_STAIRS = registerStairBlock("steel_tile_stairs", () -> STEEL_TILES.get());
    public static final DeferredBlock<DoorBlock> STEEL_DOOR = registerDoorBlock("steel_door", ModBlockSetTypes.STEEL, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> STEEL_TRAPDOOR = registerTrapdoorBlock("steel_trapdoor", ModBlockSetTypes.STEEL, () -> Blocks.COPPER_TRAPDOOR);
    public static final DeferredBlock<NPCOnlyPressurePlateBlock> VILLAGER_ONLY_PRESSURE_PLATE = registerNPCPressurePlate("villager_only_pressure_plate",  ModBlockSetTypes.STEEL, () -> STEEL_BLOCK.get());

    public static final DeferredBlock<ModLiquidBlock> NUCLEAR_WASTE = registerLiquid("nuclear_waste", () -> ModFluids.NUCLEAR_WASTE.get());
    public static final DeferredBlock<NukeBlock> NUKE = registerNuke("nuke");


    public static DeferredBlock<NukeBlock> registerNuke(String registryName) {
        return BLOCKS.register(
                registryName, () -> new NukeBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.TNT)
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                ResourceLocation.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    public static DeferredBlock<ModLiquidBlock> registerLiquid(String registryName, Supplier<FlowingFluid> fluid) {
        return BLOCKS.register(
                registryName, () -> new ModLiquidBlock(
                        fluid.get(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)
                                .noCollission()
                                .noLootTable()
                                .liquid()
                                .pushReaction(PushReaction.DESTROY)
                                .replaceable()
                                .setId(
                                    ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                    )
                                )
                        )
                )
        );
    }

    public static DeferredBlock<WeatheringCopperPressurePlateBlock> registerOxidizingPressurePlate(String registryName, int maxWeight, BlockSetType type, WeatheringCopper.WeatherState weatherState, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new WeatheringCopperPressurePlateBlock(
                        maxWeight,
                        type,
                        weatherState,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModPressurePlateBlock> registerRustingWeightedPressurePlate(String registryName, int maxWeight, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModPressurePlateBlock(
                        maxWeight,
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModTrapdoorBlock> registerRustingTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModIronBarsBlock> registerRustingBarsBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModIronBarsBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<IronBarsBlock> registerBarsBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IronBarsBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModDoorBlock> registerRustingDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<KeyOnlyDoorBlock> registerLockableDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new KeyOnlyDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).strength(50.0F, 1200.0F)
                )
        );
    }

    public static DeferredBlock<KeyOnlyTrapdoorBlock> registerLockableTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new KeyOnlyTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).strength(50.0F, 1200.0F)
                )
        );
    }

    public static DeferredBlock<DoorBlock> registerDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        if (type == ModBlockSetTypes.TUNGSTEN) {
            return BLOCKS.register(
                    registryName, () -> new DoorBlock(
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new DoorBlock(
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    public static DeferredBlock<TrapDoorBlock> registerTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        if (type == ModBlockSetTypes.TUNGSTEN) {
            return BLOCKS.register(
                    registryName, () -> new TrapDoorBlock(
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new TrapDoorBlock(
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    public static DeferredBlock<ModBlock> registerRustingBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModSlabBlock> registerRustingSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    public static DeferredBlock<ModStairBlock> registerRustingStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<WeightedPressurePlateBlock> registerWeightedPressurePlate(String registryName, int maxWeight, BlockSetType type, Supplier<Block> baseBlock) {
        if (type == ModBlockSetTypes.TUNGSTEN) {
            return BLOCKS.register(
                    registryName, () -> new WeightedPressurePlateBlock(
                            maxWeight,
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new WeightedPressurePlateBlock(
                            maxWeight,
                            type,
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    private static DeferredBlock<PlayerOnlyPressurePlateBlock> registerPlayerPressurePlate(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PlayerOnlyPressurePlateBlock(
                    type,
                    BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            )
                            .setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                )
        );
    }

    private static DeferredBlock<AnimalOnlyPressurePlateBlock> registerAnimalPressurePlate(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new AnimalOnlyPressurePlateBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                        baseBlock.get()
                                )
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                ResourceLocation.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<MonsterOnlyPressurePlateBlock> registerMonsterPressurePlate(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new MonsterOnlyPressurePlateBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                        baseBlock.get()
                                )
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                ResourceLocation.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<NPCOnlyPressurePlateBlock> registerNPCPressurePlate(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new NPCOnlyPressurePlateBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                        baseBlock.get()
                                )
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                ResourceLocation.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<Block> registerBlockVariant(String registryName, Supplier<Block> baseBlock) {
        if (registryName == "raw_tungsten_block" || registryName == "tungsten_block") {
            return BLOCKS.register(
                    registryName, () -> new Block(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new Block(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    private static DeferredBlock<DropExperienceBlock> registerOreBlock(String registryName) {
        if (registryName == "tungsten_ore") {
            return BLOCKS.register(
                    registryName, () -> new DropExperienceBlock(
                            ConstantInt.of(0),
                            BlockBehaviour.Properties.ofFullCopy(
                                    Blocks.IRON_ORE
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new DropExperienceBlock(
                            ConstantInt.of(0),
                            BlockBehaviour.Properties.ofFullCopy(
                                    Blocks.IRON_ORE
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    private static DeferredBlock<DropExperienceBlock> registerDeepslateOreBlock(String registryName) {
        if (registryName == "deepslate_tungsten_ore") {
            return BLOCKS.register(
                    registryName, () -> new DropExperienceBlock(
                            ConstantInt.of(0),
                            BlockBehaviour.Properties.ofFullCopy(
                                    Blocks.DEEPSLATE_IRON_ORE
                            ).strength(
                                    45.0F,
                                    2000.0F
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            ResourceLocation.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new DropExperienceBlock(
                            ConstantInt.of(0),
                            BlockBehaviour.Properties.ofFullCopy(
                                    Blocks.DEEPSLATE_IRON_ORE
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    private static DeferredBlock<WallBlock> registerWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new WallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<SlabBlock> registerSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new SlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        ResourceLocation.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<StairBlock> registerStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new StairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
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
        BLOCKS.register(eventBus);
    }
}
