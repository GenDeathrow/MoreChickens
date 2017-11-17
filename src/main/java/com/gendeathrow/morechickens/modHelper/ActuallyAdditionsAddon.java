package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ActuallyAdditionsAddon extends BaseModAddon
{

	@GameRegistry.ObjectHolder("actuallyadditions:item_crystal")
	public static final Item itemCrystal = null;

	public static ChickensRegistryItem blackQuartzChicken = null;
	public static ChickensRegistryItem voidCrystalChicken = null;
	public static ChickensRegistryItem palisCrystalChicken = null;
	public static ChickensRegistryItem enoriCrystalChicken = null;
	public static ChickensRegistryItem restoniaCrystalChicken = null;
	public static ChickensRegistryItem emeradicCrystalChicken = null;
	public static ChickensRegistryItem diamantineCrystalChicken = null;

	
	public ActuallyAdditionsAddon() 
	{
		super("actuallyadditions", "Actually Additions", "textures/entity/actuallyadditions/");
		this.setStartID(2140);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{

		ItemStack restoniaCrystal = new ItemStack(itemCrystal, 1, 0);
		restoniaCrystalChicken = addChicken(allChickens, 
				"restoniacrystalchicken", 
				this.nextID(), 
				"restonia_crystal_chicken.png", 
				restoniaCrystal,
				0xCA0000, 0x8C0000, 
				SpawnType.NONE);

		ItemStack palisCrystal = new ItemStack(itemCrystal, 1, 1);
		palisCrystalChicken = addChicken(allChickens, 
				"paliscrystalchicken", 
				this.nextID(), 
				"palis_crystal_chicken.png", 
				palisCrystal,
				0x0E0E84, 0x000048, 
				SpawnType.NONE);

		ItemStack diamantineCrystal = new ItemStack(itemCrystal, 1, 2);
		diamantineCrystalChicken = addChicken(allChickens, 
				"diamantinecrystalchicken", 
				this.nextID(), 
				"diamantine_crystal_chicken.png", 
				diamantineCrystal,
				0xAFB1FF, 0x797CE5, 
				SpawnType.NONE);

		ItemStack voidCrystal = new ItemStack(itemCrystal, 1, 3);
		voidCrystalChicken = addChicken(allChickens, 
				"voidcrystalchicken", 
				this.nextID(), 
				"void_crystal_chicken.png", 
				voidCrystal,
				0x1F1F1F, 0x000000, 
				SpawnType.NONE);

		ItemStack emeradicCrystal = new ItemStack(itemCrystal, 1, 4);
		emeradicCrystalChicken = addChicken(allChickens, 
				"emeradiccrystalchicken", 
				this.nextID(), 
				"emeradic_crystal_chicken.png", 
				emeradicCrystal,
				0x06D306, 0x159A0E, 
				SpawnType.NONE);

		ItemStack enoriCrystal = new ItemStack(itemCrystal, 1, 5);
		enoriCrystalChicken = addChicken(allChickens, 
				"enoricrystalchicken", 
				this.nextID(), 
				"enori_crystal_chicken.png", 
				enoriCrystal,
				0xECE3FF, 0xB5B5B5, 
				SpawnType.NONE);

		blackQuartzChicken = addChicken(allChickens, 
				"blackquartzchicken", 
				this.nextID(), 
				"black_quartz_chicken.png", 
				this.getFirstOreDictionary("gemQuartzBlack"), 
				0x1F1F1F, 0x535353, 
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{

		setParents(blackQuartzChicken, QuartzChicken, BlackChicken);
		setParents(restoniaCrystalChicken, RedstoneChicken, blackQuartzChicken);
		setParents(palisCrystalChicken, BlueChicken, blackQuartzChicken);
		setParents(voidCrystalChicken, CoalChicken, palisCrystalChicken);
		setParents(enoriCrystalChicken, voidCrystalChicken, IronChicken);
		setParents(emeradicCrystalChicken, palisCrystalChicken, EmeraldChicken);
		setParents(diamantineCrystalChicken, emeradicCrystalChicken, enoriCrystalChicken);
	}

}
