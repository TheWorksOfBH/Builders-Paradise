package github.theworksofbh.buildersparadise.renderers;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.entities.types.StreamlinedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class StreamlinedArrowRenderer extends ArrowRenderer<StreamlinedArrow, ArrowRenderState> {
    public static final Identifier STREAMLINED_ARROW_LOCATION = Identifier.fromNamespaceAndPath(BuildersParadiseConstants.MOD_ID, "textures/entity/projectiles/streamlined_arrow.png");

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