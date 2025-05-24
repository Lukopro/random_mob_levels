package net.luko.random_mob_levels.mixin;

import daripher.autoleveling.event.MobsLevelingEvents;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import static net.luko.random_mob_levels.util.LevelUtil.getRandomLevel;

@Mixin({MobsLevelingEvents.class})
public class MobsLevelingEventsMixin {

    @Inject(
            method = "createLevelForEntity(Lnet/minecraft/world/entity/LivingEntity;D)I",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void injectCreateLevelForEntity(LivingEntity entity, double distance, CallbackInfoReturnable<Integer> cir){
        if(entity.getServer() == null) {
            cir.setReturnValue(0);
            cir.cancel();
            return;
        }
        cir.setReturnValue(getRandomLevel());
        cir.cancel();
    }
}
