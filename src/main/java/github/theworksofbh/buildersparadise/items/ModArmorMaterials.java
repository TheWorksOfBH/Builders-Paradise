package github.theworksofbh.buildersparadise.items;

import com.google.common.collect.Maps;
import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public interface ModArmorMaterials {
    public static final ResourceKey<EquipmentAsset> BRONZE_ASSETS = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(BuildersParadise.MODID, "bronze"));

    ArmorMaterial BRONZE = new ArmorMaterial(11, makeDefense(1, 3, 4, 2, 4), 8, SoundEvents.ARMOR_EQUIP_COPPER, 1.0F, 1.0F, ModItemTags.REPAIRS_BRONZE_ARMOR, BRONZE_ASSETS);

    private static Map<ArmorType, Integer> makeDefense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, leggings, ArmorType.CHESTPLATE, chestplate, ArmorType.HELMET, helmet, ArmorType.BODY, body));
    }
}
