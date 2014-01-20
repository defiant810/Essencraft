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
					"y", "x", "y", 'y', new ItemStack(Block.pressurePlatePlanks), 'x', new ItemStack(Item.ingotIron)
				});
		//Chef Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.chefKnife), new Object[]
				{
					"y", "y", "x", 'y', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Butcher Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.butcherKnife), new Object[]
				{
					"yy ", "yy ", " x ", 'y', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Fillet Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.filletKnife), new Object[]
				{
					" yy", " y ", " x ", 'y', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Paring Knife
		GameRegistry.addRecipe(new ItemStack(ModItems.paringKnife), new Object[]
				{
					" ", "y", "x", 'y', new ItemStack(Item.ingotIron), 'x', new ItemStack(ModItems.knifeHandle)
				});
		//Crosshatch
		GameRegistry.addRecipe(new ItemStack(ItemIds.CROSSHATCH, 8, 0), new Object[]
				{
					" x ", "xxx", " x ", 'x', new ItemStack(Item.stick)
				});
		//Vine support
		GameRegistry.addRecipe(new ItemStack(BlockIds.VINE_SUPPORT, 4, 0), new Object[]
				{
					"xyx", "xyx", "xyx", 'x', new ItemStack(Item.stick), 'y', new ItemStack(ModItems.crossHatch)
				});	
		//Cutting board
		GameRegistry.addRecipe(new ItemStack(BlockIds.CUTTING_BOARD, 2, 0), new Object[]
				{
					"xx", 'x', new ItemStack(Block.pressurePlatePlanks)
				});
	}
}