package github.theworksofbh.buildersparadise.blocks.types;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.mojang.serialization.Codec;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface RustingIron extends ChangeOverTimeBlock<RustingIron.WeatherState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        ImmutableBiMap.Builder<Block, Block> builder = ImmutableBiMap.builder();
        Stream.of(
                ModBlocks.IRON_BLOCK,
                ModBlocks.IRON_GRATE,
                ModBlocks.CUT_IRON,
                ModBlocks.CUT_IRON_STAIRS,
                ModBlocks.CUT_IRON_SLAB,
                ModBlocks.IRON_BARS,
                ModBlocks.IRON_DOOR,
                ModBlocks.IRON_TRAPDOOR,
                ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE,
                ModBlocks.IRON_BULB,
                ModBlocks.IRON_CHAIN,
                ModBlocks.IRON_LANTERN,
                ModBlocks.IRON_SOUL_LANTERN,
                ModBlocks.IRON_FIRE_LANTERN
        ).forEach((collection) -> collection.weathering().progressMapping(builder::put));
        return builder.build();
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> ((BiMap)NEXT_BY_BLOCK.get()).inverse());

    static Optional<Block> getPrevious(final Block block) {
        return Optional.ofNullable((Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(block));
    }

    static Block getFirst(final Block block) {
        Block candiate = block;

        for (Block previous = (Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(block);
             previous != null;
             previous = (Block)((BiMap)PREVIOUS_BY_BLOCK.get()).get(previous)
        ) {
            candiate = previous;
        }

        return candiate;
    }

    static Optional<BlockState> getPrevious(final BlockState state) {
        return getPrevious(state.getBlock()).map(s -> s.withPropertiesOf(state));
    }

    static Optional<Block> getNext(final Block block) {
        return Optional.ofNullable((Block)((BiMap)NEXT_BY_BLOCK.get()).get(block));
    }

    static BlockState getFirst(final BlockState state) {
        return getFirst(state.getBlock()).withPropertiesOf(state);
    }

    @Override
    default Optional<BlockState> getNext(final BlockState state) {
        return getNext(state.getBlock()).map(s -> s.withPropertiesOf(state));
    }

    @Override
    default float getChanceModifier() {
        return this.getAge() == WeatherState.UNAFFECTED ? 0.65F : 1.0F;
    }

    public static enum WeatherState implements StringRepresentable {
        UNAFFECTED("unaffected"),
        EXPOSED("exposed"),
        WEATHERED("weathered"),
        RUSTED("rusted");

        public static final IntFunction<WeatherState> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.CLAMP);
        public static final Codec<WeatherState> CODEC = StringRepresentable.fromEnum(WeatherState::values);
        public static final StreamCodec<ByteBuf, WeatherState> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, Enum::ordinal);
        private final String name;

        private WeatherState(final String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public static void forEach(final Consumer<WeatherState> consumer) {
            for (WeatherState weatherState : values()) {
                consumer.accept(weatherState);
            }
        }

        public WeatherState next() {
            return (WeatherState)BY_ID.apply(this.ordinal() + 1);
        }

        public WeatherState previous() {
            return (WeatherState)BY_ID.apply(this.ordinal() - 1);
        }
    }
}