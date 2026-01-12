package github.theworksofbh.buildersparadise.compat;

import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import mezz.jei.api.constants.ModIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

public class TippedArrowRecipeMaker {
    public static List<RecipeHolder<FletchingRecipe>> createTippedArrowJeiRecipes() {
        Ingredient arrowIngredient = Ingredient.of(Items.ARROW);
        Registry<Potion> potionRegistry = BuiltInRegistries.POTION;

        return potionRegistry.listElements().map(potion -> {
            ItemStack potionInput = PotionContents.createItemStack(Items.LINGERING_POTION, potion);
            ItemStack output = PotionContents.createItemStack(Items.TIPPED_ARROW, potion);
            Ingredient potionIngredient = Ingredient.of(potionInput.getItem());
            Identifier potionId = potion.key().identifier();
            Identifier recipeId = Identifier.fromNamespaceAndPath(ModIds.MINECRAFT_ID, "jei.tipped.arrow." + potionId.getNamespace() + "." + potionId.getPath());
            ResourceKey<Recipe<?>> resourceKey = ResourceKey.create(Registries.RECIPE, recipeId);
            FletchingRecipe recipe = new FletchingRecipe(
                    arrowIngredient,
                    potionIngredient,
                    output
            );
            return new RecipeHolder<>(resourceKey, recipe);
        }).toList();
    }
}
