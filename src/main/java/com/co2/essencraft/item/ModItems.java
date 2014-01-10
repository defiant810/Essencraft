package com.co2.essencraft.item;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems 
{
	public static ItemFoodESC fish;
	public static ItemFoodESC fruit;
	public static ItemFoodESC vegetable;
	public static ItemESC seasoning;
	
	public static void init()
	{
		//Init items
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		vegetable = new ItemVegetable(ItemIds.VEGETABLE);
		seasoning = new ItemSeasoning(ItemIds.SEASONING);
		
		//Register items
		GameRegistry.registerItem(fish, "item.fish");
		GameRegistry.registerItem(fruit, "item.fruit");
		GameRegistry.registerItem(vegetable, "item.vegetable");
		GameRegistry.registerItem(seasoning, "item.seasoning");
		
		//Add names to language registry
		for (int i = 0; i < StringLib.FISH_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(fish.itemID, 1, i), StringLib.FISH_NAMES_HUMAN[i]);
		for (int i = 0; i < StringLib.FRUIT_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(fruit.itemID, 1, i), StringLib.FRUIT_NAMES_HUMAN[i]);
		for (int i = 0; i < StringLib.VEG_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(vegetable.itemID, 1, i), StringLib.VEG_NAMES_HUMAN[i]);
		for (int i = 0; i < StringLib.SEASONING_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(seasoning.itemID, 1, i), StringLib.SEASONING_NAMES_HUMAN[i]);
	}
}