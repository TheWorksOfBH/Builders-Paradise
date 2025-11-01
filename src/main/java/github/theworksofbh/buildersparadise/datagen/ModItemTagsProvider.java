package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersParadise.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.PIGLIN_LOVED).add(ModItems.GOLD_DOOR.get()).add(ModItems.GOLD_TRAPDOOR.get()).add(ModItems.GOLD_TILES.get()).add(ModItems.GOLD_TILE_SLAB.get()).add(ModItems.GOLD_TILE_STAIRS.get());
        tag(ModItemTags.CHESTS).add(ModItems.OAK_CHEST.get()).add(ModItems.SPRUCE_CHEST.get()).add(ModItems.BIRCH_CHEST.get()).add(ModItems.JUNGLE_CHEST.get()).add(ModItems.ACACIA_CHEST.get()).add(ModItems.DARK_OAK_CHEST.get()).add(ModItems.CRIMSON_CHEST.get()).add(ModItems.WARPED_CHEST.get()).add(ModItems.MANGROVE_CHEST.get()).add(ModItems.CHERRY_CHEST.get()).add(ModItems.BAMBOO_CHEST.get()).add(ModItems.PALE_OAK_CHEST.get());
        tag(ModItemTags.DROPPERS).add(ModItems.STONE_DROPPER.get()).add(ModItems.BLACKSTONE_DROPPER.get()).add(ModItems.DEEPSLATE_DROPPER.get());
    }
}
