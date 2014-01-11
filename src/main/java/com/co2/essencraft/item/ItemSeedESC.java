package com.co2.essencraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemSeedESC extends ItemSeeds
{	
	public ItemSeedESC(int id, int blockPlanted)
	{
		super(id, blockPlanted, Block.tilledField.blockID);
	}
}
