package dk.nvknudsen.theshrooms;

// Imports (Derp)
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = "theshrooms", version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

// The main class
public class Main
{
	
	// Blocks Here
	public static Block ShroomiteOre;
	
	// Items Here
	public static Item ShroomiteIngot;
	
	// Tools Here
	
	
	// Making the mod able to be played on a server
	@SidedProxy(clientSide = ("dk.nvknudsen.theshrooms.client.ClientProxy"), serverSide = ("dk.nvknudsen.theshrooms.CommonProxy"))
	public static CommonProxy proxy;
	
	// Just the unofficial version
	public final static String version = "a1.0.0";
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		
		System.out.println("Initializing TheShrooms v. "+version);
		
		// Block registry
		ShroomiteOre = new ShroomiteOre(501, Material.rock);
		
		// Item registry
		ShroomiteIngot = new ShroomiteIngot(5001);
		
		
		MinecraftForge.setBlockHarvestLevel(ShroomiteOre, "pickaxe", 2);
		GameRegistry.registerBlock(ShroomiteOre, "ShroomiteOre");
		LanguageRegistry.addName(ShroomiteOre, "Shroomite Ore");
		GameRegistry.addSmelting(ShroomiteOre.blockID, new ItemStack(ShroomiteIngot), 1.0F);
		
		GameRegistry.registerItem(ShroomiteIngot, "Shroomiteingot");
		LanguageRegistry.addName(ShroomiteIngot, "Shroomite ingot");
		
	}
}
