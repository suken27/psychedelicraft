package com.suken.psychedelicraft.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ExampleBlockTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

	public ExampleBlockTile() {
		super(ModBlocks.EXAMPLEBLOCK_TILE);
	}

	@Override
	public void tick() {
	}

	@Override
	public void read(CompoundNBT compound) {
		CompoundNBT invTag = compound.getCompound("inv");
		handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		handler.ifPresent(h -> {
			CompoundNBT aux = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
			compound.put("inv", aux);
		});
		return super.write(compound);
	}

	private IItemHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				return stack.getItem() == Items.DIAMOND;
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
				if (stack.getItem() != Items.DIAMOND) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent(getType().getRegistryName().getPath());
	}
	
	@Nullable
	@Override
	public Container createMenu(int id, PlayerInventory inv, PlayerEntity player) {
		return new ExampleBlockContainer(id, world, pos, inv);
	}

}
