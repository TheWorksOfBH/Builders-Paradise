package github.theworksofbh.buildersparadise.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class ModRecipeBookCategories {

    public static final RecipeBookCategory FLETCHING = register("fletching");

    private static RecipeBookCategory register(String name) {
        return Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, name, new RecipeBookCategory());
    }

    public static void initialize() {

    }
}
