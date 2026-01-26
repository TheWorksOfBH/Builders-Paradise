package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.compat.bop.CompatModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.CompatModEntities;
import github.theworksofbh.buildersparadise.compat.bop.CompatModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;

public class BOPConfig {
    public static void registerBOPCompats(IEventBus bus) {
        if (ModList.get().isLoaded("biomesoplenty")) {
            CompatModBlocks.register(bus);
            CompatModItems.register(bus);
            CompatModEntities.register(bus);
        }
    }
}
