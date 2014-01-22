package com.co2.essencraft.item.food;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.co2.essencraft.item.ItemFoodESC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCombinedFood extends ItemFoodESC
{
	public ItemCombinedFood(int id)
	{
		super(id, 0, 0, false); //We must manually set in onFoodEaten(), set to 0 so Minecraft doesnt do anything itself
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par3EntityPlayer.canEat(false))
			par3EntityPlayer.setItemInUse(par1ItemStack, par1ItemStack.getMaxItemUseDuration());
			
		return par1ItemStack;
	}
	
	@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (par2World.isRemote)
			return;
		
		FoodInfo info = getFoodInfo(par1ItemStack);
		
		par3EntityPlayer.getFoodStats().addStats(info.heal, info.saturation);
		
        if (info.effects.length > 0)
        	for (PotionEffect p : info.effects)
        		par3EntityPlayer.addPotionEffect(p);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		FoodInfo info = getFoodInfo(stack);
		if (info == null)
			return;
		
		list.add("Heals: " + info.heal);
		list.add("Saturation: " + info.saturation);
		list.add("Ingredients: ");
		for (String s : info.ingredients)
			list.add("  " + s);
		
		if (info.effects.length > 0)
		{
			list.add("Effects: ");
			for (PotionEffect p : info.effects)
				list.add("  " + p.getEffectName().substring(7) + "x" + (p.getAmplifier() + 1));
		}
	}
	
	protected FoodInfo getFoodInfo(ItemStack stack)
	{
		NBTTagList tagList = stack.stackTagCompound.getTagList("RecipeData");
		if (tagList == null)
			return null;
		if (tagList.tagCount() < 1)
			return null;
		
		int healed = 0;
		float totalSaturation = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
		
		for (int i = 0; i < tagList.tagCount(); ++i)
		{
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			names.add(tag.getString("iname"));
			totalSaturation += tag.getFloat("saturation");
			healed += tag.getByte("heal");
			if (tag.getByte("numEffects") > 0)
			{
				NBTTagList effectList = (NBTTagList) tag.getTag("EffectList");
				for (int j = 0; i < effectList.tagCount(); ++j)
					effects.add(PotionEffect.readCustomPotionEffectFromNBT((NBTTagCompound) effectList.tagAt(j)));
			}
		}
		
		int count = names.size();
		totalSaturation /= (count / 2f);
		
		return new FoodInfo(healed, totalSaturation, names.toArray(new String[names.size()]), effects.toArray(new PotionEffect[effects.size()]));
	}
}