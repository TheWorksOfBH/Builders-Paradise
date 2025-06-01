package github.theworksofbh.buildersparadise.fluids;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, BuildersParadise.MODID);

    public static final BaseFlowingFluid.Properties NUCLEAR_WASTE_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> ModFluidTypes.NUCLEAR_WASTE_TYPE.get(),
            () -> ModFluids.NUCLEAR_WASTE.get(),
            () -> ModFluids.FLOWING_NUCLEAR_WASTE.get()
    ).block(
            () -> ModBlocks.NUCLEAR_WASTE.get()
    ).bucket(
            () -> ModItems.NUCLEAR_WASTE_BUCKET.get()
    ).slopeFindDistance(4).levelDecreasePerBlock(1).explosionResistance(100.0F);

    public static final DeferredHolder<Fluid, FlowingFluid> NUCLEAR_WASTE = FLUIDS.register("nuclear_waste",
            () -> new BaseFlowingFluid.Source(NUCLEAR_WASTE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_NUCLEAR_WASTE = FLUIDS.register("flowing_nuclear_waste",
            () -> new BaseFlowingFluid.Flowing(NUCLEAR_WASTE_PROPERTIES));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
