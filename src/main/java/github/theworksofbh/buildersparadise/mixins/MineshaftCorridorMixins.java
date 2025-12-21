package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import github.theworksofbh.buildersparadise.entity.MinecartCustomChest;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces.MineShaftCorridor;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftStructure;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MineShaftCorridor.class)
public abstract class MineshaftCorridorMixins extends MineShaftPieceMixins {
    @WrapOperation(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/structure/structures/MineshaftPieces$MineShaftCorridor;createChest(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/util/RandomSource;IIILnet/minecraft/resources/ResourceKey;)Z"))
    private boolean redirectChestCreation(MineShaftCorridor instance, WorldGenLevel level, BoundingBox box, RandomSource random, int x, int y, int z, ResourceKey<LootTable> lootTable, Operation<Boolean> original) {
        if (this.type == MineshaftStructure.Type.MESA) {
            return this.createDarkOakChest(level, box, random, x, y, z, lootTable);
        } else {
            return original.call(instance, level, box, random, x, y, z, lootTable);
        }
    }

    @Unique
    private boolean createDarkOakChest(WorldGenLevel level, BoundingBox box, RandomSource random, int x, int y, int z, ResourceKey<LootTable> lootTable) {
        BlockPos blockpos = this.getWorldPos(x, y, z);
        if (box.isInside(blockpos) && level.getBlockState(blockpos).isAir() && !level.getBlockState(blockpos.below()).isAir()) {
            BlockState blockstate = (BlockState)Blocks.RAIL.defaultBlockState().setValue(RailBlock.SHAPE, random.nextBoolean() ? RailShape.NORTH_SOUTH : RailShape.EAST_WEST);
            this.placeBlock(level, blockstate, x, y, z, box);
            MinecartCustomChest minecartchest = (MinecartCustomChest) ModEntities.DARK_OAK_CHEST_MINECART.get().create(level.getLevel(), EntitySpawnReason.CHUNK_GENERATION);
            if (minecartchest != null) {
                minecartchest.setInitialPos((double)blockpos.getX() + (double)0.5F, (double)blockpos.getY() + (double)0.5F, (double)blockpos.getZ() + (double)0.5F);
                minecartchest.setLootTable(lootTable, random.nextLong());
                level.addFreshEntity(minecartchest);
            }

            return true;
        } else {
            return false;
        }
    }
}
