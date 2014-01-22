package com.co2.essencraft.client.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.item.IESCBaseFood;

public class ESCBaseFoodSlot extends Slot
{
	public ESCBaseFoodSlot(IInventory inv, int i, int x, int y)
	{
		super(inv, i, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		Item item = Item.itemsList[stack.itemID];
		return (item instanceof IESCBaseFood);
	}
}