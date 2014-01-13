package com.co2.essencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTreeFruit extends Block
{
	public BlockTreeFruit(int id)
	{
		super(id, Material.plants);
		setTickRandomly(true);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}