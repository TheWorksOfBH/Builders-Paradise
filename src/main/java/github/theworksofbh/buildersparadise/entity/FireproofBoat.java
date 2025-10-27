package github.theworksofbh.buildersparadise.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FireproofBoat extends Boat {
    public FireproofBoat(EntityType<? extends Boat> entityType, Level level, Supplier<Item> dropItem) {
        super(entityType, level, dropItem);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
}
