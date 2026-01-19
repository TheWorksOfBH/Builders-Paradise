package github.theworksofbh.buildersparadise.recipes;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, BuildersParadise.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, BuildersParadise.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BaseFletchingRecipe>> BASE_FLETCHING_RECIPE_SERIALIZER = SERIALIZERS.register("base_fletching", BaseFletchingRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<TippedFletchingRecipe>> TIPPED_FLETCHING_RECIPE_SERIALIZER = SERIALIZERS.register("tipped_fletching", TippedFletchingRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<FletchingRecipe>> FLETCHING_RECIPE_TYPE = RECIPE_TYPES.register(
            "fletching", () -> new RecipeType<FletchingRecipe>() {
                @Override
                public String toString() {
                    return "fletching";
                }
            }
    );

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
}
