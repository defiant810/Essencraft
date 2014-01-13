package com.co2.essencraft.lib;

//library of all the simple names and in game names for this mod
public class StringLib 
{
	public static final String ASSET_PREFIX = Reference.MOD_ID.toLowerCase() + ":";
	
	/* Block name constants */
	public static final String BARLEY_CROP_NAME = "barleyCrop";
	public static final String CORN_CROP_NAME = "cornCrop";
	public static final String HOP_CROP_NAME = "hopCrop";
	public static final String OAT_CROP_NAME = "oatCrop";
	public static final String RYE_CROP_NAME = "ryeCrop";
	public static final String RICE_CROP_NAME = "riceCrop";
	public static final String VINE_SUPPORT_NAME = "vineSupport";
	
	/* Item name constants */
	public static final String RYE_NAME = "ryeStalk";
	
	//Grains
	public static final String[] GRAIN_NAMES = {"Barley", "Corn", "Hops", "Oat", "Rye", "Rice"};
	//Seeds - to be plantable on grass and dirt name must contain "tree" (any case) otherwise only plantable on tilled soil
	public static final String[] SEED_NAMES = { "Barley Seed", "Corn Seed", "Hops Seed", "Oat Seed", "Rye Seed", "Rice Seed", "Banana Tree Seed",
		"Coconut Tree Seed", "Grapefruit Tree Seed", "Mango Tree Seed", "Orange Tree Seed", "Peach Tree Seed", "Pear Tree Seed", "Pineapple Tree Seed",
		"Plum Tree Seed", "Pomegranate Tree Seed", "Grape Vine Seed", "Kiwi Vine Seed", "Black Pepper Vine Seed", "Green Bean Vine Seed", "Soy Bean Vine Seed",
		"Pea Vine Seed", "Tomatoe Vine Seed", "Strawberry Vine Seed", "Decorative Vine Seed" };
	
	//Fish
	public static final String[] FISH_NAMES = { "Crab", "Halibut", "Lobster", "Salmon", "Shrimp", "Squid", "Trout", "Red Herring" };
	//Fruit
	public static final String[] FRUIT_NAMES = { "Banana", "Blackberry", "Blueberry", "Coconut", "Grapefruit", "Grapes", "Kiwi",
		"Mango", "Orange", "Peach", "Pear", "Pineapple", "Plum", "Pomegranate", "Raspberry", "Strawberry" };
	//Vegetables
	public static final String[] VEG_NAMES = { "Green Beans", "Soy Beans", "Beet", "Cabbage", "Celery", "Cucumber", "Eggplant", "Lettuce",
		"Onion", "Peas", "Red Bell Pepper", "Ghost Pepper", "Jalapeno Pepper", "Radish", "Rhubarb", "Spinach", "Squash", "Tomato", "Yellow Bell Pepper", "Orange Bell Pepper"};
	//Seasoning
	public static final String[] SEASONING_NAMES = { "Basil", "Cilantro", "Garlic", "Oregano", "Parsley", "Black Pepper", "Rosemary", "Sage",
		"Salt", "Thyme", "Vanilla"};
}