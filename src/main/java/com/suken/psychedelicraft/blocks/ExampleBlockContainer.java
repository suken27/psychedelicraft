package com.suken.psychedelicraft.blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.NonNullConsumer;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ExampleBlockContainer extends Container {

	private TileEntity tileEntity;
	private IItemHandler playerInventoryHandler;

	public ExampleBlockContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory) {
		super(ModBlocks.EXAMPLEBLOCK_CONTAINER, id);
		tileEntity = world.getTileEntity(pos);
		playerInventoryHandler = new InvWrapper(playerInventory);
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				.ifPresent(h -> addSlot(new SlotItemHandler(h, 0, 64, 24)));
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new SlotItemHandler(playerInventoryHandler, j + i * 9 + 10, 10 + j * 18, 70 + i * 18));
			}
		}
		for (int k = 1; k < 10; ++k) {
			this.addSlot(new SlotItemHandler(playerInventoryHandler, k, 10 + k * 18, 128));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerIn,
				ModBlocks.EXAMPLEBLOCK);
	}

}
