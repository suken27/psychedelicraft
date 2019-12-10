package com.suken.psychedelicraft.items;

import com.suken.psychedelicraft.Psychedelicraft;

import net.minecraft.item.Item;

public class ExampleItem extends Item {

	public ExampleItem() {
		super(new Item.Properties().group(Psychedelicraft.setup.itemGroup).maxStackSize(1));
		setRegistryName("exampleitem");
	}
	
}
