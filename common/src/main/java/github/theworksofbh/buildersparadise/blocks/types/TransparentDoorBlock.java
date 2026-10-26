package github.theworksofbh.buildersparadise.blocks.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TransparentDoorBlock extends DoorBlock {
    public TransparentDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos blockPos) {
        return 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return true;
    }
}