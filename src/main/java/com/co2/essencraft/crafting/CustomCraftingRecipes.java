package com.co2.essencraft.crafting;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.item.ModItems;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.recipe.CBCraftingManager;
import com.co2.essencraft.recipe.CBCraftingManager.KnifeType;
import com.co2.essencraft.recipe.KCCraftingManager.ContainerType;
import com.co2.essencraft.recipe.KCCraftingManager;

public class CustomCraftingRecipes 
{
	public static void init()
	{
		initCuttingBoard();
		initKitchenCounter();
	}
	
	private static void initKitchenCounter()
	{
		//The first parameter is the array of itemstack arrays. Each array holds all of the ItemStacks in the group allowed in one slot. An itemstack of size -1 allows all
		//items of the same id in. Passing null means the base must be empty for the recipe to match. The second parameter is the container type that the recipe must go
		//into/ on top of. The third parameter is the output from the recipe. The fourth parameter is all of the items that are allowed to be extra ingredients in the recipe,
		//and similar to the first parameter, a stack size of -1 allows all items of the same id to be used.
		
		//Fruit salad
		KCCraftingManager.addRecipe(new ItemStack[][] { { new ItemStack(ModItems.cutFruit, -1, 0) } , null, null }, ContainerType.BOWL, new ItemStack(ModItems.cfFruitSalad), 
				new ItemStack(ModItems.cutFruit, -1, 0));
	}
	
	private static void initCuttingBoard()
	{
		// input, tool, output
		//cut fruits
		for(int i = 0; i < StringLib.CUT_FRUIT_NAMES.length; i++)
		{
			if(null != StringLib.CUT_FRUIT_NAMES[i])
				CBCraftingManager.addRecipe(new ItemStack(ItemIds.FRUIT, 1, i), KnifeType.CHEF, new ItemStack(ItemIds.CUT_FRUIT, 1, i));
		}
		
		//cut vegetables
		for(int i = 0; i < StringLib.CUT_VEGETABLE_NAMES.length; i++)
		{
			if(StringLib.CUT_VEGETABLE_NAMES[i] != null)
				CBCraftingManager.addRecipe(new ItemStack(ItemIds.VEGETABLE, 1, i), KnifeType.CHEF, new ItemStack(ItemIds.CUT_VEGETABLE, 1, i));
		}
		
		//flour
		for(int i = 0; i < StringLib.FLOUR_NAMES.length; i++)
		{
			if(StringLib.FLOUR_NAMES[i] != null)
				CBCraftingManager.addRecipe(new ItemStack(ItemIds.GRAIN, 1, i), KnifeType.GRINDING_STONE, new ItemStack(ItemIds.FLOUR, 1, i));
		}
	}
}