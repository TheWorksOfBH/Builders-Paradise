package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModItems;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    protected void addToOxidizables(Block currentBlock, Block subsequentBlock) {
        this.builder(NeoForgeDataMaps.OXIDIZABLES)
                .add(currentBlock.builtInRegistryHolder(),
                        new Oxidizable(subsequentBlock),
                        false
                );
    }

    protected void addToWaxables(Block unwaxedBlock, Block waxedBlock) {
        this.builder(NeoForgeDataMaps.WAXABLES)
                .add(unwaxedBlock.builtInRegistryHolder(),
                        new Waxable(waxedBlock),
                        false
                );
    }

    protected void addToFurnaceFuels(Item furnaceFuel, int burnTime) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(furnaceFuel.builtInRegistryHolder(),
                        new FurnaceFuel(burnTime),
                        false
                );
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        addToFurnaceFuels(ModItems.COAL_SLAB.get(), 8000);
        addToFurnaceFuels(ModItems.COAL_STAIRS.get(), 16000);
        addToFurnaceFuels(ModItems.COAL_WALL.get(), 16000);
        addToFurnaceFuels(ModItems.COAL_FENCE.get(), 16000);

        addToFurnaceFuels(ModItems.CHARCOAL_BLOCK.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_SLAB.get(), 8000);
        addToFurnaceFuels(ModItems.CHARCOAL_STAIRS.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_WALL.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_FENCE.get(), 16000);

        addToFurnaceFuels(ModItems.COAL_BRICKS.get(), 16000);
        addToFurnaceFuels(ModItems.COAL_BRICK_SLAB.get(), 8000);
        addToFurnaceFuels(ModItems.COAL_BRICK_STAIRS.get(), 16000);
        addToFurnaceFuels(ModItems.COAL_BRICK_WALL.get(), 16000);
        addToFurnaceFuels(ModItems.COAL_BRICK_FENCE.get(), 16000);

        addToFurnaceFuels(ModItems.CHARCOAL_BRICKS.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_BRICK_SLAB.get(), 8000);
        addToFurnaceFuels(ModItems.CHARCOAL_BRICK_STAIRS.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_BRICK_WALL.get(), 16000);
        addToFurnaceFuels(ModItems.CHARCOAL_BRICK_FENCE.get(), 16000);

        addToFurnaceFuels(ModItems.URANIUM_INGOT.get(), 7200);
        addToFurnaceFuels(ModItems.URANIUM_NUGGET.get(), 800);
        addToFurnaceFuels(ModItems.URANIUM_BLOCK.get(), 64800);
        addToFurnaceFuels(ModItems.CUT_URANIUM.get(), 64800);
        addToFurnaceFuels(ModItems.CUT_URANIUM_SLAB.get(), 32400);
        addToFurnaceFuels(ModItems.CUT_URANIUM_STAIRS.get(), 64800);
        addToFurnaceFuels(ModItems.URANIUM_DOOR.get(), 43200);
        addToFurnaceFuels(ModItems.URANIUM_TRAPDOOR.get(), 43200);
        addToFurnaceFuels(ModItems.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get(), 64800);
        addToFurnaceFuels(ModItems.NUCLEAR_WASTE_BUCKET.get(), 8000000);

        addToFurnaceFuels(ModItems.OAK_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_MOSAIC.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_MOSAIC.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_MOSAIC.get(), 300);

        addToFurnaceFuels(ModItems.OAK_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.SPRUCE_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.BIRCH_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.JUNGLE_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.ACACIA_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.DARK_OAK_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.MANGROVE_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.CHERRY_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(ModItems.PALE_OAK_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.DEAD_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.EMPYREAL_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.FIR_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.JACARANDA_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.MAGIC_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.MAHOGANY_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.MAPLE_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.PALM_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.PINE_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.REDWOOD_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.UMBRAN_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.WILLOW_MOSAIC_SLAB.get(), 150);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_MOSAIC_SLAB.get(), 150);

        addToFurnaceFuels(ModItems.OAK_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_MOSAIC_STAIRS.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_MOSAIC_STAIRS.get(), 300);

        addToFurnaceFuels(ModItems.OAK_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_CRAFTING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_CRAFTING_TABLE.get(), 300);

        addToFurnaceFuels(ModItems.OAK_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_CARTOGRAPHY_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_CARTOGRAPHY_TABLE.get(), 300);

        addToFurnaceFuels(ModItems.OAK_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_SMITHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_SMITHING_TABLE.get(), 300);

        addToFurnaceFuels(ModItems.OAK_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_FLETCHING_TABLE.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_FLETCHING_TABLE.get(), 300);

        addToFurnaceFuels(ModItems.OAK_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_LOOM.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_LOOM.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_LOOM.get(), 300);

        addToFurnaceFuels(ModItems.OAK_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_LECTERN.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_LECTERN.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_LECTERN.get(), 300);

        addToFurnaceFuels(ModItems.OAK_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_BOOKSHELF.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_BOOKSHELF.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_BOOKSHELF.get(), 300);

        addToFurnaceFuels(ModItems.OAK_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_CHEST.get(), 300);

        addToFurnaceFuels(ModItems.OAK_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_BARREL.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_BARREL.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_BARREL.get(), 300);

        addToFurnaceFuels(ModItems.OAK_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.SPRUCE_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.BIRCH_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.JUNGLE_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.ACACIA_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.DARK_OAK_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.MANGROVE_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.CHERRY_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.BAMBOO_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(ModItems.PALE_OAK_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.DEAD_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.EMPYREAL_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.FIR_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.JACARANDA_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAGIC_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAHOGANY_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.MAPLE_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.PALM_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.PINE_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.REDWOOD_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.UMBRAN_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.WILLOW_TRAPPED_CHEST.get(), 300);
        addToFurnaceFuels(CompatModItems.ORIGIN_OAK_TRAPPED_CHEST.get(), 300);

        addToOxidizables(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        addToOxidizables(Blocks.IRON_BLOCK, ModBlocks.EXPOSED_IRON.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON.get(), ModBlocks.WEATHERED_IRON.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON.get(), ModBlocks.RUSTED_IRON.get());

        addToOxidizables(ModBlocks.CUT_IRON.get(), ModBlocks.EXPOSED_CUT_IRON.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_IRON.get(), ModBlocks.WEATHERED_CUT_IRON.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_IRON.get(), ModBlocks.RUSTED_CUT_IRON.get());

        addToOxidizables(ModBlocks.CUT_IRON_SLAB.get(), ModBlocks.EXPOSED_CUT_IRON_SLAB.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_IRON_SLAB.get(), ModBlocks.WEATHERED_CUT_IRON_SLAB.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_IRON_SLAB.get(), ModBlocks.RUSTED_CUT_IRON_SLAB.get());

        addToOxidizables(ModBlocks.CUT_IRON_STAIRS.get(), ModBlocks.EXPOSED_CUT_IRON_STAIRS.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_IRON_STAIRS.get(), ModBlocks.WEATHERED_CUT_IRON_STAIRS.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_IRON_STAIRS.get(), ModBlocks.RUSTED_CUT_IRON_STAIRS.get());

        addToOxidizables(Blocks.IRON_DOOR, ModBlocks.EXPOSED_IRON_DOOR.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_DOOR.get(), ModBlocks.WEATHERED_IRON_DOOR.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_DOOR.get(), ModBlocks.RUSTED_IRON_DOOR.get());

        addToOxidizables(Blocks.IRON_TRAPDOOR, ModBlocks.EXPOSED_IRON_TRAPDOOR.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_TRAPDOOR.get(), ModBlocks.WEATHERED_IRON_TRAPDOOR.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_TRAPDOOR.get(), ModBlocks.RUSTED_IRON_TRAPDOOR.get());

        addToOxidizables(Blocks.IRON_BARS, ModBlocks.EXPOSED_IRON_BARS.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_BARS.get(), ModBlocks.WEATHERED_IRON_BARS.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_BARS.get(), ModBlocks.RUSTED_IRON_BARS.get());

        addToOxidizables(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToOxidizables(Blocks.IRON_CHAIN, ModBlocks.EXPOSED_IRON_CHAIN.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_CHAIN.get(), ModBlocks.WEATHERED_IRON_CHAIN.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_CHAIN.get(), ModBlocks.RUSTED_IRON_CHAIN.get());

        addToOxidizables(Blocks.LANTERN, ModBlocks.EXPOSED_IRON_LANTERN.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_LANTERN.get(), ModBlocks.WEATHERED_IRON_LANTERN.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_LANTERN.get(), ModBlocks.RUSTED_IRON_LANTERN.get());

        addToOxidizables(Blocks.SOUL_LANTERN, ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get(), ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get(), ModBlocks.RUSTED_IRON_SOUL_LANTERN.get());

        addToOxidizables(ModBlocks.IRON_FIRE_LANTERN.get(), ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get());
        addToOxidizables(ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get(), ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get());
        addToOxidizables(ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get(), ModBlocks.RUSTED_IRON_FIRE_LANTERN.get());

        addToOxidizables(ModBlocks.COPPER_SOUL_LANTERN.get(), ModBlocks.EXPOSED_COPPER_SOUL_LANTERN.get());
        addToOxidizables(ModBlocks.EXPOSED_COPPER_SOUL_LANTERN.get(), ModBlocks.WEATHERED_COPPER_SOUL_LANTERN.get());
        addToOxidizables(ModBlocks.WEATHERED_COPPER_SOUL_LANTERN.get(), ModBlocks.OXIDIZED_COPPER_SOUL_LANTERN.get());

        addToOxidizables(ModBlocks.COPPER_FIRE_LANTERN.get(), ModBlocks.EXPOSED_COPPER_FIRE_LANTERN.get());
        addToOxidizables(ModBlocks.EXPOSED_COPPER_FIRE_LANTERN.get(), ModBlocks.WEATHERED_COPPER_FIRE_LANTERN.get());
        addToOxidizables(ModBlocks.WEATHERED_COPPER_FIRE_LANTERN.get(), ModBlocks.OXIDIZED_COPPER_FIRE_LANTERN.get());

        addToOxidizables(ModBlocks.ZINC_BLOCK.get(), ModBlocks.EXPOSED_ZINC.get());
        addToOxidizables(ModBlocks.EXPOSED_ZINC.get(), ModBlocks.WEATHERED_ZINC.get());
        addToOxidizables(ModBlocks.WEATHERED_ZINC.get(), ModBlocks.CORRODED_ZINC.get());

        addToOxidizables(ModBlocks.CUT_ZINC.get(), ModBlocks.EXPOSED_CUT_ZINC.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_ZINC.get(), ModBlocks.WEATHERED_CUT_ZINC.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_ZINC.get(), ModBlocks.CORRODED_CUT_ZINC.get());

        addToOxidizables(ModBlocks.CUT_ZINC_SLAB.get(), ModBlocks.EXPOSED_CUT_ZINC_SLAB.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get(), ModBlocks.WEATHERED_CUT_ZINC_SLAB.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get(), ModBlocks.CORRODED_CUT_ZINC_SLAB.get());

        addToOxidizables(ModBlocks.CUT_ZINC_STAIRS.get(), ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get());
        addToOxidizables(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get(), ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get());
        addToOxidizables(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get(), ModBlocks.CORRODED_CUT_ZINC_STAIRS.get());

        addToOxidizables(ModBlocks.ZINC_DOOR.get(), ModBlocks.EXPOSED_ZINC_DOOR.get());
        addToOxidizables(ModBlocks.EXPOSED_ZINC_DOOR.get(), ModBlocks.WEATHERED_ZINC_DOOR.get());
        addToOxidizables(ModBlocks.WEATHERED_ZINC_DOOR.get(), ModBlocks.CORRODED_ZINC_DOOR.get());

        addToOxidizables(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.EXPOSED_ZINC_TRAPDOOR.get());
        addToOxidizables(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get(), ModBlocks.WEATHERED_ZINC_TRAPDOOR.get());
        addToOxidizables(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get(), ModBlocks.CORRODED_ZINC_TRAPDOOR.get());

        addToOxidizables(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToOxidizables(ModBlocks.ZINC_CHAIN.get(), ModBlocks.EXPOSED_ZINC_CHAIN.get());
        addToOxidizables(ModBlocks.EXPOSED_ZINC_CHAIN.get(), ModBlocks.WEATHERED_ZINC_CHAIN.get());
        addToOxidizables(ModBlocks.WEATHERED_ZINC_CHAIN.get(), ModBlocks.CORRODED_ZINC_CHAIN.get());

        addToWaxables(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(Blocks.IRON_BLOCK, ModBlocks.WAXED_IRON_BLOCK.get());
        addToWaxables(ModBlocks.EXPOSED_IRON.get(), ModBlocks.WAXED_EXPOSED_IRON.get());
        addToWaxables(ModBlocks.WEATHERED_IRON.get(), ModBlocks.WAXED_WEATHERED_IRON.get());
        addToWaxables(ModBlocks.RUSTED_IRON.get(), ModBlocks.WAXED_RUSTED_IRON.get());

        addToWaxables(Blocks.IRON_DOOR, ModBlocks.WAXED_IRON_DOOR.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_DOOR.get(), ModBlocks.WAXED_EXPOSED_IRON_DOOR.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_DOOR.get(), ModBlocks.WAXED_WEATHERED_IRON_DOOR.get());
        addToWaxables(ModBlocks.RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_RUSTED_IRON_DOOR.get());

        addToWaxables(Blocks.IRON_TRAPDOOR, ModBlocks.WAXED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_EXPOSED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_WEATHERED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_RUSTED_IRON_TRAPDOOR.get());

        addToWaxables(Blocks.IRON_BARS, ModBlocks.WAXED_IRON_BARS.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_BARS.get(), ModBlocks.WAXED_EXPOSED_IRON_BARS.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_BARS.get(), ModBlocks.WAXED_WEATHERED_IRON_BARS.get());
        addToWaxables(ModBlocks.RUSTED_IRON_BARS.get(), ModBlocks.WAXED_RUSTED_IRON_BARS.get());

        addToWaxables(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(Blocks.IRON_CHAIN, ModBlocks.WAXED_IRON_CHAIN.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_CHAIN.get(), ModBlocks.WAXED_EXPOSED_IRON_CHAIN.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_CHAIN.get(), ModBlocks.WAXED_WEATHERED_IRON_CHAIN.get());
        addToWaxables(ModBlocks.RUSTED_IRON_CHAIN.get(), ModBlocks.WAXED_RUSTED_IRON_CHAIN.get());

        addToWaxables(Blocks.LANTERN, ModBlocks.WAXED_IRON_LANTERN.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_LANTERN.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_LANTERN.get());
        addToWaxables(ModBlocks.RUSTED_IRON_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_LANTERN.get());

        addToWaxables(Blocks.SOUL_LANTERN, ModBlocks.WAXED_IRON_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.RUSTED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_SOUL_LANTERN.get());

        addToWaxables(ModBlocks.IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_IRON_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.RUSTED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_FIRE_LANTERN.get());

        addToWaxables(ModBlocks.COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_COPPER_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.EXPOSED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.WEATHERED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get());
        addToWaxables(ModBlocks.OXIDIZED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get());

        addToWaxables(ModBlocks.COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_COPPER_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.EXPOSED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.WEATHERED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get());
        addToWaxables(ModBlocks.OXIDIZED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_OXIDIZED_COPPER_FIRE_LANTERN.get());

        addToWaxables(ModBlocks.CUT_IRON.get(), ModBlocks.WAXED_CUT_IRON.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_IRON.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_IRON.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON.get());
        addToWaxables(ModBlocks.RUSTED_CUT_IRON.get(), ModBlocks.WAXED_RUSTED_CUT_IRON.get());

        addToWaxables(ModBlocks.CUT_IRON_SLAB.get(), ModBlocks.WAXED_CUT_IRON_SLAB.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON_SLAB.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON_SLAB.get());
        addToWaxables(ModBlocks.RUSTED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_RUSTED_CUT_IRON_SLAB.get());

        addToWaxables(ModBlocks.CUT_IRON_STAIRS.get(), ModBlocks.WAXED_CUT_IRON_STAIRS.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON_STAIRS.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON_STAIRS.get());
        addToWaxables(ModBlocks.RUSTED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_RUSTED_CUT_COPPER_STAIRS.get());

        addToWaxables(ModBlocks.ZINC_BLOCK.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        addToWaxables(ModBlocks.EXPOSED_ZINC.get(), ModBlocks.WAXED_EXPOSED_ZINC.get());
        addToWaxables(ModBlocks.WEATHERED_ZINC.get(), ModBlocks.WAXED_WEATHERED_ZINC.get());
        addToWaxables(ModBlocks.CORRODED_ZINC.get(), ModBlocks.WAXED_CORRODED_ZINC.get());

        addToWaxables(ModBlocks.CUT_ZINC.get(), ModBlocks.WAXED_CUT_ZINC.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_ZINC.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_ZINC.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC.get());
        addToWaxables(ModBlocks.CORRODED_CUT_ZINC.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC.get());

        addToWaxables(ModBlocks.CUT_ZINC_SLAB.get(), ModBlocks.WAXED_CUT_ZINC_SLAB.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get());
        addToWaxables(ModBlocks.CORRODED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get());

        addToWaxables(ModBlocks.CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_CUT_ZINC_STAIRS.get());
        addToWaxables(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get());
        addToWaxables(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get());
        addToWaxables(ModBlocks.CORRODED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get());

        addToWaxables(ModBlocks.ZINC_DOOR.get(), ModBlocks.WAXED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.EXPOSED_ZINC_DOOR.get(), ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.WEATHERED_ZINC_DOOR.get(), ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_CORRODED_ZINC_DOOR.get());

        addToWaxables(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.WAXED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get());

        addToWaxables(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(ModBlocks.ZINC_CHAIN.get(), ModBlocks.WAXED_ZINC_CHAIN.get());
        addToWaxables(ModBlocks.EXPOSED_ZINC_CHAIN.get(), ModBlocks.WAXED_EXPOSED_ZINC_CHAIN.get());
        addToWaxables(ModBlocks.WEATHERED_ZINC_CHAIN.get(), ModBlocks.WAXED_WEATHERED_ZINC_CHAIN.get());
        addToWaxables(ModBlocks.CORRODED_ZINC_CHAIN.get(), ModBlocks.WAXED_CORRODED_ZINC_CHAIN.get());
    }
}
