package github.theworksofbh.buildersparadise.sounds;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BuildersParadise.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> NOTE_BLOCK_TROMBONE = registerSoundEvent("block.note_block.trombone");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String registryName) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, registryName);
        return SOUND_EVENTS.register(registryName, () -> SoundEvent.createVariableRangeEvent(resourceLocation));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
