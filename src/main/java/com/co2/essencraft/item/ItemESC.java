package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Base class for all items in this mod
public class ItemESC extends Item
{
	public static final int ID_SHIFT_CORRECTION = 256; 
	
	public ItemESC(int id)
	{
		super(id - ID_SHIFT_CORRECTION);
		this.setMaxStackSize(64);
		//TODO set proper creative tab
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + this.iconString);
	}
}