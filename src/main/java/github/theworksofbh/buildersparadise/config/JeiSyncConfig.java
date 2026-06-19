package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

public class JeiSyncConfig {
    public static void addRecipeMapsToJEI(RecipesReceivedEvent event) {
        if (ModList.get().isLoaded("jei")) {
//            SyncedRecipes.setMap(event.getRecipeMap());

        }
    }

    public static void addRecipesToJEI(OnDatapackSyncEvent event) {
        if (ModList.get().isLoaded("jei")) {
            event.sendRecipes(ModRecipes.FLETCHING_RECIPE_TYPE.get());
        }
    }
}
