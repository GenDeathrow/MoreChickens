package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class ImmersiveEngineeringAddon extends BaseModAddon
{

	public static ChickensRegistryItem uraniumChicken = null; 
	public static ChickensRegistryItem constantanChicken = null;
	
	public ImmersiveEngineeringAddon() 
	{
		super("immersiveengineering", "Immersive Engineering", "textures/entity/immersive_engineering/");
		this.setNeedsModPresent(false);
		this.setStartID(2001);
	}

	/**
	 * Textures Created by "MrAmericanMike"
	 */
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{		
		uraniumChicken = addChicken(allChickens, 
				"uraniumChicken", 
				this.nextID(), 
				"uranium_chicken.png", 
				this.getFirstOreDictionary("ingotUranium"), 
				0x91d76d, 0x9ce26c, 
				SpawnType.NONE);
		
		constantanChicken = addChicken(allChickens, 
				"constantanChicken", 
				this.nextID(), 
				"consrtantan_chicken.png", 
				this.getFirstOreDictionary("ingotConstantan"), 
				0xf98669, 0x795851, 
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(uraniumChicken, RedstoneChicken, EnderChicken);
		setParents(constantanChicken, BaseMetalsAddon.copperChicken, BaseMetalsAddon.nickelChicken);
	}
}
