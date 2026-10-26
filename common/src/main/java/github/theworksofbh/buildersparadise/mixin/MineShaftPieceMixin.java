package github.theworksofbh.buildersparadise.mixin;

import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MineshaftPieces.MineShaftPiece.class)
public abstract class MineShaftPieceMixin extends StructurePieceMixin {
    @Shadow
    public MineshaftStructure.Type type;
}