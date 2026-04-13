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

    public static final BlockFamily COBBLESTONE = familyBuilder(Blocks.COBBLESTONE).fence(ModBlocks.COBBLESTONE_FENCE.get()).polished(ModBlocks.POLISHED_STONE.get()).getFamily();
    public static final BlockFamily MOSSY_COBBLESTONE = familyBuilder(Blocks.MOSSY_COBBLESTONE).fence(ModBlocks.MOSSY_COBBLESTONE_FENCE.get()).getFamily();
    public static final BlockFamily STONE_BRICKS = familyBuilder(Blocks.STONE_BRICKS).polished(ModBlocks.STONE_TILES.get()).fence(ModBlocks.STONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily MOSSY_STONE_BRICKS = familyBuilder(Blocks.MOSSY_STONE_BRICKS).fence(ModBlocks.MOSSY_STONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily GRANITE = familyBuilder(Blocks.GRANITE).fence(ModBlocks.GRANITE_FENCE.get()).getFamily();
    public static final BlockFamily DIORITE = familyBuilder(Blocks.DIORITE).fence(ModBlocks.DIORITE_FENCE.get()).getFamily();
    public static final BlockFamily ANDESITE = familyBuilder(Blocks.ANDESITE).fence(ModBlocks.ANDESITE_FENCE.get()).getFamily();
    public static final BlockFamily COBBLED_DEEPSLATE = familyBuilder(Blocks.COBBLED_DEEPSLATE).fence(ModBlocks.COBBLED_DEEPSLATE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_DEEPSLATE = familyBuilder(Blocks.POLISHED_DEEPSLATE).fence(ModBlocks.POLISHED_DEEPSLATE_FENCE.get()).getFamily();
    public static final BlockFamily DEEPSLATE_BRICKS = familyBuilder(Blocks.DEEPSLATE_BRICKS).fence(ModBlocks.DEEPSLATE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily DEEPSLATE_TILES = familyBuilder(Blocks.DEEPSLATE_TILES).fence(ModBlocks.DEEPSLATE_TILE_FENCE.get()).getFamily();
    public static final BlockFamily TUFF = familyBuilder(Blocks.TUFF).fence(ModBlocks.TUFF_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_TUFF = familyBuilder(Blocks.POLISHED_TUFF).fence(ModBlocks.POLISHED_TUFF_FENCE.get()).getFamily();
    public static final BlockFamily TUFF_BRICKS = familyBuilder(Blocks.TUFF_BRICKS).fence(ModBlocks.TUFF_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BRICKS = familyBuilder(Blocks.BRICKS).fence(ModBlocks.BRICK_FENCE.get()).polished(ModBlocks.BIG_BRICKS.get()).getFamily();
    public static final BlockFamily MUD_BRICKS = familyBuilder(Blocks.MUD_BRICKS).fence(ModBlocks.MUD_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily RESIN_BRICKS = familyBuilder(Blocks.RESIN_BRICKS).fence(ModBlocks.RESIN_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily SANDSTONE = familyBuilder(Blocks.SANDSTONE).fence(ModBlocks.SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily RED_SANDSTONE = familyBuilder(Blocks.RED_SANDSTONE).fence(ModBlocks.RED_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily PRISMARINE = familyBuilder(Blocks.PRISMARINE).slab(Blocks.PRISMARINE_SLAB).fence(ModBlocks.PRISMARINE_FENCE.get()).chiseled(ModBlocks.CHISELED_PRISMARINE.get()).getFamily();
    public static final BlockFamily RED_NETHER_BRICKS = familyBuilder(Blocks.RED_NETHER_BRICKS).fence(ModBlocks.RED_NETHER_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLACKSTONE = familyBuilder(Blocks.BLACKSTONE).fence(ModBlocks.BLACKSTONE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_BLACKSTONE = familyBuilder(Blocks.POLISHED_BLACKSTONE).fence(ModBlocks.POLISHED_BLACKSTONE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.POLISHED_BLACKSTONE_BRICKS).fence(ModBlocks.POLISHED_BLACKSTONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily END_STONE_BRICKS = familyBuilder(Blocks.END_STONE_BRICKS).fence(ModBlocks.END_STONE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily POLISHED_GRANITE = familyBuilder(Blocks.POLISHED_GRANITE).wall(ModBlocks.POLISHED_GRANITE_WALL.get()).fence(ModBlocks.POLISHED_GRANITE_FENCE.get()).polished(ModBlocks.POLISHED_GRANITE_BRICKS.get()).getFamily();
    public static final BlockFamily POLISHED_DIORITE = familyBuilder(Blocks.POLISHED_DIORITE).wall(ModBlocks.POLISHED_DIORITE_WALL.get()).fence(ModBlocks.POLISHED_DIORITE_FENCE.get()).polished(ModBlocks.POLISHED_DIORITE_BRICKS.get()).getFamily();
    public static final BlockFamily POLISHED_ANDESITE = familyBuilder(Blocks.POLISHED_ANDESITE).wall(ModBlocks.POLISHED_ANDESITE_WALL.get()).fence(ModBlocks.POLISHED_ANDESITE_FENCE.get()).polished(ModBlocks.POLISHED_ANDESITE_BRICKS.get()).getFamily();
    public static final BlockFamily PRISMARINE_BRICKS = familyBuilder(Blocks.PRISMARINE_BRICKS).slab(Blocks.PRISMARINE_BRICK_SLAB).wall(ModBlocks.PRISMARINE_BRICK_WALL.get()).fence(ModBlocks.PRISMARINE_BRICK_FENCE.get()).chiseled(ModBlocks.CHISELED_PRISMARINE_BRICKS.get()).getFamily();
    public static final BlockFamily DARK_PRISMARINE = familyBuilder(Blocks.DARK_PRISMARINE).wall(ModBlocks.DARK_PRISMARINE_WALL.get()).fence(ModBlocks.DARK_PRISMARINE_FENCE.get()).getFamily();
    public static final BlockFamily STONE = familyBuilder(Blocks.STONE).wall(ModBlocks.STONE_WALL.get()).fence(ModBlocks.STONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_SANDSTONE = familyBuilder(Blocks.SMOOTH_SANDSTONE).wall(ModBlocks.SMOOTH_SANDSTONE_WALL.get()).fence(ModBlocks.SMOOTH_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_RED_SANDSTONE = familyBuilder(Blocks.SMOOTH_RED_SANDSTONE).wall(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get()).fence(ModBlocks.SMOOTH_RED_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily QUARTZ = familyBuilder(Blocks.QUARTZ_BLOCK).wall(ModBlocks.QUARTZ_WALL.get()).fence(ModBlocks.QUARTZ_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_QUARTZ = familyBuilder(Blocks.SMOOTH_QUARTZ).wall(ModBlocks.SMOOTH_QUARTZ_WALL.get()).fence(ModBlocks.SMOOTH_QUARTZ_FENCE.get()).getFamily();
    public static final BlockFamily PURPUR = familyBuilder(Blocks.PURPUR_BLOCK).wall(ModBlocks.PURPUR_WALL.get()).fence(ModBlocks.PURPUR_FENCE.get()).getFamily();

    public static final BlockFamily SMOOTH_STONE = familyBuilder(Blocks.SMOOTH_STONE).stairs(ModBlocks.SMOOTH_STONE_STAIRS.get()).wall(ModBlocks.SMOOTH_STONE_WALL.get()).fence(ModBlocks.SMOOTH_STONE_FENCE.get()).getFamily();
    public static final BlockFamily CUT_SANDSTONE = familyBuilder(Blocks.CUT_SANDSTONE).stairs(ModBlocks.CUT_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_SANDSTONE_WALL.get()).fence(ModBlocks.CUT_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily CUT_RED_SANDSTONE = familyBuilder(Blocks.CUT_RED_SANDSTONE).stairs(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_RED_SANDSTONE_WALL.get()).fence(ModBlocks.CUT_RED_SANDSTONE_FENCE.get()).getFamily();

    public static final BlockFamily CRACKED_STONE_BRICKS = familyBuilder(Blocks.CRACKED_STONE_BRICKS).stairs(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_STONE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_STONE_BRICK_WALL.get()).fence(ModBlocks.CRACKED_STONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BASALT = familyBuilder(Blocks.BASALT).stairs(ModBlocks.BASALT_STAIRS.get()).slab(ModBlocks.BASALT_SLAB.get()).wall(ModBlocks.BASALT_WALL.get()).fence(ModBlocks.BASALT_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_BASALT = familyBuilder(Blocks.POLISHED_BASALT).stairs(ModBlocks.POLISHED_BASALT_STAIRS.get()).slab(ModBlocks.POLISHED_BASALT_SLAB.get()).wall(ModBlocks.POLISHED_BASALT_WALL.get()).fence(ModBlocks.POLISHED_BASALT_FENCE.get()).polished(ModBlocks.BASALT_BRICKS.get()).getFamily();
    public static final BlockFamily SMOOTH_BASALT = familyBuilder(Blocks.SMOOTH_BASALT).stairs(ModBlocks.SMOOTH_BASALT_STAIRS.get()).slab(ModBlocks.SMOOTH_BASALT_SLAB.get()).wall(ModBlocks.SMOOTH_BASALT_WALL.get()).fence(ModBlocks.SMOOTH_BASALT_FENCE.get()).getFamily();
    public static final BlockFamily DEEPSLATE = familyBuilder(Blocks.DEEPSLATE).stairs(ModBlocks.DEEPSLATE_STAIRS.get()).slab(ModBlocks.DEEPSLATE_SLAB.get()).wall(ModBlocks.DEEPSLATE_WALL.get()).fence(ModBlocks.DEEPSLATE_FENCE.get()).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_BRICKS = familyBuilder(Blocks.CRACKED_DEEPSLATE_BRICKS).stairs(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get()).fence(ModBlocks.CRACKED_DEEPSLATE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_TILES = familyBuilder(Blocks.CRACKED_DEEPSLATE_TILES).stairs(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get()).slab(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get()).wall(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get()).fence(ModBlocks.CRACKED_DEEPSLATE_TILE_FENCE.get()).getFamily();
    public static final BlockFamily CRACKED_NETHER_BRICKS = familyBuilder(Blocks.CRACKED_NETHER_BRICKS).stairs(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_NETHER_BRICK_WALL.get()).fence(ModBlocks.CRACKED_NETHER_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CRACKED_POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).stairs(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get()).slab(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get()).wall(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get()).fence(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily NETHERRACK = familyBuilder(Blocks.NETHERRACK).stairs(ModBlocks.NETHERRACK_STAIRS.get()).slab(ModBlocks.NETHERRACK_SLAB.get()).wall(ModBlocks.NETHERRACK_WALL.get()).fence(ModBlocks.NETHERRACK_FENCE.get()).polished(ModBlocks.NETHERRACK_BRICKS.get()).getFamily();
    public static final BlockFamily CALCITE = familyBuilder(Blocks.CALCITE).polished(ModBlocks.POLISHED_CALCITE.get()).stairs(ModBlocks.CALCITE_STAIRS.get()).slab(ModBlocks.CALCITE_SLAB.get()).wall(ModBlocks.CALCITE_WALL.get()).fence(ModBlocks.CALCITE_FENCE.get()).getFamily();
    public static final BlockFamily DRIPSTONE = familyBuilder(Blocks.DRIPSTONE_BLOCK).polished(ModBlocks.POLISHED_DRIPSTONE.get()).stairs(ModBlocks.DRIPSTONE_STAIRS.get()).slab(ModBlocks.DRIPSTONE_SLAB.get()).wall(ModBlocks.DRIPSTONE_WALL.get()).fence(ModBlocks.DRIPSTONE_FENCE.get()).getFamily();
    public static final BlockFamily END_STONE = familyBuilder(Blocks.END_STONE).stairs(ModBlocks.END_STONE_STAIRS.get()).slab(ModBlocks.END_STONE_SLAB.get()).wall(ModBlocks.END_STONE_WALL.get()).fence(ModBlocks.END_STONE_FENCE.get()).getFamily();
    public static final BlockFamily QUARTZ_BRICKS = familyBuilder(Blocks.QUARTZ_BRICKS).stairs(ModBlocks.QUARTZ_BRICK_STAIRS.get()).slab(ModBlocks.QUARTZ_BRICK_SLAB.get()).wall(ModBlocks.QUARTZ_BRICK_WALL.get()).fence(ModBlocks.QUARTZ_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PACKED_MUD = familyBuilder(Blocks.PACKED_MUD).stairs(ModBlocks.PACKED_MUD_STAIRS.get()).slab(ModBlocks.PACKED_MUD_SLAB.get()).wall(ModBlocks.PACKED_MUD_WALL.get()).fence(ModBlocks.PACKED_MUD_FENCE.get()).getFamily();
    public static final BlockFamily RESIN = familyBuilder(Blocks.RESIN_BLOCK).stairs(ModBlocks.RESIN_STAIRS.get()).slab(ModBlocks.RESIN_SLAB.get()).wall(ModBlocks.RESIN_WALL.get()).fence(ModBlocks.RESIN_FENCE.get()).getFamily();

    public static final BlockFamily IRON_BLOCK = familyBuilder(Blocks.IRON_BLOCK).cut(ModBlocks.CUT_IRON.get()).getFamily();
    public static final BlockFamily EXPOSED_IRON = familyBuilder(ModBlocks.EXPOSED_IRON.get()).cut(ModBlocks.EXPOSED_CUT_IRON.get()).getFamily();
    public static final BlockFamily WEATHERED_IRON = familyBuilder(ModBlocks.WEATHERED_IRON.get()).cut(ModBlocks.WEATHERED_IRON.get()).getFamily();
    public static final BlockFamily RUSTED_IRON = familyBuilder(ModBlocks.RUSTED_IRON.get()).cut(ModBlocks.RUSTED_IRON.get()).getFamily();

    public static final BlockFamily WAXED_IRON_BLOCK = familyBuilder(ModBlocks.WAXED_IRON_BLOCK.get()).cut(ModBlocks.WAXED_CUT_IRON.get()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_IRON = familyBuilder(ModBlocks.WAXED_EXPOSED_IRON.get()).cut(ModBlocks.WAXED_EXPOSED_CUT_IRON.get()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_IRON = familyBuilder(ModBlocks.WAXED_WEATHERED_IRON.get()).cut(ModBlocks.WAXED_WEATHERED_IRON.get()).getFamily();
    public static final BlockFamily WAXED_RUSTED_IRON = familyBuilder(ModBlocks.WAXED_RUSTED_IRON.get()).cut(ModBlocks.WAXED_RUSTED_IRON.get()).getFamily();

    public static final BlockFamily GOLD_BLOCK = familyBuilder(Blocks.GOLD_BLOCK).cut(ModBlocks.CUT_GOLD.get()).getFamily();
    public static final BlockFamily DIAMOND_BLOCK = familyBuilder(Blocks.DIAMOND_BLOCK).cut(ModBlocks.CUT_DIAMOND.get()).getFamily();
    public static final BlockFamily EMERALD_BLOCK = familyBuilder(Blocks.EMERALD_BLOCK).cut(ModBlocks.CUT_EMERALD.get()).getFamily();
    public static final BlockFamily NETHERITE_BLOCK = familyBuilder(Blocks.NETHERITE_BLOCK).cut(ModBlocks.CUT_NETHERITE.get()).getFamily();
    public static final BlockFamily AMETHYST_BLOCK = familyBuilder(Blocks.AMETHYST_BLOCK).cut(ModBlocks.CUT_AMETHYST.get()).getFamily();

    public static final BlockFamily CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.get()).stairs(ModBlocks.CUT_IRON_STAIRS.get()).slab(ModBlocks.CUT_IRON_SLAB.get()).getFamily();
    public static final BlockFamily EXPOSED_CUT_IRON = familyBuilder(ModBlocks.EXPOSED_CUT_IRON.get()).stairs(ModBlocks.EXPOSED_CUT_IRON_STAIRS.get()).slab(ModBlocks.EXPOSED_CUT_IRON_SLAB.get()).getFamily();
    public static final BlockFamily WEATHERED_CUT_IRON = familyBuilder(ModBlocks.WEATHERED_CUT_IRON.get()).stairs(ModBlocks.WEATHERED_CUT_IRON_STAIRS.get()).slab(ModBlocks.WEATHERED_CUT_IRON_SLAB.get()).getFamily();
    public static final BlockFamily RUSTED_CUT_IRON = familyBuilder(ModBlocks.RUSTED_CUT_IRON.get()).stairs(ModBlocks.RUSTED_CUT_IRON_STAIRS.get()).slab(ModBlocks.RUSTED_CUT_IRON_SLAB.get()).getFamily();

    public static final BlockFamily WAXED_CUT_IRON = familyBuilder(ModBlocks.WAXED_CUT_IRON.get()).stairs(ModBlocks.WAXED_CUT_IRON_STAIRS.get()).slab(ModBlocks.WAXED_CUT_IRON_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_EXPOSED_CUT_IRON = familyBuilder(ModBlocks.WAXED_EXPOSED_CUT_IRON.get()).stairs(ModBlocks.WAXED_EXPOSED_CUT_IRON_STAIRS.get()).slab(ModBlocks.WAXED_EXPOSED_CUT_IRON_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_WEATHERED_CUT_IRON = familyBuilder(ModBlocks.WAXED_WEATHERED_CUT_IRON.get()).stairs(ModBlocks.WAXED_WEATHERED_CUT_IRON_STAIRS.get()).slab(ModBlocks.WAXED_WEATHERED_CUT_IRON_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_RUSTED_CUT_IRON = familyBuilder(ModBlocks.WAXED_RUSTED_CUT_IRON.get()).stairs(ModBlocks.WAXED_RUSTED_CUT_COPPER_STAIRS.get()).slab(ModBlocks.WAXED_RUSTED_CUT_IRON_SLAB.get()).dontGenerateModel().getFamily();

    public static final BlockFamily CUT_GOLD = familyBuilder(ModBlocks.CUT_GOLD.get()).stairs(ModBlocks.CUT_GOLD_STAIRS.get()).slab(ModBlocks.CUT_GOLD_SLAB.get()).getFamily();
    public static final BlockFamily CUT_DIAMOND = familyBuilder(ModBlocks.CUT_DIAMOND.get()).stairs(ModBlocks.CUT_DIAMOND_STAIRS.get()).slab(ModBlocks.CUT_DIAMOND_SLAB.get()).getFamily();
    public static final BlockFamily CUT_EMERALD = familyBuilder(ModBlocks.CUT_EMERALD.get()).stairs(ModBlocks.CUT_EMERALD_SLAB.get()).slab(ModBlocks.CUT_EMERALD_STAIRS.get()).getFamily();
    public static final BlockFamily CUT_NETHERITE = familyBuilder(ModBlocks.CUT_NETHERITE.get()).stairs(ModBlocks.CUT_NETHERITE_STAIRS.get()).slab(ModBlocks.CUT_NETHERITE_SLAB.get()).getFamily();
    public static final BlockFamily CUT_AMETHYST = familyBuilder(ModBlocks.CUT_AMETHYST.get()).slab(ModBlocks.CUT_AMETHYST_SLAB.get()).stairs(ModBlocks.CUT_AMETHYST_STAIRS.get()).getFamily();

    public static final BlockFamily POLISHED_DRIPSTONE = familyBuilder(ModBlocks.POLISHED_DRIPSTONE.get()).stairs(ModBlocks.POLISHED_DRIPSTONE_STAIRS.get()).slab(ModBlocks.POLISHED_DRIPSTONE_SLAB.get()).wall(ModBlocks.POLISHED_DRIPSTONE_WALL.get()).polished(ModBlocks.DRIPSTONE_BRICKS.get()).fence(ModBlocks.POLISHED_DRIPSTONE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_CALCITE = familyBuilder(ModBlocks.POLISHED_CALCITE.get()).stairs(ModBlocks.POLISHED_CALCITE_STAIRS.get()).slab(ModBlocks.POLISHED_CALCITE_SLAB.get()).wall(ModBlocks.POLISHED_CALCITE_WALL.get()).polished(ModBlocks.CALCITE_BRICKS.get()).fence(ModBlocks.POLISHED_CALCITE_FENCE.get()).getFamily();

    public static final BlockFamily POLISHED_GRANITE_BRICKS = familyBuilder(ModBlocks.POLISHED_GRANITE_BRICKS.get()).stairs(ModBlocks.POLISHED_GRANITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_GRANITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_GRANITE_BRICK_WALL.get()).fence(ModBlocks.POLISHED_GRANITE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_DIORITE_BRICKS = familyBuilder(ModBlocks.POLISHED_DIORITE_BRICKS.get()).stairs(ModBlocks.POLISHED_DIORITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_DIORITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_DIORITE_BRICK_WALL.get()).fence(ModBlocks.POLISHED_DIORITE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_ANDESITE_BRICKS = familyBuilder(ModBlocks.POLISHED_ANDESITE_BRICKS.get()).stairs(ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS.get()).slab(ModBlocks.POLISHED_ANDESITE_BRICK_SLAB.get()).wall(ModBlocks.POLISHED_ANDESITE_BRICK_WALL.get()).fence(ModBlocks.POLISHED_ANDESITE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily CALCITE_BRICKS = familyBuilder(ModBlocks.CALCITE_BRICKS.get()).stairs(ModBlocks.CALCITE_BRICK_STAIRS.get()).slab(ModBlocks.CALCITE_BRICK_SLAB.get()).wall(ModBlocks.CALCITE_BRICK_WALL.get()).fence(ModBlocks.CALCITE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily DRIPSTONE_BRICKS = familyBuilder(ModBlocks.DRIPSTONE_BRICKS.get()).stairs(ModBlocks.DRIPSTONE_BRICK_STAIRS.get()).slab(ModBlocks.DRIPSTONE_BRICK_SLAB.get()).wall(ModBlocks.DRIPSTONE_BRICK_WALL.get()).fence(ModBlocks.DRIPSTONE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BASALT_BRICKS = familyBuilder(ModBlocks.BASALT_BRICKS.get()).stairs(ModBlocks.BASALT_BRICK_STAIRS.get()).slab(ModBlocks.BASALT_BRICK_SLAB.get()).wall(ModBlocks.BASALT_BRICK_WALL.get()).fence(ModBlocks.BASALT_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily SOUL_SANDSTONE = familyBuilder(ModBlocks.SOUL_SANDSTONE.get()).slab(ModBlocks.SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.SOUL_SANDSTONE_WALL.get()).cut(ModBlocks.CUT_SOUL_SANDSTONE.get()).fence(ModBlocks.SOUL_SANDSTONE_FENCE.get()).chiseled(ModBlocks.CHISELED_SOUL_SANDSTONE.get()).getFamily();
    public static final BlockFamily CUT_SOUL_SANDSTONE = familyBuilder(ModBlocks.CUT_SOUL_SANDSTONE.get()).slab(ModBlocks.CUT_SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.CUT_SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.CUT_SOUL_SANDSTONE_WALL.get()).fence(ModBlocks.CUT_SOUL_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_SOUL_SANDSTONE = familyBuilder(ModBlocks.SMOOTH_SOUL_SANDSTONE.get()).slab(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get()).stairs(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get()).wall(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL.get()).fence(ModBlocks.SMOOTH_SOUL_SANDSTONE_FENCE.get()).getFamily();

    public static final BlockFamily ELDER_PRISMARINE = familyBuilder(ModBlocks.ELDER_PRISMARINE.get()).slab(ModBlocks.ELDER_PRISMARINE_SLAB.get()).stairs(ModBlocks.ELDER_PRISMARINE_STAIRS.get()).wall(ModBlocks.ELDER_PRISMARINE_WALL.get()).fence(ModBlocks.ELDER_PRISMARINE_FENCE.get()).chiseled(ModBlocks.CHISELED_ELDER_PRISMARINE.get()).getFamily();
    public static final BlockFamily ELDER_PRISMARINE_BRICKS = familyBuilder(ModBlocks.ELDER_PRISMARINE_BRICKS.get()).slab(ModBlocks.ELDER_PRISMARINE_BRICK_SLAB.get()).stairs(ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS.get()).wall(ModBlocks.ELDER_PRISMARINE_BRICK_WALL.get()).fence(ModBlocks.ELDER_PRISMARINE_BRICK_FENCE.get()).chiseled(ModBlocks.CHISELED_ELDER_PRISMARINE_BRICKS.get()).getFamily();
    public static final BlockFamily DARK_ELDER_PRISMARINE = familyBuilder(ModBlocks.DARK_ELDER_PRISMARINE.get()).slab(ModBlocks.DARK_ELDER_PRISMARINE_SLAB.get()).stairs(ModBlocks.DARK_ELDER_PRISMARINE_STAIRS.get()).wall(ModBlocks.DARK_ELDER_PRISMARINE_WALL.get()).fence(ModBlocks.DARK_ELDER_PRISMARINE_FENCE.get()).getFamily();

    public static final BlockFamily ZINC_BLOCK = familyBuilder(ModBlocks.ZINC_BLOCK.get()).cut(ModBlocks.CUT_ZINC.get()).getFamily();
    public static final BlockFamily EXPOSED_ZINC = familyBuilder(ModBlocks.EXPOSED_ZINC.get()).cut(ModBlocks.EXPOSED_CUT_ZINC.get()).getFamily();
    public static final BlockFamily WEATHERED_ZINC = familyBuilder(ModBlocks.WEATHERED_ZINC.get()).cut(ModBlocks.WEATHERED_CUT_ZINC.get()).getFamily();
    public static final BlockFamily CORRODED_ZINC = familyBuilder(ModBlocks.CORRODED_ZINC.get()).cut(ModBlocks.CORRODED_CUT_ZINC.get()).getFamily();

    public static final BlockFamily WAXED_ZINC_BLOCK = familyBuilder(ModBlocks.WAXED_ZINC_BLOCK.get()).cut(ModBlocks.WAXED_CUT_ZINC.get()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_ZINC = familyBuilder(ModBlocks.WAXED_EXPOSED_ZINC.get()).cut(ModBlocks.WAXED_EXPOSED_CUT_ZINC.get()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_ZINC = familyBuilder(ModBlocks.WAXED_WEATHERED_ZINC.get()).cut(ModBlocks.WAXED_WEATHERED_CUT_ZINC.get()).getFamily();
    public static final BlockFamily WAXED_CORRODED_ZINC = familyBuilder(ModBlocks.WAXED_CORRODED_ZINC.get()).cut(ModBlocks.WAXED_CORRODED_CUT_ZINC.get()).getFamily();

    public static final BlockFamily CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.get()).stairs(ModBlocks.CUT_ZINC_STAIRS.get()).slab(ModBlocks.CUT_ZINC_SLAB.get()).getFamily();
    public static final BlockFamily EXPOSED_CUT_ZINC = familyBuilder(ModBlocks.EXPOSED_CUT_ZINC.get()).stairs(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get()).getFamily();
    public static final BlockFamily WEATHERED_CUT_ZINC = familyBuilder(ModBlocks.WEATHERED_CUT_ZINC.get()).stairs(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get()).getFamily();
    public static final BlockFamily CORRODED_CUT_ZINC = familyBuilder(ModBlocks.CORRODED_CUT_ZINC.get()).stairs(ModBlocks.CORRODED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.CORRODED_CUT_ZINC_SLAB.get()).getFamily();

    public static final BlockFamily WAXED_CUT_ZINC = familyBuilder(ModBlocks.WAXED_CUT_ZINC.get()).stairs(ModBlocks.WAXED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.WAXED_CUT_ZINC_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_EXPOSED_CUT_ZINC = familyBuilder(ModBlocks.WAXED_EXPOSED_CUT_ZINC.get()).stairs(ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_WEATHERED_CUT_ZINC = familyBuilder(ModBlocks.WAXED_WEATHERED_CUT_ZINC.get()).stairs(ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get()).dontGenerateModel().getFamily();
    public static final BlockFamily WAXED_CORRODED_CUT_ZINC = familyBuilder(ModBlocks.WAXED_CORRODED_CUT_ZINC.get()).stairs(ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get()).slab(ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get()).dontGenerateModel().getFamily();

    public static final BlockFamily SILVER_BLOCK = familyBuilder(ModBlocks.SILVER_BLOCK.get()).cut(ModBlocks.CUT_SILVER.get()).getFamily();
    public static final BlockFamily CUT_SILVER = familyBuilder(ModBlocks.CUT_SILVER.get()).slab(ModBlocks.CUT_SILVER_SLAB.get()).stairs(ModBlocks.CUT_SILVER_STAIRS.get()).getFamily();

    public static final BlockFamily TIN_BLOCK = familyBuilder(ModBlocks.TIN_BLOCK.get()).cut(ModBlocks.CUT_TIN.get()).getFamily();
    public static final BlockFamily CUT_TIN = familyBuilder(ModBlocks.CUT_TIN.get()).slab(ModBlocks.CUT_TIN_SLAB.get()).stairs(ModBlocks.CUT_TIN_STAIRS.get()).getFamily();

    public static final BlockFamily TUNGSTEN_BLOCK = familyBuilder(ModBlocks.TUNGSTEN_BLOCK.get()).cut(ModBlocks.CUT_TUNGSTEN.get()).getFamily();
    public static final BlockFamily CUT_TUNGSTEN = familyBuilder(ModBlocks.CUT_TUNGSTEN.get()).slab(ModBlocks.CUT_TUNGSTEN_SLAB.get()).stairs(ModBlocks.CUT_TUNGSTEN_STAIRS.get()).getFamily();

    public static final BlockFamily PLATINUM_BLOCK = familyBuilder(ModBlocks.PLATINUM_BLOCK.get()).cut(ModBlocks.CUT_PLATINUM.get()).getFamily();
    public static final BlockFamily CUT_PLATINUM = familyBuilder(ModBlocks.CUT_PLATINUM.get()).slab(ModBlocks.CUT_PLATINUM_SLAB.get()).stairs(ModBlocks.CUT_PLATINUM_STAIRS.get()).getFamily();

    public static final BlockFamily LEAD_BLOCK = familyBuilder(ModBlocks.LEAD_BLOCK.get()).cut(ModBlocks.CUT_LEAD.get()).getFamily();
    public static final BlockFamily CUT_LEAD = familyBuilder(ModBlocks.CUT_LEAD.get()).slab(ModBlocks.CUT_LEAD_SLAB.get()).stairs(ModBlocks.CUT_LEAD_STAIRS.get()).getFamily();

    public static final BlockFamily URANIUM_BLOCK = familyBuilder(ModBlocks.URANIUM_BLOCK.get()).cut(ModBlocks.CUT_URANIUM.get()).getFamily();
    public static final BlockFamily CUT_URANIUM = familyBuilder(ModBlocks.CUT_URANIUM.get()).slab(ModBlocks.CUT_URANIUM_SLAB.get()).stairs(ModBlocks.CUT_URANIUM_STAIRS.get()).getFamily();

    public static final BlockFamily BRONZE_BLOCK = familyBuilder(ModBlocks.BRONZE_BLOCK.get()).cut(ModBlocks.CUT_BRONZE.get()).getFamily();
    public static final BlockFamily CUT_BRONZE = familyBuilder(ModBlocks.CUT_BRONZE.get()).slab(ModBlocks.CUT_BRONZE_SLAB.get()).stairs(ModBlocks.CUT_BRONZE_STAIRS.get()).getFamily();

    public static final BlockFamily BRASS_BLOCK = familyBuilder(ModBlocks.BRASS_BLOCK.get()).cut(ModBlocks.CUT_BRASS.get()).getFamily();
    public static final BlockFamily CUT_BRASS = familyBuilder(ModBlocks.CUT_BRASS.get()).slab(ModBlocks.CUT_BRASS_SLAB.get()).stairs(ModBlocks.CUT_BRASS_STAIRS.get()).getFamily();

    public static final BlockFamily STEEL_BLOCK = familyBuilder(ModBlocks.STEEL_BLOCK.get()).cut(ModBlocks.CUT_STEEL.get()).getFamily();
    public static final BlockFamily CUT_STEEL = familyBuilder(ModBlocks.CUT_STEEL.get()).slab(ModBlocks.CUT_STEEL_SLAB.get()).stairs(ModBlocks.CUT_STEEL_STAIRS.get()).getFamily();

    public static final BlockFamily OAK_PLANKS = familyBuilder(Blocks.OAK_PLANKS).mosaic(ModBlocks.OAK_MOSAIC.get()).getFamily();
    public static final BlockFamily SPRUCE_PLANKS = familyBuilder(Blocks.SPRUCE_PLANKS).mosaic(ModBlocks.SPRUCE_MOSAIC.get()).getFamily();
    public static final BlockFamily BIRCH_PLANKS = familyBuilder(Blocks.BIRCH_PLANKS).mosaic(ModBlocks.BIRCH_MOSAIC.get()).getFamily();
    public static final BlockFamily JUNGLE_PLANKS = familyBuilder(Blocks.JUNGLE_PLANKS).mosaic(ModBlocks.JUNGLE_MOSAIC.get()).getFamily();
    public static final BlockFamily ACACIA_PLANKS = familyBuilder(Blocks.ACACIA_PLANKS).mosaic(ModBlocks.ACACIA_MOSAIC.get()).getFamily();
    public static final BlockFamily DARK_OAK_PLANKS = familyBuilder(Blocks.DARK_OAK_PLANKS).mosaic(ModBlocks.DARK_OAK_MOSAIC.get()).getFamily();
    public static final BlockFamily CRIMSON_PLANKS = familyBuilder(Blocks.CRIMSON_PLANKS).mosaic(ModBlocks.CRIMSON_MOSAIC.get()).getFamily();
    public static final BlockFamily WARPED_PLANKS = familyBuilder(Blocks.WARPED_PLANKS).mosaic(ModBlocks.WARPED_MOSAIC.get()).getFamily();
    public static final BlockFamily MANGROVE_PLANKS = familyBuilder(Blocks.MANGROVE_PLANKS).mosaic(ModBlocks.MANGROVE_MOSAIC.get()).getFamily();
    public static final BlockFamily CHERRY_PLANKS = familyBuilder(Blocks.CHERRY_PLANKS).mosaic(ModBlocks.CHERRY_MOSAIC.get()).getFamily();
    public static final BlockFamily PALE_OAK_PLANKS = familyBuilder(Blocks.PALE_OAK_PLANKS).mosaic(ModBlocks.PALE_OAK_MOSAIC.get()).getFamily();

    public static final BlockFamily OAK_MOSAIC = familyBuilder(ModBlocks.OAK_MOSAIC.get()).slab(ModBlocks.OAK_MOSAIC_SLAB.get()).stairs(ModBlocks.OAK_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily SPRUCE_MOSAIC = familyBuilder(ModBlocks.SPRUCE_MOSAIC.get()).slab(ModBlocks.SPRUCE_MOSAIC_SLAB.get()).stairs(ModBlocks.SPRUCE_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily BIRCH_MOSAIC = familyBuilder(ModBlocks.BIRCH_MOSAIC.get()).slab(ModBlocks.BIRCH_MOSAIC_SLAB.get()).stairs(ModBlocks.BIRCH_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily JUNGLE_MOSAIC = familyBuilder(ModBlocks.JUNGLE_MOSAIC.get()).slab(ModBlocks.JUNGLE_MOSAIC_SLAB.get()).stairs(ModBlocks.JUNGLE_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily ACACIA_MOSAIC = familyBuilder(ModBlocks.ACACIA_MOSAIC.get()).slab(ModBlocks.ACACIA_MOSAIC_SLAB.get()).stairs(ModBlocks.ACACIA_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily DARK_OAK_MOSAIC = familyBuilder(ModBlocks.DARK_OAK_MOSAIC.get()).slab(ModBlocks.DARK_OAK_MOSAIC_SLAB.get()).stairs(ModBlocks.DARK_OAK_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily CRIMSON_MOSAIC = familyBuilder(ModBlocks.CRIMSON_MOSAIC.get()).slab(ModBlocks.CRIMSON_MOSAIC_SLAB.get()).stairs(ModBlocks.CRIMSON_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily WARPED_MOSAIC = familyBuilder(ModBlocks.WARPED_MOSAIC.get()).slab(ModBlocks.WARPED_MOSAIC_SLAB.get()).stairs(ModBlocks.WARPED_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily MANGROVE_MOSAIC = familyBuilder(ModBlocks.MANGROVE_MOSAIC.get()).slab(ModBlocks.MANGROVE_MOSAIC_SLAB.get()).stairs(ModBlocks.MANGROVE_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily CHERRY_MOSAIC = familyBuilder(ModBlocks.CHERRY_MOSAIC.get()).slab(ModBlocks.CHERRY_MOSAIC_SLAB.get()).stairs(ModBlocks.CHERRY_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily PALE_OAK_MOSAIC = familyBuilder(ModBlocks.PALE_OAK_MOSAIC.get()).slab(ModBlocks.PALE_OAK_MOSAIC_SLAB.get()).stairs(ModBlocks.PALE_OAK_MOSAIC_STAIRS.get()).getFamily();

    public static final BlockFamily OBSIDIAN = familyBuilder(Blocks.OBSIDIAN).stairs(ModBlocks.OBSIDIAN_STAIRS.get()).slab(ModBlocks.OBSIDIAN_SLAB.get()).wall(ModBlocks.OBSIDIAN_WALL.get()).polished(ModBlocks.OBSIDIAN_BRICKS.get()).fence(ModBlocks.OBSIDIAN_FENCE.get()).getFamily();
    public static final BlockFamily CRYING_OBSIDIAN = familyBuilder(Blocks.CRYING_OBSIDIAN).stairs(ModBlocks.CRYING_OBSIDIAN_STAIRS.get()).slab(ModBlocks.CRYING_OBSIDIAN_SLAB.get()).wall(ModBlocks.CRYING_OBSIDIAN_WALL.get()).polished(ModBlocks.CRYING_OBSIDIAN_BRICKS.get()).fence(ModBlocks.CRYING_OBSIDIAN_FENCE.get()).getFamily();
    public static final BlockFamily COAL = familyBuilder(Blocks.COAL_BLOCK).stairs(ModBlocks.COAL_STAIRS.get()).slab(ModBlocks.COAL_SLAB.get()).wall(ModBlocks.COAL_WALL.get()).polished(ModBlocks.COAL_BRICKS.get()).fence(ModBlocks.COAL_FENCE.get()).getFamily();
    public static final BlockFamily CHARCOAL = familyBuilder(ModBlocks.CHARCOAL_BLOCK.get()).stairs(ModBlocks.CHARCOAL_STAIRS.get()).slab(ModBlocks.CHARCOAL_SLAB.get()).wall(ModBlocks.CHARCOAL_WALL.get()).polished(ModBlocks.CHARCOAL_BRICKS.get()).fence(ModBlocks.CHARCOAL_FENCE.get()).getFamily();
    public static final BlockFamily LAPIS = familyBuilder(Blocks.LAPIS_BLOCK).stairs(ModBlocks.LAPIS_STAIRS.get()).slab(ModBlocks.LAPIS_SLAB.get()).wall(ModBlocks.LAPIS_WALL.get()).polished(ModBlocks.LAPIS_BRICKS.get()).fence(ModBlocks.LAPIS_FENCE.get()).chiseled(ModBlocks.CHISELED_LAPIS.get()).getFamily();
    public static final BlockFamily SNOW = familyBuilder(Blocks.SNOW_BLOCK).stairs(ModBlocks.SNOW_STAIRS.get()).slab(ModBlocks.SNOW_SLAB.get()).wall(ModBlocks.SNOW_WALL.get()).polished(ModBlocks.SNOW_BRICKS.get()).fence(ModBlocks.SNOW_FENCE.get()).getFamily();
    public static final BlockFamily ICE = familyBuilder(Blocks.ICE).stairs(ModBlocks.ICE_STAIRS.get()).slab(ModBlocks.ICE_SLAB.get()).wall(ModBlocks.ICE_WALL.get()).polished(ModBlocks.ICE_BRICKS.get()).fence(ModBlocks.ICE_FENCE.get()).getFamily();
    public static final BlockFamily PACKED_ICE = familyBuilder(Blocks.PACKED_ICE).stairs(ModBlocks.PACKED_ICE_STAIRS.get()).slab(ModBlocks.PACKED_ICE_SLAB.get()).wall(ModBlocks.PACKED_ICE_WALL.get()).polished(ModBlocks.PACKED_ICE_BRICKS.get()).fence(ModBlocks.PACKED_ICE_FENCE.get()).getFamily();
    public static final BlockFamily BLUE_ICE = familyBuilder(Blocks.BLUE_ICE).stairs(ModBlocks.BLUE_ICE_STAIRS.get()).slab(ModBlocks.BLUE_ICE_SLAB.get()).wall(ModBlocks.BLUE_ICE_WALL.get()).polished(ModBlocks.BLUE_ICE_BRICKS.get()).fence(ModBlocks.BLUE_ICE_FENCE.get()).getFamily();
    public static final BlockFamily TERRACOTTA = familyBuilder(Blocks.TERRACOTTA).stairs(ModBlocks.TERRACOTTA_STAIRS.get()).slab(ModBlocks.TERRACOTTA_SLAB.get()).wall(ModBlocks.TERRACOTTA_WALL.get()).fence(ModBlocks.TERRACOTTA_FENCE.get()).polished(ModBlocks.TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily SCULK = familyBuilder(Blocks.SCULK).stairs(ModBlocks.SCULK_STAIRS.get()).slab(ModBlocks.SCULK_SLAB.get()).wall(ModBlocks.SCULK_WALL.get()).fence(ModBlocks.SCULK_FENCE.get()).getFamily();

    public static final BlockFamily WHITE_TERRACOTTA = familyBuilder(Blocks.WHITE_TERRACOTTA).stairs(ModBlocks.WHITE_TERRACOTTA_STAIRS.get()).slab(ModBlocks.WHITE_TERRACOTTA_SLAB.get()).wall(ModBlocks.WHITE_TERRACOTTA_WALL.get()).fence(ModBlocks.WHITE_TERRACOTTA_FENCE.get()).polished(ModBlocks.WHITE_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily ORANGE_TERRACOTTA = familyBuilder(Blocks.ORANGE_TERRACOTTA).stairs(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get()).slab(ModBlocks.ORANGE_TERRACOTTA_SLAB.get()).wall(ModBlocks.ORANGE_TERRACOTTA_WALL.get()).fence(ModBlocks.ORANGE_TERRACOTTA_FENCE.get()).polished(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily MAGENTA_TERRACOTTA = familyBuilder(Blocks.MAGENTA_TERRACOTTA).stairs(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get()).slab(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get()).wall(ModBlocks.MAGENTA_TERRACOTTA_WALL.get()).fence(ModBlocks.MAGENTA_TERRACOTTA_FENCE.get()).polished(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA = familyBuilder(Blocks.LIGHT_BLUE_TERRACOTTA).stairs(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get()).slab(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get()).wall(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get()).fence(ModBlocks.LIGHT_BLUE_TERRACOTTA_FENCE.get()).polished(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily YELLOW_TERRACOTTA = familyBuilder(Blocks.YELLOW_TERRACOTTA).stairs(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get()).slab(ModBlocks.YELLOW_TERRACOTTA_SLAB.get()).wall(ModBlocks.YELLOW_TERRACOTTA_WALL.get()).fence(ModBlocks.YELLOW_TERRACOTTA_FENCE.get()).polished(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily LIME_TERRACOTTA = familyBuilder(Blocks.LIME_TERRACOTTA).stairs(ModBlocks.LIME_TERRACOTTA_STAIRS.get()).slab(ModBlocks.LIME_TERRACOTTA_SLAB.get()).wall(ModBlocks.LIME_TERRACOTTA_WALL.get()).fence(ModBlocks.LIME_TERRACOTTA_FENCE.get()).polished(ModBlocks.LIME_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily PINK_TERRACOTTA = familyBuilder(Blocks.PINK_TERRACOTTA).stairs(ModBlocks.PINK_TERRACOTTA_STAIRS.get()).slab(ModBlocks.PINK_TERRACOTTA_SLAB.get()).wall(ModBlocks.PINK_TERRACOTTA_WALL.get()).fence(ModBlocks.PINK_TERRACOTTA_FENCE.get()).polished(ModBlocks.PINK_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily GRAY_TERRACOTTA = familyBuilder(Blocks.GRAY_TERRACOTTA).stairs(ModBlocks.GRAY_TERRACOTTA_STAIRS.get()).slab(ModBlocks.GRAY_TERRACOTTA_SLAB.get()).wall(ModBlocks.GRAY_TERRACOTTA_WALL.get()).fence(ModBlocks.GRAY_TERRACOTTA_FENCE.get()).polished(ModBlocks.GRAY_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA = familyBuilder(Blocks.LIGHT_GRAY_TERRACOTTA).stairs(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get()).slab(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get()).wall(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get()).fence(ModBlocks.LIGHT_GRAY_TERRACOTTA_FENCE.get()).polished(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily CYAN_TERRACOTTA = familyBuilder(Blocks.CYAN_TERRACOTTA).stairs(ModBlocks.CYAN_TERRACOTTA_STAIRS.get()).slab(ModBlocks.CYAN_TERRACOTTA_SLAB.get()).wall(ModBlocks.CYAN_TERRACOTTA_WALL.get()).fence(ModBlocks.CYAN_TERRACOTTA_FENCE.get()).polished(ModBlocks.CYAN_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily PURPLE_TERRACOTTA = familyBuilder(Blocks.PURPLE_TERRACOTTA).stairs(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get()).slab(ModBlocks.PURPLE_TERRACOTTA_SLAB.get()).wall(ModBlocks.PURPLE_TERRACOTTA_WALL.get()).fence(ModBlocks.PURPLE_TERRACOTTA_FENCE.get()).polished(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily BLUE_TERRACOTTA = familyBuilder(Blocks.BLUE_TERRACOTTA).stairs(ModBlocks.BLUE_TERRACOTTA_STAIRS.get()).slab(ModBlocks.BLUE_TERRACOTTA_SLAB.get()).wall(ModBlocks.BLUE_TERRACOTTA_WALL.get()).fence(ModBlocks.BLUE_TERRACOTTA_FENCE.get()).polished(ModBlocks.BLUE_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily BROWN_TERRACOTTA = familyBuilder(Blocks.BROWN_TERRACOTTA).stairs(ModBlocks.BROWN_TERRACOTTA_STAIRS.get()).slab(ModBlocks.BROWN_TERRACOTTA_SLAB.get()).wall(ModBlocks.BROWN_TERRACOTTA_WALL.get()).fence(ModBlocks.BROWN_TERRACOTTA_FENCE.get()).polished(ModBlocks.BROWN_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily GREEN_TERRACOTTA = familyBuilder(Blocks.GREEN_TERRACOTTA).stairs(ModBlocks.GREEN_TERRACOTTA_STAIRS.get()).slab(ModBlocks.GREEN_TERRACOTTA_SLAB.get()).wall(ModBlocks.GREEN_TERRACOTTA_WALL.get()).fence(ModBlocks.GREEN_TERRACOTTA_FENCE.get()).polished(ModBlocks.GREEN_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily RED_TERRACOTTA = familyBuilder(Blocks.RED_TERRACOTTA).stairs(ModBlocks.RED_TERRACOTTA_STAIRS.get()).slab(ModBlocks.RED_TERRACOTTA_SLAB.get()).wall(ModBlocks.RED_TERRACOTTA_WALL.get()).fence(ModBlocks.RED_TERRACOTTA_FENCE.get()).polished(ModBlocks.RED_TERRACOTTA_BRICKS.get()).getFamily();
    public static final BlockFamily BLACK_TERRACOTTA = familyBuilder(Blocks.BLACK_TERRACOTTA).stairs(ModBlocks.BLACK_TERRACOTTA_STAIRS.get()).slab(ModBlocks.BLACK_TERRACOTTA_SLAB.get()).wall(ModBlocks.BLACK_TERRACOTTA_WALL.get()).fence(ModBlocks.BLACK_TERRACOTTA_FENCE.get()).polished(ModBlocks.BLACK_TERRACOTTA_BRICKS.get()).getFamily();

    public static final BlockFamily WHITE_CONCRETE = familyBuilder(Blocks.WHITE_CONCRETE).stairs(ModBlocks.WHITE_CONCRETE_STAIRS.get()).slab(ModBlocks.WHITE_CONCRETE_SLAB.get()).wall(ModBlocks.WHITE_CONCRETE_WALL.get()).fence(ModBlocks.WHITE_CONCRETE_FENCE.get()).polished(ModBlocks.WHITE_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily ORANGE_CONCRETE = familyBuilder(Blocks.ORANGE_CONCRETE).stairs(ModBlocks.ORANGE_CONCRETE_STAIRS.get()).slab(ModBlocks.ORANGE_CONCRETE_SLAB.get()).wall(ModBlocks.ORANGE_CONCRETE_WALL.get()).fence(ModBlocks.ORANGE_CONCRETE_FENCE.get()).polished(ModBlocks.ORANGE_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily MAGENTA_CONCRETE = familyBuilder(Blocks.MAGENTA_CONCRETE).stairs(ModBlocks.MAGENTA_CONCRETE_STAIRS.get()).slab(ModBlocks.MAGENTA_CONCRETE_SLAB.get()).wall(ModBlocks.MAGENTA_CONCRETE_WALL.get()).fence(ModBlocks.MAGENTA_CONCRETE_FENCE.get()).polished(ModBlocks.MAGENTA_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily LIGHT_BLUE_CONCRETE = familyBuilder(Blocks.LIGHT_BLUE_CONCRETE).stairs(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get()).slab(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get()).wall(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get()).fence(ModBlocks.LIGHT_BLUE_CONCRETE_FENCE.get()).polished(ModBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily YELLOW_CONCRETE = familyBuilder(Blocks.YELLOW_CONCRETE).stairs(ModBlocks.YELLOW_CONCRETE_STAIRS.get()).slab(ModBlocks.YELLOW_CONCRETE_SLAB.get()).wall(ModBlocks.YELLOW_CONCRETE_WALL.get()).fence(ModBlocks.YELLOW_CONCRETE_FENCE.get()).polished(ModBlocks.YELLOW_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily LIME_CONCRETE = familyBuilder(Blocks.LIME_CONCRETE).stairs(ModBlocks.LIME_CONCRETE_STAIRS.get()).slab(ModBlocks.LIME_CONCRETE_SLAB.get()).wall(ModBlocks.LIME_CONCRETE_WALL.get()).fence(ModBlocks.LIME_CONCRETE_FENCE.get()).polished(ModBlocks.LIME_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily PINK_CONCRETE = familyBuilder(Blocks.PINK_CONCRETE).stairs(ModBlocks.PINK_CONCRETE_STAIRS.get()).slab(ModBlocks.PINK_CONCRETE_SLAB.get()).wall(ModBlocks.PINK_CONCRETE_WALL.get()).fence(ModBlocks.PINK_CONCRETE_FENCE.get()).polished(ModBlocks.PINK_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily GRAY_CONCRETE = familyBuilder(Blocks.GRAY_CONCRETE).stairs(ModBlocks.GRAY_CONCRETE_STAIRS.get()).slab(ModBlocks.GRAY_CONCRETE_SLAB.get()).wall(ModBlocks.GRAY_CONCRETE_WALL.get()).fence(ModBlocks.GRAY_CONCRETE_FENCE.get()).polished(ModBlocks.GRAY_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily LIGHT_GRAY_CONCRETE = familyBuilder(Blocks.LIGHT_GRAY_CONCRETE).stairs(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get()).slab(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get()).wall(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get()).fence(ModBlocks.LIGHT_GRAY_CONCRETE_FENCE.get()).polished(ModBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily CYAN_CONCRETE = familyBuilder(Blocks.CYAN_CONCRETE).stairs(ModBlocks.CYAN_CONCRETE_STAIRS.get()).slab(ModBlocks.CYAN_CONCRETE_SLAB.get()).wall(ModBlocks.CYAN_CONCRETE_WALL.get()).fence(ModBlocks.CYAN_CONCRETE_FENCE.get()).polished(ModBlocks.CYAN_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily PURPLE_CONCRETE = familyBuilder(Blocks.PURPLE_CONCRETE).stairs(ModBlocks.PURPLE_CONCRETE_STAIRS.get()).slab(ModBlocks.PURPLE_CONCRETE_SLAB.get()).wall(ModBlocks.PURPLE_CONCRETE_WALL.get()).fence(ModBlocks.PURPLE_CONCRETE_FENCE.get()).polished(ModBlocks.PURPLE_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily BLUE_CONCRETE = familyBuilder(Blocks.BLUE_CONCRETE).stairs(ModBlocks.BLUE_CONCRETE_STAIRS.get()).slab(ModBlocks.BLUE_CONCRETE_SLAB.get()).wall(ModBlocks.BLUE_CONCRETE_WALL.get()).fence(ModBlocks.BLUE_CONCRETE_FENCE.get()).polished(ModBlocks.BLUE_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily BROWN_CONCRETE = familyBuilder(Blocks.BROWN_CONCRETE).stairs(ModBlocks.BROWN_CONCRETE_STAIRS.get()).slab(ModBlocks.BROWN_CONCRETE_SLAB.get()).wall(ModBlocks.BROWN_CONCRETE_WALL.get()).fence(ModBlocks.BROWN_CONCRETE_FENCE.get()).polished(ModBlocks.BROWN_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily GREEN_CONCRETE = familyBuilder(Blocks.GREEN_CONCRETE).stairs(ModBlocks.GREEN_CONCRETE_STAIRS.get()).slab(ModBlocks.GREEN_CONCRETE_SLAB.get()).wall(ModBlocks.GREEN_CONCRETE_WALL.get()).fence(ModBlocks.GREEN_CONCRETE_FENCE.get()).polished(ModBlocks.GREEN_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily RED_CONCRETE = familyBuilder(Blocks.RED_CONCRETE).stairs(ModBlocks.RED_CONCRETE_STAIRS.get()).slab(ModBlocks.RED_CONCRETE_SLAB.get()).wall(ModBlocks.RED_CONCRETE_WALL.get()).fence(ModBlocks.RED_CONCRETE_FENCE.get()).polished(ModBlocks.RED_CONCRETE_BRICKS.get()).getFamily();
    public static final BlockFamily BLACK_CONCRETE = familyBuilder(Blocks.BLACK_CONCRETE).stairs(ModBlocks.BLACK_CONCRETE_STAIRS.get()).slab(ModBlocks.BLACK_CONCRETE_SLAB.get()).wall(ModBlocks.BLACK_CONCRETE_WALL.get()).fence(ModBlocks.BLACK_CONCRETE_FENCE.get()).polished(ModBlocks.BLACK_CONCRETE_BRICKS.get()).getFamily();

    public static final BlockFamily STONE_TILES = familyBuilder(ModBlocks.STONE_TILES.get()).slab(ModBlocks.STONE_TILE_SLAB.get()).stairs(ModBlocks.STONE_TILE_STAIRS.get()).wall(ModBlocks.STONE_TILE_WALL.get()).fence(ModBlocks.STONE_TILE_FENCE.get()).getFamily();
    public static final BlockFamily MOSSY_STONE_TILES = familyBuilder(ModBlocks.MOSSY_STONE_TILES.get()).slab(ModBlocks.MOSSY_STONE_TILE_SLAB.get()).stairs(ModBlocks.MOSSY_STONE_TILE_STAIRS.get()).wall(ModBlocks.MOSSY_STONE_TILE_WALL.get()).fence(ModBlocks.MOSSY_STONE_TILE_FENCE.get()).getFamily();
    public static final BlockFamily CRACKED_STONE_TILES = familyBuilder(ModBlocks.CRACKED_STONE_TILES.get()).slab(ModBlocks.CRACKED_STONE_TILE_SLAB.get()).stairs(ModBlocks.CRACKED_STONE_TILE_STAIRS.get()).wall(ModBlocks.CRACKED_STONE_TILE_WALL.get()).fence(ModBlocks.CRACKED_STONE_TILE_FENCE.get()).getFamily();
    public static final BlockFamily OBSIDIAN_BRICKS = familyBuilder(ModBlocks.OBSIDIAN_BRICKS.get()).slab(ModBlocks.OBSIDIAN_BRICK_SLAB.get()).stairs(ModBlocks.OBSIDIAN_BRICK_STAIRS.get()).wall(ModBlocks.OBSIDIAN_BRICK_WALL.get()).fence(ModBlocks.OBSIDIAN_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CRYING_OBSIDIAN_BRICKS = familyBuilder(ModBlocks.CRYING_OBSIDIAN_BRICKS.get()).slab(ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB.get()).stairs(ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS.get()).wall(ModBlocks.CRYING_OBSIDIAN_BRICK_WALL.get()).fence(ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily COAL_BRICKS = familyBuilder(ModBlocks.COAL_BRICKS.get()).stairs(ModBlocks.COAL_BRICK_STAIRS.get()).slab(ModBlocks.COAL_BRICK_SLAB.get()).wall(ModBlocks.COAL_BRICK_WALL.get()).fence(ModBlocks.COAL_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CHARCOAL_BRICKS = familyBuilder(ModBlocks.CHARCOAL_BRICKS.get()).stairs(ModBlocks.CHARCOAL_BRICK_STAIRS.get()).slab(ModBlocks.CHARCOAL_BRICK_SLAB.get()).wall(ModBlocks.CHARCOAL_BRICK_WALL.get()).fence(ModBlocks.CHARCOAL_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LAPIS_BRICKS = familyBuilder(ModBlocks.LAPIS_BRICKS.get()).slab(ModBlocks.LAPIS_BRICK_SLAB.get()).stairs(ModBlocks.LAPIS_BRICK_STAIRS.get()).wall(ModBlocks.LAPIS_BRICK_WALL.get()).fence(ModBlocks.LAPIS_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_LAPIS = familyBuilder(ModBlocks.SMOOTH_LAPIS.get()).slab(ModBlocks.SMOOTH_LAPIS_SLAB.get()).stairs(ModBlocks.SMOOTH_LAPIS_STAIRS.get()).wall(ModBlocks.SMOOTH_LAPIS_WALL.get()).fence(ModBlocks.SMOOTH_LAPIS_FENCE.get()).getFamily();
    public static final BlockFamily SNOW_BRICKS = familyBuilder(ModBlocks.SNOW_BRICKS.get()).slab(ModBlocks.SNOW_BRICK_SLAB.get()).stairs(ModBlocks.SNOW_BRICK_STAIRS.get()).wall(ModBlocks.SNOW_BRICK_WALL.get()).fence(ModBlocks.SNOW_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily ICE_BRICKS = familyBuilder(ModBlocks.ICE_BRICKS.get()).slab(ModBlocks.ICE_BRICK_SLAB.get()).stairs(ModBlocks.ICE_BRICK_STAIRS.get()).wall(ModBlocks.ICE_BRICK_WALL.get()).fence(ModBlocks.ICE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PACKED_ICE_BRICKS = familyBuilder(ModBlocks.PACKED_ICE_BRICKS.get()).slab(ModBlocks.PACKED_ICE_BRICK_SLAB.get()).stairs(ModBlocks.PACKED_ICE_BRICK_STAIRS.get()).wall(ModBlocks.PACKED_ICE_BRICK_WALL.get()).fence(ModBlocks.PACKED_ICE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLUE_ICE_BRICKS = familyBuilder(ModBlocks.BLUE_ICE_BRICKS.get()).slab(ModBlocks.BLUE_ICE_BRICK_SLAB.get()).stairs(ModBlocks.BLUE_ICE_BRICK_STAIRS.get()).wall(ModBlocks.BLUE_ICE_BRICK_WALL.get()).fence(ModBlocks.BLUE_ICE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily SCULK_BRICKS = familyBuilder(ModBlocks.SCULK_BRICKS.get()).slab(ModBlocks.SCULK_BRICK_SLAB.get()).stairs(ModBlocks.SCULK_BRICK_STAIRS.get()).wall(ModBlocks.SCULK_BRICK_WALL.get()).chiseled(ModBlocks.CHISELED_SCULK_BRICKS.get()).fence(ModBlocks.SCULK_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily GABBRO = familyBuilder(ModBlocks.GABBRO.get()).polished(ModBlocks.POLISHED_GABBRO.get()).stairs(ModBlocks.GABBRO_STAIRS.get()).slab(ModBlocks.GABBRO_SLAB.get()).wall(ModBlocks.GABBRO_WALL.get()).fence(ModBlocks.GABBRO_FENCE.get()).getFamily();
    public static final BlockFamily RHYOLITE = familyBuilder(ModBlocks.RHYOLITE.get()).polished(ModBlocks.POLISHED_RHYOLITE.get()).stairs(ModBlocks.RHYOLITE_STAIRS.get()).slab(ModBlocks.RHYOLITE_SLAB.get()).wall(ModBlocks.RHYOLITE_WALL.get()).fence(ModBlocks.RHYOLITE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_RHYOLITE = familyBuilder(ModBlocks.POLISHED_RHYOLITE.get()).stairs(ModBlocks.POLISHED_RHYOLITE_STAIRS.get()).slab(ModBlocks.POLISHED_RHYOLITE_SLAB.get()).wall(ModBlocks.POLISHED_RHYOLITE_WALL.get()).polished(ModBlocks.RHYOLITE_BRICKS.get()).fence(ModBlocks.POLISHED_RHYOLITE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_GABBRO = familyBuilder(ModBlocks.POLISHED_GABBRO.get()).stairs(ModBlocks.POLISHED_GABBRO_STAIRS.get()).slab(ModBlocks.POLISHED_GABBRO_SLAB.get()).wall(ModBlocks.POLISHED_GABBRO_WALL.get()).polished(ModBlocks.GABBRO_BRICKS.get()).fence(ModBlocks.POLISHED_GABBRO_FENCE.get()).getFamily();
    public static final BlockFamily GABBRO_BRICKS = familyBuilder(ModBlocks.GABBRO_BRICKS.get()).stairs(ModBlocks.GABBRO_BRICK_STAIRS.get()).slab(ModBlocks.GABBRO_BRICK_SLAB.get()).wall(ModBlocks.GABBRO_BRICK_WALL.get()).fence(ModBlocks.GABBRO_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily RHYOLITE_BRICKS = familyBuilder(ModBlocks.RHYOLITE_BRICKS.get()).stairs(ModBlocks.RHYOLITE_BRICK_STAIRS.get()).slab(ModBlocks.RHYOLITE_BRICK_SLAB.get()).wall(ModBlocks.RHYOLITE_BRICK_WALL.get()).fence(ModBlocks.RHYOLITE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily PUMICE = familyBuilder(ModBlocks.PUMICE.get()).polished(ModBlocks.POLISHED_PUMICE.get()).stairs(ModBlocks.PUMICE_STAIRS.get()).slab(ModBlocks.PUMICE_SLAB.get()).wall(ModBlocks.PUMICE_WALL.get()).fence(ModBlocks.PUMICE_FENCE.get()).getFamily();
    public static final BlockFamily POLISHED_PUMICE = familyBuilder(ModBlocks.POLISHED_PUMICE.get()).stairs(ModBlocks.POLISHED_PUMICE_STAIRS.get()).slab(ModBlocks.POLISHED_PUMICE_SLAB.get()).wall(ModBlocks.POLISHED_PUMICE_WALL.get()).polished(ModBlocks.PUMICE_BRICKS.get()).fence(ModBlocks.POLISHED_PUMICE_FENCE.get()).getFamily();
    public static final BlockFamily PUMICE_BRICKS = familyBuilder(ModBlocks.PUMICE_BRICKS.get()).stairs(ModBlocks.PUMICE_BRICK_STAIRS.get()).slab(ModBlocks.PUMICE_BRICK_SLAB.get()).wall(ModBlocks.PUMICE_BRICK_WALL.get()).fence(ModBlocks.PUMICE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily POLISHED_STONE = familyBuilder(ModBlocks.POLISHED_STONE.get()).stairs(ModBlocks.POLISHED_STONE_STAIRS.get()).slab(ModBlocks.POLISHED_STONE_SLAB.get()).wall(ModBlocks.POLISHED_STONE_WALL.get()).fence(ModBlocks.POLISHED_STONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_DEEPSLATE = familyBuilder(ModBlocks.SMOOTH_DEEPSLATE.get()).stairs(ModBlocks.SMOOTH_DEEPSLATE_STAIRS.get()).slab(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get()).wall(ModBlocks.SMOOTH_DEEPSLATE_WALL.get()).fence(ModBlocks.SMOOTH_DEEPSLATE_FENCE.get()).getFamily();
    public static final BlockFamily NETHERRACK_BRICKS = familyBuilder(ModBlocks.NETHERRACK_BRICKS.get()).stairs(ModBlocks.NETHERRACK_BRICK_STAIRS.get()).slab(ModBlocks.NETHERRACK_BRICK_SLAB.get()).wall(ModBlocks.NETHERRACK_BRICK_WALL.get()).fence(ModBlocks.NETHERRACK_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily TERRACOTTA_BRICKS = familyBuilder(ModBlocks.TERRACOTTA_BRICKS.get()).stairs(ModBlocks.TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BIG_BRICKS = familyBuilder(ModBlocks.BIG_BRICKS.get()).stairs(ModBlocks.BIG_BRICK_STAIRS.get()).slab(ModBlocks.BIG_BRICK_SLAB.get()).wall(ModBlocks.BIG_BRICK_WALL.get()).fence(ModBlocks.BIG_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily WHITE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.WHITE_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.WHITE_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.WHITE_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.WHITE_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily ORANGE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.ORANGE_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.ORANGE_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily MAGENTA_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.MAGENTA_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily YELLOW_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.YELLOW_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.YELLOW_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIME_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.LIME_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.LIME_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.LIME_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.LIME_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.LIME_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PINK_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.PINK_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.PINK_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.PINK_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.PINK_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.PINK_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily GRAY_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.GRAY_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.GRAY_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.GRAY_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.GRAY_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CYAN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.CYAN_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.CYAN_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.CYAN_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.CYAN_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PURPLE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.PURPLE_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.PURPLE_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLUE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.BLUE_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.BLUE_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.BLUE_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.BLUE_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BROWN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.BROWN_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.BROWN_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.BROWN_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.BROWN_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily GREEN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.GREEN_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.GREEN_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.GREEN_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.GREEN_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily RED_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.RED_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.RED_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.RED_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.RED_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.RED_TERRACOTTA_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLACK_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.BLACK_TERRACOTTA_BRICKS.get()).stairs(ModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS.get()).slab(ModBlocks.BLACK_TERRACOTTA_BRICK_SLAB.get()).wall(ModBlocks.BLACK_TERRACOTTA_BRICK_WALL.get()).fence(ModBlocks.BLACK_TERRACOTTA_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily WHITE_CONCRETE_BRICKS = familyBuilder(ModBlocks.WHITE_CONCRETE_BRICKS.get()).stairs(ModBlocks.WHITE_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.WHITE_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.WHITE_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.WHITE_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily ORANGE_CONCRETE_BRICKS = familyBuilder(ModBlocks.ORANGE_CONCRETE_BRICKS.get()).stairs(ModBlocks.ORANGE_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.ORANGE_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.ORANGE_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.ORANGE_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily MAGENTA_CONCRETE_BRICKS = familyBuilder(ModBlocks.MAGENTA_CONCRETE_BRICKS.get()).stairs(ModBlocks.MAGENTA_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.MAGENTA_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.MAGENTA_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.MAGENTA_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIGHT_BLUE_CONCRETE_BRICKS = familyBuilder(ModBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get()).stairs(ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily YELLOW_CONCRETE_BRICKS = familyBuilder(ModBlocks.YELLOW_CONCRETE_BRICKS.get()).stairs(ModBlocks.YELLOW_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.YELLOW_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.YELLOW_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.YELLOW_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIME_CONCRETE_BRICKS = familyBuilder(ModBlocks.LIME_CONCRETE_BRICKS.get()).stairs(ModBlocks.LIME_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.LIME_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.LIME_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.LIME_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PINK_CONCRETE_BRICKS = familyBuilder(ModBlocks.PINK_CONCRETE_BRICKS.get()).stairs(ModBlocks.PINK_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.PINK_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.PINK_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.PINK_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily GRAY_CONCRETE_BRICKS = familyBuilder(ModBlocks.GRAY_CONCRETE_BRICKS.get()).stairs(ModBlocks.GRAY_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.GRAY_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.GRAY_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.GRAY_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily LIGHT_GRAY_CONCRETE_BRICKS = familyBuilder(ModBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get()).stairs(ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily CYAN_CONCRETE_BRICKS = familyBuilder(ModBlocks.CYAN_CONCRETE_BRICKS.get()).stairs(ModBlocks.CYAN_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.CYAN_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.CYAN_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.CYAN_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily PURPLE_CONCRETE_BRICKS = familyBuilder(ModBlocks.PURPLE_CONCRETE_BRICKS.get()).stairs(ModBlocks.PURPLE_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.PURPLE_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.PURPLE_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.PURPLE_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLUE_CONCRETE_BRICKS = familyBuilder(ModBlocks.BLUE_CONCRETE_BRICKS.get()).stairs(ModBlocks.BLUE_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.BLUE_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.BLUE_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.BLUE_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BROWN_CONCRETE_BRICKS = familyBuilder(ModBlocks.BROWN_CONCRETE_BRICKS.get()).stairs(ModBlocks.BROWN_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.BROWN_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.BROWN_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.BROWN_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily GREEN_CONCRETE_BRICKS = familyBuilder(ModBlocks.GREEN_CONCRETE_BRICKS.get()).stairs(ModBlocks.GREEN_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.GREEN_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.GREEN_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.GREEN_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily RED_CONCRETE_BRICKS = familyBuilder(ModBlocks.RED_CONCRETE_BRICKS.get()).stairs(ModBlocks.RED_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.RED_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.RED_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.RED_CONCRETE_BRICK_FENCE.get()).getFamily();
    public static final BlockFamily BLACK_CONCRETE_BRICKS = familyBuilder(ModBlocks.BLACK_CONCRETE_BRICKS.get()).stairs(ModBlocks.BLACK_CONCRETE_BRICK_STAIRS.get()).slab(ModBlocks.BLACK_CONCRETE_BRICK_SLAB.get()).wall(ModBlocks.BLACK_CONCRETE_BRICK_WALL.get()).fence(ModBlocks.BLACK_CONCRETE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily GILDED_BLACKSTONE = familyBuilder(Blocks.GILDED_BLACKSTONE).stairs(ModBlocks.GILDED_BLACKSTONE_STAIRS.get()).slab(ModBlocks.GILDED_BLACKSTONE_SLAB.get()).wall(ModBlocks.GILDED_BLACKSTONE_WALL.get()).fence(ModBlocks.GILDED_BLACKSTONE_FENCE.get()).getFamily();

    public static final BlockFamily GLASS = familyBuilder(Blocks.GLASS).door(ModBlocks.GLASS_DOOR.get()).trapdoor(ModBlocks.GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily TINTED_GLASS = familyBuilder(Blocks.TINTED_GLASS).door(ModBlocks.TINTED_GLASS_DOOR.get()).trapdoor(ModBlocks.TINTED_GLASS_TRAPDOOR.get()).getFamily();

    public static final BlockFamily WHITE_STAINED_GLASS = familyBuilder(Blocks.WHITE_STAINED_GLASS).door(ModBlocks.WHITE_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.WHITE_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily ORANGE_STAINED_GLASS = familyBuilder(Blocks.ORANGE_STAINED_GLASS).door(ModBlocks.ORANGE_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.ORANGE_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily MAGENTA_STAINED_GLASS = familyBuilder(Blocks.MAGENTA_STAINED_GLASS).door(ModBlocks.MAGENTA_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.MAGENTA_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily LIGHT_BLUE_STAINED_GLASS = familyBuilder(Blocks.LIGHT_BLUE_STAINED_GLASS).door(ModBlocks.LIGHT_BLUE_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily YELLOW_STAINED_GLASS = familyBuilder(Blocks.YELLOW_STAINED_GLASS).door(ModBlocks.YELLOW_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.YELLOW_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily LIME_STAINED_GLASS = familyBuilder(Blocks.LIME_STAINED_GLASS).door(ModBlocks.LIME_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.LIME_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily PINK_STAINED_GLASS = familyBuilder(Blocks.PINK_STAINED_GLASS).door(ModBlocks.PINK_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.PINK_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily GRAY_STAINED_GLASS = familyBuilder(Blocks.GRAY_STAINED_GLASS).door(ModBlocks.GRAY_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.GRAY_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily LIGHT_GRAY_STAINED_GLASS = familyBuilder(Blocks.LIGHT_GRAY_STAINED_GLASS).door(ModBlocks.LIGHT_GRAY_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily CYAN_STAINED_GLASS = familyBuilder(Blocks.CYAN_STAINED_GLASS).door(ModBlocks.CYAN_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.CYAN_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily PURPLE_STAINED_GLASS = familyBuilder(Blocks.PURPLE_STAINED_GLASS).door(ModBlocks.PURPLE_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.PURPLE_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily BLUE_STAINED_GLASS = familyBuilder(Blocks.BLUE_STAINED_GLASS).door(ModBlocks.BLUE_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.BLUE_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily BROWN_STAINED_GLASS = familyBuilder(Blocks.BROWN_STAINED_GLASS).door(ModBlocks.BROWN_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.BROWN_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily GREEN_STAINED_GLASS = familyBuilder(Blocks.GREEN_STAINED_GLASS).door(ModBlocks.GREEN_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.GREEN_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily RED_STAINED_GLASS = familyBuilder(Blocks.RED_STAINED_GLASS).door(ModBlocks.RED_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.RED_STAINED_GLASS_TRAPDOOR.get()).getFamily();
    public static final BlockFamily BLACK_STAINED_GLASS = familyBuilder(Blocks.BLACK_STAINED_GLASS).door(ModBlocks.BLACK_STAINED_GLASS_DOOR.get()).trapdoor(ModBlocks.BLACK_STAINED_GLASS_TRAPDOOR.get()).getFamily();
}
