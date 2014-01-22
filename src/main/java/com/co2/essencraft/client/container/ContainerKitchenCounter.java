package com.co2.essencraft.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.client.container.slot.ESCIngredientSlot;
import com.co2.essencraft.client.container.slot.FoodContainerSlot;
import com.co2.essencraft.client.container.slot.OutputSlot;
import com.co2.essencraft.tileentity.TileEntityKitchenCounter;

public class ContainerKitchenCounter extends ContainerESC
{
	private TileEntityKitchenCounter counterEntity;
	
	public ContainerKitchenCounter(InventoryPlayer player, TileEntityKitchenCounter entity)
	{
		this.counterEntity = entity;
		
		this.bindPlayerInventory(player);
		
		//Ingredient slots
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 0, 44, 16));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 1, 62, 16));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 2, 80, 16));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 3, 26, 34));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 4, 44, 34));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 5, 62, 34));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 6, 80, 34));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 7, 98, 34));
		
		//Other slots
		this.addSlotToContainer(new FoodContainerSlot(counterEntity, 8, 44, 59));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 9, 80, 59)); //TODO make more specific slot
		this.addSlotToContainer(new OutputSlot(counterEntity, 10, 134, 34));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer)
	{
		return counterEntity.isUseableByPlayer(entityPlayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		return null; //TODO
	}
}