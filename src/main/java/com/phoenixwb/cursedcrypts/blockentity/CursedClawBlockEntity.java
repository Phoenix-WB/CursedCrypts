package com.phoenixwb.cursedcrypts.blockentity;

import java.util.List;

import com.phoenixwb.cursedcrypts.capability.CursedClawState;
import com.phoenixwb.cursedcrypts.capability.CursedClawStateProvider;
import com.phoenixwb.cursedcrypts.init.BlockEntityInit;
import com.phoenixwb.cursedcrypts.init.MobEffectInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CursedClawBlockEntity extends BlockEntity implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);

	public CursedClawBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(BlockEntityInit.CURSED_CLAW_BLOCK_ENTITY.get(), pPos, pBlockState);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(
				new AnimationController<CursedClawBlockEntity>(this, "controller", 0, this::predicate));
	}

	@SuppressWarnings("deprecation")
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		CursedClawBlockEntity clawEntity = (CursedClawBlockEntity) event.getAnimatable();
		CursedClawState clawState = clawEntity.getCapability(CursedClawStateProvider.CURSED_CLAW_STATE).orElse(null);
		List<Entity> clawEntities = clawEntity.getLevel().getEntities(null, new AABB(clawEntity.getBlockPos()));
		if (clawEntity != null && clawState != null && !clawEntities.isEmpty()) {
			if (clawEntities.size() == 1 && clawEntities.get(0) instanceof LivingEntity
					&& clawEntities.get(0).getStringUUID().equals(clawState.getUUID())) {
				event.getController()
						.setAnimation(new AnimationBuilder().addAnimation("animation.cursed_claw.release", false)
								.addAnimation("animation.cursed_claw.ground", true));
			} else if (clawEntities.get(0) instanceof Player && ((Player) clawEntities.get(0)).isCreative()) {
				event.getController()
						.setAnimation(new AnimationBuilder().addAnimation("animation.cursed_claw.release", false)
								.addAnimation("animation.cursed_claw.ground", true));
			} else {
				event.getController()
						.setAnimation(new AnimationBuilder().addAnimation("animation.cursed_claw.grab", false)
								.addAnimation("animation.cursed_claw.idle", true));
			}
		} else {
			event.getController()
					.setAnimation(new AnimationBuilder().addAnimation("animation.cursed_claw.release", false)
							.addAnimation("animation.cursed_claw.ground", true));
		}
		return PlayState.CONTINUE;
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public static <E extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, E entity) {
		if (!level.isClientSide()) {
			if (!state.canSurvive(level, pos)) {
				level.destroyBlock(pos, false);
			}
			CursedClawBlockEntity claw = (CursedClawBlockEntity) entity;
			claw.getCapability(CursedClawStateProvider.CURSED_CLAW_STATE).ifPresent(cap -> {
				List<Entity> entities = level.getEntities(null, new AABB(pos));
				entities.forEach(entityIn -> {
					if (entityIn instanceof LivingEntity) {
						if (!(cap.getUUID().equals(entityIn.getStringUUID()))) {
							if (entityIn instanceof Player) {
								if (!((Player) entityIn).isCreative()) {
									((LivingEntity) entityIn)
											.addEffect(new MobEffectInstance(MobEffectInit.BONE_GRASP.get(), 10));
								}
							} else
								((LivingEntity) entityIn)
										.addEffect(new MobEffectInstance(MobEffectInit.BONE_GRASP.get(), 10));
						}
					}
				});
			});
		}
	}
}
