package github.theworksofbh.buildersparadise.compat.bop.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BOPRenderTypeConfig {
    protected static Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewLootTables = Set.of(

        );

        Set<Block> handMadeBlocks = Set.of(

        );

        return Stream.concat(
                vanillaBlocksThatNeedNewLootTables.stream(),
                CompatModBlocks.BOP_BLOCKS.getEntries().stream().map(Supplier::get)
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();

    }

    public static void addModRenderTypes() {
        getKnownBlocks().forEach(block -> {
                    if (block.getDescriptionId().contains("ice") && !block.getDescriptionId().contains("packed") && !block.getDescriptionId().contains("blue") && !block.getDescriptionId().contains("pum") || block.getDescriptionId().contains("nuclear_waste")) {
                        ItemBlockRenderTypes.setRenderLayer(block, ChunkSectionLayer.TRANSLUCENT);
                    } else {
                        ItemBlockRenderTypes.setRenderLayer(block, ChunkSectionLayer.CUTOUT);
                    }
                }
        );
    }
}
