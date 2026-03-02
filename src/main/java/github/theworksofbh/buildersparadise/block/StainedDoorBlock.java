package github.theworksofbh.buildersparadise.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class StainedDoorBlock extends TransparentDoorBlock implements BeaconBeamBlock {
    private final DyeColor color;

    public StainedDoorBlock(BlockSetType type, DyeColor dyeColor, Properties properties) {
        super(type, properties);
        this.color = dyeColor;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public static final MapCodec<StainedDoorBlock> CODEC = RecordCodecBuilder.mapCodec((p_432661_) -> p_432661_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(StainedDoorBlock::type), DyeColor.CODEC.fieldOf("color").forGetter(StainedDoorBlock::getColor), propertiesCodec()).apply(p_432661_, StainedDoorBlock::new));

    public MapCodec<StainedDoorBlock> codec() {
        return CODEC;
    }
}
