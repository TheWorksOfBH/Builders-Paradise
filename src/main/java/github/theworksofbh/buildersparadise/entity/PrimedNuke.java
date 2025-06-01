package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.portal.TeleportTransition;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PrimedNuke extends PrimedTnt {
    private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(PrimedNuke.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE_ID = SynchedEntityData.defineId(PrimedNuke.class, EntityDataSerializers.BLOCK_STATE);
    private float explosionPower;
    private LivingEntity owner;
    private boolean usedPortal;

    private static final ExplosionDamageCalculator USED_PORTAL_DAMAGE_CALCULATOR = new ExplosionDamageCalculator() {
        public boolean shouldBlockExplode(Explosion p_353087_, BlockGetter p_353096_, BlockPos p_353092_, BlockState p_353086_, float p_353094_) {
            return p_353086_.is(Blocks.NETHER_PORTAL) ? false : super.shouldBlockExplode(p_353087_, p_353096_, p_353092_, p_353086_, p_353094_);
        }

        public Optional<Float> getBlockExplosionResistance(Explosion p_353090_, BlockGetter p_353088_, BlockPos p_353091_, BlockState p_353093_, FluidState p_353095_) {
            return p_353093_.is(Blocks.NETHER_PORTAL) ? Optional.empty() : super.getBlockExplosionResistance(p_353090_, p_353088_, p_353091_, p_353093_, p_353095_);
        }
    };;



    public PrimedNuke(EntityType<? extends PrimedTnt> p_32076_, Level p_32077_) {
        super(p_32076_, p_32077_);
        this.explosionPower = 12.0F;
        this.blocksBuilding = true;
    }

    public PrimedNuke(Level level, double x, double y, double z, @Nullable LivingEntity owner) {
        super(level, x, y, z, owner);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FUSE_ID, 80);
        builder.define(DATA_BLOCK_STATE_ID, ModBlocks.NUKE.get().defaultBlockState());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("fuse", (short)this.getFuse());
        compound.put("block_state", NbtUtils.writeBlockState(this.getBlockState()));
        if (this.explosionPower != 12.0F) {
            compound.putFloat("explosion_power", this.explosionPower);
        }

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.setFuse(compound.getShort("fuse"));
        if (compound.contains("block_state", 10)) {
            this.setBlockState(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compound.getCompound("block_state")));
        }

        if (compound.contains("explosion_power", 99)) {
            this.explosionPower = Mth.clamp(compound.getFloat("explosion_power"), 0.0F, 128.0F);
        }

    }

    @Override
    public @Nullable LivingEntity getOwner() {
        return owner;
    }

    @Override
    public BlockState getBlockState() {
        return this.entityData.get(DATA_BLOCK_STATE_ID);
    }

    @Override
    public int getFuse() {
        return this.entityData.get(DATA_FUSE_ID);
    }

    @Override
    public void setBlockState(BlockState blockState) {
        this.entityData.set(DATA_BLOCK_STATE_ID, blockState);
    }

    @Override
    public void setFuse(int life) {
        this.entityData.set(DATA_FUSE_ID, life);
    }

    @Override
    public void restoreFrom(Entity p_306185_) {
        super.restoreFrom(p_306185_);

        if (p_306185_ instanceof PrimedNuke primedNuke) {
            this.owner = primedNuke.owner;
        }
    }

    @Override
    protected void explode() {
        this.level().explode(
                this, Explosion.getDefaultDamageSource(
                        this.level(),
                        this
                ),
                this.usedPortal ? USED_PORTAL_DAMAGE_CALCULATOR : null,
                this.getX(),
                this.getY((double)0.0625F),
                this.getZ(),
                this.explosionPower,
                true,
                Level.ExplosionInteraction.TNT
        );
    }

    public boolean isUsedPortal() {
        return usedPortal;
    }

    public void setExplosionPower(float explosionPower) {
        this.explosionPower = explosionPower;
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public void setUsedPortal(boolean usedPortal) {
        this.usedPortal = usedPortal;
    }

    @Override
    public void tick() {
        this.handlePortal();
        this.applyGravity();
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.applyEffectsFromBlocks();
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if (this.onGround()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.7, (double)-0.5F, 0.7));
        }

        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.level().isClientSide) {
                this.explode();
            }
        } else {
            this.updateInWaterStateAndDoFluidPushing();
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + (double)0.5F, this.getZ(), (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }
    }

    @Override
    public @Nullable Entity teleport(TeleportTransition p_380065_) {
        Entity entity = super.teleport(p_380065_);
        if (entity instanceof PrimedNuke primedNuke) {
            primedNuke.setUsedPortal(true);
        }

        return entity;
    }
}
