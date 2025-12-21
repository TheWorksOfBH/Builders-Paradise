package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidPiece;
import net.minecraft.world.level.levelgen.structure.structures.JungleTemplePiece;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixins {

    @Shadow
    public abstract StructurePieceType getType();

    @Shadow
    public abstract BlockPos.MutableBlockPos getWorldPos(int x, int y, int z);

    @Shadow
    public abstract void placeBlock(WorldGenLevel level, BlockState blockstate, int x, int y, int z, BoundingBox boundingbox);

    @Unique
    private boolean createJungleChest(ServerLevelAccessor level, BoundingBox box, RandomSource random, BlockPos pos, ResourceKey<LootTable> lootTable, @Nullable BlockState state) {
        if (box.isInside(pos) && !level.getBlockState(pos).is(ModBlocks.JUNGLE_CHEST.get())) {
            if (state == null) {
                state = StructurePiece.reorient(level, pos, ModBlocks.JUNGLE_CHEST.get().defaultBlockState());
            }

            level.setBlock(pos, state, 2);
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof ChestBlockEntity) {
                ((ChestBlockEntity)blockentity).setLootTable(lootTable, random.nextLong());
            }

            return true;
        } else {
            return false;
        }
    }

    @Unique
    private boolean createCrimsonChest(ServerLevelAccessor level, BoundingBox box, RandomSource random, BlockPos pos, ResourceKey<LootTable> lootTable, @Nullable BlockState state) {
        if (box.isInside(pos) && !level.getBlockState(pos).is(ModBlocks.CRIMSON_CHEST.get())) {
            if (state == null) {
                state = StructurePiece.reorient(level, pos, ModBlocks.CRIMSON_CHEST.get().defaultBlockState());
            }

            level.setBlock(pos, state, 2);
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof ChestBlockEntity) {
                ((ChestBlockEntity)blockentity).setLootTable(lootTable, random.nextLong());
            }

            return true;
        } else {
            return false;
        }
    }

    @WrapMethod(method = "createChest(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/util/RandomSource;IIILnet/minecraft/resources/ResourceKey;)Z")
    private boolean modifyCreateChest(WorldGenLevel level, BoundingBox box, RandomSource random, int x, int y, int z, ResourceKey<LootTable> lootTable, Operation<Boolean> original) {
        if ((Object) this instanceof JungleTemplePiece || (Object) this instanceof DesertPyramidPiece) {
            return createJungleChest(level, box, random, this.getWorldPos(x, y, z), lootTable, null);
        } else if ((Object) this instanceof NetherFortressPieces.NetherBridgePiece) {
            return createCrimsonChest(level, box, random, this.getWorldPos(x, y, z), lootTable, null);
        } else {
            return original.call(level, box, random, x, y, z, lootTable);
        }
    }

}
