package github.theworksofbh.buildersparadise.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FireproofChestBoat extends ChestBoat {
    public FireproofChestBoat(EntityType<? extends ChestBoat> entityType, Level level, Supplier<Item> dropItem) {
        super(entityType, level, dropItem);
    }


    @Override
    public boolean fireImmune() {
        return true;
    }
}
