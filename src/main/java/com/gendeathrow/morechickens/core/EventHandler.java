package com.gendeathrow.morechickens.core;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.gendeathrow.morechickens.modHelper.ImmersiveEngineering;
import com.setycz.chickens.chicken.EntityChickensChicken;

public class EventHandler 
{

	
	
	
	@SuppressWarnings("unused")
	@SubscribeEvent
	public static void LivingEvent(LivingUpdateEvent event)
	{
		if(event.getEntityLiving() instanceof EntityChickensChicken)
		{
			EntityChickensChicken chicken = (EntityChickensChicken) event.getEntityLiving();
			int type = 0;
			
			NBTTagCompound tag = null;
			chicken.writeEntityToNBT(tag);
			
			if(tag==null) return;
			
			if(tag.hasKey("Type"))
			{
				type = tag.getInteger("Type");
			}else return;
			
			
			if( ImmersiveEngineering.uraniumChicken != null && type == ImmersiveEngineering.uraniumChicken.getId())
			{
				if(chicken.getRNG().nextDouble() < .2)
				{
					chicken.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, chicken.posX - chicken.motionX * 0.25D, chicken.posY - chicken.motionY * 0.25D, chicken.posZ - chicken.motionZ * 0.25D, chicken.motionX, chicken.motionY, chicken.motionZ, new int[0]);
				}
			}
		}
	}
}
