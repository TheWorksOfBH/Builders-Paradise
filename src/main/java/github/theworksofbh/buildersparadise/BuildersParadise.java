package github.theworksofbh.buildersparadise;

import com.mojang.logging.LogUtils;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.config.*;
import github.theworksofbh.buildersparadise.datagen.ModDataGenerators;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluidTypes;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.loot.ModLootModifiers;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(BuildersParadise.MODID)
public class BuildersParadise
{
    public static final String MODID = "buildersparadise";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BuildersParadise(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        CreativeInvConfig.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEntities.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModSoundEvents.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModDataGenerators::gatherData);
        modEventBus.addListener(this::addFluidTypes);
        modEventBus.addListener(this::addEntityRenderers);
        NeoForge.EVENT_BUS.addListener(this::addNoteBlockInstruments);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        CreativeInvConfig.addModItemsToVanillaTabs(event);
    }

    @SubscribeEvent
    private void addNoteBlockInstruments(NoteBlockEvent.Play event) {
        NoteBlockConfig.brassBlockNoteBlock(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    private void addFluidTypes(RegisterClientExtensionsEvent event) {
        FluidTypeConfig.addFluidTypes(event);
    }

    private void addEntityRenderers(FMLClientSetupEvent event) {
        EntityRendererConfig.addEntityRenderers(event);
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            RenderTypeConfig.addModRenderTypes();
            FlammabilityConfig.createFlammableBlocks();
        }
    }
}
