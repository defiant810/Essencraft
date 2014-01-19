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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + this.textureName);
	}
}