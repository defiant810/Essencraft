package com.co2.essencraft.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.ItemIds;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesVanilla 
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ItemIds.KNIFE_HANDLE, 4, 0), new Object[]
				{
					"X", "x", "X", 'X', new ItemStack(Block.pressurePlatePlanks), 'x', new ItemStack(Item.ingotIron)
				});
	}
}