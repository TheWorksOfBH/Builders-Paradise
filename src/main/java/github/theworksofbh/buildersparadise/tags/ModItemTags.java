package github.theworksofbh.buildersparadise.tags;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> CHESTS = create("chests");
    public static final TagKey<Item> BARRELS = create("barrels");
    public static final TagKey<Item> DROPPERS = create("droppers");
    public static final TagKey<Item> CONCRETE = create("concrete");
    public static final TagKey<Item> BRONZE_TOOL_MATERIALS = create("bronze_tool_materials");
    public static final TagKey<Item> REPAIRS_BRONZE_ARMOR = create("repairs_bronze_armor");
    public static final TagKey<Item> VIABLE_FLETCHING_INGREDIENTS = create("viable_fletching_ingredients");

    private ModItemTags() {
    }

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BuildersParadise.MODID, name));
    }

    public static TagKey<Item> create(Identifier name) {
        return TagKey.create(Registries.ITEM, name);
    }

}
