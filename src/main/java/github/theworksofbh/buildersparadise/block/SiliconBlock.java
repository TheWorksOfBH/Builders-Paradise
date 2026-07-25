package github.theworksofbh.buildersparadise.block;

import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SiliconBlock extends ColoredFallingBlock {

    public SiliconBlock(ColorRGBA dustColor, Properties properties) {
        super(dustColor, properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState above = level.getBlockState(pos.above());

        if (above.is(ModBlockTags.HIGH_PRESSURE_COMPRESSORS)) {
            level.destroyBlock(pos, false);
            double roll = random.nextDouble();

            if (roll < 0.1) {
                popResource(level, pos, new ItemStack(ModItems.MONOCRYSTAL.get()));
            }
            else if (roll < 0.75) {
                popResource(level, pos, new ItemStack(ModItems.SILICENE.get(), 2));
            }
            else {
                popResource(level, pos, new ItemStack(ModItems.SILICON_DUST.get(), 4));
            }
        } else if (above.is(ModBlockTags.LOW_PRESSURE_COMPRESSORS)) {
            level.destroyBlock(pos, false);
            double roll = random.nextDouble();

            if (roll < 0.001) {
                popResource(level, pos, new ItemStack(ModItems.MONOCRYSTAL.get()));
            }
            else if (roll < 0.1) {
                popResource(level, pos, new ItemStack(ModItems.SILICENE.get(), 2));
            }
            else {
                popResource(level, pos, new ItemStack(ModItems.SILICON_DUST.get(), 4));
            }
        }
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityContext && entityContext.getEntity() instanceof ItemEntity) {
            return Shapes.empty();
        }

        return super.getCollisionShape(state, level, pos, context);
    }
}
