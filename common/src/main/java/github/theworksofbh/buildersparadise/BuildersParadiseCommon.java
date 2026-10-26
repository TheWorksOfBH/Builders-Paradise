package github.theworksofbh.buildersparadise;

import github.theworksofbh.buildersparadise.events.AddItemsToDispenserEvent;
import github.theworksofbh.buildersparadise.events.FlammabilityEvent;

public class BuildersParadiseCommon {

    public static void init() {
        AddItemsToDispenserEvent.addItemsToDispenser();
        FlammabilityEvent.createFlammableBlocks();
    }
}