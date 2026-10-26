package github.theworksofbh.buildersparadise;

import github.theworksofbh.buildersparadise.events.*;
import github.theworksofbh.buildersparadise.loot.ModLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(BuildersParadiseConstants.MOD_ID)
public class BuildersParadiseNeoForge {

    public BuildersParadiseNeoForge(IEventBus eventBus) {

        eventBus.addListener(NeoForgeInitEvent::registerClasses);
        ModLootModifiers.register(eventBus);
        BuildersParadiseCommon.init();
        eventBus.addListener(NeoForgeCreativeEvent::addItemsToCreative);
        eventBus.addListener(NeoForgeGatherDataEvent::gatherData);
        eventBus.addListener(NeoForgeBlockEntityEvent::addModdedBlocksToVanillaBlockEntities);
        eventBus.addListener(NeoForgeBlockEntityModelRendererEvent::registerBlockEntities);
        eventBus.addListener(NeoForgeEntityRendererEvent::addEntityRenderers);
        eventBus.addListener(NeoForgeEntityLayerEvent::registerEntityLayers);
        eventBus.addListener(NeoForgeFluidTypeEvent::addFluidTypes);
        eventBus.addListener(NeoForgeFluidTypeEvent::addFluidModels);
        eventBus.addListener(NeoForgeMenuScreenEvent::registerCustomScreens);
        eventBus.addListener(NeoForgePOIEvent::addModBlocksToVanillaPOIs);
        eventBus.addListener(NeoForgeParticleEvent::registerParticleProviders);

        NeoForge.EVENT_BUS.addListener(NeoForgeFireproofBoatEvent::onEntityDamage);
        NeoForge.EVENT_BUS.addListener(NeoForgeFireproofBoatEvent::onRenderOverlay);
        NeoForge.EVENT_BUS.addListener(NeoForgeNoteBlockEvent::brassBlockNoteBlock);

    }
}