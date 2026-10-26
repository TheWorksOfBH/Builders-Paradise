package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.tags.ModFluidTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends TagsProvider<Fluid> {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, Registries.FLUID, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256366_) {
        tag(ModFluidTags.NUCLEAR_WASTE).add(BuiltInRegistries.FLUID.getResourceKey(ModFluids.NUCLEAR_WASTE).orElseThrow()).add(BuiltInRegistries.FLUID.getResourceKey(ModFluids.FLOWING_NUCLEAR_WASTE).orElseThrow());
    }
}