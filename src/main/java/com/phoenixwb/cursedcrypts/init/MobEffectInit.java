package com.phoenixwb.cursedcrypts.init;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.effect.BoneGraspEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobEffectInit {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
			CursedCrypts.MODID);

	public static final RegistryObject<MobEffect> BONE_GRASP = MOB_EFFECTS.register("bone_grasp",
			() -> new BoneGraspEffect(MobEffectCategory.HARMFUL, 16250866));

}
