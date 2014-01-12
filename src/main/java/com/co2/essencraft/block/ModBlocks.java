package com.co2.essencraft.block;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks 
{
	public static BlockCropESC barleyCrop;
	public static BlockCropESC cornCrop;
	public static BlockCropESC hopCrop;
	public static BlockCropESC oatCrop;
	public static BlockCropESC ryeCrop;
	public static BlockCropESC riceCrop;
	
	public static void init()
	{
		barleyCrop = (BlockCropESC) new BlockCropESC(BlockIds.BARLEY_CROP, 1.0f, ItemIds.SEED, 0, ItemIds.GRAIN, 0).setTextureName("GrainBarley");
		cornCrop = (BlockCropESC) new BlockCropESC(BlockIds.CORN_CROP, 1.0f, ItemIds.SEED, 1, ItemIds.GRAIN, 1).setTextureName("GrainCorn");
		hopCrop = (BlockCropESC) new BlockCropESC(BlockIds.HOP_CROP, 1.0f, ItemIds.SEED, 2, ItemIds.GRAIN, 2).setTextureName("GrainHop");
		oatCrop = (BlockCropESC) new BlockCropESC(BlockIds.OAT_CROP, 1.0f, ItemIds.SEED, 3, ItemIds.GRAIN, 3).setTextureName("GrainOat");
		ryeCrop = (BlockCropESC) new BlockCropESC(BlockIds.RYE_CROP, 1.0f, ItemIds.SEED, 4, ItemIds.GRAIN, 4).setTextureName("GrainRye");
		riceCrop = (BlockCropESC) new BlockCropESC(BlockIds.RICE_CROP, 1.0f, ItemIds.SEED, 5, ItemIds.GRAIN, 5).setTextureName("GrainRice");
		
		//GameRegistry
		GameRegistry.registerBlock(barleyCrop, "tile." + StringLib.BARLEY_CROP_NAME);
		GameRegistry.registerBlock(cornCrop, "tile." + StringLib.CORN_CROP_NAME);
		GameRegistry.registerBlock(hopCrop, "tile." + StringLib.HOP_CROP_NAME);
		GameRegistry.registerBlock(oatCrop, "tile." + StringLib.OAT_CROP_NAME);
		GameRegistry.registerBlock(ryeCrop, "tile." + StringLib.RYE_CROP_NAME);
		GameRegistry.registerBlock(riceCrop, "tile." + StringLib.RICE_CROP_NAME);
		
		//LanguageRegistry
		LanguageRegistry.addName(ryeCrop, "Rye Crop");
		LanguageRegistry.addName(barleyCrop, "Barley Crop");
	}
}