package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.tags.ModFluidTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BuildersParadise.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256366_) {
        tag(ModFluidTags.NUCLEAR_WASTE).add(ModFluids.NUCLEAR_WASTE.get()).add(ModFluids.FLOWING_NUCLEAR_WASTE.get());
    }
}
