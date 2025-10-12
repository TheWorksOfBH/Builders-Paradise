package github.theworksofbh.buildersparadise.recipes;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FletchingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Ingredient arrow;
    private final Ingredient ingredient;
    private final ItemStack result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();

    public FletchingRecipeBuilder(Ingredient arrow, Ingredient ingredient, ItemLike result, int count, RecipeCategory category) {
        this.arrow = arrow;
        this.ingredient = ingredient;
        this.result = new ItemStack(result.asItem(), count);
        this.category = category;
    }

    public static FletchingRecipeBuilder fletching(Ingredient arrow, Ingredient ingredient, ItemLike result){
        return new FletchingRecipeBuilder(arrow, ingredient, result, 1, RecipeCategory.COMBAT);
    }

    @Override
    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
        return this.unlocks(s, criterion);
    }

    @Override
    public RecipeBuilder group(@Nullable String s) {
        return null;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void save(RecipeOutput recipeOutput, String id) {
        this.save(recipeOutput, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(id)));
    }

    public FletchingRecipeBuilder unlocks(String key, Criterion<?> criterion){
        this.criteria.put(key, criterion);
        return this;
    }

    @Override
    public void save(RecipeOutput recipeOutput, @NotNull ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey);
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(advancementBuilder);
        this.criteria.forEach(advancementBuilder::addCriterion);
        FletchingRecipe fletchingRecipe = new FletchingRecipe(this.arrow, this.ingredient, this.result);
        recipeOutput.accept(resourceKey, fletchingRecipe, recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR).build(resourceKey.location().withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceKey<Recipe<?>> recipe) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(recipe.location()));
        }
    }
}
