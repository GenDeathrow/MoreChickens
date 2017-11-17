package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MekanismAddon extends BaseModAddon{

	public static ChickensRegistryItem osmiumChicken = null;
	public static ChickensRegistryItem refinedGlowstoneChicken = null; 
	public static ChickensRegistryItem refinedObsidianChicken = null;
	
	public MekanismAddon() 
	{
		super("mekanism", "Mekanism", "textures/entity/mekanism/");
		this.setNeedsModPresent(false);
		this.setStartID(2010);
	}

	/**
	 * Textures Created by "MrAmericanMike"
	 */
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		Item item = Item.getByNameOrId("mekanism:Ingot");
		
		if(item != null)
		{
			osmiumChicken = addChicken(allChickens, 
					"osmiumChicken", 
					this.nextID(), 
					"osmium_chicken.png", 
					new ItemStack(item, 1, 1), 
					0x989585, 0xd1ccb6, 
					SpawnType.NONE);
		}
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(osmiumChicken, IronChicken, QuartzChicken);
	}

}
