package github.theworksofbh.buildersparadise.datagen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
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
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.ImbueRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.NeoForgeConditions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider {
    public static final ImmutableList<ItemLike> ZINC_SMELTABLES = ImmutableList.of(ModItems.ZINC_ORE.get(), ModItems.DEEPSLATE_ZINC_ORE.get(), ModItems.RAW_ZINC.get());
    public static final ImmutableList<ItemLike> SILVER_SMELTABLES = ImmutableList.of(ModItems.SILVER_ORE.get(), ModItems.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get());
    public static final ImmutableList<ItemLike> TIN_SMELTABLES = ImmutableList.of(ModItems.TIN_ORE.get(), ModItems.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get());
    public static final ImmutableList<ItemLike> TUNGSTEN_SMELTABLES = ImmutableList.of(ModItems.TUNGSTEN_ORE.get(), ModItems.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get());
    public static final ImmutableList<ItemLike> PLATINUM_SMELTABLES = ImmutableList.of(ModItems.PLATINUM_ORE.get(), ModItems.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get());
    public static final ImmutableList<ItemLike> LEAD_SMELTABLES = ImmutableList.of(ModItems.LEAD_ORE.get(), ModItems.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get());
    public static final ImmutableList<ItemLike> URANIUM_SMELTABLES = ImmutableList.of(ModItems.URANIUM_ORE.get(), ModItems.DEEPSLATE_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get());

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
        doorBuilder(ModItems.GOLD_DOOR.get(), Ingredient.of(Items.GOLD_INGOT)).unlockedBy(getHasName(Items.GOLD_INGOT), this.has(Items.GOLD_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.GOLD_TRAPDOOR.get(), Items.GOLD_INGOT);
        pressurePlate(ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Items.COPPER_INGOT);
        doorBuilder(ModItems.NETHERITE_DOOR.get(), Ingredient.of(Items.NETHERITE_INGOT)).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.NETHERITE_TRAPDOOR.get(), Items.NETHERITE_INGOT);
        pressurePlate(ModItems.PLAYER_ONLY_PRESSURE_PLATE.get(), Items.NETHERITE_INGOT);
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BLOCK.get(), getSimpleRecipeName(ModItems.CHARCOAL_BLOCK.get()), null, getSimpleRecipeName(Items.CHARCOAL) + "_b", null);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_SANDSTONE.get(), Items.SOUL_SAND);
        smeltingResultFromBase(ModItems.SMOOTH_SOUL_SANDSTONE.get(), ModItems.SOUL_SANDSTONE);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE.get(), ModItems.ELDER_PRISMARINE_SHARD.get());
        threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_BRICKS.get(), ModItems.ELDER_PRISMARINE_SHARD.get());
        shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_ELDER_PRISMARINE.get())
                .define('S', ModItems.ELDER_PRISMARINE_SHARD.get())
                .define('I', Items.DYE.black())
                .pattern("SSS")
                .pattern("SIS")
                .pattern("SSS")
                .unlockedBy("has_elder_prismarine_shard", this.has(ModItems.ELDER_PRISMARINE_SHARD.get()))
                .save(this.output);
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELDER_SEA_LANTERN.get())
                .define('S', ModItems.ELDER_PRISMARINE_SHARD.get())
                .define('C', ModItems.ELDER_PRISMARINE_CRYSTALS.get())
                .pattern("SCS")
                .pattern("CCC")
                .pattern("SCS")
                .unlockedBy("has_elder_prismarine_crystals", this.has(ModItems.ELDER_PRISMARINE_CRYSTALS.get()))
                .save(this.output);
        this.shapeless(RecipeCategory.MISC, ModItems.NETHERITE_NUGGET.get(), 9).requires(Items.NETHERITE_INGOT).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        this.shaped(RecipeCategory.MISC, Items.NETHERITE_INGOT).define('#', ModItems.NETHERITE_NUGGET.get()).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(ModItems.NETHERITE_NUGGET.get()), this.has(ModItems.NETHERITE_NUGGET.get())).save(this.output, "netherite_ingot_from_nugget");
        oreSmelting(ZINC_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ZINC_INGOT.get(), 1.0F, 200, "zinc_ingot");
        oreBlasting(ZINC_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ZINC_INGOT.get(), 1.0F, 100, "zinc_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.ZINC_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.ZINC_INGOT.get(),
                "zinc_ingot",
                null,
                "zinc_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.ZINC_BLOCK.get(),
                "zinc_block",
                null);
        doorBuilder(ModItems.ZINC_DOOR.get(), Ingredient.of(ModItems.ZINC_INGOT.get())).unlockedBy(getHasName(ModItems.ZINC_INGOT), this.has(ModItems.ZINC_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.ZINC_TRAPDOOR.get(), ModItems.ZINC_INGOT.get());
        pressurePlate(ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.ZINC_INGOT.get());

        oreSmelting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT.get(), 1.0F, 200, "silver_ingot");
        oreBlasting(SILVER_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SILVER_INGOT.get(), 1.0F, 100, "silver_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.SILVER_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.SILVER_INGOT.get(),
                "silver_ingot",
                null,
                "silver_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.SILVER_BLOCK.get(),
                "silver_block",
                null);
        doorBuilder(ModItems.SILVER_DOOR.get(), Ingredient.of(ModItems.SILVER_INGOT.get())).unlockedBy(getHasName(ModItems.SILVER_INGOT), this.has(ModItems.SILVER_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.SILVER_TRAPDOOR.get(), ModItems.SILVER_INGOT.get());
        pressurePlate(ModItems.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.SILVER_INGOT.get());

        oreSmelting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT.get(), 1.0F, 200, "tin_ingot");
        oreBlasting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TIN_INGOT.get(), 1.0F, 100, "tin_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.TIN_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.TIN_INGOT.get(),
                "tin_ingot",
                null,
                "tin_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.TIN_BLOCK.get(),
                "tin_block",
                null);
        doorBuilder(ModItems.TIN_DOOR.get(), Ingredient.of(ModItems.TIN_INGOT.get())).unlockedBy(getHasName(ModItems.TIN_INGOT), this.has(ModItems.TIN_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.TIN_TRAPDOOR.get(), ModItems.TIN_INGOT.get());
        pressurePlate(ModItems.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.TIN_INGOT.get());

        oreSmelting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 1.0F, 200, "tungsten_ingot");
        oreBlasting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 1.0F, 100, "tungsten_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT.get(),
                "tungsten_ingot",
                null,
                "tungsten_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.TUNGSTEN_BLOCK.get(),
                "tungsten_block",
                null);
        doorBuilder(ModItems.TUNGSTEN_DOOR.get(), Ingredient.of(ModItems.TUNGSTEN_INGOT.get())).unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT), this.has(ModItems.TUNGSTEN_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.TUNGSTEN_TRAPDOOR.get(), ModItems.TUNGSTEN_INGOT.get());
        pressurePlate(ModItems.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.TUNGSTEN_INGOT.get());

        oreSmelting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0F, 200, "platinum_ingot");
        oreBlasting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0F, 100, "platinum_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.PLATINUM_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.PLATINUM_INGOT.get(),
                "platinum_ingot",
                null,
                "platinum_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.PLATINUM_BLOCK.get(),
                "platinum_block",
                null);
        doorBuilder(ModItems.PLATINUM_DOOR.get(), Ingredient.of(ModItems.PLATINUM_INGOT.get())).unlockedBy(getHasName(ModItems.PLATINUM_INGOT), this.has(ModItems.PLATINUM_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.PLATINUM_TRAPDOOR.get(), ModItems.PLATINUM_INGOT.get());
        pressurePlate(ModItems.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.PLATINUM_INGOT.get());

        oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT.get(), 1.0F, 200, "lead_ingot");
        oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT.get(), 1.0F, 100, "lead_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.LEAD_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.LEAD_INGOT.get(),
                "lead_ingot",
                null,
                "lead_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.LEAD_BLOCK.get(),
                "lead_block",
                null);
        doorBuilder(ModItems.LEAD_DOOR.get(), Ingredient.of(ModItems.LEAD_INGOT.get())).unlockedBy(getHasName(ModItems.LEAD_INGOT), this.has(ModItems.LEAD_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.LEAD_TRAPDOOR.get(), ModItems.LEAD_INGOT.get());
        pressurePlate(ModItems.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.LEAD_INGOT.get());


        oreSmelting(URANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.URANIUM_INGOT.get(), 1.0F, 200, "uranium_ingot");
        oreBlasting(URANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.URANIUM_INGOT.get(), 1.0F, 100, "uranium_ingot");
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.URANIUM_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.URANIUM_INGOT.get(),
                "uranium_ingot",
                null,
                "uranium_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.URANIUM_BLOCK.get(),
                "uranium_block",
                null);
        doorBuilder(ModItems.URANIUM_DOOR.get(), Ingredient.of(ModItems.URANIUM_INGOT.get())).unlockedBy(getHasName(ModItems.URANIUM_INGOT), this.has(ModItems.URANIUM_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.URANIUM_TRAPDOOR.get(), ModItems.URANIUM_INGOT.get());
        pressurePlate(ModItems.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get(), ModItems.URANIUM_INGOT.get());

        smeltingResultFromBase(ModItems.URANIUM_NUGGET.get(), Items.REDSTONE);

        shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT.get())
                .requires(Items.COPPER_INGOT, 4)
                .requires(ModItems.TIN_INGOT, 4)
                .group("bronze_ingot")
                .unlockedBy("has_tin_ingot", this.has(ModItems.TIN_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.BRONZE_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.BRONZE_INGOT.get(),
                "bronze_ingot",
                null,
                "bronze_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.BRONZE_BLOCK.get(),
                "bronze_block",
                null);
        doorBuilder(ModItems.BRONZE_DOOR.get(), Ingredient.of(ModItems.BRONZE_INGOT.get())).unlockedBy(getHasName(ModItems.BRONZE_INGOT), this.has(ModItems.BRONZE_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.BRONZE_TRAPDOOR.get(), ModItems.BRONZE_INGOT.get());
        pressurePlate(ModItems.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get(), ModItems.BRONZE_INGOT.get());

        shapeless(RecipeCategory.MISC, ModItems.BRASS_INGOT.get())
                .requires(Items.COPPER_INGOT, 4)
                .requires(ModItems.ZINC_INGOT, 4)
                .group("brass_ingot")
                .unlockedBy("has_zinc_ingot", this.has(ModItems.ZINC_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.BRASS_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.BRASS_INGOT.get(),
                "brass_ingot",
                null,
                "brass_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.BRASS_BLOCK.get(),
                "brass_block",
                null);
        doorBuilder(ModItems.BRASS_DOOR.get(), Ingredient.of(ModItems.BRASS_INGOT.get())).unlockedBy(getHasName(ModItems.BRASS_INGOT), this.has(ModItems.BRASS_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.BRASS_TRAPDOOR.get(), ModItems.BRASS_INGOT.get());
        pressurePlate(ModItems.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get(), ModItems.BRASS_INGOT.get());

        shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get())
                .requires(Items.IRON_INGOT, 4)
                .requires(Ingredient.of(new Item[]{Items.COAL, Items.CHARCOAL}), 4)
                .group("steel_ingot")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output);
        eightyOneBlockStorageRecipes(
                RecipeCategory.MISC,
                ModItems.STEEL_NUGGET.get(),
                RecipeCategory.MISC,
                ModItems.STEEL_INGOT.get(),
                "steel_ingot",
                null,
                "steel_nugget",
                null,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.STEEL_BLOCK.get(),
                "steel_block",
                null);
        doorBuilder(ModItems.STEEL_DOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).unlockedBy(getHasName(ModItems.STEEL_INGOT), this.has(ModItems.STEEL_INGOT.get())).save(this.output);
        twoByTwoPacker(RecipeCategory.REDSTONE, ModItems.STEEL_TRAPDOOR.get(), ModItems.STEEL_INGOT.get());
        pressurePlate(ModItems.VILLAGER_ONLY_PRESSURE_PLATE.get(), ModItems.STEEL_INGOT.get());
        shapeless(RecipeCategory.TOOLS, Items.FLINT_AND_STEEL)
                .requires(ModItems.STEEL_INGOT).requires(Items.FLINT)
                .unlockedBy("has_steel_ingot", this.has(ModItems.STEEL_INGOT))
                .unlockedBy("has_obsidian", this.has(Blocks.OBSIDIAN))
                .save(output, "flint_and_steel_alt");

        shaped(RecipeCategory.REDSTONE, ModBlocks.NUKE.get())
                .define('#', Ingredient.of(new Item[]{Items.SAND, Items.RED_SAND}))
                .define('X', ModItems.URANIUM_INGOT.get())
                .pattern("X#X")
                .pattern("#X#")
                .pattern("X#X")
                .unlockedBy("has_uranium_ingot", this.has(ModItems.URANIUM_INGOT.get())).save(this.output);

        this.createCraftingTable(ModItems.OAK_CRAFTING_TABLE, Items.OAK_PLANKS);
        this.createCraftingTable(ModItems.SPRUCE_CRAFTING_TABLE, Items.SPRUCE_PLANKS);
        this.createCraftingTable(ModItems.BIRCH_CRAFTING_TABLE, Items.BIRCH_PLANKS);
        this.createCraftingTable(ModItems.JUNGLE_CRAFTING_TABLE, Items.JUNGLE_PLANKS);
        this.createCraftingTable(ModItems.ACACIA_CRAFTING_TABLE, Items.ACACIA_PLANKS);
        this.createCraftingTable(ModItems.DARK_OAK_CRAFTING_TABLE, Items.DARK_OAK_PLANKS);
        this.createCraftingTable(ModItems.CRIMSON_CRAFTING_TABLE, Items.CRIMSON_PLANKS);
        this.createCraftingTable(ModItems.WARPED_CRAFTING_TABLE, Items.WARPED_PLANKS);
        this.createCraftingTable(ModItems.MANGROVE_CRAFTING_TABLE, Items.MANGROVE_PLANKS);
        this.createCraftingTable(ModItems.CHERRY_CRAFTING_TABLE, Items.CHERRY_PLANKS);
        this.createCraftingTable(ModItems.BAMBOO_CRAFTING_TABLE, Items.BAMBOO_PLANKS);
        this.createCraftingTable(ModItems.PALE_OAK_CRAFTING_TABLE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.CRAFTING_TABLE)
                .define('#', ItemTags.PLANKS)
                .pattern("##")
                .pattern("##")
                .unlockedBy("unlock_right_away", PlayerTrigger.TriggerInstance.tick())
                .showNotification(false)
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createCartographyTable(ModItems.OAK_CARTOGRAPHY_TABLE, Items.OAK_PLANKS);
        this.createCartographyTable(ModItems.SPRUCE_CARTOGRAPHY_TABLE, Items.SPRUCE_PLANKS);
        this.createCartographyTable(ModItems.BIRCH_CARTOGRAPHY_TABLE, Items.BIRCH_PLANKS);
        this.createCartographyTable(ModItems.JUNGLE_CARTOGRAPHY_TABLE, Items.JUNGLE_PLANKS);
        this.createCartographyTable(ModItems.ACACIA_CARTOGRAPHY_TABLE, Items.ACACIA_PLANKS);
        this.createCartographyTable(ModItems.DARK_OAK_CARTOGRAPHY_TABLE, Items.DARK_OAK_PLANKS);
        this.createCartographyTable(ModItems.CRIMSON_CARTOGRAPHY_TABLE, Items.CRIMSON_PLANKS);
        this.createCartographyTable(ModItems.WARPED_CARTOGRAPHY_TABLE, Items.WARPED_PLANKS);
        this.createCartographyTable(ModItems.MANGROVE_CARTOGRAPHY_TABLE, Items.MANGROVE_PLANKS);
        this.createCartographyTable(ModItems.CHERRY_CARTOGRAPHY_TABLE, Items.CHERRY_PLANKS);
        this.createCartographyTable(ModItems.BAMBOO_CARTOGRAPHY_TABLE, Items.BAMBOO_PLANKS);
        this.createCartographyTable(ModItems.PALE_OAK_CARTOGRAPHY_TABLE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.CARTOGRAPHY_TABLE)
                .define('#', ItemTags.PLANKS)
                .define('@', Items.PAPER)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_paper", this.has(Items.PAPER))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createFletchingTable(ModItems.OAK_FLETCHING_TABLE, Items.OAK_PLANKS);
        this.createFletchingTable(ModItems.SPRUCE_FLETCHING_TABLE, Items.SPRUCE_PLANKS);
        this.createFletchingTable(ModItems.BIRCH_FLETCHING_TABLE, Items.BIRCH_PLANKS);
        this.createFletchingTable(ModItems.JUNGLE_FLETCHING_TABLE, Items.JUNGLE_PLANKS);
        this.createFletchingTable(ModItems.ACACIA_FLETCHING_TABLE, Items.ACACIA_PLANKS);
        this.createFletchingTable(ModItems.DARK_OAK_FLETCHING_TABLE, Items.DARK_OAK_PLANKS);
        this.createFletchingTable(ModItems.CRIMSON_FLETCHING_TABLE, Items.CRIMSON_PLANKS);
        this.createFletchingTable(ModItems.WARPED_FLETCHING_TABLE, Items.WARPED_PLANKS);
        this.createFletchingTable(ModItems.MANGROVE_FLETCHING_TABLE, Items.MANGROVE_PLANKS);
        this.createFletchingTable(ModItems.CHERRY_FLETCHING_TABLE, Items.CHERRY_PLANKS);
        this.createFletchingTable(ModItems.BAMBOO_FLETCHING_TABLE, Items.BAMBOO_PLANKS);
        this.createFletchingTable(ModItems.PALE_OAK_FLETCHING_TABLE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Blocks.FLETCHING_TABLE)
                .define('#', ItemTags.PLANKS)
                .define('@', Items.FLINT)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_flint", this.has(Items.FLINT))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.fletching(Items.SPECTRAL_ARROW, Items.ARROW, Items.GLOWSTONE_DUST);
        this.fletching(Items.TIPPED_ARROW, Items.ARROW, Items.LINGERING_POTION);

        this.shaped(RecipeCategory.COMBAT, Items.SPECTRAL_ARROW, 2)
                .define('#', Items.GLOWSTONE_DUST)
                .define('X', Items.ARROW)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy("has_glowstone_dust", this.has(Items.GLOWSTONE_DUST))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        CustomCraftingRecipeBuilder.customCrafting(RecipeCategory.MISC, (commonInfo, bookInfo) -> new ImbueRecipe(commonInfo, bookInfo, Ingredient.of(Items.LINGERING_POTION), Ingredient.of(Items.ARROW), new ItemStackTemplate(Items.TIPPED_ARROW, 8))).unlockedBy("has_lingering_potion", this.has(Items.LINGERING_POTION)).save(this.output.withConditions(NeoForgeConditions.never()), "tipped_arrow");

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_ZINC.get(), RecipeCategory.MISC, ModItems.RAW_ZINC_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), RecipeCategory.MISC, ModItems.RAW_SILVER_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_TIN.get(), RecipeCategory.MISC, ModItems.RAW_TIN_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_TUNGSTEN.get(), RecipeCategory.MISC, ModItems.RAW_TUNGSTEN_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_PLATINUM.get(), RecipeCategory.MISC, ModItems.RAW_PLATINUM_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_LEAD.get(), RecipeCategory.MISC, ModItems.RAW_LEAD_BLOCK.get());
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_URANIUM.get(), RecipeCategory.MISC, ModItems.RAW_URANIUM_BLOCK.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_SLAB), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, Items.STONE_SLAB, 0.1F, 200).unlockedBy("has_cobblestone_slab", this.has(Items.COBBLESTONE_SLAB)).save(this.output, "stone_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, Items.STONE_STAIRS, 0.1F, 200).unlockedBy("has_cobblestone_stairs", this.has(Items.COBBLESTONE_STAIRS)).save(this.output, "stone_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_WALL), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.STONE_WALL.get(), 0.1F, 200).unlockedBy("has_cobblestone_wall", this.has(Items.COBBLESTONE_WALL)).save(this.output, "stone_wall_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COBBLESTONE_FENCE.get()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.STONE_FENCE.get(), 0.1F, 200).unlockedBy("has_cobblestone_fence", this.has(ModItems.COBBLESTONE_FENCE.get())).save(this.output, "stone_fence_smelting");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_SLAB), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.DEEPSLATE_SLAB.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_slab", this.has(Items.COBBLED_DEEPSLATE_SLAB)).save(this.output, "deepslate_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_STAIRS), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.DEEPSLATE_STAIRS.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_stairs", this.has(Items.COBBLED_DEEPSLATE_STAIRS)).save(this.output, "deepslate_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_WALL), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.DEEPSLATE_WALL.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_wall", this.has(Items.COBBLED_DEEPSLATE_WALL)).save(this.output, "deepslate_wall_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COBBLED_DEEPSLATE_FENCE.get()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.DEEPSLATE_FENCE.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_fence", this.has(ModItems.COBBLED_DEEPSLATE_FENCE.get())).save(this.output, "deepslate_fence_smelting");

        this.createSmithingTable(ModItems.OAK_SMITHING_TABLE, Items.OAK_PLANKS);
        this.createSmithingTable(ModItems.SPRUCE_SMITHING_TABLE, Items.SPRUCE_PLANKS);
        this.createSmithingTable(ModItems.BIRCH_SMITHING_TABLE, Items.BIRCH_PLANKS);
        this.createSmithingTable(ModItems.JUNGLE_SMITHING_TABLE, Items.JUNGLE_PLANKS);
        this.createSmithingTable(ModItems.ACACIA_SMITHING_TABLE, Items.ACACIA_PLANKS);
        this.createSmithingTable(ModItems.DARK_OAK_SMITHING_TABLE, Items.DARK_OAK_PLANKS);
        this.createSmithingTable(ModItems.CRIMSON_SMITHING_TABLE, Items.CRIMSON_PLANKS);
        this.createSmithingTable(ModItems.WARPED_SMITHING_TABLE, Items.WARPED_PLANKS);
        this.createSmithingTable(ModItems.MANGROVE_SMITHING_TABLE, Items.MANGROVE_PLANKS);
        this.createSmithingTable(ModItems.CHERRY_SMITHING_TABLE, Items.CHERRY_PLANKS);
        this.createSmithingTable(ModItems.BAMBOO_SMITHING_TABLE, Items.BAMBOO_PLANKS);
        this.createSmithingTable(ModItems.PALE_OAK_SMITHING_TABLE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.SMITHING_TABLE)
                .define('#', ItemTags.PLANKS)
                .define('@', Items.IRON_INGOT)
                .pattern("@@")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createGrindstone(ModItems.OAK_GRINDSTONE, Items.OAK_PLANKS);
        this.createGrindstone(ModItems.SPRUCE_GRINDSTONE, Items.SPRUCE_PLANKS);
        this.createGrindstone(ModItems.BIRCH_GRINDSTONE, Items.BIRCH_PLANKS);
        this.createGrindstone(ModItems.JUNGLE_GRINDSTONE, Items.JUNGLE_PLANKS);
        this.createGrindstone(ModItems.ACACIA_GRINDSTONE, Items.ACACIA_PLANKS);
        this.createGrindstone(ModItems.DARK_OAK_GRINDSTONE, Items.DARK_OAK_PLANKS);
        this.createGrindstone(ModItems.CRIMSON_GRINDSTONE, Items.CRIMSON_PLANKS);
        this.createGrindstone(ModItems.WARPED_GRINDSTONE, Items.WARPED_PLANKS);
        this.createGrindstone(ModItems.MANGROVE_GRINDSTONE, Items.MANGROVE_PLANKS);
        this.createGrindstone(ModItems.CHERRY_GRINDSTONE, Items.CHERRY_PLANKS);
        this.createGrindstone(ModItems.BAMBOO_GRINDSTONE, Items.BAMBOO_PLANKS);
        this.createGrindstone(ModItems.PALE_OAK_GRINDSTONE, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.GRINDSTONE)
                .define('I', Items.STICK)
                .define('-', Items.STONE_SLAB)
                .define('#', ItemTags.PLANKS)
                .pattern("I-I")
                .pattern("# #")
                .unlockedBy("has_stone_slab", this.has(Blocks.STONE_SLAB))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createLoom(ModItems.OAK_LOOM, Items.OAK_PLANKS);
        this.createLoom(ModItems.SPRUCE_LOOM, Items.SPRUCE_PLANKS);
        this.createLoom(ModItems.BIRCH_LOOM, Items.BIRCH_PLANKS);
        this.createLoom(ModItems.JUNGLE_LOOM, Items.JUNGLE_PLANKS);
        this.createLoom(ModItems.ACACIA_LOOM, Items.ACACIA_PLANKS);
        this.createLoom(ModItems.DARK_OAK_LOOM, Items.DARK_OAK_PLANKS);
        this.createLoom(ModItems.CRIMSON_LOOM, Items.CRIMSON_PLANKS);
        this.createLoom(ModItems.WARPED_LOOM, Items.WARPED_PLANKS);
        this.createLoom(ModItems.MANGROVE_LOOM, Items.MANGROVE_PLANKS);
        this.createLoom(ModItems.CHERRY_LOOM, Items.CHERRY_PLANKS);
        this.createLoom(ModItems.BAMBOO_LOOM, Items.BAMBOO_PLANKS);
        this.createLoom(ModItems.PALE_OAK_LOOM, Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.LOOM)
                .define('#', ItemTags.PLANKS)
                .define('@', Items.STRING)
                .pattern("@@")
                .pattern("##")
                .unlockedBy("has_string", this.has(Items.STRING))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createFurnace(ModItems.STONE_FURNACE.get(), Items.COBBLESTONE, "cobblestone");
        this.createFurnace(ModItems.BLACKSTONE_FURNACE.get(), Items.BLACKSTONE, "blackstone");
        this.createFurnace(ModItems.DEEPSLATE_FURNACE.get(), Items.COBBLED_DEEPSLATE, "cobbled_deepslate");

        this.shaped(RecipeCategory.DECORATIONS, Items.FURNACE)
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_cobblestone", this.has(ItemTags.STONE_CRAFTING_MATERIALS))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createSmoker(ModItems.OAK_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.OAK_LOG, "stone_furnace");
        this.createSmoker(ModItems.SPRUCE_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.SPRUCE_LOG, "stone_furnace");
        this.createSmoker(ModItems.BIRCH_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.BIRCH_LOG, "stone_furnace");
        this.createSmoker(ModItems.JUNGLE_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.JUNGLE_LOG, "stone_furnace");
        this.createSmoker(ModItems.ACACIA_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.ACACIA_LOG, "stone_furnace");
        this.createSmoker(ModItems.DARK_OAK_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.DARK_OAK_LOG, "stone_furnace");
        this.createSmoker(ModItems.CRIMSON_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.CRIMSON_STEM, "stone_furnace");
        this.createSmoker(ModItems.WARPED_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.WARPED_STEM, "stone_furnace");
        this.createSmoker(ModItems.MANGROVE_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.MANGROVE_LOG, "stone_furnace");
        this.createSmoker(ModItems.CHERRY_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.CHERRY_LOG, "stone_furnace");
        this.createSmoker(ModItems.BAMBOO_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.BAMBOO_BLOCK, "stone_furnace");
        this.createSmoker(ModItems.PALE_OAK_STONE_SMOKER.get(), ModItems.STONE_FURNACE.get(), Items.PALE_OAK_LOG, "stone_furnace");

        this.createSmoker(ModItems.OAK_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.OAK_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.SPRUCE_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.SPRUCE_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.BIRCH_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.BIRCH_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.JUNGLE_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.JUNGLE_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.ACACIA_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.ACACIA_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.DARK_OAK_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.DARK_OAK_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.CRIMSON_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.CRIMSON_STEM, "blackstone_furnace");
        this.createSmoker(ModItems.WARPED_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.WARPED_STEM, "blackstone_furnace");
        this.createSmoker(ModItems.MANGROVE_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.MANGROVE_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.CHERRY_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.CHERRY_LOG, "blackstone_furnace");
        this.createSmoker(ModItems.BAMBOO_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.BAMBOO_BLOCK, "blackstone_furnace");
        this.createSmoker(ModItems.PALE_OAK_BLACKSTONE_SMOKER.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.PALE_OAK_LOG, "blackstone_furnace");

        this.createSmoker(ModItems.OAK_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.OAK_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.SPRUCE_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.SPRUCE_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.BIRCH_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.BIRCH_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.JUNGLE_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.JUNGLE_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.ACACIA_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.ACACIA_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.DARK_OAK_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.DARK_OAK_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.CRIMSON_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.CRIMSON_STEM, "deepslate_furnace");
        this.createSmoker(ModItems.WARPED_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.WARPED_STEM, "deepslate_furnace");
        this.createSmoker(ModItems.MANGROVE_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.MANGROVE_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.CHERRY_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.CHERRY_LOG, "deepslate_furnace");
        this.createSmoker(ModItems.BAMBOO_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.BAMBOO_BLOCK, "deepslate_furnace");
        this.createSmoker(ModItems.PALE_OAK_DEEPSLATE_SMOKER.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.PALE_OAK_LOG, "deepslate_furnace");

        this.shaped(RecipeCategory.DECORATIONS, Items.SMOKER)
                .define('#', ItemTags.LOGS)
                .define('X', Items.FURNACE)
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy("has_furnace", this.has(Items.FURNACE))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createBlastFurnace(ModItems.STONE_BLAST_FURNACE.get(), ModItems.STONE_FURNACE.get(), Items.SMOOTH_STONE, "smooth_stone");
        this.createBlastFurnace(ModItems.BLACKSTONE_BLAST_FURNACE.get(), ModItems.BLACKSTONE_FURNACE.get(), Items.POLISHED_BLACKSTONE, "polished_blackstone");
        this.createBlastFurnace(ModItems.DEEPSLATE_BLAST_FURNACE.get(), ModItems.DEEPSLATE_FURNACE.get(), Items.POLISHED_DEEPSLATE, "polished_deepslate");

        this.shaped(RecipeCategory.DECORATIONS, Items.BLAST_FURNACE)
                .define('#', Items.SMOOTH_STONE)
                .define('X', Items.FURNACE)
                .define('I', Items.IRON_INGOT)
                .pattern("III")
                .pattern("IXI")
                .pattern("###")
                .unlockedBy("has_smooth_stone", this.has(Items.SMOOTH_STONE))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createCampfires(ModItems.OAK_CAMPFIRE.get(), ModItems.OAK_SOUL_CAMPFIRE.get(), ItemTags.OAK_LOGS);
        this.createCampfires(ModItems.SPRUCE_CAMPFIRE.get(), ModItems.SPRUCE_SOUL_CAMPFIRE.get(), ItemTags.SPRUCE_LOGS);
        this.createCampfires(ModItems.BIRCH_CAMPFIRE.get(), ModItems.BIRCH_SOUL_CAMPFIRE.get(), ItemTags.BIRCH_LOGS);
        this.createCampfires(ModItems.JUNGLE_CAMPFIRE.get(), ModItems.JUNGLE_SOUL_CAMPFIRE.get(), ItemTags.JUNGLE_LOGS);
        this.createCampfires(ModItems.ACACIA_CAMPFIRE.get(), ModItems.ACACIA_SOUL_CAMPFIRE.get(), ItemTags.ACACIA_LOGS);
        this.createCampfires(ModItems.DARK_OAK_CAMPFIRE.get(), ModItems.DARK_OAK_SOUL_CAMPFIRE.get(), ItemTags.DARK_OAK_LOGS);
        this.createCampfires(ModItems.CRIMSON_CAMPFIRE.get(), ModItems.CRIMSON_SOUL_CAMPFIRE.get(), ItemTags.CRIMSON_STEMS);
        this.createCampfires(ModItems.WARPED_CAMPFIRE.get(), ModItems.WARPED_SOUL_CAMPFIRE.get(), ItemTags.WARPED_STEMS);
        this.createCampfires(ModItems.MANGROVE_CAMPFIRE.get(), ModItems.MANGROVE_SOUL_CAMPFIRE.get(), ItemTags.MANGROVE_LOGS);
        this.createCampfires(ModItems.CHERRY_CAMPFIRE.get(), ModItems.CHERRY_SOUL_CAMPFIRE.get(), ItemTags.CHERRY_LOGS);
        this.createCampfires(ModItems.BAMBOO_CAMPFIRE.get(), ModItems.BAMBOO_SOUL_CAMPFIRE.get(), ItemTags.BAMBOO_BLOCKS);
        this.createCampfires(ModItems.PALE_OAK_CAMPFIRE.get(), ModItems.PALE_OAK_SOUL_CAMPFIRE.get(), ItemTags.PALE_OAK_LOGS);

        this.shaped(RecipeCategory.DECORATIONS, Items.CAMPFIRE)
                .define('L', ItemTags.LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", this.has(Items.STICK))
                .unlockedBy("has_coal", this.has(ItemTags.COALS))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.SOUL_CAMPFIRE)
                .define('L', ItemTags.LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", this.has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createBeehive(ModItems.OAK_BEEHIVE.get(), Items.OAK_PLANKS);
        this.createBeehive(ModItems.SPRUCE_BEEHIVE.get(), Items.SPRUCE_PLANKS);
        this.createBeehive(ModItems.BIRCH_BEEHIVE.get(), Items.BIRCH_PLANKS);
        this.createBeehive(ModItems.JUNGLE_BEEHIVE.get(), Items.JUNGLE_PLANKS);
        this.createBeehive(ModItems.ACACIA_BEEHIVE.get(), Items.ACACIA_PLANKS);
        this.createBeehive(ModItems.DARK_OAK_BEEHIVE.get(), Items.DARK_OAK_PLANKS);
        this.createBeehive(ModItems.CRIMSON_BEEHIVE.get(), Items.CRIMSON_PLANKS);
        this.createBeehive(ModItems.WARPED_BEEHIVE.get(), Items.WARPED_PLANKS);
        this.createBeehive(ModItems.MANGROVE_BEEHIVE.get(), Items.MANGROVE_PLANKS);
        this.createBeehive(ModItems.CHERRY_BEEHIVE.get(), Items.CHERRY_PLANKS);
        this.createBeehive(ModItems.BAMBOO_BEEHIVE.get(), Items.BAMBOO_PLANKS);
        this.createBeehive(ModItems.PALE_OAK_BEEHIVE.get(), Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.BEEHIVE)
                .define('P', ItemTags.PLANKS)
                .define('H', Items.HONEYCOMB)
                .pattern("PPP")
                .pattern("HHH")
                .pattern("PPP")
                .unlockedBy("has_honeycomb", this.has(Items.HONEYCOMB))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createBookshelf(ModItems.OAK_BOOKSHELF.get(), Items.OAK_PLANKS);
        this.createBookshelf(ModItems.SPRUCE_BOOKSHELF.get(), Items.SPRUCE_PLANKS);
        this.createBookshelf(ModItems.BIRCH_BOOKSHELF.get(), Items.BIRCH_PLANKS);
        this.createBookshelf(ModItems.JUNGLE_BOOKSHELF.get(), Items.JUNGLE_PLANKS);
        this.createBookshelf(ModItems.ACACIA_BOOKSHELF.get(), Items.ACACIA_PLANKS);
        this.createBookshelf(ModItems.DARK_OAK_BOOKSHELF.get(), Items.DARK_OAK_PLANKS);
        this.createBookshelf(ModItems.CRIMSON_BOOKSHELF.get(), Items.CRIMSON_PLANKS);
        this.createBookshelf(ModItems.WARPED_BOOKSHELF.get(), Items.WARPED_PLANKS);
        this.createBookshelf(ModItems.MANGROVE_BOOKSHELF.get(), Items.MANGROVE_PLANKS);
        this.createBookshelf(ModItems.CHERRY_BOOKSHELF.get(), Items.CHERRY_PLANKS);
        this.createBookshelf(ModItems.BAMBOO_BOOKSHELF.get(), Items.BAMBOO_PLANKS);
        this.createBookshelf(ModItems.PALE_OAK_BOOKSHELF.get(), Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BOOKSHELF)
                .define('#', ItemTags.PLANKS)
                .define('X', Items.BOOK)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createChiseledBookshelf(ModItems.OAK_CHISELED_BOOKSHELF.get(), Items.OAK_PLANKS, Items.OAK_SLAB);
        this.createChiseledBookshelf(ModItems.SPRUCE_CHISELED_BOOKSHELF.get(), Items.SPRUCE_PLANKS, Items.SPRUCE_SLAB);
        this.createChiseledBookshelf(ModItems.BIRCH_CHISELED_BOOKSHELF.get(), Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
        this.createChiseledBookshelf(ModItems.JUNGLE_CHISELED_BOOKSHELF.get(), Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
        this.createChiseledBookshelf(ModItems.ACACIA_CHISELED_BOOKSHELF.get(), Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
        this.createChiseledBookshelf(ModItems.DARK_OAK_CHISELED_BOOKSHELF.get(), Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
        this.createChiseledBookshelf(ModItems.CRIMSON_CHISELED_BOOKSHELF.get(), Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);
        this.createChiseledBookshelf(ModItems.WARPED_CHISELED_BOOKSHELF.get(), Items.WARPED_PLANKS, Items.WARPED_SLAB);
        this.createChiseledBookshelf(ModItems.MANGROVE_CHISELED_BOOKSHELF.get(), Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
        this.createChiseledBookshelf(ModItems.CHERRY_CHISELED_BOOKSHELF.get(), Items.CHERRY_PLANKS, Items.CHERRY_SLAB);
        this.createChiseledBookshelf(ModItems.BAMBOO_CHISELED_BOOKSHELF.get(), Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB);
        this.createChiseledBookshelf(ModItems.PALE_OAK_CHISELED_BOOKSHELF.get(), Items.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_BOOKSHELF)
                .define('#', ItemTags.PLANKS)
                .define('X', ItemTags.WOODEN_SLABS)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createLectern(ModItems.OAK_LECTERN.get(), ModItems.OAK_BOOKSHELF.get(), Items.OAK_SLAB);
        this.createLectern(ModItems.SPRUCE_LECTERN.get(), ModItems.SPRUCE_BOOKSHELF.get(), Items.SPRUCE_SLAB);
        this.createLectern(ModItems.BIRCH_LECTERN.get(), ModItems.BIRCH_BOOKSHELF.get(), Items.BIRCH_SLAB);
        this.createLectern(ModItems.JUNGLE_LECTERN.get(), ModItems.JUNGLE_BOOKSHELF.get(), Items.JUNGLE_SLAB);
        this.createLectern(ModItems.ACACIA_LECTERN.get(), ModItems.ACACIA_BOOKSHELF.get(), Items.ACACIA_SLAB);
        this.createLectern(ModItems.DARK_OAK_LECTERN.get(), ModItems.DARK_OAK_BOOKSHELF.get(), Items.DARK_OAK_SLAB);
        this.createLectern(ModItems.CRIMSON_LECTERN.get(), ModItems.CRIMSON_BOOKSHELF.get(), Items.CRIMSON_SLAB);
        this.createLectern(ModItems.WARPED_LECTERN.get(), ModItems.WARPED_BOOKSHELF.get(), Items.WARPED_SLAB);
        this.createLectern(ModItems.MANGROVE_LECTERN.get(), ModItems.MANGROVE_BOOKSHELF.get(), Items.MANGROVE_SLAB);
        this.createLectern(ModItems.CHERRY_LECTERN.get(), ModItems.CHERRY_BOOKSHELF.get(), Items.CHERRY_SLAB);
        this.createLectern(ModItems.BAMBOO_LECTERN.get(), ModItems.BAMBOO_BOOKSHELF.get(), Items.BAMBOO_SLAB);
        this.createLectern(ModItems.PALE_OAK_LECTERN.get(), ModItems.PALE_OAK_BOOKSHELF.get(), Items.PALE_OAK_SLAB);

        this.shaped(RecipeCategory.REDSTONE, Items.LECTERN)
                .define('S', ItemTags.WOODEN_SLABS)
                .define('B', Items.BOOKSHELF)
                .pattern("SSS")
                .pattern(" B ")
                .pattern(" S ")
                .unlockedBy("has_book", this.has(Items.BOOK))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createBrewingStand(ModItems.STONE_BREWING_STAND.get(), Items.COBBLESTONE);
        this.createBrewingStand(ModItems.BLACKSTONE_BREWING_STAND.get(), Items.BLACKSTONE);
        this.createBrewingStand(ModItems.DEEPSLATE_BREWING_STAND.get(), Items.COBBLED_DEEPSLATE);

        this.shaped(RecipeCategory.BREWING, Items.BREWING_STAND)
                .define('B', Items.BLAZE_ROD)
                .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .pattern(" B ")
                .pattern("###")
                .unlockedBy("has_blaze_rod", this.has(Items.BLAZE_ROD))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createBarrel(ModItems.OAK_BARREL.get(), Items.OAK_PLANKS, Items.OAK_SLAB);
        this.createBarrel(ModItems.SPRUCE_BARREL.get(), Items.SPRUCE_PLANKS, Items.SPRUCE_SLAB);
        this.createBarrel(ModItems.BIRCH_BARREL.get(), Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
        this.createBarrel(ModItems.JUNGLE_BARREL.get(), Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
        this.createBarrel(ModItems.ACACIA_BARREL.get(), Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
        this.createBarrel(ModItems.DARK_OAK_BARREL.get(), Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
        this.createBarrel(ModItems.CRIMSON_BARREL.get(), Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);
        this.createBarrel(ModItems.WARPED_BARREL.get(), Items.WARPED_PLANKS, Items.WARPED_SLAB);
        this.createBarrel(ModItems.MANGROVE_BARREL.get(), Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
        this.createBarrel(ModItems.CHERRY_BARREL.get(), Items.CHERRY_PLANKS, Items.CHERRY_SLAB);
        this.createBarrel(ModItems.BAMBOO_BARREL.get(), Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB);
        this.createBarrel(ModItems.PALE_OAK_BARREL.get(), Items.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB);

        this.shaped(RecipeCategory.DECORATIONS, Items.BARREL, 1)
                .define('P', ItemTags.PLANKS)
                .define('S', ItemTags.WOODEN_SLABS)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .unlockedBy("has_planks", this.has(ItemTags.PLANKS))
                .unlockedBy("has_wood_slab", this.has(ItemTags.WOODEN_SLABS))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createDispensersDroppers(ModItems.STONE_DISPENSER.get(), ModItems.STONE_DROPPER.get(), Items.COBBLESTONE);
        this.createDispensersDroppers(ModItems.BLACKSTONE_DISPENSER.get(), ModItems.BLACKSTONE_DROPPER.get(), Items.BLACKSTONE);
        this.createDispensersDroppers(ModItems.DEEPSLATE_DISPENSER.get(), ModItems.DEEPSLATE_DROPPER.get(), Items.COBBLED_DEEPSLATE);

        this.shaped(RecipeCategory.REDSTONE, Items.DISPENSER)
                .define('R', Items.REDSTONE)
                .define('#', Items.COBBLESTONE)
                .define('X', Items.BOW)
                .pattern("###")
                .pattern("#X#")
                .pattern("#R#")
                .unlockedBy("has_bow", this.has(Items.BOW))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.REDSTONE, Items.DROPPER)
                .define('R', Items.REDSTONE)
                .define('#', Items.COBBLESTONE)
                .pattern("###")
                .pattern("# #")
                .pattern("#R#")
                .unlockedBy("has_redstone", this.has(Items.REDSTONE))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 9).requires(ModItems.WAXED_IRON_BLOCK.get()).group(null).unlockedBy(getHasName(ModItems.WAXED_IRON_BLOCK.get()), this.has(ModItems.WAXED_IRON_BLOCK.get())).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse("iron_ingot_from_waxed")));
        this.shapeless(RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 9).requires(ModItems.WAXED_ZINC_BLOCK.get()).group(null).unlockedBy(getHasName(ModItems.WAXED_ZINC_BLOCK.get()), this.has(ModItems.WAXED_ZINC_BLOCK.get())).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse("zinc_ingot_from_waxed")));

        this.createObserver(ModItems.STONE_OBSERVER, Items.COBBLESTONE);
        this.createObserver(ModItems.BLACKSTONE_OBSERVER, Items.BLACKSTONE);
        this.createObserver(ModItems.DEEPSLATE_OBSERVER, Items.COBBLED_DEEPSLATE);

        this.shaped(RecipeCategory.REDSTONE, Items.OBSERVER)
                .define('Q', Items.QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', Items.COBBLESTONE)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.woodenBoat(ModItems.CRIMSON_BOAT.get(), Items.CRIMSON_PLANKS);
        this.woodenBoat(ModItems.WARPED_BOAT.get(), Items.WARPED_PLANKS);

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
        this.modChestBoat(ModItems.CRIMSON_CHEST_BOAT.get(), ModItems.CRIMSON_BOAT.get());
        this.modChestBoat(ModItems.WARPED_CHEST_BOAT.get(), ModItems.WARPED_BOAT.get());

        this.createCrafter(ModItems.OAK_CRAFTER.get(), ModItems.OAK_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.SPRUCE_CRAFTER.get(), ModItems.SPRUCE_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.BIRCH_CRAFTER.get(), ModItems.BIRCH_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.JUNGLE_CRAFTER.get(), ModItems.JUNGLE_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.ACACIA_CRAFTER.get(), ModItems.ACACIA_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.DARK_OAK_CRAFTER.get(), ModItems.DARK_OAK_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.CRIMSON_CRAFTER.get(), ModItems.CRIMSON_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.WARPED_CRAFTER.get(), ModItems.WARPED_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.MANGROVE_CRAFTER.get(), ModItems.MANGROVE_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.CHERRY_CRAFTER.get(), ModItems.CHERRY_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.BAMBOO_CRAFTER.get(), ModItems.BAMBOO_CRAFTING_TABLE.get());
        this.createCrafter(ModItems.PALE_OAK_CRAFTER.get(), ModItems.PALE_OAK_CRAFTING_TABLE.get());

        this.shaped(RecipeCategory.REDSTONE, Items.CRAFTER)
                .define('#', Items.IRON_INGOT)
                .define('C', Items.CRAFTING_TABLE)
                .define('R', Items.REDSTONE)
                .define('D', Items.DROPPER)
                .pattern("###")
                .pattern("#C#")
                .pattern("RDR")
                .unlockedBy("has_dropper", this.has(Items.DROPPER))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createMinecart(ModItems.STONE_FURNACE_MINECART.get(), ModItems.STONE_FURNACE.get());
        this.createMinecart(ModItems.BLACKSTONE_FURNACE_MINECART.get(), ModItems.BLACKSTONE_FURNACE.get());
        this.createMinecart(ModItems.DEEPSLATE_FURNACE_MINECART.get(), ModItems.DEEPSLATE_FURNACE.get());

        this.shapeless(RecipeCategory.TRANSPORTATION, Items.FURNACE_MINECART)
                .requires(Items.FURNACE)
                .requires(Items.MINECART)
                .unlockedBy("has_minecart", this.has(Items.MINECART))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createChests(ModItems.OAK_CHEST.get(), ModItems.OAK_TRAPPED_CHEST.get(), Items.OAK_PLANKS);
        this.createChests(ModItems.SPRUCE_CHEST.get(), ModItems.SPRUCE_TRAPPED_CHEST.get(), Items.SPRUCE_PLANKS);
        this.createChests(ModItems.BIRCH_CHEST.get(), ModItems.BIRCH_TRAPPED_CHEST.get(), Items.BIRCH_PLANKS);
        this.createChests(ModItems.JUNGLE_CHEST.get(), ModItems.JUNGLE_TRAPPED_CHEST.get(), Items.JUNGLE_PLANKS);
        this.createChests(ModItems.ACACIA_CHEST.get(), ModItems.ACACIA_TRAPPED_CHEST.get(), Items.ACACIA_PLANKS);
        this.createChests(ModItems.DARK_OAK_CHEST.get(), ModItems.DARK_OAK_TRAPPED_CHEST.get(), Items.DARK_OAK_PLANKS);
        this.createChests(ModItems.CRIMSON_CHEST.get(), ModItems.CRIMSON_TRAPPED_CHEST.get(), Items.CRIMSON_PLANKS);
        this.createChests(ModItems.WARPED_CHEST.get(), ModItems.WARPED_TRAPPED_CHEST.get(), Items.WARPED_PLANKS);
        this.createChests(ModItems.MANGROVE_CHEST.get(), ModItems.MANGROVE_TRAPPED_CHEST.get(), Items.MANGROVE_PLANKS);
        this.createChests(ModItems.CHERRY_CHEST.get(), ModItems.CHERRY_TRAPPED_CHEST.get(), Items.CHERRY_PLANKS);
        this.createChests(ModItems.BAMBOO_CHEST.get(), ModItems.BAMBOO_TRAPPED_CHEST.get(), Items.BAMBOO_PLANKS);
        this.createChests(ModItems.PALE_OAK_CHEST.get(), ModItems.PALE_OAK_TRAPPED_CHEST.get(), Items.PALE_OAK_PLANKS);

        this.shaped(RecipeCategory.DECORATIONS, Items.CHEST)
                .define('#', ItemTags.PLANKS)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_lots_of_items", net.minecraft.advancements.triggers.CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), new InventoryChangeTrigger.TriggerInstance.Slots(MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY), List.of())))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shapeless(RecipeCategory.REDSTONE, Items.TRAPPED_CHEST)
                .requires(Items.CHEST)
                .requires(Items.TRIPWIRE_HOOK)
                .unlockedBy("has_tripwire_hook", this.has(Items.TRIPWIRE_HOOK))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.SHULKER_BOX)
                .define('#', Items.CHEST)
                .define('-', Items.SHULKER_SHELL)
                .pattern("-")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_shulker_shell", this.has(Items.SHULKER_SHELL))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.REDSTONE, Items.HOPPER)
                .define('C', Items.CHEST)
                .define('I', Items.IRON_INGOT)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.COPPER_CHEST.weathering().unaffected())
                .define('#', Items.COPPER_INGOT)
                .define('X', Items.CHEST)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_copper_chest", this.has(Items.COPPER_CHEST.weathering().unaffected()))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.SHULKER_BOX)
                .define('#', ModItemTags.CHESTS)
                .define('-', Items.SHULKER_SHELL)
                .pattern("-")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_shulker_shell", this.has(Items.SHULKER_SHELL))
                .save(this.output, "shulker_shell_mod");

        this.shaped(RecipeCategory.REDSTONE, Items.HOPPER)
                .define('C', ModItemTags.CHESTS)
                .define('I', Items.IRON_INGOT)
                .pattern("I I")
                .pattern("ICI")
                .pattern(" I ")
                .unlockedBy("has_iron_ingot", this.has(Items.IRON_INGOT))
                .save(this.output, "hopper_mod");

        this.shaped(RecipeCategory.DECORATIONS, Items.COPPER_CHEST.weathering().unaffected())
                .define('#', Items.COPPER_INGOT)
                .define('X', ModItemTags.CHESTS)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_copper_chest", this.has(Items.COPPER_CHEST.weathering().unaffected()))
                .save(this.output, "copper_chest_mod");

        this.shapeless(RecipeCategory.TRANSPORTATION, Items.CHEST_MINECART)
                .requires(Items.CHEST)
                .requires(Items.MINECART)
                .unlockedBy("has_minecart", this.has(Items.MINECART))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.createMinecart(ModItems.OAK_CHEST_MINECART.get(), ModItems.OAK_CHEST.get());
        this.createMinecart(ModItems.SPRUCE_CHEST_MINECART.get(), ModItems.SPRUCE_CHEST.get());
        this.createMinecart(ModItems.BIRCH_CHEST_MINECART.get(), ModItems.BIRCH_CHEST.get());
        this.createMinecart(ModItems.JUNGLE_CHEST_MINECART.get(), ModItems.JUNGLE_CHEST.get());
        this.createMinecart(ModItems.ACACIA_CHEST_MINECART.get(), ModItems.ACACIA_CHEST.get());
        this.createMinecart(ModItems.DARK_OAK_CHEST_MINECART.get(), ModItems.DARK_OAK_CHEST.get());
        this.createMinecart(ModItems.CRIMSON_CHEST_MINECART.get(), ModItems.CRIMSON_CHEST.get());
        this.createMinecart(ModItems.WARPED_CHEST_MINECART.get(), ModItems.WARPED_CHEST.get());
        this.createMinecart(ModItems.MANGROVE_CHEST_MINECART.get(), ModItems.MANGROVE_CHEST.get());
        this.createMinecart(ModItems.CHERRY_CHEST_MINECART.get(), ModItems.CHERRY_CHEST.get());
        this.createMinecart(ModItems.BAMBOO_CHEST_MINECART.get(), ModItems.BAMBOO_CHEST.get());
        this.createMinecart(ModItems.PALE_OAK_CHEST_MINECART.get(), ModItems.PALE_OAK_CHEST.get());

        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.OAK_MOSAIC.get(), Items.OAK_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.SPRUCE_MOSAIC.get(), Items.SPRUCE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.BIRCH_MOSAIC.get(), Items.BIRCH_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.JUNGLE_MOSAIC.get(), Items.JUNGLE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.ACACIA_MOSAIC.get(), Items.ACACIA_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.DARK_OAK_MOSAIC.get(), Items.DARK_OAK_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.CRIMSON_MOSAIC.get(), Items.CRIMSON_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.WARPED_MOSAIC.get(), Items.WARPED_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.MANGROVE_MOSAIC.get(), Items.MANGROVE_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.CHERRY_MOSAIC.get(), Items.CHERRY_SLAB);
        this.mosaicBuilder(RecipeCategory.DECORATIONS, ModItems.PALE_OAK_MOSAIC.get(), Items.PALE_OAK_SLAB);

        this.createBaton(ModItems.STONE_BATON.get(), Items.COBBLESTONE, "cobblestone");
        this.createBaton(ModItems.GRANITE_BATON.get(), Items.GRANITE, "granite");
        this.createBaton(ModItems.DIORITE_BATON.get(), Items.DIORITE, "diorite");
        this.createBaton(ModItems.ANDESITE_BATON.get(), Items.ANDESITE, "andesite");
        this.createBaton(ModItems.DEEPSLATE_BATON.get(), Items.COBBLED_DEEPSLATE, "cobbled_deepslate");
        this.createBaton(ModItems.TUFF_BATON.get(), Items.TUFF, "tuff");
        this.createBaton(ModItems.CALCITE_BATON.get(), Items.CALCITE, "calcite");
        this.createBaton(ModItems.PACKED_MUD_BATON.get(), Items.PACKED_MUD, "packed_mud");
        this.createBaton(ModItems.SANDSTONE_BATON.get(), Items.SANDSTONE, "sandstone");
        this.createBaton(ModItems.RED_SANDSTONE_BATON.get(), Items.RED_SANDSTONE, "red_sandstone");
        this.createBaton(ModItems.SOUL_SANDSTONE_BATON.get(), ModItems.SOUL_SANDSTONE.get(), "soul_sandstone");
        this.createBaton(ModItems.END_STONE_BATON.get(), Items.END_STONE, "end_stone");
        this.createBaton(ModItems.NETHERRACK_BATON.get(), Items.NETHERRACK, "netherrack");
        this.createBaton(ModItems.BLACKSTONE_BATON.get(), Items.BLACKSTONE, "blackstone");
        this.createBaton(ModItems.BASALT_BATON.get(), Items.BASALT, "basalt");
        this.createBaton(ModItems.OBSIDIAN_BATON, Items.OBSIDIAN, "obsidian");
        this.createBaton(ModItems.TERRACOTTA_BATON.get(), ItemTags.TERRACOTTA, "terracotta");
        this.createBaton(ModItems.CONCRETE_BATON.get(), ModItemTags.CONCRETE, "concrete");
        this.createBaton(ModItems.GABBRO_BATON.get(), ModItems.GABBRO.get(), "gabbro");
        this.createBaton(ModItems.RHYOLITE_BATON.get(), ModItems.RHYOLITE.get(), "rhyolite");
        this.createBaton(ModItems.PUMICE_BATON.get(), ModItems.PUMICE.get(), "pumice");
        this.createBaton(ModItems.CINNABAR_BATON.get(), Items.CINNABAR, "cinnabar");

        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, Items.ICE, ModItems.ICE_SHARD.get());
        this.createBatonWithCustomCount(Items.LAPIS_LAZULI, Items.LAPIS_BLOCK, "lapis_block", 18);
        this.createBatonWithCustomCount(Items.RESIN_CLUMP, Items.RESIN_BLOCK, "resin_block", 18);
        this.createBatonWithCustomCount(Items.QUARTZ, Items.QUARTZ_BLOCK, "quartz_block", 8);
        this.createBatonWithCustomCount(ModItems.ICE_SHARD.get(), Items.ICE, "ice", 8);

        this.shapeless(RecipeCategory.MISC, Items.LAPIS_LAZULI, 9).requires(Items.LAPIS_BLOCK).unlockedBy(getHasName(Items.LAPIS_BLOCK), this.has(Items.LAPIS_BLOCK)).save(this.output.withConditions(NeoForgeConditions.never()));
        this.shapeless(RecipeCategory.MISC, Items.RESIN_CLUMP, 9).requires(Items.RESIN_BLOCK).unlockedBy(getHasName(Items.RESIN_BLOCK), this.has(Items.RESIN_BLOCK)).save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.SNOW, 6)
                .define('#', Items.SNOW_BLOCK)
                .pattern("###")
                .unlockedBy("has_snowball", this.has(Items.SNOWBALL))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.DECORATIONS, Items.SNOW, 2)
                .define('#', Items.SNOWBALL)
                .pattern("##")
                .unlockedBy("has_snowball", this.has(Items.SNOWBALL))
                .save(this.output, "snowball_mod");


        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.BLACK_TERRACOTTA_SLAB.get(), Items.DYE.black());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.BLUE_TERRACOTTA_SLAB.get(), Items.DYE.blue());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.BROWN_TERRACOTTA_SLAB.get(), Items.DYE.brown());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.CYAN_TERRACOTTA_SLAB.get(), Items.DYE.cyan());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.GRAY_TERRACOTTA_SLAB.get(), Items.DYE.gray());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.GREEN_TERRACOTTA_SLAB.get(), Items.DYE.green());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.LIGHT_BLUE_TERRACOTTA_SLAB.get(), Items.DYE.lightBlue());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.LIGHT_GRAY_TERRACOTTA_SLAB.get(), Items.DYE.lightGray());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.LIME_TERRACOTTA_SLAB.get(), Items.DYE.lime());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.MAGENTA_TERRACOTTA_SLAB.get(), Items.DYE.magenta());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.ORANGE_TERRACOTTA_SLAB.get(), Items.DYE.orange());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.PINK_TERRACOTTA_SLAB.get(), Items.DYE.pink());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.PURPLE_TERRACOTTA_SLAB.get(), Items.DYE.purple());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.RED_TERRACOTTA_SLAB.get(), Items.DYE.red());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.WHITE_TERRACOTTA_SLAB.get(), Items.DYE.white());
        this.coloredTerracottaSlabFromTerracottaSlabAndDye(ModItems.YELLOW_TERRACOTTA_SLAB.get(), Items.DYE.yellow());

        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.BLACK_TERRACOTTA_STAIRS.get(), Items.DYE.black());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.BLUE_TERRACOTTA_STAIRS.get(), Items.DYE.blue());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.BROWN_TERRACOTTA_STAIRS.get(), Items.DYE.brown());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.CYAN_TERRACOTTA_STAIRS.get(), Items.DYE.cyan());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.GRAY_TERRACOTTA_STAIRS.get(), Items.DYE.gray());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.GREEN_TERRACOTTA_STAIRS.get(), Items.DYE.green());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), Items.DYE.lightBlue());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), Items.DYE.lightGray());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.LIME_TERRACOTTA_STAIRS.get(), Items.DYE.lime());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.MAGENTA_TERRACOTTA_STAIRS.get(), Items.DYE.magenta());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.ORANGE_TERRACOTTA_STAIRS.get(), Items.DYE.orange());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.PINK_TERRACOTTA_STAIRS.get(), Items.DYE.pink());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.PURPLE_TERRACOTTA_STAIRS.get(), Items.DYE.purple());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.RED_TERRACOTTA_STAIRS.get(), Items.DYE.red());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.WHITE_TERRACOTTA_STAIRS.get(), Items.DYE.white());
        this.coloredTerracottaStairsFromTerracottaStairsAndDye(ModItems.YELLOW_TERRACOTTA_STAIRS.get(), Items.DYE.yellow());

        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.BLACK_TERRACOTTA_WALL.get(), Items.DYE.black());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.BLUE_TERRACOTTA_WALL.get(), Items.DYE.blue());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.BROWN_TERRACOTTA_WALL.get(), Items.DYE.brown());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.CYAN_TERRACOTTA_WALL.get(), Items.DYE.cyan());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.GRAY_TERRACOTTA_WALL.get(), Items.DYE.gray());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.GREEN_TERRACOTTA_WALL.get(), Items.DYE.green());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.LIGHT_BLUE_TERRACOTTA_WALL.get(), Items.DYE.lightBlue());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.LIGHT_GRAY_TERRACOTTA_WALL.get(), Items.DYE.lightGray());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.LIME_TERRACOTTA_WALL.get(), Items.DYE.lime());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.MAGENTA_TERRACOTTA_WALL.get(), Items.DYE.magenta());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.ORANGE_TERRACOTTA_WALL.get(), Items.DYE.orange());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.PINK_TERRACOTTA_WALL.get(), Items.DYE.pink());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.PURPLE_TERRACOTTA_WALL.get(), Items.DYE.purple());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.RED_TERRACOTTA_WALL.get(), Items.DYE.red());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.WHITE_TERRACOTTA_WALL.get(), Items.DYE.white());
        this.coloredTerracottaWallFromTerracottaWallAndDye(ModItems.YELLOW_TERRACOTTA_WALL.get(), Items.DYE.yellow());

        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.BLACK_TERRACOTTA_FENCE.get(), Items.DYE.black());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.BLUE_TERRACOTTA_FENCE.get(), Items.DYE.blue());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.BROWN_TERRACOTTA_FENCE.get(), Items.DYE.brown());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.CYAN_TERRACOTTA_FENCE.get(), Items.DYE.cyan());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.GRAY_TERRACOTTA_FENCE.get(), Items.DYE.gray());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.GREEN_TERRACOTTA_FENCE.get(), Items.DYE.green());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.LIGHT_BLUE_TERRACOTTA_FENCE.get(), Items.DYE.lightBlue());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.LIGHT_GRAY_TERRACOTTA_FENCE.get(), Items.DYE.lightGray());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.LIME_TERRACOTTA_FENCE.get(), Items.DYE.lime());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.MAGENTA_TERRACOTTA_FENCE.get(), Items.DYE.magenta());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.ORANGE_TERRACOTTA_FENCE.get(), Items.DYE.orange());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.PINK_TERRACOTTA_FENCE.get(), Items.DYE.pink());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.PURPLE_TERRACOTTA_FENCE.get(), Items.DYE.purple());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.RED_TERRACOTTA_FENCE.get(), Items.DYE.red());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.WHITE_TERRACOTTA_FENCE.get(), Items.DYE.white());
        this.coloredTerracottaFenceFromTerracottaFenceAndDye(ModItems.YELLOW_TERRACOTTA_FENCE.get(), Items.DYE.yellow());

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_STONE_TILES.get())
                .requires(ModItems.STONE_TILES.get())
                .requires(Items.VINE).group("mossy_stone_tiles")
                .unlockedBy("has_vine", this.has(Items.VINE))
                .save(this.output, getConversionRecipeName(ModItems.MOSSY_STONE_TILES.get(), Items.VINE));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_STONE_TILES.get())
                .requires(ModItems.STONE_TILES.get())
                .requires(Items.MOSS_BLOCK).group("mossy_stone_tiles")
                .unlockedBy("has_moss_block", this.has(Items.MOSS_BLOCK))
                .save(this.output, getConversionRecipeName(ModItems.MOSSY_STONE_TILES.get(), Items.MOSS_BLOCK));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.STONE_TILES.get()), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.CRACKED_STONE_TILES.get(), 0.1F, 200).unlockedBy("has_stone_tiles", this.has(ModItems.STONE_TILES.get())).save(this.output);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.LAPIS_BLOCK), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.SMOOTH_LAPIS.get(), 0.1F, 200).unlockedBy("has_lapis_block", this.has(Items.LAPIS_BLOCK)).save(this.output);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.SCULK_VEIN), RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.SCULK_BRICK.get(), 0.1F, 200).unlockedBy("has_lapis_block", this.has(Items.LAPIS_BLOCK)).save(this.output);

        this.threeByThreePacker(RecipeCategory.MISC, Items.SCULK, Items.SCULK_VEIN);
        this.createBatonWithCustomCount(Items.SCULK_VEIN, Items.SCULK, "sculk_vein", 18);
        this.twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_BRICKS.get(), ModItems.SCULK_BRICK.get());

        this.copyBronzeSmithingTemplate(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), Items.COBBLESTONE);

        this.bronzeSmithing(Items.COPPER_CHESTPLATE, RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE.get());
        this.bronzeSmithing(Items.COPPER_LEGGINGS, RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS.get());
        this.bronzeSmithing(Items.COPPER_HELMET, RecipeCategory.COMBAT, ModItems.BRONZE_HELMET.get());
        this.bronzeSmithing(Items.COPPER_BOOTS, RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS.get());
        this.bronzeSmithing(Items.COPPER_SWORD, RecipeCategory.COMBAT, ModItems.BRONZE_SWORD.get());
        this.bronzeSmithing(Items.COPPER_AXE, RecipeCategory.TOOLS, ModItems.BRONZE_AXE.get());
        this.bronzeSmithing(Items.COPPER_PICKAXE, RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE.get());
        this.bronzeSmithing(Items.COPPER_HOE, RecipeCategory.TOOLS, ModItems.BRONZE_HOE.get());
        this.bronzeSmithing(Items.COPPER_SHOVEL, RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL.get());
        this.bronzeSmithing(Items.COPPER_SPEAR, RecipeCategory.TOOLS, ModItems.BRONZE_SPEAR.get());
        this.bronzeSmithing(Items.COPPER_HORSE_ARMOR, RecipeCategory.TOOLS, ModItems.BRONZE_HORSE_ARMOR.get());
        this.bronzeSmithing(Items.COPPER_NAUTILUS_ARMOR, RecipeCategory.TOOLS, ModItems.BRONZE_NAUTILUS_ARMOR.get());

        this.flameTestTorch(ModItems.IRON_TORCH.get(), Items.IRON_NUGGET);
        this.createLanterns(ModItems.IRON_FIRE_LANTERN.get(), Items.SOUL_LANTERN, Items.LANTERN, Items.IRON_NUGGET, Items.IRON_INGOT, ModItems.IRON_TORCH.get());

        this.createLanterns(ModItems.COPPER_FIRE_LANTERN.get(), ModItems.COPPER_SOUL_LANTERN.get(), Items.COPPER_LANTERN.weathering().unaffected(), Items.COPPER_NUGGET, Items.COPPER_INGOT, Items.COPPER_TORCH);

        this.createChain(ModItems.ZINC_CHAIN.get(), ModItems.ZINC_INGOT.get(), ModItems.ZINC_NUGGET.get());
        this.createChain(ModItems.GOLD_CHAIN.get(), Items.GOLD_INGOT, Items.GOLD_NUGGET);
        this.createChain(ModItems.NETHERITE_CHAIN.get(), Items.NETHERITE_INGOT, ModItems.NETHERITE_NUGGET.get());
        this.createChain(ModItems.SILVER_CHAIN.get(), ModItems.SILVER_INGOT.get(), ModItems.SILVER_NUGGET.get());
        this.createChain(ModItems.TIN_CHAIN.get(), ModItems.TIN_INGOT.get(), ModItems.TIN_NUGGET.get());
        this.createChain(ModItems.TUNGSTEN_CHAIN.get(), ModItems.TUNGSTEN_INGOT.get(), ModItems.TUNGSTEN_NUGGET.get());
        this.createChain(ModItems.PLATINUM_CHAIN.get(), ModItems.PLATINUM_INGOT.get(), ModItems.PLATINUM_NUGGET.get());
        this.createChain(ModItems.LEAD_CHAIN.get(), ModItems.LEAD_INGOT.get(), ModItems.LEAD_NUGGET.get());
        this.createChain(ModItems.URANIUM_CHAIN.get(), ModItems.URANIUM_INGOT.get(), ModItems.URANIUM_NUGGET.get());
        this.createChain(ModItems.BRONZE_CHAIN.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZE_NUGGET.get());
        this.createChain(ModItems.BRASS_CHAIN.get(), ModItems.BRASS_INGOT.get(), ModItems.BRASS_NUGGET.get());
        this.createChain(ModItems.STEEL_CHAIN.get(), ModItems.STEEL_INGOT.get(), ModItems.STEEL_NUGGET.get());

        this.flameTestTorch(ModItems.ZINC_TORCH.get(), ModItems.ZINC_NUGGET.get());
        this.flameTestTorch(ModItems.SILVER_TORCH.get(), ModItems.SILVER_NUGGET.get());
        this.flameTestTorch(ModItems.TIN_TORCH.get(), ModItems.TIN_NUGGET.get());
        this.flameTestTorch(ModItems.TUNGSTEN_TORCH.get(), ModItems.TUNGSTEN_NUGGET.get());
        this.flameTestTorch(ModItems.PLATINUM_TORCH.get(), ModItems.PLATINUM_NUGGET.get());
        this.flameTestTorch(ModItems.GOLD_TORCH.get(), Items.GOLD_NUGGET);
        this.flameTestTorch(ModItems.LEAD_TORCH.get(), ModItems.LEAD_NUGGET.get());
        this.flameTestTorch(ModItems.URANIUM_TORCH.get(), ModItems.URANIUM_NUGGET.get());

        this.fletching(ModItems.EXPLOSIVE_ARROW.get(), Items.ARROW, Items.GUNPOWDER);
        this.fletching(ModItems.SHARPENED_ARROW.get(), Items.ARROW, Items.FLINT);
        this.fletching(ModItems.STREAMLINED_ARROW.get(), Items.ARROW, Items.PHANTOM_MEMBRANE);

        this.slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB.get(), Ingredient.of(new ItemLike[]{ModBlocks.SOUL_SANDSTONE.get(), ModBlocks.CHISELED_SOUL_SANDSTONE.get()}))
                .unlockedBy("has_soul_sandstone", this.has(ModBlocks.SOUL_SANDSTONE.get()))
                .unlockedBy("has_chiseled_soul_sandstone", this.has(ModBlocks.CHISELED_SOUL_SANDSTONE.get()))
                .save(this.output, "soul_sandstone_slab_alt");

        this.stairBuilder(ModBlocks.SOUL_SANDSTONE_STAIRS.get(), Ingredient.of(new ItemLike[]{ModBlocks.SOUL_SANDSTONE.get(), ModBlocks.CHISELED_SOUL_SANDSTONE.get()}))
                .unlockedBy("has_soul_sandstone", this.has(ModBlocks.SOUL_SANDSTONE.get()))
                .unlockedBy("has_chiseled_soul_sandstone", this.has(ModBlocks.CHISELED_SOUL_SANDSTONE.get()))
                .save(this.output, "soul_sandstone_stairs_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICKS, 4)
                .define('#', Items.DEEPSLATE)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(Items.DEEPSLATE), this.has(Items.DEEPSLATE))
                .save(this.output, "deepslate_bricks_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, 4)
                .define('#', ModItems.POLISHED_STONE.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ModItems.POLISHED_STONE.get()), this.has(ModItems.POLISHED_STONE.get()))
                .save(this.output, "stone_bricks_alt");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.DEEPSLATE), RecipeCategory.BUILDING_BLOCKS, CookingBookCategory.BLOCKS, ModItems.SMOOTH_DEEPSLATE.get(), 0.1F, 200).unlockedBy("has_deepslate", this.has(Items.DEEPSLATE)).save(this.output, "smooth_deepslate_smelting");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.QUARTZ_PILLAR, 2)
                .define('#', Items.QUARTZ_BLOCK)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_chiseled_quartz_block", this.has(Blocks.CHISELED_QUARTZ_BLOCK))
                .unlockedBy("has_quartz_block", this.has(Blocks.QUARTZ_BLOCK))
                .unlockedBy("has_quartz_pillar", this.has(Blocks.QUARTZ_PILLAR))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.QUARTZ_PILLAR, 3)
                .define('#', Items.QUARTZ_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_chiseled_quartz_block", this.has(Blocks.CHISELED_QUARTZ_BLOCK))
                .unlockedBy("has_quartz_block", this.has(Blocks.QUARTZ_BLOCK))
                .unlockedBy("has_quartz_pillar", this.has(Blocks.QUARTZ_PILLAR))
                .save(this.output, "quartz_pillar_mod");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.PURPUR_PILLAR)
                .define('#', Items.PURPUR_SLAB)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_purpur_block", this.has(Blocks.PURPUR_BLOCK))
                .save(this.output.withConditions(NeoForgeConditions.never()));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.PURPUR_PILLAR, 3)
                .define('#', Items.PURPUR_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_purpur_block", this.has(Blocks.PURPUR_BLOCK))
                .save(this.output, "purpur_pillar_mod");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.GILDED_BLACKSTONE, 2)
                .define('#', Items.BLACKSTONE)
                .define('^', Items.GOLD_NUGGET)
                .pattern("#^")
                .pattern("^#")
                .unlockedBy("has_blackstone", this.has(Items.BLACKSTONE))
                .save(this.output);

        this.shaped(RecipeCategory.DECORATIONS, ModBlocks.TINTED_GLASS_PANE.get(), 16)
                .define('#', Blocks.TINTED_GLASS)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_tinted_glass", this.has(Blocks.TINTED_GLASS))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.HEART_BANNER_PATTERN.get())
                .requires(Items.PAPER)
                .requires(Items.CREAKING_HEART)
                .unlockedBy("has_creaking_heart", this.has(Items.CREAKING_HEART))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.DIAMOND_BANNER_PATTERN.get())
                .requires(Items.PAPER)
                .requires(Items.DIAMOND)
                .unlockedBy("has_diamond", this.has(Items.DIAMOND))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.SPADE_BANNER_PATTERN.get())
                .requires(Items.PAPER)
                .requires(Items.WOODEN_SHOVEL)
                .unlockedBy("has_wooden_shovel", this.has(Items.WOODEN_SHOVEL))
                .save(this.output);

        this.shapeless(RecipeCategory.MISC, ModItems.CLUB_BANNER_PATTERN.get())
                .requires(Items.PAPER)
                .requires(ModItems.STONE_BATON.get())
                .unlockedBy("has_stone_baton", this.has(ModItems.STONE_BATON.get()))
                .save(this.output);

        this.slabBuilder(
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.LAPIS_SLAB.get(),
                Ingredient.of(new ItemLike[]{Items.LAPIS_BLOCK, ModItems.LAPIS_PILLAR.get(), ModItems.CHISELED_LAPIS.get()})
                ).unlockedBy("has_chiseled_lapis_block", this.has(Items.LAPIS_BLOCK))
                .unlockedBy("has_lapis_block", this.has(ModItems.LAPIS_PILLAR.get()))
                .unlockedBy("has_lapis_pillar", this.has(ModItems.CHISELED_LAPIS.get()))
                .save(this.output, "lapis_slab_alt");

        this.stairBuilder(
                ModItems.LAPIS_STAIRS.get(),
                Ingredient.of(new ItemLike[]{Items.LAPIS_BLOCK, ModItems.LAPIS_PILLAR.get(), ModItems.CHISELED_LAPIS.get()})
                ).unlockedBy("has_chiseled_lapis_block", this.has(Items.LAPIS_BLOCK))
                .unlockedBy("has_lapis_block", this.has(ModItems.LAPIS_PILLAR.get()))
                .unlockedBy("has_lapis_pillar", this.has(ModItems.CHISELED_LAPIS.get()))
                .save(this.output, "lapis_stairs_alt");

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_PILLAR.asItem(), 3)
                .define('#', Items.LAPIS_BLOCK)
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_lapis", this.has(Blocks.LAPIS_BLOCK))
                .save(this.output);

        this.grate(ModBlocks.IRON_GRATE.get(), Blocks.IRON_BLOCK);
        this.grate(ModBlocks.EXPOSED_IRON_GRATE.get(), ModBlocks.EXPOSED_IRON.get());
        this.grate(ModBlocks.WEATHERED_IRON_GRATE.get(), ModBlocks.WEATHERED_IRON.get());
        this.grate(ModBlocks.RUSTED_IRON_GRATE.get(), ModBlocks.RUSTED_IRON.get());
        this.grate(ModBlocks.WAXED_IRON_GRATE.get(), ModBlocks.WAXED_IRON_BLOCK.get());
        this.grate(ModBlocks.WAXED_EXPOSED_IRON_GRATE.get(), ModBlocks.WAXED_EXPOSED_IRON.get());
        this.grate(ModBlocks.WAXED_WEATHERED_IRON_GRATE.get(), ModBlocks.WAXED_WEATHERED_IRON.get());
        this.grate(ModBlocks.WAXED_RUSTED_IRON_GRATE.get(), ModBlocks.WAXED_RUSTED_IRON.get());
        this.copperBulb(ModBlocks.IRON_BULB.get(), Blocks.IRON_BLOCK);
        this.copperBulb(ModBlocks.EXPOSED_IRON_BULB.get(), ModBlocks.EXPOSED_IRON.get());
        this.copperBulb(ModBlocks.WEATHERED_IRON_BULB.get(), ModBlocks.WEATHERED_IRON.get());
        this.copperBulb(ModBlocks.RUSTED_IRON_BULB.get(), ModBlocks.RUSTED_IRON.get());
        this.copperBulb(ModBlocks.WAXED_IRON_BULB.get(), ModBlocks.WAXED_IRON_BLOCK.get());
        this.copperBulb(ModBlocks.WAXED_EXPOSED_IRON_BULB.get(), ModBlocks.WAXED_EXPOSED_IRON.get());
        this.copperBulb(ModBlocks.WAXED_WEATHERED_IRON_BULB.get(), ModBlocks.WAXED_WEATHERED_IRON.get());
        this.copperBulb(ModBlocks.WAXED_RUSTED_IRON_BULB.get(), ModBlocks.WAXED_RUSTED_IRON.get());

        this.grate(ModBlocks.ZINC_GRATE.get(), ModBlocks.ZINC_BLOCK.get());
        this.grate(ModBlocks.EXPOSED_ZINC_GRATE.get(), ModBlocks.EXPOSED_ZINC.get());
        this.grate(ModBlocks.WEATHERED_ZINC_GRATE.get(), ModBlocks.WEATHERED_ZINC.get());
        this.grate(ModBlocks.CORRODED_ZINC_GRATE.get(), ModBlocks.CORRODED_ZINC.get());
        this.grate(ModBlocks.WAXED_ZINC_GRATE.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        this.grate(ModBlocks.WAXED_EXPOSED_ZINC_GRATE.get(), ModBlocks.WAXED_EXPOSED_ZINC.get());
        this.grate(ModBlocks.WAXED_WEATHERED_ZINC_GRATE.get(), ModBlocks.WAXED_WEATHERED_ZINC.get());
        this.grate(ModBlocks.WAXED_CORRODED_ZINC_GRATE.get(), ModBlocks.WAXED_CORRODED_ZINC.get());
        this.copperBulb(ModBlocks.ZINC_BULB.get(), ModBlocks.ZINC_BLOCK.get());
        this.copperBulb(ModBlocks.EXPOSED_ZINC_BULB.get(), ModBlocks.EXPOSED_ZINC.get());
        this.copperBulb(ModBlocks.WEATHERED_ZINC_BULB.get(), ModBlocks.WEATHERED_ZINC.get());
        this.copperBulb(ModBlocks.CORRODED_ZINC_BULB.get(), ModBlocks.CORRODED_ZINC.get());
        this.copperBulb(ModBlocks.WAXED_ZINC_BULB.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        this.copperBulb(ModBlocks.WAXED_EXPOSED_ZINC_BULB.get(), ModBlocks.WAXED_EXPOSED_ZINC.get());
        this.copperBulb(ModBlocks.WAXED_WEATHERED_ZINC_BULB.get(), ModBlocks.WAXED_WEATHERED_ZINC.get());
        this.copperBulb(ModBlocks.WAXED_CORRODED_ZINC_BULB.get(), ModBlocks.WAXED_CORRODED_ZINC.get());

        this.grate(ModBlocks.SILVER_GRATE.get(), ModBlocks.SILVER_BLOCK.get());
        this.grate(ModBlocks.TIN_GRATE.get(), ModBlocks.TIN_BLOCK.get());
        this.grate(ModBlocks.TUNGSTEN_GRATE.get(), ModBlocks.TUNGSTEN_BLOCK.get());
        this.grate(ModBlocks.PLATINUM_GRATE.get(), ModBlocks.PLATINUM_BLOCK.get());
        this.grate(ModBlocks.GOLD_GRATE.get(), Blocks.GOLD_BLOCK);
        this.grate(ModBlocks.LEAD_GRATE.get(), ModBlocks.LEAD_BLOCK.get());
        this.grate(ModBlocks.URANIUM_GRATE.get(), ModBlocks.URANIUM_BLOCK.get());
        this.grate(ModBlocks.NETHERITE_GRATE.get(), Blocks.NETHERITE_BLOCK);
        this.grate(ModBlocks.BRONZE_GRATE.get(), ModBlocks.BRONZE_BLOCK.get());
        this.grate(ModBlocks.BRASS_GRATE.get(), ModBlocks.BRASS_BLOCK.get());
        this.grate(ModBlocks.STEEL_GRATE.get(), ModBlocks.STEEL_BLOCK.get());
        this.copperBulb(ModBlocks.SILVER_BULB.get(), ModBlocks.SILVER_BLOCK.get());
        this.copperBulb(ModBlocks.TIN_BULB.get(), ModBlocks.TIN_BLOCK.get());
        this.copperBulb(ModBlocks.TUNGSTEN_BULB.get(), ModBlocks.TUNGSTEN_BLOCK.get());
        this.copperBulb(ModBlocks.PLATINUM_BULB.get(), ModBlocks.PLATINUM_BLOCK.get());
        this.copperBulb(ModBlocks.GOLD_BULB.get(), Blocks.GOLD_BLOCK);
        this.copperBulb(ModBlocks.LEAD_BULB.get(), ModBlocks.LEAD_BLOCK.get());
        this.copperBulb(ModBlocks.URANIUM_BULB.get(), ModBlocks.URANIUM_BLOCK.get());
        this.copperBulb(ModBlocks.NETHERITE_BULB.get(), Blocks.NETHERITE_BLOCK);
        this.copperBulb(ModBlocks.BRONZE_BULB.get(), ModBlocks.BRONZE_BLOCK.get());
        this.copperBulb(ModBlocks.BRASS_BULB.get(), ModBlocks.BRASS_BLOCK.get());
        this.copperBulb(ModBlocks.STEEL_BULB.get(), ModBlocks.STEEL_BLOCK.get());


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
                    item = ModItems.RED_SANDSTONE_BATON.get();
                } else if (fence.asItem().getDescriptionId().contains("soul")){
                    item = ModItems.SOUL_SANDSTONE_BATON.get();
                } else {
                    item = ModItems.SANDSTONE_BATON.get();
                }
            } else if (fence.asItem().getDescriptionId().contains("end")) {
                item = ModItems.END_STONE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("black")) {
                item = ModItems.BLACKSTONE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("drip")) {
                item = Items.POINTED_DRIPSTONE;
            } else {
                item = ModItems.STONE_BATON.get();
            }
        } else if (fence.asItem().getDescriptionId().contains("prismarine")) {
            if (fence.asItem().getDescriptionId().contains("elder")) {
                item = ModItems.ELDER_PRISMARINE_SHARD.get();
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
            item = ModItems.GRANITE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("diorite")) {
            item = ModItems.DIORITE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("andesite")) {
            item = ModItems.ANDESITE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("tuff")) {
            item = ModItems.TUFF_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("obsidian")) {
            item = ModItems.OBSIDIAN_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("calcite")) {
            item = ModItems.CALCITE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("mud")) {
            item = ModItems.PACKED_MUD_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("basalt")) {
            item = ModItems.BASALT_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("netherrack")) {
            item = ModItems.NETHERRACK_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("terracotta")) {
            item = ModItems.TERRACOTTA_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("concrete")) {
            item = ModItems.CONCRETE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("ice") && !fence.asItem().getDescriptionId().contains("pum")) {
            item = ModItems.ICE_SHARD.get();
        } else if (fence.asItem().getDescriptionId().contains("deepslate")) {
            item = ModItems.DEEPSLATE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("gabbro")) {
            item = ModItems.GABBRO_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("rhyolite")) {
            item = ModItems.RHYOLITE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("pumice")) {
            item = ModItems.PUMICE_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("sulfur")) {
            item = Items.SULFUR_SPIKE;
        } else if (fence.asItem().getDescriptionId().contains("cinnabar")) {
            item = ModItems.CINNABAR_BATON.get();
        } else if (fence.asItem().getDescriptionId().contains("brick")) {
            if (fence.asItem().getDescriptionId().contains("stone")) {
                if (fence.asItem().getDescriptionId().contains("sand")) {
                    if (fence.asItem().getDescriptionId().contains("red")){
                        item = ModItems.RED_SANDSTONE_BATON.get();
                    } else if (fence.asItem().getDescriptionId().contains("soul")){
                        item = ModItems.SOUL_SANDSTONE_BATON.get();
                    } else {
                        item = ModItems.SANDSTONE_BATON.get();
                    }
                } else if (fence.asItem().getDescriptionId().contains("end")) {
                    item = ModItems.END_STONE_BATON.get();
                } else if (fence.asItem().getDescriptionId().contains("black")) {
                    item = ModItems.BLACKSTONE_BATON.get();
                } else if (fence.asItem().getDescriptionId().contains("drip")) {
                    item = Items.POINTED_DRIPSTONE;
                } else {
                    item = ModItems.STONE_BATON.get();
                }
            } else if (fence.asItem().getDescriptionId().contains("prismarine")) {
                if (fence.asItem().getDescriptionId().contains("elder")) {
                    item = ModItems.ELDER_PRISMARINE_SHARD.get();
                } else {
                    item = Items.PRISMARINE_SHARD;
                }
            } else if (fence.asItem().getDescriptionId().contains("resin")) {
                item = Items.RESIN_BRICK;
            } else if (fence.asItem().getDescriptionId().contains("sculk")) {
                item = ModItems.SCULK_BRICK.get();
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
                item = ModItems.GRANITE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("diorite")) {
                item = ModItems.DIORITE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("andesite")) {
                item = ModItems.ANDESITE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("tuff")) {
                item = ModItems.TUFF_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("obsidian")) {
                item = ModItems.OBSIDIAN_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("calcite")) {
                item = ModItems.CALCITE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("mud")) {
                item = ModItems.PACKED_MUD_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("basalt")) {
                item = ModItems.BASALT_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("nether")) {
                item = Items.NETHER_BRICK;
            } else if (fence.asItem().getDescriptionId().contains("terracotta")) {
                item = ModItems.TERRACOTTA_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("concrete")) {
                item = ModItems.CONCRETE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("ice") && !fence.asItem().getDescriptionId().contains("pum")) {
                item = ModItems.ICE_SHARD.get();
            } else if (fence.asItem().getDescriptionId().contains("deepslate")) {
                item = ModItems.DEEPSLATE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("gabbro")) {
                item = ModItems.GABBRO_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("rhyolite")) {
                item = ModItems.RHYOLITE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("pumice")) {
                item = ModItems.PUMICE_BATON.get();
            } else if (fence.asItem().getDescriptionId().contains("sulfur")) {
                item = Items.SULFUR_SPIKE;
            } else if (fence.asItem().getDescriptionId().contains("cinnabar")) {
                item = ModItems.CINNABAR_BATON.get();
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
                .save(this.output.withConditions(NeoForgeConditions.never()));
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

    protected void createWaxedRecipe(RecipeCategory recipeCategory, Item waxedBlock, Item baseBlock, String baseBlockId) {
        this.shapeless(recipeCategory, waxedBlock)
                .requires(baseBlock)
                .requires(Items.HONEYCOMB)
                .unlockedBy("has_" + baseBlockId, has(baseBlock))
                .save(output, baseBlockId + "_waxing");
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
                .unlockedBy("has_stone_dropper", this.has(ModItems.STONE_DROPPER.get()))
                .unlockedBy("has_blackstone_dropper", this.has(ModItems.BLACKSTONE_DROPPER.get()))
                .unlockedBy("has_deepslate_dropper", this.has(ModItems.DEEPSLATE_DROPPER.get()))
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
        FletchingRecipeBuilder.fletching(Ingredient.of(arrow), Ingredient.of(ingredient), result).unlockedBy(getHasName(arrow), this.has(arrow)).save(this.output, getItemName(result) + "_fletching");
    }

    protected void createWaxedBlock(Item waxedBlock, Item baseBlock, String baseBlockId) {
        createWaxedRecipe(RecipeCategory.BUILDING_BLOCKS, waxedBlock, baseBlock, baseBlockId);
    }

    protected void createWaxedPressurePlateRecipe(Item waxedBlock, Item baseBlock, String baseBlockId) {
        createWaxedRecipe(RecipeCategory.REDSTONE, waxedBlock, baseBlock, baseBlockId);
    }

    protected void createWaxedBarsRecipe(Item waxedBlock, Item baseBlock, String baseBlockId) {
        createWaxedRecipe(RecipeCategory.DECORATIONS, waxedBlock, baseBlock, baseBlockId);
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
                .define('#', ModItems.TERRACOTTA_SLAB.get())
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_slabs")
                .unlockedBy("has_terracotta_slab", this.has(ModItems.TERRACOTTA_SLAB.get()))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaStairsFromTerracottaStairsAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModItems.TERRACOTTA_STAIRS.get())
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_stairs")
                .unlockedBy("has_terracotta_stairs", this.has(ModItems.TERRACOTTA_STAIRS.get()))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaWallFromTerracottaWallAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModItems.TERRACOTTA_WALL.get())
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_walls")
                .unlockedBy("has_terracotta_wall", this.has(ModItems.TERRACOTTA_WALL.get()))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void coloredTerracottaFenceFromTerracottaFenceAndDye(ItemLike result, ItemLike dye) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                .define('#', ModItems.TERRACOTTA_FENCE.get())
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta_fences")
                .unlockedBy("has_terracotta_fence", this.has(ModItems.TERRACOTTA_FENCE.get()))
                .save(this.output, getItemName(result) + "_dyeing");
    }

    protected void copyBronzeSmithingTemplate(ItemLike template, ItemLike baseItem) {
        this.shaped(RecipeCategory.MISC, template, 2).define('#', Items.COPPER_INGOT).define('C', baseItem).define('S', template).pattern("#S#").pattern("#C#").pattern("###").unlockedBy(getHasName(template), this.has(template)).save(this.output);
    }

    protected void bronzeSmithing(Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(ingredientItem), this.tag(ModItemTags.BRONZE_TOOL_MATERIALS), category, resultItem).unlocks("has_bronze_ingot", this.has(ModItemTags.BRONZE_TOOL_MATERIALS)).save(this.output, getItemName(resultItem) + "_smithing");
    }

    protected void flameTestTorch(Item result, ItemLike nugget) {
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
                    .unlockedBy("has_" + getItemName(ingot), this.has(ingot)).save(this.output.withConditions(NeoForgeConditions.never()));

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

    private void waxedBlocks() {
        createWaxedPressurePlateRecipe(ModItems.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "exposed_medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "weathered_medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "oxidized_medium_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_IRON_BLOCK.get(), Items.IRON_BLOCK, "iron_block");
        createWaxedBlock(ModItems.WAXED_EXPOSED_IRON.get(), ModItems.EXPOSED_CUT_IRON.get(), "exposed_iron");
        createWaxedBlock(ModItems.WAXED_WEATHERED_IRON.get(), ModItems.WEATHERED_IRON.get(), "weathered_iron");
        createWaxedBlock(ModItems.WAXED_RUSTED_IRON.get(), ModItems.RUSTED_IRON.get(), "rusted_iron");

        createWaxedPressurePlateRecipe(ModItems.WAXED_IRON_DOOR.get(), Items.IRON_DOOR, "iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_IRON_DOOR.get(), ModItems.EXPOSED_IRON_DOOR.get(), "exposed_iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_IRON_DOOR.get(), ModItems.WEATHERED_IRON_DOOR.get(), "weathered_iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_RUSTED_IRON_DOOR.get(), ModItems.RUSTED_IRON_DOOR.get(), "rusted_iron_door");

        createWaxedPressurePlateRecipe(ModItems.WAXED_IRON_TRAPDOOR.get(), Items.IRON_TRAPDOOR, "iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_IRON_TRAPDOOR.get(), ModItems.EXPOSED_IRON_TRAPDOOR.get(), "exposed_iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_IRON_TRAPDOOR.get(), ModItems.WEATHERED_IRON_TRAPDOOR.get(), "weathered_iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_RUSTED_IRON_TRAPDOOR.get(), ModItems.RUSTED_IRON_TRAPDOOR.get(), "rusted_iron_trapdoor");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_BARS.get(), Items.IRON_BARS, "iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_IRON_BARS.get(), ModItems.EXPOSED_IRON_BARS.get(), "exposed_iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_IRON_BARS.get(), ModItems.WEATHERED_IRON_BARS.get(), "weathered_iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_RUSTED_IRON_BARS.get(), ModItems.RUSTED_IRON_BARS.get(), "rusted_iron_bars");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_CHAIN.get(), Items.IRON_CHAIN, "iron_chain");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_IRON_CHAIN.get(), ModItems.EXPOSED_IRON_CHAIN.get(), "exposed_iron_chain");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_IRON_CHAIN.get(), ModItems.WEATHERED_IRON_CHAIN.get(), "weathered_iron_chain");
        createWaxedBarsRecipe(ModItems.WAXED_RUSTED_IRON_CHAIN.get(), ModItems.RUSTED_IRON_CHAIN.get(), "rusted_iron_chain");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_LANTERN.get(), Items.LANTERN, "lantern");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_IRON_LANTERN.get(), ModItems.EXPOSED_IRON_LANTERN.get(), "exposed_iron_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_IRON_LANTERN.get(), ModItems.WEATHERED_IRON_LANTERN.get(), "weathered_iron_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_RUSTED_IRON_LANTERN.get(), ModItems.RUSTED_IRON_LANTERN.get(), "rusted_iron_lantern");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_SOUL_LANTERN.get(), Items.SOUL_LANTERN, "soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_IRON_SOUL_LANTERN.get(), ModItems.EXPOSED_IRON_SOUL_LANTERN.get(), "exposed_iron_soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_IRON_SOUL_LANTERN.get(), ModItems.WEATHERED_IRON_SOUL_LANTERN.get(), "weathered_iron_soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_RUSTED_IRON_SOUL_LANTERN.get(), ModItems.RUSTED_IRON_SOUL_LANTERN.get(), "rusted_iron_soul_lantern");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_FIRE_LANTERN.get(), ModItems.IRON_FIRE_LANTERN.get(), "iron_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_IRON_FIRE_LANTERN.get(), ModItems.EXPOSED_IRON_FIRE_LANTERN.get(), "exposed_iron_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_IRON_FIRE_LANTERN.get(), ModItems.WEATHERED_IRON_FIRE_LANTERN.get(), "weathered_iron_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_RUSTED_IRON_FIRE_LANTERN.get(), ModItems.RUSTED_IRON_FIRE_LANTERN.get(), "rusted_iron_fire_lantern");

        createWaxedBarsRecipe(ModItems.WAXED_COPPER_SOUL_LANTERN.get(), ModItems.COPPER_SOUL_LANTERN.get(), "copper_soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get(), ModItems.EXPOSED_COPPER_SOUL_LANTERN.get(), "exposed_copper_soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get(), ModItems.WEATHERED_COPPER_SOUL_LANTERN.get(), "weathered_copper_soul_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get(), ModItems.OXIDIZED_COPPER_SOUL_LANTERN.get(), "oxidized_copper_soul_lantern");

        createWaxedBarsRecipe(ModItems.WAXED_COPPER_FIRE_LANTERN.get(), ModItems.COPPER_FIRE_LANTERN.get(), "copper_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get(), ModItems.EXPOSED_COPPER_FIRE_LANTERN.get(), "exposed_copper_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get(), ModItems.WEATHERED_COPPER_FIRE_LANTERN.get(), "weathered_copper_fire_lantern");
        createWaxedBarsRecipe(ModItems.WAXED_OXIDIZED_COPPER_FIRE_LANTERN.get(), ModItems.OXIDIZED_COPPER_FIRE_LANTERN.get(), "oxidized_copper_fire_lantern");

        createWaxedPressurePlateRecipe(ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), Items.HEAVY_WEIGHTED_PRESSURE_PLATE, "heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "exposed_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "weathered_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "rusted_heavy_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_CUT_IRON.get(), ModItems.CUT_IRON.get(), "cut_iron");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_IRON.get(), ModItems.EXPOSED_CUT_IRON.get(), "exposed_cut_iron");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_IRON.get(), ModItems.WEATHERED_CUT_IRON.get(), "weathered_cut_iron");
        createWaxedBlock(ModItems.WAXED_RUSTED_CUT_IRON.get(), ModItems.RUSTED_CUT_IRON.get(), "rusted_cut_iron");

        createWaxedBlock(ModItems.WAXED_CUT_IRON_SLAB.get(), ModItems.CUT_IRON_SLAB.get(), "cut_iron_slab");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_IRON_SLAB.get(), ModItems.EXPOSED_CUT_IRON_SLAB.get(), "exposed_cut_iron_slab");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_IRON_SLAB.get(), ModItems.WEATHERED_CUT_IRON_SLAB.get(), "weathered_cut_iron_slab");
        createWaxedBlock(ModItems.WAXED_RUSTED_CUT_IRON_SLAB.get(), ModItems.RUSTED_CUT_IRON_SLAB.get(), "rusted_cut_iron_slab");

        createWaxedBlock(ModItems.WAXED_CUT_IRON_STAIRS.get(), ModItems.CUT_IRON_STAIRS.get(), "cut_iron_stairs");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_IRON_STAIRS.get(), ModItems.EXPOSED_CUT_IRON_STAIRS.get(), "exposed_cut_iron_stairs");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_IRON_STAIRS.get(), ModItems.WEATHERED_CUT_IRON_STAIRS.get(), "weathered_cut_iron_stairs");
        createWaxedBlock(ModItems.WAXED_RUSTED_CUT_IRON_STAIRS.get(), ModItems.RUSTED_CUT_IRON_STAIRS.get(), "rusted_cut_iron_stairs");

        createWaxedBlock(ModItems.WAXED_ZINC_BLOCK.get(), ModItems.ZINC_BLOCK.get(), "zinc_block");
        createWaxedBlock(ModItems.WAXED_EXPOSED_ZINC.get(), ModItems.EXPOSED_ZINC.get(), "exposed_zinc");
        createWaxedBlock(ModItems.WAXED_WEATHERED_ZINC.get(), ModItems.WEATHERED_ZINC.get(), "weathered_zinc");
        createWaxedBlock(ModItems.WAXED_CORRODED_ZINC.get(), ModItems.CORRODED_ZINC.get(), "corroded_zinc");

        createWaxedPressurePlateRecipe(ModItems.WAXED_ZINC_DOOR.get(), ModItems.ZINC_DOOR.get(), "zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_ZINC_DOOR.get(), ModItems.EXPOSED_ZINC_DOOR.get(), "exposed_zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_ZINC_DOOR.get(), ModItems.WEATHERED_ZINC_DOOR.get(), "weathered_zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_CORRODED_ZINC_DOOR.get(), ModItems.CORRODED_ZINC_DOOR.get(), "corroded_zinc_door");

        createWaxedPressurePlateRecipe(ModItems.WAXED_ZINC_TRAPDOOR.get(), ModItems.ZINC_TRAPDOOR.get(), "zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_ZINC_TRAPDOOR.get(), ModItems.EXPOSED_ZINC_TRAPDOOR.get(), "exposed_zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_ZINC_TRAPDOOR.get(), ModItems.WEATHERED_ZINC_TRAPDOOR.get(), "weathered_zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_CORRODED_ZINC_TRAPDOOR.get(), ModItems.CORRODED_ZINC_TRAPDOOR.get(), "corroded_zinc_trapdoor");

        createWaxedPressurePlateRecipe(ModItems.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "exposed_barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "weathered_barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "corroded_barely_heavy_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_CUT_ZINC.get(), ModItems.CUT_ZINC.get(), "cut_zinc");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_ZINC.get(), ModItems.EXPOSED_CUT_ZINC.get(), "exposed_cut_zinc");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_ZINC.get(), ModItems.WEATHERED_CUT_ZINC.get(), "weathered_cut_zinc");
        createWaxedBlock(ModItems.WAXED_CORRODED_CUT_ZINC.get(), ModItems.CORRODED_CUT_ZINC.get(), "corroded_cut_zinc");

        createWaxedBlock(ModItems.WAXED_CUT_ZINC_SLAB.get(), ModItems.CUT_ZINC_SLAB.get(), "cut_zinc_slab");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_ZINC_SLAB.get(), ModItems.EXPOSED_CUT_ZINC_SLAB.get(), "exposed_cut_zinc_slab");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_ZINC_SLAB.get(), ModItems.WEATHERED_CUT_ZINC_SLAB.get(), "weathered_cut_zinc_slab");
        createWaxedBlock(ModItems.WAXED_CORRODED_CUT_ZINC_SLAB.get(), ModItems.CORRODED_CUT_ZINC_SLAB.get(), "corroded_cut_zinc_slab");

        createWaxedBlock(ModItems.WAXED_CUT_ZINC_STAIRS.get(), ModItems.CUT_ZINC_STAIRS.get(), "cut_zinc_stairs");
        createWaxedBlock(ModItems.WAXED_EXPOSED_CUT_ZINC_STAIRS.get(), ModItems.EXPOSED_CUT_ZINC_STAIRS.get(), "exposed_cut_zinc_stairs");
        createWaxedBlock(ModItems.WAXED_WEATHERED_CUT_ZINC_STAIRS.get(), ModItems.WEATHERED_CUT_ZINC_STAIRS.get(), "weathered_cut_zinc_stairs");
        createWaxedBlock(ModItems.WAXED_CORRODED_CUT_ZINC_STAIRS.get(), ModItems.CORRODED_CUT_ZINC_STAIRS.get(), "corroded_cut_zinc_stairs");

        createWaxedBarsRecipe(ModItems.WAXED_ZINC_CHAIN.get(), ModItems.ZINC_CHAIN.get(), "zinc_chain");
        createWaxedBarsRecipe(ModItems.WAXED_EXPOSED_ZINC_CHAIN.get(), ModItems.EXPOSED_ZINC_CHAIN.get(), "exposed_zinc_chain");
        createWaxedBarsRecipe(ModItems.WAXED_WEATHERED_ZINC_CHAIN.get(), ModItems.WEATHERED_ZINC_CHAIN.get(), "weathered_zinc_chain");
        createWaxedBarsRecipe(ModItems.WAXED_CORRODED_ZINC_CHAIN.get(), ModItems.CORRODED_ZINC_CHAIN.get(), "corroded_zinc_chain");

        createWaxedBlock(ModItems.WAXED_IRON_GRATE.get(), ModItems.IRON_GRATE.get(), "iron_grate");
        createWaxedBlock(ModItems.WAXED_EXPOSED_IRON_GRATE.get(), ModItems.EXPOSED_IRON_GRATE.get(), "exposed_iron_grate");
        createWaxedBlock(ModItems.WAXED_WEATHERED_IRON_GRATE.get(), ModItems.WEATHERED_IRON_GRATE.get(), "weathered_iron_grate");
        createWaxedBlock(ModItems.WAXED_RUSTED_IRON_GRATE.get(), ModItems.RUSTED_IRON_GRATE.get(), "rusted_iron_grate");

        createWaxedPressurePlateRecipe(ModItems.WAXED_IRON_BULB.get(), ModItems.IRON_BULB.get(), "iron_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_IRON_BULB.get(), ModItems.EXPOSED_IRON_BULB.get(), "exposed_iron_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_IRON_BULB.get(), ModItems.WEATHERED_IRON_BULB.get(), "weathered_iron_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_RUSTED_IRON_BULB.get(), ModItems.RUSTED_IRON_BULB.get(), "rusted_iron_bulb");

        createWaxedBlock(ModItems.WAXED_ZINC_GRATE.get(), ModItems.ZINC_GRATE.get(), "zinc_grate");
        createWaxedBlock(ModItems.WAXED_EXPOSED_ZINC_GRATE.get(), ModItems.EXPOSED_ZINC_GRATE.get(), "exposed_zinc_grate");
        createWaxedBlock(ModItems.WAXED_WEATHERED_ZINC_GRATE.get(), ModItems.WEATHERED_ZINC_GRATE.get(), "weathered_zinc_grate");
        createWaxedBlock(ModItems.WAXED_CORRODED_ZINC_GRATE.get(), ModItems.CORRODED_ZINC_GRATE.get(), "corroded_zinc_grate");

        createWaxedPressurePlateRecipe(ModItems.WAXED_ZINC_BULB.get(), ModItems.ZINC_BULB.get(), "zinc_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_ZINC_BULB.get(), ModItems.EXPOSED_ZINC_BULB.get(), "exposed_zinc_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_ZINC_BULB.get(), ModItems.WEATHERED_ZINC_BULB.get(), "weathered_zinc_bulb");
        createWaxedPressurePlateRecipe(ModItems.WAXED_CORRODED_ZINC_BULB.get(), ModItems.CORRODED_ZINC_BULB.get(), "corroded_zinc_bulb");


    }

    private void stoneCuttingRecipes() {
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_WALL.get(), Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_WALL.get(), Items.POLISHED_GRANITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_WALL.get(), Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_WALL.get(), Items.POLISHED_DIORITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_WALL.get(), Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_WALL.get(), Items.POLISHED_ANDESITE);

        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PRISMARINE_BRICK_WALL.get(), Items.PRISMARINE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DARK_PRISMARINE_WALL.get(), Items.DARK_PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_WALL.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_SANDSTONE_WALL.get(), Items.SMOOTH_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_RED_SANDSTONE_WALL.get(), Items.SMOOTH_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.QUARTZ_WALL.get(), Items.QUARTZ_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_QUARTZ_WALL.get(), Items.SMOOTH_QUARTZ);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPUR_WALL.get(), Items.PURPUR_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_STONE_STAIRS.get(), Items.SMOOTH_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_STONE_WALL.get(), Items.SMOOTH_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SANDSTONE_STAIRS.get(), Items.CUT_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_SANDSTONE_WALL.get(), Items.CUT_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SANDSTONE_STAIRS.get(), Items.SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_SANDSTONE_WALL.get(), Items.SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_RED_SANDSTONE_STAIRS.get(), Items.CUT_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_RED_SANDSTONE_WALL.get(), Items.CUT_RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_RED_SANDSTONE_STAIRS.get(), Items.RED_SANDSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_RED_SANDSTONE_WALL.get(), Items.RED_SANDSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_STONE_BRICK_SLAB.get(), Items.CRACKED_STONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_STONE_BRICK_STAIRS.get(), Items.CRACKED_STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_STONE_BRICK_WALL.get(), Items.CRACKED_STONE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_SLAB.get(), Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_STAIRS.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BASALT_WALL.get(), Items.BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_BASALT_SLAB.get(), Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_BASALT_STAIRS.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_BASALT_WALL.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_BASALT_SLAB.get(), Items.POLISHED_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_BASALT_STAIRS.get(), Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_BASALT_WALL.get(), Items.POLISHED_BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_BASALT_SLAB.get(), Items.SMOOTH_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_BASALT_STAIRS.get(), Items.SMOOTH_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_BASALT_WALL.get(), Items.SMOOTH_BASALT);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DEEPSLATE_SLAB.get(), Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DEEPSLATE_STAIRS.get(), Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DEEPSLATE_WALL.get(), Items.DEEPSLATE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_DEEPSLATE_BRICK_SLAB.get(), Items.CRACKED_DEEPSLATE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_DEEPSLATE_BRICK_STAIRS.get(), Items.CRACKED_DEEPSLATE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_DEEPSLATE_BRICK_WALL.get(), Items.CRACKED_DEEPSLATE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_DEEPSLATE_TILE_SLAB.get(), Items.CRACKED_DEEPSLATE_TILES, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_DEEPSLATE_TILE_STAIRS.get(), Items.CRACKED_DEEPSLATE_TILES);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_DEEPSLATE_TILE_WALL.get(), Items.CRACKED_DEEPSLATE_TILES);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_NETHER_BRICK_SLAB.get(), Items.CRACKED_NETHER_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_NETHER_BRICK_STAIRS.get(), Items.CRACKED_NETHER_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_NETHER_BRICK_WALL.get(), Items.CRACKED_NETHER_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(), Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get(), Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_SLAB.get(), Items.NETHERRACK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_STAIRS.get(), Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.NETHERRACK_WALL.get(), Items.NETHERRACK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_SLAB.get(), Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_STAIRS.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CALCITE_WALL.get(), Items.CALCITE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_SLAB.get(), Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_STAIRS.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_CALCITE_WALL.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_SLAB.get(), ModItems.POLISHED_CALCITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_CALCITE_STAIRS.get(), ModItems.POLISHED_CALCITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_CALCITE_WALL.get(), ModItems.POLISHED_CALCITE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_SLAB.get(), Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_STAIRS.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DRIPSTONE_WALL.get(), Items.DRIPSTONE_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DRIPSTONE_SLAB.get(), Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DRIPSTONE_STAIRS.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DRIPSTONE_WALL.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DRIPSTONE.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DRIPSTONE_SLAB.get(), ModItems.POLISHED_DRIPSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DRIPSTONE_STAIRS.get(), ModItems.POLISHED_DRIPSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DRIPSTONE_WALL.get(), ModItems.POLISHED_DRIPSTONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_SLAB.get(), Items.GRANITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_STAIRS.get(), Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_BRICK_WALL.get(), Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICKS.get(), Items.GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_SLAB.get(), Items.POLISHED_GRANITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_STAIRS.get(), Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_BRICK_WALL.get(), Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICKS.get(), Items.POLISHED_GRANITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_SLAB.get(), ModItems.POLISHED_GRANITE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GRANITE_BRICK_STAIRS.get(), ModItems.POLISHED_GRANITE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GRANITE_BRICK_WALL.get(), ModItems.POLISHED_GRANITE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_SLAB.get(), Items.DIORITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_STAIRS.get(), Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_BRICK_WALL.get(), Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICKS.get(), Items.DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_SLAB.get(), Items.POLISHED_DIORITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_STAIRS.get(), Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_BRICK_WALL.get(), Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICKS.get(), Items.POLISHED_DIORITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_SLAB.get(), ModItems.POLISHED_DIORITE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_DIORITE_BRICK_STAIRS.get(), ModItems.POLISHED_DIORITE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_DIORITE_BRICK_WALL.get(), ModItems.POLISHED_DIORITE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_SLAB.get(), Items.ANDESITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_STAIRS.get(), Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_BRICK_WALL.get(), Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICKS.get(), Items.ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_SLAB.get(), Items.POLISHED_ANDESITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_STAIRS.get(), Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_BRICK_WALL.get(), Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICKS.get(), Items.POLISHED_ANDESITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_SLAB.get(), ModItems.POLISHED_ANDESITE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_ANDESITE_BRICK_STAIRS.get(), ModItems.POLISHED_ANDESITE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_ANDESITE_BRICK_WALL.get(), ModItems.POLISHED_ANDESITE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_SLAB.get(), Items.CALCITE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_STAIRS.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CALCITE_BRICK_WALL.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICKS.get(), Items.CALCITE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_SLAB.get(), ModItems.POLISHED_CALCITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_STAIRS.get(), ModItems.POLISHED_CALCITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CALCITE_BRICK_WALL.get(), ModItems.POLISHED_CALCITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICKS.get(), ModItems.POLISHED_CALCITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_SLAB.get(), ModItems.CALCITE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CALCITE_BRICK_STAIRS.get(), ModItems.CALCITE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CALCITE_BRICK_WALL.get(), ModItems.CALCITE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_SLAB.get(), Items.DRIPSTONE_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_STAIRS.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DRIPSTONE_BRICK_WALL.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICKS.get(), Items.DRIPSTONE_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_SLAB.get(), ModItems.POLISHED_DRIPSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_STAIRS.get(), ModItems.POLISHED_DRIPSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DRIPSTONE_BRICK_WALL.get(), ModItems.POLISHED_DRIPSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICKS.get(), ModItems.POLISHED_DRIPSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_SLAB.get(), ModItems.DRIPSTONE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIPSTONE_BRICK_STAIRS.get(), ModItems.DRIPSTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DRIPSTONE_BRICK_WALL.get(), ModItems.DRIPSTONE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_SLAB.get(), Items.BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_STAIRS.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BASALT_BRICK_WALL.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICKS.get(), Items.BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_SLAB.get(), Items.POLISHED_BASALT, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_STAIRS.get(), Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BASALT_BRICK_WALL.get(), Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICKS.get(), Items.POLISHED_BASALT);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_SLAB.get(), ModItems.BASALT_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BASALT_BRICK_STAIRS.get(), ModItems.BASALT_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BASALT_BRICK_WALL.get(), ModItems.BASALT_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.END_STONE_SLAB.get(), Items.END_STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.END_STONE_STAIRS.get(), Items.END_STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.END_STONE_WALL.get(), Items.END_STONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.QUARTZ_BRICK_SLAB.get(), Items.QUARTZ_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.QUARTZ_BRICK_STAIRS.get(), Items.QUARTZ_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.QUARTZ_BRICK_WALL.get(), Items.QUARTZ_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.QUARTZ_BRICK_SLAB.get(), Items.QUARTZ_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.QUARTZ_BRICK_STAIRS.get(), Items.QUARTZ_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.QUARTZ_BRICK_WALL.get(), Items.QUARTZ_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_MUD_SLAB.get(), Items.PACKED_MUD, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_MUD_STAIRS.get(), Items.PACKED_MUD);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PACKED_MUD_WALL.get(), Items.PACKED_MUD);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RESIN_SLAB.get(), Items.RESIN_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RESIN_STAIRS.get(), Items.RESIN_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RESIN_WALL.get(), Items.RESIN_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_IRON.get(), Items.IRON_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_IRON_STAIRS.get(), Items.IRON_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_IRON_SLAB.get(), Items.IRON_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_IRON_STAIRS.get(), ModItems.CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_IRON_SLAB.get(), ModItems.CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_IRON.get(), ModItems.EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_IRON_STAIRS.get(), ModItems.EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_IRON_SLAB.get(), ModItems.EXPOSED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_IRON_STAIRS.get(), ModItems.EXPOSED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_IRON_SLAB.get(), ModItems.EXPOSED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_IRON.get(), ModItems.WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_IRON_STAIRS.get(), ModItems.WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_IRON_SLAB.get(), ModItems.WEATHERED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_IRON_STAIRS.get(), ModItems.WEATHERED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_IRON_SLAB.get(), ModItems.WEATHERED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_CUT_IRON.get(), ModItems.RUSTED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_CUT_IRON_STAIRS.get(), ModItems.RUSTED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_CUT_IRON_SLAB.get(), ModItems.RUSTED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_CUT_IRON_STAIRS.get(), ModItems.RUSTED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_CUT_IRON_SLAB.get(), ModItems.RUSTED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_IRON.get(), ModItems.WAXED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_IRON_STAIRS.get(), ModItems.WAXED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_IRON_SLAB.get(), ModItems.WAXED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_IRON_STAIRS.get(), ModItems.WAXED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_IRON_SLAB.get(), ModItems.WAXED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_IRON.get(), ModItems.WAXED_EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_IRON_STAIRS.get(), ModItems.WAXED_EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_IRON_SLAB.get(), ModItems.WAXED_EXPOSED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_IRON_STAIRS.get(), ModItems.WAXED_EXPOSED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_IRON_SLAB.get(), ModItems.WAXED_EXPOSED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_IRON.get(), ModItems.WAXED_WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_IRON_STAIRS.get(), ModItems.WAXED_WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_IRON_SLAB.get(), ModItems.WAXED_WEATHERED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_IRON_STAIRS.get(), ModItems.WAXED_WEATHERED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_IRON_SLAB.get(), ModItems.WAXED_WEATHERED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_CUT_IRON.get(), ModItems.WAXED_RUSTED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_CUT_IRON_STAIRS.get(), ModItems.WAXED_RUSTED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_CUT_IRON_SLAB.get(), ModItems.WAXED_RUSTED_IRON.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_CUT_IRON_STAIRS.get(), ModItems.WAXED_RUSTED_CUT_IRON.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_CUT_IRON_SLAB.get(), ModItems.WAXED_RUSTED_CUT_IRON.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_ZINC.get(), ModItems.ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_ZINC_STAIRS.get(), ModItems.ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_ZINC_SLAB.get(), ModItems.ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_ZINC_STAIRS.get(), ModItems.CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_ZINC_SLAB.get(), ModItems.CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_ZINC.get(), ModItems.EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_ZINC_STAIRS.get(), ModItems.EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_ZINC_SLAB.get(), ModItems.EXPOSED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_ZINC_STAIRS.get(), ModItems.EXPOSED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_CUT_ZINC_SLAB.get(), ModItems.EXPOSED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_ZINC.get(), ModItems.WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_ZINC_STAIRS.get(), ModItems.WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_ZINC_SLAB.get(), ModItems.WEATHERED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_ZINC_STAIRS.get(), ModItems.WEATHERED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_CUT_ZINC_SLAB.get(), ModItems.WEATHERED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_CUT_ZINC.get(), ModItems.CORRODED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_CUT_ZINC_STAIRS.get(), ModItems.CORRODED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_CUT_ZINC_SLAB.get(), ModItems.CORRODED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_CUT_ZINC_STAIRS.get(), ModItems.CORRODED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_CUT_ZINC_SLAB.get(), ModItems.CORRODED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_ZINC.get(), ModItems.WAXED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_ZINC_SLAB.get(), ModItems.WAXED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CUT_ZINC_SLAB.get(), ModItems.WAXED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_ZINC.get(), ModItems.WAXED_EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_ZINC_SLAB.get(), ModItems.WAXED_EXPOSED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_EXPOSED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_CUT_ZINC_SLAB.get(), ModItems.WAXED_EXPOSED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_ZINC.get(), ModItems.WAXED_WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_ZINC_SLAB.get(), ModItems.WAXED_WEATHERED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_WEATHERED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_CUT_ZINC_SLAB.get(), ModItems.WAXED_WEATHERED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_CUT_ZINC.get(), ModItems.WAXED_CORRODED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_CORRODED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_CUT_ZINC_SLAB.get(), ModItems.WAXED_CORRODED_ZINC.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_CUT_ZINC_STAIRS.get(), ModItems.WAXED_CORRODED_CUT_ZINC.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_CUT_ZINC_SLAB.get(), ModItems.WAXED_CORRODED_CUT_ZINC.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_GOLD.get(), Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_GOLD_STAIRS.get(), Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_GOLD_SLAB.get(), Items.GOLD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_GOLD_STAIRS.get(), ModItems.CUT_GOLD.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_GOLD_SLAB.get(), ModItems.CUT_GOLD.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_DIAMOND.get(), Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_DIAMOND_STAIRS.get(), Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_DIAMOND_SLAB.get(), Items.DIAMOND_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_DIAMOND_STAIRS.get(), ModItems.CUT_DIAMOND.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_DIAMOND_SLAB.get(), ModItems.CUT_DIAMOND.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_EMERALD.get(), Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_EMERALD_STAIRS.get(), Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_EMERALD_SLAB.get(), Items.EMERALD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_EMERALD_STAIRS.get(), ModItems.CUT_EMERALD.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_EMERALD_SLAB.get(), ModItems.CUT_EMERALD.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_NETHERITE.get(), Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_NETHERITE_STAIRS.get(), Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_NETHERITE_SLAB.get(), Items.NETHERITE_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_NETHERITE_STAIRS.get(), ModItems.CUT_NETHERITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_NETHERITE_SLAB.get(), ModItems.CUT_NETHERITE.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_SANDSTONE_SLAB.get(), ModItems.SOUL_SANDSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_SANDSTONE_STAIRS.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SOUL_SANDSTONE_WALL.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_SOUL_SANDSTONE.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SOUL_SANDSTONE.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SOUL_SANDSTONE_SLAB.get(), ModItems.SOUL_SANDSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SOUL_SANDSTONE_STAIRS.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_SOUL_SANDSTONE_WALL.get(), ModItems.SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SOUL_SANDSTONE_SLAB.get(), ModItems.CUT_SOUL_SANDSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SOUL_SANDSTONE_STAIRS.get(), ModItems.CUT_SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CUT_SOUL_SANDSTONE_WALL.get(), ModItems.CUT_SOUL_SANDSTONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_SOUL_SANDSTONE_SLAB.get(), ModItems.SMOOTH_SOUL_SANDSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_SOUL_SANDSTONE_STAIRS.get(), ModItems.SMOOTH_SOUL_SANDSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_SOUL_SANDSTONE_WALL.get(), ModItems.SMOOTH_SOUL_SANDSTONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_SLAB.get(), ModItems.ELDER_PRISMARINE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_STAIRS.get(), ModItems.ELDER_PRISMARINE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ELDER_PRISMARINE_WALL.get(), ModItems.ELDER_PRISMARINE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_BRICK_SLAB.get(), ModItems.ELDER_PRISMARINE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_BRICK_STAIRS.get(), ModItems.ELDER_PRISMARINE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ELDER_PRISMARINE_BRICK_WALL.get(), ModItems.ELDER_PRISMARINE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_ELDER_PRISMARINE_SLAB.get(), ModItems.DARK_ELDER_PRISMARINE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_ELDER_PRISMARINE_STAIRS.get(), ModItems.DARK_ELDER_PRISMARINE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.DARK_ELDER_PRISMARINE_WALL.get(), ModItems.DARK_ELDER_PRISMARINE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SILVER.get(), ModItems.SILVER_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SILVER_STAIRS.get(), ModItems.SILVER_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SILVER_SLAB.get(), ModItems.SILVER_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SILVER_STAIRS.get(), ModItems.CUT_SILVER.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_SILVER_SLAB.get(), ModItems.CUT_SILVER.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN.get(), ModItems.TIN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_STAIRS.get(), ModItems.TIN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_SLAB.get(), ModItems.TIN_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_STAIRS.get(), ModItems.CUT_TIN.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_SLAB.get(), ModItems.CUT_TIN.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TUNGSTEN.get(), ModItems.TUNGSTEN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TUNGSTEN_STAIRS.get(), ModItems.TUNGSTEN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TUNGSTEN_SLAB.get(), ModItems.TUNGSTEN_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TUNGSTEN_STAIRS.get(), ModItems.CUT_TUNGSTEN.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TUNGSTEN_SLAB.get(), ModItems.CUT_TUNGSTEN.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_PLATINUM.get(), ModItems.PLATINUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_PLATINUM_STAIRS.get(), ModItems.PLATINUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_PLATINUM_SLAB.get(), ModItems.PLATINUM_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_PLATINUM_STAIRS.get(), ModItems.CUT_PLATINUM.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_PLATINUM_SLAB.get(), ModItems.CUT_PLATINUM.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_LEAD.get(), ModItems.LEAD_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_LEAD_STAIRS.get(), ModItems.LEAD_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_LEAD_SLAB.get(), ModItems.LEAD_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_LEAD_STAIRS.get(), ModItems.CUT_LEAD.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_LEAD_SLAB.get(), ModItems.CUT_LEAD.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_URANIUM.get(), ModItems.URANIUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_URANIUM_STAIRS.get(), ModItems.URANIUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_URANIUM_SLAB.get(), ModItems.URANIUM_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_URANIUM_STAIRS.get(), ModItems.CUT_URANIUM.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_URANIUM_SLAB.get(), ModItems.CUT_URANIUM.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE.get(), ModItems.BRONZE_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_STAIRS.get(), ModItems.BRONZE_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_SLAB.get(), ModItems.BRONZE_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_STAIRS.get(), ModItems.CUT_BRONZE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_SLAB.get(), ModItems.CUT_BRONZE.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRASS.get(), ModItems.BRASS_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRASS_STAIRS.get(), ModItems.BRASS_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRASS_SLAB.get(), ModItems.BRASS_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRASS_STAIRS.get(), ModItems.CUT_BRASS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRASS_SLAB.get(), ModItems.CUT_BRASS.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_STEEL.get(), ModItems.STEEL_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_STEEL_STAIRS.get(), ModItems.STEEL_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_STEEL_SLAB.get(), ModItems.STEEL_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_STEEL_STAIRS.get(), ModItems.CUT_STEEL.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_STEEL_SLAB.get(), ModItems.CUT_STEEL.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_SLAB.get(), Items.OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_STAIRS.get(), Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.OBSIDIAN_WALL.get(), Items.OBSIDIAN);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_SLAB.get(), Items.CRYING_OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_STAIRS.get(), Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRYING_OBSIDIAN_WALL.get(), Items.CRYING_OBSIDIAN);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_SLAB.get(), Items.ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_STAIRS.get(), Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ICE_WALL.get(), Items.ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_SLAB.get(), Items.PACKED_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_STAIRS.get(), Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PACKED_ICE_WALL.get(), Items.PACKED_ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_SLAB.get(), Items.BLUE_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_STAIRS.get(), Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_ICE_WALL.get(), Items.BLUE_ICE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_SLAB.get(), Items.TERRACOTTA, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_STAIRS.get(), Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.TERRACOTTA_WALL.get(), Items.TERRACOTTA);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_SLAB.get(), Items.SCULK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_STAIRS.get(), Items.SCULK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SCULK_WALL.get(), Items.SCULK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_SLAB.get(), Items.COAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_STAIRS.get(), Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.COAL_WALL.get(), Items.COAL_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_SLAB.get(), Items.LAPIS_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_STAIRS.get(), Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LAPIS_WALL.get(), Items.LAPIS_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_SLAB.get(), Items.SNOW_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_STAIRS.get(), Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SNOW_WALL.get(), Items.SNOW_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_SLAB.get(), ModItems.CHARCOAL_BLOCK.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_STAIRS.get(), ModItems.CHARCOAL_BLOCK.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CHARCOAL_WALL.get(), ModItems.CHARCOAL_BLOCK.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.white(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.white());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.white());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.orange(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.orange());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.orange());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.magenta(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.magenta());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.magenta());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.lightBlue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.lightBlue());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.yellow(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.yellow());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.yellow());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.lime(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.lime());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.lime());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.pink(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.pink());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.pink());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.gray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.gray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.gray());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.lightGray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.lightGray());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.cyan(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.cyan());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.cyan());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.purple(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.purple());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.purple());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.blue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.blue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.blue());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.brown(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.brown());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.brown());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.green(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.green());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.green());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.red(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.red());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.red());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_SLAB.get(), Items.DYED_TERRACOTTA.black(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_STAIRS.get(), Items.DYED_TERRACOTTA.black());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_TERRACOTTA_WALL.get(), Items.DYED_TERRACOTTA.black());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_SLAB.get(), Items.CONCRETE.white(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_STAIRS.get(), Items.CONCRETE.white());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_CONCRETE_WALL.get(), Items.CONCRETE.white());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_SLAB.get(), Items.CONCRETE.orange(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_STAIRS.get(), Items.CONCRETE.orange());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_CONCRETE_WALL.get(), Items.CONCRETE.orange());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_SLAB.get(), Items.CONCRETE.magenta(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_STAIRS.get(), Items.CONCRETE.magenta());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_CONCRETE_WALL.get(), Items.CONCRETE.magenta());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_SLAB.get(), Items.CONCRETE.lightBlue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_STAIRS.get(), Items.CONCRETE.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_CONCRETE_WALL.get(), Items.CONCRETE.lightBlue());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_SLAB.get(), Items.CONCRETE.yellow(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_STAIRS.get(), Items.CONCRETE.yellow());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_CONCRETE_WALL.get(), Items.CONCRETE.yellow());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_SLAB.get(), Items.CONCRETE.lime(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_STAIRS.get(), Items.CONCRETE.lime());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_CONCRETE_WALL.get(), Items.CONCRETE.lime());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_SLAB.get(), Items.CONCRETE.pink(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_STAIRS.get(), Items.CONCRETE.pink());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_CONCRETE_WALL.get(), Items.CONCRETE.pink());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_SLAB.get(), Items.CONCRETE.gray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_STAIRS.get(), Items.CONCRETE.gray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_CONCRETE_WALL.get(), Items.CONCRETE.gray());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_SLAB.get(), Items.CONCRETE.lightGray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_STAIRS.get(), Items.CONCRETE.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_CONCRETE_WALL.get(), Items.CONCRETE.lightGray());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_SLAB.get(), Items.CONCRETE.cyan(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_STAIRS.get(), Items.CONCRETE.cyan());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_CONCRETE_WALL.get(), Items.CONCRETE.cyan());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_SLAB.get(), Items.CONCRETE.purple(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_STAIRS.get(), Items.CONCRETE.purple());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_CONCRETE_WALL.get(), Items.CONCRETE.purple());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_SLAB.get(), Items.CONCRETE.blue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_STAIRS.get(), Items.CONCRETE.blue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_CONCRETE_WALL.get(), Items.CONCRETE.blue());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_SLAB.get(), Items.CONCRETE.brown(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_STAIRS.get(), Items.CONCRETE.brown());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_CONCRETE_WALL.get(), Items.CONCRETE.brown());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_SLAB.get(), Items.CONCRETE.green(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_STAIRS.get(), Items.CONCRETE.green());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_CONCRETE_WALL.get(), Items.CONCRETE.green());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_SLAB.get(), Items.CONCRETE.red(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_STAIRS.get(), Items.CONCRETE.red());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_CONCRETE_WALL.get(), Items.CONCRETE.red());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_SLAB.get(), Items.CONCRETE.black(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_STAIRS.get(), Items.CONCRETE.black());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_CONCRETE_WALL.get(), Items.CONCRETE.black());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILES.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_SLAB.get(), Items.STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_STAIRS.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_TILE_WALL.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILES.get(), Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_SLAB.get(), Items.STONE_BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_STAIRS.get(), Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_TILE_WALL.get(), Items.STONE_BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_SLAB.get(), ModItems.STONE_TILES.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_STAIRS.get(), ModItems.STONE_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_TILE_WALL.get(), ModItems.STONE_TILES.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_STONE_TILE_SLAB.get(), ModItems.MOSSY_STONE_TILES.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MOSSY_STONE_TILE_STAIRS.get(), ModItems.MOSSY_STONE_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MOSSY_STONE_TILE_WALL.get(), ModItems.MOSSY_STONE_TILES.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_STONE_TILE_SLAB.get(), ModItems.CRACKED_STONE_TILES.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRACKED_STONE_TILE_STAIRS.get(), ModItems.CRACKED_STONE_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRACKED_STONE_TILE_WALL.get(), ModItems.CRACKED_STONE_TILES.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_BRICKS.get(), Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_BRICK_SLAB.get(), Items.OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_BRICK_STAIRS.get(), Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.OBSIDIAN_BRICK_WALL.get(), Items.OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_BRICK_SLAB.get(), ModItems.OBSIDIAN_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_BRICK_STAIRS.get(), ModItems.OBSIDIAN_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.OBSIDIAN_BRICK_WALL.get(), ModItems.OBSIDIAN_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_BRICKS.get(), Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_BRICK_SLAB.get(), Items.CRYING_OBSIDIAN, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_BRICK_STAIRS.get(), Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRYING_OBSIDIAN_BRICK_WALL.get(), Items.CRYING_OBSIDIAN);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_BRICK_SLAB.get(), ModItems.CRYING_OBSIDIAN_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYING_OBSIDIAN_BRICK_STAIRS.get(), ModItems.CRYING_OBSIDIAN_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CRYING_OBSIDIAN_BRICK_WALL.get(), ModItems.CRYING_OBSIDIAN_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_BRICKS.get(), Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_BRICK_SLAB.get(), Items.COAL_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_BRICK_STAIRS.get(), Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.COAL_BRICK_WALL.get(), Items.COAL_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_BRICK_SLAB.get(), ModItems.COAL_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.COAL_BRICK_STAIRS.get(), ModItems.COAL_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.COAL_BRICK_WALL.get(), ModItems.COAL_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BRICKS.get(), ModItems.CHARCOAL_BLOCK.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BRICK_SLAB.get(), ModItems.CHARCOAL_BLOCK.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BRICK_STAIRS.get(), ModItems.CHARCOAL_BLOCK.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CHARCOAL_BRICK_WALL.get(), ModItems.CHARCOAL_BLOCK.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BRICK_SLAB.get(), ModItems.CHARCOAL_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BRICK_STAIRS.get(), ModItems.CHARCOAL_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CHARCOAL_BRICK_WALL.get(), ModItems.CHARCOAL_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_BRICKS.get(), Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_BRICK_SLAB.get(), Items.LAPIS_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_BRICK_STAIRS.get(), Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LAPIS_BRICK_WALL.get(), Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_BRICK_SLAB.get(), ModItems.LAPIS_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_BRICK_STAIRS.get(), ModItems.LAPIS_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LAPIS_BRICK_WALL.get(), ModItems.LAPIS_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_LAPIS_SLAB.get(), ModItems.SMOOTH_LAPIS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_LAPIS_STAIRS.get(), ModItems.SMOOTH_LAPIS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_LAPIS_WALL.get(), ModItems.SMOOTH_LAPIS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICKS.get(), Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICK_SLAB.get(), Items.SNOW_BLOCK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICK_STAIRS.get(), Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SNOW_BRICK_WALL.get(), Items.SNOW_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICK_SLAB.get(), ModItems.SNOW_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SNOW_BRICK_STAIRS.get(), ModItems.SNOW_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SNOW_BRICK_WALL.get(), ModItems.SNOW_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_BRICKS.get(), Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_BRICK_SLAB.get(), Items.ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_BRICK_STAIRS.get(), Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ICE_BRICK_WALL.get(), Items.ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_BRICK_SLAB.get(), ModItems.ICE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ICE_BRICK_STAIRS.get(), ModItems.ICE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ICE_BRICK_WALL.get(), ModItems.ICE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICKS.get(), Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_SLAB.get(), Items.PACKED_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_STAIRS.get(), Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PACKED_ICE_BRICK_WALL.get(), Items.PACKED_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_SLAB.get(), ModItems.PACKED_ICE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PACKED_ICE_BRICK_STAIRS.get(), ModItems.PACKED_ICE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PACKED_ICE_BRICK_WALL.get(), ModItems.PACKED_ICE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_BRICKS.get(), Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_BRICK_SLAB.get(), Items.BLUE_ICE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_BRICK_STAIRS.get(), Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_ICE_BRICK_WALL.get(), Items.BLUE_ICE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_BRICK_SLAB.get(), ModItems.BLUE_ICE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_ICE_BRICK_STAIRS.get(), ModItems.BLUE_ICE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_ICE_BRICK_WALL.get(), ModItems.BLUE_ICE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_BRICK_SLAB.get(), ModItems.SCULK_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SCULK_BRICK_STAIRS.get(), ModItems.SCULK_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SCULK_BRICK_WALL.get(), ModItems.SCULK_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_SCULK_BRICKS.get(), ModItems.SCULK_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_AMETHYST.get(), Items.AMETHYST_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_AMETHYST_STAIRS.get(), Items.AMETHYST_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_AMETHYST_SLAB.get(), Items.AMETHYST_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_AMETHYST_STAIRS.get(), ModItems.CUT_AMETHYST.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_AMETHYST_SLAB.get(), ModItems.CUT_AMETHYST.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_SLAB.get(), ModItems.GABBRO.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_STAIRS.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GABBRO_WALL.get(), ModItems.GABBRO.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GABBRO_SLAB.get(), ModItems.GABBRO.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GABBRO_STAIRS.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GABBRO_WALL.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GABBRO.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GABBRO_SLAB.get(), ModItems.POLISHED_GABBRO.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_GABBRO_STAIRS.get(), ModItems.POLISHED_GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_GABBRO_WALL.get(), ModItems.POLISHED_GABBRO.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_SLAB.get(), ModItems.GABBRO.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_STAIRS.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GABBRO_BRICK_WALL.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICKS.get(), ModItems.GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_SLAB.get(), ModItems.POLISHED_GABBRO.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_STAIRS.get(), ModItems.POLISHED_GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GABBRO_BRICK_WALL.get(), ModItems.POLISHED_GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICKS.get(), ModItems.POLISHED_GABBRO.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_SLAB.get(), ModItems.GABBRO_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GABBRO_BRICK_STAIRS.get(), ModItems.GABBRO_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GABBRO_BRICK_WALL.get(), ModItems.GABBRO_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_SLAB.get(), ModItems.RHYOLITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_STAIRS.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RHYOLITE_WALL.get(), ModItems.RHYOLITE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_RHYOLITE_SLAB.get(), ModItems.RHYOLITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_RHYOLITE_STAIRS.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_RHYOLITE_WALL.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_RHYOLITE.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_RHYOLITE_SLAB.get(), ModItems.POLISHED_RHYOLITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_RHYOLITE_STAIRS.get(), ModItems.POLISHED_RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_RHYOLITE_WALL.get(), ModItems.POLISHED_RHYOLITE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_SLAB.get(), ModItems.RHYOLITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_STAIRS.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RHYOLITE_BRICK_WALL.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICKS.get(), ModItems.RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_SLAB.get(), ModItems.POLISHED_RHYOLITE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_STAIRS.get(), ModItems.POLISHED_RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RHYOLITE_BRICK_WALL.get(), ModItems.POLISHED_RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICKS.get(), ModItems.POLISHED_RHYOLITE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_SLAB.get(), ModItems.RHYOLITE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RHYOLITE_BRICK_STAIRS.get(), ModItems.RHYOLITE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RHYOLITE_BRICK_WALL.get(), ModItems.RHYOLITE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_SLAB.get(), ModItems.PUMICE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_STAIRS.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PUMICE_WALL.get(), ModItems.PUMICE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_PUMICE_SLAB.get(), ModItems.PUMICE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_PUMICE_STAIRS.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_PUMICE_WALL.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_PUMICE.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_PUMICE_SLAB.get(), ModItems.POLISHED_PUMICE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_PUMICE_STAIRS.get(), ModItems.POLISHED_PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_PUMICE_WALL.get(), ModItems.POLISHED_PUMICE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_SLAB.get(), ModItems.PUMICE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_STAIRS.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PUMICE_BRICK_WALL.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICKS.get(), ModItems.PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_SLAB.get(), ModItems.POLISHED_PUMICE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_STAIRS.get(), ModItems.POLISHED_PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PUMICE_BRICK_WALL.get(), ModItems.POLISHED_PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICKS.get(), ModItems.POLISHED_PUMICE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_SLAB.get(), ModItems.PUMICE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PUMICE_BRICK_STAIRS.get(), ModItems.PUMICE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PUMICE_BRICK_WALL.get(), ModItems.PUMICE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_SLAB.get(), Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_STAIRS.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_STONE_WALL.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_SLAB.get(), Items.STONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_STAIRS.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_STONE_WALL.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE.get(), Items.STONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_SLAB.get(), ModItems.POLISHED_STONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_STONE_STAIRS.get(), ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.POLISHED_STONE_WALL.get(), ModItems.POLISHED_STONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_SLAB, Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_STAIRS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.STONE_BRICK_WALL, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_STONE_BRICKS, Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_SLAB, ModItems.POLISHED_STONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICK_STAIRS, ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.STONE_BRICK_WALL, ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STONE_BRICKS, ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_STONE_BRICKS, ModItems.POLISHED_STONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_SLAB.get(), Items.COBBLESTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_STAIRS.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_TILE_WALL.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILES.get(), Items.COBBLESTONE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_SLAB.get(), ModItems.POLISHED_STONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILE_STAIRS.get(), ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.STONE_TILE_WALL.get(), ModItems.POLISHED_STONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_TILES.get(), ModItems.POLISHED_STONE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_SLAB, Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICK_STAIRS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.DEEPSLATE_BRICK_WALL, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_BRICKS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_SLAB, Items.DEEPSLATE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILE_STAIRS, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.DEEPSLATE_TILE_WALL, Items.DEEPSLATE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE_TILES, Items.DEEPSLATE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_DEEPSLATE_SLAB.get(), ModItems.SMOOTH_DEEPSLATE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SMOOTH_DEEPSLATE_STAIRS.get(), ModItems.SMOOTH_DEEPSLATE.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.SMOOTH_DEEPSLATE_WALL.get(), ModItems.SMOOTH_DEEPSLATE.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_BRICKS.get(), Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_BRICK_SLAB.get(), Items.NETHERRACK, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_BRICK_STAIRS.get(), Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.NETHERRACK_BRICK_WALL.get(), Items.NETHERRACK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_BRICK_SLAB.get(), ModItems.NETHERRACK_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERRACK_BRICK_STAIRS.get(), ModItems.NETHERRACK_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.NETHERRACK_BRICK_WALL.get(), ModItems.NETHERRACK_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICKS.get(), Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_SLAB.get(), Items.TERRACOTTA, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_STAIRS.get(), Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.TERRACOTTA_BRICK_WALL.get(), Items.TERRACOTTA);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_SLAB.get(), ModItems.TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_STAIRS.get(), ModItems.TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.TERRACOTTA_BRICK_WALL.get(), ModItems.TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BIG_BRICKS.get(), Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BIG_BRICK_SLAB.get(), Items.BRICKS, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BIG_BRICK_STAIRS.get(), Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BIG_BRICK_WALL.get(), Items.BRICKS);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BIG_BRICK_SLAB.get(), ModItems.BIG_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BIG_BRICK_STAIRS.get(), ModItems.BIG_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BIG_BRICK_WALL.get(), ModItems.BIG_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.white());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.white(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.white());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.white());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_BRICK_SLAB.get(), ModItems.WHITE_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.WHITE_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_TERRACOTTA_BRICK_WALL.get(), ModItems.WHITE_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.orange());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.orange(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.orange());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.orange());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_BRICK_SLAB.get(), ModItems.ORANGE_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.ORANGE_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_TERRACOTTA_BRICK_WALL.get(), ModItems.ORANGE_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.magenta());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.magenta(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.magenta());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.magenta());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_BRICK_SLAB.get(), ModItems.MAGENTA_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_TERRACOTTA_BRICK_STAIRS.get(), ModItems.MAGENTA_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_TERRACOTTA_BRICK_WALL.get(), ModItems.MAGENTA_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.lightBlue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_TERRACOTTA_BRICK_WALL.get(), ModItems.LIGHT_BLUE_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.yellow());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.yellow(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.yellow());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.yellow());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_BRICK_SLAB.get(), ModItems.YELLOW_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_TERRACOTTA_BRICK_STAIRS.get(), ModItems.YELLOW_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_TERRACOTTA_BRICK_WALL.get(), ModItems.YELLOW_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.lime());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.lime(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.lime());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.lime());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIME_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIME_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_TERRACOTTA_BRICK_WALL.get(), ModItems.LIME_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.pink());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.pink(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.pink());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.pink());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_BRICK_SLAB.get(), ModItems.PINK_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PINK_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_TERRACOTTA_BRICK_WALL.get(), ModItems.PINK_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.gray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.gray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.gray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.gray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.GRAY_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GRAY_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_TERRACOTTA_BRICK_WALL.get(), ModItems.GRAY_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.lightGray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_TERRACOTTA_BRICK_WALL.get(), ModItems.LIGHT_GRAY_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.cyan());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.cyan(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.cyan());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.cyan());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_BRICK_SLAB.get(), ModItems.CYAN_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.CYAN_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_TERRACOTTA_BRICK_WALL.get(), ModItems.CYAN_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.purple());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.purple(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.purple());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.purple());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_BRICK_SLAB.get(), ModItems.PURPLE_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.PURPLE_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_TERRACOTTA_BRICK_WALL.get(), ModItems.PURPLE_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.blue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.blue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.blue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.blue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLUE_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLUE_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_TERRACOTTA_BRICK_WALL.get(), ModItems.BLUE_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.brown());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.brown(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.brown());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.brown());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_BRICK_SLAB.get(), ModItems.BROWN_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BROWN_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_TERRACOTTA_BRICK_WALL.get(), ModItems.BROWN_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.green());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.green(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.green());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.green());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_BRICK_SLAB.get(), ModItems.GREEN_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_TERRACOTTA_BRICK_STAIRS.get(), ModItems.GREEN_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_TERRACOTTA_BRICK_WALL.get(), ModItems.GREEN_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.red());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.red(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.red());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.red());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_BRICK_SLAB.get(), ModItems.RED_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_TERRACOTTA_BRICK_STAIRS.get(), ModItems.RED_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_TERRACOTTA_BRICK_WALL.get(), ModItems.RED_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_BRICKS.get(), Items.DYED_TERRACOTTA.black());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get(), Items.DYED_TERRACOTTA.black(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get(), Items.DYED_TERRACOTTA.black());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_TERRACOTTA_BRICK_WALL.get(), Items.DYED_TERRACOTTA.black());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_BRICK_SLAB.get(), ModItems.BLACK_TERRACOTTA_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_TERRACOTTA_BRICK_STAIRS.get(), ModItems.BLACK_TERRACOTTA_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_TERRACOTTA_BRICK_WALL.get(), ModItems.BLACK_TERRACOTTA_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_BRICKS.get(), Items.CONCRETE.white());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.white(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.white());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.white());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_BRICK_SLAB.get(), ModItems.WHITE_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_CONCRETE_BRICK_STAIRS.get(), ModItems.WHITE_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.WHITE_CONCRETE_BRICK_WALL.get(), ModItems.WHITE_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_BRICKS.get(), Items.CONCRETE.orange());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.orange(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.orange());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.orange());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_BRICK_SLAB.get(), ModItems.ORANGE_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_CONCRETE_BRICK_STAIRS.get(), ModItems.ORANGE_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.ORANGE_CONCRETE_BRICK_WALL.get(), ModItems.ORANGE_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_BRICKS.get(), Items.CONCRETE.magenta());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.magenta(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.magenta());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.magenta());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_BRICK_SLAB.get(), ModItems.MAGENTA_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGENTA_CONCRETE_BRICK_STAIRS.get(), ModItems.MAGENTA_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.MAGENTA_CONCRETE_BRICK_WALL.get(), ModItems.MAGENTA_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get(), Items.CONCRETE.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.lightBlue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.lightBlue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_SLAB.get(), ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_STAIRS.get(), ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_BLUE_CONCRETE_BRICK_WALL.get(), ModItems.LIGHT_BLUE_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_BRICKS.get(), Items.CONCRETE.yellow());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.yellow(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.yellow());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.yellow());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_BRICK_SLAB.get(), ModItems.YELLOW_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_CONCRETE_BRICK_STAIRS.get(), ModItems.YELLOW_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.YELLOW_CONCRETE_BRICK_WALL.get(), ModItems.YELLOW_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_BRICKS.get(), Items.CONCRETE.lime());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.lime(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.lime());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.lime());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_BRICK_SLAB.get(), ModItems.LIME_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIME_CONCRETE_BRICK_STAIRS.get(), ModItems.LIME_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIME_CONCRETE_BRICK_WALL.get(), ModItems.LIME_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_BRICKS.get(), Items.CONCRETE.pink());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.pink(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.pink());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.pink());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_BRICK_SLAB.get(), ModItems.PINK_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_CONCRETE_BRICK_STAIRS.get(), ModItems.PINK_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PINK_CONCRETE_BRICK_WALL.get(), ModItems.PINK_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_BRICKS.get(), Items.CONCRETE.gray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.gray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.gray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.gray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_BRICK_SLAB.get(), ModItems.GRAY_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAY_CONCRETE_BRICK_STAIRS.get(), ModItems.GRAY_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GRAY_CONCRETE_BRICK_WALL.get(), ModItems.GRAY_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get(), Items.CONCRETE.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.lightGray(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.lightGray());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_SLAB.get(), ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_STAIRS.get(), ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.LIGHT_GRAY_CONCRETE_BRICK_WALL.get(), ModItems.LIGHT_GRAY_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_BRICKS.get(), Items.CONCRETE.cyan());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.cyan(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.cyan());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.cyan());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_BRICK_SLAB.get(), ModItems.CYAN_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CYAN_CONCRETE_BRICK_STAIRS.get(), ModItems.CYAN_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.CYAN_CONCRETE_BRICK_WALL.get(), ModItems.CYAN_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_BRICKS.get(), Items.CONCRETE.purple());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.purple(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.purple());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.purple());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_BRICK_SLAB.get(), ModItems.PURPLE_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_CONCRETE_BRICK_STAIRS.get(), ModItems.PURPLE_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.PURPLE_CONCRETE_BRICK_WALL.get(), ModItems.PURPLE_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_BRICKS.get(), Items.CONCRETE.blue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.blue(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.blue());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.blue());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_BRICK_SLAB.get(), ModItems.BLUE_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_CONCRETE_BRICK_STAIRS.get(), ModItems.BLUE_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLUE_CONCRETE_BRICK_WALL.get(), ModItems.BLUE_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_BRICKS.get(), Items.CONCRETE.brown());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.brown(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.brown());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.brown());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_BRICK_SLAB.get(), ModItems.BROWN_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_CONCRETE_BRICK_STAIRS.get(), ModItems.BROWN_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BROWN_CONCRETE_BRICK_WALL.get(), ModItems.BROWN_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_BRICKS.get(), Items.CONCRETE.green());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.green(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.green());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.green());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_BRICK_SLAB.get(), ModItems.GREEN_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_CONCRETE_BRICK_STAIRS.get(), ModItems.GREEN_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GREEN_CONCRETE_BRICK_WALL.get(), ModItems.GREEN_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_BRICKS.get(), Items.CONCRETE.red());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.red(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.red());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.red());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_BRICK_SLAB.get(), ModItems.RED_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RED_CONCRETE_BRICK_STAIRS.get(), ModItems.RED_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.RED_CONCRETE_BRICK_WALL.get(), ModItems.RED_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_BRICKS.get(), Items.CONCRETE.black());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_BRICK_SLAB.get(), Items.CONCRETE.black(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_BRICK_STAIRS.get(), Items.CONCRETE.black());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_CONCRETE_BRICK_WALL.get(), Items.CONCRETE.black());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_BRICK_SLAB.get(), ModItems.BLACK_CONCRETE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_CONCRETE_BRICK_STAIRS.get(), ModItems.BLACK_CONCRETE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.BLACK_CONCRETE_BRICK_WALL.get(), ModItems.BLACK_CONCRETE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_BLACKSTONE_SLAB.get(), Items.GILDED_BLACKSTONE, 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_BLACKSTONE_STAIRS.get(), Items.GILDED_BLACKSTONE);
        this.stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModItems.GILDED_BLACKSTONE_WALL.get(), Items.GILDED_BLACKSTONE);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PRISMARINE.get(), Items.PRISMARINE);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PRISMARINE_BRICKS.get(), Items.PRISMARINE_BRICKS);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_ELDER_PRISMARINE.get(), ModItems.ELDER_PRISMARINE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_ELDER_PRISMARINE_BRICKS.get(), ModItems.ELDER_PRISMARINE_BRICKS.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LAPIS_PILLAR.get(), Items.LAPIS_BLOCK);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_LAPIS.get(), Items.LAPIS_BLOCK);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_GRATE.get(), Items.IRON_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_IRON_GRATE.get(), ModItems.EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_IRON_GRATE.get(), ModItems.WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.RUSTED_IRON_GRATE.get(), ModItems.RUSTED_IRON.get(), 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_GRATE.get(), ModItems.WAXED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_IRON_GRATE.get(), ModItems.WAXED_EXPOSED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_IRON_GRATE.get(), ModItems.WAXED_WEATHERED_IRON.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_RUSTED_IRON_GRATE.get(), ModItems.WAXED_RUSTED_IRON.get(), 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_GRATE.get(), ModItems.ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPOSED_ZINC_GRATE.get(), ModItems.EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WEATHERED_ZINC_GRATE.get(), ModItems.WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CORRODED_ZINC_GRATE.get(), ModItems.CORRODED_ZINC.get(), 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_GRATE.get(), ModItems.WAXED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXPOSED_ZINC_GRATE.get(), ModItems.WAXED_EXPOSED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_WEATHERED_ZINC_GRATE.get(), ModItems.WAXED_WEATHERED_ZINC.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_CORRODED_ZINC_GRATE.get(), ModItems.WAXED_CORRODED_ZINC.get(), 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_GRATE.get(), ModItems.SILVER_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_GRATE.get(), ModItems.TIN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_GRATE.get(), ModItems.TUNGSTEN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_GRATE.get(), ModItems.PLATINUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_GRATE.get(), Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_GRATE.get(), ModItems.LEAD_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_GRATE.get(), ModItems.URANIUM_BLOCK.get(), 4);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_GRATE.get(), Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_GRATE.get(), ModItems.BRONZE_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_GRATE.get(), ModItems.BRASS_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_GRATE.get(), ModItems.STEEL_BLOCK.get(), 4);}

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
            return BuildersParadise.MODID + ":recipe_provider";
        }
    }


}
