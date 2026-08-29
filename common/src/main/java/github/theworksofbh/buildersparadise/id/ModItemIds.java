package github.theworksofbh.buildersparadise.id;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.function.UnaryOperator;

public class ModItemIds {

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.withDefaultNamespace(name));
    }

    private static ResourceKey<Item> createPotterySherd(final ResourceKey<DecoratedPotPattern> sherd) {
        return sherd.dependent(Registries.ITEM, "_pottery_sherd");
    }

    private static ResourceKey<Item> createArmorTrimSmithingTemplate(final ResourceKey<TrimPattern> template) {
        return template.dependent(Registries.ITEM, "_armor_trim_smithing_template");
    }

    private static ResourceKey<Item> createMusicDisc(final ResourceKey<JukeboxSong> music) {
        return music.dependent(Registries.ITEM, (UnaryOperator<String>)(path -> "music_disc_" + path));
    }

    private static ResourceKey<Item> createSpawnEgg(final ResourceKey<EntityType<?>> entity) {
        return entity.dependent(Registries.ITEM, "_spawn_egg");
    }

    private static ColorCollection<ResourceKey<Item>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModItemIds::create);
    }
}
