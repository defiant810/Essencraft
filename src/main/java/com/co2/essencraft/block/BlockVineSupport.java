package com.co2.essencraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;

import com.co2.essencraft.lib.StringLib;
import com.co2.essencraft.tileentity.TileEntityVineSupport;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVineSupport extends Block
{
	private static final String[] TEXTURES = { "VineSupport", "VineGrowing", "VineGrown", "VineGrape", "VineKiwi", "vineBlackPepper", "VineGreenBean",
		"VineSoyBean", "vinePea", "VineTomato", "VineStrawberry", "VineDecorative" };
	//0 = chance to grow from Growing -> Grown, 1+ = chances for growing for different things, starting with Grape 
	private static final float[] PERCENT_CHANCE = { 0.25f, 0.1f, };
	//{grape, kiwi, black pepper, green bean, soy bean, pea, tomato, strawberry, decorative}
	private static final int[] DROP_IDS = { 19501, 19501, 19503, 19502, 19502, 19502, 19502, 19501 };
	private static final int[] DROP_METADATA = { 5, 6, 5, 0, 1, 9, 17, 16 };
	private static final int[] MAX_VINE_HEIGHT = { 10, 4, 4, 3, 2, 3, 3, 1 }; 
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
		
	public BlockVineSupport(int id)
	{
		super(id, Material.wood);
		//set creative tab
	}
	
    /* Right-click harvests berries */
    @Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote || !(world.getBlockTileEntity(x, y, x) instanceof TileEntityVineSupport))
                return false;

        TileEntityVineSupport t = (TileEntityVineSupport) world.getBlockTileEntity(x, y, z);
        
        if (t.growthStage == 3)
        {
            t.growthStage = 2;
            EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(DROP_IDS[t.type], 1, DROP_METADATA[t.type]));
            world.spawnEntityInWorld(entityitem);
            if (!(player instanceof FakePlayer))
                entityitem.onCollideWithPlayer(player);
            return true;
        }
        return false;
    }
    
    @Override
	public void updateTick(World world, int x, int y, int z, Random random)
    {
    	if (!(world.getBlockTileEntity(x, y, z) instanceof TileEntityVineSupport))
    		return;
    	
    	TileEntityVineSupport t = (TileEntityVineSupport) world.getBlockTileEntity(x, y, z);
    	TileEntityVineSupport t2 = null;
    	if (world.getBlockTileEntity(x, y + 1, z) instanceof TileEntityVineSupport)
    		t2 = (TileEntityVineSupport) world.getBlockTileEntity(x, y + 1, z);
    	
    	int stage = t.growthStage;
    	int type = t.type;
    	int plantHeight;
    	for (plantHeight = 1; world.getBlockId(x, y - plantHeight, z) == this.blockID; ++plantHeight)
        {
            ;
        }
    	//Run updates on this block
    	if (stage == 1 && random.nextFloat() < PERCENT_CHANCE[0])
    		t.growthStage++;
    	else if (stage == 2)
    	{
    		if (random.nextFloat() < PERCENT_CHANCE[type - 2])
    			t.growthStage++;
    		
    		//Sees if the vine here spreads to the one above it
    		if (t2 != null && t2.growthStage == 0 && random.nextFloat() < 0.25 && plantHeight < MAX_VINE_HEIGHT[t.type])
    		{
    			t2.growthStage = 1;
    			t2.type = t.type;
    		}		
    	}
    }
    
    @Override
    public boolean hasTileEntity(int meta)
    {
    	return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
    	return new TileEntityVineSupport();
    }
    
    @Override
    public int getRenderType()
    {
    	return 6;
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
		
		return icons[entity.type];
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
