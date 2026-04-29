package github.theworksofbh.buildersparadise.mixins.compat.sodium;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Optional;

@Pseudo
@Mixin(targets = {"net.caffeinemc.mods.sodium.neoforge.config.ConfigLoaderForge"}, remap = false) // Credits to LivingDEnt on Discord for helping me here
public class SodiumConfigLoaderForgeMixin {
   @Inject(method = {"getModMetadata"}, at = {@At("HEAD")}, cancellable = true, remap = false)
   private static void buildersparadise$fixModMetadataLookup(String modId, CallbackInfoReturnable<Object> cir) {
      try {
         Optional<? extends ModContainer> containerOpt = ModList.get().getModContainerById(modId);
         if (containerOpt.isPresent()) {
            IModInfo mod = ((ModContainer)containerOpt.get()).getModInfo();
            Object result = createModMetadata(mod.getDisplayName(), mod.getVersion().toString());
            cir.setReturnValue(result);
            return;
         }

         Iterator var3 = ModList.get().getMods().iterator();

         while(var3.hasNext()) {
            IModInfo mod = (IModInfo)var3.next();
            if (mod.getModId().equals(modId)) {
               Object result = createModMetadata(mod.getDisplayName(), mod.getVersion().toString());
               cir.setReturnValue(result);
               return;
            }
         }

         Object result = createModMetadata(modId, "UNKNOWN");
         cir.setReturnValue(result);
      } catch (Exception var6) {
      }

   }

   private static Object createModMetadata(String modName, String modVersion) {
      try {
         Class<?> metadataClass = Class.forName("net.caffeinemc.mods.sodium.client.config.ConfigManager$ModMetadata");
         Constructor<?> constructor = metadataClass.getDeclaredConstructor(String.class, String.class);
         constructor.setAccessible(true);
         return constructor.newInstance(modName, modVersion);
      } catch (Exception var4) {
         throw new RuntimeException("Failed to create ModMetadata", var4);
      }
   }
}
