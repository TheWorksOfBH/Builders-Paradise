package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NeoForgeBlockEntityEvent {
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

    public static void addModdedBlocksToVanillaBlockEntities(BlockEntityTypeAddBlocksEvent event) {
        getKnownBlocks().forEach(block -> {
                    if (block instanceof FurnaceBlock) {
                        event.modify(BlockEntityTypes.FURNACE, block);
                    } else if (block instanceof SmokerBlock) {
                        event.modify(BlockEntityTypes.SMOKER, block);
                    } else if (block instanceof BlastFurnaceBlock) {
                        event.modify(BlockEntityTypes.BLAST_FURNACE, block);
                    } else if (block instanceof CampfireBlock) {
                        event.modify(BlockEntityTypes.CAMPFIRE, block);
                    } else if (block instanceof BeehiveBlock) {
                        event.modify(BlockEntityTypes.BEEHIVE, block);
                    } else if (block instanceof ChiseledBookShelfBlock) {
                        event.modify(BlockEntityTypes.CHISELED_BOOKSHELF, block);
                    } else if (block instanceof LecternBlock) {
                        event.modify(BlockEntityTypes.LECTERN, block);
                    } else if (block instanceof BrewingStandBlock) {
                        event.modify(BlockEntityTypes.BREWING_STAND, block);
                    } else if (block instanceof BarrelBlock) {
                        event.modify(BlockEntityTypes.BARREL, block);
                    } else if (block instanceof DispenserBlock) {
                        event.modify(BlockEntityTypes.DISPENSER, block);
                    } else if (block instanceof DropperBlock) {
                        event.modify(BlockEntityTypes.DROPPER, block);
                    } else if (block instanceof CrafterBlock) {
                        event.modify(BlockEntityTypes.CRAFTER, block);
                    } else if (block instanceof ChestBlock) {
                        if (block instanceof TrappedChestBlock) {
                            event.modify(BlockEntityTypes.TRAPPED_CHEST, block);
                        } else {
                            event.modify(BlockEntityTypes.CHEST, block);
                        }
                    } else {

                    }
                }
        );
    }
}
