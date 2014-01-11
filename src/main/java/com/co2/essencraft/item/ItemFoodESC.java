package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Base class for all food items in this mod
public abstract class ItemFoodESC extends ItemFood
{
	public static final int ID_SHIFT_CORRECTION = 256;
	
	public ItemFoodESC(int id, int hungerRegen, float saturation, boolean wolf)
	{
		super(id - ID_SHIFT_CORRECTION, hungerRegen, saturation, wolf);
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
