package github.theworksofbh.buildersparadise.config;

import github.theworksofbh.buildersparadise.entity.FireproofBoat;
import github.theworksofbh.buildersparadise.entity.FireproofChestBoat;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.RenderBlockScreenEffectEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class FireproofBoatConfig {
    public static void onEntityDamage(LivingIncomingDamageEvent event) {
        if (event.getSource().is(DamageTypes.LAVA)) {
            Entity entity = event.getEntity();
            if (entity.getVehicle() instanceof FireproofBoat || entity.getVehicle() instanceof FireproofChestBoat) {
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.clearFire();
                    livingEntity.setSharedFlagOnFire(false);
                } else if (entity instanceof Player player) {
                    player.clearFire();
                    player.setSharedFlagOnFire(false);
                }
                event.setCanceled(true);
            }
        }
    }

    public static void onRenderOverlay(RenderBlockScreenEffectEvent event) {
        if (event.getOverlayType() == RenderBlockScreenEffectEvent.OverlayType.FIRE) {
            Player player = Minecraft.getInstance().player;
            if (player != null && player.getVehicle() instanceof FireproofBoat || player.getVehicle() instanceof FireproofChestBoat) {
                event.setCanceled(true);
            }
        }
    }
}
