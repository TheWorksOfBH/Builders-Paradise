package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.types.*;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewLootTables = Set.of(
                Blocks.STONE_SLAB,
                Blocks.STONE_STAIRS,
                Blocks.ICE,
                Blocks.PACKED_ICE,
                Blocks.BLUE_ICE
        );

        Set<Block> handMadeBlocks = Set.of(
                ModBlocks.NUCLEAR_WASTE
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewLootTables.stream(),
                BuiltInRegistries.BLOCK.stream()
                        .filter(block ->
                                BuiltInRegistries.BLOCK.getKey(block)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
                        )
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

    public void generate(){
        getKnownBlocks().forEach(
                block -> {
                    if (block instanceof SlabBlock){
                        if (block == Blocks.STONE_SLAB) {
                            this.add(block, createSilkTouchSlabItemTable(block, Items.COBBLESTONE_SLAB));
                        } else if (block == ModBlocks.DEEPSLATE_SLAB) {
                            this.add(block, createSilkTouchSlabItemTable(block, Items.COBBLED_DEEPSLATE_SLAB));
                        } else if (block == ModBlocks.SNOW_SLAB || block == ModBlocks.SNOW_BRICK_SLAB) {
                            this.add(block, createColdSlabItemTable(block, Items.SNOWBALL));
                        } else if (block == ModBlocks.ICE_SLAB || block == ModBlocks.PACKED_ICE_SLAB || block == ModBlocks.BLUE_ICE_SLAB || block == ModBlocks.ICE_BRICK_SLAB || block == ModBlocks.PACKED_ICE_BRICK_SLAB || block == ModBlocks.BLUE_ICE_BRICK_SLAB) {
                            this.add(block, createColdSlabItemTable(block, ModItems.ICE_SHARD));
                        } else if (block == ModBlocks.GILDED_BLACKSTONE_SLAB) {
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
                    } else if (block instanceof StairBlock) {
                        if (block == Blocks.STONE_STAIRS) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLESTONE_STAIRS));
                        } else if (block == ModBlocks.DEEPSLATE_STAIRS) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLED_DEEPSLATE_STAIRS));
                        } else if (block == ModBlocks.SNOW_STAIRS || block == ModBlocks.SNOW_BRICK_STAIRS) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL, ConstantValue.exactly(3.0F)));
                        } else if (block == ModBlocks.ICE_STAIRS || block == ModBlocks.PACKED_ICE_STAIRS || block == ModBlocks.BLUE_ICE_STAIRS || block == ModBlocks.ICE_BRICK_STAIRS || block == ModBlocks.PACKED_ICE_BRICK_STAIRS || block == ModBlocks.BLUE_ICE_BRICK_STAIRS) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD, ConstantValue.exactly(3.0F)));
                        } else if (block == ModBlocks.GILDED_BLACKSTONE_STAIRS) {
                            this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                        } else  {
                            this.dropSelf(block);
                        }
                    } else if (block instanceof WallBlock) {
                        if (block == ModBlocks.STONE_WALL) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLESTONE_WALL));
                        } else if (block == ModBlocks.DEEPSLATE_WALL) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.COBBLED_DEEPSLATE_WALL));
                        } else if (block == ModBlocks.SNOW_WALL || block == ModBlocks.SNOW_BRICK_WALL) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL));
                        } else if (block == ModBlocks.ICE_WALL || block == ModBlocks.PACKED_ICE_WALL || block == ModBlocks.BLUE_ICE_WALL || block == ModBlocks.ICE_BRICK_WALL || block == ModBlocks.PACKED_ICE_BRICK_WALL || block == ModBlocks.BLUE_ICE_BRICK_WALL) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD));
                        } else if (block == ModBlocks.GILDED_BLACKSTONE_WALL) {
                            this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                        } else {
                            this.dropSelf(block);
                        }
                    } else if (block instanceof FenceBlock) {
                        if (block == ModBlocks.STONE_FENCE) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, ModBlocks.COBBLESTONE_FENCE.asItem()));
                        } else if (block == ModBlocks.DEEPSLATE_FENCE) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, ModBlocks.COBBLED_DEEPSLATE_FENCE.asItem()));
                        } else if (block == ModBlocks.SNOW_FENCE || block == ModBlocks.SNOW_BRICK_FENCE) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, Items.SNOWBALL));
                        } else if (block == ModBlocks.ICE_FENCE || block == ModBlocks.PACKED_ICE_FENCE || block == ModBlocks.BLUE_ICE_FENCE || block == ModBlocks.ICE_BRICK_FENCE || block == ModBlocks.PACKED_ICE_BRICK_FENCE || block == ModBlocks.BLUE_ICE_BRICK_FENCE) {
                            this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD));
                        } else if (block == ModBlocks.GILDED_BLACKSTONE_FENCE) {
                            this.add(block, (block1) -> this.createSilkTouchDispatchTable(block1, this.applyExplosionCondition(block1, (LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}))).otherwise(LootItem.lootTableItem(block1)))));
                        } else {
                            this.dropSelf(block);
                        }
                    } else if (block instanceof DoorBlock) {
                        if (block.getDescriptionId().contains("glass") && !block.getDescriptionId().contains("tinted")) {
                            this.add(block, createGlassDoorLootTable(block));
                        } else {
                            this.add(block, createDoorTable(block));
                        }
                    } else if (block instanceof TrapDoorBlock) {
                        if (block instanceof TransparentTrapDoorBlock || block instanceof StainedTrapDoorBlock) {
                            this.dropWhenSilkTouch(block);
                        } else {
                            this.dropSelf(block);
                        }
                    } else if (block instanceof DropExperienceBlock) {
                        if (block == ModBlocks.ZINC_ORE || block == ModBlocks.DEEPSLATE_ZINC_ORE) {
                            this.add(block, createOreDrop(block, ModItems.RAW_ZINC));
                        } else if (block == ModBlocks.SILVER_ORE || block == ModBlocks.DEEPSLATE_SILVER_ORE) {
                            this.add(block, createOreDrop(block, ModItems.RAW_SILVER));
                        } else if (block == ModBlocks.TIN_ORE || block == ModBlocks.DEEPSLATE_TIN_ORE) {
                            this.add(block, createMultipleOreDrops(block, ModItems.RAW_TIN, 3.0F, 5.0F));
                        } else if (block == ModBlocks.TUNGSTEN_ORE || block == ModBlocks.DEEPSLATE_TUNGSTEN_ORE) {
                            this.add(block, createOreDrop(block, ModItems.RAW_TUNGSTEN));
                        } else if (block == ModBlocks.PLATINUM_ORE || block == ModBlocks.DEEPSLATE_PLATINUM_ORE) {
                            this.add(block, createOreDrop(block, ModItems.RAW_PLATINUM));
                        } else if (block == ModBlocks.LEAD_ORE || block == ModBlocks.DEEPSLATE_LEAD_ORE) {
                            this.add(block, createMultipleOreDrops(block, ModItems.RAW_LEAD, 3.0F, 5.0F));
                        } else if (block == ModBlocks.BISMUTH_ORE || block == ModBlocks.DEEPSLATE_BISMUTH_ORE) {
                            this.add(block, createMultipleOreDrops(block, ModItems.RAW_BISMUTH, 3.0F, 5.0F));
                        } else if (block == ModBlocks.URANIUM_ORE || block == ModBlocks.DEEPSLATE_URANIUM_ORE) {
                            this.add(block, createMultipleOreDrops(block, ModItems.RAW_URANIUM, 2.0F, 4.0F));
                        } else if (block == ModBlocks.NETHER_MONOCRYSTAL_ORE) {
                            this.add(block, createOreDrop(block, ModItems.MONOCRYSTAL));
                        } else if (block == ModBlocks.RUBY_ORE || block == ModBlocks.DEEPSLATE_RUBY_ORE) {
                            this.add(block, createOreDrop(block, ModItems.RUBY));
                        } else if (block == ModBlocks.SAPPHIRE_ORE || block == ModBlocks.DEEPSLATE_SAPPHIRE_ORE) {
                            this.add(block, createOreDrop(block, ModItems.SAPPHIRE));
                        }
                    } else if (block instanceof FurnaceBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof SmokerBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof BlastFurnaceBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof CampfireBlock) {
                        this.add(block, (campfire) -> this.createSilkTouchDispatchTable(campfire, (LootPoolEntryContainer.Builder)this.applyExplosionCondition(campfire, LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))));
                    } else if (block.getDescriptionId().contains("bookshelf") && !block.getDescriptionId().contains("chiselled")) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
                    } else if (block instanceof ChiseledBookShelfBlock) {
                        this.dropWhenSilkTouch(block);
                    } else if (block instanceof BrewingStandBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof BarrelBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof DispenserBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof DropperBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof ChestBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block instanceof TrappedChestBlock) {
                        this.add(block, createNameableBlockEntityTable(block));
                    } else if (block.getDescriptionId().contains("ice") && !block.getDescriptionId().contains("pum")) {
                        this.add(block, createSingleItemTableWithSilkTouch(block, ModItems.ICE_SHARD, ConstantValue.exactly(4.0F)));
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
                                                                        (LootPoolSingletonContainer.Builder)LootItem.lootTableItem(ModItems.CARBON_DUST)
                                                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(grapheneBlock)
                                                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GrapheneBlock.LAYERS, layers))))
                                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))).when(this.doesNotHaveSilkTouch()),
                                                        AlternativesEntry.alternatives(GrapheneBlock.LAYERS.getPossibleValues(),
                                                                (layers) -> (LootPoolEntryContainer.Builder)(layers == 8 ? LootItem.lootTableItem(ModBlocks.GRAPHITE.asItem()) : LootItem.lootTableItem(ModBlocks.GRAPHENE.asItem())
                                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(grapheneBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GrapheneBlock.LAYERS, layers)))))}))));
                    } else if (block instanceof SiliceneBlock) {
                        this.add(block,
                                (siliceneBlock) -> LootTable.lootTable().withPool(
                                        LootPool.lootPool().when(
                                                LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)
                                        ).add(AlternativesEntry.alternatives(
                                                new LootPoolEntryContainer.Builder[]{
                                                        AlternativesEntry.alternatives(
                                                                GrapheneBlock.LAYERS.getPossibleValues(),
                                                                (layers) -> (
                                                                        (LootPoolSingletonContainer.Builder)LootItem.lootTableItem(ModItems.SILICON_DUST)
                                                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(siliceneBlock)
                                                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SiliceneBlock.LAYERS, layers))))
                                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))).when(this.doesNotHaveSilkTouch()),
                                                        AlternativesEntry.alternatives(SiliceneBlock.LAYERS.getPossibleValues(),
                                                                (layers) -> (LootPoolEntryContainer.Builder)(layers == 8 ? LootItem.lootTableItem(ModBlocks.SILICITE) : LootItem.lootTableItem(ModBlocks.SILICENE.asItem())
                                                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float)layers)))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(siliceneBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SiliceneBlock.LAYERS, layers)))))}))));
                    } else if (block instanceof CarbonBlock) {
                        this.add(block, LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .setRolls(ConstantValue.exactly(1))
                                                .add(
                                                        LootItem.lootTableItem(ModBlocks.CARBON_BLOCK.asItem())
                                                                .when(this.hasSilkTouch())
                                                                .otherwise(
                                                                        LootItem.lootTableItem(ModItems.CARBON_DUST)
                                                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                                                                )
                                                )
                                )
                        );
                    } else if (block instanceof SiliconBlock) {
                        this.add(block, LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .setRolls(ConstantValue.exactly(1))
                                                .add(
                                                        LootItem.lootTableItem(ModBlocks.SILICON_BLOCK.asItem())
                                                                .when(this.hasSilkTouch())
                                                                .otherwise(
                                                                        LootItem.lootTableItem(ModItems.SILICON_DUST)
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