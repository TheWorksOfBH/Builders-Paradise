package github.theworksofbh.buildersparadise.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.chest.ChestModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import org.joml.Vector3fc;

import java.util.function.Consumer;

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

    public static final Identifier SPRUCE_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "spruce_chest/normal");
    public static final Identifier BIRCH_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "birch_chest/normal");
    public static final Identifier JUNGLE_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "jungle_chest/normal");
    public static final Identifier ACACIA_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "acacia_chest/normal");
    public static final Identifier DARK_OAK_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "dark_oak_chest/normal");
    public static final Identifier CRIMSON_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "crimson_chest/normal");
    public static final Identifier WARPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "warped_chest/normal");
    public static final Identifier MANGROVE_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "mangrove_chest/normal");
    public static final Identifier CHERRY_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "cherry_chest/normal");
    public static final Identifier BAMBOO_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bamboo_chest/normal");
    public static final Identifier PALE_OAK_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "pale_oak_chest/normal");
    public static final Identifier DEAD_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "dead_chest/normal");
    public static final Identifier EMPYREAL_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "empyreal_chest/normal");
    public static final Identifier FIR_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "fir_chest/normal");
    public static final Identifier HELLBARK_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "hellbark_chest/normal");
    public static final Identifier JACARANDA_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "jacaranda_chest/normal");
    public static final Identifier MAGIC_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "magic_chest/normal");
    public static final Identifier MAHOGANY_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "mahogany_chest/normal");
    public static final Identifier MAPLE_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "maple_chest/normal");
    public static final Identifier PALM_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "palm_chest/normal");
    public static final Identifier PINE_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "pine_chest/normal");
    public static final Identifier REDWOOD_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "redwood_chest/normal");
    public static final Identifier UMBRAN_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "umbran_chest/normal");
    public static final Identifier WILLOW_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "willow_chest/normal");

    public static final Identifier SPRUCE_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "spruce_chest/trapped");
    public static final Identifier BIRCH_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "birch_chest/trapped");
    public static final Identifier JUNGLE_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "jungle_chest/trapped");
    public static final Identifier ACACIA_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "acacia_chest/trapped");
    public static final Identifier DARK_OAK_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "dark_oak_chest/trapped");
    public static final Identifier CRIMSON_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "crimson_chest/trapped");
    public static final Identifier WARPED_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "warped_chest/trapped");
    public static final Identifier MANGROVE_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "mangrove_chest/trapped");
    public static final Identifier CHERRY_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "cherry_chest/trapped");
    public static final Identifier BAMBOO_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bamboo_chest/trapped");
    public static final Identifier PALE_OAK_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "pale_oak_chest/trapped");
    public static final Identifier DEAD_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "dead_chest/trapped");
    public static final Identifier EMPYREAL_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "empyreal_chest/trapped");
    public static final Identifier FIR_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "fir_chest/trapped");
    public static final Identifier HELLBARK_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "hellbark_chest/trapped");
    public static final Identifier JACARANDA_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "jacaranda_chest/trapped");
    public static final Identifier MAGIC_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "magic_chest/trapped");
    public static final Identifier MAHOGANY_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "mahogany_chest/trapped");
    public static final Identifier MAPLE_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "maple_chest/trapped");
    public static final Identifier PALM_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "palm_chest/trapped");
    public static final Identifier PINE_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "pine_chest/trapped");
    public static final Identifier REDWOOD_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "redwood_chest/trapped");
    public static final Identifier UMBRAN_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "umbran_chest/trapped");
    public static final Identifier WILLOW_TRAPPED_CHEST_TEXTURE = Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "willow_chest/trapped");

    public void submit(ItemDisplayContext itemDisplayContext, PoseStack poseStack, SubmitNodeCollector p_440053_, int p_440465_, int p_440260_, boolean p_439501_, int p_451677_) {
        p_440053_.submitModel(this.model, this.openness, poseStack, this.material.renderType(RenderTypes::entitySolid), p_440465_, p_440260_, -1, this.materials.get(this.material), p_451677_, (ModelFeatureRenderer.CrumblingOverlay)null);
    }

    public void getExtents(Consumer<Vector3fc> output) {
        PoseStack posestack = new PoseStack();
        this.model.setupAnim(this.openness);
        this.model.root().getExtentsForGui(posestack, output);
    }

    public static record Unbaked(Identifier texture, float openness) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<ModChestSpecialRenderers.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((p_388545_) -> p_388545_.group(Identifier.CODEC.fieldOf("texture").forGetter(ModChestSpecialRenderers.Unbaked::texture), Codec.FLOAT.optionalFieldOf("openness", 0.0F).forGetter(ModChestSpecialRenderers.Unbaked::openness)).apply(p_388545_, ModChestSpecialRenderers.Unbaked::new));

        public Unbaked(Identifier p_387139_) {
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
