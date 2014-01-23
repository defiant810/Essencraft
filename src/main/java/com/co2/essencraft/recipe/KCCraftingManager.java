package com.co2.essencraft.recipe;

import java.util.ArrayList;

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
	
	//TODO: add logging output to inform user of failure
	public static boolean addRecipe(ItemStack[][] base, ContainerType type, ItemStack out, ItemStack... blacklist)
	{
		if (base.length != 3)
			return false;
		
		for (int i = 0; i < 3; ++i)
		{
			if (base[i] == null)
				continue;
				
			int lastId = 0;
			for (int j = 0; j < base[i].length; ++j)
			{
				if (j != 0 && lastId != base[i][j].itemID)
					return false;
				
				lastId = base[i][j].itemID;
				
				if (base[i] != null && !(base[i][j].getItem() instanceof IESCBaseFood))
					return false;
			}
		}
		
		if (hasRecipeWithInput(base, type))
			return false;
		
		instance.recipes.add(new KCRecipe(base, type, out, blacklist));
		return true;
	}
	
	public static boolean hasRecipe(ItemStack[][] in, ContainerType type, ItemStack out)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equals(new KCRecipe(in, type, out)))
				return true;
		
		return false;
	}
	
	public static boolean hasRecipeWithInput(ItemStack[][] in, ContainerType type)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equalsInputs(new KCRecipe(in, type, null)))
				return true;
		
		return false;
	}
	
	public static ItemStack getOutput(ItemStack[][] in, ContainerType type)
	{
		for (KCRecipe rec : instance.recipes)
			if (rec.equalsInputs(new KCRecipe(in, type, null)))
				return rec.getOutput().copy();
		
		return null;
	}
	
	public static boolean isWhiteListed(ItemStack[][] in, ContainerType type, ItemStack check)
	{
		KCRecipe rec = getRecipeWithInputs(in, type);
		
		if (rec == null)
			return false;
		
		return rec.itemWhiteListed(check);
	}
	
	private static KCRecipe getRecipeWithInputs(ItemStack[][] in, ContainerType type)
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
	private final ItemStack[][] base;
	private final ContainerType container;
	private final ItemStack output;
	private final ArrayList<ItemStack> whiteList;
	private final ArrayList<Integer> gWhiteList; //The blacklists that cover entire ids
	private final int numInputs;
	
	public KCRecipe(ItemStack[][] in, ContainerType ct, ItemStack out, ItemStack... whitelist)
	{
		this.base = new ItemStack[3][];
		int j = 0;
		for (int i = 0; i < 3; ++i)
		{
			if (in[i] != null && in[i][0] != null)
			{
				this.base[i] = new ItemStack[in[i].length];
				
				for (int k = 0; k < in[i].length; ++k)
					this.base[i][k] = in[i][k] != null ? in[i][k].copy() : null;
				
				++j;
			}
		}
		this.numInputs = j;
		this.container = ct;
		this.output = out != null ? out.copy() : null;
		this.whiteList = new ArrayList<ItemStack>();
		this.gWhiteList = new ArrayList<Integer>();
		
		for (ItemStack stack : whitelist)
		{
			if (stack.stackSize == -1)
				gWhiteList.add(stack.itemID);
			else
				whiteList.add(stack.copy());
		}
	}
	
	public ItemStack[][] getBase()
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
	
	public boolean itemWhiteListed(ItemStack stack)
	{
		for (ItemStack s : this.whiteList)
			if (s.itemID == stack.itemID && s.getItemDamage() == stack.getItemDamage())
				return true;
		
		for (Integer i : this.gWhiteList)
			if (stack.itemID == i)
				return true;
		
		return false;
	}

	public boolean equalsInputs(KCRecipe other)
	{
		if (other.numInputs != this.numInputs)
			return false;
		
		if (other.container != this.container)
			return false;
		
		boolean[] matched = { false, false, false };
		
		for (int i = 0; i < this.numInputs; ++i)
		{
			boolean found = false;
			for (int j = 0; j < other.numInputs; ++j)
			{
				if (matched[j]) //Ignore if this index has already been checked
					continue;
					
				if (this.base[i] == null && other.base[j] == null) //Found a matching null (*shouldnt happen)
				{
					found = true;
					matched[j] = true;
					break;
				}
				
				if (this.base[i] == null || other.base[j] == null) //Cant do anything else if either is null while the other isnt
					continue;
				
				if (this.base[i][0].stackSize < 0) //If its a global id match
				{
					if (this.base[i][0].itemID == other.base[j][0].itemID)
					{
						found = true;
						matched[j] = true;
						break;
					}
				}
				else
				{
					if (this.base[i].length == other.base[i].length) //If these inputs can be matched
					{
						for (int k = 0; k < this.base[i].length; ++k) //Loop through each sub-input
						{
							//If all of the sub input matches
							boolean found2 = true;
							if ((this.base[i][k].itemID != other.base[j][k].itemID) || (this.base[i][k].getItemDamage() != other.base[j][k].getItemDamage()))
							{
								found2 = false;
								break;
							}
							
							if (!found2) //Break if we miss a match
								break;
							else
							{
								found = true;
							}
						}
					}
					else
						continue;
				}
				
				if (found) //Additional break to catch a full match on the sub-inputs
					break;
			}
			
			if (!found) //If the input was not found anywhere in the other inputs
				return false;
		}
		
		return true;		
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