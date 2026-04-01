package github.theworksofbh.buildersparadise.compat.bop;

import biomesoplenty.api.block.BOPBlocks;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.AmethystSlabBlock;
import github.theworksofbh.buildersparadise.block.AmethystStairBlock;
import github.theworksofbh.buildersparadise.block.FletchingTableBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CompatModBlocks {
    public static final DeferredRegister.Blocks BOP_BLOCKS = DeferredRegister.createBlocks(BuildersParadise.MODID);

    public static final DeferredBlock<StairBlock> CUT_WHITE_SANDSTONE_STAIRS = registerStairBlock("cut_white_sandstone_stairs", () -> BOPBlocks.CUT_WHITE_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_WHITE_SANDSTONE_WALL = registerWallBlock("cut_white_sandstone_wall", () -> BOPBlocks.CUT_WHITE_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_WHITE_SANDSTONE_WALL = registerWallBlock("smooth_white_sandstone_wall", () -> BOPBlocks.SMOOTH_WHITE_SANDSTONE);

    public static final DeferredBlock<StairBlock> CUT_BLACK_SANDSTONE_STAIRS = registerStairBlock("cut_black_sandstone_stairs", () -> BOPBlocks.CUT_BLACK_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_BLACK_SANDSTONE_WALL = registerWallBlock("cut_black_sandstone_wall", () -> BOPBlocks.CUT_BLACK_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_BLACK_SANDSTONE_WALL = registerWallBlock("smooth_black_sandstone_wall", () -> BOPBlocks.SMOOTH_BLACK_SANDSTONE);

    public static final DeferredBlock<StairBlock> CUT_ORANGE_SANDSTONE_STAIRS = registerStairBlock("cut_orange_sandstone_stairs", () -> BOPBlocks.CUT_ORANGE_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_ORANGE_SANDSTONE_WALL = registerWallBlock("cut_orange_sandstone_wall", () -> BOPBlocks.CUT_ORANGE_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_ORANGE_SANDSTONE_WALL = registerWallBlock("smooth_orange_sandstone_wall", () -> BOPBlocks.SMOOTH_ORANGE_SANDSTONE);

    public static final DeferredBlock<SlabBlock> BRIMSTONE_SLAB = registerSlabBlock("brimstone_slab", () -> BOPBlocks.BRIMSTONE);
    public static final DeferredBlock<StairBlock> BRIMSTONE_STAIRS = registerStairBlock("brimstone_stairs", () -> BOPBlocks.BRIMSTONE);
    public static final DeferredBlock<WallBlock> BRIMSTONE_WALL = registerWallBlock("brimstone_wall", () -> BOPBlocks.BRIMSTONE);

    public static final DeferredBlock<ThermalCalciteSlabBlock> THERMAL_CALCITE_SLAB = registerTCSlabBlock("thermal_calcite_slab", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteStairBlock> THERMAL_CALCITE_STAIRS = registerTCStairBlock("thermal_calcite_stairs", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteWallBlock> THERMAL_CALCITE_WALL = registerTCWallBlock("thermal_calcite_wall", () -> BOPBlocks.THERMAL_CALCITE);

    public static final DeferredBlock<ThermalCalciteBlock> POLISHED_THERMAL_CALCITE = registerTCBlock("polished_thermal_calcite", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteSlabBlock> POLISHED_THERMAL_CALCITE_SLAB = registerTCSlabBlock("polished_thermal_calcite_slab", () -> POLISHED_THERMAL_CALCITE.get());
    public static final DeferredBlock<ThermalCalciteStairBlock> POLISHED_THERMAL_CALCITE_STAIRS = registerTCStairBlock("polished_thermal_calcite_stairs", () -> POLISHED_THERMAL_CALCITE.get());
    public static final DeferredBlock<ThermalCalciteWallBlock> POLISHED_THERMAL_CALCITE_WALL = registerTCWallBlock("polished_thermal_calcite_wall", () -> POLISHED_THERMAL_CALCITE.get());

    public static final DeferredBlock<ThermalCalciteBlock> THERMAL_CALCITE_BRICKS = registerTCBlock("thermal_calcite_bricks", () -> POLISHED_THERMAL_CALCITE.get());
    public static final DeferredBlock<ThermalCalciteSlabBlock> THERMAL_CALCITE_BRICK_SLAB = registerTCSlabBlock("thermal_calcite_brick_slab", () -> THERMAL_CALCITE_BRICKS.get());
    public static final DeferredBlock<ThermalCalciteStairBlock> THERMAL_CALCITE_BRICK_STAIRS = registerTCStairBlock("thermal_calcite_brick_stairs", () -> THERMAL_CALCITE_BRICKS.get());
    public static final DeferredBlock<ThermalCalciteWallBlock> THERMAL_CALCITE_BRICK_WALL = registerTCWallBlock("thermal_calcite_brick_wall", () -> THERMAL_CALCITE_BRICKS.get());

    public static final DeferredBlock<AmethystBlock> CUT_ROSE_QUARTZ = registerAmethystBlock("cut_rose_quartz", () -> BOPBlocks.ROSE_QUARTZ_BLOCK);
    public static final DeferredBlock<AmethystSlabBlock> CUT_ROSE_QUARTZ_SLAB = registerAmethystSlabBlock("cut_rose_quartz_slab", () -> CUT_ROSE_QUARTZ.get());
    public static final DeferredBlock<AmethystStairBlock> CUT_ROSE_QUARTZ_STAIRS = registerAmethystStairBlock("cut_rose_quartz_stairs", () -> CUT_ROSE_QUARTZ.get());

    public static final DeferredBlock<Block> DEAD_MOSAIC = registerBlockVariant("dead_mosaic", () -> BOPBlocks.DEAD_PLANKS);
    public static final DeferredBlock<SlabBlock> DEAD_MOSAIC_SLAB = registerSlabBlock("dead_mosaic_slab", () -> DEAD_MOSAIC.get());
    public static final DeferredBlock<StairBlock> DEAD_MOSAIC_STAIRS = registerStairBlock("dead_mosaic_stairs", () -> DEAD_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> DEAD_CRAFTING_TABLE = registerCraftingTable("dead_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> DEAD_CARTOGRAPHY_TABLE = registerCartographyTable("dead_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> DEAD_FLETCHING_TABLE = registerFletchingTable("dead_fletching_table");
    public static final DeferredBlock<BeehiveBlock> DEAD_BEEHIVE = registerBeehive("dead_beehive");
    public static final DeferredBlock<BarrelBlock> DEAD_BARREL = registerBarrel("dead_barrel");
    public static final DeferredBlock<LecternBlock> DEAD_LECTERN = registerLectern("dead_lectern");
    public static final DeferredBlock<SmithingTableBlock> DEAD_SMITHING_TABLE = registerSmithingTable("dead_smithing_table");
    public static final DeferredBlock<Block> DEAD_BOOKSHELF = registerBookshelf("dead_bookshelf");
    public static final DeferredBlock<CampfireBlock> DEAD_CAMPFIRE = registerCampfire("dead_campfire");
    public static final DeferredBlock<CampfireBlock> DEAD_SOUL_CAMPFIRE = registerSoulCampfire("dead_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> DEAD_GRINDSTONE = registerGrindstone("dead_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> DEAD_CHISELED_BOOKSHELF = registerChiseledBookshelf("dead_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> DEAD_CRAFTER = registerCrafter("dead_crafter");
    public static final DeferredBlock<SmokerBlock> DEAD_STONE_SMOKER = registerSmoker("dead_stone_smoker");
    public static final DeferredBlock<SmokerBlock> DEAD_BLACKSTONE_SMOKER = registerSmoker("dead_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> DEAD_DEEPSLATE_SMOKER = registerSmoker("dead_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> DEAD_LOOM = registerLoom("dead_loom");
    public static final DeferredBlock<ChestBlock> DEAD_CHEST = registerWoodenChest("dead_chest");
    public static final DeferredBlock<TrappedChestBlock> DEAD_TRAPPED_CHEST = registerTrappedChest("dead_trapped_chest");

    public static final DeferredBlock<Block> EMPYREAL_MOSAIC = registerBlockVariant("empyreal_mosaic", () -> BOPBlocks.EMPYREAL_PLANKS);
    public static final DeferredBlock<SlabBlock> EMPYREAL_MOSAIC_SLAB = registerSlabBlock("empyreal_mosaic_slab", () -> EMPYREAL_MOSAIC.get());
    public static final DeferredBlock<StairBlock> EMPYREAL_MOSAIC_STAIRS = registerStairBlock("empyreal_mosaic_stairs", () -> EMPYREAL_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> EMPYREAL_CRAFTING_TABLE = registerCraftingTable("empyreal_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> EMPYREAL_CARTOGRAPHY_TABLE = registerCartographyTable("empyreal_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> EMPYREAL_FLETCHING_TABLE = registerFletchingTable("empyreal_fletching_table");
    public static final DeferredBlock<BeehiveBlock> EMPYREAL_BEEHIVE = registerBeehive("empyreal_beehive");
    public static final DeferredBlock<BarrelBlock> EMPYREAL_BARREL = registerBarrel("empyreal_barrel");
    public static final DeferredBlock<LecternBlock> EMPYREAL_LECTERN = registerLectern("empyreal_lectern");
    public static final DeferredBlock<SmithingTableBlock> EMPYREAL_SMITHING_TABLE = registerSmithingTable("empyreal_smithing_table");
    public static final DeferredBlock<Block> EMPYREAL_BOOKSHELF = registerBookshelf("empyreal_bookshelf");
    public static final DeferredBlock<CampfireBlock> EMPYREAL_CAMPFIRE = registerCampfire("empyreal_campfire");
    public static final DeferredBlock<CampfireBlock> EMPYREAL_SOUL_CAMPFIRE = registerSoulCampfire("empyreal_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> EMPYREAL_GRINDSTONE = registerGrindstone("empyreal_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> EMPYREAL_CHISELED_BOOKSHELF = registerChiseledBookshelf("empyreal_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> EMPYREAL_CRAFTER = registerCrafter("empyreal_crafter");
    public static final DeferredBlock<SmokerBlock> EMPYREAL_STONE_SMOKER = registerSmoker("empyreal_stone_smoker");
    public static final DeferredBlock<SmokerBlock> EMPYREAL_BLACKSTONE_SMOKER = registerSmoker("empyreal_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> EMPYREAL_DEEPSLATE_SMOKER = registerSmoker("empyreal_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> EMPYREAL_LOOM = registerLoom("empyreal_loom");
    public static final DeferredBlock<ChestBlock> EMPYREAL_CHEST = registerWoodenChest("empyreal_chest");
    public static final DeferredBlock<TrappedChestBlock> EMPYREAL_TRAPPED_CHEST = registerTrappedChest("empyreal_trapped_chest");

    public static final DeferredBlock<Block> FIR_MOSAIC = registerBlockVariant("fir_mosaic", () -> BOPBlocks.FIR_PLANKS);
    public static final DeferredBlock<SlabBlock> FIR_MOSAIC_SLAB = registerSlabBlock("fir_mosaic_slab", () -> FIR_MOSAIC.get());
    public static final DeferredBlock<StairBlock> FIR_MOSAIC_STAIRS = registerStairBlock("fir_mosaic_stairs", () -> FIR_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> FIR_CRAFTING_TABLE = registerCraftingTable("fir_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> FIR_CARTOGRAPHY_TABLE = registerCartographyTable("fir_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> FIR_FLETCHING_TABLE = registerFletchingTable("fir_fletching_table");
    public static final DeferredBlock<BeehiveBlock> FIR_BEEHIVE = registerBeehive("fir_beehive");
    public static final DeferredBlock<BarrelBlock> FIR_BARREL = registerBarrel("fir_barrel");
    public static final DeferredBlock<LecternBlock> FIR_LECTERN = registerLectern("fir_lectern");
    public static final DeferredBlock<SmithingTableBlock> FIR_SMITHING_TABLE = registerSmithingTable("fir_smithing_table");
    public static final DeferredBlock<Block> FIR_BOOKSHELF = registerBookshelf("fir_bookshelf");
    public static final DeferredBlock<CampfireBlock> FIR_CAMPFIRE = registerCampfire("fir_campfire");
    public static final DeferredBlock<CampfireBlock> FIR_SOUL_CAMPFIRE = registerSoulCampfire("fir_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> FIR_GRINDSTONE = registerGrindstone("fir_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> FIR_CHISELED_BOOKSHELF = registerChiseledBookshelf("fir_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> FIR_CRAFTER = registerCrafter("fir_crafter");
    public static final DeferredBlock<SmokerBlock> FIR_STONE_SMOKER = registerSmoker("fir_stone_smoker");
    public static final DeferredBlock<SmokerBlock> FIR_BLACKSTONE_SMOKER = registerSmoker("fir_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> FIR_DEEPSLATE_SMOKER = registerSmoker("fir_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> FIR_LOOM = registerLoom("fir_loom");
    public static final DeferredBlock<ChestBlock> FIR_CHEST = registerWoodenChest("fir_chest");
    public static final DeferredBlock<TrappedChestBlock> FIR_TRAPPED_CHEST = registerTrappedChest("fir_trapped_chest");

    public static final DeferredBlock<Block> HELLBARK_MOSAIC = registerBlockVariant("hellbark_mosaic", () -> BOPBlocks.HELLBARK_PLANKS);
    public static final DeferredBlock<SlabBlock> HELLBARK_MOSAIC_SLAB = registerSlabBlock("hellbark_mosaic_slab", () -> HELLBARK_MOSAIC.get());
    public static final DeferredBlock<StairBlock> HELLBARK_MOSAIC_STAIRS = registerStairBlock("hellbark_mosaic_stairs", () -> HELLBARK_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> HELLBARK_CRAFTING_TABLE = registerCraftingTable("hellbark_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> HELLBARK_CARTOGRAPHY_TABLE = registerCartographyTable("hellbark_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> HELLBARK_FLETCHING_TABLE = registerFletchingTable("hellbark_fletching_table");
    public static final DeferredBlock<BeehiveBlock> HELLBARK_BEEHIVE = registerBeehive("hellbark_beehive");
    public static final DeferredBlock<BarrelBlock> HELLBARK_BARREL = registerBarrel("hellbark_barrel");
    public static final DeferredBlock<LecternBlock> HELLBARK_LECTERN = registerLectern("hellbark_lectern");
    public static final DeferredBlock<SmithingTableBlock> HELLBARK_SMITHING_TABLE = registerSmithingTable("hellbark_smithing_table");
    public static final DeferredBlock<Block> HELLBARK_BOOKSHELF = registerBookshelf("hellbark_bookshelf");
    public static final DeferredBlock<CampfireBlock> HELLBARK_CAMPFIRE = registerCampfire("hellbark_campfire");
    public static final DeferredBlock<CampfireBlock> HELLBARK_SOUL_CAMPFIRE = registerSoulCampfire("hellbark_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> HELLBARK_GRINDSTONE = registerGrindstone("hellbark_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> HELLBARK_CHISELED_BOOKSHELF = registerChiseledBookshelf("hellbark_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> HELLBARK_CRAFTER = registerCrafter("hellbark_crafter");
    public static final DeferredBlock<SmokerBlock> HELLBARK_STONE_SMOKER = registerSmoker("hellbark_stone_smoker");
    public static final DeferredBlock<SmokerBlock> HELLBARK_BLACKSTONE_SMOKER = registerSmoker("hellbark_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> HELLBARK_DEEPSLATE_SMOKER = registerSmoker("hellbark_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> HELLBARK_LOOM = registerLoom("hellbark_loom");
    public static final DeferredBlock<ChestBlock> HELLBARK_CHEST = registerWoodenChest("hellbark_chest");
    public static final DeferredBlock<TrappedChestBlock> HELLBARK_TRAPPED_CHEST = registerTrappedChest("hellbark_trapped_chest");

    public static final DeferredBlock<Block> JACARANDA_MOSAIC = registerBlockVariant("jacaranda_mosaic", () -> BOPBlocks.JACARANDA_PLANKS);
    public static final DeferredBlock<SlabBlock> JACARANDA_MOSAIC_SLAB = registerSlabBlock("jacaranda_mosaic_slab", () -> JACARANDA_MOSAIC.get());
    public static final DeferredBlock<StairBlock> JACARANDA_MOSAIC_STAIRS = registerStairBlock("jacaranda_mosaic_stairs", () -> JACARANDA_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> JACARANDA_CRAFTING_TABLE = registerCraftingTable("jacaranda_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> JACARANDA_CARTOGRAPHY_TABLE = registerCartographyTable("jacaranda_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> JACARANDA_FLETCHING_TABLE = registerFletchingTable("jacaranda_fletching_table");
    public static final DeferredBlock<BeehiveBlock> JACARANDA_BEEHIVE = registerBeehive("jacaranda_beehive");
    public static final DeferredBlock<BarrelBlock> JACARANDA_BARREL = registerBarrel("jacaranda_barrel");
    public static final DeferredBlock<LecternBlock> JACARANDA_LECTERN = registerLectern("jacaranda_lectern");
    public static final DeferredBlock<SmithingTableBlock> JACARANDA_SMITHING_TABLE = registerSmithingTable("jacaranda_smithing_table");
    public static final DeferredBlock<Block> JACARANDA_BOOKSHELF = registerBookshelf("jacaranda_bookshelf");
    public static final DeferredBlock<CampfireBlock> JACARANDA_CAMPFIRE = registerCampfire("jacaranda_campfire");
    public static final DeferredBlock<CampfireBlock> JACARANDA_SOUL_CAMPFIRE = registerSoulCampfire("jacaranda_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> JACARANDA_GRINDSTONE = registerGrindstone("jacaranda_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> JACARANDA_CHISELED_BOOKSHELF = registerChiseledBookshelf("jacaranda_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> JACARANDA_CRAFTER = registerCrafter("jacaranda_crafter");
    public static final DeferredBlock<SmokerBlock> JACARANDA_STONE_SMOKER = registerSmoker("jacaranda_stone_smoker");
    public static final DeferredBlock<SmokerBlock> JACARANDA_BLACKSTONE_SMOKER = registerSmoker("jacaranda_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> JACARANDA_DEEPSLATE_SMOKER = registerSmoker("jacaranda_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> JACARANDA_LOOM = registerLoom("jacaranda_loom");
    public static final DeferredBlock<ChestBlock> JACARANDA_CHEST = registerWoodenChest("jacaranda_chest");
    public static final DeferredBlock<TrappedChestBlock> JACARANDA_TRAPPED_CHEST = registerTrappedChest("jacaranda_trapped_chest");

    public static final DeferredBlock<Block> MAGIC_MOSAIC = registerBlockVariant("magic_mosaic", () -> BOPBlocks.MAGIC_PLANKS);
    public static final DeferredBlock<SlabBlock> MAGIC_MOSAIC_SLAB = registerSlabBlock("magic_mosaic_slab", () -> MAGIC_MOSAIC.get());
    public static final DeferredBlock<StairBlock> MAGIC_MOSAIC_STAIRS = registerStairBlock("magic_mosaic_stairs", () -> MAGIC_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> MAGIC_CRAFTING_TABLE = registerCraftingTable("magic_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> MAGIC_CARTOGRAPHY_TABLE = registerCartographyTable("magic_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> MAGIC_FLETCHING_TABLE = registerFletchingTable("magic_fletching_table");
    public static final DeferredBlock<BeehiveBlock> MAGIC_BEEHIVE = registerBeehive("magic_beehive");
    public static final DeferredBlock<BarrelBlock> MAGIC_BARREL = registerBarrel("magic_barrel");
    public static final DeferredBlock<LecternBlock> MAGIC_LECTERN = registerLectern("magic_lectern");
    public static final DeferredBlock<SmithingTableBlock> MAGIC_SMITHING_TABLE = registerSmithingTable("magic_smithing_table");
    public static final DeferredBlock<Block> MAGIC_BOOKSHELF = registerBookshelf("magic_bookshelf");
    public static final DeferredBlock<CampfireBlock> MAGIC_CAMPFIRE = registerCampfire("magic_campfire");
    public static final DeferredBlock<CampfireBlock> MAGIC_SOUL_CAMPFIRE = registerSoulCampfire("magic_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> MAGIC_GRINDSTONE = registerGrindstone("magic_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> MAGIC_CHISELED_BOOKSHELF = registerChiseledBookshelf("magic_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> MAGIC_CRAFTER = registerCrafter("magic_crafter");
    public static final DeferredBlock<SmokerBlock> MAGIC_STONE_SMOKER = registerSmoker("magic_stone_smoker");
    public static final DeferredBlock<SmokerBlock> MAGIC_BLACKSTONE_SMOKER = registerSmoker("magic_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> MAGIC_DEEPSLATE_SMOKER = registerSmoker("magic_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> MAGIC_LOOM = registerLoom("magic_loom");
    public static final DeferredBlock<ChestBlock> MAGIC_CHEST = registerWoodenChest("magic_chest");
    public static final DeferredBlock<TrappedChestBlock> MAGIC_TRAPPED_CHEST = registerTrappedChest("magic_trapped_chest");

    public static final DeferredBlock<Block> MAHOGANY_MOSAIC = registerBlockVariant("mahogany_mosaic", () -> BOPBlocks.MAHOGANY_PLANKS);
    public static final DeferredBlock<SlabBlock> MAHOGANY_MOSAIC_SLAB = registerSlabBlock("mahogany_mosaic_slab", () -> MAHOGANY_MOSAIC.get());
    public static final DeferredBlock<StairBlock> MAHOGANY_MOSAIC_STAIRS = registerStairBlock("mahogany_mosaic_stairs", () -> MAHOGANY_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> MAHOGANY_CRAFTING_TABLE = registerCraftingTable("mahogany_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> MAHOGANY_CARTOGRAPHY_TABLE = registerCartographyTable("mahogany_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> MAHOGANY_FLETCHING_TABLE = registerFletchingTable("mahogany_fletching_table");
    public static final DeferredBlock<BeehiveBlock> MAHOGANY_BEEHIVE = registerBeehive("mahogany_beehive");
    public static final DeferredBlock<BarrelBlock> MAHOGANY_BARREL = registerBarrel("mahogany_barrel");
    public static final DeferredBlock<LecternBlock> MAHOGANY_LECTERN = registerLectern("mahogany_lectern");
    public static final DeferredBlock<SmithingTableBlock> MAHOGANY_SMITHING_TABLE = registerSmithingTable("mahogany_smithing_table");
    public static final DeferredBlock<Block> MAHOGANY_BOOKSHELF = registerBookshelf("mahogany_bookshelf");
    public static final DeferredBlock<CampfireBlock> MAHOGANY_CAMPFIRE = registerCampfire("mahogany_campfire");
    public static final DeferredBlock<CampfireBlock> MAHOGANY_SOUL_CAMPFIRE = registerSoulCampfire("mahogany_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> MAHOGANY_GRINDSTONE = registerGrindstone("mahogany_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> MAHOGANY_CHISELED_BOOKSHELF = registerChiseledBookshelf("mahogany_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> MAHOGANY_CRAFTER = registerCrafter("mahogany_crafter");
    public static final DeferredBlock<SmokerBlock> MAHOGANY_STONE_SMOKER = registerSmoker("mahogany_stone_smoker");
    public static final DeferredBlock<SmokerBlock> MAHOGANY_BLACKSTONE_SMOKER = registerSmoker("mahogany_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> MAHOGANY_DEEPSLATE_SMOKER = registerSmoker("mahogany_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> MAHOGANY_LOOM = registerLoom("mahogany_loom");
    public static final DeferredBlock<ChestBlock> MAHOGANY_CHEST = registerWoodenChest("mahogany_chest");
    public static final DeferredBlock<TrappedChestBlock> MAHOGANY_TRAPPED_CHEST = registerTrappedChest("mahogany_trapped_chest");

    public static final DeferredBlock<Block> MAPLE_MOSAIC = registerBlockVariant("maple_mosaic", () -> BOPBlocks.MAPLE_PLANKS);
    public static final DeferredBlock<SlabBlock> MAPLE_MOSAIC_SLAB = registerSlabBlock("maple_mosaic_slab", () -> MAPLE_MOSAIC.get());
    public static final DeferredBlock<StairBlock> MAPLE_MOSAIC_STAIRS = registerStairBlock("maple_mosaic_stairs", () -> MAPLE_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> MAPLE_CRAFTING_TABLE = registerCraftingTable("maple_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> MAPLE_CARTOGRAPHY_TABLE = registerCartographyTable("maple_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> MAPLE_FLETCHING_TABLE = registerFletchingTable("maple_fletching_table");
    public static final DeferredBlock<BeehiveBlock> MAPLE_BEEHIVE = registerBeehive("maple_beehive");
    public static final DeferredBlock<BarrelBlock> MAPLE_BARREL = registerBarrel("maple_barrel");
    public static final DeferredBlock<LecternBlock> MAPLE_LECTERN = registerLectern("maple_lectern");
    public static final DeferredBlock<SmithingTableBlock> MAPLE_SMITHING_TABLE = registerSmithingTable("maple_smithing_table");
    public static final DeferredBlock<Block> MAPLE_BOOKSHELF = registerBookshelf("maple_bookshelf");
    public static final DeferredBlock<CampfireBlock> MAPLE_CAMPFIRE = registerCampfire("maple_campfire");
    public static final DeferredBlock<CampfireBlock> MAPLE_SOUL_CAMPFIRE = registerSoulCampfire("maple_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> MAPLE_GRINDSTONE = registerGrindstone("maple_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> MAPLE_CHISELED_BOOKSHELF = registerChiseledBookshelf("maple_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> MAPLE_CRAFTER = registerCrafter("maple_crafter");
    public static final DeferredBlock<SmokerBlock> MAPLE_STONE_SMOKER = registerSmoker("maple_stone_smoker");
    public static final DeferredBlock<SmokerBlock> MAPLE_BLACKSTONE_SMOKER = registerSmoker("maple_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> MAPLE_DEEPSLATE_SMOKER = registerSmoker("maple_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> MAPLE_LOOM = registerLoom("maple_loom");
    public static final DeferredBlock<ChestBlock> MAPLE_CHEST = registerWoodenChest("maple_chest");
    public static final DeferredBlock<TrappedChestBlock> MAPLE_TRAPPED_CHEST = registerTrappedChest("maple_trapped_chest");

    public static final DeferredBlock<Block> PALM_MOSAIC = registerBlockVariant("palm_mosaic", () -> BOPBlocks.PALM_PLANKS);
    public static final DeferredBlock<SlabBlock> PALM_MOSAIC_SLAB = registerSlabBlock("palm_mosaic_slab", () -> PALM_MOSAIC.get());
    public static final DeferredBlock<StairBlock> PALM_MOSAIC_STAIRS = registerStairBlock("palm_mosaic_stairs", () -> PALM_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> PALM_CRAFTING_TABLE = registerCraftingTable("palm_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> PALM_CARTOGRAPHY_TABLE = registerCartographyTable("palm_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> PALM_FLETCHING_TABLE = registerFletchingTable("palm_fletching_table");
    public static final DeferredBlock<BeehiveBlock> PALM_BEEHIVE = registerBeehive("palm_beehive");
    public static final DeferredBlock<BarrelBlock> PALM_BARREL = registerBarrel("palm_barrel");
    public static final DeferredBlock<LecternBlock> PALM_LECTERN = registerLectern("palm_lectern");
    public static final DeferredBlock<SmithingTableBlock> PALM_SMITHING_TABLE = registerSmithingTable("palm_smithing_table");
    public static final DeferredBlock<Block> PALM_BOOKSHELF = registerBookshelf("palm_bookshelf");
    public static final DeferredBlock<CampfireBlock> PALM_CAMPFIRE = registerCampfire("palm_campfire");
    public static final DeferredBlock<CampfireBlock> PALM_SOUL_CAMPFIRE = registerSoulCampfire("palm_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> PALM_GRINDSTONE = registerGrindstone("palm_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> PALM_CHISELED_BOOKSHELF = registerChiseledBookshelf("palm_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> PALM_CRAFTER = registerCrafter("palm_crafter");
    public static final DeferredBlock<SmokerBlock> PALM_STONE_SMOKER = registerSmoker("palm_stone_smoker");
    public static final DeferredBlock<SmokerBlock> PALM_BLACKSTONE_SMOKER = registerSmoker("palm_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> PALM_DEEPSLATE_SMOKER = registerSmoker("palm_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> PALM_LOOM = registerLoom("palm_loom");
    public static final DeferredBlock<ChestBlock> PALM_CHEST = registerWoodenChest("palm_chest");
    public static final DeferredBlock<TrappedChestBlock> PALM_TRAPPED_CHEST = registerTrappedChest("palm_trapped_chest");

    public static final DeferredBlock<Block> PINE_MOSAIC = registerBlockVariant("pine_mosaic", () -> BOPBlocks.PINE_PLANKS);
    public static final DeferredBlock<SlabBlock> PINE_MOSAIC_SLAB = registerSlabBlock("pine_mosaic_slab", () -> PINE_MOSAIC.get());
    public static final DeferredBlock<StairBlock> PINE_MOSAIC_STAIRS = registerStairBlock("pine_mosaic_stairs", () -> PINE_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> PINE_CRAFTING_TABLE = registerCraftingTable("pine_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> PINE_CARTOGRAPHY_TABLE = registerCartographyTable("pine_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> PINE_FLETCHING_TABLE = registerFletchingTable("pine_fletching_table");
    public static final DeferredBlock<BeehiveBlock> PINE_BEEHIVE = registerBeehive("pine_beehive");
    public static final DeferredBlock<BarrelBlock> PINE_BARREL = registerBarrel("pine_barrel");
    public static final DeferredBlock<LecternBlock> PINE_LECTERN = registerLectern("pine_lectern");
    public static final DeferredBlock<SmithingTableBlock> PINE_SMITHING_TABLE = registerSmithingTable("pine_smithing_table");
    public static final DeferredBlock<Block> PINE_BOOKSHELF = registerBookshelf("pine_bookshelf");
    public static final DeferredBlock<CampfireBlock> PINE_CAMPFIRE = registerCampfire("pine_campfire");
    public static final DeferredBlock<CampfireBlock> PINE_SOUL_CAMPFIRE = registerSoulCampfire("pine_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> PINE_GRINDSTONE = registerGrindstone("pine_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> PINE_CHISELED_BOOKSHELF = registerChiseledBookshelf("pine_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> PINE_CRAFTER = registerCrafter("pine_crafter");
    public static final DeferredBlock<SmokerBlock> PINE_STONE_SMOKER = registerSmoker("pine_stone_smoker");
    public static final DeferredBlock<SmokerBlock> PINE_BLACKSTONE_SMOKER = registerSmoker("pine_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> PINE_DEEPSLATE_SMOKER = registerSmoker("pine_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> PINE_LOOM = registerLoom("pine_loom");
    public static final DeferredBlock<ChestBlock> PINE_CHEST = registerWoodenChest("pine_chest");
    public static final DeferredBlock<TrappedChestBlock> PINE_TRAPPED_CHEST = registerTrappedChest("pine_trapped_chest");

    public static final DeferredBlock<Block> REDWOOD_MOSAIC = registerBlockVariant("redwood_mosaic", () -> BOPBlocks.REDWOOD_PLANKS);
    public static final DeferredBlock<SlabBlock> REDWOOD_MOSAIC_SLAB = registerSlabBlock("redwood_mosaic_slab", () -> REDWOOD_MOSAIC.get());
    public static final DeferredBlock<StairBlock> REDWOOD_MOSAIC_STAIRS = registerStairBlock("redwood_mosaic_stairs", () -> REDWOOD_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> REDWOOD_CRAFTING_TABLE = registerCraftingTable("redwood_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> REDWOOD_CARTOGRAPHY_TABLE = registerCartographyTable("redwood_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> REDWOOD_FLETCHING_TABLE = registerFletchingTable("redwood_fletching_table");
    public static final DeferredBlock<BeehiveBlock> REDWOOD_BEEHIVE = registerBeehive("redwood_beehive");
    public static final DeferredBlock<BarrelBlock> REDWOOD_BARREL = registerBarrel("redwood_barrel");
    public static final DeferredBlock<LecternBlock> REDWOOD_LECTERN = registerLectern("redwood_lectern");
    public static final DeferredBlock<SmithingTableBlock> REDWOOD_SMITHING_TABLE = registerSmithingTable("redwood_smithing_table");
    public static final DeferredBlock<Block> REDWOOD_BOOKSHELF = registerBookshelf("redwood_bookshelf");
    public static final DeferredBlock<CampfireBlock> REDWOOD_CAMPFIRE = registerCampfire("redwood_campfire");
    public static final DeferredBlock<CampfireBlock> REDWOOD_SOUL_CAMPFIRE = registerSoulCampfire("redwood_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> REDWOOD_GRINDSTONE = registerGrindstone("redwood_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> REDWOOD_CHISELED_BOOKSHELF = registerChiseledBookshelf("redwood_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> REDWOOD_CRAFTER = registerCrafter("redwood_crafter");
    public static final DeferredBlock<SmokerBlock> REDWOOD_STONE_SMOKER = registerSmoker("redwood_stone_smoker");
    public static final DeferredBlock<SmokerBlock> REDWOOD_BLACKSTONE_SMOKER = registerSmoker("redwood_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> REDWOOD_DEEPSLATE_SMOKER = registerSmoker("redwood_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> REDWOOD_LOOM = registerLoom("redwood_loom");
    public static final DeferredBlock<ChestBlock> REDWOOD_CHEST = registerWoodenChest("redwood_chest");
    public static final DeferredBlock<TrappedChestBlock> REDWOOD_TRAPPED_CHEST = registerTrappedChest("redwood_trapped_chest");

    public static final DeferredBlock<Block> UMBRAN_MOSAIC = registerBlockVariant("umbran_mosaic", () -> BOPBlocks.UMBRAN_PLANKS);
    public static final DeferredBlock<SlabBlock> UMBRAN_MOSAIC_SLAB = registerSlabBlock("umbran_mosaic_slab", () -> UMBRAN_MOSAIC.get());
    public static final DeferredBlock<StairBlock> UMBRAN_MOSAIC_STAIRS = registerStairBlock("umbran_mosaic_stairs", () -> UMBRAN_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> UMBRAN_CRAFTING_TABLE = registerCraftingTable("umbran_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> UMBRAN_CARTOGRAPHY_TABLE = registerCartographyTable("umbran_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> UMBRAN_FLETCHING_TABLE = registerFletchingTable("umbran_fletching_table");
    public static final DeferredBlock<BeehiveBlock> UMBRAN_BEEHIVE = registerBeehive("umbran_beehive");
    public static final DeferredBlock<BarrelBlock> UMBRAN_BARREL = registerBarrel("umbran_barrel");
    public static final DeferredBlock<LecternBlock> UMBRAN_LECTERN = registerLectern("umbran_lectern");
    public static final DeferredBlock<SmithingTableBlock> UMBRAN_SMITHING_TABLE = registerSmithingTable("umbran_smithing_table");
    public static final DeferredBlock<Block> UMBRAN_BOOKSHELF = registerBookshelf("umbran_bookshelf");
    public static final DeferredBlock<CampfireBlock> UMBRAN_CAMPFIRE = registerCampfire("umbran_campfire");
    public static final DeferredBlock<CampfireBlock> UMBRAN_SOUL_CAMPFIRE = registerSoulCampfire("umbran_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> UMBRAN_GRINDSTONE = registerGrindstone("umbran_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> UMBRAN_CHISELED_BOOKSHELF = registerChiseledBookshelf("umbran_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> UMBRAN_CRAFTER = registerCrafter("umbran_crafter");
    public static final DeferredBlock<SmokerBlock> UMBRAN_STONE_SMOKER = registerSmoker("umbran_stone_smoker");
    public static final DeferredBlock<SmokerBlock> UMBRAN_BLACKSTONE_SMOKER = registerSmoker("umbran_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> UMBRAN_DEEPSLATE_SMOKER = registerSmoker("umbran_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> UMBRAN_LOOM = registerLoom("umbran_loom");
    public static final DeferredBlock<ChestBlock> UMBRAN_CHEST = registerWoodenChest("umbran_chest");
    public static final DeferredBlock<TrappedChestBlock> UMBRAN_TRAPPED_CHEST = registerTrappedChest("umbran_trapped_chest");

    public static final DeferredBlock<Block> WILLOW_MOSAIC = registerBlockVariant("willow_mosaic", () -> BOPBlocks.WILLOW_PLANKS);
    public static final DeferredBlock<SlabBlock> WILLOW_MOSAIC_SLAB = registerSlabBlock("willow_mosaic_slab", () -> WILLOW_MOSAIC.get());
    public static final DeferredBlock<StairBlock> WILLOW_MOSAIC_STAIRS = registerStairBlock("willow_mosaic_stairs", () -> WILLOW_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> WILLOW_CRAFTING_TABLE = registerCraftingTable("willow_crafting_table");
    public static final DeferredBlock<CartographyTableBlock> WILLOW_CARTOGRAPHY_TABLE = registerCartographyTable("willow_cartography_table");
    public static final DeferredBlock<FletchingTableBlock> WILLOW_FLETCHING_TABLE = registerFletchingTable("willow_fletching_table");
    public static final DeferredBlock<BeehiveBlock> WILLOW_BEEHIVE = registerBeehive("willow_beehive");
    public static final DeferredBlock<BarrelBlock> WILLOW_BARREL = registerBarrel("willow_barrel");
    public static final DeferredBlock<LecternBlock> WILLOW_LECTERN = registerLectern("willow_lectern");
    public static final DeferredBlock<SmithingTableBlock> WILLOW_SMITHING_TABLE = registerSmithingTable("willow_smithing_table");
    public static final DeferredBlock<Block> WILLOW_BOOKSHELF = registerBookshelf("willow_bookshelf");
    public static final DeferredBlock<CampfireBlock> WILLOW_CAMPFIRE = registerCampfire("willow_campfire");
    public static final DeferredBlock<CampfireBlock> WILLOW_SOUL_CAMPFIRE = registerSoulCampfire("willow_soul_campfire");
    public static final DeferredBlock<GrindstoneBlock> WILLOW_GRINDSTONE = registerGrindstone("willow_grindstone");
    public static final DeferredBlock<ChiseledBookShelfBlock> WILLOW_CHISELED_BOOKSHELF = registerChiseledBookshelf("willow_chiseled_bookshelf");
    public static final DeferredBlock<CrafterBlock> WILLOW_CRAFTER = registerCrafter("willow_crafter");
    public static final DeferredBlock<SmokerBlock> WILLOW_STONE_SMOKER = registerSmoker("willow_stone_smoker");
    public static final DeferredBlock<SmokerBlock> WILLOW_BLACKSTONE_SMOKER = registerSmoker("willow_blackstone_smoker");
    public static final DeferredBlock<SmokerBlock> WILLOW_DEEPSLATE_SMOKER = registerSmoker("willow_deepslate_smoker");
    public static final DeferredBlock<LoomBlock> WILLOW_LOOM = registerLoom("willow_loom");
    public static final DeferredBlock<ChestBlock> WILLOW_CHEST = registerWoodenChest("willow_chest");
    public static final DeferredBlock<TrappedChestBlock> WILLOW_TRAPPED_CHEST = registerTrappedChest("willow_trapped_chest");

    public static final DeferredBlock<Block> ORIGIN_OAK_MOSAIC = registerBlockVariant("origin_oak_mosaic", () -> BOPBlocks.ORIGIN_OAK_PLANKS);
    public static final DeferredBlock<SlabBlock> ORIGIN_OAK_MOSAIC_SLAB = registerSlabBlock("origin_oak_mosaic_slab", () -> ORIGIN_OAK_MOSAIC.get());
    public static final DeferredBlock<StairBlock> ORIGIN_OAK_MOSAIC_STAIRS = registerStairBlock("origin_oak_mosaic_stairs", () -> ORIGIN_OAK_MOSAIC.get());
    public static final DeferredBlock<CraftingTableBlock> ORIGIN_OAK_CRAFTING_TABLE = registerCraftingTable("origin_oak_crafting_table");
    public static final DeferredBlock<Block> ORIGIN_OAK_BOOKSHELF = registerBookshelf("origin_oak_bookshelf");
    public static final DeferredBlock<ChestBlock> ORIGIN_OAK_CHEST = registerWoodenChest("origin_oak_chest");
    public static final DeferredBlock<TrappedChestBlock> ORIGIN_OAK_TRAPPED_CHEST = registerTrappedChest("origin_oak_trapped_chest");

    public static final DeferredBlock<FenceBlock> WHITE_SANDSTONE_FENCE = registerFenceBlock("white_sandstone_fence", () -> BOPBlocks.WHITE_SANDSTONE);
    public static final DeferredBlock<FenceBlock> CUT_WHITE_SANDSTONE_FENCE = registerFenceBlock("cut_white_sandstone_fence", () -> BOPBlocks.CUT_WHITE_SANDSTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_WHITE_SANDSTONE_FENCE = registerFenceBlock("smooth_white_sandstone_fence", () -> BOPBlocks.SMOOTH_WHITE_SANDSTONE);

    public static final DeferredBlock<FenceBlock> BLACK_SANDSTONE_FENCE = registerFenceBlock("black_sandstone_fence", () -> BOPBlocks.BLACK_SANDSTONE);
    public static final DeferredBlock<FenceBlock> CUT_BLACK_SANDSTONE_FENCE = registerFenceBlock("cut_black_sandstone_fence", () -> BOPBlocks.CUT_BLACK_SANDSTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_BLACK_SANDSTONE_FENCE = registerFenceBlock("smooth_black_sandstone_fence", () -> BOPBlocks.SMOOTH_BLACK_SANDSTONE);

    public static final DeferredBlock<FenceBlock> ORANGE_SANDSTONE_FENCE = registerFenceBlock("orange_sandstone_fence", () -> BOPBlocks.ORANGE_SANDSTONE);
    public static final DeferredBlock<FenceBlock> CUT_ORANGE_SANDSTONE_FENCE = registerFenceBlock("cut_orange_sandstone_fence", () -> BOPBlocks.CUT_ORANGE_SANDSTONE);
    public static final DeferredBlock<FenceBlock> SMOOTH_ORANGE_SANDSTONE_FENCE = registerFenceBlock("smooth_orange_sandstone_fence", () -> BOPBlocks.SMOOTH_ORANGE_SANDSTONE);

    public static final DeferredBlock<FenceBlock> BRIMSTONE_FENCE = registerFenceBlock("brimstone_fence", () -> BOPBlocks.BRIMSTONE);
    public static final DeferredBlock<FenceBlock> BRIMSTONE_BRICK_FENCE = registerFenceBlock("brimstone_brick_fence", () -> BOPBlocks.BRIMSTONE_BRICKS);

    public static final DeferredBlock<ThermalCalciteFenceBlock> THERMAL_CALCITE_FENCE = registerTCFenceBlock("thermal_calcite_fence", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteFenceBlock> POLISHED_THERMAL_CALCITE_FENCE = registerTCFenceBlock("polished_thermal_calcite_fence", () -> POLISHED_THERMAL_CALCITE.get());
    public static final DeferredBlock<ThermalCalciteFenceBlock> THERMAL_CALCITE_BRICK_FENCE = registerTCFenceBlock("thermal_calcite_brick_fence", () -> THERMAL_CALCITE_BRICKS.get());

    private static DeferredBlock<Block> registerBlockVariant(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
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

    private static DeferredBlock<WallBlock> registerWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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

    private static DeferredBlock<ThermalCalciteBlock> registerTCBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteBlock(
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

    private static DeferredBlock<ThermalCalciteWallBlock> registerTCWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteWallBlock(
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

    private static DeferredBlock<ThermalCalciteFenceBlock> registerTCFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteFenceBlock(
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

    private static DeferredBlock<ThermalCalciteSlabBlock> registerTCSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteSlabBlock(
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

    private static DeferredBlock<ThermalCalciteStairBlock> registerTCStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteStairBlock(
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
        return BOP_BLOCKS.register(
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

    private static DeferredBlock<AmethystBlock> registerAmethystBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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

    private static DeferredBlock<CraftingTableBlock> registerCraftingTable(String registryName) {
        if (registryName == "crimson_crafting_table" || registryName == "warped_crafting_table") {
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityType.CHEST,
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
            return BOP_BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityType.CHEST,
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
            return BOP_BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityType.CHEST,
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
            return BOP_BLOCKS.register(
                    registryName, () -> new ChestBlock(
                            () -> BlockEntityType.CHEST,
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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
        return BOP_BLOCKS.register(
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

    private static DeferredBlock<SmokerBlock> registerSmoker(String registryName) {
        if (registryName.contains("deepslate")) {
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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

    private static DeferredBlock<LoomBlock> registerLoom(String registryName) {
        if (registryName == "crimson_loom" || registryName == "warped_loom") {
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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
            return BOP_BLOCKS.register(
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

    public static void register(IEventBus eventBus){
        BOP_BLOCKS.register(eventBus);
    }

}
