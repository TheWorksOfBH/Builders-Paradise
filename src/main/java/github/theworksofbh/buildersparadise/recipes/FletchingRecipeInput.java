package github.theworksofbh.buildersparadise.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record FletchingRecipeInput(ItemStack arrow, ItemStack ingredient) implements RecipeInput {
    public FletchingRecipeInput(ItemStack arrow, ItemStack ingredient) {
        this.arrow = arrow;
        this.ingredient = ingredient;
    }


    @Override
    public ItemStack getItem(int i) {
        ItemStack itemStack;
        switch (i) {
            case 0 -> itemStack = this.arrow;
            case 1 -> itemStack = this.ingredient;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + i);
        }

        return itemStack;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public ItemStack arrow() {
        return this.arrow;
    }

    @Override
    public ItemStack ingredient() {
        return this.ingredient;
    }
}
