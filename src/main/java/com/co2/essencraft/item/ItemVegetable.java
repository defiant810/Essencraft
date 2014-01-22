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

public class ItemVegetable extends ItemFoodESC
{
	private static final int NUM_VEG = StringLib.VEG_NAMES.length;
	
	private static final String[] TEXTURES = { "VegGreenBean", "VegSoyBean", "VegBeet", "VegCabbage", "VegCelery", "VegCucumber", "VegEggPlant",
		"VegLettuce", "VegOnion", "VegPeas", "VegBellPepperR", "VegGhostPepper", "VegJalapenoPepper", "VegRadish", "VegRhubarb",
		"VegSpinach", "VegSquash", "VegTomato", "VegBellPepperY", "VegBellPepperO" };
	private static final Integer[] EATING_BLACKLIST = { };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemVegetable(int id)
	{
		super(id, 1, 0.1f, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + StringLib.VEG_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_VEG - 1)] + ".vegetable";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		if (damage < 0 || damage >= NUM_VEG)
			return null;
		
		return icons[damage];
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		int meta = par1ItemStack.getItemDamage();
		
		if (!ArrayUtils.arrayContains(EATING_BLACKLIST, meta) && par3EntityPlayer.canEat(false))
			par3EntityPlayer.setItemInUse(par1ItemStack, par1ItemStack.getMaxItemUseDuration());
		
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{	
		icons = new Icon[NUM_VEG];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + TEXTURES[i]);
	}
}