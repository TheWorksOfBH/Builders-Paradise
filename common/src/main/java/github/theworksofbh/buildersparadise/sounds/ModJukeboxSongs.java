package github.theworksofbh.buildersparadise.sounds;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {

    ResourceKey<JukeboxSong> CIRCUITRIC_MAGNET = create("circuitric_magnet");
    ResourceKey<JukeboxSong> ANGRY_BOYFRIENDS = create("angry_boyfriends");

    private static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), (float)lengthInSeconds, comparatorOutput));
    }

    static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, CIRCUITRIC_MAGNET, ModSoundEvents.MUSIC_DISC_CIRCUITRIC_MAGNET, 167, 8);
        register(context, ANGRY_BOYFRIENDS, ModSoundEvents.MUSIC_DISC_ANGRY_BOYFRIENDS, 70, 8);
    }
}