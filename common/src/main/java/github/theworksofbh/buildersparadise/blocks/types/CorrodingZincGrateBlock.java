package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorrodingZincGrateBlock extends WaterloggedTransparentBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincGrateBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(CorrodingZincGrateBlock::getAge), propertiesCodec()).apply(i, CorrodingZincGrateBlock::new));

    private final WeatherState weatherState;

    public CorrodingZincGrateBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    protected MapCodec<CorrodingZincGrateBlock> codec() {
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
