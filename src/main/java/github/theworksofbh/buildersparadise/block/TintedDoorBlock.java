package github.theworksofbh.buildersparadise.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TintedDoorBlock extends TransparentDoorBlock {
    public TintedDoorBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState p_154824_) {
        return false;
    }

    @Override
    protected int getLightDampening(BlockState state) {
        return 15;
    }

}
