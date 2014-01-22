package com.co2.essencraft.recipe;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.co2.essencraft.item.IESCBaseFood;
import com.co2.essencraft.recipe.KCCraftingManager.ContainerType;

public class KCCraftingManager 
{
	private static final KCCraftingManager instance = new KCCraftingManager();
	private ArrayList<KCRecipe> recipes;
	private KCCraftingManager()
	{
		recipes = new ArrayList<KCRecipe>();
	}
	
	public static boolean addRecipe(ItemStack base, ContainerType type, ItemStack out, ItemStack... blacklist)
	{
		if (!(Item.itemsList[base.itemID] instanceof IESCBaseFood))
			return false;
		
		if (hasRecipeWithInput(base, type))
		{
			//TODO: add logging output to inform user of failure
			return false;
		}
		
		instance.recipes.add(new KCRecipe(base, type, out, blacklist));
		return true;
	}
	
	public static boolean hasRecipe(ItemStack in, ContainerType type, ItemStack out)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equals(new KCRecipe(in, type, out)))
				return true;
		
		return false;
	}
	
	public static boolean hasRecipeWithInput(ItemStack in, ContainerType type)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equalsInputs(new KCRecipe(in, type, null)))
				return true;
		
		return false;
	}
	
	public static ItemStack getOutput(ItemStack in, ContainerType type)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equalsInputs(new KCRecipe(in, type, null)))
				return rec.getOutput().copy();
		
		return null;
	}
	
	public static boolean isBlackListed(ItemStack in, ContainerType type, ItemStack check)
	{
		KCRecipe rec = getRecipeWithInputs(in, type);
		
		if (rec == null)
			return false;
		
		return rec.itemBlackListed(check);
	}
	
	private static KCRecipe getRecipeWithInputs(ItemStack in, ContainerType type)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equalsInputs(new KCRecipe(in, type, null)))
				return rec;
		
		return null;
	}
	
	//================================================
	public enum ContainerType
	{
		PLATE,
		BOWL,
		PIEPAN
	}
}

class KCRecipe
{
	private final ItemStack base;
	private final ContainerType container;
	private final ItemStack output;
	private final ArrayList<ItemStack> blackList;
	private final ArrayList<Integer> gBlackList; //The blacklists that cover entire ids
	
	public KCRecipe(ItemStack in, ContainerType ct, ItemStack out, ItemStack... blacklist)
	{
		this.base = in.copy();
		this.container = ct;
		this.output = out != null ? out.copy() : null;
		this.blackList = new ArrayList<ItemStack>();
		this.gBlackList = new ArrayList<Integer>();
		
		for (ItemStack stack : blacklist)
		{
			if (stack.stackSize == -1)
				gBlackList.add(stack.itemID);
			else
				blackList.add(stack.copy());
		}
	}
	
	public ItemStack getBase()
	{
		return this.base;
	}
	
	public ItemStack getOutput()
	{
		return this.output;
	}
	
	public ContainerType getContainerType()
	{
		return this.container;
	}
	
	public boolean itemBlackListed(ItemStack stack)
	{
		for (ItemStack s : this.blackList)
			if (s.itemID == stack.itemID && s.getItemDamage() == stack.getItemDamage())
				return true;
		
		for (Integer i : this.gBlackList)
			if (stack.itemID == i)
				return true;
		
		return false;
	}
	
	public boolean equalsInputs(KCRecipe other)
	{
		return (this.base.itemID == other.base.itemID && this.base.getItemDamage() == other.base.getItemDamage() && this.container == other.container);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof KCRecipe))
			return false;
		
		KCRecipe rec = (KCRecipe) other;
		
		return this.equalsInputs(rec) && this.output.itemID == rec.output.itemID && this.output.getItemDamage() == rec.output.getItemDamage();
	}
	
	@Override
	public String toString()
	{
		return "[Input: " + this.base.toString() + " ContainerType: " + this.container.toString() + " Output: " + this.output.toString() + "]";
	}
}