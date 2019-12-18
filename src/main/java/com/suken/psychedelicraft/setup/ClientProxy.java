package com.suken.psychedelicraft.setup;

import com.suken.psychedelicraft.blocks.ExampleBlockScreen;
import com.suken.psychedelicraft.blocks.ModBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
	
	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public void init() {
		ScreenManager.registerFactory(ModBlocks.EXAMPLEBLOCK_CONTAINER, ExampleBlockScreen::new);
	}
	
	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

}
