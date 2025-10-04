package github.theworksofbh.buildersparadise.block;

import com.mojang.serialization.MapCodec;
import github.theworksofbh.buildersparadise.gui.FletchingMenu;
import github.theworksofbh.buildersparadise.stats.ModStats;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class FletchingTableBlock extends Block {
    public static final MapCodec<FletchingTableBlock> CODEC = simpleCodec(FletchingTableBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.fletching");

    public MapCodec<FletchingTableBlock> codec() {
        return CODEC;
    }

    public FletchingTableBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            player.openMenu(state.getMenuProvider(level, pos));
            player.awardStat(ModStats.INTERACT_WITH_FLETCHING_TABLE.value());
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((p_51353_, p_51354_, p_51355_) -> new FletchingMenu(p_51353_, p_51354_, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
}
