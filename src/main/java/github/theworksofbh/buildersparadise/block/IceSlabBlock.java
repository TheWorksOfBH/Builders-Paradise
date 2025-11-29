package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;

import javax.annotation.Nullable;

public class IceSlabBlock extends SlabBlock {
    public IceSlabBlock(Properties p_56359_) {
        super(p_56359_);
    }

    public static BlockState meltsInto() {
        return Blocks.WATER.defaultBlockState();
    }

    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, te, stack);
        if (!EnchantmentHelper.hasTag(stack, EnchantmentTags.PREVENTS_ICE_MELTING)) {
            if (level.dimensionType().ultraWarm()) {
                level.removeBlock(pos, false);
                return;
            }

            BlockState blockstate = level.getBlockState(pos.below());
            if (blockstate.blocksMotion() || blockstate.liquid()) {
                level.setBlockAndUpdate(pos, meltsInto());
            }
        }

    }

    protected void randomTick(BlockState p_221355_, ServerLevel p_221356_, BlockPos p_221357_, RandomSource p_221358_) {
        if (p_221356_.getBrightness(LightLayer.BLOCK, p_221357_) > 11 - p_221355_.getLightBlock()) {
            this.melt(p_221355_, p_221356_, p_221357_);
        }

    }

    protected void melt(BlockState state, Level level, BlockPos pos) {
        if (level.dimensionType().ultraWarm()) {
            level.removeBlock(pos, false);
        } else {
            level.setBlockAndUpdate(pos, meltsInto());
            level.neighborChanged(pos, meltsInto().getBlock(), (Orientation)null);
        }

    }
}
