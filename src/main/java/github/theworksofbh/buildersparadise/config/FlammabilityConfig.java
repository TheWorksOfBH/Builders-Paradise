package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class FlammabilityConfig {
    public static void createFlammableBlocks() {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;

        fireBlock.setFlammable(ModBlocks.COAL_SLAB.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_STAIRS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_WALL.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_FENCE.get(), 5, 5);

        fireBlock.setFlammable(ModBlocks.CHARCOAL_BLOCK.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_SLAB.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_STAIRS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_WALL.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_FENCE.get(), 5, 5);

        fireBlock.setFlammable(ModBlocks.COAL_BRICKS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_SLAB.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_STAIRS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_WALL.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.COAL_BRICK_FENCE.get(), 5, 5);

        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICKS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_SLAB.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_STAIRS.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_WALL.get(), 5, 5);
        fireBlock.setFlammable(ModBlocks.CHARCOAL_BRICK_FENCE.get(), 5, 5);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC.get(), 5, 20);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC_SLAB.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC_SLAB.get(), 5, 20);

        fireBlock.setFlammable(ModBlocks.OAK_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.SPRUCE_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_MOSAIC_STAIRS.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_MOSAIC_STAIRS.get(), 5, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_BEEHIVE.get(), 5, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_BEEHIVE.get(), 5, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_BOOKSHELF.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_BOOKSHELF.get(), 30, 20);

        fireBlock.setFlammable(ModBlocks.SPRUCE_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.BIRCH_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.JUNGLE_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.ACACIA_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.DARK_OAK_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.MANGROVE_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.CHERRY_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.BAMBOO_LECTERN.get(), 30, 20);
        fireBlock.setFlammable(ModBlocks.PALE_OAK_LECTERN.get(), 30, 20);
    }
}
