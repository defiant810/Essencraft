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
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 0, 43, 15));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 1, 61, 15));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 2, 79, 15));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 3, 25, 33));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 4, 43, 33));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 5, 61, 33));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 6, 79, 33));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 7, 97, 33));
		
		//Other slots
		this.addSlotToContainer(new FoodContainerSlot(counterEntity, 8, 43, 58));
		this.addSlotToContainer(new ESCIngredientSlot(counterEntity, 9, 79, 58)); //TODO make more specific slot
		this.addSlotToContainer(new OutputSlot(counterEntity, 10, 133, 33));
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