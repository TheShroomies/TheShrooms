package dk.nvknudsen.theshrooms;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "theshrooms", version = Main.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Main{
	public final static String version = "a1.0.0";
	@EventHandler
	public void init(FMLInitializationEvent e){
		System.out.println("Initializing TheShrooms v. "+version);
		
	}
}
