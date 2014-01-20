package com.co2.essencraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import com.co2.essencraft.lib.StringLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCutFruit extends ItemFoodESC{

	private static final int NUM_FRUIT = StringLib.CUT_FRUIT_NAMES.length;
	
	//index matches index of ItemFruit TEXTURES array, is null if it cannot be cut
	private static final String[] TEXTURES = { "FruitBanana", null, null, "FruitCoconut", "FruitGrapeFruit",
		null, "FruitKiwi", "FruitMango", "FruitOrange", "FruitPeach", "FruitPear", "FruitPineapple", "FruitPlum", null,
		null, "FruitStrawberry" };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemCutFruit(int id)
	{
		super(id, 1, 0.1f, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		String name = StringLib.CUT_FRUIT_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_FRUIT - 1)];
		if(name.equals(null))
			return null;
		
		return "item." + StringLib.CUT_FRUIT_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_FRUIT - 1)] + ".fruit";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		Icon pic = icons[damage];
		if (damage < 0 || damage >= NUM_FRUIT || pic == null)
			return null;
		
		return pic;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{		
		if (par3EntityPlayer.canEat(false))
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
			String name = TEXTURES[i];
			if(name.equals(null))
				icons[i] = null;
			else
				icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "itemCut" + name);
		}
	}
}
