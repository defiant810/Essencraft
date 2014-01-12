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
	public static BlockCropESC oatCrop;
	public static BlockCropESC riceCrop;
	public static BlockCropESC hopCrop;
	public static BlockCropESC cornCrop;
	
	public static void init()
	{
		ryeCrop = (BlockCropESC) new BlockCropESC(BlockIds.RYE_CROP, 1.0f, ItemIds.SEED, 4/*rye seed meta*/, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: rye metadata*/)
			.setTextureName("GrainRye");
		barleyCrop = (BlockCropESC) new BlockCropESC(BlockIds.BARLEY_CROP, 1.0f, ItemIds.SEED, 0, Item.wheat.itemID, 0)
			.setTextureName("GrainBarley");
		oatCrop = (BlockCropESC) new BlockCropESC(BlockIds.OAT_CROP, 1.0f, ItemIds.SEED, 3, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: oat metadata*/)
		.setTextureName("GrainOat");
		riceCrop = (BlockCropESC) new BlockCropESC(BlockIds.RICE_CROP, 1.0f, ItemIds.SEED, 5, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: rice metadata*/)
		.setTextureName("GrainRice");
		hopCrop = (BlockCropESC) new BlockCropESC(BlockIds.HOP_CROP, 1.0f, ItemIds.SEED, 2, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: hop metadata*/)
		.setTextureName("GrainHop");
		cornCrop = (BlockCropESC) new BlockCropESC(BlockIds.CORN_CROP, 1.0f, ItemIds.SEED, 1, Item.wheat.itemID/*TODO: Grain id*/, 0/*TODO: corn metadata*/)
		.setTextureName("GrainCorn");
		
		GameRegistry.registerBlock(ryeCrop, "tile." + StringLib.RYE_CROP_NAME);
		GameRegistry.registerBlock(barleyCrop, "tile." + StringLib.BARLEY_CROP_NAME);
		
		LanguageRegistry.addName(ryeCrop, "Rye Crop");
		LanguageRegistry.addName(barleyCrop, "Barley Crop");
	}
}