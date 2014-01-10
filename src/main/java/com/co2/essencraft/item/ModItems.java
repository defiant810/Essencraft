package com.co2.essencraft.item;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems 
{
	public static ItemESC rawSaltPile;
	public static ItemESC coconut;
	public static ItemESC rye;
	public static ItemESC herb;
	
	public static ItemFoodESC fruit;
	public static ItemFoodESC fish;
	public static ItemFoodESC kiwi;
	
	public static void init()
	{
		 rawSaltPile = new ItemRawSaltPile(ItemIds.RAW_SALT_PILE);
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
		 GameRegistry.registerItem(fruit, "item." + StringLib.FRUIT_NAMES);
		 GameRegistry.registerItem(herb, "item." + StringLib.HERB_NAMES);
		 
		 LanguageRegistry.addName(rawSaltPile, "Large Salt Pile");
		 LanguageRegistry.addName(coconut, "Coconut");
		 LanguageRegistry.addName(fish, "Fish");
		 LanguageRegistry.addName(kiwi, "Kiwi");
		 LanguageRegistry.addName(rye, "Rye");
		 LanguageRegistry.addName(fruit, "Fruit");
		 LanguageRegistry.addName(herb, "Herb");
	}
}