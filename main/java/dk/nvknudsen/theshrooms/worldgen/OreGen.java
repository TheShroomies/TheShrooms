package dk.nvknudsen.theshrooms.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public abstract class OreGen implements IWorldGenerator{
	
	private final int rarity, maxY, minY;
	
	/**
	 * Simple ore generation library.
	 * @param rarity The amount of veins in a chunk.
	 * @param maxY The maximum height value.
	 * @param minY The minimum height value.
	 */
	public OreGen(int rarity,int maxY,int minY)
	{
		this.rarity = rarity;
		this.maxY=maxY;
		this.minY=minY;
	}
	
	/**
	 * Simple ore generation library.
	 * @param rarity The amount of veins in a chunk.
	 * @param maxY The maximum height value.
	 */
	public OreGen(int rarity,int maxY)
	{
		this(rarity,maxY,0);
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX = chunkX*16+random.nextInt(16);
		chunkZ = chunkZ*16+random.nextInt(16);;
		int chunkY = minY+random.nextInt(maxY-minY);
		
		switch(world.provider.dimensionId){
		case -1:
			for(int i=0;i<rarity;++i)
				generateNether(random, chunkX, chunkY, chunkZ, world);
			break;
		case 0:
			for(int i=0;i<rarity;++i)
				generateOverworld(random, chunkX, chunkY, chunkZ, world);
		case 1:
			for(int i=0;i<rarity;++i)
				generateEnd(random, chunkX, chunkY, chunkZ, world);
		}
	}
	
	protected void generateOverworld(Random random, int chunkX, int chunkY, int chunkZ, World world) {}
	protected void generateNether(Random random, int chunkX, int chunkY, int chunkZ, World world) {}
	protected void generateEnd(Random random, int chunkX, int chunkY, int chunkZ, World world) {}

}
