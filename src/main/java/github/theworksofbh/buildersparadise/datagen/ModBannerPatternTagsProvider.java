package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBannerPatterns;
import github.theworksofbh.buildersparadise.tags.ModBannerPatternTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.tags.BannerPatternTags;

import java.util.concurrent.CompletableFuture;

public class ModBannerPatternTagsProvider extends BannerPatternTagsProvider {
    public ModBannerPatternTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersParadise.MODID);
    }

    protected void addTags(HolderLookup.Provider registries) {
        tag(BannerPatternTags.NO_ITEM_REQUIRED)
                .add(ModBannerPatterns.QUARTER_VERTICAL)
                .add(ModBannerPatterns.QUARTER_VERTICAL_MIRROR)
                .add(ModBannerPatterns.SIXTH_VERTICAL)
                .add(ModBannerPatterns.SIXTH_VERTICAL_MIRROR)
                .add(ModBannerPatterns.QUARTER_HORIZONTAL)
                .add(ModBannerPatterns.QUARTER_HORIZONTAL_MIRROR)
                .add(ModBannerPatterns.SIXTH_HORIZONTAL)
                .add(ModBannerPatterns.SIXTH_HORIZONTAL_MIRROR)
                .add(ModBannerPatterns.QUADRANT_TOP_LEFT)
                .add(ModBannerPatterns.QUADRANT_TOP_RIGHT)
                .add(ModBannerPatterns.QUADRANT_BOTTOM_LEFT)
                .add(ModBannerPatterns.QUADRANT_BOTTOM_RIGHT)
                .add(ModBannerPatterns.OFFSET_CROSS)
                .add(ModBannerPatterns.OFFSET_CROSS_MIRROR)
                .add(ModBannerPatterns.HALF_CROSS)
                .add(ModBannerPatterns.HALF_CROSS_MIRROR)
                .add(ModBannerPatterns.LONG_TRIANGLE)
                .add(ModBannerPatterns.LONG_TRIANGLE_MIRROR)
                .add(ModBannerPatterns.STRIPE_LONG)
                .add(ModBannerPatterns.STRIPE_DIAGONAL)
                .add(ModBannerPatterns.STRIPE_DIAGONAL_MIRROR)
                .add(ModBannerPatterns.CHECKER)
                .add(ModBannerPatterns.CHECKER_MIRROR)
                .add(ModBannerPatterns.BIG_RHOMBUS_MIDDLE)
                .add(ModBannerPatterns.BIG_OUTLINE_STAR_5)
                .add(ModBannerPatterns.BIG_FULL_STAR_5)
                .add(ModBannerPatterns.BIG_OUTLINE_STAR_6)
                .add(ModBannerPatterns.BIG_FULL_STAR_6)
                .add(ModBannerPatterns.SMALL_OUTLINE_STAR_5)
                .add(ModBannerPatterns.SMALL_FULL_STAR_5)
                .add(ModBannerPatterns.SMALL_OUTLINE_STAR_6)
                .add(ModBannerPatterns.SMALL_FULL_STAR_6)
                .add(ModBannerPatterns.TOP_CANTON_STAR_5)
                .add(ModBannerPatterns.TOP_LEFT_CANTON_STAR_5)
                .add(ModBannerPatterns.TOP_RIGHT_CANTON_STAR_5)
                .add(ModBannerPatterns.BOTTOM_CANTON_STAR_5)
                .add(ModBannerPatterns.BOTTOM_LEFT_CANTON_STAR_5)
                .add(ModBannerPatterns.BOTTOM_RIGHT_CANTON_STAR_5)
                .add(ModBannerPatterns.TOP_CANTON_STAR_6)
                .add(ModBannerPatterns.TOP_LEFT_CANTON_STAR_6)
                .add(ModBannerPatterns.TOP_RIGHT_CANTON_STAR_6)
                .add(ModBannerPatterns.BOTTOM_CANTON_STAR_6)
                .add(ModBannerPatterns.BOTTOM_LEFT_CANTON_STAR_6)
                .add(ModBannerPatterns.BOTTOM_RIGHT_CANTON_STAR_6)
                .add(ModBannerPatterns.HALF_STRIPE_TOP_LEFT)
                .add(ModBannerPatterns.HALF_STRIPE_TOP_RIGHT)
                .add(ModBannerPatterns.HALF_STRIPE_BOTTOM_LEFT)
                .add(ModBannerPatterns.HALF_STRIPE_BOTTOM_RIGHT)
                .add(ModBannerPatterns.HALF_STRIPE_VERTICAL)
                .add(ModBannerPatterns.HALF_STRIPE_VERTICAL_MIRROR)
                .add(ModBannerPatterns.HALF_STRIPE_HORIZONTAL)
                .add(ModBannerPatterns.HALF_STRIPE_HORIZONTAL_MIRROR);

        tag(ModBannerPatternTags.PATTERN_ITEM_HEART).add(ModBannerPatterns.HEART);
        tag(ModBannerPatternTags.PATTERN_ITEM_DIAMOND).add(ModBannerPatterns.DIAMOND);
        tag(ModBannerPatternTags.PATTERN_ITEM_SPADE).add(ModBannerPatterns.SPADE);
        tag(ModBannerPatternTags.PATTERN_ITEM_CLUB).add(ModBannerPatterns.CLUB);
    }
}