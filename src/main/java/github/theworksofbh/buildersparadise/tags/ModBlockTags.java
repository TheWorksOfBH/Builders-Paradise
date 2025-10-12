package github.theworksofbh.buildersparadise.tags;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {

    public static final TagKey<Block> ZINC_ORES = create("zinc_ores");
    public static final TagKey<Block> SILVER_ORES = create("silver_ores");
    public static final TagKey<Block> TIN_ORES = create("tin_ores");
    public static final TagKey<Block> TUNGSTEN_ORES = create("tungsten_ores");
    public static final TagKey<Block> PLATINUM_ORES = create("platinum_ores");
    public static final TagKey<Block> LEAD_ORES = create("lead_ores");
    public static final TagKey<Block> URANIUM_ORES = create("uranium_ores");
    public static final TagKey<Block> CRAFTING_TABLES = create("crafting_tables");
    public static final TagKey<Block> CARTOGRAPHY_TABLES = create("cartography_tables");
    public static final TagKey<Block> FLETCHING_TABLES = create("fletching_tables");
    public static final TagKey<Block> SMITHING_TABLES = create("smithing_tables");
    public static final TagKey<Block> GRINDSTONES = create("grindstones");
    public static final TagKey<Block> LOOMS = create("looms");
    public static final TagKey<Block> FURNACES = create("furnaces");
    public static final TagKey<Block> SMOKERS = create("smokers");
    public static final TagKey<Block> BLAST_FURNACES = create("blast_furnaces");
    public static final TagKey<Block> BEEHIVES = create("beehives");
    public static final TagKey<Block> BOOKSHELVES = create("bookshelves");
    public static final TagKey<Block> CHISELED_BOOKSHELVES = create("chiseled_bookshelves");



    private ModBlockTags() {
    }

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }
}
