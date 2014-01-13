package com.co2.essencraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVineSupport extends TileEntity
{
	public int growthStage;
	public int type;
	
	public TileEntityVineSupport()
	{
		growthStage = 0;
		type = 0;
	}
	
	public int getGrowthStage()
	{
		return growthStage;
	}
	
	public int getType()
	{
		return type;
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
}
