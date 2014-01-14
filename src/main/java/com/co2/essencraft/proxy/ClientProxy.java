package com.co2.essencraft.proxy;

import com.co2.essencraft.lib.RenderIds;
import com.co2.essencraft.renderer.VineSupportSimpleRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy 
{
	@Override
	public void registerRenderers() 
	{
		RenderIds.VINE_SUPPORT_SIMPLE = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(RenderIds.VINE_SUPPORT_SIMPLE, new VineSupportSimpleRenderer());
	}
}