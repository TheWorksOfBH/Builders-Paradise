package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.material.Fluids;

public class RenderTypeConfig {
    public static void addModRenderTypes() {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUSTED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_RUSTED_IRON_DOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUSTED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_RUSTED_IRON_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUSTED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_RUSTED_IRON_BARS.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOLD_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOLD_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRODED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_CORRODED_ZINC_DOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRODED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SILVER_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SILVER_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TIN_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TIN_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLATINUM_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLATINUM_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.URANIUM_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.URANIUM_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRONZE_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRONZE_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_DOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRASS_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.NUCLEAR_WASTE.get(), ChunkSectionLayer.TRANSLUCENT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIRCH_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.JUNGLE_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_OAK_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGROVE_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BAMBOO_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_OAK_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIRCH_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.JUNGLE_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_OAK_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGROVE_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BAMBOO_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_OAK_SOUL_CAMPFIRE.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKSTONE_BREWING_STAND.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEEPSLATE_BREWING_STAND.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(Fluids.LAVA, ChunkSectionLayer.TRANSLUCENT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_SLAB.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_STAIRS.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_WALL.get(), ChunkSectionLayer.TRANSLUCENT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUSTED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_RUSTED_IRON_CHAIN.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_BRICKS.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_BRICK_SLAB.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_BRICK_STAIRS.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_BRICK_WALL.get(), ChunkSectionLayer.TRANSLUCENT);

    }
}
