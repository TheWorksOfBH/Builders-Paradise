package github.theworksofbh.buildersparadise.blocks.collections;

import com.google.common.collect.ImmutableList;
import github.theworksofbh.buildersparadise.blocks.types.CorrodingZinc;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;


public record CorrodingZincCollection<T>(CorrodingZincCollection.ByState<T> weathering, CorrodingZincCollection.ByState<T> waxed) {
    public static final CorrodingZincCollection.ByState<CorrodingZinc.WeatherState> STATES = new CorrodingZincCollection.ByState<>(
            CorrodingZinc.WeatherState.UNAFFECTED, CorrodingZinc.WeatherState.EXPOSED, CorrodingZinc.WeatherState.WEATHERED, CorrodingZinc.WeatherState.CORRODED
    );
    public static final CorrodingZincCollection<String> PREFIXES = new CorrodingZincCollection<>(
            new CorrodingZincCollection.ByState<>("", "exposed_", "weathered_", "corroded_"),
            new CorrodingZincCollection.ByState<>("waxed_", "waxed_exposed_", "waxed_weathered_", "waxed_corroded_")
    );

    public static CorrodingZincCollection<String> prefixWithState(final CorrodingZincCollection<String> ids) {
        return zipMap(PREFIXES, ids, (state, id) -> state + id);
    }

    public static CorrodingZincCollection<String> create(final String name) {
        return same(CorrodingZincCollection.ByState.create(name));
    }

    public static CorrodingZincCollection<String> same(final CorrodingZincCollection.ByState<String> byState) {
        return new CorrodingZincCollection<>(byState, byState);
    }

    public static <WaxedBlock extends Block, RustingBlock extends Block & CorrodingZinc, Id> CorrodingZincCollection<Block> registerBlocks(
            final CorrodingZincCollection<Id> ids,
            final TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register,
            final BiFunction<CorrodingZinc.WeatherState, BlockBehaviour.Properties, WaxedBlock> waxedBlockFactory,
            final BiFunction<CorrodingZinc.WeatherState, BlockBehaviour.Properties, RustingBlock> rustingBlockFactory,
            final Function<CorrodingZinc.WeatherState, BlockBehaviour.Properties> propertiesSupplier
    ) {
        CorrodingZincCollection.ByState<Block> weathering = zipMap(
                STATES,
                ids.weathering(),
                (state, id) -> register.apply(
                            id,
                            properties -> rustingBlockFactory.apply(state, properties),
                            propertiesSupplier.apply(state)
                )
        );

        CorrodingZincCollection.ByState<Block> waxed = zipMap(
                STATES,
                ids.waxed(),
                (state, id) -> register.apply(
                        id,
                        properties -> waxedBlockFactory.apply(state, properties),
                        propertiesSupplier.apply(state)
                )
        );

        return new CorrodingZincCollection<>(
                weathering,
                waxed
        );
    }

    public static <Id> CorrodingZincCollection<Item> registerItems(
            final CorrodingZincCollection<Id> ids, final CorrodingZincCollection<Block> blocks, final BiFunction<Id, Block, Item> itemFactory
    ) {
        return zipMap(ids, blocks, itemFactory);
    }

    public static CorrodingZincCollection<BlockFamily> createFamily(
            final BiFunction<String, CorrodingZinc.WeatherState, BlockFamily> waxedProvider, final BiFunction<String, CorrodingZinc.WeatherState, BlockFamily> weatheringProvider
    ) {
        return PREFIXES.apply(
                weatheringPrefixes -> zipMap(weatheringPrefixes, STATES, weatheringProvider), waxedPrefixes -> zipMap(waxedPrefixes, STATES, waxedProvider)
        );
    }

    public List<T> asList() {
        ImmutableList.Builder<T> builder = ImmutableList.builderWithExpectedSize(8);
        this.forEach(builder::add);
        return builder.build();
    }

    public void forEach(final Consumer<T> consumer) {
        this.weathering.forEach(consumer);
        this.waxed.forEach(consumer);
    }

    public <U> CorrodingZincCollection<U> map(final Function<T, U> mapper) {
        return new CorrodingZincCollection(this.weathering.map((Function<T, T>)mapper), this.waxed.map((Function<T, T>)mapper));
    }

    public <U> CorrodingZincCollection<U> apply(final Function<CorrodingZincCollection.ByState<T>, CorrodingZincCollection.ByState<U>> mapper) {
        return this.apply(mapper, mapper);
    }

    public <U> CorrodingZincCollection<U> apply(
            final Function<CorrodingZincCollection.ByState<T>, CorrodingZincCollection.ByState<U>> weatheringMapper,
            final Function<CorrodingZincCollection.ByState<T>, CorrodingZincCollection.ByState<U>> waxedMapper
    ) {
        return new CorrodingZincCollection(
                (CorrodingZincCollection.ByState<T>)weatheringMapper.apply(this.weathering), (CorrodingZincCollection.ByState<T>)waxedMapper.apply(this.waxed)
        );
    }

    public static <T, U> void zipApply(final CorrodingZincCollection<T> first, final CorrodingZincCollection<U> second, final BiConsumer<T, U> consumer) {
        zipApply(first.weathering, second.weathering, consumer);
        zipApply(first.waxed, second.waxed, consumer);
    }

    public static <T, U, R> CorrodingZincCollection<R> zipMap(
            final CorrodingZincCollection<T> first, final CorrodingZincCollection<U> second, final BiFunction<T, U, R> operation
    ) {
        return new CorrodingZincCollection(
                zipMap(first.weathering, second.weathering, (BiFunction<T, U, T>)operation), zipMap(first.waxed, second.waxed, (BiFunction<T, U, T>)operation)
        );
    }

    public void zipUnwaxedWaxed(final BiConsumer<T, T> consumer) {
        zipApply(this.weathering, this.waxed, consumer);
    }

    public static <T, U> void zipApply(
            final CorrodingZincCollection.ByState<T> first, final CorrodingZincCollection.ByState<U> second, final BiConsumer<T, U> consumer
    ) {
        consumer.accept(first.unaffected, second.unaffected);
        consumer.accept(first.exposed, second.exposed);
        consumer.accept(first.weathered, second.weathered);
        consumer.accept(first.corroded, second.corroded);
    }

    public static <T, U, R> CorrodingZincCollection.ByState<R> zipMap(
            final CorrodingZincCollection.ByState<T> first, final CorrodingZincCollection.ByState<U> second, final BiFunction<T, U, R> operation
    ) {
        return (CorrodingZincCollection.ByState<R>)(new CorrodingZincCollection.ByState<>(
                operation.apply(first.unaffected, second.unaffected),
                operation.apply(first.exposed, second.exposed),
                operation.apply(first.weathered, second.weathered),
                operation.apply(first.corroded, second.corroded)
        ));
    }

    public record ByState<T>(T unaffected, T exposed, T weathered, T corroded) {
        public static <T> CorrodingZincCollection.ByState<T> create(final T value) {
            return new CorrodingZincCollection.ByState<>(value, value, value, value);
        }

        public <U> CorrodingZincCollection.ByState<U> map(final Function<T, U> mapper) {
            return (CorrodingZincCollection.ByState<U>)(new CorrodingZincCollection.ByState<>(
                    mapper.apply(this.unaffected), mapper.apply(this.exposed), mapper.apply(this.weathered), mapper.apply(this.corroded)
            ));
        }

        public T pick(final CorrodingZinc.WeatherState state) {
            return (T)(switch (state) {
                case UNAFFECTED -> this.unaffected;
                case EXPOSED -> this.exposed;
                case WEATHERED -> this.weathered;
                case CORRODED -> this.corroded;
            });
        }

        public void forEach(final Consumer<T> consumer) {
            consumer.accept(this.unaffected);
            consumer.accept(this.exposed);
            consumer.accept(this.weathered);
            consumer.accept(this.corroded);
        }

        public void progressMapping(final BiConsumer<T, T> consumer) {
            consumer.accept(this.unaffected, this.exposed);
            consumer.accept(this.exposed, this.weathered);
            consumer.accept(this.weathered, this.corroded);
        }
    }
}
