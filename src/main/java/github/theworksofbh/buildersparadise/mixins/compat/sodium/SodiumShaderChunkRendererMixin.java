package github.theworksofbh.buildersparadise.mixins.compat.sodium;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.lang.reflect.Method;

@Pseudo
@Mixin(targets = {"net.caffeinemc.mods.sodium.client.render.chunk.ShaderChunkRenderer"}, remap = false) // Credits to LivingDEnt on Discord for helping me here
public class SodiumShaderChunkRendererMixin {
   @Redirect(method = {"begin"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/pipeline/RenderTarget;getColorTexture()Lcom/mojang/blaze3d/textures/GpuTexture;"), remap = false)
   private GpuTexture buildersparadise$unwrapColorTexture(RenderTarget target) {
      GpuTexture texture = target.getColorTexture();
      return unwrapValidationTexture(texture);
   }

   @Redirect(method = {"begin"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/pipeline/RenderTarget;getDepthTexture()Lcom/mojang/blaze3d/textures/GpuTexture;"), remap = false)
   private GpuTexture buildersparadise$unwrapDepthTexture(RenderTarget target) {
      GpuTexture texture = target.getDepthTexture();
      return unwrapValidationTexture(texture);
   }

   @Redirect(method = {"begin"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;getDevice()Lcom/mojang/blaze3d/systems/GpuDevice;"), remap = false)
   private static GpuDevice buildersparadise$unwrapDevice() {
      GpuDevice device = RenderSystem.getDevice();
      return unwrapValidationDevice(device);
   }

   private static GpuTexture unwrapValidationTexture(GpuTexture texture) {
      if (texture == null) {
         return null;
      } else if (texture.getClass().getName().equals("net.neoforged.neoforge.client.blaze3d.validation.ValidationGpuTexture")) {
         try {
            Method getRealTexture = texture.getClass().getMethod("getRealTexture");
            return (GpuTexture)getRealTexture.invoke(texture);
         } catch (Exception var2) {
            return texture;
         }
      } else {
         return texture;
      }
   }

   private static GpuDevice unwrapValidationDevice(GpuDevice device) {
      if (device == null) {
         return null;
      } else if (device.getClass().getName().equals("net.neoforged.neoforge.client.blaze3d.validation.ValidationGpuDevice")) {
         try {
            Method getRealDevice = device.getClass().getMethod("getRealDevice");
            return (GpuDevice)getRealDevice.invoke(device);
         } catch (Exception var2) {
            return device;
         }
      } else {
         return device;
      }
   }
}
