package com.co2.essencraft.item;

public class ItemCraftingTool extends ItemESC
{
	public ItemCraftingTool(int id, int use)
	{
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(use);
	}
}