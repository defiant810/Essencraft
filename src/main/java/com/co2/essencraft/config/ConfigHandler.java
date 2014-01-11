package com.co2.essencraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

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
			ItemIds.SEASONING = con.getItem("Seasoning", ItemIds.SEASONING_DEFAULT).getInt(ItemIds.SEASONING_DEFAULT);
			ItemIds.VEGETABLE = con.getItem("Vegetable", ItemIds.VEGETABLE_DEFAULT).getInt(ItemIds.VEGETABLE_DEFAULT);
			ItemIds.RYE_SEED = con.getItem("Rye Seed", ItemIds.RYE_SEED_DEFAULT).getInt(ItemIds.RYE_SEED_DEFAULT);
			ItemIds.RYE_CROP = con.getItem("Rye Crop", ItemIds.RYE_CROP_DEFAULT).getInt(ItemIds.RYE_CROP_DEFAULT);
			ItemIds.OAT_SEED = con.getItem("Oat Seed", ItemIds.OAT_SEED_DEFAULT).getInt(ItemIds.OAT_SEED_DEFAULT);
			ItemIds.OAT_CROP = con.getItem("Oat Crop", ItemIds.OAT_CROP_DEFAULT).getInt(ItemIds.OAT_CROP_DEFAULT);
			ItemIds.BARLEY_SEED = con.getItem("Barley Seed", ItemIds.BARLEY_SEED_DEFAULT).getInt(ItemIds.BARLEY_SEED_DEFAULT);
			ItemIds.BARLEY_CROP = con.getItem("Barley Crop", ItemIds.BARLEY_CROP_DEFAULT).getInt(ItemIds.BARLEY_CROP_DEFAULT);
			ItemIds.CORN_SEED = con.getItem("Corn Seed", ItemIds.CORN_SEED_DEFAULT).getInt(ItemIds.CORN_SEED_DEFAULT);
			ItemIds.CORN_CROP = con.getItem("Corn Crop", ItemIds.CORN_CROP_DEFAULT).getInt(ItemIds.CORN_CROP_DEFAULT);
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