package github.theworksofbh.buildersparadise.compat;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.Nullable;

public class FletchingTableRecipeCategory implements IRecipeCategory<FletchingRecipe> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/gui/container/fletching.png");
    public static final Identifier UID = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "fletching");

    public static final IRecipeType<FletchingRecipe> FLETCHING_RECIPE_TYPE = new IRecipeType<FletchingRecipe>() {
        @Override
        public Identifier getUid() {
            return UID;
        }

        @Override
        public Class<? extends FletchingRecipe> getRecipeClass() {
            return FletchingRecipe.class;
        }
    };

    private final IDrawable background;
    private final IDrawable icon;
    private int width = 176;
    private int height = 85;

    public FletchingTableRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, width, height);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.FLETCHING_TABLE));
    }

    @Override
    public IRecipeType<FletchingRecipe> getRecipeType() {
        return FLETCHING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.fletching");
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FletchingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 39).add(recipe.arrow()).setStandardSlotBackground();
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 39).add(recipe.ingredient()).setStandardSlotBackground();
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 39).add(recipe.output()).setOutputSlotBackground();
    }

    @Override
    public void draw(FletchingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        background.draw(guiGraphics);
    }
}
