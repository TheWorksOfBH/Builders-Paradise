package github.theworksofbh.buildersparadise.mixin;

import github.theworksofbh.buildersparadise.blocks.types.SiliceneBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedStoneWireBlock.class)
public class RedStoneWireBlockMixin {

    @Inject(method = "shouldConnectTo", at = @At("HEAD"), cancellable = true)
    private static void connectToSilicene(BlockState blockState, @Nullable Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.getBlock() instanceof SiliceneBlock) {
            cir.setReturnValue(true);
        }
    }
}
