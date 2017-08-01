package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class ExtremeReactorsAddon extends BaseModAddon
{
    public static ChickensRegistryItem yelloriumChicken = null;
    public static ChickensRegistryItem cyaniteChicken = null;
    public static ChickensRegistryItem blutoniumChicken = null;
    public static ChickensRegistryItem ludicriteChicken = null;
    public static ChickensRegistryItem graphiteChicken = null;
    
	public ExtremeReactorsAddon() 
	{
		super("bigreactors", "Extreme Reactors", "textures/entity/extreme_reactors/");
		this.setStartID(2100);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		yelloriumChicken = addChicken(allChickens, 
				"yelloriumChicken", 
				this.nextID(), 
				"yellorium_chicken.png", 
				this.getFirstOreDictionary("ingotYellorium"), 
				0xA5B700, 0xD7EF00, 
				SpawnType.NONE);
		
		graphiteChicken = addChicken(allChickens, 
				"graphiteChicken", 
				this.nextID(), 
				"graphite_chicken.png", 
				this.getFirstOreDictionary("ingotGraphite"), 
				0x41453F, 0x595959, 
				SpawnType.NONE);
		
		cyaniteChicken = addChicken(allChickens, 
				"cyaniteChicken", 
				this.nextID(), 
				"cyanite_chicken.png", 
				this.getFirstOreDictionary("ingotCyanite"), 
				0x0068B4, 0x5CAFDB, 
				SpawnType.NONE); 
		
		blutoniumChicken = addChicken(allChickens, 
				"blutoniumChicken", 
				this.nextID(), 
				"blutonium_chicken.png", 
				this.getFirstOreDictionary("ingotBlutonium"), 
				0x4642D6, 0xf5fcf1, 
				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(yelloriumChicken, GlowstoneChicken, EnderChicken);

		setParents(graphiteChicken, CoalChicken, BlackChicken);
		
		setParents(cyaniteChicken, yelloriumChicken, SandChicken);
		
		setParents(blutoniumChicken, cyaniteChicken, WaterChicken);

	}

}
