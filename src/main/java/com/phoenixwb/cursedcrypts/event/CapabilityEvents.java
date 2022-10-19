package com.phoenixwb.cursedcrypts.event;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.blockentity.CursedClawBlockEntity;
import com.phoenixwb.cursedcrypts.capability.CursedClawStateProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CursedCrypts.MODID)
public class CapabilityEvents {
	@SubscribeEvent
	public static void onAttachCapabilitiesBlock(AttachCapabilitiesEvent<BlockEntity> event) {
		if (event.getObject() instanceof CursedClawBlockEntity) {
			if (!event.getObject().getCapability(CursedClawStateProvider.CURSED_CLAW_STATE).isPresent()) {
				event.addCapability(new ResourceLocation(CursedCrypts.MODID, "cursed_claw_state"),
						new CursedClawStateProvider());
			}
		}
	}
}
