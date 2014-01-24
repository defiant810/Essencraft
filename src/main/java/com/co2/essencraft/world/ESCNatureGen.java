package com.co2.essencraft.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.co2.essencraft.block.ModBlocks;
import com.co2.essencraft.lib.WorldGenSettings;
import com.co2.essencraft.util.WorldUtils;

import cpw.mods.fml.common.IWorldGenerator;

public class ESCNatureGen implements IWorldGenerator
{
	WorldGenESCBush blackBerry;
	WorldGenESCBush blueBerry;
	WorldGenESCBush raspBerry;
	
	public ESCNatureGen()
	{
		blackBerry = new WorldGenESCBush(false, ModBlocks.blackberryBush.blockID);
		blueBerry = new WorldGenESCBush(false, ModBlocks.blueberryBush.blockID);
		raspBerry = new WorldGenESCBush(false, ModBlocks.raspberryBush.blockID);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			return;
		case 0:
			generateOverworldBushes(world, random, chunkX * 16, chunkZ * 16);
			generateOverworldTrees(world, random, chunkX * 16, chunkZ * 16);
			return;
		}
	}
	
	private void generateOverworldBushes(World world, Random random, int blockX, int blockZ)
	{
		int bX = blockX + random.nextInt(16);
		int bZ = blockZ + random.nextInt(16);
		int bY = WorldUtils.getMaxHeightOfBlockWithSpaceAbove(world, bX, bZ, new Integer[] { Block.grass.blockID, Block.dirt.blockID });
		
		//Blackberry
		if (WorldGenSettings.genBlackberryBushes && random.nextFloat() < WorldGenSettings.genChanceBlackberryBushes && bY < 255 && bY > 60)
		{
			blackBerry.generate(world, random, bX, bY, bZ);
		}

		//Blueberry
		if (WorldGenSettings.genBlueberryBushes && random.nextFloat() < WorldGenSettings.genChanceBlueberryBushes && bY < 255 && bY > 60)
		{
			bX = blockX + random.nextInt(16);
			bZ = blockZ + random.nextInt(16);
			bY = WorldUtils.getMaxHeightOfBlockWithSpaceAbove(world, bX, bZ, new Integer[] { Block.grass.blockID, Block.dirt.blockID });
			blueBerry.generate(world, random, bX, bY, bZ);
		}
		
		//Blueberry
		if (WorldGenSettings.genRaspberryBushes && random.nextFloat() < WorldGenSettings.genChanceRaspberryBushes && bY < 255 && bY > 60)
		{
			bX = blockX + random.nextInt(16);
			bZ = blockZ + random.nextInt(16);
			bY = WorldUtils.getMaxHeightOfBlockWithSpaceAbove(world, bX, bZ, new Integer[] { Block.grass.blockID, Block.dirt.blockID });
			raspBerry.generate(world, random, bX, bY, bZ);
		}
	}
	
	private void generateOverworldTrees(World world, Random random, int blockX, int blockZ)
	{
		
	}
	
	private void generateNether(World world, Random random, int blockX, int blockY)
	{
		
	}
}