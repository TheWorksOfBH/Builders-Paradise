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
import net.minecraft.client.resources.model.sprite.Material;
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

    public static final List<TrimMaterialData> MOD_TRIM_MATERIAL_MODELS = List.of(
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.QUARTZ, TrimMaterials.QUARTZ),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.IRON, TrimMaterials.IRON),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.NETHERITE, TrimMaterials.NETHERITE),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.REDSTONE, TrimMaterials.REDSTONE),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.COPPER, TrimMaterials.COPPER),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.GOLD, TrimMaterials.GOLD),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.EMERALD, TrimMaterials.EMERALD),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.DIAMOND, TrimMaterials.DIAMOND),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.LAPIS, TrimMaterials.LAPIS),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.AMETHYST, TrimMaterials.AMETHYST),
            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.RESIN, TrimMaterials.RESIN),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.ZINC, ModTrimMaterials.ZINC),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.SILVER, ModTrimMaterials.SILVER),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.TIN, ModTrimMaterials.TIN),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.TUNGSTEN, ModTrimMaterials.TUNGSTEN),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.PLATINUM, ModTrimMaterials.PLATINUM),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.LEAD, ModTrimMaterials.LEAD),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.URANIUM, ModTrimMaterials.URANIUM),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.BRONZE, ModTrimMaterials.BRONZE),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.BRASS, ModTrimMaterials.BRASS),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.STEEL, ModTrimMaterials.STEEL),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.SCULK, ModTrimMaterials.SCULK),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.MONOCRYSTAL, ModTrimMaterials.MONOCRYSTAL),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.RUBY, ModTrimMaterials.RUBY),
            new ItemModelGenerators.TrimMaterialData(ModMaterialAssetGroups.SAPPHIRE, ModTrimMaterials.SAPPHIRE)
    );

    @Override
    public void generateTrimmableItem(Item item, ResourceKey<EquipmentAsset> equipmentAsset, Identifier trimBaseTexture, boolean hasOverlay) {
        Identifier modelId = ModelLocationUtils.getModelLocation(item);
        Material baseTexture = TextureMapping.getItemTexture(item);
        Material overlayTexture = TextureMapping.getItemTexture(item, "_overlay");

        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> cases = new ArrayList<>(MOD_TRIM_MATERIAL_MODELS.size());

        for (TrimMaterialData trimData : MOD_TRIM_MATERIAL_MODELS) {
            Identifier trimmedModelId = modelId.withSuffix("_" + trimData.assets().base().suffix() + "_trim");

            Identifier materialId = trimData.materialKey().identifier();

            String trimSuffix = trimData.assets().assetId(equipmentAsset).suffix();

            Material layer1Texture = new Material(trimBaseTexture.withSuffix("_" + trimSuffix));

            ItemModel.Unbaked unbaked;
            if (hasOverlay) {
                this.generateLayeredItem(trimmedModelId, baseTexture, overlayTexture, layer1Texture);
                unbaked = ItemModelUtils.tintedModel(trimmedModelId, new ItemTintSource[]{ new Dye(-6265536) });
            } else {
                this.generateLayeredItem(trimmedModelId, baseTexture, layer1Texture);
                unbaked = ItemModelUtils.plainModel(trimmedModelId);
            }
            cases.add(ItemModelUtils.when(trimData.materialKey(), unbaked));
        }
        ItemModel.Unbaked fallback;
        if (hasOverlay) {
            ModelTemplates.TWO_LAYERED_ITEM.create(modelId, TextureMapping.layered(baseTexture, overlayTexture), this.modelOutput);
            fallback = ItemModelUtils.tintedModel(modelId, new ItemTintSource[]{ new Dye(-6265536) });
        } else {
            ModelTemplates.FLAT_ITEM.create(modelId, TextureMapping.layer0(baseTexture), this.modelOutput);
            fallback = ItemModelUtils.plainModel(modelId);
        }
        this.itemModelOutput.accept(item, ItemModelUtils.select(new TrimMaterialProperty(), fallback, cases));
    }

    @Override
    public void run() {
        this.generateFlatItem(ModItems.ELDER_PRISMARINE_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ELDER_PRISMARINE_CRYSTALS.get(), ModelTemplates.FLAT_ITEM);
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
        this.generateTrimmableItem(ModItems.BRONZE_HELMET.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(ModItems.BRONZE_CHESTPLATE.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(ModItems.BRONZE_LEGGINGS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(ModItems.BRONZE_BOOTS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_BOOTS, false);
        this.generateFlatItem(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BRONZE_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        this.generateTrimmableItem(Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.LEATHER_HELMET, EquipmentAssets.LEATHER, TRIM_PREFIX_HELMET, true);
        this.generateTrimmableItem(Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, TRIM_PREFIX_CHESTPLATE, true);
        this.generateTrimmableItem(Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, TRIM_PREFIX_LEGGINGS, true);
        this.generateTrimmableItem(Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, TRIM_PREFIX_BOOTS, true);
        this.generateTrimmableItem(Items.COPPER_HELMET, EquipmentAssets.COPPER, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.COPPER_BOOTS, EquipmentAssets.COPPER, TRIM_PREFIX_BOOTS, false);
        this.generateTrimmableItem(Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_BOOTS, false);
        this.generateTrimmableItem(Items.IRON_HELMET, EquipmentAssets.IRON, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.IRON_CHESTPLATE, EquipmentAssets.IRON, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.IRON_LEGGINGS, EquipmentAssets.IRON, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.IRON_BOOTS, EquipmentAssets.IRON, TRIM_PREFIX_BOOTS, false);
        this.generateTrimmableItem(Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, TRIM_PREFIX_BOOTS, false);
        this.generateTrimmableItem(Items.GOLDEN_HELMET, EquipmentAssets.GOLD, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, TRIM_PREFIX_BOOTS, false);
        this.generateTrimmableItem(Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, TRIM_PREFIX_BOOTS, false);
        this.generateFlatItem(ModItems.EXPLOSIVE_ARROW.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SHARPENED_ARROW.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.STREAMLINED_ARROW.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.GABBRO_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.RHYOLITE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PUMICE_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.HEART_BANNER_PATTERN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.DIAMOND_BANNER_PATTERN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SPADE_BANNER_PATTERN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CLUB_BANNER_PATTERN.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CINNABAR_BATON.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CARBON_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RAW_BISMUTH.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BISMUTH_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BISMUTH_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SILICON_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MONOCRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUBY.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SAPPHIRE.get(), ModelTemplates.FLAT_ITEM);
    }
}
