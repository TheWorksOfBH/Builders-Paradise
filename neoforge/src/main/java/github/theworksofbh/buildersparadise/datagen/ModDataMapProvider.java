package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.collections.CorrodingZincCollection;
import github.theworksofbh.buildersparadise.blocks.collections.RustingIronCollection;
import github.theworksofbh.buildersparadise.blocks.types.CorrodingZinc;
import github.theworksofbh.buildersparadise.blocks.types.RustingIron;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    public static final List<RustingIronCollection<Block>> RUSTING_IRON_COLLECTIONS = List.of(
            ModBlocks.IRON_BLOCK,
            ModBlocks.IRON_GRATE,
            ModBlocks.CUT_IRON,
            ModBlocks.CUT_IRON_STAIRS,
            ModBlocks.CUT_IRON_SLAB,
            ModBlocks.IRON_BARS,
            ModBlocks.IRON_DOOR,
            ModBlocks.IRON_TRAPDOOR,
            ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.IRON_CHAIN,
            ModBlocks.IRON_LANTERN,
            ModBlocks.IRON_SOUL_LANTERN,
            ModBlocks.IRON_FIRE_LANTERN
    );

    public static final List<WeatheringCopperCollection<Block>> WEATHERING_COPPER_COLLECTIONS = List.of(
            ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.COPPER_SOUL_LANTERN,
            ModBlocks.COPPER_FIRE_LANTERN
    );

    public static final List<CorrodingZincCollection<Block>> CORRODING_ZINC_COLLECTIONS = List.of(
            ModBlocks.ZINC_BLOCK,
            ModBlocks.ZINC_GRATE,
            ModBlocks.CUT_ZINC,
            ModBlocks.CUT_ZINC_STAIRS,
            ModBlocks.CUT_ZINC_SLAB,
            ModBlocks.ZINC_DOOR,
            ModBlocks.ZINC_TRAPDOOR,
            ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.ZINC_CHAIN,
            ModBlocks.ZINC_LANTERN,
            ModBlocks.ZINC_SOUL_LANTERN,
            ModBlocks.ZINC_FIRE_LANTERN
    );

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
        addToFurnaceFuels(ModBlocks.COAL_SLAB.asItem(), 8000);
        addToFurnaceFuels(ModBlocks.COAL_STAIRS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.COAL_WALL.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.COAL_FENCE.asItem(), 16000);

        addToFurnaceFuels(ModBlocks.CHARCOAL_BLOCK.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_SLAB.asItem(), 8000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_STAIRS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_WALL.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_FENCE.asItem(), 16000);

        addToFurnaceFuels(ModBlocks.COAL_BRICKS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.COAL_BRICK_SLAB.asItem(), 8000);
        addToFurnaceFuels(ModBlocks.COAL_BRICK_STAIRS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.COAL_BRICK_WALL.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.COAL_BRICK_FENCE.asItem(), 16000);

        addToFurnaceFuels(ModBlocks.CHARCOAL_BRICKS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_BRICK_SLAB.asItem(), 8000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_BRICK_STAIRS.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_BRICK_WALL.asItem(), 16000);
        addToFurnaceFuels(ModBlocks.CHARCOAL_BRICK_FENCE.asItem(), 16000);

        addToFurnaceFuels(ModItems.URANIUM_INGOT, 7200);
        addToFurnaceFuels(ModItems.URANIUM_NUGGET, 800);
        addToFurnaceFuels(ModBlocks.URANIUM_BLOCK.asItem(), 64800);
        addToFurnaceFuels(ModBlocks.CUT_URANIUM.asItem(), 64800);
        addToFurnaceFuels(ModBlocks.CUT_URANIUM_SLAB.asItem(), 32400);
        addToFurnaceFuels(ModBlocks.CUT_URANIUM_STAIRS.asItem(), 64800);
        addToFurnaceFuels(ModBlocks.URANIUM_DOOR.asItem(), 43200);
        addToFurnaceFuels(ModBlocks.URANIUM_TRAPDOOR.asItem(), 43200);
        addToFurnaceFuels(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.asItem(), 64800);
        addToFurnaceFuels(ModItems.NUCLEAR_WASTE_BUCKET, 8000000);

        addToFurnaceFuels(ModBlocks.OAK_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_MOSAIC.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_MOSAIC.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.SPRUCE_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.BIRCH_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.JUNGLE_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.ACACIA_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.DARK_OAK_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.MANGROVE_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.CHERRY_MOSAIC_SLAB.asItem(), 150);
        addToFurnaceFuels(ModBlocks.PALE_OAK_MOSAIC_SLAB.asItem(), 150);

        addToFurnaceFuels(ModBlocks.OAK_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_MOSAIC_STAIRS.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_MOSAIC_STAIRS.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_CRAFTING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_SMITHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_SMITHING_TABLE.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.SPRUCE_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_FLETCHING_TABLE.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_FLETCHING_TABLE.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_LOOM.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_LOOM.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_LECTERN.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_LECTERN.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_BOOKSHELF.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_BOOKSHELF.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_CHEST.asItem(), 300);

        addToFurnaceFuels(ModBlocks.OAK_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_BARREL.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_BARREL.asItem(), 300);

        addToFurnaceFuels(ModBlocks.SPRUCE_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BIRCH_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.JUNGLE_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.ACACIA_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.DARK_OAK_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.MANGROVE_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.CHERRY_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.BAMBOO_TRAPPED_CHEST.asItem(), 300);
        addToFurnaceFuels(ModBlocks.PALE_OAK_TRAPPED_CHEST.asItem(), 300);

        for (RustingIronCollection<Block> collection : RUSTING_IRON_COLLECTIONS) {
            addToOxidizables(collection.weathering().unaffected(), collection.weathering().exposed());
            addToOxidizables(collection.weathering().exposed(), collection.weathering().weathered());
            addToOxidizables(collection.weathering().weathered(), collection.weathering().rusted());
            RustingIron.WeatherState.forEach(statex -> addToWaxables(collection.weathering().pick(statex), collection.waxed().pick(statex)));
        }

        for (WeatheringCopperCollection<Block> collection : WEATHERING_COPPER_COLLECTIONS) {
            addToOxidizables(collection.weathering().unaffected(), collection.weathering().exposed());
            addToOxidizables(collection.weathering().exposed(), collection.weathering().weathered());
            addToOxidizables(collection.weathering().weathered(), collection.weathering().oxidized());
            WeatheringCopper.WeatherState.forEach(statex -> addToWaxables(collection.weathering().pick(statex), collection.waxed().pick(statex)));
        }

        for (CorrodingZincCollection<Block> collection : CORRODING_ZINC_COLLECTIONS) {
            addToOxidizables(collection.weathering().unaffected(), collection.weathering().exposed());
            addToOxidizables(collection.weathering().exposed(), collection.weathering().weathered());
            addToOxidizables(collection.weathering().weathered(), collection.weathering().corroded());
            CorrodingZinc.WeatherState.forEach(statex -> addToWaxables(collection.weathering().pick(statex), collection.waxed().pick(statex)));
        }
    }
}