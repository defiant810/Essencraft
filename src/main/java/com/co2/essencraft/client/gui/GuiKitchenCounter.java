package com.co2.essencraft.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.co2.essencraft.client.container.ContainerKitchenCounter;
import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.tileentity.TileEntityKitchenCounter;

public class GuiKitchenCounter extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/kitchenCounter.png");
	
	public GuiKitchenCounter(InventoryPlayer player, TileEntityKitchenCounter entity)
	{
		super(new ContainerKitchenCounter(player, entity));
		
		this.xSize = 176;
		this.ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
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
		fontRenderer.drawString("Kitchen Counter", 5, 4, 4210752);
	}
}