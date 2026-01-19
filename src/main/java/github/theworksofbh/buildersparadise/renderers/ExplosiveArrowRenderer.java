package github.theworksofbh.buildersparadise.renderers;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.entity.ExplosiveArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class ExplosiveArrowRenderer extends ArrowRenderer<ExplosiveArrow, ArrowRenderState> {
    public static final Identifier EXPLOSIVE_ARROW_LOCATION = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "textures/entity/projectiles/explosive_arrow.png");

    public ExplosiveArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTextureLocation(ArrowRenderState arrowRenderState) {
        return EXPLOSIVE_ARROW_LOCATION;
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
