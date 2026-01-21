package github.theworksofbh.buildersparadise.compat.jei;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.gui.FletchingMenu;
import github.theworksofbh.buildersparadise.gui.FletchingScreen;
import github.theworksofbh.buildersparadise.gui.ModMenuTypes;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import github.theworksofbh.buildersparadise.recipes.TippedFletchingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

        VanillaRecipes vanillaRecipes = new VanillaRecipes(SyncedRecipes.getMap());
        var fletchingRecipes = vanillaRecipes.getFletchingRecipes(new FletchingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        var specialFletchingRecipes = replaceSpecialFletchingRecipes(fletchingRecipes, registration.getJeiHelpers());

        registration.addRecipes(FletchingTableRecipeCategory.FLETCHING_RECIPE_TYPE.get(), specialFletchingRecipes);
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

    private static List<RecipeHolder<FletchingRecipe>> replaceSpecialFletchingRecipes(List<RecipeHolder<FletchingRecipe>> unhandledFletchingRecipes, IJeiHelpers jeiHelpers) {
        Map<Class<? extends FletchingRecipe>, Supplier<List<RecipeHolder<FletchingRecipe>>>> replacers = new IdentityHashMap<>();
        replacers.put(TippedFletchingRecipe.class, TippedArrowRecipeMaker::createTippedArrowJeiRecipes);

        return unhandledFletchingRecipes.stream()
                .map(RecipeHolder::value)
                .map(FletchingRecipe::getClass)
                .filter(replacers::containsKey)
                .distinct()
                .limit(replacers.size())
                .flatMap(recipeClass -> {
                    var supplier = replacers.get(recipeClass);
                    try {
                        return supplier.get().stream();
                    } catch (RuntimeException runtimeException) {
                        BuildersParadise.LOGGER.error("Failed to create JEI recipes for {}", recipeClass, runtimeException);
                        return Stream.of();
                    }
                }).toList();
    }
}
