package com.co2.essencraft.proxy;

import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;
import com.co2.essencraft.tileentity.TileEntityVineSupport;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy 
{
	@Override
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityVineSupport.class, "tile." + StringLib.VINE_SUPPORT_NAME);
		GameRegistry.registerTileEntity(TileEntityCuttingBoard.class, "tile." + StringLib.CUTTING_BOARD_NAME);
	}
}