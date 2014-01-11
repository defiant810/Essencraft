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
	
	private static final String[] TEXTURES = { "FishCrab", "FishHalibut", 
		"FishLobster", "FishSalmon", "FishShrimp", "FishSquid", "FishTrout", "FishRedHerring" };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemFish(int id)
	{
		super(id, 2, 0.3f, true);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	  
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + StringLib.FISH_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_FISH - 1)].toLowerCase() + ".fish";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		if (damage < 0 || damage >= NUM_FISH)
			return null;
		
		return icons[damage];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[NUM_FISH];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + TEXTURES[i]);
	}
}