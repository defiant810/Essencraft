package com.co2.essencraft.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillagerESC implements IVillageTradeHandler
{
	private List<IVendorRecipeProvider> recipeProviders;
	
	public VillagerESC(IVendorRecipeProvider... ivrp)
	{
		recipeProviders = new ArrayList<IVendorRecipeProvider>();
		
		for (IVendorRecipeProvider rp : ivrp)
			this.registerRecipeProvider(rp);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random)
	{
		recipeList.clear();
		
		for(IVendorRecipeProvider ivrp : this.recipeProviders)
			recipeList.addAll(ivrp.makeRecipeList(villager, random));
	}
	
	public VillagerESC registerRecipeProvider(IVendorRecipeProvider ivrp)
	{
		this.recipeProviders.add(ivrp);
		return this;
	}
}