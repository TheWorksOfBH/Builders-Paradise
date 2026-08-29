package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class RustingIronTrapDoorBlock extends TrapDoorBlock implements RustingIron {
    public static final MapCodec<RustingIronTrapDoorBlock> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(RustingIronTrapDoorBlock::getType), RustingIron.WeatherState.CODEC.fieldOf("weathering_state").forGetter(RustingIronTrapDoorBlock::getAge), propertiesCodec()).apply(i, RustingIronTrapDoorBlock::new));
    private final RustingIron.WeatherState weatherState;

    public MapCodec<RustingIronTrapDoorBlock> codec() {
        return CODEC;
    }

    public RustingIronTrapDoorBlock(BlockSetType type, RustingIron.WeatherState weatherState, Properties properties) {
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
        return RustingIron.getNext(state.getBlock()).isPresent();
    }

    @Override
    public BlockSetType getType() {
        return super.getType();
    }
}
