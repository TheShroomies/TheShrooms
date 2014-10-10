package dk.nvknudsen.theshrooms.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class Shroombie extends EntityMob{

	public Shroombie(World par1World)
	{
		super(par1World);
	}
	
	public boolean attackEntityAsMob(Entity e)
	{
		e.worldObj.spawnParticle("heart", this.posX, this.posY+this.height+0.1D, this.posZ, 0.0D, 0.0D, 0.0D);
		e.worldObj.playSoundAtEntity(this, "mob.cow.say", 1.0f, 1.0f);
		return true;
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.2D);
	}

}
