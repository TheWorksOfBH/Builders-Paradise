package github.theworksofbh.buildersparadise.mixins;

import net.minecraft.client.gui.screens.inventory.LoomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LoomScreen.class)
public class LoomScreenMixins {
    @ModifyConstant(method = "containerChanged", constant = @Constant(intValue = 6))
    private int maxBannerPattern(int orig) {
        return 16;
    }
}
