package com.co2.essencraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.co2.essencraft.lib.BlockIds;
import com.co2.essencraft.lib.ItemIds;
import com.co2.essencraft.lib.Reference;
import com.co2.essencraft.lib.VillagerIds;
import com.co2.essencraft.lib.WorldGenSettings;

import cpw.mods.fml.common.FMLLog;

public class ConfigHandler 
{
	public static void init(String path)
	{
		blockInit(new File(path + "block.properties"));
		itemInit(new File(path + "item.properties"));
		otherInit(new File(path + "core.properties"));
	}
	
	private static void otherInit(File f)
	{
		Configuration con = new Configuration(f);
		
		try
		{
			con.load();
			
			VillagerIds.FRUIT_VENDOR = con.get("Village", "idFruitVendorVillager", VillagerIds.FRUIT_VENDOR_DEFAULT).getInt(VillagerIds.FRUIT_VENDOR_DEFAULT);
			VillagerIds.VEGETABLE_VENDOR = con.get("Village", "idVegetableVendorVillager", VillagerIds.VEGETABLE_VENDOR_DEFAULT).getInt(VillagerIds.VEGETABLE_VENDOR_DEFAULT);
			VillagerIds.SEED_VENDOR = con.get("Village", "idSeedVendorVillager", VillagerIds.SEED_VENDOR_DEFAULT).getInt(VillagerIds.SEED_VENDOR_DEFAULT);
			
			con.addCustomCategoryComment("WorldGen", "For gen chances, bushes are 0.0-1.0 for chances to grow in each chunk.");
			
			WorldGenSettings.genBlackberryBushes = con.get("WorldGen", "genBlackberryBushes", true, "").getBoolean(true);
			WorldGenSettings.genBlueberryBushes = con.get("WorldGen", "genBlueberryBushes", true, "").getBoolean(true);
			WorldGenSettings.genRaspberryBushes = con.get("WorldGen", "genRaspberryBushes", true, "").getBoolean(true);
			
			WorldGenSettings.genChanceBlackberryBushes = (float) con.get("WorldGen", "chanceBlackberryBushes", 0.03).getDouble(0.03);
			WorldGenSettings.genChanceBlueberryBushes = (float) con.get("WorldGen", "chanceBlueberryBushes", 0.03).getDouble(0.03);
			WorldGenSettings.genChanceRaspberryBushes = (float) con.get("WorldGen", "chanceRaspberryBushes", 0.03).getDouble(0.03);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " cannot load its core properties configuration file.");
		}
		finally
		{
			con.save();
		}
	}
	
	private static void blockInit(File f)
	{
		Configuration con = new Configuration(f);

		try
		{
			con.load();
			
			BlockIds.RYE_CROP = con.getBlock("ryeCrop", BlockIds.RYE_CROP_DEFAULT).getInt(BlockIds.RYE_CROP_DEFAULT);
			BlockIds.OAT_CROP = con.getBlock("oatCrop", BlockIds.OAT_CROP_DEFAULT).getInt(BlockIds.OAT_CROP_DEFAULT);
			BlockIds.BARLEY_CROP = con.getBlock("barleyCrop", BlockIds.BARLEY_CROP_DEFAULT).getInt(BlockIds.BARLEY_CROP_DEFAULT);
			BlockIds.CORN_CROP = con.getBlock("cornCrop", BlockIds.CORN_CROP_DEFAULT).getInt(BlockIds.CORN_CROP_DEFAULT);
			BlockIds.RICE_CROP = con.getBlock("riceCrop", BlockIds.RICE_CROP_DEFAULT).getInt(BlockIds.RICE_CROP_DEFAULT);
			BlockIds.HOP_CROP = con.getBlock("hopCrop", BlockIds.HOP_CROP_DEFAULT).getInt(BlockIds.HOP_CROP_DEFAULT);
			BlockIds.VINE_SUPPORT = con.getBlock("vineSupport", BlockIds.VINE_SUPPORT_DEFAULT).getInt(BlockIds.VINE_SUPPORT_DEFAULT);
			BlockIds.CUTTING_BOARD = con.getBlock("cuttingBoard", BlockIds.CUTTING_BOARD_DEFAULT).getInt(BlockIds.CUTTING_BOARD_DEFAULT);
			BlockIds.KITCHEN_COUNTER = con.getBlock("kitchenCounter", BlockIds.KITCHEN_COUNTER_DEFAULT).getInt(BlockIds.KITCHEN_COUNTER_DEFAULT);
			BlockIds.BLUEBERRY_BUSH = con.getBlock("blueberryBush", BlockIds.BLUEBERRY_BUSH_DEFAULT).getInt(BlockIds.BLUEBERRY_BUSH_DEFAULT);
			BlockIds.RASPBERRY_BUSH = con.getBlock("raspberryBush", BlockIds.RASPBERRY_BUSH_DEFAULT).getInt(BlockIds.RASPBERRY_BUSH_DEFAULT);
			BlockIds.BLACKBERRY_BUSH = con.getBlock("blackberryBush", BlockIds.BLACKBERRY_BUSH_DEFAULT).getInt(BlockIds.BLACKBERRY_BUSH_DEFAULT);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " cannot load its block properties configuration file.");
		}
		finally
		{
			con.save();
		}
	}
	
	private static void itemInit(File f)
	{
		Configuration con = new Configuration(f);
		
		try
		{
			con.load();
			
			ItemIds.FISH = con.getItem("fish", ItemIds.FISH_DEFAULT).getInt(ItemIds.FISH_DEFAULT);
			ItemIds.FRUIT = con.getItem("fruit", ItemIds.FRUIT_DEFAULT).getInt(ItemIds.FRUIT_DEFAULT);
			ItemIds.SEASONING = con.getItem("seasoning", ItemIds.SEASONING_DEFAULT).getInt(ItemIds.SEASONING_DEFAULT);
			ItemIds.VEGETABLE = con.getItem("vegetable", ItemIds.VEGETABLE_DEFAULT).getInt(ItemIds.VEGETABLE_DEFAULT);
			ItemIds.SEED = con.getItem("seed", ItemIds.SEED_DEFAULT).getInt(ItemIds.SEED_DEFAULT);
			ItemIds.GRAIN = con.getItem("grain", ItemIds.GRAIN_DEFAULT).getInt(ItemIds.GRAIN_DEFAULT);
			ItemIds.CUT_FRUIT = con.getItem("cutFruit", ItemIds.CUT_FRUIT_DEFAULT).getInt(ItemIds.CUT_FRUIT_DEFAULT);
			ItemIds.CUT_VEGETABLE = con.getItem("cutVegetable", ItemIds.CUT_VEGETABLE_DEFAULT).getInt(ItemIds.CUT_VEGETABLE_DEFAULT);
			ItemIds.FLOUR = con.getItem("flour", ItemIds.FLOUR_DEFAULT).getInt(ItemIds.FLOUR_DEFAULT);
			
			ItemIds.KNIFE_HANDLE = con.getItem("knifeHandle", ItemIds.KNIFE_HANDLE_DEFAULT).getInt(ItemIds.KNIFE_HANDLE_DEFAULT);
			ItemIds.CHEF_KNIFE = con.getItem("chefKnife", ItemIds.CHEF_KNIFE_DEFAULT).getInt(ItemIds.CHEF_KNIFE_DEFAULT);
			ItemIds.BUTCHER_KNIFE = con.getItem("butcherKnife", ItemIds.BUTCHER_KNIFE_DEFUALT).getInt(ItemIds.BUTCHER_KNIFE_DEFUALT);
			ItemIds.FILET_KNIFE = con.getItem("filetKnife", ItemIds.FILET_KNIFE_DEFAULT).getInt(ItemIds.FILET_KNIFE_DEFAULT);
			ItemIds.PARING_KNIFE = con.getItem("paringKnife", ItemIds.PARING_KNIFE_DEFAULT).getInt(ItemIds.PARING_KNIFE_DEFAULT);
			ItemIds.GRINDING_STONE = con.getItem("grindingStone", ItemIds.GRINDING_STONE_DEFAULT).getInt(ItemIds.GRINDING_STONE_DEFAULT);
			
			ItemIds.CROSSHATCH = con.getItem("crossHatch", ItemIds.CROSSHATCH_DEFAULT).getInt(ItemIds.CROSSHATCH_DEFAULT);
			ItemIds.PLATE = con.getItem("plate", ItemIds.PLATE_DEFAULT).getInt(ItemIds.PLATE_DEFAULT);
			ItemIds.PIE_PAN = con.getItem("piePan", ItemIds.PIE_PAN_DEFAULT).getInt(ItemIds.PIE_PAN_DEFAULT);
			
			ItemIds.CF_FRUIT_SALAD = con.getItem("cffruitSalad", ItemIds.CF_FRUIT_SALAD_DEFAULT).getInt(ItemIds.CF_FRUIT_SALAD_DEFAULT);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " cannot load its item properties configuration file.");
		}
		finally
		{
			con.save();
		}
	}
}