package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.*;
import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
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
                ModBlocks.BLOCKS.getEntries().stream().map(Supplier::get)
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    protected Iterable<Block> getBOPBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTags = Set.of(

        );

        Set<Block> handMadeBlocks = Set.of(

        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTags.stream(),
                CompatModBlocks.BOP_BLOCKS.getEntries().stream().map(Supplier::get)
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
                        } else if (block.getDescriptionId().contains("resin")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                            } else {

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
                    } else if (!block.getDescriptionId().contains("chain") || !block.getDescriptionId().contains("lantern")) {
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(block);
                        }
                    } else if (block instanceof ChainBlock) {
                        tag(BlockTags.CHAINS).add(block);
                    } else if (block instanceof TorchBlock) {
                        tag(BlockTags.WALL_POST_OVERRIDE).add(block);
                    } else if (block instanceof LanternBlock) {
                        tag(BlockTags.LANTERNS).add(block);
                    }
                }
        );

        getBOPBlocks().forEach(
                block -> {
                    if ((block instanceof BasePressurePlateBlock) || block.getDescriptionId().contains("mosaic") || block.getDescriptionId().contains("oak") || block.getDescriptionId().contains("dead") || block.getDescriptionId().contains("empyreal") || block.getDescriptionId().contains("fir") || block.getDescriptionId().contains("jacaranda") || block.getDescriptionId().contains("magic") || block.getDescriptionId().contains("mahogany") || block.getDescriptionId().contains("maple") || block.getDescriptionId().contains("palm") || block.getDescriptionId().contains("pine") || block.getDescriptionId().contains("redwood") || block.getDescriptionId().contains("umbran") || block.getDescriptionId().contains("willow") || (block instanceof CraftingTableBlock) || (block instanceof ChestBlock) || (block instanceof BarrelBlock) || (block instanceof CampfireBlock) || (block instanceof CartographyTableBlock) || (block instanceof BeehiveBlock) || (block instanceof ChiseledBookShelfBlock) || (block instanceof SmithingTableBlock) || (block instanceof LoomBlock) || block.getDescriptionId().contains("bookshelf") || block.getDescriptionId().contains("snow") || block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk")) {
                        if (block instanceof BasePressurePlateBlock) {
                            tag(BlockTags.PRESSURE_PLATES).addOptional(block);
                        } else if (block instanceof CraftingTableBlock) {
                            tag(ModBlockTags.CRAFTING_TABLES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof CartographyTableBlock) {
                            tag(ModBlockTags.CARTOGRAPHY_TABLES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof FletchingTableBlock) {
                            tag(ModBlockTags.FLETCHING_TABLES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof SmithingTableBlock) {
                            tag(ModBlockTags.SMITHING_TABLES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof LoomBlock) {
                            tag(ModBlockTags.LOOMS).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof CampfireBlock) {
                            tag(BlockTags.CAMPFIRES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof BeehiveBlock) {
                            tag(ModBlockTags.BEEHIVES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block.getDescriptionId().contains("bookshelf") && !block.getDescriptionId().contains("chiseled")) {
                            tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).addOptional(block);
                            tag(ModBlockTags.BOOKSHELVES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof ChiseledBookShelfBlock) {
                            tag(ModBlockTags.CHISELED_BOOKSHELVES).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof LecternBlock) {
                            tag(ModBlockTags.LECTERNS).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof BarrelBlock) {
                            tag(ModBlockTags.BARRELS).addOptional(block);
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block instanceof ChestBlock || block instanceof TrappedChestBlock) {
                            tag(BlockTags.GUARDED_BY_PIGLINS).addOptional(block);
                            tag(ModBlockTags.WOODEN_CHESTS).addOptional(block);
                            if (block instanceof TrappedChestBlock){
                                tag(ModBlockTags.TRAPPED_CHESTS).addOptional(block);
                            }
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block.getDescriptionId().contains("mosaic")) {
                            tag(BlockTags.MINEABLE_WITH_AXE).addOptional(block);
                        } else if (block.getDescriptionId().contains("snow")) {
                            tag(BlockTags.MINEABLE_WITH_SHOVEL).addOptional(block);
                        } else if (block.getDescriptionId().contains("sculk")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(block);
                            } else {
                                tag(BlockTags.MINEABLE_WITH_HOE).addOptional(block);
                            }
                        } else if (block.getDescriptionId().contains("resin")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(block);
                            } else {

                            }
                        }
                    } else {
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).addOptional(block);
                    }
                    if (block instanceof SlabBlock){
                        tag(BlockTags.SLABS).addOptional(block);
                    }
                    else if (block instanceof StairBlock) {
                        tag(BlockTags.STAIRS).addOptional(block);
                    }
                    else if (block instanceof DoorBlock) {
                        tag(BlockTags.DOORS).addOptional(block);
                    }
                    else if (block instanceof TrapDoorBlock) {
                        tag(BlockTags.TRAPDOORS).addOptional(block);
                    }
                    else if (block instanceof WallBlock) {
                        tag(BlockTags.WALLS).addOptional(block);
                    }
                    else if (block instanceof FenceBlock) {
                        tag(BlockTags.FENCES).addOptional(block);
                    }
                    else if (block instanceof GrindstoneBlock) {
                        tag(ModBlockTags.GRINDSTONES).addOptional(block);
                    } else if (block instanceof FurnaceBlock) {
                        tag(ModBlockTags.FURNACES).addOptional(block);
                    } else if (block instanceof SmokerBlock) {
                        tag(ModBlockTags.SMOKERS).addOptional(block);
                    } else if (block instanceof BlastFurnaceBlock) {
                        tag(ModBlockTags.BLAST_FURNACES).addOptional(block);
                    } else if (block instanceof BrewingStandBlock) {
                        tag(ModBlockTags.BREWING_STANDS).addOptional(block);
                    } else if (block instanceof DispenserBlock) {
                        tag(ModBlockTags.DISPENSERS).addOptional(block);
                    } else if (block instanceof DropperBlock) {
                        tag(ModBlockTags.DROPPERS).addOptional(block);
                    } else if (block instanceof ObserverBlock) {
                        tag(ModBlockTags.OBSERVERS).addOptional(block);
                    } else if (block instanceof CrafterBlock) {
                        tag(ModBlockTags.CRAFTERS).addOptional(block);
                    } else if (!block.getDescriptionId().contains("chain") || !block.getDescriptionId().contains("lantern")) {
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).addOptional(block);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).addOptional(block);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).addOptional(block);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addOptional(block);
                        }
                    } else if (block instanceof ChainBlock) {
                        tag(BlockTags.CHAINS).addOptional(block);
                    } else if (block instanceof TorchBlock) {
                        tag(BlockTags.WALL_POST_OVERRIDE).addOptional(block);
                    } else if (block instanceof LanternBlock) {
                        tag(BlockTags.LANTERNS).addOptional(block);
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

        tag(ModBlockTags.GALVANIZES_IRON)
                .add(ModBlocks.ZINC_BLOCK.get())
                .add(ModBlocks.EXPOSED_ZINC.get())
                .add(ModBlocks.WEATHERED_ZINC.get())
                .add(ModBlocks.CORRODED_ZINC.get())
                .add(ModBlocks.WAXED_ZINC_BLOCK.get())
                .add(ModBlocks.WAXED_EXPOSED_ZINC.get())
                .add(ModBlocks.WAXED_WEATHERED_ZINC.get())
                .add(ModBlocks.WAXED_CORRODED_ZINC.get())
                .add(ModBlocks.CUT_ZINC.get())
                .add(ModBlocks.EXPOSED_CUT_ZINC.get())
                .add(ModBlocks.WEATHERED_CUT_ZINC.get())
                .add(ModBlocks.CORRODED_CUT_ZINC.get())
                .add(ModBlocks.WAXED_CUT_ZINC.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_ZINC.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_ZINC.get())
                .add(ModBlocks.WAXED_CORRODED_CUT_ZINC.get())
                .add(ModBlocks.CUT_ZINC_SLAB.get())
                .add(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.CORRODED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.WAXED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get())
                .add(ModBlocks.CUT_ZINC_STAIRS.get())
                .add(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.CORRODED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.WAXED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get())
                .add(ModBlocks.ZINC_DOOR.get())
                .add(ModBlocks.EXPOSED_ZINC_DOOR.get())
                .add(ModBlocks.WEATHERED_ZINC_DOOR.get())
                .add(ModBlocks.CORRODED_ZINC_DOOR.get())
                .add(ModBlocks.WAXED_ZINC_DOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get())
                .add(ModBlocks.WAXED_CORRODED_ZINC_DOOR.get())
                .add(ModBlocks.ZINC_TRAPDOOR.get())
                .add(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.CORRODED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.WAXED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get())
                .add(ModBlocks.ZINC_CHAIN.get())
                .add(ModBlocks.EXPOSED_ZINC_CHAIN.get())
                .add(ModBlocks.WEATHERED_ZINC_CHAIN.get())
                .add(ModBlocks.CORRODED_ZINC_CHAIN.get())
                .add(ModBlocks.WAXED_ZINC_CHAIN.get())
                .add(ModBlocks.WAXED_EXPOSED_ZINC_CHAIN.get())
                .add(ModBlocks.WAXED_WEATHERED_ZINC_CHAIN.get())
                .add(ModBlocks.WAXED_CORRODED_ZINC_CHAIN.get())
                .add(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                .add(ModBlocks.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        tag(ModBlockTags.SHATTERABLE_BY_SHARPENED_ARROW)
                .add(Blocks.GLASS)
                .add(Blocks.GLASS_PANE)
                .add(Blocks.TINTED_GLASS)
                .add(Blocks.WHITE_STAINED_GLASS)
                .add(Blocks.ORANGE_STAINED_GLASS)
                .add(Blocks.MAGENTA_STAINED_GLASS)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS)
                .add(Blocks.YELLOW_STAINED_GLASS)
                .add(Blocks.LIME_STAINED_GLASS)
                .add(Blocks.PINK_STAINED_GLASS)
                .add(Blocks.GRAY_STAINED_GLASS)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS)
                .add(Blocks.CYAN_STAINED_GLASS)
                .add(Blocks.PURPLE_STAINED_GLASS)
                .add(Blocks.BLUE_STAINED_GLASS)
                .add(Blocks.BROWN_STAINED_GLASS)
                .add(Blocks.GREEN_STAINED_GLASS)
                .add(Blocks.RED_STAINED_GLASS)
                .add(Blocks.BLACK_STAINED_GLASS)
                .add(Blocks.WHITE_STAINED_GLASS_PANE)
                .add(Blocks.ORANGE_STAINED_GLASS_PANE)
                .add(Blocks.MAGENTA_STAINED_GLASS_PANE)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)
                .add(Blocks.YELLOW_STAINED_GLASS_PANE)
                .add(Blocks.LIME_STAINED_GLASS_PANE)
                .add(Blocks.PINK_STAINED_GLASS_PANE)
                .add(Blocks.GRAY_STAINED_GLASS_PANE)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)
                .add(Blocks.CYAN_STAINED_GLASS_PANE)
                .add(Blocks.PURPLE_STAINED_GLASS_PANE)
                .add(Blocks.BLUE_STAINED_GLASS_PANE)
                .add(Blocks.BROWN_STAINED_GLASS_PANE)
                .add(Blocks.GREEN_STAINED_GLASS_PANE)
                .add(Blocks.RED_STAINED_GLASS_PANE)
                .add(Blocks.BLACK_STAINED_GLASS_PANE)
                .addTags(BlockTags.FLOWER_POTS)
                .addTags(BlockTags.LEAVES);
    }
}
