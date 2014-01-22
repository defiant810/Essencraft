package com.co2.essencraft.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.co2.essencraft.Essencraft;
import com.co2.essencraft.lib.GuiIds;
import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.tileentity.TileEntityKitchenCounter;

import cpw.mods.fml.common.network.FMLNetworkHandler;

public class BlockKitchenCounter extends BlockESC implements ITileEntityProvider
{
	public BlockKitchenCounter(int id)
	{
		super(id, Material.iron);
		this.setUnlocalizedName("tile." + StringLib.KITCHEN_COUNTER_NAME);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote && world.isAirBlock(x, y + 1, z))
			FMLNetworkHandler.openGui(player, Essencraft.instance, GuiIds.KITCHEN_COUNTER, world, x, y, z);
		
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta)
	{
		return new TileEntityKitchenCounter();
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}