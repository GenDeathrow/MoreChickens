package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BotaniaAddon extends BaseModAddon
{
	
	@GameRegistry.ObjectHolder("botania:manaresource") // 19
	public static final Item manaresource = null;

	public static ChickensRegistryItem elementiumChicken = null;
	public static ChickensRegistryItem manasteelChicken = null; 
	public static ChickensRegistryItem terrasteelChicken = null;


	public BotaniaAddon() 
	{
		super("botania", "Botania","textures/entity/botania/");
		this.setStartID(120);
		this.setNeedsModPresent(true);
		
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		ItemStack terrasteel = new ItemStack(manaresource,1,4);
		terrasteelChicken = addChicken(allChickens, 
				"terrasteelchicken", 
				this.nextID(), 
				"terrasteel_chicken.png", 
				terrasteel, 
				0x3ff123, 0xf5fcf1, 
				SpawnType.NONE);
		

		ItemStack manasteel = new ItemStack(manaresource);
		manasteelChicken = addChicken(allChickens, 
				"manasteelchicken", 
				this.nextID(), 
				"manasteel_chicken.png", 
				manasteel, 
				0x69d7ff, 0x002c4b, 
				SpawnType.NONE);
		
		ItemStack elementium = new ItemStack(manaresource,1,19);
		elementiumChicken = addChicken(allChickens, 
				"elementiumchicken", 
				this.nextID(), 
				"elementium_chicken.png", 
				elementium, 
				0xf655f3, 0xb407b7, 
				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(manasteelChicken, IronChicken, GhastChicken);
		setParents(terrasteelChicken, EnderChicken, PCrystalChicken);
		setParents(elementiumChicken, manasteelChicken, terrasteelChicken);
	}

}
