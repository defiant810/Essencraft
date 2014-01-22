package com.co2.essencraft.item.food;

import net.minecraft.potion.PotionEffect;

public class FoodInfo 
{
	public final int heal;
	public final float saturation;
	public final String[] ingredients;
	public final PotionEffect[] effects;
	
	public FoodInfo(int heal, float saturation, String[] inames, PotionEffect[] effects)
	{
		this.heal = heal;
		this.saturation = saturation;
		this.ingredients = inames;
		this.effects = effects;
	}
}