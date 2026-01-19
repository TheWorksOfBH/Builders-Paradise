package github.theworksofbh.buildersparadise.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class BaseFletchingRecipe implements FletchingRecipe {
    final Ingredient arrow;
    final Ingredient ingredient;
    final ItemStack output;

    public BaseFletchingRecipe(Ingredient arrow, Ingredient ingredient, ItemStack output) {
        this.arrow = arrow;
        this.ingredient = ingredient;
        this.output = output;
    }


    @Override
    public boolean matches(FletchingRecipeInput fletchingRecipeInput, Level level) {
        return arrow.test(fletchingRecipeInput.getItem(0)) && ingredient.test(fletchingRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(FletchingRecipeInput fletchingRecipeInput, HolderLookup.Provider provider) {
        return output.copy();

    }

    @Override
    public RecipeSerializer<? extends Recipe<FletchingRecipeInput>> getSerializer() {
        return ModRecipes.BASE_FLETCHING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<FletchingRecipe> getType() {
        return ModRecipes.FLETCHING_RECIPE_TYPE.get();
    }

    @Override
    public Ingredient arrow() {
        return arrow;
    }

    @Override
    public Ingredient ingredient() {
        return ingredient;
    }

    @Override
    public ItemStack output() {
        return output;
    }

    @Override
    public @NonNull PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public @NonNull RecipeBookCategory recipeBookCategory() {
        return ModRecipeBookCategories.FLETCHING.get();
    }

    @Override
    public @NonNull List<RecipeDisplay> display() {
        return List.of(new FletchingRecipeDisplay(this.arrow().display(), this.ingredient().display(), this.resultDisplay(), new SlotDisplay.ItemSlotDisplay(Items.FLETCHING_TABLE)));
    }

    public SlotDisplay resultDisplay() {
        return new SlotDisplay.ItemStackSlotDisplay(this.output());
    }

    public static class Serializer implements RecipeSerializer<BaseFletchingRecipe> {
        public static final MapCodec<BaseFletchingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                fletchingRecipeInstance -> fletchingRecipeInstance.group(
                Ingredient.CODEC.fieldOf("arrow").forGetter(BaseFletchingRecipe::arrow),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(BaseFletchingRecipe::ingredient),
                ItemStack.CODEC.fieldOf("output").forGetter(BaseFletchingRecipe::output)
        ).apply(fletchingRecipeInstance, BaseFletchingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BaseFletchingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, BaseFletchingRecipe::arrow,
                Ingredient.CONTENTS_STREAM_CODEC, BaseFletchingRecipe::ingredient,
                ItemStack.STREAM_CODEC, BaseFletchingRecipe::output,
                BaseFletchingRecipe::new
        );

        @Override
        public MapCodec<BaseFletchingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BaseFletchingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
