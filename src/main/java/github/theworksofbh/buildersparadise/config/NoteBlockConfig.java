package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NoteBlock;
import net.neoforged.neoforge.event.level.NoteBlockEvent;


public class NoteBlockConfig {
    public static void brassBlockNoteBlock(NoteBlockEvent.Play event){
        if (event.getLevel().getBlockState(event.getPos().below()).is(ModBlocks.BRASS_BLOCK.get()) || event.getLevel().getBlockState(event.getPos().below()).is(ModBlocks.BRASS_TILES.get()) || event.getLevel().getBlockState(event.getPos().below()).is(ModBlocks.BRASS_TILE_SLAB.get()) || event.getLevel().getBlockState(event.getPos().below()).is(ModBlocks.BRASS_TILE_STAIRS.get())) {
            event.setCanceled(true);

            Level level = (Level) event.getLevel();
            ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;

            int note = event.getState().getValue(NoteBlock.NOTE);

            BlockPos pos = event.getPos();

            float pitch = NoteBlock.getPitchFromNote(note);

            level.playSound(null, pos, ModSoundEvents.NOTE_BLOCK_TROMBONE.get(), SoundSource.RECORDS, 3.0F, pitch);

            particleEngine.createParticle(ParticleTypes.NOTE, pos.getX() + 0.5F, pos.getY() + 1.2, pos.getZ() + 0.5F,  note / 24.0F, 0.0F, 0.0F);
        }
    }
}
