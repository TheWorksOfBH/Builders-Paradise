package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartChest.class)
public class MinecartChestMixins {
    @ModifyReturnValue(method = "getDropItem", at = @At("RETURN"))
    private Item modifyGetDropItem(Item original) {
        return ModItems.OAK_CHEST_MINECART.get();
    }

    @ModifyReturnValue(method = "getPickResult", at = @At("RETURN"))
    private ItemStack modifyGetPickResult(ItemStack original) {
        return new ItemStack(ModItems.OAK_CHEST_MINECART.get());
    }
}
