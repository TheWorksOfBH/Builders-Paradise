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

    }
}
