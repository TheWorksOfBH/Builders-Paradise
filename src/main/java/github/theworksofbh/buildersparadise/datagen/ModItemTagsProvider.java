package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersParadise.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.PIGLIN_LOVED).add(ModItems.GOLD_DOOR.get()).add(ModItems.GOLD_TRAPDOOR.get()).add(ModItems.CUT_GOLD.get()).add(ModItems.CUT_GOLD_SLAB.get()).add(ModItems.CUT_GOLD_STAIRS.get());
        tag(ModItemTags.CHESTS).add(ModItems.OAK_CHEST.get()).add(ModItems.SPRUCE_CHEST.get()).add(ModItems.BIRCH_CHEST.get()).add(ModItems.JUNGLE_CHEST.get()).add(ModItems.ACACIA_CHEST.get()).add(ModItems.DARK_OAK_CHEST.get()).add(ModItems.CRIMSON_CHEST.get()).add(ModItems.WARPED_CHEST.get()).add(ModItems.MANGROVE_CHEST.get()).add(ModItems.CHERRY_CHEST.get()).add(ModItems.BAMBOO_CHEST.get()).add(ModItems.PALE_OAK_CHEST.get());
        tag(ModItemTags.DROPPERS).add(ModItems.STONE_DROPPER.get()).add(ModItems.BLACKSTONE_DROPPER.get()).add(ModItems.DEEPSLATE_DROPPER.get());
        tag(ModItemTags.CONCRETE).add(Items.WHITE_CONCRETE).add(Items.ORANGE_CONCRETE).add(Items.MAGENTA_CONCRETE).add(Items.LIGHT_BLUE_CONCRETE).add(Items.YELLOW_CONCRETE).add(Items.LIME_CONCRETE).add(Items.PINK_CONCRETE).add(Items.GRAY_CONCRETE).add(Items.LIGHT_GRAY_CONCRETE).add(Items.CYAN_CONCRETE).add(Items.PURPLE_CONCRETE).add(Items.BLUE_CONCRETE).add(Items.BROWN_CONCRETE).add(Items.GREEN_CONCRETE).add(Items.RED_CONCRETE).add(Items.BLACK_CONCRETE);
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(ModItems.BRONZE_INGOT.get()).add(ModItems.SILVER_INGOT.get()).add(ModItems.PLATINUM_INGOT.get());
        tag(ModItemTags.BRONZE_TOOL_MATERIALS).add(ModItems.BRONZE_INGOT.get());
        tag(ModItemTags.REPAIRS_BRONZE_ARMOR).addTag(ModItemTags.BRONZE_TOOL_MATERIALS);
        tag(ModItemTags.BARRELS).add(ModItems.OAK_BARREL.get()).add(ModItems.SPRUCE_BARREL.get()).add(ModItems.BIRCH_BARREL.get()).add(ModItems.JUNGLE_BARREL.get()).add(ModItems.ACACIA_BARREL.get()).add(ModItems.DARK_OAK_BARREL.get()).add(ModItems.CRIMSON_BARREL.get()).add(ModItems.WARPED_BARREL.get()).add(ModItems.MANGROVE_BARREL.get()).add(ModItems.CHERRY_BARREL.get()).add(ModItems.BAMBOO_BARREL.get()).add(ModItems.PALE_OAK_BARREL.get());
    }
}
