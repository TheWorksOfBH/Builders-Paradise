package github.theworksofbh.buildersparadise.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Supplier;

public class FireproofChestBoat extends ChestBoat {
    public FireproofChestBoat(EntityType<? extends ChestBoat> entityType, Level level, Supplier<Item> dropItem) {
        super(entityType, level, dropItem);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean canBoatInFluid(FluidType type) {
        return super.canBoatInFluid(type) || type.equals(Fluids.LAVA.getFluidType());
    }

    @Override
    public boolean canBoatInFluid(FluidState state) {
        return super.canBoatInFluid(state) || state.getFluidType().equals(Fluids.LAVA.getFluidType());
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            for (Entity passenger : this.getPassengers()) {
                if (passenger instanceof LivingEntity livingEntity) {
                    if (this.isInLava() || this.isOnFire()) {
                        livingEntity.clearFire();
                        livingEntity.setTicksFrozen(0);
                        if (livingEntity.level().isClientSide()) {
                            livingEntity.setRemainingFireTicks(0);
                        }
                        livingEntity.setSharedFlagOnFire(false);
                    }
                } else if (passenger instanceof Player player) {
                    if (this.isInLava() || this.isOnFire()) {
                        player.clearFire();
                        player.setTicksFrozen(0);
                        if (player.level().isClientSide()) {
                            player.setRemainingFireTicks(0);
                        }
                        player.setSharedFlagOnFire(false);
                    }
                }
            }
        }
    }
}
