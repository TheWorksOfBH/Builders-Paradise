package github.theworksofbh.buildersparadise.fluids;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector4f;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, BuildersParadise.MODID);

    public static final DeferredHolder<FluidType, BaseFluidType> NUCLEAR_WASTE_TYPE = register("nuclear_waste_fluid", FluidType.Properties.create().viscosity(1000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA), ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "block/nuclear_waste_flow"), ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "block/nuclear_waste_still"), 1.0F, 0.0F, 1.0F, 0.0F);

    private static DeferredHolder<FluidType, BaseFluidType> register(String registryName, FluidType.Properties properties, ResourceLocation stillLoc, ResourceLocation flowingLoc, float alpha, float red, float green, float blue) {
        return FLUID_TYPES.register(registryName,
                () -> new BaseFluidType(
                        properties.descriptionId(registryName),
                        stillLoc,
                        flowingLoc,
                        null,
                        -1,
                        new Vector4f(red, green, blue, alpha)
                )
        );
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
