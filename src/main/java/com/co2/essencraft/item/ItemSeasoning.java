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
	private static final int NUM_HERB = 10;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemSeasoning(int id)
	{
		super(id);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("herb/spice");
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName();// + 
				//StringLib.HERB_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, 9)];
		//without 9 being scaled to one less the length of herb[] the items in icons[] aren't named correctly in game
		//crashes when (NUM_HERB -1) results in a negative number though
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	 
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{	
		icons = new Icon[NUM_HERB];
		icons[0] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbBasil");
		icons[1] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbCilantro");
		icons[2] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbGarlicClove");
		icons[3] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbOregano");
		icons[4] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbParsley");
		icons[5] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbRawBlackPepper");
		icons[6] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbRosemary");
		icons[7] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbSage");
		icons[8] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbThyme");
		icons[9] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemHerbVanillaBean");
	}
}
