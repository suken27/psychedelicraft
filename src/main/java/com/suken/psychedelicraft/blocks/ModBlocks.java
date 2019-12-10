package com.suken.psychedelicraft.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

	@ObjectHolder("psychedelicraft:exampleblock")
	public static ExampleBlock EXAMPLEBLOCK;
	
	@ObjectHolder("psychedelicraft:exampleblock")
	public static TileEntityType<ExampleBlockTile> EXAMPLEBLOCK_TILE;
	
}
