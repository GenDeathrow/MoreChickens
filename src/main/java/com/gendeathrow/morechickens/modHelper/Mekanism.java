package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class Mekanism 
{
	
	private static String skinLocation = "textures/entity/mekanism/";

	public static ChickensRegistryItem osmiumChicken = null;
	public static ChickensRegistryItem refinedGlowstoneChicken = null; 
	public static ChickensRegistryItem refinedObsidianChicken = null;

	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
        ChickensMore.logger.info("Looking for Mekanism addon...");
		
       	chickens = registerChickens(chickens);
		
		return chickens;
	}
	

	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{
		/*
mekanism:Ingot Ores:[ ore:ingotRefinedObsidian]
mekanism:Ingot:1 Ores:[ ore:ingotOsmium]
mekanism:Ingot:3 Ores:[ ore:ingotRefinedGlowstone]


		 */
	
		List<ItemStack> ingotOsmium = OreDictionary.getOres("ingotOsmium");
		
		Item item = Item.getByNameOrId("mekanism:Ingot");
		//List<ItemStack> ingotRefinedGlowstone =  OreDictionary.getOres("ingotRefinedGlowstone");
		//List<ItemStack> ingotRefinedObsidian =  OreDictionary.getOres("ingotRefinedObsidian");
		
		if(item != null)
		{
			osmiumChicken = new ChickensRegistryItem(
				2010, "osmiumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "osmium_chicken.png"),
				new ItemStack(item, 1, 1),
                0xbecad4, 0x8097ab).setSpawnType(SpawnType.NONE);
        	chickens.add(osmiumChicken);
		}else ChickensMore.logger.error("Couldn't find Osmium");
		
//		if(ingotRefinedGlowstone.size() > 0)
//		{
//			refinedGlowstoneChicken = new ChickensRegistryItem(
//					2002, "draconiumAwakenedChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "uranium_chicken.png"),
//					ingotRefinedGlowstone.get(0),
//                0xcc440c, 0x9c691a).setSpawnType(SpawnType.NONE);
//        	chickens.add(refinedGlowstoneChicken);
//		}
		
//		if(ingotRefinedObsidian.size() > 0)
//		{
//			refinedObsidianChicken = new ChickensRegistryItem(
//                2003, "draconiumAwakenedChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "consrtantan_chicken.png"),
//                ingotRefinedObsidian.get(0),
//                0xcc440c, 0x9c691a).setSpawnType(SpawnType.NONE);
//        	chickens.add(refinedObsidianChicken);
//		}
		

        	if(osmiumChicken != null)
        		osmiumChicken.setParents(ChickensMore.findChickenChickensMod("ironChicken"), ChickensMore.findChickenChickensMod("quartzChicken"));
        	
//        	if(refinedGlowstoneChicken != null)
//        		refinedGlowstoneChicken.setParents(osmiumChicken, ChickensMore.findChickenChickensMod("enderchicken"));
//        	if(refinedObsidianChicken != null)
//        		refinedObsidianChicken.setParents(osmiumChicken, ChickensMore.findChickenChickensMod("enderchicken"));
        
		return chickens;
	}
	
}