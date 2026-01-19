package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.entity.ExplosiveArrow;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class ExplosiveArrowItem extends ArrowItem {
    public ExplosiveArrowItem(Properties properties) {
        super(properties);
    }

    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity owner, @Nullable ItemStack firedFromWeapon) {
        return new ExplosiveArrow(level, owner, itemStack.copyWithCount(1), firedFromWeapon);
    }

    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ExplosiveArrow explosiveArrow = new ExplosiveArrow(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1), (ItemStack)null);
        explosiveArrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return explosiveArrow;
    }

    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return false;
    }
}
