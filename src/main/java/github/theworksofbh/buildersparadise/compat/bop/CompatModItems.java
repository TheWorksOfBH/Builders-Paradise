package github.theworksofbh.buildersparadise.compat.bop;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CompatModItems {
    public static final DeferredRegister.Items BOP_ITEMS = DeferredRegister.createItems(BuildersParadise.MODID);

    public static final DeferredItem<BlockItem> CUT_WHITE_SANDSTONE_STAIRS = registerBlockItem("cut_white_sandstone_stairs", () -> CompatModBlocks.CUT_WHITE_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_WHITE_SANDSTONE_WALL = registerBlockItem("cut_white_sandstone_wall", () -> CompatModBlocks.CUT_WHITE_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_WHITE_SANDSTONE_WALL = registerBlockItem("smooth_white_sandstone_wall", () -> CompatModBlocks.SMOOTH_WHITE_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_BLACK_SANDSTONE_STAIRS = registerBlockItem("cut_black_sandstone_stairs", () -> CompatModBlocks.CUT_BLACK_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_BLACK_SANDSTONE_WALL = registerBlockItem("cut_black_sandstone_wall", () -> CompatModBlocks.CUT_BLACK_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_BLACK_SANDSTONE_WALL = registerBlockItem("smooth_black_sandstone_wall", () -> CompatModBlocks.SMOOTH_BLACK_SANDSTONE_WALL.get());

    public static final DeferredItem<BlockItem> CUT_ORANGE_SANDSTONE_STAIRS = registerBlockItem("cut_orange_sandstone_stairs", () -> CompatModBlocks.CUT_ORANGE_SANDSTONE_STAIRS.get());
    public static final DeferredItem<BlockItem> CUT_ORANGE_SANDSTONE_WALL = registerBlockItem("cut_orange_sandstone_wall", () -> CompatModBlocks.CUT_ORANGE_SANDSTONE_WALL.get());
    public static final DeferredItem<BlockItem> SMOOTH_ORANGE_SANDSTONE_WALL = registerBlockItem("smooth_orange_sandstone_wall", () -> CompatModBlocks.SMOOTH_ORANGE_SANDSTONE_WALL.get());

    private static DeferredItem<Item> registerCustomItem(String registryName) {
        return BOP_ITEMS.register(
                registryName, () -> new Item(
                        new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        Identifier.fromNamespaceAndPath(
                                                BuildersParadise.MODID,
                                                registryName
                                        )
                                )
                        )
                )
        );
    }

    private static DeferredItem<BlockItem> registerBlockItem(String registryName, Supplier<Block> block){
        return BOP_ITEMS.register(
                        registryName, () -> new BlockItem(
                                block.get(), new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
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
        BOP_ITEMS.register(eventBus);
    }

}
