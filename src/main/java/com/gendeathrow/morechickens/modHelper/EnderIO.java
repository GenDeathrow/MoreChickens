package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class EnderIO 
{

	// TODO
	/*
	 * Electric Steel
	 * Basic Capacitor
	 * compondchicken
	 * redstone alloy
	 * dark steel
	 * pulsating iron
	 * 
	 */
	
	private static String skinLocation = "textures/entity/enderio/";
	
	public static ChickensRegistryItem electricSteelChicken = null;
	public static ChickensRegistryItem compoundChicken = null;
	public static ChickensRegistryItem basicCapChicken = null; 
	public static ChickensRegistryItem redstoneAlloyChicken = null;
	public static ChickensRegistryItem darkSteelChicken = null;
	public static ChickensRegistryItem pulsatingIronChicken = null;
	
	
	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
        ChickensMore.logger.info("Looking for EnderIO addon...");
        if(!Loader.isModLoaded("enderio")) return chickens;
        ChickensMore.logger.info("Loading EnderIO addon...");
       	chickens = registerChickens(chickens);
		return chickens;
	}
	
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{
		
			List<ItemStack> ingotelectricSteel = OreDictionary.getOres("ingotYellorium");
	        List<ItemStack> compoundItem =  OreDictionary.getOres("ingotCyanite");
	        List<ItemStack> basciCap =  OreDictionary.getOres("ingotGraphite");
	        List<ItemStack> redstoneAlloy =  OreDictionary.getOres("ingotBlutonium");
	        List<ItemStack> darkSteel =  OreDictionary.getOres("ingotBlutonium");
	        List<ItemStack> pulsatingIron =  OreDictionary.getOres("ingotBlutonium");
	        	        //List<ItemStack> ingotLudicrite =  OreDictionary.getOres("ingotLudicrite");

	        if(ingotelectricSteel.size() > 0)
	        {
	        	electricSteelChicken = new ChickensRegistryItem(
	                    2100,
	                    "yelloriumChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "yellorium_chicken.png"),
	                    ingotelectricSteel.get(0).copy(),
	                    0xA5B700,
	                    0xD7EF00
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(electricSteelChicken);

	            electricSteelChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("GlowstoneChicken"),
	                    ChickensMore.findChickenChickensMod("EnderChicken")
	            );
	        }
		return chickens;
	}
}
