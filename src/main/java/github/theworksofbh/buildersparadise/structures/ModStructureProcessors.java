package github.theworksofbh.buildersparadise.structures;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class ModStructureProcessors {

    public static ResourceKey<StructureProcessorType<?>> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_PROCESSOR, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static void bootstrap(BootstrapContext<StructureProcessorType<?>> context) {
        context.register(GENERIC_BLOCK_REPLACER_KEY, GENERIC_BLOCK_REPLACER);
    }

    public static final ResourceKey<StructureProcessorType<?>> GENERIC_BLOCK_REPLACER_KEY = registerKey("generic_block_replacer");
    public static final StructureProcessorType<GenericBlockReplacementProcessor> GENERIC_BLOCK_REPLACER = () -> GenericBlockReplacementProcessor.CODEC;
}
