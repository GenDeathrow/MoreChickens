package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.gendeathrow.morechickens.core.ModItems;
import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.ItemStack;

public class MoreChickens extends BaseModAddon
{

	public static ChickensRegistryItem xpChicken;

	
	
	public MoreChickens() 
	{
		super(ChickensMore.MODID, ChickensMore.NAME, "textures/entity/");
		this.setNeedsModPresent(false);
		this.setStartID(500);
		
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
        xpChicken = addChicken(allChickens, 
				"xpChicken", 
				this.nextID(), 
				"xp_chicken.png", 
				new ItemStack(ModItems.solidXp, 1 , 0), 
				0x3dff1e, 0x3ff123, 
				SpawnType.NONE); 
        		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(xpChicken, EmeraldChicken, GreenChicken);
	}

}
