
package github.theworksofbh.buildersparadise.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;

import java.util.concurrent.CompletableFuture;

public class ModParticleDescriptionProvider implements DataProvider {
    private final FabricPackOutput output;

    public ModParticleDescriptionProvider(FabricPackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return CompletableFuture.allOf(
                createParticle(cachedOutput, "iron_fire_flame", 4),
                createParticle(cachedOutput, "zinc_fire_flame", 4),
                createParticle(cachedOutput, "silver_fire_flame", 4),
                createParticle(cachedOutput, "tin_fire_flame", 4),
                createParticle(cachedOutput, "tungsten_fire_flame", 4),
                createParticle(cachedOutput, "platinum_fire_flame", 4),
                createParticle(cachedOutput, "gold_fire_flame", 4),
                createParticle(cachedOutput, "lead_fire_flame", 4),
                createParticle(cachedOutput, "bismuth_fire_flame", 4),
                createParticle(cachedOutput, "uranium_fire_flame", 4)
        );
    }

    private CompletableFuture<?> createParticle(CachedOutput cachedOutput, String name, int frameCount) {
        JsonObject json = new JsonObject();
        JsonArray textures = new JsonArray();

        for (int i = 0; i < frameCount; i++) {
            textures.add(BuildersParadiseConstants.MOD_ID + ":" + name + "_" + i);
        }

        json.add("textures", textures);

        return net.minecraft.data.DataProvider.saveStable(
                cachedOutput,
                json,
                output.getOutputFolder()
                        .resolve("assets")
                        .resolve(BuildersParadiseConstants.MOD_ID)
                        .resolve("particles")
                        .resolve(name + ".json")
        );
    }

    @Override
    public String getName() {
        return BuildersParadiseConstants.MOD_ID + " particle descriptions";
    }
}
