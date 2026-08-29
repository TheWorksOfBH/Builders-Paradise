package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronLanternBlock extends LanternBlock implements RustingIron {
    public static final MapCodec<RustingIronLanternBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronLanternBlock::getAge), propertiesCodec()).apply(i, RustingIronLanternBlock::new));
    private final RustingIron.WeatherState weatherState;

    public MapCodec<RustingIronLanternBlock> codec() {
        return CODEC;
    }

    public RustingIronLanternBlock(RustingIron.WeatherState weatherState, Properties properties) {
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
        return RustingIron.getNext(state.getBlock()).isPresent();
    }
}
