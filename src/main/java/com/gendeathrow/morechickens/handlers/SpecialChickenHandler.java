package com.gendeathrow.morechickens.handlers;

import com.gendeathrow.morechickens.modHelper.SpecialChickens;
import com.setycz.chickens.entity.EntityChickensChicken;
import com.setycz.chickens.registry.ChickensRegistry;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpecialChickenHandler 
{

	@SubscribeEvent
	public void transformChicken (PlayerInteractEvent.EntityInteract event)
	{
        ItemStack item = event.getEntityPlayer().getHeldItem(event.getHand());
        
        if (item == null) {
            return;
        }
        if (!(event.getTarget() instanceof EntityChicken) || (event.getTarget() instanceof EntityChickensChicken)) {
            return;
        }

        World worldObj = event.getEntityPlayer().world;
        if (worldObj.isRemote) {
            return;
        }
        
        ChickensRegistryItem chickenDescription = null;
        
        if(item.getItem() == Items.CAKE)
        	chickenDescription = SpecialChickens.chickenosto;
        if(item.getItem() == Item.getItemFromBlock(Blocks.TNT))
        	chickenDescription = SpecialChickens.funwaychick;
        if(item.getItem() == Item.getItemFromBlock(Blocks.GRASS))
        	chickenDescription = SpecialChickens.boopbeepchick;
        if(item.getItem() == Items.BANNER)
        	chickenDescription = SpecialChickens.mramericanchick;
        
        if (chickenDescription == null || !chickenDescription.isEnabled()) {
            return;
        }
        
        EntityChicken chicken = (EntityChicken) event.getTarget();
        
        EntityChickensChicken smartChicken = convertChicken(chicken, worldObj, chickenDescription);

        worldObj.removeEntity(chicken);
        worldObj.spawnEntity(smartChicken);
        smartChicken.spawnExplosionParticle();
        
        item.shrink(1);
        
        event.setCanceled(true);
	}
	
    private EntityChickensChicken convertChicken(EntityChicken chicken, World worldObj, ChickensRegistryItem chickenDescription) 
    {
        EntityChickensChicken ChickensChicken = new EntityChickensChicken(worldObj);
        ChickensChicken.setPositionAndRotation(chicken.posX, chicken.posY, chicken.posZ, chicken.rotationYaw, chicken.rotationPitch);
        ChickensChicken.onInitialSpawn(worldObj.getDifficultyForLocation(chicken.getPosition()), null);
        ChickensChicken.setChickenType(chickenDescription.getRegistryName().toString());
        if (chicken.hasCustomName()) {
        	ChickensChicken.setCustomNameTag(chicken.getCustomNameTag());
        }
        ChickensChicken.setGrowingAge(chicken.getGrowingAge());
        return ChickensChicken;
    }
    
	
//	@SuppressWarnings("unused")
//	@SubscribeEvent
//	public void LivingEvent(LivingUpdateEvent event)
//	{
//		if(event.getEntityLiving() instanceof EntityChickensChicken)
//		{
//			EntityChickensChicken chicken = (EntityChickensChicken)event.getEntityLiving();
//			
//			
//			if(getTypeFromChicken(chicken) == SpecialChickens.funwaychick)
//			{
//				System.out.println("dark");
//				
//				if(!chicken.captureDrops) chicken.captureDrops = true;
//				
//				for(EntityItem stack : chicken.capturedDrops)
//				{
//					if(stack.getEntityItem().getItem() == Items.FIREWORKS)
//					{
//				
//						if(!chicken.worldObj.isRemote)
//						{
//					         EntityFireworkRocket entityfireworkrocket = new EntityFireworkRocket(chicken.worldObj, chicken.getPosition().getX(), chicken.getPosition().getY(), chicken.getPosition().getZ(), stack.getEntityItem());
//					         chicken.worldObj.spawnEntityInWorld(entityfireworkrocket);
//						}
//
//						
//					}
//				}
//			}
//			
////			EntityChickensChicken chicken = (EntityChickensChicken) event.getEntityLiving();
////			
////			if( ImmersiveEngineering.uraniumChicken != null && type == ImmersiveEngineering.uraniumChicken.getId())
////			{
////				if(chicken.getRNG().nextDouble() < .2)
////				{
////					chicken.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, chicken.posX - chicken.motionX * 0.25D, chicken.posY - chicken.motionY * 0.25D, chicken.posZ - chicken.motionZ * 0.25D, chicken.motionX, chicken.motionY, chicken.motionZ, new int[0]);
////				}
////			}
//		}
//	}
    
    
    public ChickensRegistryItem getTypeFromChicken(EntityChickensChicken chicken)
    {
    	NBTTagCompound tag = new NBTTagCompound();
    	chicken.readFromNBT(tag);
    	
    	return ChickensRegistry.getByRegistryName(tag.getString("Type"));
    }
    
    
}
