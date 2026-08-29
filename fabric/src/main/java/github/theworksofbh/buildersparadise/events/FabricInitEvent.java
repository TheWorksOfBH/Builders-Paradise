package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.particles.ModParticles;

public class FabricInitEvent {
    public static void initializeClasses(){
        ModParticles.initialize();
        ModBlocks.initialize();
        ModItems.initialize();
    }
}
