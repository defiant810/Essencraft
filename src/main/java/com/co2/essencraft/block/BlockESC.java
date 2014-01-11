package com.co2.essencraft.block;

import com.co2.essencraft.lib.StringLib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Base class for all blocks in this mod
public abstract class BlockESC extends Block
{
	public BlockESC(int id)
	{
		super(id, Material.rock);
	}
	
	public BlockESC(int id, Material mat)
	{
		super(id, mat);
	}
	
	public String getSimpleName()
	{
		return this.getLocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		//Get the name with a capital first letter
		String file = this.getSimpleName().toUpperCase().charAt(0) + this.getSimpleName().substring(1, this.getSimpleName().length() - 5);
		this.blockIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + file);
	}
}