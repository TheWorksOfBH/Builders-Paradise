package github.theworksofbh.buildersparadise.mixins;

import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SmithingMenu.class)
public class SmithingMenuMixins {

    @Inject(method = "isValidBlock", at = @At("HEAD"), cancellable = true)
    private void isValidBlock(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof SmithingTableBlock) {
            cir.setReturnValue(true);
        }
    } //Credits to LieOnLion for this code by the way
}
