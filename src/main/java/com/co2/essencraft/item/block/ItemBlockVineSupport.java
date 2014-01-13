package com.co2.essencraft.item.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockVineSupport extends ItemBlock
{
	private int blockID;
	
	public ItemBlockVineSupport(int id, int blockId)
	{
		super(id);
		this.blockID = blockId;
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int b = par3World.getBlockId(par4, par5, par6);
		int m = par3World.getBlockMetadata(par4, par5, par6);
		
		//If its tilled field and fertile
		if (b == Block.tilledField.blockID && m > 0 && par7 == 1)
		{
			par3World.setBlock(par4, par5 + 1, par6, blockID, 0, 3);
			--par1ItemStack.stackSize;
			return true;
		}
		
		return false;
	}
}