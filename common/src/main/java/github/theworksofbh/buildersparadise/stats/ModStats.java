package github.theworksofbh.buildersparadise.stats;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;

public class ModStats {
    public static final StatType<Identifier> CUSTOM = makeRegistryStatType("custom", BuiltInRegistries.CUSTOM_STAT);
    public static final Identifier INTERACT_WITH_FLETCHING_TABLE = makeCustomStat("interact_with_fletching_table", StatFormatter.DEFAULT);

    private static Identifier makeCustomStat(final String id, final StatFormatter formatter) {
        Identifier location = Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, location);
        CUSTOM.get(location, formatter);
        return location;
    }

    private static <T> StatType<T> makeRegistryStatType(final String name, final Registry<T> registry) {
        Component displayName = Component.translatable("stat_type.buildersparadise." + name);
        return Registry.register(BuiltInRegistries.STAT_TYPE, name, new StatType<>(registry, displayName));
    }

    public static void initialize() {

    }
}
