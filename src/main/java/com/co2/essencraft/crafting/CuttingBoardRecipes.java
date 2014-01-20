package com.co2.essencraft.crafting;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.recipe.CBCraftingManager;
import com.co2.essencraft.recipe.CBCraftingManager.KnifeType;

public class CuttingBoardRecipes 
{
	public static void init()
	{
		CBCraftingManager.addRecipe(new ItemStack(ItemIds.FRUIT, 1, 0), KnifeType.CHEF, new ItemStack(ItemIds.FRUIT, 1, 1));
	}
}