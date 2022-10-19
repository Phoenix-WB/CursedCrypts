package com.phoenixwb.cursedcrypts.item;

import com.phoenixwb.cursedcrypts.capability.CursedClawStateProvider;
import com.phoenixwb.cursedcrypts.init.BlockInit;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class CursedWandItem extends BlockItem implements Vanishable {
	public CursedWandItem(Properties pProperties) {
		super(BlockInit.CURSED_CLAW.get(), pProperties);
	}

	@Override
	public InteractionResult place(BlockPlaceContext pContext) {
		if (!pContext.canPlace()) {
			return InteractionResult.FAIL;
		} else {
			BlockPlaceContext blockplacecontext = this.updatePlacementContext(pContext);
			if (blockplacecontext == null) {
				return InteractionResult.FAIL;
			} else {
				BlockState blockstate = this.getPlacementState(blockplacecontext);
				if (blockstate == null) {
					return InteractionResult.FAIL;
				} else if (!this.placeBlock(blockplacecontext, blockstate)) {
					return InteractionResult.FAIL;
				} else {
					BlockPos blockpos = blockplacecontext.getClickedPos();
					Level level = blockplacecontext.getLevel();
					Player player = blockplacecontext.getPlayer();
					ItemStack itemstack = blockplacecontext.getItemInHand();
					BlockState blockstate1 = level.getBlockState(blockpos);
					if (blockstate1.is(blockstate.getBlock())) {
						blockstate1 = this.updateBlockStateFromTag(blockpos, level, itemstack, blockstate1);
						this.updateCustomBlockEntityTag(blockpos, level, player, itemstack, blockstate1);
						blockstate1.getBlock().setPlacedBy(level, blockpos, blockstate1, player, itemstack);
						if (player instanceof ServerPlayer) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
						}
					}

					if (blockstate1.hasBlockEntity()) {
						level.getBlockEntity(blockpos).getCapability(CursedClawStateProvider.CURSED_CLAW_STATE)
								.ifPresent(cap -> {
									cap.setUUID(player.getUUID());
								});
					}

					level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, blockstate1));
					SoundType soundtype = blockstate1.getSoundType(level, blockpos, pContext.getPlayer());
					level.playSound(player, blockpos,
							this.getPlaceSound(blockstate1, level, blockpos, pContext.getPlayer()), SoundSource.BLOCKS,
							(soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					if (player == null || !player.getAbilities().instabuild) {
						pContext.getItemInHand().hurtAndBreak(1, player, (p_150686_) -> {
							p_150686_.broadcastBreakEvent(pContext.getHand());
						});
					}

					return InteractionResult.sidedSuccess(level.isClientSide);
				}
			}
		}
	}

	public boolean isValidRepairItem(ItemStack stack1, ItemStack stack2) {
		return stack2.is(Blocks.BONE_BLOCK.asItem());
	}

	@Override
	public String getDescriptionId() {
		return this.getOrCreateDescriptionId();
	}
}
