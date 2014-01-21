package com.co2.essencraft.client.container.slot;

import com.co2.essencraft.util.IdUtils;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class FoodContainerSlot extends Slot
{
	public FoodContainerSlot(IInventory inv, int i, int x, int y)
	{
		super(inv, i, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return IdUtils.isFoodContainer(stack);
	}
}