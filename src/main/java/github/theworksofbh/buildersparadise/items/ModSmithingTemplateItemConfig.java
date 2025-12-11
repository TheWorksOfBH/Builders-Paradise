package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.ChatFormatting;
import net.minecraft.util.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItemConfig extends SmithingTemplateItem {
    private static final Component BRONZE_UPGRADE_APPLIES_TO;
    private static final Component BRONZE_UPGRADE_INGREDIENTS;
    private static final Component BRONZE_UPGRADE_BASE_SLOT_DESCRIPTION;
    private static final Component BRONZE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION;
    private static final Identifier EMPTY_SLOT_HELMET;
    private static final Identifier EMPTY_SLOT_CHESTPLATE;
    private static final Identifier EMPTY_SLOT_LEGGINGS;
    private static final Identifier EMPTY_SLOT_BOOTS;
    private static final Identifier EMPTY_SLOT_HOE;
    private static final Identifier EMPTY_SLOT_AXE;
    private static final Identifier EMPTY_SLOT_SWORD;
    private static final Identifier EMPTY_SLOT_SHOVEL;
    private static final Identifier EMPTY_SLOT_PICKAXE;
    private static final Identifier EMPTY_SLOT_INGOT;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;


    public ModSmithingTemplateItemConfig(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<Identifier> baseSlotEmptyIcons, List<Identifier> additionalSlotEmptyIcons, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties);
    }

    public static SmithingTemplateItem createBronzeUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(BRONZE_UPGRADE_APPLIES_TO, BRONZE_UPGRADE_INGREDIENTS, BRONZE_UPGRADE_BASE_SLOT_DESCRIPTION, BRONZE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createBronzeUpgradeIconList(), createBronzeUpgradeMaterialList(), properties);
    }

    private static List<Identifier> createBronzeUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<Identifier> createBronzeUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    
    static {
        BRONZE_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "smithing_template.bronze_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
        BRONZE_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "smithing_template.bronze_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
        BRONZE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "smithing_template.bronze_upgrade.base_slot_description")));
        BRONZE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "smithing_template.bronze_upgrade.additions_slot_description")));
        EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("container/slot/helmet");
        EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("container/slot/chestplate");
        EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("container/slot/leggings");
        EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("container/slot/boots");
        EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("container/slot/hoe");
        EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
        EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
        EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
        EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
        EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
    }
}
