package com.suken.psychedelicraft.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ExampleBlockTile extends TileEntity implements ITickableTileEntity {
	
	private ItemStackHandler handler;
	
	public ExampleBlockTile() {
		super(ModBlocks.EXAMPLEBLOCK_TILE);
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			System.out.println("ExampleBlockTile.tick");
		}
	}
	
	@Override
	public void read(CompoundNBT compound) {
		CompoundNBT invTag = compound.getCompound("inv");
		getHandler().deserializeNBT(invTag);
		super.read(compound);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		CompoundNBT aux = getHandler().serializeNBT();
		compound.put("inv", aux);
		return super.write(compound);
	}
	
	private ItemStackHandler getHandler() {
		if(handler == null) {
			handler = new ItemStackHandler(1);
		}
		return handler;
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return LazyOptional.of(() -> (T) getHandler());
		}
		return super.getCapability(cap, side);
	}

}
