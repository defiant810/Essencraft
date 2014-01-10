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
		super(id, 2, true);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("fish");
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." +
				StringLib.FISH_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, 2)];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	//Example of how to make some foods editable but others not
	/*@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		int meta = par1ItemStack.getItemDamage();
		
		if (!(meta >= 2))
			par3EntityPlayer.setItemInUse(par1ItemStack, par1ItemStack.getMaxItemUseDuration());
		
		return par1ItemStack;
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[NUM_FISH];
		icons[0] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFishHalibut");
		icons[1] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFishSalmon");
		icons[2] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemFishTrout");
	}
}