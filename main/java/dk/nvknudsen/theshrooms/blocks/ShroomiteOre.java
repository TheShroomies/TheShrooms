package dk.nvknudsen.theshrooms.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import dk.nvknudsen.theshrooms.mob.Shroombie;

public class ShroomiteOre extends Block
{

	public ShroomiteOre(int par1)
	{
		
		// All the properties
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("ShroomiteOre");
		this.setTextureName("theshrooms:ShroomiteOre");
		
	}
	
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta)
	{
		if(!w.isRemote)
		{
			Shroombie s=new Shroombie(w);
			s.setPosition(x, y, z);
			w.spawnEntityInWorld(s);
		}
	}
}
