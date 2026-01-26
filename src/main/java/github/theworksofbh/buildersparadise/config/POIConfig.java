package github.theworksofbh.buildersparadise.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
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
            ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.DEAD_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.EMPYREAL_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.FIR_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.HELLBARK_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.JACARANDA_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.MAGIC_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.MAHOGANY_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.MAPLE_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.PALM_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.PINE_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.REDWOOD_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.UMBRAN_CARTOGRAPHY_TABLE.get(),
            CompatModBlocks.WILLOW_CARTOGRAPHY_TABLE.get()
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
            ModBlocks.PALE_OAK_FLETCHING_TABLE.get(),
            CompatModBlocks.DEAD_FLETCHING_TABLE.get(),
            CompatModBlocks.EMPYREAL_FLETCHING_TABLE.get(),
            CompatModBlocks.FIR_FLETCHING_TABLE.get(),
            CompatModBlocks.HELLBARK_FLETCHING_TABLE.get(),
            CompatModBlocks.JACARANDA_FLETCHING_TABLE.get(),
            CompatModBlocks.MAGIC_FLETCHING_TABLE.get(),
            CompatModBlocks.MAHOGANY_FLETCHING_TABLE.get(),
            CompatModBlocks.MAPLE_FLETCHING_TABLE.get(),
            CompatModBlocks.PALM_FLETCHING_TABLE.get(),
            CompatModBlocks.PINE_FLETCHING_TABLE.get(),
            CompatModBlocks.REDWOOD_FLETCHING_TABLE.get(),
            CompatModBlocks.UMBRAN_FLETCHING_TABLE.get(),
            CompatModBlocks.WILLOW_FLETCHING_TABLE.get()
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
            ModBlocks.PALE_OAK_SMITHING_TABLE.get(),
            CompatModBlocks.DEAD_SMITHING_TABLE.get(),
            CompatModBlocks.EMPYREAL_SMITHING_TABLE.get(),
            CompatModBlocks.FIR_SMITHING_TABLE.get(),
            CompatModBlocks.HELLBARK_SMITHING_TABLE.get(),
            CompatModBlocks.JACARANDA_SMITHING_TABLE.get(),
            CompatModBlocks.MAGIC_SMITHING_TABLE.get(),
            CompatModBlocks.MAHOGANY_SMITHING_TABLE.get(),
            CompatModBlocks.MAPLE_SMITHING_TABLE.get(),
            CompatModBlocks.PALM_SMITHING_TABLE.get(),
            CompatModBlocks.PINE_SMITHING_TABLE.get(),
            CompatModBlocks.REDWOOD_SMITHING_TABLE.get(),
            CompatModBlocks.UMBRAN_SMITHING_TABLE.get(),
            CompatModBlocks.WILLOW_SMITHING_TABLE.get()
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
            ModBlocks.PALE_OAK_GRINDSTONE.get(),
            CompatModBlocks.DEAD_GRINDSTONE.get(),
            CompatModBlocks.EMPYREAL_GRINDSTONE.get(),
            CompatModBlocks.FIR_GRINDSTONE.get(),
            CompatModBlocks.HELLBARK_GRINDSTONE.get(),
            CompatModBlocks.JACARANDA_GRINDSTONE.get(),
            CompatModBlocks.MAGIC_GRINDSTONE.get(),
            CompatModBlocks.MAHOGANY_GRINDSTONE.get(),
            CompatModBlocks.MAPLE_GRINDSTONE.get(),
            CompatModBlocks.PALM_GRINDSTONE.get(),
            CompatModBlocks.PINE_GRINDSTONE.get(),
            CompatModBlocks.REDWOOD_GRINDSTONE.get(),
            CompatModBlocks.UMBRAN_GRINDSTONE.get(),
            CompatModBlocks.WILLOW_GRINDSTONE.get()
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
            ModBlocks.PALE_OAK_LOOM.get(),
            CompatModBlocks.DEAD_LOOM.get(),
            CompatModBlocks.EMPYREAL_LOOM.get(),
            CompatModBlocks.FIR_LOOM.get(),
            CompatModBlocks.HELLBARK_LOOM.get(),
            CompatModBlocks.JACARANDA_LOOM.get(),
            CompatModBlocks.MAGIC_LOOM.get(),
            CompatModBlocks.MAHOGANY_LOOM.get(),
            CompatModBlocks.MAPLE_LOOM.get(),
            CompatModBlocks.PALM_LOOM.get(),
            CompatModBlocks.PINE_LOOM.get(),
            CompatModBlocks.REDWOOD_LOOM.get(),
            CompatModBlocks.UMBRAN_LOOM.get(),
            CompatModBlocks.WILLOW_LOOM.get()
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
            ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.DEAD_STONE_SMOKER.get(),
            CompatModBlocks.EMPYREAL_STONE_SMOKER.get(),
            CompatModBlocks.FIR_STONE_SMOKER.get(),
            CompatModBlocks.HELLBARK_STONE_SMOKER.get(),
            CompatModBlocks.JACARANDA_STONE_SMOKER.get(),
            CompatModBlocks.MAGIC_STONE_SMOKER.get(),
            CompatModBlocks.MAHOGANY_STONE_SMOKER.get(),
            CompatModBlocks.MAPLE_STONE_SMOKER.get(),
            CompatModBlocks.PALM_STONE_SMOKER.get(),
            CompatModBlocks.PINE_STONE_SMOKER.get(),
            CompatModBlocks.REDWOOD_STONE_SMOKER.get(),
            CompatModBlocks.UMBRAN_STONE_SMOKER.get(),
            CompatModBlocks.WILLOW_STONE_SMOKER.get(),
            CompatModBlocks.DEAD_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.EMPYREAL_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.FIR_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.HELLBARK_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.JACARANDA_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.MAGIC_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.MAHOGANY_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.MAPLE_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.PALM_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.PINE_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.REDWOOD_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.UMBRAN_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.WILLOW_BLACKSTONE_SMOKER.get(),
            CompatModBlocks.DEAD_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.EMPYREAL_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.FIR_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.HELLBARK_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.JACARANDA_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.MAGIC_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.MAHOGANY_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.MAPLE_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.PALM_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.PINE_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.REDWOOD_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.UMBRAN_DEEPSLATE_SMOKER.get(),
            CompatModBlocks.WILLOW_DEEPSLATE_SMOKER.get()
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
            ModBlocks.PALE_OAK_BEEHIVE.get(),
            CompatModBlocks.DEAD_BEEHIVE.get(),
            CompatModBlocks.EMPYREAL_BEEHIVE.get(),
            CompatModBlocks.FIR_BEEHIVE.get(),
            CompatModBlocks.HELLBARK_BEEHIVE.get(),
            CompatModBlocks.JACARANDA_BEEHIVE.get(),
            CompatModBlocks.MAGIC_BEEHIVE.get(),
            CompatModBlocks.MAHOGANY_BEEHIVE.get(),
            CompatModBlocks.MAPLE_BEEHIVE.get(),
            CompatModBlocks.PALM_BEEHIVE.get(),
            CompatModBlocks.PINE_BEEHIVE.get(),
            CompatModBlocks.REDWOOD_BEEHIVE.get(),
            CompatModBlocks.UMBRAN_BEEHIVE.get(),
            CompatModBlocks.WILLOW_BEEHIVE.get()
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
            ModBlocks.PALE_OAK_LECTERN.get(),
            CompatModBlocks.DEAD_LECTERN.get(),
            CompatModBlocks.EMPYREAL_LECTERN.get(),
            CompatModBlocks.FIR_LECTERN.get(),
            CompatModBlocks.HELLBARK_LECTERN.get(),
            CompatModBlocks.JACARANDA_LECTERN.get(),
            CompatModBlocks.MAGIC_LECTERN.get(),
            CompatModBlocks.MAHOGANY_LECTERN.get(),
            CompatModBlocks.MAPLE_LECTERN.get(),
            CompatModBlocks.PALM_LECTERN.get(),
            CompatModBlocks.PINE_LECTERN.get(),
            CompatModBlocks.REDWOOD_LECTERN.get(),
            CompatModBlocks.UMBRAN_LECTERN.get(),
            CompatModBlocks.WILLOW_LECTERN.get()
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
            ModBlocks.PALE_OAK_BARREL.get(),
            CompatModBlocks.DEAD_BARREL.get(),
            CompatModBlocks.EMPYREAL_BARREL.get(),
            CompatModBlocks.FIR_BARREL.get(),
            CompatModBlocks.HELLBARK_BARREL.get(),
            CompatModBlocks.JACARANDA_BARREL.get(),
            CompatModBlocks.MAGIC_BARREL.get(),
            CompatModBlocks.MAHOGANY_BARREL.get(),
            CompatModBlocks.MAPLE_BARREL.get(),
            CompatModBlocks.PALM_BARREL.get(),
            CompatModBlocks.PINE_BARREL.get(),
            CompatModBlocks.REDWOOD_BARREL.get(),
            CompatModBlocks.UMBRAN_BARREL.get(),
            CompatModBlocks.WILLOW_BARREL.get()
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
