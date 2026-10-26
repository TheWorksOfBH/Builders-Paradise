package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.blocks.types.FletchingTableBlock;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ModBlockTagsProvider extends TagsProvider<Block> {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.BLOCK, lookupProvider);
    }

    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTags = Set.of(
                Blocks.CRAFTING_TABLE,
                Blocks.CARTOGRAPHY_TABLE,
                Blocks.SMITHING_TABLE,
                Blocks.FLETCHING_TABLE,
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

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getKnownBlocks().forEach(
                block -> {
                    ResourceKey<Block> blockResourceKey = BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
                    if ((block instanceof BasePressurePlateBlock) || block.getDescriptionId().contains("mosaic") || block.getDescriptionId().contains("oak") || block.getDescriptionId().contains("spruce") || block.getDescriptionId().contains("birch") || block.getDescriptionId().contains("jungle") || block.getDescriptionId().contains("acacia") || block.getDescriptionId().contains("crimson") || block.getDescriptionId().contains("warped") || block.getDescriptionId().contains("mangrove") || block.getDescriptionId().contains("cherry") || block.getDescriptionId().contains("bamboo") || (block instanceof CraftingTableBlock) || (block instanceof ChestBlock) || (block instanceof BarrelBlock) || (block instanceof CampfireBlock) || (block instanceof CartographyTableBlock) || (block instanceof BeehiveBlock) || (block instanceof ChiseledBookShelfBlock) || (block instanceof SmithingTableBlock) || (block instanceof LoomBlock) || block.getDescriptionId().contains("bookshelf") || block.getDescriptionId().contains("snow") || block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk") || block.getDescriptionId().contains("carbon") || block.getDescriptionId().contains("silicon")) {
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
                        } else if (block.getDescriptionId().contains("silicon")) {
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
                        if (block instanceof TorchBlock || (block.getDescriptionId().contains("resin") || block.getDescriptionId().contains("sculk")) && !block.getDescriptionId().contains("brick")) {

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
                            tag(ModBlockTags.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
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
                            tag(ModBlockTags.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
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
                            tag(ModBlockTags.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
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
                            tag(ModBlockTags.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                    else if (block instanceof IronBarsBlock) {
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
                            tag(ModBlockTags.NEEDS_NETHERITE_TOOL).add(blockResourceKey);
                        }
                    }
                }
        );

        tag(ModBlockTags.ZINC_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_ZINC_ORE).orElseThrow());
        tag(ModBlockTags.SILVER_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SILVER_ORE).orElseThrow());
        tag(ModBlockTags.TIN_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TIN_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TIN_ORE).orElseThrow());
        tag(ModBlockTags.TUNGSTEN_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TUNGSTEN_ORE).orElseThrow());
        tag(ModBlockTags.PLATINUM_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLATINUM_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_PLATINUM_ORE).orElseThrow());
        tag(ModBlockTags.LEAD_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LEAD_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_LEAD_ORE).orElseThrow());
        tag(ModBlockTags.BISMUTH_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BISMUTH_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_BISMUTH_ORE).orElseThrow());
        tag(ModBlockTags.URANIUM_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.URANIUM_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_URANIUM_ORE).orElseThrow());
        tag(ModBlockTags.RUBY_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RUBY_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_RUBY_ORE).orElseThrow());
        tag(ModBlockTags.SAPPHIRE_ORES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SAPPHIRE_ORE).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_SAPPHIRE_ORE).orElseThrow());
        tag(ModBlockTags.IRON).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.weathering().unaffected()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.weathering().exposed()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.weathering().weathered()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.weathering().rusted()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.waxed().unaffected()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.waxed().exposed()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.waxed().weathered()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BLOCK.waxed().rusted()).orElseThrow());
        tag(ModBlockTags.ZINC).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().unaffected()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().exposed()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().weathered()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().corroded()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().unaffected()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().exposed()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().weathered()).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().corroded()).orElseThrow());
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.INCORRECT_FOR_STONE_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.INCORRECT_FOR_COPPER_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL).addTag(ModBlockTags.NEEDS_NETHERITE_TOOL);

        tag(BlockTags.BEACON_BASE_BLOCKS).addTag(ModBlockTags.IRON).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRONZE_BLOCK).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.SILVER_BLOCK).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLATINUM_BLOCK).orElseThrow());
        tag(ModBlockTags.INCORRECT_FOR_BRONZE_TOOL).addTag(BlockTags.INCORRECT_FOR_COPPER_TOOL);

        tag(ModBlockTags.GALVANIZES_IRON)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.weathering().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.weathering().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BLOCK.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_SLAB.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_ZINC_STAIRS.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_DOOR.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_TRAPDOOR.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_CHAIN.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_GRATE.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_BULB.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_FIRE_LANTERN.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_SOUL_LANTERN.waxed().corroded()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.ZINC_LANTERN.waxed().corroded()).orElseThrow());

        tag(ModBlockTags.GLASS_DOORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GLASS_DOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_DOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.white()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.orange()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.magenta()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.lightBlue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.yellow()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.lime()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.pink()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.gray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.lightGray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.cyan()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.purple()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.blue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.green()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.red()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_DOOR.black()).orElseThrow());

        tag(ModBlockTags.GLASS_TRAPDOORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GLASS_TRAPDOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_TRAPDOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.white()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.orange()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.magenta()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.lightBlue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.yellow()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.lime()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.pink()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.gray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.lightGray()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.cyan()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.purple()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.blue()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.brown()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.green()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.red()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.STAINED_GLASS_TRAPDOOR.black()).orElseThrow());

        tag(ModBlockTags.SHATTERABLE_BY_SHARPENED_ARROW)
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.GLASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.GLASS_PANE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.TINTED_GLASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TINTED_GLASS_PANE).orElseThrow())
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
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TIN_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TIN_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.LEAD_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_LEAD_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRONZE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRONZE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.BRASS_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_BRASS_STAIRS).orElseThrow());

        tag(BlockTags.DRAGON_IMMUNE)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.END_STONE_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.END_STONE_BRICK_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.weathering().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.weathering().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.weathering().rusted()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.waxed().unaffected()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.waxed().exposed()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.waxed().weathered()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.IRON_BARS.waxed().rusted()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.POLISHED_GRAPHITE_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.GRAPHITE_BRICK_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_FENCE).orElseThrow());

        tag(ModBlockTags.COMPRESSES_CARBON)
                .addTag(ModBlockTags.HIGH_PRESSURE_COMPRESSORS)
                .addTag(ModBlockTags.LOW_PRESSURE_COMPRESSORS);

        tag(ModBlockTags.LOW_PRESSURE_COMPRESSORS)
                .addTag(BlockTags.ANVIL)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICK_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICK_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_DOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_TRAPDOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_CHAIN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_BULB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.NETHERITE_GRATE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_DOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_TRAPDOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_CHAIN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_BULB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_GRATE).orElseThrow());

        tag(ModBlockTags.HIGH_PRESSURE_COMPRESSORS)
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.OBSIDIAN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.OBSIDIAN_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.CRYING_OBSIDIAN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CRYING_OBSIDIAN_BRICKS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.ANCIENT_DEBRIS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.NETHERITE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_NETHERITE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.DEEPSLATE_TUNGSTEN_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_TUNGSTEN_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.TUNGSTEN_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.CUT_TUNGSTEN).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(Blocks.HEAVY_CORE).orElseThrow());

    }
}