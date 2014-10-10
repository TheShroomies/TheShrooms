package dk.nvknudsen.theshrooms.proxy;

import net.minecraft.client.renderer.entity.RenderZombie;
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
