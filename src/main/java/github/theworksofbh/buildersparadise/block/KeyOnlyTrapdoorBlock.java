package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class KeyOnlyTrapdoorBlock extends TrapDoorBlock {

    private final BlockSetType type;

    public KeyOnlyTrapdoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
        this.type = type;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState blockstate = (BlockState)state.cycle(OPEN);
        boolean isOpened = false;
        if (stack.getItem() != Items.TRIAL_KEY) {
            return InteractionResult.PASS;
        } else {
            state = (BlockState)state.cycle(OPEN);
            level.setBlock(pos, state, 10);
            this.playSound(player, level, pos, (Boolean)state.getValue(OPEN));
            level.gameEvent(player, isOpened ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            if ((Boolean)blockstate.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected void neighborChanged(BlockState p_57547_, Level p_57548_, BlockPos p_57549_, Block p_57550_, @Nullable Orientation p_364404_, boolean p_57552_) {

    }
}
