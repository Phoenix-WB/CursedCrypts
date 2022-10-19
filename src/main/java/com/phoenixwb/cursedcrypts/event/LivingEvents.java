package com.phoenixwb.cursedcrypts.event;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.init.MobEffectInit;

import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CursedCrypts.MODID)
public class LivingEvents {
	@SubscribeEvent
	public static void onLivingJumpWithBoneGraspEffect(LivingJumpEvent event) {
		if (event.getEntity().hasEffect(MobEffectInit.BONE_GRASP.get())) {
			event.getEntity().setDeltaMovement(new Vec3(0, 0, 0));
		}
	}
}
