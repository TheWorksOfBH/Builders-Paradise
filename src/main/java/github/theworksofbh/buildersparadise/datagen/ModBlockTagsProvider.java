package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.FletchingTableBlock;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.block.ModIronBarsBlock;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
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

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownBlocks().forEach(
                block -> {
                    ResourceKey<Block> blockResourceKey = BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
                    if ((block instanceof BasePressurePlateBlock) || block.getDescriptionId().contains("mosaic") || block.getDescriptionId().contains("oak") || block.getDescriptionId().contains("spruce") || block.getDescriptionId().contains("birch") || block.getDescriptionId().contains("jungle") || block.getDescriptionId().contains("acacia") || block.getDescriptionId().contains("crimson") || block.getDescriptionId().contains("warped") || block.getDescriptionId().contains("mangrove") || block.getDescriptionId().contains("cherry") || block.getDescriptionId().contains("bamboo") || (block instanceof CraftingTableBlock) || (block instanceof ChestBlock) || (block instanceof BarrelBlock) || (block instanceof CampfireBlock) || (block instanceof CartographyTableBlock) || (block instanceof BeehiveBlock) || (block instanceof ChiseledBookShelfBlock) || (block instanceof SmithingTableBlock) || (block instanceof LoomBlock) || block.getDescriptionId().contains("bookshelf") || block.getDescriptionId().contains("snow") || block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk") || block.getDescriptionId().contains("carbon")) {
                        if (block instanceof BasePressurePlateBlock) {
                            tag(BlockTags.PRESSURE_PLATES).add(blockResourceKey);
                        } else if (block instanceof CraftingTableBlock) {
                            tag(ModBlockTags.CRAFTING_TABLES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof CartographyTableBlock) {
                            tag(ModBlockTags.CARTOGRAPHY_TABLES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof FletchingTableBlock) {
                            tag(ModBlockTags.FLETCHING_TABLES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof SmithingTableBlock) {
                            tag(ModBlockTags.SMITHING_TABLES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof LoomBlock) {
                            tag(ModBlockTags.LOOMS).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof CampfireBlock) {
                            tag(BlockTags.CAMPFIRES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof BeehiveBlock) {
                            tag(ModBlockTags.BEEHIVES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("bookshelf") && !block.getDescriptionId().contains("chiseled")) {
                            tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(blockResourceKey);
                            tag(ModBlockTags.BOOKSHELVES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof ChiseledBookShelfBlock) {
                            tag(ModBlockTags.CHISELED_BOOKSHELVES).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof LecternBlock) {
                            tag(ModBlockTags.LECTERNS).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof BarrelBlock) {
                            tag(ModBlockTags.BARRELS).add(blockResourceKey);
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block instanceof ChestBlock || block instanceof TrappedChestBlock) {
                            tag(BlockTags.GUARDED_BY_PIGLINS).add(blockResourceKey);
                            tag(ModBlockTags.WOODEN_CHESTS).add(blockResourceKey);
                            if (block instanceof TrappedChestBlock){
                                tag(ModBlockTags.TRAPPED_CHESTS).add(blockResourceKey);
                            }
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("mosaic")) {
                            tag(BlockTags.MINEABLE_WITH_AXE).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("snow")) {
                            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("carbon")) {
                            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("sculk")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                            } else {
                                tag(BlockTags.MINEABLE_WITH_HOE).add(blockResourceKey);
                            }
                        } else if (block.getDescriptionId().contains("resin")) {
                            if (block.getDescriptionId().contains("brick")) {
                                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                            } else {

                            }
                        }
                    } else {
                        if (block instanceof TorchBlock || block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk") && !block.getDescriptionId().contains("brick")) {
                            tag(BlockTags.MINEABLE_WITH_PICKAXE).remove(blockResourceKey);
                        } else {
                            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                        }
                    }
                    if (block instanceof SlabBlock){
                        tag(BlockTags.SLABS).add(blockResourceKey);
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("ruby") || block.getDescriptionId().contains("sapphire") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("monocrystal") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium") || block.getDescriptionId().contains("bismuth")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                    else if (block instanceof StairBlock) {
                        tag(BlockTags.STAIRS).add(blockResourceKey);
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("ruby") || block.getDescriptionId().contains("sapphire") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("monocrystal") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium") || block.getDescriptionId().contains("bismuth")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                    else if (block instanceof DoorBlock) {
                        tag(BlockTags.DOORS).add(blockResourceKey);
                    }
                    else if (block instanceof TrapDoorBlock) {
                        tag(BlockTags.TRAPDOORS).add(blockResourceKey);
                    }
                    else if (block instanceof WallBlock) {
                        tag(BlockTags.WALLS).add(blockResourceKey);
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("ruby") || block.getDescriptionId().contains("sapphire") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("monocrystal") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium") || block.getDescriptionId().contains("bismuth")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                    else if (block instanceof FenceBlock) {
                        tag(BlockTags.FENCES).add(blockResourceKey);
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis")|| block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting") || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("ruby") || block.getDescriptionId().contains("sapphire") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("monocrystal") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium") || block.getDescriptionId().contains("bismuth")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                    else if (block instanceof IronBarsBlock || block instanceof ModIronBarsBlock) {
                        tag(BlockTags.BARS).add(blockResourceKey);
                    }
                    else if (block instanceof GrindstoneBlock) {
                        tag(ModBlockTags.GRINDSTONES).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof FurnaceBlock) {
                        tag(ModBlockTags.FURNACES).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof SmokerBlock) {
                        tag(ModBlockTags.SMOKERS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof BlastFurnaceBlock) {
                        tag(ModBlockTags.BLAST_FURNACES).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof BrewingStandBlock) {
                        tag(ModBlockTags.BREWING_STANDS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof DispenserBlock) {
                        tag(ModBlockTags.DISPENSERS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof DropperBlock) {
                        tag(ModBlockTags.DROPPERS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof ObserverBlock) {
                        tag(ModBlockTags.OBSERVERS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                    } else if (block instanceof CrafterBlock) {
                        tag(ModBlockTags.CRAFTERS).add(blockResourceKey);
                        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockResourceKey);
                        tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                    } else if (block instanceof ChainBlock) {
                        tag(BlockTags.CHAINS).add(blockResourceKey);
                    } else if ((block instanceof TorchBlock) && !(block instanceof WallTorchBlock)) {
                        tag(BlockTags.WALL_POST_OVERRIDE).add(blockResourceKey);
                    } else if (block instanceof LanternBlock) {
                        tag(BlockTags.LANTERNS).add(blockResourceKey);
                    } else if (!(block instanceof TorchBlock)) {
                        if (block.getDescriptionId().contains("iron") || block.getDescriptionId().contains("copper") || block.getDescriptionId().contains("lapis") || (block.getDescriptionId().contains("tin") && !block.getDescriptionId().contains("crafting")) || block.getDescriptionId().contains("lead") || block.getDescriptionId().contains("bronze") || block.getDescriptionId().contains("steel")) {
                            tag(BlockTags.NEEDS_STONE_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("gold") || block.getDescriptionId().contains("ruby") || block.getDescriptionId().contains("sapphire") || block.getDescriptionId().contains("diamond") || block.getDescriptionId().contains("monocrystal") || block.getDescriptionId().contains("emerald") || block.getDescriptionId().contains("zinc") || block.getDescriptionId().contains("silver") || block.getDescriptionId().contains("platinum") || block.getDescriptionId().contains("brass") || block.getDescriptionId().contains("uranium") || block.getDescriptionId().contains("bismuth")) {
                            tag(BlockTags.NEEDS_IRON_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("obsidian") || block.getDescriptionId().contains("netherite")) {
                            tag(BlockTags.NEEDS_DIAMOND_TOOL).add(blockResourceKey);
                        } else if (block.getDescriptionId().contains("tungsten")) {
                            tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                }
        );

        tag(ModBlockTags.ZINC_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_ZINC_ORE.get()).orElseThrow());
        tag(ModBlockTags.SILVER_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE.get()).orElseThrow());
        tag(ModBlockTags.TIN_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TIN_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TIN_ORE.get()).orElseThrow());
        tag(ModBlockTags.TUNGSTEN_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get()).orElseThrow());
        tag(ModBlockTags.PLATINUM_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLATINUM_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_PLATINUM_ORE.get()).orElseThrow());
        tag(ModBlockTags.LEAD_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LEAD_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_LEAD_ORE.get()).orElseThrow());
        tag(ModBlockTags.BISMUTH_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BISMUTH_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_BISMUTH_ORE.get()).orElseThrow());
        tag(ModBlockTags.URANIUM_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.URANIUM_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_URANIUM_ORE.get()).orElseThrow());
        tag(ModBlockTags.RUBY_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RUBY_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_RUBY_ORE.get()).orElseThrow());
        tag(ModBlockTags.SAPPHIRE_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SAPPHIRE_ORE.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).orElseThrow());
        tag(ModBlockTags.IRON).add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.IRON_BLOCK).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_IRON.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_IRON.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RUSTED_IRON.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_IRON_BLOCK.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_IRON.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_IRON.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_RUSTED_IRON.get()).orElseThrow());
        tag(ModBlockTags.ZINC).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_BLOCK.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC.get()).orElseThrow());

        tag(BlockTags.BEACON_BASE_BLOCKS).addTag(ModBlockTags.IRON).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRONZE_BLOCK.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_BLOCK.get()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLATINUM_BLOCK.get()).orElseThrow());
        tag(ModBlockTags.INCORRECT_FOR_BRONZE_TOOL).addTag(BlockTags.INCORRECT_FOR_COPPER_TOOL);

        tag(ModBlockTags.GALVANIZES_IRON)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_CUT_ZINC.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_FIRE_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_SOUL_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CORRODED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_ZINC_LANTERN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_CORRODED_ZINC_LANTERN.get()).orElseThrow());

        tag(ModBlockTags.GLASS_DOORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WHITE_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ORANGE_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.MAGENTA_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIGHT_BLUE_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.YELLOW_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIME_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PINK_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAY_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIGHT_GRAY_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CYAN_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PURPLE_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BLUE_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BROWN_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GREEN_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RED_STAINED_GLASS_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BLACK_STAINED_GLASS_DOOR.get()).orElseThrow());

        tag(ModBlockTags.GLASS_TRAPDOORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WHITE_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ORANGE_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.MAGENTA_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.YELLOW_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIME_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PINK_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAY_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CYAN_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PURPLE_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BLUE_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BROWN_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GREEN_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RED_STAINED_GLASS_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BLACK_STAINED_GLASS_TRAPDOOR.get()).orElseThrow());

        tag(ModBlockTags.SHATTERABLE_BY_SHARPENED_ARROW)
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.GLASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.GLASS_PANE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TINTED_GLASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_PANE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.white()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.orange()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.magenta()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.lightBlue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.yellow()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.lime()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.pink()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.gray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.lightGray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.cyan()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.purple()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.blue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.green()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.red()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.white()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.orange()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.magenta()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.lightBlue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.yellow()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.lime()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.pink()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.gray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.lightGray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.cyan()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.purple()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.blue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.green()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.red()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.STAINED_GLASS_PANE.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.POINTED_DRIPSTONE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.VINE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.SHORT_GRASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TALL_GRASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.SHORT_DRY_GRASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TALL_DRY_GRASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.DEAD_BUSH).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.BUSH).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.SWEET_BERRY_BUSH).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.GLOW_LICHEN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.CAVE_VINES).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.CAVE_VINES_PLANT).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.WEEPING_VINES).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.WEEPING_VINES_PLANT).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TWISTING_VINES).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TWISTING_VINES_PLANT).orElseThrow())
                .addTag(BlockTags.FLOWERS)
                .addTag(BlockTags.FLOWER_POTS)
                .addTag(BlockTags.LEAVES)
                .addTag(ModBlockTags.GLASS_DOORS)
                .addTag(ModBlockTags.GLASS_TRAPDOORS);

        tag(ModBlockTags.TROMBONE_NOTE_BLOCK_SOUNDS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TIN_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LEAD_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRONZE_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRASS_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS_STAIRS.get()).orElseThrow());

        tag(BlockTags.DRAGON_IMMUNE)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_BRICK_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXPOSED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WEATHERED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RUSTED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_EXPOSED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_WEATHERED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.WAXED_RUSTED_IRON_BARS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICKS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICKS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_FENCE.get()).orElseThrow());

        tag(ModBlockTags.COMPRESSES_CARBON)
                .addTag(ModBlockTags.HIGH_PRESSURE_COMPRESSORS)
                .addTag(ModBlockTags.LOW_PRESSURE_COMPRESSORS);

        tag(ModBlockTags.LOW_PRESSURE_COMPRESSORS)
                .addTag(BlockTags.ANVIL)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_WALL.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_GRATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN_SLAB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN_STAIRS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_DOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_TRAPDOOR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_CHAIN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_BULB.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_GRATE.get()).orElseThrow());

        tag(ModBlockTags.HIGH_PRESSURE_COMPRESSORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.OBSIDIAN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICKS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.CRYING_OBSIDIAN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICKS.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.ANCIENT_DEBRIS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.NETHERITE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_ORE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_TUNGSTEN_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_BLOCK.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.HEAVY_CORE).orElseThrow());

    }
}
