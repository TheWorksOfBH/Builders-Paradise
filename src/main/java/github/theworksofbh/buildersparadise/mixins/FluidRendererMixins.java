package github.theworksofbh.buildersparadise.mixins;

import github.theworksofbh.buildersparadise.entity.FireproofBoat;
import github.theworksofbh.buildersparadise.entity.FireproofChestBoat;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FluidRenderer.class)
public class FluidRendererMixins {
    @Unique
    private boolean hasFireproofBoatAbove(BlockAndTintGetter level, BlockPos pos) {
        if (!(level instanceof Level realLevel)) {
            return false;
        }

        AABB checkBox = new AABB(pos).inflate(0.1, 1.5, 0.1);

        return !realLevel.getEntitiesOfClass(
                FireproofBoat.class,
                checkBox
        ).isEmpty();
    }

    @Unique
    private boolean hasFireproofChestBoatAbove(BlockAndTintGetter level, BlockPos pos) {
        if (!(level instanceof Level realLevel)) {
            return false;
        }

        AABB checkBox = new AABB(pos).inflate(0.1, 1.5, 0.1);

        return !realLevel.getEntitiesOfClass(
                FireproofChestBoat.class,
                checkBox
        ).isEmpty();
    }



    @Redirect(method = "tesselate", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/FluidRenderer;isNeighborSameFluid(Lnet/minecraft/world/level/material/FluidState;Lnet/minecraft/world/level/material/FluidState;)Z"))
    private boolean preventLavaInsideBoat(FluidState fluidState, FluidState neighborFluidState, BlockAndTintGetter level, BlockPos pos) {
        boolean original = neighborFluidState.getType().isSame(fluidState.getType());

        if (!fluidState.is(FluidTags.LAVA)) {
            return original;
        }

        if (level instanceof Level realLevel) {
            AABB box = new AABB(pos).inflate(0.2, 1.0, 0.2);

            boolean hasBoat = !realLevel.getEntitiesOfClass(
                    Boat.class,
                    box,
                    boat -> boat.fireImmune()
            ).isEmpty();

            if (hasBoat) {
                return true;
            }
        }

        return original;
    }
}
