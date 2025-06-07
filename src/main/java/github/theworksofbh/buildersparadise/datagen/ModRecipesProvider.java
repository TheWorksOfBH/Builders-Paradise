package github.theworksofbh.buildersparadise.datagen;

import com.google.common.collect.ImmutableList;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

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
        nineBlockStorageRecipes(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, ModItems.CHARCOAL_BLOCK.get());
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
        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SEA_LANTERN)
                .define('S', ModItems.ELDER_PRISMARINE_SHARD.get())
                .define('C', ModItems.ELDER_PRISMARINE_CRYSTALS.get())
                .pattern("SCS")
                .pattern("CCC")
                .pattern("SCS")
                .unlockedBy("has_elder_prismarine_crystals", this.has(ModItems.ELDER_PRISMARINE_CRYSTALS.get()))
                .save(this.output);
        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), RecipeCategory.MISC, Items.COPPER_INGOT);
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
