package com.co2.essencraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//Base class for all items in this mod
public abstract class ItemESC extends Item
{
	public static final int ID_SHIFT_CORRECTION = 256; 
	
	public ItemESC(int id)
	{
		super(id - ID_SHIFT_CORRECTION);
		this.setMaxStackSize(64);
		//TODO set proper creative tab
	}
	
	public String simpleName(int meta)
	{
		ItemStack st = new ItemStack(this.itemID, 1, meta);
		String name = this.getUnlocalizedName(st).substring(this.getUnlocalizedName(st).indexOf(".") + 1);
		name = name.substring(0, name.indexOf("."));
		return name;
	}
	
	public String simpleName()
	{
		String name = this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
		name = name.substring(0, name.indexOf("."));
		return name;
	}
}