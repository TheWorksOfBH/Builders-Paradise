package github.theworksofbh.buildersparadise.compat.bop.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.world.poi.ExtendPoiTypesEvent;

import java.util.Set;

public class BOPPOIConfig {
    private static final Set<BlockState> BOP_CARTOGRAPHY_TABLES = ImmutableList.of(
            CompatModBlocks.DEAD_CARTOGRAPHY_TABLE.get(),
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

    private static final Set<BlockState> BOP_FLETCHING_TABLES = ImmutableList.of(
            CompatModBlocks.DEAD_FLETCHING_TABLE.get(),
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

    private static final Set<BlockState> BOP_SMITHING_TABLES = ImmutableList.of(
            CompatModBlocks.DEAD_SMITHING_TABLE.get(),
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

    private static final Set<BlockState> BOP_GRINDSTONES = ImmutableList.of(
            CompatModBlocks.DEAD_GRINDSTONE.get(),
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

    private static final Set<BlockState> BOP_LOOMS = ImmutableList.of(
            CompatModBlocks.DEAD_LOOM.get(),
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

    private static final Set<BlockState> BOP_SMOKERS = ImmutableList.of(
            CompatModBlocks.DEAD_STONE_SMOKER.get(),
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

    private static final Set<BlockState> BOP_BEEHIVES = ImmutableList.of(
            CompatModBlocks.DEAD_BEEHIVE.get(),
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

    private static final Set<BlockState> BOP_LECTERNS = ImmutableList.of(
            CompatModBlocks.DEAD_LECTERN.get(),
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

    private static final Set<BlockState> BOP_BARRELS = ImmutableList.of(
            CompatModBlocks.DEAD_BARREL.get(),
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

    public static void addModBlocksToBOPPois(ExtendPoiTypesEvent event) {
        event.addStatesToPoi(PoiTypes.CARTOGRAPHER, BOP_CARTOGRAPHY_TABLES);
        event.addStatesToPoi(PoiTypes.FLETCHER, BOP_FLETCHING_TABLES);
        event.addStatesToPoi(PoiTypes.TOOLSMITH, BOP_SMITHING_TABLES);
        event.addStatesToPoi(PoiTypes.WEAPONSMITH, BOP_GRINDSTONES);
        event.addStatesToPoi(PoiTypes.SHEPHERD, BOP_LOOMS);
        event.addStatesToPoi(PoiTypes.BUTCHER, BOP_SMOKERS);
        event.addStatesToPoi(PoiTypes.BEEHIVE, BOP_BEEHIVES);
        event.addStatesToPoi(PoiTypes.LIBRARIAN, BOP_LECTERNS);
        event.addStatesToPoi(PoiTypes.FISHERMAN, BOP_BARRELS);
    }
}
