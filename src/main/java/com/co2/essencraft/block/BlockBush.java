package com.co2.essencraft.block;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import com.co2.essencraft.lib.StringLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBush extends BlockCropESC{

	protected static final int GROWTH_STAGES = 7;
	
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
	
	@SuppressWarnings("unused")
	private float getGrowthRate(World world, int x, int y, int z)
	{
		return 1.0f;
	}
	
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int meta = world.getBlockMetadata(x, y, z);
		
		if (meta == (GROWTH_STAGES - 1))
		{
			if(world.isRemote)
				return true;
			
			world.setBlockMetadataWithNotify(x, y, z, (GROWTH_STAGES - 2), 2);
			EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(this.dropId, 1, this.dropMeta));
			world.spawnEntityInWorld(entityitem);
			if (!(player instanceof FakePlayer))
				entityitem.onCollideWithPlayer(player);
			world.markBlockForUpdate(x, y, z); // is this needed? since this is are using meta data and not tile entity
			return true;
		}
		
		return false;
	}
	
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        
        //Force at least one seed to drop
        drops.add(new ItemStack(this.seedId, 1, this.seedMeta));

        //If the plant is fully grown//change this section down 
        if (metadata >= (GROWTH_STAGES - 1))
        {
        	//Force it to drop a grain item
        	drops.add(new ItemStack(this.dropId, this.dropAmt, this.dropMeta));
        }

        return drops;
	}
	
	//Apply bonemeal to the crops.
	public void fertilize(World world, int x, int y, int z)
	{
        int num = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (num > (GROWTH_STAGES - 1))
        {
            num = GROWTH_STAGES - 1;
        }

        world.setBlockMetadataWithNotify(x, y, z, num, 2);
	}
	
	@Override
	public int getRenderType()
	{
		return 1; //not sure on this need to double check
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(meta < 0 || meta > (GROWTH_STAGES - 1))
			meta = (GROWTH_STAGES - 1);
		
		return icons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[GROWTH_STAGES];
		for (int i = 0; i < icons.length - 1; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "blockBushstage0" + i);
		
		icons[GROWTH_STAGES - 1] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "block" + this.textureName + "stage0" + (GROWTH_STAGES - 1)); 
	}
}
