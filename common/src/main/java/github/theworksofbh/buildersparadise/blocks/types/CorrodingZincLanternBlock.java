package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorrodingZincLanternBlock extends LanternBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincLanternBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(CorrodingZincLanternBlock::getAge), propertiesCodec()).apply(i, CorrodingZincLanternBlock::new));
    private final WeatherState weatherState;

    public MapCodec<CorrodingZincLanternBlock> codec() {
        return CODEC;
    }

    public CorrodingZincLanternBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return CorrodingZinc.getNext(state.getBlock()).isPresent();
    }
}
