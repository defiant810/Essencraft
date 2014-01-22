package com.co2.essencraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;

import com.co2.essencraft.item.IESCBaseFood;
import com.co2.essencraft.item.IESCIngredient;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.recipe.KCCraftingManager;
import com.co2.essencraft.recipe.KCCraftingManager.ContainerType;
import com.co2.essencraft.util.ArrayUtils;

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
		super.onInventoryChanged();
		
		if (inventory[8] == null || inventory[9] == null)
			return;
		
		//If something got crafted
		if (inventory[10] == null && lastOutput != null)
		{
			for (int i = 0; i < 10; ++i)
				if (inventory[i] != null && !KCCraftingManager.isBlackListed(inventory[9], getContainerType(inventory[8]), inventory[i]))
					--inventory[i].stackSize;
			
			for (int i = 0; i < 10; ++i)
				if (inventory[i] != null && inventory[i].stackSize < 1)
					inventory[i] = null;
		}
		
		ItemStack out = null;
		if (getStackInSlot(9) != null && getStackInSlot(8) != null)
			out = KCCrafter.getCraftResult(ArrayUtils.itemStackSubArray(inventory, 0, 10));
		
		inventory[10] = out;
		lastOutput = out != null ? out.copy() : null;
	}
	
	public static ContainerType getContainerType(ItemStack stack)
	{
		int id = stack.itemID;
		
		if (id == ItemIds.PLATE)
			return ContainerType.PLATE;
		else if (id == ItemIds.PIE_PAN)
			return ContainerType.PIEPAN;
		else
			return ContainerType.BOWL;
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
				inventory[index] = ItemStack.loadItemStackFromNBT(stack);
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

//Class that actually handles all of the crafting
class KCCrafter
{
	public static ItemStack getCraftResult(ItemStack[] input)
	{
		ItemStack container = input[8];
		ItemStack base = input[9];
		ItemStack output = KCCraftingManager.getOutput(base, TileEntityKitchenCounter.getContainerType(container));
		if (output == null)
			return null;
		
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < 8; ++i)
		{
			if (input[i] == null)
				continue;
			
			IESCIngredient in = null;
			try
			{
				in = (IESCIngredient) Item.itemsList[input[i].itemID];
			}
			catch (Exception e)
			{
				continue;
			}
			if (in == null)
				continue;
			
			if (KCCraftingManager.isBlackListed(base, TileEntityKitchenCounter.getContainerType(container), input[i]))
				continue;
			
			PotionEffect[] effects = in.getEffects(input[i].getItemDamage());
			
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("iname", in.getIngredientName(input[i].getItemDamage()));
			tag.setFloat("saturation", in.getSaturation(input[i].getItemDamage()));
			tag.setByte("heal", (byte)in.getFoodValue(input[i].getItemDamage()));
			tag.setByte("numEffects", effects != null ? (byte)effects.length : (byte)0);
			if (effects != null && effects.length > 0)
			{
				NBTTagList effectList = new NBTTagList();
				for (PotionEffect eff : in.getEffects(input[i].getItemDamage()))
				{
					NBTTagCompound effectTag = new NBTTagCompound();
					eff.writeCustomPotionEffectToNBT(effectTag);
					effectList.appendTag(effectTag);
				}
				tag.setTag("EffectList", effectList);
			}
			
			list.appendTag(tag);
		}
		
		IESCBaseFood bf = (IESCBaseFood) Item.itemsList[input[9].itemID];
		PotionEffect[] effects = bf.getEffects(input[9].getItemDamage());
		NBTTagCompound baseTag = new NBTTagCompound();
		baseTag.setString("iname", bf.getIngredientName(input[9].getItemDamage()));
		baseTag.setFloat("saturation", bf.getSaturation(input[9].getItemDamage()));
		baseTag.setByte("heal", (byte)bf.getFoodValue(input[9].getItemDamage()));
		baseTag.setByte("numEffects", effects != null ? (byte)effects.length : (byte)0);
		if (effects != null && effects.length > 0)
		{
			NBTTagList effectList = new NBTTagList();
			for (PotionEffect eff : bf.getEffects(input[9].getItemDamage()))
			{
				NBTTagCompound effectTag = new NBTTagCompound();
				eff.writeCustomPotionEffectToNBT(effectTag);
				effectList.appendTag(effectTag);
			}
			baseTag.setTag("EffectList", effectList);
		}
		list.appendTag(baseTag);
		
		if (output.stackTagCompound == null)
			output.stackTagCompound = new NBTTagCompound();
			
		output.stackTagCompound.setTag("RecipeData", list);
		
		return output;
	}
}