package github.theworksofbh.buildersparadise.fluids;

import github.theworksofbh.buildersparadise.fluids.types.NuclearWasteFluid;
import github.theworksofbh.buildersparadise.id.ModFluidIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class ModFluids {

    public static final FlowingFluid FLOWING_NUCLEAR_WASTE = register(ModFluidIds.FLOWING_NUCLEAR_WASTE, new NuclearWasteFluid.Flowing());
    public static final FlowingFluid NUCLEAR_WASTE = register(ModFluidIds.NUCLEAR_WASTE, new NuclearWasteFluid.Source());

    private static <T extends Fluid> T register(final ResourceKey<Fluid> id, final T fluid) {
        return Registry.register(BuiltInRegistries.FLUID, id, fluid);
    }

    public static void initialize(){

    }
}
