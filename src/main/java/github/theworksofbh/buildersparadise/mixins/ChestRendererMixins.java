package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(ChestRenderer.class)
public class ChestRendererMixins {
    @Inject()
    private Material getModdedChestMaterial(BlockEntity blockEntity, ChestType chestType, boolean xmas, Operation<Material> original){
        if (!xmas && blockEntity.getBlockState().getBlock() instanceof ChestBlock chestBlock) {
            if (chestBlock instanceof TrappedChestBlock) {
                return chooseCustomMaterial(chestType, chestBlock.getDescriptionId().replace("block.buildersparadise.", "").replace("trapped_", ""), true);
            } else {
                return chooseCustomMaterial(chestType, chestBlock.getDescriptionId().replace("block.buildersparadise.", ""), false);
            }
        }

        return original.call(blockEntity, chestType, xmas);
    }

}
