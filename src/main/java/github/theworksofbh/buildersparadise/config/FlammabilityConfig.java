package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.fml.ModList;

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

        if (ModList.get().isLoaded("biomesoplenty")) {
            fireBlock.setFlammable(CompatModBlocks.DEAD_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.DEAD_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.DEAD_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.DEAD_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.DEAD_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.DEAD_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.EMPYREAL_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.FIR_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.FIR_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.FIR_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.FIR_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.FIR_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.FIR_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.JACARANDA_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.JACARANDA_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.JACARANDA_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.JACARANDA_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.JACARANDA_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.JACARANDA_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.MAGIC_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAGIC_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAGIC_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAGIC_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAGIC_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.MAGIC_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.MAHOGANY_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.MAPLE_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAPLE_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAPLE_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAPLE_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.MAPLE_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.MAPLE_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.PALM_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PALM_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PALM_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PALM_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PALM_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.PALM_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.PINE_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PINE_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PINE_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PINE_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.PINE_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.PINE_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.REDWOOD_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.REDWOOD_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.REDWOOD_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.REDWOOD_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.REDWOOD_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.REDWOOD_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.UMBRAN_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.UMBRAN_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.UMBRAN_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.UMBRAN_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.UMBRAN_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.UMBRAN_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.WILLOW_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.WILLOW_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.WILLOW_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.WILLOW_BEEHIVE.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.WILLOW_BOOKSHELF.get(), 30, 20);
            fireBlock.setFlammable(CompatModBlocks.WILLOW_LECTERN.get(), 30, 20);

            fireBlock.setFlammable(CompatModBlocks.ORIGIN_OAK_MOSAIC.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.ORIGIN_OAK_MOSAIC_SLAB.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.ORIGIN_OAK_MOSAIC_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(CompatModBlocks.ORIGIN_OAK_BOOKSHELF.get(), 30, 20);
        }
    }
}
