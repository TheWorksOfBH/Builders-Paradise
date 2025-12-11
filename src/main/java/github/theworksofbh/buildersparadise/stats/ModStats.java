package github.theworksofbh.buildersparadise.stats;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStats {
    public static final DeferredRegister<Identifier> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, BuildersParadise.MODID);

    public static final Holder<Identifier> INTERACT_WITH_FLETCHING_TABLE = makeCustomStat("interact_with_fletching_table", StatFormatter.DEFAULT);

    public static void register(IEventBus eventBus){
        STATS.register(eventBus);
    }

    public static Holder<Identifier> makeCustomStat(String registryName, StatFormatter statFormatter) {
        return STATS.register(registryName, () -> Identifier.fromNamespaceAndPath(BuildersParadise.MODID, registryName));
    }
}
