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

    private static final Set<BlockState> SMITHING_TABLES = ImmutableList.of(
            ModBlocks.OAK_SMITHING_TABLE.get(),
            ModBlocks.OAK_SMITHING_TABLE.get(),
            ModBlocks.SPRUCE_SMITHING_TABLE.get(),
            ModBlocks.BIRCH_SMITHING_TABLE.get(),
            ModBlocks.JUNGLE_SMITHING_TABLE.get(),
            ModBlocks.ACACIA_SMITHING_TABLE.get(),
            ModBlocks.DARK_OAK_SMITHING_TABLE.get(),
            ModBlocks.CRIMSON_SMITHING_TABLE.get(),
            ModBlocks.WARPED_SMITHING_TABLE.get(),
            ModBlocks.CHERRY_SMITHING_TABLE.get(),
            ModBlocks.BAMBOO_SMITHING_TABLE.get(),
            ModBlocks.PALE_OAK_SMITHING_TABLE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> GRINDSTONES = ImmutableList.of(
            ModBlocks.OAK_GRINDSTONE.get(),
            ModBlocks.OAK_GRINDSTONE.get(),
            ModBlocks.SPRUCE_GRINDSTONE.get(),
            ModBlocks.BIRCH_GRINDSTONE.get(),
            ModBlocks.JUNGLE_GRINDSTONE.get(),
            ModBlocks.ACACIA_GRINDSTONE.get(),
            ModBlocks.CRIMSON_GRINDSTONE.get(),
            ModBlocks.WARPED_GRINDSTONE.get(),
            ModBlocks.MANGROVE_GRINDSTONE.get(),
            ModBlocks.CHERRY_GRINDSTONE.get(),
            ModBlocks.BAMBOO_GRINDSTONE.get(),
            ModBlocks.PALE_OAK_GRINDSTONE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> LOOMS = ImmutableList.of(
            ModBlocks.SPRUCE_LOOM.get(),
            ModBlocks.SPRUCE_LOOM.get(),
            ModBlocks.BIRCH_LOOM.get(),
            ModBlocks.JUNGLE_LOOM.get(),
            ModBlocks.ACACIA_LOOM.get(),
            ModBlocks.DARK_OAK_LOOM.get(),
            ModBlocks.CRIMSON_LOOM.get(),
            ModBlocks.WARPED_LOOM.get(),
            ModBlocks.MANGROVE_LOOM.get(),
            ModBlocks.CHERRY_LOOM.get(),
            ModBlocks.BAMBOO_LOOM.get(),
            ModBlocks.PALE_OAK_LOOM.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> SMOKERS = ImmutableList.of(
            ModBlocks.SPRUCE_STONE_SMOKER.get(),
            ModBlocks.SPRUCE_STONE_SMOKER.get(),
            ModBlocks.BIRCH_STONE_SMOKER.get(),
            ModBlocks.JUNGLE_STONE_SMOKER.get(),
            ModBlocks.ACACIA_STONE_SMOKER.get(),
            ModBlocks.DARK_OAK_STONE_SMOKER.get(),
            ModBlocks.CRIMSON_STONE_SMOKER.get(),
            ModBlocks.WARPED_STONE_SMOKER.get(),
            ModBlocks.MANGROVE_STONE_SMOKER.get(),
            ModBlocks.CHERRY_STONE_SMOKER.get(),
            ModBlocks.BAMBOO_STONE_SMOKER.get(),
            ModBlocks.PALE_OAK_STONE_SMOKER.get(),
            ModBlocks.OAK_BLACKSTONE_SMOKER.get(),
            ModBlocks.SPRUCE_BLACKSTONE_SMOKER.get(),
            ModBlocks.BIRCH_BLACKSTONE_SMOKER.get(),
            ModBlocks.JUNGLE_BLACKSTONE_SMOKER.get(),
            ModBlocks.ACACIA_BLACKSTONE_SMOKER.get(),
            ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.get(),
            ModBlocks.CRIMSON_BLACKSTONE_SMOKER.get(),
            ModBlocks.WARPED_BLACKSTONE_SMOKER.get(),
            ModBlocks.MANGROVE_BLACKSTONE_SMOKER.get(),
            ModBlocks.CHERRY_BLACKSTONE_SMOKER.get(),
            ModBlocks.BAMBOO_BLACKSTONE_SMOKER.get(),
            ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.get(),
            ModBlocks.OAK_DEEPSLATE_SMOKER.get(),
            ModBlocks.SPRUCE_DEEPSLATE_SMOKER.get(),
            ModBlocks.BIRCH_DEEPSLATE_SMOKER.get(),
            ModBlocks.JUNGLE_DEEPSLATE_SMOKER.get(),
            ModBlocks.ACACIA_DEEPSLATE_SMOKER.get(),
            ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.get(),
            ModBlocks.CRIMSON_DEEPSLATE_SMOKER.get(),
            ModBlocks.WARPED_DEEPSLATE_SMOKER.get(),
            ModBlocks.MANGROVE_DEEPSLATE_SMOKER.get(),
            ModBlocks.CHERRY_DEEPSLATE_SMOKER.get(),
            ModBlocks.BAMBOO_DEEPSLATE_SMOKER.get(),
            ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> BLAST_FURNACES = ImmutableList.of(
            ModBlocks.BLACKSTONE_BLAST_FURNACE.get(),
            ModBlocks.BLACKSTONE_BLAST_FURNACE.get(),
            ModBlocks.DEEPSLATE_BLAST_FURNACE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> BREWING_STANDS = ImmutableList.of(
            ModBlocks.BLACKSTONE_BREWING_STAND.get(),
            ModBlocks.BLACKSTONE_BREWING_STAND.get(),
            ModBlocks.DEEPSLATE_BREWING_STAND.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> BEEHIVES = ImmutableList.of(
            ModBlocks.SPRUCE_BEEHIVE.get(),
            ModBlocks.SPRUCE_BEEHIVE.get(),
            ModBlocks.BIRCH_BEEHIVE.get(),
            ModBlocks.JUNGLE_BEEHIVE.get(),
            ModBlocks.ACACIA_BEEHIVE.get(),
            ModBlocks.DARK_OAK_BEEHIVE.get(),
            ModBlocks.CRIMSON_BEEHIVE.get(),
            ModBlocks.WARPED_BEEHIVE.get(),
            ModBlocks.MANGROVE_BEEHIVE.get(),
            ModBlocks.CHERRY_BEEHIVE.get(),
            ModBlocks.BAMBOO_BEEHIVE.get(),
            ModBlocks.PALE_OAK_BEEHIVE.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> LECTERNS = ImmutableList.of(
            ModBlocks.SPRUCE_LECTERN.get(),
            ModBlocks.SPRUCE_LECTERN.get(),
            ModBlocks.BIRCH_LECTERN.get(),
            ModBlocks.JUNGLE_LECTERN.get(),
            ModBlocks.ACACIA_LECTERN.get(),
            ModBlocks.DARK_OAK_LECTERN.get(),
            ModBlocks.CRIMSON_LECTERN.get(),
            ModBlocks.WARPED_LECTERN.get(),
            ModBlocks.MANGROVE_LECTERN.get(),
            ModBlocks.CHERRY_LECTERN.get(),
            ModBlocks.BAMBOO_LECTERN.get(),
            ModBlocks.PALE_OAK_LECTERN.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());

    private static final Set<BlockState> BARRELS = ImmutableList.of(
            ModBlocks.OAK_BARREL.get(),
            ModBlocks.OAK_BARREL.get(),
            ModBlocks.BIRCH_BARREL.get(),
            ModBlocks.JUNGLE_BARREL.get(),
            ModBlocks.ACACIA_BARREL.get(),
            ModBlocks.DARK_OAK_BARREL.get(),
            ModBlocks.CRIMSON_BARREL.get(),
            ModBlocks.WARPED_BARREL.get(),
            ModBlocks.MANGROVE_BARREL.get(),
            ModBlocks.CHERRY_BARREL.get(),
            ModBlocks.BAMBOO_BARREL.get(),
            ModBlocks.PALE_OAK_BARREL.get()
    ).stream().flatMap((block) -> block.getStateDefinition().getPossibleStates().stream()).collect(ImmutableSet.toImmutableSet());


    public static void addModBlocksToVanillaPOIs(ExtendPoiTypesEvent event) {
        event.addStatesToPoi(PoiTypes.CARTOGRAPHER, CARTOGRAPHY_TABLES);
        event.addStatesToPoi(PoiTypes.FLETCHER, FLETCHING_TABLES);
        event.addStatesToPoi(PoiTypes.TOOLSMITH, SMITHING_TABLES);
        event.addStatesToPoi(PoiTypes.WEAPONSMITH, GRINDSTONES);
        event.addStatesToPoi(PoiTypes.SHEPHERD, LOOMS);
        event.addStatesToPoi(PoiTypes.BUTCHER, SMOKERS);
        event.addStatesToPoi(PoiTypes.ARMORER, BLAST_FURNACES);
        event.addStatesToPoi(PoiTypes.BEEHIVE, BEEHIVES);
        event.addStatesToPoi(PoiTypes.LIBRARIAN, LECTERNS);
        event.addStatesToPoi(PoiTypes.CLERIC, BREWING_STANDS);
        event.addStatesToPoi(PoiTypes.FISHERMAN, BARRELS);

    }

}
