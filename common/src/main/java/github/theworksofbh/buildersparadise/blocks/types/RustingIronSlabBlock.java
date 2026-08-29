package github.theworksofbh.buildersparadise.blocks.types;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronSlabBlock extends SlabBlock implements RustingIron {
    public static final MapCodec<RustingIronSlabBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec()).apply(i, RustingIronSlabBlock::new));
    private final WeatherState weatherState;

    public RustingIronSlabBlock(final WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    public MapCodec<RustingIronSlabBlock> codec() {
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
