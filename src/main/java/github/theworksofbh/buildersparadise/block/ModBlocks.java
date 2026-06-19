package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

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

    public static final DeferredBlock<ModBlock> CUT_IRON = registerRustingBlock("cut_iron", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModSlabBlock> CUT_IRON_SLAB = registerRustingSlabBlock("cut_iron_slab", () -> CUT_IRON.get());
    public static final DeferredBlock<ModStairBlock> CUT_IRON_STAIRS = registerRustingStairBlock("cut_iron_stairs", () -> CUT_IRON.get());

    public static final DeferredBlock<Block> CUT_GOLD = registerBlockVariant("cut_gold", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<SlabBlock> CUT_GOLD_SLAB = registerSlabBlock("cut_gold_slab", () -> CUT_GOLD.get());
    public static final DeferredBlock<StairBlock> CUT_GOLD_STAIRS = registerStairBlock("cut_gold_stairs", () -> CUT_GOLD.get());

    public static final DeferredBlock<Block> CUT_DIAMOND = registerBlockVariant("cut_diamond", () -> Blocks.DIAMOND_BLOCK);
    public static final DeferredBlock<SlabBlock> CUT_DIAMOND_SLAB = registerSlabBlock("cut_diamond_slab", () -> CUT_DIAMOND.get());
    public static final DeferredBlock<StairBlock> CUT_DIAMOND_STAIRS = registerStairBlock("cut_diamond_stairs", () -> CUT_DIAMOND.get());

    public static final DeferredBlock<Block> CUT_EMERALD = registerBlockVariant("cut_emerald", () -> Blocks.EMERALD_BLOCK);
    public static final DeferredBlock<SlabBlock> CUT_EMERALD_STAIRS = registerSlabBlock("cut_emerald_slab", () -> CUT_EMERALD.get());
    public static final DeferredBlock<StairBlock> CUT_EMERALD_SLAB = registerStairBlock("cut_emerald_stairs", () -> CUT_EMERALD.get());

    public static final DeferredBlock<Block> CUT_NETHERITE = registerBlockVariant("cut_netherite", () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<SlabBlock> CUT_NETHERITE_SLAB = registerSlabBlock("cut_netherite_slab", () -> CUT_NETHERITE.get());
    public static final DeferredBlock<StairBlock> CUT_NETHERITE_STAIRS = registerStairBlock("cut_netherite_stairs", () -> CUT_NETHERITE.get());

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

    public static final DeferredBlock<ModBlock> EXPOSED_IRON = registerRustingBlock("exposed_iron", () -> Blocks.IRON_BLOCK, MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<ModBlock> WEATHERED_IRON = registerRustingBlock("weathered_iron", () -> Blocks.IRON_BLOCK, MapColor.STONE);
    public static final DeferredBlock<ModBlock> RUSTED_IRON = registerRustingBlock("rusted_iron", () -> Blocks.IRON_BLOCK, MapColor.COLOR_GRAY);

    public static final DeferredBlock<Block> WAXED_IRON_BLOCK = registerBlockVariant("waxed_iron_block", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<Block> WAXED_EXPOSED_IRON = registerBlockVariant("waxed_exposed_iron", () -> Blocks.IRON_BLOCK, MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> WAXED_WEATHERED_IRON = registerBlockVariant("waxed_weathered_iron", () -> Blocks.IRON_BLOCK, MapColor.STONE);
    public static final DeferredBlock<Block> WAXED_RUSTED_IRON = registerBlockVariant("waxed_rusted_iron", () -> Blocks.IRON_BLOCK, MapColor.COLOR_GRAY);

    public static final DeferredBlock<ModBlock> EXPOSED_CUT_IRON = registerRustingBlock("exposed_cut_iron", () -> EXPOSED_IRON.get());
    public static final DeferredBlock<ModSlabBlock> EXPOSED_CUT_IRON_SLAB = registerRustingSlabBlock("exposed_cut_iron_slab", () -> EXPOSED_CUT_IRON.get());
    public static final DeferredBlock<ModStairBlock> EXPOSED_CUT_IRON_STAIRS = registerRustingStairBlock("exposed_cut_iron_stairs", () -> EXPOSED_CUT_IRON.get());

    public static final DeferredBlock<ModBlock> WEATHERED_CUT_IRON = registerRustingBlock("weathered_cut_iron", () -> WEATHERED_IRON.get());
    public static final DeferredBlock<ModSlabBlock> WEATHERED_CUT_IRON_SLAB = registerRustingSlabBlock("weathered_cut_iron_slab", () -> WEATHERED_CUT_IRON.get());
    public static final DeferredBlock<ModStairBlock> WEATHERED_CUT_IRON_STAIRS = registerRustingStairBlock("weathered_cut_iron_stairs", () -> WEATHERED_CUT_IRON.get());

    public static final DeferredBlock<ModBlock> RUSTED_CUT_IRON = registerRustingBlock("rusted_cut_iron", () -> RUSTED_IRON.get());
    public static final DeferredBlock<ModSlabBlock> RUSTED_CUT_IRON_SLAB = registerRustingSlabBlock("rusted_cut_iron_slab", () -> RUSTED_CUT_IRON.get());
    public static final DeferredBlock<ModStairBlock> RUSTED_CUT_IRON_STAIRS = registerRustingStairBlock("rusted_cut_iron_stairs", () -> RUSTED_CUT_IRON.get());

    public static final DeferredBlock<Block> WAXED_CUT_IRON = registerBlockVariant("waxed_cut_iron", () -> WAXED_IRON_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_CUT_IRON_SLAB = registerSlabBlock("waxed_cut_iron_slab", () -> WAXED_CUT_IRON.get());
    public static final DeferredBlock<StairBlock> WAXED_CUT_IRON_STAIRS = registerStairBlock("waxed_cut_iron_stairs", () -> WAXED_CUT_IRON.get());

    public static final DeferredBlock<Block> WAXED_EXPOSED_CUT_IRON = registerBlockVariant("waxed_exposed_cut_iron", () -> WAXED_EXPOSED_IRON.get());
    public static final DeferredBlock<SlabBlock> WAXED_EXPOSED_CUT_IRON_SLAB = registerSlabBlock("waxed_exposed_cut_iron_slab", () -> WAXED_EXPOSED_CUT_IRON.get());
    public static final DeferredBlock<StairBlock> WAXED_EXPOSED_CUT_IRON_STAIRS = registerStairBlock("waxed_exposed_cut_iron_stairs", () -> WAXED_EXPOSED_CUT_IRON.get());

    public static final DeferredBlock<Block> WAXED_WEATHERED_CUT_IRON = registerBlockVariant("waxed_weathered_cut_iron", () -> WAXED_WEATHERED_IRON.get());
    public static final DeferredBlock<SlabBlock> WAXED_WEATHERED_CUT_IRON_SLAB = registerSlabBlock("waxed_weathered_cut_iron_slab", () -> WAXED_WEATHERED_CUT_IRON.get());
    public static final DeferredBlock<StairBlock> WAXED_WEATHERED_CUT_IRON_STAIRS = registerStairBlock("waxed_weathered_cut_iron_stairs", () -> WAXED_WEATHERED_CUT_IRON.get());

    public static final DeferredBlock<Block> WAXED_RUSTED_CUT_IRON = registerBlockVariant("waxed_rusted_cut_iron", () -> WAXED_RUSTED_IRON.get());
    public static final DeferredBlock<SlabBlock> WAXED_RUSTED_CUT_IRON_SLAB = registerSlabBlock("waxed_rusted_cut_iron_slab", () -> WAXED_RUSTED_CUT_IRON.get());
    public static final DeferredBlock<StairBlock> WAXED_RUSTED_CUT_COPPER_STAIRS = registerStairBlock("waxed_rusted_cut_iron_stairs", () -> WAXED_RUSTED_CUT_IRON.get());

    public static final DeferredBlock<ModDoorBlock> EXPOSED_IRON_DOOR = registerRustingDoorBlock("exposed_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModDoorBlock> WEATHERED_IRON_DOOR = registerRustingDoorBlock("weathered_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModDoorBlock> RUSTED_IRON_DOOR = registerRustingDoorBlock("rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);

    public static final DeferredBlock<DoorBlock> WAXED_IRON_DOOR = registerDoorBlock("waxed_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_EXPOSED_IRON_DOOR = registerDoorBlock("waxed_exposed_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_WEATHERED_IRON_DOOR = registerDoorBlock("waxed_weathered_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<DoorBlock> WAXED_RUSTED_IRON_DOOR = registerDoorBlock("waxed_rusted_iron_door", BlockSetType.IRON, () -> Blocks.IRON_DOOR);

    public static final DeferredBlock<ModTrapdoorBlock> EXPOSED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("exposed_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModTrapdoorBlock> WEATHERED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("weathered_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModTrapdoorBlock> RUSTED_IRON_TRAPDOOR = registerRustingTrapdoorBlock("rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);

    public static final DeferredBlock<TrapDoorBlock> WAXED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_EXPOSED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_exposed_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_WEATHERED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_weathered_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<TrapDoorBlock> WAXED_RUSTED_IRON_TRAPDOOR = registerTrapdoorBlock("waxed_rusted_iron_trapdoor", BlockSetType.IRON, () -> Blocks.IRON_TRAPDOOR);

    public static final DeferredBlock<ModPressurePlateBlock> EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("exposed_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<ModPressurePlateBlock> WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("weathered_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<ModPressurePlateBlock> RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_heavy_weighted_pressure_plate",150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_exposed_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_weathered_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_rusted_heavy_weighted_pressure_plate", 150, BlockSetType.IRON, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<ModIronBarsBlock> EXPOSED_IRON_BARS = registerRustingBarsBlock("exposed_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<ModIronBarsBlock> WEATHERED_IRON_BARS = registerRustingBarsBlock("weathered_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<ModIronBarsBlock> RUSTED_IRON_BARS = registerRustingBarsBlock("rusted_iron_bars", () -> Blocks.IRON_BARS);

    public static final DeferredBlock<IronBarsBlock> WAXED_IRON_BARS = registerBarsBlock("waxed_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_EXPOSED_IRON_BARS = registerBarsBlock("waxed_exposed_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_WEATHERED_IRON_BARS = registerBarsBlock("waxed_weathered_iron_bars", () -> Blocks.IRON_BARS);
    public static final DeferredBlock<IronBarsBlock> WAXED_RUSTED_IRON_BARS = registerBarsBlock("waxed_rusted_iron_bars", () -> Blocks.IRON_BARS);

    public static final DeferredBlock<DoorBlock> GOLD_DOOR = registerDoorBlock("gold_door", BlockSetType.GOLD, () -> Blocks.COPPER_DOOR.weathering().unaffected());
    public static final DeferredBlock<TrapDoorBlock> GOLD_TRAPDOOR = registerTrapdoorBlock("gold_trapdoor", BlockSetType.GOLD, () -> Blocks.COPPER_DOOR.weathering().unaffected());

    public static final DeferredBlock<KeyOnlyDoorBlock> NETHERITE_DOOR = registerLockableDoorBlock("netherite_door", ModBlockSetTypes.NETHERITE, () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<KeyOnlyTrapdoorBlock> NETHERITE_TRAPDOOR = registerLockableTrapdoorBlock("netherite_trapdoor", ModBlockSetTypes.NETHERITE, () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<PlayerOnlyPressurePlateBlock> PLAYER_ONLY_PRESSURE_PLATE = registerPlayerPressurePlate("player_only_pressure_plate", ModBlockSetTypes.NETHERITE, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

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

    public static final DeferredBlock<Block> CHARCOAL_BLOCK = registerBlockVariant("charcoal_block", () -> Blocks.COAL_BLOCK, MapColor.TERRACOTTA_GRAY);

    public static final DeferredBlock<Block> SOUL_SANDSTONE = registerBlockVariant("soul_sandstone", () -> Blocks.SANDSTONE, MapColor.TERRACOTTA_BROWN);
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

    public static final DeferredBlock<Block> ELDER_PRISMARINE = registerBlockVariant("elder_prismarine", () -> Blocks.PRISMARINE, MapColor.WOOD);
    public static final DeferredBlock<SlabBlock> ELDER_PRISMARINE_SLAB = registerSlabBlock("elder_prismarine_slab", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<StairBlock> ELDER_PRISMARINE_STAIRS = registerStairBlock("elder_prismarine_stairs", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<WallBlock> ELDER_PRISMARINE_WALL = registerWallBlock("elder_prismarine_wall", () -> ELDER_PRISMARINE.get());

    public static final DeferredBlock<Block> ELDER_PRISMARINE_BRICKS = registerBlockVariant("elder_prismarine_bricks", () -> Blocks.PRISMARINE_BRICKS, MapColor.WOOD);
    public static final DeferredBlock<SlabBlock> ELDER_PRISMARINE_BRICK_SLAB = registerSlabBlock("elder_prismarine_brick_slab", () -> ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredBlock<StairBlock> ELDER_PRISMARINE_BRICK_STAIRS = registerStairBlock("elder_prismarine_brick_stairs", () -> ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredBlock<WallBlock> ELDER_PRISMARINE_BRICK_WALL = registerWallBlock("elder_prismarine_brick_wall", () -> ELDER_PRISMARINE_BRICKS.get());

    public static final DeferredBlock<Block> DARK_ELDER_PRISMARINE = registerBlockVariant("dark_elder_prismarine", () -> Blocks.DARK_PRISMARINE, MapColor.COLOR_BROWN);
    public static final DeferredBlock<SlabBlock> DARK_ELDER_PRISMARINE_SLAB = registerSlabBlock("dark_elder_prismarine_slab", () -> DARK_ELDER_PRISMARINE.get());
    public static final DeferredBlock<StairBlock> DARK_ELDER_PRISMARINE_STAIRS = registerStairBlock("dark_elder_prismarine_stairs", () -> DARK_ELDER_PRISMARINE.get());
    public static final DeferredBlock<WallBlock> DARK_ELDER_PRISMARINE_WALL = registerWallBlock("dark_elder_prismarine_wall", () -> DARK_ELDER_PRISMARINE.get());

    public static final DeferredBlock<Block> ELDER_SEA_LANTERN = registerBlockVariant("elder_sea_lantern", () -> Blocks.SEA_LANTERN);

    public static final DeferredBlock<DropExperienceBlock> ZINC_ORE = registerOreBlock("zinc_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ZINC_ORE = registerDeepslateOreBlock("deepslate_zinc_ore");
    public static final DeferredBlock<Block> RAW_ZINC_BLOCK = registerBlockVariant("raw_zinc_block", () -> Blocks.RAW_IRON_BLOCK, MapColor.SNOW);

    public static final DeferredBlock<ModBlock> ZINC_BLOCK = registerRustingBlock("zinc_block", () -> Blocks.IRON_BLOCK, MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<ModBlock> CUT_ZINC = registerRustingBlock("cut_zinc", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModSlabBlock> CUT_ZINC_SLAB = registerRustingSlabBlock("cut_zinc_slab", () -> CUT_ZINC.get());
    public static final DeferredBlock<ModStairBlock> CUT_ZINC_STAIRS = registerRustingStairBlock("cut_zinc_stairs", () -> CUT_ZINC.get());
    public static final DeferredBlock<ModDoorBlock> ZINC_DOOR = registerRustingDoorBlock("zinc_door", ModBlockSetTypes.ZINC, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<ModTrapdoorBlock> ZINC_TRAPDOOR = registerRustingTrapdoorBlock("zinc_trapdoor", ModBlockSetTypes.ZINC, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<ModPressurePlateBlock> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<ModBlock> EXPOSED_ZINC = registerRustingBlock("exposed_zinc", () -> ZINC_BLOCK.get(), MapColor.METAL);
    public static final DeferredBlock<ModBlock> EXPOSED_CUT_ZINC = registerRustingBlock("exposed_cut_zinc", () -> EXPOSED_ZINC.get());
    public static final DeferredBlock<ModSlabBlock> EXPOSED_CUT_ZINC_SLAB = registerRustingSlabBlock("exposed_cut_zinc_slab", () -> EXPOSED_CUT_ZINC.get());
    public static final DeferredBlock<ModStairBlock> EXPOSED_CUT_ZINC_STAIRS = registerRustingStairBlock("exposed_cut_zinc_stairs", () -> EXPOSED_CUT_ZINC.get());
    public static final DeferredBlock<ModDoorBlock> EXPOSED_ZINC_DOOR = registerRustingDoorBlock("exposed_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> EXPOSED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("exposed_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("exposed_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<ModBlock> WEATHERED_ZINC = registerRustingBlock("weathered_zinc", () -> ZINC_BLOCK.get(), MapColor.WOOL);
    public static final DeferredBlock<ModBlock> WEATHERED_CUT_ZINC = registerRustingBlock("weathered_cut_zinc", () -> WEATHERED_ZINC.get());
    public static final DeferredBlock<ModSlabBlock> WEATHERED_CUT_ZINC_SLAB = registerRustingSlabBlock("weathered_cut_zinc_slab", () -> WEATHERED_CUT_ZINC.get());
    public static final DeferredBlock<ModStairBlock> WEATHERED_CUT_ZINC_STAIRS = registerRustingStairBlock("weathered_cut_zinc_stairs", () -> WEATHERED_CUT_ZINC.get());
    public static final DeferredBlock<ModDoorBlock> WEATHERED_ZINC_DOOR = registerRustingDoorBlock("weathered_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> WEATHERED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("weathered_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("weathered_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<ModBlock> CORRODED_ZINC = registerRustingBlock("corroded_zinc", () -> ZINC_BLOCK.get(), MapColor.SNOW);
    public static final DeferredBlock<ModBlock> CORRODED_CUT_ZINC = registerRustingBlock("corroded_cut_zinc", () -> CORRODED_ZINC.get());
    public static final DeferredBlock<ModSlabBlock> CORRODED_CUT_ZINC_SLAB = registerRustingSlabBlock("corroded_cut_zinc_slab", () -> CORRODED_CUT_ZINC.get());
    public static final DeferredBlock<ModStairBlock> CORRODED_CUT_ZINC_STAIRS = registerRustingStairBlock("corroded_cut_zinc_stairs", () -> CORRODED_CUT_ZINC.get());
    public static final DeferredBlock<ModDoorBlock> CORRODED_ZINC_DOOR = registerRustingDoorBlock("corroded_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<ModTrapdoorBlock> CORRODED_ZINC_TRAPDOOR = registerRustingTrapdoorBlock("corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<ModPressurePlateBlock> CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerRustingWeightedPressurePlate("corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_ZINC_BLOCK = registerBlockVariant("waxed_zinc_block", () -> ZINC_BLOCK.get(), MapColor.COLOR_LIGHT_GRAY);
    public static final DeferredBlock<Block> WAXED_CUT_ZINC = registerBlockVariant("waxed_cut_zinc", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<SlabBlock> WAXED_CUT_ZINC_SLAB = registerSlabBlock("waxed_cut_zinc_slab", () -> WAXED_CUT_ZINC.get());
    public static final DeferredBlock<StairBlock> WAXED_CUT_ZINC_STAIRS = registerStairBlock("waxed_cut_zinc_stairs", () -> WAXED_CUT_ZINC.get());
    public static final DeferredBlock<DoorBlock> WAXED_ZINC_DOOR = registerDoorBlock("waxed_zinc_door", ModBlockSetTypes.ZINC, () -> ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_EXPOSED_ZINC = registerBlockVariant("waxed_exposed_zinc", () -> WAXED_ZINC_BLOCK.get(), MapColor.METAL);
    public static final DeferredBlock<Block> WAXED_EXPOSED_CUT_ZINC = registerBlockVariant("waxed_exposed_cut_zinc", () -> WAXED_EXPOSED_ZINC.get());
    public static final DeferredBlock<SlabBlock> WAXED_EXPOSED_CUT_ZINC_SLAB = registerSlabBlock("waxed_exposed_cut_zinc_slab", () -> WAXED_EXPOSED_CUT_ZINC.get());
    public static final DeferredBlock<StairBlock> WAXED_EXPOSED_CUT_ZINC_STAIRS = registerStairBlock("waxed_exposed_cut_zinc_stairs", () -> WAXED_EXPOSED_CUT_ZINC.get());
    public static final DeferredBlock<DoorBlock> WAXED_EXPOSED_ZINC_DOOR = registerDoorBlock("waxed_exposed_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_EXPOSED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_exposed_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_exposed_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_WEATHERED_ZINC = registerBlockVariant("waxed_weathered_zinc", () -> WAXED_ZINC_BLOCK.get(), MapColor.WOOL);
    public static final DeferredBlock<Block> WAXED_WEATHERED_CUT_ZINC = registerBlockVariant("waxed_weathered_cut_zinc", () -> WAXED_WEATHERED_ZINC.get());
    public static final DeferredBlock<SlabBlock> WAXED_WEATHERED_CUT_ZINC_SLAB = registerSlabBlock("waxed_weathered_cut_zinc_slab", () -> WAXED_WEATHERED_CUT_ZINC.get());
    public static final DeferredBlock<StairBlock> WAXED_WEATHERED_CUT_ZINC_STAIRS = registerStairBlock("waxed_weathered_cut_zinc_stairs", () -> WAXED_WEATHERED_CUT_ZINC.get());
    public static final DeferredBlock<DoorBlock> WAXED_WEATHERED_ZINC_DOOR = registerDoorBlock("waxed_weathered_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_WEATHERED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_weathered_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_weathered_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<Block> WAXED_CORRODED_ZINC = registerBlockVariant("waxed_corroded_zinc", () -> WAXED_ZINC_BLOCK.get(), MapColor.SNOW);
    public static final DeferredBlock<Block> WAXED_CORRODED_CUT_ZINC = registerBlockVariant("waxed_corroded_cut_zinc", () -> WAXED_CORRODED_ZINC.get());
    public static final DeferredBlock<SlabBlock> WAXED_CORRODED_CUT_ZINC_SLAB = registerSlabBlock("waxed_corroded_cut_zinc_slab", () -> WAXED_CORRODED_CUT_ZINC.get());
    public static final DeferredBlock<StairBlock> WAXED_CORRODED_CUT_ZINC_STAIRS = registerStairBlock("waxed_corroded_cut_zinc_stairs", () -> WAXED_WEATHERED_CUT_ZINC.get());
    public static final DeferredBlock<DoorBlock> WAXED_CORRODED_ZINC_DOOR = registerDoorBlock("waxed_corroded_zinc_door", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> WAXED_CORRODED_ZINC_TRAPDOOR = registerTrapdoorBlock("waxed_corroded_zinc_trapdoor", ModBlockSetTypes.ZINC, () -> WAXED_ZINC_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("waxed_corroded_barely_heavy_weighted_pressure_plate", 100, ModBlockSetTypes.ZINC, () -> WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

    public static final DeferredBlock<DropExperienceBlock> SILVER_ORE = registerOreBlock("silver_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILVER_ORE = registerDeepslateOreBlock("deepslate_silver_ore");
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlockVariant("raw_silver_block", () -> Blocks.RAW_GOLD_BLOCK, MapColor.METAL);

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlockVariant("silver_block", () -> Blocks.GOLD_BLOCK, MapColor.METAL);
    public static final DeferredBlock<Block> CUT_SILVER = registerBlockVariant("cut_silver", () -> SILVER_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_SILVER_SLAB = registerSlabBlock("cut_silver_slab", () -> CUT_SILVER.get());
    public static final DeferredBlock<StairBlock> CUT_SILVER_STAIRS = registerStairBlock("cut_silver_stairs", () -> CUT_SILVER.get());
    public static final DeferredBlock<DoorBlock> SILVER_DOOR = registerDoorBlock("silver_door", ModBlockSetTypes.SILVER, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> SILVER_TRAPDOOR = registerTrapdoorBlock("silver_trapdoor", ModBlockSetTypes.SILVER, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("noticeably_light_weighted_pressure_plate", 40, ModBlockSetTypes.SILVER, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> TIN_ORE = registerOreBlock("tin_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TIN_ORE = registerDeepslateOreBlock("deepslate_tin_ore");
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlockVariant("raw_tin_block", () -> Blocks.RAW_COPPER_BLOCK, MapColor.WOOD);

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlockVariant("tin_block", () -> Blocks.COPPER_BLOCK.weathering().unaffected(), MapColor.WOOD);
    public static final DeferredBlock<Block> CUT_TIN = registerBlockVariant("cut_tin", () -> TIN_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_TIN_SLAB = registerSlabBlock("cut_tin_slab", () -> CUT_TIN.get());
    public static final DeferredBlock<StairBlock> CUT_TIN_STAIRS = registerStairBlock("cut_tin_stairs", () -> CUT_TIN.get());
    public static final DeferredBlock<DoorBlock> TIN_DOOR = registerDoorBlock("tin_door", ModBlockSetTypes.TIN, () -> Blocks.COPPER_DOOR.weathering().unaffected());
    public static final DeferredBlock<TrapDoorBlock> TIN_TRAPDOOR = registerTrapdoorBlock("tin_trapdoor", ModBlockSetTypes.TIN, () -> Blocks.COPPER_TRAPDOOR.weathering().unaffected());
    public static final DeferredBlock<WeightedPressurePlateBlock> BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("barely_light_weighted_pressure_plate", 75, ModBlockSetTypes.TIN, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> TUNGSTEN_ORE = registerOreBlock("tungsten_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_TUNGSTEN_ORE = registerDeepslateOreBlock("deepslate_tungsten_ore");
    public static final DeferredBlock<Block> RAW_TUNGSTEN_BLOCK = registerBlockVariant("raw_tungsten_block", () -> Blocks.RAW_GOLD_BLOCK, MapColor.TERRACOTTA_LIGHT_BLUE);

    public static final DeferredBlock<Block> TUNGSTEN_BLOCK = registerBlockVariant("tungsten_block", () -> Blocks.NETHERITE_BLOCK, MapColor.TERRACOTTA_LIGHT_BLUE);
    public static final DeferredBlock<Block> CUT_TUNGSTEN = registerBlockVariant("cut_tungsten", () -> TUNGSTEN_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_TUNGSTEN_SLAB = registerSlabBlock("cut_tungsten_slab", () -> CUT_TUNGSTEN.get());
    public static final DeferredBlock<StairBlock> CUT_TUNGSTEN_STAIRS = registerStairBlock("cut_tungsten_stairs", () -> CUT_TUNGSTEN.get());
    public static final DeferredBlock<DoorBlock> TUNGSTEN_DOOR = registerDoorBlock("tungsten_door", ModBlockSetTypes.TUNGSTEN, () -> NETHERITE_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> TUNGSTEN_TRAPDOOR = registerTrapdoorBlock("tungsten_trapdoor", ModBlockSetTypes.TUNGSTEN, () -> NETHERITE_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("extraordinarily_heavy_weighted_pressure_plate", 1500, ModBlockSetTypes.TUNGSTEN, () -> PLAYER_ONLY_PRESSURE_PLATE.get());

    public static final DeferredBlock<DropExperienceBlock> PLATINUM_ORE = registerOreBlock("platinum_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_PLATINUM_ORE = registerDeepslateOreBlock("deepslate_platinum_ore");
    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = registerBlockVariant("raw_platinum_block", () -> Blocks.RAW_GOLD_BLOCK, MapColor.CLAY);

    public static final DeferredBlock<Block> PLATINUM_BLOCK = registerBlockVariant("platinum_block", () -> Blocks.GOLD_BLOCK, MapColor.CLAY);
    public static final DeferredBlock<Block> CUT_PLATINUM = registerBlockVariant("cut_platinum", () -> PLATINUM_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_PLATINUM_SLAB = registerSlabBlock("cut_platinum_slab", () -> CUT_PLATINUM.get());
    public static final DeferredBlock<StairBlock> CUT_PLATINUM_STAIRS = registerStairBlock("cut_platinum_stairs", () -> CUT_PLATINUM.get());
    public static final DeferredBlock<DoorBlock> PLATINUM_DOOR = registerDoorBlock("platinum_door", ModBlockSetTypes.PLATINUM, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> PLATINUM_TRAPDOOR = registerTrapdoorBlock("platinum_trapdoor", ModBlockSetTypes.PLATINUM, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("extraordinarily_light_weighted_pressure_plate", 2, ModBlockSetTypes.PLATINUM, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> LEAD_ORE = registerOreBlock("lead_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_LEAD_ORE = registerDeepslateOreBlock("deepslate_lead_ore");
    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = registerBlockVariant("raw_lead_block", () -> Blocks.RAW_COPPER_BLOCK, MapColor.COLOR_BLACK);

    public static final DeferredBlock<Block> LEAD_BLOCK = registerBlockVariant("lead_block", () -> Blocks.COPPER_BLOCK.weathering().unaffected(), MapColor.COLOR_BLACK);
    public static final DeferredBlock<Block> CUT_LEAD = registerBlockVariant("cut_lead", () -> LEAD_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_LEAD_SLAB = registerSlabBlock("cut_lead_slab", () -> CUT_LEAD.get());
    public static final DeferredBlock<StairBlock> CUT_LEAD_STAIRS = registerStairBlock("cut_lead_stairs", () -> CUT_LEAD.get());
    public static final DeferredBlock<DoorBlock> LEAD_DOOR = registerDoorBlock("lead_door", ModBlockSetTypes.LEAD, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> LEAD_TRAPDOOR = registerTrapdoorBlock("lead_trapdoor", ModBlockSetTypes.LEAD, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("noticeably_heavy_weighted_pressure_plate", 125, ModBlockSetTypes.LEAD, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<DropExperienceBlock> URANIUM_ORE = registerOreBlock("uranium_ore");
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_URANIUM_ORE = registerDeepslateOreBlock("deepslate_uranium_ore");
    public static final DeferredBlock<Block> RAW_URANIUM_BLOCK = registerBlockVariant("raw_uranium_block", () -> Blocks.RAW_GOLD_BLOCK, MapColor.COLOR_LIGHT_GREEN);

    public static final DeferredBlock<Block> URANIUM_BLOCK = registerBlockVariant("uranium_block", () -> Blocks.GOLD_BLOCK, MapColor.COLOR_LIGHT_GREEN);
    public static final DeferredBlock<Block> CUT_URANIUM = registerBlockVariant("cut_uranium", () -> URANIUM_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_URANIUM_SLAB = registerSlabBlock("cut_uranium_slab", () -> CUT_URANIUM.get());
    public static final DeferredBlock<StairBlock> CUT_URANIUM_STAIRS = registerStairBlock("cut_uranium_stairs", () -> CUT_URANIUM.get());
    public static final DeferredBlock<DoorBlock> URANIUM_DOOR = registerDoorBlock("uranium_door", ModBlockSetTypes.URANIUM, () -> GOLD_DOOR.get());
    public static final DeferredBlock<TrapDoorBlock> URANIUM_TRAPDOOR = registerTrapdoorBlock("uranium_trapdoor", ModBlockSetTypes.URANIUM, () -> GOLD_TRAPDOOR.get());
    public static final DeferredBlock<WeightedPressurePlateBlock> NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE = registerWeightedPressurePlate("negligible_weighted_pressure_plate", 1, ModBlockSetTypes.URANIUM, () -> Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    public static final DeferredBlock<Block> BRONZE_BLOCK = registerBlockVariant("bronze_block", () -> Blocks.COPPER_BLOCK.weathering().unaffected(), MapColor.PODZOL);
    public static final DeferredBlock<Block> CUT_BRONZE = registerBlockVariant("cut_bronze", () -> BRONZE_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_BRONZE_SLAB = registerSlabBlock("cut_bronze_slab", () -> CUT_BRONZE.get());
    public static final DeferredBlock<StairBlock> CUT_BRONZE_STAIRS = registerStairBlock("cut_bronze_stairs", () -> CUT_BRONZE.get());
    public static final DeferredBlock<DoorBlock> BRONZE_DOOR = registerDoorBlock("bronze_door", ModBlockSetTypes.BRONZE, () -> Blocks.COPPER_DOOR.weathering().unaffected());
    public static final DeferredBlock<TrapDoorBlock> BRONZE_TRAPDOOR = registerTrapdoorBlock("bronze_trapdoor", ModBlockSetTypes.BRONZE, () -> Blocks.COPPER_TRAPDOOR.weathering().unaffected());
    public static final DeferredBlock<AnimalOnlyPressurePlateBlock> PASSIVE_MOB_ONLY_PRESSURE_PLATE = registerAnimalPressurePlate("passive_mob_only_pressure_plate",  ModBlockSetTypes.BRONZE, () -> BRONZE_BLOCK.get());

    public static final DeferredBlock<Block> BRASS_BLOCK = registerBlockVariant("brass_block", () -> Blocks.COPPER_BLOCK.weathering().unaffected(), MapColor.WOOD);
    public static final DeferredBlock<Block> CUT_BRASS = registerBlockVariant("cut_brass", () -> BRASS_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_BRASS_SLAB = registerSlabBlock("cut_brass_slab", () -> CUT_BRASS.get());
    public static final DeferredBlock<StairBlock> CUT_BRASS_STAIRS = registerStairBlock("cut_brass_stairs", () -> CUT_BRASS.get());
    public static final DeferredBlock<DoorBlock> BRASS_DOOR = registerDoorBlock("brass_door", ModBlockSetTypes.BRASS, () -> Blocks.COPPER_DOOR.weathering().unaffected());
    public static final DeferredBlock<TrapDoorBlock> BRASS_TRAPDOOR = registerTrapdoorBlock("brass_trapdoor", ModBlockSetTypes.BRASS, () -> Blocks.COPPER_TRAPDOOR.weathering().unaffected());
    public static final DeferredBlock<MonsterOnlyPressurePlateBlock> HOSTILE_MOB_ONLY_PRESSURE_PLATE = registerMonsterPressurePlate("hostile_mob_only_pressure_plate",  ModBlockSetTypes.BRASS, () -> BRASS_BLOCK.get());

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlockVariant("steel_block", () -> Blocks.IRON_BLOCK, MapColor.COLOR_GRAY);
    public static final DeferredBlock<Block> CUT_STEEL = registerBlockVariant("cut_steel", () -> STEEL_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CUT_STEEL_SLAB = registerSlabBlock("cut_steel_slab", () -> CUT_STEEL.get());
    public static final DeferredBlock<StairBlock> CUT_STEEL_STAIRS = registerStairBlock("cut_steel_stairs", () -> CUT_STEEL.get());
    public static final DeferredBlock<DoorBlock> STEEL_DOOR = registerDoorBlock("steel_door", ModBlockSetTypes.STEEL, () -> Blocks.IRON_DOOR);
    public static final DeferredBlock<TrapDoorBlock> STEEL_TRAPDOOR = registerTrapdoorBlock("steel_trapdoor", ModBlockSetTypes.STEEL, () -> Blocks.IRON_TRAPDOOR);
    public static final DeferredBlock<NPCOnlyPressurePlateBlock> VILLAGER_ONLY_PRESSURE_PLATE = registerNPCPressurePlate("villager_only_pressure_plate",  ModBlockSetTypes.STEEL, () -> STEEL_BLOCK.get());

    public static final DeferredBlock<ModLiquidBlock> NUCLEAR_WASTE = registerLiquid("nuclear_waste", () -> ModFluids.NUCLEAR_WASTE.get());
    public static final DeferredBlock<NukeBlock> NUKE = registerNuke("nuke");

    public static final DeferredBlock<CraftingTableBlock> SPRUCE_CRAFTING_TABLE = registerCraftingTable("spruce_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> BIRCH_CRAFTING_TABLE = registerCraftingTable("birch_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> JUNGLE_CRAFTING_TABLE = registerCraftingTable("jungle_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> ACACIA_CRAFTING_TABLE = registerCraftingTable("acacia_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> DARK_OAK_CRAFTING_TABLE = registerCraftingTable("dark_oak_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> CRIMSON_CRAFTING_TABLE = registerCraftingTable("crimson_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> WARPED_CRAFTING_TABLE = registerCraftingTable("warped_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> MANGROVE_CRAFTING_TABLE = registerCraftingTable("mangrove_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> CHERRY_CRAFTING_TABLE = registerCraftingTable("cherry_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> BAMBOO_CRAFTING_TABLE = registerCraftingTable("bamboo_crafting_table");
    public static final DeferredBlock<CraftingTableBlock> PALE_OAK_CRAFTING_TABLE = registerCraftingTable("pale_oak_crafting_table");

    public static final DeferredBlock<CartographyTableBlock> OAK_CARTOGRAPHY_TABLE = registerCartographyTable("oak_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> SPRUCE_CARTOGRAPHY_TABLE = registerCartographyTable("spruce_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> BIRCH_CARTOGRAPHY_TABLE = registerCartographyTable("birch_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> JUNGLE_CARTOGRAPHY_TABLE = registerCartographyTable("jungle_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> ACACIA_CARTOGRAPHY_TABLE = registerCartographyTable("acacia_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> CRIMSON_CARTOGRAPHY_TABLE = registerCartographyTable("crimson_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> WARPED_CARTOGRAPHY_TABLE = registerCartographyTable("warped_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> MANGROVE_CARTOGRAPHY_TABLE = registerCartographyTable("mangrove_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> CHERRY_CARTOGRAPHY_TABLE = registerCartographyTable("cherry_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> BAMBOO_CARTOGRAPHY_TABLE = registerCartographyTable("bamboo_cartography_table");
    public static final DeferredBlock<CartographyTableBlock> PALE_OAK_CARTOGRAPHY_TABLE = registerCartographyTable("pale_oak_cartography_table");

    public static final DeferredBlock<FletchingTableBlock> OAK_FLETCHING_TABLE = registerFletchingTable("oak_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> SPRUCE_FLETCHING_TABLE = registerFletchingTable("spruce_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> BIRCH_FLETCHING_TABLE = registerFletchingTable("birch_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> JUNGLE_FLETCHING_TABLE = registerFletchingTable("jungle_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> ACACIA_FLETCHING_TABLE = registerFletchingTable("acacia_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> DARK_OAK_FLETCHING_TABLE = registerFletchingTable("dark_oak_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> CRIMSON_FLETCHING_TABLE = registerFletchingTable("crimson_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> WARPED_FLETCHING_TABLE = registerFletchingTable("warped_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> MANGROVE_FLETCHING_TABLE = registerFletchingTable("mangrove_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> CHERRY_FLETCHING_TABLE = registerFletchingTable("cherry_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> BAMBOO_FLETCHING_TABLE = registerFletchingTable("bamboo_fletching_table");
    public static final DeferredBlock<FletchingTableBlock> PALE_OAK_FLETCHING_TABLE = registerFletchingTable("pale_oak_fletching_table");

    public static final DeferredBlock<SmithingTableBlock> OAK_SMITHING_TABLE = registerSmithingTable("oak_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> SPRUCE_SMITHING_TABLE = registerSmithingTable("spruce_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> BIRCH_SMITHING_TABLE = registerSmithingTable("birch_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> JUNGLE_SMITHING_TABLE = registerSmithingTable("jungle_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> ACACIA_SMITHING_TABLE = registerSmithingTable("acacia_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> DARK_OAK_SMITHING_TABLE = registerSmithingTable("dark_oak_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> CRIMSON_SMITHING_TABLE = registerSmithingTable("crimson_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> WARPED_SMITHING_TABLE = registerSmithingTable("warped_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> CHERRY_SMITHING_TABLE = registerSmithingTable("cherry_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> BAMBOO_SMITHING_TABLE = registerSmithingTable("bamboo_smithing_table");
    public static final DeferredBlock<SmithingTableBlock> PALE_OAK_SMITHING_TABLE = registerSmithingTable("pale_oak_smithing_table");

    public static final DeferredBlock<GrindstoneBlock> OAK_GRINDSTONE = registerGrindstone("oak_grindstone");
    public static final DeferredBlock<GrindstoneBlock> SPRUCE_GRINDSTONE = registerGrindstone("spruce_grindstone");
    public static final DeferredBlock<GrindstoneBlock> BIRCH_GRINDSTONE = registerGrindstone("birch_grindstone");
    public static final DeferredBlock<GrindstoneBlock> JUNGLE_GRINDSTONE = registerGrindstone("jungle_grindstone");
    public static final DeferredBlock<GrindstoneBlock> ACACIA_GRINDSTONE = registerGrindstone("acacia_grindstone");
    public static final DeferredBlock<GrindstoneBlock> CRIMSON_GRINDSTONE = registerGrindstone("crimson_grindstone");
    public static final DeferredBlock<GrindstoneBlock> WARPED_GRINDSTONE = registerGrindstone("warped_grindstone");
    public static final DeferredBlock<GrindstoneBlock> MANGROVE_GRINDSTONE = registerGrindstone("mangrove_grindstone");
    public static final DeferredBlock<GrindstoneBlock> CHERRY_GRINDSTONE = registerGrindstone("cherry_grindstone");
    public static final DeferredBlock<GrindstoneBlock> BAMBOO_GRINDSTONE = registerGrindstone("bamboo_grindstone");
    public static final DeferredBlock<GrindstoneBlock> PALE_OAK_GRINDSTONE = registerGrindstone("pale_oak_grindstone");

    public static final DeferredBlock<LoomBlock> SPRUCE_LOOM = registerLoom("spruce_loom");
    public static final DeferredBlock<LoomBlock> BIRCH_LOOM = registerLoom("birch_loom");
    public static final DeferredBlock<LoomBlock> JUNGLE_LOOM = registerLoom("jungle_loom");
    public static final DeferredBlock<LoomBlock> ACACIA_LOOM = registerLoom("acacia_loom");
    public static final DeferredBlock<LoomBlock> DARK_OAK_LOOM = registerLoom("dark_oak_loom");
    public static final DeferredBlock<LoomBlock> CRIMSON_LOOM = registerLoom("crimson_loom");
    public static final DeferredBlock<LoomBlock> WARPED_LOOM = registerLoom("warped_loom");
    public static final DeferredBlock<LoomBlock> MANGROVE_LOOM = registerLoom("mangrove_loom");
    public static final DeferredBlock<LoomBlock> CHERRY_LOOM = registerLoom("cherry_loom");
    public static final DeferredBlock<LoomBlock> BAMBOO_LOOM = registerLoom("bamboo_loom");
    public static final DeferredBlock<LoomBlock> PALE_OAK_LOOM = registerLoom("pale_oak_loom");

    public static final DeferredBlock<FurnaceBlock> BLACKSTONE_FURNACE = registerFurnace("blackstone_furnace");
    public static final DeferredBlock<FurnaceBlock> DEEPSLATE_FURNACE = registerFurnace("deepslate_furnace");

    public static final DeferredBlock<SmokerBlock> SPRUCE_STONE_SMOKER = registerSmoker("spruce_stone_smoker");
    public static final DeferredBlock<SmokerBlock> BIRCH_STONE_SMOKER = registerSmoker("birch_stone_smoker");
    public static final DeferredBlock<SmokerBlock> JUNGLE_STONE_SMOKER = registerSmoker("jungle_stone_smoker");
    public static final DeferredBlock<SmokerBlock> ACACIA_STONE_SMOKER = registerSmoker("acacia_stone_smoker");
    public static final DeferredBlock<SmokerBlock> DARK_OAK_STONE_SMOKER = registerSmoker("dark_oak_stone_smoker");
    public static final DeferredBlock<SmokerBlock> CRIMSON_STONE_SMOKER = registerSmoker("crimson_stone_smoker");
    public static final DeferredBlock<SmokerBlock> WARPED_STONE_SMOKER = registerSmoker("warped_stone_smoker");
    public static final DeferredBlock<SmokerBlock> MANGROVE_STONE_SMOKER = registerSmoker("mangrove_stone_smoker");
    public static final DeferredBlock<SmokerBlock> CHERRY_STONE_SMOKER = registerSmoker("cherry_stone_smoker");
    public static final DeferredBlock<SmokerBlock> BAMBOO_STONE_SMOKER = registerSmoker("bamboo_stone_smoker");
    public static final DeferredBlock<SmokerBlock> PALE_OAK_STONE_SMOKER = registerSmoker("pale_oak_stone_smoker");

    public static final DeferredBlock<SmokerBlock> OAK_BLACKSTONE_SMOKER = registerSmoker("oak_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> SPRUCE_BLACKSTONE_SMOKER = registerSmoker("spruce_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> BIRCH_BLACKSTONE_SMOKER = registerSmoker("birch_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> JUNGLE_BLACKSTONE_SMOKER = registerSmoker("jungle_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> ACACIA_BLACKSTONE_SMOKER = registerSmoker("acacia_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> DARK_OAK_BLACKSTONE_SMOKER = registerSmoker("dark_oak_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> CRIMSON_BLACKSTONE_SMOKER = registerSmoker("crimson_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> WARPED_BLACKSTONE_SMOKER = registerSmoker("warped_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> MANGROVE_BLACKSTONE_SMOKER = registerSmoker("mangrove_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> CHERRY_BLACKSTONE_SMOKER = registerSmoker("cherry_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> BAMBOO_BLACKSTONE_SMOKER = registerSmoker("bamboo_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> PALE_OAK_BLACKSTONE_SMOKER = registerSmoker("pale_oak_blackstone_smoker");

    public static final DeferredBlock<SmokerBlock> OAK_DEEPSLATE_SMOKER = registerSmoker("oak_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> SPRUCE_DEEPSLATE_SMOKER = registerSmoker("spruce_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> BIRCH_DEEPSLATE_SMOKER = registerSmoker("birch_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> JUNGLE_DEEPSLATE_SMOKER = registerSmoker("jungle_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> ACACIA_DEEPSLATE_SMOKER = registerSmoker("acacia_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> DARK_OAK_DEEPSLATE_SMOKER = registerSmoker("dark_oak_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> CRIMSON_DEEPSLATE_SMOKER = registerSmoker("crimson_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> WARPED_DEEPSLATE_SMOKER = registerSmoker("warped_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> MANGROVE_DEEPSLATE_SMOKER = registerSmoker("mangrove_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> CHERRY_DEEPSLATE_SMOKER = registerSmoker("cherry_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> BAMBOO_DEEPSLATE_SMOKER = registerSmoker("bamboo_deepslate_smoker");
    public static final DeferredBlock<SmokerBlock> PALE_OAK_DEEPSLATE_SMOKER = registerSmoker("pale_oak_deepslate_smoker");

    public static final DeferredBlock<BlastFurnaceBlock> BLACKSTONE_BLAST_FURNACE = registerBlastFurnace("blackstone_blast_furnace");
    public static final DeferredBlock<BlastFurnaceBlock> DEEPSLATE_BLAST_FURNACE = registerBlastFurnace("deepslate_blast_furnace");

    public static final DeferredBlock<CampfireBlock> SPRUCE_CAMPFIRE = registerCampfire("spruce_campfire");
    public static final DeferredBlock<CampfireBlock> BIRCH_CAMPFIRE = registerCampfire("birch_campfire");
    public static final DeferredBlock<CampfireBlock> JUNGLE_CAMPFIRE = registerCampfire("jungle_campfire");
    public static final DeferredBlock<CampfireBlock> ACACIA_CAMPFIRE = registerCampfire("acacia_campfire");
    public static final DeferredBlock<CampfireBlock> DARK_OAK_CAMPFIRE = registerCampfire("dark_oak_campfire");
    public static final DeferredBlock<CampfireBlock> CRIMSON_CAMPFIRE = registerCampfire("crimson_campfire");
    public static final DeferredBlock<CampfireBlock> WARPED_CAMPFIRE = registerCampfire("warped_campfire");
    public static final DeferredBlock<CampfireBlock> MANGROVE_CAMPFIRE = registerCampfire("mangrove_campfire");
    public static final DeferredBlock<CampfireBlock> CHERRY_CAMPFIRE = registerCampfire("cherry_campfire");
    public static final DeferredBlock<CampfireBlock> BAMBOO_CAMPFIRE = registerCampfire("bamboo_campfire");
    public static final DeferredBlock<CampfireBlock> PALE_OAK_CAMPFIRE = registerCampfire("pale_oak_campfire");

    public static final DeferredBlock<CampfireBlock> SPRUCE_SOUL_CAMPFIRE = registerSoulCampfire("spruce_soul_campfire");
    public static final DeferredBlock<CampfireBlock> BIRCH_SOUL_CAMPFIRE = registerSoulCampfire("birch_soul_campfire");
    public static final DeferredBlock<CampfireBlock> JUNGLE_SOUL_CAMPFIRE = registerSoulCampfire("jungle_soul_campfire");
    public static final DeferredBlock<CampfireBlock> ACACIA_SOUL_CAMPFIRE = registerSoulCampfire("acacia_soul_campfire");
    public static final DeferredBlock<CampfireBlock> DARK_OAK_SOUL_CAMPFIRE = registerSoulCampfire("dark_oak_soul_campfire");
    public static final DeferredBlock<CampfireBlock> CRIMSON_SOUL_CAMPFIRE = registerSoulCampfire("crimson_soul_campfire");
    public static final DeferredBlock<CampfireBlock> WARPED_SOUL_CAMPFIRE = registerSoulCampfire("warped_soul_campfire");
    public static final DeferredBlock<CampfireBlock> MANGROVE_SOUL_CAMPFIRE = registerSoulCampfire("mangrove_soul_campfire");
    public static final DeferredBlock<CampfireBlock> CHERRY_SOUL_CAMPFIRE = registerSoulCampfire("cherry_soul_campfire");
    public static final DeferredBlock<CampfireBlock> BAMBOO_SOUL_CAMPFIRE = registerSoulCampfire("bamboo_soul_campfire");
    public static final DeferredBlock<CampfireBlock> PALE_OAK_SOUL_CAMPFIRE = registerSoulCampfire("pale_oak_soul_campfire");

    public static final DeferredBlock<BeehiveBlock> SPRUCE_BEEHIVE = registerBeehive("spruce_beehive");
    public static final DeferredBlock<BeehiveBlock> BIRCH_BEEHIVE = registerBeehive("birch_beehive");
    public static final DeferredBlock<BeehiveBlock> JUNGLE_BEEHIVE = registerBeehive("jungle_beehive");
    public static final DeferredBlock<BeehiveBlock> ACACIA_BEEHIVE = registerBeehive("acacia_beehive");
    public static final DeferredBlock<BeehiveBlock> DARK_OAK_BEEHIVE = registerBeehive("dark_oak_beehive");
    public static final DeferredBlock<BeehiveBlock> CRIMSON_BEEHIVE = registerBeehive("crimson_beehive");
    public static final DeferredBlock<BeehiveBlock> WARPED_BEEHIVE = registerBeehive("warped_beehive");
    public static final DeferredBlock<BeehiveBlock> MANGROVE_BEEHIVE = registerBeehive("mangrove_beehive");
    public static final DeferredBlock<BeehiveBlock> CHERRY_BEEHIVE = registerBeehive("cherry_beehive");
    public static final DeferredBlock<BeehiveBlock> BAMBOO_BEEHIVE = registerBeehive("bamboo_beehive");
    public static final DeferredBlock<BeehiveBlock> PALE_OAK_BEEHIVE = registerBeehive("pale_oak_beehive");

    public static final DeferredBlock<Block> SPRUCE_BOOKSHELF = registerBookshelf("spruce_bookshelf");
    public static final DeferredBlock<Block> BIRCH_BOOKSHELF = registerBookshelf("birch_bookshelf");
    public static final DeferredBlock<Block> JUNGLE_BOOKSHELF = registerBookshelf("jungle_bookshelf");
    public static final DeferredBlock<Block> ACACIA_BOOKSHELF = registerBookshelf("acacia_bookshelf");
    public static final DeferredBlock<Block> DARK_OAK_BOOKSHELF = registerBookshelf("dark_oak_bookshelf");
    public static final DeferredBlock<Block> CRIMSON_BOOKSHELF = registerBookshelf("crimson_bookshelf");
    public static final DeferredBlock<Block> WARPED_BOOKSHELF = registerBookshelf("warped_bookshelf");
    public static final DeferredBlock<Block> MANGROVE_BOOKSHELF = registerBookshelf("mangrove_bookshelf");
    public static final DeferredBlock<Block> CHERRY_BOOKSHELF = registerBookshelf("cherry_bookshelf");
    public static final DeferredBlock<Block> BAMBOO_BOOKSHELF = registerBookshelf("bamboo_bookshelf");
    public static final DeferredBlock<Block> PALE_OAK_BOOKSHELF = registerBookshelf("pale_oak_bookshelf");

    public static final DeferredBlock<ChiseledBookShelfBlock> SPRUCE_CHISELED_BOOKSHELF = registerChiseledBookshelf("spruce_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> BIRCH_CHISELED_BOOKSHELF = registerChiseledBookshelf("birch_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> JUNGLE_CHISELED_BOOKSHELF = registerChiseledBookshelf("jungle_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> ACACIA_CHISELED_BOOKSHELF = registerChiseledBookshelf("acacia_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> DARK_OAK_CHISELED_BOOKSHELF = registerChiseledBookshelf("dark_oak_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> CRIMSON_CHISELED_BOOKSHELF = registerChiseledBookshelf("crimson_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> WARPED_CHISELED_BOOKSHELF = registerChiseledBookshelf("warped_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> MANGROVE_CHISELED_BOOKSHELF = registerChiseledBookshelf("mangrove_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> CHERRY_CHISELED_BOOKSHELF = registerChiseledBookshelf("cherry_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> BAMBOO_CHISELED_BOOKSHELF = registerChiseledBookshelf("bamboo_chiseled_bookshelf");
    public static final DeferredBlock<ChiseledBookShelfBlock> PALE_OAK_CHISELED_BOOKSHELF = registerChiseledBookshelf("pale_oak_chiseled_bookshelf");

    public static final DeferredBlock<LecternBlock> SPRUCE_LECTERN = registerLectern("spruce_lectern");
    public static final DeferredBlock<LecternBlock> BIRCH_LECTERN = registerLectern("birch_lectern");
    public static final DeferredBlock<LecternBlock> JUNGLE_LECTERN = registerLectern("jungle_lectern");
    public static final DeferredBlock<LecternBlock> ACACIA_LECTERN = registerLectern("acacia_lectern");
    public static final DeferredBlock<LecternBlock> DARK_OAK_LECTERN = registerLectern("dark_oak_lectern");
    public static final DeferredBlock<LecternBlock> CRIMSON_LECTERN = registerLectern("crimson_lectern");
    public static final DeferredBlock<LecternBlock> WARPED_LECTERN = registerLectern("warped_lectern");
    public static final DeferredBlock<LecternBlock> MANGROVE_LECTERN = registerLectern("mangrove_lectern");
    public static final DeferredBlock<LecternBlock> CHERRY_LECTERN = registerLectern("cherry_lectern");
    public static final DeferredBlock<LecternBlock> BAMBOO_LECTERN = registerLectern("bamboo_lectern");
    public static final DeferredBlock<LecternBlock> PALE_OAK_LECTERN = registerLectern("pale_oak_lectern");

    public static final DeferredBlock<BrewingStandBlock> BLACKSTONE_BREWING_STAND = registerBrewingStand("blackstone_brewing_stand");
    public static final DeferredBlock<BrewingStandBlock> DEEPSLATE_BREWING_STAND = registerBrewingStand("deepslate_brewing_stand");

    public static final DeferredBlock<BarrelBlock> OAK_BARREL = registerBarrel("oak_barrel");
    public static final DeferredBlock<BarrelBlock> BIRCH_BARREL = registerBarrel("birch_barrel");
    public static final DeferredBlock<BarrelBlock> JUNGLE_BARREL = registerBarrel("jungle_barrel");
    public static final DeferredBlock<BarrelBlock> ACACIA_BARREL = registerBarrel("acacia_barrel");
    public static final DeferredBlock<BarrelBlock> DARK_OAK_BARREL = registerBarrel("dark_oak_barrel");
    public static final DeferredBlock<BarrelBlock> CRIMSON_BARREL = registerBarrel("crimson_barrel");
    public static final DeferredBlock<BarrelBlock> WARPED_BARREL = registerBarrel("warped_barrel");
    public static final DeferredBlock<BarrelBlock> MANGROVE_BARREL = registerBarrel("mangrove_barrel");
    public static final DeferredBlock<BarrelBlock> CHERRY_BARREL = registerBarrel("cherry_barrel");
    public static final DeferredBlock<BarrelBlock> BAMBOO_BARREL = registerBarrel("bamboo_barrel");
    public static final DeferredBlock<BarrelBlock> PALE_OAK_BARREL = registerBarrel("pale_oak_barrel");

    public static final DeferredBlock<DispenserBlock> BLACKSTONE_DISPENSER = registerDispenser("blackstone_dispenser");
    public static final DeferredBlock<DispenserBlock> DEEPSLATE_DISPENSER = registerDispenser("deepslate_dispenser");

    public static final DeferredBlock<DropperBlock> BLACKSTONE_DROPPER = registerDropper("blackstone_dropper");
    public static final DeferredBlock<DropperBlock> DEEPSLATE_DROPPER = registerDropper("deepslate_dropper");

    public static final DeferredBlock<ObserverBlock> BLACKSTONE_OBSERVER = registerObserver("blackstone_observer");
    public static final DeferredBlock<ObserverBlock> DEEPSLATE_OBSERVER = registerObserver("deepslate_observer");

    public static final DeferredBlock<CrafterBlock> SPRUCE_CRAFTER = registerCrafter("spruce_crafter");
    public static final DeferredBlock<CrafterBlock> BIRCH_CRAFTER = registerCrafter("birch_crafter");
    public static final DeferredBlock<CrafterBlock> JUNGLE_CRAFTER = registerCrafter("jungle_crafter");
    public static final DeferredBlock<CrafterBlock> ACACIA_CRAFTER = registerCrafter("acacia_crafter");
    public static final DeferredBlock<CrafterBlock> DARK_OAK_CRAFTER = registerCrafter("dark_oak_crafter");
    public static final DeferredBlock<CrafterBlock> CRIMSON_CRAFTER = registerCrafter("crimson_crafter");
    public static final DeferredBlock<CrafterBlock> WARPED_CRAFTER = registerCrafter("warped_crafter");
    public static final DeferredBlock<CrafterBlock> MANGROVE_CRAFTER = registerCrafter("mangrove_crafter");
    public static final DeferredBlock<CrafterBlock> CHERRY_CRAFTER = registerCrafter("cherry_crafter");
    public static final DeferredBlock<CrafterBlock> BAMBOO_CRAFTER = registerCrafter("bamboo_crafter");
    public static final DeferredBlock<CrafterBlock> PALE_OAK_CRAFTER = registerCrafter("pale_oak_crafter");

    public static final DeferredBlock<ChestBlock> SPRUCE_CHEST = registerWoodenChest("spruce_chest");
    public static final DeferredBlock<ChestBlock> BIRCH_CHEST = registerWoodenChest("birch_chest");
    public static final DeferredBlock<ChestBlock> JUNGLE_CHEST = registerWoodenChest("jungle_chest");
    public static final DeferredBlock<ChestBlock> ACACIA_CHEST = registerWoodenChest("acacia_chest");
    public static final DeferredBlock<ChestBlock> DARK_OAK_CHEST = registerWoodenChest("dark_oak_chest");
    public static final DeferredBlock<ChestBlock> CRIMSON_CHEST = registerWoodenChest("crimson_chest");
    public static final DeferredBlock<ChestBlock> WARPED_CHEST = registerWoodenChest("warped_chest");
    public static final DeferredBlock<ChestBlock> MANGROVE_CHEST = registerWoodenChest("mangrove_chest");
    public static final DeferredBlock<ChestBlock> CHERRY_CHEST = registerWoodenChest("cherry_chest");
    public static final DeferredBlock<ChestBlock> BAMBOO_CHEST = registerWoodenChest("bamboo_chest");
    public static final DeferredBlock<ChestBlock> PALE_OAK_CHEST = registerWoodenChest("pale_oak_chest");

    public static final DeferredBlock<TrappedChestBlock> SPRUCE_TRAPPED_CHEST = registerTrappedChest("spruce_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> BIRCH_TRAPPED_CHEST = registerTrappedChest("birch_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> JUNGLE_TRAPPED_CHEST = registerTrappedChest("jungle_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> ACACIA_TRAPPED_CHEST = registerTrappedChest("acacia_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> DARK_OAK_TRAPPED_CHEST = registerTrappedChest("dark_oak_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> CRIMSON_TRAPPED_CHEST = registerTrappedChest("crimson_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> WARPED_TRAPPED_CHEST = registerTrappedChest("warped_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> MANGROVE_TRAPPED_CHEST = registerTrappedChest("mangrove_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> CHERRY_TRAPPED_CHEST = registerTrappedChest("cherry_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> BAMBOO_TRAPPED_CHEST = registerTrappedChest("bamboo_trapped_chest");
    public static final DeferredBlock<TrappedChestBlock> PALE_OAK_TRAPPED_CHEST = registerTrappedChest("pale_oak_trapped_chest");

    public static final DeferredBlock<Block> OAK_MOSAIC = registerBlockVariant("oak_mosaic", () -> Blocks.OAK_PLANKS);
    public static final DeferredBlock<SlabBlock> OAK_MOSAIC_SLAB = registerSlabBlock("oak_mosaic_slab", () -> OAK_MOSAIC.get());
    public static final DeferredBlock<StairBlock> OAK_MOSAIC_STAIRS = registerStairBlock("oak_mosaic_stairs", () -> OAK_MOSAIC.get());

    public static final DeferredBlock<Block> SPRUCE_MOSAIC = registerBlockVariant("spruce_mosaic", () -> Blocks.SPRUCE_PLANKS);
    public static final DeferredBlock<SlabBlock> SPRUCE_MOSAIC_SLAB = registerSlabBlock("spruce_mosaic_slab", () -> SPRUCE_MOSAIC.get());
    public static final DeferredBlock<StairBlock> SPRUCE_MOSAIC_STAIRS = registerStairBlock("spruce_mosaic_stairs", () -> SPRUCE_MOSAIC.get());

    public static final DeferredBlock<Block> BIRCH_MOSAIC = registerBlockVariant("birch_mosaic", () -> Blocks.BIRCH_PLANKS);
    public static final DeferredBlock<SlabBlock> BIRCH_MOSAIC_SLAB = registerSlabBlock("birch_mosaic_slab", () -> BIRCH_MOSAIC.get());
    public static final DeferredBlock<StairBlock> BIRCH_MOSAIC_STAIRS = registerStairBlock("birch_mosaic_stairs", () -> BIRCH_MOSAIC.get());

    public static final DeferredBlock<Block> JUNGLE_MOSAIC = registerBlockVariant("jungle_mosaic", () -> Blocks.JUNGLE_PLANKS);
    public static final DeferredBlock<SlabBlock> JUNGLE_MOSAIC_SLAB = registerSlabBlock("jungle_mosaic_slab", () -> JUNGLE_MOSAIC.get());
    public static final DeferredBlock<StairBlock> JUNGLE_MOSAIC_STAIRS = registerStairBlock("jungle_mosaic_stairs", () -> JUNGLE_MOSAIC.get());

    public static final DeferredBlock<Block> ACACIA_MOSAIC = registerBlockVariant("acacia_mosaic", () -> Blocks.ACACIA_PLANKS);
    public static final DeferredBlock<SlabBlock> ACACIA_MOSAIC_SLAB = registerSlabBlock("acacia_mosaic_slab", () -> ACACIA_MOSAIC.get());
    public static final DeferredBlock<StairBlock> ACACIA_MOSAIC_STAIRS = registerStairBlock("acacia_mosaic_stairs", () -> ACACIA_MOSAIC.get());

    public static final DeferredBlock<Block> DARK_OAK_MOSAIC = registerBlockVariant("dark_oak_mosaic", () -> Blocks.DARK_OAK_PLANKS);
    public static final DeferredBlock<SlabBlock> DARK_OAK_MOSAIC_SLAB = registerSlabBlock("dark_oak_mosaic_slab", () -> DARK_OAK_MOSAIC.get());
    public static final DeferredBlock<StairBlock> DARK_OAK_MOSAIC_STAIRS = registerStairBlock("dark_oak_mosaic_stairs", () -> DARK_OAK_MOSAIC.get());

    public static final DeferredBlock<Block> CRIMSON_MOSAIC = registerBlockVariant("crimson_mosaic", () -> Blocks.CRIMSON_PLANKS);
    public static final DeferredBlock<SlabBlock> CRIMSON_MOSAIC_SLAB = registerSlabBlock("crimson_mosaic_slab", () -> CRIMSON_MOSAIC.get());
    public static final DeferredBlock<StairBlock> CRIMSON_MOSAIC_STAIRS = registerStairBlock("crimson_mosaic_stairs", () -> CRIMSON_MOSAIC.get());

    public static final DeferredBlock<Block> WARPED_MOSAIC = registerBlockVariant("warped_mosaic", () -> Blocks.WARPED_PLANKS);
    public static final DeferredBlock<SlabBlock> WARPED_MOSAIC_SLAB = registerSlabBlock("warped_mosaic_slab", () -> WARPED_MOSAIC.get());
    public static final DeferredBlock<StairBlock> WARPED_MOSAIC_STAIRS = registerStairBlock("warped_mosaic_stairs", () -> WARPED_MOSAIC.get());

    public static final DeferredBlock<Block> MANGROVE_MOSAIC = registerBlockVariant("mangrove_mosaic", () -> Blocks.MANGROVE_PLANKS);
    public static final DeferredBlock<SlabBlock> MANGROVE_MOSAIC_SLAB = registerSlabBlock("mangrove_mosaic_slab", () -> MANGROVE_MOSAIC.get());
    public static final DeferredBlock<StairBlock> MANGROVE_MOSAIC_STAIRS = registerStairBlock("mangrove_mosaic_stairs", () -> MANGROVE_MOSAIC.get());

    public static final DeferredBlock<Block> CHERRY_MOSAIC = registerBlockVariant("cherry_mosaic", () -> Blocks.CHERRY_PLANKS);
    public static final DeferredBlock<SlabBlock> CHERRY_MOSAIC_SLAB = registerSlabBlock("cherry_mosaic_slab", () -> CHERRY_MOSAIC.get());
    public static final DeferredBlock<StairBlock> CHERRY_MOSAIC_STAIRS = registerStairBlock("cherry_mosaic_stairs", () -> CHERRY_MOSAIC.get());

    public static final DeferredBlock<Block> PALE_OAK_MOSAIC = registerBlockVariant("pale_oak_mosaic", () -> Blocks.PALE_OAK_PLANKS);
    public static final DeferredBlock<SlabBlock> PALE_OAK_MOSAIC_SLAB = registerSlabBlock("pale_oak_mosaic_slab", () -> PALE_OAK_MOSAIC.get());
    public static final DeferredBlock<StairBlock> PALE_OAK_MOSAIC_STAIRS = registerStairBlock("pale_oak_mosaic_stairs", () -> PALE_OAK_MOSAIC.get());

    public static final DeferredBlock<SlabBlock> OBSIDIAN_SLAB = registerSlabBlock("obsidian_slab", () -> Blocks.OBSIDIAN);
    public static final DeferredBlock<StairBlock> OBSIDIAN_STAIRS = registerStairBlock("obsidian_stairs", () -> Blocks.OBSIDIAN);
    public static final DeferredBlock<WallBlock> OBSIDIAN_WALL = registerWallBlock("obsidian_wall", () -> Blocks.OBSIDIAN);

    public static final DeferredBlock<CryingObsidianSlabBlock> CRYING_OBSIDIAN_SLAB = registerCOSlabBlock("crying_obsidian_slab", () -> Blocks.CRYING_OBSIDIAN);
    public static final DeferredBlock<CryingObsidianStairBlock> CRYING_OBSIDIAN_STAIRS = registerCOStairBlock("crying_obsidian_stairs", () -> Blocks.CRYING_OBSIDIAN);
    public static final DeferredBlock<CryingObsidianWallBlock> CRYING_OBSIDIAN_WALL = registerCOWallBlock("crying_obsidian_wall", () -> Blocks.CRYING_OBSIDIAN);

    public static final DeferredBlock<SlabBlock> COAL_SLAB = registerSlabBlock("coal_slab", () -> Blocks.COAL_BLOCK);
    public static final DeferredBlock<StairBlock> COAL_STAIRS = registerStairBlock("coal_stairs", () -> Blocks.COAL_BLOCK);
    public static final DeferredBlock<WallBlock> COAL_WALL = registerWallBlock("coal_wall", () -> Blocks.COAL_BLOCK);

    public static final DeferredBlock<SlabBlock> CHARCOAL_SLAB = registerSlabBlock("charcoal_slab", () -> CHARCOAL_BLOCK.get());
    public static final DeferredBlock<StairBlock> CHARCOAL_STAIRS = registerStairBlock("charcoal_stairs", () -> CHARCOAL_BLOCK.get());
    public static final DeferredBlock<WallBlock> CHARCOAL_WALL = registerWallBlock("charcoal_wall", () -> CHARCOAL_BLOCK.get());

    public static final DeferredBlock<SlabBlock> LAPIS_SLAB = registerSlabBlock("lapis_slab", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<StairBlock> LAPIS_STAIRS = registerStairBlock("lapis_stairs", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<WallBlock> LAPIS_WALL = registerWallBlock("lapis_wall", () -> Blocks.LAPIS_BLOCK);

    public static final DeferredBlock<SlabBlock> SNOW_SLAB = registerSlabBlock("snow_slab", () -> Blocks.SNOW_BLOCK);
    public static final DeferredBlock<StairBlock> SNOW_STAIRS = registerStairBlock("snow_stairs", () -> Blocks.SNOW_BLOCK);
    public static final DeferredBlock<WallBlock> SNOW_WALL = registerWallBlock("snow_wall", () -> Blocks.SNOW_BLOCK);

    public static final DeferredBlock<IceSlabBlock> ICE_SLAB = registerIceSlabBlock("ice_slab", () -> Blocks.ICE);
    public static final DeferredBlock<IceStairBlock> ICE_STAIRS = registerIceStairBlock("ice_stairs", () -> Blocks.ICE);
    public static final DeferredBlock<IceWallBlock> ICE_WALL = registerIceWallBlock("ice_wall", () -> Blocks.ICE);

    public static final DeferredBlock<SlabBlock> PACKED_ICE_SLAB = registerSlabBlock("packed_ice_slab", () -> Blocks.PACKED_ICE);
    public static final DeferredBlock<StairBlock> PACKED_ICE_STAIRS = registerStairBlock("packed_ice_stairs", () -> Blocks.PACKED_ICE);
    public static final DeferredBlock<WallBlock> PACKED_ICE_WALL = registerWallBlock("packed_ice_wall", () -> Blocks.PACKED_ICE);

    public static final DeferredBlock<SlabBlock> BLUE_ICE_SLAB = registerSlabBlock("blue_ice_slab", () -> Blocks.BLUE_ICE);
    public static final DeferredBlock<StairBlock> BLUE_ICE_STAIRS = registerStairBlock("blue_ice_stairs", () -> Blocks.BLUE_ICE);
    public static final DeferredBlock<WallBlock> BLUE_ICE_WALL = registerWallBlock("blue_ice_wall", () -> Blocks.BLUE_ICE);

    public static final DeferredBlock<SlabBlock> TERRACOTTA_SLAB = registerSlabBlock("terracotta_slab", () -> Blocks.TERRACOTTA);
    public static final DeferredBlock<StairBlock> TERRACOTTA_STAIRS = registerStairBlock("terracotta_stairs", () -> Blocks.TERRACOTTA);
    public static final DeferredBlock<WallBlock> TERRACOTTA_WALL = registerWallBlock("terracotta_wall", () -> Blocks.TERRACOTTA);

    public static final DeferredBlock<SlabBlock> SCULK_SLAB = registerSlabBlock("sculk_slab", () -> Blocks.SCULK);
    public static final DeferredBlock<StairBlock> SCULK_STAIRS = registerStairBlock("sculk_stairs", () -> Blocks.SCULK);
    public static final DeferredBlock<WallBlock> SCULK_WALL = registerWallBlock("sculk_wall", () -> Blocks.SCULK);

    public static final DeferredBlock<SlabBlock> WHITE_TERRACOTTA_SLAB = registerSlabBlock("white_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.white());
    public static final DeferredBlock<StairBlock> WHITE_TERRACOTTA_STAIRS = registerStairBlock("white_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.white());
    public static final DeferredBlock<WallBlock> WHITE_TERRACOTTA_WALL = registerWallBlock("white_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.white());
    public static final DeferredBlock<SlabBlock> ORANGE_TERRACOTTA_SLAB = registerSlabBlock("orange_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.orange());
    public static final DeferredBlock<StairBlock> ORANGE_TERRACOTTA_STAIRS = registerStairBlock("orange_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.orange());
    public static final DeferredBlock<WallBlock> ORANGE_TERRACOTTA_WALL = registerWallBlock("orange_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.orange());
    public static final DeferredBlock<SlabBlock> MAGENTA_TERRACOTTA_SLAB = registerSlabBlock("magenta_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.magenta());
    public static final DeferredBlock<StairBlock> MAGENTA_TERRACOTTA_STAIRS = registerStairBlock("magenta_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.magenta());
    public static final DeferredBlock<WallBlock> MAGENTA_TERRACOTTA_WALL = registerWallBlock("magenta_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.magenta());
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_TERRACOTTA_SLAB = registerSlabBlock("light_blue_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.lightBlue());
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_TERRACOTTA_STAIRS = registerStairBlock("light_blue_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.lightBlue());
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_TERRACOTTA_WALL = registerWallBlock("light_blue_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.lightBlue());
    public static final DeferredBlock<SlabBlock> YELLOW_TERRACOTTA_SLAB = registerSlabBlock("yellow_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.yellow());
    public static final DeferredBlock<StairBlock> YELLOW_TERRACOTTA_STAIRS = registerStairBlock("yellow_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.yellow());
    public static final DeferredBlock<WallBlock> YELLOW_TERRACOTTA_WALL = registerWallBlock("yellow_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.yellow());
    public static final DeferredBlock<SlabBlock> LIME_TERRACOTTA_SLAB = registerSlabBlock("lime_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.lime());
    public static final DeferredBlock<StairBlock> LIME_TERRACOTTA_STAIRS = registerStairBlock("lime_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.lime());
    public static final DeferredBlock<WallBlock> LIME_TERRACOTTA_WALL = registerWallBlock("lime_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.lime());
    public static final DeferredBlock<SlabBlock> PINK_TERRACOTTA_SLAB = registerSlabBlock("pink_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.pink());
    public static final DeferredBlock<StairBlock> PINK_TERRACOTTA_STAIRS = registerStairBlock("pink_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.pink());
    public static final DeferredBlock<WallBlock> PINK_TERRACOTTA_WALL = registerWallBlock("pink_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.pink());
    public static final DeferredBlock<SlabBlock> GRAY_TERRACOTTA_SLAB = registerSlabBlock("gray_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.gray());
    public static final DeferredBlock<StairBlock> GRAY_TERRACOTTA_STAIRS = registerStairBlock("gray_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.gray());
    public static final DeferredBlock<WallBlock> GRAY_TERRACOTTA_WALL = registerWallBlock("gray_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.gray());
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_TERRACOTTA_SLAB = registerSlabBlock("light_gray_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.lightGray());
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_TERRACOTTA_STAIRS = registerStairBlock("light_gray_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.lightGray());
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_TERRACOTTA_WALL = registerWallBlock("light_gray_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.lightGray());
    public static final DeferredBlock<SlabBlock> CYAN_TERRACOTTA_SLAB = registerSlabBlock("cyan_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.cyan());
    public static final DeferredBlock<StairBlock> CYAN_TERRACOTTA_STAIRS = registerStairBlock("cyan_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.cyan());
    public static final DeferredBlock<WallBlock> CYAN_TERRACOTTA_WALL = registerWallBlock("cyan_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.cyan());
    public static final DeferredBlock<SlabBlock> PURPLE_TERRACOTTA_SLAB = registerSlabBlock("purple_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.purple());
    public static final DeferredBlock<StairBlock> PURPLE_TERRACOTTA_STAIRS = registerStairBlock("purple_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.purple());
    public static final DeferredBlock<WallBlock> PURPLE_TERRACOTTA_WALL = registerWallBlock("purple_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.purple());
    public static final DeferredBlock<SlabBlock> BLUE_TERRACOTTA_SLAB = registerSlabBlock("blue_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.blue());
    public static final DeferredBlock<StairBlock> BLUE_TERRACOTTA_STAIRS = registerStairBlock("blue_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.blue());
    public static final DeferredBlock<WallBlock> BLUE_TERRACOTTA_WALL = registerWallBlock("blue_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.blue());
    public static final DeferredBlock<SlabBlock> BROWN_TERRACOTTA_SLAB = registerSlabBlock("brown_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.brown());
    public static final DeferredBlock<StairBlock> BROWN_TERRACOTTA_STAIRS = registerStairBlock("brown_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.brown());
    public static final DeferredBlock<WallBlock> BROWN_TERRACOTTA_WALL = registerWallBlock("brown_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.brown());
    public static final DeferredBlock<SlabBlock> GREEN_TERRACOTTA_SLAB = registerSlabBlock("green_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.green());
    public static final DeferredBlock<StairBlock> GREEN_TERRACOTTA_STAIRS = registerStairBlock("green_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.green());
    public static final DeferredBlock<WallBlock> GREEN_TERRACOTTA_WALL = registerWallBlock("green_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.green());
    public static final DeferredBlock<SlabBlock> RED_TERRACOTTA_SLAB = registerSlabBlock("red_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.red());
    public static final DeferredBlock<StairBlock> RED_TERRACOTTA_STAIRS = registerStairBlock("red_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.red());
    public static final DeferredBlock<WallBlock> RED_TERRACOTTA_WALL = registerWallBlock("red_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.red());
    public static final DeferredBlock<SlabBlock> BLACK_TERRACOTTA_SLAB = registerSlabBlock("black_terracotta_slab", () -> Blocks.DYED_TERRACOTTA.black());
    public static final DeferredBlock<StairBlock> BLACK_TERRACOTTA_STAIRS = registerStairBlock("black_terracotta_stairs", () -> Blocks.DYED_TERRACOTTA.black());
    public static final DeferredBlock<WallBlock> BLACK_TERRACOTTA_WALL = registerWallBlock("black_terracotta_wall", () -> Blocks.DYED_TERRACOTTA.black());

    public static final DeferredBlock<SlabBlock> WHITE_CONCRETE_SLAB = registerSlabBlock("white_concrete_slab", () -> Blocks.CONCRETE.white());
    public static final DeferredBlock<StairBlock> WHITE_CONCRETE_STAIRS = registerStairBlock("white_concrete_stairs", () -> Blocks.CONCRETE.white());
    public static final DeferredBlock<WallBlock> WHITE_CONCRETE_WALL = registerWallBlock("white_concrete_wall", () -> Blocks.CONCRETE.white());
    public static final DeferredBlock<SlabBlock> ORANGE_CONCRETE_SLAB = registerSlabBlock("orange_concrete_slab", () -> Blocks.CONCRETE.orange());
    public static final DeferredBlock<StairBlock> ORANGE_CONCRETE_STAIRS = registerStairBlock("orange_concrete_stairs", () -> Blocks.CONCRETE.orange());
    public static final DeferredBlock<WallBlock> ORANGE_CONCRETE_WALL = registerWallBlock("orange_concrete_wall", () -> Blocks.CONCRETE.orange());
    public static final DeferredBlock<SlabBlock> MAGENTA_CONCRETE_SLAB = registerSlabBlock("magenta_concrete_slab", () -> Blocks.CONCRETE.magenta());
    public static final DeferredBlock<StairBlock> MAGENTA_CONCRETE_STAIRS = registerStairBlock("magenta_concrete_stairs", () -> Blocks.CONCRETE.magenta());
    public static final DeferredBlock<WallBlock> MAGENTA_CONCRETE_WALL = registerWallBlock("magenta_concrete_wall", () -> Blocks.CONCRETE.magenta());
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_CONCRETE_SLAB = registerSlabBlock("light_blue_concrete_slab", () -> Blocks.CONCRETE.lightBlue());
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_CONCRETE_STAIRS = registerStairBlock("light_blue_concrete_stairs", () -> Blocks.CONCRETE.lightBlue());
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_CONCRETE_WALL = registerWallBlock("light_blue_concrete_wall", () -> Blocks.CONCRETE.lightBlue());
    public static final DeferredBlock<SlabBlock> YELLOW_CONCRETE_SLAB = registerSlabBlock("yellow_concrete_slab", () -> Blocks.CONCRETE.yellow());
    public static final DeferredBlock<StairBlock> YELLOW_CONCRETE_STAIRS = registerStairBlock("yellow_concrete_stairs", () -> Blocks.CONCRETE.yellow());
    public static final DeferredBlock<WallBlock> YELLOW_CONCRETE_WALL = registerWallBlock("yellow_concrete_wall", () -> Blocks.CONCRETE.yellow());
    public static final DeferredBlock<SlabBlock> LIME_CONCRETE_SLAB = registerSlabBlock("lime_concrete_slab", () -> Blocks.CONCRETE.lime());
    public static final DeferredBlock<StairBlock> LIME_CONCRETE_STAIRS = registerStairBlock("lime_concrete_stairs", () -> Blocks.CONCRETE.lime());
    public static final DeferredBlock<WallBlock> LIME_CONCRETE_WALL = registerWallBlock("lime_concrete_wall", () -> Blocks.CONCRETE.lime());
    public static final DeferredBlock<SlabBlock> PINK_CONCRETE_SLAB = registerSlabBlock("pink_concrete_slab", () -> Blocks.CONCRETE.pink());
    public static final DeferredBlock<StairBlock> PINK_CONCRETE_STAIRS = registerStairBlock("pink_concrete_stairs", () -> Blocks.CONCRETE.pink());
    public static final DeferredBlock<WallBlock> PINK_CONCRETE_WALL = registerWallBlock("pink_concrete_wall", () -> Blocks.CONCRETE.pink());
    public static final DeferredBlock<SlabBlock> GRAY_CONCRETE_SLAB = registerSlabBlock("gray_concrete_slab", () -> Blocks.CONCRETE.gray());
    public static final DeferredBlock<StairBlock> GRAY_CONCRETE_STAIRS = registerStairBlock("gray_concrete_stairs", () -> Blocks.CONCRETE.gray());
    public static final DeferredBlock<WallBlock> GRAY_CONCRETE_WALL = registerWallBlock("gray_concrete_wall", () -> Blocks.CONCRETE.gray());
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_CONCRETE_SLAB = registerSlabBlock("light_gray_concrete_slab", () -> Blocks.CONCRETE.lightGray());
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_CONCRETE_STAIRS = registerStairBlock("light_gray_concrete_stairs", () -> Blocks.CONCRETE.lightGray());
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_CONCRETE_WALL = registerWallBlock("light_gray_concrete_wall", () -> Blocks.CONCRETE.lightGray());
    public static final DeferredBlock<SlabBlock> CYAN_CONCRETE_SLAB = registerSlabBlock("cyan_concrete_slab", () -> Blocks.CONCRETE.cyan());
    public static final DeferredBlock<StairBlock> CYAN_CONCRETE_STAIRS = registerStairBlock("cyan_concrete_stairs", () -> Blocks.CONCRETE.cyan());
    public static final DeferredBlock<WallBlock> CYAN_CONCRETE_WALL = registerWallBlock("cyan_concrete_wall", () -> Blocks.CONCRETE.cyan());
    public static final DeferredBlock<SlabBlock> PURPLE_CONCRETE_SLAB = registerSlabBlock("purple_concrete_slab", () -> Blocks.CONCRETE.purple());
    public static final DeferredBlock<StairBlock> PURPLE_CONCRETE_STAIRS = registerStairBlock("purple_concrete_stairs", () -> Blocks.CONCRETE.purple());
    public static final DeferredBlock<WallBlock> PURPLE_CONCRETE_WALL = registerWallBlock("purple_concrete_wall", () -> Blocks.CONCRETE.purple());
    public static final DeferredBlock<SlabBlock> BLUE_CONCRETE_SLAB = registerSlabBlock("blue_concrete_slab", () -> Blocks.CONCRETE.blue());
    public static final DeferredBlock<StairBlock> BLUE_CONCRETE_STAIRS = registerStairBlock("blue_concrete_stairs", () -> Blocks.CONCRETE.blue());
    public static final DeferredBlock<WallBlock> BLUE_CONCRETE_WALL = registerWallBlock("blue_concrete_wall", () -> Blocks.CONCRETE.blue());
    public static final DeferredBlock<SlabBlock> BROWN_CONCRETE_SLAB = registerSlabBlock("brown_concrete_slab", () -> Blocks.CONCRETE.brown());
    public static final DeferredBlock<StairBlock> BROWN_CONCRETE_STAIRS = registerStairBlock("brown_concrete_stairs", () -> Blocks.CONCRETE.brown());
    public static final DeferredBlock<WallBlock> BROWN_CONCRETE_WALL = registerWallBlock("brown_concrete_wall", () -> Blocks.CONCRETE.brown());
    public static final DeferredBlock<SlabBlock> GREEN_CONCRETE_SLAB = registerSlabBlock("green_concrete_slab", () -> Blocks.CONCRETE.green());
    public static final DeferredBlock<StairBlock> GREEN_CONCRETE_STAIRS = registerStairBlock("green_concrete_stairs", () -> Blocks.CONCRETE.green());
    public static final DeferredBlock<WallBlock> GREEN_CONCRETE_WALL = registerWallBlock("green_concrete_wall", () -> Blocks.CONCRETE.green());
    public static final DeferredBlock<SlabBlock> RED_CONCRETE_SLAB = registerSlabBlock("red_concrete_slab", () -> Blocks.CONCRETE.red());
    public static final DeferredBlock<StairBlock> RED_CONCRETE_STAIRS = registerStairBlock("red_concrete_stairs", () -> Blocks.CONCRETE.red());
    public static final DeferredBlock<WallBlock> RED_CONCRETE_WALL = registerWallBlock("red_concrete_wall", () -> Blocks.CONCRETE.red());
    public static final DeferredBlock<SlabBlock> BLACK_CONCRETE_SLAB = registerSlabBlock("black_concrete_slab", () -> Blocks.CONCRETE.black());
    public static final DeferredBlock<StairBlock> BLACK_CONCRETE_STAIRS = registerStairBlock("black_concrete_stairs", () -> Blocks.CONCRETE.black());
    public static final DeferredBlock<WallBlock> BLACK_CONCRETE_WALL = registerWallBlock("black_concrete_wall", () -> Blocks.CONCRETE.black());

    public static final DeferredBlock<Block> STONE_TILES = registerBlockVariant("stone_tiles", () -> Blocks.STONE_BRICKS);
    public static final DeferredBlock<SlabBlock> STONE_TILE_SLAB = registerSlabBlock("stone_tile_slab", () -> STONE_TILES.get());
    public static final DeferredBlock<StairBlock> STONE_TILE_STAIRS = registerStairBlock("stone_tile_stairs", () -> STONE_TILES.get());
    public static final DeferredBlock<WallBlock> STONE_TILE_WALL = registerWallBlock("stone_tile_wall", () -> STONE_TILES.get());

    public static final DeferredBlock<Block> MOSSY_STONE_TILES = registerBlockVariant("mossy_stone_tiles", () -> Blocks.MOSSY_STONE_BRICKS);
    public static final DeferredBlock<SlabBlock> MOSSY_STONE_TILE_SLAB = registerSlabBlock("mossy_stone_tile_slab", () -> MOSSY_STONE_TILES.get());
    public static final DeferredBlock<StairBlock> MOSSY_STONE_TILE_STAIRS = registerStairBlock("mossy_stone_tile_stairs", () -> MOSSY_STONE_TILES.get());
    public static final DeferredBlock<WallBlock> MOSSY_STONE_TILE_WALL = registerWallBlock("mossy_stone_tile_wall", () -> MOSSY_STONE_TILES.get());

    public static final DeferredBlock<Block> CRACKED_STONE_TILES = registerBlockVariant("cracked_stone_tiles", () -> Blocks.CRACKED_STONE_BRICKS);
    public static final DeferredBlock<SlabBlock> CRACKED_STONE_TILE_SLAB = registerSlabBlock("cracked_stone_tile_slab", () -> CRACKED_STONE_TILES.get());
    public static final DeferredBlock<StairBlock> CRACKED_STONE_TILE_STAIRS = registerStairBlock("cracked_stone_tile_stairs", () -> CRACKED_STONE_TILES.get());
    public static final DeferredBlock<WallBlock> CRACKED_STONE_TILE_WALL = registerWallBlock("cracked_stone_tile_wall", () -> CRACKED_STONE_TILES.get());

    public static final DeferredBlock<ModChainBlock> EXPOSED_IRON_CHAIN = registerRustingChainBlock("exposed_iron_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ModChainBlock> WEATHERED_IRON_CHAIN = registerRustingChainBlock("weathered_iron_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ModChainBlock> RUSTED_IRON_CHAIN = registerRustingChainBlock("rusted_iron_chain", () -> Blocks.IRON_CHAIN);

    public static final DeferredBlock<ChainBlock> WAXED_IRON_CHAIN = registerChainBlock("waxed_iron_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_EXPOSED_IRON_CHAIN = registerChainBlock("waxed_exposed_iron_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_WEATHERED_IRON_CHAIN = registerChainBlock("waxed_weathered_iron_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_RUSTED_IRON_CHAIN = registerChainBlock("waxed_rusted_iron_chain", () -> Blocks.IRON_CHAIN);

    public static final DeferredBlock<Block> OBSIDIAN_BRICKS = registerBlockVariant("obsidian_bricks", () -> Blocks.OBSIDIAN);
    public static final DeferredBlock<SlabBlock> OBSIDIAN_BRICK_SLAB = registerSlabBlock("obsidian_brick_slab", () -> OBSIDIAN_BRICKS.get());
    public static final DeferredBlock<StairBlock> OBSIDIAN_BRICK_STAIRS = registerStairBlock("obsidian_brick_stairs", () -> OBSIDIAN_BRICKS.get());
    public static final DeferredBlock<WallBlock> OBSIDIAN_BRICK_WALL = registerWallBlock("obsidian_brick_wall", () -> OBSIDIAN_BRICKS.get());

    public static final DeferredBlock<CryingObsidianBlock> CRYING_OBSIDIAN_BRICKS = registerCOBlock("crying_obsidian_bricks", () -> Blocks.CRYING_OBSIDIAN);
    public static final DeferredBlock<CryingObsidianSlabBlock> CRYING_OBSIDIAN_BRICK_SLAB = registerCOSlabBlock("crying_obsidian_brick_slab", () -> CRYING_OBSIDIAN_BRICKS.get());
    public static final DeferredBlock<CryingObsidianStairBlock> CRYING_OBSIDIAN_BRICK_STAIRS = registerCOStairBlock("crying_obsidian_brick_stairs", () -> CRYING_OBSIDIAN_BRICKS.get());
    public static final DeferredBlock<CryingObsidianWallBlock> CRYING_OBSIDIAN_BRICK_WALL = registerCOWallBlock("crying_obsidian_brick_wall", () -> CRYING_OBSIDIAN_BRICKS.get());

    public static final DeferredBlock<Block> COAL_BRICKS = registerBlockVariant("coal_bricks", () -> Blocks.COAL_BLOCK);
    public static final DeferredBlock<SlabBlock> COAL_BRICK_SLAB = registerSlabBlock("coal_brick_slab", () -> COAL_BRICKS.get());
    public static final DeferredBlock<StairBlock> COAL_BRICK_STAIRS = registerStairBlock("coal_brick_stairs", () -> COAL_BRICKS.get());
    public static final DeferredBlock<WallBlock> COAL_BRICK_WALL = registerWallBlock("coal_brick_wall", () -> COAL_BRICKS.get());

    public static final DeferredBlock<Block> CHARCOAL_BRICKS = registerBlockVariant("charcoal_bricks", () -> CHARCOAL_BLOCK.get());
    public static final DeferredBlock<SlabBlock> CHARCOAL_BRICK_SLAB = registerSlabBlock("charcoal_brick_slab", () -> CHARCOAL_BRICKS.get());
    public static final DeferredBlock<StairBlock> CHARCOAL_BRICK_STAIRS = registerStairBlock("charcoal_brick_stairs", () -> CHARCOAL_BRICKS.get());
    public static final DeferredBlock<WallBlock> CHARCOAL_BRICK_WALL = registerWallBlock("charcoal_brick_wall", () -> CHARCOAL_BRICKS.get());

    public static final DeferredBlock<Block> LAPIS_BRICKS = registerBlockVariant("lapis_bricks", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<SlabBlock> LAPIS_BRICK_SLAB = registerSlabBlock("lapis_brick_slab", () -> LAPIS_BRICKS.get());
    public static final DeferredBlock<StairBlock> LAPIS_BRICK_STAIRS = registerStairBlock("lapis_brick_stairs", () -> LAPIS_BRICKS.get());
    public static final DeferredBlock<WallBlock> LAPIS_BRICK_WALL = registerWallBlock("lapis_brick_wall", () -> LAPIS_BRICKS.get());

    public static final DeferredBlock<Block> SMOOTH_LAPIS = registerBlockVariant("smooth_lapis", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<SlabBlock> SMOOTH_LAPIS_SLAB = registerSlabBlock("smooth_lapis_slab", () -> SMOOTH_LAPIS.get());
    public static final DeferredBlock<StairBlock> SMOOTH_LAPIS_STAIRS = registerStairBlock("smooth_lapis_stairs", () -> SMOOTH_LAPIS.get());
    public static final DeferredBlock<WallBlock> SMOOTH_LAPIS_WALL = registerWallBlock("smooth_lapis_wall", () -> SMOOTH_LAPIS.get());

    public static final DeferredBlock<Block> SNOW_BRICKS = registerBlockVariant("snow_bricks", () -> Blocks.SNOW_BLOCK);
    public static final DeferredBlock<SlabBlock> SNOW_BRICK_SLAB = registerSlabBlock("snow_brick_slab", () -> SNOW_BRICKS.get());
    public static final DeferredBlock<StairBlock> SNOW_BRICK_STAIRS = registerStairBlock("snow_brick_stairs", () -> SNOW_BRICKS.get());
    public static final DeferredBlock<WallBlock> SNOW_BRICK_WALL = registerWallBlock("snow_brick_wall", () -> SNOW_BRICKS.get());

    public static final DeferredBlock<IceBlock> ICE_BRICKS = registerIceBlock("ice_bricks", () -> Blocks.ICE);
    public static final DeferredBlock<IceSlabBlock> ICE_BRICK_SLAB = registerIceSlabBlock("ice_brick_slab", () -> ICE_BRICKS.get());
    public static final DeferredBlock<IceStairBlock> ICE_BRICK_STAIRS = registerIceStairBlock("ice_brick_stairs", () -> ICE_BRICKS.get());
    public static final DeferredBlock<IceWallBlock> ICE_BRICK_WALL = registerIceWallBlock("ice_brick_wall", () -> ICE_BRICKS.get());

    public static final DeferredBlock<Block> PACKED_ICE_BRICKS = registerBlockVariant("packed_ice_bricks", () -> Blocks.PACKED_ICE);
    public static final DeferredBlock<SlabBlock> PACKED_ICE_BRICK_SLAB = registerSlabBlock("packed_ice_brick_slab", () -> PACKED_ICE_BRICKS.get());
    public static final DeferredBlock<StairBlock> PACKED_ICE_BRICK_STAIRS = registerStairBlock("packed_ice_brick_stairs", () -> PACKED_ICE_BRICKS.get());
    public static final DeferredBlock<WallBlock> PACKED_ICE_BRICK_WALL = registerWallBlock("packed_ice_brick_wall", () -> PACKED_ICE_BRICKS.get());

    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = registerBlockVariant("blue_ice_bricks", () -> Blocks.BLUE_ICE);
    public static final DeferredBlock<SlabBlock> BLUE_ICE_BRICK_SLAB = registerSlabBlock("blue_ice_brick_slab", () -> BLUE_ICE_BRICKS.get());
    public static final DeferredBlock<StairBlock> BLUE_ICE_BRICK_STAIRS = registerStairBlock("blue_ice_brick_stairs", () -> BLUE_ICE_BRICKS.get());
    public static final DeferredBlock<WallBlock> BLUE_ICE_BRICK_WALL = registerWallBlock("blue_ice_brick_wall", () -> BLUE_ICE_BRICKS.get());

    public static final DeferredBlock<Block> SCULK_BRICKS = registerBlockVariant("sculk_bricks", () -> Blocks.RESIN_BRICKS, MapColor.COLOR_BLACK);
    public static final DeferredBlock<SlabBlock> SCULK_BRICK_SLAB = registerSlabBlock("sculk_brick_slab", () -> SCULK_BRICKS.get());
    public static final DeferredBlock<StairBlock> SCULK_BRICK_STAIRS = registerStairBlock("sculk_brick_stairs", () -> SCULK_BRICKS.get());
    public static final DeferredBlock<WallBlock> SCULK_BRICK_WALL = registerWallBlock("sculk_brick_wall", () -> SCULK_BRICKS.get());
    public static final DeferredBlock<Block> CHISELED_SCULK_BRICKS = registerBlockVariant("chiseled_sculk_bricks", () -> SCULK_BRICKS.get());

    public static final DeferredBlock<FenceBlock> STONE_FENCE = registerFenceBlock("stone_fence", () -> Blocks.STONE);
    public static final DeferredBlock<FenceBlock> COBBLESTONE_FENCE = registerFenceBlock("cobblestone_fence", () -> Blocks.COBBLESTONE);
    public static final DeferredBlock<FenceBlock> MOSSY_COBBLESTONE_FENCE = registerFenceBlock("mossy_cobblestone_fence", () -> Blocks.MOSSY_COBBLESTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_STONE_FENCE = registerFenceBlock("smooth_stone_fence", () -> Blocks.SMOOTH_STONE);
    public static final DeferredBlock<FenceBlock> STONE_BRICK_FENCE = registerFenceBlock("stone_brick_fence", () -> Blocks.STONE_BRICKS);
    public static final DeferredBlock<FenceBlock> MOSSY_STONE_BRICK_FENCE = registerFenceBlock("mossy_stone_brick_fence", () -> Blocks.MOSSY_STONE_BRICKS);
    public static final DeferredBlock<FenceBlock> CRACKED_STONE_BRICK_FENCE = registerFenceBlock("cracked_stone_brick_fence", () -> Blocks.CRACKED_STONE_BRICKS);
    public static final DeferredBlock<FenceBlock> STONE_TILE_FENCE = registerFenceBlock("stone_tile_fence", () -> STONE_TILES.get());
    public static final DeferredBlock<FenceBlock> MOSSY_STONE_TILE_FENCE = registerFenceBlock("mossy_stone_tile_fence", () -> MOSSY_STONE_TILES.get());
    public static final DeferredBlock<FenceBlock> CRACKED_STONE_TILE_FENCE = registerFenceBlock("cracked_stone_tile_fence", () -> CRACKED_STONE_TILES.get());

    public static final DeferredBlock<FenceBlock> GRANITE_FENCE = registerFenceBlock("granite_fence", () -> Blocks.GRANITE);
    public static final DeferredBlock<FenceBlock> POLISHED_GRANITE_FENCE = registerFenceBlock("polished_granite_fence", () -> Blocks.POLISHED_GRANITE);
    public static final DeferredBlock<FenceBlock> POLISHED_GRANITE_BRICK_FENCE = registerFenceBlock("polished_granite_brick_fence", () -> POLISHED_GRANITE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> DIORITE_FENCE = registerFenceBlock("diorite_fence", () -> Blocks.DIORITE);
    public static final DeferredBlock<FenceBlock> POLISHED_DIORITE_FENCE = registerFenceBlock("polished_diorite_fence", () -> Blocks.POLISHED_DIORITE);
    public static final DeferredBlock<FenceBlock> POLISHED_DIORITE_BRICK_FENCE = registerFenceBlock("polished_diorite_brick_fence", () -> POLISHED_DIORITE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> ANDESITE_FENCE = registerFenceBlock("andesite_fence", () -> Blocks.ANDESITE);
    public static final DeferredBlock<FenceBlock> POLISHED_ANDESITE_FENCE = registerFenceBlock("polished_andesite_fence", () -> Blocks.POLISHED_ANDESITE);
    public static final DeferredBlock<FenceBlock> POLISHED_ANDESITE_BRICK_FENCE = registerFenceBlock("polished_andesite_brick_fence", () -> POLISHED_ANDESITE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> DEEPSLATE_FENCE = registerFenceBlock("deepslate_fence", () -> Blocks.DEEPSLATE);
    public static final DeferredBlock<FenceBlock> COBBLED_DEEPSLATE_FENCE = registerFenceBlock("cobbled_deepslate_fence", () -> Blocks.COBBLED_DEEPSLATE);
    public static final DeferredBlock<FenceBlock> POLISHED_DEEPSLATE_FENCE = registerFenceBlock("polished_deepslate_fence", () -> Blocks.POLISHED_DEEPSLATE);
    public static final DeferredBlock<FenceBlock> DEEPSLATE_BRICK_FENCE = registerFenceBlock("deepslate_brick_fence", () -> Blocks.DEEPSLATE_BRICKS);
    public static final DeferredBlock<FenceBlock> CRACKED_DEEPSLATE_BRICK_FENCE = registerFenceBlock("cracked_deepslate_brick_fence", () -> Blocks.CRACKED_DEEPSLATE_BRICKS);
    public static final DeferredBlock<FenceBlock> DEEPSLATE_TILE_FENCE = registerFenceBlock("deepslate_tile_fence", () -> Blocks.DEEPSLATE_TILES);
    public static final DeferredBlock<FenceBlock> CRACKED_DEEPSLATE_TILE_FENCE = registerFenceBlock("cracked_deepslate_tile_fence", () -> Blocks.CRACKED_DEEPSLATE_TILES);

    public static final DeferredBlock<FenceBlock> TUFF_FENCE = registerFenceBlock("tuff_fence", () -> Blocks.TUFF);
    public static final DeferredBlock<FenceBlock> POLISHED_TUFF_FENCE = registerFenceBlock("polished_tuff_fence", () -> Blocks.POLISHED_TUFF);
    public static final DeferredBlock<FenceBlock> TUFF_BRICK_FENCE = registerFenceBlock("tuff_brick_fence", () -> Blocks.TUFF_BRICKS);

    public static final DeferredBlock<FenceBlock> CALCITE_FENCE = registerFenceBlock("calcite_fence", () -> Blocks.CALCITE);
    public static final DeferredBlock<FenceBlock> POLISHED_CALCITE_FENCE = registerFenceBlock("polished_calcite_fence", () -> POLISHED_CALCITE.get());
    public static final DeferredBlock<FenceBlock> CALCITE_BRICK_FENCE = registerFenceBlock("calcite_brick_fence", () -> CALCITE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> DRIPSTONE_FENCE = registerFenceBlock("dripstone_fence", () -> Blocks.DRIPSTONE_BLOCK);
    public static final DeferredBlock<FenceBlock> POLISHED_DRIPSTONE_FENCE = registerFenceBlock("polished_dripstone_fence", () -> POLISHED_DRIPSTONE.get());
    public static final DeferredBlock<FenceBlock> DRIPSTONE_BRICK_FENCE = registerFenceBlock("dripstone_brick_fence", () -> DRIPSTONE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> BRICK_FENCE = registerFenceBlock("brick_fence", () -> Blocks.BRICKS);

    public static final DeferredBlock<FenceBlock> PACKED_MUD_FENCE = registerFenceBlock("packed_mud_fence", () -> Blocks.PACKED_MUD);
    public static final DeferredBlock<FenceBlock> MUD_BRICK_FENCE = registerFenceBlock("mud_brick_fence", () -> Blocks.MUD_BRICKS);

    public static final DeferredBlock<FenceBlock> RESIN_FENCE = registerFenceBlock("resin_fence", () -> Blocks.RESIN_BLOCK);
    public static final DeferredBlock<FenceBlock> RESIN_BRICK_FENCE = registerFenceBlock("resin_brick_fence", () -> Blocks.RESIN_BRICKS);

    public static final DeferredBlock<FenceBlock> SANDSTONE_FENCE = registerFenceBlock("sandstone_fence", () -> Blocks.SANDSTONE);
    public static final DeferredBlock<FenceBlock> CUT_SANDSTONE_FENCE = registerFenceBlock("cut_sandstone_fence", () -> Blocks.CUT_SANDSTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_SANDSTONE_FENCE = registerFenceBlock("smooth_sandstone_fence", () -> Blocks.SMOOTH_SANDSTONE);

    public static final DeferredBlock<FenceBlock> RED_SANDSTONE_FENCE = registerFenceBlock("red_sandstone_fence", () -> Blocks.RED_SANDSTONE);
    public static final DeferredBlock<FenceBlock> CUT_RED_SANDSTONE_FENCE = registerFenceBlock("cut_red_sandstone_fence", () -> Blocks.CUT_RED_SANDSTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_RED_SANDSTONE_FENCE = registerFenceBlock("smooth_red_sandstone_fence", () -> Blocks.SMOOTH_RED_SANDSTONE);

    public static final DeferredBlock<FenceBlock> SOUL_SANDSTONE_FENCE = registerFenceBlock("soul_sandstone_fence", () -> SOUL_SANDSTONE.get());
    public static final DeferredBlock<FenceBlock> CUT_SOUL_SANDSTONE_FENCE = registerFenceBlock("cut_soul_sandstone_fence", () -> CUT_SOUL_SANDSTONE.get());
    public static final DeferredBlock<FenceBlock> SMOOTH_SOUL_SANDSTONE_FENCE = registerFenceBlock("smooth_soul_sandstone_fence", () -> SMOOTH_SOUL_SANDSTONE.get());

    public static final DeferredBlock<FenceBlock> END_STONE_FENCE = registerFenceBlock("end_stone_fence", () -> Blocks.END_STONE);
    public static final DeferredBlock<FenceBlock> END_STONE_BRICK_FENCE = registerFenceBlock("end_stone_brick_fence", () -> Blocks.END_STONE_BRICKS);

    public static final DeferredBlock<FenceBlock> PURPUR_FENCE = registerFenceBlock("purpur_fence", () -> Blocks.PURPUR_BLOCK);

    public static final DeferredBlock<FenceBlock> NETHERRACK_FENCE = registerFenceBlock("netherrack_fence", () -> Blocks.NETHERRACK);

    public static final DeferredBlock<FenceBlock> CRACKED_NETHER_BRICK_FENCE = registerFenceBlock("cracked_nether_brick_fence", () -> Blocks.CRACKED_NETHER_BRICKS);
    public static final DeferredBlock<FenceBlock> RED_NETHER_BRICK_FENCE = registerFenceBlock("red_nether_brick_fence", () -> Blocks.RED_NETHER_BRICKS);

    public static final DeferredBlock<FenceBlock> BASALT_FENCE = registerFenceBlock("basalt_fence", () -> Blocks.BASALT);
    public static final DeferredBlock<FenceBlock> POLISHED_BASALT_FENCE = registerFenceBlock("polished_basalt_fence", () -> Blocks.POLISHED_BASALT);
    public static final DeferredBlock<FenceBlock> SMOOTH_BASALT_FENCE = registerFenceBlock("smooth_basalt_fence", () -> Blocks.SMOOTH_BASALT);
    public static final DeferredBlock<FenceBlock> BASALT_BRICK_FENCE = registerFenceBlock("basalt_brick_fence", () -> BASALT_BRICKS.get());

    public static final DeferredBlock<FenceBlock> PRISMARINE_FENCE = registerFenceBlock("prismarine_fence", () -> Blocks.PRISMARINE);
    public static final DeferredBlock<FenceBlock> PRISMARINE_BRICK_FENCE = registerFenceBlock("prismarine_brick_fence", () -> Blocks.PRISMARINE_BRICKS);
    public static final DeferredBlock<FenceBlock> DARK_PRISMARINE_FENCE = registerFenceBlock("dark_prismarine_fence", () -> Blocks.DARK_PRISMARINE);

    public static final DeferredBlock<FenceBlock> ELDER_PRISMARINE_FENCE = registerFenceBlock("elder_prismarine_fence", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<FenceBlock> ELDER_PRISMARINE_BRICK_FENCE = registerFenceBlock("elder_prismarine_brick_fence", () -> ELDER_PRISMARINE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> DARK_ELDER_PRISMARINE_FENCE = registerFenceBlock("dark_elder_prismarine_fence", () -> DARK_ELDER_PRISMARINE.get());

    public static final DeferredBlock<FenceBlock> BLACKSTONE_FENCE = registerFenceBlock("blackstone_fence", () -> Blocks.BLACKSTONE);
    public static final DeferredBlock<FenceBlock> POLISHED_BLACKSTONE_FENCE = registerFenceBlock("polished_blackstone_fence", () -> Blocks.POLISHED_BLACKSTONE);
    public static final DeferredBlock<FenceBlock> POLISHED_BLACKSTONE_BRICK_FENCE = registerFenceBlock("polished_blackstone_brick_fence", () -> Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final DeferredBlock<FenceBlock> CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE = registerFenceBlock("cracked_polished_blackstone_brick_fence", () -> Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);

    public static final DeferredBlock<FenceBlock> QUARTZ_FENCE = registerFenceBlock("quartz_fence", () -> Blocks.QUARTZ_BLOCK);
    public static final DeferredBlock<FenceBlock> SMOOTH_QUARTZ_FENCE = registerFenceBlock("smooth_quartz_fence", () -> Blocks.SMOOTH_QUARTZ);
    public static final DeferredBlock<FenceBlock> QUARTZ_BRICK_FENCE = registerFenceBlock("quartz_brick_fence", () -> Blocks.QUARTZ_BRICKS);

    public static final DeferredBlock<FenceBlock> OBSIDIAN_FENCE = registerFenceBlock("obsidian_fence", () -> Blocks.OBSIDIAN);
    public static final DeferredBlock<FenceBlock> OBSIDIAN_BRICK_FENCE = registerFenceBlock("obsidian_brick_fence", () -> OBSIDIAN_BRICKS.get());

    public static final DeferredBlock<CryingObsidianFenceBlock> CRYING_OBSIDIAN_FENCE = registerCOFenceBlock("crying_obsidian_fence", () -> Blocks.CRYING_OBSIDIAN);
    public static final DeferredBlock<CryingObsidianFenceBlock> CRYING_OBSIDIAN_BRICK_FENCE = registerCOFenceBlock("crying_obsidian_brick_fence", () -> CRYING_OBSIDIAN_BRICKS.get());

    public static final DeferredBlock<FenceBlock> COAL_FENCE = registerFenceBlock("coal_fence", () -> Blocks.COAL_BLOCK);
    public static final DeferredBlock<FenceBlock> COAL_BRICK_FENCE = registerFenceBlock("coal_brick_fence", () -> COAL_BRICKS.get());

    public static final DeferredBlock<FenceBlock> CHARCOAL_FENCE = registerFenceBlock("charcoal_fence", () -> CHARCOAL_BLOCK.get());
    public static final DeferredBlock<FenceBlock> CHARCOAL_BRICK_FENCE = registerFenceBlock("charcoal_brick_fence", () -> CHARCOAL_BRICKS.get());

    public static final DeferredBlock<FenceBlock> LAPIS_FENCE = registerFenceBlock("lapis_fence", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<FenceBlock> SMOOTH_LAPIS_FENCE = registerFenceBlock("smooth_lapis_fence", () -> SMOOTH_LAPIS.get());
    public static final DeferredBlock<FenceBlock> LAPIS_BRICK_FENCE = registerFenceBlock("lapis_brick_fence", () -> LAPIS_BRICKS.get());

    public static final DeferredBlock<FenceBlock> SNOW_FENCE = registerFenceBlock("snow_fence", () -> Blocks.SNOW_BLOCK);
    public static final DeferredBlock<FenceBlock> SNOW_BRICK_FENCE = registerFenceBlock("snow_brick_fence", () -> SNOW_BRICKS.get());

    public static final DeferredBlock<IceFenceBlock> ICE_FENCE = registerIceFenceBlock("ice_fence", () -> Blocks.ICE);
    public static final DeferredBlock<IceFenceBlock> ICE_BRICK_FENCE = registerIceFenceBlock("ice_brick_fence", () -> ICE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> PACKED_ICE_FENCE = registerFenceBlock("packed_ice_fence", () -> Blocks.PACKED_ICE);
    public static final DeferredBlock<FenceBlock> PACKED_ICE_BRICK_FENCE = registerFenceBlock("packed_ice_brick_fence", () -> PACKED_ICE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> BLUE_ICE_FENCE = registerFenceBlock("blue_ice_fence", () -> Blocks.BLUE_ICE);
    public static final DeferredBlock<FenceBlock> BLUE_ICE_BRICK_FENCE = registerFenceBlock("blue_ice_brick_fence", () -> BLUE_ICE_BRICKS.get());

    public static final DeferredBlock<FenceBlock> SCULK_FENCE = registerFenceBlock("sculk_fence", () -> Blocks.SCULK);
    public static final DeferredBlock<FenceBlock> SCULK_BRICK_FENCE = registerFenceBlock("sculk_brick_fence", () -> SCULK_BRICKS.get());

    public static final DeferredBlock<FenceBlock> TERRACOTTA_FENCE = registerFenceBlock("terracotta_fence", () -> Blocks.TERRACOTTA);

    public static final DeferredBlock<FenceBlock> WHITE_TERRACOTTA_FENCE = registerFenceBlock("white_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.white());
    public static final DeferredBlock<FenceBlock> ORANGE_TERRACOTTA_FENCE = registerFenceBlock("orange_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.orange());
    public static final DeferredBlock<FenceBlock> MAGENTA_TERRACOTTA_FENCE = registerFenceBlock("magenta_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.magenta());
    public static final DeferredBlock<FenceBlock> LIGHT_BLUE_TERRACOTTA_FENCE = registerFenceBlock("light_blue_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.lightBlue());
    public static final DeferredBlock<FenceBlock> YELLOW_TERRACOTTA_FENCE = registerFenceBlock("yellow_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.yellow());
    public static final DeferredBlock<FenceBlock> LIME_TERRACOTTA_FENCE = registerFenceBlock("lime_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.lime());
    public static final DeferredBlock<FenceBlock> PINK_TERRACOTTA_FENCE = registerFenceBlock("pink_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.pink());
    public static final DeferredBlock<FenceBlock> GRAY_TERRACOTTA_FENCE = registerFenceBlock("gray_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.gray());
    public static final DeferredBlock<FenceBlock> LIGHT_GRAY_TERRACOTTA_FENCE = registerFenceBlock("light_gray_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.lightGray());
    public static final DeferredBlock<FenceBlock> CYAN_TERRACOTTA_FENCE = registerFenceBlock("cyan_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.cyan());
    public static final DeferredBlock<FenceBlock> PURPLE_TERRACOTTA_FENCE = registerFenceBlock("purple_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.purple());
    public static final DeferredBlock<FenceBlock> BLUE_TERRACOTTA_FENCE = registerFenceBlock("blue_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.blue());
    public static final DeferredBlock<FenceBlock> BROWN_TERRACOTTA_FENCE = registerFenceBlock("brown_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.brown());
    public static final DeferredBlock<FenceBlock> GREEN_TERRACOTTA_FENCE = registerFenceBlock("green_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.green());
    public static final DeferredBlock<FenceBlock> RED_TERRACOTTA_FENCE = registerFenceBlock("red_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.red());
    public static final DeferredBlock<FenceBlock> BLACK_TERRACOTTA_FENCE = registerFenceBlock("black_terracotta_fence", () -> Blocks.DYED_TERRACOTTA.black());

    public static final DeferredBlock<FenceBlock> WHITE_CONCRETE_FENCE = registerFenceBlock("white_concrete_fence", () -> Blocks.CONCRETE.white());
    public static final DeferredBlock<FenceBlock> ORANGE_CONCRETE_FENCE = registerFenceBlock("orange_concrete_fence", () -> Blocks.CONCRETE.orange());
    public static final DeferredBlock<FenceBlock> MAGENTA_CONCRETE_FENCE = registerFenceBlock("magenta_concrete_fence", () -> Blocks.CONCRETE.magenta());
    public static final DeferredBlock<FenceBlock> LIGHT_BLUE_CONCRETE_FENCE = registerFenceBlock("light_blue_concrete_fence", () -> Blocks.CONCRETE.lightBlue());
    public static final DeferredBlock<FenceBlock> YELLOW_CONCRETE_FENCE = registerFenceBlock("yellow_concrete_fence", () -> Blocks.CONCRETE.yellow());
    public static final DeferredBlock<FenceBlock> LIME_CONCRETE_FENCE = registerFenceBlock("lime_concrete_fence", () -> Blocks.CONCRETE.lime());
    public static final DeferredBlock<FenceBlock> PINK_CONCRETE_FENCE = registerFenceBlock("pink_concrete_fence", () -> Blocks.CONCRETE.pink());
    public static final DeferredBlock<FenceBlock> GRAY_CONCRETE_FENCE = registerFenceBlock("gray_concrete_fence", () -> Blocks.CONCRETE.gray());
    public static final DeferredBlock<FenceBlock> LIGHT_GRAY_CONCRETE_FENCE = registerFenceBlock("light_gray_concrete_fence", () -> Blocks.CONCRETE.lightGray());
    public static final DeferredBlock<FenceBlock> CYAN_CONCRETE_FENCE = registerFenceBlock("cyan_concrete_fence", () -> Blocks.CONCRETE.cyan());
    public static final DeferredBlock<FenceBlock> PURPLE_CONCRETE_FENCE = registerFenceBlock("purple_concrete_fence", () -> Blocks.CONCRETE.purple());
    public static final DeferredBlock<FenceBlock> BLUE_CONCRETE_FENCE = registerFenceBlock("blue_concrete_fence", () -> Blocks.CONCRETE.blue());
    public static final DeferredBlock<FenceBlock> BROWN_CONCRETE_FENCE = registerFenceBlock("brown_concrete_fence", () -> Blocks.CONCRETE.brown());
    public static final DeferredBlock<FenceBlock> GREEN_CONCRETE_FENCE = registerFenceBlock("green_concrete_fence", () -> Blocks.CONCRETE.green());
    public static final DeferredBlock<FenceBlock> RED_CONCRETE_FENCE = registerFenceBlock("red_concrete_fence", () -> Blocks.CONCRETE.red());
    public static final DeferredBlock<FenceBlock> BLACK_CONCRETE_FENCE = registerFenceBlock("black_concrete_fence", () -> Blocks.CONCRETE.black());

    public static final DeferredBlock<TorchBlock> IRON_TORCH = registerTorchBlock("iron_torch", () -> ModParticles.IRON_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> IRON_WALL_TORCH = registerWallTorchBlock("iron_wall_torch", () -> ModParticles.IRON_FIRE_FLAME.get(), () -> IRON_TORCH.get());

    public static final DeferredBlock<ModLanternBlock> EXPOSED_IRON_LANTERN = registerRustingLanternBlock("exposed_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<ModLanternBlock> WEATHERED_IRON_LANTERN = registerRustingLanternBlock("weathered_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<ModLanternBlock> RUSTED_IRON_LANTERN = registerRustingLanternBlock("rusted_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_IRON_LANTERN = registerLanternBlock("waxed_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_EXPOSED_IRON_LANTERN = registerLanternBlock("waxed_exposed_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_WEATHERED_IRON_LANTERN = registerLanternBlock("waxed_weathered_iron_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_RUSTED_IRON_LANTERN = registerLanternBlock("waxed_rusted_iron_lantern", () -> Blocks.LANTERN);

    public static final DeferredBlock<ModLanternBlock> EXPOSED_IRON_SOUL_LANTERN = registerRustingLanternBlock("exposed_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<ModLanternBlock> WEATHERED_IRON_SOUL_LANTERN = registerRustingLanternBlock("weathered_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<ModLanternBlock> RUSTED_IRON_SOUL_LANTERN = registerRustingLanternBlock("rusted_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_IRON_SOUL_LANTERN = registerLanternBlock("waxed_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_EXPOSED_IRON_SOUL_LANTERN = registerLanternBlock("waxed_exposed_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_WEATHERED_IRON_SOUL_LANTERN = registerLanternBlock("waxed_weathered_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_RUSTED_IRON_SOUL_LANTERN = registerLanternBlock("waxed_rusted_iron_soul_lantern", () -> Blocks.SOUL_LANTERN);

    public static final DeferredBlock<ModLanternBlock> IRON_FIRE_LANTERN = registerRustingLanternBlock("iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<ModLanternBlock> EXPOSED_IRON_FIRE_LANTERN = registerRustingLanternBlock("exposed_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<ModLanternBlock> WEATHERED_IRON_FIRE_LANTERN = registerRustingLanternBlock("weathered_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<ModLanternBlock> RUSTED_IRON_FIRE_LANTERN = registerRustingLanternBlock("rusted_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_IRON_FIRE_LANTERN = registerLanternBlock("waxed_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_EXPOSED_IRON_FIRE_LANTERN = registerLanternBlock("waxed_exposed_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_WEATHERED_IRON_FIRE_LANTERN = registerLanternBlock("waxed_weathered_iron_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_RUSTED_IRON_FIRE_LANTERN = registerLanternBlock("waxed_rusted_iron_fire_lantern", () -> Blocks.LANTERN);

    public static final DeferredBlock<WeatheringLanternBlock> COPPER_SOUL_LANTERN = registerOxidizingLanternBlock("copper_soul_lantern", () -> Blocks.SOUL_LANTERN, WeatheringCopper.WeatherState.UNAFFECTED);
    public static final DeferredBlock<WeatheringLanternBlock> EXPOSED_COPPER_SOUL_LANTERN = registerOxidizingLanternBlock("exposed_copper_soul_lantern", () -> Blocks.SOUL_LANTERN, WeatheringCopper.WeatherState.EXPOSED);
    public static final DeferredBlock<WeatheringLanternBlock> WEATHERED_COPPER_SOUL_LANTERN = registerOxidizingLanternBlock("weathered_copper_soul_lantern", () -> Blocks.SOUL_LANTERN, WeatheringCopper.WeatherState.WEATHERED);
    public static final DeferredBlock<WeatheringLanternBlock> OXIDIZED_COPPER_SOUL_LANTERN = registerOxidizingLanternBlock("oxidized_copper_soul_lantern", () -> Blocks.SOUL_LANTERN, WeatheringCopper.WeatherState.OXIDIZED);
    public static final DeferredBlock<LanternBlock> WAXED_COPPER_SOUL_LANTERN = registerLanternBlock("waxed_copper_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_EXPOSED_COPPER_SOUL_LANTERN = registerLanternBlock("waxed_exposed_copper_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_WEATHERED_COPPER_SOUL_LANTERN = registerLanternBlock("waxed_weathered_copper_soul_lantern", () -> Blocks.SOUL_LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_OXIDIZED_COPPER_SOUL_LANTERN = registerLanternBlock("waxed_oxidized_copper_soul_lantern", () -> Blocks.SOUL_LANTERN);

    public static final DeferredBlock<WeatheringLanternBlock> COPPER_FIRE_LANTERN = registerOxidizingLanternBlock("copper_fire_lantern", () -> Blocks.LANTERN, WeatheringCopper.WeatherState.UNAFFECTED);
    public static final DeferredBlock<WeatheringLanternBlock> EXPOSED_COPPER_FIRE_LANTERN = registerOxidizingLanternBlock("exposed_copper_fire_lantern", () -> Blocks.LANTERN, WeatheringCopper.WeatherState.EXPOSED);
    public static final DeferredBlock<WeatheringLanternBlock> WEATHERED_COPPER_FIRE_LANTERN = registerOxidizingLanternBlock("weathered_copper_fire_lantern", () -> Blocks.LANTERN, WeatheringCopper.WeatherState.WEATHERED);
    public static final DeferredBlock<WeatheringLanternBlock> OXIDIZED_COPPER_FIRE_LANTERN = registerOxidizingLanternBlock("oxidized_copper_fire_lantern", () -> Blocks.LANTERN, WeatheringCopper.WeatherState.OXIDIZED);
    public static final DeferredBlock<LanternBlock> WAXED_COPPER_FIRE_LANTERN = registerLanternBlock("waxed_copper_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_EXPOSED_COPPER_FIRE_LANTERN = registerLanternBlock("waxed_exposed_copper_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_WEATHERED_COPPER_FIRE_LANTERN = registerLanternBlock("waxed_weathered_copper_fire_lantern", () -> Blocks.LANTERN);
    public static final DeferredBlock<LanternBlock> WAXED_OXIDIZED_COPPER_FIRE_LANTERN = registerLanternBlock("waxed_oxidized_copper_fire_lantern", () -> Blocks.LANTERN);

    public static final DeferredBlock<ModChainBlock> ZINC_CHAIN = registerRustingChainBlock("zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ModChainBlock> EXPOSED_ZINC_CHAIN = registerRustingChainBlock("exposed_zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ModChainBlock> WEATHERED_ZINC_CHAIN = registerRustingChainBlock("weathered_zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ModChainBlock> CORRODED_ZINC_CHAIN = registerRustingChainBlock("corroded_zinc_chain", () -> Blocks.IRON_CHAIN);

    public static final DeferredBlock<ChainBlock> WAXED_ZINC_CHAIN = registerChainBlock("waxed_zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_EXPOSED_ZINC_CHAIN = registerChainBlock("waxed_exposed_zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_WEATHERED_ZINC_CHAIN = registerChainBlock("waxed_weathered_zinc_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> WAXED_CORRODED_ZINC_CHAIN = registerChainBlock("waxed_corroded_zinc_chain", () -> Blocks.IRON_CHAIN);

    public static final DeferredBlock<ChainBlock> GOLD_CHAIN = registerChainBlock("gold_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> NETHERITE_CHAIN = registerChainBlock("netherite_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> SILVER_CHAIN = registerChainBlock("silver_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> TIN_CHAIN = registerChainBlock("tin_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> TUNGSTEN_CHAIN = registerChainBlock("tungsten_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> PLATINUM_CHAIN = registerChainBlock("platinum_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> LEAD_CHAIN = registerChainBlock("lead_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> URANIUM_CHAIN = registerChainBlock("uranium_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> BRONZE_CHAIN = registerChainBlock("bronze_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> BRASS_CHAIN = registerChainBlock("brass_chain", () -> Blocks.IRON_CHAIN);
    public static final DeferredBlock<ChainBlock> STEEL_CHAIN = registerChainBlock("steel_chain", () -> Blocks.IRON_CHAIN);

    public static final DeferredBlock<TorchBlock> ZINC_TORCH = registerTorchBlock("zinc_torch", () -> ModParticles.ZINC_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> ZINC_WALL_TORCH = registerWallTorchBlock("zinc_wall_torch", () -> ModParticles.ZINC_FIRE_FLAME.get(), () -> ZINC_TORCH.get());

    public static final DeferredBlock<TorchBlock> SILVER_TORCH = registerTorchBlock("silver_torch", () -> ModParticles.SILVER_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> SILVER_WALL_TORCH = registerWallTorchBlock("silver_wall_torch", () -> ModParticles.SILVER_FIRE_FLAME.get(), () -> SILVER_TORCH.get());

    public static final DeferredBlock<TorchBlock> TIN_TORCH = registerTorchBlock("tin_torch", () -> ModParticles.TIN_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> TIN_WALL_TORCH = registerWallTorchBlock("tin_wall_torch", () -> ModParticles.TIN_FIRE_FLAME.get(), () -> TIN_TORCH.get());

    public static final DeferredBlock<TorchBlock> TUNGSTEN_TORCH = registerTorchBlock("tungsten_torch", () -> ModParticles.TUNGSTEN_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> TUNGSTEN_WALL_TORCH = registerWallTorchBlock("tungsten_wall_torch", () -> ModParticles.TUNGSTEN_FIRE_FLAME.get(), () -> TUNGSTEN_TORCH.get());

    public static final DeferredBlock<TorchBlock> PLATINUM_TORCH = registerTorchBlock("platinum_torch", () -> ModParticles.PLATINUM_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> PLATINUM_WALL_TORCH = registerWallTorchBlock("platinum_wall_torch", () -> ModParticles.PLATINUM_FIRE_FLAME.get(), () -> PLATINUM_TORCH.get());

    public static final DeferredBlock<TorchBlock> GOLD_TORCH = registerTorchBlock("gold_torch", () -> ModParticles.GOLD_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> GOLD_WALL_TORCH = registerWallTorchBlock("gold_wall_torch", () -> ModParticles.GOLD_FIRE_FLAME.get(), () -> GOLD_TORCH.get());

    public static final DeferredBlock<TorchBlock> LEAD_TORCH = registerTorchBlock("lead_torch", () -> ModParticles.LEAD_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> LEAD_WALL_TORCH = registerWallTorchBlock("lead_wall_torch", () -> ModParticles.LEAD_FIRE_FLAME.get(), () -> LEAD_TORCH.get());

    public static final DeferredBlock<TorchBlock> URANIUM_TORCH = registerTorchBlock("uranium_torch", () -> ModParticles.URANIUM_FIRE_FLAME.get());
    public static final DeferredBlock<WallTorchBlock> URANIUM_WALL_TORCH = registerWallTorchBlock("uranium_wall_torch", () -> ModParticles.URANIUM_FIRE_FLAME.get(), () -> URANIUM_TORCH.get());

    public static final DeferredBlock<AmethystBlock> CUT_AMETHYST = registerAmethystBlock("cut_amethyst", () -> Blocks.AMETHYST_BLOCK);
    public static final DeferredBlock<AmethystSlabBlock> CUT_AMETHYST_SLAB = registerAmethystSlabBlock("cut_amethyst_slab", () -> CUT_AMETHYST.get());
    public static final DeferredBlock<AmethystStairBlock> CUT_AMETHYST_STAIRS = registerAmethystStairBlock("cut_amethyst_stairs", () -> CUT_AMETHYST.get());

    public static final DeferredBlock<Block> GABBRO = registerBlockVariant("gabbro", () -> Blocks.TUFF, MapColor.TERRACOTTA_GREEN);
    public static final DeferredBlock<SlabBlock> GABBRO_SLAB = registerSlabBlock("gabbro_slab", () -> GABBRO.get());
    public static final DeferredBlock<StairBlock> GABBRO_STAIRS = registerStairBlock("gabbro_stairs", () -> GABBRO.get());
    public static final DeferredBlock<WallBlock> GABBRO_WALL = registerWallBlock("gabbro_wall", () -> GABBRO.get());
    public static final DeferredBlock<FenceBlock> GABBRO_FENCE = registerFenceBlock("gabbro_fence", () -> GABBRO.get());

    public static final DeferredBlock<Block> POLISHED_GABBRO = registerBlockVariant("polished_gabbro", () -> Blocks.POLISHED_TUFF, MapColor.TERRACOTTA_GREEN);
    public static final DeferredBlock<SlabBlock> POLISHED_GABBRO_SLAB = registerSlabBlock("polished_gabbro_slab", () -> POLISHED_GABBRO.get());
    public static final DeferredBlock<StairBlock> POLISHED_GABBRO_STAIRS = registerStairBlock("polished_gabbro_stairs", () -> POLISHED_GABBRO.get());
    public static final DeferredBlock<WallBlock> POLISHED_GABBRO_WALL = registerWallBlock("polished_gabbro_wall", () -> POLISHED_GABBRO.get());
    public static final DeferredBlock<FenceBlock> POLISHED_GABBRO_FENCE = registerFenceBlock("polished_gabbro_fence", () -> POLISHED_GABBRO.get());

    public static final DeferredBlock<Block> GABBRO_BRICKS = registerBlockVariant("gabbro_bricks", () -> Blocks.TUFF_BRICKS, MapColor.TERRACOTTA_GREEN);
    public static final DeferredBlock<SlabBlock> GABBRO_BRICK_SLAB = registerSlabBlock("gabbro_brick_slab", () -> GABBRO_BRICKS.get());
    public static final DeferredBlock<StairBlock> GABBRO_BRICK_STAIRS = registerStairBlock("gabbro_brick_stairs", () -> GABBRO_BRICKS.get());
    public static final DeferredBlock<WallBlock> GABBRO_BRICK_WALL = registerWallBlock("gabbro_brick_wall", () -> GABBRO_BRICKS.get());
    public static final DeferredBlock<FenceBlock> GABBRO_BRICK_FENCE = registerFenceBlock("gabbro_brick_fence", () -> GABBRO_BRICKS.get());

    public static final DeferredBlock<Block> RHYOLITE = registerBlockVariant("rhyolite", () -> Blocks.TUFF, MapColor.DIRT);
    public static final DeferredBlock<SlabBlock> RHYOLITE_SLAB = registerSlabBlock("rhyolite_slab", () -> RHYOLITE.get());
    public static final DeferredBlock<StairBlock> RHYOLITE_STAIRS = registerStairBlock("rhyolite_stairs", () -> RHYOLITE.get());
    public static final DeferredBlock<WallBlock> RHYOLITE_WALL = registerWallBlock("rhyolite_wall", () -> RHYOLITE.get());
    public static final DeferredBlock<FenceBlock> RHYOLITE_FENCE = registerFenceBlock("rhyolite_fence", () -> RHYOLITE.get());

    public static final DeferredBlock<Block> POLISHED_RHYOLITE = registerBlockVariant("polished_rhyolite", () -> Blocks.POLISHED_TUFF, MapColor.DIRT);
    public static final DeferredBlock<SlabBlock> POLISHED_RHYOLITE_SLAB = registerSlabBlock("polished_rhyolite_slab", () -> POLISHED_RHYOLITE.get());
    public static final DeferredBlock<StairBlock> POLISHED_RHYOLITE_STAIRS = registerStairBlock("polished_rhyolite_stairs", () -> POLISHED_RHYOLITE.get());
    public static final DeferredBlock<WallBlock> POLISHED_RHYOLITE_WALL = registerWallBlock("polished_rhyolite_wall", () -> POLISHED_RHYOLITE.get());
    public static final DeferredBlock<FenceBlock> POLISHED_RHYOLITE_FENCE = registerFenceBlock("polished_rhyolite_fence", () -> POLISHED_RHYOLITE.get());

    public static final DeferredBlock<Block> RHYOLITE_BRICKS = registerBlockVariant("rhyolite_bricks", () -> Blocks.TUFF_BRICKS, MapColor.DIRT);
    public static final DeferredBlock<SlabBlock> RHYOLITE_BRICK_SLAB = registerSlabBlock("rhyolite_brick_slab", () -> RHYOLITE_BRICKS.get());
    public static final DeferredBlock<StairBlock> RHYOLITE_BRICK_STAIRS = registerStairBlock("rhyolite_brick_stairs", () -> RHYOLITE_BRICKS.get());
    public static final DeferredBlock<WallBlock> RHYOLITE_BRICK_WALL = registerWallBlock("rhyolite_brick_wall", () -> RHYOLITE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> RHYOLITE_BRICK_FENCE = registerFenceBlock("rhyolite_brick_fence", () -> RHYOLITE_BRICKS.get());

    public static final DeferredBlock<PumiceBlock> PUMICE = registerPumiceBlock("pumice", () -> Blocks.BASALT);
    public static final DeferredBlock<PumiceSlabBlock> PUMICE_SLAB = registerPumiceSlabBlock("pumice_slab", () -> PUMICE.get());
    public static final DeferredBlock<PumiceStairBlock> PUMICE_STAIRS = registerPumiceStairBlock("pumice_stairs", () -> PUMICE.get());
    public static final DeferredBlock<PumiceWallBlock> PUMICE_WALL = registerPumiceWallBlock("pumice_wall", () -> PUMICE.get());
    public static final DeferredBlock<PumiceFenceBlock> PUMICE_FENCE = registerPumiceFenceBlock("pumice_fence", () -> PUMICE.get());

    public static final DeferredBlock<PumiceBlock> POLISHED_PUMICE = registerPumiceBlock("polished_pumice", () -> PUMICE.get());
    public static final DeferredBlock<PumiceSlabBlock> POLISHED_PUMICE_SLAB = registerPumiceSlabBlock("polished_pumice_slab", () -> POLISHED_PUMICE.get());
    public static final DeferredBlock<PumiceStairBlock> POLISHED_PUMICE_STAIRS = registerPumiceStairBlock("polished_pumice_stairs", () -> POLISHED_PUMICE.get());
    public static final DeferredBlock<PumiceWallBlock> POLISHED_PUMICE_WALL = registerPumiceWallBlock("polished_pumice_wall", () -> POLISHED_PUMICE.get());
    public static final DeferredBlock<PumiceFenceBlock> POLISHED_PUMICE_FENCE = registerPumiceFenceBlock("polished_pumice_fence", () -> POLISHED_PUMICE.get());

    public static final DeferredBlock<PumiceBlock> PUMICE_BRICKS = registerPumiceBlock("pumice_bricks", () -> POLISHED_PUMICE.get());
    public static final DeferredBlock<PumiceSlabBlock> PUMICE_BRICK_SLAB = registerPumiceSlabBlock("pumice_brick_slab", () -> PUMICE_BRICKS.get());
    public static final DeferredBlock<PumiceStairBlock> PUMICE_BRICK_STAIRS = registerPumiceStairBlock("pumice_brick_stairs", () -> PUMICE_BRICKS.get());
    public static final DeferredBlock<PumiceWallBlock> PUMICE_BRICK_WALL = registerPumiceWallBlock("pumice_brick_wall", () -> PUMICE_BRICKS.get());
    public static final DeferredBlock<PumiceFenceBlock> PUMICE_BRICK_FENCE = registerPumiceFenceBlock("pumice_brick_fence", () -> PUMICE_BRICKS.get());

    public static final DeferredBlock<Block> POLISHED_STONE = registerBlockVariant("polished_stone", () -> Blocks.COBBLESTONE);
    public static final DeferredBlock<SlabBlock> POLISHED_STONE_SLAB = registerSlabBlock("polished_stone_slab", () -> POLISHED_STONE.get());
    public static final DeferredBlock<StairBlock> POLISHED_STONE_STAIRS = registerStairBlock("polished_stone_stairs", () -> POLISHED_STONE.get());
    public static final DeferredBlock<WallBlock> POLISHED_STONE_WALL = registerWallBlock("polished_stone_wall", () -> POLISHED_STONE.get());
    public static final DeferredBlock<FenceBlock> POLISHED_STONE_FENCE = registerFenceBlock("polished_stone_fence", () -> POLISHED_STONE.get());

    public static final DeferredBlock<Block> SMOOTH_DEEPSLATE = registerBlockVariant("smooth_deepslate", () -> Blocks.DEEPSLATE);
    public static final DeferredBlock<SlabBlock> SMOOTH_DEEPSLATE_SLAB = registerSlabBlock("smooth_deepslate_slab", () -> SMOOTH_DEEPSLATE.get());
    public static final DeferredBlock<StairBlock> SMOOTH_DEEPSLATE_STAIRS = registerStairBlock("smooth_deepslate_stairs", () -> SMOOTH_DEEPSLATE.get());
    public static final DeferredBlock<WallBlock> SMOOTH_DEEPSLATE_WALL = registerWallBlock("smooth_deepslate_wall", () -> SMOOTH_DEEPSLATE.get());
    public static final DeferredBlock<FenceBlock> SMOOTH_DEEPSLATE_FENCE = registerFenceBlock("smooth_deepslate_fence", () -> SMOOTH_DEEPSLATE.get());

    public static final DeferredBlock<Block> NETHERRACK_BRICKS = registerBlockVariant("netherrack_bricks", () -> Blocks.NETHERRACK);
    public static final DeferredBlock<SlabBlock> NETHERRACK_BRICK_SLAB = registerSlabBlock("netherrack_brick_slab", () -> NETHERRACK_BRICKS.get());
    public static final DeferredBlock<StairBlock> NETHERRACK_BRICK_STAIRS = registerStairBlock("netherrack_brick_stairs", () -> NETHERRACK_BRICKS.get());
    public static final DeferredBlock<WallBlock> NETHERRACK_BRICK_WALL = registerWallBlock("netherrack_brick_wall", () -> NETHERRACK_BRICKS.get());
    public static final DeferredBlock<FenceBlock> NETHERRACK_BRICK_FENCE = registerFenceBlock("netherrack_brick_fence", () -> NETHERRACK_BRICKS.get());

    public static final DeferredBlock<Block> TERRACOTTA_BRICKS = registerBlockVariant("terracotta_bricks", () -> Blocks.TERRACOTTA);
    public static final DeferredBlock<SlabBlock> TERRACOTTA_BRICK_SLAB = registerSlabBlock("terracotta_brick_slab", () -> TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> TERRACOTTA_BRICK_STAIRS = registerStairBlock("terracotta_brick_stairs", () -> TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> TERRACOTTA_BRICK_WALL = registerWallBlock("terracotta_brick_wall", () -> TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> TERRACOTTA_BRICK_FENCE = registerFenceBlock("terracotta_brick_fence", () -> TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> WHITE_TERRACOTTA_BRICKS = registerBlockVariant("white_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.white());
    public static final DeferredBlock<SlabBlock> WHITE_TERRACOTTA_BRICK_SLAB = registerSlabBlock("white_terracotta_brick_slab", () -> WHITE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> WHITE_TERRACOTTA_BRICK_STAIRS = registerStairBlock("white_terracotta_brick_stairs", () -> WHITE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> WHITE_TERRACOTTA_BRICK_WALL = registerWallBlock("white_terracotta_brick_wall", () -> WHITE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> WHITE_TERRACOTTA_BRICK_FENCE = registerFenceBlock("white_terracotta_brick_fence", () -> WHITE_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_BRICKS = registerBlockVariant("orange_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.orange());
    public static final DeferredBlock<SlabBlock> ORANGE_TERRACOTTA_BRICK_SLAB = registerSlabBlock("orange_terracotta_brick_slab", () -> ORANGE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> ORANGE_TERRACOTTA_BRICK_STAIRS = registerStairBlock("orange_terracotta_brick_stairs", () -> ORANGE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> ORANGE_TERRACOTTA_BRICK_WALL = registerWallBlock("orange_terracotta_brick_wall", () -> ORANGE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> ORANGE_TERRACOTTA_BRICK_FENCE = registerFenceBlock("orange_terracotta_brick_fence", () -> ORANGE_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_BRICKS = registerBlockVariant("magenta_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.magenta());
    public static final DeferredBlock<SlabBlock> MAGENTA_TERRACOTTA_BRICK_SLAB = registerSlabBlock("magenta_terracotta_brick_slab", () -> MAGENTA_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> MAGENTA_TERRACOTTA_BRICK_STAIRS = registerStairBlock("magenta_terracotta_brick_stairs", () -> MAGENTA_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> MAGENTA_TERRACOTTA_BRICK_WALL = registerWallBlock("magenta_terracotta_brick_wall", () -> MAGENTA_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> MAGENTA_TERRACOTTA_BRICK_FENCE = registerFenceBlock("magenta_terracotta_brick_fence", () -> MAGENTA_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlockVariant("light_blue_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.lightBlue());
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = registerSlabBlock("light_blue_terracotta_brick_slab", () -> LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = registerStairBlock("light_blue_terracotta_brick_stairs", () -> LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = registerWallBlock("light_blue_terracotta_brick_wall", () -> LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIGHT_BLUE_TERRACOTTA_BRICK_FENCE = registerFenceBlock("light_blue_terracotta_brick_fence", () -> LIGHT_BLUE_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_BRICKS = registerBlockVariant("yellow_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.yellow());
    public static final DeferredBlock<SlabBlock> YELLOW_TERRACOTTA_BRICK_SLAB = registerSlabBlock("yellow_terracotta_brick_slab", () -> YELLOW_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> YELLOW_TERRACOTTA_BRICK_STAIRS = registerStairBlock("yellow_terracotta_brick_stairs", () -> YELLOW_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> YELLOW_TERRACOTTA_BRICK_WALL = registerWallBlock("yellow_terracotta_brick_wall", () -> YELLOW_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> YELLOW_TERRACOTTA_BRICK_FENCE = registerFenceBlock("yellow_terracotta_brick_fence", () -> YELLOW_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> LIME_TERRACOTTA_BRICKS = registerBlockVariant("lime_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.lime());
    public static final DeferredBlock<SlabBlock> LIME_TERRACOTTA_BRICK_SLAB = registerSlabBlock("lime_terracotta_brick_slab", () -> LIME_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIME_TERRACOTTA_BRICK_STAIRS = registerStairBlock("lime_terracotta_brick_stairs", () -> LIME_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIME_TERRACOTTA_BRICK_WALL = registerWallBlock("lime_terracotta_brick_wall", () -> LIME_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIME_TERRACOTTA_BRICK_FENCE = registerFenceBlock("lime_terracotta_brick_fence", () -> LIME_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> PINK_TERRACOTTA_BRICKS = registerBlockVariant("pink_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.pink());
    public static final DeferredBlock<SlabBlock> PINK_TERRACOTTA_BRICK_SLAB = registerSlabBlock("pink_terracotta_brick_slab", () -> PINK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> PINK_TERRACOTTA_BRICK_STAIRS = registerStairBlock("pink_terracotta_brick_stairs", () -> PINK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> PINK_TERRACOTTA_BRICK_WALL = registerWallBlock("pink_terracotta_brick_wall", () -> PINK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> PINK_TERRACOTTA_BRICK_FENCE = registerFenceBlock("pink_terracotta_brick_fence", () -> PINK_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> GRAY_TERRACOTTA_BRICKS = registerBlockVariant("gray_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.gray());
    public static final DeferredBlock<SlabBlock> GRAY_TERRACOTTA_BRICK_SLAB = registerSlabBlock("gray_terracotta_brick_slab", () -> GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> GRAY_TERRACOTTA_BRICK_STAIRS = registerStairBlock("gray_terracotta_brick_stairs", () -> GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> GRAY_TERRACOTTA_BRICK_WALL = registerWallBlock("gray_terracotta_brick_wall", () -> GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> GRAY_TERRACOTTA_BRICK_FENCE = registerFenceBlock("gray_terracotta_brick_fence", () -> GRAY_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlockVariant("light_gray_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.lightGray());
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = registerSlabBlock("light_gray_terracotta_brick_slab", () -> LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = registerStairBlock("light_gray_terracotta_brick_stairs", () -> LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = registerWallBlock("light_gray_terracotta_brick_wall", () -> LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIGHT_GRAY_TERRACOTTA_BRICK_FENCE = registerFenceBlock("light_gray_terracotta_brick_fence", () -> LIGHT_GRAY_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> CYAN_TERRACOTTA_BRICKS = registerBlockVariant("cyan_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.cyan());
    public static final DeferredBlock<SlabBlock> CYAN_TERRACOTTA_BRICK_SLAB = registerSlabBlock("cyan_terracotta_brick_slab", () -> CYAN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> CYAN_TERRACOTTA_BRICK_STAIRS = registerStairBlock("cyan_terracotta_brick_stairs", () -> CYAN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> CYAN_TERRACOTTA_BRICK_WALL = registerWallBlock("cyan_terracotta_brick_wall", () -> CYAN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> CYAN_TERRACOTTA_BRICK_FENCE = registerFenceBlock("cyan_terracotta_brick_fence", () -> CYAN_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_BRICKS = registerBlockVariant("purple_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.purple());
    public static final DeferredBlock<SlabBlock> PURPLE_TERRACOTTA_BRICK_SLAB = registerSlabBlock("purple_terracotta_brick_slab", () -> PURPLE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> PURPLE_TERRACOTTA_BRICK_STAIRS = registerStairBlock("purple_terracotta_brick_stairs", () -> PURPLE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> PURPLE_TERRACOTTA_BRICK_WALL = registerWallBlock("purple_terracotta_brick_wall", () -> PURPLE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> PURPLE_TERRACOTTA_BRICK_FENCE = registerFenceBlock("purple_terracotta_brick_fence", () -> PURPLE_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> BLUE_TERRACOTTA_BRICKS = registerBlockVariant("blue_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.blue());
    public static final DeferredBlock<SlabBlock> BLUE_TERRACOTTA_BRICK_SLAB = registerSlabBlock("blue_terracotta_brick_slab", () -> BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> BLUE_TERRACOTTA_BRICK_STAIRS = registerStairBlock("blue_terracotta_brick_stairs", () -> BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> BLUE_TERRACOTTA_BRICK_WALL = registerWallBlock("blue_terracotta_brick_wall", () -> BLUE_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BLUE_TERRACOTTA_BRICK_FENCE = registerFenceBlock("blue_terracotta_brick_fence", () -> BLUE_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> BROWN_TERRACOTTA_BRICKS = registerBlockVariant("brown_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.brown());
    public static final DeferredBlock<SlabBlock> BROWN_TERRACOTTA_BRICK_SLAB = registerSlabBlock("brown_terracotta_brick_slab", () -> BROWN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> BROWN_TERRACOTTA_BRICK_STAIRS = registerStairBlock("brown_terracotta_brick_stairs", () -> BROWN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> BROWN_TERRACOTTA_BRICK_WALL = registerWallBlock("brown_terracotta_brick_wall", () -> BROWN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BROWN_TERRACOTTA_BRICK_FENCE = registerFenceBlock("brown_terracotta_brick_fence", () -> BROWN_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> GREEN_TERRACOTTA_BRICKS = registerBlockVariant("green_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.green());
    public static final DeferredBlock<SlabBlock> GREEN_TERRACOTTA_BRICK_SLAB = registerSlabBlock("green_terracotta_brick_slab", () -> GREEN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> GREEN_TERRACOTTA_BRICK_STAIRS = registerStairBlock("green_terracotta_brick_stairs", () -> GREEN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> GREEN_TERRACOTTA_BRICK_WALL = registerWallBlock("green_terracotta_brick_wall", () -> GREEN_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> GREEN_TERRACOTTA_BRICK_FENCE = registerFenceBlock("green_terracotta_brick_fence", () -> GREEN_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> RED_TERRACOTTA_BRICKS = registerBlockVariant("red_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.red());
    public static final DeferredBlock<SlabBlock> RED_TERRACOTTA_BRICK_SLAB = registerSlabBlock("red_terracotta_brick_slab", () -> RED_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> RED_TERRACOTTA_BRICK_STAIRS = registerStairBlock("red_terracotta_brick_stairs", () -> RED_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> RED_TERRACOTTA_BRICK_WALL = registerWallBlock("red_terracotta_brick_wall", () -> RED_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> RED_TERRACOTTA_BRICK_FENCE = registerFenceBlock("red_terracotta_brick_fence", () -> RED_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> BLACK_TERRACOTTA_BRICKS = registerBlockVariant("black_terracotta_bricks", () -> Blocks.DYED_TERRACOTTA.black());
    public static final DeferredBlock<SlabBlock> BLACK_TERRACOTTA_BRICK_SLAB = registerSlabBlock("black_terracotta_brick_slab", () -> BLACK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<StairBlock> BLACK_TERRACOTTA_BRICK_STAIRS = registerStairBlock("black_terracotta_brick_stairs", () -> BLACK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<WallBlock> BLACK_TERRACOTTA_BRICK_WALL = registerWallBlock("black_terracotta_brick_wall", () -> BLACK_TERRACOTTA_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BLACK_TERRACOTTA_BRICK_FENCE = registerFenceBlock("black_terracotta_brick_fence", () -> BLACK_TERRACOTTA_BRICKS.get());

    public static final DeferredBlock<Block> BIG_BRICKS = registerBlockVariant("big_bricks", () -> Blocks.BRICKS);
    public static final DeferredBlock<SlabBlock> BIG_BRICK_SLAB = registerSlabBlock("big_brick_slab", () -> BIG_BRICKS.get());
    public static final DeferredBlock<StairBlock> BIG_BRICK_STAIRS = registerStairBlock("big_brick_stairs", () -> BIG_BRICKS.get());
    public static final DeferredBlock<WallBlock> BIG_BRICK_WALL = registerWallBlock("big_brick_wall", () -> BIG_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BIG_BRICK_FENCE = registerFenceBlock("big_brick_fence", () -> BIG_BRICKS.get());

    public static final DeferredBlock<Block> WHITE_CONCRETE_BRICKS = registerBlockVariant("white_concrete_bricks", () -> Blocks.CONCRETE.white());
    public static final DeferredBlock<SlabBlock> WHITE_CONCRETE_BRICK_SLAB = registerSlabBlock("white_concrete_brick_slab", () -> WHITE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> WHITE_CONCRETE_BRICK_STAIRS = registerStairBlock("white_concrete_brick_stairs", () -> WHITE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> WHITE_CONCRETE_BRICK_WALL = registerWallBlock("white_concrete_brick_wall", () -> WHITE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> WHITE_CONCRETE_BRICK_FENCE = registerFenceBlock("white_concrete_brick_fence", () -> WHITE_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> ORANGE_CONCRETE_BRICKS = registerBlockVariant("orange_concrete_bricks", () -> Blocks.CONCRETE.orange());
    public static final DeferredBlock<SlabBlock> ORANGE_CONCRETE_BRICK_SLAB = registerSlabBlock("orange_concrete_brick_slab", () -> ORANGE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> ORANGE_CONCRETE_BRICK_STAIRS = registerStairBlock("orange_concrete_brick_stairs", () -> ORANGE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> ORANGE_CONCRETE_BRICK_WALL = registerWallBlock("orange_concrete_brick_wall", () -> ORANGE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> ORANGE_CONCRETE_BRICK_FENCE = registerFenceBlock("orange_concrete_brick_fence", () -> ORANGE_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> MAGENTA_CONCRETE_BRICKS = registerBlockVariant("magenta_concrete_bricks", () -> Blocks.CONCRETE.magenta());
    public static final DeferredBlock<SlabBlock> MAGENTA_CONCRETE_BRICK_SLAB = registerSlabBlock("magenta_concrete_brick_slab", () -> MAGENTA_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> MAGENTA_CONCRETE_BRICK_STAIRS = registerStairBlock("magenta_concrete_brick_stairs", () -> MAGENTA_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> MAGENTA_CONCRETE_BRICK_WALL = registerWallBlock("magenta_concrete_brick_wall", () -> MAGENTA_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> MAGENTA_CONCRETE_BRICK_FENCE = registerFenceBlock("magenta_concrete_brick_fence", () -> MAGENTA_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_BRICKS = registerBlockVariant("light_blue_concrete_bricks", () -> Blocks.CONCRETE.lightBlue());
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_CONCRETE_BRICK_SLAB = registerSlabBlock("light_blue_concrete_brick_slab", () -> LIGHT_BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_CONCRETE_BRICK_STAIRS = registerStairBlock("light_blue_concrete_brick_stairs", () -> LIGHT_BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_CONCRETE_BRICK_WALL = registerWallBlock("light_blue_concrete_brick_wall", () -> LIGHT_BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIGHT_BLUE_CONCRETE_BRICK_FENCE = registerFenceBlock("light_blue_concrete_brick_fence", () -> LIGHT_BLUE_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> YELLOW_CONCRETE_BRICKS = registerBlockVariant("yellow_concrete_bricks", () -> Blocks.CONCRETE.yellow());
    public static final DeferredBlock<SlabBlock> YELLOW_CONCRETE_BRICK_SLAB = registerSlabBlock("yellow_concrete_brick_slab", () -> YELLOW_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> YELLOW_CONCRETE_BRICK_STAIRS = registerStairBlock("yellow_concrete_brick_stairs", () -> YELLOW_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> YELLOW_CONCRETE_BRICK_WALL = registerWallBlock("yellow_concrete_brick_wall", () -> YELLOW_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> YELLOW_CONCRETE_BRICK_FENCE = registerFenceBlock("yellow_concrete_brick_fence", () -> YELLOW_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> LIME_CONCRETE_BRICKS = registerBlockVariant("lime_concrete_bricks", () -> Blocks.CONCRETE.lime());
    public static final DeferredBlock<SlabBlock> LIME_CONCRETE_BRICK_SLAB = registerSlabBlock("lime_concrete_brick_slab", () -> LIME_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIME_CONCRETE_BRICK_STAIRS = registerStairBlock("lime_concrete_brick_stairs", () -> LIME_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIME_CONCRETE_BRICK_WALL = registerWallBlock("lime_concrete_brick_wall", () -> LIME_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIME_CONCRETE_BRICK_FENCE = registerFenceBlock("lime_concrete_brick_fence", () -> LIME_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> PINK_CONCRETE_BRICKS = registerBlockVariant("pink_concrete_bricks", () -> Blocks.CONCRETE.pink());
    public static final DeferredBlock<SlabBlock> PINK_CONCRETE_BRICK_SLAB = registerSlabBlock("pink_concrete_brick_slab", () -> PINK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> PINK_CONCRETE_BRICK_STAIRS = registerStairBlock("pink_concrete_brick_stairs", () -> PINK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> PINK_CONCRETE_BRICK_WALL = registerWallBlock("pink_concrete_brick_wall", () -> PINK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> PINK_CONCRETE_BRICK_FENCE = registerFenceBlock("pink_concrete_brick_fence", () -> PINK_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> GRAY_CONCRETE_BRICKS = registerBlockVariant("gray_concrete_bricks", () -> Blocks.CONCRETE.gray());
    public static final DeferredBlock<SlabBlock> GRAY_CONCRETE_BRICK_SLAB = registerSlabBlock("gray_concrete_brick_slab", () -> GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> GRAY_CONCRETE_BRICK_STAIRS = registerStairBlock("gray_concrete_brick_stairs", () -> GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> GRAY_CONCRETE_BRICK_WALL = registerWallBlock("gray_concrete_brick_wall", () -> GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> GRAY_CONCRETE_BRICK_FENCE = registerFenceBlock("gray_concrete_brick_fence", () -> GRAY_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_BRICKS = registerBlockVariant("light_gray_concrete_bricks", () -> Blocks.CONCRETE.lightGray());
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_CONCRETE_BRICK_SLAB = registerSlabBlock("light_gray_concrete_brick_slab", () -> LIGHT_GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_CONCRETE_BRICK_STAIRS = registerStairBlock("light_gray_concrete_brick_stairs", () -> LIGHT_GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_CONCRETE_BRICK_WALL = registerWallBlock("light_gray_concrete_brick_wall", () -> LIGHT_GRAY_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> LIGHT_GRAY_CONCRETE_BRICK_FENCE = registerFenceBlock("light_gray_concrete_brick_fence", () -> LIGHT_GRAY_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> CYAN_CONCRETE_BRICKS = registerBlockVariant("cyan_concrete_bricks", () -> Blocks.CONCRETE.cyan());
    public static final DeferredBlock<SlabBlock> CYAN_CONCRETE_BRICK_SLAB = registerSlabBlock("cyan_concrete_brick_slab", () -> CYAN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> CYAN_CONCRETE_BRICK_STAIRS = registerStairBlock("cyan_concrete_brick_stairs", () -> CYAN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> CYAN_CONCRETE_BRICK_WALL = registerWallBlock("cyan_concrete_brick_wall", () -> CYAN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> CYAN_CONCRETE_BRICK_FENCE = registerFenceBlock("cyan_concrete_brick_fence", () -> CYAN_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> PURPLE_CONCRETE_BRICKS = registerBlockVariant("purple_concrete_bricks", () -> Blocks.CONCRETE.purple());
    public static final DeferredBlock<SlabBlock> PURPLE_CONCRETE_BRICK_SLAB = registerSlabBlock("purple_concrete_brick_slab", () -> PURPLE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> PURPLE_CONCRETE_BRICK_STAIRS = registerStairBlock("purple_concrete_brick_stairs", () -> PURPLE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> PURPLE_CONCRETE_BRICK_WALL = registerWallBlock("purple_concrete_brick_wall", () -> PURPLE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> PURPLE_CONCRETE_BRICK_FENCE = registerFenceBlock("purple_concrete_brick_fence", () -> PURPLE_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> BLUE_CONCRETE_BRICKS = registerBlockVariant("blue_concrete_bricks", () -> Blocks.CONCRETE.blue());
    public static final DeferredBlock<SlabBlock> BLUE_CONCRETE_BRICK_SLAB = registerSlabBlock("blue_concrete_brick_slab", () -> BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> BLUE_CONCRETE_BRICK_STAIRS = registerStairBlock("blue_concrete_brick_stairs", () -> BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> BLUE_CONCRETE_BRICK_WALL = registerWallBlock("blue_concrete_brick_wall", () -> BLUE_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BLUE_CONCRETE_BRICK_FENCE = registerFenceBlock("blue_concrete_brick_fence", () -> BLUE_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> BROWN_CONCRETE_BRICKS = registerBlockVariant("brown_concrete_bricks", () -> Blocks.CONCRETE.brown());
    public static final DeferredBlock<SlabBlock> BROWN_CONCRETE_BRICK_SLAB = registerSlabBlock("brown_concrete_brick_slab", () -> BROWN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> BROWN_CONCRETE_BRICK_STAIRS = registerStairBlock("brown_concrete_brick_stairs", () -> BROWN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> BROWN_CONCRETE_BRICK_WALL = registerWallBlock("brown_concrete_brick_wall", () -> BROWN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BROWN_CONCRETE_BRICK_FENCE = registerFenceBlock("brown_concrete_brick_fence", () -> BROWN_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> GREEN_CONCRETE_BRICKS = registerBlockVariant("green_concrete_bricks", () -> Blocks.CONCRETE.green());
    public static final DeferredBlock<SlabBlock> GREEN_CONCRETE_BRICK_SLAB = registerSlabBlock("green_concrete_brick_slab", () -> GREEN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> GREEN_CONCRETE_BRICK_STAIRS = registerStairBlock("green_concrete_brick_stairs", () -> GREEN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> GREEN_CONCRETE_BRICK_WALL = registerWallBlock("green_concrete_brick_wall", () -> GREEN_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> GREEN_CONCRETE_BRICK_FENCE = registerFenceBlock("green_concrete_brick_fence", () -> GREEN_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> RED_CONCRETE_BRICKS = registerBlockVariant("red_concrete_bricks", () -> Blocks.CONCRETE.red());
    public static final DeferredBlock<SlabBlock> RED_CONCRETE_BRICK_SLAB = registerSlabBlock("red_concrete_brick_slab", () -> RED_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> RED_CONCRETE_BRICK_STAIRS = registerStairBlock("red_concrete_brick_stairs", () -> RED_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> RED_CONCRETE_BRICK_WALL = registerWallBlock("red_concrete_brick_wall", () -> RED_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> RED_CONCRETE_BRICK_FENCE = registerFenceBlock("red_concrete_brick_fence", () -> RED_CONCRETE_BRICKS.get());

    public static final DeferredBlock<Block> BLACK_CONCRETE_BRICKS = registerBlockVariant("black_concrete_bricks", () -> Blocks.CONCRETE.black());
    public static final DeferredBlock<SlabBlock> BLACK_CONCRETE_BRICK_SLAB = registerSlabBlock("black_concrete_brick_slab", () -> BLACK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<StairBlock> BLACK_CONCRETE_BRICK_STAIRS = registerStairBlock("black_concrete_brick_stairs", () -> BLACK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<WallBlock> BLACK_CONCRETE_BRICK_WALL = registerWallBlock("black_concrete_brick_wall", () -> BLACK_CONCRETE_BRICKS.get());
    public static final DeferredBlock<FenceBlock> BLACK_CONCRETE_BRICK_FENCE = registerFenceBlock("black_concrete_brick_fence", () -> BLACK_CONCRETE_BRICKS.get());

    public static final DeferredBlock<SlabBlock> GILDED_BLACKSTONE_SLAB = registerSlabBlock("gilded_blackstone_slab", () -> Blocks.GILDED_BLACKSTONE);
    public static final DeferredBlock<StairBlock> GILDED_BLACKSTONE_STAIRS = registerStairBlock("gilded_blackstone_stairs", () -> Blocks.GILDED_BLACKSTONE);
    public static final DeferredBlock<WallBlock> GILDED_BLACKSTONE_WALL = registerWallBlock("gilded_blackstone_wall", () -> Blocks.GILDED_BLACKSTONE);
    public static final DeferredBlock<FenceBlock> GILDED_BLACKSTONE_FENCE = registerFenceBlock("gilded_blackstone_fence", () -> Blocks.GILDED_BLACKSTONE);

    public static final DeferredBlock<TintedIronBarsBlock> TINTED_GLASS_PANE = registerTintedBarsBlock("tinted_glass_pane", () -> Blocks.TINTED_GLASS);

    public static final DeferredBlock<TransparentDoorBlock> GLASS_DOOR = registerGlassDoorBlock("glass_door", ModBlockSetTypes.GLASS, () -> Blocks.GLASS);
    public static final DeferredBlock<TintedDoorBlock> TINTED_GLASS_DOOR = registerTintedDoorBlock("tinted_glass_door", ModBlockSetTypes.TINTED_GLASS, () -> Blocks.TINTED_GLASS);

    public static final DeferredBlock<StainedDoorBlock> WHITE_STAINED_GLASS_DOOR = registerStainedDoorBlock("white_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.WHITE, () -> Blocks.STAINED_GLASS.white());
    public static final DeferredBlock<StainedDoorBlock> ORANGE_STAINED_GLASS_DOOR = registerStainedDoorBlock("orange_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.ORANGE, () -> Blocks.STAINED_GLASS.orange());
    public static final DeferredBlock<StainedDoorBlock> MAGENTA_STAINED_GLASS_DOOR = registerStainedDoorBlock("magenta_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.MAGENTA, () -> Blocks.STAINED_GLASS.magenta());
    public static final DeferredBlock<StainedDoorBlock> LIGHT_BLUE_STAINED_GLASS_DOOR = registerStainedDoorBlock("light_blue_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIGHT_BLUE, () -> Blocks.STAINED_GLASS.lightBlue());
    public static final DeferredBlock<StainedDoorBlock> YELLOW_STAINED_GLASS_DOOR = registerStainedDoorBlock("yellow_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.YELLOW, () -> Blocks.STAINED_GLASS.yellow());
    public static final DeferredBlock<StainedDoorBlock> LIME_STAINED_GLASS_DOOR = registerStainedDoorBlock("lime_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIME, () -> Blocks.STAINED_GLASS.lime());
    public static final DeferredBlock<StainedDoorBlock> PINK_STAINED_GLASS_DOOR = registerStainedDoorBlock("pink_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.PINK, () -> Blocks.STAINED_GLASS.pink());
    public static final DeferredBlock<StainedDoorBlock> GRAY_STAINED_GLASS_DOOR = registerStainedDoorBlock("gray_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.GRAY, () -> Blocks.STAINED_GLASS.gray());
    public static final DeferredBlock<StainedDoorBlock> LIGHT_GRAY_STAINED_GLASS_DOOR = registerStainedDoorBlock("light_gray_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIGHT_GRAY, () -> Blocks.STAINED_GLASS.lightGray());
    public static final DeferredBlock<StainedDoorBlock> CYAN_STAINED_GLASS_DOOR = registerStainedDoorBlock("cyan_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.CYAN, () -> Blocks.STAINED_GLASS.cyan());
    public static final DeferredBlock<StainedDoorBlock> PURPLE_STAINED_GLASS_DOOR = registerStainedDoorBlock("purple_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.PURPLE, () -> Blocks.STAINED_GLASS.purple());
    public static final DeferredBlock<StainedDoorBlock> BLUE_STAINED_GLASS_DOOR = registerStainedDoorBlock("blue_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.BLUE, () -> Blocks.STAINED_GLASS.blue());
    public static final DeferredBlock<StainedDoorBlock> BROWN_STAINED_GLASS_DOOR = registerStainedDoorBlock("brown_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.BROWN, () -> Blocks.STAINED_GLASS.brown());
    public static final DeferredBlock<StainedDoorBlock> GREEN_STAINED_GLASS_DOOR = registerStainedDoorBlock("green_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.GREEN, () -> Blocks.STAINED_GLASS.green());
    public static final DeferredBlock<StainedDoorBlock> RED_STAINED_GLASS_DOOR = registerStainedDoorBlock("red_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.RED, () -> Blocks.STAINED_GLASS.red());
    public static final DeferredBlock<StainedDoorBlock> BLACK_STAINED_GLASS_DOOR = registerStainedDoorBlock("black_stained_glass_door", ModBlockSetTypes.STAINED_GLASS, DyeColor.BLACK, () -> Blocks.STAINED_GLASS.black());

    public static final DeferredBlock<TransparentTrapdoorBlock> GLASS_TRAPDOOR = registerGlassTrapdoorBlock("glass_trapdoor", ModBlockSetTypes.GLASS, () -> Blocks.GLASS);
    public static final DeferredBlock<TintedTrapdoorBlock> TINTED_GLASS_TRAPDOOR = registerTintedTrapdoorBlock("tinted_glass_trapdoor", ModBlockSetTypes.TINTED_GLASS, () -> Blocks.TINTED_GLASS);

    public static final DeferredBlock<StainedTrapdoorBlock> WHITE_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("white_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.WHITE, () -> Blocks.STAINED_GLASS.white());
    public static final DeferredBlock<StainedTrapdoorBlock> ORANGE_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("orange_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.ORANGE, () -> Blocks.STAINED_GLASS.orange());
    public static final DeferredBlock<StainedTrapdoorBlock> MAGENTA_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("magenta_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.MAGENTA, () -> Blocks.STAINED_GLASS.magenta());
    public static final DeferredBlock<StainedTrapdoorBlock> LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("light_blue_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIGHT_BLUE, () -> Blocks.STAINED_GLASS.lightBlue());
    public static final DeferredBlock<StainedTrapdoorBlock> YELLOW_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("yellow_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.YELLOW, () -> Blocks.STAINED_GLASS.yellow());
    public static final DeferredBlock<StainedTrapdoorBlock> LIME_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("lime_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIME, () -> Blocks.STAINED_GLASS.lime());
    public static final DeferredBlock<StainedTrapdoorBlock> PINK_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("pink_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.PINK, () -> Blocks.STAINED_GLASS.pink());
    public static final DeferredBlock<StainedTrapdoorBlock> GRAY_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("gray_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.GRAY, () -> Blocks.STAINED_GLASS.gray());
    public static final DeferredBlock<StainedTrapdoorBlock> LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("light_gray_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.LIGHT_GRAY, () -> Blocks.STAINED_GLASS.lightGray());
    public static final DeferredBlock<StainedTrapdoorBlock> CYAN_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("cyan_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.CYAN, () -> Blocks.STAINED_GLASS.cyan());
    public static final DeferredBlock<StainedTrapdoorBlock> PURPLE_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("purple_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.PURPLE, () -> Blocks.STAINED_GLASS.purple());
    public static final DeferredBlock<StainedTrapdoorBlock> BLUE_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("blue_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.BLUE, () -> Blocks.STAINED_GLASS.blue());
    public static final DeferredBlock<StainedTrapdoorBlock> BROWN_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("brown_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.BROWN, () -> Blocks.STAINED_GLASS.brown());
    public static final DeferredBlock<StainedTrapdoorBlock> GREEN_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("green_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.GREEN, () -> Blocks.STAINED_GLASS.green());
    public static final DeferredBlock<StainedTrapdoorBlock> RED_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("red_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.RED, () -> Blocks.STAINED_GLASS.red());
    public static final DeferredBlock<StainedTrapdoorBlock> BLACK_STAINED_GLASS_TRAPDOOR = registerStainedTrapdoorBlock("black_stained_glass_trapdoor", ModBlockSetTypes.STAINED_GLASS, DyeColor.BLACK, () -> Blocks.STAINED_GLASS.black());

    public static final DeferredBlock<Block> CHISELED_PRISMARINE = registerBlockVariant("chiseled_prismarine", () -> Blocks.PRISMARINE);
    public static final DeferredBlock<Block> CHISELED_PRISMARINE_BRICKS = registerBlockVariant("chiseled_prismarine_bricks", () -> Blocks.PRISMARINE_BRICKS);

    public static final DeferredBlock<Block> CHISELED_ELDER_PRISMARINE = registerBlockVariant("chiseled_elder_prismarine", () -> ELDER_PRISMARINE.get());
    public static final DeferredBlock<Block> CHISELED_ELDER_PRISMARINE_BRICKS = registerBlockVariant("chiseled_elder_prismarine_bricks", () -> ELDER_PRISMARINE_BRICKS.get());

    public static final DeferredBlock<RotatedPillarBlock> LAPIS_PILLAR = registerPillarBlock("lapis_pillar", () -> Blocks.LAPIS_BLOCK);
    public static final DeferredBlock<Block> CHISELED_LAPIS = registerBlockVariant("chiseled_lapis", () -> Blocks.LAPIS_BLOCK);

    public static final DeferredBlock<ModGrateBlock> IRON_GRATE = registerRustingGrateBlock("iron_grate", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModGrateBlock> EXPOSED_IRON_GRATE = registerRustingGrateBlock("exposed_iron_grate", () -> EXPOSED_IRON.get());
    public static final DeferredBlock<ModGrateBlock> WEATHERED_IRON_GRATE = registerRustingGrateBlock("weathered_iron_grate", () -> WEATHERED_IRON.get());
    public static final DeferredBlock<ModGrateBlock> RUSTED_IRON_GRATE = registerRustingGrateBlock("rusted_iron_grate", () -> RUSTED_IRON.get());

    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_IRON_GRATE = registerGrateBlock("waxed_iron_grate", () -> WAXED_IRON_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_EXPOSED_IRON_GRATE = registerGrateBlock("waxed_exposed_iron_grate", () -> WAXED_EXPOSED_IRON.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_WEATHERED_IRON_GRATE = registerGrateBlock("waxed_weathered_iron_grate", () -> WAXED_WEATHERED_IRON.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_RUSTED_IRON_GRATE = registerGrateBlock("waxed_rusted_iron_grate", () -> WAXED_RUSTED_IRON.get());

    public static final DeferredBlock<ModGrateBlock> ZINC_GRATE = registerRustingGrateBlock("zinc_grate", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModGrateBlock> EXPOSED_ZINC_GRATE = registerRustingGrateBlock("exposed_zinc_grate", () -> EXPOSED_ZINC.get());
    public static final DeferredBlock<ModGrateBlock> WEATHERED_ZINC_GRATE = registerRustingGrateBlock("weathered_zinc_grate", () -> WEATHERED_ZINC.get());
    public static final DeferredBlock<ModGrateBlock> CORRODED_ZINC_GRATE = registerRustingGrateBlock("corroded_zinc_grate", () -> CORRODED_ZINC.get());

    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_ZINC_GRATE = registerGrateBlock("waxed_zinc_grate", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_EXPOSED_ZINC_GRATE = registerGrateBlock("waxed_exposed_zinc_grate", () -> WAXED_EXPOSED_ZINC.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_WEATHERED_ZINC_GRATE = registerGrateBlock("waxed_weathered_zinc_grate", () -> WAXED_WEATHERED_ZINC.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> WAXED_CORRODED_ZINC_GRATE = registerGrateBlock("waxed_corroded_zinc_grate", () -> WAXED_CORRODED_ZINC.get());

    public static final DeferredBlock<WaterloggedTransparentBlock> SILVER_GRATE = registerGrateBlock("silver_grate", () -> SILVER_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> TIN_GRATE = registerGrateBlock("tin_grate", () -> TIN_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> TUNGSTEN_GRATE = registerGrateBlock("tungsten_grate", () -> TUNGSTEN_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> PLATINUM_GRATE = registerGrateBlock("platinum_grate", () -> PLATINUM_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> GOLD_GRATE = registerGrateBlock("gold_grate", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<WaterloggedTransparentBlock> LEAD_GRATE = registerGrateBlock("lead_grate", () -> LEAD_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> URANIUM_GRATE = registerGrateBlock("uranium_grate", () -> URANIUM_BLOCK.get());

    public static final DeferredBlock<WaterloggedTransparentBlock> NETHERITE_GRATE = registerGrateBlock("netherite_grate", () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<WaterloggedTransparentBlock> BRONZE_GRATE = registerGrateBlock("bronze_grate", () -> BRONZE_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> BRASS_GRATE = registerGrateBlock("brass_grate", () -> BRASS_BLOCK.get());
    public static final DeferredBlock<WaterloggedTransparentBlock> STEEL_GRATE = registerGrateBlock("steel_grate", () -> STEEL_BLOCK.get());

    public static final DeferredBlock<ModBulbBlock> IRON_BULB = registerRustingBulbBlock("iron_bulb", () -> Blocks.IRON_BLOCK);
    public static final DeferredBlock<ModBulbBlock> EXPOSED_IRON_BULB = registerRustingBulbBlock("exposed_iron_bulb", () -> EXPOSED_IRON.get());
    public static final DeferredBlock<ModBulbBlock> WEATHERED_IRON_BULB = registerRustingBulbBlock("weathered_iron_bulb", () -> WEATHERED_IRON.get());
    public static final DeferredBlock<ModBulbBlock> RUSTED_IRON_BULB = registerRustingBulbBlock("rusted_iron_bulb", () -> RUSTED_IRON.get());

    public static final DeferredBlock<CopperBulbBlock> WAXED_IRON_BULB = registerBulbBlock("waxed_iron_bulb", () -> WAXED_IRON_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_EXPOSED_IRON_BULB = registerBulbBlock("waxed_exposed_iron_bulb", () -> WAXED_EXPOSED_IRON.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_WEATHERED_IRON_BULB = registerBulbBlock("waxed_weathered_iron_bulb", () -> WAXED_WEATHERED_IRON.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_RUSTED_IRON_BULB = registerBulbBlock("waxed_rusted_iron_bulb", () -> WAXED_RUSTED_IRON.get());

    public static final DeferredBlock<ModBulbBlock> ZINC_BULB = registerRustingBulbBlock("zinc_bulb", () -> ZINC_BLOCK.get());
    public static final DeferredBlock<ModBulbBlock> EXPOSED_ZINC_BULB = registerRustingBulbBlock("exposed_zinc_bulb", () -> EXPOSED_ZINC.get());
    public static final DeferredBlock<ModBulbBlock> WEATHERED_ZINC_BULB = registerRustingBulbBlock("weathered_zinc_bulb", () -> WEATHERED_ZINC.get());
    public static final DeferredBlock<ModBulbBlock> CORRODED_ZINC_BULB = registerRustingBulbBlock("corroded_zinc_bulb", () -> CORRODED_ZINC.get());

    public static final DeferredBlock<CopperBulbBlock> WAXED_ZINC_BULB = registerBulbBlock("waxed_zinc_bulb", () -> WAXED_ZINC_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_EXPOSED_ZINC_BULB = registerBulbBlock("waxed_exposed_zinc_bulb", () -> WAXED_EXPOSED_ZINC.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_WEATHERED_ZINC_BULB = registerBulbBlock("waxed_weathered_zinc_bulb", () -> WAXED_WEATHERED_ZINC.get());
    public static final DeferredBlock<CopperBulbBlock> WAXED_CORRODED_ZINC_BULB = registerBulbBlock("waxed_corroded_zinc_bulb", () -> WAXED_CORRODED_ZINC.get());

    public static final DeferredBlock<CopperBulbBlock> SILVER_BULB = registerBulbBlock("silver_bulb", () -> SILVER_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> TIN_BULB = registerBulbBlock("tin_bulb", () -> TIN_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> TUNGSTEN_BULB = registerBulbBlock("tungsten_bulb", () -> TUNGSTEN_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> PLATINUM_BULB = registerBulbBlock("platinum_bulb", () -> PLATINUM_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> GOLD_BULB = registerBulbBlock("gold_bulb", () -> Blocks.GOLD_BLOCK);
    public static final DeferredBlock<CopperBulbBlock> LEAD_BULB = registerBulbBlock("lead_bulb", () -> LEAD_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> URANIUM_BULB = registerBulbBlock("uranium_bulb", () -> URANIUM_BLOCK.get());

    public static final DeferredBlock<CopperBulbBlock> NETHERITE_BULB = registerBulbBlock("netherite_bulb", () -> Blocks.NETHERITE_BLOCK);
    public static final DeferredBlock<CopperBulbBlock> BRONZE_BULB = registerBulbBlock("bronze_bulb", () -> BRONZE_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> BRASS_BULB = registerBulbBlock("brass_bulb", () -> BRASS_BLOCK.get());
    public static final DeferredBlock<CopperBulbBlock> STEEL_BULB = registerBulbBlock("steel_bulb", () -> STEEL_BLOCK.get());

    public static final DeferredBlock<FenceBlock> SULFUR_FENCE = registerFenceBlock("sulfur_fence", () -> Blocks.SULFUR);
    public static final DeferredBlock<FenceBlock> POLISHED_SULFUR_FENCE = registerFenceBlock("polished_sulfur_fence", () -> Blocks.POLISHED_SULFUR);
    public static final DeferredBlock<FenceBlock> SULFUR_BRICK_FENCE = registerFenceBlock("sulfur_brick_fence", () -> Blocks.SULFUR_BRICKS);

    public static final DeferredBlock<FenceBlock> CINNABAR_FENCE = registerFenceBlock("cinnabar_fence", () -> Blocks.CINNABAR);
    public static final DeferredBlock<FenceBlock> POLISHED_CINNABAR_FENCE = registerFenceBlock("polished_cinnabar_fence", () -> Blocks.POLISHED_CINNABAR);
    public static final DeferredBlock<FenceBlock> CINNABAR_BRICK_FENCE = registerFenceBlock("cinnabar_brick_fence", () -> Blocks.CINNABAR_BRICKS);

    private static DeferredBlock<CraftingTableBlock> registerCraftingTable(String registryName) {
        if (registryName == "crimson_crafting_table" || registryName == "warped_crafting_table") {
            return BLOCKS.register(
                    registryName, () -> new CraftingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_crafting_table") {
            return BLOCKS.register(
                    registryName, () -> new CraftingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_crafting_table") {
            return BLOCKS.register(
                    registryName, () -> new CraftingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new CraftingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<CartographyTableBlock> registerCartographyTable(String registryName) {
        if (registryName == "crimson_cartography_table" || registryName == "warped_cartography_table") {
            return BLOCKS.register(
                    registryName, () -> new CartographyTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_cartography_table") {
            return BLOCKS.register(
                    registryName, () -> new CartographyTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_cartography_table") {
            return BLOCKS.register(
                    registryName, () -> new CartographyTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new CartographyTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<FletchingTableBlock> registerFletchingTable(String registryName) {
        if (registryName == "crimson_fletching_table" || registryName == "warped_fletching_table") {
            return BLOCKS.register(
                    registryName, () -> new FletchingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FLETCHING_TABLE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_fletching_table") {
            return BLOCKS.register(
                    registryName, () -> new FletchingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FLETCHING_TABLE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_fletching_table") {
            return BLOCKS.register(
                    registryName, () -> new FletchingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FLETCHING_TABLE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new FletchingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FLETCHING_TABLE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<BeehiveBlock> registerBeehive(String registryName) {
        if (registryName == "crimson_beehive" || registryName == "warped_beehive") {
            return BLOCKS.register(
                    registryName, () -> new BeehiveBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_beehive") {
            return BLOCKS.register(
                    registryName, () -> new BeehiveBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_beehive") {
            return BLOCKS.register(
                    registryName, () -> new BeehiveBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new BeehiveBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BEEHIVE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<BarrelBlock> registerBarrel(String registryName) {
        if (registryName == "crimson_barrel" || registryName == "warped_barrel") {
            return BLOCKS.register(
                    registryName, () -> new BarrelBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_barrel") {
            return BLOCKS.register(
                    registryName, () -> new BarrelBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_barrel") {
            return BLOCKS.register(
                    registryName, () -> new BarrelBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new BarrelBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<LecternBlock> registerLectern(String registryName) {
        if (registryName == "crimson_lectern" || registryName == "warped_lectern") {
            return BLOCKS.register(
                    registryName, () -> new LecternBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LECTERN).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_lectern") {
            return BLOCKS.register(
                    registryName, () -> new LecternBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LECTERN).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_lectern") {
            return BLOCKS.register(
                    registryName, () -> new LecternBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LECTERN).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new LecternBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LECTERN)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<ChestBlock> registerWoodenChest(String registryName) {
        if (registryName == "crimson_chest" || registryName == "warped_chest") {
            return BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityTypes.CHEST,
                            SoundEvents.CHEST_OPEN,
                            SoundEvents.CHEST_CLOSE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_chest") {
            return BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityTypes.CHEST,
                            SoundEvents.CHEST_OPEN,
                            SoundEvents.CHEST_CLOSE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_chest") {
            return BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityTypes.CHEST,
                            SoundEvents.CHEST_OPEN,
                            SoundEvents.CHEST_CLOSE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityTypes.CHEST,
                            SoundEvents.CHEST_OPEN,
                            SoundEvents.CHEST_CLOSE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<TrappedChestBlock> registerTrappedChest(String registryName) {
        if (registryName == "crimson_trapped_chest" || registryName == "warped_trapped_chest") {
            return BLOCKS.register(
                    registryName, () -> new TrappedChestBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.TRAPPED_CHEST).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_trapped_chest") {
            return BLOCKS.register(
                    registryName, () -> new TrappedChestBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.TRAPPED_CHEST).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_trapped_chest") {
            return BLOCKS.register(
                    registryName, () -> new TrappedChestBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.TRAPPED_CHEST).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new TrappedChestBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.TRAPPED_CHEST)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<SmithingTableBlock> registerSmithingTable(String registryName) {
        if (registryName == "crimson_smithing_table" || registryName == "warped_smithing_table") {
            return BLOCKS.register(
                    registryName, () -> new SmithingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_smithing_table") {
            return BLOCKS.register(
                    registryName, () -> new SmithingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_smithing_table") {
            return BLOCKS.register(
                    registryName, () -> new SmithingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new SmithingTableBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<Block> registerBookshelf(String registryName) {
        if (registryName == "crimson_bookshelf" || registryName == "warped_bookshelf") {
            return BLOCKS.register(
                    registryName, () -> new Block(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_bookshelf") {
            return BLOCKS.register(
                    registryName, () -> new Block(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_bookshelf") {
            return BLOCKS.register(
                    registryName, () -> new Block(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
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
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BOOKSHELF)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<CampfireBlock> registerCampfire(String registryName) {
        if (registryName == "crimson_campfire" || registryName == "warped_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            true,
                            1,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            true,
                            1,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            true,
                            1,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            true,
                            1,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<CampfireBlock> registerSoulCampfire(String registryName) {
        if (registryName == "crimson_soul_campfire" || registryName == "warped_soul_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            false,
                            2,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_soul_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            false,
                            2,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_soul_campfire") {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            false,
                            2,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new CampfireBlock(
                            false,
                            2,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<GrindstoneBlock> registerGrindstone(String registryName) {
        return BLOCKS.register(
                registryName, () -> new GrindstoneBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.GRINDSTONE)
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                Identifier.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<ChiseledBookShelfBlock> registerChiseledBookshelf(String registryName) {
        return BLOCKS.register(
                registryName, () -> new ChiseledBookShelfBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_BOOKSHELF)
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                Identifier.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<CrafterBlock> registerCrafter(String registryName) {
        return BLOCKS.register(
                registryName, () -> new CrafterBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                Identifier.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<FurnaceBlock> registerFurnace(String registryName) {
        if (registryName == "deepslate_furnace") {
            return BLOCKS.register(
                    registryName, () -> new FurnaceBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new FurnaceBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<DispenserBlock> registerDispenser(String registryName) {
        if (registryName == "deepslate_dispenser") {
            return BLOCKS.register(
                    registryName, () -> new DispenserBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.DISPENSER).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new DispenserBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.DISPENSER)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<ObserverBlock> registerObserver(String registryName) {
        if (registryName == "deepslate_observer") {
            return BLOCKS.register(
                    registryName, () -> new ObserverBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.OBSERVER).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new ObserverBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.OBSERVER)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<DropperBlock> registerDropper(String registryName) {
        if (registryName == "deepslate_dropper") {
            return BLOCKS.register(
                    registryName, () -> new DropperBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.DROPPER).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new DropperBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.DROPPER)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<BrewingStandBlock> registerBrewingStand(String registryName) {
        if (registryName == "deepslate_brewing_stand") {
            return BLOCKS.register(
                    registryName, () -> new BrewingStandBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BREWING_STAND).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new BrewingStandBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BREWING_STAND)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<SmokerBlock> registerSmoker(String registryName) {
        if (registryName.contains("deepslate")) {
            return BLOCKS.register(
                    registryName, () -> new SmokerBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOKER).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new SmokerBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOKER)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<BlastFurnaceBlock> registerBlastFurnace(String registryName) {
        if (registryName == "deepslate_blast_furnace") {
            return BLOCKS.register(
                    registryName, () -> new BlastFurnaceBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE).sound(SoundType.DEEPSLATE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new BlastFurnaceBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<LoomBlock> registerLoom(String registryName) {
        if (registryName == "crimson_loom" || registryName == "warped_loom") {
            return BLOCKS.register(
                    registryName, () -> new LoomBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LOOM).sound(SoundType.NETHER_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "cherry_loom") {
            return BLOCKS.register(
                    registryName, () -> new LoomBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LOOM).sound(SoundType.CHERRY_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else if (registryName == "bamboo_loom") {
            return BLOCKS.register(
                    registryName, () -> new LoomBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LOOM).sound(SoundType.BAMBOO_WOOD)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    Identifier.fromNamespaceAndPath(
                                                            BuildersParadise.MODID,
                                                            registryName
                                                    )
                                            )
                                    )
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new LoomBlock(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LOOM)
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
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

    private static DeferredBlock<NukeBlock> registerNuke(String registryName) {
        return BLOCKS.register(
                registryName, () -> new NukeBlock(
                        BlockBehaviour.Properties.ofFullCopy(Blocks.TNT)
                                .setId(
                                        ResourceKey.create(
                                                Registries.BLOCK,
                                                Identifier.fromNamespaceAndPath(
                                                        BuildersParadise.MODID,
                                                        registryName
                                                )
                                        )
                                )
                )
        );
    }

    private static DeferredBlock<ModLiquidBlock> registerLiquid(String registryName, Supplier<FlowingFluid> fluid) {
        return BLOCKS.register(
                registryName, () -> new ModLiquidBlock(
                        fluid.get(),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)
                                .noCollision()
                                .noLootTable()
                                .liquid()
                                .pushReaction(PushReaction.DESTROY)
                                .replaceable()
                                .setId(
                                    ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                    )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<WeatheringCopperPressurePlateBlock> registerOxidizingPressurePlate(String registryName, int maxWeight, BlockSetType type, WeatheringCopper.WeatherState weatherState, Supplier<Block> baseBlock) {
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
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ModPressurePlateBlock> registerRustingWeightedPressurePlate(String registryName, int maxWeight, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModPressurePlateBlock(
                        maxWeight,
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ModTrapdoorBlock> registerRustingTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<TransparentTrapdoorBlock> registerGlassTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new TransparentTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<TintedTrapdoorBlock> registerTintedTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new TintedTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<StainedTrapdoorBlock> registerStainedTrapdoorBlock(String registryName, BlockSetType type, DyeColor dyeColor, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new StainedTrapdoorBlock(
                        type,
                        dyeColor,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<TransparentDoorBlock> registerGlassDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new TransparentDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<TintedDoorBlock> registerTintedDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new TintedDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<StainedDoorBlock> registerStainedDoorBlock(String registryName, BlockSetType type, DyeColor dyeColor, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new StainedDoorBlock(
                        type,
                        dyeColor,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ModIronBarsBlock> registerRustingBarsBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModIronBarsBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<IronBarsBlock> registerBarsBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IronBarsBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<TintedIronBarsBlock> registerTintedBarsBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new TintedIronBarsBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ModDoorBlock> registerRustingDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<KeyOnlyDoorBlock> registerLockableDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new KeyOnlyDoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).strength(50.0F, 1200.0F)
                )
        );
    }

    private static DeferredBlock<KeyOnlyTrapdoorBlock> registerLockableTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new KeyOnlyTrapdoorBlock(
                        type,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).strength(50.0F, 1200.0F)
                )
        );
    }

    private static DeferredBlock<DoorBlock> registerDoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
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
                                            Identifier.fromNamespaceAndPath(
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

    private static DeferredBlock<TrapDoorBlock> registerTrapdoorBlock(String registryName, BlockSetType type, Supplier<Block> baseBlock) {
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
                                            Identifier.fromNamespaceAndPath(
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

    private static DeferredBlock<ModChainBlock> registerRustingChainBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModChainBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ChainBlock> registerChainBlock(String registryName, Supplier<Block> baseBlock) {
        if (registryName.contains("netherite")) {
            return BLOCKS.register(
                    registryName, () -> new ChainBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).strength(50.0F, 1200.0F)
                    )
            );
        } else if (registryName.contains("tungsten")) {
            return BLOCKS.register(
                    registryName, () -> new ChainBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).strength(45.0F, 2000.0F)
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new ChainBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
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

    private static DeferredBlock<ModBlock> registerRustingBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ModBlock> registerRustingBlock(String registryName, Supplier<Block> baseBlock, MapColor mapColor) {
        return BLOCKS.register(
                registryName, () -> new ModBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks().mapColor(mapColor)
                )
        );
    }

    private static DeferredBlock<ModSlabBlock> registerRustingSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).randomTicks()
                )
        );
    }

    private static DeferredBlock<ModStairBlock> registerRustingStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
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
                                            Identifier.fromNamespaceAndPath(
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
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).strength(50.0F, 1200.0F)
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
                                                Identifier.fromNamespaceAndPath(
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
                                                Identifier.fromNamespaceAndPath(
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
                                                Identifier.fromNamespaceAndPath(
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
                                            Identifier.fromNamespaceAndPath(
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

    private static DeferredBlock<Block> registerBlockVariant(String registryName, Supplier<Block> baseBlock, MapColor mapColor) {
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
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).mapColor(mapColor)
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
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).mapColor(mapColor)
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
                                            Identifier.fromNamespaceAndPath(
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
                                            Identifier.fromNamespaceAndPath(
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

    private static DeferredBlock<IceBlock> registerIceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<IceWallBlock> registerIceWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IceWallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<IceFenceBlock> registerIceFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IceFenceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<IceSlabBlock> registerIceSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IceSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<IceStairBlock> registerIceStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new IceStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<AmethystBlock> registerAmethystBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new AmethystBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<AmethystSlabBlock> registerAmethystSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new AmethystSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<AmethystStairBlock> registerAmethystStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new AmethystStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<CryingObsidianBlock> registerCOBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new CryingObsidianBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<CryingObsidianSlabBlock> registerCOSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new CryingObsidianSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<CryingObsidianStairBlock> registerCOStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new CryingObsidianStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<CryingObsidianWallBlock> registerCOWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new CryingObsidianWallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<CryingObsidianFenceBlock> registerCOFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new CryingObsidianFenceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<PumiceBlock> registerPumiceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PumiceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<PumiceSlabBlock> registerPumiceSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PumiceSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<PumiceStairBlock> registerPumiceStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PumiceStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<PumiceWallBlock> registerPumiceWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PumiceWallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<PumiceFenceBlock> registerPumiceFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new PumiceFenceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<WallBlock> registerWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new WallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
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
                                        Identifier.fromNamespaceAndPath(
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
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<FenceBlock> registerFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new FenceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<RotatedPillarBlock> registerPillarBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new RotatedPillarBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ModGrateBlock> registerRustingGrateBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModGrateBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).sound(SoundType.COPPER_GRATE).noOcclusion()
                )
        );
    }

    private static DeferredBlock<WaterloggedTransparentBlock> registerGrateBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new WaterloggedTransparentBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        ).sound(SoundType.COPPER_GRATE).noOcclusion()
                )
        );
    }

    private static DeferredBlock<ModBulbBlock> registerRustingBulbBlock(String registryName, Supplier<Block> baseBlock) {
        if (registryName.contains("exposed")) {
            return BLOCKS.register(
                    registryName, () -> new ModBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(12))
                    )
            );
        } else if (registryName.contains("weathered")) {
            return BLOCKS.register(
                    registryName, () -> new ModBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(8))
                    )
            );
        } else if (registryName.contains("rusted") || registryName.contains("corroded")) {
            return BLOCKS.register(
                    registryName, () -> new ModBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(4))
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new ModBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(15))
                    )
            );
        }
    }

    private static DeferredBlock<CopperBulbBlock> registerBulbBlock(String registryName, Supplier<Block> baseBlock) {
        if (registryName.contains("exposed")) {
            return BLOCKS.register(
                    registryName, () -> new CopperBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(12))
                    )
            );
        } else if (registryName.contains("weathered")) {
            return BLOCKS.register(
                    registryName, () -> new CopperBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(8))
                    )
            );
        } else if (registryName.contains("rusted") || registryName.contains("corroded")) {
            return BLOCKS.register(
                    registryName, () -> new CopperBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(4))
                    )
            );
        } else {
            return BLOCKS.register(
                    registryName, () -> new CopperBulbBlock(
                            BlockBehaviour.Properties.ofFullCopy(
                                    baseBlock.get()
                            ).setId(
                                    ResourceKey.create(
                                            Registries.BLOCK,
                                            Identifier.fromNamespaceAndPath(
                                                    BuildersParadise.MODID,
                                                    registryName
                                            )
                                    )
                            ).sound(SoundType.COPPER_BULB).lightLevel(litBlockEmission(15))
                    )
            );
        }
    }

    private static DeferredBlock<TorchBlock> registerTorchBlock(String registryName, Supplier<SimpleParticleType> particleType){
        return BLOCKS.register(
                registryName, () -> new TorchBlock(
                        particleType.get(),
                        BlockBehaviour.Properties.ofFullCopy(
                                Blocks.TORCH
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<WallTorchBlock> registerWallTorchBlock(String registryName, Supplier<SimpleParticleType> particleType, Supplier<Block> groundTorch){
        return BLOCKS.register(
                registryName, () -> new WallTorchBlock(
                        particleType.get(),
                        wallVariant(groundTorch.get(), true).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<LanternBlock> registerLanternBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new LanternBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ModLanternBlock> registerRustingLanternBlock(String registryName, Supplier<Block> baseBlock) {
        return BLOCKS.register(
                registryName, () -> new ModLanternBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<WeatheringLanternBlock> registerOxidizingLanternBlock(String registryName, Supplier<Block> baseBlock, WeatheringCopper.WeatherState weatherState) {
        return BLOCKS.register(
                registryName, () -> new WeatheringLanternBlock(
                        weatherState,
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static BlockBehaviour.Properties wallVariant(Block baseBlock, boolean overrideDescription) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(baseBlock.getLootTable());
        if (overrideDescription) {
            blockbehaviour$properties = blockbehaviour$properties.overrideDescription(baseBlock.getDescriptionId());
        }

        return blockbehaviour$properties;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightEmission) {
        return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? lightEmission : 0;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
