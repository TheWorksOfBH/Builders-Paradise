package github.theworksofbh.buildersparadise.mixins;

import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MineshaftPieces.MineShaftPiece.class)
public abstract class MineShaftPieceMixins extends StructurePieceMixins {
    @Shadow
    public MineshaftStructure.Type type;
}
