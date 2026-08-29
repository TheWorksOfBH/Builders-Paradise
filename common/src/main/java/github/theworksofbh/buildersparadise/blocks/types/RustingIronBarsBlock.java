package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronBarsBlock extends IronBarsBlock implements RustingIron {
    public static final MapCodec<RustingIronBarsBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronBarsBlock::getAge), propertiesCodec()).apply(i, RustingIronBarsBlock::new));

    private final WeatherState weatherState;

    public RustingIronBarsBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    public MapCodec<RustingIronBarsBlock> codec() {
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
}
