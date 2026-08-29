package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronStairBlock extends StairBlock implements RustingIron {
    public static final MapCodec<RustingIronStairBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), BlockState.CODEC.fieldOf("base_state").forGetter((b) -> b.baseState), propertiesCodec()).apply(i, RustingIronStairBlock::new));
    private final RustingIron.WeatherState weatherState;

    public RustingIronStairBlock(WeatherState weatherState, BlockState baseState, Properties properties) {
        super(baseState, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, level, pos, random);
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return RustingIron.getNext(state.getBlock()).isPresent();
    }

    public MapCodec<RustingIronStairBlock> codec() {
        return CODEC;
    }

}
