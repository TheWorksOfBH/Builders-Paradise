package github.theworksofbh.buildersparadise.config;

import com.mojang.blaze3d.vertex.PoseStack;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.fluids.ModFluidTypes;
import github.theworksofbh.buildersparadise.fluids.ModFluids;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.joml.Vector4f;

import javax.annotation.Nullable;

public class FluidTypeConfig {

    public static void addFluidTypes(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @Nullable Identifier getRenderOverlayTexture(Minecraft mc) {
                return null;
            }

            @Override
            public void renderOverlay(Minecraft mc, PoseStack poseStack, SubmitNodeCollector submitNodeCollector) {
                IClientFluidTypeExtensions.super.renderOverlay(mc, poseStack, submitNodeCollector);
            }

            @Override
            public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
                fluidFogColor.set(ModFluidTypes.NUCLEAR_WASTE_TYPE.get().getFogColor());
            }

            @Override
            public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
                fogData.environmentalStart = 0.1F;
                fogData.environmentalEnd = 1.0F;
                fogData.renderDistanceStart = 0.0F;
                fogData.renderDistanceEnd = renderDistance;
            }
        }, ModFluidTypes.NUCLEAR_WASTE_TYPE.get());
    }

    public static void addFluidModels(RegisterFluidModelsEvent event) {
        FluidModel.Unbaked nuclearFluidModel = new FluidModel.Unbaked(
                new Material(
                        Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "block/nuclear_waste_still")
                ),
                new Material(
                        Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "block/nuclear_waste_flow")
                ),
                null, null
        );

        event.register(nuclearFluidModel, ModFluids.NUCLEAR_WASTE, ModFluids.FLOWING_NUCLEAR_WASTE);
    }
}
