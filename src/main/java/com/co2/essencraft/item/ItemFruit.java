package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFruit extends ItemFoodESC
{
	private static final int NUM_FRUIT = 3;
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemFruit(int id)
	{
		super(id, 2, false);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("fruit");
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + 
				StringLib.FRUIT_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, 2)];
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
		icons = new Icon[NUM_FRUIT];
		icons[0] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFruitBanana");
		icons[1] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFruitPineapple");
		icons[2] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFruitBlueberries");
	}
}
