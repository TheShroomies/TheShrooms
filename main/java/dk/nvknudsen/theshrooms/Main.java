package dk.nvknudsen.theshrooms;

// Imports
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dk.nvknudsen.theshrooms.blocks.ShroomiteOre;
import dk.nvknudsen.theshrooms.items.ShroomiteIngot;
import dk.nvknudsen.theshrooms.worldgen.ShroomiteOreGen;


@Mod(modid = "theshrooms", version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

// The main class
public class Main
{
	
	// Blocks Here
	public final static Block ShroomiteOre = new ShroomiteOre(501);
	
	// Items Here
	public final  static Item ShroomiteIngot = new ShroomiteIngot(5001);
	
	// Tools Here
	
	
	// The technical version
	public final static String version = "a1.0.0";
		
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		
		System.out.println("Initializing TheShrooms v. "+version);
		
		// Block & Item registrations
		GameRegistry.registerBlock(ShroomiteOre, "shroomiteOre");
		GameRegistry.registerItem(ShroomiteIngot, "shroomiteIngot");
		
		// Harvest level
		MinecraftForge.setBlockHarvestLevel(ShroomiteOre, "pickaxe", 2);
		
		// Melting registrations
		GameRegistry.addSmelting(ShroomiteOre.blockID, new ItemStack(ShroomiteIngot), 1.0F);
		
		// Language registrations
		LanguageRegistry.addName(ShroomiteIngot, "Shroomite ingot");
		LanguageRegistry.addName(ShroomiteOre, "Shroomite Ore");
		
		// World generators
		GameRegistry.registerWorldGenerator(new ShroomiteOreGen());
		
	}
}
