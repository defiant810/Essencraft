package com.co2.essencraft.block;

import java.util.ArrayList;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBush extends BlockCropESC{

	public BlockBush(int id, float growthRate, int seedId, int seedMeta, int dropId, int dropMeta)
	{
		super(id, growthRate, seedId, seedMeta, dropId, dropMeta);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
	}
	
	protected boolean canThisPlantGrowThisBlockID(int id)
	{	
		int dirt = Block.dirt.blockID;
		int grass = Block.grass.blockID;
		return id == dirt || id == grass;
	}
	
	//not sure that updateTick needs to be override, just the methods it calls
	
	//super getGrowthRate encourages rows, not sure yet how we want growth rate to be determined for a bush
	// possibly slower if it has more bushes around it?
	private float getGrowthRate(World world, int x, int y, int z)
	{
		return 1.0f;
	}
	
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        //Force at least one seed to drop
        ret.add(new ItemStack(this.seedId, 1, this.seedMeta));

        //If the plant is fully grown//change this section down 
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
	
	//Apply bonemeal to the crops.
	public void fertilize(World world, int x, int y, int z)
	{
        int l = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
	
	@Override
	public int getRenderType()
	{
		return 1; //not sure on this need to double check
	}
	
	//need to modify for this class
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(meta < 0 || meta > 7)
			meta = 7;
		
		return icons[meta];
	}
	
	//need to modify for this class
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[GROWTH_STAGES];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + this.textureName + "stage0" + i);
	}
}
