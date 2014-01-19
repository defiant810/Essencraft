package com.co2.essencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.co2.essencraft.Essencraft;
import com.co2.essencraft.lib.GuiIds;
import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;

import cpw.mods.fml.common.network.FMLNetworkHandler;

public class BlockCuttingBoard extends Block implements ITileEntityProvider
{
	public BlockCuttingBoard(int id)
	{
		super(id, Material.wood);
		this.setUnlocalizedName("tile." + StringLib.CUTTING_BOARD_NAME);
		this.setHardness(0.05f);
		this.setResistance(0.05f);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		System.out.println("Block activated.");
		if (!world.isRemote)
		{
			System.out.println("Attempting to open gui.");
			FMLNetworkHandler.openGui(player, Essencraft.instance, GuiIds.CUTTING_BOARD, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta)
	{
		return new TileEntityCuttingBoard();
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}
}