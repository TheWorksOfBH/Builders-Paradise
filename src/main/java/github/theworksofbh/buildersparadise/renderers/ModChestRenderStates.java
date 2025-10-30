package github.theworksofbh.buildersparadise.renderers;

import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.world.level.block.state.properties.ChestType;

public class ModChestRenderStates extends ChestRenderState {
    public ModChestRenderStates() {
        this.type = ChestType.SINGLE;
        this.material = ChestRenderState.ChestMaterialType.REGULAR;
    }

    public static enum ChestMaterialType {
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK,
        CRIMSON,
        WARPED,
        MANGROVE,
        CHERRY,
        BAMBOO,
        PALE_OAK
    }
}
