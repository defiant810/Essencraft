package com.co2.essencraft.villager;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipe;

public interface IVendorRecipeProvider 
{
	public List<MerchantRecipe> makeRecipeList(EntityVillager entity, Random random);
}