package github.theworksofbh.buildersparadise.events;

import github.theworksofbh.buildersparadise.menu.FletchingScreen;
import github.theworksofbh.buildersparadise.menu.ModMenuTypes;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class NeoForgeMenuScreenEvent {
    public static void registerCustomScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.FLETCHING_MENU, FletchingScreen::new);
    }
}
