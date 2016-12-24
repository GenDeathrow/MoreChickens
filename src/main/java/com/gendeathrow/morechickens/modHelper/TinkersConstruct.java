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




public class TinkersConstruct 
{
	
	private static String skinLocation = "textures/entity/tinkers/";
	
	public static ChickensRegistryItem arditeChicken = null;
	public static ChickensRegistryItem colbaltChicken = null; 
	public static ChickensRegistryItem manyullynChicken = null;
	public static ChickensRegistryItem pigIronChicken = null;
	public static ChickensRegistryItem knightSlimeChicken = null; 
	public static ChickensRegistryItem bloodSlimeChicken = null;
	public static ChickensRegistryItem purpleSlimeChicken = null;
	public static ChickensRegistryItem magmaSlimeChicken = null; 
	public static ChickensRegistryItem blueSlimeChicken = null;
	
	public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
	{
        ChickensMore.logger.info("Checking for Tinkers Construct addon...");
        if(!Loader.isModLoaded("tconstruct")) return chickens;
        ChickensMore.logger.info("Loading Tinkers Construct addon...");

        
        chickens = registerChickens(chickens);
		
		return chickens;
	}
	

    
	public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
	{

		
		ItemStack arditeIngot = OreDictionary.getOres("ingotArdite").get(0);
		ItemStack cobaltIngot =  OreDictionary.getOres("ingotCobalt").get(0);
		ItemStack manyullynIngot = OreDictionary.getOres("ingotManyullyn").get(0);
		ItemStack pigIronIngot = OreDictionary.getOres("ingotPigiron").get(0);
		ItemStack knightSlimeIngot =  OreDictionary.getOres("ingotKnightslime").get(0);
		ItemStack bloodSlime = OreDictionary.getOres("slimeballBlood").get(0);
		ItemStack purpleSlime = OreDictionary.getOres("slimeballPurple").get(0);
		ItemStack magmaSlime =  OreDictionary.getOres("slimeballMagma").get(0);
		ItemStack blueSlime = OreDictionary.getOres("slimeballBlue").get(0);
		
		
		if(arditeIngot != null)
		{
			arditeChicken = new ChickensRegistryItem(
                80, "arditeChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "ArditeChicken.png"),
                arditeIngot,
                0xdc3e00, 0xffb20b).setSpawnType(SpawnType.NONE);
        	chickens.add(arditeChicken);
		}
		
		if(cobaltIngot != null)
		{
			colbaltChicken = new ChickensRegistryItem(
                81, "colbaltChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "ColbaltChicken.png"),
                cobaltIngot,
                0x0c5abe, 0x03d94f1).setSpawnType(SpawnType.NONE);
         	chickens.add(colbaltChicken);
		}
		
		if(manyullynIngot != null)
		{
			manyullynChicken = new ChickensRegistryItem(
                82, "manyullynChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "ManyullynChicken.png"),
                manyullynIngot,
                0x652e87, 0xbc8fe7).setSpawnType(SpawnType.NONE);
			chickens.add(manyullynChicken);
		}
		
		if(pigIronIngot != null)
		{
			pigIronChicken = new ChickensRegistryItem(
                83, "pigIronChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "PigIronChicken.png"),
                pigIronIngot,
                0xe6b8b8, 0xdba9a9).setSpawnType(SpawnType.NONE);
			chickens.add(pigIronChicken);
		}
		
		if(knightSlimeIngot != null)
		{
			knightSlimeChicken = new ChickensRegistryItem(
                84, "knightSlimeChicken", new ResourceLocation(ChickensMore.MODID, skinLocation + "KnightSlimeChicken.png"),
                knightSlimeIngot,
                0xc17ced, 0xad70d8).setSpawnType(SpawnType.NONE);
			chickens.add(knightSlimeChicken);
		}
		
		if(bloodSlime != null)
		{
			bloodSlimeChicken = new ChickensRegistryItem(
                85, "bloodSlime", new ResourceLocation(ChickensMore.MODID, skinLocation + "BloodSlime.png"),
                bloodSlime,
                0xc50616, 0xee0316).setSpawnType(SpawnType.NONE);
			chickens.add(bloodSlimeChicken);
		}
		
		if(purpleSlime != null)
		{
			purpleSlimeChicken = new ChickensRegistryItem(
                86, "purpleSlime", new ResourceLocation(ChickensMore.MODID, skinLocation + "PurpleSlime.png"),
                purpleSlime,
                0xc9aad9, 0x7511bf).setSpawnType(SpawnType.NONE);
			chickens.add(purpleSlimeChicken);
		}
		
		if(magmaSlime != null)
		{
			magmaSlimeChicken = new ChickensRegistryItem(
                87, "magmaSlime", new ResourceLocation(ChickensMore.MODID, skinLocation + "MagmaSlime.png"),
                magmaSlime,
                0xecb55f, 0xaf7314).setSpawnType(SpawnType.NONE);
        	chickens.add(magmaSlimeChicken);
		}
		
		if(blueSlime != null)
		{
			blueSlimeChicken = new ChickensRegistryItem(
                88, "blueSlime", new ResourceLocation(ChickensMore.MODID, skinLocation + "BlueSlime.png"),
                blueSlime,
                0x67b4c4, 0x30717f).setSpawnType(SpawnType.NONE);
			chickens.add(blueSlimeChicken);
		}
        // aluminumBrassIngot

       if(arditeIngot != null)
        arditeChicken.setParents(ChickensMore.findChickenChickensMod("BlazeChicken"),  ChickensMore.findChickenChickensMod("magmachicken"));
       
       if(cobaltIngot != null)
        colbaltChicken.setParents(ChickensMore.findChickenChickensMod("netherwartchicken"),  ChickensMore.findChickenChickensMod("ghastchicken"));
       
       if(pigIronIngot != null)
        pigIronChicken.setParents(arditeChicken, ChickensMore.findChickenChickensMod("ironchicken"));
       
       if(manyullynIngot != null)
        manyullynChicken.setParents(arditeChicken, colbaltChicken);
       
       if(knightSlimeIngot != null)
        knightSlimeChicken.setParents(manyullynChicken, pigIronChicken);
       
       if(bloodSlime != null)
        bloodSlimeChicken.setParents(ChickensMore.findChickenChickensMod("slimechicken"), ChickensMore.findChickenChickensMod("RedChicken"));
       
       if(purpleSlime != null)
        purpleSlimeChicken.setParents(bloodSlimeChicken, ChickensMore.findChickenChickensMod("BlueChicken"));
       
       if(magmaSlime != null)
        magmaSlimeChicken.setParents(ChickensMore.findChickenChickensMod("slimechicken"), ChickensMore.findChickenChickensMod("magmachicken"));
       
       if(blueSlime != null)
        blueSlimeChicken.setParents(ChickensMore.findChickenChickensMod("slimechicken"), ChickensMore.findChickenChickensMod("BlueChicken"));
        
		return chickens;
	}
    
    
	
}
