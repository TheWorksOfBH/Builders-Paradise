package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.*;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewLootTables = Set.of(
                Blocks.CRAFTING_TABLE,
                Blocks.CARTOGRAPHY_TABLE,
                Blocks.FLETCHING_TABLE,
                Blocks.STONE_SLAB,
                Blocks.STONE_STAIRS,
                Blocks.SMITHING_TABLE,
                Blocks.GRINDSTONE,
                Blocks.LOOM,
                Blocks.FURNACE,
                Blocks.SMOKER,
                Blocks.BLAST_FURNACE,
                Blocks.CAMPFIRE,
                Blocks.SOUL_CAMPFIRE,
                Blocks.BEEHIVE,
                Blocks.BOOKSHELF,
                Blocks.CHISELED_BOOKSHELF,
                Blocks.LECTERN,
                Blocks.BREWING_STAND,
                Blocks.BARREL,
                Blocks.DISPENSER,
                Blocks.DROPPER,
                Blocks.OBSERVER,
                Blocks.CRAFTER,
                Blocks.CHEST,
                Blocks.TRAPPED_CHEST,
                Blocks.ICE,
                Blocks.PACKED_ICE,
                Blocks.BLUE_ICE
        );

        Set<Block> handMadeBlocks = Set.of(
                ModBlocks.NUCLEAR_WASTE.get()
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewLootTables.stream(),
                ModBlocks.BLOCKS.getEntries().stream().map(Supplier::get)
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createSilkTouchSlabItemTable(Block block, Item otherWiseItem) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(
                                        LootItem.lootTableItem(block.asItem())
                                                .when(this.hasSilkTouch())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                                                .otherwise(
                                                        LootItem.lootTableItem(otherWiseItem)
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                                                )
                                )
                );
    }

    protected LootTable.Builder createColdSlabItemTable(Block block, Item otherWiseItem) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(
                                        LootItem.lootTableItem(block.asItem())
                                                .when(this.hasSilkTouch())
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                                                .otherwise(
                                                        LootItem.lootTableItem(otherWiseItem)
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                                                )
                                )
                );
    }

    protected LootTable.Builder createGlassDoorLootTable(Block block) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(
                        block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        LootItem.lootTableItem(block)
                                                .when(this.hasSilkTouch())
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(DoorBlock.HALF, DoubleBlockHalf.LOWER))))));

    }

    protected void generate(){
        getKnownBlocks().forEach(
            block -> {
                if (block instanceof SlabBlock || block instanceof ModSlabBlock){
                    if (block == Blocks.STONE_SLAB) {
                        this.add(block, createSilkTouchSlabItemTable(block, Items.COBBLESTONE_SLAB));
                    } else if (block == ModBlocks.DEEPSLATE_SLAB.get()) {
                        this.add(block, createSilkTouchSlabItemTable(block, Items.COBBLED_DEEPSLATE_SLAB));
                    } else if (block == ModBlocks.SNOW_SLAB.get() || block == ModBlocks.SNOW_BRICK_SLAB.get()) {
                        this.add(block, createColdSlabItemTable(block, Items.SNOWBALL));
                    } else if (block == ModBlocks.ICE_SLAB.get() || block == ModBlocks.PACKED_ICE_SLAB.get() || block == ModBlocks.BLUE_ICE_SLAB.get() || block == ModBlocks.ICE_BRICK_SLAB.get() || block == ModBlocks.PACKED_ICE_BRICK_SLAB.get() || block == ModBlocks.BLUE_ICE_BRICK_SLAB.get()) {
                        this.add(block, createColdSlabItemTable(block, ModItems.ICE_SHARD.get()));
                    } else if (block == ModBlocks.GILDED_BLACKSTONE_SLAB.get()) {
                        this.add(block, this.createSilkTouchDispatchTable(block,
                                this.applyExplosionCondition(block, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                        .when(
                                                BonusLevelTableCondition.bonusLevelFlatChance(
                                                        this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE),
                                                        new float[]{0.1F, 0.14285715F, 0.25F, 1.0F})
                                        )
                                ).otherwise(
                                        LootItem.lootTableItem(block)
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                                ))));

                    } else {
                        this.add(block, createSlabItemTable(block));
                    }
                } else if (block instanceof StairBlock || block instanceof ModStairBlock) {
                    if (block == Blocks.STONE_STAIRS) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLESTONE_STAIRS));
                    } else if (block == ModBlocks.DEEPSLATE_STAIRS.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLED_DEEPSLATE_STAIRS));
                    } else if (block == ModBlocks.SNOW_STAIRS.get() || block == ModBlocks.SNOW_BRICK_STAIRS.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL, ConstantValue.exactly(3.0F)));
                    } else if (block == ModBlocks.ICE_STAIRS.get() || block == ModBlocks.PACKED_ICE_STAIRS.get() || block == ModBlocks.BLUE_ICE_STAIRS.get() || block == ModBlocks.ICE_BRICK_STAIRS.get() || block == ModBlocks.PACKED_ICE_BRICK_STAIRS.get() || block == ModBlocks.BLUE_ICE_BRICK_STAIRS.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD.get(), ConstantValue.exactly(3.0F)));
                    } else if (block == ModBlocks.GILDED_BLACKSTONE_STAIRS.get()) {
                        this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                    } else  {
                        this.dropSelf(block);
                    }
                } else if (block instanceof WallBlock) {
                    if (block == ModBlocks.STONE_WALL.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLESTONE_WALL));
                    } else if (block == ModBlocks.DEEPSLATE_WALL.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLED_DEEPSLATE_WALL));
                    } else if (block == ModBlocks.SNOW_WALL.get() || block == ModBlocks.SNOW_BRICK_WALL.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL));
                    } else if (block == ModBlocks.ICE_WALL.get() || block == ModBlocks.PACKED_ICE_WALL.get() || block == ModBlocks.BLUE_ICE_WALL.get() || block == ModBlocks.ICE_BRICK_WALL.get() || block == ModBlocks.PACKED_ICE_BRICK_WALL.get() || block == ModBlocks.BLUE_ICE_BRICK_WALL.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD.get()));
                    } else if (block == ModBlocks.GILDED_BLACKSTONE_WALL.get()) {
                        this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                    } else {
                        this.dropSelf(block);
                    }
                } else if (block instanceof FenceBlock) {
                    if (block == ModBlocks.STONE_FENCE.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.COBBLESTONE_FENCE.get()));
                    } else if (block == ModBlocks.DEEPSLATE_FENCE.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.COBBLED_DEEPSLATE_FENCE.get()));
                    } else if (block == ModBlocks.SNOW_FENCE.get() || block == ModBlocks.SNOW_BRICK_FENCE.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL));
                    } else if (block == ModBlocks.ICE_FENCE.get() || block == ModBlocks.PACKED_ICE_FENCE.get() || block == ModBlocks.BLUE_ICE_FENCE.get() || block == ModBlocks.ICE_BRICK_FENCE.get() || block == ModBlocks.PACKED_ICE_BRICK_FENCE.get() || block == ModBlocks.BLUE_ICE_BRICK_FENCE.get()) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD.get()));
                    } else if (block == ModBlocks.GILDED_BLACKSTONE_FENCE.get()) {
                        this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                    } else {
                        this.dropSelf(block);
                    }
                } else if (block instanceof DoorBlock || block instanceof ModDoorBlock) {
                    if (block.getDescriptionId().contains("glass") && !block.getDescriptionId().contains("tinted")) {
                        this.add(block, createGlassDoorLootTable(block));
                    } else {
                        this.add(block, createDoorTable(block));
                    }
                } else if (block instanceof TrapDoorBlock || block instanceof ModTrapdoorBlock) {
                    if (block instanceof TransparentTrapdoorBlock || block instanceof StainedTrapdoorBlock) {
                        this.dropWhenSilkTouch(block);
                    } else {
                        this.dropSelf(block);
                    }
                } else if (block instanceof DropExperienceBlock) {
                    if (block == ModBlocks.ZINC_ORE.get() || block == ModBlocks.DEEPSLATE_ZINC_ORE.get()) {
                        this.add(block, createOreDrop(block, ModItems.RAW_ZINC.get()));
                    } else if (block == ModBlocks.SILVER_ORE.get() || block == ModBlocks.DEEPSLATE_SILVER_ORE.get()) {
                        this.add(block, createOreDrop(block, ModItems.RAW_SILVER.get()));
                    } else if (block == ModBlocks.TIN_ORE.get() || block == ModBlocks.DEEPSLATE_TIN_ORE.get()) {
                        this.add(block, createMultipleOreDrops(block, ModItems.RAW_TIN.get(), 3.0F, 5.0F));
                    } else if (block == ModBlocks.TUNGSTEN_ORE.get() || block == ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get()) {
                        this.add(block, createOreDrop(block, ModItems.RAW_TUNGSTEN.get()));
                    } else if (block == ModBlocks.PLATINUM_ORE.get() || block == ModBlocks.DEEPSLATE_PLATINUM_ORE.get()) {
                        this.add(block, createOreDrop(block, ModItems.RAW_PLATINUM.get()));
                    } else if (block == ModBlocks.LEAD_ORE.get() || block == ModBlocks.DEEPSLATE_LEAD_ORE.get()) {
                        this.add(block, createMultipleOreDrops(block, ModItems.RAW_LEAD.get(), 3.0F, 5.0F));
                    } else if (block == ModBlocks.BISMUTH_ORE.get() || block == ModBlocks.DEEPSLATE_BISMUTH_ORE.get()) {
                        this.add(block, createMultipleOreDrops(block, ModItems.RAW_BISMUTH.get(), 3.0F, 5.0F));
                    } else if (block == ModBlocks.URANIUM_ORE.get() || block == ModBlocks.DEEPSLATE_URANIUM_ORE.get()) {
                        this.add(block, createMultipleOreDrops(block, ModItems.RAW_URANIUM.get(), 2.0F, 4.0F));
                    }
                } else if (block == Blocks.CRAFTING_TABLE) {
                    this.dropOther(block, ModItems.OAK_CRAFTING_TABLE.get());
                } else if (block == Blocks.CARTOGRAPHY_TABLE) {
                    this.dropOther(block, ModItems.DARK_OAK_CARTOGRAPHY_TABLE.get());
                } else if (block == Blocks.FLETCHING_TABLE) {
                    this.dropOther(block, ModItems.BIRCH_FLETCHING_TABLE.get());
                } else if (block == Blocks.SMITHING_TABLE) {
                    this.dropOther(block, ModItems.MANGROVE_SMITHING_TABLE.get());
                } else if (block == Blocks.GRINDSTONE) {
                    this.dropOther(block, ModItems.DARK_OAK_GRINDSTONE.get());
                } else if (block == Blocks.LOOM) {
                    this.dropOther(block, ModItems.OAK_LOOM.get());
                } else if (block instanceof FurnaceBlock) {
                    if (block == Blocks.FURNACE) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.STONE_FURNACE.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof SmokerBlock) {
                    if (block == Blocks.SMOKER) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.OAK_STONE_SMOKER.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof BlastFurnaceBlock) {
                    if (block == Blocks.BLAST_FURNACE) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.STONE_BLAST_FURNACE.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof CampfireBlock) {
                    if (block.getDescriptionId().contains("soul")) {
                        if (block == Blocks.SOUL_CAMPFIRE) {
                            this.add(block, LootTable.lootTable()
                                    .withPool(
                                            LootPool.lootPool()
                                                    .setRolls(ConstantValue.exactly(1.0F))
                                                    .add(
                                                            (LootItem.lootTableItem(ModItems.OAK_SOUL_CAMPFIRE.get())
                                                                    .when(this.hasSilkTouch()))
                                                                    .otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.SOUL_SOIL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))))));
                        } else {
                            this.add(block, (campfire) -> this.createSilkTouchDispatchTable(campfire, (LootPoolEntryContainer.Builder)this.applyExplosionCondition(campfire, LootItem.lootTableItem(Items.SOUL_SOIL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
                        }
                    } else {
                        if (block == Blocks.CAMPFIRE) {
                            this.add(block, LootTable.lootTable()
                                    .withPool(
                                            LootPool.lootPool()
                                                    .setRolls(ConstantValue.exactly(1.0F))
                                                    .add(
                                                            (LootItem.lootTableItem(ModItems.OAK_CAMPFIRE.get())
                                                                    .when(this.hasSilkTouch()))
                                                                    .otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))))));
                        } else {
                            this.add(block, (campfire) -> this.createSilkTouchDispatchTable(campfire, (LootPoolEntryContainer.Builder)this.applyExplosionCondition(campfire, LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))));
                        }
                    }
                } else if (block == Blocks.BEEHIVE) {
                    this.dropOther(block, ModItems.OAK_BEEHIVE.get());
                } else if (block.getDescriptionId().contains("bookshelf") && !block.getDescriptionId().contains("chiselled")) {
                    if (block == Blocks.BOOKSHELF) {
                        this.add(block, LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .setRolls(ConstantValue.exactly(1))
                                                .add(
                                                        LootItem.lootTableItem(ModItems.OAK_BOOKSHELF.get())
                                                                .when(this.hasSilkTouch())
                                                                .otherwise(
                                                                        LootItem.lootTableItem(Items.BOOK)
                                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))
                                                                )
                                                )
                                )
                        );
                    } else {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
                    }
                } else if (block instanceof ChiseledBookShelfBlock) {
                    if (block == Blocks.CHISELED_BOOKSHELF) {
                        this.add(block, createSilkTouchOnlyTable(ModItems.OAK_CHISELED_BOOKSHELF.get()));
                    } else {
                        this.dropWhenSilkTouch(block);
                    }
                } else if (block == Blocks.LECTERN) {
                    this.dropOther(block, ModItems.OAK_LECTERN.get());
                } else if (block instanceof BrewingStandBlock) {
                    if (block == Blocks.BREWING_STAND) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.STONE_BREWING_STAND.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof BarrelBlock) {
                    if (block == Blocks.BARREL) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.SPRUCE_BARREL.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof DispenserBlock) {
                    if (block == Blocks.DISPENSER) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.STONE_DISPENSER.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof DropperBlock) {
                    if (block == Blocks.DROPPER) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.STONE_DROPPER.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block == Blocks.OBSERVER) {
                    this.dropOther(block, ModItems.STONE_OBSERVER.get());
                } else if (block == Blocks.CRAFTER) {
                    this.dropOther(block, ModItems.OAK_CRAFTER.get());
                } else if (block instanceof ChestBlock) {
                    if (block == Blocks.CHEST) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.OAK_CHEST.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block instanceof TrappedChestBlock) {
                    if (block == Blocks.TRAPPED_CHEST) {
                        this.add(block, LootTable.lootTable().withPool(
                                (LootPool.Builder)this.applyExplosionCondition(
                                        block,
                                        LootPool.lootPool().setRolls(
                                                ConstantValue.exactly(1.0F)
                                        ).add(LootItem.lootTableItem(ModItems.OAK_TRAPPED_CHEST.get())
                                                .apply(
                                                        CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY)
                                                                .include(DataComponents.CUSTOM_NAME))))));
                    } else {
                        this.add(block, createNameableBlockEntityTable(block));
                    }
                } else if (block.getDescriptionId().contains("ice") && !block.getDescriptionId().contains("pum")) {
                    this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD.get(), ConstantValue.exactly(4.0F)));
                } else if (block.getDescriptionId().contains("snow") && block.getDescriptionId().contains("bricks")) {
                    this.add(block, this.createSingleItemTableWithSilkTouch(block, Items.SNOWBALL, ConstantValue.exactly(4.0F)));
                } else if (block instanceof GrapheneBlock) {
                    this.add(block,
                            (grapheneBlock) -> LootTable.lootTable().withPool(
                                    LootPool.lootPool().when(
                                            LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)
                                    ).add(AlternativesEntry.alternatives(
                                            new LootPoolEntryContainer.Builder[]{
                                                    AlternativesEntry.alternatives(
                                                            GrapheneBlock.LAYERS.getPossibleValues(),
                                                            (layers) -> (
                                                                    (LootPoolSingletonContainer.Builder)LootItem.lootTableItem(ModItems.CARBON_DUST.get())
                                                                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(grapheneBlock)
                                                                                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GrapheneBlock.LAYERS, layers))))
                                                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))).when(this.doesNotHaveSilkTouch()),
                                                    AlternativesEntry.alternatives(GrapheneBlock.LAYERS.getPossibleValues(),
                                                            (layers) -> (LootPoolEntryContainer.Builder)(layers == 8 ? LootItem.lootTableItem(ModItems.GRAPHITE.get()) : LootItem.lootTableItem(ModItems.GRAPHENE.get())
                                                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))
                                                                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(grapheneBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GrapheneBlock.LAYERS, layers)))))}))));
                } else if (block instanceof CarbonBlock) {
                    this.add(block, LootTable.lootTable()
                            .withPool(
                                    LootPool.lootPool()
                                            .setRolls(ConstantValue.exactly(1))
                                            .add(
                                                    LootItem.lootTableItem(ModItems.CARBON_BLOCK.get())
                                                            .when(this.hasSilkTouch())
                                                            .otherwise(
                                                                    LootItem.lootTableItem(ModItems.CARBON_DUST)
                                                                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                                                            )
                                            )
                            )
                    );
                } else {
                    this.dropSelf(block);
                }
            }
        );
    }
}
