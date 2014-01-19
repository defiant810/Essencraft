package com.co2.essencraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.co2.essencraft.client.container.ContainerCuttingBoard;
import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;

public class GuiCuttingBoard extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/cuttingBoard.png");
	
	public GuiCuttingBoard(InventoryPlayer player, TileEntityCuttingBoard entity)
	{
		super(new ContainerCuttingBoard(player, entity));
		
		this.xSize = 176;
		this.ySize = 165;
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		this.mc.getTextureManager().bindTexture(texture);
		
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		
		drawTexturedModalRect(xStart, yStart, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString("Cutting Board", 8, 6, 4210752);
	}
}