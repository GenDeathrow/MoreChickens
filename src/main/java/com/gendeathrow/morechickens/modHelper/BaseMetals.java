package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class BaseMetals 
{

	private static String skinLocation = "textures/entity/basemetals/";
	
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

	
	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
          
        ChickensMore.logger.info("Checking for Base Metals Chickens...");
       	chickens = registerChickens(chickens);
		return chickens;
	}
	
	//Terrasteel, Manasteel, elementium
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{


		
		/*
		 * 
		 * 	basemetals:adamantine_ingot Ores:[ ore:ingotAdamantine]
			basemetals:aquarium_ingot Ores:[ ore:ingotAquarium]
			basemetals:brass_ingot Ores:[ ore:ingotBrass]
			basemetals:coldiron_ingot Ores:[ ore:ingotColdiron]
			basemetals:cupronickel_ingot Ores:[ ore:ingotCupronickel]
					basemetals:electrum_ingot Ores:[ ore:ingotElectrum]
					
			basemetals:invar_ingot Ores:[ ore:ingotInvar]
			basemetals:bronze_ingot Ores:[ ore:ingotBronze]
			basemetals:copper_ingot Ores:[ ore:ingotCopper]
			basemetals:lead_ingot Ores:[ ore:ingotLead]
			basemetals:mithril_ingot Ores:[ ore:ingotMithril]
			basemetals:nickel_ingot Ores:[ ore:ingotNickel]
			basemetals:platinum_ingot Ores:[ ore:ingotPlatinum]
			basemetals:silver_ingot Ores:[ ore:ingotSilver]
			basemetals:starsteel_ingot Ores:[ ore:ingotStarsteel]
			basemetals:steel_ingot Ores:[ ore:ingotSteel]
			basemetals:tin_ingot Ores:[ ore:ingotTin]
			basemetals:zinc_ingot Ores:[ ore:ingotZinc]
		 */
		List<ItemStack> brassIngot = OreDictionary.getOres("ingotBrass");
		List<ItemStack> invarIngot = OreDictionary.getOres("ingotInvar");
		List<ItemStack> cupronickelIngot =  OreDictionary.getOres("ingotCupronickel");
		List<ItemStack> electrumIngot = OreDictionary.getOres("ingotElectrum");
		List<ItemStack> bronzeIngot =  OreDictionary.getOres("ingotBronze");
		List<ItemStack> copperIngot = OreDictionary.getOres("ingotCopper");
		List<ItemStack> leadIngot = OreDictionary.getOres("ingotLead");
		List<ItemStack> nickelIngot =  OreDictionary.getOres("ingotNickel");
		List<ItemStack> platinumIngot = OreDictionary.getOres("ingotPlatinum");
		List<ItemStack> silverIngot =  OreDictionary.getOres("ingotSilver");
		List<ItemStack> steelIngot =  OreDictionary.getOres("ingotSteel");
		List<ItemStack> tinIngot = OreDictionary.getOres("ingotTin");
		List<ItemStack> zincIngot =  OreDictionary.getOres("ingotZinc");

		List<ItemStack> itemSilicon = OreDictionary.getOres("itemSilicon");

		List<ItemStack> dustSulfur = OreDictionary.getOres("dustSulfur");
		List<ItemStack> dustSaltpeter = OreDictionary.getOres("dustSaltpeter");


		
		if(invarIngot.size() > 0)
		{
			invarChicken = new ChickensRegistryItem(
                140, "invarchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "invar_chicken.png"),
                invarIngot.get(0).copy(),
                0x989585, 0xd1ccb6).setSpawnType(SpawnType.NONE);
			chickens.add(invarChicken);
		}
		
		if(bronzeIngot.size() > 0)
		{
			bronzeChicken = new ChickensRegistryItem(
                141, "bronzechicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "bronze_chicken.png"),
                bronzeIngot.get(0).copy(),
                0x9a6731, 0xf6a44e).setSpawnType(SpawnType.NONE);
			chickens.add(bronzeChicken);
		}
		
		if(zincIngot.size() > 0)
		{
			zincChicken = new ChickensRegistryItem(
                142, "zincchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "zinc_chicken.png"),
                zincIngot.get(0).copy(),
                0xb7b7b7, 0x868686).setSpawnType(SpawnType.NONE);
			chickens.add(zincChicken);
		}
		
		if(tinIngot.size() > 0)
		{
			tinChicken = new ChickensRegistryItem(
                143, "tinchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "tin_chicken.png"),
                tinIngot.get(0).copy(),
                0xfff7ee, 0xbbb1a7).setSpawnType(SpawnType.NONE);
			chickens.add(tinChicken);
		}
		
		if(steelIngot.size() > 0)
		{
			steelChicken = new ChickensRegistryItem(
                144, "steelchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "steel_chicken.png"),
                steelIngot.get(0).copy(),
                0xd3e1e3, 0x8e9799).setSpawnType(SpawnType.NONE);
			chickens.add(steelChicken);
		}
		
		if(silverIngot.size() > 0)
		{
			silverOreChicken = new ChickensRegistryItem(
                145, "silverorechicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "silver_chicken.png"),
                silverIngot.get(0).copy(),
                0xbebebe, 0xffffff).setSpawnType(SpawnType.NONE);
			chickens.add(silverOreChicken);
		}
		
		if(platinumIngot.size() > 0)
		{
			platinumChicken = new ChickensRegistryItem(
                146, "platinumchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "platinum_chicken.png"),
                platinumIngot.get(0).copy(),
                0xffffff, 0x8d9a96).setSpawnType(SpawnType.NONE);
			chickens.add(platinumChicken);
		}
		
		if(nickelIngot.size() > 0)
		{
			nickelChicken = new ChickensRegistryItem(
                147, "nickelchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "nickel_chicken.png"),
                nickelIngot.get(0).copy(),
                0xefffec, 0xa2b69f).setSpawnType(SpawnType.NORMAL);
			chickens.add(nickelChicken);
		}
		
		if(leadIngot.size() > 0)
		{
			leadChicken = new ChickensRegistryItem(
                148, "leadchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "lead_chicken.png"),
                leadIngot.get(0).copy(),
                0x777777, 0x383838).setSpawnType(SpawnType.NONE);
			chickens.add(leadChicken);
		}
		
		if(copperIngot.size() > 0)
		{
			copperChicken = new ChickensRegistryItem(
                149, "copperchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "copper_chicken.png"),
                copperIngot.get(0).copy(),
                0xc06a48, 0xff9d76).setSpawnType(SpawnType.NORMAL);
			chickens.add(copperChicken);
		}
		
		if(brassIngot.size() > 0)
		{
			brassChicken = new ChickensRegistryItem(
                150, "brasschicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "brass_chicken.png"),
                brassIngot.get(0).copy(),
                0xa99340, 0xffe377).setSpawnType(SpawnType.NONE);
			chickens.add(brassChicken);
		}
		
		if(cupronickelIngot.size() > 0)
		{
			cupronickelChicken = new ChickensRegistryItem(
                151, "cupronickelchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "cupronickel_chicken.png"),
                cupronickelIngot.get(0).copy(),
                0xd8ccb4, 0x98896c).setSpawnType(SpawnType.NONE);
			chickens.add(cupronickelChicken);
		}

		if(electrumIngot.size() > 0)
		{
			electrumChicken = new ChickensRegistryItem(
                152, "electrumchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "electrum_chicken.png"),
                electrumIngot.get(0).copy(),
                0xfff2b1, 0xd4be50).setSpawnType(SpawnType.NONE);
			chickens.add(electrumChicken);
		}

		if(itemSilicon.size() > 0)
		{
			siliconChicken = new ChickensRegistryItem(
                153, "siliconchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "silicon_chicken.png"),
                itemSilicon.get(0).copy(),
                0x5f706b, 0x424242).setSpawnType(SpawnType.NONE);
			chickens.add(siliconChicken);

		if(dustSulfur.size() > 0)
		{
			sulfurChicken = new ChickensRegistryItem(
                154, "sulfurchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "sulfur_chicken.png"),
                dustSulfur.get(0).copy(),
                0xFFE782, 0xAD9326).setSpawnType(SpawnType.NONE);
			chickens.add(sulfurChicken);
		}

		if(dustSaltpeter.size() > 0)
		{
			saltpeterChicken = new ChickensRegistryItem(
                155, "saltpeterchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "saltpeter_chicken.png"),
                dustSaltpeter.get(0).copy(),
                0xDDD6D6, 0xAC9E9D).setSpawnType(SpawnType.NONE);
			chickens.add(saltpeterChicken);
		}

        
		if(brassChicken != null)
			brassChicken.setParentsNew(copperChicken, zincChicken);
		
		if(bronzeChicken != null)
			bronzeChicken.setParentsNew(copperChicken, tinChicken);
		
		if(invarChicken != null)
			invarChicken.setParentsNew(ChickensMore.findChickenChickensMod("IronChicken"), nickelChicken);
		
		if(cupronickelChicken != null)
			cupronickelChicken.setParentsNew(copperChicken, nickelChicken);
		
		if(electrumChicken != null)
			electrumChicken.setParentsNew(silverOreChicken, ChickensMore.findChickenChickensMod("GoldChicken"));

		if(steelChicken != null)
			steelChicken.setParentsNew(ChickensMore.findChickenChickensMod("IronChicken"), ChickensMore.findChickenChickensMod("CoalChicken"));
		
		if(copperChicken != null)
			copperChicken.setParentsNew(ChickensMore.findChickenChickensMod("YellowChicken"), ChickensMore.findChickenChickensMod("BrownChicken"));
		
		if(leadChicken != null)
			leadChicken.setParentsNew(ChickensMore.findChickenChickensMod("IronChicken"), ChickensMore.findChickenChickensMod("CoalChicken"));		
		
		if(tinChicken != null)
			tinChicken.setParentsNew(ChickensMore.findChickenChickensMod("WhiteChicken"), ChickensMore.findChickenChickensMod("ClayChicken"));		

		if(nickelChicken != null)
			nickelChicken.setParentsNew(ChickensMore.findChickenChickensMod("WhiteChicken"), ChickensMore.findChickenChickensMod("GreenChicken"));	
	
		if(zincChicken != null)
			zincChicken.setParentsNew(ChickensMore.findChickenChickensMod("BlackChicken"), ChickensMore.findChickenChickensMod("ClayChicken"));	
		
		if(silverOreChicken != null)
			silverOreChicken.setParentsNew(ChickensMore.findChickenChickensMod("IronChicken"), ChickensMore.findChickenChickensMod("WhiteChicken"));	

		if(platinumChicken != null)
			platinumChicken.setParentsNew(nickelChicken, silverOreChicken);

		if(sulfurChicken != null)
			sulfurChicken.setParentsNew(ChickensMore.findChickenChickensMod("CoalChicken"), ChickensMore.findChickenChickensMod("FlintChicken"));
		
		if(saltpeterChicken != null)
			saltpeterChicken.setParentsNew(sulfurChicken, ChickensMore.findChickenChickensMod("RedstoneChicken"));
		
		if(siliconChicken != null)
			siliconChicken.setParentsNew(ChickensMore.findChickenChickensMod("FlintChicken"), ChickensMore.findChickenChickensMod("SandChicken"));	
		
		return chickens;
	}
}
