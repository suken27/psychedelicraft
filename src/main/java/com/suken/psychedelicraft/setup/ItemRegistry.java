package com.suken.psychedelicraft.setup;

import com.suken.psychedelicraft.Utils;
import com.suken.psychedelicraft.group.ModGroup;
import com.suken.psychedelicraft.item.TutorialBrownie;
import com.suken.psychedelicraft.item.TutorialWeed;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

	public static final RegistryObject<Item> tutorialWeed = ITEMS.register("tutorial_weed", TutorialWeed::new);
	public static final RegistryObject<Item> tutorialBrownie = ITEMS.register("tutorial_brownie", TutorialBrownie::new);
	public static final RegistryObject<Item> tutorialWeedBlock = ITEMS.register("tutorial_weed_block",
			() -> new BlockItem(BlockRegistry.tutorialWeedBlock.get(),
					new Item.Properties().group(ModGroup.itemGroup)));

	/**
	 * Hidden constructor.
	 */
	private ItemRegistry() {
		super();
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}

}
