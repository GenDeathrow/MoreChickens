package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class EvilCraftAddon extends BaseModAddon
{
	public static ChickensRegistryItem darkGemChicken = null;
	
	public EvilCraftAddon() 
	{
		super("evilcraft", "EvilCraft", "textures/entity/evilcraft/");
		this.setStartID(2160);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		
		darkGemChicken = addChicken(allChickens, 
				"darkgemchicken", 
				this.nextID(), 
				"dark_gem_chicken.png", 
				this.getFirstOreDictionary("gemDark"), 
				0x1A1A1A, 0x414141, 
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(darkGemChicken, EmeraldChicken, CoalChicken);
	}

}
