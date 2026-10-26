package github.theworksofbh.buildersparadise.blocks;

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

    public static final BlockFamily COBBLESTONE = familyBuilder(Blocks.COBBLESTONE).fence(ModBlocks.COBBLESTONE_FENCE).polished(ModBlocks.POLISHED_STONE).getFamily();
    public static final BlockFamily MOSSY_COBBLESTONE = familyBuilder(Blocks.MOSSY_COBBLESTONE).fence(ModBlocks.MOSSY_COBBLESTONE_FENCE).getFamily();
    public static final BlockFamily STONE_BRICKS = familyBuilder(Blocks.STONE_BRICKS).polished(ModBlocks.STONE_TILES).fence(ModBlocks.STONE_BRICK_FENCE).getFamily();
    public static final BlockFamily MOSSY_STONE_BRICKS = familyBuilder(Blocks.MOSSY_STONE_BRICKS).fence(ModBlocks.MOSSY_STONE_BRICK_FENCE).getFamily();
    public static final BlockFamily GRANITE = familyBuilder(Blocks.GRANITE).fence(ModBlocks.GRANITE_FENCE).getFamily();
    public static final BlockFamily DIORITE = familyBuilder(Blocks.DIORITE).fence(ModBlocks.DIORITE_FENCE).getFamily();
    public static final BlockFamily ANDESITE = familyBuilder(Blocks.ANDESITE).fence(ModBlocks.ANDESITE_FENCE).getFamily();
    public static final BlockFamily COBBLED_DEEPSLATE = familyBuilder(Blocks.COBBLED_DEEPSLATE).fence(ModBlocks.COBBLED_DEEPSLATE_FENCE).getFamily();
    public static final BlockFamily POLISHED_DEEPSLATE = familyBuilder(Blocks.POLISHED_DEEPSLATE).fence(ModBlocks.POLISHED_DEEPSLATE_FENCE).getFamily();
    public static final BlockFamily DEEPSLATE_BRICKS = familyBuilder(Blocks.DEEPSLATE_BRICKS).fence(ModBlocks.DEEPSLATE_BRICK_FENCE).getFamily();
    public static final BlockFamily DEEPSLATE_TILES = familyBuilder(Blocks.DEEPSLATE_TILES).fence(ModBlocks.DEEPSLATE_TILE_FENCE).getFamily();
    public static final BlockFamily TUFF = familyBuilder(Blocks.TUFF).fence(ModBlocks.TUFF_FENCE).getFamily();
    public static final BlockFamily POLISHED_TUFF = familyBuilder(Blocks.POLISHED_TUFF).fence(ModBlocks.POLISHED_TUFF_FENCE).getFamily();
    public static final BlockFamily TUFF_BRICKS = familyBuilder(Blocks.TUFF_BRICKS).fence(ModBlocks.TUFF_BRICK_FENCE).getFamily();
    public static final BlockFamily BRICKS = familyBuilder(Blocks.BRICKS).fence(ModBlocks.BRICK_FENCE).polished(ModBlocks.BIG_BRICKS).getFamily();
    public static final BlockFamily MUD_BRICKS = familyBuilder(Blocks.MUD_BRICKS).fence(ModBlocks.MUD_BRICK_FENCE).getFamily();
    public static final BlockFamily RESIN_BRICKS = familyBuilder(Blocks.RESIN_BRICKS).fence(ModBlocks.RESIN_BRICK_FENCE).getFamily();
    public static final BlockFamily SANDSTONE = familyBuilder(Blocks.SANDSTONE).fence(ModBlocks.SANDSTONE_FENCE).getFamily();
    public static final BlockFamily RED_SANDSTONE = familyBuilder(Blocks.RED_SANDSTONE).fence(ModBlocks.RED_SANDSTONE_FENCE).getFamily();
    public static final BlockFamily PRISMARINE = familyBuilder(Blocks.PRISMARINE).slab(Blocks.PRISMARINE_SLAB).fence(ModBlocks.PRISMARINE_FENCE).chiseled(ModBlocks.CHISELED_PRISMARINE).getFamily();
    public static final BlockFamily RED_NETHER_BRICKS = familyBuilder(Blocks.RED_NETHER_BRICKS).fence(ModBlocks.RED_NETHER_BRICK_FENCE).getFamily();
    public static final BlockFamily BLACKSTONE = familyBuilder(Blocks.BLACKSTONE).fence(ModBlocks.BLACKSTONE_FENCE).getFamily();
    public static final BlockFamily POLISHED_BLACKSTONE = familyBuilder(Blocks.POLISHED_BLACKSTONE).fence(ModBlocks.POLISHED_BLACKSTONE_FENCE).getFamily();
    public static final BlockFamily POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.POLISHED_BLACKSTONE_BRICKS).fence(ModBlocks.POLISHED_BLACKSTONE_BRICK_FENCE).getFamily();
    public static final BlockFamily END_STONE_BRICKS = familyBuilder(Blocks.END_STONE_BRICKS).fence(ModBlocks.END_STONE_BRICK_FENCE).getFamily();
    public static final BlockFamily SULFUR = familyBuilder(Blocks.SULFUR).fence(ModBlocks.SULFUR_FENCE).getFamily();
    public static final BlockFamily POLISHED_SULFUR = familyBuilder(Blocks.POLISHED_SULFUR).fence(ModBlocks.POLISHED_SULFUR_FENCE).getFamily();
    public static final BlockFamily SULFUR_BRICKS = familyBuilder(Blocks.SULFUR_BRICKS).fence(ModBlocks.SULFUR_BRICK_FENCE).getFamily();
    public static final BlockFamily CINNABAR = familyBuilder(Blocks.CINNABAR).fence(ModBlocks.CINNABAR_FENCE).getFamily();
    public static final BlockFamily POLISHED_CINNABAR = familyBuilder(Blocks.POLISHED_CINNABAR).fence(ModBlocks.POLISHED_CINNABAR_FENCE).getFamily();
    public static final BlockFamily CINNABAR_BRICKS = familyBuilder(Blocks.CINNABAR_BRICKS).fence(ModBlocks.CINNABAR_BRICK_FENCE).getFamily();

    public static final BlockFamily POLISHED_GRANITE = familyBuilder(Blocks.POLISHED_GRANITE).wall(ModBlocks.POLISHED_GRANITE_WALL).fence(ModBlocks.POLISHED_GRANITE_FENCE).polished(ModBlocks.POLISHED_GRANITE_BRICKS).getFamily();
    public static final BlockFamily POLISHED_DIORITE = familyBuilder(Blocks.POLISHED_DIORITE).wall(ModBlocks.POLISHED_DIORITE_WALL).fence(ModBlocks.POLISHED_DIORITE_FENCE).polished(ModBlocks.POLISHED_DIORITE_BRICKS).getFamily();
    public static final BlockFamily POLISHED_ANDESITE = familyBuilder(Blocks.POLISHED_ANDESITE).wall(ModBlocks.POLISHED_ANDESITE_WALL).fence(ModBlocks.POLISHED_ANDESITE_FENCE).polished(ModBlocks.POLISHED_ANDESITE_BRICKS).getFamily();
    public static final BlockFamily PRISMARINE_BRICKS = familyBuilder(Blocks.PRISMARINE_BRICKS).slab(Blocks.PRISMARINE_BRICK_SLAB).wall(ModBlocks.PRISMARINE_BRICK_WALL).fence(ModBlocks.PRISMARINE_BRICK_FENCE).chiseled(ModBlocks.CHISELED_PRISMARINE_BRICKS).getFamily();
    public static final BlockFamily DARK_PRISMARINE = familyBuilder(Blocks.DARK_PRISMARINE).wall(ModBlocks.DARK_PRISMARINE_WALL).fence(ModBlocks.DARK_PRISMARINE_FENCE).getFamily();
    public static final BlockFamily STONE = familyBuilder(Blocks.STONE).wall(ModBlocks.STONE_WALL).fence(ModBlocks.STONE_FENCE).getFamily();
    public static final BlockFamily SMOOTH_SANDSTONE = familyBuilder(Blocks.SMOOTH_SANDSTONE).wall(ModBlocks.SMOOTH_SANDSTONE_WALL).fence(ModBlocks.SMOOTH_SANDSTONE_FENCE).getFamily();
    public static final BlockFamily SMOOTH_RED_SANDSTONE = familyBuilder(Blocks.SMOOTH_RED_SANDSTONE).wall(ModBlocks.SMOOTH_RED_SANDSTONE_WALL).fence(ModBlocks.SMOOTH_RED_SANDSTONE_FENCE).getFamily();
    public static final BlockFamily QUARTZ = familyBuilder(Blocks.QUARTZ_BLOCK).wall(ModBlocks.QUARTZ_WALL).fence(ModBlocks.QUARTZ_FENCE).getFamily();
    public static final BlockFamily SMOOTH_QUARTZ = familyBuilder(Blocks.SMOOTH_QUARTZ).wall(ModBlocks.SMOOTH_QUARTZ_WALL).fence(ModBlocks.SMOOTH_QUARTZ_FENCE).getFamily();
    public static final BlockFamily PURPUR = familyBuilder(Blocks.PURPUR_BLOCK).wall(ModBlocks.PURPUR_WALL).fence(ModBlocks.PURPUR_FENCE).getFamily();

    public static final BlockFamily SMOOTH_STONE = familyBuilder(Blocks.SMOOTH_STONE).stairs(ModBlocks.SMOOTH_STONE_STAIRS).wall(ModBlocks.SMOOTH_STONE_WALL).fence(ModBlocks.SMOOTH_STONE_FENCE).getFamily();
    public static final BlockFamily CUT_SANDSTONE = familyBuilder(Blocks.CUT_SANDSTONE).stairs(ModBlocks.CUT_SANDSTONE_STAIRS).wall(ModBlocks.CUT_SANDSTONE_WALL).fence(ModBlocks.CUT_SANDSTONE_FENCE).getFamily();
    public static final BlockFamily CUT_RED_SANDSTONE = familyBuilder(Blocks.CUT_RED_SANDSTONE).stairs(ModBlocks.CUT_RED_SANDSTONE_STAIRS).wall(ModBlocks.CUT_RED_SANDSTONE_WALL).fence(ModBlocks.CUT_RED_SANDSTONE_FENCE).getFamily();

    public static final BlockFamily CRACKED_STONE_BRICKS = familyBuilder(Blocks.CRACKED_STONE_BRICKS).stairs(ModBlocks.CRACKED_STONE_BRICK_STAIRS).slab(ModBlocks.CRACKED_STONE_BRICK_SLAB).wall(ModBlocks.CRACKED_STONE_BRICK_WALL).fence(ModBlocks.CRACKED_STONE_BRICK_FENCE).getFamily();
    public static final BlockFamily BASALT = familyBuilder(Blocks.BASALT).stairs(ModBlocks.BASALT_STAIRS).slab(ModBlocks.BASALT_SLAB).wall(ModBlocks.BASALT_WALL).fence(ModBlocks.BASALT_FENCE).getFamily();
    public static final BlockFamily POLISHED_BASALT = familyBuilder(Blocks.POLISHED_BASALT).stairs(ModBlocks.POLISHED_BASALT_STAIRS).slab(ModBlocks.POLISHED_BASALT_SLAB).wall(ModBlocks.POLISHED_BASALT_WALL).fence(ModBlocks.POLISHED_BASALT_FENCE).polished(ModBlocks.BASALT_BRICKS).getFamily();
    public static final BlockFamily SMOOTH_BASALT = familyBuilder(Blocks.SMOOTH_BASALT).stairs(ModBlocks.SMOOTH_BASALT_STAIRS).slab(ModBlocks.SMOOTH_BASALT_SLAB).wall(ModBlocks.SMOOTH_BASALT_WALL).fence(ModBlocks.SMOOTH_BASALT_FENCE).getFamily();
    public static final BlockFamily DEEPSLATE = familyBuilder(Blocks.DEEPSLATE).stairs(ModBlocks.DEEPSLATE_STAIRS).slab(ModBlocks.DEEPSLATE_SLAB).wall(ModBlocks.DEEPSLATE_WALL).fence(ModBlocks.DEEPSLATE_FENCE).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_BRICKS = familyBuilder(Blocks.CRACKED_DEEPSLATE_BRICKS).stairs(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS).slab(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB).wall(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL).fence(ModBlocks.CRACKED_DEEPSLATE_BRICK_FENCE).getFamily();
    public static final BlockFamily CRACKED_DEEPSLATE_TILES = familyBuilder(Blocks.CRACKED_DEEPSLATE_TILES).stairs(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS).slab(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB).wall(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL).fence(ModBlocks.CRACKED_DEEPSLATE_TILE_FENCE).getFamily();
    public static final BlockFamily CRACKED_NETHER_BRICKS = familyBuilder(Blocks.CRACKED_NETHER_BRICKS).stairs(ModBlocks.CRACKED_NETHER_BRICK_STAIRS).slab(ModBlocks.CRACKED_NETHER_BRICK_SLAB).wall(ModBlocks.CRACKED_NETHER_BRICK_WALL).fence(ModBlocks.CRACKED_NETHER_BRICK_FENCE).getFamily();
    public static final BlockFamily CRACKED_POLISHED_BLACKSTONE_BRICKS = familyBuilder(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).stairs(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS).slab(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB).wall(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL).fence(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_FENCE).getFamily();
    public static final BlockFamily NETHERRACK = familyBuilder(Blocks.NETHERRACK).stairs(ModBlocks.NETHERRACK_STAIRS).slab(ModBlocks.NETHERRACK_SLAB).wall(ModBlocks.NETHERRACK_WALL).fence(ModBlocks.NETHERRACK_FENCE).polished(ModBlocks.NETHERRACK_BRICKS).getFamily();
    public static final BlockFamily CALCITE = familyBuilder(Blocks.CALCITE).polished(ModBlocks.POLISHED_CALCITE).stairs(ModBlocks.CALCITE_STAIRS).slab(ModBlocks.CALCITE_SLAB).wall(ModBlocks.CALCITE_WALL).fence(ModBlocks.CALCITE_FENCE).getFamily();
    public static final BlockFamily DRIPSTONE = familyBuilder(Blocks.DRIPSTONE_BLOCK).polished(ModBlocks.POLISHED_DRIPSTONE).stairs(ModBlocks.DRIPSTONE_STAIRS).slab(ModBlocks.DRIPSTONE_SLAB).wall(ModBlocks.DRIPSTONE_WALL).fence(ModBlocks.DRIPSTONE_FENCE).getFamily();
    public static final BlockFamily END_STONE = familyBuilder(Blocks.END_STONE).stairs(ModBlocks.END_STONE_STAIRS).slab(ModBlocks.END_STONE_SLAB).wall(ModBlocks.END_STONE_WALL).fence(ModBlocks.END_STONE_FENCE).getFamily();
    public static final BlockFamily QUARTZ_BRICKS = familyBuilder(Blocks.QUARTZ_BRICKS).stairs(ModBlocks.QUARTZ_BRICK_STAIRS).slab(ModBlocks.QUARTZ_BRICK_SLAB).wall(ModBlocks.QUARTZ_BRICK_WALL).fence(ModBlocks.QUARTZ_BRICK_FENCE).getFamily();
    public static final BlockFamily PACKED_MUD = familyBuilder(Blocks.PACKED_MUD).stairs(ModBlocks.PACKED_MUD_STAIRS).slab(ModBlocks.PACKED_MUD_SLAB).wall(ModBlocks.PACKED_MUD_WALL).fence(ModBlocks.PACKED_MUD_FENCE).getFamily();
    public static final BlockFamily RESIN = familyBuilder(Blocks.RESIN_BLOCK).stairs(ModBlocks.RESIN_STAIRS).slab(ModBlocks.RESIN_SLAB).wall(ModBlocks.RESIN_WALL).fence(ModBlocks.RESIN_FENCE).getFamily();

    public static final BlockFamily IRON_BLOCK = familyBuilder(ModBlocks.IRON_BLOCK.weathering().unaffected()).cut(ModBlocks.CUT_IRON.weathering().unaffected()).getFamily();
    public static final BlockFamily EXPOSED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.weathering().exposed()).cut(ModBlocks.CUT_IRON.weathering().exposed()).getFamily();
    public static final BlockFamily WEATHERED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.weathering().weathered()).cut(ModBlocks.CUT_IRON.weathering().weathered()).getFamily();
    public static final BlockFamily RUSTED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.weathering().rusted()).cut(ModBlocks.CUT_IRON.weathering().rusted()).getFamily();

    public static final BlockFamily WAXED_IRON_BLOCK = familyBuilder(ModBlocks.IRON_BLOCK.waxed().unaffected()).cut(ModBlocks.CUT_IRON.waxed().unaffected()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.waxed().exposed()).cut(ModBlocks.CUT_IRON.waxed().exposed()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.waxed().weathered()).cut(ModBlocks.CUT_IRON.waxed().weathered()).getFamily();
    public static final BlockFamily WAXED_RUSTED_IRON = familyBuilder(ModBlocks.IRON_BLOCK.waxed().rusted()).cut(ModBlocks.CUT_IRON.waxed().rusted()).getFamily();

    public static final BlockFamily GOLD_BLOCK = familyBuilder(Blocks.GOLD_BLOCK).cut(ModBlocks.CUT_GOLD).getFamily();
    public static final BlockFamily DIAMOND_BLOCK = familyBuilder(Blocks.DIAMOND_BLOCK).cut(ModBlocks.CUT_DIAMOND).getFamily();
    public static final BlockFamily EMERALD_BLOCK = familyBuilder(Blocks.EMERALD_BLOCK).cut(ModBlocks.CUT_EMERALD).getFamily();
    public static final BlockFamily NETHERITE_BLOCK = familyBuilder(Blocks.NETHERITE_BLOCK).cut(ModBlocks.CUT_NETHERITE).getFamily();
    public static final BlockFamily AMETHYST_BLOCK = familyBuilder(Blocks.AMETHYST_BLOCK).cut(ModBlocks.CUT_AMETHYST).getFamily();

    public static final BlockFamily CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.weathering().unaffected()).stairs(ModBlocks.CUT_IRON_STAIRS.weathering().unaffected()).slab(ModBlocks.CUT_IRON_SLAB.weathering().unaffected()).getFamily();
    public static final BlockFamily EXPOSED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.weathering().exposed()).stairs(ModBlocks.CUT_IRON_STAIRS.weathering().exposed()).slab(ModBlocks.CUT_IRON_SLAB.weathering().exposed()).getFamily();
    public static final BlockFamily WEATHERED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.weathering().weathered()).stairs(ModBlocks.CUT_IRON_STAIRS.weathering().weathered()).slab(ModBlocks.CUT_IRON_SLAB.weathering().weathered()).getFamily();
    public static final BlockFamily RUSTED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.weathering().rusted()).stairs(ModBlocks.CUT_IRON_STAIRS.weathering().rusted()).slab(ModBlocks.CUT_IRON_SLAB.weathering().rusted()).getFamily();

    public static final BlockFamily WAXED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.waxed().unaffected()).stairs(ModBlocks.CUT_IRON_STAIRS.waxed().unaffected()).slab(ModBlocks.CUT_IRON_SLAB.waxed().unaffected()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.waxed().exposed()).stairs(ModBlocks.CUT_IRON_STAIRS.waxed().exposed()).slab(ModBlocks.CUT_IRON_SLAB.waxed().exposed()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.waxed().weathered()).stairs(ModBlocks.CUT_IRON_STAIRS.waxed().weathered()).slab(ModBlocks.CUT_IRON_SLAB.waxed().weathered()).getFamily();
    public static final BlockFamily WAXED_RUSTED_CUT_IRON = familyBuilder(ModBlocks.CUT_IRON.waxed().rusted()).stairs(ModBlocks.CUT_IRON_STAIRS.waxed().rusted()).slab(ModBlocks.CUT_IRON_SLAB.waxed().rusted()).getFamily();

    public static final BlockFamily CUT_GOLD = familyBuilder(ModBlocks.CUT_GOLD).stairs(ModBlocks.CUT_GOLD_STAIRS).slab(ModBlocks.CUT_GOLD_SLAB).getFamily();
    public static final BlockFamily CUT_DIAMOND = familyBuilder(ModBlocks.CUT_DIAMOND).stairs(ModBlocks.CUT_DIAMOND_STAIRS).slab(ModBlocks.CUT_DIAMOND_SLAB).getFamily();
    public static final BlockFamily CUT_EMERALD = familyBuilder(ModBlocks.CUT_EMERALD).stairs(ModBlocks.CUT_EMERALD_SLAB).slab(ModBlocks.CUT_EMERALD_STAIRS).getFamily();
    public static final BlockFamily CUT_NETHERITE = familyBuilder(ModBlocks.CUT_NETHERITE).stairs(ModBlocks.CUT_NETHERITE_STAIRS).slab(ModBlocks.CUT_NETHERITE_SLAB).getFamily();
    public static final BlockFamily CUT_AMETHYST = familyBuilder(ModBlocks.CUT_AMETHYST).slab(ModBlocks.CUT_AMETHYST_SLAB).stairs(ModBlocks.CUT_AMETHYST_STAIRS).getFamily();

    public static final BlockFamily POLISHED_DRIPSTONE = familyBuilder(ModBlocks.POLISHED_DRIPSTONE).stairs(ModBlocks.POLISHED_DRIPSTONE_STAIRS).slab(ModBlocks.POLISHED_DRIPSTONE_SLAB).wall(ModBlocks.POLISHED_DRIPSTONE_WALL).polished(ModBlocks.DRIPSTONE_BRICKS).fence(ModBlocks.POLISHED_DRIPSTONE_FENCE).getFamily();
    public static final BlockFamily POLISHED_CALCITE = familyBuilder(ModBlocks.POLISHED_CALCITE).stairs(ModBlocks.POLISHED_CALCITE_STAIRS).slab(ModBlocks.POLISHED_CALCITE_SLAB).wall(ModBlocks.POLISHED_CALCITE_WALL).polished(ModBlocks.CALCITE_BRICKS).fence(ModBlocks.POLISHED_CALCITE_FENCE).getFamily();

    public static final BlockFamily POLISHED_GRANITE_BRICKS = familyBuilder(ModBlocks.POLISHED_GRANITE_BRICKS).stairs(ModBlocks.POLISHED_GRANITE_BRICK_STAIRS).slab(ModBlocks.POLISHED_GRANITE_BRICK_SLAB).wall(ModBlocks.POLISHED_GRANITE_BRICK_WALL).fence(ModBlocks.POLISHED_GRANITE_BRICK_FENCE).getFamily();
    public static final BlockFamily POLISHED_DIORITE_BRICKS = familyBuilder(ModBlocks.POLISHED_DIORITE_BRICKS).stairs(ModBlocks.POLISHED_DIORITE_BRICK_STAIRS).slab(ModBlocks.POLISHED_DIORITE_BRICK_SLAB).wall(ModBlocks.POLISHED_DIORITE_BRICK_WALL).fence(ModBlocks.POLISHED_DIORITE_BRICK_FENCE).getFamily();
    public static final BlockFamily POLISHED_ANDESITE_BRICKS = familyBuilder(ModBlocks.POLISHED_ANDESITE_BRICKS).stairs(ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS).slab(ModBlocks.POLISHED_ANDESITE_BRICK_SLAB).wall(ModBlocks.POLISHED_ANDESITE_BRICK_WALL).fence(ModBlocks.POLISHED_ANDESITE_BRICK_FENCE).getFamily();

    public static final BlockFamily CALCITE_BRICKS = familyBuilder(ModBlocks.CALCITE_BRICKS).stairs(ModBlocks.CALCITE_BRICK_STAIRS).slab(ModBlocks.CALCITE_BRICK_SLAB).wall(ModBlocks.CALCITE_BRICK_WALL).fence(ModBlocks.CALCITE_BRICK_FENCE).getFamily();
    public static final BlockFamily DRIPSTONE_BRICKS = familyBuilder(ModBlocks.DRIPSTONE_BRICKS).stairs(ModBlocks.DRIPSTONE_BRICK_STAIRS).slab(ModBlocks.DRIPSTONE_BRICK_SLAB).wall(ModBlocks.DRIPSTONE_BRICK_WALL).fence(ModBlocks.DRIPSTONE_BRICK_FENCE).getFamily();
    public static final BlockFamily BASALT_BRICKS = familyBuilder(ModBlocks.BASALT_BRICKS).stairs(ModBlocks.BASALT_BRICK_STAIRS).slab(ModBlocks.BASALT_BRICK_SLAB).wall(ModBlocks.BASALT_BRICK_WALL).fence(ModBlocks.BASALT_BRICK_FENCE).getFamily();

    public static final BlockFamily SOUL_SANDSTONE = familyBuilder(ModBlocks.SOUL_SANDSTONE).slab(ModBlocks.SOUL_SANDSTONE_SLAB).stairs(ModBlocks.SOUL_SANDSTONE_STAIRS).wall(ModBlocks.SOUL_SANDSTONE_WALL).cut(ModBlocks.CUT_SOUL_SANDSTONE).fence(ModBlocks.SOUL_SANDSTONE_FENCE).chiseled(ModBlocks.CHISELED_SOUL_SANDSTONE).getFamily();
    public static final BlockFamily CUT_SOUL_SANDSTONE = familyBuilder(ModBlocks.CUT_SOUL_SANDSTONE).slab(ModBlocks.CUT_SOUL_SANDSTONE_SLAB).stairs(ModBlocks.CUT_SOUL_SANDSTONE_STAIRS).wall(ModBlocks.CUT_SOUL_SANDSTONE_WALL).fence(ModBlocks.CUT_SOUL_SANDSTONE_FENCE).getFamily();
    public static final BlockFamily SMOOTH_SOUL_SANDSTONE = familyBuilder(ModBlocks.SMOOTH_SOUL_SANDSTONE).slab(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB).stairs(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS).wall(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL).fence(ModBlocks.SMOOTH_SOUL_SANDSTONE_FENCE).getFamily();

    public static final BlockFamily ELDER_PRISMARINE = familyBuilder(ModBlocks.ELDER_PRISMARINE).slab(ModBlocks.ELDER_PRISMARINE_SLAB).stairs(ModBlocks.ELDER_PRISMARINE_STAIRS).wall(ModBlocks.ELDER_PRISMARINE_WALL).fence(ModBlocks.ELDER_PRISMARINE_FENCE).chiseled(ModBlocks.CHISELED_ELDER_PRISMARINE).getFamily();
    public static final BlockFamily ELDER_PRISMARINE_BRICKS = familyBuilder(ModBlocks.ELDER_PRISMARINE_BRICKS).slab(ModBlocks.ELDER_PRISMARINE_BRICK_SLAB).stairs(ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS).wall(ModBlocks.ELDER_PRISMARINE_BRICK_WALL).fence(ModBlocks.ELDER_PRISMARINE_BRICK_FENCE).chiseled(ModBlocks.CHISELED_ELDER_PRISMARINE_BRICKS).getFamily();
    public static final BlockFamily DARK_ELDER_PRISMARINE = familyBuilder(ModBlocks.DARK_ELDER_PRISMARINE).slab(ModBlocks.DARK_ELDER_PRISMARINE_SLAB).stairs(ModBlocks.DARK_ELDER_PRISMARINE_STAIRS).wall(ModBlocks.DARK_ELDER_PRISMARINE_WALL).fence(ModBlocks.DARK_ELDER_PRISMARINE_FENCE).getFamily();

    public static final BlockFamily ZINC_BLOCK = familyBuilder(ModBlocks.ZINC_BLOCK.weathering().unaffected()).cut(ModBlocks.CUT_ZINC.weathering().unaffected()).getFamily();
    public static final BlockFamily EXPOSED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.weathering().exposed()).cut(ModBlocks.CUT_ZINC.weathering().exposed()).getFamily();
    public static final BlockFamily WEATHERED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.weathering().weathered()).cut(ModBlocks.CUT_ZINC.weathering().weathered()).getFamily();
    public static final BlockFamily RUSTED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.weathering().corroded()).cut(ModBlocks.CUT_ZINC.weathering().corroded()).getFamily();

    public static final BlockFamily WAXED_ZINC_BLOCK = familyBuilder(ModBlocks.ZINC_BLOCK.waxed().unaffected()).cut(ModBlocks.CUT_ZINC.waxed().unaffected()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.waxed().exposed()).cut(ModBlocks.CUT_ZINC.waxed().exposed()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.waxed().weathered()).cut(ModBlocks.CUT_ZINC.waxed().weathered()).getFamily();
    public static final BlockFamily WAXED_RUSTED_ZINC = familyBuilder(ModBlocks.ZINC_BLOCK.waxed().corroded()).cut(ModBlocks.CUT_ZINC.waxed().corroded()).getFamily();

    public static final BlockFamily CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.weathering().unaffected()).stairs(ModBlocks.CUT_ZINC_STAIRS.weathering().unaffected()).slab(ModBlocks.CUT_ZINC_SLAB.weathering().unaffected()).getFamily();
    public static final BlockFamily EXPOSED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.weathering().exposed()).stairs(ModBlocks.CUT_ZINC_STAIRS.weathering().exposed()).slab(ModBlocks.CUT_ZINC_SLAB.weathering().exposed()).getFamily();
    public static final BlockFamily WEATHERED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.weathering().weathered()).stairs(ModBlocks.CUT_ZINC_STAIRS.weathering().weathered()).slab(ModBlocks.CUT_ZINC_SLAB.weathering().weathered()).getFamily();
    public static final BlockFamily RUSTED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.weathering().corroded()).stairs(ModBlocks.CUT_ZINC_STAIRS.weathering().corroded()).slab(ModBlocks.CUT_ZINC_SLAB.weathering().corroded()).getFamily();

    public static final BlockFamily WAXED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.waxed().unaffected()).stairs(ModBlocks.CUT_ZINC_STAIRS.waxed().unaffected()).slab(ModBlocks.CUT_ZINC_SLAB.waxed().unaffected()).getFamily();
    public static final BlockFamily WAXED_EXPOSED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.waxed().exposed()).stairs(ModBlocks.CUT_ZINC_STAIRS.waxed().exposed()).slab(ModBlocks.CUT_ZINC_SLAB.waxed().exposed()).getFamily();
    public static final BlockFamily WAXED_WEATHERED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.waxed().weathered()).stairs(ModBlocks.CUT_ZINC_STAIRS.waxed().weathered()).slab(ModBlocks.CUT_ZINC_SLAB.waxed().weathered()).getFamily();
    public static final BlockFamily WAXED_RUSTED_CUT_ZINC = familyBuilder(ModBlocks.CUT_ZINC.waxed().corroded()).stairs(ModBlocks.CUT_ZINC_STAIRS.waxed().corroded()).slab(ModBlocks.CUT_ZINC_SLAB.waxed().corroded()).getFamily();

    public static final BlockFamily SILVER_BLOCK = familyBuilder(ModBlocks.SILVER_BLOCK).cut(ModBlocks.CUT_SILVER).getFamily();
    public static final BlockFamily CUT_SILVER = familyBuilder(ModBlocks.CUT_SILVER).slab(ModBlocks.CUT_SILVER_SLAB).stairs(ModBlocks.CUT_SILVER_STAIRS).getFamily();

    public static final BlockFamily TIN_BLOCK = familyBuilder(ModBlocks.TIN_BLOCK).cut(ModBlocks.CUT_TIN).getFamily();
    public static final BlockFamily CUT_TIN = familyBuilder(ModBlocks.CUT_TIN).slab(ModBlocks.CUT_TIN_SLAB).stairs(ModBlocks.CUT_TIN_STAIRS).getFamily();

    public static final BlockFamily TUNGSTEN_BLOCK = familyBuilder(ModBlocks.TUNGSTEN_BLOCK).cut(ModBlocks.CUT_TUNGSTEN).getFamily();
    public static final BlockFamily CUT_TUNGSTEN = familyBuilder(ModBlocks.CUT_TUNGSTEN).slab(ModBlocks.CUT_TUNGSTEN_SLAB).stairs(ModBlocks.CUT_TUNGSTEN_STAIRS).getFamily();

    public static final BlockFamily PLATINUM_BLOCK = familyBuilder(ModBlocks.PLATINUM_BLOCK).cut(ModBlocks.CUT_PLATINUM).getFamily();
    public static final BlockFamily CUT_PLATINUM = familyBuilder(ModBlocks.CUT_PLATINUM).slab(ModBlocks.CUT_PLATINUM_SLAB).stairs(ModBlocks.CUT_PLATINUM_STAIRS).getFamily();

    public static final BlockFamily LEAD_BLOCK = familyBuilder(ModBlocks.LEAD_BLOCK).cut(ModBlocks.CUT_LEAD).getFamily();
    public static final BlockFamily CUT_LEAD = familyBuilder(ModBlocks.CUT_LEAD).slab(ModBlocks.CUT_LEAD_SLAB).stairs(ModBlocks.CUT_LEAD_STAIRS).getFamily();

    public static final BlockFamily URANIUM_BLOCK = familyBuilder(ModBlocks.URANIUM_BLOCK).cut(ModBlocks.CUT_URANIUM).getFamily();
    public static final BlockFamily CUT_URANIUM = familyBuilder(ModBlocks.CUT_URANIUM).slab(ModBlocks.CUT_URANIUM_SLAB).stairs(ModBlocks.CUT_URANIUM_STAIRS).getFamily();

    public static final BlockFamily BRONZE_BLOCK = familyBuilder(ModBlocks.BRONZE_BLOCK).cut(ModBlocks.CUT_BRONZE).getFamily();
    public static final BlockFamily CUT_BRONZE = familyBuilder(ModBlocks.CUT_BRONZE).slab(ModBlocks.CUT_BRONZE_SLAB).stairs(ModBlocks.CUT_BRONZE_STAIRS).getFamily();

    public static final BlockFamily BRASS_BLOCK = familyBuilder(ModBlocks.BRASS_BLOCK).cut(ModBlocks.CUT_BRASS).getFamily();
    public static final BlockFamily CUT_BRASS = familyBuilder(ModBlocks.CUT_BRASS).slab(ModBlocks.CUT_BRASS_SLAB).stairs(ModBlocks.CUT_BRASS_STAIRS).getFamily();

    public static final BlockFamily STEEL_BLOCK = familyBuilder(ModBlocks.STEEL_BLOCK).cut(ModBlocks.CUT_STEEL).getFamily();
    public static final BlockFamily CUT_STEEL = familyBuilder(ModBlocks.CUT_STEEL).slab(ModBlocks.CUT_STEEL_SLAB).stairs(ModBlocks.CUT_STEEL_STAIRS).getFamily();

    public static final BlockFamily OAK_PLANKS = familyBuilder(Blocks.OAK_PLANKS).mosaic(ModBlocks.OAK_MOSAIC).getFamily();
    public static final BlockFamily SPRUCE_PLANKS = familyBuilder(Blocks.SPRUCE_PLANKS).mosaic(ModBlocks.SPRUCE_MOSAIC).getFamily();
    public static final BlockFamily BIRCH_PLANKS = familyBuilder(Blocks.BIRCH_PLANKS).mosaic(ModBlocks.BIRCH_MOSAIC).getFamily();
    public static final BlockFamily JUNGLE_PLANKS = familyBuilder(Blocks.JUNGLE_PLANKS).mosaic(ModBlocks.JUNGLE_MOSAIC).getFamily();
    public static final BlockFamily ACACIA_PLANKS = familyBuilder(Blocks.ACACIA_PLANKS).mosaic(ModBlocks.ACACIA_MOSAIC).getFamily();
    public static final BlockFamily DARK_OAK_PLANKS = familyBuilder(Blocks.DARK_OAK_PLANKS).mosaic(ModBlocks.DARK_OAK_MOSAIC).getFamily();
    public static final BlockFamily CRIMSON_PLANKS = familyBuilder(Blocks.CRIMSON_PLANKS).mosaic(ModBlocks.CRIMSON_MOSAIC).getFamily();
    public static final BlockFamily WARPED_PLANKS = familyBuilder(Blocks.WARPED_PLANKS).mosaic(ModBlocks.WARPED_MOSAIC).getFamily();
    public static final BlockFamily MANGROVE_PLANKS = familyBuilder(Blocks.MANGROVE_PLANKS).mosaic(ModBlocks.MANGROVE_MOSAIC).getFamily();
    public static final BlockFamily CHERRY_PLANKS = familyBuilder(Blocks.CHERRY_PLANKS).mosaic(ModBlocks.CHERRY_MOSAIC).getFamily();
    public static final BlockFamily PALE_OAK_PLANKS = familyBuilder(Blocks.PALE_OAK_PLANKS).mosaic(ModBlocks.PALE_OAK_MOSAIC).getFamily();

    public static final BlockFamily OAK_MOSAIC = familyBuilder(ModBlocks.OAK_MOSAIC).slab(ModBlocks.OAK_MOSAIC_SLAB).stairs(ModBlocks.OAK_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily SPRUCE_MOSAIC = familyBuilder(ModBlocks.SPRUCE_MOSAIC).slab(ModBlocks.SPRUCE_MOSAIC_SLAB).stairs(ModBlocks.SPRUCE_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily BIRCH_MOSAIC = familyBuilder(ModBlocks.BIRCH_MOSAIC).slab(ModBlocks.BIRCH_MOSAIC_SLAB).stairs(ModBlocks.BIRCH_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily JUNGLE_MOSAIC = familyBuilder(ModBlocks.JUNGLE_MOSAIC).slab(ModBlocks.JUNGLE_MOSAIC_SLAB).stairs(ModBlocks.JUNGLE_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily ACACIA_MOSAIC = familyBuilder(ModBlocks.ACACIA_MOSAIC).slab(ModBlocks.ACACIA_MOSAIC_SLAB).stairs(ModBlocks.ACACIA_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily DARK_OAK_MOSAIC = familyBuilder(ModBlocks.DARK_OAK_MOSAIC).slab(ModBlocks.DARK_OAK_MOSAIC_SLAB).stairs(ModBlocks.DARK_OAK_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily CRIMSON_MOSAIC = familyBuilder(ModBlocks.CRIMSON_MOSAIC).slab(ModBlocks.CRIMSON_MOSAIC_SLAB).stairs(ModBlocks.CRIMSON_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily WARPED_MOSAIC = familyBuilder(ModBlocks.WARPED_MOSAIC).slab(ModBlocks.WARPED_MOSAIC_SLAB).stairs(ModBlocks.WARPED_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily MANGROVE_MOSAIC = familyBuilder(ModBlocks.MANGROVE_MOSAIC).slab(ModBlocks.MANGROVE_MOSAIC_SLAB).stairs(ModBlocks.MANGROVE_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily CHERRY_MOSAIC = familyBuilder(ModBlocks.CHERRY_MOSAIC).slab(ModBlocks.CHERRY_MOSAIC_SLAB).stairs(ModBlocks.CHERRY_MOSAIC_STAIRS).getFamily();
    public static final BlockFamily PALE_OAK_MOSAIC = familyBuilder(ModBlocks.PALE_OAK_MOSAIC).slab(ModBlocks.PALE_OAK_MOSAIC_SLAB).stairs(ModBlocks.PALE_OAK_MOSAIC_STAIRS).getFamily();

    public static final BlockFamily OBSIDIAN = familyBuilder(Blocks.OBSIDIAN).stairs(ModBlocks.OBSIDIAN_STAIRS).slab(ModBlocks.OBSIDIAN_SLAB).wall(ModBlocks.OBSIDIAN_WALL).polished(ModBlocks.OBSIDIAN_BRICKS).fence(ModBlocks.OBSIDIAN_FENCE).getFamily();
    public static final BlockFamily CRYING_OBSIDIAN = familyBuilder(Blocks.CRYING_OBSIDIAN).stairs(ModBlocks.CRYING_OBSIDIAN_STAIRS).slab(ModBlocks.CRYING_OBSIDIAN_SLAB).wall(ModBlocks.CRYING_OBSIDIAN_WALL).polished(ModBlocks.CRYING_OBSIDIAN_BRICKS).fence(ModBlocks.CRYING_OBSIDIAN_FENCE).getFamily();
    public static final BlockFamily COAL = familyBuilder(Blocks.COAL_BLOCK).stairs(ModBlocks.COAL_STAIRS).slab(ModBlocks.COAL_SLAB).wall(ModBlocks.COAL_WALL).polished(ModBlocks.COAL_BRICKS).fence(ModBlocks.COAL_FENCE).getFamily();
    public static final BlockFamily CHARCOAL = familyBuilder(ModBlocks.CHARCOAL_BLOCK).stairs(ModBlocks.CHARCOAL_STAIRS).slab(ModBlocks.CHARCOAL_SLAB).wall(ModBlocks.CHARCOAL_WALL).polished(ModBlocks.CHARCOAL_BRICKS).fence(ModBlocks.CHARCOAL_FENCE).getFamily();
    public static final BlockFamily LAPIS = familyBuilder(Blocks.LAPIS_BLOCK).stairs(ModBlocks.LAPIS_STAIRS).slab(ModBlocks.LAPIS_SLAB).wall(ModBlocks.LAPIS_WALL).polished(ModBlocks.LAPIS_BRICKS).fence(ModBlocks.LAPIS_FENCE).chiseled(ModBlocks.CHISELED_LAPIS).getFamily();
    public static final BlockFamily SNOW = familyBuilder(Blocks.SNOW_BLOCK).stairs(ModBlocks.SNOW_STAIRS).slab(ModBlocks.SNOW_SLAB).wall(ModBlocks.SNOW_WALL).polished(ModBlocks.SNOW_BRICKS).fence(ModBlocks.SNOW_FENCE).getFamily();
    public static final BlockFamily ICE = familyBuilder(Blocks.ICE).stairs(ModBlocks.ICE_STAIRS).slab(ModBlocks.ICE_SLAB).wall(ModBlocks.ICE_WALL).polished(ModBlocks.ICE_BRICKS).fence(ModBlocks.ICE_FENCE).getFamily();
    public static final BlockFamily PACKED_ICE = familyBuilder(Blocks.PACKED_ICE).stairs(ModBlocks.PACKED_ICE_STAIRS).slab(ModBlocks.PACKED_ICE_SLAB).wall(ModBlocks.PACKED_ICE_WALL).polished(ModBlocks.PACKED_ICE_BRICKS).fence(ModBlocks.PACKED_ICE_FENCE).getFamily();
    public static final BlockFamily BLUE_ICE = familyBuilder(Blocks.BLUE_ICE).stairs(ModBlocks.BLUE_ICE_STAIRS).slab(ModBlocks.BLUE_ICE_SLAB).wall(ModBlocks.BLUE_ICE_WALL).polished(ModBlocks.BLUE_ICE_BRICKS).fence(ModBlocks.BLUE_ICE_FENCE).getFamily();
    public static final BlockFamily TERRACOTTA = familyBuilder(Blocks.TERRACOTTA).stairs(ModBlocks.TERRACOTTA_STAIRS).slab(ModBlocks.TERRACOTTA_SLAB).wall(ModBlocks.TERRACOTTA_WALL).fence(ModBlocks.TERRACOTTA_FENCE).polished(ModBlocks.TERRACOTTA_BRICKS).getFamily();
    public static final BlockFamily SCULK = familyBuilder(Blocks.SCULK).stairs(ModBlocks.SCULK_STAIRS).slab(ModBlocks.SCULK_SLAB).wall(ModBlocks.SCULK_WALL).fence(ModBlocks.SCULK_FENCE).getFamily();

    public static final BlockFamily WHITE_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.white()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.white()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.white()).wall(ModBlocks.DYED_TERRACOTTA_WALL.white()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.white()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.white()).getFamily();
    public static final BlockFamily ORANGE_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.orange()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.orange()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.orange()).wall(ModBlocks.DYED_TERRACOTTA_WALL.orange()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.orange()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.orange()).getFamily();
    public static final BlockFamily MAGENTA_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.magenta()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.magenta()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.magenta()).wall(ModBlocks.DYED_TERRACOTTA_WALL.magenta()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.magenta()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.magenta()).getFamily();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.lightBlue()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.lightBlue()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.lightBlue()).wall(ModBlocks.DYED_TERRACOTTA_WALL.lightBlue()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.lightBlue()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.lightBlue()).getFamily();
    public static final BlockFamily YELLOW_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.yellow()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.yellow()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.yellow()).wall(ModBlocks.DYED_TERRACOTTA_WALL.yellow()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.yellow()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.yellow()).getFamily();
    public static final BlockFamily LIME_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.lime()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.lime()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.lime()).wall(ModBlocks.DYED_TERRACOTTA_WALL.lime()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.lime()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.lime()).getFamily();
    public static final BlockFamily PINK_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.pink()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.pink()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.pink()).wall(ModBlocks.DYED_TERRACOTTA_WALL.pink()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.pink()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.pink()).getFamily();
    public static final BlockFamily GRAY_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.gray()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.gray()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.gray()).wall(ModBlocks.DYED_TERRACOTTA_WALL.gray()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.gray()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.gray()).getFamily();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.lightGray()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.lightGray()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.lightGray()).wall(ModBlocks.DYED_TERRACOTTA_WALL.lightGray()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.lightGray()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.lightGray()).getFamily();
    public static final BlockFamily CYAN_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.cyan()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.cyan()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.cyan()).wall(ModBlocks.DYED_TERRACOTTA_WALL.cyan()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.cyan()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.cyan()).getFamily();
    public static final BlockFamily PURPLE_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.purple()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.purple()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.purple()).wall(ModBlocks.DYED_TERRACOTTA_WALL.purple()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.purple()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.purple()).getFamily();
    public static final BlockFamily BLUE_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.blue()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.blue()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.blue()).wall(ModBlocks.DYED_TERRACOTTA_WALL.blue()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.blue()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.blue()).getFamily();
    public static final BlockFamily BROWN_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.brown()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.brown()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.brown()).wall(ModBlocks.DYED_TERRACOTTA_WALL.brown()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.brown()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.brown()).getFamily();
    public static final BlockFamily GREEN_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.green()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.green()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.green()).wall(ModBlocks.DYED_TERRACOTTA_WALL.green()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.green()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.green()).getFamily();
    public static final BlockFamily RED_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.red()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.red()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.red()).wall(ModBlocks.DYED_TERRACOTTA_WALL.red()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.red()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.red()).getFamily();
    public static final BlockFamily BLACK_TERRACOTTA = familyBuilder(Blocks.DYED_TERRACOTTA.black()).stairs(ModBlocks.DYED_TERRACOTTA_STAIRS.black()).slab(ModBlocks.DYED_TERRACOTTA_SLAB.black()).wall(ModBlocks.DYED_TERRACOTTA_WALL.black()).fence(ModBlocks.DYED_TERRACOTTA_FENCE.black()).polished(ModBlocks.DYED_TERRACOTTA_BRICKS.black()).getFamily();

    public static final BlockFamily WHITE_CONCRETE = familyBuilder(Blocks.CONCRETE.white()).stairs(ModBlocks.CONCRETE_STAIRS.white()).slab(ModBlocks.CONCRETE_SLAB.white()).wall(ModBlocks.CONCRETE_WALL.white()).fence(ModBlocks.CONCRETE_FENCE.white()).polished(ModBlocks.CONCRETE_BRICKS.white()).getFamily();
    public static final BlockFamily ORANGE_CONCRETE = familyBuilder(Blocks.CONCRETE.orange()).stairs(ModBlocks.CONCRETE_STAIRS.orange()).slab(ModBlocks.CONCRETE_SLAB.orange()).wall(ModBlocks.CONCRETE_WALL.orange()).fence(ModBlocks.CONCRETE_FENCE.orange()).polished(ModBlocks.CONCRETE_BRICKS.orange()).getFamily();
    public static final BlockFamily MAGENTA_CONCRETE = familyBuilder(Blocks.CONCRETE.magenta()).stairs(ModBlocks.CONCRETE_STAIRS.magenta()).slab(ModBlocks.CONCRETE_SLAB.magenta()).wall(ModBlocks.CONCRETE_WALL.magenta()).fence(ModBlocks.CONCRETE_FENCE.magenta()).polished(ModBlocks.CONCRETE_BRICKS.magenta()).getFamily();
    public static final BlockFamily LIGHT_BLUE_CONCRETE = familyBuilder(Blocks.CONCRETE.lightBlue()).stairs(ModBlocks.CONCRETE_STAIRS.lightBlue()).slab(ModBlocks.CONCRETE_SLAB.lightBlue()).wall(ModBlocks.CONCRETE_WALL.lightBlue()).fence(ModBlocks.CONCRETE_FENCE.lightBlue()).polished(ModBlocks.CONCRETE_BRICKS.lightBlue()).getFamily();
    public static final BlockFamily YELLOW_CONCRETE = familyBuilder(Blocks.CONCRETE.yellow()).stairs(ModBlocks.CONCRETE_STAIRS.yellow()).slab(ModBlocks.CONCRETE_SLAB.yellow()).wall(ModBlocks.CONCRETE_WALL.yellow()).fence(ModBlocks.CONCRETE_FENCE.yellow()).polished(ModBlocks.CONCRETE_BRICKS.yellow()).getFamily();
    public static final BlockFamily LIME_CONCRETE = familyBuilder(Blocks.CONCRETE.lime()).stairs(ModBlocks.CONCRETE_STAIRS.lime()).slab(ModBlocks.CONCRETE_SLAB.lime()).wall(ModBlocks.CONCRETE_WALL.lime()).fence(ModBlocks.CONCRETE_FENCE.lime()).polished(ModBlocks.CONCRETE_BRICKS.lime()).getFamily();
    public static final BlockFamily PINK_CONCRETE = familyBuilder(Blocks.CONCRETE.pink()).stairs(ModBlocks.CONCRETE_STAIRS.pink()).slab(ModBlocks.CONCRETE_SLAB.pink()).wall(ModBlocks.CONCRETE_WALL.pink()).fence(ModBlocks.CONCRETE_FENCE.pink()).polished(ModBlocks.CONCRETE_BRICKS.pink()).getFamily();
    public static final BlockFamily GRAY_CONCRETE = familyBuilder(Blocks.CONCRETE.gray()).stairs(ModBlocks.CONCRETE_STAIRS.gray()).slab(ModBlocks.CONCRETE_SLAB.gray()).wall(ModBlocks.CONCRETE_WALL.gray()).fence(ModBlocks.CONCRETE_FENCE.gray()).polished(ModBlocks.CONCRETE_BRICKS.gray()).getFamily();
    public static final BlockFamily LIGHT_GRAY_CONCRETE = familyBuilder(Blocks.CONCRETE.lightGray()).stairs(ModBlocks.CONCRETE_STAIRS.lightGray()).slab(ModBlocks.CONCRETE_SLAB.lightGray()).wall(ModBlocks.CONCRETE_WALL.lightGray()).fence(ModBlocks.CONCRETE_FENCE.lightGray()).polished(ModBlocks.CONCRETE_BRICKS.lightGray()).getFamily();
    public static final BlockFamily CYAN_CONCRETE = familyBuilder(Blocks.CONCRETE.cyan()).stairs(ModBlocks.CONCRETE_STAIRS.cyan()).slab(ModBlocks.CONCRETE_SLAB.cyan()).wall(ModBlocks.CONCRETE_WALL.cyan()).fence(ModBlocks.CONCRETE_FENCE.cyan()).polished(ModBlocks.CONCRETE_BRICKS.cyan()).getFamily();
    public static final BlockFamily PURPLE_CONCRETE = familyBuilder(Blocks.CONCRETE.purple()).stairs(ModBlocks.CONCRETE_STAIRS.purple()).slab(ModBlocks.CONCRETE_SLAB.purple()).wall(ModBlocks.CONCRETE_WALL.purple()).fence(ModBlocks.CONCRETE_FENCE.purple()).polished(ModBlocks.CONCRETE_BRICKS.purple()).getFamily();
    public static final BlockFamily BLUE_CONCRETE = familyBuilder(Blocks.CONCRETE.blue()).stairs(ModBlocks.CONCRETE_STAIRS.blue()).slab(ModBlocks.CONCRETE_SLAB.blue()).wall(ModBlocks.CONCRETE_WALL.blue()).fence(ModBlocks.CONCRETE_FENCE.blue()).polished(ModBlocks.CONCRETE_BRICKS.blue()).getFamily();
    public static final BlockFamily BROWN_CONCRETE = familyBuilder(Blocks.CONCRETE.brown()).stairs(ModBlocks.CONCRETE_STAIRS.brown()).slab(ModBlocks.CONCRETE_SLAB.brown()).wall(ModBlocks.CONCRETE_WALL.brown()).fence(ModBlocks.CONCRETE_FENCE.brown()).polished(ModBlocks.CONCRETE_BRICKS.brown()).getFamily();
    public static final BlockFamily GREEN_CONCRETE = familyBuilder(Blocks.CONCRETE.green()).stairs(ModBlocks.CONCRETE_STAIRS.green()).slab(ModBlocks.CONCRETE_SLAB.green()).wall(ModBlocks.CONCRETE_WALL.green()).fence(ModBlocks.CONCRETE_FENCE.green()).polished(ModBlocks.CONCRETE_BRICKS.green()).getFamily();
    public static final BlockFamily RED_CONCRETE = familyBuilder(Blocks.CONCRETE.red()).stairs(ModBlocks.CONCRETE_STAIRS.red()).slab(ModBlocks.CONCRETE_SLAB.red()).wall(ModBlocks.CONCRETE_WALL.red()).fence(ModBlocks.CONCRETE_FENCE.red()).polished(ModBlocks.CONCRETE_BRICKS.red()).getFamily();
    public static final BlockFamily BLACK_CONCRETE = familyBuilder(Blocks.CONCRETE.black()).stairs(ModBlocks.CONCRETE_STAIRS.black()).slab(ModBlocks.CONCRETE_SLAB.black()).wall(ModBlocks.CONCRETE_WALL.black()).fence(ModBlocks.CONCRETE_FENCE.black()).polished(ModBlocks.CONCRETE_BRICKS.black()).getFamily();

    public static final BlockFamily STONE_TILES = familyBuilder(ModBlocks.STONE_TILES).slab(ModBlocks.STONE_TILE_SLAB).stairs(ModBlocks.STONE_TILE_STAIRS).wall(ModBlocks.STONE_TILE_WALL).fence(ModBlocks.STONE_TILE_FENCE).getFamily();
    public static final BlockFamily MOSSY_STONE_TILES = familyBuilder(ModBlocks.MOSSY_STONE_TILES).slab(ModBlocks.MOSSY_STONE_TILE_SLAB).stairs(ModBlocks.MOSSY_STONE_TILE_STAIRS).wall(ModBlocks.MOSSY_STONE_TILE_WALL).fence(ModBlocks.MOSSY_STONE_TILE_FENCE).getFamily();
    public static final BlockFamily CRACKED_STONE_TILES = familyBuilder(ModBlocks.CRACKED_STONE_TILES).slab(ModBlocks.CRACKED_STONE_TILE_SLAB).stairs(ModBlocks.CRACKED_STONE_TILE_STAIRS).wall(ModBlocks.CRACKED_STONE_TILE_WALL).fence(ModBlocks.CRACKED_STONE_TILE_FENCE).getFamily();
    public static final BlockFamily OBSIDIAN_BRICKS = familyBuilder(ModBlocks.OBSIDIAN_BRICKS).slab(ModBlocks.OBSIDIAN_BRICK_SLAB).stairs(ModBlocks.OBSIDIAN_BRICK_STAIRS).wall(ModBlocks.OBSIDIAN_BRICK_WALL).fence(ModBlocks.OBSIDIAN_BRICK_FENCE).getFamily();
    public static final BlockFamily CRYING_OBSIDIAN_BRICKS = familyBuilder(ModBlocks.CRYING_OBSIDIAN_BRICKS).slab(ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB).stairs(ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS).wall(ModBlocks.CRYING_OBSIDIAN_BRICK_WALL).fence(ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE).getFamily();
    public static final BlockFamily COAL_BRICKS = familyBuilder(ModBlocks.COAL_BRICKS).stairs(ModBlocks.COAL_BRICK_STAIRS).slab(ModBlocks.COAL_BRICK_SLAB).wall(ModBlocks.COAL_BRICK_WALL).fence(ModBlocks.COAL_BRICK_FENCE).getFamily();
    public static final BlockFamily CHARCOAL_BRICKS = familyBuilder(ModBlocks.CHARCOAL_BRICKS).stairs(ModBlocks.CHARCOAL_BRICK_STAIRS).slab(ModBlocks.CHARCOAL_BRICK_SLAB).wall(ModBlocks.CHARCOAL_BRICK_WALL).fence(ModBlocks.CHARCOAL_BRICK_FENCE).getFamily();
    public static final BlockFamily LAPIS_BRICKS = familyBuilder(ModBlocks.LAPIS_BRICKS).slab(ModBlocks.LAPIS_BRICK_SLAB).stairs(ModBlocks.LAPIS_BRICK_STAIRS).wall(ModBlocks.LAPIS_BRICK_WALL).fence(ModBlocks.LAPIS_BRICK_FENCE).getFamily();
    public static final BlockFamily SMOOTH_LAPIS = familyBuilder(ModBlocks.SMOOTH_LAPIS).slab(ModBlocks.SMOOTH_LAPIS_SLAB).stairs(ModBlocks.SMOOTH_LAPIS_STAIRS).wall(ModBlocks.SMOOTH_LAPIS_WALL).fence(ModBlocks.SMOOTH_LAPIS_FENCE).getFamily();
    public static final BlockFamily SNOW_BRICKS = familyBuilder(ModBlocks.SNOW_BRICKS).slab(ModBlocks.SNOW_BRICK_SLAB).stairs(ModBlocks.SNOW_BRICK_STAIRS).wall(ModBlocks.SNOW_BRICK_WALL).fence(ModBlocks.SNOW_BRICK_FENCE).getFamily();
    public static final BlockFamily ICE_BRICKS = familyBuilder(ModBlocks.ICE_BRICKS).slab(ModBlocks.ICE_BRICK_SLAB).stairs(ModBlocks.ICE_BRICK_STAIRS).wall(ModBlocks.ICE_BRICK_WALL).fence(ModBlocks.ICE_BRICK_FENCE).getFamily();
    public static final BlockFamily PACKED_ICE_BRICKS = familyBuilder(ModBlocks.PACKED_ICE_BRICKS).slab(ModBlocks.PACKED_ICE_BRICK_SLAB).stairs(ModBlocks.PACKED_ICE_BRICK_STAIRS).wall(ModBlocks.PACKED_ICE_BRICK_WALL).fence(ModBlocks.PACKED_ICE_BRICK_FENCE).getFamily();
    public static final BlockFamily BLUE_ICE_BRICKS = familyBuilder(ModBlocks.BLUE_ICE_BRICKS).slab(ModBlocks.BLUE_ICE_BRICK_SLAB).stairs(ModBlocks.BLUE_ICE_BRICK_STAIRS).wall(ModBlocks.BLUE_ICE_BRICK_WALL).fence(ModBlocks.BLUE_ICE_BRICK_FENCE).getFamily();
    public static final BlockFamily SCULK_BRICKS = familyBuilder(ModBlocks.SCULK_BRICKS).slab(ModBlocks.SCULK_BRICK_SLAB).stairs(ModBlocks.SCULK_BRICK_STAIRS).wall(ModBlocks.SCULK_BRICK_WALL).chiseled(ModBlocks.CHISELED_SCULK_BRICKS).fence(ModBlocks.SCULK_BRICK_FENCE).getFamily();

    public static final BlockFamily GABBRO = familyBuilder(ModBlocks.GABBRO).polished(ModBlocks.POLISHED_GABBRO).stairs(ModBlocks.GABBRO_STAIRS).slab(ModBlocks.GABBRO_SLAB).wall(ModBlocks.GABBRO_WALL).fence(ModBlocks.GABBRO_FENCE).getFamily();
    public static final BlockFamily RHYOLITE = familyBuilder(ModBlocks.RHYOLITE).polished(ModBlocks.POLISHED_RHYOLITE).stairs(ModBlocks.RHYOLITE_STAIRS).slab(ModBlocks.RHYOLITE_SLAB).wall(ModBlocks.RHYOLITE_WALL).fence(ModBlocks.RHYOLITE_FENCE).getFamily();
    public static final BlockFamily POLISHED_RHYOLITE = familyBuilder(ModBlocks.POLISHED_RHYOLITE).stairs(ModBlocks.POLISHED_RHYOLITE_STAIRS).slab(ModBlocks.POLISHED_RHYOLITE_SLAB).wall(ModBlocks.POLISHED_RHYOLITE_WALL).polished(ModBlocks.RHYOLITE_BRICKS).fence(ModBlocks.POLISHED_RHYOLITE_FENCE).getFamily();
    public static final BlockFamily POLISHED_GABBRO = familyBuilder(ModBlocks.POLISHED_GABBRO).stairs(ModBlocks.POLISHED_GABBRO_STAIRS).slab(ModBlocks.POLISHED_GABBRO_SLAB).wall(ModBlocks.POLISHED_GABBRO_WALL).polished(ModBlocks.GABBRO_BRICKS).fence(ModBlocks.POLISHED_GABBRO_FENCE).getFamily();
    public static final BlockFamily GABBRO_BRICKS = familyBuilder(ModBlocks.GABBRO_BRICKS).stairs(ModBlocks.GABBRO_BRICK_STAIRS).slab(ModBlocks.GABBRO_BRICK_SLAB).wall(ModBlocks.GABBRO_BRICK_WALL).fence(ModBlocks.GABBRO_BRICK_FENCE).getFamily();
    public static final BlockFamily RHYOLITE_BRICKS = familyBuilder(ModBlocks.RHYOLITE_BRICKS).stairs(ModBlocks.RHYOLITE_BRICK_STAIRS).slab(ModBlocks.RHYOLITE_BRICK_SLAB).wall(ModBlocks.RHYOLITE_BRICK_WALL).fence(ModBlocks.RHYOLITE_BRICK_FENCE).getFamily();

    public static final BlockFamily PUMICE = familyBuilder(ModBlocks.PUMICE).polished(ModBlocks.POLISHED_PUMICE).stairs(ModBlocks.PUMICE_STAIRS).slab(ModBlocks.PUMICE_SLAB).wall(ModBlocks.PUMICE_WALL).fence(ModBlocks.PUMICE_FENCE).getFamily();
    public static final BlockFamily POLISHED_PUMICE = familyBuilder(ModBlocks.POLISHED_PUMICE).stairs(ModBlocks.POLISHED_PUMICE_STAIRS).slab(ModBlocks.POLISHED_PUMICE_SLAB).wall(ModBlocks.POLISHED_PUMICE_WALL).polished(ModBlocks.PUMICE_BRICKS).fence(ModBlocks.POLISHED_PUMICE_FENCE).getFamily();
    public static final BlockFamily PUMICE_BRICKS = familyBuilder(ModBlocks.PUMICE_BRICKS).stairs(ModBlocks.PUMICE_BRICK_STAIRS).slab(ModBlocks.PUMICE_BRICK_SLAB).wall(ModBlocks.PUMICE_BRICK_WALL).fence(ModBlocks.PUMICE_BRICK_FENCE).getFamily();

    public static final BlockFamily POLISHED_STONE = familyBuilder(ModBlocks.POLISHED_STONE).stairs(ModBlocks.POLISHED_STONE_STAIRS).slab(ModBlocks.POLISHED_STONE_SLAB).wall(ModBlocks.POLISHED_STONE_WALL).fence(ModBlocks.POLISHED_STONE_FENCE).getFamily();
    public static final BlockFamily SMOOTH_DEEPSLATE = familyBuilder(ModBlocks.SMOOTH_DEEPSLATE).stairs(ModBlocks.SMOOTH_DEEPSLATE_STAIRS).slab(ModBlocks.SMOOTH_DEEPSLATE_SLAB).wall(ModBlocks.SMOOTH_DEEPSLATE_WALL).fence(ModBlocks.SMOOTH_DEEPSLATE_FENCE).getFamily();
    public static final BlockFamily NETHERRACK_BRICKS = familyBuilder(ModBlocks.NETHERRACK_BRICKS).stairs(ModBlocks.NETHERRACK_BRICK_STAIRS).slab(ModBlocks.NETHERRACK_BRICK_SLAB).wall(ModBlocks.NETHERRACK_BRICK_WALL).fence(ModBlocks.NETHERRACK_BRICK_FENCE).getFamily();
    public static final BlockFamily TERRACOTTA_BRICKS = familyBuilder(ModBlocks.TERRACOTTA_BRICKS).stairs(ModBlocks.TERRACOTTA_BRICK_STAIRS).slab(ModBlocks.TERRACOTTA_BRICK_SLAB).wall(ModBlocks.TERRACOTTA_BRICK_WALL).fence(ModBlocks.TERRACOTTA_BRICK_FENCE).getFamily();
    public static final BlockFamily BIG_BRICKS = familyBuilder(ModBlocks.BIG_BRICKS).stairs(ModBlocks.BIG_BRICK_STAIRS).slab(ModBlocks.BIG_BRICK_SLAB).wall(ModBlocks.BIG_BRICK_WALL).fence(ModBlocks.BIG_BRICK_FENCE).getFamily();

    public static final BlockFamily WHITE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.white()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.white()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.white()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.white()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.white()).getFamily();
    public static final BlockFamily ORANGE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.orange()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.orange()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.orange()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.orange()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.orange()).getFamily();
    public static final BlockFamily MAGENTA_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.magenta()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.magenta()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.magenta()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.magenta()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.magenta()).getFamily();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.lightBlue()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.lightBlue()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.lightBlue()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.lightBlue()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.lightBlue()).getFamily();
    public static final BlockFamily YELLOW_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.yellow()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.yellow()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.yellow()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.yellow()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.yellow()).getFamily();
    public static final BlockFamily LIME_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.lime()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.lime()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.lime()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.lime()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.lime()).getFamily();
    public static final BlockFamily PINK_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.pink()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.pink()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.pink()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.pink()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.pink()).getFamily();
    public static final BlockFamily GRAY_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.gray()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.gray()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.gray()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.gray()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.gray()).getFamily();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.lightGray()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.lightGray()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.lightGray()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.lightGray()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.lightGray()).getFamily();
    public static final BlockFamily CYAN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.cyan()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.cyan()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.cyan()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.cyan()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.cyan()).getFamily();
    public static final BlockFamily PURPLE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.purple()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.purple()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.purple()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.purple()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.purple()).getFamily();
    public static final BlockFamily BLUE_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.blue()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.blue()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.blue()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.blue()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.blue()).getFamily();
    public static final BlockFamily BROWN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.brown()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.brown()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.brown()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.brown()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.brown()).getFamily();
    public static final BlockFamily GREEN_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.green()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.green()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.green()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.green()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.green()).getFamily();
    public static final BlockFamily RED_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.red()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.red()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.red()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.red()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.red()).getFamily();
    public static final BlockFamily BLACK_TERRACOTTA_BRICKS = familyBuilder(ModBlocks.DYED_TERRACOTTA_BRICKS.black()).stairs(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS.black()).slab(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB.black()).wall(ModBlocks.DYED_TERRACOTTA_BRICK_WALL.black()).fence(ModBlocks.DYED_TERRACOTTA_BRICK_FENCE.black()).getFamily();

    public static final BlockFamily WHITE_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.white()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.white()).slab(ModBlocks.CONCRETE_BRICK_SLAB.white()).wall(ModBlocks.CONCRETE_BRICK_WALL.white()).fence(ModBlocks.CONCRETE_BRICK_FENCE.white()).getFamily();
    public static final BlockFamily ORANGE_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.orange()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.orange()).slab(ModBlocks.CONCRETE_BRICK_SLAB.orange()).wall(ModBlocks.CONCRETE_BRICK_WALL.orange()).fence(ModBlocks.CONCRETE_BRICK_FENCE.orange()).getFamily();
    public static final BlockFamily MAGENTA_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.magenta()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.magenta()).slab(ModBlocks.CONCRETE_BRICK_SLAB.magenta()).wall(ModBlocks.CONCRETE_BRICK_WALL.magenta()).fence(ModBlocks.CONCRETE_BRICK_FENCE.magenta()).getFamily();
    public static final BlockFamily LIGHT_BLUE_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.lightBlue()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.lightBlue()).slab(ModBlocks.CONCRETE_BRICK_SLAB.lightBlue()).wall(ModBlocks.CONCRETE_BRICK_WALL.lightBlue()).fence(ModBlocks.CONCRETE_BRICK_FENCE.lightBlue()).getFamily();
    public static final BlockFamily YELLOW_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.yellow()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.yellow()).slab(ModBlocks.CONCRETE_BRICK_SLAB.yellow()).wall(ModBlocks.CONCRETE_BRICK_WALL.yellow()).fence(ModBlocks.CONCRETE_BRICK_FENCE.yellow()).getFamily();
    public static final BlockFamily LIME_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.lime()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.lime()).slab(ModBlocks.CONCRETE_BRICK_SLAB.lime()).wall(ModBlocks.CONCRETE_BRICK_WALL.lime()).fence(ModBlocks.CONCRETE_BRICK_FENCE.lime()).getFamily();
    public static final BlockFamily PINK_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.pink()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.pink()).slab(ModBlocks.CONCRETE_BRICK_SLAB.pink()).wall(ModBlocks.CONCRETE_BRICK_WALL.pink()).fence(ModBlocks.CONCRETE_BRICK_FENCE.pink()).getFamily();
    public static final BlockFamily GRAY_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.gray()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.gray()).slab(ModBlocks.CONCRETE_BRICK_SLAB.gray()).wall(ModBlocks.CONCRETE_BRICK_WALL.gray()).fence(ModBlocks.CONCRETE_BRICK_FENCE.gray()).getFamily();
    public static final BlockFamily LIGHT_GRAY_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.lightGray()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.lightGray()).slab(ModBlocks.CONCRETE_BRICK_SLAB.lightGray()).wall(ModBlocks.CONCRETE_BRICK_WALL.lightGray()).fence(ModBlocks.CONCRETE_BRICK_FENCE.lightGray()).getFamily();
    public static final BlockFamily CYAN_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.cyan()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.cyan()).slab(ModBlocks.CONCRETE_BRICK_SLAB.cyan()).wall(ModBlocks.CONCRETE_BRICK_WALL.cyan()).fence(ModBlocks.CONCRETE_BRICK_FENCE.cyan()).getFamily();
    public static final BlockFamily PURPLE_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.purple()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.purple()).slab(ModBlocks.CONCRETE_BRICK_SLAB.purple()).wall(ModBlocks.CONCRETE_BRICK_WALL.purple()).fence(ModBlocks.CONCRETE_BRICK_FENCE.purple()).getFamily();
    public static final BlockFamily BLUE_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.blue()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.blue()).slab(ModBlocks.CONCRETE_BRICK_SLAB.blue()).wall(ModBlocks.CONCRETE_BRICK_WALL.blue()).fence(ModBlocks.CONCRETE_BRICK_FENCE.blue()).getFamily();
    public static final BlockFamily BROWN_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.brown()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.brown()).slab(ModBlocks.CONCRETE_BRICK_SLAB.brown()).wall(ModBlocks.CONCRETE_BRICK_WALL.brown()).fence(ModBlocks.CONCRETE_BRICK_FENCE.brown()).getFamily();
    public static final BlockFamily GREEN_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.green()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.green()).slab(ModBlocks.CONCRETE_BRICK_SLAB.green()).wall(ModBlocks.CONCRETE_BRICK_WALL.green()).fence(ModBlocks.CONCRETE_BRICK_FENCE.green()).getFamily();
    public static final BlockFamily RED_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.red()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.red()).slab(ModBlocks.CONCRETE_BRICK_SLAB.red()).wall(ModBlocks.CONCRETE_BRICK_WALL.red()).fence(ModBlocks.CONCRETE_BRICK_FENCE.red()).getFamily();
    public static final BlockFamily BLACK_CONCRETE_BRICKS = familyBuilder(ModBlocks.CONCRETE_BRICKS.black()).stairs(ModBlocks.CONCRETE_BRICK_STAIRS.black()).slab(ModBlocks.CONCRETE_BRICK_SLAB.black()).wall(ModBlocks.CONCRETE_BRICK_WALL.black()).fence(ModBlocks.CONCRETE_BRICK_FENCE.black()).getFamily();

    public static final BlockFamily GILDED_BLACKSTONE = familyBuilder(Blocks.GILDED_BLACKSTONE).stairs(ModBlocks.GILDED_BLACKSTONE_STAIRS).slab(ModBlocks.GILDED_BLACKSTONE_SLAB).wall(ModBlocks.GILDED_BLACKSTONE_WALL).fence(ModBlocks.GILDED_BLACKSTONE_FENCE).getFamily();

    public static final BlockFamily GLASS = familyBuilder(Blocks.GLASS).door(ModBlocks.GLASS_DOOR).trapdoor(ModBlocks.GLASS_TRAPDOOR).getFamily();
    public static final BlockFamily TINTED_GLASS = familyBuilder(Blocks.TINTED_GLASS).door(ModBlocks.TINTED_GLASS_DOOR).trapdoor(ModBlocks.TINTED_GLASS_TRAPDOOR).getFamily();

    public static final BlockFamily WHITE_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.white()).door(ModBlocks.STAINED_GLASS_DOOR.white()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.white()).getFamily();
    public static final BlockFamily ORANGE_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.orange()).door(ModBlocks.STAINED_GLASS_DOOR.orange()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.orange()).getFamily();
    public static final BlockFamily MAGENTA_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.magenta()).door(ModBlocks.STAINED_GLASS_DOOR.magenta()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.magenta()).getFamily();
    public static final BlockFamily LIGHT_BLUE_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.lightBlue()).door(ModBlocks.STAINED_GLASS_DOOR.lightBlue()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.lightBlue()).getFamily();
    public static final BlockFamily YELLOW_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.yellow()).door(ModBlocks.STAINED_GLASS_DOOR.yellow()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.yellow()).getFamily();
    public static final BlockFamily LIME_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.lime()).door(ModBlocks.STAINED_GLASS_DOOR.lime()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.lime()).getFamily();
    public static final BlockFamily PINK_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.pink()).door(ModBlocks.STAINED_GLASS_DOOR.pink()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.pink()).getFamily();
    public static final BlockFamily GRAY_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.gray()).door(ModBlocks.STAINED_GLASS_DOOR.gray()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.gray()).getFamily();
    public static final BlockFamily LIGHT_GRAY_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.lightGray()).door(ModBlocks.STAINED_GLASS_DOOR.lightGray()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.lightGray()).getFamily();
    public static final BlockFamily CYAN_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.cyan()).door(ModBlocks.STAINED_GLASS_DOOR.cyan()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.cyan()).getFamily();
    public static final BlockFamily PURPLE_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.purple()).door(ModBlocks.STAINED_GLASS_DOOR.purple()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.purple()).getFamily();
    public static final BlockFamily BLUE_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.blue()).door(ModBlocks.STAINED_GLASS_DOOR.blue()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.blue()).getFamily();
    public static final BlockFamily BROWN_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.brown()).door(ModBlocks.STAINED_GLASS_DOOR.brown()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.brown()).getFamily();
    public static final BlockFamily GREEN_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.green()).door(ModBlocks.STAINED_GLASS_DOOR.green()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.green()).getFamily();
    public static final BlockFamily RED_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.red()).door(ModBlocks.STAINED_GLASS_DOOR.red()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.red()).getFamily();
    public static final BlockFamily BLACK_STAINED_GLASS = familyBuilder(Blocks.STAINED_GLASS.black()).door(ModBlocks.STAINED_GLASS_DOOR.black()).trapdoor(ModBlocks.STAINED_GLASS_TRAPDOOR.black()).getFamily();

    public static final BlockFamily GRAPHITE = familyBuilder(ModBlocks.GRAPHITE).polished(ModBlocks.POLISHED_GRAPHITE).stairs(ModBlocks.GRAPHITE_STAIRS).slab(ModBlocks.GRAPHITE_SLAB).wall(ModBlocks.GRAPHITE_WALL).fence(ModBlocks.GRAPHITE_FENCE).getFamily();
    public static final BlockFamily POLISHED_GRAPHITE = familyBuilder(ModBlocks.POLISHED_GRAPHITE).stairs(ModBlocks.POLISHED_GRAPHITE_STAIRS).slab(ModBlocks.POLISHED_GRAPHITE_SLAB).wall(ModBlocks.POLISHED_GRAPHITE_WALL).polished(ModBlocks.GRAPHITE_BRICKS).fence(ModBlocks.POLISHED_GRAPHITE_FENCE).getFamily();
    public static final BlockFamily GRAPHITE_BRICKS = familyBuilder(ModBlocks.GRAPHITE_BRICKS).stairs(ModBlocks.GRAPHITE_BRICK_STAIRS).slab(ModBlocks.GRAPHITE_BRICK_SLAB).wall(ModBlocks.GRAPHITE_BRICK_WALL).fence(ModBlocks.GRAPHITE_BRICK_FENCE).getFamily();

    public static final BlockFamily BISMUTH_BLOCK = familyBuilder(ModBlocks.BISMUTH_BLOCK).cut(ModBlocks.CUT_BISMUTH).getFamily();
    public static final BlockFamily CUT_BISMUTH = familyBuilder(ModBlocks.CUT_BISMUTH).slab(ModBlocks.CUT_BISMUTH_SLAB).stairs(ModBlocks.CUT_BISMUTH_STAIRS).getFamily();

    public static final BlockFamily SILICITE = familyBuilder(ModBlocks.SILICITE).polished(ModBlocks.POLISHED_SILICITE).stairs(ModBlocks.SILICITE_STAIRS).slab(ModBlocks.SILICITE_SLAB).wall(ModBlocks.SILICITE_WALL).fence(ModBlocks.SILICITE_FENCE).getFamily();
    public static final BlockFamily POLISHED_SILICITE = familyBuilder(ModBlocks.POLISHED_SILICITE).stairs(ModBlocks.POLISHED_SILICITE_STAIRS).slab(ModBlocks.POLISHED_SILICITE_SLAB).wall(ModBlocks.POLISHED_SILICITE_WALL).polished(ModBlocks.SILICITE_BRICKS).fence(ModBlocks.POLISHED_SILICITE_FENCE).getFamily();
    public static final BlockFamily SILICITE_BRICKS = familyBuilder(ModBlocks.SILICITE_BRICKS).stairs(ModBlocks.SILICITE_BRICK_STAIRS).slab(ModBlocks.SILICITE_BRICK_SLAB).wall(ModBlocks.SILICITE_BRICK_WALL).fence(ModBlocks.SILICITE_BRICK_FENCE).getFamily();

    public static final BlockFamily MONOCRYSTAL_BLOCK = familyBuilder(ModBlocks.MONOCRYSTAL_BLOCK).cut(ModBlocks.CUT_MONOCRYSTAL).getFamily();
    public static final BlockFamily CUT_MONOCRYSTAL = familyBuilder(ModBlocks.CUT_MONOCRYSTAL).slab(ModBlocks.CUT_MONOCRYSTAL_SLAB).stairs(ModBlocks.CUT_MONOCRYSTAL_STAIRS).getFamily();

    public static final BlockFamily RUBY_BLOCK = familyBuilder(ModBlocks.RUBY_BLOCK).cut(ModBlocks.CUT_RUBY).getFamily();
    public static final BlockFamily CUT_RUBY = familyBuilder(ModBlocks.CUT_RUBY).slab(ModBlocks.CUT_RUBY_SLAB).stairs(ModBlocks.CUT_RUBY_STAIRS).getFamily();

    public static final BlockFamily SAPPHIRE_BLOCK = familyBuilder(ModBlocks.SAPPHIRE_BLOCK).cut(ModBlocks.CUT_SAPPHIRE).getFamily();
    public static final BlockFamily CUT_SAPPHIRE = familyBuilder(ModBlocks.CUT_SAPPHIRE).slab(ModBlocks.CUT_SAPPHIRE_SLAB).stairs(ModBlocks.CUT_SAPPHIRE_STAIRS).getFamily();

}