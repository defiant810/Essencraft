package com.co2.essencraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVineESC extends BlockVine
{

	public BlockVineESC(int id){
		super(id);
		//set creative tab
	}
	
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return 0;
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    public int getRenderColor(int par1)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return 0;
	}
	
	public int quatityDropped(Random par1Random)
	{
		return 1;
	}
	
	@Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
    }
	/*
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && par1World.rand.nextInt(4) == 0)
        {
            byte b0 = 4;
            int l = 5;
            boolean flag = false;
            int i1;
            int j1;
            int k1;
            label138:

            for (i1 = par2 - b0; i1 <= par2 + b0; ++i1)
            {
                for (j1 = par4 - b0; j1 <= par4 + b0; ++j1)
                {
                    for (k1 = par3 - 1; k1 <= par3 + 1; ++k1)
                    {
                        if (par1World.getBlockId(i1, k1, j1) == this.blockID)
                        {
                            --l;

                            if (l <= 0)
                            {
                                flag = true;
                                break label138;
                            }
                        }
                    }
                }
            }

            i1 = par1World.getBlockMetadata(par2, par3, par4);
            j1 = par1World.rand.nextInt(6);
            k1 = Direction.facingToDirection[j1];
            int l1;
            int i2;

            if (j1 == 1 && par3 < 255 && par1World.isAirBlock(par2, par3 + 1, par4))
            {
                if (flag)
                {
                    return;
                }

                l1 = par1World.rand.nextInt(16) & i1;

                if (l1 > 0)
                {
                    for (i2 = 0; i2 <= 3; ++i2)
                    {
                        if (!this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[i2], par3 + 1, par4 + Direction.offsetZ[i2])))
                        {
                            l1 &= ~(1 << i2);
                        }
                    }

                    if (l1 > 0)
                    {
                        par1World.setBlock(par2, par3 + 1, par4, this.blockID, l1, 2);
                    }
                }
            }
            else
            {
                int j2;

                if (j1 >= 2 && j1 <= 5 && (i1 & 1 << k1) == 0)
                {
                    if (flag)
                    {
                        return;
                    }

                    l1 = par1World.getBlockId(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1]);

                    if (l1 != 0 && Block.blocksList[l1] != null)
                    {
                        if (Block.blocksList[l1].blockMaterial.isOpaque() && Block.blocksList[l1].renderAsNormalBlock())
                        {
                            par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 | 1 << k1, 2);
                        }
                    }
                    else
                    {
                        i2 = k1 + 1 & 3;
                        j2 = k1 + 3 & 3;

                        if ((i1 & 1 << i2) != 0 && this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2])))
                        {
                            par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this.blockID, 1 << i2, 2);
                        }
                        else if ((i1 & 1 << j2) != 0 && this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2])))
                        {
                            par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this.blockID, 1 << j2, 2);
                        }
                        else if ((i1 & 1 << i2) != 0 && par1World.isAirBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2]) && this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[i2])))
                        {
                            par1World.setBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[i2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[i2], this.blockID, 1 << (k1 + 2 & 3), 2);
                        }
                        else if ((i1 & 1 << j2) != 0 && par1World.isAirBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2]) && this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[j2])))
                        {
                            par1World.setBlock(par2 + Direction.offsetX[k1] + Direction.offsetX[j2], par3, par4 + Direction.offsetZ[k1] + Direction.offsetZ[j2], this.blockID, 1 << (k1 + 2 & 3), 2);
                        }
                        else if (this.canBePlacedOn(par1World.getBlockId(par2 + Direction.offsetX[k1], par3 + 1, par4 + Direction.offsetZ[k1])))
                        {
                            par1World.setBlock(par2 + Direction.offsetX[k1], par3, par4 + Direction.offsetZ[k1], this.blockID, 0, 2);
                        }
                    }
                }
                else if (par3 > 1)
                {
                    l1 = par1World.getBlockId(par2, par3 - 1, par4);

                    if (l1 == 0)
                    {
                        i2 = par1World.rand.nextInt(16) & i1;

                        if (i2 > 0)
                        {
                            par1World.setBlock(par2, par3 - 1, par4, this.blockID, i2, 2);
                        }
                    }
                    else if (l1 == this.blockID)
                    {
                        i2 = par1World.rand.nextInt(16) & i1;
                        j2 = par1World.getBlockMetadata(par2, par3 - 1, par4);

                        if (j2 != (j2 | i2))
                        {
                            par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j2 | i2, 2);
                        }
                    }
                }
            }
        }
    } */
}
