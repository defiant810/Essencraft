package com.co2.essencraft.util;

public class ArrayUtils 
{
	public static boolean ArrayContains(Object[] arr, Object check)
	{
		for (Object o : arr)
			if (o.equals(check))
				return true;
		
		return false;
	}
}