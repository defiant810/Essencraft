package com.co2.essencraft.crafting;

public class CraftingHandler 
{
	public static void init()
	{
		//Init vanilla style recipes
		SimpleRecipes.init();
		
		//Init the recipes for the cutting board
		CuttingBoardRecipes.init();
	}
}