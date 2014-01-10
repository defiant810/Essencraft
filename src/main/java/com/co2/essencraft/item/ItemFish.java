package com.co2.essencraft.item;

import com.co2.essencraft.lib.StringLib;

public class ItemFish extends ItemFoodESC{
	public ItemFish(int id)
	{
		super(id, 2, true);
		this.setUnlocalizedName(StringLib.FISH_NAME);
	}

}
