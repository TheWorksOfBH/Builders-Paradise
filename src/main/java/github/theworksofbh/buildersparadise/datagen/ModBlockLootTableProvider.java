package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.block.ModDoorBlock;
import github.theworksofbh.buildersparadise.block.ModSlabBlock;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
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
                Blocks.FLETCHING_TABLE
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
                    this.add(block, createSlabItemTable(block));
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
                } else {
                    this.dropSelf(block);
                }
            }
        );
    }
}
