package com.co2.essencraft.util;

import com.co2.essencraft.lib.ItemIds;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IdUtils 
{
	public static boolean isKnife(ItemStack stack)
	{
		int id = stack.itemID;
		return (id == ItemIds.BUTCHER_KNIFE || id == ItemIds.CHEF_KNIFE || id == ItemIds.FILET_KNIFE || id == ItemIds.PARING_KNIFE);
	}
	
	public static boolean isCraftingTool(ItemStack stack)
	{
		int id = stack.itemID;
		return (id == ItemIds.BUTCHER_KNIFE || id == ItemIds.CHEF_KNIFE || id == ItemIds.FILET_KNIFE || id == ItemIds.PARING_KNIFE || id == ItemIds.GRINDING_STONE);
	}
	
	public static boolean isCuttable(ItemStack stack)
	{
		int id = stack.itemID;
		return (id == ItemIds.FRUIT || id == ItemIds.VEGETABLE);
	}
	
	public static boolean hasCuttingBoardRecipe(ItemStack stack)
	{
		int id = stack.itemID;
		return (id == ItemIds.FRUIT || id == ItemIds.VEGETABLE || id == ItemIds.GRAIN);
	}
	
	public static boolean isFoodContainer(ItemStack stack)
	{
		int id = stack.itemID;
		return (id == ItemIds.PLATE || id == ItemIds.PIE_PAN || id == Item.bowlEmpty.itemID);
	}
}