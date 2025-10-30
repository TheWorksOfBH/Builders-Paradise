package github.theworksofbh.buildersparadise.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.model.ChestModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector3f;

import java.util.Set;

public class ModChestSpecialRenderers extends ChestSpecialRenderer {
    public ModChestSpecialRenderers(MaterialSet p_434968_, ChestModel p_386863_, Material p_388350_, float p_386750_) {
        super(p_434968_, p_386863_, p_388350_, p_386750_);
        this.materials = p_434968_;
        this.model = p_386863_;
        this.material = p_388350_;
        this.openness = p_386750_;
    }
    private final MaterialSet materials;
    private final ChestModel model;
    private final Material material;
    private final float openness;

    public static final ResourceLocation SPRUCE_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "spruce_chest/normal");
    public static final ResourceLocation BIRCH_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "birch_chest/normal");
    public static final ResourceLocation JUNGLE_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "jungle_chest/normal");
    public static final ResourceLocation ACACIA_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "acacia_chest/normal");
    public static final ResourceLocation DARK_OAK_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "dark_oak_chest/normal");
    public static final ResourceLocation CRIMSON_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "crimson_chest/normal");
    public static final ResourceLocation WARPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "warped_chest/normal");
    public static final ResourceLocation MANGROVE_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "mangrove_chest/normal");
    public static final ResourceLocation CHERRY_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "cherry_chest/normal");
    public static final ResourceLocation BAMBOO_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "bamboo_chest/normal");
    public static final ResourceLocation PALE_OAK_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "pale_oak_chest/normal");

    public static final ResourceLocation SPRUCE_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "spruce_chest/trapped");
    public static final ResourceLocation BIRCH_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "birch_chest/trapped");
    public static final ResourceLocation JUNGLE_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "jungle_chest/trapped");
    public static final ResourceLocation ACACIA_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "acacia_chest/trapped");
    public static final ResourceLocation DARK_OAK_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "dark_oak_chest/trapped");
    public static final ResourceLocation CRIMSON_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "crimson_chest/trapped");
    public static final ResourceLocation WARPED_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "warped_chest/trapped");
    public static final ResourceLocation MANGROVE_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "mangrove_chest/trapped");
    public static final ResourceLocation CHERRY_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "cherry_chest/trapped");
    public static final ResourceLocation BAMBOO_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "bamboo_chest/trapped");
    public static final ResourceLocation PALE_OAK_TRAPPED_CHEST_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "pale_oak_chest/trapped");

    public void submit(ItemDisplayContext p_440682_, PoseStack p_439468_, SubmitNodeCollector p_440053_, int p_440465_, int p_440260_, boolean p_439501_, int p_451677_) {
        p_440053_.submitModel(this.model, this.openness, p_439468_, this.material.renderType(RenderType::entitySolid), p_440465_, p_440260_, -1, this.materials.get(this.material), p_451677_, (ModelFeatureRenderer.CrumblingOverlay)null);
    }

    public void getExtents(Set<Vector3f> output) {
        PoseStack posestack = new PoseStack();
        this.model.setupAnim(this.openness);
        this.model.root().getExtentsForGui(posestack, output);
    }

    public static record Unbaked(ResourceLocation texture, float openness) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<ModChestSpecialRenderers.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((p_388545_) -> p_388545_.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(ModChestSpecialRenderers.Unbaked::texture), Codec.FLOAT.optionalFieldOf("openness", 0.0F).forGetter(ModChestSpecialRenderers.Unbaked::openness)).apply(p_388545_, ModChestSpecialRenderers.Unbaked::new));

        public Unbaked(ResourceLocation p_387139_) {
            this(p_387139_, 0.0F);
        }

        public MapCodec<ModChestSpecialRenderers.Unbaked> type() {
            return MAP_CODEC;
        }

        public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext p_434841_) {
            ChestModel chestmodel = new ChestModel(p_434841_.entityModelSet().bakeLayer(ModelLayers.CHEST));
            Material material = Sheets.CHEST_MAPPER.apply(this.texture);
            return new ModChestSpecialRenderers(p_434841_.materials(), chestmodel, material, this.openness);
        }
    }
}
