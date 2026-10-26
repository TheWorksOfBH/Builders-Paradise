package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.client.particle.FlameParticle;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

public class NeoForgeParticleEvent {
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.IRON_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.IRON_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.ZINC_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.ZINC_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SILVER_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.SILVER_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.TIN_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.TIN_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.TUNGSTEN_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.TUNGSTEN_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.PLATINUM_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.PLATINUM_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.GOLD_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.GOLD_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.LEAD_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.LEAD_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.BISMUTH_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.BISMUTH_FIRE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(ModParticles.URANIUM_FIRE_FLAME, FlameParticle.SmallFlameProvider::new);
        event.registerSpriteSet(ModParticles.URANIUM_FIRE_FLAME, FlameParticle.Provider::new);


    }
}
