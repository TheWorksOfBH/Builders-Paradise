package github.theworksofbh.buildersparadise.structures;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.Nullable;
import java.util.Optional;

public class GenericBlockReplacementProcessor extends StructureProcessor {
    private final Block targetBlock;
    private final Block replacementBlock;
    private final @Nullable BlockEntityType<?> replacementBlockEntity;
    public static final MapCodec<GenericBlockReplacementProcessor> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("target").forGetter(p -> p.targetBlock),
                            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("replacement").forGetter(p -> p.replacementBlock),
                            BuiltInRegistries.BLOCK_ENTITY_TYPE.byNameCodec().optionalFieldOf("replacement_be")
                                    .forGetter(p -> Optional.ofNullable(p.replacementBlockEntity))
                    ).apply(instance, (target, replacement, opt) ->
                            new GenericBlockReplacementProcessor(target, replacement, opt.orElse(null)))
            );

    public GenericBlockReplacementProcessor(Block target, Block replacement, @Nullable BlockEntityType<?> replacementBE) {
        this.targetBlock = target;
        this.replacementBlock = replacement;
        this.replacementBlockEntity = replacementBE;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(LevelReader world, BlockPos pos, BlockPos pivot, StructureTemplate.StructureBlockInfo original, StructureTemplate.StructureBlockInfo current, StructurePlaceSettings settings, @Nullable StructureTemplate template) {
        BlockState state = current.state();

        if (!state.is(targetBlock)) {
            return current;
        }

        BlockState newState = replacementBlock.defaultBlockState();

        for (Property<?> property : state.getProperties()) {
            if (newState.hasProperty(property)) {
                newState = copyProp(state, newState, property);
            }
        }

        CompoundTag originalNbt = current.nbt();
        CompoundTag newNbt = null;

        if (originalNbt != null) {
            newNbt = originalNbt.copy();

            if (replacementBlockEntity != null) {
                ResourceLocation beId = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(replacementBlockEntity);
                if (beId != null) {
                    newNbt.putString("id", beId.toString());
                }
            }
        }

        return new StructureTemplate.StructureBlockInfo(
                current.pos(),
                newState,
                newNbt
        );
    }

    private static <T extends Comparable<T>> BlockState copyProp(BlockState from, BlockState to, Property<T> prop) {
        return to.setValue(prop, from.getValue(prop));
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModStructureProcessors.GENERIC_BLOCK_REPLACER;
    }
}

