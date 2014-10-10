package dk.nvknudsen.theshrooms.mob;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderShroombie extends RenderBiped{
	
	public RenderShroombie()
	{
		super(new ModelZombie(),0.5F);
	}

	public ResourceLocation getEntityTexture(Entity par1Entity)
    {
    	return new ResourceLocation("theshrooms:textures/entity/shroombie.png");
    }
}
