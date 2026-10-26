package github.theworksofbh.buildersparadise.sounds;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {

    public static final Holder.Reference<SoundEvent> NOTE_BLOCK_TROMBONE = registerForHolder("block.note_block.trombone");
    public static final Holder.Reference<SoundEvent> MUSIC_DISC_CIRCUITRIC_MAGNET = registerForHolder("music_disc.circuitric_magnet");
    public static final Holder.Reference<SoundEvent> MUSIC_DISC_ANGRY_BOYFRIENDS = registerForHolder("music_disc.angry_boyfriends");

    private static Holder<SoundEvent> register(final Identifier id, final Identifier soundId, final float range) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createFixedRangeEvent(soundId, range));
    }

    private static SoundEvent register(final String id) {
        return register(Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, id));
    }

    private static SoundEvent register(final Identifier id) {
        return register(id, id);
    }

    private static Holder.Reference<SoundEvent> registerForHolder(final String id) {
        return registerForHolder(Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, id));
    }

    private static Holder.Reference<SoundEvent> registerForHolder(final Identifier id) {
        return registerForHolder(id, id);
    }

    private static SoundEvent register(final Identifier id, final Identifier soundId) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
    }

    private static Holder.Reference<SoundEvent> registerForHolder(final Identifier id, final Identifier soundId) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
    }

    public static void initialize() {

    }
}
