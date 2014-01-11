package com.co2.essencraft.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.co2.essencraft.lib.StringLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSeedESC extends ItemSeeds
{	
	private static final int ID_SHIFT_CORRECTION = 256;
	
	private static final int NUM_SEEDS = StringLib.SEED_NAMES.length;
	private static final String[] TEXTURES = { "SeedBarley", "SeedCorn", "SeedHop", "SeedOat", "SeedRye" };
	//The id of the block planted by each seed
	private static final int[] PLANTED_TYPES = { Block.crops.blockID, Block.crops.blockID, Block.crops.blockID, Block.crops.blockID, Block.crops.blockID };
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemSeedESC(int id)
	{
		super(id - ID_SHIFT_CORRECTION, 0, Block.tilledField.blockID);
		this.setMaxStackSize(64);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		//TODO set proper creative tab
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int xPos, int yPos, int zPos, int side, float xClick, float yClick, float zClick)
	{
		if (side != 1)
			return false;
		else if (player.canPlayerEdit(xPos, yPos, zPos, side, stack) && player.canPlayerEdit(xPos, yPos + 1, zPos, side, stack))
		{
			int i1 = world.getBlockId(xPos, yPos, zPos);
			Block soil = Block.blocksList[i1];

			//We can change this later to allow different metadata to grow on different surfaces
			if (soil != null && soil.canSustainPlant(world, xPos, yPos, zPos, ForgeDirection.UP, this) && world.isAirBlock(xPos, yPos + 1, zPos))
			{
				world.setBlock(xPos, yPos + 1, zPos, PLANTED_TYPES[MathHelper.clamp_int(stack.getItemDamage(), 0, NUM_SEEDS)], 0, 3);
				--stack.stackSize;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + StringLib.SEED_NAMES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, NUM_SEEDS - 1)].toLowerCase() + ".seed";
	}
	
	@Override
	public Icon getIconFromDamage(int damage)
	{
		if (damage < 0 || damage >= icons.length)
			return null;
		
		return icons[damage];
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[NUM_SEEDS];
		for (int i = 0; i < icons.length; i++)
			icons[i] = iconRegister.registerIcon(StringLib.ASSET_PREFIX + "item" + TEXTURES[i]);
	}
	
	public String simpleName(int meta)
	{
		ItemStack st = new ItemStack(this.itemID, 1, meta);
		String name = this.getUnlocalizedName(st).substring(this.getUnlocalizedName(st).indexOf(".") + 1);
		name = name.substring(0, name.indexOf("."));
		return name;
	}
	
	public String simpleName()
	{
		String name = this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
		name = name.substring(0, name.indexOf("."));
		return name;
	}
}