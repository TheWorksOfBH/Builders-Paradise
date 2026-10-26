package github.theworksofbh.buildersparadise.recipe;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {
    public static final RecipeType<FletchingRecipe> FLETCHING_RECIPE_TYPE = register("fletching");

    private static <T extends Recipe<?>> RecipeType<T> register(final String name) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name), new RecipeType<T>() {
            public String toString() {
                return name;
            }
        });
    }

    public static void initialize() {

    }
}
