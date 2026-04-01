package github.theworksofbh.buildersparadise.compat.bop;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;

import java.util.Map;

public record CompatModMaterialAssetGroups(MaterialAssetGroup.AssetInfo base, Map<ResourceKey<EquipmentAsset>, MaterialAssetGroup.AssetInfo> overrides) {
    public static final String SEPARATOR = "_";
    public static final MapCodec<MaterialAssetGroup> MAP_CODEC = RecordCodecBuilder.mapCodec((p_400278_) -> p_400278_.group(MaterialAssetGroup.AssetInfo.CODEC.fieldOf("asset_name").forGetter(MaterialAssetGroup::base), Codec.unboundedMap(ResourceKey.codec(EquipmentAssets.ROOT_ID), MaterialAssetGroup.AssetInfo.CODEC).optionalFieldOf("override_armor_assets", Map.of()).forGetter(MaterialAssetGroup::overrides)).apply(p_400278_, MaterialAssetGroup::new));
    public static final StreamCodec<ByteBuf, MaterialAssetGroup> STREAM_CODEC;
    public static final MaterialAssetGroup GLOWWORM_SILK = create("glowworm_silk");
    public static final MaterialAssetGroup ROSE_QUARTZ = create("rose_quartz");

    public static MaterialAssetGroup create(String name) {
        return new MaterialAssetGroup(new MaterialAssetGroup.AssetInfo(name), Map.of());
    }

    public static MaterialAssetGroup create(String name, Map<ResourceKey<EquipmentAsset>, String> overrides) {
        return new MaterialAssetGroup(new MaterialAssetGroup.AssetInfo(name), Map.copyOf(Maps.transformValues(overrides, MaterialAssetGroup.AssetInfo::new)));
    }

    public MaterialAssetGroup.AssetInfo assetId(ResourceKey<EquipmentAsset> assetKey) {
        return (MaterialAssetGroup.AssetInfo)this.overrides.getOrDefault(assetKey, this.base);
    }

    static {
        STREAM_CODEC = StreamCodec.composite(MaterialAssetGroup.AssetInfo.STREAM_CODEC, MaterialAssetGroup::base, ByteBufCodecs.map(Object2ObjectOpenHashMap::new, ResourceKey.streamCodec(EquipmentAssets.ROOT_ID), MaterialAssetGroup.AssetInfo.STREAM_CODEC), MaterialAssetGroup::overrides, MaterialAssetGroup::new);
    }

    public static record AssetInfo(String suffix) {
        public static final Codec<MaterialAssetGroup.AssetInfo> CODEC;
        public static final StreamCodec<ByteBuf, MaterialAssetGroup.AssetInfo> STREAM_CODEC;

        public AssetInfo {
            if (!Identifier.isValidPath(suffix)) {
                throw new IllegalArgumentException("Invalid string to use as a resource path element: " + suffix);
            }
        }

        static {
            CODEC = ExtraCodecs.RESOURCE_PATH_CODEC.xmap(MaterialAssetGroup.AssetInfo::new, MaterialAssetGroup.AssetInfo::suffix);
            STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(MaterialAssetGroup.AssetInfo::new, MaterialAssetGroup.AssetInfo::suffix);
        }
    }
}
