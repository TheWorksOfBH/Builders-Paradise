
package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModSoundDefinitionsProvider extends FabricSoundsProvider {

    public ModSoundDefinitionsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, SoundExporter exporter) {
        exporter.add(
                ModSoundEvents.NOTE_BLOCK_TROMBONE,
                SoundTypeBuilder.of()
                        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadiseConstants.MOD_ID,
                                        "note/trombone"
                                )
                        ))
                        .subtitle("subtitles.block.note_block.note")
        );

        exporter.add(
                ModSoundEvents.MUSIC_DISC_CIRCUITRIC_MAGNET,
                SoundTypeBuilder.of()
                        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadiseConstants.MOD_ID,
                                        "records/circuitric_magnet"
                                )
                        ))
        );

        exporter.add(
                ModSoundEvents.MUSIC_DISC_ANGRY_BOYFRIENDS,
                SoundTypeBuilder.of()
                        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadiseConstants.MOD_ID,
                                        "records/angry_boyfriends"
                                )
                        ))
        );
    }

    @Override
    public String getName() {
        return BuildersParadiseConstants.MOD_ID + " sound definitions";
    }
}
