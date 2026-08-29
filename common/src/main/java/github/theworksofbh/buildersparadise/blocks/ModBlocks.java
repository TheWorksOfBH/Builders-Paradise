package github.theworksofbh.buildersparadise.blocks;

import github.theworksofbh.buildersparadise.blocks.collections.RustingIronCollection;
import github.theworksofbh.buildersparadise.blocks.types.*;
import github.theworksofbh.buildersparadise.id.ModBlockIds;
import github.theworksofbh.buildersparadise.id.ModBlockItemIds;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {

    // Vanilla block family completion

    public static final Block STONE_WALL = register(ModBlockItemIds.STONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).forceSolidOn());
    public static final Block STONE_FENCE = register(ModBlockItemIds.STONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).forceSolidOn());
    public static final Block COBBLESTONE_FENCE = register(ModBlockItemIds.COBBLESTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).forceSolidOn());
    public static final Block MOSSY_COBBLESTONE_FENCE = register(ModBlockItemIds.MOSSY_COBBLESTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).forceSolidOn());
    public static final Block SMOOTH_STONE_STAIRS = register(ModBlockItemIds.SMOOTH_STONE_STAIRS, properties -> new StairBlock(Blocks.SMOOTH_STONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).forceSolidOn());
    public static final Block SMOOTH_STONE_WALL = register(ModBlockItemIds.SMOOTH_STONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).forceSolidOn());
    public static final Block SMOOTH_STONE_FENCE = register(ModBlockItemIds.SMOOTH_STONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE).forceSolidOn());
    public static final Block STONE_BRICK_FENCE = register(ModBlockItemIds.STONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).forceSolidOn());
    public static final Block MOSSY_STONE_BRICK_FENCE = register(ModBlockItemIds.MOSSY_STONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS).forceSolidOn());
    public static final Block GRANITE_FENCE = register(ModBlockItemIds.GRANITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).forceSolidOn());
    public static final Block POLISHED_GRANITE_WALL = register(ModBlockItemIds.POLISHED_GRANITE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE).forceSolidOn());
    public static final Block POLISHED_GRANITE_FENCE = register(ModBlockItemIds.POLISHED_GRANITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE).forceSolidOn());
    public static final Block DIORITE_FENCE = register(ModBlockItemIds.DIORITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).forceSolidOn());
    public static final Block POLISHED_DIORITE_WALL = register(ModBlockItemIds.POLISHED_DIORITE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE).forceSolidOn());
    public static final Block POLISHED_DIORITE_FENCE = register(ModBlockItemIds.POLISHED_DIORITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE).forceSolidOn());
    public static final Block ANDESITE_FENCE = register(ModBlockItemIds.ANDESITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).forceSolidOn());
    public static final Block POLISHED_ANDESITE_WALL = register(ModBlockItemIds.POLISHED_ANDESITE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE).forceSolidOn());
    public static final Block POLISHED_ANDESITE_FENCE = register(ModBlockItemIds.POLISHED_ANDESITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE).forceSolidOn());
    public static final Block COBBLED_DEEPSLATE_FENCE = register(ModBlockItemIds.COBBLED_DEEPSLATE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).forceSolidOn());
    public static final Block POLISHED_DEEPSLATE_FENCE = register(ModBlockItemIds.POLISHED_DEEPSLATE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).forceSolidOn());
    public static final Block DEEPSLATE_BRICK_FENCE = register(ModBlockItemIds.DEEPSLATE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).forceSolidOn());
    public static final Block DEEPSLATE_TILE_FENCE = register(ModBlockItemIds.DEEPSLATE_TILE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_TILES).forceSolidOn());
    public static final Block TUFF_FENCE = register(ModBlockItemIds.TUFF_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).forceSolidOn());
    public static final Block POLISHED_TUFF_FENCE = register(ModBlockItemIds.POLISHED_TUFF_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_TUFF).forceSolidOn());
    public static final Block TUFF_BRICK_FENCE = register(ModBlockItemIds.TUFF_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS).forceSolidOn());
    public static final Block BRICK_FENCE = register(ModBlockItemIds.BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).forceSolidOn());
    public static final Block MUD_BRICK_FENCE = register(ModBlockItemIds.MUD_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).forceSolidOn());
    public static final Block RESIN_BRICK_FENCE = register(ModBlockItemIds.RESIN_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BRICKS).forceSolidOn());
    public static final Block SANDSTONE_FENCE = register(ModBlockItemIds.SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).forceSolidOn());
    public static final Block SMOOTH_SANDSTONE_WALL = register(ModBlockItemIds.SMOOTH_SANDSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE).forceSolidOn());
    public static final Block SMOOTH_SANDSTONE_FENCE = register(ModBlockItemIds.SMOOTH_SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE).forceSolidOn());
    public static final Block CUT_SANDSTONE_STAIRS = register(ModBlockItemIds.CUT_SANDSTONE_STAIRS, properties -> new StairBlock(Blocks.CUT_SANDSTONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).forceSolidOn());
    public static final Block CUT_SANDSTONE_WALL = register(ModBlockItemIds.CUT_SANDSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).forceSolidOn());
    public static final Block CUT_SANDSTONE_FENCE = register(ModBlockItemIds.CUT_SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).forceSolidOn());
    public static final Block RED_SANDSTONE_FENCE = register(ModBlockItemIds.RED_SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).forceSolidOn());
    public static final Block SMOOTH_RED_SANDSTONE_WALL = register(ModBlockItemIds.SMOOTH_RED_SANDSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_RED_SANDSTONE).forceSolidOn());
    public static final Block SMOOTH_RED_SANDSTONE_FENCE = register(ModBlockItemIds.SMOOTH_RED_SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_RED_SANDSTONE).forceSolidOn());
    public static final Block CUT_RED_SANDSTONE_STAIRS = register(ModBlockItemIds.CUT_RED_SANDSTONE_STAIRS, properties -> new StairBlock(Blocks.CUT_RED_SANDSTONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_RED_SANDSTONE).forceSolidOn());
    public static final Block CUT_RED_SANDSTONE_WALL = register(ModBlockItemIds.CUT_RED_SANDSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_RED_SANDSTONE).forceSolidOn());
    public static final Block CUT_RED_SANDSTONE_FENCE = register(ModBlockItemIds.CUT_RED_SANDSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_RED_SANDSTONE).forceSolidOn());
    public static final Block CINNABAR_FENCE = register(ModBlockItemIds.CINNABAR_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CINNABAR).forceSolidOn());
    public static final Block POLISHED_CINNABAR_FENCE = register(ModBlockItemIds.POLISHED_CINNABAR_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_CINNABAR).forceSolidOn());
    public static final Block CINNABAR_BRICK_FENCE = register(ModBlockItemIds.CINNABAR_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CINNABAR_BRICKS).forceSolidOn());
    public static final Block SULFUR_FENCE = register(ModBlockItemIds.SULFUR_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SULFUR).forceSolidOn());
    public static final Block POLISHED_SULFUR_FENCE = register(ModBlockItemIds.POLISHED_SULFUR_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_SULFUR).forceSolidOn());
    public static final Block SULFUR_BRICK_FENCE = register(ModBlockItemIds.SULFUR_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SULFUR_BRICKS).forceSolidOn());
    public static final Block PRISMARINE_FENCE = register(ModBlockItemIds.PRISMARINE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE).forceSolidOn());
    public static final Block PRISMARINE_BRICK_WALL = register(ModBlockItemIds.PRISMARINE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS).forceSolidOn());
    public static final Block PRISMARINE_BRICK_FENCE = register(ModBlockItemIds.PRISMARINE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS).forceSolidOn());
    public static final Block DARK_PRISMARINE_WALL = register(ModBlockItemIds.DARK_PRISMARINE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE).forceSolidOn());
    public static final Block DARK_PRISMARINE_FENCE = register(ModBlockItemIds.DARK_PRISMARINE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_PRISMARINE).forceSolidOn());
    public static final Block RED_NETHER_BRICK_FENCE = register(ModBlockItemIds.RED_NETHER_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_NETHER_BRICKS).forceSolidOn());
    public static final Block BLACKSTONE_FENCE = register(ModBlockItemIds.BLACKSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).forceSolidOn());
    public static final Block POLISHED_BLACKSTONE_FENCE = register(ModBlockItemIds.POLISHED_BLACKSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE).forceSolidOn());
    public static final Block POLISHED_BLACKSTONE_BRICK_FENCE = register(ModBlockItemIds.POLISHED_BLACKSTONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS).forceSolidOn());
    public static final Block END_STONE_BRICK_FENCE = register(ModBlockItemIds.END_STONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS).forceSolidOn());
    public static final Block PURPUR_WALL = register(ModBlockItemIds.PURPUR_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK).forceSolidOn());
    public static final Block PURPUR_FENCE = register(ModBlockItemIds.PURPUR_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK).forceSolidOn());
    public static final Block QUARTZ_WALL = register(ModBlockItemIds.QUARTZ_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).forceSolidOn());
    public static final Block QUARTZ_FENCE = register(ModBlockItemIds.QUARTZ_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).forceSolidOn());
    public static final Block SMOOTH_QUARTZ_WALL = register(ModBlockItemIds.SMOOTH_QUARTZ_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).forceSolidOn());
    public static final Block SMOOTH_QUARTZ_FENCE = register(ModBlockItemIds.SMOOTH_QUARTZ_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).forceSolidOn());

    // New quasi-blocks based entirely on vanilla blocks

    public static final Block CRACKED_STONE_BRICK_STAIRS = register(ModBlockItemIds.CRACKED_STONE_BRICK_STAIRS, properties -> new StairBlock(Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_STONE_BRICK_SLAB = register(ModBlockItemIds.CRACKED_STONE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_STONE_BRICK_WALL = register(ModBlockItemIds.CRACKED_STONE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_STONE_BRICK_FENCE = register(ModBlockItemIds.CRACKED_STONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS).forceSolidOn());
    public static final Block DEEPSLATE_STAIRS = register(ModBlockItemIds.DEEPSLATE_STAIRS, properties -> new StairBlock(Blocks.DEEPSLATE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).forceSolidOn());
    public static final Block DEEPSLATE_SLAB = register(ModBlockItemIds.DEEPSLATE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).forceSolidOn());
    public static final Block DEEPSLATE_WALL = register(ModBlockItemIds.DEEPSLATE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).forceSolidOn());
    public static final Block DEEPSLATE_FENCE = register(ModBlockItemIds.DEEPSLATE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_BRICK_STAIRS = register(ModBlockItemIds.CRACKED_DEEPSLATE_BRICK_STAIRS, properties -> new StairBlock(Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_BRICK_SLAB = register(ModBlockItemIds.CRACKED_DEEPSLATE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_BRICK_WALL = register(ModBlockItemIds.CRACKED_DEEPSLATE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_BRICK_FENCE = register(ModBlockItemIds.CRACKED_DEEPSLATE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_BRICKS).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_TILE_STAIRS = register(ModBlockItemIds.CRACKED_DEEPSLATE_TILE_STAIRS, properties -> new StairBlock(Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_TILES).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_TILE_SLAB = register(ModBlockItemIds.CRACKED_DEEPSLATE_TILE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_TILES).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_TILE_WALL = register(ModBlockItemIds.CRACKED_DEEPSLATE_TILE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_TILES).forceSolidOn());
    public static final Block CRACKED_DEEPSLATE_TILE_FENCE = register(ModBlockItemIds.CRACKED_DEEPSLATE_TILE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_DEEPSLATE_TILES).forceSolidOn());
    public static final Block CALCITE_STAIRS = register(ModBlockItemIds.CALCITE_STAIRS, properties -> new StairBlock(Blocks.CALCITE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).forceSolidOn());
    public static final Block CALCITE_SLAB = register(ModBlockItemIds.CALCITE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).forceSolidOn());
    public static final Block CALCITE_WALL = register(ModBlockItemIds.CALCITE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).forceSolidOn());
    public static final Block CALCITE_FENCE = register(ModBlockItemIds.CALCITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).forceSolidOn());
    public static final Block DRIPSTONE_STAIRS = register(ModBlockItemIds.DRIPSTONE_STAIRS, properties -> new StairBlock(Blocks.DRIPSTONE_BLOCK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).forceSolidOn());
    public static final Block DRIPSTONE_SLAB = register(ModBlockItemIds.DRIPSTONE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).forceSolidOn());
    public static final Block DRIPSTONE_WALL = register(ModBlockItemIds.DRIPSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).forceSolidOn());
    public static final Block DRIPSTONE_FENCE = register(ModBlockItemIds.DRIPSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).forceSolidOn());
    public static final Block PACKED_MUD_STAIRS = register(ModBlockItemIds.PACKED_MUD_STAIRS, properties -> new StairBlock(Blocks.PACKED_MUD.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).forceSolidOn());
    public static final Block PACKED_MUD_SLAB = register(ModBlockItemIds.PACKED_MUD_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).forceSolidOn());
    public static final Block PACKED_MUD_WALL = register(ModBlockItemIds.PACKED_MUD_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).forceSolidOn());
    public static final Block PACKED_MUD_FENCE = register(ModBlockItemIds.PACKED_MUD_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).forceSolidOn());
    public static final Block RESIN_STAIRS = register(ModBlockItemIds.RESIN_STAIRS, properties -> new StairBlock(Blocks.RESIN_BLOCK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BLOCK).forceSolidOn());
    public static final Block RESIN_SLAB = register(ModBlockItemIds.RESIN_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BLOCK).forceSolidOn());
    public static final Block RESIN_WALL = register(ModBlockItemIds.RESIN_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BLOCK).forceSolidOn());
    public static final Block RESIN_FENCE = register(ModBlockItemIds.RESIN_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BLOCK).forceSolidOn());
    public static final Block SCULK_STAIRS = register(ModBlockItemIds.SCULK_STAIRS, properties -> new StairBlock(Blocks.SCULK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK).forceSolidOn());
    public static final Block SCULK_SLAB = register(ModBlockItemIds.SCULK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK).forceSolidOn());
    public static final Block SCULK_WALL = register(ModBlockItemIds.SCULK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK).forceSolidOn());
    public static final Block SCULK_FENCE = register(ModBlockItemIds.SCULK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCULK).forceSolidOn());
    public static final Block SNOW_STAIRS = register(ModBlockItemIds.SNOW_STAIRS, properties -> new StairBlock(Blocks.SNOW_BLOCK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).forceSolidOn());
    public static final Block SNOW_SLAB = register(ModBlockItemIds.SNOW_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).forceSolidOn());
    public static final Block SNOW_WALL = register(ModBlockItemIds.SNOW_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).forceSolidOn());
    public static final Block SNOW_FENCE = register(ModBlockItemIds.SNOW_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK).forceSolidOn());
    public static final Block ICE_STAIRS = register(ModBlockItemIds.ICE_STAIRS, properties -> new IceStairBlock(Blocks.ICE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).forceSolidOn());
    public static final Block ICE_SLAB = register(ModBlockItemIds.ICE_SLAB, IceSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).forceSolidOn());
    public static final Block ICE_WALL = register(ModBlockItemIds.ICE_WALL, IceWallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).forceSolidOn());
    public static final Block ICE_FENCE = register(ModBlockItemIds.ICE_FENCE, IceFenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).forceSolidOn());
    public static final Block PACKED_ICE_STAIRS = register(ModBlockItemIds.PACKED_ICE_STAIRS, properties -> new StairBlock(Blocks.PACKED_ICE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).forceSolidOn());
    public static final Block PACKED_ICE_SLAB = register(ModBlockItemIds.PACKED_ICE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).forceSolidOn());
    public static final Block PACKED_ICE_WALL = register(ModBlockItemIds.PACKED_ICE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).forceSolidOn());
    public static final Block PACKED_ICE_FENCE = register(ModBlockItemIds.PACKED_ICE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).forceSolidOn());
    public static final Block BLUE_ICE_STAIRS = register(ModBlockItemIds.BLUE_ICE_STAIRS, properties -> new StairBlock(Blocks.BLUE_ICE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE).forceSolidOn());
    public static final Block BLUE_ICE_SLAB = register(ModBlockItemIds.BLUE_ICE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE).forceSolidOn());
    public static final Block BLUE_ICE_WALL = register(ModBlockItemIds.BLUE_ICE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE).forceSolidOn());
    public static final Block BLUE_ICE_FENCE = register(ModBlockItemIds.BLUE_ICE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE).forceSolidOn());
    public static final Block NETHERRACK_STAIRS = register(ModBlockItemIds.NETHERRACK_STAIRS, properties -> new StairBlock(Blocks.NETHERRACK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).forceSolidOn());
    public static final Block NETHERRACK_SLAB = register(ModBlockItemIds.NETHERRACK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).forceSolidOn());
    public static final Block NETHERRACK_WALL = register(ModBlockItemIds.NETHERRACK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).forceSolidOn());
    public static final Block NETHERRACK_FENCE = register(ModBlockItemIds.NETHERRACK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).forceSolidOn());
    public static final Block BASALT_STAIRS = register(ModBlockItemIds.BASALT_STAIRS, properties -> new StairBlock(Blocks.BASALT.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).forceSolidOn());
    public static final Block BASALT_SLAB = register(ModBlockItemIds.BASALT_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).forceSolidOn());
    public static final Block BASALT_WALL = register(ModBlockItemIds.BASALT_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).forceSolidOn());
    public static final Block BASALT_FENCE = register(ModBlockItemIds.BASALT_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).forceSolidOn());
    public static final Block SMOOTH_BASALT_STAIRS = register(ModBlockItemIds.SMOOTH_BASALT_STAIRS, properties -> new StairBlock(Blocks.SMOOTH_BASALT.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_BASALT).forceSolidOn());
    public static final Block SMOOTH_BASALT_SLAB = register(ModBlockItemIds.SMOOTH_BASALT_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_BASALT).forceSolidOn());
    public static final Block SMOOTH_BASALT_WALL = register(ModBlockItemIds.SMOOTH_BASALT_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_BASALT).forceSolidOn());
    public static final Block SMOOTH_BASALT_FENCE = register(ModBlockItemIds.SMOOTH_BASALT_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_BASALT).forceSolidOn());
    public static final Block POLISHED_BASALT_STAIRS = register(ModBlockItemIds.POLISHED_BASALT_STAIRS, properties -> new StairBlock(Blocks.POLISHED_BASALT.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT).forceSolidOn());
    public static final Block POLISHED_BASALT_SLAB = register(ModBlockItemIds.POLISHED_BASALT_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT).forceSolidOn());
    public static final Block POLISHED_BASALT_WALL = register(ModBlockItemIds.POLISHED_BASALT_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT).forceSolidOn());
    public static final Block POLISHED_BASALT_FENCE = register(ModBlockItemIds.POLISHED_BASALT_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT).forceSolidOn());
    public static final Block CRACKED_NETHER_BRICK_STAIRS = register(ModBlockItemIds.CRACKED_NETHER_BRICK_STAIRS, properties -> new StairBlock(Blocks.CRACKED_NETHER_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_NETHER_BRICKS).forceSolidOn());
    public static final Block CRACKED_NETHER_BRICK_SLAB = register(ModBlockItemIds.CRACKED_NETHER_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_NETHER_BRICKS).forceSolidOn());
    public static final Block CRACKED_NETHER_BRICK_WALL = register(ModBlockItemIds.CRACKED_NETHER_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_NETHER_BRICKS).forceSolidOn());
    public static final Block CRACKED_NETHER_BRICK_FENCE = register(ModBlockItemIds.CRACKED_NETHER_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_NETHER_BRICKS).forceSolidOn());
    public static final Block GILDED_BLACKSTONE_STAIRS = register(ModBlockItemIds.GILDED_BLACKSTONE_STAIRS, properties -> new StairBlock(Blocks.GILDED_BLACKSTONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).forceSolidOn());
    public static final Block GILDED_BLACKSTONE_SLAB = register(ModBlockItemIds.GILDED_BLACKSTONE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).forceSolidOn());
    public static final Block GILDED_BLACKSTONE_WALL = register(ModBlockItemIds.GILDED_BLACKSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).forceSolidOn());
    public static final Block GILDED_BLACKSTONE_FENCE = register(ModBlockItemIds.GILDED_BLACKSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).forceSolidOn());
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = register(ModBlockItemIds.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, properties -> new StairBlock(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = register(ModBlockItemIds.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = register(ModBlockItemIds.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).forceSolidOn());
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE = register(ModBlockItemIds.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).forceSolidOn());
    public static final Block END_STONE_STAIRS = register(ModBlockItemIds.END_STONE_STAIRS, properties -> new StairBlock(Blocks.END_STONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).forceSolidOn());
    public static final Block END_STONE_SLAB = register(ModBlockItemIds.END_STONE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).forceSolidOn());
    public static final Block END_STONE_WALL = register(ModBlockItemIds.END_STONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).forceSolidOn());
    public static final Block END_STONE_FENCE = register(ModBlockItemIds.END_STONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).forceSolidOn());
    public static final Block OBSIDIAN_STAIRS = register(ModBlockItemIds.OBSIDIAN_STAIRS, properties -> new StairBlock(Blocks.OBSIDIAN.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).forceSolidOn());
    public static final Block OBSIDIAN_SLAB = register(ModBlockItemIds.OBSIDIAN_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).forceSolidOn());
    public static final Block OBSIDIAN_WALL = register(ModBlockItemIds.OBSIDIAN_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).forceSolidOn());
    public static final Block OBSIDIAN_FENCE = register(ModBlockItemIds.OBSIDIAN_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).forceSolidOn());
    public static final Block CRYING_OBSIDIAN_STAIRS = register(ModBlockItemIds.CRYING_OBSIDIAN_STAIRS, properties -> new CryingObsidianStairBlock(Blocks.CRYING_OBSIDIAN.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).forceSolidOn());
    public static final Block CRYING_OBSIDIAN_SLAB = register(ModBlockItemIds.CRYING_OBSIDIAN_SLAB, CryingObsidianSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).forceSolidOn());
    public static final Block CRYING_OBSIDIAN_WALL = register(ModBlockItemIds.CRYING_OBSIDIAN_WALL, CryingObsidianWallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).forceSolidOn());
    public static final Block CRYING_OBSIDIAN_FENCE = register(ModBlockItemIds.CRYING_OBSIDIAN_FENCE, CryingObsidianFenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRYING_OBSIDIAN).forceSolidOn());
    public static final Block COAL_STAIRS = register(ModBlockItemIds.COAL_STAIRS, properties -> new StairBlock(Blocks.COAL_BLOCK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).forceSolidOn());
    public static final Block COAL_SLAB = register(ModBlockItemIds.COAL_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).forceSolidOn());
    public static final Block COAL_WALL = register(ModBlockItemIds.COAL_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).forceSolidOn());
    public static final Block COAL_FENCE = register(ModBlockItemIds.COAL_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).forceSolidOn());
    public static final Block LAPIS_STAIRS = register(ModBlockItemIds.LAPIS_STAIRS, properties -> new StairBlock(Blocks.LAPIS_BLOCK.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).forceSolidOn());
    public static final Block LAPIS_SLAB = register(ModBlockItemIds.LAPIS_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).forceSolidOn());
    public static final Block LAPIS_WALL = register(ModBlockItemIds.LAPIS_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).forceSolidOn());
    public static final Block LAPIS_FENCE = register(ModBlockItemIds.LAPIS_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).forceSolidOn());
    public static final Block QUARTZ_BRICK_STAIRS = register(ModBlockItemIds.QUARTZ_BRICK_STAIRS, properties -> new StairBlock(Blocks.QUARTZ_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).forceSolidOn());
    public static final Block QUARTZ_BRICK_SLAB = register(ModBlockItemIds.QUARTZ_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).forceSolidOn());
    public static final Block QUARTZ_BRICK_WALL = register(ModBlockItemIds.QUARTZ_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).forceSolidOn());
    public static final Block QUARTZ_BRICK_FENCE = register(ModBlockItemIds.QUARTZ_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).forceSolidOn());
    public static final Block TERRACOTTA_STAIRS = register(ModBlockItemIds.TERRACOTTA_STAIRS, properties -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).forceSolidOn());
    public static final Block TERRACOTTA_SLAB = register(ModBlockItemIds.TERRACOTTA_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).forceSolidOn());
    public static final Block TERRACOTTA_WALL = register(ModBlockItemIds.TERRACOTTA_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).forceSolidOn());
    public static final Block TERRACOTTA_FENCE = register(ModBlockItemIds.TERRACOTTA_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).forceSolidOn());
    public static final ColorCollection<Block> DYED_TERRACOTTA_STAIRS = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_STAIRS, ModBlocks::register, (color, properties) -> new StairBlock(Blocks.DYED_TERRACOTTA.pick(color).defaultBlockState(), properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.DYED_TERRACOTTA.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_SLAB = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_SLAB, ModBlocks::register, (color, properties) -> new SlabBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.DYED_TERRACOTTA.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_WALL = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_WALL, ModBlocks::register, (color, properties) -> new WallBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.DYED_TERRACOTTA.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_FENCE = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_FENCE, ModBlocks::register, (color, properties) -> new FenceBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.DYED_TERRACOTTA.pick(color)));
    public static final ColorCollection<Block> CONCRETE_STAIRS = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_STAIRS, ModBlocks::register, (color, properties) -> new StairBlock(Blocks.CONCRETE.pick(color).defaultBlockState(), properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(color)));
    public static final ColorCollection<Block> CONCRETE_SLAB = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_SLAB, ModBlocks::register, (color, properties) -> new SlabBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(color)));
    public static final ColorCollection<Block> CONCRETE_WALL = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_WALL, ModBlocks::register, (color, properties) -> new WallBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(color)));
    public static final ColorCollection<Block> CONCRETE_FENCE = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_FENCE, ModBlocks::register, (color, properties) -> new FenceBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(color)));

    // Blocks based on pre-existing Vanilla materials but just new variants

    public static final Block POLISHED_STONE = register(ModBlockItemIds.POLISHED_STONE, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE));
    public static final Block POLISHED_STONE_STAIRS = register(ModBlockItemIds.POLISHED_STONE_STAIRS, properties -> new StairBlock(POLISHED_STONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_STONE).forceSolidOn());
    public static final Block POLISHED_STONE_SLAB = register(ModBlockItemIds.POLISHED_STONE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_STONE).forceSolidOn());
    public static final Block POLISHED_STONE_WALL = register(ModBlockItemIds.POLISHED_STONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_STONE).forceSolidOn());
    public static final Block POLISHED_STONE_FENCE = register(ModBlockItemIds.POLISHED_STONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_STONE).forceSolidOn());
    public static final Block STONE_TILES = register(ModBlockItemIds.STONE_TILES, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    public static final Block STONE_TILE_STAIRS = register(ModBlockItemIds.STONE_TILE_STAIRS, properties -> new StairBlock(STONE_TILES.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(STONE_TILES).forceSolidOn());
    public static final Block STONE_TILE_SLAB = register(ModBlockItemIds.STONE_TILE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(STONE_TILES).forceSolidOn());
    public static final Block STONE_TILE_WALL = register(ModBlockItemIds.STONE_TILE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(STONE_TILES).forceSolidOn());
    public static final Block STONE_TILE_FENCE = register(ModBlockItemIds.STONE_TILE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(STONE_TILES).forceSolidOn());
    public static final Block MOSSY_STONE_TILES = register(ModBlockItemIds.MOSSY_STONE_TILES, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_STONE_BRICKS));
    public static final Block MOSSY_STONE_TILE_STAIRS = register(ModBlockItemIds.MOSSY_STONE_TILE_STAIRS, properties -> new StairBlock(MOSSY_STONE_TILES.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE_TILES).forceSolidOn());
    public static final Block MOSSY_STONE_TILE_SLAB = register(ModBlockItemIds.MOSSY_STONE_TILE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE_TILES).forceSolidOn());
    public static final Block MOSSY_STONE_TILE_WALL = register(ModBlockItemIds.MOSSY_STONE_TILE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE_TILES).forceSolidOn());
    public static final Block MOSSY_STONE_TILE_FENCE = register(ModBlockItemIds.MOSSY_STONE_TILE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(MOSSY_STONE_TILES).forceSolidOn());
    public static final Block CRACKED_STONE_TILES = register(ModBlockItemIds.CRACKED_STONE_TILES, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_TILE_STAIRS = register(ModBlockItemIds.CRACKED_STONE_TILE_STAIRS, properties -> new StairBlock(CRACKED_STONE_TILES.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(CRACKED_STONE_TILES).forceSolidOn());
    public static final Block CRACKED_STONE_TILE_SLAB = register(ModBlockItemIds.CRACKED_STONE_TILE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CRACKED_STONE_TILES).forceSolidOn());
    public static final Block CRACKED_STONE_TILE_WALL = register(ModBlockItemIds.CRACKED_STONE_TILE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(CRACKED_STONE_TILES).forceSolidOn());
    public static final Block CRACKED_STONE_TILE_FENCE = register(ModBlockItemIds.CRACKED_STONE_TILE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(CRACKED_STONE_TILES).forceSolidOn());
    public static final Block POLISHED_GRANITE_BRICKS = register(ModBlockItemIds.POLISHED_GRANITE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_GRANITE));
    public static final Block POLISHED_GRANITE_BRICK_STAIRS = register(ModBlockItemIds.POLISHED_GRANITE_BRICK_STAIRS, properties -> new StairBlock(POLISHED_GRANITE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_GRANITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_GRANITE_BRICK_SLAB = register(ModBlockItemIds.POLISHED_GRANITE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_GRANITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_GRANITE_BRICK_WALL = register(ModBlockItemIds.POLISHED_GRANITE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_GRANITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_GRANITE_BRICK_FENCE = register(ModBlockItemIds.POLISHED_GRANITE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_GRANITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_DIORITE_BRICKS = register(ModBlockItemIds.POLISHED_DIORITE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DIORITE));
    public static final Block POLISHED_DIORITE_BRICK_STAIRS = register(ModBlockItemIds.POLISHED_DIORITE_BRICK_STAIRS, properties -> new StairBlock(POLISHED_DIORITE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_DIORITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_DIORITE_BRICK_SLAB = register(ModBlockItemIds.POLISHED_DIORITE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DIORITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_DIORITE_BRICK_WALL = register(ModBlockItemIds.POLISHED_DIORITE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DIORITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_DIORITE_BRICK_FENCE = register(ModBlockItemIds.POLISHED_DIORITE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DIORITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_ANDESITE_BRICKS = register(ModBlockItemIds.POLISHED_ANDESITE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_ANDESITE));
    public static final Block POLISHED_ANDESITE_BRICK_STAIRS = register(ModBlockItemIds.POLISHED_ANDESITE_BRICK_STAIRS, properties -> new StairBlock(POLISHED_ANDESITE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_ANDESITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_ANDESITE_BRICK_SLAB = register(ModBlockItemIds.POLISHED_ANDESITE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_ANDESITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_ANDESITE_BRICK_WALL = register(ModBlockItemIds.POLISHED_ANDESITE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_ANDESITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_ANDESITE_BRICK_FENCE = register(ModBlockItemIds.POLISHED_ANDESITE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_ANDESITE_BRICKS).forceSolidOn());
    public static final Block SMOOTH_DEEPSLATE = register(ModBlockItemIds.SMOOTH_DEEPSLATE, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE));
    public static final Block SMOOTH_DEEPSLATE_STAIRS = register(ModBlockItemIds.SMOOTH_DEEPSLATE_STAIRS, properties -> new StairBlock(SMOOTH_DEEPSLATE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(SMOOTH_DEEPSLATE).forceSolidOn());
    public static final Block SMOOTH_DEEPSLATE_SLAB = register(ModBlockItemIds.SMOOTH_DEEPSLATE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_DEEPSLATE).forceSolidOn());
    public static final Block SMOOTH_DEEPSLATE_WALL = register(ModBlockItemIds.SMOOTH_DEEPSLATE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_DEEPSLATE).forceSolidOn());
    public static final Block SMOOTH_DEEPSLATE_FENCE = register(ModBlockItemIds.SMOOTH_DEEPSLATE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_DEEPSLATE).forceSolidOn());
    public static final Block POLISHED_CALCITE = register(ModBlockItemIds.POLISHED_CALCITE, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_STAIRS = register(ModBlockItemIds.POLISHED_CALCITE_STAIRS, properties -> new StairBlock(POLISHED_CALCITE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE).forceSolidOn());
    public static final Block POLISHED_CALCITE_SLAB = register(ModBlockItemIds.POLISHED_CALCITE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE).forceSolidOn());
    public static final Block POLISHED_CALCITE_WALL = register(ModBlockItemIds.POLISHED_CALCITE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE).forceSolidOn());
    public static final Block POLISHED_CALCITE_FENCE = register(ModBlockItemIds.POLISHED_CALCITE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE).forceSolidOn());
    public static final Block CALCITE_BRICKS = register(ModBlockItemIds.CALCITE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_CALCITE));
    public static final Block CALCITE_BRICK_STAIRS = register(ModBlockItemIds.CALCITE_BRICK_STAIRS, properties -> new StairBlock(CALCITE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS).forceSolidOn());
    public static final Block CALCITE_BRICK_SLAB = register(ModBlockItemIds.CALCITE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS).forceSolidOn());
    public static final Block CALCITE_BRICK_WALL = register(ModBlockItemIds.CALCITE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS).forceSolidOn());
    public static final Block CALCITE_BRICK_FENCE = register(ModBlockItemIds.CALCITE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(CALCITE_BRICKS).forceSolidOn());
    public static final Block POLISHED_DRIPSTONE = register(ModBlockItemIds.POLISHED_DRIPSTONE, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK));
    public static final Block POLISHED_DRIPSTONE_STAIRS = register(ModBlockItemIds.POLISHED_DRIPSTONE_STAIRS, properties -> new StairBlock(POLISHED_DRIPSTONE.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE).forceSolidOn());
    public static final Block POLISHED_DRIPSTONE_SLAB = register(ModBlockItemIds.POLISHED_DRIPSTONE_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE).forceSolidOn());
    public static final Block POLISHED_DRIPSTONE_WALL = register(ModBlockItemIds.POLISHED_DRIPSTONE_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE).forceSolidOn());
    public static final Block POLISHED_DRIPSTONE_FENCE = register(ModBlockItemIds.POLISHED_DRIPSTONE_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE).forceSolidOn());
    public static final Block DRIPSTONE_BRICKS = register(ModBlockItemIds.DRIPSTONE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(POLISHED_DRIPSTONE));
    public static final Block DRIPSTONE_BRICK_STAIRS = register(ModBlockItemIds.DRIPSTONE_BRICK_STAIRS, properties -> new StairBlock(DRIPSTONE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS).forceSolidOn());
    public static final Block DRIPSTONE_BRICK_SLAB = register(ModBlockItemIds.DRIPSTONE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS).forceSolidOn());
    public static final Block DRIPSTONE_BRICK_WALL = register(ModBlockItemIds.DRIPSTONE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS).forceSolidOn());
    public static final Block DRIPSTONE_BRICK_FENCE = register(ModBlockItemIds.DRIPSTONE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(DRIPSTONE_BRICKS).forceSolidOn());
    public static final Block BIG_BRICKS = register(ModBlockItemIds.BIG_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
    public static final Block BIG_BRICK_STAIRS = register(ModBlockItemIds.BIG_BRICK_STAIRS, properties -> new StairBlock(BIG_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(BIG_BRICKS).forceSolidOn());
    public static final Block BIG_BRICK_SLAB = register(ModBlockItemIds.BIG_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BIG_BRICKS).forceSolidOn());
    public static final Block BIG_BRICK_WALL = register(ModBlockItemIds.BIG_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(BIG_BRICKS).forceSolidOn());
    public static final Block BIG_BRICK_FENCE = register(ModBlockItemIds.BIG_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(BIG_BRICKS).forceSolidOn());
    public static final Block SCULK_BRICKS = register(ModBlockItemIds.SCULK_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RESIN_BRICKS).mapColor(MapColor.COLOR_BLACK));
    public static final Block SCULK_BRICK_STAIRS = register(ModBlockItemIds.SCULK_BRICK_STAIRS, properties -> new StairBlock(SCULK_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(SCULK_BRICKS).forceSolidOn());
    public static final Block SCULK_BRICK_SLAB = register(ModBlockItemIds.SCULK_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SCULK_BRICKS).forceSolidOn());
    public static final Block SCULK_BRICK_WALL = register(ModBlockItemIds.SCULK_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SCULK_BRICKS).forceSolidOn());
    public static final Block SCULK_BRICK_FENCE = register(ModBlockItemIds.SCULK_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(SCULK_BRICKS).forceSolidOn());
    public static final Block CHISELED_SCULK_BRICKS = register(ModBlockItemIds.CHISELED_SCULK_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(SCULK_BRICKS));
    public static final Block SNOW_BRICKS = register(ModBlockItemIds.SNOW_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK));
    public static final Block SNOW_BRICK_STAIRS = register(ModBlockItemIds.SNOW_BRICK_STAIRS, properties -> new StairBlock(SNOW_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS).forceSolidOn());
    public static final Block SNOW_BRICK_SLAB = register(ModBlockItemIds.SNOW_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS).forceSolidOn());
    public static final Block SNOW_BRICK_WALL = register(ModBlockItemIds.SNOW_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS).forceSolidOn());
    public static final Block SNOW_BRICK_FENCE = register(ModBlockItemIds.SNOW_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(SNOW_BRICKS).forceSolidOn());
    public static final Block ICE_BRICKS = register(ModBlockItemIds.ICE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ICE));
    public static final Block ICE_BRICK_STAIRS = register(ModBlockItemIds.ICE_BRICK_STAIRS, properties -> new StairBlock(ICE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS).forceSolidOn());
    public static final Block ICE_BRICK_SLAB = register(ModBlockItemIds.ICE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS).forceSolidOn());
    public static final Block ICE_BRICK_WALL = register(ModBlockItemIds.ICE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS).forceSolidOn());
    public static final Block ICE_BRICK_FENCE = register(ModBlockItemIds.ICE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(ICE_BRICKS).forceSolidOn());
    public static final Block PACKED_ICE_BRICKS = register(ModBlockItemIds.PACKED_ICE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE));
    public static final Block PACKED_ICE_BRICK_STAIRS = register(ModBlockItemIds.PACKED_ICE_BRICK_STAIRS, properties -> new StairBlock(PACKED_ICE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS).forceSolidOn());
    public static final Block PACKED_ICE_BRICK_SLAB = register(ModBlockItemIds.PACKED_ICE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS).forceSolidOn());
    public static final Block PACKED_ICE_BRICK_WALL = register(ModBlockItemIds.PACKED_ICE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS).forceSolidOn());
    public static final Block PACKED_ICE_BRICK_FENCE = register(ModBlockItemIds.PACKED_ICE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(PACKED_ICE_BRICKS).forceSolidOn());
    public static final Block BLUE_ICE_BRICKS = register(ModBlockItemIds.BLUE_ICE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE));
    public static final Block BLUE_ICE_BRICK_STAIRS = register(ModBlockItemIds.BLUE_ICE_BRICK_STAIRS, properties -> new StairBlock(BLUE_ICE_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS).forceSolidOn());
    public static final Block BLUE_ICE_BRICK_SLAB = register(ModBlockItemIds.BLUE_ICE_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS).forceSolidOn());
    public static final Block BLUE_ICE_BRICK_WALL = register(ModBlockItemIds.BLUE_ICE_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS).forceSolidOn());
    public static final Block BLUE_ICE_BRICK_FENCE = register(ModBlockItemIds.BLUE_ICE_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(BLUE_ICE_BRICKS).forceSolidOn());
    public static final Block CHISELED_PRISMARINE = register(ModBlockItemIds.CHISELED_PRISMARINE, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE));
    public static final Block CHISELED_PRISMARINE_BRICKS = register(ModBlockItemIds.CHISELED_PRISMARINE_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS));
    public static final Block NETHERRACK_BRICKS = register(ModBlockItemIds.NETHERRACK_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block NETHERRACK_BRICK_STAIRS = register(ModBlockItemIds.NETHERRACK_BRICK_STAIRS, properties -> new StairBlock(NETHERRACK_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(NETHERRACK_BRICKS).forceSolidOn());
    public static final Block NETHERRACK_BRICK_SLAB = register(ModBlockItemIds.NETHERRACK_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(NETHERRACK_BRICKS).forceSolidOn());
    public static final Block NETHERRACK_BRICK_WALL = register(ModBlockItemIds.NETHERRACK_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(NETHERRACK_BRICKS).forceSolidOn());
    public static final Block NETHERRACK_BRICK_FENCE = register(ModBlockItemIds.NETHERRACK_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(NETHERRACK_BRICKS).forceSolidOn());
    public static final Block BASALT_BRICKS = register(ModBlockItemIds.BASALT_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT));
    public static final Block BASALT_BRICK_STAIRS = register(ModBlockItemIds.BASALT_BRICK_STAIRS, properties -> new StairBlock(BASALT_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS).forceSolidOn());
    public static final Block BASALT_BRICK_SLAB = register(ModBlockItemIds.BASALT_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS).forceSolidOn());
    public static final Block BASALT_BRICK_WALL = register(ModBlockItemIds.BASALT_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS).forceSolidOn());
    public static final Block BASALT_BRICK_FENCE = register(ModBlockItemIds.BASALT_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(BASALT_BRICKS).forceSolidOn());
    public static final Block COAL_BRICKS = register(ModBlockItemIds.COAL_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK));
    public static final Block COAL_BRICK_STAIRS = register(ModBlockItemIds.COAL_BRICK_STAIRS, properties -> new StairBlock(COAL_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(COAL_BRICKS).forceSolidOn());
    public static final Block COAL_BRICK_SLAB = register(ModBlockItemIds.COAL_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COAL_BRICKS).forceSolidOn());
    public static final Block COAL_BRICK_WALL = register(ModBlockItemIds.COAL_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(COAL_BRICKS).forceSolidOn());
    public static final Block COAL_BRICK_FENCE = register(ModBlockItemIds.COAL_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(COAL_BRICKS).forceSolidOn());
    public static final Block LAPIS_BRICKS = register(ModBlockItemIds.LAPIS_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final Block LAPIS_BRICK_STAIRS = register(ModBlockItemIds.LAPIS_BRICK_STAIRS, properties -> new StairBlock(LAPIS_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(LAPIS_BRICKS).forceSolidOn());
    public static final Block LAPIS_BRICK_SLAB = register(ModBlockItemIds.LAPIS_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(LAPIS_BRICKS).forceSolidOn());
    public static final Block LAPIS_BRICK_WALL = register(ModBlockItemIds.LAPIS_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(LAPIS_BRICKS).forceSolidOn());
    public static final Block LAPIS_BRICK_FENCE = register(ModBlockItemIds.LAPIS_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(LAPIS_BRICKS).forceSolidOn());
    public static final Block SMOOTH_LAPIS = register(ModBlockItemIds.SMOOTH_LAPIS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final Block SMOOTH_LAPIS_STAIRS = register(ModBlockItemIds.SMOOTH_LAPIS_STAIRS, properties -> new StairBlock(SMOOTH_LAPIS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(SMOOTH_LAPIS).forceSolidOn());
    public static final Block SMOOTH_LAPIS_SLAB = register(ModBlockItemIds.SMOOTH_LAPIS_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_LAPIS).forceSolidOn());
    public static final Block SMOOTH_LAPIS_WALL = register(ModBlockItemIds.SMOOTH_LAPIS_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_LAPIS).forceSolidOn());
    public static final Block SMOOTH_LAPIS_FENCE = register(ModBlockItemIds.SMOOTH_LAPIS_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_LAPIS).forceSolidOn());
    public static final Block CHISELED_LAPIS = register(ModBlockItemIds.CHISELED_LAPIS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final Block LAPIS_PILLAR = register(ModBlockItemIds.LAPIS_PILLAR, RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK));
    public static final Block TERRACOTTA_BRICKS = register(ModBlockItemIds.TERRACOTTA_BRICKS, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final Block TERRACOTTA_BRICK_STAIRS = register(ModBlockItemIds.TERRACOTTA_BRICK_STAIRS, properties -> new StairBlock(TERRACOTTA_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_BRICKS).forceSolidOn());
    public static final Block TERRACOTTA_BRICK_SLAB = register(ModBlockItemIds.TERRACOTTA_BRICK_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_BRICKS).forceSolidOn());
    public static final Block TERRACOTTA_BRICK_WALL = register(ModBlockItemIds.TERRACOTTA_BRICK_WALL, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_BRICKS).forceSolidOn());
    public static final Block TERRACOTTA_BRICK_FENCE = register(ModBlockItemIds.TERRACOTTA_BRICK_FENCE, FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_BRICKS).forceSolidOn());
    public static final ColorCollection<Block> DYED_TERRACOTTA_BRICKS = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_BRICKS, ModBlocks::register, (color, properties) -> new Block(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.DYED_TERRACOTTA.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_BRICK_STAIRS = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_BRICK_STAIRS, ModBlocks::register, (color, properties) -> new StairBlock(DYED_TERRACOTTA_BRICKS.pick(color).defaultBlockState(), properties), (color) -> BlockBehaviour.Properties.ofFullCopy(DYED_TERRACOTTA_BRICKS.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_BRICK_SLAB = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_BRICK_SLAB, ModBlocks::register, (color, properties) -> new SlabBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(DYED_TERRACOTTA_BRICKS.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_BRICK_WALL = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_BRICK_WALL, ModBlocks::register, (color, properties) -> new WallBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(DYED_TERRACOTTA_BRICKS.pick(color)));
    public static final ColorCollection<Block> DYED_TERRACOTTA_BRICK_FENCE = ColorCollection.registerBlocks(ModBlockItemIds.DYED_TERRACOTTA_BRICK_FENCE, ModBlocks::register, (color, properties) -> new FenceBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(DYED_TERRACOTTA_BRICKS.pick(color)));
    public static final ColorCollection<Block> CONCRETE_BRICKS = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_BRICKS, ModBlocks::register, (color, properties) -> new Block(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CONCRETE.pick(color)));
    public static final ColorCollection<Block> CONCRETE_BRICK_STAIRS = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_BRICK_STAIRS, ModBlocks::register, (color, properties) -> new StairBlock(CONCRETE_BRICKS.pick(color).defaultBlockState(), properties), (color) -> BlockBehaviour.Properties.ofFullCopy(CONCRETE_BRICKS.pick(color)));
    public static final ColorCollection<Block> CONCRETE_BRICK_SLAB = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_BRICK_SLAB, ModBlocks::register, (color, properties) -> new SlabBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(CONCRETE_BRICKS.pick(color)));
    public static final ColorCollection<Block> CONCRETE_BRICK_WALL = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_BRICK_WALL, ModBlocks::register, (color, properties) -> new WallBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(CONCRETE_BRICKS.pick(color)));
    public static final ColorCollection<Block> CONCRETE_BRICK_FENCE = ColorCollection.registerBlocks(ModBlockItemIds.CONCRETE_BRICK_FENCE, ModBlocks::register, (color, properties) -> new FenceBlock(properties), (color) -> BlockBehaviour.Properties.ofFullCopy(CONCRETE_BRICKS.pick(color)));

    // Wooden blocks

    public static final Block OAK_MOSAIC = register(ModBlockItemIds.OAK_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final Block OAK_MOSAIC_STAIRS = register(ModBlockItemIds.OAK_MOSAIC_STAIRS, properties -> new StairBlock(OAK_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(OAK_MOSAIC).forceSolidOn());
    public static final Block OAK_MOSAIC_SLAB = register(ModBlockItemIds.OAK_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_MOSAIC).forceSolidOn());
    public static final Block SPRUCE_MOSAIC = register(ModBlockItemIds.SPRUCE_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final Block SPRUCE_MOSAIC_STAIRS = register(ModBlockItemIds.SPRUCE_MOSAIC_STAIRS, properties -> new StairBlock(SPRUCE_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(SPRUCE_MOSAIC).forceSolidOn());
    public static final Block SPRUCE_MOSAIC_SLAB = register(ModBlockItemIds.SPRUCE_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SPRUCE_MOSAIC).forceSolidOn());
    public static final Block BIRCH_MOSAIC = register(ModBlockItemIds.BIRCH_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final Block BIRCH_MOSAIC_STAIRS = register(ModBlockItemIds.BIRCH_MOSAIC_STAIRS, properties -> new StairBlock(BIRCH_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(BIRCH_MOSAIC).forceSolidOn());
    public static final Block BIRCH_MOSAIC_SLAB = register(ModBlockItemIds.BIRCH_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(BIRCH_MOSAIC).forceSolidOn());
    public static final Block JUNGLE_MOSAIC = register(ModBlockItemIds.JUNGLE_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final Block JUNGLE_MOSAIC_STAIRS = register(ModBlockItemIds.JUNGLE_MOSAIC_STAIRS, properties -> new StairBlock(JUNGLE_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(JUNGLE_MOSAIC).forceSolidOn());
    public static final Block JUNGLE_MOSAIC_SLAB = register(ModBlockItemIds.JUNGLE_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(JUNGLE_MOSAIC).forceSolidOn());
    public static final Block ACACIA_MOSAIC = register(ModBlockItemIds.ACACIA_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final Block ACACIA_MOSAIC_STAIRS = register(ModBlockItemIds.ACACIA_MOSAIC_STAIRS, properties -> new StairBlock(ACACIA_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(ACACIA_MOSAIC).forceSolidOn());
    public static final Block ACACIA_MOSAIC_SLAB = register(ModBlockItemIds.ACACIA_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(ACACIA_MOSAIC).forceSolidOn());
    public static final Block DARK_OAK_MOSAIC = register(ModBlockItemIds.DARK_OAK_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final Block DARK_OAK_MOSAIC_STAIRS = register(ModBlockItemIds.DARK_OAK_MOSAIC_STAIRS, properties -> new StairBlock(DARK_OAK_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(DARK_OAK_MOSAIC).forceSolidOn());
    public static final Block DARK_OAK_MOSAIC_SLAB = register(ModBlockItemIds.DARK_OAK_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(DARK_OAK_MOSAIC).forceSolidOn());
    public static final Block MANGROVE_MOSAIC = register(ModBlockItemIds.MANGROVE_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
    public static final Block MANGROVE_MOSAIC_STAIRS = register(ModBlockItemIds.MANGROVE_MOSAIC_STAIRS, properties -> new StairBlock(MANGROVE_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(MANGROVE_MOSAIC).forceSolidOn());
    public static final Block MANGROVE_MOSAIC_SLAB = register(ModBlockItemIds.MANGROVE_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(MANGROVE_MOSAIC).forceSolidOn());
    public static final Block CHERRY_MOSAIC = register(ModBlockItemIds.CHERRY_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS));
    public static final Block CHERRY_MOSAIC_STAIRS = register(ModBlockItemIds.CHERRY_MOSAIC_STAIRS, properties -> new StairBlock(CHERRY_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(CHERRY_MOSAIC).forceSolidOn());
    public static final Block CHERRY_MOSAIC_SLAB = register(ModBlockItemIds.CHERRY_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CHERRY_MOSAIC).forceSolidOn());
    public static final Block PALE_OAK_MOSAIC = register(ModBlockItemIds.PALE_OAK_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS));
    public static final Block PALE_OAK_MOSAIC_STAIRS = register(ModBlockItemIds.PALE_OAK_MOSAIC_STAIRS, properties -> new StairBlock(PALE_OAK_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(PALE_OAK_MOSAIC).forceSolidOn());
    public static final Block PALE_OAK_MOSAIC_SLAB = register(ModBlockItemIds.PALE_OAK_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PALE_OAK_MOSAIC).forceSolidOn());
    public static final Block CRIMSON_MOSAIC = register(ModBlockItemIds.CRIMSON_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final Block CRIMSON_MOSAIC_STAIRS = register(ModBlockItemIds.CRIMSON_MOSAIC_STAIRS, properties -> new StairBlock(CRIMSON_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(CRIMSON_MOSAIC).forceSolidOn());
    public static final Block CRIMSON_MOSAIC_SLAB = register(ModBlockItemIds.CRIMSON_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CRIMSON_MOSAIC).forceSolidOn());
    public static final Block WARPED_MOSAIC = register(ModBlockItemIds.WARPED_MOSAIC, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));
    public static final Block WARPED_MOSAIC_STAIRS = register(ModBlockItemIds.WARPED_MOSAIC_STAIRS, properties -> new StairBlock(WARPED_MOSAIC.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(WARPED_MOSAIC).forceSolidOn());
    public static final Block WARPED_MOSAIC_SLAB = register(ModBlockItemIds.WARPED_MOSAIC_SLAB, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(WARPED_MOSAIC).forceSolidOn());

    // Metallic block family completion

    public static final RustingIronCollection<Block> IRON_BLOCK = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_BLOCK, ModBlocks::register, (weatherState, properties) -> new Block(properties), RustingIronFullBlock::new, (weatherState) -> {
        MapColor mapColor = switch (weatherState) {
            case UNAFFECTED -> MapColor.METAL;
            case EXPOSED -> MapColor.COLOR_LIGHT_GRAY;
            case WEATHERED -> MapColor.DEEPSLATE;
            case RUSTED -> MapColor.COLOR_GRAY;
            default -> throw new MatchException((String)null, (Throwable)null);
        };

        return BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(mapColor);
    }, Blocks.IRON_BLOCK);
    public static final RustingIronCollection<Block> IRON_GRATE = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_GRATE, ModBlocks::register, (weatherState, properties) -> new WaterloggedTransparentBlock(properties), RustingIronGrateBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE.weathering().unaffected()).strength(IRON_BLOCK.weathering().pick(weatherState).defaultDestroyTime(), IRON_BLOCK.weathering().pick(weatherState).getExplosionResistance()).mapColor((var1x) -> ((Block)IRON_BLOCK.weathering().pick(weatherState)).defaultMapColor()).noOcclusion(), null);
    public static final RustingIronCollection<Block> CUT_IRON = RustingIronCollection.registerBlocks(ModBlockItemIds.CUT_IRON, ModBlocks::register, (weatherState, properties) -> new Block(properties), RustingIronFullBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(IRON_BLOCK.weathering().pick(weatherState)), null);
    public static final RustingIronCollection<Block> CUT_IRON_STAIRS = RustingIronCollection.registerBlocks(ModBlockItemIds.CUT_IRON_STAIRS, ModBlocks::register, (weatherState, properties) -> new StairBlock(CUT_IRON.weathering().pick(weatherState).defaultBlockState(), properties), (weatherState, properties) -> new RustingIronStairBlock(weatherState, CUT_IRON.weathering().pick(weatherState).defaultBlockState(), properties), (weatherState) -> BlockBehaviour.Properties.ofFullCopy(CUT_IRON.weathering().pick(weatherState)).forceSolidOn(), null);
    public static final RustingIronCollection<Block> CUT_IRON_SLAB = RustingIronCollection.registerBlocks(ModBlockItemIds.CUT_IRON_SLAB, ModBlocks::register, (weatherState, properties) -> new SlabBlock(properties), RustingIronSlabBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(CUT_IRON.weathering().pick(weatherState)), null);
    public static final RustingIronCollection<Block> IRON_BARS = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_BARS, ModBlocks::register, (weatherState, properties) -> new IronBarsBlock(properties), RustingIronBarsBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), Blocks.IRON_BARS);
    public static final RustingIronCollection<Block> IRON_DOOR = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_DOOR, ModBlocks::register, (weatherState, properties) -> new DoorBlock(BlockSetType.IRON, properties), (weatherState, properties) -> new RustingIronDoorBlock(BlockSetType.IRON, weatherState, properties), (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).mapColor((var1x) -> ((Block)IRON_BLOCK.weathering().pick(weatherState)).defaultMapColor()), Blocks.IRON_DOOR);
    public static final RustingIronCollection<Block> IRON_TRAPDOOR = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_TRAPDOOR, ModBlocks::register, (weatherState, properties) -> new TrapDoorBlock(BlockSetType.IRON, properties), (weatherState, properties) -> new RustingIronTrapDoorBlock(BlockSetType.IRON, weatherState, properties), (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR).mapColor((var1x) -> ((Block)IRON_BLOCK.weathering().pick(weatherState)).defaultMapColor()), Blocks.IRON_TRAPDOOR);
    public static final RustingIronCollection<Block> HEAVY_WEIGHTED_PRESSURE_PLATE = RustingIronCollection.registerBlocks(ModBlockItemIds.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks::register, (weatherState, properties) -> new WeightedPressurePlateBlock(150, BlockSetType.IRON, properties), (weatherState, properties) -> new RustingIronWeightedPressurePlateBlock(150, weatherState, BlockSetType.IRON, properties), (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).mapColor((var1x) -> ((Block)IRON_BLOCK.weathering().pick(weatherState)).defaultMapColor()), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final RustingIronCollection<Block> IRON_BULB = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_BULB, ModBlocks::register, (weatherState, properties) -> new CopperBulbBlock(properties), RustingIronBulbBlock::new, (weatherState) -> {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BULB.weathering().unaffected()).strength(IRON_BLOCK.weathering().pick(weatherState).defaultDestroyTime(), IRON_BLOCK.weathering().pick(weatherState).getExplosionResistance()).mapColor((var1x) -> ((Block)IRON_BLOCK.weathering().pick(weatherState)).defaultMapColor());
        int lightLevel = switch (weatherState) {
            case UNAFFECTED -> 15;
            case EXPOSED -> 12;
            case WEATHERED -> 8;
            case RUSTED -> 4;
            default -> throw new MatchException((String)null, (Throwable)null);
        };
        return properties.lightLevel((state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? lightLevel : 0);
    }, null);
    public static final RustingIronCollection<Block> IRON_CHAIN = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_CHAIN, ModBlocks::register, (weatherState, properties) -> new ChainBlock(properties), RustingIronChainBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN), Blocks.IRON_CHAIN);
    public static final RustingIronCollection<Block> IRON_LANTERN = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_LANTERN, ModBlocks::register, (weatherState, properties) -> new LanternBlock(properties), RustingIronLanternBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), Blocks.LANTERN);
    public static final RustingIronCollection<Block> IRON_SOUL_LANTERN = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_SOUL_LANTERN, ModBlocks::register, (weatherState, properties) -> new LanternBlock(properties), RustingIronLanternBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_LANTERN), Blocks.SOUL_LANTERN);
    public static final RustingIronCollection<Block> IRON_FIRE_LANTERN = RustingIronCollection.registerBlocks(ModBlockItemIds.IRON_FIRE_LANTERN, ModBlocks::register, (weatherState, properties) -> new LanternBlock(properties), RustingIronLanternBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(IRON_LANTERN.weathering().pick(weatherState)), null);
    public static final Block IRON_TORCH = registerStandingVariant(ModBlockItemIds.IRON_TORCH, (properties) -> new TorchBlock(ModParticles.IRON_FIRE_FLAME, properties), BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel((statex) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY));
    public static final Block IRON_WALL_TORCH = registerWallVariant(ModBlockIds.IRON_WALL_TORCH, (properties) -> new WallTorchBlock(ModParticles.IRON_FIRE_FLAME, properties), BlockBehaviour.Properties.of().noCollision().instabreak().lightLevel((statex) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), IRON_TORCH);
    public static final WeatheringCopperCollection<Block> MEDIUM_WEIGHTED_PRESSURE_PLATE = WeatheringCopperCollection.registerBlocks(ModBlockItemIds.MEDIUM_WEIGHTED_PRESSURE_PLATE, ModBlocks::register, (weatherState, properties) -> new WeightedPressurePlateBlock(88, BlockSetType.COPPER, properties), (weatherState, propeties) -> new WeatheringCopperWeightedPressurePlateBlock(88, weatherState, BlockSetType.COPPER, propeties), (weatherState) -> BlockBehaviour.Properties.of().forceSolidOn().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY).mapColor(Blocks.COPPER_BLOCK.weathering().pick(weatherState).defaultMapColor()));
    public static final WeatheringCopperCollection<Block> COPPER_SOUL_LANTERN = WeatheringCopperCollection.registerBlocks(ModBlockItemIds.COPPER_SOUL_LANTERN, ModBlocks::register, (weatherState, properties) -> new LanternBlock(properties), WeatheringLanternBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_LANTERN.weathering().pick(weatherState)).lightLevel((statex) -> 10));
    public static final WeatheringCopperCollection<Block> COPPER_FIRE_LANTERN = WeatheringCopperCollection.registerBlocks(ModBlockItemIds.COPPER_FIRE_LANTERN, ModBlocks::register, (weatherState, properties) -> new LanternBlock(properties), WeatheringLanternBlock::new, (weatherState) -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_LANTERN.weathering().pick(weatherState)).lightLevel((statex) -> 15));

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    private static Block registerStandingVariant(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);

        return block;
    }

    private static Block registerWallVariant(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, Block standingVariant) {
        Block block = register(id, blockFactory, properties.overrideLootTable(standingVariant.getLootTable()).overrideDescription(standingVariant.getDescriptionId()));

        return block;
    }

    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = (Block)factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {

    }
}
