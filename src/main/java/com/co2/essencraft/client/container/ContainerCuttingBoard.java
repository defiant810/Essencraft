package com.co2.essencraft.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.client.container.slot.CuttableSlot;
import com.co2.essencraft.client.container.slot.KnifeSlot;
import com.co2.essencraft.client.container.slot.OutputSlot;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;
import com.co2.essencraft.util.IdUtils;

public class ContainerCuttingBoard extends ContainerESC
{
	private TileEntityCuttingBoard boardEntity;
	
	public ContainerCuttingBoard(InventoryPlayer player, TileEntityCuttingBoard entity)
	{
		this.boardEntity = entity;
		
		this.bindPlayerInventory(player);
		
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
			if (slot < INVENTORY_OFFSET)
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
			else if (!this.mergeItemStack(slotStack, 0, INVENTORY_OFFSET, false))
				return null;
			
			if (slotStack.stackSize == 0)
				invSlot.putStack(null);
			else
				invSlot.onSlotChanged();
		}
		
		return stack;
	}
}