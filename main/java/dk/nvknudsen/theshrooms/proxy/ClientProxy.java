package dk.nvknudsen.theshrooms.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import dk.nvknudsen.theshrooms.mob.RenderShroombie;
import dk.nvknudsen.theshrooms.mob.Shroombie;

public class ClientProxy extends CommonProxy{
	
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(Shroombie.class, new RenderShroombie());
	}
    public void registerSound(){
    	
    }
    
}
