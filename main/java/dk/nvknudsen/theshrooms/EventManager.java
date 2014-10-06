package dk.nvknudsen.theshrooms;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		
		switch(world.provider.dimensionId)
		{
		
		case 0:
			generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		
		}
		
	}
}
