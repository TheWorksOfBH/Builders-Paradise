package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CorrodingZincTrapDoorBlock extends TrapDoorBlock implements CorrodingZinc {
    public static final MapCodec<CorrodingZincTrapDoorBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(CorrodingZincTrapDoorBlock::getType), WeatherState.CODEC.fieldOf("weathering_state").forGetter(CorrodingZincTrapDoorBlock::getAge), propertiesCodec()).apply(i, CorrodingZincTrapDoorBlock::new));
    private final WeatherState weatherState;

    public MapCodec<CorrodingZincTrapDoorBlock> codec() {
        return CODEC;
    }

    public CorrodingZincTrapDoorBlock(BlockSetType type, WeatherState weatherState, Properties properties) {
        super(type, properties);
        this.weatherState = weatherState;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
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
    public BlockSetType getType() {
        return super.getType();
    }
}
