package dk.nvknudsen.theshrooms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sun.net.www.content.text.Generic;

public class shroomiteore extends Block
{

	public shroomiteore(int par1, Material par2Material)
	{
		
		// All the properties
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0F);
		this.setStepSound(soundStoneFootstep);
		this.setUnlocalizedName("ShroomitOre");
		
		
	}
}
