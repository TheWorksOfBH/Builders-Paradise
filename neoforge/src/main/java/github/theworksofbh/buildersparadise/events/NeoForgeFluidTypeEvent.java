package github.theworksofbh.buildersparadise.events;

import com.mojang.blaze3d.vertex.PoseStack;
import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4f;

public class NeoForgeFluidTypeEvent {
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
                fluidFogColor.set(new Vector4f(1.0f, 0.0f, 1.0f, 0.0f));
            }

            @Override
            public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
                fogData.environmentalStart = 0.1F;
                fogData.environmentalEnd = 1.0F;
                fogData.renderDistanceStart = 0.0F;
                fogData.renderDistanceEnd = renderDistance;
            }
        }, new FluidType(
                FluidType.Properties.create()
                        .viscosity(1000)
                        .lightLevel(15)
                        .canConvertToSource(true)
                        .motionScale(0.1)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .pathType(PathType.LAVA)
                        .temperature(700)
                        .motionScale(0.00001F)
                        .isWaterLike(false)
                        .density(1000)
        ));
    }

    public static void addFluidModels(RegisterFluidModelsEvent event) {
        FluidModel.Unbaked nuclearFluidModel = new FluidModel.Unbaked(
                new Material(
                        Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "block/nuclear_waste_still")
                ),
                new Material(
                        Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "block/nuclear_waste_flow")
                ),
                null, null
        );

        event.register(nuclearFluidModel, ModFluids.NUCLEAR_WASTE, ModFluids.FLOWING_NUCLEAR_WASTE);
    }
}
