package github.theworksofbh.buildersparadise.renderers;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.function.IntFunction;

public class ModChestRenderStates extends ChestRenderState {
    public ModChestRenderStates() {
        this.type = ChestType.SINGLE;
        this.material = ChestRenderState.ChestMaterialType.REGULAR;
    }

    public static enum ChestMaterialType implements StringRepresentable {
        OAK(0, "oak"),
        SPRUCE(1, "spruce"),
        BIRCH(2, "birch"),
        JUNGLE(3, "jungle"),
        ACACIA(4, "acacia"),
        DARK_OAK(5, "dark_oak"),
        CRIMSON(6, "crimson"),
        WARPED(7, "warped"),
        MANGROVE(8, "mangrove"),
        CHERRY(9, "cherry"),
        BAMBOO(10, "bamboo"),
        PALE_OAK(11, "pale_oak");

        public static final ChestMaterialType DEFAULT = OAK;
        private final int id;
        private final String name;
        private static final IntFunction<ModChestRenderStates.ChestMaterialType> BY_ID = ByIdMap.continuous(ModChestRenderStates.ChestMaterialType::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        public static final StreamCodec<ByteBuf, ModChestRenderStates.ChestMaterialType> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, ModChestRenderStates.ChestMaterialType::getId);
        public static final Codec<ModChestRenderStates.ChestMaterialType> CODEC = StringRepresentable.fromEnum(ModChestRenderStates.ChestMaterialType::values);

        private ChestMaterialType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }

        public static ModChestRenderStates.ChestMaterialType byId(int id) {
            return (ModChestRenderStates.ChestMaterialType)BY_ID.apply(id);
        }
    }
}
