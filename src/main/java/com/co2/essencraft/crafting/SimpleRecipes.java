package com.co2.essencraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.item.ModItems;
import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;

import cpw.mods.fml.common.registry.GameRegistry;

public class SimpleRecipes 
{
	public static void init()
	{
		//Knife Handle
		GameRegistry.addRecipe(new ItemStack(ItemIds.KNIFE_HANDLE, 4, 0), new Object[]
				{
					"X", "x", "X", 'X', new ItemStack(Block.pressurePlatePlanks), 'x', new ItemStack(Item.ingotIron)
				});
		//Chef Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.chefKnife), new Object[]
				{
					"X", "X", "x", 'X', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Butcher Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.butcherKnife), new Object[]
				{
					"XX ", "XX ", " x ", 'X', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Filet Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.filetKnife), new Object[]
				{
					" XX", " X ", " x ", 'X', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Paring Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.paringKnife), new Object[]
				{
					" ", "X", "x", 'X', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Crosshatch
		GameRegistry.addRecipe(new ItemStack(ItemIds.CROSSHATCH, 8, 0), new Object[]
				{
					" X ", "XXX", " X ", 'X', new ItemStack(Item.stick)
				});
		//Vine support
		GameRegistry.addRecipe(new ItemStack(BlockIds.VINE_SUPPORT, 4, 0), new Object[]
				{
					"xXx", "xXx", "xXx", 'x', new ItemStack(Item.stick), 'X', new ItemStack(ModItems.crossHatch)
				});	
	}
}