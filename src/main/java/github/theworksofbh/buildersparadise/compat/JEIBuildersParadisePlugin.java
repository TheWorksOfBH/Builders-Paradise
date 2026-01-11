package github.theworksofbh.buildersparadise.compat;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.gui.FletchingMenu;
import github.theworksofbh.buildersparadise.gui.FletchingScreen;
import github.theworksofbh.buildersparadise.gui.ModMenuTypes;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;

import java.util.List;

@JeiPlugin
public class JEIBuildersParadisePlugin implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FletchingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeMap synchedRecipes = Minecraft.getInstance().level.getServer().getRecipeManager().recipeMap();

        IRecipeType<FletchingRecipe> fletchingRecipeIRecipeType = FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE;
        List<FletchingRecipe> fletchingRecipes = synchedRecipes.byType(ModRecipes.FLETCHING_RECIPE_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(fletchingRecipeIRecipeType, fletchingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FletchingScreen.class, 80, 39, 28, 21, FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE, new ItemStack(Items.FLETCHING_TABLE));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FletchingMenu.class, ModMenuTypes.FLETCHING_MENU.get(), FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE, FletchingMenu.ARROW_SLOT, FletchingMenu.RESULT_SLOT, 3, 36);
    }
}
