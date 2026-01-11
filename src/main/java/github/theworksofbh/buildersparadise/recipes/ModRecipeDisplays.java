package github.theworksofbh.buildersparadise.recipes;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeDisplays {
    public static final DeferredRegister<RecipeDisplay.Type<?>> RECIPE_DISPLAYS = DeferredRegister.create(Registries.RECIPE_DISPLAY, BuildersParadise.MODID);

    public static final DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<FletchingRecipeDisplay>> FLETCHING = register("fletching", FletchingRecipeDisplay.TYPE);

    private static <T extends RecipeDisplay> DeferredHolder<RecipeDisplay.Type<?>, RecipeDisplay.Type<T>> register(String name, RecipeDisplay.Type<T> type) {
        return RECIPE_DISPLAYS.register(name, () -> type);
    }

    public static void register(IEventBus bus) {
        RECIPE_DISPLAYS.register(bus);
    }
}
