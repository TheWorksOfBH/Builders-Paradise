package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.*;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BuildersParadise.MODID);
    }

    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTags = Set.of(
                Blocks.CRAFTING_TABLE,
                Blocks.CARTOGRAPHY_TABLE,
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

        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTags.stream(),
                ModBlocks.BLOCKS.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownBlocks().forEach(
                block -> {
                    if ((block instanceof BasePressurePlateBlock) || block.getDescriptionId().contains("mosaic") || block.getDescriptionId().contains("oak") || block.getDescriptionId().contains("spruce") || block.getDescriptionId().contains("birch") || block.getDescriptionId().contains("jungle") || block.getDescriptionId().contains("acacia") || block.getDescriptionId().contains("crimson") || block.getDescriptionId().contains("warped") || block.getDescriptionId().contains("mangrove") || block.getDescriptionId().contains("cherry") || block.getDescriptionId().contains("bamboo") || (block instanceof CraftingTableBlock) || (block instanceof ChestBlock) || (block instanceof BarrelBlock) || (block instanceof CampfireBlock) || (block instanceof CartographyTableBlock) || (block instanceof BeehiveBlock) || (block instanceof ChiseledBookShelfBlock) || (block instanceof SmithingTableBlock) || (block instanceof LoomBlock) || block.getDescriptionId().contains("bookshelf") || block.getDescriptionId().contains("snow") || block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk")) {
                        if (block instanceof BasePressurePlateBlock) {
                            tag(BlockTags.PRESSURE_PLATES).add(block);
                        } else if (block instanceof CraftingTableBlock) {
                            tag(ModBlockTags.CRAFTING_TABLES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof CartographyTableBlock) {
                            tag(ModBlockTags.CARTOGRAPHY_TABLES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof FletchingTableBlock) {
                            tag(ModBlockTags.FLETCHING_TABLES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof SmithingTableBlock) {
                            tag(ModBlockTags.SMITHING_TABLES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof LoomBlock) {
                            tag(ModBlockTags.LOOMS).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof CampfireBlock) {
                            tag(BlockTags.CAMPFIRES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof BeehiveBlock) {
                            tag(ModBlockTags.BEEHIVES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block.getDescriptionId().contains("bookshelf") && !block.getDescriptionId().contains("chiseled")) {
                            tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(block);
                            tag(ModBlockTags.BOOKSHELVES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof ChiseledBookShelfBlock) {
                            tag(ModBlockTags.CHISELED_BOOKSHELVES).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof LecternBlock) {
                            tag(ModBlockTags.LECTERNS).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof BarrelBlock) {
                            tag(ModBlockTags.BARRELS).add(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block instanceof ChestBlock || block instanceof TrappedChestBlock) {
                            tag(BlockTags.GUARDED_BY_PIGLINS).add(block);
                            tag(ModBlockTags.WOODEN_CHESTS).add(block);
                            if (block instanceof TrappedChestBlock){
                                tag(ModBlockTags.TRAPPED_CHESTS).add(block);
                            }
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block.getDescriptionId().contains("mosaic")) {
                            tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        } else if (block.getDescriptionId().contains("snow")) {
                            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
                        } else if (block.getDescriptionId().contains("sculk")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                            } else {
                                tag(BlockTags.MINEABLE_WITH_HOE).add(block);
                            }
                        }
                    } else {
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                    }
                    if (block instanceof SlabBlock){
                        tag(BlockTags.SLABS).add(block);
                    }
                    else if (block instanceof StairBlock) {
                        tag(BlockTags.STAIRS).add(block);
                    }
                    else if (block instanceof DoorBlock) {
                        tag(BlockTags.DOORS).add(block);
                    }
                    else if (block instanceof TrapDoorBlock) {
                        tag(BlockTags.TRAPDOORS).add(block);
                    }
                    else if (block instanceof WallBlock) {
                        tag(BlockTags.WALLS).add(block);
                    }
                    else if (block instanceof FenceBlock) {
                        tag(BlockTags.FENCES).add(block);
                    }
                    else if (block instanceof GrindstoneBlock) {
                        tag(ModBlockTags.GRINDSTONES).add(block);
                    } else if (block instanceof FurnaceBlock) {
                        tag(ModBlockTags.FURNACES).add(block);
                    } else if (block instanceof SmokerBlock) {
                        tag(ModBlockTags.SMOKERS).add(block);
                    } else if (block instanceof BlastFurnaceBlock) {
                        tag(ModBlockTags.BLAST_FURNACES).add(block);
                    } else if (block instanceof BrewingStandBlock) {
                        tag(ModBlockTags.BREWING_STANDS).add(block);
                    } else if (block instanceof DispenserBlock) {
                        tag(ModBlockTags.DISPENSERS).add(block);
                    } else if (block instanceof DropperBlock) {
                        tag(ModBlockTags.DROPPERS).add(block);
                    } else if (block instanceof ObserverBlock) {
                        tag(ModBlockTags.OBSERVERS).add(block);
                    } else if (block instanceof CrafterBlock) {
                        tag(ModBlockTags.CRAFTERS).add(block);
                    } else if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                        tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                    } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium")) {
                        tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                    } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                    } else if (block.getDescriptionId().contains("tungsten")) {
                        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(block);
                    } else if (block instanceof ChainBlock) {
                        tag(BlockTags.CHAINS).add(block);
                    }
                }
        );

        tag(ModBlockTags.ZINC_ORES).add(ModBlocks.ZINC_ORE.get()).add(ModBlocks.DEEPSLATE_ZINC_ORE.get());
        tag(ModBlockTags.SILVER_ORES).add(ModBlocks.SILVER_ORE.get()).add(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        tag(ModBlockTags.TIN_ORES).add(ModBlocks.TIN_ORE.get()).add(ModBlocks.DEEPSLATE_TIN_ORE.get());
        tag(ModBlockTags.TUNGSTEN_ORES).add(ModBlocks.TUNGSTEN_ORE.get()).add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        tag(ModBlockTags.PLATINUM_ORES).add(ModBlocks.PLATINUM_ORE.get()).add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        tag(ModBlockTags.LEAD_ORES).add(ModBlocks.LEAD_ORE.get()).add(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(ModBlockTags.URANIUM_ORES).add(ModBlocks.URANIUM_ORE.get()).add(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
        tag(ModBlockTags.IRON).add(Blocks.IRON_BLOCK).add(ModBlocks.EXPOSED_IRON.get()).add(ModBlocks.WEATHERED_IRON.get()).add(ModBlocks.RUSTED_IRON.get()).add(ModBlocks.WAXED_IRON_BLOCK.get()).add(ModBlocks.WAXED_EXPOSED_IRON.get()).add(ModBlocks.WAXED_WEATHERED_IRON.get()).add(ModBlocks.WAXED_RUSTED_IRON.get());
        tag(ModBlockTags.ZINC).add(ModBlocks.ZINC_BLOCK.get()).add(ModBlocks.EXPOSED_ZINC.get()).add(ModBlocks.WEATHERED_ZINC.get()).add(ModBlocks.CORRODED_ZINC.get()).add(ModBlocks.WAXED_ZINC_BLOCK.get()).add(ModBlocks.WAXED_EXPOSED_ZINC.get()).add(ModBlocks.WAXED_WEATHERED_ZINC.get()).add(ModBlocks.WAXED_CORRODED_ZINC.get());

        tag(BlockTags.BEACON_BASE_BLOCKS).addTag(ModBlockTags.IRON).add(ModBlocks.BRONZE_BLOCK.get()).add(ModBlocks.SILVER_BLOCK.get()).add(ModBlocks.PLATINUM_BLOCK.get());
        tag(ModBlockTags.INCORRECT_FOR_BRONZE_TOOL).addTag(BlockTags.INCORRECT_FOR_COPPER_TOOL);
    }
}
