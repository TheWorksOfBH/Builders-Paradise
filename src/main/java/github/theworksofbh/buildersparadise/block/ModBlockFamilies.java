package github.theworksofbh.buildersparadise.block;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    public static final Map<Block, BlockFamily> BLOCK_BLOCK_FAMILY_MAP = Maps.<Block, BlockFamily>newHashMap();

    private static BlockFamily.Builder familyBuilder(Block baseBlock){
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockfamily = BLOCK_BLOCK_FAMILY_MAP.put(baseBlock, blockfamily$builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + String.valueOf(BuiltInRegistries.BLOCK.getKey(baseBlock)));
        } else {
            return blockfamily$builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return BLOCK_BLOCK_FAMILY_MAP.values().stream();
    }

    public static final BlockFamily POLISHED_GRANITE = familyBuilder(Blocks.POLISHED_GRANITE).wall(ModBlocks.POLISHED_GRANITE_WALL.get()).polished(ModBlocks.POLISHED_GRANITE_BRICKS.get()).getFamily();
    public static final BlockFamily POLISHED_DIORITE = familyBuilder(Blocks.POLISHED_DIORITE).wall(ModBlocks.POLISHED_DIORITE_WALL.get()).polished(ModBlocks.POLISHED_DIORITE_BRICKS.get()).getFamily();
    public static final BlockFamily POLISHED_ANDESITE = familyBuilder(Blocks.POLISHED_ANDESITE).wall(ModBlocks.POLISHED_ANDESITE_WALL.get()).polished(ModBlocks.POLISHED_ANDESITE_BRICKS.get()).getFamily();
    public static final BlockFamily PRISMARINE_BRICKS = familyBuilder(Blocks.PRISMARINE_BRICKS).wall(ModBlocks.PRISMARINE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily DARK_PRISMARINE = familyBuilder(Blocks.DARK_PRISMARINE).wall(ModBlocks.DARK_PRISMARINE_WALL.get()).getFamily();
    public static final BlockFamily STONE = familyBuilder(Blocks.STONE).wall(ModBlocks.STONE_WALL.get()).getFamily();
    public static final BlockFamily SMOOTH_SANDSTONE = familyBuilder(Blocks.SMOOTH_SANDSTONE).wall(ModBlocks.SMOOTH_SANDSTONE_WALL.get()).getFamily();
    public static final BlockFamily SMOOTH_RED_SANDSTONE = familyBuilder(Blocks.SMOOTH_RED_SANDSTONE).wall(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get()).getFamily();
    public static final BlockFamily QUARTZ = familyBuilder(Blocks.QUARTZ_BLOCK).wall(ModBlocks.QUARTZ_WALL.get()).getFamily();
    public static final BlockFamily SMOOTH_QUARTZ = familyBuilder(Blocks.SMOOTH_QUARTZ).wall(ModBlocks.SMOOTH_QUARTZ_WALL.get()).getFamily();
    public static final BlockFamily PURPUR = familyBuilder(Blocks.PURPUR_BLOCK).wall(ModBlocks.PURPUR_WALL.get()).getFamily();

    public static final BlockFamily SMOOTH_STONE = familyBuilder(Blocks.SMOOTH_STONE).stairs(ModBlocks.SMOOTH_STONE_STAIRS.get()).wall(ModBlocks.SMOOTH_STONE_WALL.get()).getFamily();
    public static final BlockFamily CUT_SANDSTONE = familyBuilder(Blocks.CUT_SANDSTONE).stairs(ModBlocks.CUT_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_SANDSTONE_WALL.get()).getFamily();
    public static final BlockFamily CUT_RED_SANDSTONE = familyBuilder(Blocks.CUT_RED_SANDSTONE).stairs(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_RED_SANDSTONE_WALL.get()).getFamily();

    public static final BlockFamily CRACKED_STONE_BRICKS = familyBuilder(Blocks.CRACKED_STONE_BRICKS).stairs(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_STONE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_STONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily BASALT = familyBuilder(Blocks.BASALT).stairs(ModBlocks.BASALT_STAIRS.get()).slab(ModBlocks.BASALT_SLAB.get()).wall(ModBlocks.BASALT_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_BASALT = familyBuilder(Blocks.POLISHED_BASALT).stairs(ModBlocks.POLISHED_BASALT_STAIRS.get()).slab(ModBlocks.POLISHED_BASALT_SLAB.get()).wall(ModBlocks.POLISHED_BASALT_WALL.get()).polished(ModBlocks.BASALT_BRICKS.get()).getFamily();
    public static final BlockFamily SMOOTH_BASALT = familyBuilder(Blocks.SMOOTH_BASALT).stairs(ModBlocks.SMOOTH_BASALT_STAIRS.get()).slab(ModBlocks.SMOOTH_BASALT_SLAB.get()).wall(ModBlocks.SMOOTH_BASALT_WALL.get()).getFamily();
    public static final BlockFamily DEEPSLATE = familyBuilder(Blocks.DEEPSLATE).stairs(ModBlocks.DEEPSLATE_STAIRS.get()).slab(ModBlocks.DEEPSLATE_SLAB.get()).wall(ModBlocks.DEEPSLATE_WALL.get()).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_BRICKS = familyBuilder(Blocks.CRACKED_DEEPSLATE_BRICKS).stairs(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_TILES = familyBuilder(Blocks.CRACKED_DEEPSLATE_TILES).stairs(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get()).slab(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get()).wall(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get()).getFamily();
    public static final BlockFamily CRACKED_NETHER_BRICKS = familyBuilder(Blocks.CRACKED_NETHER_BRICKS).stairs(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_NETHER_BRICK_WALL.get()).getFamily();
    public static final BlockFamily CRACKED_POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).stairs(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily NETHERRACK = familyBuilder(Blocks.NETHERRACK).stairs(ModBlocks.NETHERRACK_STAIRS.get()).slab(ModBlocks.NETHERRACK_SLAB.get()).wall(ModBlocks.NETHERRACK_WALL.get()).getFamily();
    public static final BlockFamily CALCITE = familyBuilder(Blocks.CALCITE).polished(ModBlocks.POLISHED_CALCITE.get()).stairs(ModBlocks.CALCITE_STAIRS.get()).slab(ModBlocks.CALCITE_SLAB.get()).wall(ModBlocks.CALCITE_WALL.get()).getFamily();
    public static final BlockFamily DRIPSTONE = familyBuilder(Blocks.DRIPSTONE_BLOCK).polished(ModBlocks.POLISHED_DRIPSTONE.get()).stairs(ModBlocks.DRIPSTONE_STAIRS.get()).slab(ModBlocks.DRIPSTONE_SLAB.get()).wall(ModBlocks.DRIPSTONE_WALL.get()).getFamily();
    public static final BlockFamily END_STONE = familyBuilder(Blocks.END_STONE).stairs(ModBlocks.END_STONE_STAIRS.get()).slab(ModBlocks.END_STONE_SLAB.get()).wall(ModBlocks.END_STONE_WALL.get()).getFamily();
    public static final BlockFamily QUARTZ_BRICKS = familyBuilder(Blocks.QUARTZ_BRICKS).stairs(ModBlocks.QUARTZ_BRICK_STAIRS.get()).slab(ModBlocks.QUARTZ_BRICK_SLAB.get()).wall(ModBlocks.QUARTZ_BRICK_WALL.get()).getFamily();
    public static final BlockFamily PACKED_MUD = familyBuilder(Blocks.PACKED_MUD).stairs(ModBlocks.PACKED_MUD_STAIRS.get()).slab(ModBlocks.PACKED_MUD_SLAB.get()).wall(ModBlocks.PACKED_MUD_WALL.get()).getFamily();
    public static final BlockFamily RESIN = familyBuilder(Blocks.RESIN_BLOCK).stairs(ModBlocks.RESIN_STAIRS.get()).slab(ModBlocks.RESIN_SLAB.get()).wall(ModBlocks.RESIN_WALL.get()).getFamily();

    public static final BlockFamily IRON_BLOCK = familyBuilder(Blocks.IRON_BLOCK).cut(ModBlocks.IRON_TILES.get()).getFamily();
    public static final BlockFamily MILDLY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.MILDLY_RUSTED_IRON_TILES.get()).getFamily();
    public static final BlockFamily MODERATELY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get()).getFamily();
    public static final BlockFamily EXTREMELY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get()).getFamily();

    public static final BlockFamily WAXED_IRON_BLOCK = familyBuilder(ModBlocks.WAXED_IRON_BLOCK.get()).cut(ModBlocks.WAXED_IRON_TILES.get()).getFamily();
    public static final BlockFamily WAXED_MILDLY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.WAXED_MILDLY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get()).getFamily();
    public static final BlockFamily WAXED_MODERATELY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get()).getFamily();
    public static final BlockFamily WAXED_EXTREMELY_RUSTED_IRON_BLOCK = familyBuilder(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get()).cut(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get()).getFamily();

    public static final BlockFamily GOLD_BLOCK = familyBuilder(Blocks.GOLD_BLOCK).cut(ModBlocks.GOLD_TILES.get()).getFamily();
    public static final BlockFamily DIAMOND_BLOCK = familyBuilder(Blocks.DIAMOND_BLOCK).cut(ModBlocks.DIAMOND_TILES.get()).getFamily();
    public static final BlockFamily EMERALD_BLOCK = familyBuilder(Blocks.EMERALD_BLOCK).cut(ModBlocks.EMERALD_TILES.get()).getFamily();
    public static final BlockFamily NETHERITE_BLOCK = familyBuilder(Blocks.NETHERITE_BLOCK).cut(ModBlocks.NETHERITE_TILES.get()).getFamily();

    public static final BlockFamily IRON_TILES = familyBuilder(ModBlocks.IRON_TILES.get()).stairs(ModBlocks.IRON_TILE_STAIRS.get()).slab(ModBlocks.IRON_TILE_SLAB.get()).getFamily();
    public static final BlockFamily MILDLY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.MILDLY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get()).getFamily();
    public static final BlockFamily MODERATELY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get()).getFamily();
    public static final BlockFamily EXTREMELY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get()).getFamily();

    public static final BlockFamily WAXED_IRON_TILES = familyBuilder(ModBlocks.WAXED_IRON_TILES.get()).stairs(ModBlocks.WAXED_IRON_TILE_STAIRS.get()).slab(ModBlocks.WAXED_IRON_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_MILDLY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_MODERATELY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_EXTREMELY_RUSTED_IRON_TILES = familyBuilder(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILES.get()).stairs(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get()).slab(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get()).dontGenerateModel().getFamily();

    public static final BlockFamily GOLD_TILES = familyBuilder(ModBlocks.GOLD_TILES.get()).stairs(ModBlocks.GOLD_TILE_STAIRS.get()).slab(ModBlocks.GOLD_TILE_SLAB.get()).getFamily();
    public static final BlockFamily DIAMOND_TILES = familyBuilder(ModBlocks.DIAMOND_TILES.get()).stairs(ModBlocks.DIAMOND_TILE_STAIRS.get()).slab(ModBlocks.DIAMOND_TILE_SLAB.get()).getFamily();
    public static final BlockFamily EMERALD_TILES = familyBuilder(ModBlocks.EMERALD_TILES.get()).stairs(ModBlocks.EMERALD_TILE_STAIRS.get()).slab(ModBlocks.EMERALD_TILE_SLAB.get()).getFamily();
    public static final BlockFamily NETHERITE_TILES = familyBuilder(ModBlocks.NETHERITE_TILES.get()).stairs(ModBlocks.NETHERITE_TILE_STAIRS.get()).slab(ModBlocks.NETHERITE_TILE_SLAB.get()).getFamily();

    public static final BlockFamily POLISHED_DRIPSTONE = familyBuilder(ModBlocks.POLISHED_DRIPSTONE.get()).stairs(ModBlocks.POLISHED_DRIPSTONE_STAIRS.get()).slab(ModBlocks.POLISHED_DRIPSTONE_SLAB.get()).wall(ModBlocks.POLISHED_DRIPSTONE_WALL.get()).polished(ModBlocks.DRIPSTONE_BRICKS.get()).getFamily();
    public static final BlockFamily POLISHED_CALCITE = familyBuilder(ModBlocks.POLISHED_CALCITE.get()).stairs(ModBlocks.POLISHED_CALCITE_STAIRS.get()).slab(ModBlocks.POLISHED_CALCITE_SLAB.get()).wall(ModBlocks.POLISHED_CALCITE_WALL.get()).polished(ModBlocks.CALCITE_BRICKS.get()).getFamily();

    public static final BlockFamily POLISHED_GRANITE_BRICKS = familyBuilder(ModBlocks.POLISHED_GRANITE_BRICKS.get()).stairs(ModBlocks.POLISHED_GRANITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_GRANITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_GRANITE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_DIORITE_BRICKS = familyBuilder(ModBlocks.POLISHED_DIORITE_BRICKS.get()).stairs(ModBlocks.POLISHED_DIORITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_DIORITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_DIORITE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_ANDESITE_BRICKS = familyBuilder(ModBlocks.POLISHED_ANDESITE_BRICKS.get()).stairs(ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_ANDESITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_ANDESITE_BRICK_WALL.get()).getFamily();

    public static final BlockFamily CALCITE_BRICKS = familyBuilder(ModBlocks.CALCITE_BRICKS.get()).stairs(ModBlocks.CALCITE_BRICK_STAIRS.get()).slab(ModBlocks.CALCITE_BRICK_SLAB.get()).wall(ModBlocks.CALCITE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily DRIPSTONE_BRICKS = familyBuilder(ModBlocks.DRIPSTONE_BRICKS.get()).stairs(ModBlocks.DRIPSTONE_BRICK_STAIRS.get()).slab(ModBlocks.DRIPSTONE_BRICK_SLAB.get()).wall(ModBlocks.DRIPSTONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily BASALT_BRICKS = familyBuilder(ModBlocks.BASALT_BRICKS.get()).stairs(ModBlocks.BASALT_BRICK_STAIRS.get()).slab(ModBlocks.BASALT_BRICK_SLAB.get()).wall(ModBlocks.BASALT_BRICK_WALL.get()).getFamily();

    public static final BlockFamily SOUL_SANDSTONE = familyBuilder(ModBlocks.SOUL_SANDSTONE.get()).slab(ModBlocks.SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.SOUL_SANDSTONE_WALL.get()).cut(ModBlocks.CUT_SOUL_SANDSTONE.get()).chiseled(ModBlocks.CHISELED_SOUL_SANDSTONE.get()).getFamily();
    public static final BlockFamily CUT_SOUL_SANDSTONE = familyBuilder(ModBlocks.CUT_SOUL_SANDSTONE.get()).slab(ModBlocks.CUT_SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.CUT_SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_SOUL_SANDSTONE_WALL.get()).getFamily();
    public static final BlockFamily SMOOTH_SOUL_SANDSTONE = familyBuilder(ModBlocks.SMOOTH_SOUL_SANDSTONE.get()).slab(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL.get()).getFamily();

    public static final BlockFamily ELDER_PRISMARINE = familyBuilder(ModBlocks.ELDER_PRISMARINE.get()).slab(ModBlocks.ELDER_PRISMARINE_SLAB.get()).stairs(ModBlocks.ELDER_PRISMARINE_STAIRS.get()).wall(ModBlocks.ELDER_PRISMARINE_WALL.get()).getFamily();
    public static final BlockFamily ELDER_PRISMARINE_BRICKS = familyBuilder(ModBlocks.ELDER_PRISMARINE_BRICKS.get()).slab(ModBlocks.ELDER_PRISMARINE_BRICK_SLAB.get()).stairs(ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS.get()).wall(ModBlocks.ELDER_PRISMARINE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily DARK_ELDER_PRISMARINE = familyBuilder(ModBlocks.DARK_ELDER_PRISMARINE.get()).slab(ModBlocks.DARK_ELDER_PRISMARINE_SLAB.get()).stairs(ModBlocks.DARK_ELDER_PRISMARINE_STAIRS.get()).wall(ModBlocks.DARK_ELDER_PRISMARINE_WALL.get()).getFamily();

    public static final BlockFamily ZINC_BLOCK = familyBuilder(ModBlocks.ZINC_BLOCK.get()).cut(ModBlocks.ZINC_TILES.get()).getFamily();
    public static final BlockFamily SLIGHTLY_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get()).getFamily();
    public static final BlockFamily SOMEWHAT_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get()).getFamily();
    public static final BlockFamily REALLY_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.REALLY_CORRODED_ZINC_TILES.get()).getFamily();

    public static final BlockFamily WAXED_ZINC_BLOCK = familyBuilder(ModBlocks.WAXED_ZINC_BLOCK.get()).cut(ModBlocks.WAXED_ZINC_TILES.get()).getFamily();
    public static final BlockFamily WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get()).getFamily();
    public static final BlockFamily WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get()).getFamily();
    public static final BlockFamily WAXED_REALLY_CORRODED_ZINC_BLOCK = familyBuilder(ModBlocks.WAXED_REALLY_CORRODED_ZINC_BLOCK.get()).cut(ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get()).getFamily();

    public static final BlockFamily ZINC_TILES = familyBuilder(ModBlocks.ZINC_TILES.get()).stairs(ModBlocks.ZINC_TILE_STAIRS.get()).slab(ModBlocks.ZINC_TILE_SLAB.get()).getFamily();
    public static final BlockFamily SLIGHTLY_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get()).getFamily();
    public static final BlockFamily SOMEWHAT_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get()).getFamily();
    public static final BlockFamily REALLY_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.REALLY_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get()).getFamily();

    public static final BlockFamily WAXED_ZINC_TILES = familyBuilder(ModBlocks.WAXED_ZINC_TILES.get()).stairs(ModBlocks.WAXED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.WAXED_ZINC_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_SLIGHTLY_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_SOMEWHAT_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_REALLY_CORRODED_ZINC_TILES = familyBuilder(ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get()).stairs(ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get()).slab(ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get()).dontGenerateModel().getFamily();

    public static final BlockFamily SILVER_BLOCK = familyBuilder(ModBlocks.SILVER_BLOCK.get()).cut(ModBlocks.SILVER_TILES.get()).getFamily();
    public static final BlockFamily SILVER_TILES = familyBuilder(ModBlocks.SILVER_TILES.get()).slab(ModBlocks.SILVER_TILE_SLAB.get()).stairs(ModBlocks.SILVER_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily TIN_BLOCK = familyBuilder(ModBlocks.TIN_BLOCK.get()).cut(ModBlocks.CUT_TIN.get()).getFamily();
    public static final BlockFamily CUT_TIN = familyBuilder(ModBlocks.CUT_TIN.get()).slab(ModBlocks.CUT_TIN_SLAB.get()).stairs(ModBlocks.CUT_TIN_STAIRS.get()).getFamily();

    public static final BlockFamily TUNGSTEN_BLOCK = familyBuilder(ModBlocks.TUNGSTEN_BLOCK.get()).cut(ModBlocks.TUNGSTEN_TILES.get()).getFamily();
    public static final BlockFamily TUNGSTEN_TILES = familyBuilder(ModBlocks.TUNGSTEN_TILES.get()).slab(ModBlocks.TUNGSTEN_TILE_SLAB.get()).stairs(ModBlocks.TUNGSTEN_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily PLATINUM_BLOCK = familyBuilder(ModBlocks.PLATINUM_BLOCK.get()).cut(ModBlocks.PLATINUM_TILES.get()).getFamily();
    public static final BlockFamily PLATINUM_TILES = familyBuilder(ModBlocks.PLATINUM_TILES.get()).slab(ModBlocks.PLATINUM_TILE_SLAB.get()).stairs(ModBlocks.PLATINUM_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily LEAD_BLOCK = familyBuilder(ModBlocks.LEAD_BLOCK.get()).cut(ModBlocks.LEAD_TILES.get()).getFamily();
    public static final BlockFamily LEAD_TILES = familyBuilder(ModBlocks.LEAD_TILES.get()).slab(ModBlocks.LEAD_TILE_SLAB.get()).stairs(ModBlocks.LEAD_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily URANIUM_BLOCK = familyBuilder(ModBlocks.URANIUM_BLOCK.get()).cut(ModBlocks.URANIUM_TILES.get()).getFamily();
    public static final BlockFamily URANIUM_TILES = familyBuilder(ModBlocks.URANIUM_TILES.get()).slab(ModBlocks.URANIUM_TILE_SLAB.get()).stairs(ModBlocks.URANIUM_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily BRONZE_BLOCK = familyBuilder(ModBlocks.BRONZE_BLOCK.get()).cut(ModBlocks.CUT_BRONZE.get()).getFamily();
    public static final BlockFamily CUT_BRONZE = familyBuilder(ModBlocks.CUT_BRONZE.get()).slab(ModBlocks.CUT_BRONZE_SLAB.get()).stairs(ModBlocks.CUT_BRONZE_STAIRS.get()).getFamily();

    public static final BlockFamily BRASS_BLOCK = familyBuilder(ModBlocks.BRASS_BLOCK.get()).cut(ModBlocks.BRASS_TILES.get()).getFamily();
    public static final BlockFamily BRASS_TILES = familyBuilder(ModBlocks.BRASS_TILES.get()).slab(ModBlocks.BRASS_TILE_SLAB.get()).stairs(ModBlocks.BRASS_TILE_STAIRS.get()).getFamily();

    public static final BlockFamily STEEL_BLOCK = familyBuilder(ModBlocks.STEEL_BLOCK.get()).cut(ModBlocks.STEEL_TILES.get()).getFamily();
    public static final BlockFamily STEEL_TILES = familyBuilder(ModBlocks.STEEL_TILES.get()).slab(ModBlocks.STEEL_TILE_SLAB.get()).stairs(ModBlocks.STEEL_TILE_STAIRS.get()).getFamily();

}
