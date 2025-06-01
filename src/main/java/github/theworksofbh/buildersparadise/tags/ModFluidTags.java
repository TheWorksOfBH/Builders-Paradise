package github.theworksofbh.buildersparadise.tags;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public final class ModFluidTags {

    public static final TagKey<Fluid> NUCLEAR_WASTE = create("nuclear_waste");


    private ModFluidTags() {
    }

    private static TagKey<Fluid> create(String name) {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static TagKey<Fluid> create(ResourceLocation name) {
        return TagKey.create(Registries.FLUID, name);
    }
}
