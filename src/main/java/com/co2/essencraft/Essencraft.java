package com.co2.essencraft;

import java.io.File;

import com.co2.essencraft.block.ModBlocks;
import com.co2.essencraft.config.ConfigHandler;
import com.co2.essencraft.item.ModItems;
import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.proxy.IProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Essencraft 
{
	@Instance(value = Reference.MOD_ID)
	public static Essencraft instance; 
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Set version number
		event.getModMetadata().version = Reference.MOD_VERSION;
		
		//Init config
		ConfigHandler.init(event.getModConfigurationDirectory() + File.separator + Reference.MOD_ID.toLowerCase() + File.separator);
		
		//Init mod blocks
		ModBlocks.init();
		
		//Init mod items
		ModItems.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Initialize custom rendering (client only)
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}