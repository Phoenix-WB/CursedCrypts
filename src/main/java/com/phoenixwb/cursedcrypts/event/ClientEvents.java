package com.phoenixwb.cursedcrypts.event;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.geckolib.CursedClawBlockRenderer;
import com.phoenixwb.cursedcrypts.geckolib.WandClawBlockRenderer;
import com.phoenixwb.cursedcrypts.init.BlockEntityInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CursedCrypts.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BlockEntityInit.CURSED_CLAW_BLOCK_ENTITY.get(), CursedClawBlockRenderer::new);
		event.registerBlockEntityRenderer(BlockEntityInit.WAND_CLAW_BLOCK_ENTITY.get(), WandClawBlockRenderer::new);
	}
}
