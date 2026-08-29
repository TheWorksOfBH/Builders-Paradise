package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class RustingIronDoorBlock extends DoorBlock implements RustingIron {
    public static final MapCodec<RustingIronDoorBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(DoorBlock::type), RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronDoorBlock::getAge), propertiesCodec()).apply(i, RustingIronDoorBlock::new));
    private final RustingIron.WeatherState weatherState;

    public MapCodec<RustingIronDoorBlock> codec() {
        return CODEC;
    }

    public RustingIronDoorBlock(BlockSetType type, RustingIron.WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER) {
            this.changeOverTime(state, level, pos, random);
        }
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
