package com.phoenixwb.cursedcrypts.init;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.blockentity.CursedClawBlockEntity;
import com.phoenixwb.cursedcrypts.blockentity.WandClawBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CursedCrypts.MODID);

	public static final RegistryObject<BlockEntityType<?>> CURSED_CLAW_BLOCK_ENTITY = BLOCK_ENTITIES.register(
			"cursed_claw_block_entity",
			() -> BlockEntityType.Builder.of(CursedClawBlockEntity::new, BlockInit.CURSED_CLAW.get()).build(null));

	public static final RegistryObject<BlockEntityType<?>> WAND_CLAW_BLOCK_ENTITY = BLOCK_ENTITIES.register(
			"wand_claw_block_entity",
			() -> BlockEntityType.Builder.of(WandClawBlockEntity::new, BlockInit.WAND_CLAW.get()).build(null));
}
