package com.co2.essencraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.recipe.CBCraftingManager;
import com.co2.essencraft.recipe.CBCraftingManager.KnifeType;

public class TileEntityCuttingBoard extends TileEntity implements IInventory
{
	//Inventory slots
	//0 = knife, 1 = input, 2 = output
	private ItemStack[] inventory;
	
	private ItemStack lastOutput;
	
	public TileEntityCuttingBoard()
	{
		super();
		inventory = new ItemStack[3];
	}
	
	@Override
	public void onInventoryChanged()
	{
		super.onInventoryChanged();
		
		if (getStackInSlot(0) == null)
			return;
		
		if (getStackInSlot(2) == null && lastOutput != null)
		{
			inventory[2] = null;
			if (inventory[1].stackSize <= 1)
				inventory[1] = null;
			else
				inventory[1] = inventory[1].splitStack(inventory[1].stackSize - 1);
		}
		
		KnifeType knife = getKnifeType(getStackInSlot(0));
		ItemStack in = getStackInSlot(1);
		ItemStack out = null;
		
		if (in != null && getStackInSlot(0) != null)
			out = CBCraftingManager.getOutput(in, knife);
		
		inventory[2] = out;
		lastOutput = out != null ? out.copy() : null;
	}
	
	public KnifeType getKnifeType(ItemStack stack)
	{
		if (stack.itemID == ItemIds.CHEF_KNIFE)
			return KnifeType.CHEF;
		else if (stack.itemID == ItemIds.BUTCHER_KNIFE)
			return KnifeType.BUTCHER;
		else if (stack.itemID == ItemIds.FILET_KNIFE)
			return KnifeType.FILET;
		else 
			return KnifeType.PARING;
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
		return false; //This is for autoinjection of items to sides 
	}
}