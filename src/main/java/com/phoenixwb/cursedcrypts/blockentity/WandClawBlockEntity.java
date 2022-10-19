package com.phoenixwb.cursedcrypts.blockentity;

import com.phoenixwb.cursedcrypts.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WandClawBlockEntity extends BlockEntity implements IAnimatable {
	private AnimationFactory factory = new AnimationFactory(this);

	public WandClawBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(BlockEntityInit.WAND_CLAW_BLOCK_ENTITY.get(), pPos, pBlockState);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(
				new AnimationController<WandClawBlockEntity>(this, "controller", 0, this::predicate));
	}

	@SuppressWarnings("deprecation")
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wand_claw.hold", true));
		return PlayState.CONTINUE;
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public static <E extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, E entity) {
		if (!level.isClientSide()) {
			if (!state.canSurvive(level, pos)) {
				level.destroyBlock(pos, true);
			}
		}
	}
}
