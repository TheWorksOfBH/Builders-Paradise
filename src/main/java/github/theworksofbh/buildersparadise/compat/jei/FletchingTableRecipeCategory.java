package github.theworksofbh.buildersparadise.compat.jei;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.display.SlotDisplay;

import java.util.function.Supplier;

public class FletchingTableRecipeCategory extends RecipeHolderCategory<FletchingRecipe> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/gui/container/fletching.png");

    public static final Supplier<IRecipeHolderType<FletchingRecipe>> FLETCHING_RECIPE_TYPE = IRecipeHolderType.createDeferred(ModRecipes.FLETCHING_RECIPE_TYPE::get);

    private final IGuiHelper guiHelper;

    public FletchingTableRecipeCategory(IGuiHelper guiHelper) {
        super(
                FLETCHING_RECIPE_TYPE,
                Component.translatable("container.fletching"),
                guiHelper.createDrawable(TEXTURE, 38, 33, 102, 30),
                guiHelper.createDrawableItemStack(new ItemStack(Items.FLETCHING_TABLE))
        );
        this.guiHelper = guiHelper;
    }

    @Override
    public IRecipeType<RecipeHolder<FletchingRecipe>> getRecipeType() {
        return FLETCHING_RECIPE_TYPE.get();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<FletchingRecipe> recipe, IFocusGroup focuses) {
        FletchingRecipe fletchingRecipe = recipe.value();
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 6).add(fletchingRecipe.arrow());
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 6).add(fletchingRecipe.ingredient());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 6)
                .add(new SlotDisplay.ItemStackSlotDisplay(
                        ItemStackTemplate.fromNonEmptyStack(fletchingRecipe.output().create())
                ));
    }

    @Override
    public void draw(RecipeHolder<FletchingRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }
}
