package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class ImmersiveEngineering 
{

	private static String skinLocation = "textures/entity/immersive_engineering/";

	public static ChickensRegistryItem aluminunChicken = null;
	public static ChickensRegistryItem uraniumChicken = null; 
	public static ChickensRegistryItem constantanChicken = null;

	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
        ChickensMore.logger.info("Looking for Immerssive Enginner addon...");
		
       	chickens = registerChickens(chickens);
		
		return chickens;
	}
	

	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{
		/*
		 * immersiveengineering:metal:1 Ores:[ ore:ingotAluminum]
			immersiveengineering:metal:5 Ores:[ ore:ingotUranium]
			immersiveengineering:metal:6 Ores:[ ore:ingotConstantan]
			immersiveengineering:graphiteElectrode Ores:[]

		 */
	
		List<ItemStack> ingotAluminum = OreDictionary.getOres("ingotAluminum");
		List<ItemStack> ingotUranium =  OreDictionary.getOres("ingotUranium");
		List<ItemStack> ingotConstantan =  OreDictionary.getOres("ingotConstantan");
		
		if(ingotAluminum.size() > 0)
		{
			aluminunChicken = new ChickensRegistryItem(
				2001, "aluminunChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "aluminium_chicken.png"),
                ingotAluminum.get(0),
                0xd3dddc, 0xcbd7d6).setSpawnType(SpawnType.NONE);
        	chickens.add(aluminunChicken);
		}
		
		if(ingotUranium.size() > 0)
		{
			uraniumChicken = new ChickensRegistryItem(
					2002, "uraniumChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "uranium_chicken.png"),
                ingotUranium.get(0),
                0x91d76d, 0x9ce26c).setSpawnType(SpawnType.NONE);
        	chickens.add(uraniumChicken);
		}
		
		if(ingotConstantan.size() > 0)
		{
			constantanChicken = new ChickensRegistryItem(
                2003, "constantanChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "consrtantan_chicken.png"),
                ingotConstantan.get(0),
                0xf98669, 0x795851).setSpawnType(SpawnType.NONE);
        	chickens.add(constantanChicken);
		}
		

        	if(aluminunChicken != null)
        		aluminunChicken.setParents(ChickensMore.findChickenChickensMod("flintChicken"), ChickensMore.findChickenChickensMod("ironchicken"));
        	
        	if(uraniumChicken != null)
        		uraniumChicken.setParents( ChickensMore.findChickenChickensMod("redstonechicken"), ChickensMore.findChickenChickensMod("enderchicken"));
        	
        	if(constantanChicken != null && BaseMetals.copperChicken != null && BaseMetals.nickelChicken != null)
        		constantanChicken.setParents(BaseMetals.copperChicken, BaseMetals.nickelChicken);
        
		return chickens;
	}
    
}
