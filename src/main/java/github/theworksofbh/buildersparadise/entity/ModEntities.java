package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(BuildersParadise.MODID);

    public static final Supplier<EntityType<PrimedNuke>> NUKE = register("nuke", PrimedNuke::new, MobCategory.MISC, 0.98F, 0.98F);

    public static <T extends Entity> Supplier<EntityType<T>> register(String registryName, EntityFactory<T> entityFactory, MobCategory mobCategory, float width, float height) {
        return ENTITIES.register(
                registryName,
                () -> Builder.of(
                        entityFactory,
                        mobCategory
                ).sized(
                        width,
                        height
                ).build(
                        ResourceKey.create(
                                Registries.ENTITY_TYPE,
                                ResourceLocation.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        );
    }

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }

}
