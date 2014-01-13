package com.co2.essencraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVineSupport extends TileEntity
{
	/* 0 = empty, 1 = growing, 2 = grown, 3 = flowered */
	public int growthStage;
	public int type;
	
	public TileEntityVineSupport()
	{
		growthStage = 0;
		type = -1;
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
