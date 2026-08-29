package github.theworksofbh.buildersparadise.particles;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import java.util.function.Function;

public class ModParticles {
    public static final SimpleParticleType IRON_FIRE_FLAME = register("iron_fire_flame", false);
    public static final SimpleParticleType ZINC_FIRE_FLAME = register("zinc_fire_flame", false);
    public static final SimpleParticleType SILVER_FIRE_FLAME = register("silver_fire_flame", false);
    public static final SimpleParticleType TIN_FIRE_FLAME = register("tin_fire_flame", false);
    public static final SimpleParticleType TUNGSTEN_FIRE_FLAME = register("tungsten_fire_flame", false);
    public static final SimpleParticleType PLATINUM_FIRE_FLAME = register("platinum_fire_flame", false);
    public static final SimpleParticleType GOLD_FIRE_FLAME = register("gold_fire_flame", false);
    public static final SimpleParticleType LEAD_FIRE_FLAME = register("lead_fire_flame", false);
    public static final SimpleParticleType BISMUTH_FIRE_FLAME = register("bismuth_fire_flame", false);
    public static final SimpleParticleType URANIUM_FIRE_FLAME = register("uranium_fire_flame", false);

    private static SimpleParticleType register(String name, boolean overrideLimiter) {
        return (SimpleParticleType)Registry.register(BuiltInRegistries.PARTICLE_TYPE, name, new SimpleParticleType(overrideLimiter) {});
    }

    private static <T extends ParticleOptions> ParticleType<T> register(String name, boolean overrideLimiter, final Function<ParticleType<T>, MapCodec<T>> codec, final Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> streamCodec) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, name, new ParticleType<T>(overrideLimiter) {
            public MapCodec<T> codec() {
                return codec.apply(this);
            }

            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodec.apply(this);
            }
        });
    }


    public static void initialize() {

    }
}
