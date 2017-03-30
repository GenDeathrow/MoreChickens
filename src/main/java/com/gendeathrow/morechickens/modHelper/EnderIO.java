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
	
	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
        ChickensMore.logger.info("Looking for EnderIO addon...");
        if(!Loader.isModLoaded("EnderIO")) return chickens;
        ChickensMore.logger.info("Loading EnderIO addon...");
       	chickens = registerChickens(chickens);
		return chickens;
	}
	
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{
		
			List<ItemStack> ingotElectricalSteel = OreDictionary.getOres("ingotElectricalSteel");
			List<ItemStack> ingotEnergeticAlloy = OreDictionary.getOres("ingotEnergeticAlloy");
			List<ItemStack> ingotVibrantAlloy = OreDictionary.getOres("ingotVibrantAlloy");
			List<ItemStack> ingotRedstoneAlloy = OreDictionary.getOres("ingotElectricalSteel");
			List<ItemStack> ingotConductiveIron = OreDictionary.getOres("ingotElectricalSteel");
			List<ItemStack> ingotPulsatingIron = OreDictionary.getOres("ingotElectricalSteel");
			List<ItemStack> ingotDarkSteel = OreDictionary.getOres("ingotElectricalSteel");
			List<ItemStack> ingotSoularium = OreDictionary.getOres("ingotElectricalSteel");

	        if(ingotElectricalSteel.size() > 0)
	        {
	        	electricalSteelChicken = new ChickensRegistryItem(
	                    2030,
	                    "electricalSteelChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "electrical_steel_chicken.png"),
	                    ingotElectricalSteel.get(0).copy(),
	                    0x939393,
	                    0x474747
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(electricalSteelChicken);

	            electricalSteelChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("ironchicken"),
	                    BaseMetals.siliconChicken
	            );
	        }
	        
	        if(ingotEnergeticAlloy.size() > 0)
	        {
	        	energeticAlloyChicken = new ChickensRegistryItem(
	                    2031,
	                    "energeticAlloyChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "energetic_alloy_chicken.png"),
	                    ingotEnergeticAlloy.get(0).copy(),
	                    0xea6c05,
	                    0x65321b
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(energeticAlloyChicken);

	            energeticAlloyChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("redstonechicken"),
	                    ChickensMore.findChickenChickensMod("goldchicken")
	            );
	        }
	        
	        if(ingotVibrantAlloy.size() > 0)
	        {
	        	vibrantAlloyChicken = new ChickensRegistryItem(
	                    2032,
	                    "vibrantAlloyChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "vibrant_alloy_chicken.png"),
	                    ingotVibrantAlloy.get(0).copy(),
	                    0xbcf239,
	                    0x779c1d
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(vibrantAlloyChicken);

	            vibrantAlloyChicken.setParentsNew(
	            		energeticAlloyChicken,
	                    ChickensMore.findChickenChickensMod("enderchicken")
	            );
	        }

	        if(ingotRedstoneAlloy.size() > 0)
	        {
	        	redstoneAlloyChicken = new ChickensRegistryItem(
	                    2033,
	                    "redstoneAlloyChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "redstone_alloy_chicken.png"),
	                    ingotRedstoneAlloy.get(0).copy(),
	                    0xd03939,
	                    0x621919
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(redstoneAlloyChicken);

	            redstoneAlloyChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("redstonechicken"),
	                    BaseMetals.siliconChicken
	            );
	        }
	        
	        if(ingotConductiveIron.size() > 0)
	        {
	        	conductiveIronChicken = new ChickensRegistryItem(
	                    2034,
	                    "conductiveIronChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "conductive_iron_chicken.png"),
	                    ingotConductiveIron.get(0).copy(),
	                    0xCC9D96,
	                    0x7E6764
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(conductiveIronChicken);

	            conductiveIronChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("redstonechicken"),
	                    ChickensMore.findChickenChickensMod("ironchicken")
	            );
	        }
	        
	        if(ingotPulsatingIron.size() > 0)
	        {
	        	pulsatingIronChicken = new ChickensRegistryItem(
	                    2035,
	                    "pulsatingIronChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "pulsating_iron_chicken.png"),
	                    ingotPulsatingIron.get(0).copy(),
	                    0x6FE78B,
	                    0x406448
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(pulsatingIronChicken);

	            pulsatingIronChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("enderchicken"),
	                    ChickensMore.findChickenChickensMod("ironchicken")
	            );
	        }
	        
	        if(ingotDarkSteel.size() > 0)
	        {
	        	darkSteelChicken = new ChickensRegistryItem(
	                    2036,
	                    "darkSteelChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "dark_steel_chicken.png"),
	                    ingotDarkSteel.get(0).copy(),
	                    0x4D4D4E,
	                    0x242424
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(darkSteelChicken);

	            darkSteelChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("coalchicken"),
	                    ChickensMore.findChickenChickensMod("ironchicken")
	            );
	        }
	        
	        if(ingotSoularium.size() > 0)
	        {
	        	soulariumChicken = new ChickensRegistryItem(
	                    2037,
	                    "soulariumChicken",
	                    new ResourceLocation(ChickensMore.MODID, skinLocation + "soularium_chicken.png"),
	                    ingotSoularium.get(0).copy(),
	                    0x6F5C36,
	                    0x4E371A
	            ).setSpawnType(SpawnType.NONE);
	            chickens.add(soulariumChicken);

	            soulariumChicken.setParentsNew(
	                    ChickensMore.findChickenChickensMod("goldchicken"),
	                    ChickensMore.findChickenChickensMod("netherwartchicken")
	            );
	        }
		return chickens;
	}
}
