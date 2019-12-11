package com.suken.psychedelicraft.blocks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

	@ObjectHolder("psychedelicraft:exampleblock")
	public static ExampleBlock EXAMPLEBLOCK;
	
	@ObjectHolder("psychedelicraft:exampleblock")
	public static TileEntityType<ExampleBlockTile> EXAMPLEBLOCK_TILE;
	
	@ObjectHolder("psychedelicraft:exampleblock")
	public static ContainerType<ExampleBlockContainer> EXAMPLEBLOCK_CONTAINER;
	
}
