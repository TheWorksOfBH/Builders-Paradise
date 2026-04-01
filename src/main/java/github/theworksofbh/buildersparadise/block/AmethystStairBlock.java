package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AmethystStairBlock extends StairBlock {

    public AmethystStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }

    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult hitResult, Projectile projectile) {
        if (!level.isClientSide()) {
            BlockPos blockpos = hitResult.getBlockPos();
            level.playSound((Entity)null, blockpos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + level.getRandom().nextFloat() * 1.2F);
        }

    }
}
