package github.theworksofbh.buildersparadise.mixins;

import net.minecraft.world.item.crafting.BannerDuplicateRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BannerDuplicateRecipe.class)
public class BannerDuplicateRecipeMixins {

    @ModifyConstant(method = "matches(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/world/level/Level;)Z", constant = @Constant(intValue = 6))
    private int modifyBannerPatternLimit(int original) {
        return 16;
    }

    @ModifyConstant(method = "assemble(Lnet/minecraft/world/item/crafting/CraftingInput;)Lnet/minecraft/world/item/ItemStack;", constant = @Constant(intValue = 6))
    private int modifyBannerPatternMaxLimit(int original){
        return 16;
    }
}
