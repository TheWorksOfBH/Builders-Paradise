package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class WeatheringCopperWeightedPressurePlateBlock extends BasePressurePlateBlock implements WeatheringCopper {
    public static final MapCodec<WeatheringCopperWeightedPressurePlateBlock> CODEC = RecordCodecBuilder.mapCodec(
            (i) -> i.group(Codec.intRange(1, 1024).fieldOf("max_weight").forGetter((b) -> b.maxWeight),
                    WeatherState.CODEC.fieldOf("weathering_state").forGetter(WeatheringCopperWeightedPressurePlateBlock::getAge),
                    BlockSetType.CODEC.fieldOf("block_set_type").forGetter(WeatheringCopperWeightedPressurePlateBlock::getType),
                    propertiesCodec()).apply(i, WeatheringCopperWeightedPressurePlateBlock::new));
    private final WeatherState weatherState;
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public final int maxWeight;

    public WeatheringCopperWeightedPressurePlateBlock(int maxWeight, WeatherState weatherstate, BlockSetType type, Properties properties) {
        super(properties, type);
        this.maxWeight = maxWeight;
        this.weatherState = weatherstate;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(POWER, 0));
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

    public BlockSetType getType() {
        return this.type;
    }

    @Override
    protected MapCodec<WeatheringCopperWeightedPressurePlateBlock> codec() {
        return CODEC;
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos blockPos) {
        int count = Math.min(getEntityCount(level, TOUCH_AABB.move(blockPos), Entity.class), this.maxWeight);
        if (count > 0) {
            float percent = (float)Math.min(this.maxWeight, count) / (float)this.maxWeight;
            return Mth.ceil(percent * 15.0F);
        } else {
            return 0;
        }
    }

    @Override
    protected int getSignalForState(BlockState blockState) {
        return (Integer)blockState.getValue(POWER);
    }

    @Override
    protected BlockState setSignalForState(BlockState blockState, int i) {
        return (BlockState)blockState.setValue(POWER, i);
    }

    @Override
    protected int getPressedTime() {
        return 10;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{POWER});
    }
}
