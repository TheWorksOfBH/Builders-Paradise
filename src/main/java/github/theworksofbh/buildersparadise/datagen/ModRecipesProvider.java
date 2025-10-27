package github.theworksofbh.buildersparadise.datagen;

import com.google.common.collect.ImmutableList;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipeBuilder;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.TippedArrowRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.NeoForgeConditions;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider {

    public static final ImmutableList<ItemLike> ZINC_SMELTABLES = ImmutableList.of(ModItems.ZINC_ORE.get(), ModItems.DEEPSLATE_ZINC_ORE.get(), ModItems.RAW_ZINC.get());
    public static final ImmutableList<ItemLike> SILVER_SMELTABLES = ImmutableList.of(ModItems.SILVER_ORE.get(), ModItems.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get());
    public static final ImmutableList<ItemLike> TIN_SMELTABLES = ImmutableList.of(ModItems.TIN_ORE.get(), ModItems.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get());
    public static final ImmutableList<ItemLike> TUNGSTEN_SMELTABLES = ImmutableList.of(ModItems.TUNGSTEN_ORE.get(), ModItems.DEEPSLATE_TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get());
    public static final ImmutableList<ItemLike> PLATINUM_SMELTABLES = ImmutableList.of(ModItems.PLATINUM_ORE.get(), ModItems.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get());
    public static final ImmutableList<ItemLike> LEAD_SMELTABLES = ImmutableList.of(ModItems.LEAD_ORE.get(), ModItems.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get());
    public static final ImmutableList<ItemLike> URANIUM_SMELTABLES = ImmutableList.of(ModItems.URANIUM_ORE.get(), ModItems.DEEPSLATE_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get());

    protected ModRecipesProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    protected void buildRecipes() {
        this.output.includeRootAdvancement();
        generateForEnabledBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA));
        stoneCuttingRecipes();
        waxedBlocks();
        doorBuilder(ModItems.GOLD_DOOR.get(), Ingredient.of(Items.GOLD_INGOT)).unlockedBy(getHasName(Items.GOLD_INGOT), this.has(Items.GOLD_INGOT)).save(this.output);
        trapdoorBuilder(ModItems.GOLD_TRAPDOOR.get(), Ingredient.of(Items.GOLD_INGOT)).unlockedBy(getHasName(Items.GOLD_INGOT), this.has(Items.GOLD_INGOT)).save(this.output);
        pressurePlate(ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Items.COPPER_INGOT);
        doorBuilder(ModItems.NETHERITE_DOOR.get(), Ingredient.of(Items.NETHERITE_INGOT)).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        trapdoorBuilder(ModItems.NETHERITE_TRAPDOOR.get(), Ingredient.of(Items.NETHERITE_INGOT)).unlockedBy(getHasName(Items.NETHERITE_INGOT), this.has(Items.NETHERITE_INGOT)).save(this.output);
        pressurePlate(ModItems.PLAYER_ONLY_PRESSURE_PLATE.get(), Items.NETHERITE_INGOT);
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BLOCK.get(), getSimpleRecipeName(ModItems.CHARCOAL_BLOCK.get()), null, getSimpleRecipeName(Items.CHARCOAL) + "_b", null);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModItems.SOUL_SANDSTONE.get(), Items.SOUL_SAND);
        smeltingResultFromBase(ModItems.SMOOTH_SOUL_SANDSTONE.get(), ModItems.SOUL_SANDSTONE);
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE.get(), ModItems.ELDER_PRISMARINE_SHARD.get());
        threeByThreePacker(RecipeCategory.BUILDING_BLOCKS, ModItems.ELDER_PRISMARINE_BRICKS.get(), ModItems.ELDER_PRISMARINE_SHARD.get());
        shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_ELDER_PRISMARINE.get())
                .define('S', ModItems.ELDER_PRISMARINE_SHARD.get())
                .define('I', Items.BLACK_DYE)
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
//        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), RecipeCategory.MISC, Items.COPPER_INGOT);
        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.NETHERITE_NUGGET.get(), RecipeCategory.MISC, Items.NETHERITE_INGOT);
        oreSmelting(ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 1.0F, 200, "zinc_ingot");
        oreBlasting(ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 1.0F, 200, "zinc_ingot");
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
        trapdoorBuilder(ModItems.ZINC_TRAPDOOR.get(), Ingredient.of(ModItems.ZINC_INGOT.get())).unlockedBy(getHasName(ModItems.ZINC_INGOT), this.has(ModItems.ZINC_INGOT.get())).save(this.output);
        pressurePlate(ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.ZINC_INGOT.get());

        oreSmelting(SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 1.0F, 200, "silver_ingot");
        oreBlasting(SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 1.0F, 200, "silver_ingot");
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
        trapdoorBuilder(ModItems.SILVER_TRAPDOOR.get(), Ingredient.of(ModItems.SILVER_INGOT.get())).unlockedBy(getHasName(ModItems.SILVER_INGOT), this.has(ModItems.SILVER_INGOT.get())).save(this.output);
        pressurePlate(ModItems.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.SILVER_INGOT.get());

        oreSmelting(TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 1.0F, 200, "tin_ingot");
        oreBlasting(TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 1.0F, 200, "tin_ingot");
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
        trapdoorBuilder(ModItems.TIN_TRAPDOOR.get(), Ingredient.of(ModItems.TIN_INGOT.get())).unlockedBy(getHasName(ModItems.TIN_INGOT), this.has(ModItems.TIN_INGOT.get())).save(this.output);
        pressurePlate(ModItems.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.TIN_INGOT.get());

        oreSmelting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 1.0F, 200, "tungsten_ingot");
        oreBlasting(TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT.get(), 1.0F, 200, "tungsten_ingot");
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
        trapdoorBuilder(ModItems.TUNGSTEN_TRAPDOOR.get(), Ingredient.of(ModItems.TUNGSTEN_INGOT.get())).unlockedBy(getHasName(ModItems.TUNGSTEN_INGOT), this.has(ModItems.TUNGSTEN_INGOT.get())).save(this.output);
        pressurePlate(ModItems.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.TUNGSTEN_INGOT.get());

        oreSmelting(PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0F, 200, "platinum_ingot");
        oreBlasting(PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 1.0F, 200, "platinum_ingot");
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
        trapdoorBuilder(ModItems.PLATINUM_TRAPDOOR.get(), Ingredient.of(ModItems.PLATINUM_INGOT.get())).unlockedBy(getHasName(ModItems.PLATINUM_INGOT), this.has(ModItems.PLATINUM_INGOT.get())).save(this.output);
        pressurePlate(ModItems.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModItems.PLATINUM_INGOT.get());

        oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 1.0F, 200, "lead_ingot");
        oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 1.0F, 200, "lead_ingot");
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
        trapdoorBuilder(ModItems.LEAD_TRAPDOOR.get(), Ingredient.of(ModItems.LEAD_INGOT.get())).unlockedBy(getHasName(ModItems.LEAD_INGOT), this.has(ModItems.LEAD_INGOT.get())).save(this.output);
        pressurePlate(ModItems.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.LEAD_INGOT.get());


        oreSmelting(URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 1.0F, 200, "uranium_ingot");
        oreBlasting(URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 1.0F, 200, "uranium_ingot");
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
        trapdoorBuilder(ModItems.URANIUM_TRAPDOOR.get(), Ingredient.of(ModItems.URANIUM_INGOT.get())).unlockedBy(getHasName(ModItems.URANIUM_INGOT), this.has(ModItems.URANIUM_INGOT.get())).save(this.output);
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
        trapdoorBuilder(ModItems.BRONZE_TRAPDOOR.get(), Ingredient.of(ModItems.BRONZE_INGOT.get())).unlockedBy(getHasName(ModItems.BRONZE_INGOT), this.has(ModItems.BRONZE_INGOT.get())).save(this.output);
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
        trapdoorBuilder(ModItems.BRASS_TRAPDOOR.get(), Ingredient.of(ModItems.BRASS_INGOT.get())).unlockedBy(getHasName(ModItems.BRASS_INGOT), this.has(ModItems.BRASS_INGOT.get())).save(this.output);
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
        trapdoorBuilder(ModItems.STEEL_TRAPDOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).unlockedBy(getHasName(ModItems.STEEL_INGOT), this.has(ModItems.STEEL_INGOT.get())).save(this.output);
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

        SpecialRecipeBuilder.special(TippedArrowRecipe::new)
                .save(this.output.withConditions(NeoForgeConditions.never()), "tipped_arrow");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_SLAB), RecipeCategory.BUILDING_BLOCKS, Items.STONE_SLAB, 0.1F, 200).unlockedBy("has_cobblestone_slab", this.has(Items.COBBLESTONE_SLAB)).save(this.output, "stone_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_STAIRS), RecipeCategory.BUILDING_BLOCKS, Items.STONE_STAIRS, 0.1F, 200).unlockedBy("has_cobblestone_stairs", this.has(Items.COBBLESTONE_STAIRS)).save(this.output, "stone_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLESTONE_WALL), RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_WALL.get(), 0.1F, 200).unlockedBy("has_cobblestone_wall", this.has(Items.COBBLESTONE_WALL)).save(this.output, "stone_wall_smelting");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_SLAB), RecipeCategory.BUILDING_BLOCKS, ModItems.DEEPSLATE_SLAB.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_slab", this.has(Items.COBBLED_DEEPSLATE_SLAB)).save(this.output, "deepslate_slab_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_STAIRS), RecipeCategory.BUILDING_BLOCKS, ModItems.DEEPSLATE_STAIRS.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_stairs", this.has(Items.COBBLED_DEEPSLATE_STAIRS)).save(this.output, "deepslate_stairs_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.COBBLED_DEEPSLATE_WALL), RecipeCategory.BUILDING_BLOCKS, ModItems.DEEPSLATE_WALL.get(), 0.1F, 200).unlockedBy("has_cobbled_deepslate_wall", this.has(Items.COBBLED_DEEPSLATE_WALL)).save(this.output, "deepslate_wall_smelting");

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

        this.shapeless(RecipeCategory.MISC, Items.IRON_INGOT, 9).requires(ModItems.WAXED_IRON_BLOCK.get()).group(null).unlockedBy(getHasName(ModItems.WAXED_IRON_BLOCK.get()), this.has(ModItems.WAXED_IRON_BLOCK.get())).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("iron_ingot_from_waxed")));
        this.shapeless(RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 9).requires(ModItems.WAXED_ZINC_BLOCK.get()).group(null).unlockedBy(getHasName(ModItems.WAXED_ZINC_BLOCK.get()), this.has(ModItems.WAXED_ZINC_BLOCK.get())).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("zinc_ingot_from_waxed")));

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
        this.chestBoat(ModItems.CRIMSON_CHEST_BOAT.get(), ModItems.CRIMSON_BOAT.get());

        this.woodenBoat(ModItems.WARPED_BOAT.get(), Items.WARPED_PLANKS);
        this.chestBoat(ModItems.WARPED_CHEST_BOAT.get(), ModItems.WARPED_BOAT.get());
    }

    @Override
    protected void generateForEnabledBlockFamilies(FeatureFlagSet enabledFeatures) {
        ModBlockFamilies.getAllFamilies()
                .filter(
                        BlockFamily::shouldGenerateRecipe
                ).forEach((p_359455_) -> this.generateRecipes(p_359455_, enabledFeatures));
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

    protected void createObserver(ItemLike observer, ItemLike stoneType) {
        this.shaped(RecipeCategory.REDSTONE, observer)
                .define('Q', Items.QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', stoneType)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", this.has(Items.QUARTZ))
                .save(this.output.withConditions(NeoForgeConditions.never()));
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
                .unlockedBy("has_" + woodPlanks.asItem().getDescriptionId(), this.has(woodPlanks))
                .unlockedBy("has_" + woodSlabs.asItem().getDescriptionId(), this.has(woodSlabs))
                .save(this.output.withConditions(NeoForgeConditions.never()));
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
        this.shapeless(nuggetCategory, nugget, 9).requires(ingot).group(nuggetGroup).unlockedBy(getHasName(ingot), this.has(ingot)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(nuggetName)));
        this.shaped(ingotCategory, ingot).define('#', nugget).pattern("###").pattern("###").pattern("###").group(ingotGroup).unlockedBy(getHasName(nugget), this.has(nugget)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(ingotName)));

        this.shapeless(ingotCategory, ingot, 9).requires(block).group(ingotGroup).unlockedBy(getHasName(block), this.has(block)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(ingotName + "_b")));
        this.shaped(blockCategory, block).define('#', ingot).pattern("###").pattern("###").pattern("###").group(blockGroup).unlockedBy(getHasName(ingot), this.has(block)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(blockName)));
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

    private void waxedBlocks() {
        createWaxedPressurePlateRecipe(ModItems.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "exposed_medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "weathered_medium_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModItems.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), "oxidized_medium_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_IRON_BLOCK.get(), Items.IRON_BLOCK, "iron_block");
        createWaxedBlock(ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get(), ModItems.MILDLY_RUSTED_IRON_TILES.get(), "mildly_rusted_iron_block");
        createWaxedBlock(ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get(), ModItems.MODERATELY_RUSTED_IRON_BLOCK.get(), "moderately_rusted_iron_block");
        createWaxedBlock(ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get(), ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get(), "extremely_rusted_iron_block");

        createWaxedPressurePlateRecipe(ModItems.WAXED_IRON_DOOR.get(), Items.IRON_DOOR, "iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MILDLY_RUSTED_IRON_DOOR.get(), ModItems.MILDLY_RUSTED_IRON_DOOR.get(), "mildly_rusted_iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MODERATELY_RUSTED_IRON_DOOR.get(), ModItems.MODERATELY_RUSTED_IRON_DOOR.get(), "moderately_rusted_iron_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get(), ModItems.EXTREMELY_RUSTED_IRON_DOOR.get(), "extremely_rusted_iron_door");

        createWaxedPressurePlateRecipe(ModItems.WAXED_IRON_TRAPDOOR.get(), Items.IRON_TRAPDOOR, "iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get(), ModItems.MILDLY_RUSTED_IRON_TRAPDOOR.get(), "mildly_rusted_iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get(), ModItems.MODERATELY_RUSTED_IRON_TRAPDOOR.get(), "moderately_rusted_iron_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get(), ModItems.EXTREMELY_RUSTED_IRON_TRAPDOOR.get(), "extremely_rusted_iron_trapdoor");

        createWaxedBarsRecipe(ModItems.WAXED_IRON_BARS.get(), Items.IRON_BARS, "iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_MILDLY_RUSTED_IRON_BARS.get(), ModItems.MILDLY_RUSTED_IRON_BARS.get(), "mildly_rusted_iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_MODERATELY_RUSTED_IRON_BARS.get(), ModItems.MODERATELY_RUSTED_IRON_BARS.get(), "moderately_rusted_iron_bars");
        createWaxedBarsRecipe(ModItems.WAXED_EXTREMELY_RUSTED_IRON_BARS.get(), ModItems.EXTREMELY_RUSTED_IRON_BARS.get(), "extremely_rusted_iron_bars");

        createWaxedPressurePlateRecipe(ModItems.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), Items.HEAVY_WEIGHTED_PRESSURE_PLATE, "heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "mildly_rusted_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "moderately_rusted_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "extremely_rusted_heavy_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_IRON_TILES.get(), ModItems.IRON_TILES.get(), "iron_tiles");
        createWaxedBlock(ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get(), ModItems.MILDLY_RUSTED_IRON_TILES.get(), "mildly_rusted_iron_tiles");
        createWaxedBlock(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get(), ModItems.MODERATELY_RUSTED_IRON_TILES.get(), "moderately_rusted_iron_tiles");
        createWaxedBlock(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get(), ModItems.EXTREMELY_RUSTED_IRON_TILES.get(), "extremely_rusted_iron_tiles");

        createWaxedBlock(ModItems.WAXED_IRON_TILE_SLAB.get(), ModItems.IRON_TILE_SLAB.get(), "iron_tile_slab");
        createWaxedBlock(ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MILDLY_RUSTED_IRON_TILE_SLAB.get(), "mildly_rusted_iron_tile_slab");
        createWaxedBlock(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), "moderately_rusted_iron_tile_slab");
        createWaxedBlock(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), "extremely_rusted_iron_tile_slab");

        createWaxedBlock(ModItems.WAXED_IRON_TILE_STAIRS.get(), ModItems.IRON_TILE_STAIRS.get(), "iron_tile_stairs");
        createWaxedBlock(ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), "mildly_rusted_iron_tile_stairs");
        createWaxedBlock(ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), "moderately_rusted_iron_tile_stairs");
        createWaxedBlock(ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), "extremely_rusted_iron_tile_stairs");

        createWaxedBlock(ModItems.WAXED_ZINC_BLOCK.get(), ModItems.ZINC_BLOCK.get(), "zinc_block");
        createWaxedBlock(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModItems.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), "slightly_corroded_zinc_block");
        createWaxedBlock(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModItems.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), "somewhat_corroded_zinc_block");
        createWaxedBlock(ModItems.WAXED_REALLY_CORRODED_ZINC_BLOCK.get(), ModItems.REALLY_CORRODED_ZINC_BLOCK.get(), "really_corroded_zinc_block");

        createWaxedPressurePlateRecipe(ModItems.WAXED_ZINC_DOOR.get(), ModItems.ZINC_DOOR.get(), "zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModItems.SLIGHTLY_CORRODED_ZINC_DOOR.get(), "slightly_corroded_zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModItems.SOMEWHAT_CORRODED_ZINC_DOOR.get(), "somewhat_corroded_zinc_door");
        createWaxedPressurePlateRecipe(ModItems.WAXED_REALLY_CORRODED_ZINC_DOOR.get(), ModItems.REALLY_CORRODED_ZINC_DOOR.get(), "really_corroded_zinc_door");

        createWaxedPressurePlateRecipe(ModItems.WAXED_ZINC_TRAPDOOR.get(), ModItems.ZINC_TRAPDOOR.get(), "zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), "slightly_corroded_zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), "somewhat_corroded_zinc_trapdoor");
        createWaxedPressurePlateRecipe(ModItems.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get(), ModItems.REALLY_CORRODED_ZINC_TRAPDOOR.get(), "really_corroded_zinc_trapdoor");

        createWaxedPressurePlateRecipe(ModItems.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "slightly_corroded_barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "somewhat_corroded_barely_heavy_weighted_pressure_plate");
        createWaxedPressurePlateRecipe(ModItems.WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModItems.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), "really_corroded_barely_heavy_weighted_pressure_plate");

        createWaxedBlock(ModItems.WAXED_ZINC_TILES.get(), ModItems.ZINC_TILES.get(), "zinc_tiles");
        createWaxedBlock(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TILES.get(), "slightly_corroded_zinc_tiles");
        createWaxedBlock(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TILES.get(), "somewhat_corroded_zinc_tiles");
        createWaxedBlock(ModItems.WAXED_REALLY_CORRODED_ZINC_TILES.get(), ModItems.REALLY_CORRODED_ZINC_TILES.get(), "really_corroded_zinc_tiles");

        createWaxedBlock(ModItems.WAXED_ZINC_TILE_SLAB.get(), ModItems.ZINC_TILE_SLAB.get(), "zinc_tile_slab");
        createWaxedBlock(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), "slightly_corroded_zinc_tile_slab");
        createWaxedBlock(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), "somewhat_corroded_zinc_tile_slab");
        createWaxedBlock(ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.REALLY_CORRODED_ZINC_TILE_SLAB.get(), "really_corroded_zinc_tile_slab");

        createWaxedBlock(ModItems.WAXED_ZINC_TILE_STAIRS.get(), ModItems.ZINC_TILE_STAIRS.get(), "zinc_tile_stairs");
        createWaxedBlock(ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), "slightly_corroded_zinc_tile_stairs");
        createWaxedBlock(ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), "somewhat_corroded_zinc_tile_stairs");
        createWaxedBlock(ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.REALLY_CORRODED_ZINC_TILE_STAIRS.get(), "really_corroded_zinc_tile_stairs");
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

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_TILES.get(), Items.IRON_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_TILE_STAIRS.get(), Items.IRON_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_TILE_SLAB.get(), Items.IRON_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_TILE_STAIRS.get(), ModItems.IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.IRON_TILE_SLAB.get(), ModItems.IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MILDLY_RUSTED_IRON_TILES.get(), ModItems.MILDLY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MILDLY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MILDLY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MILDLY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MILDLY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MODERATELY_RUSTED_IRON_TILES.get(), ModItems.MODERATELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MODERATELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MODERATELY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.MODERATELY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.MODERATELY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXTREMELY_RUSTED_IRON_TILES.get(), ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.EXTREMELY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.EXTREMELY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.EXTREMELY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_TILES.get(), ModItems.WAXED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_TILE_STAIRS.get(), ModItems.WAXED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_TILE_SLAB.get(), ModItems.WAXED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_TILE_STAIRS.get(), ModItems.WAXED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_IRON_TILE_SLAB.get(), ModItems.WAXED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get(), ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_MILDLY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_MILDLY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get(), ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_MODERATELY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModItems.WAXED_EXTREMELY_RUSTED_IRON_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_TILES.get(), ModItems.ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_TILE_STAIRS.get(), ModItems.ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_TILE_SLAB.get(), ModItems.ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_TILE_STAIRS.get(), ModItems.ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.ZINC_TILE_SLAB.get(), ModItems.ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SLIGHTLY_CORRODED_ZINC_TILES.get(), ModItems.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SLIGHTLY_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOMEWHAT_CORRODED_ZINC_TILES.get(), ModItems.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModItems.SOMEWHAT_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.REALLY_CORRODED_ZINC_TILES.get(), ModItems.REALLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.REALLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.REALLY_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.REALLY_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.REALLY_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_TILES.get(), ModItems.WAXED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_TILE_SLAB.get(), ModItems.WAXED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_ZINC_TILE_SLAB.get(), ModItems.WAXED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get(), ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get(), ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_REALLY_CORRODED_ZINC_TILES.get(), ModItems.WAXED_REALLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_REALLY_CORRODED_ZINC_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_REALLY_CORRODED_ZINC_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModItems.WAXED_REALLY_CORRODED_ZINC_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModItems.WAXED_REALLY_CORRODED_ZINC_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_TILES.get(), Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_TILE_STAIRS.get(), Items.GOLD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_TILE_SLAB.get(), Items.GOLD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_TILE_STAIRS.get(), ModItems.GOLD_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.GOLD_TILE_SLAB.get(), ModItems.GOLD_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DIAMOND_TILES.get(), Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DIAMOND_TILE_STAIRS.get(), Items.DIAMOND_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DIAMOND_TILE_SLAB.get(), Items.DIAMOND_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DIAMOND_TILE_STAIRS.get(), ModItems.DIAMOND_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.DIAMOND_TILE_SLAB.get(), ModItems.DIAMOND_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_TILES.get(), Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_TILE_STAIRS.get(), Items.EMERALD_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_TILE_SLAB.get(), Items.EMERALD_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_TILE_STAIRS.get(), ModItems.EMERALD_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_TILE_SLAB.get(), ModItems.EMERALD_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_TILES.get(), Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_TILE_STAIRS.get(), Items.NETHERITE_BLOCK, 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_TILE_SLAB.get(), Items.NETHERITE_BLOCK, 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_TILE_STAIRS.get(), ModItems.NETHERITE_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.NETHERITE_TILE_SLAB.get(), ModItems.NETHERITE_TILES.get(), 2);

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

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_TILES.get(), ModItems.SILVER_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_TILE_STAIRS.get(), ModItems.SILVER_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_TILE_SLAB.get(), ModItems.SILVER_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_TILE_STAIRS.get(), ModItems.SILVER_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_TILE_SLAB.get(), ModItems.SILVER_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN.get(), ModItems.TIN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_STAIRS.get(), ModItems.TIN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_SLAB.get(), ModItems.TIN_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_STAIRS.get(), ModItems.CUT_TIN.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_TIN_SLAB.get(), ModItems.CUT_TIN.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_TILES.get(), ModItems.TUNGSTEN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_TILE_STAIRS.get(), ModItems.TUNGSTEN_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_TILE_SLAB.get(), ModItems.TUNGSTEN_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_TILE_STAIRS.get(), ModItems.TUNGSTEN_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.TUNGSTEN_TILE_SLAB.get(), ModItems.TUNGSTEN_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_TILES.get(), ModItems.PLATINUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_TILE_STAIRS.get(), ModItems.PLATINUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_TILE_SLAB.get(), ModItems.PLATINUM_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_TILE_STAIRS.get(), ModItems.PLATINUM_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_TILE_SLAB.get(), ModItems.PLATINUM_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_TILES.get(), ModItems.LEAD_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_TILE_STAIRS.get(), ModItems.LEAD_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_TILE_SLAB.get(), ModItems.LEAD_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_TILE_STAIRS.get(), ModItems.LEAD_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_TILE_SLAB.get(), ModItems.LEAD_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_TILES.get(), ModItems.URANIUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_TILE_STAIRS.get(), ModItems.URANIUM_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_TILE_SLAB.get(), ModItems.URANIUM_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_TILE_STAIRS.get(), ModItems.URANIUM_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_TILE_SLAB.get(), ModItems.URANIUM_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE.get(), ModItems.BRONZE_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_STAIRS.get(), ModItems.BRONZE_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_SLAB.get(), ModItems.BRONZE_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_STAIRS.get(), ModItems.CUT_BRONZE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.CUT_BRONZE_SLAB.get(), ModItems.CUT_BRONZE.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_TILES.get(), ModItems.BRASS_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_TILE_STAIRS.get(), ModItems.BRASS_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_TILE_SLAB.get(), ModItems.BRASS_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_TILE_STAIRS.get(), ModItems.BRASS_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.BRASS_TILE_SLAB.get(), ModItems.BRASS_TILES.get(), 2);

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_TILES.get(), ModItems.STEEL_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_TILE_STAIRS.get(), ModItems.STEEL_BLOCK.get(), 4);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_TILE_SLAB.get(), ModItems.STEEL_BLOCK.get(), 8);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_TILE_STAIRS.get(), ModItems.STEEL_TILES.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_TILE_SLAB.get(), ModItems.STEEL_TILES.get(), 2);
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
            return BuildersParadise.MODID + ":recipe_provider";
        }
    }
}
