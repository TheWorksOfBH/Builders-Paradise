package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorrodingZincChainBlock extends ChainBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincChainBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(CorrodingZincChainBlock::getAge), propertiesCodec()).apply(i, CorrodingZincChainBlock::new));
    private final WeatherState weatherState;

    public CorrodingZincChainBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public MapCodec<CorrodingZincChainBlock> codec() {
        return CODEC;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return CorrodingZinc.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
