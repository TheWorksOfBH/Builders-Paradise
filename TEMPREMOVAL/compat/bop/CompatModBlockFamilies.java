package github.theworksofbh.buildersparadise.compat.bop;

import biomesoplenty.api.block.BOPBlocks;
import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class CompatModBlockFamilies {
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

    public static final BlockFamily WHITE_SANDSTONE = familyBuilder(BOPBlocks.WHITE_SANDSTONE).fence(CompatModBlocks.WHITE_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily CUT_WHITE_SANDSTONE = familyBuilder(BOPBlocks.CUT_WHITE_SANDSTONE).stairs(CompatModBlocks.CUT_WHITE_SANDSTONE_STAIRS.get()).wall(CompatModBlocks.CUT_WHITE_SANDSTONE_WALL.get()).fence(CompatModBlocks.CUT_WHITE_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_WHITE_SANDSTONE = familyBuilder(BOPBlocks.SMOOTH_WHITE_SANDSTONE).wall(CompatModBlocks.SMOOTH_WHITE_SANDSTONE_WALL.get()).fence(CompatModBlocks.SMOOTH_WHITE_SANDSTONE_FENCE.get()).getFamily();

    public static final BlockFamily BLACK_SANDSTONE = familyBuilder(BOPBlocks.BLACK_SANDSTONE).fence(CompatModBlocks.BLACK_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily CUT_BLACK_SANDSTONE = familyBuilder(BOPBlocks.CUT_BLACK_SANDSTONE).stairs(CompatModBlocks.CUT_BLACK_SANDSTONE_STAIRS.get()).wall(CompatModBlocks.CUT_BLACK_SANDSTONE_WALL.get()).fence(CompatModBlocks.CUT_BLACK_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_BLACK_SANDSTONE = familyBuilder(BOPBlocks.SMOOTH_BLACK_SANDSTONE).wall(CompatModBlocks.SMOOTH_BLACK_SANDSTONE_WALL.get()).fence(CompatModBlocks.SMOOTH_BLACK_SANDSTONE_FENCE.get()).getFamily();

    public static final BlockFamily ORANGE_SANDSTONE = familyBuilder(BOPBlocks.ORANGE_SANDSTONE).fence(CompatModBlocks.ORANGE_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily CUT_ORANGE_SANDSTONE = familyBuilder(BOPBlocks.CUT_ORANGE_SANDSTONE).stairs(CompatModBlocks.CUT_ORANGE_SANDSTONE_STAIRS.get()).wall(CompatModBlocks.CUT_ORANGE_SANDSTONE_WALL.get()).fence(CompatModBlocks.CUT_ORANGE_SANDSTONE_FENCE.get()).getFamily();
    public static final BlockFamily SMOOTH_ORANGE_SANDSTONE = familyBuilder(BOPBlocks.SMOOTH_ORANGE_SANDSTONE).wall(CompatModBlocks.SMOOTH_ORANGE_SANDSTONE_WALL.get()).fence(CompatModBlocks.SMOOTH_ORANGE_SANDSTONE_FENCE.get()).getFamily();

    public static final BlockFamily BRIMSTONE = familyBuilder(BOPBlocks.BRIMSTONE).slab(CompatModBlocks.BRIMSTONE_SLAB.get()).stairs(CompatModBlocks.BRIMSTONE_STAIRS.get()).wall(CompatModBlocks.BRIMSTONE_WALL.get()).fence(CompatModBlocks.BRIMSTONE_FENCE.get()).getFamily();
    public static final BlockFamily BRIMSTONE_BRICKS = familyBuilder(BOPBlocks.BRIMSTONE_BRICKS).fence(CompatModBlocks.BRIMSTONE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily THERMAL_CALCITE = familyBuilder(BOPBlocks.THERMAL_CALCITE).slab(CompatModBlocks.THERMAL_CALCITE_SLAB.get()).stairs(CompatModBlocks.THERMAL_CALCITE_STAIRS.get()).wall(CompatModBlocks.THERMAL_CALCITE_WALL.get()).fence(CompatModBlocks.THERMAL_CALCITE_FENCE.get()).polished(CompatModBlocks.POLISHED_THERMAL_CALCITE.get()).getFamily();
    public static final BlockFamily POLISHED_THERMAL_CALCITE = familyBuilder(CompatModBlocks.POLISHED_THERMAL_CALCITE.get()).slab(CompatModBlocks.POLISHED_THERMAL_CALCITE_SLAB.get()).stairs(CompatModBlocks.POLISHED_THERMAL_CALCITE_STAIRS.get()).wall(CompatModBlocks.POLISHED_THERMAL_CALCITE_WALL.get()).fence(CompatModBlocks.POLISHED_THERMAL_CALCITE_FENCE.get()).polished(CompatModBlocks.THERMAL_CALCITE_BRICKS.get()).getFamily();
    public static final BlockFamily THERMAL_CALCITE_BRICKS = familyBuilder(CompatModBlocks.THERMAL_CALCITE_BRICKS.get()).slab(CompatModBlocks.THERMAL_CALCITE_BRICK_SLAB.get()).stairs(CompatModBlocks.THERMAL_CALCITE_BRICK_STAIRS.get()).wall(CompatModBlocks.THERMAL_CALCITE_BRICK_WALL.get()).fence(CompatModBlocks.THERMAL_CALCITE_BRICK_FENCE.get()).getFamily();

    public static final BlockFamily ROSE_QUARTZ_BLOCK = familyBuilder(BOPBlocks.ROSE_QUARTZ_BLOCK).cut(CompatModBlocks.CUT_ROSE_QUARTZ.get()).getFamily();
    public static final BlockFamily CUT_ROSE_QUARTZ = familyBuilder(CompatModBlocks.CUT_ROSE_QUARTZ.get()).slab(CompatModBlocks.CUT_ROSE_QUARTZ_SLAB.get()).stairs(CompatModBlocks.CUT_ROSE_QUARTZ_STAIRS.get()).getFamily();

    public static final BlockFamily DEAD_PLANKS = familyBuilder(BOPBlocks.DEAD_PLANKS).mosaic(CompatModBlocks.DEAD_MOSAIC.get()).getFamily();
    public static final BlockFamily EMPYREAL_PLANKS = familyBuilder(BOPBlocks.EMPYREAL_PLANKS).mosaic(CompatModBlocks.EMPYREAL_MOSAIC.get()).getFamily();
    public static final BlockFamily FIR_PLANKS = familyBuilder(BOPBlocks.FIR_PLANKS).mosaic(CompatModBlocks.FIR_MOSAIC.get()).getFamily();
    public static final BlockFamily HELLBARK_PLANKS = familyBuilder(BOPBlocks.HELLBARK_PLANKS).mosaic(CompatModBlocks.HELLBARK_MOSAIC.get()).getFamily();
    public static final BlockFamily JACARANDA_PLANKS = familyBuilder(BOPBlocks.JACARANDA_PLANKS).mosaic(CompatModBlocks.JACARANDA_MOSAIC.get()).getFamily();
    public static final BlockFamily MAGIC_PLANKS = familyBuilder(BOPBlocks.MAGIC_PLANKS).mosaic(CompatModBlocks.MAGIC_MOSAIC.get()).getFamily();
    public static final BlockFamily MAHOGANY_PLANKS = familyBuilder(BOPBlocks.MAHOGANY_PLANKS).mosaic(CompatModBlocks.MAHOGANY_MOSAIC.get()).getFamily();
    public static final BlockFamily MAPLE_PLANKS = familyBuilder(BOPBlocks.MAPLE_PLANKS).mosaic(CompatModBlocks.MAPLE_MOSAIC.get()).getFamily();
    public static final BlockFamily PALM_PLANKS = familyBuilder(BOPBlocks.PALM_PLANKS).mosaic(CompatModBlocks.PALM_MOSAIC.get()).getFamily();
    public static final BlockFamily PINE_PLANKS = familyBuilder(BOPBlocks.PINE_PLANKS).mosaic(CompatModBlocks.PINE_MOSAIC.get()).getFamily();
    public static final BlockFamily REDWOOD_PLANKS = familyBuilder(BOPBlocks.REDWOOD_PLANKS).mosaic(CompatModBlocks.REDWOOD_MOSAIC.get()).getFamily();
    public static final BlockFamily UMBRAN_PLANKS = familyBuilder(BOPBlocks.UMBRAN_PLANKS).mosaic(CompatModBlocks.UMBRAN_MOSAIC.get()).getFamily();
    public static final BlockFamily WILLOW_PLANKS = familyBuilder(BOPBlocks.WILLOW_PLANKS).mosaic(CompatModBlocks.WILLOW_MOSAIC.get()).getFamily();
    public static final BlockFamily ORIGIN_OAK_PLANKS = familyBuilder(BOPBlocks.ORIGIN_OAK_PLANKS).mosaic(CompatModBlocks.ORIGIN_OAK_MOSAIC.get()).getFamily();

    public static final BlockFamily DEAD_MOSAIC = familyBuilder(CompatModBlocks.DEAD_MOSAIC.get()).slab(CompatModBlocks.DEAD_MOSAIC_SLAB.get()).stairs(CompatModBlocks.DEAD_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily EMPYREAL_MOSAIC = familyBuilder(CompatModBlocks.EMPYREAL_MOSAIC.get()).slab(CompatModBlocks.EMPYREAL_MOSAIC_SLAB.get()).stairs(CompatModBlocks.EMPYREAL_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily FIR_MOSAIC = familyBuilder(CompatModBlocks.FIR_MOSAIC.get()).slab(CompatModBlocks.FIR_MOSAIC_SLAB.get()).stairs(CompatModBlocks.FIR_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily HELLBARK_MOSAIC = familyBuilder(CompatModBlocks.HELLBARK_MOSAIC.get()).slab(CompatModBlocks.HELLBARK_MOSAIC_SLAB.get()).stairs(CompatModBlocks.HELLBARK_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily JACARANDA_MOSAIC = familyBuilder(CompatModBlocks.JACARANDA_MOSAIC.get()).slab(CompatModBlocks.JACARANDA_MOSAIC_SLAB.get()).stairs(CompatModBlocks.JACARANDA_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily MAGIC_MOSAIC = familyBuilder(CompatModBlocks.MAGIC_MOSAIC.get()).slab(CompatModBlocks.MAGIC_MOSAIC_SLAB.get()).stairs(CompatModBlocks.MAGIC_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily MAHOGANY_MOSAIC = familyBuilder(CompatModBlocks.MAHOGANY_MOSAIC.get()).slab(CompatModBlocks.MAHOGANY_MOSAIC_SLAB.get()).stairs(CompatModBlocks.MAHOGANY_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily MAPLE_MOSAIC = familyBuilder(CompatModBlocks.MAPLE_MOSAIC.get()).slab(CompatModBlocks.MAPLE_MOSAIC_SLAB.get()).stairs(CompatModBlocks.MAPLE_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily PALM_MOSAIC = familyBuilder(CompatModBlocks.PALM_MOSAIC.get()).slab(CompatModBlocks.PALM_MOSAIC_SLAB.get()).stairs(CompatModBlocks.PALM_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily PINE_MOSAIC = familyBuilder(CompatModBlocks.PINE_MOSAIC.get()).slab(CompatModBlocks.PINE_MOSAIC_SLAB.get()).stairs(CompatModBlocks.PINE_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily REDWOOD_MOSAIC = familyBuilder(CompatModBlocks.REDWOOD_MOSAIC.get()).slab(CompatModBlocks.REDWOOD_MOSAIC_SLAB.get()).stairs(CompatModBlocks.REDWOOD_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily UMBRAN_MOSAIC = familyBuilder(CompatModBlocks.UMBRAN_MOSAIC.get()).slab(CompatModBlocks.UMBRAN_MOSAIC_SLAB.get()).stairs(CompatModBlocks.UMBRAN_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily WILLOW_MOSAIC = familyBuilder(CompatModBlocks.WILLOW_MOSAIC.get()).slab(CompatModBlocks.WILLOW_MOSAIC_SLAB.get()).stairs(CompatModBlocks.WILLOW_MOSAIC_STAIRS.get()).getFamily();
    public static final BlockFamily ORIGIN_OAK_MOSAIC = familyBuilder(CompatModBlocks.ORIGIN_OAK_MOSAIC.get()).slab(CompatModBlocks.ORIGIN_OAK_MOSAIC_SLAB.get()).stairs(CompatModBlocks.ORIGIN_OAK_MOSAIC_STAIRS.get()).getFamily();

}
