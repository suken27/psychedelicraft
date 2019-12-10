package com.suken.psychedelicraft.setup;

import com.suken.psychedelicraft.blocks.ModBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
	
	public ItemGroup itemGroup = new ItemGroup("psychedelicraft") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.EXAMPLEBLOCK);
		}
	};

	public void init() {
		
	}
	
}
