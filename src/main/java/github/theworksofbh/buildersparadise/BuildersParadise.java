package github.theworksofbh.buildersparadise;

import com.mojang.logging.LogUtils;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.config.*;
import github.theworksofbh.buildersparadise.datagen.ModDataGenerators;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.fluids.ModFluidTypes;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import github.theworksofbh.buildersparadise.gui.ModMenuTypes;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.loot.ModLootModifiers;
import github.theworksofbh.buildersparadise.particles.ModParticles;
import github.theworksofbh.buildersparadise.recipes.ModRecipeBookCategories;
import github.theworksofbh.buildersparadise.recipes.ModRecipeDisplays;
import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import github.theworksofbh.buildersparadise.sounds.ModSoundEvents;
import github.theworksofbh.buildersparadise.stats.ModStats;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.world.poi.ExtendPoiTypesEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(BuildersParadise.MODID)
public class BuildersParadise
{
    public static final String MODID = "buildersparadise";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BuildersParadise(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ModParticles.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        CreativeInvConfig.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModEffects.register(modEventBus);

        BOPConfig.registerBOPCompats(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModSoundEvents.register(modEventBus);

        ModStats.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModRecipeDisplays.register(modEventBus);
        ModRecipeBookCategories.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModDataGenerators::gatherData);
        modEventBus.addListener(this::addFluidTypes);
        modEventBus.addListener(this::addEntityRenderers);
        modEventBus.addListener(this::addGuiScreens);
        modEventBus.addListener(this::addPOIBlocks);
        modEventBus.addListener(this::addBlockEntities);
        modEventBus.addListener(this::addEntityLayerRenderers);
        modEventBus.addListener(this::addBlockEntityRenderers);
        modEventBus.addListener(this::addParticles);

        NeoForge.EVENT_BUS.addListener(this::addEntityDamages);
        NeoForge.EVENT_BUS.addListener(this::addNoteBlockInstruments);
        NeoForge.EVENT_BUS.addListener(this::omitFireOverlayInBoats);
        NeoForge.EVENT_BUS.addListener(this::addJeiCompat);
        NeoForge.EVENT_BUS.addListener(this::syncDataPacks);


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

    private void addPOIBlocks(ExtendPoiTypesEvent event) {
        POIConfig.addModBlocksToVanillaPOIs(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    private void addBlockEntities(BlockEntityTypeAddBlocksEvent event){
        BlockEntityConfig.addModdedBlocksToVanillaBlockEntities(event);
    }

    private void addGuiScreens(RegisterMenuScreensEvent event) {
        MenuScreenConfig.registerCustomScreens(event);
    }

    private void addFluidTypes(RegisterClientExtensionsEvent event) {
        FluidTypeConfig.addFluidTypes(event);
    }

    private void addEntityRenderers(FMLClientSetupEvent event) {
        EntityRendererConfig.addEntityRenderers(event);
    }

    private void addEntityLayerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        EntityLayersConfig.registerEntityLayers(event);
    }

    private void addEntityDamages(LivingIncomingDamageEvent event) {
        FireproofBoatConfig.onEntityDamage(event);
    }

    private void omitFireOverlayInBoats(RenderBlockScreenEffectEvent event) {
        FireproofBoatConfig.onRenderOverlay(event);
    }

    private void addBlockEntityRenderers(RegisterSpecialBlockModelRendererEvent event){
        BlockEntityModelRendersConfig.registerBlockEntities(event);
    }

    private void addParticles(RegisterParticleProvidersEvent event){
        ParticleConfig.registerParticleProviders(event);
    }

    private void addJeiCompat(RecipesReceivedEvent event) {
        JeiSyncConfig.addRecipeMapsToJEI(event);
    }

    private void syncDataPacks(OnDatapackSyncEvent event) {
        JeiSyncConfig.addRecipesToJEI(event);
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            RenderTypeConfig.addModRenderTypes();
            FlammabilityConfig.createFlammableBlocks();
            DispenserConfig.addItemsToDispenser();
        }
    }
}
