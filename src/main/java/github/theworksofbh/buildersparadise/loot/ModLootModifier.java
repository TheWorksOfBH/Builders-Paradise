package github.theworksofbh.buildersparadise.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.theworksofbh.buildersparadise.items.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class ModLootModifier extends LootModifier {
    public static final MapCodec<ModLootModifier> CODEC = RecordCodecBuilder.mapCodec(
            inst -> LootModifier.codecStart(inst).and(inst.group(
                    Codec.INT.fieldOf("minimum").forGetter(e -> e.minimum),
                    Codec.INT.fieldOf("maximum").forGetter(e -> e.maximum),
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)
            )).apply(inst, ModLootModifier::new)
    );
    private final int minimum;
    private final int maximum;
    private final Item item;

    public ModLootModifier(LootItemCondition[] conditionsIn, int minimum, int maximum, Item item) {
        super(conditionsIn);
        this.minimum = minimum;
        this.maximum = maximum;
        this.item = item;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        generatedLoot.replaceAll(itemStack -> {
            if (itemStack.is(Items.PRISMARINE_SHARD)) {
                return new ItemStack(ModItems.ELDER_PRISMARINE_SHARD.get(), itemStack.getCount());
            } else if (itemStack.is(Items.PRISMARINE_CRYSTALS)) {
                return new ItemStack(ModItems.ELDER_PRISMARINE_CRYSTALS.get(), itemStack.getCount());
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
}
