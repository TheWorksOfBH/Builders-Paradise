package github.theworksofbh.buildersparadise.gui;

import github.theworksofbh.buildersparadise.block.FletchingTableBlock;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipe;
import github.theworksofbh.buildersparadise.recipes.FletchingRecipeInput;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Optional;

public class FletchingMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final Container inputContainer;
    private final ResultContainer outputContainer;
    Runnable slotUpdateListener = () -> {
    };
    private final Level level;
    private FletchingRecipe currentRecipe;
    long lastSoundTime;
    private final Player player;

    public static final int ARROW_SLOT = 0;
    public static final int INGREDIENT_SLOT = 1;
    public static final int RESULT_SLOT = 2;

    public FletchingMenu(int containerId, Inventory inventory, final ContainerLevelAccess access) {
        super(ModMenuTypes.FLETCHING_MENU.get(), containerId);
        this.inputContainer = new SimpleContainer(2) {
            @Override
            public void setChanged() {
                super.setChanged();
                FletchingMenu.this.slotsChanged(this);
                FletchingMenu.this.slotUpdateListener.run();
            }
        };
        this.addArrowSlot();
        this.addIngredientSlot();
        this.outputContainer = new ResultContainer() {
            @Override
            public void setChanged() {
                super.setChanged();
                FletchingMenu.this.slotsChanged(this);
                FletchingMenu.this.slotUpdateListener.run();
            }
        };
        this.addResultSlot();
        this.access = access;
        this.level = inventory.player.level();
        this.addStandardInventorySlots(inventory, 8, 84);
        this.player = inventory.player;

    }

    public FletchingMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    protected void addArrowSlot() {
        this.addSlot(new Slot(inputContainer, ARROW_SLOT, 44, 39) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ArrowItem;
            }
        });
    }

    protected void addIngredientSlot() {
        this.addSlot(new Slot(inputContainer, INGREDIENT_SLOT, 62, 39) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                if (stack.getItem() instanceof LingeringPotionItem || stack.getItem() == Items.GLOWSTONE_DUST) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    protected void addResultSlot() {
        this.addSlot(new Slot(outputContainer, RESULT_SLOT, 116, 39){
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

                ItemStack arrowStack = FletchingMenu.this.inputContainer.getItem(ARROW_SLOT);
                ItemStack ingredientStack = FletchingMenu.this.inputContainer.getItem(INGREDIENT_SLOT);

                if (!arrowStack.isEmpty() && !ingredientStack.isEmpty()) {
                    Item ingredientItem = ingredientStack.getItem();

                    if (ingredientItem == Items.LINGERING_POTION) {
                        arrowStack.shrink(arrowStack.getCount());
                        ingredientStack.shrink(1);
                    } else if (ingredientItem == Items.GLOWSTONE_DUST) {
                        arrowStack.shrink(1);
                        ingredientStack.shrink(1);
                    }
                }
            }
        });
    }

    @Override
    public void slotsChanged(Container container) {
        super.slotsChanged(container);
        this.access.execute(((level1, blockPos) -> {
            if (level1 instanceof ServerLevel serverLevel) {
                slotsChangedFletchingMenu(this, serverLevel, player, null);
            }
        }));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();
            if (index == this.getResultSlot().getSlotIndex()) {
                if (!this.moveItemStackTo(stackInSlot, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onTake(player, stackInSlot);
            } else if (index != this.getIngredientSlot().getSlotIndex() && index != this.getArrowSlot().getSlotIndex()) {
                if (stackInSlot.getItem() instanceof ArrowItem) {
                    if (!this.moveItemStackTo(stackInSlot, this.getArrowSlot().getSlotIndex(), this.getArrowSlot().getSlotIndex() + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (stackInSlot.getItem() instanceof LingeringPotionItem || stackInSlot.getItem() == Items.GLOWSTONE_DUST) {
                    if (!this.moveItemStackTo(stackInSlot, this.getIngredientSlot().getSlotIndex(), this.getIngredientSlot().getSlotIndex() + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(stackInSlot, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stackInSlot.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
        }

        return itemstack;
    }

    protected void slotsChangedFletchingMenu(AbstractContainerMenu menu, ServerLevel level, Player player, @Nullable RecipeHolder<FletchingRecipe> recipe) {
        ItemStack arrowSlot = this.getArrowSlot().getItem();
        ItemStack ingredientSlot = this.getIngredientSlot().getItem();

        FletchingRecipeInput fletchingRecipeInput = new FletchingRecipeInput(arrowSlot, ingredientSlot);
        ServerPlayer serverPlayer = (ServerPlayer) player;
        ItemStack itemStack = ItemStack.EMPTY;

        Optional<RecipeHolder<FletchingRecipe>> optional = level.getServer().getRecipeManager().getRecipeFor(ModRecipes.FLETCHING_RECIPE_TYPE.get(), fletchingRecipeInput, level, recipe);
        if (optional.isPresent()) {
            RecipeHolder<FletchingRecipe> recipeHolder = optional.get();
            FletchingRecipe fletchingRecipe = recipeHolder.value();
            ItemStack itemStack1 = fletchingRecipe.assemble(fletchingRecipeInput, level.registryAccess());
            if (itemStack1.isItemEnabled(level.enabledFeatures())) {
                itemStack = itemStack1;
            }
        }

        outputContainer.setItem(this.getResultSlot().getSlotIndex(), itemStack);
        menu.setRemoteSlot(this.getResultSlot().getSlotIndex(), itemStack);
        serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), this.getResultSlot().getSlotIndex(), itemStack));
    }

    public Slot getArrowSlot() {
        return this.getSlot(ARROW_SLOT);
    }

    public Slot getIngredientSlot() {
        return this.getSlot(INGREDIENT_SLOT);
    }

    public Slot getResultSlot() {
        return this.getSlot(RESULT_SLOT);
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
}
