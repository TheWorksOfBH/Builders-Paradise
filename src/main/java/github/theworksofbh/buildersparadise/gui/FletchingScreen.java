package github.theworksofbh.buildersparadise.gui;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class FletchingScreen extends AbstractContainerScreen<FletchingMenu> {
    private static final Identifier BG = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/gui/container/fletching.png");
    private static final Identifier ARROW_SLOT_SPRITE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "container/slot/arrow");
    private static final Identifier GLOWSTONE_POTION_SLOT_SPRITE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "container/slot/glowstone_potion");
    private static final Identifier ERROR_SPRITE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "container/fletching/error");

    public FletchingScreen(FletchingMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 166;
        this.imageWidth = 176;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int mouseX, int mouseY) {
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BG, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);

        Slot arrowSlot = ((FletchingMenu) this.menu).getArrowSlot();
        Slot ingredientSlot = ((FletchingMenu) this.menu).getIngredientSlot();
        Slot resultSlot = ((FletchingMenu) this.menu).getResultSlot();

        if (!arrowSlot.hasItem()){
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, ARROW_SLOT_SPRITE, i + arrowSlot.x, j + arrowSlot.y, 16, 16);
        }

        if (!ingredientSlot.hasItem()){
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, GLOWSTONE_POTION_SLOT_SPRITE, i + ingredientSlot.x, j + ingredientSlot.y, 16, 16);
        }

        if (!arrowSlot.hasItem() || !ingredientSlot.hasItem()) {
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, ERROR_SPRITE, i + resultSlot.x - 33, j + resultSlot.y - 2, 28, 21);
        }
    }
}
