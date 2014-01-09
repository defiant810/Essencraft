package com.co2.essencraft.item;

import com.co2.essencraft.lib.StringLib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
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
	
	public String getSimpleName()
	{
		return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		//The name with a capital first letter
		String file = this.getSimpleName().toUpperCase().charAt(0) + this.getSimpleName().substring(1);
		this.itemIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + file);
	}
}