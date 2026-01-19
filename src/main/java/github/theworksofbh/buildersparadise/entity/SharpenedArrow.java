package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class SharpenedArrow extends AbstractArrow {
    public SharpenedArrow(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public SharpenedArrow(Level level, LivingEntity owner, ItemStack itemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.SHARPENED_ARROW.get(), owner, level, itemStack, firedFromWeapon);
    }

    public SharpenedArrow(Level level, double x, double y, double z, ItemStack itemStack, ItemStack itemStack1) {
        super(ModEntities.SHARPENED_ARROW.get(), x, y, z, level, itemStack, itemStack1);
    }

    @Override
    public ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.SHARPENED_ARROW.get());
    }

    @Override
    protected void onHitBlock(BlockHitResult hit) {
        super.onHitBlock(hit);

        if (level().isClientSide()) return;

        BlockPos pos = hit.getBlockPos();
        BlockState state = level().getBlockState(pos);

        if (state.is(ModBlockTags.SHATTERABLE_BY_SHARPENED_ARROW)) {
            shatterBlock(pos, state);
        }
    }

    private void shatterBlock(BlockPos pos, BlockState state) {
        level().levelEvent(2001, pos, Block.getId(state));

        level().destroyBlock(pos, shouldDrop(), this);

        this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
    }

    private boolean shouldDrop() {
        Entity owner = this.getOwner();

        if (owner instanceof Player player) {
            return !player.getAbilities().instabuild;
        }

        return true;
    }
}
