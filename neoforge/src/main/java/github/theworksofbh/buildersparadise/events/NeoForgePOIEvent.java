package github.theworksofbh.buildersparadise.events;

import com.google.common.collect.ImmutableSet;
import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.types.FletchingTableBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.world.poi.ExtendPoiTypesEvent;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NeoForgePOIEvent {
    protected static Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTags = Set.of(

        );

        Set<Block> handMadeBlocks = Set.of(

        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTags.stream(),
                BuiltInRegistries.BLOCK.stream()
                        .filter(block ->
                                BuiltInRegistries.BLOCK.getKey(block)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
                        )
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    public static void addModBlocksToVanillaPOIs(ExtendPoiTypesEvent event) {
        getKnownBlocks().forEach(block -> {
            ImmutableSet<BlockState> blockStates = block.getStateDefinition().getPossibleStates().stream().collect(ImmutableSet.toImmutableSet());
            if (block instanceof CartographyTableBlock) {
                event.addStatesToPoi(PoiTypes.CARTOGRAPHER, blockStates);
            } else if (block instanceof FletchingTableBlock) {
                event.addStatesToPoi(PoiTypes.FLETCHER, blockStates);
            } else if (block instanceof SmithingTableBlock) {
                event.addStatesToPoi(PoiTypes.TOOLSMITH, blockStates);
            } else if (block instanceof GrindstoneBlock) {
                event.addStatesToPoi(PoiTypes.WEAPONSMITH, blockStates);
            } else if (block instanceof LoomBlock) {
                event.addStatesToPoi(PoiTypes.SHEPHERD, blockStates);
            } else if (block instanceof SmokerBlock) {
                event.addStatesToPoi(PoiTypes.BUTCHER, blockStates);
            } else if (block instanceof BlastFurnaceBlock) {
                event.addStatesToPoi(PoiTypes.ARMORER, blockStates);
            } else if (block instanceof BeehiveBlock) {
                event.addStatesToPoi(PoiTypes.BEEHIVE, blockStates);
            } else if (block instanceof LecternBlock) {
                event.addStatesToPoi(PoiTypes.LIBRARIAN, blockStates);
            } else if (block instanceof BrewingStandBlock) {
                event.addStatesToPoi(PoiTypes.CLERIC, blockStates);
            } else if (block instanceof BarrelBlock) {
                event.addStatesToPoi(PoiTypes.FISHERMAN, blockStates);
            } else {

            }
        });
    }
}
