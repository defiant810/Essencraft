package com.co2.essencraft.config;

import java.io.File;
import java.util.logging.Level;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.lib.StringLib;

import net.minecraftforge.common.Configuration;
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
			/*
			BlockIds.SALT_BLOCK = con.getBlock(StringLib.SALT_BLOCK_NAME, BlockIds.SALT_BLOCK_DEFAULT).getInt(BlockIds.SALT_BLOCK_DEFAULT);
			BlockIds.RYE_CROP = con.getBlock(StringLib.RYE_CROP_NAME, BlockIds.RYE_CROP_DEFAULT).getInt(BlockIds.RYE_CROP_DEFAULT);*/
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
			/*
			ItemIds.RAW_SALT_PILE = con.getItem(StringLib.RAW_SALT_PILE_NAME, ItemIds.RAW_SALT_PILE_DEFAULT).getInt(ItemIds.RAW_SALT_PILE_DEFAULT);
			ItemIds.COCONUT = con.getItem(StringLib.COCONUT_NAME, ItemIds.COCONUT_DEFAULT).getInt(ItemIds.COCONUT_DEFAULT);
			ItemIds.KIWI = con.getItem(StringLib.KIWI_NAME, ItemIds.KIWI_DEFAULT).getInt(ItemIds.KIWI_DEFAULT);
			ItemIds.RYE = con.getItem(StringLib.RYE_NAME, ItemIds.RYE_DEFAULT).getInt(ItemIds.RYE_DEFAULT);
			ItemIds.FRUIT = con.getItem("fruit", ItemIds.FRUIT_DEFAULT).getInt(ItemIds.FRUIT_DEFAULT);
			ItemIds.HERB = con.getItem("herb", ItemIds.HERB_DEFAULT).getInt(ItemIds.HERB_DEFAULT);*/
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