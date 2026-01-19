package github.theworksofbh.buildersparadise.renderers;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.entity.SharpenedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class SharpenedArrowRenderer extends ArrowRenderer<SharpenedArrow, ArrowRenderState> {
    public static final Identifier SHARPENED_ARROW_LOCATION = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/entity/projectiles/sharpened_arrow.png");

    public SharpenedArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTextureLocation(ArrowRenderState arrowRenderState) {
        return SHARPENED_ARROW_LOCATION;
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
