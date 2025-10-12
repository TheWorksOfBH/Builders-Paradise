package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LoomBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LoomMenu.class)
public class LoomMenuMixins {

    @WrapOperation(method = "stillValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/LoomMenu;stillValid(Lnet/minecraft/world/inventory/ContainerLevelAccess;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean modifyStillValid(ContainerLevelAccess containerLevelAccess, Player player, Block targetBlock, Operation<Boolean> original){
        return original.call(
                containerLevelAccess, player, targetBlock)
                || containerLevelAccess.evaluate((world, pos) -> world.getBlockState(pos).getBlock() instanceof LoomBlock, true);
    } //Credits to LieOnLion for this code by the way
}
