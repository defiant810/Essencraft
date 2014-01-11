package com.co2.essencraft.block;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	public static BlockRyeCrop ryeCrop;
	
	public static void init()
	{
		ryeCrop = new BlockRyeCrop(BlockIds.RYE_CROP, 1.0f);
		
		GameRegistry.registerBlock(ryeCrop, "tile." + StringLib.RYE_CROP_NAME);
	}
}