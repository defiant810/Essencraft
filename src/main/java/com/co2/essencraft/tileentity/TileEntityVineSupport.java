package com.co2.essencraft.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVineSupport extends TileEntity
{
	/* 0 = empty, 1 = growing, 2 = grown, 3 = flowered */
	private int lastGS;
	private int lastT;
	public int growthStage;
	public int type;
	
	public TileEntityVineSupport()
	{
		growthStage = 0;
		lastGS = 0;
		type = -1;
		lastT = -1;
	}
	
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
    	super.readFromNBT(nbt);
    	this.growthStage = nbt.getInteger("growthStage");
    	this.type = nbt.getInteger("type");
	}	

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger("growthStage", growthStage);
		nbt.setInteger("type", type);
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	}
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData data)
	{
		this.readFromNBT(data.data);
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		//If minecraft has finished loading the world and there is a difference in data
		if (Minecraft.getMinecraft().theWorld != null && ((lastGS != growthStage) || (lastT != type)))
			Minecraft.getMinecraft().renderGlobal.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}
}
