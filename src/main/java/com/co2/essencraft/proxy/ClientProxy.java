package com.co2.essencraft.proxy;

import com.co2.essencraft.lib.RenderIds;
import com.co2.essencraft.render.VineSupportRenderer;
import com.co2.essencraft.tileentity.TileEntityVineSupport;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerRenderers() 
	{
		RenderIds.VINE_SUPPORT = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVineSupport.class, new VineSupportRenderer());
	}
}