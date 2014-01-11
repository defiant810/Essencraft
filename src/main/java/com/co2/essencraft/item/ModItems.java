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
	public static ItemSeedESC seed;
	
	public static void init()
	{
		//Init items
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		vegetable = new ItemVegetable(ItemIds.VEGETABLE);
		seasoning = new ItemSeasoning(ItemIds.SEASONING);
		seed = new ItemSeedESC(ItemIds.SEED);
		
		//Register items
		GameRegistry.registerItem(fish, "item.fish");
		GameRegistry.registerItem(fruit, "item.fruit");
		GameRegistry.registerItem(vegetable, "item.vegetable");
		GameRegistry.registerItem(seasoning, "item.seasoning");
		GameRegistry.registerItem(seed, "item.seed");
		
		//Add names to language registry from items with metadata
		for (int i = 0; i < StringLib.FISH_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(fish.itemID, 1, i), StringLib.FISH_NAMES[i]);
		for (int i = 0; i < StringLib.FRUIT_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(fruit.itemID, 1, i), StringLib.FRUIT_NAMES[i]);
		for (int i = 0; i < StringLib.VEG_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(vegetable.itemID, 1, i), StringLib.VEG_NAMES[i]);
		for (int i = 0; i < StringLib.SEASONING_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(seasoning.itemID, 1, i), StringLib.SEASONING_NAMES[i]);
		for (int i = 0; i < StringLib.SEED_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(seed, 1, i), StringLib.SEED_NAMES[i]);
	}
}