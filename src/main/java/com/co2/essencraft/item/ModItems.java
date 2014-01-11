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
	public static ItemSeedESC ryeSeed;
	public static ItemSeedESC oatSeed;
	public static ItemSeedESC barleySeed;
	public static ItemSeedESC cornSeed;
	
	public static void init()
	{
		//Init items
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		vegetable = new ItemVegetable(ItemIds.VEGETABLE);
		seasoning = new ItemSeasoning(ItemIds.SEASONING);
		ryeSeed = new ItemSeedESC(ItemIds.RYE_SEED, ItemIds.RYE_CROP);
		oatSeed = new ItemSeedESC(ItemIds.OAT_SEED, ItemIds.OAT_CROP);
		barleySeed = new ItemSeedESC(ItemIds.BARLEY_SEED, ItemIds.BARLEY_CROP);		
		cornSeed = new ItemSeedESC(ItemIds.CORN_SEED, ItemIds.CORN_CROP);
		
		
		//Register items
		GameRegistry.registerItem(fish, "item.fish");
		GameRegistry.registerItem(fruit, "item.fruit");
		GameRegistry.registerItem(vegetable, "item.vegetable");
		GameRegistry.registerItem(seasoning, "item.seasoning");
		GameRegistry.registerItem(ryeSeed, "item.ryeSeed");
		GameRegistry.registerItem(oatSeed, "item.oatSeed");
		GameRegistry.registerItem(barleySeed, "item.barleySeed");
		GameRegistry.registerItem(cornSeed, "item.cornSeed");
		
		//Add names to language registry
		LanguageRegistry.addName(ryeSeed, "Rye Seed");
		LanguageRegistry.addName(oatSeed, "Oat Seed");
		LanguageRegistry.addName(barleySeed, "Barley Seed");
		LanguageRegistry.addName(cornSeed, "Corn Seed");
		
		//Add names to language registry from items with metadata
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