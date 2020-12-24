package com.suken.psychedelicraft.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {
	
	public static void register() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemRegistry.register(eventBus);
		BlockRegistry.register(eventBus);
	}
	
}
