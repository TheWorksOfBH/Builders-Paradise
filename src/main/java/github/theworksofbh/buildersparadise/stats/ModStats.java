package github.theworksofbh.buildersparadise.stats;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStats {
    public static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, BuildersParadise.MODID);

    public static final Holder<ResourceLocation> INTERACT_WITH_FLETCHING_TABLE = makeCustomStat("interact_with_fletching_table", StatFormatter.DEFAULT);

    public static void register(IEventBus eventBus){
        STATS.register(eventBus);
    }

    public static Holder<ResourceLocation> makeCustomStat(String registryName, StatFormatter statFormatter) {
        return STATS.register(registryName, () -> ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, registryName));
    }
}
