package github.theworksofbh.buildersparadise.entities.types;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;

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

    public boolean canUseInFluid(FluidState fluidState) {
        return fluidState.is(FluidTags.WATER) || fluidState.is(FluidTags.LAVA);
    }

    @Override
    public float getWaterLevelAbove() {
        AABB aabb = this.getBoundingBox();
        int minX = Mth.floor(aabb.minX);
        int maxX = Mth.ceil(aabb.maxX);
        int minY = Mth.floor(aabb.maxY);
        int maxY = Mth.ceil(aabb.maxY - this.lastYd);
        int minZ = Mth.floor(aabb.minZ);
        int maxZ = Mth.ceil(aabb.maxZ);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        label39:
        for(int y = minY; y < maxY; ++y) {
            float blockHeight = 0.0F;

            for(int x = minX; x < maxX; ++x) {
                for(int z = minZ; z < maxZ; ++z) {
                    pos.set(x, y, z);
                    FluidState fluidState = this.level().getFluidState(pos);
                    if (this.canUseInFluid(fluidState)) {
                        blockHeight = Math.max(blockHeight, fluidState.getHeight(this.level(), pos));
                    }

                    if (blockHeight >= 1.0F) {
                        continue label39;
                    }
                }
            }

            if (blockHeight < 1.0F) {
                return (float)pos.getY() + blockHeight;
            }
        }

        return (float)(maxY + 1);
    }

    @Override
    public boolean checkInWater() {
        AABB bb = this.getBoundingBox();
        int minX = Mth.floor(bb.minX);
        int maxX = Mth.ceil(bb.maxX);
        int minY = Mth.floor(bb.minY);
        int maxY = Mth.ceil(bb.minY + 0.001);
        int minZ = Mth.floor(bb.minZ);
        int maxZ = Mth.ceil(bb.maxZ);
        boolean inWater = false;
        this.waterLevel = -Double.MAX_VALUE;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for(int x = minX; x < maxX; ++x) {
            for(int y = minY; y < maxY; ++y) {
                for(int z = minZ; z < maxZ; ++z) {
                    pos.set(x, y, z);
                    FluidState fluidState = this.level().getFluidState(pos);
                    if (canUseInFluid(fluidState)) {
                        float height = (float)y + fluidState.getHeight(this.level(), pos);
                        this.waterLevel = Math.max((double)height, this.waterLevel);
                        inWater |= bb.minY < (double)height;
                    }
                }
            }
        }

        return inWater;
    }

    @Override
    public @Nullable Status isUnderwater() {
        AABB aabb = this.getBoundingBox();
        double maxY = aabb.maxY + 0.001;
        int x0 = Mth.floor(aabb.minX);
        int x1 = Mth.ceil(aabb.maxX);
        int y0 = Mth.floor(aabb.maxY);
        int y1 = Mth.ceil(maxY);
        int z0 = Mth.floor(aabb.minZ);
        int z1 = Mth.ceil(aabb.maxZ);
        boolean underWater = false;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for(int x = x0; x < x1; ++x) {
            for(int y = y0; y < y1; ++y) {
                for(int z = z0; z < z1; ++z) {
                    pos.set(x, y, z);
                    FluidState fluidState = this.level().getFluidState(pos);
                    if (canUseInFluid(fluidState) && maxY < (double)((float)pos.getY() + fluidState.getHeight(this.level(), pos))) {
                        if (!fluidState.isSource()) {
                            return Status.UNDER_FLOWING_WATER;
                        }

                        underWater = true;
                    }
                }
            }
        }

        return underWater ? Status.UNDER_WATER : null;
    }
}
