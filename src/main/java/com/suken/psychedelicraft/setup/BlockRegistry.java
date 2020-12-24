package com.suken.psychedelicraft.setup;

import com.suken.psychedelicraft.Utils;
import com.suken.psychedelicraft.block.TutorialWeedBlock;

import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
	
	public static final RegistryObject<Block> tutorialWeedBlock = BLOCKS.register("tutorial_weed_block", TutorialWeedBlock::new);
	
	/**
	 * Hidden constructor
	 */
	private BlockRegistry() {
		super();
	}
	
	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
	
}
