package github.theworksofbh.buildersparadise.effect;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, BuildersParadise.MODID);

    public static final Holder<MobEffect> IRRADIATION_EFFECT = MOB_EFFECTS.register("irradiation",
            () -> new IrradiationEffect(
                    MobEffectCategory.HARMFUL,
                    0x35f067
            ));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
