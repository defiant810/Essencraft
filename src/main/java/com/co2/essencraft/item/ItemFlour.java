package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlour extends ItemESC{

	private static final int NUM_FLOURS = StringLib.FLOUR_NAMES.length;
	private static final String[] TEXTURES = {"FlourBarley", "FlourCorn", null, "FlourOat", "FlourRye", "FlourRice"};
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemFlour(int id)
	{
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		String name = StringLib.FLOUR_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_FLOURS - 1)];
		if(null == name)
			return "UDunGoofed";
		
		return "item." + name + ".grain";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		if (damage < 0 || damage >= NUM_FLOURS)
			return null;
		
		return icons[damage];
	}
	 
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{	
		icons = new Icon[NUM_FLOURS];
		for (int i = 0; i < icons.length; i++)
		{
			String name = TEXTURES[i];
			if(null == name)
				icons[i] = null;
			else
				icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + name);
		}
	}
}
