package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.id.ModBlockItemIds;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;

import java.util.function.Function;

public class ModItems {

    // Items of blocks with standing and wall variants

    public static final Item IRON_TORCH = register(ModBlockItemIds.IRON_TORCH.item(), (properties) -> new StandingAndWallBlockItem(ModBlocks.IRON_TORCH, ModBlocks.IRON_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());

    private static Item register(ResourceKey<Item> id, Function<Item.Properties, Item> function, Item.Properties properties) {
        Item item = function.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {

    }
}
