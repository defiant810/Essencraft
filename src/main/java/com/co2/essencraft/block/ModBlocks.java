package com.co2.essencraft.block;

import net.minecraft.item.Item;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks 
{
	public static BlockCropESC ryeCrop;
	public static BlockCropESC barleyCrop;
	
	public static void init()
	{
		ryeCrop = (BlockCropESC) new BlockCropESC(BlockIds.RYE_CROP, 1.0f, ItemIds.SEED, 4/*rye seed meta*/, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: rye metadata*/)
			.setTextureName("GrainRye");
		barleyCrop = (BlockCropESC) new BlockCropESC(BlockIds.BARLEY_CROP, 1.0f, ItemIds.SEED, 0, Item.wheat.itemID, 0)
			.setTextureName("GrainBarley");
		
		GameRegistry.registerBlock(ryeCrop, "tile." + StringLib.RYE_CROP_NAME);
		GameRegistry.registerBlock(barleyCrop, "tile." + StringLib.BARLEY_CROP_NAME);
		
		LanguageRegistry.addName(ryeCrop, "Rye Crop");
		LanguageRegistry.addName(barleyCrop, "Barley Crop");
	}
}