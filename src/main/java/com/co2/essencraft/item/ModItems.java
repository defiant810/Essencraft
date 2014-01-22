package com.co2.essencraft.item;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.item.food.ItemCombinedFood;
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
	public static ItemFoodESC cutVegetable;
	public static ItemESC grindingStone;
	public static ItemFlour flour;
	public static ItemESC plate;
	public static ItemESC piePan;
	
	public static ItemCombinedFood cfFruitSalad;
	
	public static void init()
	{
		fish = new ItemFish(ItemIds.FISH);
		fruit = new ItemFruit(ItemIds.FRUIT);
		vegetable = new ItemVegetable(ItemIds.VEGETABLE);
		seasoning = new ItemSeasoning(ItemIds.SEASONING);
		seed = new ItemSeedESC(ItemIds.SEED);
		grain = new ItemGrain(ItemIds.GRAIN);
		knifeHandle = (ItemESC) new ItemESC(ItemIds.KNIFE_HANDLE).setUnlocalizedName(StringLib.CROSSHATCH_NAME).setTextureName("KnifeHandle");
		chefKnife = (ItemCraftTool) new ItemCraftTool(ItemIds.CHEF_KNIFE, 256).setUnlocalizedName(StringLib.CHEF_KNIFE_NAME).setTextureName("ChefKnife");
		butcherKnife = (ItemCraftTool) new ItemCraftTool(ItemIds.BUTCHER_KNIFE, 256).setUnlocalizedName(StringLib.BUTCHER_KNIFE_NAME).setTextureName("ButcherKnife");
		filletKnife = (ItemCraftTool) new ItemCraftTool(ItemIds.FILET_KNIFE, 256).setUnlocalizedName(StringLib.FILET_KNIFE_NAME).setTextureName("FiletKnife");
		paringKnife = (ItemCraftTool) new ItemCraftTool(ItemIds.PARING_KNIFE, 256).setUnlocalizedName(StringLib.PARING_KNIFE_NAME).setTextureName("ParingKnife");
		crossHatch = (ItemESC) new ItemESC(ItemIds.CROSSHATCH).setUnlocalizedName(StringLib.KNIFE_HANDLE_NAME).setTextureName("CrossHatch");
		cutFruit = new ItemCutFruit(ItemIds.CUT_FRUIT);
		cutVegetable = new ItemCutVegetable(ItemIds.CUT_VEGETABLE);
		grindingStone = (ItemCraftTool) new ItemCraftTool(ItemIds.GRINDING_STONE, 256).setUnlocalizedName(StringLib.GRINDING_STONE_NAME).setTextureName("Grindingstone");
		flour = new ItemFlour(ItemIds.FLOUR);
		plate = (ItemESC) new ItemESC(ItemIds.PLATE).setUnlocalizedName(StringLib.PLATE_NAME).setTextureName("Plate");
		piePan = (ItemESC) new ItemESC(ItemIds.PIE_PAN).setUnlocalizedName(StringLib.PIE_PAN_NAME).setTextureName("PiePan");
		cfFruitSalad = (ItemCombinedFood) new ItemCombinedFood(ItemIds.CF_FRUIT_SALAD).setUnlocalizedName(StringLib.CF_FRUIT_SALAD).setTextureName("CFFruitSalad");
		
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
		GameRegistry.registerItem(cutVegetable, "item.cutVegetable");
		GameRegistry.registerItem(grindingStone, "item.grindingStone");
		GameRegistry.registerItem(flour, "item.flour");
		GameRegistry.registerItem(plate, "item.plate");
		GameRegistry.registerItem(piePan, "item.piePan");
		GameRegistry.registerItem(cfFruitSalad, "item.salad");
				
		LanguageRegistry.addName(knifeHandle, "Knife Handle");
		LanguageRegistry.addName(chefKnife, "Chef's Knife");
		LanguageRegistry.addName(butcherKnife, "Butcher Knife");
		LanguageRegistry.addName(filletKnife, "Filet Knife");
		LanguageRegistry.addName(paringKnife, "Paring Knife");
		LanguageRegistry.addName(crossHatch, "Crosshatching");
		LanguageRegistry.addName(grindingStone, "Grinding Stone");
		LanguageRegistry.addName(plate, "Plate");
		LanguageRegistry.addName(piePan, "Pie Pan");
		
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
		for (int i = 0; i < StringLib.CUT_FRUIT_NAMES.length; i++)
		{
			String name = StringLib.CUT_FRUIT_NAMES[i]; 
			if(null != name)
				LanguageRegistry.addName(new ItemStack(cutFruit.itemID, 1, i), name);
		}
		for (int i = 0; i < StringLib.CUT_VEGETABLE_NAMES.length; i++)
		{
			String name = StringLib.CUT_VEGETABLE_NAMES[i]; 
			if(name != null)
				LanguageRegistry.addName(new ItemStack(cutVegetable.itemID, 1, i), name);
		}
		for ( int i = 0; i < StringLib.FLOUR_NAMES.length; i++)
		{
			String name = StringLib.FLOUR_NAMES[i]; 
			if(name != null)
				LanguageRegistry.addName(new ItemStack(flour.itemID, 1, i), name);
		}	
	}
}