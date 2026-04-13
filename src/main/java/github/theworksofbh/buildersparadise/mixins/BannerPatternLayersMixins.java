package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(BannerPatternLayers.class)
public class BannerPatternLayersMixins {
    @Shadow
    @Final
    private List<BannerPatternLayers.Layer> layers;

    @Definition(id = "min", method = "Ljava/lang/Math;min(II)I")
    @Definition(id = "layers", method = "Lnet/minecraft/world/level/block/entity/BannerPatternLayers;layers()Ljava/util/List;")
    @Definition(id = "size", method = "Ljava/util/List;size()I")
    @Expression("min(this.layers().size(), 6)")
    @ModifyExpressionValue(method = "addToTooltip", at = @At(value = "MIXINEXTRAS:EXPRESSION", target = "Math.min(this.layers().size(), 6)"))
    private int modifyAddToTooltip(int original) {
        return Math.min(this.layers.size(), 16);
    }
}
