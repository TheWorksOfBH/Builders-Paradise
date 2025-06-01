package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.ModBlocks;
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
        addToFurnaceFuels(ModItems.CHARCOAL_BLOCK.get(), 1022400);
        addToFurnaceFuels(ModItems.URANIUM_INGOT.get(), 7200);
        addToFurnaceFuels(ModItems.URANIUM_NUGGET.get(), 800);
        addToFurnaceFuels(ModItems.URANIUM_BLOCK.get(), 64800);
        addToFurnaceFuels(ModItems.URANIUM_TILES.get(), 64800);
        addToFurnaceFuels(ModItems.URANIUM_TILE_SLAB.get(), 32400);
        addToFurnaceFuels(ModItems.URANIUM_TILE_STAIRS.get(), 48600);
        addToFurnaceFuels(ModItems.URANIUM_DOOR.get(), 24300);
        addToFurnaceFuels(ModItems.URANIUM_TRAPDOOR.get(), 12150);
        addToFurnaceFuels(ModItems.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get(), 3100);
        addToFurnaceFuels(ModItems.NUCLEAR_WASTE_BUCKET.get(), 80000);


        addToOxidizables(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        addToOxidizables(Blocks.IRON_BLOCK, ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get(), ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get(), ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get());

        addToOxidizables(ModBlocks.IRON_TILES.get(), ModBlocks.MILDLY_RUSTED_IRON_TILES.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_TILES.get(), ModBlocks.MODERATELY_RUSTED_IRON_TILES.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get());

        addToOxidizables(ModBlocks.IRON_TILE_SLAB.get(), ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get());

        addToOxidizables(ModBlocks.IRON_TILE_STAIRS.get(), ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

        addToOxidizables(Blocks.IRON_DOOR, ModBlocks.MILDLY_RUSTED_IRON_DOOR.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_DOOR.get(), ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get(), ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get());

        addToOxidizables(Blocks.IRON_TRAPDOOR, ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

        addToOxidizables(Blocks.IRON_BARS, ModBlocks.MILDLY_RUSTED_IRON_BARS.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_IRON_BARS.get(), ModBlocks.MODERATELY_RUSTED_IRON_BARS.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_IRON_BARS.get(), ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get());

        addToOxidizables(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToOxidizables(ModBlocks.ZINC_BLOCK.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get());

        addToOxidizables(ModBlocks.ZINC_TILES.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get(), ModBlocks.REALLY_CORRODED_ZINC_TILES.get());

        addToOxidizables(ModBlocks.ZINC_TILE_SLAB.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get());

        addToOxidizables(ModBlocks.ZINC_TILE_STAIRS.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get());

        addToOxidizables(ModBlocks.ZINC_DOOR.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModBlocks.REALLY_CORRODED_ZINC_DOOR.get());

        addToOxidizables(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get());

        addToOxidizables(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToOxidizables(ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(Blocks.IRON_BLOCK, ModBlocks.WAXED_IRON_BLOCK.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_BLOCK.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get());

        addToWaxables(Blocks.IRON_DOOR, ModBlocks.WAXED_IRON_DOOR.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_DOOR.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_DOOR.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get());

        addToWaxables(Blocks.IRON_TRAPDOOR, ModBlocks.WAXED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

        addToWaxables(Blocks.IRON_BARS, ModBlocks.WAXED_IRON_BARS.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_BARS.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BARS.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BARS.get());

        addToWaxables(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        addToWaxables(ModBlocks.IRON_TILES.get(), ModBlocks.WAXED_IRON_TILES.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILES.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILES.get());

        addToWaxables(ModBlocks.IRON_TILE_SLAB.get(), ModBlocks.WAXED_IRON_TILE_SLAB.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get());

        addToWaxables(ModBlocks.IRON_TILE_STAIRS.get(), ModBlocks.WAXED_IRON_TILE_STAIRS.get());
        addToWaxables(ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get());
        addToWaxables(ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get());
        addToWaxables(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

        addToWaxables(ModBlocks.ZINC_BLOCK.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_BLOCK.get());

        addToWaxables(ModBlocks.ZINC_TILES.get(), ModBlocks.WAXED_ZINC_TILES.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get());

        addToWaxables(ModBlocks.ZINC_TILE_SLAB.get(), ModBlocks.WAXED_ZINC_TILE_SLAB.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get());

        addToWaxables(ModBlocks.ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_ZINC_TILE_STAIRS.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get());

        addToWaxables(ModBlocks.ZINC_DOOR.get(), ModBlocks.WAXED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_DOOR.get());

        addToWaxables(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.WAXED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get());

        addToWaxables(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        addToWaxables(ModBlocks.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
    }
}
