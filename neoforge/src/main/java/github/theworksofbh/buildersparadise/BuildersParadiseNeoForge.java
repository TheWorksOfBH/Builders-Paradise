package github.theworksofbh.buildersparadise;

import github.theworksofbh.buildersparadise.events.NeoForgeCreativeEvent;
import github.theworksofbh.buildersparadise.events.NeoForgeInitEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(BuildersParadiseConstants.MOD_ID)
public class BuildersParadiseNeoForge {

    public BuildersParadiseNeoForge(IEventBus eventBus) {

        BuildersParadiseCommon.init();
        eventBus.addListener(this::addClasses);
        eventBus.addListener(this::addCreative);

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        NeoForgeCreativeEvent.addItemsToCreative(event);
    }

    private void addClasses(RegisterEvent event) {
        NeoForgeInitEvent.registerClasses(event);
    }
}