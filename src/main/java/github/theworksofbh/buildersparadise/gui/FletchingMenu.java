package github.theworksofbh.buildersparadise.gui;

import github.theworksofbh.buildersparadise.block.FletchingTableBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LingeringPotionItem;

public class FletchingMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final Container inputContainer;
    private final Container outputContainer;
    Runnable slotUpdateListener;
    long lastSoundTime;

    public static final int INPUT_SLOT_1 = 0;
    public static final int INPUT_SLOT_2 = 1;
    public static final int RESULT_SLOT = 0;

    private final Slot arrowSlot;
    private final Slot ingredientSlot;
    private final Slot resultSlot;

    public FletchingMenu(int containerId, Inventory inventory, final ContainerLevelAccess access) {
        super(ModMenuTypes.FLETCHING_MENU.get(), containerId);
        this.slotUpdateListener = () -> {
        };
        this.inputContainer = new SimpleContainer(2) {
            @Override
            public void setChanged() {
                super.setChanged();
                FletchingMenu.this.slotsChanged(this);
                FletchingMenu.this.slotUpdateListener.run();
            }
        };
        this.outputContainer = new SimpleContainer(1) {
            @Override
            public void setChanged() {
                super.setChanged();
                FletchingMenu.this.slotUpdateListener.run();
            }
        };
        this.access = access;
        this.arrowSlot = this.addSlot(new Slot(inputContainer, INPUT_SLOT_1, 44, 39) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ArrowItem;
            }
        });
        this.ingredientSlot = this.addSlot(new Slot(inputContainer, INPUT_SLOT_2, 62, 39) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                if (stack.getItem() instanceof LingeringPotionItem || stack.getItem() == Items.GLOWSTONE_DUST) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        this.resultSlot = this.addSlot(new Slot(outputContainer, RESULT_SLOT, 116, 39) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);

                access.execute((p_393252_, p_393253_) -> {
                    long i = p_393252_.getGameTime();
                    if (FletchingMenu.this.lastSoundTime != i) {
                        p_393252_.playSound(null, p_393253_, SoundEvents.VILLAGER_WORK_FLETCHER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        FletchingMenu.this.lastSoundTime = i;
                    }
                });
            }
        });

        this.addStandardInventorySlots(inventory, 8, 84);
    }

    public FletchingMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == this.resultSlot.index) {
                if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index != this.ingredientSlot.index && index != this.arrowSlot.index) {
                if (itemstack1.getItem() instanceof ArrowItem) {
                    if (!this.moveItemStackTo(itemstack1, this.arrowSlot.index, this.arrowSlot.index + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (itemstack1.getItem() instanceof LingeringPotionItem || itemstack1.getItem() == Items.GLOWSTONE_DUST) {
                    if (!this.moveItemStackTo(itemstack1, this.ingredientSlot.index, this.ingredientSlot.index + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 4, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((level, pos) -> level.getBlockState(pos).getBlock() instanceof FletchingTableBlock, true);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute(((level, blockPos) -> this.clearContainer(player, this.inputContainer)));
    }


    public Slot getArrowSlot() {
        return arrowSlot;
    }

    public Slot getIngredientSlot() {
        return ingredientSlot;
    }

    public Slot getResultSlot() {
        return resultSlot;
    }
}
