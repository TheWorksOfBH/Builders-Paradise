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


    private ModBlockTags() {
    }

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }
}
