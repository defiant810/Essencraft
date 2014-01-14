package com.co2.essencraft.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import com.co2.essencraft.block.BlockVineSupport;
import com.co2.essencraft.tileentity.TileEntityVineSupport;

public class VineSupportRenderer extends TileEntitySpecialRenderer
{
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
	{
		if (!(tileEntity instanceof TileEntityVineSupport))
			return;
		
		TileEntityVineSupport ent = (TileEntityVineSupport) tileEntity;
        
        Icon icon = ((BlockVineSupport)ent.blockType).getVineTexture(ent);
        
        //TODO: Make the silly thing work
	}
}