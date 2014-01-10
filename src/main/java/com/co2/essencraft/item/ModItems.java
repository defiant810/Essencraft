package com.co2.essencraft.item;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems 
{
	/*public static ItemESC rye;
	public static ItemESC herb;*/
	
	public static ItemFoodESC fish;
	public static ItemFoodESC fruit;
	
	public static void init()
	{
		//Init items
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		
		//Register items
		GameRegistry.registerItem(fish, "item.fish");
		GameRegistry.registerItem(fruit, "item.fruit");
		
		//Add names to language registry
		for (int i = 0; i < StringLib.FISH_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(fish.itemID, 1, i), StringLib.FISH_NAMES_HUMAN[i]);
		for (int i = 0; i < StringLib.FRUIT_NAMES_HUMAN.length; i++)
			LanguageRegistry.addName(new ItemStack(fruit.itemID, 1, i), StringLib.FRUIT_NAMES_HUMAN[i]);
		
		 /*rawSaltPile = new ItemRawSaltPile(ItemIds.RAW_SALT_PILE);
		 coconut = new ItemCoconut(ItemIds.COCONUT);
		 fish = new ItemFish(ItemIds.FISH);
		 kiwi = new ItemKiwi(ItemIds.KIWI);
		 rye = new ItemRye(ItemIds.RYE);
		 fruit = new ItemFruit(ItemIds.FRUIT);
		 herb = new ItemHerb(ItemIds.HERB);
		 
		 GameRegistry.registerItem(rawSaltPile, "item." + StringLib.RAW_SALT_PILE_NAME);
		 GameRegistry.registerItem(coconut, "item." + StringLib.COCONUT_NAME);
		 GameRegistry.registerItem(fish, "item.fish");
		 GameRegistry.registerItem(kiwi, "item." + StringLib.KIWI_NAME);
		 GameRegistry.registerItem(rye, "item." + StringLib.RYE_NAME);
		 GameRegistry.registerItem(fruit, "item.fruit");
		 GameRegistry.registerItem(herb, "item.herb");
		 
		 LanguageRegistry.addName(rawSaltPile, "Large Salt Pile");
		 LanguageRegistry.addName(coconut, "Coconut");
		 for(int i = 0; i < StringLib.HUMAN_FISH_NAMES.length; i++)
			 LanguageRegistry.addName(new ItemStack(fish.itemID, 1, i), StringLib.HUMAN_FISH_NAMES[i]);
		 LanguageRegistry.addName(kiwi, "Kiwi");
		 LanguageRegistry.addName(rye, "Rye");*/
	}
}