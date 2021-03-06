package dk.nvknudsen.theshrooms.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import dk.nvknudsen.theshrooms.Main;

public class ShroomiteOreGen extends OreGen
{
	public ShroomiteOreGen()
	{
		super(50,30);
	}

	private WorldGenMinable generator=new WorldGenMinable(Main.shroomiteOre.blockID, 3);

	@Override
	protected void generateOverworld(Random random, int chunkX, int chunkY, int chunkZ, World world)
	{
		generator.generate(world, random, chunkX, chunkY, chunkZ);
	}
}
