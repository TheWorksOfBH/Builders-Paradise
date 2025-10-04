package github.theworksofbh.buildersparadise.gui;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(BuiltInRegistries.MENU, BuildersParadise.MODID);

    public static final Supplier<MenuType<FletchingMenu>> FLETCHING_MENU = registerMenu("fletching", FletchingMenu::new);

    public static <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenu(String registryName, MenuType.MenuSupplier<T> constructor) {
        return MENU_TYPES.register(registryName, () -> new MenuType<>(constructor, FeatureFlags.VANILLA_SET));
    }

    public static void register(IEventBus eventBus){
        MENU_TYPES.register(eventBus);
    }
}
