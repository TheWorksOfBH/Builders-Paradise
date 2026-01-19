package github.theworksofbh.buildersparadise.renderers;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.entity.StreamlinedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class StreamlinedArrowRenderer extends ArrowRenderer<StreamlinedArrow, ArrowRenderState> {
    public static final Identifier STREAMLINED_ARROW_LOCATION = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/entity/projectiles/streamlined_arrow.png");

    public StreamlinedArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTextureLocation(ArrowRenderState arrowRenderState) {
        return STREAMLINED_ARROW_LOCATION;
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
