package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.entities.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.menu.ModMenuTypes;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import github.theworksofbh.buildersparadise.recipe.ModRecipeBookCategories;
import github.theworksofbh.buildersparadise.recipe.ModRecipeDisplays;
import github.theworksofbh.buildersparadise.recipe.ModRecipeSerializers;
import github.theworksofbh.buildersparadise.recipe.ModRecipes;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import github.theworksofbh.buildersparadise.stats.ModStats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

public class NeoForgeInitEvent {
    public static void registerClasses(RegisterEvent event) {
        event.register(BuiltInRegistries.PARTICLE_TYPE.key(), helper -> ModParticles.initialize());
        event.register(BuiltInRegistries.BLOCK.key(), helper -> ModBlocks.initialize());
        event.register(BuiltInRegistries.ENTITY_TYPE.key(), helper -> ModEntities.initialize());
        event.register(BuiltInRegistries.SOUND_EVENT.key(), helper -> ModSoundEvents.initialize());
        event.register(BuiltInRegistries.ITEM.key(), helper -> ModItems.initialize());
        event.register(BuiltInRegistries.MOB_EFFECT.key(), helper -> ModEffects.initialize());
        event.register(BuiltInRegistries.FLUID.key(), helper -> ModFluids.initialize());
        event.register(BuiltInRegistries.CUSTOM_STAT.key(), helper -> ModStats.initialize());
        event.register(BuiltInRegistries.MENU.key(), helper -> ModMenuTypes.initialize());
        event.register(BuiltInRegistries.RECIPE_TYPE.key(), helper -> ModRecipes.initialize());
        event.register(BuiltInRegistries.RECIPE_SERIALIZER.key(), helper -> ModRecipeSerializers.initialize());
        event.register(BuiltInRegistries.RECIPE_DISPLAY.key(), helper -> ModRecipeDisplays.initialize());
        event.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY.key(), helper -> ModRecipeBookCategories.initialize());
    }
}
