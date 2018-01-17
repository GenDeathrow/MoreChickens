package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class EnderIOAddon extends BaseModAddon
{

	public static ChickensRegistryItem electricalSteelChicken = null;
	public static ChickensRegistryItem energeticAlloyChicken = null;
	public static ChickensRegistryItem vibrantAlloyChicken = null;
	public static ChickensRegistryItem redstoneAlloyChicken = null;
	public static ChickensRegistryItem conductiveIronChicken = null;
	public static ChickensRegistryItem pulsatingIronChicken = null;
	public static ChickensRegistryItem darkSteelChicken = null;
	public static ChickensRegistryItem soulariumChicken = null;
	public static ChickensRegistryItem conduitBinderChicken = null;
	public static ChickensRegistryItem basicCapacitorChicken = null;
	
	public EnderIOAddon() 
	{
		super("enderio", "EnderIO", "textures/entity/enderio/");
		this.setStartID(2030);
	}
	/**
	 * 	Created By: bogger33
	 */
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		electricalSteelChicken = addChicken(allChickens, 
				"electricalSteelChicken", 
				this.nextID(), 
				"electrical_steel_chicken.png", 
				this.getFirstOreDictionary("ingotElectricalSteel"), 
				0x939393, 0x474747, 
				SpawnType.NONE);
		
		energeticAlloyChicken = addChicken(allChickens, 
				"energeticAlloyChicken", 
				this.nextID(), 
				"energetic_alloy_chicken.png", 
				this.getFirstOreDictionary("ingotEnergeticAlloy"), 
				0xea6c05, 0x65321b, 
				SpawnType.NONE);
		
		vibrantAlloyChicken = addChicken(allChickens, 
				"vibrantAlloyChicken", 
				this.nextID(), 
				"vibrant_alloy_chicken.png", 
				this.getFirstOreDictionary("ingotVibrantAlloy"), 
				0xbcf239, 0x779c1d, 
				SpawnType.NONE);
		
		redstoneAlloyChicken = addChicken(allChickens, 
				"redstoneAlloyChicken", 
				this.nextID(), 
				"redstone_alloy_chicken.png", 
				this.getFirstOreDictionary("ingotRedstoneAlloy"), 
				0xd03939, 0x621919, 
				SpawnType.NONE); 
		
		conductiveIronChicken = addChicken(allChickens, 
				"conductiveIronChicken", 
				this.nextID(), 
				"conductive_iron_chicken.png", 
				this.getFirstOreDictionary("ingotConductiveIron"), 
				0xCC9D96, 0x7E6764, 
				SpawnType.NONE); 
		
		pulsatingIronChicken = addChicken(allChickens, 
				"pulsatingIronChicken", 
				this.nextID(), 
				"pulsating_iron_chicken.png", 
				this.getFirstOreDictionary("ingotPulsatingIron"), 
				0x6FE78B, 0x406448, 
				SpawnType.NONE);
		
		darkSteelChicken = addChicken(allChickens, 
				"darkSteelChicken", 
				this.nextID(), 
				"dark_steel_chicken.png", 
				this.getFirstOreDictionary("ingotDarkSteel"), 
				0x4D4D4E, 0x242424, 
				SpawnType.NONE);
		
		soulariumChicken = addChicken(allChickens, 
				"soulariumChicken", 
				this.nextID(), 
				"soularium_chicken.png", 
				this.getFirstOreDictionary("ingotSoularium"), 
				0x6F5C36, 0x4E371A, 
				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(electricalSteelChicken, IronChicken, BaseMetalsAddon.siliconChicken);
		setParents(energeticAlloyChicken, GoldChicken, GlowstoneChicken);
		setParents(vibrantAlloyChicken, energeticAlloyChicken, EnderChicken);
		setParents(redstoneAlloyChicken, RedstoneChicken, BaseMetalsAddon.siliconChicken);
		setParents(conductiveIronChicken, RedstoneChicken, IronChicken);
		setParents(pulsatingIronChicken, IronChicken, EnderChicken);
		setParents(darkSteelChicken, IronChicken, ObsidianChicken);
		setParents(soulariumChicken, SoulSandChicken, GoldChicken);
	}

}
