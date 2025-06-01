package github.theworksofbh.buildersparadise.fluids;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector4f;

import javax.annotation.Nullable;

public class BaseFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation overlayTexture;
    private final int tintColor;
    private final Vector4f fogColor;

    public BaseFluidType(Properties properties, ResourceLocation flowingTexture, ResourceLocation stillTexture, @Nullable ResourceLocation overlayTexture, @Nullable Integer tintColor, Vector4f fogColor) {
        super(properties);
        this.flowingTexture = flowingTexture;
        this.stillTexture = stillTexture;
        this.overlayTexture = overlayTexture;
        this.tintColor = tintColor;
        this.fogColor = fogColor;
    }

    public Vector4f getFogColor() {
        return fogColor;
    }

    public int getTintColor() {
        return tintColor;
    }

    public ResourceLocation getStillTexture() {
        return stillTexture;
    }

    public ResourceLocation getFlowingTexture() {
        return flowingTexture;
    }

    public ResourceLocation getOverlayTexture() {
        return overlayTexture;
    }
}
