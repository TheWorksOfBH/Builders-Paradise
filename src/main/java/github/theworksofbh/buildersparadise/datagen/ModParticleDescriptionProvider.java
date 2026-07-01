package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider {
    protected ModParticleDescriptionProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void addDescriptions() {
        this.spriteSet(ModParticles.IRON_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "iron_fire_flame"));
        this.spriteSet(ModParticles.ZINC_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "zinc_fire_flame"));
        this.spriteSet(ModParticles.SILVER_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "silver_fire_flame"));
        this.spriteSet(ModParticles.TIN_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "tin_fire_flame"));
        this.spriteSet(ModParticles.TUNGSTEN_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "tungsten_fire_flame"));
        this.spriteSet(ModParticles.PLATINUM_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "platinum_fire_flame"));
        this.spriteSet(ModParticles.GOLD_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "gold_fire_flame"));
        this.spriteSet(ModParticles.LEAD_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "lead_fire_flame"));
        this.spriteSet(ModParticles.BISMUTH_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bismuth_fire_flame"));
        this.spriteSet(ModParticles.URANIUM_FIRE_FLAME.get(), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "uranium_fire_flame"));
    }
}
