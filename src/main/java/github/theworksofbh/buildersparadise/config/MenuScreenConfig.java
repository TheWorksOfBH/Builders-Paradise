package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.gui.FletchingScreen;
import github.theworksofbh.buildersparadise.gui.ModMenuTypes;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class MenuScreenConfig {
    public static void registerCustomScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.FLETCHING_MENU.get(), FletchingScreen::new);
    }

}
