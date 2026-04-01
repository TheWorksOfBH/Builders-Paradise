package github.theworksofbh.buildersparadise.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TintedIronBarsBlock extends IronBarsBlock {
    public TintedIronBarsBlock(Properties properties) {
        super(properties);
    }

    public static final MapCodec<TintedIronBarsBlock> CODEC = simpleCodec(TintedIronBarsBlock::new);

    public MapCodec<TintedIronBarsBlock> codec() {
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
