package com.gendeathrow.morechickens.modHelper;

import java.util.Collection;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;


public class Botania 
{
	private static String skinLocation = "textures/entity/botania/";
	
	public static ChickensRegistryItem elementiumChicken = null;
	public static ChickensRegistryItem manasteelChicken = null; 
	public static ChickensRegistryItem terrasteelChicken = null;

	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
        if(!Loader.isModLoaded("Botania")) return chickens;
        
        ChickensMore.logger.info("Loading Botania Chickens...");
       	chickens = registerChickens(chickens);
		return chickens;
	}
	
	//Terrasteel, Manasteel, elementium
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{

		
		List<ItemStack> terrasteelIngot = OreDictionary.getOres("ingotTerrasteel");
		List<ItemStack> manasteelIngot =  OreDictionary.getOres("ingotManasteel");
		List<ItemStack> elementiumNugget = OreDictionary.getOres("nuggetElvenElementium");
		
		if(terrasteelIngot.size() > 0)
		{
			 terrasteelChicken = new ChickensRegistryItem(
                120, "terrasteelchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "TerrasteelChicken.png"),
                terrasteelIngot.get(0).copy(),
                0x3ff123, 0xf5fcf1).setSpawnType(SpawnType.NONE);
			chickens.add(terrasteelChicken);
		}
		
		if(terrasteelIngot.size() > 0)
		{
			 manasteelChicken = new ChickensRegistryItem(
                121, "manasteelchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "ManasteelChicken.png"),
                manasteelIngot.get(0).copy(),
                0x69d7ff, 0x002c4b).setSpawnType(SpawnType.NONE);
			chickens.add(manasteelChicken);
		}

		if(terrasteelIngot.size() > 0)
		{
			elementiumChicken = new ChickensRegistryItem(
                122, "elementiumchicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "ElementiumChicken.png"),
                elementiumNugget.get(0).copy(),
                0xf655f3, 0xb407b7).setSpawnType(SpawnType.NONE);
			chickens.add(elementiumChicken);
		}
        
        
		if(manasteelChicken != null)
			manasteelChicken.setParents(ChickensMore.findChickenChickensMod("ironchicken"), ChickensMore.findChickenChickensMod("ghastchicken"));
		if(terrasteelChicken != null)
			terrasteelChicken.setParents(ChickensMore.findChickenChickensMod("enderchicken"), ChickensMore.findChicken(chickens, "pCrystalChicken"));
		if(elementiumChicken != null)
			elementiumChicken.setParents(manasteelChicken, terrasteelChicken);
        
    	
    	return chickens;
	}
	
}
