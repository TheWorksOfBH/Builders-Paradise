package github.theworksofbh.buildersparadise.tags;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public final class ModBannerPatternTags {

    public static final TagKey<BannerPattern> PATTERN_ITEM_HEART = create("pattern_item_heart");
    public static final TagKey<BannerPattern> PATTERN_ITEM_DIAMOND = create("pattern_item_diamond");
    public static final TagKey<BannerPattern> PATTERN_ITEM_SPADE = create("pattern_item_spade");
    public static final TagKey<BannerPattern> PATTERN_ITEM_CLUB = create("pattern_item_club");


    private ModBannerPatternTags() {
    }

    private static TagKey<BannerPattern> create(String name) {
        return TagKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static TagKey<BannerPattern> create(Identifier name) {
        return TagKey.create(Registries.BANNER_PATTERN, name);
    }
}
