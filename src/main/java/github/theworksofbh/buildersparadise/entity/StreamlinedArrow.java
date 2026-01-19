package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class StreamlinedArrow extends AbstractArrow {
    public StreamlinedArrow(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public StreamlinedArrow(Level level, LivingEntity owner, ItemStack itemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.STREAMLINED_ARROW.get(), owner, level, itemStack, firedFromWeapon);
    }

    public StreamlinedArrow(Level level, double x, double y, double z, ItemStack itemStack, ItemStack itemStack1) {
        super(ModEntities.STREAMLINED_ARROW.get(), x, y, z, level, itemStack, itemStack1);
    }

    @Override
    public ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.STREAMLINED_ARROW.get());
    }

    @Override
    protected double getDefaultGravity() {
        return 0;
    }
}
