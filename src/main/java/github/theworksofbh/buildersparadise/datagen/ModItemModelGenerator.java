package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.items.ModArmorMaterials;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.BiConsumer;

public class ModItemModelGenerator extends ItemModelGenerators {
    public ModItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
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
        this.generateTrimmableItem(ModItems.BRONZE_HELMET.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_HELMET, false);
        this.generateTrimmableItem(ModItems.BRONZE_CHESTPLATE.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_CHESTPLATE, false);
        this.generateTrimmableItem(ModItems.BRONZE_LEGGINGS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_LEGGINGS, false);
        this.generateTrimmableItem(ModItems.BRONZE_BOOTS.get(), ModArmorMaterials.BRONZE_ASSETS, TRIM_PREFIX_BOOTS, false);
        this.generateFlatItem(ModItems.BRONZE_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);


    }
}
