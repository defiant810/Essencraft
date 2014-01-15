package com.co2.essencraft.item;

public class ItemCraftTool extends ItemESC 
{		
	public ItemCraftTool(int id, int maxUses)
	{
		super(id);
		this.setMaxDamage(maxUses);
		this.setMaxStackSize(1);
	}
}
