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


public class DraconicEvolution 
{
	public static ChickensRegistryItem draconiumChicken = null;
	public static ChickensRegistryItem draconiumAwakenedChicken = null; 
	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
		
        if(!Loader.isModLoaded("draconicevolution")) return chickens;
        ChickensMore.logger.info("Loading Draconic Evolution addon...");
		
       	chickens = registerChickens(chickens);
		
		return chickens;
	}
	

	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{
	
		ItemStack draconiumIngot = OreDictionary.getOres("ingotDraconium").get(0);
		ItemStack awakendNuggut =  OreDictionary.getOres("nuggetDraconiumAwakened").get(0);
		
		if(draconiumIngot != null)
		{
        	draconiumChicken = new ChickensRegistryItem(
                90, "draconiumChicken", new ResourceLocation(ChickensMore.MODID, "textures/entity/DraconiumChicken.png"),
                draconiumIngot,
                0x301549, 0x1a0c27).setSpawnType(SpawnType.NONE);
        	chickens.add(draconiumChicken);
		}
		if(awakendNuggut != null)
		{
        	draconiumAwakenedChicken = new ChickensRegistryItem(
                91, "draconiumAwakenedChicken", new ResourceLocation(ChickensMore.MODID, "textures/entity/DraconiumAwakenedChicken.png"),
                awakendNuggut,
                0xcc440c, 0x9c691a).setSpawnType(SpawnType.NONE);
        	chickens.add(draconiumAwakenedChicken);
		}
        
        if(Loader.isModLoaded("tconstruct"))
        {
        	if(draconiumChicken != null)
        		draconiumChicken.setParents(ChickensMore.findChickenChickensMod("pigIronChicken"), ChickensMore.findChickenChickensMod("enderchicken"));
        	if(awakendNuggut != null)
        		draconiumAwakenedChicken.setParents(draconiumChicken,ChickensMore.findChickenChickensMod("enderchicken"));
        }
        else
        {
        	if(draconiumChicken != null)
        		draconiumChicken.setParents(ChickensMore.findChickenChickensMod("gunpowderchicken"), ChickensMore.findChickenChickensMod("enderchicken"));
        	if(awakendNuggut != null)
        		draconiumAwakenedChicken.setParents(draconiumChicken, ChickensMore.findChickenChickensMod("enderchicken"));
        }
        
		return chickens;
	}
    
}
