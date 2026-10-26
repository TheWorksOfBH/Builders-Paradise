package github.theworksofbh.buildersparadise.datagen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.ModBlockFamilies;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.collections.CorrodingZincCollection;
import github.theworksofbh.buildersparadise.blocks.collections.RustingIronCollection;
import github.theworksofbh.buildersparadise.blocks.types.*;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipeBuilder;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.minecraft.advancements.predicates.MinMaxBounds;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider {
    public static final ImmutableList<ItemLike> ZINC_SMELTABLES = ImmutableList.of(ModBlocks.ZINC_ORE, ModBlocks.DEEPSLATE_ZINC_ORE, ModItems.RAW_ZINC);
    public static final ImmutableList<ItemLike> SILVER_SMELTABLES = ImmutableList.of(ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER);
    public static final ImmutableList<ItemLike> TIN_SMELTABLES = ImmutableList.of(ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN);
    public static final ImmutableList<ItemLike> TUNGSTEN_SMELTABLES = ImmutableList.of(ModBlocks.TUNGSTEN_ORE, ModBlocks.DEEPSLATE_TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN);
    public static final ImmutableList<ItemLike> PLATINUM_SMELTABLES = ImmutableList.of(ModBlocks.PLATINUM_ORE, ModBlocks.DEEPSLATE_PLATINUM_ORE, ModItems.RAW_PLATINUM);
    public static final ImmutableList<ItemLike> LEAD_SMELTABLES = ImmutableList.of(ModBlocks.LEAD_ORE, ModBlocks.DEEPSLATE_LEAD_ORE, ModItems.RAW_LEAD);
    public static final ImmutableList<ItemLike> BISMUTH_SMELTABLES = ImmutableList.of(ModBlocks.BISMUTH_ORE, ModBlocks.DEEPSLATE_BISMUTH_ORE, ModItems.RAW_BISMUTH);
    public static final ImmutableList<ItemLike> URANIUM_SMELTABLES = ImmutableList.of(ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE, ModItems.RAW_URANIUM);
    public static final ImmutableList<ItemLike> MONOCRYSTAL_SMELTABLES = ImmutableList.of(ModBlocks.NETHER_MONOCRYSTAL_ORE);
    public static final ImmutableList<ItemLike> RUBY_SMELTABLES = ImmutableList.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
    public static final ImmutableList<ItemLike> SAPPHIRE_SMELTABLES = ImmutableList.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

    public static final List<RustingIronCollection<Block>> RUSTING_IRON_COLLECTIONS = List.of(
            ModBlocks.IRON_BLOCK,
            ModBlocks.IRON_GRATE,
            ModBlocks.CUT_IRON,
            ModBlocks.CUT_IRON_STAIRS,
            ModBlocks.CUT_IRON_SLAB,
            ModBlocks.IRON_BARS,
            ModBlocks.IRON_DOOR,
            ModBlocks.IRON_TRAPDOOR,
            ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.IRON_CHAIN,
            ModBlocks.IRON_LANTERN,
            ModBlocks.IRON_SOUL_LANTERN,
            ModBlocks.IRON_FIRE_LANTERN
    );

    public static final List<WeatheringCopperCollection<Block>> WEATHERING_COPPER_COLLECTIONS = List.of(
            ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.COPPER_SOUL_LANTERN,
            ModBlocks.COPPER_FIRE_LANTERN
    );

    public static final List<CorrodingZincCollection<Block>> CORRODING_ZINC_COLLECTIONS = List.of(
            ModBlocks.ZINC_BLOCK,
            ModBlocks.ZINC_GRATE,
            ModBlocks.CUT_ZINC,
            ModBlocks.CUT_ZINC_STAIRS,
            ModBlocks.CUT_ZINC_SLAB,
            ModBlocks.ZINC_DOOR,
            ModBlocks.ZINC_TRAPDOOR,
            ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE,
            ModBlocks.ZINC_CHAIN,
            ModBlocks.ZINC_LANTERN,
            ModBlocks.ZINC_SOUL_LANTERN,
            ModBlocks.ZINC_FIRE_LANTERN
    );

    @FunctionalInterface
    interface ModFamilyRecipeProvider {
        RecipeBuilder create(ModRecipesProvider var1, ItemLike var2, ItemLike var3);
    }

    protected ModRecipesProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    private static final Map<Variant, ModFamilyRecipeProvider> SHAPE_BUILDERS = ImmutableMap.<Variant, ModFamilyRecipeProvider>builder()
            .put(Variant.BUTTON, (ModFamilyRecipeProvider)(context, result, base) -> context.buttonBuilder(result, Ingredient.of(base)))
            .put(Variant.CHISELED, (ModFamilyRecipeProvider)(context, result, base) -> context.chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, result, Ingredient.of(base)))
            .put(Variant.CUT, (ModFamilyRecipeProvider)(context, result, base) -> context.cutBuilder(RecipeCategory.BUILDING_BLOCKS, result, Ingredient.of(base)))
            .put(Variant.DOOR, (ModFamilyRecipeProvider)(context, result, base) -> context.doorBuilder(result, Ingredient.of(base)))
            .put(Variant.CUSTOM_FENCE, (ModFamilyRecipeProvider)(context, result, base) -> context.fenceBuilder(result, Ingredient.of(base)))
            .put(Variant.FENCE, (ModFamilyRecipeProvider)(context, result, base) -> context.fenceBuilder(result, Ingredient.of(base)))
            .put(Variant.CUSTOM_FENCE_GATE, (ModFamilyRecipeProvider)(context, result, base) -> context.fenceGateBuilder(result, Ingredient.of(base)))
            .put(Variant.FENCE_GATE, (ModFamilyRecipeProvider)(context, result, base) -> context.fenceGateBuilder(result, Ingredient.of(base)))
            .put(Variant.SIGN, (ModFamilyRecipeProvider)(context, result, base) -> context.signBuilder(result, Ingredient.of(base)))
            .put(Variant.SLAB, (ModFamilyRecipeProvider)(context, result, base) -> context.slabBuilder(RecipeCategory.BUILDING_BLOCKS, result, Ingredient.of(base)))
            .put(Variant.STAIRS, (ModFamilyRecipeProvider)(context, result, base) -> context.stairBuilder(result, Ingredient.of(base)))
            .put(Variant.PRESSURE_PLATE, (ModFamilyRecipeProvider)(context, result, base) -> context.pressurePlateBuilder(RecipeCategory.REDSTONE, result, Ingredient.of(base)))
            .put(Variant.POLISHED, (ModFamilyRecipeProvider)(context, result, base) -> context.polishedBuilder(RecipeCategory.BUILDING_BLOCKS, result, Ingredient.of(base)))
            .put(Variant.TRAPDOOR, (ModFamilyRecipeProvider)(context, result, base) -> context.trapdoorBuilder(result, Ingredient.of(base)))
            .put(Variant.WALL, (ModFamilyRecipeProvider)(context, result, base) -> context.wallBuilder(RecipeCategory.DECORATIONS, result, Ingredient.of(base)))
            .build();


    @Override
    protected void generateRecipes(final BlockFamily family, final FeatureFlagSet flagSet) {
        family.getVariants().forEach((variant, result) -> {
            if (result.requiredFeatures().isSubsetOf(flagSet)) {
                ModFamilyRecipeProvider recipeFunction = (ModFamilyRecipeProvider)SHAPE_BUILDERS.get(variant);
                ItemLike base = this.getBaseBlockForCrafting(family, variant);
                if (recipeFunction != null) {
                    RecipeBuilder builder = recipeFunction.create(this, result, base);
                    family.getRecipeGroupPrefix().ifPresent(prefix -> builder.group(prefix + (variant == Variant.CUT ? "" : "_" + variant.getRecipeGroup())));
                    builder.unlockedBy((String)family.getRecipeUnlockedBy().orElseGet(() -> getHasName(base)), this.has(base));
                    builder.save(this.output);
                }

                if (variant == Variant.CRACKED) {
                    this.smeltingResultFromBase(result, base);
                }
            }
        });
    }

    protected void buildRecipes() {
        this.output.includeRootAdvancement();
        generateForEnabledBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA));
        stoneCuttingRecipes();
        waxedBlocks();
        doorBuilder(ModBlocks.GOLD_DOOR, Ingredient.of(Items.GOLD_INGOT)).unlockedBy(getHasName(Items.GOLD_INGOT), this.has(Items.GOLD_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.GOLD_TRAPDOOR, Items.GOLD_INGOT);
        pressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), Items.COPPER_INGOT);
        doorBuilder(ModBlocks.NETHERITE_DOOR, Ingredient.of(Items.NETHERITE_INGOT)).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.NETHERITE_TRAPDOOR, Items.NETHERITE_INGOT);
        pressurePlate(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE, Items.NETHERITE_INGOT);
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BLOCK, getSimpleRecipeName(ModBlocks.CHARCOAL_BLOCK), null, getSimpleRecipeName(Items.CHARCOAL) + "_b", null);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE, Items.SOUL_SAND);
        smeltingResultFromBase(ModBlocks.SMOOTH_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE, ModItems.ELDER_PRISMARINE_SHARD);
        threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE_BRICKS, ModItems.ELDER_PRISMARINE_SHARD);
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_ELDER_PRISMARINE)
                .define('S', ModItems.ELDER_PRISMARINE_SHARD)
                .define('I', Items.DYE.black())
                .pattern("SSS")
                .pattern("SIS")
                .pattern("SSS")
                .unlockedBy("has_elder_prismarine_shard", this.has(ModItems.ELDER_PRISMARINE_SHARD))
                .save(this.output);
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_SEA_LANTERN)
                .define('S', ModItems.ELDER_PRISMARINE_SHARD)
                .define('C', ModItems.ELDER_PRISMARINE_CRYSTALS)
                .pattern("SCS")
                .pattern("CCC")
                .pattern("SCS")
                .unlockedBy("has_elder_prismarine_crystals", this.has(ModItems.ELDER_PRISMARINE_CRYSTALS))
                .save(this.output);
        this.shapeless(RecipeCategory.MISC, ModItems.NETHERITE_NUGGET, 9).requires(Items.NETHERITE_INGOT).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        this.shaped(RecipeCategory.MISC, Items.NETHERITE_INGOT).define('#', ModItems.NETHERITE_NUGGET).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(ModItems.NETHERITE_NUGGET), this.has(ModItems.NETHERITE_NUGGET)).save(this.output, "netherite_ingot_from_nugget");
        oreSmelting(ZINC_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ZINC_INGOT, 1.0F, 200, "zinc_ingot");
        oreBlasting(ZINC_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ZINC_INGOT, 1.0F, 100, "zinc_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.ZINC_NUGGET,
                RecipeCategory.MISC,
                ModItems.ZINC_INGOT,
                "zinc_ingot",
                null,
                "zinc_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ZINC_BLOCK.weathering().unaffected(),
                "zinc_block",
                null);
        doorBuilder(ModBlocks.ZINC_DOOR.weathering().unaffected(), Ingredient.of(ModItems.ZINC_INGOT)).unlockedBy(getHasName(ModItems.ZINC_INGOT), this.has(ModItems.ZINC_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.ZINC_TRAPDOOR.weathering().unaffected(), ModItems.ZINC_INGOT);
        pressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), ModItems.ZINC_INGOT);

        oreSmelting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0F, 200, "silver_ingot");
        oreBlasting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT, 1.0F, 100, "silver_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.SILVER_NUGGET,
                RecipeCategory.MISC,
                ModItems.SILVER_INGOT,
                "silver_ingot",
                null,
                "silver_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SILVER_BLOCK,
                "silver_block",
                null);
        doorBuilder(ModBlocks.SILVER_DOOR, Ingredient.of(ModItems.SILVER_INGOT)).unlockedBy(getHasName(ModItems.SILVER_INGOT), this.has(ModItems.SILVER_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.SILVER_TRAPDOOR, ModItems.SILVER_INGOT);
        pressurePlate(ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModItems.SILVER_INGOT);

        oreSmelting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT, 1.0F, 200, "tin_ingot");
        oreBlasting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT, 1.0F, 100, "tin_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.TIN_NUGGET,
                RecipeCategory.MISC,
                ModItems.TIN_INGOT,
                "tin_ingot",
                null,
                "tin_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.TIN_BLOCK,
                "tin_block",
                null);
        doorBuilder(ModBlocks.TIN_DOOR, Ingredient.of(ModItems.TIN_INGOT)).unlockedBy(getHasName(ModItems.TIN_INGOT), this.has(ModItems.TIN_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.TIN_TRAPDOOR, ModItems.TIN_INGOT);
        pressurePlate(ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModItems.TIN_INGOT);

        oreSmelting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TUNGSTEN_INGOT, 1.0F, 200, "tungsten_ingot");
        oreBlasting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TUNGSTEN_INGOT, 1.0F, 100, "tungsten_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_NUGGET,
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT,
                "tungsten_ingot",
                null,
                "tungsten_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.TUNGSTEN_BLOCK,
                "tungsten_block",
                null);
        doorBuilder(ModBlocks.TUNGSTEN_DOOR, Ingredient.of(ModItems.TUNGSTEN_INGOT)).unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT), this.has(ModItems.TUNGSTEN_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.TUNGSTEN_TRAPDOOR, ModItems.TUNGSTEN_INGOT);
        pressurePlate(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE, ModItems.TUNGSTEN_INGOT);

        oreSmelting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PLATINUM_INGOT, 1.0F, 200, "platinum_ingot");
        oreBlasting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PLATINUM_INGOT, 1.0F, 100, "platinum_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.PLATINUM_NUGGET,
                RecipeCategory.MISC,
                ModItems.PLATINUM_INGOT,
                "platinum_ingot",
                null,
                "platinum_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.PLATINUM_BLOCK,
                "platinum_block",
                null);
        doorBuilder(ModBlocks.PLATINUM_DOOR, Ingredient.of(ModItems.PLATINUM_INGOT)).unlockedBy(getHasName(ModItems.PLATINUM_INGOT), this.has(ModItems.PLATINUM_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.PLATINUM_TRAPDOOR, ModItems.PLATINUM_INGOT);
        pressurePlate(ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModItems.PLATINUM_INGOT);

        oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1.0F, 200, "lead_ingot");
        oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT, 1.0F, 100, "lead_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.LEAD_NUGGET,
                RecipeCategory.MISC,
                ModItems.LEAD_INGOT,
                "lead_ingot",
                null,
                "lead_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.LEAD_BLOCK,
                "lead_block",
                null);
        doorBuilder(ModBlocks.LEAD_DOOR, Ingredient.of(ModItems.LEAD_INGOT)).unlockedBy(getHasName(ModItems.LEAD_INGOT), this.has(ModItems.LEAD_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.LEAD_TRAPDOOR, ModItems.LEAD_INGOT);
        pressurePlate(ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE, ModItems.LEAD_INGOT);


        oreSmelting(URANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.URANIUM_INGOT, 1.0F, 200, "uranium_ingot");
        oreBlasting(URANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.URANIUM_INGOT, 1.0F, 100, "uranium_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.URANIUM_NUGGET,
                RecipeCategory.MISC,
                ModItems.URANIUM_INGOT,
                "uranium_ingot",
                null,
                "uranium_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.URANIUM_BLOCK,
                "uranium_block",
                null);
        doorBuilder(ModBlocks.URANIUM_DOOR, Ingredient.of(ModItems.URANIUM_INGOT)).unlockedBy(getHasName(ModItems.URANIUM_INGOT), this.has(ModItems.URANIUM_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.URANIUM_TRAPDOOR, ModItems.URANIUM_INGOT);
        pressurePlate(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE, ModItems.URANIUM_INGOT);

        smeltingResultFromBase(ModItems.URANIUM_NUGGET, Items.REDSTONE);

        shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT)
                .requires(Items.COPPER_INGOT, 4)
                .requires(ModItems.TIN_INGOT, 4)
                .group("bronze_ingot")
                .unlockedBy("has_tin_ingot", this.has(ModItems.TIN_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET,
                RecipeCategory.MISC,
                ModItems.BRONZE_INGOT,
                "bronze_ingot",
                null,
                "bronze_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.BRONZE_BLOCK,
                "bronze_block",
                null);
        doorBuilder(ModBlocks.BRONZE_DOOR, Ingredient.of(ModItems.BRONZE_INGOT)).unlockedBy(getHasName(ModItems.BRONZE_INGOT), this.has(ModItems.BRONZE_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.BRONZE_TRAPDOOR, ModItems.BRONZE_INGOT);
        pressurePlate(ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE, ModItems.BRONZE_INGOT);

        shapeless(RecipeCategory.MISC, ModItems.BRASS_INGOT)
                .requires(Items.COPPER_INGOT, 4)
                .requires(ModItems.ZINC_INGOT, 4)
                .group("brass_ingot")
                .unlockedBy("has_zinc_ingot", this.has(ModItems.ZINC_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.BRASS_NUGGET,
                RecipeCategory.MISC,
                ModItems.BRASS_INGOT,
                "brass_ingot",
                null,
                "brass_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.BRASS_BLOCK,
                "brass_block",
                null);
        doorBuilder(ModBlocks.BRASS_DOOR, Ingredient.of(ModItems.BRASS_INGOT)).unlockedBy(getHasName(ModItems.BRASS_INGOT), this.has(ModItems.BRASS_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.BRASS_TRAPDOOR, ModItems.BRASS_INGOT);
        pressurePlate(ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE, ModItems.BRASS_INGOT);

        shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT)
                .requires(Items.IRON_INGOT, 4)
                .requires(Ingredient.of(new Item[]{Items.COAL, Items.CHARCOAL, ModItems.CARBON_DUST}), 4)
                .group("steel_ingot")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.STEEL_NUGGET,
                RecipeCategory.MISC,
                ModItems.STEEL_INGOT,
                "steel_ingot",
                null,
                "steel_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.STEEL_BLOCK,
                "steel_block",
                null);
        doorBuilder(ModBlocks.STEEL_DOOR, Ingredient.of(ModItems.STEEL_INGOT)).unlockedBy(getHasName(ModItems.STEEL_INGOT), this.has(ModItems.STEEL_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.STEEL_TRAPDOOR, ModItems.STEEL_INGOT);
        pressurePlate(ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE, ModItems.STEEL_INGOT);
        shapeless(RecipeCategory.TOOLS, Items.FLINT_AND_STEEL)
                .requires(ModItems.STEEL_INGOT).requires(Items.FLINT)
                .unlockedBy("has_steel_ingot", this.has(ModItems.STEEL_INGOT))
                .unlockedBy("has_obsidian", this.has(Blocks.OBSIDIAN))
                .save(output, "flint_and_steel_alt");

        shaped(RecipeCategory.REDSTONE, ModBlocks.NUKE)
                .define('#', Ingredient.of(new Item[]{Items.SAND, Items.RED_SAND}))
                .define('X', ModItems.URANIUM_INGOT)
                .pattern("X#X")
                .pattern("#X#")
                .pattern("X#X")
                .unlockedBy("has_uranium_ingot", this.has(ModItems.URANIUM_INGOT)).save(this.output);

        this.createCraftingTable(Blocks.CRAFTING_TABLE, Items.OAK_PLANKS);
        this.createCraftingTable(ModBlocks.SPRUCE_CRAFTING_TABLE, Items.SPRUCE_PLANKS);
        this.createCraftingTable(ModBlocks.BIRCH_CRAFTING_TABLE, Items.BIRCH_PLANKS);
        this.createCraftingTable(ModBlocks.JUNGLE_CRAFTING_TABLE, Items.JUNGLE_PLANKS);
        this.createCraftingTable(ModBlocks.ACACIA_CRAFTING_TABLE, Items.ACACIA_PLANKS);
        this.createCraftingTable(ModBlocks.DARK_OAK_CRAFTING_TABLE, Items.DARK_OAK_PLANKS);
        this.createCraftingTable(ModBlocks.CRIMSON_CRAFTING_TABLE, Items.CRIMSON_PLANKS);
        this.createCraftingTable(ModBlocks.WARPED_CRAFTING_TABLE, Items.WARPED_PLANKS);
        this.createCraftingTable(ModBlocks.MANGROVE_CRAFTING_TABLE, Items.MANGROVE_PLANKS);
        this.createCraftingTable(ModBlocks.CHERRY_CRAFTING_TABLE, Items.CHERRY_PLANKS);
        this.createCraftingTable(ModBlocks.BAMBOO_CRAFTING_TABLE, Items.BAMBOO_PLANKS);
        this.createCraftingTable(ModBlocks.PALE_OAK_CRAFTING_TABLE, Items.PALE_OAK_PLANKS);

        this.createCartographyTable(ModBlocks.OAK_CARTOGRAPHY_TABLE, Items.OAK_PLANKS);
        this.createCartographyTable(ModBlocks.SPRUCE_CARTOGRAPHY_TABLE, Items.SPRUCE_PLANKS);
        this.createCartographyTable(ModBlocks.BIRCH_CARTOGRAPHY_TABLE, Items.BIRCH_PLANKS);
        this.createCartographyTable(ModBlocks.JUNGLE_CARTOGRAPHY_TABLE, Items.JUNGLE_PLANKS);
        this.createCartographyTable(ModBlocks.ACACIA_CARTOGRAPHY_TABLE, Items.ACACIA_PLANKS);
        this.createCartographyTable(Blocks.CARTOGRAPHY_TABLE, Items.DARK_OAK_PLANKS);
        this.createCartographyTable(ModBlocks.CRIMSON_CARTOGRAPHY_TABLE, Items.CRIMSON_PLANKS);
        this.createCartographyTable(ModBlocks.WARPED_CARTOGRAPHY_TABLE, Items.WARPED_PLANKS);
        this.createCartographyTable(ModBlocks.MANGROVE_CARTOGRAPHY_TABLE, Items.MANGROVE_PLANKS);
        this.createCartographyTable(ModBlocks.CHERRY_CARTOGRAPHY_TABLE, Items.CHERRY_PLANKS);
        this.createCartographyTable(ModBlocks.BAMBOO_CARTOGRAPHY_TABLE, Items.BAMBOO_PLANKS);
        this.createCartographyTable(ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE, Items.PALE_OAK_PLANKS);

        this.createFletchingTable(ModBlocks.OAK_FLETCHING_TABLE, Items.OAK_PLANKS);
        this.createFletchingTable(ModBlocks.SPRUCE_FLETCHING_TABLE, Items.SPRUCE_PLANKS);
        this.createFletchingTable(Blocks.FLETCHING_TABLE, Items.BIRCH_PLANKS);
        this.createFletchingTable(ModBlocks.JUNGLE_FLETCHING_TABLE, Items.JUNGLE_PLANKS);
        this.createFletchingTable(ModBlocks.ACACIA_FLETCHING_TABLE, Items.ACACIA_PLANKS);
        this.createFletchingTable(ModBlocks.DARK_OAK_FLETCHING_TABLE, Items.DARK_OAK_PLANKS);
        this.createFletchingTable(ModBlocks.CRIMSON_FLETCHING_TABLE, Items.CRIMSON_PLANKS);
        this.createFletchingTable(ModBlocks.WARPED_FLETCHING_TABLE, Items.WARPED_PLANKS);
        this.createFletchingTable(ModBlocks.MANGROVE_FLETCHING_TABLE, Items.MANGROVE_PLANKS);
        this.createFletchingTable(ModBlocks.CHERRY_FLETCHING_TABLE, Items.CHERRY_PLANKS);
        this.createFletchingTable(ModBlocks.BAMBOO_FLETCHING_TABLE, Items.BAMBOO_PLANKS);
        this.createFletchingTable(ModBlocks.PALE_OAK_FLETCHING_TABLE, Items.PALE_OAK_PLANKS);

        this.fletching(Items.SPECTRAL_ARROW, Items.ARROW, Items.GLOWSTONE_DUST);
        this.fletching(Items.TIPPED_ARROW, Items.ARROW, Items.LINGERING_POTION);

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_ZINC, RecipeCategory.MISC, ModBlocks.RAW_ZINC_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_SILVER, RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_TIN, RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_TUNGSTEN, RecipeCategory.MISC, ModBlocks.RAW_TUNGSTEN_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_PLATINUM, RecipeCategory.MISC, ModBlocks.RAW_PLATINUM_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_LEAD, RecipeCategory.MISC, ModBlocks.RAW_LEAD_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_BISMUTH, RecipeCategory.MISC, ModBlocks.RAW_BISMUTH_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_URANIUM, RecipeCategory.MISC, ModBlocks.RAW_URANIUM_BLOCK);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_SLAB), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, Items.STONE_SLAB, 0.1F, 200).unlockedBy("has_cobblestone_slab", this.has(Items.COBBLESTONE_SLAB)).save(this.output, "stone_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, Items.STONE_STAIRS, 0.1F, 200).unlockedBy("has_cobblestone_stairs", this.has(Items.COBBLESTONE_STAIRS)).save(this.output, "stone_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_WALL), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.STONE_WALL, 0.1F, 200).unlockedBy("has_cobblestone_wall", this.has(Items.COBBLESTONE_WALL)).save(this.output, "stone_wall_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.COBBLESTONE_FENCE), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.STONE_FENCE, 0.1F, 200).unlockedBy("has_cobblestone_fence", this.has(ModBlocks.COBBLESTONE_FENCE)).save(this.output, "stone_fence_smelting");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_SLAB), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.DEEPSLATE_SLAB, 0.1F, 200).unlockedBy("has_cobbled_deepslate_slab", this.has(Items.COBBLED_DEEPSLATE_SLAB)).save(this.output, "deepslate_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.DEEPSLATE_STAIRS, 0.1F, 200).unlockedBy("has_cobbled_deepslate_stairs", this.has(Items.COBBLED_DEEPSLATE_STAIRS)).save(this.output, "deepslate_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_WALL), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.DEEPSLATE_WALL, 0.1F, 200).unlockedBy("has_cobbled_deepslate_wall", this.has(Items.COBBLED_DEEPSLATE_WALL)).save(this.output, "deepslate_wall_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.COBBLED_DEEPSLATE_FENCE), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.DEEPSLATE_FENCE, 0.1F, 200).unlockedBy("has_cobbled_deepslate_fence", this.has(ModBlocks.COBBLED_DEEPSLATE_FENCE)).save(this.output, "deepslate_fence_smelting");

        this.createSmithingTable(ModBlocks.OAK_SMITHING_TABLE, Items.OAK_PLANKS);
        this.createSmithingTable(ModBlocks.SPRUCE_SMITHING_TABLE, Items.SPRUCE_PLANKS);
        this.createSmithingTable(ModBlocks.BIRCH_SMITHING_TABLE, Items.BIRCH_PLANKS);
        this.createSmithingTable(ModBlocks.JUNGLE_SMITHING_TABLE, Items.JUNGLE_PLANKS);
        this.createSmithingTable(ModBlocks.ACACIA_SMITHING_TABLE, Items.ACACIA_PLANKS);
        this.createSmithingTable(ModBlocks.DARK_OAK_SMITHING_TABLE, Items.DARK_OAK_PLANKS);
        this.createSmithingTable(ModBlocks.CRIMSON_SMITHING_TABLE, Items.CRIMSON_PLANKS);
        this.createSmithingTable(ModBlocks.WARPED_SMITHING_TABLE, Items.WARPED_PLANKS);
        this.createSmithingTable(Blocks.SMITHING_TABLE, Items.MANGROVE_PLANKS);
        this.createSmithingTable(ModBlocks.CHERRY_SMITHING_TABLE, Items.CHERRY_PLANKS);
        this.createSmithingTable(ModBlocks.BAMBOO_SMITHING_TABLE, Items.BAMBOO_PLANKS);
        this.createSmithingTable(ModBlocks.PALE_OAK_SMITHING_TABLE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.SMITHING_TABLE)
                .define('#', ItemTags.PLANKS)
                .define('@', Items.IRON_INGOT)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output);

        this.createGrindstone(ModBlocks.OAK_GRINDSTONE, Items.OAK_PLANKS);
        this.createGrindstone(ModBlocks.SPRUCE_GRINDSTONE, Items.SPRUCE_PLANKS);
        this.createGrindstone(ModBlocks.BIRCH_GRINDSTONE, Items.BIRCH_PLANKS);
        this.createGrindstone(ModBlocks.JUNGLE_GRINDSTONE, Items.JUNGLE_PLANKS);
        this.createGrindstone(ModBlocks.ACACIA_GRINDSTONE, Items.ACACIA_PLANKS);
        this.createGrindstone(Blocks.GRINDSTONE, Items.DARK_OAK_PLANKS);
        this.createGrindstone(ModBlocks.CRIMSON_GRINDSTONE, Items.CRIMSON_PLANKS);
        this.createGrindstone(ModBlocks.WARPED_GRINDSTONE, Items.WARPED_PLANKS);
        this.createGrindstone(ModBlocks.MANGROVE_GRINDSTONE, Items.MANGROVE_PLANKS);
        this.createGrindstone(ModBlocks.CHERRY_GRINDSTONE, Items.CHERRY_PLANKS);
        this.createGrindstone(ModBlocks.BAMBOO_GRINDSTONE, Items.BAMBOO_PLANKS);
        this.createGrindstone(ModBlocks.PALE_OAK_GRINDSTONE, Items.PALE_OAK_PLANKS);

        this.createLoom(Blocks.LOOM, Items.OAK_PLANKS);
        this.createLoom(ModBlocks.SPRUCE_LOOM, Items.SPRUCE_PLANKS);
        this.createLoom(ModBlocks.BIRCH_LOOM, Items.BIRCH_PLANKS);
        this.createLoom(ModBlocks.JUNGLE_LOOM, Items.JUNGLE_PLANKS);
        this.createLoom(ModBlocks.ACACIA_LOOM, Items.ACACIA_PLANKS);
        this.createLoom(ModBlocks.DARK_OAK_LOOM, Items.DARK_OAK_PLANKS);
        this.createLoom(ModBlocks.CRIMSON_LOOM, Items.CRIMSON_PLANKS);
        this.createLoom(ModBlocks.WARPED_LOOM, Items.WARPED_PLANKS);
        this.createLoom(ModBlocks.MANGROVE_LOOM, Items.MANGROVE_PLANKS);
        this.createLoom(ModBlocks.CHERRY_LOOM, Items.CHERRY_PLANKS);
        this.createLoom(ModBlocks.BAMBOO_LOOM, Items.BAMBOO_PLANKS);
        this.createLoom(ModBlocks.PALE_OAK_LOOM, Items.PALE_OAK_PLANKS);

        this.createFurnace(Blocks.FURNACE, Items.COBBLESTONE, "cobblestone");
        this.createFurnace(ModBlocks.BLACKSTONE_FURNACE, Items.BLACKSTONE, "blackstone");
        this.createFurnace(ModBlocks.DEEPSLATE_FURNACE, Items.COBBLED_DEEPSLATE, "cobbled_deepslate");

        this.createSmoker(Blocks.SMOKER, Blocks.SMOKER, Items.OAK_LOG, "furnace");
        this.createSmoker(ModBlocks.SPRUCE_STONE_SMOKER, Blocks.SMOKER, Items.SPRUCE_LOG, "furnace");
        this.createSmoker(ModBlocks.BIRCH_STONE_SMOKER, Blocks.SMOKER, Items.BIRCH_LOG, "furnace");
        this.createSmoker(ModBlocks.JUNGLE_STONE_SMOKER, Blocks.SMOKER, Items.JUNGLE_LOG, "furnace");
        this.createSmoker(ModBlocks.ACACIA_STONE_SMOKER, Blocks.SMOKER, Items.ACACIA_LOG, "furnace");
        this.createSmoker(ModBlocks.DARK_OAK_STONE_SMOKER, Blocks.SMOKER, Items.DARK_OAK_LOG, "furnace");
        this.createSmoker(ModBlocks.CRIMSON_STONE_SMOKER, Blocks.SMOKER, Items.CRIMSON_STEM, "furnace");
        this.createSmoker(ModBlocks.WARPED_STONE_SMOKER, Blocks.SMOKER, Items.WARPED_STEM, "furnace");
        this.createSmoker(ModBlocks.MANGROVE_STONE_SMOKER, Blocks.SMOKER, Items.MANGROVE_LOG, "furnace");
        this.createSmoker(ModBlocks.CHERRY_STONE_SMOKER, Blocks.SMOKER, Items.CHERRY_LOG, "furnace");
        this.createSmoker(ModBlocks.BAMBOO_STONE_SMOKER, Blocks.SMOKER, Items.BAMBOO_BLOCK, "furnace");
        this.createSmoker(ModBlocks.PALE_OAK_STONE_SMOKER, Blocks.SMOKER, Items.PALE_OAK_LOG, "furnace");

        this.createSmoker(ModBlocks.OAK_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.OAK_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.SPRUCE_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.SPRUCE_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.BIRCH_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.BIRCH_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.JUNGLE_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.JUNGLE_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.ACACIA_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.ACACIA_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.DARK_OAK_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.DARK_OAK_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.CRIMSON_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.CRIMSON_STEM, "blackstone_furnace");
        this.createSmoker(ModBlocks.WARPED_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.WARPED_STEM, "blackstone_furnace");
        this.createSmoker(ModBlocks.MANGROVE_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.MANGROVE_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.CHERRY_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.CHERRY_LOG, "blackstone_furnace");
        this.createSmoker(ModBlocks.BAMBOO_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.BAMBOO_BLOCK, "blackstone_furnace");
        this.createSmoker(ModBlocks.PALE_OAK_BLACKSTONE_SMOKER, ModBlocks.BLACKSTONE_FURNACE, Items.PALE_OAK_LOG, "blackstone_furnace");

        this.createSmoker(ModBlocks.OAK_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.OAK_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.SPRUCE_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.SPRUCE_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.BIRCH_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.BIRCH_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.JUNGLE_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.JUNGLE_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.ACACIA_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.ACACIA_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.DARK_OAK_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.DARK_OAK_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.CRIMSON_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.CRIMSON_STEM, "deepslate_furnace");
        this.createSmoker(ModBlocks.WARPED_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.WARPED_STEM, "deepslate_furnace");
        this.createSmoker(ModBlocks.MANGROVE_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.MANGROVE_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.CHERRY_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.CHERRY_LOG, "deepslate_furnace");
        this.createSmoker(ModBlocks.BAMBOO_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.BAMBOO_BLOCK, "deepslate_furnace");
        this.createSmoker(ModBlocks.PALE_OAK_DEEPSLATE_SMOKER, ModBlocks.DEEPSLATE_FURNACE, Items.PALE_OAK_LOG, "deepslate_furnace");

        this.createBlastFurnace(Blocks.BLAST_FURNACE, Blocks.FURNACE, Items.SMOOTH_STONE, "smooth_stone");
        this.createBlastFurnace(ModBlocks.BLACKSTONE_BLAST_FURNACE, ModBlocks.BLACKSTONE_FURNACE, Items.POLISHED_BLACKSTONE, "polished_blackstone");
        this.createBlastFurnace(ModBlocks.DEEPSLATE_BLAST_FURNACE, ModBlocks.DEEPSLATE_FURNACE, ModBlocks.SMOOTH_DEEPSLATE, "smooth_deepslate");

        this.createCampfires(Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE, ItemTags.OAK_LOGS);
        this.createCampfires(ModBlocks.SPRUCE_CAMPFIRE, ModBlocks.SPRUCE_SOUL_CAMPFIRE, ItemTags.SPRUCE_LOGS);
        this.createCampfires(ModBlocks.BIRCH_CAMPFIRE, ModBlocks.BIRCH_SOUL_CAMPFIRE, ItemTags.BIRCH_LOGS);
        this.createCampfires(ModBlocks.JUNGLE_CAMPFIRE, ModBlocks.JUNGLE_SOUL_CAMPFIRE, ItemTags.JUNGLE_LOGS);
        this.createCampfires(ModBlocks.ACACIA_CAMPFIRE, ModBlocks.ACACIA_SOUL_CAMPFIRE, ItemTags.ACACIA_LOGS);
        this.createCampfires(ModBlocks.DARK_OAK_CAMPFIRE, ModBlocks.DARK_OAK_SOUL_CAMPFIRE, ItemTags.DARK_OAK_LOGS);
        this.createCampfires(ModBlocks.CRIMSON_CAMPFIRE, ModBlocks.CRIMSON_SOUL_CAMPFIRE, ItemTags.CRIMSON_STEMS);
        this.createCampfires(ModBlocks.WARPED_CAMPFIRE, ModBlocks.WARPED_SOUL_CAMPFIRE, ItemTags.WARPED_STEMS);
        this.createCampfires(ModBlocks.MANGROVE_CAMPFIRE, ModBlocks.MANGROVE_SOUL_CAMPFIRE, ItemTags.MANGROVE_LOGS);
        this.createCampfires(ModBlocks.CHERRY_CAMPFIRE, ModBlocks.CHERRY_SOUL_CAMPFIRE, ItemTags.CHERRY_LOGS);
        this.createCampfires(ModBlocks.BAMBOO_CAMPFIRE, ModBlocks.BAMBOO_SOUL_CAMPFIRE, ItemTags.BAMBOO_BLOCKS);
        this.createCampfires(ModBlocks.PALE_OAK_CAMPFIRE, ModBlocks.PALE_OAK_SOUL_CAMPFIRE, ItemTags.PALE_OAK_LOGS);

        this.createBeehive(Blocks.BEEHIVE, Items.OAK_PLANKS);
        this.createBeehive(ModBlocks.SPRUCE_BEEHIVE, Items.SPRUCE_PLANKS);
        this.createBeehive(ModBlocks.BIRCH_BEEHIVE, Items.BIRCH_PLANKS);
        this.createBeehive(ModBlocks.JUNGLE_BEEHIVE, Items.JUNGLE_PLANKS);
        this.createBeehive(ModBlocks.ACACIA_BEEHIVE, Items.ACACIA_PLANKS);
        this.createBeehive(ModBlocks.DARK_OAK_BEEHIVE, Items.DARK_OAK_PLANKS);
        this.createBeehive(ModBlocks.CRIMSON_BEEHIVE, Items.CRIMSON_PLANKS);
        this.createBeehive(ModBlocks.WARPED_BEEHIVE, Items.WARPED_PLANKS);
        this.createBeehive(ModBlocks.MANGROVE_BEEHIVE, Items.MANGROVE_PLANKS);
        this.createBeehive(ModBlocks.CHERRY_BEEHIVE, Items.CHERRY_PLANKS);
        this.createBeehive(ModBlocks.BAMBOO_BEEHIVE, Items.BAMBOO_PLANKS);
        this.createBeehive(ModBlocks.PALE_OAK_BEEHIVE, Items.PALE_OAK_PLANKS);

        this.createBookshelf(Blocks.BOOKSHELF, Items.OAK_PLANKS);
        this.createBookshelf(ModBlocks.SPRUCE_BOOKSHELF, Items.SPRUCE_PLANKS);
        this.createBookshelf(ModBlocks.BIRCH_BOOKSHELF, Items.BIRCH_PLANKS);
        this.createBookshelf(ModBlocks.JUNGLE_BOOKSHELF, Items.JUNGLE_PLANKS);
        this.createBookshelf(ModBlocks.ACACIA_BOOKSHELF, Items.ACACIA_PLANKS);
        this.createBookshelf(ModBlocks.DARK_OAK_BOOKSHELF, Items.DARK_OAK_PLANKS);
        this.createBookshelf(ModBlocks.CRIMSON_BOOKSHELF, Items.CRIMSON_PLANKS);
        this.createBookshelf(ModBlocks.WARPED_BOOKSHELF, Items.WARPED_PLANKS);
        this.createBookshelf(ModBlocks.MANGROVE_BOOKSHELF, Items.MANGROVE_PLANKS);
        this.createBookshelf(ModBlocks.CHERRY_BOOKSHELF, Items.CHERRY_PLANKS);
        this.createBookshelf(ModBlocks.BAMBOO_BOOKSHELF, Items.BAMBOO_PLANKS);
        this.createBookshelf(ModBlocks.PALE_OAK_BOOKSHELF, Items.PALE_OAK_PLANKS);

        this.createChiseledBookshelf(Blocks.CHISELED_BOOKSHELF, Items.OAK_PLANKS, Items.OAK_SLAB);
        this.createChiseledBookshelf(ModBlocks.SPRUCE_CHISELED_BOOKSHELF, Items.SPRUCE_PLANKS, Items.SPRUCE_SLAB);
        this.createChiseledBookshelf(ModBlocks.BIRCH_CHISELED_BOOKSHELF, Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
        this.createChiseledBookshelf(ModBlocks.JUNGLE_CHISELED_BOOKSHELF, Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
        this.createChiseledBookshelf(ModBlocks.ACACIA_CHISELED_BOOKSHELF, Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
        this.createChiseledBookshelf(ModBlocks.DARK_OAK_CHISELED_BOOKSHELF, Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
        this.createChiseledBookshelf(ModBlocks.CRIMSON_CHISELED_BOOKSHELF, Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);
        this.createChiseledBookshelf(ModBlocks.WARPED_CHISELED_BOOKSHELF, Items.WARPED_PLANKS, Items.WARPED_SLAB);
        this.createChiseledBookshelf(ModBlocks.MANGROVE_CHISELED_BOOKSHELF, Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
        this.createChiseledBookshelf(ModBlocks.CHERRY_CHISELED_BOOKSHELF, Items.CHERRY_PLANKS, Items.CHERRY_SLAB);
        this.createChiseledBookshelf(ModBlocks.BAMBOO_CHISELED_BOOKSHELF, Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB);
        this.createChiseledBookshelf(ModBlocks.PALE_OAK_CHISELED_BOOKSHELF, Items.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB);

        this.createLectern(Blocks.LECTERN, Blocks.BOOKSHELF, Items.OAK_SLAB);
        this.createLectern(ModBlocks.SPRUCE_LECTERN, ModBlocks.SPRUCE_BOOKSHELF, Items.SPRUCE_SLAB);
        this.createLectern(ModBlocks.BIRCH_LECTERN, ModBlocks.BIRCH_BOOKSHELF, Items.BIRCH_SLAB);
        this.createLectern(ModBlocks.JUNGLE_LECTERN, ModBlocks.JUNGLE_BOOKSHELF, Items.JUNGLE_SLAB);
        this.createLectern(ModBlocks.ACACIA_LECTERN, ModBlocks.ACACIA_BOOKSHELF, Items.ACACIA_SLAB);
        this.createLectern(ModBlocks.DARK_OAK_LECTERN, ModBlocks.DARK_OAK_BOOKSHELF, Items.DARK_OAK_SLAB);
        this.createLectern(ModBlocks.CRIMSON_LECTERN, ModBlocks.CRIMSON_BOOKSHELF, Items.CRIMSON_SLAB);
        this.createLectern(ModBlocks.WARPED_LECTERN, ModBlocks.WARPED_BOOKSHELF, Items.WARPED_SLAB);
        this.createLectern(ModBlocks.MANGROVE_LECTERN, ModBlocks.MANGROVE_BOOKSHELF, Items.MANGROVE_SLAB);
        this.createLectern(ModBlocks.CHERRY_LECTERN, ModBlocks.CHERRY_BOOKSHELF, Items.CHERRY_SLAB);
        this.createLectern(ModBlocks.BAMBOO_LECTERN, ModBlocks.BAMBOO_BOOKSHELF, Items.BAMBOO_SLAB);
        this.createLectern(ModBlocks.PALE_OAK_LECTERN, ModBlocks.PALE_OAK_BOOKSHELF, Items.PALE_OAK_SLAB);

        this.createBrewingStand(Blocks.BREWING_STAND, Items.COBBLESTONE);
        this.createBrewingStand(ModBlocks.BLACKSTONE_BREWING_STAND, Items.BLACKSTONE);
        this.createBrewingStand(ModBlocks.DEEPSLATE_BREWING_STAND, Items.COBBLED_DEEPSLATE);

        this.createBarrel(ModBlocks.OAK_BARREL, Items.OAK_PLANKS, Items.OAK_SLAB);
        this.createBarrel(Blocks.BARREL, Items.SPRUCE_PLANKS, Items.SPRUCE_SLAB);
        this.createBarrel(ModBlocks.BIRCH_BARREL, Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
        this.createBarrel(ModBlocks.JUNGLE_BARREL, Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
        this.createBarrel(ModBlocks.ACACIA_BARREL, Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
        this.createBarrel(ModBlocks.DARK_OAK_BARREL, Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
        this.createBarrel(ModBlocks.CRIMSON_BARREL, Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);
        this.createBarrel(ModBlocks.WARPED_BARREL, Items.WARPED_PLANKS, Items.WARPED_SLAB);
        this.createBarrel(ModBlocks.MANGROVE_BARREL, Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
        this.createBarrel(ModBlocks.CHERRY_BARREL, Items.CHERRY_PLANKS, Items.CHERRY_SLAB);
        this.createBarrel(ModBlocks.BAMBOO_BARREL, Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB);
        this.createBarrel(ModBlocks.PALE_OAK_BARREL, Items.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB);

        this.createDispensersDroppers(Blocks.DISPENSER, Blocks.DROPPER, Items.COBBLESTONE);
        this.createDispensersDroppers(ModBlocks.BLACKSTONE_DISPENSER, ModBlocks.BLACKSTONE_DROPPER, Items.BLACKSTONE);
        this.createDispensersDroppers(ModBlocks.DEEPSLATE_DISPENSER, ModBlocks.DEEPSLATE_DROPPER, Items.COBBLED_DEEPSLATE);

        this.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 9).requires(ModBlocks.IRON_BLOCK.waxed().unaffected()).group(null).unlockedBy(getHasName(ModBlocks.IRON_BLOCK.waxed().unaffected()), this.has(ModBlocks.IRON_BLOCK.waxed().unaffected())).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse("iron_ingot_from_waxed")));
        this.shapeless(RecipeCategory.MISC, ModItems.ZINC_INGOT, 9).requires(ModBlocks.ZINC_BLOCK.waxed().unaffected()).group(null).unlockedBy(getHasName(ModBlocks.ZINC_BLOCK.waxed().unaffected()), this.has(ModBlocks.ZINC_BLOCK.waxed().unaffected())).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse("zinc_ingot_from_waxed")));

        this.createObserver(Blocks.OBSERVER, Items.COBBLESTONE);
        this.createObserver(ModBlocks.BLACKSTONE_OBSERVER, Items.BLACKSTONE);
        this.createObserver(ModBlocks.DEEPSLATE_OBSERVER, Items.COBBLED_DEEPSLATE);

        this.shaped(RecipeCategory.REDSTONE, Items.OBSERVER)
                .define('Q', Items.QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', Items.COBBLESTONE)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output);

        this.woodenBoat(ModItems.CRIMSON_BOAT, Items.CRIMSON_PLANKS);
        this.woodenBoat(ModItems.WARPED_BOAT, Items.WARPED_PLANKS);

        this.nullifyChestBoat(Items.ACACIA_CHEST_BOAT, Items.ACACIA_BOAT);
        this.nullifyChestBoat(Items.BIRCH_CHEST_BOAT, Items.BIRCH_BOAT);
        this.nullifyChestBoat(Items.DARK_OAK_CHEST_BOAT, Items.DARK_OAK_BOAT);
        this.nullifyChestBoat(Items.PALE_OAK_CHEST_BOAT, Items.PALE_OAK_BOAT);
        this.nullifyChestBoat(Items.JUNGLE_CHEST_BOAT, Items.JUNGLE_BOAT);
        this.nullifyChestBoat(Items.OAK_CHEST_BOAT, Items.OAK_BOAT);
        this.nullifyChestBoat(Items.SPRUCE_CHEST_BOAT, Items.SPRUCE_BOAT);
        this.nullifyChestBoat(Items.MANGROVE_CHEST_BOAT, Items.MANGROVE_BOAT);
        this.nullifyChestBoat(Items.CHERRY_CHEST_BOAT, Items.CHERRY_BOAT);

        this.chestBoat(Items.ACACIA_CHEST_BOAT, Items.ACACIA_BOAT);
        this.chestBoat(Items.BIRCH_CHEST_BOAT, Items.BIRCH_BOAT);
        this.chestBoat(Items.DARK_OAK_CHEST_BOAT, Items.DARK_OAK_BOAT);
        this.chestBoat(Items.PALE_OAK_CHEST_BOAT, Items.PALE_OAK_BOAT);
        this.chestBoat(Items.JUNGLE_CHEST_BOAT, Items.JUNGLE_BOAT);
        this.chestBoat(Items.OAK_CHEST_BOAT, Items.OAK_BOAT);
        this.chestBoat(Items.SPRUCE_CHEST_BOAT, Items.SPRUCE_BOAT);
        this.chestBoat(Items.MANGROVE_CHEST_BOAT, Items.MANGROVE_BOAT);
        this.chestBoat(Items.CHERRY_CHEST_BOAT, Items.CHERRY_BOAT);
        this.modChestBoat(ModItems.CRIMSON_CHEST_BOAT, ModItems.CRIMSON_BOAT);
        this.modChestBoat(ModItems.WARPED_CHEST_BOAT, ModItems.WARPED_BOAT);

        this.createCrafter(Blocks.CRAFTER, Blocks.CRAFTING_TABLE);
        this.createCrafter(ModBlocks.SPRUCE_CRAFTER, ModBlocks.SPRUCE_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.BIRCH_CRAFTER, ModBlocks.BIRCH_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.JUNGLE_CRAFTER, ModBlocks.JUNGLE_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.ACACIA_CRAFTER, ModBlocks.ACACIA_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.DARK_OAK_CRAFTER, ModBlocks.DARK_OAK_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.CRIMSON_CRAFTER, ModBlocks.CRIMSON_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.WARPED_CRAFTER, ModBlocks.WARPED_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.MANGROVE_CRAFTER, ModBlocks.MANGROVE_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.CHERRY_CRAFTER, ModBlocks.CHERRY_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.BAMBOO_CRAFTER, ModBlocks.BAMBOO_CRAFTING_TABLE);
        this.createCrafter(ModBlocks.PALE_OAK_CRAFTER, ModBlocks.PALE_OAK_CRAFTING_TABLE);

        this.createMinecart(Items.FURNACE_MINECART, Blocks.FURNACE);
        this.createMinecart(ModItems.BLACKSTONE_FURNACE_MINECART, ModBlocks.BLACKSTONE_FURNACE);
        this.createMinecart(ModItems.DEEPSLATE_FURNACE_MINECART, ModBlocks.DEEPSLATE_FURNACE);

        this.createChests(Blocks.CHEST, Blocks.TRAPPED_CHEST, Items.OAK_PLANKS);
        this.createChests(ModBlocks.SPRUCE_CHEST, ModBlocks.SPRUCE_TRAPPED_CHEST, Items.SPRUCE_PLANKS);
        this.createChests(ModBlocks.BIRCH_CHEST, ModBlocks.BIRCH_TRAPPED_CHEST, Items.BIRCH_PLANKS);
        this.createChests(ModBlocks.JUNGLE_CHEST, ModBlocks.JUNGLE_TRAPPED_CHEST, Items.JUNGLE_PLANKS);
        this.createChests(ModBlocks.ACACIA_CHEST, ModBlocks.ACACIA_TRAPPED_CHEST, Items.ACACIA_PLANKS);
        this.createChests(ModBlocks.DARK_OAK_CHEST, ModBlocks.DARK_OAK_TRAPPED_CHEST, Items.DARK_OAK_PLANKS);
        this.createChests(ModBlocks.CRIMSON_CHEST, ModBlocks.CRIMSON_TRAPPED_CHEST, Items.CRIMSON_PLANKS);
        this.createChests(ModBlocks.WARPED_CHEST, ModBlocks.WARPED_TRAPPED_CHEST, Items.WARPED_PLANKS);
        this.createChests(ModBlocks.MANGROVE_CHEST, ModBlocks.MANGROVE_TRAPPED_CHEST, Items.MANGROVE_PLANKS);
        this.createChests(ModBlocks.CHERRY_CHEST, ModBlocks.CHERRY_TRAPPED_CHEST, Items.CHERRY_PLANKS);
        this.createChests(ModBlocks.BAMBOO_CHEST, ModBlocks.BAMBOO_TRAPPED_CHEST, Items.BAMBOO_PLANKS);
        this.createChests(ModBlocks.PALE_OAK_CHEST, ModBlocks.PALE_OAK_TRAPPED_CHEST, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.SHULKER_BOX)
                .define('#', ModItemTags.CHESTS)
                .define('-', Items.SHULKER_SHELL)
                .pattern("-")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_shulker_shell", this.has(Items.SHULKER_SHELL))
                .save(this.output);

        this.shaped(RecipeCategory.REDSTONE, Items.HOPPER)
                .define('C', ModItemTags.CHESTS)
                .define('I', Items.IRON_INGOT)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, Items.COPPER_CHEST.weathering().unaffected())
                .define('#', Items.COPPER_INGOT)
                .define('X', ModItemTags.CHESTS)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_copper_chest", this.has(Items.COPPER_CHEST.weathering().unaffected()))
                .save(this.output);

        this.createMinecart(Items.CHEST_MINECART, Blocks.CHEST);
        this.createMinecart(ModItems.SPRUCE_CHEST_MINECART, ModBlocks.SPRUCE_CHEST);
        this.createMinecart(ModItems.BIRCH_CHEST_MINECART, ModBlocks.BIRCH_CHEST);
        this.createMinecart(ModItems.JUNGLE_CHEST_MINECART, ModBlocks.JUNGLE_CHEST);
        this.createMinecart(ModItems.ACACIA_CHEST_MINECART, ModBlocks.ACACIA_CHEST);
        this.createMinecart(ModItems.DARK_OAK_CHEST_MINECART, ModBlocks.DARK_OAK_CHEST);
        this.createMinecart(ModItems.CRIMSON_CHEST_MINECART, ModBlocks.CRIMSON_CHEST);
        this.createMinecart(ModItems.WARPED_CHEST_MINECART, ModBlocks.WARPED_CHEST);
        this.createMinecart(ModItems.MANGROVE_CHEST_MINECART, ModBlocks.MANGROVE_CHEST);
        this.createMinecart(ModItems.CHERRY_CHEST_MINECART, ModBlocks.CHERRY_CHEST);
        this.createMinecart(ModItems.BAMBOO_CHEST_MINECART, ModBlocks.BAMBOO_CHEST);
        this.createMinecart(ModItems.PALE_OAK_CHEST_MINECART, ModBlocks.PALE_OAK_CHEST);

        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.OAK_MOSAIC, Items.OAK_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.SPRUCE_MOSAIC, Items.SPRUCE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.BIRCH_MOSAIC, Items.BIRCH_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.JUNGLE_MOSAIC, Items.JUNGLE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.ACACIA_MOSAIC, Items.ACACIA_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.DARK_OAK_MOSAIC, Items.DARK_OAK_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.CRIMSON_MOSAIC, Items.CRIMSON_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.WARPED_MOSAIC, Items.WARPED_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.MANGROVE_MOSAIC, Items.MANGROVE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.CHERRY_MOSAIC, Items.CHERRY_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModBlocks.PALE_OAK_MOSAIC, Items.PALE_OAK_SLAB);

        this.createBaton(ModItems.STONE_BATON, Items.COBBLESTONE, "cobblestone");
        this.createBaton(ModItems.GRANITE_BATON, Items.GRANITE, "granite");
        this.createBaton(ModItems.DIORITE_BATON, Items.DIORITE, "diorite");
        this.createBaton(ModItems.ANDESITE_BATON, Items.ANDESITE, "andesite");
        this.createBaton(ModItems.DEEPSLATE_BATON, Items.COBBLED_DEEPSLATE, "cobbled_deepslate");
        this.createBaton(ModItems.TUFF_BATON, Items.TUFF, "tuff");
        this.createBaton(ModItems.CALCITE_BATON, Items.CALCITE, "calcite");
        this.createBaton(ModItems.PACKED_MUD_BATON, Items.PACKED_MUD, "packed_mud");
        this.createBaton(ModItems.SANDSTONE_BATON, Items.SANDSTONE, "sandstone");
        this.createBaton(ModItems.RED_SANDSTONE_BATON, Items.RED_SANDSTONE, "red_sandstone");
        this.createBaton(ModItems.SOUL_SANDSTONE_BATON, ModBlocks.SOUL_SANDSTONE, "soul_sandstone");
        this.createBaton(ModItems.END_STONE_BATON, Items.END_STONE, "end_stone");
        this.createBaton(ModItems.NETHERRACK_BATON, Items.NETHERRACK, "netherrack");
        this.createBaton(ModItems.BLACKSTONE_BATON, Items.BLACKSTONE, "blackstone");
        this.createBaton(ModItems.BASALT_BATON, Items.BASALT, "basalt");
        this.createBaton(ModItems.OBSIDIAN_BATON, Items.OBSIDIAN, "obsidian");
        this.createBaton(ModItems.TERRACOTTA_BATON, ItemTags.TERRACOTTA, "terracotta");
        this.createBaton(ModItems.CONCRETE_BATON, ModItemTags.CONCRETE, "concrete");
        this.createBaton(ModItems.GABBRO_BATON, ModBlocks.GABBRO, "gabbro");
        this.createBaton(ModItems.RHYOLITE_BATON, ModBlocks.RHYOLITE, "rhyolite");
        this.createBaton(ModItems.PUMICE_BATON, ModBlocks.PUMICE, "pumice");
        this.createBaton(ModItems.CINNABAR_BATON, Items.CINNABAR, "cinnabar");

        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, Items.ICE, ModItems.ICE_SHARD);
        this.createBatonWithCustomCount(Items.LAPIS_LAZULI, Items.LAPIS_BLOCK, "lapis_block", 18);
        this.createBatonWithCustomCount(Items.RESIN_CLUMP, Items.RESIN_BLOCK, "resin_block", 18);
        this.createBatonWithCustomCount(Items.QUARTZ, Items.QUARTZ_BLOCK, "quartz_block", 8);
        this.createBatonWithCustomCount(ModItems.ICE_SHARD, Items.ICE, "ice", 8);

        this.shapeless(RecipeCategory.MISC, Items.LAPIS_LAZULI, 9).requires(Items.LAPIS_BLOCK).unlockedBy(getHasName(Items.LAPIS_BLOCK), this.has(Items.LAPIS_BLOCK)).save(this.output);
        this.shapeless(RecipeCategory.MISC, Items.RESIN_CLUMP, 9).requires(Items.RESIN_BLOCK).unlockedBy(getHasName(Items.RESIN_BLOCK), this.has(Items.RESIN_BLOCK)).save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, Items.SNOW, 6)
                .define('#', Items.SNOW_BLOCK)
                .pattern("###")
                .unlockedBy("has_snowball", this.has(Items.SNOWBALL))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, Items.SNOW, 2)
                .define('#', Items.SNOWBALL)
                .pattern("##")
                .unlockedBy("has_snowball", this.has(Items.SNOWBALL))
                .save(this.output, "snowball_mod");


        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_SLAB, Items.DYE, (dyedSlab, dye) -> this.coloredTerracottaSlabFromTerracottaSlabAndDye(dyedSlab, dye));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_STAIRS, Items.DYE, (dyedStairs, dye) -> this.coloredTerracottaStairsFromTerracottaStairsAndDye(dyedStairs, dye));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_WALL, Items.DYE, (dyedWall, dye) -> this.coloredTerracottaWallFromTerracottaWallAndDye(dyedWall, dye));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_FENCE, Items.DYE, (dyedFence, dye) -> this.coloredTerracottaFenceFromTerracottaFenceAndDye(dyedFence, dye));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_TILES)
                .requires(ModBlocks.STONE_TILES)
                .requires(Items.VINE).group("mossy_stone_tiles")
                .unlockedBy("has_vine", this.has(Items.VINE))
                .save(this.output, getConversionRecipeName(ModBlocks.MOSSY_STONE_TILES, Items.VINE));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_TILES)
                .requires(ModBlocks.STONE_TILES)
                .requires(Items.MOSS_BLOCK).group("mossy_stone_tiles")
                .unlockedBy("has_moss_block", this.has(Items.MOSS_BLOCK))
                .save(this.output, getConversionRecipeName(ModBlocks.MOSSY_STONE_TILES, Items.MOSS_BLOCK));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.STONE_TILES), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.CRACKED_STONE_TILES, 0.1F, 200).unlockedBy("has_stone_tiles", this.has(ModBlocks.STONE_TILES)).save(this.output);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.LAPIS_BLOCK), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.SMOOTH_LAPIS, 0.1F, 200).unlockedBy("has_lapis_block", this.has(Items.LAPIS_BLOCK)).save(this.output);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.SCULK_VEIN), RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SCULK_BRICK, 0.1F, 200).unlockedBy("has_lapis_block", this.has(Items.SCULK_VEIN)).save(this.output);

        this.threeByThreePacker(RecipeCategory.MISC, Items.SCULK, Items.SCULK_VEIN);
        this.createBatonWithCustomCount(Items.SCULK_VEIN, Items.SCULK, "sculk_vein", 18);
        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_BRICKS, ModItems.SCULK_BRICK);

        this.copyBronzeSmithingTemplate(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE, Items.COBBLESTONE);

        this.bronzeSmithing(Items.COPPER_CHESTPLATE, RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE);
        this.bronzeSmithing(Items.COPPER_LEGGINGS, RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS);
        this.bronzeSmithing(Items.COPPER_HELMET, RecipeCategory.COMBAT, ModItems.BRONZE_HELMET);
        this.bronzeSmithing(Items.COPPER_BOOTS, RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS);
        this.bronzeSmithing(Items.COPPER_SWORD, RecipeCategory.COMBAT, ModItems.BRONZE_SWORD);
        this.bronzeSmithing(Items.COPPER_AXE, RecipeCategory.TOOLS, ModItems.BRONZE_AXE);
        this.bronzeSmithing(Items.COPPER_PICKAXE, RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE);
        this.bronzeSmithing(Items.COPPER_HOE, RecipeCategory.TOOLS, ModItems.BRONZE_HOE);
        this.bronzeSmithing(Items.COPPER_SHOVEL, RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL);
        this.bronzeSmithing(Items.COPPER_SPEAR, RecipeCategory.COMBAT, ModItems.BRONZE_SPEAR);
        this.bronzeSmithing(Items.COPPER_HORSE_ARMOR, RecipeCategory.COMBAT, ModItems.BRONZE_HORSE_ARMOR);
        this.bronzeSmithing(Items.COPPER_NAUTILUS_ARMOR, RecipeCategory.COMBAT, ModItems.BRONZE_NAUTILUS_ARMOR);

        this.flameTestTorch(ModBlocks.IRON_TORCH, Items.IRON_NUGGET);
        this.createLanterns(ModBlocks.IRON_FIRE_LANTERN.weathering().unaffected(), ModBlocks.IRON_SOUL_LANTERN.weathering().unaffected(), ModBlocks.IRON_LANTERN.weathering().unaffected(), Items.IRON_NUGGET, Items.IRON_INGOT, ModBlocks.IRON_TORCH);

        this.createLanterns(ModBlocks.COPPER_FIRE_LANTERN.weathering().unaffected(), ModBlocks.COPPER_SOUL_LANTERN.weathering().unaffected(), Items.COPPER_LANTERN.weathering().unaffected(), Items.COPPER_NUGGET, Items.COPPER_INGOT, Items.COPPER_TORCH);

        this.createChain(ModBlocks.ZINC_CHAIN.weathering().unaffected(), ModItems.ZINC_INGOT, ModItems.ZINC_NUGGET);
        this.createChain(ModBlocks.GOLD_CHAIN, Items.GOLD_INGOT, Items.GOLD_NUGGET);
        this.createChain(ModBlocks.NETHERITE_CHAIN, Items.NETHERITE_INGOT, ModItems.NETHERITE_NUGGET);
        this.createChain(ModBlocks.SILVER_CHAIN, ModItems.SILVER_INGOT, ModItems.SILVER_NUGGET);
        this.createChain(ModBlocks.TIN_CHAIN, ModItems.TIN_INGOT, ModItems.TIN_NUGGET);
        this.createChain(ModBlocks.TUNGSTEN_CHAIN, ModItems.TUNGSTEN_INGOT, ModItems.TUNGSTEN_NUGGET);
        this.createChain(ModBlocks.PLATINUM_CHAIN, ModItems.PLATINUM_INGOT, ModItems.PLATINUM_NUGGET);
        this.createChain(ModBlocks.LEAD_CHAIN, ModItems.LEAD_INGOT, ModItems.LEAD_NUGGET);
        this.createChain(ModBlocks.URANIUM_CHAIN, ModItems.URANIUM_INGOT, ModItems.URANIUM_NUGGET);
        this.createChain(ModBlocks.BRONZE_CHAIN, ModItems.BRONZE_INGOT, ModItems.BRONZE_NUGGET);
        this.createChain(ModBlocks.BRASS_CHAIN, ModItems.BRASS_INGOT, ModItems.BRASS_NUGGET);
        this.createChain(ModBlocks.STEEL_CHAIN, ModItems.STEEL_INGOT, ModItems.STEEL_NUGGET);

        this.flameTestTorch(ModBlocks.ZINC_TORCH, ModItems.ZINC_NUGGET);
        this.flameTestTorch(ModBlocks.SILVER_TORCH, ModItems.SILVER_NUGGET);
        this.flameTestTorch(ModBlocks.TIN_TORCH, ModItems.TIN_NUGGET);
        this.flameTestTorch(ModBlocks.TUNGSTEN_TORCH, ModItems.TUNGSTEN_NUGGET);
        this.flameTestTorch(ModBlocks.PLATINUM_TORCH, ModItems.PLATINUM_NUGGET);
        this.flameTestTorch(ModBlocks.GOLD_TORCH, Items.GOLD_NUGGET);
        this.flameTestTorch(ModBlocks.LEAD_TORCH, ModItems.LEAD_NUGGET);
        this.flameTestTorch(ModBlocks.URANIUM_TORCH, ModItems.URANIUM_NUGGET);

        this.fletching(ModItems.EXPLOSIVE_ARROW, Items.ARROW, Items.GUNPOWDER);
        this.fletching(ModItems.SHARPENED_ARROW, Items.ARROW, Items.FLINT);
        this.fletching(ModItems.STREAMLINED_ARROW, Items.ARROW, Items.PHANTOM_MEMBRANE);

        this.slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB, Ingredient.of(new ItemLike[]{ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE}))
                .unlockedBy("has_soul_sandstone", this.has(ModBlocks.SOUL_SANDSTONE))
                .unlockedBy("has_chiseled_soul_sandstone", this.has(ModBlocks.CHISELED_SOUL_SANDSTONE))
                .save(this.output, "soul_sandstone_slab_alt");

        this.stairBuilder(ModBlocks.SOUL_SANDSTONE_STAIRS, Ingredient.of(new ItemLike[]{ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE}))
                .unlockedBy("has_soul_sandstone", this.has(ModBlocks.SOUL_SANDSTONE))
                .unlockedBy("has_chiseled_soul_sandstone", this.has(ModBlocks.CHISELED_SOUL_SANDSTONE))
                .save(this.output, "soul_sandstone_stairs_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICKS, 4)
                .define('#', Items.DEEPSLATE)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(Items.DEEPSLATE), this.has(Items.DEEPSLATE))
                .save(this.output, "deepslate_bricks_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, 4)
                .define('#', ModBlocks.POLISHED_STONE)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ModBlocks.POLISHED_STONE), this.has(ModBlocks.POLISHED_STONE))
                .save(this.output, "stone_bricks_alt");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEEPSLATE), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModBlocks.SMOOTH_DEEPSLATE, 0.1F, 200).unlockedBy("has_deepslate", this.has(Items.DEEPSLATE)).save(this.output, "smooth_deepslate_smelting");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.QUARTZ_PILLAR, 3)
                .define('#', Items.QUARTZ_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_chiseled_quartz_block", this.has(Blocks.CHISELED_QUARTZ_BLOCK))
                .unlockedBy("has_quartz_block", this.has(Blocks.QUARTZ_BLOCK))
                .unlockedBy("has_quartz_pillar", this.has(Blocks.QUARTZ_PILLAR))
                .save(this.output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.PURPUR_PILLAR, 3)
                .define('#', Items.PURPUR_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_purpur_block", this.has(Blocks.PURPUR_BLOCK))
                .save(this.output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.GILDED_BLACKSTONE, 2)
                .define('#', Items.BLACKSTONE)
                .define('^', Items.GOLD_NUGGET)
                .pattern("#^")
                .pattern("^#")
                .unlockedBy("has_blackstone", this.has(Items.BLACKSTONE))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, ModBlocks.TINTED_GLASS_PANE, 16)
                .define('#', Blocks.TINTED_GLASS)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_tinted_glass", this.has(Blocks.TINTED_GLASS))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.HEART_BANNER_PATTERN)
                .requires(Items.PAPER)
                .requires(Items.CREAKING_HEART)
                .unlockedBy("has_creaking_heart", this.has(Items.CREAKING_HEART))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.DIAMOND_BANNER_PATTERN)
                .requires(Items.PAPER)
                .requires(Items.DIAMOND)
                .unlockedBy("has_diamond", this.has(Items.DIAMOND))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.SPADE_BANNER_PATTERN)
                .requires(Items.PAPER)
                .requires(Items.WOODEN_SHOVEL)
                .unlockedBy("has_wooden_shovel", this.has(Items.WOODEN_SHOVEL))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.CLUB_BANNER_PATTERN)
                .requires(Items.PAPER)
                .requires(ModItems.STONE_BATON)
                .unlockedBy("has_stone_baton", this.has(ModItems.STONE_BATON))
                .save(this.output);

        this.slabBuilder(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.LAPIS_SLAB,
                        Ingredient.of(new ItemLike[]{Items.LAPIS_BLOCK, ModBlocks.LAPIS_PILLAR, ModBlocks.CHISELED_LAPIS})
                ).unlockedBy("has_chiseled_lapis_block", this.has(Items.LAPIS_BLOCK))
                .unlockedBy("has_lapis_block", this.has(ModBlocks.LAPIS_PILLAR))
                .unlockedBy("has_lapis_pillar", this.has(ModBlocks.CHISELED_LAPIS))
                .save(this.output, "lapis_slab_alt");

        this.stairBuilder(
                        ModBlocks.LAPIS_STAIRS,
                        Ingredient.of(new ItemLike[]{Items.LAPIS_BLOCK, ModBlocks.LAPIS_PILLAR, ModBlocks.CHISELED_LAPIS})
                ).unlockedBy("has_chiseled_lapis_block", this.has(Items.LAPIS_BLOCK))
                .unlockedBy("has_lapis_block", this.has(ModBlocks.LAPIS_PILLAR))
                .unlockedBy("has_lapis_pillar", this.has(ModBlocks.CHISELED_LAPIS))
                .save(this.output, "lapis_stairs_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_PILLAR.asItem(), 3)
                .define('#', Items.LAPIS_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_lapis", this.has(Blocks.LAPIS_BLOCK))
                .save(this.output);

        RustingIronCollection.zipApply(ModBlocks.IRON_GRATE, ModBlocks.IRON_BLOCK, (x$0, x$1) -> this.grate(x$0, x$1));
        RustingIronCollection.zipApply(ModBlocks.IRON_BULB, ModBlocks.IRON_BLOCK, (x$0, x$1) -> this.copperBulb(x$0, x$1));

        CorrodingZincCollection.zipApply(ModBlocks.ZINC_GRATE, ModBlocks.ZINC_BLOCK, (x$0, x$1) -> this.grate(x$0, x$1));
        CorrodingZincCollection.zipApply(ModBlocks.ZINC_BULB, ModBlocks.ZINC_BLOCK, (x$0, x$1) -> this.copperBulb(x$0, x$1));

        this.threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE, ModItems.CARBON_DUST);
        this.shapeless(RecipeCategory.MISC, ModItems.CARBON_DUST, 2)
                .requires(Ingredient.of(new Item[]{Items.COAL, Items.CHARCOAL}))
                .unlockedBy("has_coal", this.has(Items.COAL))
                .unlockedBy("has_charcoal", this.has(Items.CHARCOAL))
                .save(this.output, "carbon_dust_alt");

        this.shaped(RecipeCategory.DECORATIONS, ModBlocks.GRAPHENE, 2)
                .define('#', ModItems.CARBON_DUST)
                .pattern("##")
                .unlockedBy("has_carbon_dust", this.has(ModItems.CARBON_DUST))
                .save(this.output);
        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARBON_BLOCK, ModItems.CARBON_DUST);
        this.shapeless(RecipeCategory.MISC, ModItems.CARBON_DUST, 4)
                .requires(Ingredient.of(ModBlocks.CARBON_BLOCK.asItem()))
                .unlockedBy("has_carbon_block", this.has(ModBlocks.CARBON_BLOCK))
                .save(this.output);

        oreSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH_INGOT, 1.0F, 200, "bismuth_ingot");
        oreBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.BISMUTH_INGOT, 1.0F, 100, "bismuth_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.BISMUTH_NUGGET,
                RecipeCategory.MISC,
                ModItems.BISMUTH_INGOT,
                "bismuth_ingot",
                null,
                "bismuth_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.BISMUTH_BLOCK,
                "bismuth_block",
                null);
        doorBuilder(ModBlocks.BISMUTH_DOOR, Ingredient.of(ModItems.BISMUTH_INGOT)).unlockedBy(getHasName(ModItems.BISMUTH_INGOT), this.has(ModItems.BISMUTH_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModBlocks.BISMUTH_TRAPDOOR, ModItems.BISMUTH_INGOT);
        pressurePlate(ModBlocks.VEHEMENT_WEIGHTED_PRESSURE_PLATE, ModItems.BISMUTH_INGOT);

        this.createChain(ModBlocks.BISMUTH_CHAIN, ModItems.BISMUTH_INGOT, ModItems.BISMUTH_NUGGET);
        this.flameTestTorch(ModBlocks.BISMUTH_TORCH, ModItems.BISMUTH_NUGGET);
        this.grate(ModBlocks.BISMUTH_GRATE, ModBlocks.BISMUTH_BLOCK);
        this.copperBulb(ModBlocks.BISMUTH_BULB, ModBlocks.BISMUTH_BLOCK);

        this.createLanterns(ModBlocks.ZINC_FIRE_LANTERN.weathering().unaffected(), ModBlocks.ZINC_SOUL_LANTERN.weathering().unaffected(), ModBlocks.ZINC_LANTERN.weathering().unaffected(), ModItems.ZINC_NUGGET, ModItems.ZINC_INGOT, ModBlocks.ZINC_TORCH);
        this.createLanterns(ModBlocks.SILVER_FIRE_LANTERN, ModBlocks.SILVER_SOUL_LANTERN, ModBlocks.SILVER_LANTERN.asItem(), ModItems.SILVER_NUGGET, ModItems.SILVER_INGOT, ModBlocks.SILVER_TORCH);
        this.createLanterns(ModBlocks.TIN_FIRE_LANTERN, ModBlocks.TIN_SOUL_LANTERN, ModBlocks.TIN_LANTERN.asItem(), ModItems.TIN_NUGGET, ModItems.TIN_INGOT, ModBlocks.TIN_TORCH);
        this.createLanterns(ModBlocks.TUNGSTEN_FIRE_LANTERN, ModBlocks.TUNGSTEN_SOUL_LANTERN, ModBlocks.TUNGSTEN_LANTERN.asItem(), ModItems.TUNGSTEN_NUGGET, ModItems.TUNGSTEN_INGOT, ModBlocks.TUNGSTEN_TORCH);
        this.createLanterns(ModBlocks.PLATINUM_FIRE_LANTERN, ModBlocks.PLATINUM_SOUL_LANTERN, ModBlocks.PLATINUM_LANTERN.asItem(), ModItems.PLATINUM_NUGGET, ModItems.PLATINUM_INGOT, ModBlocks.PLATINUM_TORCH);
        this.createLanterns(ModBlocks.GOLD_FIRE_LANTERN, ModBlocks.GOLD_SOUL_LANTERN, ModBlocks.GOLD_LANTERN.asItem(), Items.GOLD_NUGGET, Items.GOLD_INGOT, ModBlocks.GOLD_TORCH);
        this.createLanterns(ModBlocks.LEAD_FIRE_LANTERN, ModBlocks.LEAD_SOUL_LANTERN, ModBlocks.LEAD_LANTERN.asItem(), ModItems.LEAD_NUGGET, ModItems.LEAD_INGOT, ModBlocks.LEAD_TORCH);
        this.createLanterns(ModBlocks.BISMUTH_FIRE_LANTERN, ModBlocks.BISMUTH_SOUL_LANTERN, ModBlocks.BISMUTH_LANTERN.asItem(), ModItems.BISMUTH_NUGGET, ModItems.BISMUTH_INGOT, ModBlocks.BISMUTH_TORCH);
        this.createLanterns(ModBlocks.URANIUM_FIRE_LANTERN, ModBlocks.URANIUM_SOUL_LANTERN, ModBlocks.URANIUM_LANTERN.asItem(), ModItems.URANIUM_NUGGET, ModItems.URANIUM_INGOT, ModBlocks.URANIUM_TORCH);

        this.createLanterns(ModBlocks.NETHERITE_FIRE_LANTERN, ModBlocks.NETHERITE_SOUL_LANTERN, Items.NETHERITE_INGOT, ModItems.NETHERITE_NUGGET);
        this.createLanterns(ModBlocks.BRONZE_FIRE_LANTERN, ModBlocks.BRONZE_SOUL_LANTERN, ModItems.BRONZE_INGOT, ModItems.BRONZE_NUGGET);
        this.createLanterns(ModBlocks.BRASS_FIRE_LANTERN, ModBlocks.BRASS_SOUL_LANTERN, ModItems.BRASS_INGOT, ModItems.BRASS_NUGGET);
        this.createLanterns(ModBlocks.STEEL_FIRE_LANTERN, ModBlocks.STEEL_SOUL_LANTERN, ModItems.STEEL_INGOT, ModItems.STEEL_NUGGET);

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.MONOCRYSTAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONOCRYSTAL_BLOCK);
        oreSmelting(MONOCRYSTAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.MONOCRYSTAL, 1.0F, 200, "monocrystal");
        oreBlasting(MONOCRYSTAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.MONOCRYSTAL, 1.0F, 100, "monocrystal");

        this.threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE, ModItems.SILICON_DUST);
        this.shapeless(RecipeCategory.MISC, ModItems.SILICON_DUST, 2)
                .requires(Ingredient.of(Items.QUARTZ))
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output, "silicon_dust_alt");

        this.shaped(RecipeCategory.DECORATIONS, ModBlocks.SILICENE, 2)
                .define('#', ModItems.SILICON_DUST)
                .pattern("##")
                .unlockedBy("has_silicon_dust", this.has(ModItems.SILICON_DUST))
                .save(this.output);

        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICON_BLOCK, ModItems.SILICON_DUST);
        this.shapeless(RecipeCategory.MISC, ModItems.SILICON_DUST, 4)
                .requires(Ingredient.of(ModBlocks.SILICON_BLOCK.asItem()))
                .unlockedBy("has_silicon_block", this.has(ModBlocks.SILICON_BLOCK))
                .save(this.output);

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO)
                .requires(Items.TUFF)
                .requires(Items.QUARTZ)
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.TUFF, 2)
                .define('Q', Items.QUARTZ)
                .define('C', Items.COBBLED_DEEPSLATE)
                .pattern("CQ")
                .pattern("QC")
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output);


        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE, 2)
                .requires(Items.TUFF)
                .requires(Items.COBBLED_DEEPSLATE)
                .unlockedBy("has_tuff", this.has(Items.TUFF))
                .save(this.output);

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);
        oreSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1.0F, 200, "ruby");
        oreBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.RUBY, 1.0F, 100, "ruby");

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.SAPPHIRE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BLOCK);
        oreSmelting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SAPPHIRE, 1.0F, 200, "sapphire");
        oreBlasting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SAPPHIRE, 1.0F, 100, "sapphire");
    }

    protected void createChain(ItemLike result, ItemLike ingot, ItemLike nugget) {
        this.shaped(RecipeCategory.DECORATIONS, result)
                .define('I', ingot)
                .define('N', nugget)
                .pattern("N")
                .pattern("I")
                .pattern("N")
                .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);
    }

    @Override
    protected RecipeBuilder fenceBuilder(ItemLike fence, Ingredient material) {
        Item item;
        if (fence.asItem().getDescriptionId().contains("stone")) {
            if (fence.asItem().getDescriptionId().contains("sand")) {
                if (fence.asItem().getDescriptionId().contains("red")){
                    item = ModItems.RED_SANDSTONE_BATON;
                } else if (fence.asItem().getDescriptionId().contains("soul")){
                    item = ModItems.SOUL_SANDSTONE_BATON;
                } else {
                    item = ModItems.SANDSTONE_BATON;
                }
            } else if (fence.asItem().getDescriptionId().contains("end")) {
                item = ModItems.END_STONE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("black")) {
                item = ModItems.BLACKSTONE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("drip")) {
                item = Items.POINTED_DRIPSTONE;
            } else {
                item = ModItems.STONE_BATON;
            }
        } else if (fence.asItem().getDescriptionId().contains("prismarine")) {
            if (fence.asItem().getDescriptionId().contains("elder")) {
                item = ModItems.ELDER_PRISMARINE_SHARD;
            } else {
                item = Items.PRISMARINE_SHARD;
            }
        } else if (fence.asItem().getDescriptionId().contains("resin") && !fence.asItem().getDescriptionId().contains("brick")) {
            item = Items.RESIN_CLUMP;
        } else if (fence.asItem().getDescriptionId().contains("sculk") && !fence.asItem().getDescriptionId().contains("brick")) {
            item = Items.SCULK_VEIN;
        } else if (fence.asItem().getDescriptionId().contains("quartz")) {
            item = Items.QUARTZ;
        } else if (fence.asItem().getDescriptionId().contains("lapis")) {
            item = Items.LAPIS_LAZULI;
        } else if (fence.asItem().getDescriptionId().contains("coal") && !fence.asItem().getDescriptionId().contains("char")) {
            item = Items.COAL;
        } else if (fence.asItem().getDescriptionId().contains("charcoal")) {
            item = Items.CHARCOAL;
        } else if (fence.asItem().getDescriptionId().contains("purpur")) {
            item = Items.POPPED_CHORUS_FRUIT;
        } else if (fence.asItem().getDescriptionId().contains("snow")) {
            item = Items.SNOWBALL;
        } else if (fence.asItem().getDescriptionId().contains("granite")) {
            item = ModItems.GRANITE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("diorite")) {
            item = ModItems.DIORITE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("andesite")) {
            item = ModItems.ANDESITE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("tuff")) {
            item = ModItems.TUFF_BATON;
        } else if (fence.asItem().getDescriptionId().contains("obsidian")) {
            item = ModItems.OBSIDIAN_BATON;
        } else if (fence.asItem().getDescriptionId().contains("calcite")) {
            item = ModItems.CALCITE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("mud")) {
            item = ModItems.PACKED_MUD_BATON;
        } else if (fence.asItem().getDescriptionId().contains("basalt")) {
            item = ModItems.BASALT_BATON;
        } else if (fence.asItem().getDescriptionId().contains("netherrack")) {
            item = ModItems.NETHERRACK_BATON;
        } else if (fence.asItem().getDescriptionId().contains("terracotta")) {
            item = ModItems.TERRACOTTA_BATON;
        } else if (fence.asItem().getDescriptionId().contains("concrete")) {
            item = ModItems.CONCRETE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("ice") && !fence.asItem().getDescriptionId().contains("pum")) {
            item = ModItems.ICE_SHARD;
        } else if (fence.asItem().getDescriptionId().contains("deepslate")) {
            item = ModItems.DEEPSLATE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("gabbro")) {
            item = ModItems.GABBRO_BATON;
        } else if (fence.asItem().getDescriptionId().contains("rhyolite")) {
            item = ModItems.RHYOLITE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("pumice")) {
            item = ModItems.PUMICE_BATON;
        } else if (fence.asItem().getDescriptionId().contains("sulfur")) {
            item = Items.SULFUR_SPIKE;
        } else if (fence.asItem().getDescriptionId().contains("cinnabar")) {
            item = ModItems.CINNABAR_BATON;
        } else if (fence.asItem().getDescriptionId().contains("graphite")) {
            item = ModItems.CARBON_DUST;
        } else if (fence.asItem().getDescriptionId().contains("silicite")) {
            item = ModItems.SILICON_DUST;
        } else if (fence.asItem().getDescriptionId().contains("brick")) {
            if (fence.asItem().getDescriptionId().contains("stone")) {
                if (fence.asItem().getDescriptionId().contains("sand")) {
                    if (fence.asItem().getDescriptionId().contains("red")){
                        item = ModItems.RED_SANDSTONE_BATON;
                    } else if (fence.asItem().getDescriptionId().contains("soul")){
                        item = ModItems.SOUL_SANDSTONE_BATON;
                    } else {
                        item = ModItems.SANDSTONE_BATON;
                    }
                } else if (fence.asItem().getDescriptionId().contains("end")) {
                    item = ModItems.END_STONE_BATON;
                } else if (fence.asItem().getDescriptionId().contains("black")) {
                    item = ModItems.BLACKSTONE_BATON;
                } else if (fence.asItem().getDescriptionId().contains("drip")) {
                    item = Items.POINTED_DRIPSTONE;
                } else {
                    item = ModItems.STONE_BATON;
                }
            } else if (fence.asItem().getDescriptionId().contains("prismarine")) {
                if (fence.asItem().getDescriptionId().contains("elder")) {
                    item = ModItems.ELDER_PRISMARINE_SHARD;
                } else {
                    item = Items.PRISMARINE_SHARD;
                }
            } else if (fence.asItem().getDescriptionId().contains("resin")) {
                item = Items.RESIN_BRICK;
            } else if (fence.asItem().getDescriptionId().contains("sculk")) {
                item = ModItems.SCULK_BRICK;
            } else if (fence.asItem().getDescriptionId().contains("quartz")) {
                item = Items.QUARTZ;
            } else if (fence.asItem().getDescriptionId().contains("lapis")) {
                item = Items.LAPIS_LAZULI;
            } else if (fence.asItem().getDescriptionId().contains("coal") && !fence.asItem().getDescriptionId().contains("char")) {
                item = Items.COAL;
            } else if (fence.asItem().getDescriptionId().contains("charcoal")) {
                item = Items.CHARCOAL;
            } else if (fence.asItem().getDescriptionId().contains("purpur")) {
                item = Items.POPPED_CHORUS_FRUIT;
            } else if (fence.asItem().getDescriptionId().contains("snow")) {
                item = Items.SNOWBALL;
            } else if (fence.asItem().getDescriptionId().contains("granite")) {
                item = ModItems.GRANITE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("diorite")) {
                item = ModItems.DIORITE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("andesite")) {
                item = ModItems.ANDESITE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("tuff")) {
                item = ModItems.TUFF_BATON;
            } else if (fence.asItem().getDescriptionId().contains("obsidian")) {
                item = ModItems.OBSIDIAN_BATON;
            } else if (fence.asItem().getDescriptionId().contains("calcite")) {
                item = ModItems.CALCITE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("mud")) {
                item = ModItems.PACKED_MUD_BATON;
            } else if (fence.asItem().getDescriptionId().contains("basalt")) {
                item = ModItems.BASALT_BATON;
            } else if (fence.asItem().getDescriptionId().contains("nether")) {
                item = Items.NETHER_BRICK;
            } else if (fence.asItem().getDescriptionId().contains("terracotta")) {
                item = ModItems.TERRACOTTA_BATON;
            } else if (fence.asItem().getDescriptionId().contains("concrete")) {
                item = ModItems.CONCRETE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("ice") && !fence.asItem().getDescriptionId().contains("pum")) {
                item = ModItems.ICE_SHARD;
            } else if (fence.asItem().getDescriptionId().contains("deepslate")) {
                item = ModItems.DEEPSLATE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("gabbro")) {
                item = ModItems.GABBRO_BATON;
            } else if (fence.asItem().getDescriptionId().contains("rhyolite")) {
                item = ModItems.RHYOLITE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("pumice")) {
                item = ModItems.PUMICE_BATON;
            } else if (fence.asItem().getDescriptionId().contains("sulfur")) {
                item = Items.SULFUR_SPIKE;
            } else if (fence.asItem().getDescriptionId().contains("cinnabar")) {
                item = ModItems.CINNABAR_BATON;
            } else if (fence.asItem().getDescriptionId().contains("graphite")) {
                item = ModItems.CARBON_DUST;
            } else if (fence.asItem().getDescriptionId().contains("silicite")) {
                item = ModItems.SILICON_DUST;
            } else {
                item = Items.BRICK;
            }
        } else {
            item = Items.STICK;
        }

        return this.shaped(RecipeCategory.DECORATIONS, fence, 6).define('W', material).define('#', item).pattern("W#W").pattern("W#W");
    }

    @Override
    protected void chestBoat(ItemLike boat, ItemLike material) {
        this.shapeless(RecipeCategory.TRANSPORTATION, boat)
                .requires(ModItemTags.CHESTS)
                .requires(material)
                .group("chest_boat")
                .unlockedBy("has_boat", this.has(ItemTags.BOATS))
                .save(this.output, getItemName(boat) + "_mod");
    }

    protected void modChestBoat(ItemLike boat, ItemLike material) {
        this.shapeless(RecipeCategory.TRANSPORTATION, boat)
                .requires(ModItemTags.CHESTS)
                .requires(material)
                .group("chest_boat")
                .unlockedBy("has_boat", this.has(ItemTags.BOATS))
                .save(this.output);
    }

    protected void nullifyChestBoat(ItemLike boat, ItemLike material) {
        this.shapeless(RecipeCategory.TRANSPORTATION, boat)
                .requires(Items.CHEST)
                .requires(material)
                .group("chest_boat")
                .unlockedBy("has_boat", this.has(ItemTags.BOATS))
                .save(this.output);
    }

    @Override
    protected void generateForEnabledBlockFamilies(FeatureFlagSet enabledFeatures) {
        ModBlockFamilies.getAllFamilies()
                .filter(
                        BlockFamily::shouldGenerateCraftingRecipe
                ).forEach((p_359455_) -> this.generateRecipes(p_359455_, enabledFeatures));
    }

    protected void createMinecart(ItemLike minecart, ItemLike itemInsideMinecart) {
        this.shapeless(RecipeCategory.TRANSPORTATION, minecart)
                .requires(itemInsideMinecart)
                .requires(Items.MINECART)
                .unlockedBy("has_minecart", this.has(Items.MINECART))
                .save(this.output);

    }

    protected void createWaxedRecipe(RecipeCategory recipeCategory, ItemLike waxedBlock, ItemLike baseBlock) {
        this.shapeless(recipeCategory, waxedBlock)
                .requires(baseBlock)
                .requires(Items.HONEYCOMB)
                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                .save(output, getItemName(baseBlock) + "_waxing");
    }

    protected void createBrewingStand(ItemLike brewingStand, ItemLike stoneType){
        this.shaped(RecipeCategory.BREWING, brewingStand)
                .define('B', Items.BLAZE_ROD)
                .define('#', stoneType)
                .pattern(" B ")
                .pattern("###")
                .unlockedBy("has_blaze_rod", this.has(Items.BLAZE_ROD))
                .save(this.output);
    }

    protected void createChests(ItemLike chest, ItemLike trappedChest, ItemLike planks) {
        this.shaped(RecipeCategory.DECORATIONS, chest)
                .define('#', planks)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_lots_of_items", net.minecraft.advancements.triggers.CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), new InventoryChangeTrigger.TriggerInstance.Slots(MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY), List.of())))
                .save(this.output);

        this.shapeless(RecipeCategory.REDSTONE, trappedChest)
                .requires(chest)
                .requires(Items.TRIPWIRE_HOOK)
                .unlockedBy("has_tripwire_hook", this.has(Items.TRIPWIRE_HOOK))
                .save(this.output);
    }

    protected void createCrafter(ItemLike crafter, ItemLike craftingTable) {
        this.shaped(RecipeCategory.REDSTONE, crafter)
                .define('#', Items.IRON_INGOT)
                .define('C', craftingTable)
                .define('R', Items.REDSTONE)
                .define('D', ModItemTags.DROPPERS)
                .pattern("###")
                .pattern("#C#")
                .pattern("RDR")
                .unlockedBy("has_stone_dropper", this.has(Blocks.DROPPER))
                .unlockedBy("has_blackstone_dropper", this.has(ModBlocks.BLACKSTONE_DROPPER))
                .unlockedBy("has_deepslate_dropper", this.has(ModBlocks.DEEPSLATE_DROPPER))
                .save(this.output);
    }

    protected void createObserver(ItemLike observer, ItemLike stoneType) {
        this.shaped(RecipeCategory.REDSTONE, observer)
                .define('Q', Items.QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', stoneType)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output);
    }

    protected void createDispensersDroppers(ItemLike dispenser, ItemLike dropper, ItemLike stoneIngredient) {
        this.shaped(RecipeCategory.REDSTONE, dispenser)
                .define('R', Items.REDSTONE)
                .define('#', stoneIngredient)
                .define('X', Items.BOW)
                .pattern("###")
                .pattern("#X#")
                .pattern("#R#")
                .unlockedBy("has_bow", this.has(Items.BOW))
                .save(this.output);

        this.shaped(RecipeCategory.REDSTONE, dropper)
                .define('R', Items.REDSTONE)
                .define('#', stoneIngredient)
                .pattern("###")
                .pattern("# #")
                .pattern("#R#")
                .unlockedBy("has_redstone", this.has(Items.REDSTONE))
                .save(this.output);
    }

    protected void createChiseledBookshelf(ItemLike chiseledBookshelf, ItemLike woodPlanks, ItemLike woodSlabs) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, chiseledBookshelf)
                .define('#', woodPlanks)
                .define('X', woodSlabs)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output);
    }

    protected void createBarrel(ItemLike barrel, ItemLike woodPlanks, ItemLike woodSlabs) {
        this.shaped(RecipeCategory.DECORATIONS, barrel, 1)
                .define('P', woodPlanks)
                .define('S', woodSlabs)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .unlockedBy("has_" + getItemName(woodPlanks), this.has(woodPlanks))
                .unlockedBy("has_" + getItemName(woodSlabs), this.has(woodSlabs))
                .save(this.output);
    }

    protected void createBookshelf(ItemLike bookshelf, ItemLike woodType) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, bookshelf)
                .define('#', woodType)
                .define('X', Items.BOOK)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output);

    }

    protected void createLectern(ItemLike lectern, ItemLike bookshelf, ItemLike slab) {
        this.shaped(RecipeCategory.REDSTONE, lectern)
                .define('S', slab)
                .define('B', bookshelf)
                .pattern("SSS")
                .pattern(" B ")
                .pattern(" S ")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output);
    }

    protected void createBeehive(ItemLike beehive, ItemLike woodType) {
        this.shaped(RecipeCategory.DECORATIONS, beehive)
                .define('P', woodType)
                .define('H', Items.HONEYCOMB)
                .pattern("PPP")
                .pattern("HHH")
                .pattern("PPP")
                .unlockedBy("has_honeycomb", this.has(Items.HONEYCOMB))
                .save(this.output);
    }

    protected void createCampfires(ItemLike campfire, ItemLike soulCampfire, TagKey logType){
        this.shaped(RecipeCategory.DECORATIONS, campfire)
                .define('L', logType)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", this.has(Items.STICK))
                .unlockedBy("has_coal", this.has(ItemTags.COALS))
                .save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, soulCampfire)
                .define('L', logType)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", this.has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(this.output);
    }

    protected void createFurnace(ItemLike furnace, ItemLike stoneType, String baseBlockId) {
        this.shaped(RecipeCategory.DECORATIONS, furnace)
                .define('#', stoneType)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + baseBlockId, this.has(stoneType))
                .save(this.output);
    }

    protected void createSmoker(ItemLike smoker, ItemLike furnace, ItemLike woodType, String baseBlockId) {
        this.shaped(RecipeCategory.DECORATIONS, smoker)
                .define('#', woodType)
                .define('X', furnace)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy("has_" + baseBlockId, this.has(furnace))
                .save(this.output);
    }

    protected void createBlastFurnace(ItemLike blastFurnace, ItemLike furnace, ItemLike polishedStoneType, String baseBlockId) {
        this.shaped(RecipeCategory.DECORATIONS, blastFurnace)
                .define('#', polishedStoneType)
                .define('X', furnace)
                .define('I', Items.IRON_INGOT)
                .pattern("III")
                .pattern("IXI")
                .pattern("###")
                .unlockedBy("has_" + baseBlockId, this.has(polishedStoneType))
                .save(this.output);
    }

    protected void fletching(ItemLike result, Item arrow, Item ingredient) {
        FletchingRecipeBuilder.fletching(Ingredient.of(arrow), Ingredient.of(ingredient), result).unlockedBy(getHasName(arrow), this.has(arrow)).save(this.output, getItemName(result));
    }

    protected void eightyOneBlockStorageRecipes(RecipeCategory nuggetCategory, ItemLike nugget, RecipeCategory ingotCategory, ItemLike ingot, String ingotName, @Nullable String ingotGroup, String nuggetName, @Nullable String nuggetGroup, RecipeCategory blockCategory, ItemLike block, String blockName, @Nullable String blockGroup) {
        this.shapeless(nuggetCategory, nugget, 9).requires(ingot).group(nuggetGroup).unlockedBy(getHasName(ingot), this.has(ingot)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(nuggetName)));
        this.shaped(ingotCategory, ingot).define('#', nugget).pattern("###").pattern("###").pattern("###").group(ingotGroup).unlockedBy(getHasName(nugget), this.has(nugget)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(ingotName)));

        this.shapeless(ingotCategory, ingot, 9).requires(block).group(ingotGroup).unlockedBy(getHasName(block), this.has(block)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(ingotName + "_b")));
        this.shaped(blockCategory, block).define('#', ingot).pattern("###").pattern("###").pattern("###").group(blockGroup).unlockedBy(getHasName(ingot), this.has(ingot)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(blockName)));
    }

    protected void createCraftingTable(ItemLike craftingTable, ItemLike planks){
        this.shaped(RecipeCategory.DECORATIONS, craftingTable)
                .define('#', planks)
                .pattern("##")
                .pattern("##")
                .unlockedBy("unlock_right_away", PlayerTrigger.TriggerInstance.tick())
                .showNotification(false)
                .save(this.output);
    }

    protected void createGrindstone(ItemLike grindstone, ItemLike planks) {
        this.shaped(RecipeCategory.DECORATIONS, grindstone)
                .define('I', Items.STICK)
                .define('-', Items.STONE_SLAB)
                .define('#', planks)
                .pattern("I-I")
                .pattern("# #")
                .unlockedBy("has_stone_slab", this.has(Blocks.STONE_SLAB))
                .save(this.output);
    }

    protected void createCartographyTable(ItemLike cartograhyTable, ItemLike planks){
        this.shaped(RecipeCategory.DECORATIONS, cartograhyTable)
                .define('#', planks)
                .define('@', Items.PAPER)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_paper", this.has(Items.PAPER))
                .save(this.output);
    }

    protected void createFletchingTable(ItemLike fletchingTable, ItemLike planks) {
        this.shaped(RecipeCategory.DECORATIONS, fletchingTable)
                .define('#', planks)
                .define('@', Items.FLINT)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_flint", this.has(Items.FLINT))
                .save(this.output);
    }

    protected void createSmithingTable(ItemLike smithingTable, ItemLike planks) {
        this.shaped(RecipeCategory.DECORATIONS, smithingTable)
                .define('#', planks)
                .define('@', Items.IRON_INGOT)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output);
    }

    protected void createLoom(ItemLike loom, ItemLike planks) {
        this.shaped(RecipeCategory.DECORATIONS, loom)
                .define('#', planks)
                .define('@', Items.STRING)
                .pattern("@@")
                .pattern("##")
                .unlockedBy("has_string", this.has(Items.STRING))
                .save(this.output);
    }

    protected void createBaton(ItemLike baton, ItemLike ingredient, String ingredientName) {
        this.shaped(RecipeCategory.MISC, baton, 4)
                .define('#', ingredient)
                .pattern("#")
                .pattern("#")
                .group("sticks")
                .unlockedBy("has_" + ingredientName, this.has(ingredient))
                .save(this.output);
    }

    protected void createBaton(ItemLike baton, TagKey<Item> ingredient, String ingredientName) {
        this.shaped(RecipeCategory.MISC, baton, 4)
                .define('#', ingredient)
                .pattern("#")
                .pattern("#")
                .group("sticks")
                .unlockedBy("has_" + ingredientName, this.has(ingredient))
                .save(this.output);
    }

    protected void createBatonWithCustomCount(ItemLike baton, ItemLike ingredient, String ingredientName, int count) {
        this.shaped(RecipeCategory.MISC, baton, count)
                .define('#', ingredient)
                .pattern("#")
                .pattern("#")
                .group("sticks")
                .unlockedBy("has_" + ingredientName, this.has(ingredient))
                .save(this.output, getItemName(baton) + "_mod");
    }

    protected void coloredTerracottaSlabFromTerracottaSlabAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModBlocks.TERRACOTTA_SLAB)
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_slabs")
                .unlockedBy("has_terracotta_slab", this.has(ModBlocks.TERRACOTTA_SLAB))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaStairsFromTerracottaStairsAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModBlocks.TERRACOTTA_STAIRS)
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_stairs")
                .unlockedBy("has_terracotta_stairs", this.has(ModBlocks.TERRACOTTA_STAIRS))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaWallFromTerracottaWallAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModBlocks.TERRACOTTA_WALL)
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_walls")
                .unlockedBy("has_terracotta_wall", this.has(ModBlocks.TERRACOTTA_WALL))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaFenceFromTerracottaFenceAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModBlocks.TERRACOTTA_FENCE)
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_fences")
                .unlockedBy("has_terracotta_fence", this.has(ModBlocks.TERRACOTTA_FENCE))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void copyBronzeSmithingTemplate(ItemLike template, ItemLike baseItem) {
        this.shaped(RecipeCategory.MISC, template, 2).define('#', Items.COPPER_INGOT).define('C', baseItem).define('S', template).pattern("#S#").pattern("#C#").pattern("###").unlockedBy(getHasName(template), this.has(template)).save(this.output);
    }

    protected void bronzeSmithing(Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ingredientItem), this.tag(ModItemTags.BRONZE_TOOL_MATERIALS), category, resultItem).unlocks("has_bronze_ingot", this.has(ModItemTags.BRONZE_TOOL_MATERIALS)).save(this.output, getItemName(resultItem) + "_smithing");
    }

    protected void flameTestTorch(ItemLike result, ItemLike nugget) {
        this.shaped(RecipeCategory.DECORATIONS, result, 4).define('X', Ingredient.of(new ItemLike[]{Items.COAL, Items.CHARCOAL})).define('#', Items.STICK).define('C', nugget).pattern("C").pattern("X").pattern("#").unlockedBy("has_" + getItemName(nugget), this.has(nugget)).save(this.output);
    }

    protected void createLanterns(ItemLike normal, ItemLike soul, ItemLike flameTest, ItemLike nugget, ItemLike ingot, ItemLike flameTestTorch) {
        if (flameTest == Items.LANTERN) {
            this.shaped(RecipeCategory.DECORATIONS, flameTest)
                    .define('#', Items.TORCH)
                    .define('X', nugget)
                    .pattern("XXX")
                    .pattern("X#X")
                    .pattern("XXX")
                    .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                    .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);

            this.shaped(RecipeCategory.DECORATIONS, flameTest)
                    .define('#', flameTestTorch)
                    .define('X', nugget)
                    .pattern("XXX")
                    .pattern("X#X")
                    .pattern("XXX")
                    .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                    .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output, "lantern_mod");
        } else {
            this.shaped(RecipeCategory.DECORATIONS, flameTest)
                    .define('#', flameTestTorch)
                    .define('X', nugget)
                    .pattern("XXX")
                    .pattern("X#X")
                    .pattern("XXX")
                    .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                    .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);
        }

        this.shaped(RecipeCategory.DECORATIONS, normal)
                .define('#', Items.TORCH)
                .define('X', nugget)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, soul)
                .define('#', Items.SOUL_TORCH)
                .define('X', nugget)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);
    }

    protected void createLanterns(ItemLike normal, ItemLike soul, ItemLike nugget, ItemLike ingot) {
        this.shaped(RecipeCategory.DECORATIONS, normal)
                .define('#', Items.TORCH)
                .define('X', nugget)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, soul)
                .define('#', Items.SOUL_TORCH)
                .define('X', nugget)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .unlockedBy("has_" + getItemName(nugget), this.has(nugget))
                .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output);
    }

    private void waxedBlocks() {
        for (RustingIronCollection<Block> collection : RUSTING_IRON_COLLECTIONS) {
            if (collection.weathering().unaffected() instanceof RustingIronFullBlock || collection.weathering().unaffected() instanceof RustingIronSlabBlock || collection.weathering().unaffected() instanceof RustingIronStairBlock || collection.weathering().unaffected() instanceof RustingIronGrateBlock) {
                RustingIron.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.BUILDING_BLOCKS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof RustingIronBarsBlock || collection.weathering().unaffected() instanceof RustingIronLanternBlock || collection.weathering().unaffected() instanceof RustingIronChainBlock) {
                RustingIron.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof RustingIronDoorBlock || collection.weathering().unaffected() instanceof RustingIronTrapDoorBlock || collection.weathering().unaffected() instanceof RustingIronWeightedPressurePlateBlock || collection.weathering().unaffected() instanceof RustingIronBulbBlock) {
                RustingIron.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            }
        }

        for (WeatheringCopperCollection<Block> collection : WEATHERING_COPPER_COLLECTIONS) {
            if (collection.weathering().unaffected() instanceof WeatheringCopperFullBlock || collection.weathering().unaffected() instanceof WeatheringCopperSlabBlock || collection.weathering().unaffected() instanceof WeatheringCopperStairBlock || collection.weathering().unaffected() instanceof WeatheringCopperGrateBlock) {
                WeatheringCopper.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.BUILDING_BLOCKS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof WeatheringCopperBarsBlock || collection.weathering().unaffected() instanceof WeatheringLanternBlock || collection.weathering().unaffected() instanceof WeatheringCopperChainBlock) {
                WeatheringCopper.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof WeatheringCopperDoorBlock || collection.weathering().unaffected() instanceof WeatheringCopperTrapDoorBlock || collection.weathering().unaffected() instanceof WeatheringCopperWeightedPressurePlateBlock || collection.weathering().unaffected() instanceof WeatheringCopperBulbBlock) {
                WeatheringCopper.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            }
        }

        for (CorrodingZincCollection<Block> collection : CORRODING_ZINC_COLLECTIONS) {
            if (collection.weathering().unaffected() instanceof CorrodingZincFullBlock || collection.weathering().unaffected() instanceof CorrodingZincSlabBlock || collection.weathering().unaffected() instanceof CorrodingZincStairBlock || collection.weathering().unaffected() instanceof CorrodingZincGrateBlock) {
                CorrodingZinc.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.BUILDING_BLOCKS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof CorrodingZincLanternBlock || collection.weathering().unaffected() instanceof CorrodingZincChainBlock) {
                CorrodingZinc.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            } else if (collection.weathering().unaffected() instanceof CorrodingZincDoorBlock || collection.weathering().unaffected() instanceof CorrodingZincTrapDoorBlock || collection.weathering().unaffected() instanceof CorrodingZincWeightedPressurePlateBlock || collection.weathering().unaffected() instanceof CorrodingZincBulbBlock) {
                CorrodingZinc.WeatherState.forEach((statex) -> createWaxedRecipe(RecipeCategory.DECORATIONS, collection.waxed().pick(statex), collection.weathering().pick(statex)));
            }
        }
    }

    private void stoneCuttingRecipes() {
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRANITE_WALL, Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRANITE_WALL, Items.POLISHED_GRANITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DIORITE_WALL, Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DIORITE_WALL, Items.POLISHED_DIORITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_ANDESITE_WALL, Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_ANDESITE_WALL, Items.POLISHED_ANDESITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PRISMARINE_BRICK_WALL, Items.PRISMARINE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DARK_PRISMARINE_WALL, Items.DARK_PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_WALL, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_SANDSTONE_WALL, Items.SMOOTH_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_RED_SANDSTONE_WALL, Items.SMOOTH_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.QUARTZ_WALL, Items.QUARTZ_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_QUARTZ_WALL, Items.SMOOTH_QUARTZ);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PURPUR_WALL, Items.PURPUR_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_STAIRS, Items.SMOOTH_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_STONE_WALL, Items.SMOOTH_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS, Items.CUT_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_SANDSTONE_WALL, Items.CUT_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS, Items.SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_SANDSTONE_WALL, Items.SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS, Items.CUT_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_RED_SANDSTONE_WALL, Items.CUT_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS, Items.RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_RED_SANDSTONE_WALL, Items.RED_SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_SLAB, Items.CRACKED_STONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_STAIRS, Items.CRACKED_STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_STONE_BRICK_WALL, Items.CRACKED_STONE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_SLAB, Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_STAIRS, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BASALT_WALL, Items.BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BASALT_SLAB, Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BASALT_STAIRS, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_BASALT_WALL, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BASALT_SLAB, Items.POLISHED_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BASALT_STAIRS, Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_BASALT_WALL, Items.POLISHED_BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_SLAB, Items.SMOOTH_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_STAIRS, Items.SMOOTH_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_BASALT_WALL, Items.SMOOTH_BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_SLAB, Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_STAIRS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_WALL, Items.DEEPSLATE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB, Items.CRACKED_DEEPSLATE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS, Items.CRACKED_DEEPSLATE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL, Items.CRACKED_DEEPSLATE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB, Items.CRACKED_DEEPSLATE_TILES, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS, Items.CRACKED_DEEPSLATE_TILES);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_DEEPSLATE_TILE_WALL, Items.CRACKED_DEEPSLATE_TILES);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_SLAB, Items.CRACKED_NETHER_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_STAIRS, Items.CRACKED_NETHER_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_NETHER_BRICK_WALL, Items.CRACKED_NETHER_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_SLAB, Items.NETHERRACK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_STAIRS, Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.NETHERRACK_WALL, Items.NETHERRACK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB, Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CALCITE_WALL, Items.CALCITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB, Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_CALCITE_WALL, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB, ModBlocks.POLISHED_CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS, ModBlocks.POLISHED_CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_CALCITE_WALL, ModBlocks.POLISHED_CALCITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_SLAB, Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_STAIRS, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DRIPSTONE_WALL, Items.DRIPSTONE_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB, Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_STAIRS, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DRIPSTONE_WALL, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB, ModBlocks.POLISHED_DRIPSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_STAIRS, ModBlocks.POLISHED_DRIPSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DRIPSTONE_WALL, ModBlocks.POLISHED_DRIPSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_SLAB, Items.GRANITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_STAIRS, Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRANITE_BRICK_WALL, Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_SLAB, Items.POLISHED_GRANITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_STAIRS, Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRANITE_BRICK_WALL, Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_SLAB, ModBlocks.POLISHED_GRANITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICK_STAIRS, ModBlocks.POLISHED_GRANITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRANITE_BRICK_WALL, ModBlocks.POLISHED_GRANITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_SLAB, Items.DIORITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_STAIRS, Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DIORITE_BRICK_WALL, Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_SLAB, Items.POLISHED_DIORITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_STAIRS, Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DIORITE_BRICK_WALL, Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_SLAB, ModBlocks.POLISHED_DIORITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICK_STAIRS, ModBlocks.POLISHED_DIORITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_DIORITE_BRICK_WALL, ModBlocks.POLISHED_DIORITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_SLAB, Items.ANDESITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS, Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_ANDESITE_BRICK_WALL, Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_SLAB, Items.POLISHED_ANDESITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS, Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_ANDESITE_BRICK_WALL, Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_SLAB, ModBlocks.POLISHED_ANDESITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICK_STAIRS, ModBlocks.POLISHED_ANDESITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_ANDESITE_BRICK_WALL, ModBlocks.POLISHED_ANDESITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_SLAB, Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_STAIRS, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CALCITE_BRICK_WALL, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS, Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_SLAB, ModBlocks.POLISHED_CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_STAIRS, ModBlocks.POLISHED_CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CALCITE_BRICK_WALL, ModBlocks.POLISHED_CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS, ModBlocks.POLISHED_CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_SLAB, ModBlocks.CALCITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICK_STAIRS, ModBlocks.CALCITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CALCITE_BRICK_WALL, ModBlocks.CALCITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_SLAB, Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_STAIRS, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DRIPSTONE_BRICK_WALL, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS, Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_SLAB, ModBlocks.POLISHED_DRIPSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_STAIRS, ModBlocks.POLISHED_DRIPSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DRIPSTONE_BRICK_WALL, ModBlocks.POLISHED_DRIPSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS, ModBlocks.POLISHED_DRIPSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_SLAB, ModBlocks.DRIPSTONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICK_STAIRS, ModBlocks.DRIPSTONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DRIPSTONE_BRICK_WALL, ModBlocks.DRIPSTONE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_SLAB, Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_STAIRS, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BASALT_BRICK_WALL, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICKS, Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_SLAB, Items.POLISHED_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_STAIRS, Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BASALT_BRICK_WALL, Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICKS, Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_SLAB, ModBlocks.BASALT_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_BRICK_STAIRS, ModBlocks.BASALT_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BASALT_BRICK_WALL, ModBlocks.BASALT_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_SLAB, Items.END_STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_STAIRS, Items.END_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.END_STONE_WALL, Items.END_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB, Items.QUARTZ_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS, Items.QUARTZ_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.QUARTZ_BRICK_WALL, Items.QUARTZ_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB, Items.QUARTZ_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS, Items.QUARTZ_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.QUARTZ_BRICK_WALL, Items.QUARTZ_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_MUD_SLAB, Items.PACKED_MUD, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_MUD_STAIRS, Items.PACKED_MUD);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PACKED_MUD_WALL, Items.PACKED_MUD);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_SLAB, Items.RESIN_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_STAIRS, Items.RESIN_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.RESIN_WALL, Items.RESIN_BLOCK);

        RustingIronCollection.zipApply(ModBlocks.CUT_IRON, ModBlocks.IRON_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));
        RustingIronCollection.zipApply(ModBlocks.CUT_IRON_STAIRS, ModBlocks.IRON_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));
        RustingIronCollection.zipApply(ModBlocks.CUT_IRON_SLAB, ModBlocks.IRON_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 8));
        RustingIronCollection.zipApply(ModBlocks.CUT_IRON_STAIRS, ModBlocks.CUT_IRON, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        RustingIronCollection.zipApply(ModBlocks.CUT_IRON_SLAB, ModBlocks.CUT_IRON, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));

        CorrodingZincCollection.zipApply(ModBlocks.CUT_ZINC, ModBlocks.ZINC_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));
        CorrodingZincCollection.zipApply(ModBlocks.CUT_ZINC_STAIRS, ModBlocks.ZINC_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));
        CorrodingZincCollection.zipApply(ModBlocks.CUT_ZINC_SLAB, ModBlocks.ZINC_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 8));
        CorrodingZincCollection.zipApply(ModBlocks.CUT_ZINC_STAIRS, ModBlocks.CUT_ZINC, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        CorrodingZincCollection.zipApply(ModBlocks.CUT_ZINC_SLAB, ModBlocks.CUT_ZINC, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD, Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_STAIRS, Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_SLAB, Items.GOLD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_STAIRS, ModBlocks.CUT_GOLD);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_SLAB, ModBlocks.CUT_GOLD, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DIAMOND, Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DIAMOND_STAIRS, Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DIAMOND_SLAB, Items.DIAMOND_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DIAMOND_STAIRS, ModBlocks.CUT_DIAMOND);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_DIAMOND_SLAB, ModBlocks.CUT_DIAMOND, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_EMERALD, Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_EMERALD_STAIRS, Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_EMERALD_SLAB, Items.EMERALD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_EMERALD_STAIRS, ModBlocks.CUT_EMERALD);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_EMERALD_SLAB, ModBlocks.CUT_EMERALD, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_NETHERITE, Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_NETHERITE_STAIRS, Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_NETHERITE_SLAB, Items.NETHERITE_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_NETHERITE_STAIRS, ModBlocks.CUT_NETHERITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_NETHERITE_SLAB, ModBlocks.CUT_NETHERITE, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB, ModBlocks.SOUL_SANDSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_STAIRS, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE_SLAB, ModBlocks.SOUL_SANDSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE_STAIRS, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE_SLAB, ModBlocks.CUT_SOUL_SANDSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE_STAIRS, ModBlocks.CUT_SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CUT_SOUL_SANDSTONE_WALL, ModBlocks.CUT_SOUL_SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, ModBlocks.SMOOTH_SOUL_SANDSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, ModBlocks.SMOOTH_SOUL_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL, ModBlocks.SMOOTH_SOUL_SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE_SLAB, ModBlocks.ELDER_PRISMARINE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE_STAIRS, ModBlocks.ELDER_PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ELDER_PRISMARINE_WALL, ModBlocks.ELDER_PRISMARINE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE_BRICK_SLAB, ModBlocks.ELDER_PRISMARINE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_PRISMARINE_BRICK_STAIRS, ModBlocks.ELDER_PRISMARINE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ELDER_PRISMARINE_BRICK_WALL, ModBlocks.ELDER_PRISMARINE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_ELDER_PRISMARINE_SLAB, ModBlocks.DARK_ELDER_PRISMARINE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_ELDER_PRISMARINE_STAIRS, ModBlocks.DARK_ELDER_PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DARK_ELDER_PRISMARINE_WALL, ModBlocks.DARK_ELDER_PRISMARINE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SILVER, ModBlocks.SILVER_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SILVER_STAIRS, ModBlocks.SILVER_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SILVER_SLAB, ModBlocks.SILVER_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SILVER_STAIRS, ModBlocks.CUT_SILVER);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SILVER_SLAB, ModBlocks.CUT_SILVER, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN, ModBlocks.TIN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_STAIRS, ModBlocks.TIN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.TIN_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_STAIRS, ModBlocks.CUT_TIN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.CUT_TIN, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TUNGSTEN, ModBlocks.TUNGSTEN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TUNGSTEN_STAIRS, ModBlocks.TUNGSTEN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TUNGSTEN_SLAB, ModBlocks.TUNGSTEN_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TUNGSTEN_STAIRS, ModBlocks.CUT_TUNGSTEN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TUNGSTEN_SLAB, ModBlocks.CUT_TUNGSTEN, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATINUM, ModBlocks.PLATINUM_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATINUM_STAIRS, ModBlocks.PLATINUM_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATINUM_SLAB, ModBlocks.PLATINUM_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATINUM_STAIRS, ModBlocks.CUT_PLATINUM);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PLATINUM_SLAB, ModBlocks.CUT_PLATINUM, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_LEAD, ModBlocks.LEAD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_LEAD_STAIRS, ModBlocks.LEAD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_LEAD_SLAB, ModBlocks.LEAD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_LEAD_STAIRS, ModBlocks.CUT_LEAD);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_LEAD_SLAB, ModBlocks.CUT_LEAD, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM, ModBlocks.URANIUM_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_STAIRS, ModBlocks.URANIUM_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_SLAB, ModBlocks.URANIUM_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_STAIRS, ModBlocks.CUT_URANIUM);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_URANIUM_SLAB, ModBlocks.CUT_URANIUM, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE, ModBlocks.BRONZE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_STAIRS, ModBlocks.BRONZE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_SLAB, ModBlocks.BRONZE_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_STAIRS, ModBlocks.CUT_BRONZE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRONZE_SLAB, ModBlocks.CUT_BRONZE, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRASS, ModBlocks.BRASS_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRASS_STAIRS, ModBlocks.BRASS_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRASS_SLAB, ModBlocks.BRASS_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRASS_STAIRS, ModBlocks.CUT_BRASS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BRASS_SLAB, ModBlocks.CUT_BRASS, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_STEEL, ModBlocks.STEEL_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_STEEL_STAIRS, ModBlocks.STEEL_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_STEEL_SLAB, ModBlocks.STEEL_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_STEEL_STAIRS, ModBlocks.CUT_STEEL);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_STEEL_SLAB, ModBlocks.CUT_STEEL, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_SLAB, Items.OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_STAIRS, Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_WALL, Items.OBSIDIAN);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_SLAB, Items.CRYING_OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_STAIRS, Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRYING_OBSIDIAN_WALL, Items.CRYING_OBSIDIAN);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Items.ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_STAIRS, Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ICE_WALL, Items.ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Items.PACKED_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_STAIRS, Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PACKED_ICE_WALL, Items.PACKED_ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_SLAB, Items.BLUE_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_STAIRS, Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BLUE_ICE_WALL, Items.BLUE_ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_SLAB, Items.TERRACOTTA, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_STAIRS, Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.TERRACOTTA_WALL, Items.TERRACOTTA);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_SLAB, Items.SCULK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_STAIRS, Items.SCULK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SCULK_WALL, Items.SCULK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_SLAB, Items.COAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_STAIRS, Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.COAL_WALL, Items.COAL_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_SLAB, Items.LAPIS_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_STAIRS, Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.LAPIS_WALL, Items.LAPIS_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_SLAB, Items.SNOW_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_STAIRS, Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SNOW_WALL, Items.SNOW_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_SLAB, ModBlocks.CHARCOAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_STAIRS, ModBlocks.CHARCOAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CHARCOAL_WALL, ModBlocks.CHARCOAL_BLOCK);

        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_SLAB, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_STAIRS, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_WALL, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICKS, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_WALL, Items.DYED_TERRACOTTA, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_SLAB, ModBlocks.DYED_TERRACOTTA_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_STAIRS, ModBlocks.DYED_TERRACOTTA_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.DYED_TERRACOTTA_BRICK_WALL, ModBlocks.DYED_TERRACOTTA_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));

        ColorCollection.zipApply(ModBlocks.CONCRETE_SLAB, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.CONCRETE_STAIRS, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_WALL, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICKS, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_SLAB, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_STAIRS, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_WALL, Items.CONCRETE, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_SLAB, ModBlocks.CONCRETE_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 2));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_STAIRS, ModBlocks.CONCRETE_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input));
        ColorCollection.zipApply(ModBlocks.CONCRETE_BRICK_WALL, ModBlocks.CONCRETE_BRICKS, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, result, input));

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILES, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_SLAB, Items.STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_STAIRS, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_TILE_WALL, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILES, Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_SLAB, Items.STONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_STAIRS, Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_TILE_WALL, Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_SLAB, ModBlocks.STONE_TILES, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_STAIRS, ModBlocks.STONE_TILES);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_TILE_WALL, ModBlocks.STONE_TILES);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_TILE_SLAB, ModBlocks.MOSSY_STONE_TILES, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_STONE_TILE_STAIRS, ModBlocks.MOSSY_STONE_TILES);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.MOSSY_STONE_TILE_WALL, ModBlocks.MOSSY_STONE_TILES);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_TILE_SLAB, ModBlocks.CRACKED_STONE_TILES, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_TILE_STAIRS, ModBlocks.CRACKED_STONE_TILES);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRACKED_STONE_TILE_WALL, ModBlocks.CRACKED_STONE_TILES);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICKS, Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, Items.OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_BRICK_WALL, Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_SLAB, ModBlocks.OBSIDIAN_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_BRICK_STAIRS, ModBlocks.OBSIDIAN_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_BRICK_WALL, ModBlocks.OBSIDIAN_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_BRICKS, Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB, Items.CRYING_OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS, Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRYING_OBSIDIAN_BRICK_WALL, Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB, ModBlocks.CRYING_OBSIDIAN_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS, ModBlocks.CRYING_OBSIDIAN_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CRYING_OBSIDIAN_BRICK_WALL, ModBlocks.CRYING_OBSIDIAN_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_BRICKS, Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_BRICK_SLAB, Items.COAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_BRICK_STAIRS, Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.COAL_BRICK_WALL, Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_BRICK_SLAB, ModBlocks.COAL_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COAL_BRICK_STAIRS, ModBlocks.COAL_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.COAL_BRICK_WALL, ModBlocks.COAL_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BRICKS, ModBlocks.CHARCOAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BRICK_SLAB, ModBlocks.CHARCOAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BRICK_STAIRS, ModBlocks.CHARCOAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CHARCOAL_BRICK_WALL, ModBlocks.CHARCOAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BRICK_SLAB, ModBlocks.CHARCOAL_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHARCOAL_BRICK_STAIRS, ModBlocks.CHARCOAL_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CHARCOAL_BRICK_WALL, ModBlocks.CHARCOAL_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_BRICKS, Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_BRICK_SLAB, Items.LAPIS_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_BRICK_STAIRS, Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.LAPIS_BRICK_WALL, Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_BRICK_SLAB, ModBlocks.LAPIS_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_BRICK_STAIRS, ModBlocks.LAPIS_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.LAPIS_BRICK_WALL, ModBlocks.LAPIS_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_LAPIS_SLAB, ModBlocks.SMOOTH_LAPIS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_LAPIS_STAIRS, ModBlocks.SMOOTH_LAPIS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_LAPIS_WALL, ModBlocks.SMOOTH_LAPIS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICKS, Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_SLAB, Items.SNOW_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_STAIRS, Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SNOW_BRICK_WALL, Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_SLAB, ModBlocks.SNOW_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_STAIRS, ModBlocks.SNOW_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SNOW_BRICK_WALL, ModBlocks.SNOW_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_BRICKS, Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_BRICK_SLAB, Items.ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_BRICK_STAIRS, Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ICE_BRICK_WALL, Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_BRICK_SLAB, ModBlocks.ICE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_BRICK_STAIRS, ModBlocks.ICE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ICE_BRICK_WALL, ModBlocks.ICE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICKS, Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_SLAB, Items.PACKED_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_STAIRS, Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PACKED_ICE_BRICK_WALL, Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_SLAB, ModBlocks.PACKED_ICE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_BRICK_STAIRS, ModBlocks.PACKED_ICE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PACKED_ICE_BRICK_WALL, ModBlocks.PACKED_ICE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_BRICKS, Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_BRICK_SLAB, Items.BLUE_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_BRICK_STAIRS, Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BLUE_ICE_BRICK_WALL, Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_BRICK_SLAB, ModBlocks.BLUE_ICE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_BRICK_STAIRS, ModBlocks.BLUE_ICE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BLUE_ICE_BRICK_WALL, ModBlocks.BLUE_ICE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_BRICK_SLAB, ModBlocks.SCULK_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULK_BRICK_STAIRS, ModBlocks.SCULK_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SCULK_BRICK_WALL, ModBlocks.SCULK_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SCULK_BRICKS, ModBlocks.SCULK_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST, Items.AMETHYST_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST_STAIRS, Items.AMETHYST_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST_SLAB, Items.AMETHYST_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST_STAIRS, ModBlocks.CUT_AMETHYST);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_AMETHYST_SLAB, ModBlocks.CUT_AMETHYST, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_SLAB, ModBlocks.GABBRO, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_STAIRS, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GABBRO_WALL, ModBlocks.GABBRO);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GABBRO_SLAB, ModBlocks.GABBRO, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GABBRO_STAIRS, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GABBRO_WALL, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GABBRO, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GABBRO_SLAB, ModBlocks.POLISHED_GABBRO, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GABBRO_STAIRS, ModBlocks.POLISHED_GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GABBRO_WALL, ModBlocks.POLISHED_GABBRO);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_SLAB, ModBlocks.GABBRO, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_STAIRS, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GABBRO_BRICK_WALL, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICKS, ModBlocks.GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_SLAB, ModBlocks.POLISHED_GABBRO, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_STAIRS, ModBlocks.POLISHED_GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GABBRO_BRICK_WALL, ModBlocks.POLISHED_GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICKS, ModBlocks.POLISHED_GABBRO);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_SLAB, ModBlocks.GABBRO_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GABBRO_BRICK_STAIRS, ModBlocks.GABBRO_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GABBRO_BRICK_WALL, ModBlocks.GABBRO_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_SLAB, ModBlocks.RHYOLITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_STAIRS, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.RHYOLITE_WALL, ModBlocks.RHYOLITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RHYOLITE_SLAB, ModBlocks.RHYOLITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RHYOLITE_STAIRS, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_RHYOLITE_WALL, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RHYOLITE, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RHYOLITE_SLAB, ModBlocks.POLISHED_RHYOLITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RHYOLITE_STAIRS, ModBlocks.POLISHED_RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_RHYOLITE_WALL, ModBlocks.POLISHED_RHYOLITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_SLAB, ModBlocks.RHYOLITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_STAIRS, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.RHYOLITE_BRICK_WALL, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICKS, ModBlocks.RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_SLAB, ModBlocks.POLISHED_RHYOLITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_STAIRS, ModBlocks.POLISHED_RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.RHYOLITE_BRICK_WALL, ModBlocks.POLISHED_RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICKS, ModBlocks.POLISHED_RHYOLITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_SLAB, ModBlocks.RHYOLITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RHYOLITE_BRICK_STAIRS, ModBlocks.RHYOLITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.RHYOLITE_BRICK_WALL, ModBlocks.RHYOLITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_SLAB, ModBlocks.PUMICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_STAIRS, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PUMICE_WALL, ModBlocks.PUMICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PUMICE_SLAB, ModBlocks.PUMICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PUMICE_STAIRS, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_PUMICE_WALL, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PUMICE, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PUMICE_SLAB, ModBlocks.POLISHED_PUMICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_PUMICE_STAIRS, ModBlocks.POLISHED_PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_PUMICE_WALL, ModBlocks.POLISHED_PUMICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_SLAB, ModBlocks.PUMICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_STAIRS, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PUMICE_BRICK_WALL, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICKS, ModBlocks.PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_SLAB, ModBlocks.POLISHED_PUMICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_STAIRS, ModBlocks.POLISHED_PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PUMICE_BRICK_WALL, ModBlocks.POLISHED_PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICKS, ModBlocks.POLISHED_PUMICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_SLAB, ModBlocks.PUMICE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PUMICE_BRICK_STAIRS, ModBlocks.PUMICE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.PUMICE_BRICK_WALL, ModBlocks.PUMICE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB, Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_STONE_WALL, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB, Items.STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_STONE_WALL, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE, Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB, ModBlocks.POLISHED_STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_STONE_WALL, ModBlocks.POLISHED_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_SLAB, Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_STAIRS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.STONE_BRICK_WALL, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_STONE_BRICKS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_SLAB, ModBlocks.POLISHED_STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_STAIRS, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.STONE_BRICK_WALL, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_STONE_BRICKS, ModBlocks.POLISHED_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_SLAB, Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_STAIRS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_TILE_WALL, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILES, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_SLAB, ModBlocks.POLISHED_STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILE_STAIRS, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.STONE_TILE_WALL, ModBlocks.POLISHED_STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_TILES, ModBlocks.POLISHED_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_SLAB, Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_STAIRS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.DEEPSLATE_BRICK_WALL, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICKS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_SLAB, Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_STAIRS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.DEEPSLATE_TILE_WALL, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILES, Items.DEEPSLATE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_DEEPSLATE_SLAB, ModBlocks.SMOOTH_DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_DEEPSLATE_STAIRS, ModBlocks.SMOOTH_DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SMOOTH_DEEPSLATE_WALL, ModBlocks.SMOOTH_DEEPSLATE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_BRICKS, Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_BRICK_SLAB, Items.NETHERRACK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_BRICK_STAIRS, Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.NETHERRACK_BRICK_WALL, Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_BRICK_SLAB, ModBlocks.NETHERRACK_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_BRICK_STAIRS, ModBlocks.NETHERRACK_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.NETHERRACK_BRICK_WALL, ModBlocks.NETHERRACK_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICKS, Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_SLAB, Items.TERRACOTTA, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_STAIRS, Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.TERRACOTTA_BRICK_WALL, Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_SLAB, ModBlocks.TERRACOTTA_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TERRACOTTA_BRICK_STAIRS, ModBlocks.TERRACOTTA_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.TERRACOTTA_BRICK_WALL, ModBlocks.TERRACOTTA_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIG_BRICKS, Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIG_BRICK_SLAB, Items.BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIG_BRICK_STAIRS, Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BIG_BRICK_WALL, Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIG_BRICK_SLAB, ModBlocks.BIG_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIG_BRICK_STAIRS, ModBlocks.BIG_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BIG_BRICK_WALL, ModBlocks.BIG_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_BLACKSTONE_SLAB, Items.GILDED_BLACKSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_BLACKSTONE_STAIRS, Items.GILDED_BLACKSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GILDED_BLACKSTONE_WALL, Items.GILDED_BLACKSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PRISMARINE, Items.PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PRISMARINE_BRICKS, Items.PRISMARINE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ELDER_PRISMARINE, ModBlocks.ELDER_PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ELDER_PRISMARINE_BRICKS, ModBlocks.ELDER_PRISMARINE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_PILLAR, Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_LAPIS, Items.LAPIS_BLOCK);

        RustingIronCollection.zipApply(ModBlocks.IRON_GRATE, ModBlocks.IRON_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));
        CorrodingZincCollection.zipApply(ModBlocks.ZINC_GRATE, ModBlocks.ZINC_BLOCK, (result, input) -> this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, 4));

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_GRATE, ModBlocks.SILVER_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_GRATE, ModBlocks.TIN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUNGSTEN_GRATE, ModBlocks.TUNGSTEN_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATINUM_GRATE, ModBlocks.PLATINUM_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_GRATE, Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_GRATE, ModBlocks.LEAD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_GRATE, ModBlocks.URANIUM_BLOCK, 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERITE_GRATE, Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRONZE_GRATE, ModBlocks.BRONZE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRASS_GRATE, ModBlocks.BRASS_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_GRATE, ModBlocks.STEEL_BLOCK, 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_SLAB, ModBlocks.GRAPHITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_STAIRS, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_WALL, ModBlocks.GRAPHITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRAPHITE_SLAB, ModBlocks.GRAPHITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRAPHITE_STAIRS, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRAPHITE_WALL, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRAPHITE, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRAPHITE_SLAB, ModBlocks.POLISHED_GRAPHITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRAPHITE_STAIRS, ModBlocks.POLISHED_GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_GRAPHITE_WALL, ModBlocks.POLISHED_GRAPHITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_SLAB, ModBlocks.GRAPHITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_STAIRS, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_BRICK_WALL, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICKS, ModBlocks.GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_SLAB, ModBlocks.POLISHED_GRAPHITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_STAIRS, ModBlocks.POLISHED_GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_BRICK_WALL, ModBlocks.POLISHED_GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICKS, ModBlocks.POLISHED_GRAPHITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_SLAB, ModBlocks.GRAPHITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_BRICK_STAIRS, ModBlocks.GRAPHITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_BRICK_WALL, ModBlocks.GRAPHITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BISMUTH, ModBlocks.BISMUTH_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BISMUTH_STAIRS, ModBlocks.BISMUTH_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BISMUTH_SLAB, ModBlocks.BISMUTH_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BISMUTH_STAIRS, ModBlocks.CUT_BISMUTH);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_BISMUTH_SLAB, ModBlocks.CUT_BISMUTH, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_GRATE, ModBlocks.BISMUTH_BLOCK, 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_SLAB, ModBlocks.SILICITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_STAIRS, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILICITE_WALL, ModBlocks.SILICITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SILICITE_SLAB, ModBlocks.SILICITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SILICITE_STAIRS, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_SILICITE_WALL, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SILICITE, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SILICITE_SLAB, ModBlocks.POLISHED_SILICITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_SILICITE_STAIRS, ModBlocks.POLISHED_SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.POLISHED_SILICITE_WALL, ModBlocks.POLISHED_SILICITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_SLAB, ModBlocks.SILICITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_STAIRS, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILICITE_BRICK_WALL, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICKS, ModBlocks.SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_SLAB, ModBlocks.POLISHED_SILICITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_STAIRS, ModBlocks.POLISHED_SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILICITE_BRICK_WALL, ModBlocks.POLISHED_SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICKS, ModBlocks.POLISHED_SILICITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_SLAB, ModBlocks.SILICITE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILICITE_BRICK_STAIRS, ModBlocks.SILICITE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILICITE_BRICK_WALL, ModBlocks.SILICITE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_MONOCRYSTAL, ModBlocks.MONOCRYSTAL_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_MONOCRYSTAL_STAIRS, ModBlocks.MONOCRYSTAL_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_MONOCRYSTAL_SLAB, ModBlocks.MONOCRYSTAL_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_MONOCRYSTAL_STAIRS, ModBlocks.CUT_MONOCRYSTAL);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_MONOCRYSTAL_SLAB, ModBlocks.CUT_MONOCRYSTAL, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RUBY, ModBlocks.RUBY_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RUBY_STAIRS, ModBlocks.RUBY_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RUBY_SLAB, ModBlocks.RUBY_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RUBY_STAIRS, ModBlocks.CUT_RUBY);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RUBY_SLAB, ModBlocks.CUT_RUBY, 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SAPPHIRE, ModBlocks.SAPPHIRE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SAPPHIRE_STAIRS, ModBlocks.SAPPHIRE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SAPPHIRE_SLAB, ModBlocks.SAPPHIRE_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SAPPHIRE_STAIRS, ModBlocks.CUT_SAPPHIRE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SAPPHIRE_SLAB, ModBlocks.CUT_SAPPHIRE, 2);

    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider){
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipesProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return BuildersParadiseConstants.MOD_ID + ":recipe_provider";
        }
    }


}