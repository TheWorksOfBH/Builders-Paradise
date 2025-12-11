package github.theworksofbh.buildersparadise.entity;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.minecart.MinecartChest;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MinecartCustomChest extends MinecartChest {
    public Block blockInside;
    public Item baseItem;

    public MinecartCustomChest(EntityType<? extends MinecartChest> entityType, Level level, Block blockInside, Item baseItem) {
        super(entityType, level);
        this.blockInside = blockInside;
        this.baseItem = baseItem;
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return (BlockState) blockInside.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }

    @Override
    protected Item getDropItem() {
        return baseItem;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(baseItem);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("entity.minecraft.chest_minecart");
    }
}
