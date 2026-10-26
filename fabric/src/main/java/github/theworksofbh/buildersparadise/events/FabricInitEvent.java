package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.entities.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.menu.ModMenuTypes;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import github.theworksofbh.buildersparadise.recipe.ModRecipeDisplays;
import github.theworksofbh.buildersparadise.recipe.ModRecipeSerializers;
import github.theworksofbh.buildersparadise.recipe.ModRecipes;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import github.theworksofbh.buildersparadise.stats.ModStats;

public class FabricInitEvent {
    public static void initializeClasses(){
        ModParticles.initialize();
        ModBlocks.initialize();
        ModEntities.initialize();
        ModSoundEvents.initialize();
        ModItems.initialize();
        ModEffects.initialize();
        ModFluids.initialize();
        ModStats.initialize();
        ModMenuTypes.initialize();
        ModRecipes.initialize();
        ModRecipeSerializers.initialize();
        ModRecipeDisplays.initialize();
    }
}
