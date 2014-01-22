package com.co2.essencraft.item;

import net.minecraft.potion.PotionEffect;

/**
 * The interface that tells the mod that the item can be used in the kitchen counter recipe.
 */
public interface IESCIngredient 
{
	/**
	 * Gets the food value to add to the final recipe.
	 * @param damage The damage of the itemstack in the crafting grid.
	 * @return The food value (0-20) that this food adds to the recipe.
	 */
	public int getFoodValue(int damage);
	
	/**
	 * Gets the poition effects to add to the final recipe
	 * @param damage The damage of the itemstack in the crafting grid.
	 * @return An array of all of the potion effects to add to the recipe.
	 */
	public PotionEffect[] getEffects(int damage);
	
	/**
	 * Gets the satuation value to add to the AVERAGE for the final recipe.
	 * @param damage The damage of the itemstack in the crafting grid.
	 * @return The float value to add the the saturation amount before it is averaged of the recipe.
	 */
	public float getSaturation(int damage);
	
	/**
	 * Gets the name of the ingredient.
	 * @param damage The damage of the itemstack in the crafting grid
	 * @return The String of the name of the ingredient.
	 */
	public String getIngredientName(int damage);
}