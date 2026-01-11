package github.theworksofbh.buildersparadise.recipes;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeBookCategories {
    public static final DeferredRegister<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = DeferredRegister.create(Registries.RECIPE_BOOK_CATEGORY, BuildersParadise.MODID);

    public static final DeferredHolder<RecipeBookCategory, RecipeBookCategory> FLETCHING = register("fletching");

    private static DeferredHolder<RecipeBookCategory, RecipeBookCategory> register(String name) {
        return RECIPE_BOOK_CATEGORIES.register(name, () -> new RecipeBookCategory());
    }

    public static void register(IEventBus bus) {
        RECIPE_BOOK_CATEGORIES.register(bus);
    }
}
