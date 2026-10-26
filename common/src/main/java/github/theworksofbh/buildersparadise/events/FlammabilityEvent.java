package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class FlammabilityEvent {
    public static void createFlammableBlocks() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;

        fireBlock.setFlammable(ModBlocks.COAL_SLAB, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_STAIRS, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_WALL, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_FENCE, 5, 5);

        fireBlock.setFlammable(ModBlocks.CHARCOAL_BLOCK, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_SLAB, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_STAIRS, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_WALL, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_FENCE, 5, 5);

        fireBlock.setFlammable(ModBlocks.COAL_BRICKS, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_SLAB, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_STAIRS, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_WALL, 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_FENCE, 5, 5);

        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICKS, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_SLAB, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_STAIRS, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_WALL, 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_FENCE, 5, 5);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC, 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC, 5, 20);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC_SLAB, 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC_SLAB, 5, 20);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC_STAIRS, 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC_STAIRS, 5, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_BEEHIVE, 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_BEEHIVE, 5, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_BOOKSHELF, 30, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_BOOKSHELF, 30, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_LECTERN, 30, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_LECTERN, 30, 20);
    }
}
