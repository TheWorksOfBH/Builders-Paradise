package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MinecartJungleChest extends MinecartChest {

    public MinecartJungleChest(EntityType<? extends MinecartChest> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return (BlockState) ModBlocks.JUNGLE_CHEST.get().defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.JUNGLE_CHEST_MINECART.get();
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.JUNGLE_CHEST_MINECART.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("entity.minecraft.chest_minecart");
    }
}
