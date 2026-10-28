
package github.theworksofbh.buildersparadise.datamap;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.collections.CorrodingZincCollection;
import github.theworksofbh.buildersparadise.blocks.collections.RustingIronCollection;
import github.theworksofbh.buildersparadise.blocks.types.CorrodingZinc;
import github.theworksofbh.buildersparadise.blocks.types.RustingIron;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.world.level.block.entity.FuelValues;

import java.util.List;

public final class ModDataMaps {

    private ModDataMaps() {
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

    public static void register() {
        registerOxidation();
        registerFuels();
    }

    private static void registerOxidation() {
        for (RustingIronCollection<Block> collection
                : RUSTING_IRON_COLLECTIONS) {

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().unaffected(),
                    collection.weathering().exposed()
            );

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().exposed(),
                    collection.weathering().weathered()
            );

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().weathered(),
                    collection.weathering().rusted()
            );

            RustingIron.WeatherState.forEach(state ->
                    OxidizableBlocksRegistry.registerWaxable(
                            collection.weathering().pick(state),
                            collection.waxed().pick(state)
                    )
            );
        }

        for (WeatheringCopperCollection<Block> collection : WEATHERING_COPPER_COLLECTIONS) {

            OxidizableBlocksRegistry.registerWeatheringCopperBlocks(
                    collection
            );
        }

        for (CorrodingZincCollection<Block> collection
                : CORRODING_ZINC_COLLECTIONS) {

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().unaffected(),
                    collection.weathering().exposed()
            );

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().exposed(),
                    collection.weathering().weathered()
            );

            OxidizableBlocksRegistry.registerNextStage(
                    collection.weathering().weathered(),
                    collection.weathering().corroded()
            );

            CorrodingZinc.WeatherState.forEach(state ->
                    OxidizableBlocksRegistry.registerWaxable(
                            collection.weathering().pick(state),
                            collection.waxed().pick(state)
                    )
            );
        }
    }

    private static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            fuel(builder, ModBlocks.COAL_SLAB.asItem(), 8000);
            fuel(builder, ModBlocks.COAL_STAIRS.asItem(), 16000);
            fuel(builder, ModBlocks.COAL_WALL.asItem(), 16000);
            fuel(builder, ModBlocks.COAL_FENCE.asItem(), 16000);

            fuel(builder, ModBlocks.CHARCOAL_BLOCK.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_SLAB.asItem(), 8000);
            fuel(builder, ModBlocks.CHARCOAL_STAIRS.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_WALL.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_FENCE.asItem(), 16000);

            fuel(builder, ModBlocks.COAL_BRICKS.asItem(), 16000);
            fuel(builder, ModBlocks.COAL_BRICK_SLAB.asItem(), 8000);
            fuel(builder, ModBlocks.COAL_BRICK_STAIRS.asItem(), 16000);
            fuel(builder, ModBlocks.COAL_BRICK_WALL.asItem(), 16000);
            fuel(builder, ModBlocks.COAL_BRICK_FENCE.asItem(), 16000);

            fuel(builder, ModBlocks.CHARCOAL_BRICKS.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_BRICK_SLAB.asItem(), 8000);
            fuel(builder, ModBlocks.CHARCOAL_BRICK_STAIRS.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_BRICK_WALL.asItem(), 16000);
            fuel(builder, ModBlocks.CHARCOAL_BRICK_FENCE.asItem(), 16000);

            fuel(builder, ModItems.URANIUM_INGOT, 7200);
            fuel(builder, ModItems.URANIUM_NUGGET, 800);
            fuel(builder, ModBlocks.URANIUM_BLOCK.asItem(), 64800);
            fuel(builder, ModBlocks.CUT_URANIUM.asItem(), 64800);
            fuel(builder, ModBlocks.CUT_URANIUM_SLAB.asItem(), 32400);
            fuel(builder, ModBlocks.CUT_URANIUM_STAIRS.asItem(), 64800);
            fuel(builder, ModBlocks.URANIUM_DOOR.asItem(), 43200);
            fuel(builder, ModBlocks.URANIUM_TRAPDOOR.asItem(), 43200);
            fuel(builder, ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.asItem(), 64800);
            fuel(builder, ModItems.NUCLEAR_WASTE_BUCKET, 8000000);

            fuelMosaics(builder);

            fuelWoodenVariants(builder);
        });
    }

    private static void fuelMosaics(FuelValues.Builder builder) {
        fuel(builder, ModBlocks.OAK_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.SPRUCE_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_MOSAIC.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_MOSAIC.asItem(), 300);

        fuel(builder, ModBlocks.OAK_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.SPRUCE_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.BIRCH_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.JUNGLE_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.ACACIA_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.DARK_OAK_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.MANGROVE_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.CHERRY_MOSAIC_SLAB.asItem(), 150);
        fuel(builder, ModBlocks.PALE_OAK_MOSAIC_SLAB.asItem(), 150);

        fuel(builder, ModBlocks.OAK_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.SPRUCE_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_MOSAIC_STAIRS.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_MOSAIC_STAIRS.asItem(), 300);
    }

    private static void fuelWoodenVariants(FuelValues.Builder builder) {
        fuel(builder, ModBlocks.SPRUCE_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem(), 300);

        fuel(builder, ModBlocks.OAK_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.asItem(), 300);

        fuel(builder, ModBlocks.OAK_FLETCHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.SPRUCE_FLETCHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_CRAFTING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_CRAFTING_TABLE.asItem(), 300);

        fuel(builder, ModBlocks.OAK_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.SPRUCE_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_SMITHING_TABLE.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_SMITHING_TABLE.asItem(), 300);

        fuel(builder, ModBlocks.SPRUCE_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_LOOM.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_LOOM.asItem(), 300);

        fuel(builder, ModBlocks.SPRUCE_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_LECTERN.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_LECTERN.asItem(), 300);

        fuel(builder, ModBlocks.SPRUCE_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_BOOKSHELF.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_BOOKSHELF.asItem(), 300);

        fuel(builder, ModBlocks.SPRUCE_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_CHEST.asItem(), 300);

        fuel(builder, ModBlocks.OAK_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_BARREL.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_BARREL.asItem(), 300);

        fuel(builder, ModBlocks.SPRUCE_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.BIRCH_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.JUNGLE_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.ACACIA_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.DARK_OAK_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.MANGROVE_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.CHERRY_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.BAMBOO_TRAPPED_CHEST.asItem(), 300);
        fuel(builder, ModBlocks.PALE_OAK_TRAPPED_CHEST.asItem(), 300);
    }

    private static void fuel(FuelValues.Builder builder, Item item, int burnTime
    ) {
        builder.add(item, burnTime);
    }
}
