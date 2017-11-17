package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class MineFactoryReloadedAddon extends BaseModAddon
{
	public static ChickensRegistryItem pinkSlimeChicken = null;
	
	public MineFactoryReloadedAddon() 
	{
		super("minefactoryreloaded", "MineFactory Reloaded", "textures/entity/minefactoryreloaded/");
		this.setStartID(2200);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		
		pinkSlimeChicken = addChicken(allChickens, 
				"pinkslimechicken", 
				this.nextID(), 
				"pink_slime_chicken.png", 
				this.getFirstOreDictionary("slimeballPink"), 
				0xC8738A, 0x804954, 
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(pinkSlimeChicken, PinkChicken, SlimeChicken);
	}

}
