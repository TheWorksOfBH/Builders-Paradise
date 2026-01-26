package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

public class RisingBlockEntity extends FallingBlockEntity {
    private BlockState state;
    private static final BlockState DEFAULT_BLOCK_STATE = ModBlocks.PUMICE.get().defaultBlockState();
    private static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE = SynchedEntityData.defineId(RisingBlockEntity.class, EntityDataSerializers.BLOCK_STATE);

    public RisingBlockEntity(EntityType<? extends FallingBlockEntity> type, Level level) {
        super(type, level);
        this.state = DEFAULT_BLOCK_STATE;
    }

    public RisingBlockEntity(Level level, double x, double y, double z, BlockState state) {
        super(ModEntities.RISING_BLOCK.get(), level);
        this.state = state;
        this.entityData.set(DATA_BLOCK_STATE, state);
        this.setPos(x, y, z);
        this.blocksBuilding = true;
        this.setDeltaMovement(Vec3.ZERO);
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide()) return;

        BlockPos pos = this.blockPosition();
        boolean waterAbove = level().getFluidState(pos.above()).is(Fluids.WATER) || level().getFluidState(pos.above()).is(Fluids.FLOWING_WATER);

        Vec3 motion = this.getDeltaMovement();

        if (waterAbove) {
            double acceleration = 0.03;
            double maxSpeed = 0.12;

            double newY = Math.min(motion.y + acceleration, maxSpeed);
            this.setDeltaMovement(0.0, newY, 0.0);
            this.move(MoverType.SELF, this.getDeltaMovement());

        } else {
            placeAtSurface();
        }
    }


    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.store("BlockState", BlockState.CODEC, this.state);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.state = (BlockState)input.read("BlockState", BlockState.CODEC).orElse(DEFAULT_BLOCK_STATE);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_BLOCK_STATE, DEFAULT_BLOCK_STATE);
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    private void placeAtSurface() {
        BlockPos placePos = BlockPos.containing(
                this.getX(),
                this.getBoundingBox().minY,
                this.getZ()
        );

        if (!this.level().getBlockState(placePos).canBeReplaced()) {
            return;
        }

        this.level().setBlock(placePos, this.state, 3);
        this.discard();
    }

    @Override
    public BlockState getBlockState() {
        return this.entityData.get(DATA_BLOCK_STATE);
    }

}