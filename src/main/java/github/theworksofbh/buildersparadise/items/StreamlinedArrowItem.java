package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.entity.StreamlinedArrow;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class StreamlinedArrowItem extends ArrowItem {
    public StreamlinedArrowItem(Properties properties) {
        super(properties);
    }

    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity owner, @Nullable ItemStack firedFromWeapon) {
        return new StreamlinedArrow(level, owner, itemStack.copyWithCount(1), firedFromWeapon);
    }

    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        StreamlinedArrow streamlinedArrow = new StreamlinedArrow(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1), (ItemStack)null);
        streamlinedArrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return streamlinedArrow;
    }

    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return false;
    }
}
