package com.co2.essencraft.block;

import java.util.ArrayList;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import com.co2.essencraft.lib.StringLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlant extends BlockCropESC{

	private static final int GROWTH_STAGES = 7;
	
	public BlockPlant (int id, float growthRate, int seedId, int seedMeta, int dropId, int dropMeta, int dropAmt){
		super(id, growthRate, seedId, seedMeta, dropId, dropMeta);
		this.dropAmt = dropAmt; // amount dropped when harvested grown
	}
	
	@Override
	protected float getGrowthRate(World par1World, int par2, int par3, int par4)
	{
		//I think the higher the value the faster it grows
		return 1.0f;
	}
	
	@Override
	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (meta >= (GROWTH_STAGES - 1))
		{
			if(world.isRemote)
				return true;
			
			world.setBlockMetadataWithNotify(x, y, z, (GROWTH_STAGES - 2), 2);
			EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(this.dropId, this.dropAmt, this.dropMeta));
			world.spawnEntityInWorld(entityitem);
			if (!(player instanceof FakePlayer))
				entityitem.onCollideWithPlayer(player);
			return true;
		}
		
		return false;
	}
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        
        //Force at least one seed to drop
        drops.add(new ItemStack(this.seedId, 1, this.seedMeta));

        //If the plant is fully grown drops  
        if (metadata >= (GROWTH_STAGES - 1))
        {
        	drops.add(new ItemStack(this.seedId, 1, this.seedMeta));
        	drops.add(new ItemStack(this.dropId, 1, this.dropMeta));
        }

        return drops;
	}
	
	@Override
	public int getRenderType()
	{
		return 1;
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
