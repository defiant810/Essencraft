package com.co2.essencraft.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import com.co2.essencraft.client.container.slot.CuttableSlot;
import com.co2.essencraft.client.container.slot.KnifeSlot;
import com.co2.essencraft.client.container.slot.OutputSlot;
import com.co2.essencraft.tileentity.TileEntityCuttingBoard;

public class ContainerCuttingBoard extends Container
{
	private TileEntityCuttingBoard boardEntity;
	
	public ContainerCuttingBoard(InventoryPlayer player, TileEntityCuttingBoard entity)
	{
		this.boardEntity = entity;
		
		//Add the hotbar
		for (int i = 0; i < 9; ++i)
			this.addSlotToContainer(new Slot(player, i, 8 + (i * 18), 142));
		
		//Add the rest of the player inventory
		for (int y = 0; y < 3; ++y)
			for (int x = 0; x < 9; ++x)
				this.addSlotToContainer(new Slot(player, 9 + x + (y * 9), 8 + (x * 18), 84 + (y * 18)));
		
		//Add the three custom gui slots
		this.addSlotToContainer(new KnifeSlot(boardEntity, 0, 62, 26));
		this.addSlotToContainer(new CuttableSlot(boardEntity, 1, 62, 44));
		this.addSlotToContainer(new OutputSlot(boardEntity, 2, 98, 35));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return boardEntity.isUseableByPlayer(player);
	}
}