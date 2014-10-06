package dk.nvknudsen.theshrooms;

// Imports (Derp)
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "theshrooms", version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

// The main class
public class Main
{
	
	// Blocks Here
	public static Block shroomiteore;
	
	// Items Here
	public static Item shroomiteingot;
	
	// Making the block able to be played on a server
	@SidedProxy(clientSide = ("dk.nvknudsen.theshrooms.client.ClientProxy"), serverSide = ("dk.nvknudsen.theshrooms.CommonProxy"))
	public static CommonProxy proxy;
	
	// Just the unofficial version
	public final static String version = "a1.0.0";
	
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		
		System.out.println("Initializing TheShrooms v. "+version);
		
		// Block registry
		shroomiteore = new shroomiteore(5001, Material.rock);
		
		// Item registry
		shroomiteingot = new shroomiteingot(5002);
		
		MinecraftForge.setBlockHarvestLevel(shroomiteore, "pickaxe", 2);
		GameRegistry.registerBlock(shroomiteore, "ShroomiteOre");
		LanguageRegistry.addName(shroomiteore, "Shroomite Ore");
		
		
		
	}
}
