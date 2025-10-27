package github.theworksofbh.buildersparadise.sounds;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;

public interface ModJukeboxSongs {

    ResourceKey<JukeboxSong> CIRCUITRIC_MAGNET = create("circuitric_magnet");
    ResourceKey<JukeboxSong> ANGRY_BOYFRIENDS = create("angry_boyfriends");

    private static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, DeferredHolder<SoundEvent, SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())), (float)lengthInSeconds, comparatorOutput));
    }

    static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, CIRCUITRIC_MAGNET, ModSoundEvents.MUSIC_DISC_CIRCUITRIC_MAGNET, 167, 8);
        register(context, ANGRY_BOYFRIENDS, ModSoundEvents.MUSIC_DISC_ANGRY_BOYFRIENDS, 70, 8);
    }
}
