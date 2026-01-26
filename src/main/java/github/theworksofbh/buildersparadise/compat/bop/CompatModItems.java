package github.theworksofbh.buildersparadise.compat.bop;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CompatModItems {
    public static final DeferredRegister.Items BOP_ITEMS = DeferredRegister.createItems(BuildersParadise.MODID);

    public static final DeferredItem<BlockItem> CUT_WHITE_SANDSTONE_STAIRS = registerBlockItem("cut_white_sandstone_stairs", () -> CompatModBlocks.CUT_WHITE_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_WHITE_SANDSTONE_WALL = registerBlockItem("cut_white_sandstone_wall", () -> CompatModBlocks.CUT_WHITE_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_WHITE_SANDSTONE_WALL = registerBlockItem("smooth_white_sandstone_wall", () -> CompatModBlocks.SMOOTH_WHITE_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_BLACK_SANDSTONE_STAIRS = registerBlockItem("cut_black_sandstone_stairs", () -> CompatModBlocks.CUT_BLACK_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_BLACK_SANDSTONE_WALL = registerBlockItem("cut_black_sandstone_wall", () -> CompatModBlocks.CUT_BLACK_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_BLACK_SANDSTONE_WALL = registerBlockItem("smooth_black_sandstone_wall", () -> CompatModBlocks.SMOOTH_BLACK_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_ORANGE_SANDSTONE_STAIRS = registerBlockItem("cut_orange_sandstone_stairs", () -> CompatModBlocks.CUT_ORANGE_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_ORANGE_SANDSTONE_WALL = registerBlockItem("cut_orange_sandstone_wall", () -> CompatModBlocks.CUT_ORANGE_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_ORANGE_SANDSTONE_WALL = registerBlockItem("smooth_orange_sandstone_wall", () -> CompatModBlocks.SMOOTH_ORANGE_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> BRIMSTONE_SLAB = registerBlockItem("brimstone_slab", () -> CompatModBlocks.BRIMSTONE_SLAB.get());
    public static final DeferredItem<BlockItem> BRIMSTONE_STAIRS = registerBlockItem("brimstone_stairs", () -> CompatModBlocks.BRIMSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> BRIMSTONE_WALL = registerBlockItem("brimstone_wall", () -> CompatModBlocks.BRIMSTONE_WALL.get());

    public static final DeferredItem<BlockItem> THERMAL_CALCITE_SLAB = registerBlockItem("thermal_calcite_slab", () -> CompatModBlocks.THERMAL_CALCITE_SLAB.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_STAIRS = registerBlockItem("thermal_calcite_stairs", () -> CompatModBlocks.THERMAL_CALCITE_STAIRS.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_WALL = registerBlockItem("thermal_calcite_wall", () -> CompatModBlocks.THERMAL_CALCITE_WALL.get());

    public static final DeferredItem<BlockItem> POLISHED_THERMAL_CALCITE = registerBlockItem("polished_thermal_calcite", () -> CompatModBlocks.POLISHED_THERMAL_CALCITE.get());
    public static final DeferredItem<BlockItem> POLISHED_THERMAL_CALCITE_SLAB = registerBlockItem("polished_thermal_calcite_slab", () -> CompatModBlocks.POLISHED_THERMAL_CALCITE_SLAB.get());
    public static final DeferredItem<BlockItem> POLISHED_THERMAL_CALCITE_STAIRS = registerBlockItem("polished_thermal_calcite_stairs", () -> CompatModBlocks.POLISHED_THERMAL_CALCITE_STAIRS.get());
    public static final DeferredItem<BlockItem> POLISHED_THERMAL_CALCITE_WALL = registerBlockItem("polished_thermal_calcite_wall", () -> CompatModBlocks.POLISHED_THERMAL_CALCITE_WALL.get());

    public static final DeferredItem<BlockItem> THERMAL_CALCITE_BRICKS = registerBlockItem("thermal_calcite_bricks", () -> CompatModBlocks.THERMAL_CALCITE_BRICKS.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_BRICK_SLAB = registerBlockItem("thermal_calcite_brick_slab", () -> CompatModBlocks.THERMAL_CALCITE_BRICK_SLAB.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_BRICK_STAIRS = registerBlockItem("thermal_calcite_brick_stairs", () -> CompatModBlocks.THERMAL_CALCITE_BRICK_STAIRS.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_BRICK_WALL = registerBlockItem("thermal_calcite_brick_wall", () -> CompatModBlocks.THERMAL_CALCITE_BRICK_WALL.get());

    public static final DeferredItem<BlockItem> CUT_ROSE_QUARTZ = registerBlockItem("cut_rose_quartz", () -> CompatModBlocks.CUT_ROSE_QUARTZ.get());
    public static final DeferredItem<BlockItem> CUT_ROSE_QUARTZ_SLAB = registerBlockItem("cut_rose_quartz_slab", () -> CompatModBlocks.CUT_ROSE_QUARTZ_SLAB.get());
    public static final DeferredItem<BlockItem> CUT_ROSE_QUARTZ_STAIRS = registerBlockItem("cut_rose_quartz_stairs", () -> CompatModBlocks.CUT_ROSE_QUARTZ_STAIRS.get());

    public static final DeferredItem<BlockItem> DEAD_MOSAIC = registerBlockItem("dead_mosaic", () -> CompatModBlocks.DEAD_MOSAIC.get());
    public static final DeferredItem<BlockItem> DEAD_MOSAIC_SLAB = registerBlockItem("dead_mosaic_slab", () -> CompatModBlocks.DEAD_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> DEAD_MOSAIC_STAIRS = registerBlockItem("dead_mosaic_stairs", () -> CompatModBlocks.DEAD_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> DEAD_CRAFTING_TABLE = registerBlockItem("dead_crafting_table", () -> CompatModBlocks.DEAD_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> DEAD_CARTOGRAPHY_TABLE = registerBlockItem("dead_cartography_table", () -> CompatModBlocks.DEAD_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> DEAD_FLETCHING_TABLE = registerBlockItem("dead_fletching_table", () -> CompatModBlocks.DEAD_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> DEAD_BEEHIVE = registerBlockItem("dead_beehive", () -> CompatModBlocks.DEAD_BEEHIVE.get());
    public static final DeferredItem<BlockItem> DEAD_BARREL = registerBlockItem("dead_barrel", () -> CompatModBlocks.DEAD_BARREL.get());
    public static final DeferredItem<BlockItem> DEAD_LECTERN = registerBlockItem("dead_lectern", () -> CompatModBlocks.DEAD_LECTERN.get());
    public static final DeferredItem<BlockItem> DEAD_SMITHING_TABLE = registerBlockItem("dead_smithing_table", () -> CompatModBlocks.DEAD_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> DEAD_BOOKSHELF = registerBlockItem("dead_bookshelf", () -> CompatModBlocks.DEAD_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> DEAD_CAMPFIRE = registerBlockItem("dead_campfire", () -> CompatModBlocks.DEAD_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> DEAD_SOUL_CAMPFIRE = registerBlockItem("dead_soul_campfire", () -> CompatModBlocks.DEAD_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> DEAD_GRINDSTONE = registerBlockItem("dead_grindstone", () -> CompatModBlocks.DEAD_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> DEAD_CHISELED_BOOKSHELF = registerBlockItem("dead_chiseled_bookshelf", () -> CompatModBlocks.DEAD_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> DEAD_CRAFTER = registerBlockItem("dead_crafter", () -> CompatModBlocks.DEAD_CRAFTER.get());
    public static final DeferredItem<BlockItem> DEAD_STONE_SMOKER = registerBlockItem("dead_stone_smoker", () -> CompatModBlocks.DEAD_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> DEAD_BLACKSTONE_SMOKER = registerBlockItem("dead_blackstone_smoker", () -> CompatModBlocks.DEAD_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> DEAD_DEEPSLATE_SMOKER = registerBlockItem("dead_deepslate_smoker", () -> CompatModBlocks.DEAD_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> DEAD_LOOM = registerBlockItem("dead_loom", () -> CompatModBlocks.DEAD_LOOM.get());
    public static final DeferredItem<BlockItem> DEAD_CHEST = registerBlockItem("dead_chest", () -> CompatModBlocks.DEAD_CHEST.get());
    public static final DeferredItem<BlockItem> DEAD_TRAPPED_CHEST = registerBlockItem("dead_trapped_chest", () -> CompatModBlocks.DEAD_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> DEAD_CHEST_MINECART = registerMinecartItem("dead_chest_minecart", () -> CompatModEntities.DEAD_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> EMPYREAL_MOSAIC = registerBlockItem("empyreal_mosaic", () -> CompatModBlocks.EMPYREAL_MOSAIC.get());
    public static final DeferredItem<BlockItem> EMPYREAL_MOSAIC_SLAB = registerBlockItem("empyreal_mosaic_slab", () -> CompatModBlocks.EMPYREAL_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> EMPYREAL_MOSAIC_STAIRS = registerBlockItem("empyreal_mosaic_stairs", () -> CompatModBlocks.EMPYREAL_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CRAFTING_TABLE = registerBlockItem("empyreal_crafting_table", () -> CompatModBlocks.EMPYREAL_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CARTOGRAPHY_TABLE = registerBlockItem("empyreal_cartography_table", () -> CompatModBlocks.EMPYREAL_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_FLETCHING_TABLE = registerBlockItem("empyreal_fletching_table", () -> CompatModBlocks.EMPYREAL_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_BEEHIVE = registerBlockItem("empyreal_beehive", () -> CompatModBlocks.EMPYREAL_BEEHIVE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_BARREL = registerBlockItem("empyreal_barrel", () -> CompatModBlocks.EMPYREAL_BARREL.get());
    public static final DeferredItem<BlockItem> EMPYREAL_LECTERN = registerBlockItem("empyreal_lectern", () -> CompatModBlocks.EMPYREAL_LECTERN.get());
    public static final DeferredItem<BlockItem> EMPYREAL_SMITHING_TABLE = registerBlockItem("empyreal_smithing_table", () -> CompatModBlocks.EMPYREAL_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_BOOKSHELF = registerBlockItem("empyreal_bookshelf", () -> CompatModBlocks.EMPYREAL_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CAMPFIRE = registerBlockItem("empyreal_campfire", () -> CompatModBlocks.EMPYREAL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_SOUL_CAMPFIRE = registerBlockItem("empyreal_soul_campfire", () -> CompatModBlocks.EMPYREAL_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_GRINDSTONE = registerBlockItem("empyreal_grindstone", () -> CompatModBlocks.EMPYREAL_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CHISELED_BOOKSHELF = registerBlockItem("empyreal_chiseled_bookshelf", () -> CompatModBlocks.EMPYREAL_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CRAFTER = registerBlockItem("empyreal_crafter", () -> CompatModBlocks.EMPYREAL_CRAFTER.get());
    public static final DeferredItem<BlockItem> EMPYREAL_STONE_SMOKER = registerBlockItem("empyreal_stone_smoker", () -> CompatModBlocks.EMPYREAL_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> EMPYREAL_BLACKSTONE_SMOKER = registerBlockItem("empyreal_blackstone_smoker", () -> CompatModBlocks.EMPYREAL_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> EMPYREAL_DEEPSLATE_SMOKER = registerBlockItem("empyreal_deepslate_smoker", () -> CompatModBlocks.EMPYREAL_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> EMPYREAL_LOOM = registerBlockItem("empyreal_loom", () -> CompatModBlocks.EMPYREAL_LOOM.get());
    public static final DeferredItem<BlockItem> EMPYREAL_CHEST = registerBlockItem("empyreal_chest", () -> CompatModBlocks.EMPYREAL_CHEST.get());
    public static final DeferredItem<BlockItem> EMPYREAL_TRAPPED_CHEST = registerBlockItem("empyreal_trapped_chest", () -> CompatModBlocks.EMPYREAL_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> EMPYREAL_CHEST_MINECART = registerMinecartItem("empyreal_chest_minecart", () -> CompatModEntities.EMPYREAL_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> FIR_MOSAIC = registerBlockItem("fir_mosaic", () -> CompatModBlocks.FIR_MOSAIC.get());
    public static final DeferredItem<BlockItem> FIR_MOSAIC_SLAB = registerBlockItem("fir_mosaic_slab", () -> CompatModBlocks.FIR_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> FIR_MOSAIC_STAIRS = registerBlockItem("fir_mosaic_stairs", () -> CompatModBlocks.FIR_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> FIR_CRAFTING_TABLE = registerBlockItem("fir_crafting_table", () -> CompatModBlocks.FIR_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> FIR_CARTOGRAPHY_TABLE = registerBlockItem("fir_cartography_table", () -> CompatModBlocks.FIR_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> FIR_FLETCHING_TABLE = registerBlockItem("fir_fletching_table", () -> CompatModBlocks.FIR_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> FIR_BEEHIVE = registerBlockItem("fir_beehive", () -> CompatModBlocks.FIR_BEEHIVE.get());
    public static final DeferredItem<BlockItem> FIR_BARREL = registerBlockItem("fir_barrel", () -> CompatModBlocks.FIR_BARREL.get());
    public static final DeferredItem<BlockItem> FIR_LECTERN = registerBlockItem("fir_lectern", () -> CompatModBlocks.FIR_LECTERN.get());
    public static final DeferredItem<BlockItem> FIR_SMITHING_TABLE = registerBlockItem("fir_smithing_table", () -> CompatModBlocks.FIR_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> FIR_BOOKSHELF = registerBlockItem("fir_bookshelf", () -> CompatModBlocks.FIR_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> FIR_CAMPFIRE = registerBlockItem("fir_campfire", () -> CompatModBlocks.FIR_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> FIR_SOUL_CAMPFIRE = registerBlockItem("fir_soul_campfire", () -> CompatModBlocks.FIR_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> FIR_GRINDSTONE = registerBlockItem("fir_grindstone", () -> CompatModBlocks.FIR_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> FIR_CHISELED_BOOKSHELF = registerBlockItem("fir_chiseled_bookshelf", () -> CompatModBlocks.FIR_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> FIR_CRAFTER = registerBlockItem("fir_crafter", () -> CompatModBlocks.FIR_CRAFTER.get());
    public static final DeferredItem<BlockItem> FIR_STONE_SMOKER = registerBlockItem("fir_stone_smoker", () -> CompatModBlocks.FIR_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> FIR_BLACKSTONE_SMOKER = registerBlockItem("fir_blackstone_smoker", () -> CompatModBlocks.FIR_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> FIR_DEEPSLATE_SMOKER = registerBlockItem("fir_deepslate_smoker", () -> CompatModBlocks.FIR_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> FIR_LOOM = registerBlockItem("fir_loom", () -> CompatModBlocks.FIR_LOOM.get());
    public static final DeferredItem<BlockItem> FIR_CHEST = registerBlockItem("fir_chest", () -> CompatModBlocks.FIR_CHEST.get());
    public static final DeferredItem<BlockItem> FIR_TRAPPED_CHEST = registerBlockItem("fir_trapped_chest", () -> CompatModBlocks.FIR_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> FIR_CHEST_MINECART = registerMinecartItem("fir_chest_minecart", () -> CompatModEntities.FIR_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> HELLBARK_MOSAIC = registerBlockItem("hellbark_mosaic", () -> CompatModBlocks.HELLBARK_MOSAIC.get());
    public static final DeferredItem<BlockItem> HELLBARK_MOSAIC_SLAB = registerBlockItem("hellbark_mosaic_slab", () -> CompatModBlocks.HELLBARK_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> HELLBARK_MOSAIC_STAIRS = registerBlockItem("hellbark_mosaic_stairs", () -> CompatModBlocks.HELLBARK_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> HELLBARK_CRAFTING_TABLE = registerBlockItem("hellbark_crafting_table", () -> CompatModBlocks.HELLBARK_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> HELLBARK_CARTOGRAPHY_TABLE = registerBlockItem("hellbark_cartography_table", () -> CompatModBlocks.HELLBARK_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> HELLBARK_FLETCHING_TABLE = registerBlockItem("hellbark_fletching_table", () -> CompatModBlocks.HELLBARK_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> HELLBARK_BEEHIVE = registerBlockItem("hellbark_beehive", () -> CompatModBlocks.HELLBARK_BEEHIVE.get());
    public static final DeferredItem<BlockItem> HELLBARK_BARREL = registerBlockItem("hellbark_barrel", () -> CompatModBlocks.HELLBARK_BARREL.get());
    public static final DeferredItem<BlockItem> HELLBARK_LECTERN = registerBlockItem("hellbark_lectern", () -> CompatModBlocks.HELLBARK_LECTERN.get());
    public static final DeferredItem<BlockItem> HELLBARK_SMITHING_TABLE = registerBlockItem("hellbark_smithing_table", () -> CompatModBlocks.HELLBARK_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> HELLBARK_BOOKSHELF = registerBlockItem("hellbark_bookshelf", () -> CompatModBlocks.HELLBARK_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> HELLBARK_CAMPFIRE = registerBlockItem("hellbark_campfire", () -> CompatModBlocks.HELLBARK_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> HELLBARK_SOUL_CAMPFIRE = registerBlockItem("hellbark_soul_campfire", () -> CompatModBlocks.HELLBARK_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> HELLBARK_GRINDSTONE = registerBlockItem("hellbark_grindstone", () -> CompatModBlocks.HELLBARK_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> HELLBARK_CHISELED_BOOKSHELF = registerBlockItem("hellbark_chiseled_bookshelf", () -> CompatModBlocks.HELLBARK_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> HELLBARK_CRAFTER = registerBlockItem("hellbark_crafter", () -> CompatModBlocks.HELLBARK_CRAFTER.get());
    public static final DeferredItem<BlockItem> HELLBARK_STONE_SMOKER = registerBlockItem("hellbark_stone_smoker", () -> CompatModBlocks.HELLBARK_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> HELLBARK_BLACKSTONE_SMOKER = registerBlockItem("hellbark_blackstone_smoker", () -> CompatModBlocks.HELLBARK_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> HELLBARK_DEEPSLATE_SMOKER = registerBlockItem("hellbark_deepslate_smoker", () -> CompatModBlocks.HELLBARK_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> HELLBARK_LOOM = registerBlockItem("hellbark_loom", () -> CompatModBlocks.HELLBARK_LOOM.get());
    public static final DeferredItem<BlockItem> HELLBARK_CHEST = registerBlockItem("hellbark_chest", () -> CompatModBlocks.HELLBARK_CHEST.get());
    public static final DeferredItem<BlockItem> HELLBARK_TRAPPED_CHEST = registerBlockItem("hellbark_trapped_chest", () -> CompatModBlocks.HELLBARK_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> HELLBARK_CHEST_MINECART = registerMinecartItem("hellbark_chest_minecart", () -> CompatModEntities.HELLBARK_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> JACARANDA_MOSAIC = registerBlockItem("jacaranda_mosaic", () -> CompatModBlocks.JACARANDA_MOSAIC.get());
    public static final DeferredItem<BlockItem> JACARANDA_MOSAIC_SLAB = registerBlockItem("jacaranda_mosaic_slab", () -> CompatModBlocks.JACARANDA_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> JACARANDA_MOSAIC_STAIRS = registerBlockItem("jacaranda_mosaic_stairs", () -> CompatModBlocks.JACARANDA_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> JACARANDA_CRAFTING_TABLE = registerBlockItem("jacaranda_crafting_table", () -> CompatModBlocks.JACARANDA_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> JACARANDA_CARTOGRAPHY_TABLE = registerBlockItem("jacaranda_cartography_table", () -> CompatModBlocks.JACARANDA_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> JACARANDA_FLETCHING_TABLE = registerBlockItem("jacaranda_fletching_table", () -> CompatModBlocks.JACARANDA_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> JACARANDA_BEEHIVE = registerBlockItem("jacaranda_beehive", () -> CompatModBlocks.JACARANDA_BEEHIVE.get());
    public static final DeferredItem<BlockItem> JACARANDA_BARREL = registerBlockItem("jacaranda_barrel", () -> CompatModBlocks.JACARANDA_BARREL.get());
    public static final DeferredItem<BlockItem> JACARANDA_LECTERN = registerBlockItem("jacaranda_lectern", () -> CompatModBlocks.JACARANDA_LECTERN.get());
    public static final DeferredItem<BlockItem> JACARANDA_SMITHING_TABLE = registerBlockItem("jacaranda_smithing_table", () -> CompatModBlocks.JACARANDA_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> JACARANDA_BOOKSHELF = registerBlockItem("jacaranda_bookshelf", () -> CompatModBlocks.JACARANDA_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> JACARANDA_CAMPFIRE = registerBlockItem("jacaranda_campfire", () -> CompatModBlocks.JACARANDA_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> JACARANDA_SOUL_CAMPFIRE = registerBlockItem("jacaranda_soul_campfire", () -> CompatModBlocks.JACARANDA_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> JACARANDA_GRINDSTONE = registerBlockItem("jacaranda_grindstone", () -> CompatModBlocks.JACARANDA_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> JACARANDA_CHISELED_BOOKSHELF = registerBlockItem("jacaranda_chiseled_bookshelf", () -> CompatModBlocks.JACARANDA_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> JACARANDA_CRAFTER = registerBlockItem("jacaranda_crafter", () -> CompatModBlocks.JACARANDA_CRAFTER.get());
    public static final DeferredItem<BlockItem> JACARANDA_STONE_SMOKER = registerBlockItem("jacaranda_stone_smoker", () -> CompatModBlocks.JACARANDA_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> JACARANDA_BLACKSTONE_SMOKER = registerBlockItem("jacaranda_blackstone_smoker", () -> CompatModBlocks.JACARANDA_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> JACARANDA_DEEPSLATE_SMOKER = registerBlockItem("jacaranda_deepslate_smoker", () -> CompatModBlocks.JACARANDA_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> JACARANDA_LOOM = registerBlockItem("jacaranda_loom", () -> CompatModBlocks.JACARANDA_LOOM.get());
    public static final DeferredItem<BlockItem> JACARANDA_CHEST = registerBlockItem("jacaranda_chest", () -> CompatModBlocks.JACARANDA_CHEST.get());
    public static final DeferredItem<BlockItem> JACARANDA_TRAPPED_CHEST = registerBlockItem("jacaranda_trapped_chest", () -> CompatModBlocks.JACARANDA_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> JACARANDA_CHEST_MINECART = registerMinecartItem("jacaranda_chest_minecart", () -> CompatModEntities.JACARANDA_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> MAGIC_MOSAIC = registerBlockItem("magic_mosaic", () -> CompatModBlocks.MAGIC_MOSAIC.get());
    public static final DeferredItem<BlockItem> MAGIC_MOSAIC_SLAB = registerBlockItem("magic_mosaic_slab", () -> CompatModBlocks.MAGIC_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> MAGIC_MOSAIC_STAIRS = registerBlockItem("magic_mosaic_stairs", () -> CompatModBlocks.MAGIC_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> MAGIC_CRAFTING_TABLE = registerBlockItem("magic_crafting_table", () -> CompatModBlocks.MAGIC_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> MAGIC_CARTOGRAPHY_TABLE = registerBlockItem("magic_cartography_table", () -> CompatModBlocks.MAGIC_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> MAGIC_FLETCHING_TABLE = registerBlockItem("magic_fletching_table", () -> CompatModBlocks.MAGIC_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAGIC_BEEHIVE = registerBlockItem("magic_beehive", () -> CompatModBlocks.MAGIC_BEEHIVE.get());
    public static final DeferredItem<BlockItem> MAGIC_BARREL = registerBlockItem("magic_barrel", () -> CompatModBlocks.MAGIC_BARREL.get());
    public static final DeferredItem<BlockItem> MAGIC_LECTERN = registerBlockItem("magic_lectern", () -> CompatModBlocks.MAGIC_LECTERN.get());
    public static final DeferredItem<BlockItem> MAGIC_SMITHING_TABLE = registerBlockItem("magic_smithing_table", () -> CompatModBlocks.MAGIC_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAGIC_BOOKSHELF = registerBlockItem("magic_bookshelf", () -> CompatModBlocks.MAGIC_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAGIC_CAMPFIRE = registerBlockItem("magic_campfire", () -> CompatModBlocks.MAGIC_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAGIC_SOUL_CAMPFIRE = registerBlockItem("magic_soul_campfire", () -> CompatModBlocks.MAGIC_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAGIC_GRINDSTONE = registerBlockItem("magic_grindstone", () -> CompatModBlocks.MAGIC_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> MAGIC_CHISELED_BOOKSHELF = registerBlockItem("magic_chiseled_bookshelf", () -> CompatModBlocks.MAGIC_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAGIC_CRAFTER = registerBlockItem("magic_crafter", () -> CompatModBlocks.MAGIC_CRAFTER.get());
    public static final DeferredItem<BlockItem> MAGIC_STONE_SMOKER = registerBlockItem("magic_stone_smoker", () -> CompatModBlocks.MAGIC_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAGIC_BLACKSTONE_SMOKER = registerBlockItem("magic_blackstone_smoker", () -> CompatModBlocks.MAGIC_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAGIC_DEEPSLATE_SMOKER = registerBlockItem("magic_deepslate_smoker", () -> CompatModBlocks.MAGIC_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAGIC_LOOM = registerBlockItem("magic_loom", () -> CompatModBlocks.MAGIC_LOOM.get());
    public static final DeferredItem<BlockItem> MAGIC_CHEST = registerBlockItem("magic_chest", () -> CompatModBlocks.MAGIC_CHEST.get());
    public static final DeferredItem<BlockItem> MAGIC_TRAPPED_CHEST = registerBlockItem("magic_trapped_chest", () -> CompatModBlocks.MAGIC_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> MAGIC_CHEST_MINECART = registerMinecartItem("magic_chest_minecart", () -> CompatModEntities.MAGIC_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> MAHOGANY_MOSAIC = registerBlockItem("mahogany_mosaic", () -> CompatModBlocks.MAHOGANY_MOSAIC.get());
    public static final DeferredItem<BlockItem> MAHOGANY_MOSAIC_SLAB = registerBlockItem("mahogany_mosaic_slab", () -> CompatModBlocks.MAHOGANY_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> MAHOGANY_MOSAIC_STAIRS = registerBlockItem("mahogany_mosaic_stairs", () -> CompatModBlocks.MAHOGANY_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CRAFTING_TABLE = registerBlockItem("mahogany_crafting_table", () -> CompatModBlocks.MAHOGANY_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CARTOGRAPHY_TABLE = registerBlockItem("mahogany_cartography_table", () -> CompatModBlocks.MAHOGANY_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_FLETCHING_TABLE = registerBlockItem("mahogany_fletching_table", () -> CompatModBlocks.MAHOGANY_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_BEEHIVE = registerBlockItem("mahogany_beehive", () -> CompatModBlocks.MAHOGANY_BEEHIVE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_BARREL = registerBlockItem("mahogany_barrel", () -> CompatModBlocks.MAHOGANY_BARREL.get());
    public static final DeferredItem<BlockItem> MAHOGANY_LECTERN = registerBlockItem("mahogany_lectern", () -> CompatModBlocks.MAHOGANY_LECTERN.get());
    public static final DeferredItem<BlockItem> MAHOGANY_SMITHING_TABLE = registerBlockItem("mahogany_smithing_table", () -> CompatModBlocks.MAHOGANY_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_BOOKSHELF = registerBlockItem("mahogany_bookshelf", () -> CompatModBlocks.MAHOGANY_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CAMPFIRE = registerBlockItem("mahogany_campfire", () -> CompatModBlocks.MAHOGANY_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_SOUL_CAMPFIRE = registerBlockItem("mahogany_soul_campfire", () -> CompatModBlocks.MAHOGANY_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_GRINDSTONE = registerBlockItem("mahogany_grindstone", () -> CompatModBlocks.MAHOGANY_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CHISELED_BOOKSHELF = registerBlockItem("mahogany_chiseled_bookshelf", () -> CompatModBlocks.MAHOGANY_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CRAFTER = registerBlockItem("mahogany_crafter", () -> CompatModBlocks.MAHOGANY_CRAFTER.get());
    public static final DeferredItem<BlockItem> MAHOGANY_STONE_SMOKER = registerBlockItem("mahogany_stone_smoker", () -> CompatModBlocks.MAHOGANY_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAHOGANY_BLACKSTONE_SMOKER = registerBlockItem("mahogany_blackstone_smoker", () -> CompatModBlocks.MAHOGANY_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAHOGANY_DEEPSLATE_SMOKER = registerBlockItem("mahogany_deepslate_smoker", () -> CompatModBlocks.MAHOGANY_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAHOGANY_LOOM = registerBlockItem("mahogany_loom", () -> CompatModBlocks.MAHOGANY_LOOM.get());
    public static final DeferredItem<BlockItem> MAHOGANY_CHEST = registerBlockItem("mahogany_chest", () -> CompatModBlocks.MAHOGANY_CHEST.get());
    public static final DeferredItem<BlockItem> MAHOGANY_TRAPPED_CHEST = registerBlockItem("mahogany_trapped_chest", () -> CompatModBlocks.MAHOGANY_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> MAHOGANY_CHEST_MINECART = registerMinecartItem("mahogany_chest_minecart", () -> CompatModEntities.MAHOGANY_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> MAPLE_MOSAIC = registerBlockItem("maple_mosaic", () -> CompatModBlocks.MAPLE_MOSAIC.get());
    public static final DeferredItem<BlockItem> MAPLE_MOSAIC_SLAB = registerBlockItem("maple_mosaic_slab", () -> CompatModBlocks.MAPLE_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> MAPLE_MOSAIC_STAIRS = registerBlockItem("maple_mosaic_stairs", () -> CompatModBlocks.MAPLE_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> MAPLE_CRAFTING_TABLE = registerBlockItem("maple_crafting_table", () -> CompatModBlocks.MAPLE_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> MAPLE_CARTOGRAPHY_TABLE = registerBlockItem("maple_cartography_table", () -> CompatModBlocks.MAPLE_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> MAPLE_FLETCHING_TABLE = registerBlockItem("maple_fletching_table", () -> CompatModBlocks.MAPLE_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAPLE_BEEHIVE = registerBlockItem("maple_beehive", () -> CompatModBlocks.MAPLE_BEEHIVE.get());
    public static final DeferredItem<BlockItem> MAPLE_BARREL = registerBlockItem("maple_barrel", () -> CompatModBlocks.MAPLE_BARREL.get());
    public static final DeferredItem<BlockItem> MAPLE_LECTERN = registerBlockItem("maple_lectern", () -> CompatModBlocks.MAPLE_LECTERN.get());
    public static final DeferredItem<BlockItem> MAPLE_SMITHING_TABLE = registerBlockItem("maple_smithing_table", () -> CompatModBlocks.MAPLE_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> MAPLE_BOOKSHELF = registerBlockItem("maple_bookshelf", () -> CompatModBlocks.MAPLE_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAPLE_CAMPFIRE = registerBlockItem("maple_campfire", () -> CompatModBlocks.MAPLE_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAPLE_SOUL_CAMPFIRE = registerBlockItem("maple_soul_campfire", () -> CompatModBlocks.MAPLE_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> MAPLE_GRINDSTONE = registerBlockItem("maple_grindstone", () -> CompatModBlocks.MAPLE_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> MAPLE_CHISELED_BOOKSHELF = registerBlockItem("maple_chiseled_bookshelf", () -> CompatModBlocks.MAPLE_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> MAPLE_CRAFTER = registerBlockItem("maple_crafter", () -> CompatModBlocks.MAPLE_CRAFTER.get());
    public static final DeferredItem<BlockItem> MAPLE_STONE_SMOKER = registerBlockItem("maple_stone_smoker", () -> CompatModBlocks.MAPLE_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAPLE_BLACKSTONE_SMOKER = registerBlockItem("maple_blackstone_smoker", () -> CompatModBlocks.MAPLE_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAPLE_DEEPSLATE_SMOKER = registerBlockItem("maple_deepslate_smoker", () -> CompatModBlocks.MAPLE_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> MAPLE_LOOM = registerBlockItem("maple_loom", () -> CompatModBlocks.MAPLE_LOOM.get());
    public static final DeferredItem<BlockItem> MAPLE_CHEST = registerBlockItem("maple_chest", () -> CompatModBlocks.MAPLE_CHEST.get());
    public static final DeferredItem<BlockItem> MAPLE_TRAPPED_CHEST = registerBlockItem("maple_trapped_chest", () -> CompatModBlocks.MAPLE_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> MAPLE_CHEST_MINECART = registerMinecartItem("maple_chest_minecart", () -> CompatModEntities.MAPLE_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> PALM_MOSAIC = registerBlockItem("palm_mosaic", () -> CompatModBlocks.PALM_MOSAIC.get());
    public static final DeferredItem<BlockItem> PALM_MOSAIC_SLAB = registerBlockItem("palm_mosaic_slab", () -> CompatModBlocks.PALM_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> PALM_MOSAIC_STAIRS = registerBlockItem("palm_mosaic_stairs", () -> CompatModBlocks.PALM_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> PALM_CRAFTING_TABLE = registerBlockItem("palm_crafting_table", () -> CompatModBlocks.PALM_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> PALM_CARTOGRAPHY_TABLE = registerBlockItem("palm_cartography_table", () -> CompatModBlocks.PALM_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> PALM_FLETCHING_TABLE = registerBlockItem("palm_fletching_table", () -> CompatModBlocks.PALM_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> PALM_BEEHIVE = registerBlockItem("palm_beehive", () -> CompatModBlocks.PALM_BEEHIVE.get());
    public static final DeferredItem<BlockItem> PALM_BARREL = registerBlockItem("palm_barrel", () -> CompatModBlocks.PALM_BARREL.get());
    public static final DeferredItem<BlockItem> PALM_LECTERN = registerBlockItem("palm_lectern", () -> CompatModBlocks.PALM_LECTERN.get());
    public static final DeferredItem<BlockItem> PALM_SMITHING_TABLE = registerBlockItem("palm_smithing_table", () -> CompatModBlocks.PALM_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> PALM_BOOKSHELF = registerBlockItem("palm_bookshelf", () -> CompatModBlocks.PALM_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PALM_CAMPFIRE = registerBlockItem("palm_campfire", () -> CompatModBlocks.PALM_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PALM_SOUL_CAMPFIRE = registerBlockItem("palm_soul_campfire", () -> CompatModBlocks.PALM_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PALM_GRINDSTONE = registerBlockItem("palm_grindstone", () -> CompatModBlocks.PALM_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> PALM_CHISELED_BOOKSHELF = registerBlockItem("palm_chiseled_bookshelf", () -> CompatModBlocks.PALM_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PALM_CRAFTER = registerBlockItem("palm_crafter", () -> CompatModBlocks.PALM_CRAFTER.get());
    public static final DeferredItem<BlockItem> PALM_STONE_SMOKER = registerBlockItem("palm_stone_smoker", () -> CompatModBlocks.PALM_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALM_BLACKSTONE_SMOKER = registerBlockItem("palm_blackstone_smoker", () -> CompatModBlocks.PALM_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALM_DEEPSLATE_SMOKER = registerBlockItem("palm_deepslate_smoker", () -> CompatModBlocks.PALM_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> PALM_LOOM = registerBlockItem("palm_loom", () -> CompatModBlocks.PALM_LOOM.get());
    public static final DeferredItem<BlockItem> PALM_CHEST = registerBlockItem("palm_chest", () -> CompatModBlocks.PALM_CHEST.get());
    public static final DeferredItem<BlockItem> PALM_TRAPPED_CHEST = registerBlockItem("palm_trapped_chest", () -> CompatModBlocks.PALM_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> PALM_CHEST_MINECART = registerMinecartItem("palm_chest_minecart", () -> CompatModEntities.PALM_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> PINE_MOSAIC = registerBlockItem("pine_mosaic", () -> CompatModBlocks.PINE_MOSAIC.get());
    public static final DeferredItem<BlockItem> PINE_MOSAIC_SLAB = registerBlockItem("pine_mosaic_slab", () -> CompatModBlocks.PINE_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> PINE_MOSAIC_STAIRS = registerBlockItem("pine_mosaic_stairs", () -> CompatModBlocks.PINE_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> PINE_CRAFTING_TABLE = registerBlockItem("pine_crafting_table", () -> CompatModBlocks.PINE_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> PINE_CARTOGRAPHY_TABLE = registerBlockItem("pine_cartography_table", () -> CompatModBlocks.PINE_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> PINE_FLETCHING_TABLE = registerBlockItem("pine_fletching_table", () -> CompatModBlocks.PINE_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> PINE_BEEHIVE = registerBlockItem("pine_beehive", () -> CompatModBlocks.PINE_BEEHIVE.get());
    public static final DeferredItem<BlockItem> PINE_BARREL = registerBlockItem("pine_barrel", () -> CompatModBlocks.PINE_BARREL.get());
    public static final DeferredItem<BlockItem> PINE_LECTERN = registerBlockItem("pine_lectern", () -> CompatModBlocks.PINE_LECTERN.get());
    public static final DeferredItem<BlockItem> PINE_SMITHING_TABLE = registerBlockItem("pine_smithing_table", () -> CompatModBlocks.PINE_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> PINE_BOOKSHELF = registerBlockItem("pine_bookshelf", () -> CompatModBlocks.PINE_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PINE_CAMPFIRE = registerBlockItem("pine_campfire", () -> CompatModBlocks.PINE_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PINE_SOUL_CAMPFIRE = registerBlockItem("pine_soul_campfire", () -> CompatModBlocks.PINE_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> PINE_GRINDSTONE = registerBlockItem("pine_grindstone", () -> CompatModBlocks.PINE_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> PINE_CHISELED_BOOKSHELF = registerBlockItem("pine_chiseled_bookshelf", () -> CompatModBlocks.PINE_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> PINE_CRAFTER = registerBlockItem("pine_crafter", () -> CompatModBlocks.PINE_CRAFTER.get());
    public static final DeferredItem<BlockItem> PINE_STONE_SMOKER = registerBlockItem("pine_stone_smoker", () -> CompatModBlocks.PINE_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PINE_BLACKSTONE_SMOKER = registerBlockItem("pine_blackstone_smoker", () -> CompatModBlocks.PINE_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> PINE_DEEPSLATE_SMOKER = registerBlockItem("pine_deepslate_smoker", () -> CompatModBlocks.PINE_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> PINE_LOOM = registerBlockItem("pine_loom", () -> CompatModBlocks.PINE_LOOM.get());
    public static final DeferredItem<BlockItem> PINE_CHEST = registerBlockItem("pine_chest", () -> CompatModBlocks.PINE_CHEST.get());
    public static final DeferredItem<BlockItem> PINE_TRAPPED_CHEST = registerBlockItem("pine_trapped_chest", () -> CompatModBlocks.PINE_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> PINE_CHEST_MINECART = registerMinecartItem("pine_chest_minecart", () -> CompatModEntities.PINE_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> REDWOOD_MOSAIC = registerBlockItem("redwood_mosaic", () -> CompatModBlocks.REDWOOD_MOSAIC.get());
    public static final DeferredItem<BlockItem> REDWOOD_MOSAIC_SLAB = registerBlockItem("redwood_mosaic_slab", () -> CompatModBlocks.REDWOOD_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> REDWOOD_MOSAIC_STAIRS = registerBlockItem("redwood_mosaic_stairs", () -> CompatModBlocks.REDWOOD_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> REDWOOD_CRAFTING_TABLE = registerBlockItem("redwood_crafting_table", () -> CompatModBlocks.REDWOOD_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> REDWOOD_CARTOGRAPHY_TABLE = registerBlockItem("redwood_cartography_table", () -> CompatModBlocks.REDWOOD_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> REDWOOD_FLETCHING_TABLE = registerBlockItem("redwood_fletching_table", () -> CompatModBlocks.REDWOOD_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> REDWOOD_BEEHIVE = registerBlockItem("redwood_beehive", () -> CompatModBlocks.REDWOOD_BEEHIVE.get());
    public static final DeferredItem<BlockItem> REDWOOD_BARREL = registerBlockItem("redwood_barrel", () -> CompatModBlocks.REDWOOD_BARREL.get());
    public static final DeferredItem<BlockItem> REDWOOD_LECTERN = registerBlockItem("redwood_lectern", () -> CompatModBlocks.REDWOOD_LECTERN.get());
    public static final DeferredItem<BlockItem> REDWOOD_SMITHING_TABLE = registerBlockItem("redwood_smithing_table", () -> CompatModBlocks.REDWOOD_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> REDWOOD_BOOKSHELF = registerBlockItem("redwood_bookshelf", () -> CompatModBlocks.REDWOOD_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> REDWOOD_CAMPFIRE = registerBlockItem("redwood_campfire", () -> CompatModBlocks.REDWOOD_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> REDWOOD_SOUL_CAMPFIRE = registerBlockItem("redwood_soul_campfire", () -> CompatModBlocks.REDWOOD_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> REDWOOD_GRINDSTONE = registerBlockItem("redwood_grindstone", () -> CompatModBlocks.REDWOOD_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> REDWOOD_CHISELED_BOOKSHELF = registerBlockItem("redwood_chiseled_bookshelf", () -> CompatModBlocks.REDWOOD_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> REDWOOD_CRAFTER = registerBlockItem("redwood_crafter", () -> CompatModBlocks.REDWOOD_CRAFTER.get());
    public static final DeferredItem<BlockItem> REDWOOD_STONE_SMOKER = registerBlockItem("redwood_stone_smoker", () -> CompatModBlocks.REDWOOD_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> REDWOOD_BLACKSTONE_SMOKER = registerBlockItem("redwood_blackstone_smoker", () -> CompatModBlocks.REDWOOD_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> REDWOOD_DEEPSLATE_SMOKER = registerBlockItem("redwood_deepslate_smoker", () -> CompatModBlocks.REDWOOD_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> REDWOOD_LOOM = registerBlockItem("redwood_loom", () -> CompatModBlocks.REDWOOD_LOOM.get());
    public static final DeferredItem<BlockItem> REDWOOD_CHEST = registerBlockItem("redwood_chest", () -> CompatModBlocks.REDWOOD_CHEST.get());
    public static final DeferredItem<BlockItem> REDWOOD_TRAPPED_CHEST = registerBlockItem("redwood_trapped_chest", () -> CompatModBlocks.REDWOOD_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> REDWOOD_CHEST_MINECART = registerMinecartItem("redwood_chest_minecart", () -> CompatModEntities.REDWOOD_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> UMBRAN_MOSAIC = registerBlockItem("umbran_mosaic", () -> CompatModBlocks.UMBRAN_MOSAIC.get());
    public static final DeferredItem<BlockItem> UMBRAN_MOSAIC_SLAB = registerBlockItem("umbran_mosaic_slab", () -> CompatModBlocks.UMBRAN_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> UMBRAN_MOSAIC_STAIRS = registerBlockItem("umbran_mosaic_stairs", () -> CompatModBlocks.UMBRAN_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> UMBRAN_CRAFTING_TABLE = registerBlockItem("umbran_crafting_table", () -> CompatModBlocks.UMBRAN_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> UMBRAN_CARTOGRAPHY_TABLE = registerBlockItem("umbran_cartography_table", () -> CompatModBlocks.UMBRAN_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> UMBRAN_FLETCHING_TABLE = registerBlockItem("umbran_fletching_table", () -> CompatModBlocks.UMBRAN_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> UMBRAN_BEEHIVE = registerBlockItem("umbran_beehive", () -> CompatModBlocks.UMBRAN_BEEHIVE.get());
    public static final DeferredItem<BlockItem> UMBRAN_BARREL = registerBlockItem("umbran_barrel", () -> CompatModBlocks.UMBRAN_BARREL.get());
    public static final DeferredItem<BlockItem> UMBRAN_LECTERN = registerBlockItem("umbran_lectern", () -> CompatModBlocks.UMBRAN_LECTERN.get());
    public static final DeferredItem<BlockItem> UMBRAN_SMITHING_TABLE = registerBlockItem("umbran_smithing_table", () -> CompatModBlocks.UMBRAN_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> UMBRAN_BOOKSHELF = registerBlockItem("umbran_bookshelf", () -> CompatModBlocks.UMBRAN_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> UMBRAN_CAMPFIRE = registerBlockItem("umbran_campfire", () -> CompatModBlocks.UMBRAN_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> UMBRAN_SOUL_CAMPFIRE = registerBlockItem("umbran_soul_campfire", () -> CompatModBlocks.UMBRAN_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> UMBRAN_GRINDSTONE = registerBlockItem("umbran_grindstone", () -> CompatModBlocks.UMBRAN_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> UMBRAN_CHISELED_BOOKSHELF = registerBlockItem("umbran_chiseled_bookshelf", () -> CompatModBlocks.UMBRAN_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> UMBRAN_CRAFTER = registerBlockItem("umbran_crafter", () -> CompatModBlocks.UMBRAN_CRAFTER.get());
    public static final DeferredItem<BlockItem> UMBRAN_STONE_SMOKER = registerBlockItem("umbran_stone_smoker", () -> CompatModBlocks.UMBRAN_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> UMBRAN_BLACKSTONE_SMOKER = registerBlockItem("umbran_blackstone_smoker", () -> CompatModBlocks.UMBRAN_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> UMBRAN_DEEPSLATE_SMOKER = registerBlockItem("umbran_deepslate_smoker", () -> CompatModBlocks.UMBRAN_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> UMBRAN_LOOM = registerBlockItem("umbran_loom", () -> CompatModBlocks.UMBRAN_LOOM.get());
    public static final DeferredItem<BlockItem> UMBRAN_CHEST = registerBlockItem("umbran_chest", () -> CompatModBlocks.UMBRAN_CHEST.get());
    public static final DeferredItem<BlockItem> UMBRAN_TRAPPED_CHEST = registerBlockItem("umbran_trapped_chest", () -> CompatModBlocks.UMBRAN_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> UMBRAN_CHEST_MINECART = registerMinecartItem("umbran_chest_minecart", () -> CompatModEntities.UMBRAN_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> WILLOW_MOSAIC = registerBlockItem("willow_mosaic", () -> CompatModBlocks.WILLOW_MOSAIC.get());
    public static final DeferredItem<BlockItem> WILLOW_MOSAIC_SLAB = registerBlockItem("willow_mosaic_slab", () -> CompatModBlocks.WILLOW_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> WILLOW_MOSAIC_STAIRS = registerBlockItem("willow_mosaic_stairs", () -> CompatModBlocks.WILLOW_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> WILLOW_CRAFTING_TABLE = registerBlockItem("willow_crafting_table", () -> CompatModBlocks.WILLOW_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> WILLOW_CARTOGRAPHY_TABLE = registerBlockItem("willow_cartography_table", () -> CompatModBlocks.WILLOW_CARTOGRAPHY_TABLE.get());
    public static final DeferredItem<BlockItem> WILLOW_FLETCHING_TABLE = registerBlockItem("willow_fletching_table", () -> CompatModBlocks.WILLOW_FLETCHING_TABLE.get());
    public static final DeferredItem<BlockItem> WILLOW_BEEHIVE = registerBlockItem("willow_beehive", () -> CompatModBlocks.WILLOW_BEEHIVE.get());
    public static final DeferredItem<BlockItem> WILLOW_BARREL = registerBlockItem("willow_barrel", () -> CompatModBlocks.WILLOW_BARREL.get());
    public static final DeferredItem<BlockItem> WILLOW_LECTERN = registerBlockItem("willow_lectern", () -> CompatModBlocks.WILLOW_LECTERN.get());
    public static final DeferredItem<BlockItem> WILLOW_SMITHING_TABLE = registerBlockItem("willow_smithing_table", () -> CompatModBlocks.WILLOW_SMITHING_TABLE.get());
    public static final DeferredItem<BlockItem> WILLOW_BOOKSHELF = registerBlockItem("willow_bookshelf", () -> CompatModBlocks.WILLOW_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> WILLOW_CAMPFIRE = registerBlockItem("willow_campfire", () -> CompatModBlocks.WILLOW_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> WILLOW_SOUL_CAMPFIRE = registerBlockItem("willow_soul_campfire", () -> CompatModBlocks.WILLOW_SOUL_CAMPFIRE.get());
    public static final DeferredItem<BlockItem> WILLOW_GRINDSTONE = registerBlockItem("willow_grindstone", () -> CompatModBlocks.WILLOW_GRINDSTONE.get());
    public static final DeferredItem<BlockItem> WILLOW_CHISELED_BOOKSHELF = registerBlockItem("willow_chiseled_bookshelf", () -> CompatModBlocks.WILLOW_CHISELED_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> WILLOW_CRAFTER = registerBlockItem("willow_crafter", () -> CompatModBlocks.WILLOW_CRAFTER.get());
    public static final DeferredItem<BlockItem> WILLOW_STONE_SMOKER = registerBlockItem("willow_stone_smoker", () -> CompatModBlocks.WILLOW_STONE_SMOKER.get());
    public static final DeferredItem<BlockItem> WILLOW_BLACKSTONE_SMOKER = registerBlockItem("willow_blackstone_smoker", () -> CompatModBlocks.WILLOW_BLACKSTONE_SMOKER.get());
    public static final DeferredItem<BlockItem> WILLOW_DEEPSLATE_SMOKER = registerBlockItem("willow_deepslate_smoker", () -> CompatModBlocks.WILLOW_DEEPSLATE_SMOKER.get());
    public static final DeferredItem<BlockItem> WILLOW_LOOM = registerBlockItem("willow_loom", () -> CompatModBlocks.WILLOW_LOOM.get());
    public static final DeferredItem<BlockItem> WILLOW_CHEST = registerBlockItem("willow_chest", () -> CompatModBlocks.WILLOW_CHEST.get());
    public static final DeferredItem<BlockItem> WILLOW_TRAPPED_CHEST = registerBlockItem("willow_trapped_chest", () -> CompatModBlocks.WILLOW_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> WILLOW_CHEST_MINECART = registerMinecartItem("willow_chest_minecart", () -> CompatModEntities.WILLOW_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> ORIGIN_OAK_MOSAIC = registerBlockItem("origin_oak_mosaic", () -> CompatModBlocks.ORIGIN_OAK_MOSAIC.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_MOSAIC_SLAB = registerBlockItem("origin_oak_mosaic_slab", () -> CompatModBlocks.ORIGIN_OAK_MOSAIC_SLAB.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_MOSAIC_STAIRS = registerBlockItem("origin_oak_mosaic_stairs", () -> CompatModBlocks.ORIGIN_OAK_MOSAIC_STAIRS.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_CRAFTING_TABLE = registerBlockItem("origin_oak_crafting_table", () -> CompatModBlocks.ORIGIN_OAK_CRAFTING_TABLE.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_BOOKSHELF = registerBlockItem("origin_oak_bookshelf", () -> CompatModBlocks.ORIGIN_OAK_BOOKSHELF.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_CHEST = registerBlockItem("origin_oak_chest", () -> CompatModBlocks.ORIGIN_OAK_CHEST.get());
    public static final DeferredItem<BlockItem> ORIGIN_OAK_TRAPPED_CHEST = registerBlockItem("origin_oak_trapped_chest", () -> CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get());
    public static final DeferredItem<MinecartItem> ORIGIN_OAK_CHEST_MINECART = registerMinecartItem("origin_oak_chest_minecart", () -> CompatModEntities.ORIGIN_OAK_CHEST_MINECART.get());

    public static final DeferredItem<BlockItem> WHITE_SANDSTONE_FENCE = registerBlockItem("white_sandstone_fence", () -> CompatModBlocks.WHITE_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_WHITE_SANDSTONE_FENCE = registerBlockItem("cut_white_sandstone_fence", () -> CompatModBlocks.CUT_WHITE_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_WHITE_SANDSTONE_FENCE = registerBlockItem("smooth_white_sandstone_fence", () -> CompatModBlocks.SMOOTH_WHITE_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> BLACK_SANDSTONE_FENCE = registerBlockItem("black_sandstone_fence", () -> CompatModBlocks.BLACK_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_BLACK_SANDSTONE_FENCE = registerBlockItem("cut_black_sandstone_fence", () -> CompatModBlocks.CUT_BLACK_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_BLACK_SANDSTONE_FENCE = registerBlockItem("smooth_black_sandstone_fence", () -> CompatModBlocks.SMOOTH_BLACK_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> ORANGE_SANDSTONE_FENCE = registerBlockItem("orange_sandstone_fence", () -> CompatModBlocks.ORANGE_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> CUT_ORANGE_SANDSTONE_FENCE = registerBlockItem("cut_orange_sandstone_fence", () -> CompatModBlocks.CUT_ORANGE_SANDSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> SMOOTH_ORANGE_SANDSTONE_FENCE = registerBlockItem("smooth_orange_sandstone_fence", () -> CompatModBlocks.SMOOTH_ORANGE_SANDSTONE_FENCE.get());

    public static final DeferredItem<BlockItem> BRIMSTONE_FENCE = registerBlockItem("brimstone_fence", () -> CompatModBlocks.BRIMSTONE_FENCE.get());
    public static final DeferredItem<BlockItem> BRIMSTONE_BRICK_FENCE = registerBlockItem("brimstone_brick_fence", () -> CompatModBlocks.BRIMSTONE_BRICK_FENCE.get());

    public static final DeferredItem<BlockItem> THERMAL_CALCITE_FENCE = registerBlockItem("thermal_calcite_fence", () -> CompatModBlocks.THERMAL_CALCITE_FENCE.get());
    public static final DeferredItem<BlockItem> POLISHED_THERMAL_CALCITE_FENCE = registerBlockItem("polished_thermal_calcite_fence", () -> CompatModBlocks.POLISHED_THERMAL_CALCITE_FENCE.get());
    public static final DeferredItem<BlockItem> THERMAL_CALCITE_BRICK_FENCE = registerBlockItem("thermal_calcite_brick_fence", () -> CompatModBlocks.THERMAL_CALCITE_BRICK_FENCE.get());

    public static final DeferredItem<Item> WHITE_SANDSTONE_BATON = registerCustomItem("white_sandstone_baton");
    public static final DeferredItem<Item> BLACK_SANDSTONE_BATON = registerCustomItem("black_sandstone_baton");
    public static final DeferredItem<Item> ORANGE_SANDSTONE_BATON = registerCustomItem("orange_sandstone_baton");
    public static final DeferredItem<Item> BRIMSTONE_BATON = registerCustomItem("brimstone_baton");

    private static DeferredItem<Item> registerCustomItem(String registryName) {
        return BOP_ITEMS.register(
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

    private static DeferredItem<BlockItem> registerBlockItem(String registryName, Supplier<Block> block){
        return BOP_ITEMS.register(
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

    private static DeferredItem<MinecartItem> registerMinecartItem(String registryName, Supplier<? extends EntityType<? extends AbstractMinecart>> entityType) {
        return BOP_ITEMS.register(registryName, () -> new MinecartItem(
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

    public static void register(IEventBus eventBus){
        BOP_ITEMS.register(eventBus);
    }

}
