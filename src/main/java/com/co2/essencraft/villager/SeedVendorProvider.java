package com.co2.essencraft.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;

import com.co2.essencraft.item.ItemSeedESC;
import com.co2.essencraft.item.ModItems;

public class SeedVendorProvider implements IVendorRecipeProvider
{
	@Override
	public List<MerchantRecipe> makeRecipeList(EntityVillager entity, Random random)
	{
		List<MerchantRecipe> rList = new ArrayList<MerchantRecipe>();
		
		for (int i = 0; i < ItemSeedESC.NUM_SEEDS; ++i)
			rList.add(new MerchantRecipe(new ItemStack(Item.emerald, getSeedValue(i)), new ItemStack(ModItems.seed, getSeedAmount(i), i)));
		
		return rList;
	}
	
	private int getSeedValue(int meta)
	{
		return 1;
	}
	
	private int getSeedAmount(int meta)
	{
		return 8;
	}
}