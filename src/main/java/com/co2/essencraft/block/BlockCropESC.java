package com.co2.essencraft.block;

import java.util.ArrayList;
import java.util.Random;

import com.co2.essencraft.lib.StringLib;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCropESC extends BlockFlower
{
	protected static final int GROWTH_STAGES = 8;
	
	@SideOnly(Side.CLIENT)
    public Icon[] icons;
	
	protected float growthRate;
	protected final int seedId; //Id of the seed dropped
	protected final int seedMeta; //Metadata of the seed dropped
	protected final int dropId; //Id of the grain item dropped
	protected final int dropMeta; //Meta of the grain item dropped
	protected int dropAmt = 1; //The amount of grain item dropped
	
	public BlockCropESC(int id, float growthRate, int seedId, int seedMeta, int dropId, int dropMeta)
	{
		super(id);
		this.growthRate = growthRate;
		this.seedId = seedId;
		this.seedMeta = seedMeta;
		this.dropId = dropId;
		this.dropMeta = dropMeta;
		setTickRandomly(true);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	protected boolean canThisPlantGrowThisBlockID(int par1)
	{
		return par1 == Block.tilledField.blockID;
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		growthRate = this.getGrowthRate(par1World, par2, par3, par4);
		if(par1World.getBlockLightValue(par2, par3 + 1, par4) >= 0)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			
			if(l < 7)
			{
				//float f = this.getGrowthRate(par1World, par2, par3, par4); replaced with growthRate variable
				if(par5Random.nextInt((int)(25.0F / growthRate) + 1) == 0)
				{
					++l;
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
				}
			}
		}
	}
	
	/**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
	private float getGrowthRate(World par1World, int par2, int par3, int par4)
	{
		float f = 1.0f;
        int l = par1World.getBlockId(par2, par3, par4 - 1);
        int i1 = par1World.getBlockId(par2, par3, par4 + 1);
        int j1 = par1World.getBlockId(par2 - 1, par3, par4);
        int k1 = par1World.getBlockId(par2 + 1, par3, par4);
        int l1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int i2 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int j2 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int k2 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean flag = j1 == this.blockID || k1 == this.blockID;
        boolean flag1 = l == this.blockID || i1 == this.blockID;
        boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

        for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2)
        {
            for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3)
            {
                int j3 = par1World.getBlockId(l2, par3 - 1, i3);
                float f1 = 0.0F;

                if (blocksList[j3] != null && blocksList[j3].canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this))
                {
                    f1 = 1.0F;

                    if (blocksList[j3].isFertile(par1World, l2, par3 - 1, i3))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l2 != par2 || i3 != par4)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f * this.growthRate;
	}
	
	@Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        //Force at least one seed to drop
        ret.add(new ItemStack(this.seedId, 1, this.seedMeta));

        //If the plant is fully grown
        if (metadata >= 7)
        {
        	//Force it to drop a grain item
        	ret.add(new ItemStack(this.dropId, this.dropAmt, this.dropMeta));
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(this.seedId, 1, this.seedMeta));
                }
            }
        }

        return ret;
    }
	
	@Override
	public int getRenderType()
	{
		return 6;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(meta < 0 || meta > 7)
			meta = 7;
		
		return icons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[GROWTH_STAGES];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + this.textureName + "stage0" + i);
	}
}
