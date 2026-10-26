package github.theworksofbh.buildersparadise.recipe;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {

    public static final RecipeSerializer<BaseFletchingRecipe> BASE_FLETCHING_RECIPE_SERIALIZER = register("base_fletching", BaseFletchingRecipe.SERIALIZER);
    public static final RecipeSerializer<TippedFletchingRecipe> TIPPED_FLETCHING_RECIPE_SERIALIZER = register("tipped_fletching", TippedFletchingRecipe.SERIALIZER);

    private static <T extends Recipe<?>> RecipeSerializer<T> register(String name, RecipeSerializer<T> serializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name), serializer);
    }

    public static void initialize() {

    }
}
