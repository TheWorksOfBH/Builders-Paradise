package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.items.ModArmorMaterials;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.items.ModMaterialAssetGroups;
import github.theworksofbh.buildersparadise.items.ModTrimMaterials;
import net.minecraft.client.color.item.Dye;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ModItemModelGenerator extends ItemModelGenerators {
    public ModItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }

    public static final List<ModTrimMaterialData> MOD_TRIM_MATERIAL_MODELS = List.of(
            new ModTrimMaterialData(MaterialAssetGroup.QUARTZ, TrimMaterials.QUARTZ),
            new ModTrimMaterialData(MaterialAssetGroup.IRON, TrimMaterials.IRON),
            new ModTrimMaterialData(MaterialAssetGroup.NETHERITE, TrimMaterials.NETHERITE),
            new ModTrimMaterialData(MaterialAssetGroup.REDSTONE, TrimMaterials.REDSTONE),
            new ModTrimMaterialData(MaterialAssetGroup.COPPER, TrimMaterials.COPPER),
            new ModTrimMaterialData(MaterialAssetGroup.GOLD, TrimMaterials.GOLD),
            new ModTrimMaterialData(MaterialAssetGroup.EMERALD, TrimMaterials.EMERALD),
            new ModTrimMaterialData(MaterialAssetGroup.DIAMOND, TrimMaterials.DIAMOND),
            new ModTrimMaterialData(MaterialAssetGroup.LAPIS, TrimMaterials.LAPIS),
            new ModTrimMaterialData(MaterialAssetGroup.AMETHYST, TrimMaterials.AMETHYST),
            new ModTrimMaterialData(MaterialAssetGroup.RESIN, TrimMaterials.RESIN),
            new ModTrimMaterialData(ModMaterialAssetGroups.ZINC, ModTrimMaterials.ZINC),
            new ModTrimMaterialData(ModMaterialAssetGroups.SILVER, ModTrimMaterials.SILVER),
            new ModTrimMaterialData(ModMaterialAssetGroups.TIN, ModTrimMaterials.TIN),
            new ModTrimMaterialData(ModMaterialAssetGroups.TUNGSTEN, ModTrimMaterials.TUNGSTEN),
            new ModTrimMaterialData(ModMaterialAssetGroups.PLATINUM, ModTrimMaterials.PLATINUM),
            new ModTrimMaterialData(ModMaterialAssetGroups.LEAD, ModTrimMaterials.LEAD),
            new ModTrimMaterialData(ModMaterialAssetGroups.URANIUM, ModTrimMaterials.URANIUM),
            new ModTrimMaterialData(ModMaterialAssetGroups.BRONZE, ModTrimMaterials.BRONZE),
            new ModTrimMaterialData(ModMaterialAssetGroups.BRASS, ModTrimMaterials.BRASS),
            new ModTrimMaterialData(ModMaterialAssetGroups.STEEL, ModTrimMaterials.STEEL),
            new ModTrimMaterialData(ModMaterialAssetGroups.SCULK, ModTrimMaterials.SCULK)
            );

    public void generateCustomTrimmableItem(Item item, ResourceKey<EquipmentAsset> assetResourceKey, Identifier prefix, boolean dyeable) {
        Identifier identifier = ModelLocationUtils.getModelLocation(item);
        Identifier identifier1 = TextureMapping.getItemTexture(item);
        Identifier identifier2 = TextureMapping.getItemTexture(item, "_overlay");
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> list = new ArrayList(MOD_TRIM_MATERIAL_MODELS.size());

        for (ModTrimMaterialData moditemmodelgenerator$modtrimmaterialdata : MOD_TRIM_MATERIAL_MODELS) {
            Identifier identifier3 = identifier.withSuffix("_" + moditemmodelgenerator$modtrimmaterialdata.assets().base().suffix() + "_trim");
            String var10001 = moditemmodelgenerator$modtrimmaterialdata.assets().assetId(assetResourceKey).suffix();
            Identifier identifier4 = prefix.withSuffix("_" + var10001);
            ItemModel.Unbaked itemmodel$unbaked;
            if (dyeable) {
                this.generateLayeredItem(identifier3, identifier1, identifier2, identifier4);
                itemmodel$unbaked = ItemModelUtils.tintedModel(identifier3, new ItemTintSource[]{new Dye(-6265536)});
            } else {
                this.generateLayeredItem(identifier3, identifier1, identifier4);
                itemmodel$unbaked = ItemModelUtils.plainModel(identifier3);
            }

            list.add(ItemModelUtils.when(moditemmodelgenerator$modtrimmaterialdata.materialKey, itemmodel$unbaked));
        }

        ItemModel.Unbaked itemmodel$unbaked1;
        if (dyeable) {
            ModelTemplates.TWO_LAYERED_ITEM.create(identifier, TextureMapping.layered(identifier1, identifier2), this.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.tintedModel(identifier, new ItemTintSource[]{new Dye(-6265536)});
        } else {
            ModelTemplates.FLAT_ITEM.create(identifier, TextureMapping.layer0(identifier1), this.modelOutput);
            itemmodel$unbaked1 = ItemModelUtils.plainModel(identifier);
        }

        this.itemModelOutput.accept(item, ItemModelUtils.select(new TrimMaterialProperty(), itemmodel$unbaked1, list));
    }

    public static record ModTrimMaterialData(MaterialAssetGroup assets, ResourceKey<TrimMaterial> materialKey) {
    }

    @Override
    public void run() {
        this.generateFlatItem(ModItems.ELDER_PRISMARINE_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ELDER_PRISMARINE_CRYSTALS.get(), ModelTemplates.FLAT_ITEM);
//        this.generateFlatItem(ModItems.COPPER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.NETHERITE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_ZINC.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ZINC_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ZINC_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_SILVER.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SILVER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_TIN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.TIN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_TUNGSTEN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.TUNGSTEN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.TUNGSTEN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_PLATINUM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.PLATINUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.PLATINUM_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_URANIUM.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.URANIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.URANIUM_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRASS_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRASS_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.NUCLEAR_WASTE_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MUSIC_DISC_CIRCUITRIC_MAGNET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MUSIC_DISC_ANGRY_BOYFRIENDS.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CRIMSON_BOAT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.WARPED_BOAT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CRIMSON_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.WARPED_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.STONE_FURNACE_MINECART.get(), Items.FURNACE_MINECART, ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BLACKSTONE_FURNACE_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.DEEPSLATE_FURNACE_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.OAK_CHEST_MINECART.get(), Items.CHEST_MINECART, ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SPRUCE_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BIRCH_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.JUNGLE_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ACACIA_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.DARK_OAK_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CRIMSON_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.WARPED_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MANGROVE_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CHERRY_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BAMBOO_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.PALE_OAK_CHEST_MINECART.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.STONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.GRANITE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.DIORITE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.ANDESITE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.DEEPSLATE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.TUFF_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CALCITE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PACKED_MUD_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.SANDSTONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.RED_SANDSTONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.SOUL_SANDSTONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.END_STONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.NETHERRACK_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BLACKSTONE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BASALT_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.OBSIDIAN_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.TERRACOTTA_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CONCRETE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.ICE_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SCULK_BRICK.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BRONZE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BRONZE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BRONZE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.BRONZE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateSpear(ModItems.BRONZE_SPEAR.get());
        this.generateCustomTrimmableItem(ModItems.BRONZE_HELMET.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(ModItems.BRONZE_CHESTPLATE.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(ModItems.BRONZE_LEGGINGS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(ModItems.BRONZE_BOOTS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_BOOTS, false);
        this.generateFlatItem(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        this.generateCustomTrimmableItem(Items.LEATHER_HELMET, EquipmentAssets.LEATHER, TRIM_PREFIX_HELMET, true);
        this.generateCustomTrimmableItem(Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, TRIM_PREFIX_CHESTPLATE, true);
        this.generateCustomTrimmableItem(Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, TRIM_PREFIX_LEGGINGS, true);
        this.generateCustomTrimmableItem(Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, TRIM_PREFIX_BOOTS, true);
        this.generateCustomTrimmableItem(Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(Items.COPPER_HELMET, EquipmentAssets.COPPER, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.COPPER_BOOTS, EquipmentAssets.COPPER, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(Items.IRON_HELMET, EquipmentAssets.IRON, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.IRON_CHESTPLATE, EquipmentAssets.IRON, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.IRON_LEGGINGS, EquipmentAssets.IRON, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.IRON_BOOTS, EquipmentAssets.IRON, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(Items.GOLDEN_HELMET, EquipmentAssets.GOLD, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, TRIM_PREFIX_BOOTS, false);


    }
}
