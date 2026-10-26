package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CopperBulbBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorrodingZincBulbBlock extends CopperBulbBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincBulbBlock> CODEC = RecordCodecBuilder.mapCodec(
            i -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(CorrodingZincBulbBlock::getAge), propertiesCodec())
                    .apply(i, CorrodingZincBulbBlock::new)
    );

    private final WeatherState weatherState;

    public CorrodingZincBulbBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<CorrodingZincBulbBlock> codec() {
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
