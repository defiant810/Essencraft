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
	}
}