package com.gendeathrow.morechickens.modHelper;

import java.util.List;


import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class ImmersiveEngineeringAddon extends BaseModAddon
{

	public static ChickensRegistryItem aluminunChicken = null;
	public static ChickensRegistryItem uraniumChicken = null; 
	public static ChickensRegistryItem constantanChicken = null;
	
	public ImmersiveEngineeringAddon() 
	{
		super("immersiveengineering", "Immersive Engineering", "textures/entity/immersive_engineering/");
		this.setNeedsModPresent(false);
		this.setStartID(2001);
	}


	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		aluminunChicken = addChicken(allChickens, 
				"aluminunChicken", 
				this.nextID(), 
				"aluminium_chicken.png", 
				this.getFirstOreDictionary("ingotAluminum"), 
				0xd3dddc, 0xcbd7d6, 
				SpawnType.NONE);
		
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
		setParents(aluminunChicken, FlintChicken, IronChicken);
		setParents(uraniumChicken, RedstoneChicken, EnderChicken);
		setParents(constantanChicken, BaseMetalsAddon.copperChicken, BaseMetalsAddon.nickelChicken);
	}
}
