package github.theworksofbh.buildersparadise.blocks.types;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CorrodingZincSlabBlock extends SlabBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincSlabBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec()).apply(i, CorrodingZincSlabBlock::new));
    private final WeatherState weatherState;

    public CorrodingZincSlabBlock(final WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    public MapCodec<CorrodingZincSlabBlock> codec() {
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
}
