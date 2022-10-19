package com.phoenixwb.cursedcrypts.capability;

import java.util.UUID;

import net.minecraft.nbt.CompoundTag;

public class CursedClawState {
	private String ownerUUID;

	public CursedClawState() {
		ownerUUID = "";
	}

	public String getUUID() {
		return ownerUUID;
	}

	public void setUUID(UUID ownerUUID) {
		setUUID(ownerUUID.toString());
	}

	public void setUUID(String ownerUUID) {
		this.ownerUUID = ownerUUID;
	}

	public void saveNBT(CompoundTag nbt) {
		nbt.putString("ownerUUID", ownerUUID);
	}

	public void loadNBT(CompoundTag nbt) {
		ownerUUID = nbt.getString("ownerUUID");
	}
}
