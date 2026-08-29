package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

public class NeoForgeInitEvent {
    public static void registerClasses(RegisterEvent event) {
        event.register(
                BuiltInRegistries.PARTICLE_TYPE.key(),
                helper -> ModParticles.initialize()
        );event.register(
                BuiltInRegistries.BLOCK.key(),
                helper -> ModBlocks.initialize()
        );
        event.register(
                BuiltInRegistries.ITEM.key(),
                helper -> ModItems.initialize()
        );
    }
}
