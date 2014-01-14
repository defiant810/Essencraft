package com.co2.essencraft.item;


public class ItemToolESC extends ItemESC 
{		
	public ItemToolESC(int id, int maxUses)
	{
		super(id);
		this.setMaxDamage(maxUses);
		this.setMaxStackSize(1);
	}
	
}
