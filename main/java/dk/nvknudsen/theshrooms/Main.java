package dk.nvknudsen.theshrooms;

// Imports
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(modid = "theshrooms", version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


// The main class
public class Main
{
	
	// Materials
	public final static EnumToolMaterial ShroomiteToolMaterial = EnumHelper.addToolMaterial("Shroomite", 2, 1200, 12.0F, 2.0F, 30);
	
	// Blocks Here
	public final static Block ShroomiteOre = new ShroomiteOre(501);
	
	// Items Here
	public final static Item ShroomiteIngot = new ShroomiteIngot(5001);
	
	@SidedProxy(clientSide="dk.nvknudsen.theshrooms.proxy.ClientProxy",serverSide="dk.nvknudsen.theshrooms.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	// Tools Here
	public final static Item ShroomitePickaxe = new ItemPickaxe(5051, ShroomiteToolMaterial).setUnlocalizedName("ShroomitePickaxe").setTextureName("theshrooms:ShroomitePickaxe");
	public final static Item ShroomiteShovel = new ItemSpade(5052, ShroomiteToolMaterial).setUnlocalizedName("ShroomiteShovel").setTextureName("theshrooms:ShroomiteShovel");
	public final static Item ShroomiteSword = new ItemSword(5053, ShroomiteToolMaterial).setUnlocalizedName("ShroomiteSword").setTextureName("theshrooms:ShroomiteSword");
	public final static Item ShroomiteAxe = new ItemAxe(5054, ShroomiteToolMaterial).setUnlocalizedName("ShroomiteAxe").setTextureName("theshrooms:ShroomiteAxe");
	
	// The technical version
	public final static String version = "a1.0.0";

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		
		System.out.println("Initializing TheShrooms v. "+version);
		
		// Block & Item registrations
		GameRegistry.registerBlock(ShroomiteOre, "shroomiteOre");
		GameRegistry.registerItem(ShroomiteIngot, "shroomiteIngot");
		
		// Tools
		GameRegistry.registerItem(ShroomitePickaxe, "Shroomite Pickaxe");
		GameRegistry.registerItem(ShroomiteShovel, "Shroomite Shovel");
		GameRegistry.registerItem(ShroomiteSword, "Shroomite Sword");
		GameRegistry.registerItem(ShroomiteAxe, "Shroomite Axe");

		// Crafting registrations
		GameRegistry.addShapedRecipe(new ItemStack(ShroomiteAxe),
				"xx ", "xy ", " y ",
				'x', new ItemStack(ShroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(ShroomitePickaxe),
				"xxx", " y ", " y ",
				'x', new ItemStack(ShroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(ShroomiteShovel),
				" x ", " y ", " y ",
				'x', new ItemStack(ShroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		GameRegistry.addShapedRecipe(new ItemStack(ShroomiteSword),
				" x ", " x ", " y ",
				'x', new ItemStack(ShroomiteIngot), 'y', new ItemStack(Item.stick)
		);
		
		// Harvest level
		MinecraftForge.setBlockHarvestLevel(ShroomiteOre, "pickaxe", 2);
		
		// Entity registrations
		EntityRegistry.registerModEntity(Shroombie.class, "shroombie", 0, this, 80, 1, true);
		EntityRegistry.addSpawn(Shroombie.class, 10, 0, 1, EnumCreatureType.creature);
		
		// Melting registrations
		GameRegistry.addSmelting(ShroomiteOre.blockID, new ItemStack(ShroomiteIngot), 1.0F);
		
		// Language registrations
		LanguageRegistry.addName(ShroomiteIngot, "Shroomite ingot");
		LanguageRegistry.addName(ShroomiteOre, "Shroomite Ore");
		LanguageRegistry.addName(ShroomiteAxe, "Shroomite Axe");
		LanguageRegistry.addName(ShroomiteSword, "Shroomite Sword");
		LanguageRegistry.addName(ShroomiteShovel, "Shroomite Shovel");
		LanguageRegistry.addName(ShroomitePickaxe, "Shroomite Pickaxe");
		
		// World generators
		GameRegistry.registerWorldGenerator(new ShroomiteOreGen());
		
		// Proxy registrations
		proxy.registerRenderThings();
		
	}
}
