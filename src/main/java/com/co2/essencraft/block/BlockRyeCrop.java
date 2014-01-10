package com.co2.essencraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.co2.essencraft.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRyeCrop extends BlockESC
{
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public BlockRyeCrop(int id)
	{
		super(id, Material.plants);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
		setTickRandomly(true);
	}
	
	/**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
	public boolean canThisPlantGrowThisBlockID(int par1)
	{
		return par1 == Block.tilledField.blockID;
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);
		
		if(par1World.getBlockLightValue(par2, par3 + 1, par4) >= 0)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			
			if(l < 7)
			{
				float f = this.getGrowthRate(par1World, par2, par3, par4);
				if(par5Random.nextInt((int)(25.0F / f) + 1) == 0)
				{
					++l;
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
				}
			}
		}
	}
	
	private float getGrowthRate(World par1World, int par2, int par3, int par4)
	{
		float f = 1.0F;
		return f;
	}
    
	/**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		if(par2 < 0 || par2 > 7)
		{
			par2 = 7;
		}
		return this.iconArray[par2];
	}
	
	/**
     * The type of render function that is called for this block
     */
	public int getRenderType()
	{
		return 6;
	}
	
	/**
     * Generate a seed ItemStack for this crop.
     */
	public int getSeedItem()
	{
		return Item.seeds.itemID;
	}
	
	/**
     * Generate a crop produce ItemStack for this crop.
     */
	public int getCropItem()
	{
		return ItemIds.RYE;
	}
	
	/**
     * Drops the block items with a specified chance of dropping the specified items
     */
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
	}
	
	@Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

        if (metadata >= 7)
        {
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(this.getSeedItem(), 1, 0));
                }
            }
        }

        return ret;
    }
	
	/**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return par1 == 7 ? this.getCropItem() : this.getSeedItem();
    }
   
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[8];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }
}
