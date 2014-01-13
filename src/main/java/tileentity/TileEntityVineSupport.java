package tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVineSupport extends TileEntity{

	public int growthStage = 0;
	public int type = 0;
	private static final String[] TEXTURE = {"VineSupport", "VineGrowing", "VineGrape"}; 
	
	public String getTexture()
	{
		return TEXTURE[type];
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
