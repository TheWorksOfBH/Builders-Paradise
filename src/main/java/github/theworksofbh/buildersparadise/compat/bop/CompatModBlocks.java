package github.theworksofbh.buildersparadise.compat.bop;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.block.ThermalCalciteBlock;
import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CompatModBlocks {
    public static final DeferredRegister.Blocks BOP_BLOCKS = DeferredRegister.createBlocks(BuildersParadise.MODID);

    public static final DeferredBlock<StairBlock> CUT_WHITE_SANDSTONE_STAIRS = registerStairBlock("cut_white_sandstone_stairs", () -> BOPBlocks.CUT_WHITE_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_WHITE_SANDSTONE_WALL = registerWallBlock("cut_white_sandstone_wall", () -> BOPBlocks.CUT_WHITE_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_WHITE_SANDSTONE_WALL = registerWallBlock("smooth_white_sandstone_wall", () -> BOPBlocks.SMOOTH_WHITE_SANDSTONE);

    public static final DeferredBlock<StairBlock> CUT_BLACK_SANDSTONE_STAIRS = registerStairBlock("cut_black_sandstone_stairs", () -> BOPBlocks.CUT_BLACK_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_BLACK_SANDSTONE_WALL = registerWallBlock("cut_black_sandstone_wall", () -> BOPBlocks.CUT_BLACK_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_BLACK_SANDSTONE_WALL = registerWallBlock("smooth_black_sandstone_wall", () -> BOPBlocks.SMOOTH_BLACK_SANDSTONE);

    public static final DeferredBlock<StairBlock> CUT_ORANGE_SANDSTONE_STAIRS = registerStairBlock("cut_orange_sandstone_stairs", () -> BOPBlocks.CUT_ORANGE_SANDSTONE);
    public static final DeferredBlock<WallBlock> CUT_ORANGE_SANDSTONE_WALL = registerWallBlock("cut_orange_sandstone_wall", () -> BOPBlocks.CUT_ORANGE_SANDSTONE);
    public static final DeferredBlock<WallBlock> SMOOTH_ORANGE_SANDSTONE_WALL = registerWallBlock("smooth_orange_sandstone_wall", () -> BOPBlocks.SMOOTH_ORANGE_SANDSTONE);

    public static final DeferredBlock<SlabBlock> BRIMSTONE_SLAB = registerSlabBlock("brimstone_slab", () -> BOPBlocks.BRIMSTONE);
    public static final DeferredBlock<StairBlock> BRIMSTONE_STAIRS = registerStairBlock("brimstone_stairs", () -> BOPBlocks.BRIMSTONE);
    public static final DeferredBlock<WallBlock> BRIMSTONE_WALL = registerWallBlock("brimstone_wall", () -> BOPBlocks.BRIMSTONE);

    public static final DeferredBlock<ThermalCalciteSlabBlock> THERMAL_CALCITE_SLAB = registerTCSlabBlock("thermal_calcite_slab", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteStairBlock> THERMAL_CALCITE_STAIRS = registerTCStairBlock("thermal_calcite_stairs", () -> BOPBlocks.THERMAL_CALCITE);
    public static final DeferredBlock<ThermalCalciteWallBlock> THERMAL_CALCITE_WALL = registerTCWallBlock("thermal_calcite_wall", () -> BOPBlocks.THERMAL_CALCITE);

    private static DeferredBlock<Block> registerBlockVariant(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new Block(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<WallBlock> registerWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new WallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<SlabBlock> registerSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new SlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<StairBlock> registerStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new StairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ThermalCalciteBlock> registerTCBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ThermalCalciteWallBlock> registerTCWallBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteWallBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ThermalCalciteSlabBlock> registerTCSlabBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteSlabBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<ThermalCalciteStairBlock> registerTCStairBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new ThermalCalciteStairBlock(
                        baseBlock.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredBlock<FenceBlock> registerFenceBlock(String registryName, Supplier<Block> baseBlock) {
        return BOP_BLOCKS.register(
                registryName, () -> new FenceBlock(
                        BlockBehaviour.Properties.ofFullCopy(
                                baseBlock.get()
                        ).setId(
                                ResourceKey.create(
                                        Registries.BLOCK,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    public static void register(IEventBus eventBus){
        BOP_BLOCKS.register(eventBus);
    }

}
