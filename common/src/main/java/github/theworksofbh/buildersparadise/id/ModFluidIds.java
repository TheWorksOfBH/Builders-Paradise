package github.theworksofbh.buildersparadise.id;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.Fluid;

public class ModFluidIds {
    public static final ResourceKey<Fluid> NUCLEAR_WASTE = create("nuclear_waste");
    public static final ResourceKey<Fluid> FLOWING_NUCLEAR_WASTE = create("flowing_nuclear_waste");

    private static ResourceKey<Fluid> create(final String name) {
        return ResourceKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }
}
