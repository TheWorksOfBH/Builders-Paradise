package github.theworksofbh.buildersparadise.mixins.compat;

import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.lang.reflect.Method;

@Pseudo
@Mixin(targets = {"net.caffeinemc.mods.sodium.client.render.chunk.shader.DefaultShaderInterface"}, remap = false) // Credits to LivingDEnt on Discord for helping me here
public class SodiumDefaultShaderInterfaceMixin {
   @Redirect(method = {"bindTexture"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/textures/GpuTextureView;texture()Lcom/mojang/blaze3d/textures/GpuTexture;"), remap = false)
   private GpuTexture buildersparadise$unwrapTextureViewTexture(GpuTextureView textureView) {
      GpuTexture texture = textureView.texture();
      return unwrapValidationTexture(texture);
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
}
