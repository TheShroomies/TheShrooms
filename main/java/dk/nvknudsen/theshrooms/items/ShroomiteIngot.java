package dk.nvknudsen.theshrooms.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShroomiteIngot extends Item
{

	public ShroomiteIngot(int par1)
	{
		
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("ShroomiteIngot");
		this.setMaxStackSize(64);
		this.setTextureName("theshrooms:ShroomiteIngot");
		
	}
}
