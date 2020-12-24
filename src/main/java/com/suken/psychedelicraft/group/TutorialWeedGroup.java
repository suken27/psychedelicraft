package com.suken.psychedelicraft.group;

import com.suken.psychedelicraft.setup.ItemRegistry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TutorialWeedGroup extends ItemGroup {

	public TutorialWeedGroup() {
		super("tutorial_weed_group");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemRegistry.tutorialWeed.get());
	}
	
}
