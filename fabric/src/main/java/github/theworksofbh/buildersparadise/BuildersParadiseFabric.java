package github.theworksofbh.buildersparadise;

import github.theworksofbh.buildersparadise.datamap.ModDataMaps;
import github.theworksofbh.buildersparadise.events.FabricCreativeEvent;
import github.theworksofbh.buildersparadise.events.FabricInitEvent;
import github.theworksofbh.buildersparadise.loot.ModChestLootModifier;
import github.theworksofbh.buildersparadise.worldgen.ModBiomeModifiers;
import net.fabricmc.api.ModInitializer;

public class BuildersParadiseFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        BuildersParadiseCommon.init();
        FabricInitEvent.initializeClasses();
        FabricCreativeEvent.initialize();

        ModChestLootModifier.register();
        ModDataMaps.register();
        ModBiomeModifiers.register();
    }
}
