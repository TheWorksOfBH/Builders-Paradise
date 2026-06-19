package github.theworksofbh.buildersparadise.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;
import java.util.Optional;

public class ModLootModifier extends LootModifier {
    public static final MapCodec<ModLootModifier> CODEC =
            RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst)
                    .and(Entry.CODEC.listOf().fieldOf("entries").forGetter(m -> m.entries))
                    .apply(inst, ModLootModifier::new));

    private final List<Entry> entries;

    public ModLootModifier(LootItemCondition[] conditions, int priority, List<Entry> entries) {
        super(conditions, priority);
        this.entries = entries;
    }

    private ItemStack getRandomFromTag(TagKey<Item> tag, LootContext ctx) {
        var possible = BuiltInRegistries.ITEM.get(tag)
                .map(holders -> holders.stream().toList())
                .orElse(List.of());

        if (possible.isEmpty()) {
            return ItemStack.EMPTY;
        }

        Holder<Item> chosen = possible.get(ctx.getRandom().nextInt(possible.size()));
        return new ItemStack(chosen.value());
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        RandomSource rand = context.getRandom();

        for (Entry e : entries) {
            if (rand.nextInt(100) >= e.weight()) continue;
            int count;
            if (e.minimum().isPresent() && e.maximum().isPresent()) {
                count = rand.nextIntBetweenInclusive(e.minimum().get(), e.maximum().get());
            } else {
                count = 1;
            }

            generatedLoot.add(new ItemStack(e.item(), count));
        }

        generatedLoot.replaceAll(itemStack -> {
            if (itemStack.is(Items.BARREL)) {
                ItemStack replacement = getRandomFromTag(ModItemTags.BARRELS, context);

                if (!replacement.isEmpty()) {
                    replacement.setCount(itemStack.getCount());
                    return replacement;
                }

                return itemStack;
            } else {
                return itemStack;
            }
        });

        return generatedLoot;
    }


    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    public record Entry(Item item, int weight, Optional<Integer> minimum, Optional<Integer> maximum) {

        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(Entry::item),
                Codec.INT.fieldOf("weight").forGetter(Entry::weight),
                Codec.INT.optionalFieldOf("minimum").forGetter(Entry::minimum),
                Codec.INT.optionalFieldOf("maximum").forGetter(Entry::maximum)
        ).apply(inst, Entry::new));
    }

}