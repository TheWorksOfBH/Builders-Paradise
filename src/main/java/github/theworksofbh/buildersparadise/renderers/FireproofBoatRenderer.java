package github.theworksofbh.buildersparadise.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import github.theworksofbh.buildersparadise.model_layers.ModModelLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Unit;

public class FireproofBoatRenderer extends BoatRenderer {
    private final Model.Simple waterPatchModel;
    private final EntityModel<BoatRenderState> model;

    public FireproofBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelId) {
        super(context, modelId);
        this.waterPatchModel = new Model.Simple(context.bakeLayer(ModModelLayers.BOAT_LAVA_PATCH), (t) -> RenderTypes.waterMask());
        this.model = new BoatModel(context.bakeLayer(modelId));
    }

    @Override
    protected EntityModel<BoatRenderState> model() {
        return this.model;
    }

    @Override
    protected void submitTypeAdditions(BoatRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords) {
        if (!state.isUnderWater) {
            submitNodeCollector.submitModel(this.waterPatchModel, Unit.INSTANCE, poseStack, this.texture, lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor, (ModelFeatureRenderer.CrumblingOverlay)null);
        }
    }
}
