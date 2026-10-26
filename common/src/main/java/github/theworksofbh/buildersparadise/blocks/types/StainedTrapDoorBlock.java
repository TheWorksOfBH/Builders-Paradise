package github.theworksofbh.buildersparadise.blocks.types;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class StainedTrapDoorBlock extends TransparentTrapDoorBlock implements BeaconBeamBlock {
    private final DyeColor color;

    public StainedTrapDoorBlock(BlockSetType type, DyeColor dyeColor, Properties properties) {
        super(type, properties);
        this.color = dyeColor;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public static final MapCodec<StainedTrapDoorBlock> CODEC = RecordCodecBuilder.mapCodec((p_432661_) -> p_432661_.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(StainedTrapDoorBlock::getType), DyeColor.CODEC.fieldOf("color").forGetter(StainedTrapDoorBlock::getColor), propertiesCodec()).apply(p_432661_, StainedTrapDoorBlock::new));

    public MapCodec<StainedTrapDoorBlock> codec() {
        return CODEC;
    }


    @Override
    public BlockSetType getType() {
        return super.getType();
    }
}