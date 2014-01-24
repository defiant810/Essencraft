package com.co2.essencraft.util;

import net.minecraft.world.World;

public class WorldUtils 
{
	public static int getMaxHeightOfBlockWithSpaceAbove(World world, int x, int z, int id)
	{
		int highest = -1;
		
		for (int y = 254; y >= 0; --y)
		{
			if (world.getBlockId(x, y, z) == id && world.isAirBlock(x, y + 1, z))
			{
				highest = y;
				break;
			}
		}
		
		return highest;
	}
	
	public static int getMaxHeightOfBlockWithSpaceAbove(World world, int x, int z, Integer[] ids)
	{
		int highest = -1;
		
		int y = 255;
		while (y >= 0)
		{
			--y;
			if (ArrayUtils.arrayContains(ids, (Integer) world.getBlockId(x, y, z)) && world.isAirBlock(x, y + 1, z))
			{
				highest = y;
				break;
			}
		}
		
		return highest;
	}
}