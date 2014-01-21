package com.co2.essencraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityKitchenCounter extends TileEntity implements IInventory
{
	//Inventory Slots
	//0-7 ingredients, 8 utensil, 9 meal base, 10 output
	//See: https://drive.google.com/file/d/0B_QTwbv36vr6OTk2V2VCWXhoTVE/edit?usp=sharing
	private ItemStack[] inventory;
	
	private ItemStack lastOutput;
	
	public TileEntityKitchenCounter()
	{
		super();
		inventory = new ItemStack[getSizeInventory()];
	}
	
	@Override
	public void onInventoryChanged()
	{
		//TODO
	}
	
	@Override
	public int getSizeInventory()
	{
		return 11;
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
		return "KitchenCounter";
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
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		
		NBTTagList tagList = tag.getTagList("Items");
		inventory = new ItemStack[getSizeInventory()];
		for (int i = 0; i < inventory.length && i < tagList.tagCount(); ++i)
		{
			NBTTagCompound stack = (NBTTagCompound) tagList.tagAt(i);
			byte index = stack.getByte("Slot");
			if (index >= 0 && index < inventory.length)
				inventory[i] = ItemStack.loadItemStackFromNBT(stack);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		
		NBTTagList tagList = new NBTTagList();
		for (int i = 0; i < inventory.length; ++i)
		{
			if (inventory[i] != null)
			{
				NBTTagCompound stack = new NBTTagCompound();
				stack.setByte("Slot", (byte)i);
				inventory[i].writeToNBT(stack);
				tagList.appendTag(stack);
			}
		}
		tag.setTag("Items", tagList);
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	}
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet)
	{
		this.readFromNBT(packet.data);
	}
}