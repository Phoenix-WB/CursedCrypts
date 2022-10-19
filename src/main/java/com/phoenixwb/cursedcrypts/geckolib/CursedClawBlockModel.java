package com.phoenixwb.cursedcrypts.geckolib;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.blockentity.CursedClawBlockEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CursedClawBlockModel extends AnimatedGeoModel<CursedClawBlockEntity> {
	@Override
	public ResourceLocation getModelResource(CursedClawBlockEntity animatable) {
		return new ResourceLocation(CursedCrypts.MODID, "geo/block/cursed_claw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CursedClawBlockEntity object) {
		return new ResourceLocation(CursedCrypts.MODID, "textures/block/cursed_claw.png");
	}

	@Override
	public ResourceLocation getAnimationResource(CursedClawBlockEntity object) {
		return new ResourceLocation(CursedCrypts.MODID, "animations/block/cursed_claw.animation.json");
	}
}
