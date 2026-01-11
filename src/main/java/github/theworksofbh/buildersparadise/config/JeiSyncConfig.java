package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.recipes.ModRecipes;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

public class JeiSyncConfig {
    public static void addRecipesToJEI(OnDatapackSyncEvent event) {
        event.sendRecipes(ModRecipes.FLETCHING_RECIPE_TYPE.get());
    }
}
