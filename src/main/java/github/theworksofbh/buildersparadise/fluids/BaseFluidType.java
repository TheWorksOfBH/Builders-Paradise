package github.theworksofbh.buildersparadise.fluids;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector4f;

import javax.annotation.Nullable;

public class BaseFluidType extends FluidType {
    private final Identifier stillTexture;
    private final Identifier flowingTexture;
    private final Identifier overlayTexture;
    private final int tintColor;
    private final Vector4f fogColor;

    public BaseFluidType(Properties properties, Identifier flowingTexture, Identifier stillTexture, @Nullable Identifier overlayTexture, @Nullable Integer tintColor, Vector4f fogColor) {
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

    public Identifier getStillTexture() {
        return stillTexture;
    }

    public Identifier getFlowingTexture() {
        return flowingTexture;
    }

    public Identifier getOverlayTexture() {
        return overlayTexture;
    }

    public @Nullable SoundEvent getSound(SoundAction action) {
        return (SoundEvent)this.sounds.get(action);
    }
}
