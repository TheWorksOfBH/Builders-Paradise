package github.theworksofbh.buildersparadise.entity;

import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrimedNuke extends PrimedTnt {
    private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(PrimedNuke.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE_ID = SynchedEntityData.defineId(PrimedNuke.class, EntityDataSerializers.BLOCK_STATE);
    private float explosionPower;
    private EntityReference<LivingEntity> owner;
    private boolean usedPortal;
    final List<BlockPos> sources = new ArrayList<>();
    private static final BlockState DEFAULT_BLOCK_STATE = ModBlocks.NUKE.get().defaultBlockState();



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
        this(ModEntities.NUKE.get(), level);
        this.setPos(x, y, z);
        double d0 = level.random.nextDouble() * (double)((float)Math.PI * 2F);
        this.setDeltaMovement(-Math.sin(d0) * 0.02, (double)0.2F, -Math.cos(d0) * 0.02);
        this.setFuse(80);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.owner = owner != null ? new EntityReference(owner) : null;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FUSE_ID, 80);
        builder.define(DATA_BLOCK_STATE_ID, ModBlocks.NUKE.get().withPropertiesOf(this.level().getBlockState(BlockPos.containing(this.getX(), this.getY(), this.getZ()))));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput p_421712_) {
        super.addAdditionalSaveData(p_421712_);
        p_421712_.putShort("fuse", (short)this.getFuse());
        p_421712_.store("block_state", BlockState.CODEC, this.getBlockState());
        if (this.explosionPower != 4.0F) {
            p_421712_.putFloat("explosion_power", this.explosionPower);
        }

        EntityReference.store(this.owner, p_421712_, "owner");
    }

    @Override
    protected void readAdditionalSaveData(ValueInput p_422034_) {
        super.readAdditionalSaveData(p_422034_);
        this.setFuse(p_422034_.getShortOr("fuse", (short)80));
        this.setBlockState((BlockState)p_422034_.read("block_state", BlockState.CODEC).orElse(DEFAULT_BLOCK_STATE));
        this.explosionPower = Mth.clamp(p_422034_.getFloatOr("explosion_power", 4.0F), 0.0F, 128.0F);
        this.owner = EntityReference.read(p_422034_, "owner");

    }

    @Override
    public @Nullable LivingEntity getOwner() {
        return (LivingEntity)EntityReference.get(this.owner, this.level(), LivingEntity.class);
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

        for (int x = -15; x < 16; ++x) {
            for (int y = 4; y < 16; ++y) {
                for (int z = -15; z < 16; ++z) {
                    if (level().getBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() - y, (int) this.getZ() + z)).isAir()) {
                        level().setBlockAndUpdate(new BlockPos((int) this.getX() + x, (int) this.getY() - y, (int) this.getZ() + z), ModBlocks.NUCLEAR_WASTE.get().defaultBlockState());
                    }

                    if (level().getBlockState(new BlockPos((int) this.getX() + x, (int) this.getY() - y, (int) this.getZ() + z)).is(Blocks.FIRE)) {
                        level().setBlockAndUpdate(new BlockPos((int) this.getX() + x, (int) this.getY() - y, (int) this.getZ() + z), ModBlocks.NUCLEAR_WASTE.get().defaultBlockState());
                    }
                }
            }
        }
    }


    public boolean isUsedPortal() {
        return usedPortal;
    }

    public void setExplosionPower(float explosionPower) {
        this.explosionPower = explosionPower;
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
