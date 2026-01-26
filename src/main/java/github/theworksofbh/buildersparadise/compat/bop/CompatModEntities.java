package github.theworksofbh.buildersparadise.compat.bop;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.entity.MinecartCustomChest;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CompatModEntities {
    public static final DeferredRegister.Entities BOP_ENTITIES = DeferredRegister.createEntities(BuildersParadise.MODID);

    public static final Supplier<EntityType<MinecartCustomChest>> DEAD_CHEST_MINECART = register("dead_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.DEAD_CHEST.get(), CompatModItems.DEAD_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> EMPYREAL_CHEST_MINECART = register("empyreal_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.EMPYREAL_CHEST.get(), CompatModItems.EMPYREAL_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> FIR_CHEST_MINECART = register("fir_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.FIR_CHEST.get(), CompatModItems.FIR_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> HELLBARK_CHEST_MINECART = register("hellbark_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.HELLBARK_CHEST.get(), CompatModItems.HELLBARK_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> JACARANDA_CHEST_MINECART = register("jacaranda_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.JACARANDA_CHEST.get(), CompatModItems.JACARANDA_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> MAGIC_CHEST_MINECART = register("magic_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.MAGIC_CHEST.get(), CompatModItems.MAGIC_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> MAHOGANY_CHEST_MINECART = register("mahogany_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.MAHOGANY_CHEST.get(), CompatModItems.MAHOGANY_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> MAPLE_CHEST_MINECART = register("maple_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.MAPLE_CHEST.get(), CompatModItems.MAPLE_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> PALM_CHEST_MINECART = register("palm_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.PALM_CHEST.get(), CompatModItems.PALM_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> PINE_CHEST_MINECART = register("pine_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.PINE_CHEST.get(), CompatModItems.PINE_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> REDWOOD_CHEST_MINECART = register("redwood_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.REDWOOD_CHEST.get(), CompatModItems.REDWOOD_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> UMBRAN_CHEST_MINECART = register("umbran_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.UMBRAN_CHEST.get(), CompatModItems.UMBRAN_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> WILLOW_CHEST_MINECART = register("willow_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.WILLOW_CHEST.get(), CompatModItems.WILLOW_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);
    public static final Supplier<EntityType<MinecartCustomChest>> ORIGIN_OAK_CHEST_MINECART = register("origin_oak_chest_minecart", (customChestMinecart, level) -> new MinecartCustomChest(customChestMinecart, level, CompatModBlocks.ORIGIN_OAK_CHEST.get(), CompatModItems.ORIGIN_OAK_CHEST_MINECART.get()), MobCategory.MISC, 0.98F, 0.7F);

    public static <T extends Entity> Supplier<EntityType<T>> register(String registryName, EntityType.EntityFactory<T> entityFactory, MobCategory mobCategory, float width, float height) {
        return BOP_ENTITIES.register(
                registryName,
                () -> EntityType.Builder.of(
                        entityFactory,
                        mobCategory
                ).sized(
                        width,
                        height
                ).noLootTable().build(
                        ResourceKey.create(
                                Registries.ENTITY_TYPE,
                                Identifier.fromNamespaceAndPath(
                                        BuildersParadise.MODID,
                                        registryName
                                )
                        )
                )
        );
    }

    public static void register(IEventBus eventBus){
        BOP_ENTITIES.register(eventBus);
    }
}
