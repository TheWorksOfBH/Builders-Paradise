package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

public class BlockEntityConfig {
    public static void addModdedBlocksToVanillaBlockEntities(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.FURNACE, ModBlocks.BLACKSTONE_FURNACE.get());
        event.modify(BlockEntityType.FURNACE, ModBlocks.DEEPSLATE_FURNACE.get());

        event.modify(BlockEntityType.SMOKER, ModBlocks.SPRUCE_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BIRCH_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.JUNGLE_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.ACACIA_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.DARK_OAK_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CRIMSON_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.WARPED_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.MANGROVE_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CHERRY_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BAMBOO_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.PALE_OAK_STONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.OAK_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.SPRUCE_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BIRCH_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.JUNGLE_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.ACACIA_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CRIMSON_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.WARPED_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.MANGROVE_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CHERRY_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BAMBOO_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.OAK_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.SPRUCE_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BIRCH_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.JUNGLE_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.ACACIA_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CRIMSON_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.WARPED_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.MANGROVE_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.CHERRY_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.BAMBOO_DEEPSLATE_SMOKER.get());
        event.modify(BlockEntityType.SMOKER, ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.get());

        event.modify(BlockEntityType.BLAST_FURNACE, ModBlocks.BLACKSTONE_BLAST_FURNACE.get());
        event.modify(BlockEntityType.BLAST_FURNACE, ModBlocks.DEEPSLATE_BLAST_FURNACE.get());

        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.SPRUCE_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.BIRCH_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.JUNGLE_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.ACACIA_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.DARK_OAK_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.CRIMSON_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.WARPED_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.MANGROVE_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.CHERRY_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.BAMBOO_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.PALE_OAK_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.SPRUCE_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.BIRCH_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.JUNGLE_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.ACACIA_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.DARK_OAK_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.CRIMSON_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.WARPED_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.MANGROVE_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.CHERRY_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.BAMBOO_SOUL_CAMPFIRE.get());
        event.modify(BlockEntityType.CAMPFIRE, ModBlocks.PALE_OAK_SOUL_CAMPFIRE.get());

        event.modify(BlockEntityType.BEEHIVE, ModBlocks.SPRUCE_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.BIRCH_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.JUNGLE_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.ACACIA_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.DARK_OAK_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.CRIMSON_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.WARPED_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.MANGROVE_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.CHERRY_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.BAMBOO_BEEHIVE.get());
        event.modify(BlockEntityType.BEEHIVE, ModBlocks.PALE_OAK_BEEHIVE.get());

        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.SPRUCE_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.BIRCH_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.JUNGLE_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.ACACIA_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.DARK_OAK_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.CRIMSON_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.WARPED_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.MANGROVE_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.CHERRY_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.BAMBOO_CHISELED_BOOKSHELF.get());
        event.modify(BlockEntityType.CHISELED_BOOKSHELF, ModBlocks.PALE_OAK_CHISELED_BOOKSHELF.get());

        event.modify(BlockEntityType.LECTERN, ModBlocks.SPRUCE_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.BIRCH_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.JUNGLE_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.ACACIA_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.DARK_OAK_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.CRIMSON_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.WARPED_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.MANGROVE_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.CHERRY_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.BAMBOO_LECTERN.get());
        event.modify(BlockEntityType.LECTERN, ModBlocks.PALE_OAK_LECTERN.get());

        event.modify(BlockEntityType.BREWING_STAND, ModBlocks.BLACKSTONE_BREWING_STAND.get());
        event.modify(BlockEntityType.BREWING_STAND, ModBlocks.DEEPSLATE_BREWING_STAND.get());

        event.modify(BlockEntityType.BARREL, ModBlocks.OAK_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.BIRCH_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.JUNGLE_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.ACACIA_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.DARK_OAK_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.CRIMSON_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.WARPED_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.MANGROVE_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.CHERRY_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.BAMBOO_BARREL.get());
        event.modify(BlockEntityType.BARREL, ModBlocks.PALE_OAK_BARREL.get());

        event.modify(BlockEntityType.DISPENSER, ModBlocks.BLACKSTONE_DISPENSER.get());
        event.modify(BlockEntityType.DISPENSER, ModBlocks.DEEPSLATE_DISPENSER.get());

        event.modify(BlockEntityType.DROPPER, ModBlocks.BLACKSTONE_DROPPER.get());
        event.modify(BlockEntityType.DROPPER, ModBlocks.DEEPSLATE_DROPPER.get());

        event.modify(BlockEntityType.CRAFTER, ModBlocks.SPRUCE_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.BIRCH_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.JUNGLE_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.ACACIA_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.DARK_OAK_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.CRIMSON_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.WARPED_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.MANGROVE_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.CHERRY_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.BAMBOO_CRAFTER.get());
        event.modify(BlockEntityType.CRAFTER, ModBlocks.PALE_OAK_CRAFTER.get());

        event.modify(BlockEntityType.CHEST, ModBlocks.SPRUCE_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.BIRCH_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.JUNGLE_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.ACACIA_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.DARK_OAK_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.CRIMSON_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.WARPED_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.MANGROVE_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.CHERRY_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.BAMBOO_CHEST.get());
        event.modify(BlockEntityType.CHEST, ModBlocks.PALE_OAK_CHEST.get());

        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.SPRUCE_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.BIRCH_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.JUNGLE_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.ACACIA_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.DARK_OAK_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.CRIMSON_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.WARPED_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.MANGROVE_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.CHERRY_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.BAMBOO_TRAPPED_CHEST.get());
        event.modify(BlockEntityType.TRAPPED_CHEST, ModBlocks.PALE_OAK_TRAPPED_CHEST.get());

    }
}
