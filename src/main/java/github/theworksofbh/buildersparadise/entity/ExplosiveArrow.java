package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrow extends AbstractArrow {
    public ExplosiveArrow(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public ExplosiveArrow(Level level, LivingEntity owner, ItemStack itemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.EXPLOSIVE_ARROW.get(), owner, level, itemStack, firedFromWeapon);
    }

    public ExplosiveArrow(Level level, double x, double y, double z, ItemStack itemStack, ItemStack itemStack1) {
        super(ModEntities.EXPLOSIVE_ARROW.get(), x, y, z, level, itemStack, itemStack1);
    }

    @Override
    public ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.EXPLOSIVE_ARROW.get());
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide()) {
            explode();
            this.discard();
        }
    }

    private void explode() {
        level().explode(
                this,
                this.getX(),
                this.getY(),
                this.getZ(),
                2.5F,
                Level.ExplosionInteraction.MOB
        );
    }
}
