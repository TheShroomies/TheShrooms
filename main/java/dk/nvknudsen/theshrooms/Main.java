package dk.nvknudsen.theshrooms;

// Imports
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dk.nvknudsen.theshrooms.blocks.ShroomiteOre;
import dk.nvknudsen.theshrooms.items.ShroomiteIngot;
import dk.nvknudsen.theshrooms.mob.Shroombie;
import dk.nvknudsen.theshrooms.proxy.CommonProxy;
import dk.nvknudsen.theshrooms.worldgen.ShroomiteOreGen;

@Mod(modid = Main.modid, version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


// The main class
public class Main
{
	
	// Materials
	public final static EnumToolMaterial shroomiteToolMaterial = EnumHelper.addToolMaterial("Shroomite", 2, 1200, 12.0F, 2.0F, 30);
	
	// Blocks Here
	public final static Block shroomiteOre = new ShroomiteOre(501);
	
	// Items Here
	public final static Item shroomiteIngot = new ShroomiteIngot(5001);
	
	@SidedProxy(clientSide="dk.nvknudsen.theshrooms.proxy.ClientProxy",serverSide="dk.nvknudsen.theshrooms.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	// Tools Here
	public final static Item shroomitePickaxe = new ItemPickaxe(5051, shroomiteToolMaterial).setUnlocalizedName("ShroomitePickaxe").setTextureName("theshrooms:ShroomitePickaxe");
	public final static Item shroomiteShovel = new ItemSpade(5052, shroomiteToolMaterial).setUnlocalizedName("ShroomiteShovel").setTextureName("theshrooms:ShroomiteShovel");
	public final static Item shroomiteSword = new ItemSword(5053, shroomiteToolMaterial).setUnlocalizedName("ShroomiteSword").setTextureName("theshrooms:ShroomiteSword");
	public final static Item shroomiteAxe = new ItemAxe(5054, shroomiteToolMaterial).setUnlocalizedName("ShroomiteAxe").setTextureName("theshrooms:ShroomiteAxe");
	
	// The technical version
	public final static String version = "a1.0.0";
	public final static String modid = "theshrooms";
	
	public final static Logger log = Logger.getLogger("theshrooms");

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		
		log.info("Initializing TheShrooms ("+modid+") v. "+version);
		
		
		// Block & Item registrations
		GameRegistry.registerBlock(shroomiteOre, "shroomiteOre");
		GameRegistry.registerItem(shroomiteIngot, "shroomiteIngot");
		
		// Tools
		GameRegistry.registerItem(shroomitePickaxe, "Shroomite Pickaxe");
		GameRegistry.registerItem(shroomiteShovel, "Shroomite Shovel");
		GameRegistry.registerItem(shroomiteSword, "Shroomite Sword");
		GameRegistry.registerItem(shroomiteAxe, "Shroomite Axe");

		// Crafting registrations
		GameRegistry.addShapedRecipe(new ItemStack(shroomiteAxe),
				"xx ", "xy ", " y ",
				'x', new ItemStack(shroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(shroomitePickaxe),
				"xxx", " y ", " y ",
				'x', new ItemStack(shroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(shroomiteShovel),
				" x ", " y ", " y ",
				'x', new ItemStack(shroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(shroomiteSword),
				" x ", " x ", " y ",
				'x', new ItemStack(shroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		
		// Harvest level
		MinecraftForge.setBlockHarvestLevel(shroomiteOre, "pickaxe", 2);
		
		// Entity registrations
		registerEntity(Shroombie.class, "shroombie");
		EntityRegistry.addSpawn(Shroombie.class, 10, 0, 4, EnumCreatureType.monster);
		
		// Melting registrations
		GameRegistry.addSmelting(shroomiteOre.blockID, new ItemStack(shroomiteIngot), 1.0F);
		
		// Language registrations
		LanguageRegistry.addName(shroomiteIngot, "Shroomite ingot");
		LanguageRegistry.addName(shroomiteOre, "Shroomite Ore");
		LanguageRegistry.addName(shroomiteAxe, "Shroomite Axe");
		LanguageRegistry.addName(shroomiteSword, "Shroomite Sword");
		LanguageRegistry.addName(shroomiteShovel, "Shroomite Shovel");
		LanguageRegistry.addName(shroomitePickaxe, "Shroomite Pickaxe");
		
		// World generators
		GameRegistry.registerWorldGenerator(new ShroomiteOreGen());
		
		// Proxy registrations
		proxy.registerRenderThings();
		
	}
	
	public void registerEntity(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, 0, this, 64, 1, true);
	}
}
