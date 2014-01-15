package com.co2.essencraft.item;

public class ItemCraftToolESC extends ItemESC 
{		
	public ItemCraftToolESC(int id, int maxUses)
	{
		super(id);
		this.setMaxDamage(maxUses);
		this.setMaxStackSize(1);
	}
}
