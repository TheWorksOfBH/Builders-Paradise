package github.theworksofbh.buildersparadise.config;

import com.mojang.blaze3d.shaders.FogShape;
import github.theworksofbh.buildersparadise.fluids.ModFluidTypes;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4f;

public class FluidTypeConfig {

    public static void addFluidTypes(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ModFluidTypes.NUCLEAR_WASTE_TYPE.get().getStillTexture();
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ModFluidTypes.NUCLEAR_WASTE_TYPE.get().getFlowingTexture();
            }

            @Override
            public @Nullable ResourceLocation getOverlayTexture() {
                return null;
            }

            @Override
            public int getTintColor() {
                return ModFluidTypes.NUCLEAR_WASTE_TYPE.get().getTintColor();
            }

            @Override
            public Vector4f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
                return ModFluidTypes.NUCLEAR_WASTE_TYPE.get().getFogColor();
            }

            @Override
            public FogParameters modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, FogParameters fogParameters) {
                return new FogParameters(0.1F, 1.0F, FogShape.SPHERE, 0.0F, 1.0F, 0.0F, 1.0F);
            }
        }, ModFluidTypes.NUCLEAR_WASTE_TYPE.get());
    }
}
