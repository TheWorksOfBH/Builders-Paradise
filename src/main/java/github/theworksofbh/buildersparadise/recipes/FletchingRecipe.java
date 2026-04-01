package github.theworksofbh.buildersparadise.recipes;

import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public interface FletchingRecipe extends Recipe<FletchingRecipeInput> {
    @Override
    default RecipeType<FletchingRecipe> getType(){
        return ModRecipes.FLETCHING_RECIPE_TYPE.get();
    }

    @Override
    RecipeSerializer<? extends Recipe<FletchingRecipeInput>> getSerializer();

    @Override
    RecipeBookCategory recipeBookCategory();

    @Override
    boolean matches(FletchingRecipeInput fletchingRecipeInput, Level level);

    Ingredient arrow();
    Ingredient ingredient();
    ItemStackTemplate output();
}
