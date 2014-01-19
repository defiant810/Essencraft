package com.co2.essencraft.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.co2.essencraft.client.container.ContainerCuttingBoard;
import com.co2.essencraft.lib.GuiIds;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;

import cpw.mods.fml.common.network.IGuiHandler;

public class ECGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch (id)
		{
		case GuiIds.CUTTING_BOARD:
			if (entity instanceof TileEntityCuttingBoard)
				return new ContainerCuttingBoard(player.inventory, (TileEntityCuttingBoard) entity);
			else
				return null;
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		switch (id)
		{
		case GuiIds.CUTTING_BOARD:
			if (entity instanceof TileEntityCuttingBoard)
				return new GuiCuttingBoard(player.inventory, (TileEntityCuttingBoard) entity);
			else
				return null;
		default:
			return null;
		}
	}
}