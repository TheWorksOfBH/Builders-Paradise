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
import mezz.jei.api.constants.ModIds;
import mezz.jei.api.registration.*;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.*;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

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
        var specialFletchingRecipes = replaceSpecialFletchingRecipes(fletchingRecipes);

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

    public List<RecipeHolder<FletchingRecipe>> createTippedArrowJeiRecipes() {
        Ingredient arrowIngredient = Ingredient.of(Items.ARROW);
        Registry<Potion> potionRegistry = BuiltInRegistries.POTION;

        return potionRegistry.listElements().map(potion -> {
            ItemStack input = PotionContents.createItemStack(Items.LINGERING_POTION, potion);
            ItemStack output = PotionContents.createItemStack(Items.TIPPED_ARROW, potion);
            Ingredient potionIngredient = new Ingredient(new DataComponentIngredient(HolderSet.direct(input.typeHolder()), DataComponentPatch.builder().set(DataComponents.POTION_CONTENTS, new PotionContents(potion.getDelegate())).build(), false));
            ItemStackTemplate outputStack = ItemStackTemplate.fromNonEmptyStack(output);

            Identifier potionId = potion.key().identifier();
            Identifier recipeId = Identifier.fromNamespaceAndPath(ModIds.MINECRAFT_ID, "jei.tipped.arrow." + potionId.getNamespace() + "." + potionId.getPath());

            ResourceKey<Recipe<?>> resourceKey = ResourceKey.create(Registries.RECIPE, recipeId);

            FletchingRecipe recipe = new TippedFletchingRecipe(
                    arrowIngredient,
                    potionIngredient,
                    outputStack
            );

            return new RecipeHolder<>(resourceKey, recipe);
        }).toList();
    }

    private List<RecipeHolder<FletchingRecipe>> replaceSpecialFletchingRecipes(List<RecipeHolder<FletchingRecipe>> unhandledFletchingRecipes) {
        Map<Class<? extends FletchingRecipe>, Supplier<List<RecipeHolder<FletchingRecipe>>>> replacers = new IdentityHashMap<>();
        replacers.put(TippedFletchingRecipe.class, this::createTippedArrowJeiRecipes);

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
