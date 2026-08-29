package github.theworksofbh.buildersparadise;

import github.theworksofbh.buildersparadise.events.FabricCreativeEvent;
import github.theworksofbh.buildersparadise.events.FabricInitEvent;
import net.fabricmc.api.ModInitializer;

public class BuildersParadiseFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        BuildersParadiseCommon.init();
        FabricInitEvent.initializeClasses();
        FabricCreativeEvent.initialize();
    }
}
