package github.theworksofbh.buildersparadise.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState.ChestMaterialType;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class FabricChestRendererMixin {

    @WrapOperation(method = "submit", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/Sheets;chooseSprite(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/sprite/SpriteId;"))
    private SpriteId chooseSprite(ChestMaterialType materialType, ChestType type, Operation<SpriteId> original, ChestRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        Block block = ((BlockEntityRenderStateAccessor) state).getBlockState().getBlock();

        if (!(block instanceof ChestBlock)) {
            return original.call(materialType, type);
        }

        Identifier key = BuiltInRegistries.BLOCK.getKey(block);

        if (key == null || !key.getNamespace().equals(BuildersParadiseConstants.MOD_ID)) {
            return original.call(materialType, type);
        }

        boolean isTrapped = block instanceof TrappedChestBlock;

        String path = key.getPath().replace("trapped_", "");

        if (ChestRenderer.xmasTextures()) {
            return switch (type) {
                case LEFT -> getChristmasChestPath("_left");
                case RIGHT -> getChristmasChestPath("_right");
                case SINGLE -> getChristmasChestPath("");
            };
        }

        return switch (type) {
            case LEFT -> getCustomChestPath(path, isTrapped, "_left");
            case RIGHT -> getCustomChestPath(path, isTrapped, "_right");
            case SINGLE -> getCustomChestPath(path, isTrapped, "");
        };
    }

    @Unique
    private static SpriteId getCustomChestPath(String path, boolean isTrapped, String part) {
        String variant = isTrapped ? "trapped" : "normal";

        return new SpriteId(
                Sheets.CHEST_SHEET,
                Identifier.fromNamespaceAndPath(
                        BuildersParadiseConstants.MOD_ID,
                        "entity/chest/" + path + "/" + variant + part
                )
        );
    }

    @Unique
    private static SpriteId getChristmasChestPath(String part) {
        return new SpriteId(
                Sheets.CHEST_SHEET,
                Identifier.withDefaultNamespace(
                        "entity/chest/christmas" + part
                )
        );
    }
}