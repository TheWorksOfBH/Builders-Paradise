package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
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

        if (ModList.get().isLoaded("biomesoplenty")) {
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.DEAD_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.DEAD_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.DEAD_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.DEAD_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.DEAD_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.DEAD_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.DEAD_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.DEAD_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.DEAD_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.DEAD_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.EMPYREAL_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.EMPYREAL_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.EMPYREAL_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.EMPYREAL_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.EMPYREAL_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.EMPYREAL_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.EMPYREAL_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.EMPYREAL_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.EMPYREAL_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.EMPYREAL_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.FIR_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.FIR_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.FIR_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.FIR_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.FIR_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.FIR_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.FIR_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.FIR_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.FIR_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.FIR_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.HELLBARK_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.HELLBARK_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.HELLBARK_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.HELLBARK_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.HELLBARK_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.HELLBARK_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.HELLBARK_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.HELLBARK_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.HELLBARK_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.HELLBARK_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.JACARANDA_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.JACARANDA_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.JACARANDA_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.JACARANDA_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.JACARANDA_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.JACARANDA_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.JACARANDA_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.JACARANDA_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.JACARANDA_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.JACARANDA_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAGIC_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAGIC_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAGIC_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.MAGIC_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.MAGIC_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.MAGIC_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.MAGIC_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.MAGIC_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.MAGIC_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.MAGIC_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAHOGANY_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAHOGANY_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAHOGANY_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.MAHOGANY_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.MAHOGANY_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.MAHOGANY_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.MAHOGANY_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.MAHOGANY_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.MAHOGANY_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.MAHOGANY_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAPLE_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAPLE_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.MAPLE_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.MAPLE_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.MAPLE_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.MAPLE_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.MAPLE_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.MAPLE_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.MAPLE_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.MAPLE_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PALM_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PALM_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PALM_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.PALM_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.PALM_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.PALM_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.PALM_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.PALM_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.PALM_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.PALM_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PINE_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PINE_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.PINE_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.PINE_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.PINE_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.PINE_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.PINE_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.PINE_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.PINE_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.PINE_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.REDWOOD_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.REDWOOD_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.REDWOOD_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.REDWOOD_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.REDWOOD_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.REDWOOD_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.REDWOOD_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.REDWOOD_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.REDWOOD_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.REDWOOD_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.UMBRAN_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.UMBRAN_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.UMBRAN_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.UMBRAN_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.UMBRAN_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.UMBRAN_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.UMBRAN_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.UMBRAN_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.UMBRAN_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.UMBRAN_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.SMOKER, CompatModBlocks.WILLOW_STONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.WILLOW_BLACKSTONE_SMOKER.get());
            event.modify(BlockEntityType.SMOKER, CompatModBlocks.WILLOW_DEEPSLATE_SMOKER.get());
            event.modify(BlockEntityType.BEEHIVE, CompatModBlocks.WILLOW_BEEHIVE.get());
            event.modify(BlockEntityType.CHISELED_BOOKSHELF, CompatModBlocks.WILLOW_CHISELED_BOOKSHELF.get());
            event.modify(BlockEntityType.LECTERN, CompatModBlocks.WILLOW_LECTERN.get());
            event.modify(BlockEntityType.BARREL, CompatModBlocks.WILLOW_BARREL.get());
            event.modify(BlockEntityType.CRAFTER, CompatModBlocks.WILLOW_CRAFTER.get());
            event.modify(BlockEntityType.CHEST, CompatModBlocks.WILLOW_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.WILLOW_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.CHEST, CompatModBlocks.ORIGIN_OAK_CHEST.get());
            event.modify(BlockEntityType.TRAPPED_CHEST, CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get());

            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.DEAD_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.EMPYREAL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.FIR_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.HELLBARK_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.JACARANDA_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAGIC_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAHOGANY_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAPLE_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.PALM_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.PINE_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.REDWOOD_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.UMBRAN_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.WILLOW_CAMPFIRE.get());

            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.DEAD_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.EMPYREAL_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.FIR_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.HELLBARK_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.JACARANDA_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAGIC_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAHOGANY_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.MAPLE_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.PALM_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.PINE_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.REDWOOD_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.UMBRAN_SOUL_CAMPFIRE.get());
            event.modify(BlockEntityType.CAMPFIRE, CompatModBlocks.WILLOW_SOUL_CAMPFIRE.get());
        }
    }
}
