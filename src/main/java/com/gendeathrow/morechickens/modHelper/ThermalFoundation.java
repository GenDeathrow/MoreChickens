package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;


public class ThermalFoundation 
{
	private static String skinLocation = "textures/entity/thermal_foundation/";
	
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

	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
		ChickensMore.logger.info("Looking for Thermal Foundation addon...");
        if(!Loader.isModLoaded("thermalfoundation")) return chickens;
        ChickensMore.logger.info("Loading Thermal Foundation Chickens...");
       	chickens = registerChickens(chickens);
		return chickens;
	}
	
	//Terrasteel, Manasteel, elementium
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{

		
		List<ItemStack> rodBasalz = OreDictionary.getOres("rodBasalz");
		List<ItemStack> rodBlitz = OreDictionary.getOres("rodBlitz");
		List<ItemStack> rodBlizz = OreDictionary.getOres("rodBlizz");
		List<ItemStack> crystalCinnabar =  OreDictionary.getOres("crystalCinnabar");
		List<ItemStack> nuggetEnderium =  OreDictionary.getOres("nuggetEnderium");
		List<ItemStack> nuggetIridium =  OreDictionary.getOres("nuggetIridium");
		List<ItemStack> ingotLumium = OreDictionary.getOres("ingotLumium");
		List<ItemStack> ingotMithril = OreDictionary.getOres("ingotMithril");
		List<ItemStack> ingotSignalum = OreDictionary.getOres("ingotSignalum");
		List<ItemStack> crystalSlag = OreDictionary.getOres("crystalSlag");
		List<ItemStack> crystalSlagRich = OreDictionary.getOres("crystalSlagRich");
		
		if(rodBasalz.size() > 0)
		{
			 basalzRodChicken = new ChickensRegistryItem(
                2060, "basalzRodChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "basalz_rod_chicken.png"),
                rodBasalz.get(0).copy(),
                0xECE992, 0x66E5EF).setSpawnType(SpawnType.NONE);
			chickens.add(basalzRodChicken);
		}

		if(rodBlitz.size() > 0)
		{
			 blitzRodChicken = new ChickensRegistryItem(
                2061, "blitzRodChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "blitz_rod_chicken.png"),
                rodBlitz.get(0).copy(),
                0xECE992, 0x66E5EF).setSpawnType(SpawnType.NONE);
			chickens.add(blitzRodChicken);
		}

		if(rodBlizz.size() > 0)
		{
			 blizzRodChicken = new ChickensRegistryItem(
                2062, "blizzRodChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "blizz_rod_chicken.png"),
                rodBlizz.get(0).copy(),
                0x88E0FF, 0x1D3B95).setSpawnType(SpawnType.NONE);
			chickens.add(blizzRodChicken);
		}

		if(crystalCinnabar.size() > 0)
		{
			 cinnabarChicken = new ChickensRegistryItem(
                2063, "cinnabarChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "cinnabar_chicken.png"),
                crystalCinnabar.get(0).copy(),
                0xE49790, 0x9B3229).setSpawnType(SpawnType.NONE);
			chickens.add(cinnabarChicken);
		}

		if(nuggetEnderium.size() > 0)
		{
			 enderiumChicken = new ChickensRegistryItem(
                2064, "enderiumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "enderium_chicken.png"),
                nuggetEnderium.get(0).copy(),
                0x127575, 0x0A4849).setSpawnType(SpawnType.NONE);
			chickens.add(enderiumChicken);
		}

		if(nuggetIridium.size() > 0)
		{
			 iridiumChicken = new ChickensRegistryItem(
                2065, "iridiumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "iridium_chicken.png"),
                nuggetIridium.get(0).copy(),
                0xEDEBF1, 0xBBBCDD).setSpawnType(SpawnType.NONE);
			chickens.add(iridiumChicken);
		}

		if(ingotLumium.size() > 0)
		{
			 lumiumChicken = new ChickensRegistryItem(
                2066, "lumiumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "lumium_chicken.png"),
                ingotLumium.get(0).copy(),
                0xEEF4DF, 0xF4B134).setSpawnType(SpawnType.NONE);
			chickens.add(lumiumChicken);
		}

		if(ingotMithril.size() > 0)
		{
			 mithrilChicken = new ChickensRegistryItem(
                2067, "mithrilChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "mithril_chicken.png"),
                ingotMithril.get(0).copy(),
                0x5A89A8, 0xA7FFFF).setSpawnType(SpawnType.NONE);
			chickens.add(mithrilChicken);
		}

		if(ingotSignalum.size() > 0)
		{
			 signalumChicken = new ChickensRegistryItem(
                2068, "signalumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "signalum_chicken.png"),
                ingotSignalum.get(0).copy(),
                0xFFA424, 0xC63200).setSpawnType(SpawnType.NONE);
			chickens.add(signalumChicken);
		}

		if(crystalSlag.size() > 0)
		{
			 slagChicken = new ChickensRegistryItem(
                2069, "slagChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "blizz_rod_chicken.png"),
                crystalSlag.get(0).copy(),
                0x83715E, 0x443B31).setSpawnType(SpawnType.NONE);
			chickens.add(slagChicken);
		}

		if(crystalSlagRich.size() > 0)
		{
			 richSlagChicken = new ChickensRegistryItem(
                2070, "richSlagChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "blizz_rod_chicken.png"),
                crystalSlagRich.get(0).copy(),
                0x5B3F20, 0x3D2915).setSpawnType(SpawnType.NONE);
			chickens.add(richSlagChicken);
		}
/*
    	if(basalzRodChicken != null)
    		basalzRodChicken.setParentsNew(ChickensMore.findChicken(chickens, "saltpeterchicken"), ChickensMore.findChickenChickensMod("BlazeChicken"));
    	if(blitzRodChicken != null)
    		blitzRodChicken.setParentsNew(basalzRodChicken, ChickensMore.findChicken(chickens, "sulfurchicken"));
    	if(blizzRodChicken != null)
    		blizzRodChicken.setParentsNew(blitzRodChicken, ChickensMore.findChickenChickensMod("SnowballChicken"));
    	if(slagChicken != null)
    		slagChicken.setParentsNew(ChickensMore.findChickenChickensMod("RedstoneChicken"), ChickensMore.findChickenChickensMod("FlintChicken"));
    	if(richSlagChicken != null)
    		richSlagChicken.setParentsNew(slagChicken, ChickensMore.findChickenChickensMod("GlassChicken"));
    	if(cinnabarChicken != null)
    		richSlagChicken.setParentsNew(richSlagChicken, ChickensMore.findChickenChickensMod("DiamondChicken"));
        if(signalumChicken != null)
        	signalumChicken.setParentsNew(ChickensMore.findChicken(chickens, "copperchicken"), ChickensMore.findChicken(chickens, "silverorechicken"));
        if(enderiumChicken != null)
        	enderiumChicken.setParentsNew(ChickensMore.findChicken(chickens, "platinumchicken"), ChickensMore.findChickenChickensMod("EnderChicken"));
        if(iridiumChicken != null)
        	iridiumChicken.setParentsNew(enderiumChicken, blizzRodChicken);
        if(lumiumChicken != null)
        	lumiumChicken.setParentsNew(ChickensMore.findChicken(chickens, "tinchicken"), ChickensMore.findChickenChickensMod("GlowstoneChicken"));
        if(mithrilChicken != null)
        	mithrilChicken.setParentsNew(iridiumChicken, ChickensMore.findChickenChickensMod("GoldChicken"));
    	  */
    	return chickens;
	}
	
}
