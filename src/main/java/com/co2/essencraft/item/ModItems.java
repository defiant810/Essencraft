package com.co2.essencraft.item;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems 
{
	public static ItemESC rawSaltPile;
	public static ItemFoodESC coconut;
	
	public static void init()
	{
		 rawSaltPile = new ItemRawSaltPile(ItemIds.RAW_SALT_PILE);
		 coconut = new ItemCoconut(ItemIds.COCONUT);
		 
		 GameRegistry.registerItem(coconut, "item." + StringLib.COCONUT_NAME);
		 GameRegistry.registerItem(rawSaltPile, "item." + StringLib.RAW_SALT_PILE_NAME);
	}
}