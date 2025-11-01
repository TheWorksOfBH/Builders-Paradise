package github.theworksofbh.buildersparadise.mixins;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestRenderer.class)
public class ChestRendererMixins<T extends BlockEntity & LidBlockEntity> {


    @Unique
    private static Material getCustomChestPath(String path, boolean isTrapped, String part) {
        if (isTrapped) {
            return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "entity/chest" + path + "/trapped" + part));
        } else {
            return new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "entity/chest" + path + "/normal" + part));
        }
    }

    @Unique
    private static Material determineCustomMaterial(ChestType type, boolean isTrapped, String path) {
        if (isTrapped) {
            return switch (type) {
                case LEFT -> getCustomChestPath(path, true, "_left");
                case RIGHT -> getCustomChestPath(path, true, "_right");
                case SINGLE -> getCustomChestPath(path, true, "");
            };
        } else {
            return switch (type) {
                case LEFT -> getCustomChestPath(path, false, "_left");
                case RIGHT -> getCustomChestPath(path, false, "_right");
                case SINGLE -> getCustomChestPath(path, false, "");
            };
        }
    }

    @Inject(method = "getCustomMaterial", at = @At("HEAD"), cancellable = true)
    private void getModdedChestMaterial(T blockEntity, ChestRenderState renderState, CallbackInfoReturnable<Material> cir) {
        Block block = blockEntity.getBlockState().getBlock();

        if (!(block instanceof ChestBlock) && !(block instanceof TrappedChestBlock)) return;

        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);
        if (key == null || !key.getNamespace().equals(BuildersParadise.MODID)) return;

        boolean isTrapped = block instanceof TrappedChestBlock;
        ChestType type = blockEntity.getBlockState().getValue(ChestBlock.TYPE);
        String rawPath = key.getPath().replace("trapped_", "");
        String path = "/" + rawPath;

        Material mat = determineCustomMaterial(type, isTrapped, path);
        if (mat != null) {
            cir.setReturnValue(mat);
        }
    }
}
