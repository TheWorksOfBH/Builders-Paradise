package github.theworksofbh.buildersparadise.recipe;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

public class ModRecipeDisplays {

    public static final RecipeDisplay.Type<FletchingRecipeDisplay> FLETCHING = register("fletching", FletchingRecipeDisplay.TYPE);

    private static <T extends RecipeDisplay> RecipeDisplay.Type<T> register(String name, RecipeDisplay.Type<T> displayType) {
        return Registry.register(BuiltInRegistries.RECIPE_DISPLAY, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name), displayType);
    }

    public static void initialize() {

    }
}
