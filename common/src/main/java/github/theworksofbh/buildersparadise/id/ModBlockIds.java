package github.theworksofbh.buildersparadise.id;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;

public class ModBlockIds {
    public static final ResourceKey<Block> IRON_WALL_TORCH = create("iron_wall_torch");
    public static final ResourceKey<Block> ZINC_WALL_TORCH = create("zinc_wall_torch");
    public static final ResourceKey<Block> SILVER_WALL_TORCH = create("silver_wall_torch");
    public static final ResourceKey<Block> TIN_WALL_TORCH = create("tin_wall_torch");
    public static final ResourceKey<Block> TUNGSTEN_WALL_TORCH = create("tungsten_wall_torch");
    public static final ResourceKey<Block> PLATINUM_WALL_TORCH = create("platinum_wall_torch");
    public static final ResourceKey<Block> GOLD_WALL_TORCH = create("gold_wall_torch");
    public static final ResourceKey<Block> LEAD_WALL_TORCH = create("lead_wall_torch");
    public static final ResourceKey<Block> BISMUTH_WALL_TORCH = create("bismuth_wall_torch");
    public static final ResourceKey<Block> URANIUM_WALL_TORCH = create("uranium_wall_torch");
    public static final ResourceKey<Block> NUCLEAR_WASTE = create("nuclear_waste");

    private static ResourceKey<Block> create(final String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, name));
    }

    private static ColorCollection<ResourceKey<Block>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModBlockIds::create);
    }
}
