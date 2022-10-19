package com.phoenixwb.cursedcrypts.capability;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CursedClawStateProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<CursedClawState> CURSED_CLAW_STATE = CapabilityManager.get(new CapabilityToken<>() {
	});
	
	private CursedClawState cursedClawOwner = null;
	private final LazyOptional<CursedClawState> optional = LazyOptional.of(this::createCursedClawOwner);
	
	private CursedClawState createCursedClawOwner() {
		if (this.cursedClawOwner == null) {
			this.cursedClawOwner = new CursedClawState();
		}
		return this.cursedClawOwner;
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == CURSED_CLAW_STATE) {
			return optional.cast();
		}
		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createCursedClawOwner().saveNBT(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createCursedClawOwner().loadNBT(nbt);
	}
}
