package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.util.ArrayUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFruit extends ItemFoodESC
{
	private static final int NUM_FRUIT = StringLib.FRUIT_NAMES.length;
	private static final Integer[] EATING_BLACKLIST = { 3, 11, 13 };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemFruit(int id)
	{
		super(id, 2, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." +
				StringLib.FRUIT_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_FRUIT - 1)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[MathHelper.clamp_int(damage, 0, NUM_FRUIT - 1)];
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		int meta = par1ItemStack.getItemDamage();
		
		if (!ArrayUtils.ArrayContains(EATING_BLACKLIST, meta))
			par3EntityPlayer.setItemInUse(par1ItemStack, par1ItemStack.getMaxItemUseDuration());
		
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{	
		icons = new Icon[NUM_FRUIT];
		for (int i = 0; i < icons.length; i++)
		{
			String file = StringLib.FRUIT_NAMES[i].toUpperCase().charAt(0) + StringLib.FRUIT_NAMES[i].substring(1);
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + file);
		}
	}
}
