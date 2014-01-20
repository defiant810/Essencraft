package com.co2.essencraft.recipe;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import com.co2.essencraft.recipe.CBCraftingManager.KnifeType;

public class CBCraftingManager 
{
	private static final CBCraftingManager instance = new CBCraftingManager();
	private ArrayList<CBRecipe> recipes;
	private CBCraftingManager()
	{
		recipes = new ArrayList<CBRecipe>();
	}
	
	public static boolean addRecipe(ItemStack in, KnifeType knife, ItemStack out)
	{
		if (hasRecipeWithInput(in, knife))
		{
			//TODO: add logging output to inform user of failure
			return false;
		}
		
		instance.recipes.add(new CBRecipe(in, knife, out));
		return true;
	}
	
	public static boolean hasRecipe(ItemStack in, KnifeType knife, ItemStack out)
	{
		for (CBRecipe rec : instance.recipes)
			if (rec.equals(new CBRecipe(in, knife, out)))
				return true;
		
		return false;
	}
	
	public static boolean hasRecipeWithInput(ItemStack in, KnifeType knife)
	{
		for (CBRecipe rec : instance.recipes)
			if (rec.equalsInputs(new CBRecipe(in, knife, null)))
				return true;
		
		return false;
	}
	
	public static ItemStack getOutput(ItemStack in, KnifeType knife)
	{
		for (CBRecipe rec : instance.recipes)
			if (rec.equalsInputs(new CBRecipe(in, knife, null)))
				return rec.getOutput().copy();
		
		return null;
	}
	
	//========================================================================
	public enum KnifeType
	{
		CHEF,
		BUTCHER,
		FILET,
		PARING
	}
}

class CBRecipe
{
	private final ItemStack input;
	private final ItemStack output;
	private final KnifeType knifeType;
	
	public CBRecipe(ItemStack in, KnifeType knife, ItemStack out)
	{
		this.input = in != null ? in.copy() : null;
		this.output = out != null ? out.copy() : null;
		this.knifeType = knife;
	}
	
	public ItemStack getInput()
	{
		return input;
	}
	
	public ItemStack getOutput()
	{
		return output;
	}
	
	public KnifeType getKnifeType()
	{
		return knifeType;
	}
	
	public boolean equalsInputs(CBRecipe other)
	{
		return (other.input.itemID == this.input.itemID && other.input.getItemDamage() == this.input.getItemDamage()
				&& other.knifeType == this.knifeType);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof CBRecipe))
			return false;
		
		CBRecipe rec = (CBRecipe) other;
		
		if (rec.input.itemID == this.input.itemID && this.input.getItemDamage() == this.input.getItemDamage()
				&& rec.output.itemID == this.output.itemID && rec.output.getItemDamage() == this.output.getItemDamage()
				&& rec.knifeType == this.knifeType)
			return true;
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return "[Input: " + this.input.toString() + " KnifeType: " + this.knifeType.toString() + 
				" Output: " + this.output.toString() + "]";
	}
}