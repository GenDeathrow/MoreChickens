package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.gendeathrow.morechickens.core.ModItems;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class MoreChickens extends BaseModAddon
{

	public static ChickensRegistryItem xpChicken;
	public static ChickensRegistryItem pShardChicken;
	public static ChickensRegistryItem pCrystalChicken;
	public static ChickensRegistryItem obsidianChicken;
	public static ChickensRegistryItem soulSandChicken;
	
	
	public MoreChickens() 
	{
		super(ChickensMore.MODID, ChickensMore.NAME, "textures/entity/");
		this.setNeedsModPresent(false);
		this.setStartID(500);
		
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
        xpChicken = addChicken(allChickens, 
				"xpChicken", 
				this.nextID(), 
				"XpChicken.png", 
				new ItemStack(ModItems.solidXp, 1 , 0), 
				0x3dff1e, 0x3ff123, 
				SpawnType.NONE); 
        		

        //Prismarine shard        
        pShardChicken  = addChicken(allChickens, 
				"pShardChicken", 
				this.nextID(), 
				"PShardChicken.png", 
				new ItemStack(Items.PRISMARINE_SHARD, 1 , 0), 
				0x43806e, 0x9fcbbc, 
				SpawnType.NONE);
        
        //Prismarine crystal        
        pCrystalChicken = addChicken(allChickens, 
				"pCrystalChicken", 
				this.nextID(), 
				"PCrystalChicken.png", 
				new ItemStack(Items.PRISMARINE_CRYSTALS, 1 , 0), 
				0x4e6961, 0xdfe9dc, 
				SpawnType.NONE); 
        
        
        obsidianChicken = addChicken(allChickens, 
				"obsidianChicken", 
				this.nextID(), 
				"obsidian_chicken.png", 
				new ItemStack(Blocks.OBSIDIAN, 1 , 0), 
				0x08080e, 0x463a60, 
				SpawnType.NONE); 
        
        
        soulSandChicken = addChicken(allChickens, 
				"soulSandChicken", 
				this.nextID(), 
				"soulsand_chicken.png", 
				new ItemStack(Blocks.SOUL_SAND, 1 , 0), 
				0x453125, 0xd52f08, 
				SpawnType.HELL); 
        
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(xpChicken, EmeraldChicken, GreenChicken);
		setParents(pShardChicken, WaterChicken, BlueChicken);
		setParents(pCrystalChicken, WaterChicken, EmeraldChicken);
		setParents(obsidianChicken, WaterChicken, LavaChicken);
	}

}
