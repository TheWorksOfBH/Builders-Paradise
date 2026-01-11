package github.theworksofbh.buildersparadise.particles;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, BuildersParadise.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> IRON_FIRE_FLAME = register("iron_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ZINC_FIRE_FLAME = register("zinc_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SILVER_FIRE_FLAME = register("silver_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TIN_FIRE_FLAME = register("tin_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TUNGSTEN_FIRE_FLAME = register("tungsten_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PLATINUM_FIRE_FLAME = register("platinum_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GOLD_FIRE_FLAME = register("gold_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEAD_FIRE_FLAME = register("lead_fire_flame", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> URANIUM_FIRE_FLAME = register("uranium_fire_flame", false);

    private static DeferredHolder<ParticleType<?>, SimpleParticleType> register(String key, boolean overrideLimiter) {
        return PARTICLES.register(key, () -> new SimpleParticleType(overrideLimiter));
    }

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
