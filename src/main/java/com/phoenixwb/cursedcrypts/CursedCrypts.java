package com.phoenixwb.cursedcrypts;

import com.phoenixwb.cursedcrypts.capability.CursedClawState;
import com.phoenixwb.cursedcrypts.init.BlockEntityInit;
import com.phoenixwb.cursedcrypts.init.BlockInit;
import com.phoenixwb.cursedcrypts.init.ItemInit;
import com.phoenixwb.cursedcrypts.init.MobEffectInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod(CursedCrypts.MODID)
public class CursedCrypts {
	public static final String MODID = "cursedcrypts";

	@SuppressWarnings("deprecation")
	public CursedCrypts() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		GeckoLibMod.DISABLE_IN_DEV = true;

		GeckoLib.initialize();

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		MobEffectInit.MOB_EFFECTS.register(bus);

		bus.addListener(this::onRegisterCapabilities);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void onRegisterCapabilities(final RegisterCapabilitiesEvent event) {
		event.register(CursedClawState.class);
	}

	public static final CreativeModeTab CURSED_CRYPTS = new CreativeModeTab("cursed_crypts") {
		@Override
		public ItemStack makeIcon() {
			return ItemInit.CURSED_WAND.get().getDefaultInstance();
		}
	};
}
