package github.theworksofbh.buildersparadise.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WeatheringCopperPressurePlateBlock extends WeightedPressurePlateBlock implements WeatheringCopper {
    public static final MapCodec<WeatheringCopperPressurePlateBlock> CODEC = RecordCodecBuilder.mapCodec(
            (p_999999_) -> p_999999_.group(
                    Codec.intRange(1, 1024).fieldOf("max_weight")
                            .forGetter(
                                    (p_999998_) -> p_999998_.maxWeight
                            ),
                    BlockSetType.CODEC.fieldOf("block_set_type")
                            .forGetter(
                                    (p_999997_) -> p_999997_.type
                            ),
                    WeatherState.CODEC.fieldOf("weathering_state")
                            .forGetter(
                                    ChangeOverTimeBlock::getAge
                            ),
                    propertiesCodec()
            ).apply(p_999999_, WeatheringCopperPressurePlateBlock::new)
    );

    @Override
    public MapCodec<WeightedPressurePlateBlock> codec() {
        return super.codec();
    }

    private final int maxWeight;
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperPressurePlateBlock(int maxWeight, BlockSetType type, WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(maxWeight, type, properties);
        this.maxWeight = maxWeight;
        this.weatherState = weatherState;
    }

    @Override
    protected void randomTick(BlockState p_222670_, ServerLevel p_222671_, BlockPos p_222672_, RandomSource p_222673_) {
        this.changeOverTime(p_222670_, p_222671_, p_222672_, p_222673_);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState p_154947_) {
        return this.weatherState != WeatherState.OXIDIZED;
    }

    public WeatherState getAge() {
        return this.weatherState;
    }
}
