package github.theworksofbh.buildersparadise.compat.jei;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.function.Supplier;

public abstract class RecipeHolderCategory<T extends Recipe<?>> implements IRecipeCategory<RecipeHolder<T>> {
    private final Supplier<IRecipeHolderType<T>> typeSupplier;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    protected RecipeHolderCategory(Supplier<IRecipeHolderType<T>> typeSupplier, Component title, IDrawable background, IDrawable icon) {
        this.typeSupplier = typeSupplier;
        this.title = title;
        this.background = background;
        this.icon = icon;
    }

    public IRecipeType<RecipeHolder<T>> getRecipeType() {
        return typeSupplier.get();
    }

    public Component getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.background.getWidth();
    }

    public int getHeight() {
        return this.background.getHeight();
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void draw(RecipeHolder<T> recipe, IRecipeSlotsView view, GuiGraphics graphics, double mouseX, double mouseY) {
        this.background.draw(graphics);
    }
}
