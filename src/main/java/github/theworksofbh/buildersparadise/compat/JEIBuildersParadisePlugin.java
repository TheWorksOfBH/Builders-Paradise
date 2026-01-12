package github.theworksofbh.buildersparadise.compat;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.gui.FletchingMenu;
import github.theworksofbh.buildersparadise.gui.FletchingScreen;
import github.theworksofbh.buildersparadise.gui.ModMenuTypes;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

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
        registration.addRecipes(FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE.get(), this.getRecipes(ModRecipes.FLETCHING_RECIPE_TYPE.get()));
    }

    private <C extends RecipeInput, T extends Recipe<C>> List<RecipeHolder<T>> getRecipes(RecipeType<T> type) { // LMAO I yoinked Crayfish's code
        return List.copyOf(SyncedRecipes.getMap().byType(type));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(FletchingScreen.class, 80, 39, 28, 21, FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE.get());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE.get(), new ItemStack(Items.FLETCHING_TABLE));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(FletchingMenu.class, ModMenuTypes.FLETCHING_MENU.get(), FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE.get(), FletchingMenu.ARROW_SLOT, FletchingMenu.RESULT_SLOT, 3, 36);
    }
}
