package github.theworksofbh.buildersparadise.effect;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModEffects {

    public static final Holder<MobEffect> IRRADIATION = register("irradiation", new IrradiationEffect(MobEffectCategory.HARMFUL, 3534951));

    private static Holder<MobEffect> register(final String name, final MobEffect mobEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name), mobEffect);
    }

    public static void initialize() {

    }
}
