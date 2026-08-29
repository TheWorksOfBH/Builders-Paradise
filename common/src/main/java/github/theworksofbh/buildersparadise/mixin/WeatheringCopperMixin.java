package github.theworksofbh.buildersparadise.mixin;

import com.google.common.collect.ImmutableBiMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WeatheringCopper.class)
public interface WeatheringCopperMixin {

    @WrapOperation(method = "lambda$static$0", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableBiMap$Builder;build()Lcom/google/common/collect/ImmutableBiMap;"))
    private static ImmutableBiMap<Block, Block> addBPWeatheringBlocks(ImmutableBiMap.Builder<Block, Block> builder, Operation<ImmutableBiMap<Block, Block>> original) {
        ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().progressMapping(builder::put);
        ModBlocks.COPPER_SOUL_LANTERN.weathering().progressMapping(builder::put);
        ModBlocks.COPPER_FIRE_LANTERN.weathering().progressMapping(builder::put);
        return original.call(builder);
    }
}
