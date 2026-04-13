package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModBannerPatterns {
    private static ResourceKey<BannerPattern> registerKey(String id) {
        return ResourceKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, id));
    }

    public static void register(BootstrapContext<BannerPattern> context, ResourceKey<BannerPattern> key) {
        System.out.println("Bootstrapping banner pattern " + key.identifier());
        context.register(key, new BannerPattern(key.identifier(), "block.minecraft.banner." + key.identifier().toShortLanguageKey().replace("buildersparadise.", "")));
    }

    public static final ResourceKey<BannerPattern> QUARTER_VERTICAL = registerKey("pattern_0");
    public static final ResourceKey<BannerPattern> QUARTER_VERTICAL_MIRROR = registerKey("pattern_1");
    public static final ResourceKey<BannerPattern> SIXTH_VERTICAL = registerKey("pattern_2");
    public static final ResourceKey<BannerPattern> SIXTH_VERTICAL_MIRROR = registerKey("pattern_3");
    public static final ResourceKey<BannerPattern> QUARTER_HORIZONTAL = registerKey("pattern_4");
    public static final ResourceKey<BannerPattern> QUARTER_HORIZONTAL_MIRROR = registerKey("pattern_5");
    public static final ResourceKey<BannerPattern> SIXTH_HORIZONTAL = registerKey("pattern_6");
    public static final ResourceKey<BannerPattern> SIXTH_HORIZONTAL_MIRROR = registerKey("pattern_7");
    public static final ResourceKey<BannerPattern> QUADRANT_TOP_LEFT = registerKey("pattern_8");
    public static final ResourceKey<BannerPattern> QUADRANT_TOP_RIGHT = registerKey("pattern_9");
    public static final ResourceKey<BannerPattern> QUADRANT_BOTTOM_LEFT = registerKey("pattern_10");
    public static final ResourceKey<BannerPattern> QUADRANT_BOTTOM_RIGHT = registerKey("pattern_11");
    public static final ResourceKey<BannerPattern> OFFSET_CROSS = registerKey("pattern_12");
    public static final ResourceKey<BannerPattern> OFFSET_CROSS_MIRROR = registerKey("pattern_13");
    public static final ResourceKey<BannerPattern> HALF_CROSS = registerKey("pattern_14");
    public static final ResourceKey<BannerPattern> HALF_CROSS_MIRROR = registerKey("pattern_15");
    public static final ResourceKey<BannerPattern> LONG_TRIANGLE = registerKey("pattern_16");
    public static final ResourceKey<BannerPattern> LONG_TRIANGLE_MIRROR = registerKey("pattern_17");
    public static final ResourceKey<BannerPattern> STRIPE_LONG = registerKey("pattern_18");
    public static final ResourceKey<BannerPattern> STRIPE_DIAGONAL = registerKey("pattern_19");
    public static final ResourceKey<BannerPattern> STRIPE_DIAGONAL_MIRROR = registerKey("pattern_20");
    public static final ResourceKey<BannerPattern> CHECKER = registerKey("pattern_21");
    public static final ResourceKey<BannerPattern> CHECKER_MIRROR = registerKey("pattern_22");
    public static final ResourceKey<BannerPattern> BIG_RHOMBUS_MIDDLE = registerKey("pattern_23");
    public static final ResourceKey<BannerPattern> BIG_OUTLINE_STAR_5 = registerKey("pattern_24");
    public static final ResourceKey<BannerPattern> BIG_FULL_STAR_5 = registerKey("pattern_25");
    public static final ResourceKey<BannerPattern> BIG_OUTLINE_STAR_6 = registerKey("pattern_26");
    public static final ResourceKey<BannerPattern> BIG_FULL_STAR_6 = registerKey("pattern_27");
    public static final ResourceKey<BannerPattern> SMALL_OUTLINE_STAR_5 = registerKey("pattern_28");
    public static final ResourceKey<BannerPattern> SMALL_FULL_STAR_5 = registerKey("pattern_29");
    public static final ResourceKey<BannerPattern> SMALL_OUTLINE_STAR_6 = registerKey("pattern_30");
    public static final ResourceKey<BannerPattern> SMALL_FULL_STAR_6 = registerKey("pattern_31");
    public static final ResourceKey<BannerPattern> TOP_CANTON_STAR_5 = registerKey("pattern_32");
    public static final ResourceKey<BannerPattern> TOP_LEFT_CANTON_STAR_5 = registerKey("pattern_33");
    public static final ResourceKey<BannerPattern> TOP_RIGHT_CANTON_STAR_5 = registerKey("pattern_34");
    public static final ResourceKey<BannerPattern> BOTTOM_CANTON_STAR_5 = registerKey("pattern_35");
    public static final ResourceKey<BannerPattern> BOTTOM_LEFT_CANTON_STAR_5 = registerKey("pattern_36");
    public static final ResourceKey<BannerPattern> BOTTOM_RIGHT_CANTON_STAR_5 = registerKey("pattern_37");
    public static final ResourceKey<BannerPattern> HEART = registerKey("pattern_38");
    public static final ResourceKey<BannerPattern> DIAMOND = registerKey("pattern_39");
    public static final ResourceKey<BannerPattern> TOP_CANTON_STAR_6 = registerKey("pattern_40");
    public static final ResourceKey<BannerPattern> TOP_LEFT_CANTON_STAR_6 = registerKey("pattern_41");
    public static final ResourceKey<BannerPattern> TOP_RIGHT_CANTON_STAR_6 = registerKey("pattern_42");
    public static final ResourceKey<BannerPattern> BOTTOM_CANTON_STAR_6 = registerKey("pattern_43");
    public static final ResourceKey<BannerPattern> BOTTOM_LEFT_CANTON_STAR_6 = registerKey("pattern_44");
    public static final ResourceKey<BannerPattern> BOTTOM_RIGHT_CANTON_STAR_6 = registerKey("pattern_45");
    public static final ResourceKey<BannerPattern> SPADE = registerKey("pattern_46");
    public static final ResourceKey<BannerPattern> CLUB = registerKey("pattern_47");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_TOP_LEFT = registerKey("pattern_48");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_TOP_RIGHT = registerKey("pattern_49");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_BOTTOM_LEFT = registerKey("pattern_50");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_BOTTOM_RIGHT = registerKey("pattern_51");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_VERTICAL = registerKey("pattern_52");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_VERTICAL_MIRROR = registerKey("pattern_53");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_HORIZONTAL = registerKey("pattern_54");
    public static final ResourceKey<BannerPattern> HALF_STRIPE_HORIZONTAL_MIRROR = registerKey("pattern_55");

    public static void bootstrap(BootstrapContext<BannerPattern> context) {
        register(context, QUARTER_VERTICAL);
        register(context, QUARTER_VERTICAL_MIRROR);
        register(context, SIXTH_VERTICAL);
        register(context, SIXTH_VERTICAL_MIRROR);
        register(context, QUARTER_HORIZONTAL);
        register(context, QUARTER_HORIZONTAL_MIRROR);
        register(context, SIXTH_HORIZONTAL);
        register(context, SIXTH_HORIZONTAL_MIRROR);
        register(context, QUADRANT_TOP_LEFT);
        register(context, QUADRANT_TOP_RIGHT);
        register(context, QUADRANT_BOTTOM_LEFT);
        register(context, QUADRANT_BOTTOM_RIGHT);
        register(context, OFFSET_CROSS);
        register(context, OFFSET_CROSS_MIRROR);
        register(context, HALF_CROSS);
        register(context, HALF_CROSS_MIRROR);
        register(context, LONG_TRIANGLE);
        register(context, LONG_TRIANGLE_MIRROR);
        register(context, STRIPE_LONG);
        register(context, STRIPE_DIAGONAL);
        register(context, STRIPE_DIAGONAL_MIRROR);
        register(context, CHECKER);
        register(context, CHECKER_MIRROR);
        register(context, BIG_RHOMBUS_MIDDLE);
        register(context, BIG_OUTLINE_STAR_5);
        register(context, BIG_FULL_STAR_5);
        register(context, BIG_OUTLINE_STAR_6);
        register(context, BIG_FULL_STAR_6);
        register(context, SMALL_OUTLINE_STAR_5);
        register(context, SMALL_FULL_STAR_5);
        register(context, SMALL_OUTLINE_STAR_6);
        register(context, SMALL_FULL_STAR_6);
        register(context, TOP_CANTON_STAR_5);
        register(context, TOP_LEFT_CANTON_STAR_5);
        register(context, TOP_RIGHT_CANTON_STAR_5);
        register(context, BOTTOM_CANTON_STAR_5);
        register(context, BOTTOM_LEFT_CANTON_STAR_5);
        register(context, BOTTOM_RIGHT_CANTON_STAR_5);
        register(context, HEART);
        register(context, DIAMOND);
        register(context, TOP_CANTON_STAR_6);
        register(context, TOP_LEFT_CANTON_STAR_6);
        register(context, TOP_RIGHT_CANTON_STAR_6);
        register(context, BOTTOM_CANTON_STAR_6);
        register(context, BOTTOM_LEFT_CANTON_STAR_6);
        register(context, BOTTOM_RIGHT_CANTON_STAR_6);
        register(context, SPADE);
        register(context, CLUB);
        register(context, HALF_STRIPE_TOP_LEFT);
        register(context, HALF_STRIPE_TOP_RIGHT);
        register(context, HALF_STRIPE_BOTTOM_LEFT);
        register(context, HALF_STRIPE_BOTTOM_RIGHT);
        register(context, HALF_STRIPE_VERTICAL);
        register(context, HALF_STRIPE_VERTICAL_MIRROR);
        register(context, HALF_STRIPE_HORIZONTAL);
        register(context, HALF_STRIPE_HORIZONTAL_MIRROR);
    }
}
