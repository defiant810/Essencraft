package com.co2.essencraft.item;

import com.co2.essencraft.lib.StringLib;

public class ItemCoconut extends ItemFoodESC
{
	public ItemCoconut(int id)
	{
		super(id, 2, false);
		this.setUnlocalizedName(StringLib.COCONUT_NAME);
	}
}