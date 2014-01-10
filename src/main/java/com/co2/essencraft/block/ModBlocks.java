package com.co2.essencraft.block;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	public static BlockESC saltBlock;
	
	public static void init()
	{
		saltBlock = new BlockSaltBlock(BlockIds.SALT_BLOCK);
		
		GameRegistry.registerBlock(saltBlock, "tile." + StringLib.SALT_BLOCK_NAME);
	}
}