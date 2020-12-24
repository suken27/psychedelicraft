package com.suken.psychedelicraft.item;

import com.suken.psychedelicraft.group.ModGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class TutorialBrownie extends Item {

	private static final Food food = (new Food.Builder()).saturation(10).hunger(20)
			.effect(() -> new EffectInstance(Effects.POISON, 3 * 20, 1), 1).build();
	
	public TutorialBrownie() {
		super(new Properties().food(food).group(ModGroup.itemGroup));
	}

}
