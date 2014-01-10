package com.co2.essencraft.crafting;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.block.ModBlocks;
import com.co2.essencraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesVanilla 
{
	public static void init()
	{
		//9 Raw salt piles -> salt block
		GameRegistry.addRecipe(new ItemStack(ModBlocks.saltBlock.blockID, 1, 0), new Object[] {
				"iii", "iii", "iii", 'i', new ItemStack(ModItems.rawSaltPile)
			});
		//Salt block -> 9 raw salt pieces
		GameRegistry.addRecipe(new ItemStack(ModItems.rawSaltPile, 9), new Object[] {
				"i", 'i', new ItemStack(ModBlocks.saltBlock)
			});
	}
}