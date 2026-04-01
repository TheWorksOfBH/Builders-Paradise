package github.theworksofbh.buildersparadise.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class TippedFletchingRecipe extends BaseFletchingRecipe {
    final Ingredient arrow;
    final Ingredient ingredient;
    final ItemStackTemplate output;

    public TippedFletchingRecipe(Ingredient arrow, Ingredient ingredient, ItemStackTemplate output) {
        super(arrow, ingredient, output);
        this.arrow = arrow;
        this.ingredient = ingredient;
        this.output = output;
    }


    @Override
    public boolean matches(FletchingRecipeInput fletchingRecipeInput, Level level) {
        return arrow.test(fletchingRecipeInput.getItem(0)) && ingredient.test(fletchingRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(FletchingRecipeInput fletchingRecipeInput) {
        ItemStack itemStack = fletchingRecipeInput.getItem(1);
        ItemStack itemStack1 = new ItemStack(Items.TIPPED_ARROW, fletchingRecipeInput.getItem(0).getCount());
        itemStack1.set(DataComponents.POTION_CONTENTS, (PotionContents) itemStack.get(DataComponents.POTION_CONTENTS));
        return itemStack1;
    }

    @Override
    public RecipeSerializer<? extends Recipe<FletchingRecipeInput>> getSerializer() {
        return ModRecipes.TIPPED_FLETCHING_RECIPE_SERIALIZER.get();
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
    public ItemStackTemplate output() {
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

    public static final MapCodec<TippedFletchingRecipe> CODEC = RecordCodecBuilder.mapCodec(
            fletchingRecipeInstance -> fletchingRecipeInstance.group(
                    Ingredient.CODEC.fieldOf("arrow").forGetter(TippedFletchingRecipe::arrow),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(TippedFletchingRecipe::ingredient),
                    ItemStackTemplate.CODEC.fieldOf("output").forGetter(TippedFletchingRecipe::output)
            ).apply(fletchingRecipeInstance, TippedFletchingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, TippedFletchingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, TippedFletchingRecipe::arrow,
            Ingredient.CONTENTS_STREAM_CODEC, TippedFletchingRecipe::ingredient,
            ItemStackTemplate.STREAM_CODEC, TippedFletchingRecipe::output,
            TippedFletchingRecipe::new
    );

    public static final RecipeSerializer<TippedFletchingRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);
}
