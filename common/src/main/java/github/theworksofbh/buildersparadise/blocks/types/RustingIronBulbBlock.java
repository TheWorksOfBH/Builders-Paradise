package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CopperBulbBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RustingIronBulbBlock extends CopperBulbBlock implements RustingIron {
    public static final MapCodec<RustingIronBulbBlock> CODEC = RecordCodecBuilder.mapCodec(
            i -> i.group(RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronBulbBlock::getAge), propertiesCodec())
                    .apply(i, RustingIronBulbBlock::new)
    );

    private final RustingIron.WeatherState weatherState;

    public RustingIronBulbBlock(WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    protected MapCodec<RustingIronBulbBlock> codec() {
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
