package com.co2.essencraft.util;

import net.minecraft.item.ItemStack;

public class ArrayUtils 
{
	public static boolean arrayContains(Object[] arr, Object check)
	{
		for (Object o : arr)
			if (o.equals(check))
				return true;
		
		return false;
	}
	
	public static Object[] subArray(Object[] input, int start, int end)
	{
		if (start < 0) start = 0;
		if (end > input.length) 
			end = input.length;
		else if (end <= start)
			end = start + 1;
		
		Object[] retval = new Object[end - start];
		int j = 0;
		for (int i = start; i < end; ++i)
			retval[j++] = input[i];
		
		return retval;
	}
	
	public static ItemStack[] itemStackSubArray(ItemStack[] input, int start, int end)
	{
		if (start < 0) start = 0;
		if (end > input.length) 
			end = input.length;
		else if (end <= start)
			end = start + 1;
		
		ItemStack[] retval = new ItemStack[end - start];
		int j = 0;
		for (int i = start; i < end; ++i)
			retval[j++] = input[i] != null ? input[i].copy() : null;
		
		return retval;
	}
}