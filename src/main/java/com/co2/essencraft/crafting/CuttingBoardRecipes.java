package com.co2.essencraft.crafting;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.recipe.CBCraftingManager;
import com.co2.essencraft.recipe.CBCraftingManager.KnifeType;

public class CuttingBoardRecipes 
{
	public static void init()
	{
		//addRecipe(input, knife, output)
		CBCraftingManager.addRecipe(new ItemStack(ItemIds.FRUIT, 1, 0), KnifeType.CHEF, new ItemStack(ItemIds.FRUIT, 1, 1));
		
		//cut fruits
		for(int i = 0; i < StringLib.CUT_FRUIT_NAMES.length; i++)
		{
			if(!StringLib.CUT_FRUIT_NAMES[i].equals(null))
				CBCraftingManager.addRecipe(new ItemStack(ItemIds.FRUIT, 1, i), KnifeType.CHEF, new ItemStack(ItemIds.CUT_FRUIT, 1, i));
		}
		
		
	}
}