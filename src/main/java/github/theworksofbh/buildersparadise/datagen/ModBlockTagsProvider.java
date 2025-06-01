package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.*;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersParadise.MODID);
    }

    protected Iterable<Block> getKnownBlocks() {
        List<DeferredBlock<?>> handMadeBlocks = List.of(

        );
        Collection<DeferredHolder<Block, ? extends Block>> BLOCKS = ModBlocks.BLOCKS.getEntries();
        Set<DeferredHolder<Block, ? extends Block>> COPY = new HashSet<>(BLOCKS);

        for (DeferredBlock<?> block : handMadeBlocks) {
            COPY.remove(block);
        }

        return COPY.stream()
                .map(DeferredHolder::value)
                .collect(Collectors.toList());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownBlocks().forEach(
                block -> {
                    if (!(block instanceof WeatheringCopperPressurePlateBlock) | !(block instanceof WeightedPressurePlateBlock) | !(block instanceof ModPressurePlateBlock)) {
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                    }
                    if (block instanceof SlabBlock || block instanceof ModSlabBlock){
                        tag(BlockTags.SLABS).add(block);
                    }
                    else if (block instanceof StairBlock || block instanceof ModStairBlock) {
                        tag(BlockTags.STAIRS).add(block);
                    }
                    else if (block instanceof DoorBlock || block instanceof ModDoorBlock) {
                        tag(BlockTags.DOORS).add(block);
                    }
                    else if (block instanceof TrapDoorBlock || block instanceof ModTrapdoorBlock) {
                        tag(BlockTags.TRAPDOORS).add(block);
                    }
                    else if (block instanceof WallBlock) {
                        tag(BlockTags.WALLS).add(block);
                    }
                    else if (block instanceof WeatheringCopperPressurePlateBlock | block instanceof WeightedPressurePlateBlock | block instanceof ModPressurePlateBlock) {
                        tag(BlockTags.PRESSURE_PLATES).add(block);
                    }
                }
        );
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.IRON_TILES.get(), ModBlocks.IRON_TILE_SLAB.get(), ModBlocks.IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MILDLY_RUSTED_IRON_TILES.get(), ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get(), ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_IRON_TILES.get(), ModBlocks.WAXED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MILDLY_RUSTED_IRON_DOOR.get()).add(ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get()).add(ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_IRON_DOOR.get()).add(ModBlocks.WAXED_MILDLY_RUSTED_IRON_DOOR.get()).add(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_DOOR.get()).add(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get()).add(ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get()).add(ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_IRON_TRAPDOOR.get()).add(ModBlocks.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get()).add(ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get()).add(ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get(), ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get(), ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.WAXED_IRON_BLOCK.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.GOLD_TILES.get(), ModBlocks.GOLD_TILE_SLAB.get(), ModBlocks.GOLD_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.DIAMOND_TILES.get(), ModBlocks.DIAMOND_TILE_SLAB.get(), ModBlocks.DIAMOND_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.EMERALD_TILES.get(), ModBlocks.EMERALD_TILE_SLAB.get(), ModBlocks.EMERALD_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.NETHERITE_TILES.get(), ModBlocks.NETHERITE_TILE_SLAB.get(), ModBlocks.NETHERITE_TILE_STAIRS.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.NETHERITE_DOOR.get()).add(ModBlocks.NETHERITE_TRAPDOOR.get()).add(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.get());

        tag(ModBlockTags.ZINC_ORES).add(ModBlocks.ZINC_ORE.get()).add(ModBlocks.DEEPSLATE_ZINC_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ZINC_ORE.get()).add(ModBlocks.DEEPSLATE_ZINC_ORE.get()).add(ModBlocks.RAW_ZINC_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ZINC_BLOCK.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_ZINC_BLOCK.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ZINC_TILES.get(), ModBlocks.ZINC_TILE_SLAB.get(), ModBlocks.ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.REALLY_CORRODED_ZINC_TILES.get(), ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_ZINC_TILES.get(), ModBlocks.WAXED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ZINC_DOOR.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModBlocks.REALLY_CORRODED_ZINC_DOOR.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_ZINC_DOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_DOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.WAXED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get());

        tag(ModBlockTags.SILVER_ORES).add(ModBlocks.SILVER_ORE.get()).add(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SILVER_ORE.get()).add(ModBlocks.DEEPSLATE_SILVER_ORE.get()).add(ModBlocks.RAW_SILVER_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SILVER_BLOCK.get()).add(ModBlocks.SILVER_TILES.get()).add(ModBlocks.SILVER_TILE_SLAB.get()).add(ModBlocks.SILVER_TILE_STAIRS.get()).add(ModBlocks.SILVER_DOOR.get()).add(ModBlocks.SILVER_TRAPDOOR.get());

        tag(ModBlockTags.TIN_ORES).add(ModBlocks.TIN_ORE.get()).add(ModBlocks.DEEPSLATE_TIN_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.TIN_ORE.get()).add(ModBlocks.DEEPSLATE_TIN_ORE.get()).add(ModBlocks.RAW_TIN_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.TIN_BLOCK.get()).add(ModBlocks.CUT_TIN.get()).add(ModBlocks.CUT_TIN_SLAB.get()).add(ModBlocks.CUT_TIN_STAIRS.get()).add(ModBlocks.TIN_DOOR.get()).add(ModBlocks.TIN_TRAPDOOR.get());

        tag(ModBlockTags.TUNGSTEN_ORES).add(ModBlocks.TUNGSTEN_ORE.get()).add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.TUNGSTEN_ORE.get()).add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get()).add(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.TUNGSTEN_BLOCK.get()).add(ModBlocks.TUNGSTEN_TILES.get()).add(ModBlocks.TUNGSTEN_TILE_SLAB.get()).add(ModBlocks.TUNGSTEN_TILE_STAIRS.get()).add(ModBlocks.TUNGSTEN_DOOR.get()).add(ModBlocks.TUNGSTEN_TRAPDOOR.get());

        tag(ModBlockTags.PLATINUM_ORES).add(ModBlocks.PLATINUM_ORE.get()).add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.PLATINUM_ORE.get()).add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get()).add(ModBlocks.RAW_PLATINUM_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.PLATINUM_BLOCK.get()).add(ModBlocks.PLATINUM_TILES.get()).add(ModBlocks.PLATINUM_TILE_SLAB.get()).add(ModBlocks.PLATINUM_TILE_STAIRS.get()).add(ModBlocks.PLATINUM_DOOR.get()).add(ModBlocks.PLATINUM_TRAPDOOR.get());

        tag(ModBlockTags.LEAD_ORES).add(ModBlocks.LEAD_ORE.get()).add(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.LEAD_ORE.get()).add(ModBlocks.DEEPSLATE_LEAD_ORE.get()).add(ModBlocks.RAW_LEAD_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.LEAD_BLOCK.get()).add(ModBlocks.LEAD_TILES.get()).add(ModBlocks.LEAD_TILE_SLAB.get()).add(ModBlocks.LEAD_TILE_STAIRS.get()).add(ModBlocks.LEAD_DOOR.get()).add(ModBlocks.LEAD_TRAPDOOR.get());

        tag(ModBlockTags.URANIUM_ORES).add(ModBlocks.URANIUM_ORE.get()).add(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.URANIUM_ORE.get()).add(ModBlocks.DEEPSLATE_URANIUM_ORE.get()).add(ModBlocks.RAW_URANIUM_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.URANIUM_BLOCK.get()).add(ModBlocks.URANIUM_TILES.get()).add(ModBlocks.URANIUM_TILE_SLAB.get()).add(ModBlocks.URANIUM_TILE_STAIRS.get()).add(ModBlocks.URANIUM_DOOR.get()).add(ModBlocks.URANIUM_TRAPDOOR.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.BRONZE_BLOCK.get()).add(ModBlocks.CUT_BRONZE.get()).add(ModBlocks.CUT_BRONZE_SLAB.get()).add(ModBlocks.CUT_BRONZE_STAIRS.get()).add(ModBlocks.BRONZE_DOOR.get()).add(ModBlocks.BRONZE_TRAPDOOR.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BRASS_BLOCK.get()).add(ModBlocks.BRASS_TILES.get()).add(ModBlocks.BRASS_TILE_SLAB.get()).add(ModBlocks.BRASS_TILE_STAIRS.get()).add(ModBlocks.BRASS_DOOR.get()).add(ModBlocks.BRASS_TRAPDOOR.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.STEEL_BLOCK.get()).add(ModBlocks.STEEL_TILES.get()).add(ModBlocks.STEEL_TILE_SLAB.get()).add(ModBlocks.STEEL_TILE_STAIRS.get()).add(ModBlocks.STEEL_DOOR.get()).add(ModBlocks.STEEL_TRAPDOOR.get());
    }
}
