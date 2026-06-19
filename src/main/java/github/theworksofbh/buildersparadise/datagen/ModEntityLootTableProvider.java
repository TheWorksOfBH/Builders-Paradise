package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModEntityLootTableProvider extends EntityLootSubProvider {
    protected ModEntityLootTableProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    public LootTable.Builder modElderGuardianLootTable() {
        return LootTable.lootTable().withPool(
                LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.ELDER_PRISMARINE_SHARD.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.COD).setWeight(3)
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))
                                .add(LootItem.lootTableItem(ModItems.ELDER_PRISMARINE_CRYSTALS.get()).setWeight(2)
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))
                                .add(EmptyLootItem.emptyItem())).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.WET_SPONGE)).when(LootItemKilledByPlayerCondition.killedByPlayer()))
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.COD).setWeight(60))
                                .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                                .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                                .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.025F, 0.01F)))
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(EmptyLootItem.emptyItem().setWeight(4))
                                .add(LootItem.lootTableItem(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE).setWeight(1)));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        Set<EntityType<?>> vanillaEntitiesThatNeedNewLootTables = Set.of(
                EntityTypes.ELDER_GUARDIAN,
                EntityTypes.HUSK
        );

        return Stream.concat(
                vanillaEntitiesThatNeedNewLootTables.stream(),
                ModEntities.ENTITIES.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                entityType -> entityType.getCategory() != MobCategory.MISC
        );
    }

    @Override
    public void generate() {
        this.add(EntityTypes.ELDER_GUARDIAN, this.modElderGuardianLootTable());
        this.add(EntityTypes.HUSK, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))
        ).withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.ZINC_INGOT.get()))
                        .add(LootItem.lootTableItem(Items.CARROT))
                        .add(LootItem.lootTableItem(Items.POTATO)
                                .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.025F, 0.01F))));
    }
}
