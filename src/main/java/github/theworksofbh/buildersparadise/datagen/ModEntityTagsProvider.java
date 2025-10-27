package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.entity.ModEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }


    protected void addTags(HolderLookup.Provider provider) {
        tag(EntityTypeTags.BOAT).add(ModEntities.CRIMSON_BOAT.get());
        tag(EntityTypeTags.BOAT).add(ModEntities.WARPED_BOAT.get());
    }
}