package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class ThermalFoundationAddon extends BaseModAddon{

	public static ThermalFoundationAddon INSTANCE;
	
	public static ChickensRegistryItem basalzRodChicken = null;
	public static ChickensRegistryItem blitzRodChicken = null;
	public static ChickensRegistryItem blizzRodChicken = null;
	public static ChickensRegistryItem cinnabarChicken = null;
	public static ChickensRegistryItem enderiumChicken = null;
	public static ChickensRegistryItem iridiumChicken = null;
	public static ChickensRegistryItem lumiumChicken = null;
	public static ChickensRegistryItem mithrilChicken = null;
	public static ChickensRegistryItem signalumChicken = null;
	public static ChickensRegistryItem richSlagChicken = null;
	public static ChickensRegistryItem slagChicken = null;
	public static ChickensRegistryItem sawDustChicken = null;
	
	public ThermalFoundationAddon() 
	{
		super("thermalfoundation", "Thermal Foundation", "textures/entity/thermal_foundation/");
		setStartID(2060);
		INSTANCE = this;
	}

	/**
	 * Textures Created by "bogger33"
	 */
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		basalzRodChicken = addChicken(allChickens, 
				"basalzRodChicken", 
				this.nextID(), 
				"basalz_rod_chicken.png", 
				this.getFirstOreDictionary("rodBasalz"), 
				0x980000, 0x6E6664, 
				SpawnType.NONE);
		
		blitzRodChicken = addChicken(allChickens, 
				"blitzRodChicken", 
				this.nextID(), 
				"blitz_rod_chicken.png", 
				this.getFirstOreDictionary("rodBlitz"), 
				0xECE992, 0x66E5EF, 
				SpawnType.NONE); 
		
		blizzRodChicken = addChicken(allChickens, 
				"blizzRodChicken", 
				this.nextID(), 
				"blizz_rod_chicken.png", 
				this.getFirstOreDictionary("rodBlizz"), 
				0x88E0FF, 0x1D3B95, 
				SpawnType.NONE); 
		
		cinnabarChicken = addChicken(allChickens, 
				"cinnabarChicken", 
				this.nextID(), 
				"cinnabar_chicken.png", 
				this.getFirstOreDictionary("crystalCinnabar"), 
				0xE49790, 0x9B3229, 
				SpawnType.NONE); 
		
		enderiumChicken = addChicken(allChickens, 
				"enderiumChicken", 
				this.nextID(), 
				"enderium_chicken.png", 
				this.getFirstOreDictionary("nuggetEnderium"), 
				0x127575, 0x0A4849, 
				SpawnType.NONE);
		
		iridiumChicken = addChicken(allChickens, 
				"iridiumChicken", 
				this.nextID(), 
				"iridium_chicken.png", 
				this.getFirstOreDictionary("nuggetIridium"), 
				0xEDEBF1, 0xBBBCDD, 
				SpawnType.NONE); 
		
		lumiumChicken = addChicken(allChickens, 
				"lumiumChicken", 
				this.nextID(), 
				"lumium_chicken.png", 
				this.getFirstOreDictionary("ingotLumium"), 
				0xEEF4DF, 0xF4B134, 
				SpawnType.NONE);
		
		mithrilChicken = addChicken(allChickens, 
				"mithrilChicken", 
				this.nextID(), 
				"mithril_chicken.png", 
				this.getFirstOreDictionary("ingotMithril"), 
				0x5A89A8, 0xA7FFFF, 
				SpawnType.NONE); 
		
		signalumChicken = addChicken(allChickens, 
				"signalumChicken", 
				this.nextID(), 
				"signalum_chicken.png", 
				this.getFirstOreDictionary("ingotSignalum"), 
				0xFFA424, 0xC63200, 
				SpawnType.NONE); 
		
		slagChicken = addChicken(allChickens, 
				"slagChicken", 
				this.nextID(), 
				"slag_chicken.png", 
				this.getFirstOreDictionary("crystalSlag"), 
				0x83715E, 0x443B31, 
				SpawnType.NONE);
		
		richSlagChicken = addChicken(allChickens, 
				"richSlagChicken", 
				this.nextID(), 
				"rich_slag_chicken.png", 
				this.getFirstOreDictionary("crystalSlagRich"), 
				0x5B3F20, 0x3D2915, 
				SpawnType.NONE);
		
//		sawDustChicken = addChicken(allChickens, 
//				"sawDustChicken", 
//				this.nextID(), 
//				"sawdust_chicken.png", 
//				this.getFirstOreDictionary("dustSaw"), 
//				0x5B3F20, 0x3D2915, 
//				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(basalzRodChicken, BaseMetalsAddon.saltpeterChicken, BlazeChicken);
		setParents(blitzRodChicken, basalzRodChicken, BaseMetalsAddon.sulfurChicken);
		setParents(blizzRodChicken, blitzRodChicken, SnowballChicken);
		setParents(slagChicken, RedstoneChicken, IronChicken);
		setParents(richSlagChicken, slagChicken, slagChicken);
		setParents(cinnabarChicken, richSlagChicken, DiamondChicken);
		setParents(signalumChicken, BaseMetalsAddon.copperChicken, BaseMetalsAddon.silverOreChicken);
		setParents(enderiumChicken, BaseMetalsAddon.platinumChicken, EnderChicken);
		setParents(iridiumChicken, enderiumChicken, blizzRodChicken);
		setParents(lumiumChicken, BaseMetalsAddon.tinChicken, GlowstoneChicken);
		setParents(mithrilChicken, iridiumChicken, GoldChicken);
	}

}
