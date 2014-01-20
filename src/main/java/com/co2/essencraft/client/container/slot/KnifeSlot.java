package com.co2.essencraft.client.container.slot;

import com.co2.essencraft.lib.ItemIds;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class KnifeSlot extends Slot
{
	public KnifeSlot(IInventory inv, int i, int x, int y)
	{
		super(inv, i, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		if (stack == null)
			return true;
		
		int id = stack.itemID;
		
		return (id == ItemIds.BUTCHER_KNIFE || id == ItemIds.CHEF_KNIFE
				|| id == ItemIds.FILET_KNIFE || id == ItemIds.PARING_KNIFE);
	}
}