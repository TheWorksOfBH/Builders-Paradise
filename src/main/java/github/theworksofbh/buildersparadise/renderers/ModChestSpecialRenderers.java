package github.theworksofbh.buildersparadise.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.chest.ChestModel;
import net.minecraft.client.renderer.MultiblockChestResources;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.joml.Vector3fc;

import java.util.function.Consumer;

public class ModChestSpecialRenderers extends ChestSpecialRenderer {
    private final SpriteGetter sprites;
    private final ChestModel model;
    private final SpriteId sprite;
    private final float openness;

    public ModChestSpecialRenderers(SpriteGetter sprites, ChestModel model, SpriteId sprite, float openness) {
        super(sprites, model, sprite, openness);
        this.sprites = sprites;
        this.model = model;
        this.sprite = sprite;
        this.openness = openness;
    }

    public static final MultiblockChestResources<Identifier> SPRUCE_CHEST_TEXTURE = createDefaultTextures("spruce_chest/normal");
    public static final MultiblockChestResources<Identifier> BIRCH_CHEST_TEXTURE = createDefaultTextures("birch_chest/normal");
    public static final MultiblockChestResources<Identifier> JUNGLE_CHEST_TEXTURE = createDefaultTextures("jungle_chest/normal");
    public static final MultiblockChestResources<Identifier> ACACIA_CHEST_TEXTURE = createDefaultTextures("acacia_chest/normal");
    public static final MultiblockChestResources<Identifier> DARK_OAK_CHEST_TEXTURE = createDefaultTextures("dark_oak_chest/normal");
    public static final MultiblockChestResources<Identifier> CRIMSON_CHEST_TEXTURE = createDefaultTextures("crimson_chest/normal");
    public static final MultiblockChestResources<Identifier> WARPED_CHEST_TEXTURE = createDefaultTextures("warped_chest/normal");
    public static final MultiblockChestResources<Identifier> MANGROVE_CHEST_TEXTURE = createDefaultTextures("mangrove_chest/normal");
    public static final MultiblockChestResources<Identifier> CHERRY_CHEST_TEXTURE = createDefaultTextures("cherry_chest/normal");
    public static final MultiblockChestResources<Identifier> BAMBOO_CHEST_TEXTURE = createDefaultTextures("bamboo_chest/normal");
    public static final MultiblockChestResources<Identifier> PALE_OAK_CHEST_TEXTURE = createDefaultTextures("pale_oak_chest/normal");
    public static final MultiblockChestResources<Identifier> DEAD_CHEST_TEXTURE = createDefaultTextures("dead_chest/normal");
    public static final MultiblockChestResources<Identifier> EMPYREAL_CHEST_TEXTURE = createDefaultTextures("empyreal_chest/normal");
    public static final MultiblockChestResources<Identifier> FIR_CHEST_TEXTURE = createDefaultTextures("fir_chest/normal");
    public static final MultiblockChestResources<Identifier> HELLBARK_CHEST_TEXTURE = createDefaultTextures("hellbark_chest/normal");
    public static final MultiblockChestResources<Identifier> JACARANDA_CHEST_TEXTURE = createDefaultTextures("jacaranda_chest/normal");
    public static final MultiblockChestResources<Identifier> MAGIC_CHEST_TEXTURE = createDefaultTextures("magic_chest/normal");
    public static final MultiblockChestResources<Identifier> MAHOGANY_CHEST_TEXTURE = createDefaultTextures("mahogany_chest/normal");
    public static final MultiblockChestResources<Identifier> MAPLE_CHEST_TEXTURE = createDefaultTextures("maple_chest/normal");
    public static final MultiblockChestResources<Identifier> PALM_CHEST_TEXTURE = createDefaultTextures("palm_chest/normal");
    public static final MultiblockChestResources<Identifier> PINE_CHEST_TEXTURE = createDefaultTextures("pine_chest/normal");
    public static final MultiblockChestResources<Identifier> REDWOOD_CHEST_TEXTURE = createDefaultTextures("redwood_chest/normal");
    public static final MultiblockChestResources<Identifier> UMBRAN_CHEST_TEXTURE = createDefaultTextures("umbran_chest/normal");
    public static final MultiblockChestResources<Identifier> WILLOW_CHEST_TEXTURE = createDefaultTextures("willow_chest/normal");

    public static final MultiblockChestResources<Identifier> SPRUCE_TRAPPED_CHEST_TEXTURE = createDefaultTextures("spruce_chest/trapped");
    public static final MultiblockChestResources<Identifier> BIRCH_TRAPPED_CHEST_TEXTURE = createDefaultTextures("birch_chest/trapped");
    public static final MultiblockChestResources<Identifier> JUNGLE_TRAPPED_CHEST_TEXTURE = createDefaultTextures("jungle_chest/trapped");
    public static final MultiblockChestResources<Identifier> ACACIA_TRAPPED_CHEST_TEXTURE = createDefaultTextures("acacia_chest/trapped");
    public static final MultiblockChestResources<Identifier> DARK_OAK_TRAPPED_CHEST_TEXTURE = createDefaultTextures("dark_oak_chest/trapped");
    public static final MultiblockChestResources<Identifier> CRIMSON_TRAPPED_CHEST_TEXTURE = createDefaultTextures("crimson_chest/trapped");
    public static final MultiblockChestResources<Identifier> WARPED_TRAPPED_CHEST_TEXTURE = createDefaultTextures("warped_chest/trapped");
    public static final MultiblockChestResources<Identifier> MANGROVE_TRAPPED_CHEST_TEXTURE = createDefaultTextures("mangrove_chest/trapped");
    public static final MultiblockChestResources<Identifier> CHERRY_TRAPPED_CHEST_TEXTURE = createDefaultTextures("cherry_chest/trapped");
    public static final MultiblockChestResources<Identifier> BAMBOO_TRAPPED_CHEST_TEXTURE = createDefaultTextures("bamboo_chest/trapped");
    public static final MultiblockChestResources<Identifier> PALE_OAK_TRAPPED_CHEST_TEXTURE = createDefaultTextures("pale_oak_chest/trapped");
    public static final MultiblockChestResources<Identifier> DEAD_TRAPPED_CHEST_TEXTURE = createDefaultTextures("dead_chest/trapped");
    public static final MultiblockChestResources<Identifier> EMPYREAL_TRAPPED_CHEST_TEXTURE = createDefaultTextures("empyreal_chest/trapped");
    public static final MultiblockChestResources<Identifier> FIR_TRAPPED_CHEST_TEXTURE = createDefaultTextures("fir_chest/trapped");
    public static final MultiblockChestResources<Identifier> HELLBARK_TRAPPED_CHEST_TEXTURE = createDefaultTextures("hellbark_chest/trapped");
    public static final MultiblockChestResources<Identifier> JACARANDA_TRAPPED_CHEST_TEXTURE = createDefaultTextures("jacaranda_chest/trapped");
    public static final MultiblockChestResources<Identifier> MAGIC_TRAPPED_CHEST_TEXTURE = createDefaultTextures("magic_chest/trapped");
    public static final MultiblockChestResources<Identifier> MAHOGANY_TRAPPED_CHEST_TEXTURE = createDefaultTextures("mahogany_chest/trapped");
    public static final MultiblockChestResources<Identifier> MAPLE_TRAPPED_CHEST_TEXTURE = createDefaultTextures("maple_chest/trapped");
    public static final MultiblockChestResources<Identifier> PALM_TRAPPED_CHEST_TEXTURE = createDefaultTextures("palm_chest/trapped");
    public static final MultiblockChestResources<Identifier> PINE_TRAPPED_CHEST_TEXTURE = createDefaultTextures("pine_chest/trapped");
    public static final MultiblockChestResources<Identifier> REDWOOD_TRAPPED_CHEST_TEXTURE = createDefaultTextures("redwood_chest/trapped");
    public static final MultiblockChestResources<Identifier> UMBRAN_TRAPPED_CHEST_TEXTURE = createDefaultTextures("umbran_chest/trapped");
    public static final MultiblockChestResources<Identifier> WILLOW_TRAPPED_CHEST_TEXTURE = createDefaultTextures("willow_chest/trapped");

    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, boolean hasFoil, int outlineColor) {
        submitNodeCollector.submitModel(this.model, this.openness, poseStack, lightCoords, overlayCoords, -1, this.sprite, this.sprites, outlineColor, (ModelFeatureRenderer.CrumblingOverlay)null);
    }

    public void getExtents(Consumer<Vector3fc> output) {
        PoseStack poseStack = new PoseStack();
        this.model.setupAnim(this.openness);
        this.model.root().getExtentsForGui(poseStack, output);
    }

    public static record Unbaked(Identifier texture, float openness, ChestType chestType) implements NoDataSpecialModelRenderer.Unbaked {
        public static final MapCodec<ChestSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(Identifier.CODEC.fieldOf("texture").forGetter(ChestSpecialRenderer.Unbaked::texture), Codec.FLOAT.optionalFieldOf("openness", 0.0F).forGetter(ChestSpecialRenderer.Unbaked::openness), ChestType.CODEC.optionalFieldOf("chest_type", ChestType.SINGLE).forGetter(ChestSpecialRenderer.Unbaked::chestType)).apply(i, ChestSpecialRenderer.Unbaked::new));

        public Unbaked(Identifier texture, ChestType chestType) {
            this(texture, 0.0F, chestType);
        }

        public Unbaked(Identifier texture) {
            this(texture, 0.0F, ChestType.SINGLE);
        }

        public MapCodec<ChestSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        public ChestSpecialRenderer bake(SpecialModelRenderer.BakingContext context) {
            ChestModel model = new ChestModel(context.entityModelSet().bakeLayer((ModelLayerLocation) ChestRenderer.LAYERS.select(this.chestType)));
            SpriteId fullTexture = Sheets.CHEST_MAPPER.apply(this.texture);
            return new ChestSpecialRenderer(context.sprites(), model, fullTexture, this.openness);
        }
    }

    private static MultiblockChestResources<Identifier> createDefaultTextures(String prefix) {
        return new MultiblockChestResources(Identifier.fromNamespaceAndPath(BuildersParadise.MODID, prefix), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, prefix + "_left"), Identifier.fromNamespaceAndPath(BuildersParadise.MODID, prefix + "_right"));
    }
}
