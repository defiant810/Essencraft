package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSeasoning extends ItemESC 
{
	private static final int NUM_SEASONINGS = StringLib.SEASONING_NAMES.length;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemSeasoning(int id)
	{
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." + 
				StringLib.SEASONING_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_SEASONINGS - 1)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[MathHelper.clamp_int(damage, 0, NUM_SEASONINGS - 1)];
	}
	 
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{	
		icons = new Icon[NUM_SEASONINGS];
		for (int i = 0; i < icons.length; i++)
		{
			String file = StringLib.SEASONING_NAMES[i].toUpperCase().charAt(0) + StringLib.SEASONING_NAMES[i].substring(1);
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + file);
		}
	}
}
