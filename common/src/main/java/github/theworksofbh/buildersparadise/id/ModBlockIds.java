package github.theworksofbh.buildersparadise.id;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;

public class ModBlockIds {
    public static final ResourceKey<Block> IRON_WALL_TORCH = create("iron_wall_torch");

    private static ResourceKey<Block> create(final String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(name));
    }

    private static ColorCollection<ResourceKey<Block>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModBlockIds::create);
    }
}
