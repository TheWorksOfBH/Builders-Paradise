package github.theworksofbh.buildersparadise.tags;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModFluidTags {
    public static final TagKey<Fluid> NUCLEAR_WASTE = create("nuclear_waste");


    private ModFluidTags() {
    }

    private static TagKey<Fluid> create(String name) {
        return TagKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }

    public static TagKey<Fluid> create(Identifier name) {
        return TagKey.create(Registries.FLUID, name);
    }
}
