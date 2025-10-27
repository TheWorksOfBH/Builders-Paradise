package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    protected ModSoundDefinitionsProvider(PackOutput output) {
        super(output, BuildersParadise.MODID);
    }



    @Override
    public void registerSounds() {
        add(ModSoundEvents.NOTE_BLOCK_TROMBONE.get(), SoundDefinition.definition()
                .with(
                        sound("buildersparadise:note/trombone", SoundDefinition.SoundType.SOUND)
                ).subtitle("subtitles.block.note_block.note")
        );
        add(ModSoundEvents.MUSIC_DISC_CIRCUITRIC_MAGNET.get(), SoundDefinition.definition()
                .with(
                        sound("buildersparadise:records/circuitric_magnet", SoundDefinition.SoundType.SOUND)
                )
        );
        add(ModSoundEvents.MUSIC_DISC_ANGRY_BOYFRIENDS.get(), SoundDefinition.definition()
                .with(
                        sound("buildersparadise:records/angry_boyfriends", SoundDefinition.SoundType.SOUND)
                )
        );
    }
}
