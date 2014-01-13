package com.co2.essencraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockVine;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;

import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.tileentity.TileEntityVineSupport;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVineSupport extends BlockVine
{
	private static final String[] TEXTURES = { "VineSupport", "VineGrowing", "VineGrown", "VineGrape" };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockVineSupport(int id)
	{
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
	
    @Override
    public boolean hasTileEntity(int metadat)
    {
    	return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
    	return new TileEntityVineSupport();
    }
    
    @Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if (par1World.getBlockTileEntity(par2, par3, par4) == null || par1World.getBlockTileEntity(par2, par3 + 1, par4) == null
    			|| !(par1World.getBlockTileEntity(par2, par3, par4) instanceof TileEntityVineSupport))
    		return;
    	
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
		if (!(par1IBlockAccess.getBlockTileEntity(par2, par3, par4) instanceof TileEntityVineSupport))
			return null;
		
		TileEntityVineSupport entity = (TileEntityVineSupport) par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
		
		return icons[entity.getType()];
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[TEXTURES.length];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + TEXTURES[i]);
	}
}
