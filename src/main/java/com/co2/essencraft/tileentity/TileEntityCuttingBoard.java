package com.co2.essencraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCuttingBoard extends TileEntity implements IInventory
{
	//Inventory slots
	private ItemStack[] inventory;
	
	public TileEntityCuttingBoard()
	{
		super();
		inventory = new ItemStack[3];
	}
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) 
	{	
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) 
	{
		ItemStack stack = getStackInSlot(slot);
		
		if (stack != null)
		{
			if (stack.stackSize <= count)
				setInventorySlotContents(slot, null);
			else
			{
				stack = stack.splitStack(count);
				onInventoryChanged();
			}
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) 
	{	
		ItemStack stack = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) 
	{	
		inventory[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
			itemStack.stackSize = getInventoryStackLimit();
		
		onInventoryChanged();
	}

	@Override
	public String getInvName() 
	{	
		return "CuttingBoard";
	}

	@Override
	public boolean isInvNameLocalized() 
	{	
		return true;
	}

	@Override
	public int getInventoryStackLimit() 
	{	
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) 
	{	
		return entityPlayer.getDistanceSq(xCoord + .5d, yCoord + .5d, zCoord + .5d) <= 64d;
	}

	@Override
	public void openChest() { }

	@Override
	public void closeChest() { }

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
		return true;
	}
}