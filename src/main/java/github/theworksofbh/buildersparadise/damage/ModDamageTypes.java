package github.theworksofbh.buildersparadise.damage;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

public class ModDamageTypes {
    public static ResourceKey<DamageType> registerKey(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(RADIATION, new DamageType("radiation", DamageScaling.NEVER, 0.0F, DamageEffects.HURT, DeathMessageType.DEFAULT));
    }

    public static final ResourceKey<DamageType> RADIATION = registerKey("radiation");
}
