package com.phoenixwb.cursedcrypts.effect;

import java.util.UUID;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class BoneGraspEffect extends MobEffect {
	public BoneGraspEffect(MobEffectCategory pCategory, int pColor) {
		super(pCategory, pColor);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, UUID.randomUUID().toString(), -1.0D,
				AttributeModifier.Operation.MULTIPLY_TOTAL);
		this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, UUID.randomUUID().toString(), 1.0D,
				AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
	}

	@Override
	public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
		return true;
	}
}
