package github.theworksofbh.buildersparadise.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class MonsterOnlyPressurePlateBlock extends PressurePlateBlock {
    public MonsterOnlyPressurePlateBlock(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        return getEntityCount(level, TOUCH_AABB.move(pos), Monster.class) > 0 ? 15 : 0;
    }
}
