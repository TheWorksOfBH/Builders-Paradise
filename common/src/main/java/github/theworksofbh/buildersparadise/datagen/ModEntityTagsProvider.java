package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.entities.ModEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagsProvider extends TagsProvider<EntityType<?>> {
    public ModEntityTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, Registries.ENTITY_TYPE, provider);
    }

    protected void addTags(HolderLookup.Provider provider) {
        tag(EntityTypeTags.BOAT).add(BuiltInRegistries.ENTITY_TYPE.getResourceKey(ModEntities.CRIMSON_BOAT).orElseThrow());
        tag(EntityTypeTags.BOAT).add(BuiltInRegistries.ENTITY_TYPE.getResourceKey(ModEntities.WARPED_BOAT).orElseThrow());
    }
}