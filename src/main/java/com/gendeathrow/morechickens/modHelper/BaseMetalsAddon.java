package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.util.ResourceLocation;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class BaseMetalsAddon extends BaseModAddon
{

	
	public BaseMetalsAddon() 
	{
		super("basemetals", "Base Metals", "textures/entity/basemetals/");
		this.setNeedsModPresent(false);
		this.setStartID(140);
	}
	
	public static ChickensRegistryItem brassChicken = null;
	public static ChickensRegistryItem cupronickelChicken = null; 
	public static ChickensRegistryItem electrumChicken = null;
	public static ChickensRegistryItem invarChicken = null;
	public static ChickensRegistryItem bronzeChicken = null;
	public static ChickensRegistryItem copperChicken = null;
	public static ChickensRegistryItem leadChicken = null;
	public static ChickensRegistryItem nickelChicken = null;
	public static ChickensRegistryItem platinumChicken = null;
	public static ChickensRegistryItem silverOreChicken = null;
	public static ChickensRegistryItem tinChicken = null;
	public static ChickensRegistryItem zincChicken = null;
	public static ChickensRegistryItem steelChicken = null;
	public static ChickensRegistryItem siliconChicken = null;
	public static ChickensRegistryItem sulfurChicken = null;
	public static ChickensRegistryItem saltpeterChicken = null;


	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		invarChicken = addChicken(allChickens, 
				"invarchicken", 
				this.nextID(), 
				"invar_chicken.png", 
				this.getFirstOreDictionary("ingotInvar"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		bronzeChicken = addChicken(allChickens, 
				"bronzechicken", 
				this.nextID(), 
				"bronze_chicken.png", 
				this.getFirstOreDictionary("ingotBronze"), 
				0x9a6731, 0xf6a44e, 
				SpawnType.NONE);
		
		zincChicken = addChicken(allChickens, 
				"zincchicken", 
				this.nextID(), 
				"zinc_chicken.png", 
				this.getFirstOreDictionary("ingotZinc"), 
				0xb7b7b7, 0x868686, 
				SpawnType.NONE);
		
		tinChicken = addChicken(allChickens, 
				"tinchicken", 
				this.nextID(), 
				"tin_chicken.png", 
				this.getFirstOreDictionary("ingotTin"), 
				0xfff7ee, 0xbbb1a7, 
				SpawnType.NONE);
		//TODO
		steelChicken = addChicken(allChickens, 
				"steelchicken", 
				this.nextID(), 
				"steel_chicken.png", 
				this.getFirstOreDictionary("ingotSteel"), 
				0xd3e1e3, 0x8e9799, 
				SpawnType.NONE);
		
		silverOreChicken = addChicken(allChickens, 
				"silverorechicken", 
				this.nextID(), 
				"silver_chicken.png", 
				this.getFirstOreDictionary("ingotSilver"), 
				0xbebebe, 0xffffff, 
				SpawnType.NONE);
		
		platinumChicken = addChicken(allChickens, 
				"platinumchicken", 
				this.nextID(), 
				"platinum_chicken.png", 
				this.getFirstOreDictionary("ingotPlatinum"), 
				0xffffff, 0x8d9a96, 
				SpawnType.NONE);
		
		nickelChicken = addChicken(allChickens, 
				"nickelchicken", 
				this.nextID(), 
				"nickel_chicken.png", 
				this.getFirstOreDictionary("ingotNickel"), 
				0xefffec, 0xa2b69f, 
				SpawnType.NONE);
		//TODO
		leadChicken = addChicken(allChickens, 
				"leadchicken", 
				this.nextID(), 
				"lead_chicken.png", 
				this.getFirstOreDictionary("ingotLead"), 
				0x777777, 0x383838, 
				SpawnType.NONE); 
		
		copperChicken = addChicken(allChickens, 
				"copperchicken", 
				this.nextID(), 
				"copper_chicken.png", 
				this.getFirstOreDictionary("ingotCopper"), 
				0xc06a48, 0xff9d76, 
				SpawnType.NONE); 
		
		brassChicken = addChicken(allChickens, 
				"brasschicken", 
				this.nextID(), 
				"brass_chicken.png", 
				this.getFirstOreDictionary("ingotBrass"), 
				0xa99340, 0xffe377, 
				SpawnType.NONE); 
		
		cupronickelChicken = addChicken(allChickens, 
				"cupronickelchicken", 
				this.nextID(), 
				"cupronickel_chicken.png", 
				this.getFirstOreDictionary("ingotCupronickel"), 
				0xd8ccb4, 0x98896c, 
				SpawnType.NONE); 
		
		electrumChicken = addChicken(allChickens, 
				"electrumchicken", 
				this.nextID(), 
				"electrum_chicken.png", 
				this.getFirstOreDictionary("ingotElectrum"), 
				0xfff2b1, 0xd4be50, 
				SpawnType.NONE); 
		
		siliconChicken =  addChicken(allChickens, 
				"siliconchicken", 
				this.nextID(), 
				"silicon_chicken.png", 
				this.getFirstOreDictionary("itemSilicon"), 
				0x5f706b, 0x424242, 
				SpawnType.NONE); 
		
		sulfurChicken =  addChicken(allChickens, 
				"sulfurchicken", 
				this.nextID(), 
				"sulfur_chicken.png", 
				this.getFirstOreDictionary("dustSulfur"), 
				0xFFE782, 0xAD9326, 
				SpawnType.NONE); 
		
		saltpeterChicken =  addChicken(allChickens, 
				"saltpeterchicken", 
				this.nextID(), 
				"saltpeter_chicken.png", 
				this.getFirstOreDictionary("dustSaltpeter"), 
				0xDDD6D6, 0xAC9E9D, 
				SpawnType.NONE); 
		
		return allChickens;
	}


	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(brassChicken, copperChicken, zincChicken);
		setParents(bronzeChicken, copperChicken, tinChicken);
		setParents(invarChicken, IronChicken, nickelChicken);
		setParents(cupronickelChicken, copperChicken, nickelChicken);
		setParents(electrumChicken, silverOreChicken, GoldChicken);
		setParents(steelChicken, IronChicken, CoalChicken);
		setParents(copperChicken, YellowChicken, BrownChicken);
		setParents(leadChicken, IronChicken, CyanChicken);
		setParents(tinChicken, WhiteChicken, ClayChicken);
		setParents(nickelChicken, WhiteChicken, GreenChicken);
		setParents(zincChicken, WhiteChicken, ClayChicken);
		setParents(silverOreChicken, IronChicken, WhiteChicken);
		setParents(platinumChicken, nickelChicken, silverOreChicken);
		setParents(sulfurChicken, GunpowderChicken, FlintChicken);
		setParents(saltpeterChicken, sulfurChicken, RedstoneChicken);
		setParents(siliconChicken, ClayChicken, SandChicken);	
	}



}
