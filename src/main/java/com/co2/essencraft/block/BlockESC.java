package com.co2.essencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
}