package com.co2.essencraft.config;

import net.minecraftforge.common.Configuration;

import java.io.File;

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
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			con.save();
		}
	}
}