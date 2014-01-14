package com.co2.essencraft.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class VineSupportSimpleRenderer implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{		
		Icon icon = block.getBlockTexture(world, x, y, z, 0);
		
		renderer.setOverrideBlockTexture(icon);
		final boolean rendered = renderer.renderBlockCrops(block, x, y, z);
		renderer.clearOverrideBlockTexture();
		
		return rendered;
	}

	@Override
	public boolean shouldRender3DInInventory() 
	{
		return false;
	}

	@Override
	public int getRenderId() 
	{
		return 0;
	}

}