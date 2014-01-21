package com.co2.essencraft.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.client.container.slot.CuttableSlot;
import com.co2.essencraft.client.container.slot.KnifeSlot;
import com.co2.essencraft.client.container.slot.OutputSlot;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;
import com.co2.essencraft.util.IdUtils;

public class ContainerCuttingBoard extends Container
{
	private TileEntityCuttingBoard boardEntity;
	
	public ContainerCuttingBoard(InventoryPlayer player, TileEntityCuttingBoard entity)
	{
		this.boardEntity = entity;
		
		//Add the hotbar
		for (int i = 0; i < 9; ++i)
			this.addSlotToContainer(new Slot(player, i, 8 + (i * 18), 142));
		
		//Add the rest of the player inventory
		for (int y = 0; y < 3; ++y)
			for (int x = 0; x < 9; ++x)
				this.addSlotToContainer(new Slot(player, 9 + x + (y * 9), 8 + (x * 18), 84 + (y * 18)));
		
		//Add the three custom gui slots
		this.addSlotToContainer(new KnifeSlot(boardEntity, 0, 62, 26));
		this.addSlotToContainer(new CuttableSlot(boardEntity, 1, 62, 44));
		this.addSlotToContainer(new OutputSlot(boardEntity, 2, 98, 35));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return boardEntity.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack stack = null;
		Slot invSlot = (Slot) this.inventorySlots.get(slot);
		
		if (invSlot != null && invSlot.getHasStack())
		{
			ItemStack slotStack = invSlot.getStack();
			stack = slotStack.copy();
			
			//If the origin slot is in the player inventory
			if (slot < 36)
			{
				if (IdUtils.isCraftingTool(slotStack))
				{
					if (!this.mergeItemStack(slotStack, 36, 37, false))
						return null;
				}
				else if (IdUtils.hasCuttingBoardRecipe(slotStack))
				{
					if (!this.mergeItemStack(slotStack, 37, 38, false))
						return null;
				}
				else
					return null;
			}
			else if (!this.mergeItemStack(slotStack, 0, 36, false))
				return null;
			
			if (slotStack.stackSize == 0)
				invSlot.putStack(null);
			else
				invSlot.onSlotChanged();
		}
		
		return stack;
	}
}