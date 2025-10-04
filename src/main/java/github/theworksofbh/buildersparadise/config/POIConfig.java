package github.theworksofbh.buildersparadise.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.world.poi.ExtendPoiTypesEvent;

import java.util.Set;

public class POIConfig {
    private static final Set<BlockState> CARTOGRAPHY_TABLES = ImmutableList.of(
            ModBlocks.OAK_CARTOGRAPHY_TABLE.get(),
            ModBlocks.OAK_CARTOGRAPHY_TABLE.get(),
            ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.BIRCH_CARTOGRAPHY_TABLE.get(),
            ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.ACACIA_CARTOGRAPHY_TABLE.get(),
            ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.get(),
            ModBlocks.WARPED_CARTOGRAPHY_TABLE.get(),
            ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.get(),
            ModBlocks.CHERRY_CARTOGRAPHY_TABLE.get(),
            ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.get(),
            ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> FLETCHING_TABLES = ImmutableList.of(
            ModBlocks.OAK_FLETCHING_TABLE.get(),
            ModBlocks.SPRUCE_FLETCHING_TABLE.get(),
            ModBlocks.BIRCH_FLETCHING_TABLE.get(),
            ModBlocks.JUNGLE_FLETCHING_TABLE.get(),
            ModBlocks.ACACIA_FLETCHING_TABLE.get(),
            ModBlocks.DARK_OAK_FLETCHING_TABLE.get(),
            ModBlocks.CRIMSON_FLETCHING_TABLE.get(),
            ModBlocks.WARPED_FLETCHING_TABLE.get(),
            ModBlocks.MANGROVE_FLETCHING_TABLE.get(),
            ModBlocks.CHERRY_FLETCHING_TABLE.get(),
            ModBlocks.BAMBOO_FLETCHING_TABLE.get(),
            ModBlocks.PALE_OAK_FLETCHING_TABLE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    public static void addModBlocksToVanillaPOIs(ExtendPoiTypesEvent event) {
        event.addStatesToPoi(PoiTypes.CARTOGRAPHER, CARTOGRAPHY_TABLES);
        event.addStatesToPoi(PoiTypes.FLETCHER, FLETCHING_TABLES);
    }

}
