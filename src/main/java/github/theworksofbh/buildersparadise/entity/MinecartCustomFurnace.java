package github.theworksofbh.buildersparadise.entity;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.minecart.MinecartFurnace;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MinecartCustomFurnace extends MinecartFurnace {
    public Block blockInside;
    public Item baseItem;

    public MinecartCustomFurnace(EntityType<? extends MinecartFurnace> entityType, Level level, Block blockInside, Item baseItem) {
        super(entityType, level);
        this.blockInside = blockInside;
        this.baseItem = baseItem;
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
    public BlockState getDefaultDisplayBlockState() {
        return (BlockState)((BlockState) blockInside.defaultBlockState().setValue(FurnaceBlock.FACING, Direction.NORTH)).setValue(FurnaceBlock.LIT, this.hasFuel());
    }
}
