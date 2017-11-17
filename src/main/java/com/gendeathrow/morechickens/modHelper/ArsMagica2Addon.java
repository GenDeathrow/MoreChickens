package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class ArsMagica2Addon extends BaseModAddon
{
	public static ChickensRegistryItem vinteumChicken = null;
	
	public ArsMagica2Addon() 
	{
		super("arsmagica2", "Ars Magica 2", "textures/entity/arsmagica2/");
		this.setStartID(2220);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		
		vinteumChicken = addChicken(allChickens, 
				"vinteumchicken", 
				this.nextID(), 
				"vinteum_chicken.png", 
				this.getFirstOreDictionary("dustVinteum"), 
				0x625FE7, 0x2E3CC7, 
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(vinteumChicken, DiamondChicken, BlueChicken);
	}

}
