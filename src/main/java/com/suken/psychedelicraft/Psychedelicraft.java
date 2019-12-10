package com.suken.psychedelicraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.suken.psychedelicraft.blocks.ExampleBlock;
import com.suken.psychedelicraft.blocks.ModBlocks;
import com.suken.psychedelicraft.setup.ClientProxy;
import com.suken.psychedelicraft.setup.IProxy;
import com.suken.psychedelicraft.setup.ModSetup;
import com.suken.psychedelicraft.setup.ServerProxy;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("psychedelicraft")
public class Psychedelicraft {
	
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	
	public static ModSetup setup = new ModSetup();
	
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	public Psychedelicraft() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent event) {
		setup.init();
		proxy.init();
	}

	// You can use EventBusSubscriber to automatically subscribe events on the
	// contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		// Hide public constructor.
		private RegistryEvents() {
			super();
		}
		
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			blockRegistryEvent.getRegistry().register(new ExampleBlock());
		}
		
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
			Properties properties = new Item.Properties().group(setup.itemGroup);
			itemRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.EXAMPLEBLOCK, properties).setRegistryName("exampleblock"));
		}
	}
}
