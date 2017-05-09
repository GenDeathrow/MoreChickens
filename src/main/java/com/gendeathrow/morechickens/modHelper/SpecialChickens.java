package com.gendeathrow.morechickens.modHelper;

import java.util.Collection;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistry;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class SpecialChickens 
{

	public static ChickensRegistryItem chickenosto;
	public static ChickensRegistryItem funwaychick;
	public static ChickensRegistryItem boopbeepchick;
	
	public static List<ChickensRegistryItem> init(List<ChickensRegistryItem> allChickens)
	{
		
        //Darkostos Chicken        
        chickenosto = new ChickensRegistryItem(
                2025, "chickenosto", new ResourceLocation(ChickensMore.MODID, "textures/entity/chickenosto.png"),
                new ItemStack(Items.CAKE, 1 , 0),
                0x000000, 0xffffff){
        	@Override
        	public boolean canSpawn() 
        	{
        		return true;
        	}
        	@Override
            public int getTier() 
            {
            	return 5;
            }
        };
        chickenosto.setNoParents();
        chickenosto.setSpawnType(SpawnType.NONE);
        
        allChickens.add(chickenosto);
        
        //Funwayguy Chicken
        funwaychick = new ChickensRegistryItem(
                2026, "funwaychick", new ResourceLocation(ChickensMore.MODID, "textures/entity/funwaychick.png"),
                new ItemStack(Items.FIREWORKS, 1 , 0),
                0x4e6961, 0x215a1b){
        	
        	@Override
        	public boolean canSpawn() 
        	{
        		return true;
        	}  
        	@Override
            public int getTier() 
            {
            	return 5;
            }
        };
        funwaychick.setNoParents();
        funwaychick.setSpawnType(SpawnType.NONE);

        
        allChickens.add(funwaychick);

        //Boop_beep Chicken
        boopbeepchick = new ChickensRegistryItem(
                2027, "boopbeepchick", new ResourceLocation(ChickensMore.MODID, "textures/entity/boop_beepchick.png"),
                new ItemStack(Blocks.GRASS, 1),
                0x455A2B, 0x546E34){
        	
        	@Override
        	public boolean canSpawn() 
        	{
        		return true;
        	}  
        	@Override
            public int getTier() 
            {
            	return 5;
            }
        };
        boopbeepchick.setNoParents();
        boopbeepchick.setSpawnType(SpawnType.NONE);

        
        allChickens.add(boopbeepchick);
        
        return allChickens;
	}
	
	
}
