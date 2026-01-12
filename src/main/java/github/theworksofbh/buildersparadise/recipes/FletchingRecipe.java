package github.theworksofbh.buildersparadise.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;

import java.util.List;

public record FletchingRecipe(Ingredient arrow, Ingredient ingredient, ItemStack output) implements Recipe<FletchingRecipeInput> {

    @Override
    public boolean matches(FletchingRecipeInput fletchingRecipeInput, Level level) {
        return arrow.test(fletchingRecipeInput.getItem(0)) && ingredient.test(fletchingRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(FletchingRecipeInput fletchingRecipeInput, HolderLookup.Provider provider) {
        ItemStack itemStack = fletchingRecipeInput.getItem(1);
        if (itemStack.is(Items.LINGERING_POTION)) {
            ItemStack itemStack1 = new ItemStack(Items.TIPPED_ARROW, fletchingRecipeInput.getItem(0).getCount());
            itemStack1.set(DataComponents.POTION_CONTENTS, (PotionContents) itemStack.get(DataComponents.POTION_CONTENTS));
            return itemStack1;
        } else {
            return output.copy();
        }
    }

    @Override
    public RecipeSerializer<? extends Recipe<FletchingRecipeInput>> getSerializer() {
        return ModRecipes.FLETCHING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<FletchingRecipeInput>> getType() {
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
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return ModRecipeBookCategories.FLETCHING.get();
    }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(new FletchingRecipeDisplay(this.arrow().display(), this.ingredient().display(), this.resultDisplay(), new SlotDisplay.ItemSlotDisplay(Items.FLETCHING_TABLE)));
    }

    public SlotDisplay resultDisplay() {
        return new SlotDisplay.ItemStackSlotDisplay(this.output());
    }

    public static class Serializer implements RecipeSerializer<FletchingRecipe> {
        public static final MapCodec<FletchingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                fletchingRecipeInstance -> fletchingRecipeInstance.group(
                Ingredient.CODEC.fieldOf("arrow").forGetter(FletchingRecipe::arrow),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(FletchingRecipe::ingredient),
                ItemStack.CODEC.fieldOf("output").forGetter(FletchingRecipe::output)
        ).apply(fletchingRecipeInstance, FletchingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FletchingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, FletchingRecipe::arrow,
                Ingredient.CONTENTS_STREAM_CODEC, FletchingRecipe::ingredient,
                ItemStack.STREAM_CODEC, FletchingRecipe::output,
                FletchingRecipe::new
        );

        @Override
        public MapCodec<FletchingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FletchingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
