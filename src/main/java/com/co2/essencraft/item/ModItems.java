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
	public static ItemGrain grain;
	public static ItemESC knifeHandle;
	public static ItemESC chefKnife;
	public static ItemESC butcherKnife;
	public static ItemESC filletKnife;
	public static ItemESC paringKnife;
	public static ItemESC crossHatch;
	public static ItemFoodESC cutFruit;
	
	public static void init()
	{
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		vegetable = new ItemVegetable(ItemIds.VEGETABLE);
		seasoning = new ItemSeasoning(ItemIds.SEASONING);
		seed = new ItemSeedESC(ItemIds.SEED);
		grain = new ItemGrain(ItemIds.GRAIN);
		knifeHandle = (ItemESC) new ItemESC(ItemIds.KNIFE_HANDLE).setUnlocalizedName(StringLib.CROSSHATCH_NAME).setTextureName("KnifeHandle");
		chefKnife = (ItemESC) new ItemESC(ItemIds.CHEF_KNIFE).setUnlocalizedName(StringLib.CHEF_KNIFE_NAME).setTextureName("ChefKnife");
		butcherKnife = (ItemESC) new ItemESC(ItemIds.BUTCHER_KNIFE).setUnlocalizedName(StringLib.BUTCHER_KNIFE_NAME).setTextureName("ButcherKnife");
		filletKnife = (ItemESC) new ItemESC(ItemIds.FILET_KNIFE).setUnlocalizedName(StringLib.FILET_KNIFE_NAME).setTextureName("FiletKnife");
		paringKnife = (ItemESC) new ItemESC(ItemIds.PARING_KNIFE).setUnlocalizedName(StringLib.PARING_KNIFE_NAME).setTextureName("ParingKnife");
		crossHatch = (ItemESC) new ItemESC(ItemIds.CROSSHATCH).setUnlocalizedName(StringLib.KNIFE_HANDLE_NAME).setTextureName("CrossHatch");
		cutFruit = new ItemCutFruit(ItemIds.CUT_FRUIT);
		
		GameRegistry.registerItem(fish, "item.fish");
		GameRegistry.registerItem(fruit, "item.fruit");
		GameRegistry.registerItem(vegetable, "item.vegetable");
		GameRegistry.registerItem(seasoning, "item.seasoning");
		GameRegistry.registerItem(seed, "item.seed");
		GameRegistry.registerItem(grain, "item.grain");
		GameRegistry.registerItem(knifeHandle, "item.knifeHandle");
		GameRegistry.registerItem(chefKnife, "item.chefKnife");
		GameRegistry.registerItem(butcherKnife, "item.butcherKnife");
		GameRegistry.registerItem(filletKnife, "item.filetKnife");
		GameRegistry.registerItem(paringKnife, "item.paringKnife");
		GameRegistry.registerItem(crossHatch, "item.crossHatch");
		GameRegistry.registerItem(cutFruit, "item.cutFruit");
		
		LanguageRegistry.addName(knifeHandle, "Knife Handle");
		LanguageRegistry.addName(chefKnife, "Chef's Knife");
		LanguageRegistry.addName(butcherKnife, "Butcher Knife");
		LanguageRegistry.addName(filletKnife, "Filet Knife");
		LanguageRegistry.addName(paringKnife, "Paring Knife");
		LanguageRegistry.addName(crossHatch, "Crosshatching");
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
		for (int i = 0; i < StringLib.GRAIN_NAMES.length; i++)
			LanguageRegistry.addName(new ItemStack(grain.itemID,1, i), StringLib.GRAIN_NAMES[i]);
		for (int i = 0; i < StringLib.CUT_FRUIT_NAMES.length; i ++)
		{
			String name = StringLib.CUT_FRUIT_NAMES[i]; 
			if(null != name)
				LanguageRegistry.addName(new ItemStack(cutFruit.itemID, 1, i), name);
		}
	}
}