package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.MinecartFurnace;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlackstoneMinecartFurnace extends MinecartFurnace {
    public BlackstoneMinecartFurnace(EntityType<? extends MinecartFurnace> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.BLACKSTONE_FURNACE_MINECART.get();
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.BLACKSTONE_FURNACE_MINECART.get());
    }

    @Override
    public BlockState getDefaultDisplayBlockState() {
        return (BlockState)((BlockState) ModBlocks.BLACKSTONE_FURNACE.get().defaultBlockState().setValue(FurnaceBlock.FACING, Direction.NORTH)).setValue(FurnaceBlock.LIT, this.hasFuel());
    }
}
