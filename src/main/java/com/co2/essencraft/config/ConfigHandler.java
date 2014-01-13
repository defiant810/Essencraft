package com.co2.essencraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class ConfigHandler 
{
	public static void init(String path)
	{
		blockInit(new File(path + "block.properties"));
		itemInit(new File(path + "item.properties"));
	}
	
	private static void blockInit(File f)
	{
		Configuration con = new Configuration(f);

		try
		{
			con.load();
			
			//Load ids here
			BlockIds.RYE_CROP = con.getBlock("ryeCrop", BlockIds.RYE_CROP_DEFAULT).getInt(BlockIds.RYE_CROP_DEFAULT);
			BlockIds.OAT_CROP = con.getBlock("oatCrop", BlockIds.OAT_CROP_DEFAULT).getInt(BlockIds.OAT_CROP_DEFAULT);
			BlockIds.BARLEY_CROP = con.getBlock("barleyCrop", BlockIds.BARLEY_CROP_DEFAULT).getInt(BlockIds.BARLEY_CROP_DEFAULT);
			BlockIds.CORN_CROP = con.getBlock("cornCrop", BlockIds.CORN_CROP_DEFAULT).getInt(BlockIds.CORN_CROP_DEFAULT);
			BlockIds.RICE_CROP = con.getBlock("riceCrop", BlockIds.RICE_CROP_DEFAULT).getInt(BlockIds.RICE_CROP_DEFAULT);
			BlockIds.HOP_CROP = con.getBlock("hopCrop", BlockIds.HOP_CROP_DEFAULT).getInt(BlockIds.HOP_CROP_DEFAULT);
			BlockIds.VINE_SUPPORT = con.getBlock("vineSupport", BlockIds.VINE_SUPPORT_DEFAULT).getInt(BlockIds.VINE_SUPPORT_DEFAULT);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " cannot load its block properties configuration file.");
		}
		finally
		{
			con.save();
		}
	}
	
	private static void itemInit(File f)
	{
		Configuration con = new Configuration(f);
		
		try
		{
			con.load();
			
			//Load ids here
			ItemIds.FISH = con.getItem("fish", ItemIds.FISH_DEFAULT).getInt(ItemIds.FISH_DEFAULT);
			ItemIds.FRUIT = con.getItem("fruit", ItemIds.FRUIT_DEFAULT).getInt(ItemIds.FRUIT_DEFAULT);
			ItemIds.SEASONING = con.getItem("seasoning", ItemIds.SEASONING_DEFAULT).getInt(ItemIds.SEASONING_DEFAULT);
			ItemIds.VEGETABLE = con.getItem("vegetable", ItemIds.VEGETABLE_DEFAULT).getInt(ItemIds.VEGETABLE_DEFAULT);
			ItemIds.SEED = con.getItem("seed", ItemIds.SEED_DEFAULT).getInt(ItemIds.SEED_DEFAULT);
			ItemIds.GRAIN = con.getItem("grain", ItemIds.GRAIN_DEFAULT).getInt(ItemIds.GRAIN_DEFAULT);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " cannot load its item properties configuration file.");
		}
		finally
		{
			con.save();
		}
	}
}