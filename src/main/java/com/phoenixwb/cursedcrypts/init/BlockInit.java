package com.phoenixwb.cursedcrypts.init;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.block.CursedClaw;
import com.phoenixwb.cursedcrypts.block.WandClaw;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CursedCrypts.MODID);

	public static final RegistryObject<Block> CURSED_CLAW = BLOCKS.register("cursed_claw",
			() -> new CursedClaw(Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
	
	public static final RegistryObject<Block> WAND_CLAW = BLOCKS.register("wand_claw",
			() -> new WandClaw(Properties.copy(Blocks.BONE_BLOCK).noOcclusion()));
}
