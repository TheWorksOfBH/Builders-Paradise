package github.theworksofbh.buildersparadise.blocks.collections;

import com.google.common.collect.ImmutableList;
import github.theworksofbh.buildersparadise.blocks.types.RustingIron;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.apache.commons.lang3.function.TriFunction;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;


public record RustingIronCollection<T>(RustingIronCollection.ByState<T> weathering, RustingIronCollection.ByState<T> waxed) {
    public static final RustingIronCollection.ByState<RustingIron.WeatherState> STATES = new RustingIronCollection.ByState<>(
            RustingIron.WeatherState.UNAFFECTED, RustingIron.WeatherState.EXPOSED, RustingIron.WeatherState.WEATHERED, RustingIron.WeatherState.RUSTED
    );
    public static final RustingIronCollection<String> PREFIXES = new RustingIronCollection<>(
            new RustingIronCollection.ByState<>("", "exposed_", "weathered_", "rusted_"),
            new RustingIronCollection.ByState<>("waxed_", "waxed_exposed_", "waxed_weathered_", "waxed_rusted_")
    );

    public static RustingIronCollection<String> prefixWithState(final RustingIronCollection<String> ids) {
        return zipMap(PREFIXES, ids, (state, id) -> state + id);
    }

    public static RustingIronCollection<String> create(final String name) {
        return same(RustingIronCollection.ByState.create(name));
    }

    public static RustingIronCollection<String> same(final RustingIronCollection.ByState<String> byState) {
        return new RustingIronCollection<>(byState, byState);
    }

    public static <WaxedBlock extends Block, RustingBlock extends Block & RustingIron, Id> RustingIronCollection<Block> registerBlocks(
            final RustingIronCollection<Id> ids,
            final TriFunction<Id, Function<BlockBehaviour.Properties, Block>, BlockBehaviour.Properties, Block> register,
            final BiFunction<RustingIron.WeatherState, BlockBehaviour.Properties, WaxedBlock> waxedBlockFactory,
            final BiFunction<RustingIron.WeatherState, BlockBehaviour.Properties, RustingBlock> rustingBlockFactory,
            final Function<RustingIron.WeatherState, BlockBehaviour.Properties> propertiesSupplier,
            @Nullable final Block unaffectedOverride
    ) {
        RustingIronCollection.ByState<Block> weathering = zipMap(
                STATES,
                ids.weathering(),
                (state, id) -> {
                    if (state == RustingIron.WeatherState.UNAFFECTED && unaffectedOverride != null) {
                        return unaffectedOverride;
                    }

                    return register.apply(
                            id,
                            properties -> rustingBlockFactory.apply(state, properties),
                            propertiesSupplier.apply(state)
                    );
                }
        );

        RustingIronCollection.ByState<Block> waxed = zipMap(
                STATES,
                ids.waxed(),
                (state, id) -> register.apply(
                        id,
                        properties -> waxedBlockFactory.apply(state, properties),
                        propertiesSupplier.apply(state)
                )
        );

        return new RustingIronCollection<>(
                weathering,
                waxed
        );
    }

    public static <Id> RustingIronCollection<Item> registerItems(
            final RustingIronCollection<Id> ids, final RustingIronCollection<Block> blocks, final BiFunction<Id, Block, Item> itemFactory
    ) {
        return zipMap(ids, blocks, itemFactory);
    }

    public static RustingIronCollection<BlockFamily> createFamily(
            final BiFunction<String, RustingIron.WeatherState, BlockFamily> waxedProvider, final BiFunction<String, RustingIron.WeatherState, BlockFamily> weatheringProvider
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

    public <U> RustingIronCollection<U> map(final Function<T, U> mapper) {
        return new RustingIronCollection(this.weathering.map((Function<T, T>)mapper), this.waxed.map((Function<T, T>)mapper));
    }

    public <U> RustingIronCollection<U> apply(final Function<RustingIronCollection.ByState<T>, RustingIronCollection.ByState<U>> mapper) {
        return this.apply(mapper, mapper);
    }

    public <U> RustingIronCollection<U> apply(
            final Function<RustingIronCollection.ByState<T>, RustingIronCollection.ByState<U>> weatheringMapper,
            final Function<RustingIronCollection.ByState<T>, RustingIronCollection.ByState<U>> waxedMapper
    ) {
        return new RustingIronCollection(
                (RustingIronCollection.ByState<T>)weatheringMapper.apply(this.weathering), (RustingIronCollection.ByState<T>)waxedMapper.apply(this.waxed)
        );
    }

    public static <T, U> void zipApply(final RustingIronCollection<T> first, final RustingIronCollection<U> second, final BiConsumer<T, U> consumer) {
        zipApply(first.weathering, second.weathering, consumer);
        zipApply(first.waxed, second.waxed, consumer);
    }

    public static <T, U, R> RustingIronCollection<R> zipMap(
            final RustingIronCollection<T> first, final RustingIronCollection<U> second, final BiFunction<T, U, R> operation
    ) {
        return new RustingIronCollection(
                zipMap(first.weathering, second.weathering, (BiFunction<T, U, T>)operation), zipMap(first.waxed, second.waxed, (BiFunction<T, U, T>)operation)
        );
    }

    public void zipUnwaxedWaxed(final BiConsumer<T, T> consumer) {
        zipApply(this.weathering, this.waxed, consumer);
    }

    public static <T, U> void zipApply(
            final RustingIronCollection.ByState<T> first, final RustingIronCollection.ByState<U> second, final BiConsumer<T, U> consumer
    ) {
        consumer.accept(first.unaffected, second.unaffected);
        consumer.accept(first.exposed, second.exposed);
        consumer.accept(first.weathered, second.weathered);
        consumer.accept(first.rusted, second.rusted);
    }

    public static <T, U, R> RustingIronCollection.ByState<R> zipMap(
            final RustingIronCollection.ByState<T> first, final RustingIronCollection.ByState<U> second, final BiFunction<T, U, R> operation
    ) {
        return (RustingIronCollection.ByState<R>)(new RustingIronCollection.ByState<>(
                operation.apply(first.unaffected, second.unaffected),
                operation.apply(first.exposed, second.exposed),
                operation.apply(first.weathered, second.weathered),
                operation.apply(first.rusted, second.rusted)
        ));
    }

    public record ByState<T>(T unaffected, T exposed, T weathered, T rusted) {
        public static <T> RustingIronCollection.ByState<T> create(final T value) {
            return new RustingIronCollection.ByState<>(value, value, value, value);
        }

        public <U> RustingIronCollection.ByState<U> map(final Function<T, U> mapper) {
            return (RustingIronCollection.ByState<U>)(new RustingIronCollection.ByState<>(
                    mapper.apply(this.unaffected), mapper.apply(this.exposed), mapper.apply(this.weathered), mapper.apply(this.rusted)
            ));
        }

        public T pick(final RustingIron.WeatherState state) {
            return (T)(switch (state) {
                case UNAFFECTED -> this.unaffected;
                case EXPOSED -> this.exposed;
                case WEATHERED -> this.weathered;
                case RUSTED -> this.rusted;
            });
        }

        public void forEach(final Consumer<T> consumer) {
            consumer.accept(this.unaffected);
            consumer.accept(this.exposed);
            consumer.accept(this.weathered);
            consumer.accept(this.rusted);
        }

        public void progressMapping(final BiConsumer<T, T> consumer) {
            consumer.accept(this.unaffected, this.exposed);
            consumer.accept(this.exposed, this.weathered);
            consumer.accept(this.weathered, this.rusted);
        }
    }
}
