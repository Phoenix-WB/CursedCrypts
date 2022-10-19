package com.phoenixwb.cursedcrypts.init;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.item.CursedWandItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			CursedCrypts.MODID);

	public static final RegistryObject<Item> CURSED_WAND = ITEMS.register("cursed_wand",
			() -> new CursedWandItem(new Item.Properties().defaultDurability(30).tab(CursedCrypts.CURSED_CRYPTS)));
}
