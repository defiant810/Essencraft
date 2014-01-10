package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFish extends ItemFoodESC
{
	private static final int NUM_FISH = StringLib.FISH_NAMES.length;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemFish(int id)
	{
		super(id, 2, 0.4f, true);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." +
				StringLib.FISH_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, StringLib.FISH_NAMES.length - 1)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[MathHelper.clamp_int(damage, 0, icons.length - 1)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[NUM_FISH];
		for (int i = 0; i < icons.length; i++)
		{
			String file = StringLib.FISH_NAMES[i].toUpperCase().charAt(0) + StringLib.FISH_NAMES[i].substring(1);
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + file);
		}
	}
}