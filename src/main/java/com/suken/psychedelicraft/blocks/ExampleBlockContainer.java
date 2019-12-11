package com.suken.psychedelicraft.blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class ExampleBlockContainer extends Container {
	
	private TileEntity tileEntity;

	public ExampleBlockContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory) {
		super(ModBlocks.EXAMPLEBLOCK_CONTAINER, id);
		tileEntity = world.getTileEntity(pos);
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerIn, ModBlocks.EXAMPLEBLOCK);
	}

}
