package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TintedPaneBlock extends IronBarsBlock {
    public TintedPaneBlock(Properties properties) {
        super(properties);
    }

    public static final MapCodec<TintedPaneBlock> CODEC = simpleCodec(TintedPaneBlock::new);

    public MapCodec<TintedPaneBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState state) {
        return Shapes.empty();
    }

    @Override
    protected int getLightDampening(BlockState state) {
        return 15;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return false;
    }
}
