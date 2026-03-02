package github.theworksofbh.buildersparadise.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class StainedTrapdoorBlock extends TransparentTrapdoorBlock implements BeaconBeamBlock {
    private final DyeColor color;

    public StainedTrapdoorBlock(BlockSetType type, DyeColor dyeColor, Properties properties) {
        super(type, properties);
        this.color = dyeColor;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public static final MapCodec<StainedTrapdoorBlock> CODEC = RecordCodecBuilder.mapCodec((p_432661_) -> p_432661_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(StainedTrapdoorBlock::getType), DyeColor.CODEC.fieldOf("color").forGetter(StainedTrapdoorBlock::getColor), propertiesCodec()).apply(p_432661_, StainedTrapdoorBlock::new));

    public MapCodec<StainedTrapdoorBlock> codec() {
        return CODEC;
    }
}
