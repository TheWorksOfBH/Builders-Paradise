package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.block.ModDoorBlock;
import github.theworksofbh.buildersparadise.block.ModSlabBlock;
import github.theworksofbh.buildersparadise.block.ModStairBlock;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
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
                Blocks.TRAPPED_CHEST
        );

        Set<Block> handMadeBlocks = Set.of(
                ModBlocks.NUCLEAR_WASTE.get()
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewLootTables.stream(),
                ModBlocks.BLOCKS.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected void generate(){
        getKnownBlocks().forEach(
            block -> {
                if (block instanceof SlabBlock || block instanceof ModSlabBlock){
                    if (block == Blocks.STONE_SLAB) {
                        this.add(block, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Blocks.COBBLESTONE_SLAB)
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
                    } else if (block == ModBlocks.DEEPSLATE_SLAB.get()) {
                        this.add(block, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Blocks.COBBLED_DEEPSLATE_SLAB)
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
                    } else {
                        this.add(block, createSlabItemTable(block));
                    }
                } else if (block instanceof StairBlock || block instanceof ModStairBlock) {
                    if (block == Blocks.STONE_STAIRS) {
                        this.dropOther(block, Items.COBBLESTONE_STAIRS);
                    } else if (block == ModBlocks.DEEPSLATE_STAIRS.get()) {
                        this.dropOther(block, Items.COBBLED_DEEPSLATE_STAIRS);
                    } else {
                        this.dropSelf(block);
                    }
                } else if (block instanceof WallBlock) {
                    if (block == ModBlocks.STONE_WALL.get()) {
                        this.dropOther(block, Items.COBBLESTONE_WALL);
                    } else if (block == ModBlocks.DEEPSLATE_WALL.get()) {
                        this.dropOther(block, Items.COBBLED_DEEPSLATE_WALL);
                    } else {
                        this.dropSelf(block);
                    }
                } else if (block instanceof DoorBlock || block instanceof ModDoorBlock) {
                    this.add(block, createDoorTable(block));
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
                } else if (block == Blocks.CAMPFIRE) {
                    this.dropOther(block, ModItems.OAK_CAMPFIRE.get());
                } else if (block == Blocks.SOUL_CAMPFIRE) {
                    this.dropOther(block, ModItems.OAK_SOUL_CAMPFIRE.get());
                } else if (block == Blocks.BEEHIVE) {
                    this.dropOther(block, ModItems.OAK_BEEHIVE.get());
                } else if (block.getName().contains(Component.nullToEmpty("bookshelf")) && !block.getName().contains(Component.nullToEmpty("chiselled"))) {
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
                } else {
                    this.dropSelf(block);
                }
            }
        );
    }
}
