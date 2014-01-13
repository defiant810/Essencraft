package com.co2.essencraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockVine;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import tileentity.TileEntityVineSupport;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVineSupportESC extends BlockVine
{

	public BlockVineSupportESC(int id){
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
        return 0;//ColorizerFoliage.getFoliageColorBasic();
    }

	//only drops FruitItems if vine has fruit
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
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
	
    /* Right-click harvests berries */
    @Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        /*if (world.isRemote)
                return false;*/

        TileEntityVineSupport t = (TileEntityVineSupport) world.getBlockTileEntity(x, y, z);
        
        if (t.growthStage >= 15)
        {
            if (world.isRemote)
                return true;
    
            t.growthStage = 6;
            EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(ItemIds.FRUIT, 1, t.type));
            world.spawnEntityInWorld(entityitem);
            if (!(player instanceof FakePlayer))
                entityitem.onCollideWithPlayer(player);
            return true;
        }
        return false;
    }
	
    public boolean hasTileEntity(int metadat)
    {
    	return true;
    }
    
    public TileEntityVineSupport createNewTileEntity(World par1World)
    {
    	try
    	{
    		return new TileEntityVineSupport();
    	
    	}
    	catch (Exception var3) 
    	{
    		throw new RuntimeException(var3);
    	}
    }
    
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
		TileEntityVineSupport t = (TileEntityVineSupport) par1World.getBlockTileEntity(par2, par3, par4);
		TileEntityVineSupport t2 = (TileEntityVineSupport) par1World.getBlockTileEntity(par2, par3 + 1, par4);
		int stage = t.growthStage;
		
		if ((par1World.getBlockId(par2, par3 + 1, par4) == this.blockID) && t2.growthStage == 0)
        {
            int l;

            for (l = 1; par1World.getBlockId(par2, par3 - l, par4) == this.blockID; ++l)
            {
                ;
            }

            if (l < 10)
            {
                if (stage == 5)
                {
                    par1World.setBlock(par2, par3 + 1, par4, this.blockID);
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
                    t.growthStage++;
                }
                else
                {
                	t.growthStage++;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, stage + 1, 3);
                }
            }
        }
		else if (stage <= 15)
				t.growthStage++;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {	
		String name = par1IBlockAccess.getBlockTileEntity(par2, par3, par4).getTexture();
		String file = name.toUpperCase().charAt(0) + name.substring(1);
		this.blockIcon = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + file);
		return this.blockIcon;
    }
}
