package com.co2.essencraft.world;

import java.util.Random;

import com.co2.essencraft.util.WorldUtils;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenESCBush extends WorldGenerator
{
	private final int plantedId;
	
	public WorldGenESCBush(boolean notify, int id)
	{
		super(notify);
		this.plantedId = id;
	}
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		for (int count = 0; count < 15; ++count)
		{
			setBlockAndMetadata(world, i, j + 1, k, plantedId, 0);
			
			i += (random.nextInt(3) - 1);
			k += (random.nextInt(3) - 1);
			j = WorldUtils.getMaxHeightOfBlockWithSpaceAbove(world, i, k, new Integer[] { Block.grass.blockID, Block.dirt.blockID });
		}
		
		return false;
	}
}