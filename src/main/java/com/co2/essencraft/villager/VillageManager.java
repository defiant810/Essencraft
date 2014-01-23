package com.co2.essencraft.villager;

import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.lib.VillagerIds;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class VillageManager 
{
	public static final ResourceLocation FRUIT_VENDOR_TEXTURE = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/entity/villagerFruitVendor.png");
	public static final ResourceLocation VEGETABLE_VENDOR_TEXTURE = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/entity/villagerVegetableVendor.png");
	public static final ResourceLocation SEED_VENDOR_TEXTURE = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/entity/villagerSeedVendor.png");
	
	public static void init()
	{
		
		/*
		//Fruit Vendor
		VillagerRegistry.instance().registerVillagerId(VillagerIds.FRUIT_VENDOR);
		VillagerRegistry.instance().registerVillageTradeHandler(VillagerIds.FRUIT_VENDOR, new VillagerESC(null)); //TODO make not null
		VillagerRegistry.instance().registerVillagerSkin(VillagerIds.FRUIT_VENDOR, FRUIT_VENDOR_TEXTURE);
		
		//Veggie Vendor
		VillagerRegistry.instance().registerVillagerId(VillagerIds.VEGETABLE_VENDOR);
		VillagerRegistry.instance().registerVillageTradeHandler(VillagerIds.VEGETABLE_VENDOR, new VillagerESC(null)); //TODO make not null
		VillagerRegistry.instance().registerVillagerSkin(VillagerIds.VEGETABLE_VENDOR, VEGETABLE_VENDOR_TEXTURE);
		*/
		
		//Seed Vendor
		VillagerRegistry.instance().registerVillagerId(VillagerIds.SEED_VENDOR);
		VillagerRegistry.instance().registerVillageTradeHandler(VillagerIds.SEED_VENDOR, new VillagerESC(new SeedVendorProvider()));
		VillagerRegistry.instance().registerVillagerSkin(VillagerIds.SEED_VENDOR, SEED_VENDOR_TEXTURE);
	}
}