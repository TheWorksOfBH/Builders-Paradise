package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.items.ModArmorMaterials;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Optional;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider {
    public ModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(
                ModArmorMaterials.BRONZE_ASSETS,
                EquipmentClientInfo.builder().addLayers(
                        EquipmentClientInfo.LayerType.HUMANOID,
                        new EquipmentClientInfo.Layer(
                                Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bronze"),
                                Optional.empty(),
                                false
                        )
                ).addLayers(
                        EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS,
                        new EquipmentClientInfo.Layer(
                                Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bronze"),
                                Optional.empty(),
                                false
                        )
                ).addLayers(
                        EquipmentClientInfo.LayerType.HORSE_BODY,
                        new EquipmentClientInfo.Layer(
                                Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bronze"),
                                Optional.empty(),
                                false
                        )
                ).addLayers(
                        EquipmentClientInfo.LayerType.NAUTILUS_BODY,
                        new EquipmentClientInfo.Layer(
                                Identifier.fromNamespaceAndPath(BuildersParadise.MODID, "bronze"),
                                Optional.empty(),
                                false
                        )
                ).build()
        );
    }
}
