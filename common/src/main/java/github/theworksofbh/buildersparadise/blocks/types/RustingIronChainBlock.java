package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronChainBlock extends ChainBlock implements RustingIron {
    public static final MapCodec<RustingIronChainBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronChainBlock::getAge), propertiesCodec()).apply(i, RustingIronChainBlock::new));
    private final RustingIron.WeatherState weatherState;

    public RustingIronChainBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public MapCodec<RustingIronChainBlock> codec() {
        return CODEC;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return RustingIron.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
