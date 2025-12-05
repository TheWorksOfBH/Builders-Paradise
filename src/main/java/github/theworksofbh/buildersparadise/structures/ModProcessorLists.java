package github.theworksofbh.buildersparadise.structures;

import com.google.common.collect.ImmutableList;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class ModProcessorLists {
    private static void register(BootstrapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, List<StructureProcessor> processors) {
        context.register(key, new StructureProcessorList(processors));
    }

    private static ResourceKey<StructureProcessorList> createKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static final ResourceKey<StructureProcessorList> REPLACE_SNOW_BLOCK_WITH_SNOW_BRICKS = createKey("replace_snow_block_with_snow_bricks");
    public static final ResourceKey<StructureProcessorList> REPLACE_PACKED_ICE_WITH_PACKED_ICE_BRICKS = createKey("replace_packed_ice_with_packed_ice_bricks");
    public static final ResourceKey<StructureProcessorList> REPLACE_BLUE_ICE_WITH_BLUE_ICE_BRICKS = createKey("replace_blue_ice_with_blue_ice_bricks");
    public static final ResourceKey<StructureProcessorList> OAK_THINGS_UP = createKey("oak_things_up");
    public static final ResourceKey<StructureProcessorList> SPRUCE_THINGS_UP = createKey("spruce_things_up");
    public static final ResourceKey<StructureProcessorList> JUNGLE_THINGS_UP = createKey("jungle_things_up");
    public static final ResourceKey<StructureProcessorList> ACACIA_THINGS_UP = createKey("acacia_things_up");
    public static final ResourceKey<StructureProcessorList> DARK_OAK_THINGS_UP = createKey("dark_oak_things_up");
    public static final ResourceKey<StructureProcessorList> CRIMSON_THINGS_UP = createKey("crimson_things_up");
    public static final ResourceKey<StructureProcessorList> WARPED_THINGS_UP = createKey("warped_things_up");

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        register(
                context,
                REPLACE_SNOW_BLOCK_WITH_SNOW_BRICKS,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.SNOW_BLOCK,
                                ModBlocks.SNOW_BRICKS.get(),
                                null
                        )
                )
        );
        register(
                context,
                REPLACE_PACKED_ICE_WITH_PACKED_ICE_BRICKS,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.PACKED_ICE,
                                ModBlocks.PACKED_ICE_BRICKS.get(),
                                null
                        )
                )
        );
        register(
                context,
                REPLACE_BLUE_ICE_WITH_BLUE_ICE_BRICKS,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BLUE_ICE,
                                ModBlocks.BLUE_ICE_BRICKS.get(),
                                null
                        )
                )
        );
        register(
                context,
                OAK_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.OAK_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.OAK_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.OAK_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.OAK_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.OAK_GRINDSTONE.get(),
                                null
                        )
                )
        );
        register(
                context,
                SPRUCE_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.SPRUCE_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.SPRUCE_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.SPRUCE_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.SPRUCE_GRINDSTONE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.SPRUCE_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.SPRUCE_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.SPRUCE_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.SPRUCE_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.SPRUCE_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.SPRUCE_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.SPRUCE_STONE_SMOKER.get(),
                                null
                        )
                )
        );
        register(
                context,
                JUNGLE_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.JUNGLE_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.JUNGLE_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.JUNGLE_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.JUNGLE_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.JUNGLE_GRINDSTONE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.JUNGLE_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.JUNGLE_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.JUNGLE_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.JUNGLE_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.JUNGLE_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.JUNGLE_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.JUNGLE_STONE_SMOKER.get(),
                                null
                        )
                )
        );
        register(
                context,
                ACACIA_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.ACACIA_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.ACACIA_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.ACACIA_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.ACACIA_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.ACACIA_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.ACACIA_GRINDSTONE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.ACACIA_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.ACACIA_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.ACACIA_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.ACACIA_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.ACACIA_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.ACACIA_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.ACACIA_STONE_SMOKER.get(),
                                null
                        )
                )
        );
        register(
                context,
                DARK_OAK_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.DARK_OAK_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.DARK_OAK_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.DARK_OAK_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.DARK_OAK_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.DARK_OAK_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.DARK_OAK_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.DARK_OAK_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.DARK_OAK_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.DARK_OAK_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.DARK_OAK_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.DARK_OAK_STONE_SMOKER.get(),
                                null
                        )
                )
        );
        register(
                context,
                CRIMSON_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.CRIMSON_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.CRIMSON_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.CRIMSON_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.CRIMSON_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.CRIMSON_GRINDSTONE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.CRIMSON_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.CRIMSON_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.CRIMSON_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.CRIMSON_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.CRIMSON_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.CRIMSON_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.CRIMSON_STONE_SMOKER.get(),
                                null
                        )
                )
        );
        register(
                context,
                WARPED_THINGS_UP,
                ImmutableList.of(
                        new GenericBlockReplacementProcessor(
                                Blocks.BARREL,
                                ModBlocks.WARPED_BARREL.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.BOOKSHELF,
                                ModBlocks.WARPED_BOOKSHELF.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CARTOGRAPHY_TABLE,
                                ModBlocks.WARPED_CARTOGRAPHY_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMITHING_TABLE,
                                ModBlocks.WARPED_SMITHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.FLETCHING_TABLE,
                                ModBlocks.WARPED_FLETCHING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.GRINDSTONE,
                                ModBlocks.WARPED_GRINDSTONE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CAMPFIRE,
                                ModBlocks.WARPED_CAMPFIRE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CHEST,
                                ModBlocks.WARPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.TRAPPED_CHEST,
                                ModBlocks.WARPED_TRAPPED_CHEST.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.CRAFTING_TABLE,
                                ModBlocks.WARPED_CRAFTING_TABLE.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LOOM,
                                ModBlocks.WARPED_LOOM.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.LECTERN,
                                ModBlocks.WARPED_LECTERN.get(),
                                null
                        ),
                        new GenericBlockReplacementProcessor(
                                Blocks.SMOKER,
                                ModBlocks.WARPED_STONE_SMOKER.get(),
                                null
                        )
                )
        );
    }
}
