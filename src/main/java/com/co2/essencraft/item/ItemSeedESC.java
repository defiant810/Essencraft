package com.co2.essencraft.item;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeeds;

public class ItemSeedESC extends ItemSeeds
{	
	public static final int ID_SHIFT_CORRECTION = 256;
	
	public ItemSeedESC(int id, int blockPlanted)
	{
		super(id - ID_SHIFT_CORRECTION, blockPlanted, Block.tilledField.blockID);
	}
	
	public String getSimpleName()
	{
		return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		//The name with a capital first letter
		String file = this.getSimpleName().toUpperCase().charAt(0) + this.getSimpleName().substring(1);
		this.itemIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + file);
	}
}
