package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class TinkersConstructAddon extends BaseModAddon
{
	public static ChickensRegistryItem arditeChicken = null;
	public static ChickensRegistryItem colbaltChicken = null; 
	public static ChickensRegistryItem manyullynChicken = null;
	public static ChickensRegistryItem pigIronChicken = null;
	public static ChickensRegistryItem knightSlimeChicken = null; 
	public static ChickensRegistryItem bloodSlimeChicken = null;
	public static ChickensRegistryItem purpleSlimeChicken = null;
	public static ChickensRegistryItem magmaSlimeChicken = null; 
	public static ChickensRegistryItem blueSlimeChicken = null;
	
	public TinkersConstructAddon() 
	{
		super("tconstruct", "Tinkers Construct", "textures/entity/tinkers/");
		this.setStartID(80);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		
		arditeChicken = addChicken(allChickens, 
				"arditeChicken", 
				this.nextID(), 
				"ArditeChicken.png", 
				this.getFirstOreDictionary("ingotArdite"), 
				0xdc3e00, 0xffb20b, 
				SpawnType.NONE);
		
		colbaltChicken = addChicken(allChickens, 
				"colbaltChicken", 
				this.nextID(), 
				"ColbaltChicken.png", 
				this.getFirstOreDictionary("ingotCobalt"), 
				0x0c5abe, 0x03d94f1, 
				SpawnType.NONE);
		
		manyullynChicken = addChicken(allChickens, 
				"manyullynChicken", 
				this.nextID(), 
				"ManyullynChicken.png", 
				this.getFirstOreDictionary("ingotManyullyn"), 
				0x652e87, 0xbc8fe7, 
				SpawnType.NONE);
		
		pigIronChicken = addChicken(allChickens, 
				"pigIronChicken", 
				this.nextID(), 
				"PigIronChicken.png", 
				this.getFirstOreDictionary("ingotPigiron"), 
				0xe6b8b8, 0xdba9a9, 
				SpawnType.NONE);
		
		knightSlimeChicken = addChicken(allChickens, 
				"knightSlimeChicken", 
				this.nextID(), 
				"KnightSlimeChicken.png", 
				this.getFirstOreDictionary("ingotKnightslime"), 
				0xc17ced, 0xad70d8, 
				SpawnType.NONE);
		
		bloodSlimeChicken = addChicken(allChickens, 
				"bloodSlime", 
				this.nextID(), 
				"BloodSlime.png", 
				this.getFirstOreDictionary("slimeballBlood"), 
				0xc50616, 0xee0316, 
				SpawnType.NONE);
		
		purpleSlimeChicken = addChicken(allChickens, 
				"purpleSlime", 
				this.nextID(), 
				"PurpleSlime.png", 
				this.getFirstOreDictionary("slimeballPurple"), 
				0xc9aad9, 0x7511bf, 
				SpawnType.NONE);
		
		magmaSlimeChicken = addChicken(allChickens, 
				"magmaSlime", 
				this.nextID(), 
				"MagmaSlime.png", 
				this.getFirstOreDictionary("slimeballMagma"), 
				0xecb55f, 0xaf7314, 
				SpawnType.NONE);
		
		blueSlimeChicken = addChicken(allChickens, 
				"blueSlime", 
				this.nextID(), 
				"BlueSlime.png", 
				this.getFirstOreDictionary("slimeballBlue"), 
				0x67b4c4, 0x30717f, 
				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(arditeChicken, BlazeChicken, MagmaChicken);
		setParents(colbaltChicken, NetherWartChicken, GhastChicken);
		setParents(manyullynChicken, arditeChicken, colbaltChicken);
		setParents(pigIronChicken, arditeChicken, IronChicken);
		setParents(knightSlimeChicken, manyullynChicken, pigIronChicken);
		setParents(bloodSlimeChicken, SlimeChicken, RedChicken);
		setParents(purpleSlimeChicken, bloodSlimeChicken, BlueChicken);
		setParents(magmaSlimeChicken, SlimeChicken, MagmaChicken);
		setParents(blueSlimeChicken, SlimeChicken, BlueChicken);
	}

}
