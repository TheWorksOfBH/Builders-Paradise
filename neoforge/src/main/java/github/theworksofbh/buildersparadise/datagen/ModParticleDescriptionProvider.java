package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider {
    public ModParticleDescriptionProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void addDescriptions() {
        this.spriteSet(ModParticles.IRON_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "iron_fire_flame"));
        this.spriteSet(ModParticles.ZINC_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "zinc_fire_flame"));
        this.spriteSet(ModParticles.SILVER_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "silver_fire_flame"));
        this.spriteSet(ModParticles.TIN_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "tin_fire_flame"));
        this.spriteSet(ModParticles.TUNGSTEN_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "tungsten_fire_flame"));
        this.spriteSet(ModParticles.PLATINUM_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "platinum_fire_flame"));
        this.spriteSet(ModParticles.GOLD_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "gold_fire_flame"));
        this.spriteSet(ModParticles.LEAD_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "lead_fire_flame"));
        this.spriteSet(ModParticles.BISMUTH_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "bismuth_fire_flame"));
        this.spriteSet(ModParticles.URANIUM_FIRE_FLAME, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "uranium_fire_flame"));
    }
}