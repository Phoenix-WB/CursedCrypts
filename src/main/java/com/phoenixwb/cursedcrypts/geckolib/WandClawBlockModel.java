package com.phoenixwb.cursedcrypts.geckolib;

import com.phoenixwb.cursedcrypts.CursedCrypts;
import com.phoenixwb.cursedcrypts.blockentity.WandClawBlockEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WandClawBlockModel extends AnimatedGeoModel<WandClawBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(WandClawBlockEntity animatable) {
		return new ResourceLocation(CursedCrypts.MODID, "animations/block/wand_claw.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WandClawBlockEntity object) {
		return new ResourceLocation(CursedCrypts.MODID, "geo/block/wand_claw.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WandClawBlockEntity object) {
		return new ResourceLocation(CursedCrypts.MODID, "textures/block/wand_claw.png");
	}

}
