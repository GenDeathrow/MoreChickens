package com.gendeathrow.morechickens.modHelper;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.gendeathrow.morechickens.util.ChickenInformation;
import com.gendeathrow.morechickens.util.LogUtil;
import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistry;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public abstract class BaseModAddon 
{

	protected String modID;
	protected String modName;
	protected String texturesLocation;
	
	private int startID = 2000;
	
	private boolean needsMod = true;

	public BaseModAddon(String modID, String modName, String texturesLocation)
	{
		this.modID = modID;
		this.modName = modName;
		this.texturesLocation = texturesLocation;
	}
	
	
	public String getModID()
	{
		return this.modID;
	}
	
	public String getModName()
	{
		return this.modName;
	}
	
	/**
	 * set a mod needs to be loaded to try and register chickens
	 * 
	 * @param bool
	 */
	public void setNeedsModPresent(boolean bool)
	{
		this.needsMod = bool;
	}
	
	public void setStartID(int startID)
	{
		this.startID = startID;
	}
	
	public List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> allChickens)
	{
        LogUtil.info("Looking for "+ modName +" addon...");
        
        if(needsMod && !Loader.isModLoaded(modID)) return allChickens;
        
        LogUtil.info("Loading "+ modName +" addon...");
        
       	return allChickens = registerChickens(allChickens);
	};
	
	/**
	 * Register your Chickens here
	 * 
	 * @param chickenList List<ChickensRegistryItem>
	 * @return
	 */
	public abstract  List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens);
	
	/**
	 * Register parents for chickens returns boolean if Successful
	 * 
	 * @param child
	 * @param parentName1
	 * @param parentName2
	 * @return
	 */
	public abstract void RegisterAllParents(List<ChickensRegistryItem> allChickens);
	

	boolean first = true;
	
	protected int nextID()
	{
		return this.startID++;
	}
	
	/**
	 * Used to add chickens to the registry
	 * 
	 * @param chickenName
	 * @param chickenID
	 * @param texture
	 * @param layItem
	 * @param bgColor
	 * @param fgColor
	 * 
	 * @param (Optional) spawnType
	 * @param (Optional) parent1 (String / ChickensRegistryItem) 
	 * @param (Optional) parent2 (String / ChickensRegistryItem) 
	 * @return
	 */
	protected ChickensRegistryItem addChicken(List<ChickensRegistryItem> chickenList, String chickenName, int chickenID, String texture, ItemStack layItem, int bgColor, int fgColor)
	{
		return addChicken(chickenList, chickenName, fgColor, texture, layItem, fgColor, fgColor, SpawnType.NONE);
	}
	
	protected ChickensRegistryItem addChicken(List<ChickensRegistryItem> chickenList, String chickenName, int chickenID, String texture, ItemStack layItem, int bgColor, int fgColor, SpawnType spawntype)
	{
		if(layItem == null || layItem.getItem() == null || layItem.isEmpty())
		{
			LogUtil.error("Error Registering ("+ this.modID +") Chicken: '"+chickenName+"' It's LayItem was null");
			return null;
		}
		
		
		LogUtil.debug("Registering ("+ this.modID +") Chicken: '"+chickenName+"':"+ chickenID +":"+ layItem.getDisplayName());
		
		ChickensRegistryItem chicken = new ChickensRegistryItem( new ResourceLocation(ChickensMore.MODID, chickenName), chickenName, new ResourceLocation(ChickensMore.MODID, this.texturesLocation + texture), layItem.copy(), bgColor, fgColor).setSpawnType(spawntype);
		
		chickenList.add(chicken);
		
		ChickenInformation.AddChickenInformation(new ResourceLocation(ChickensMore.MODID, chickenName).toString(), new ChickenInformation(ChickensMore.NAME, "", this.getModName()));
		
		return chicken;
	}
	
	
	
	protected void setParents(ChickensRegistryItem child, Object parent1, Object parent2)
	{
		ChickensRegistryItem parentChicken1 = null;
		ChickensRegistryItem parentChicken2 = null;
		
		if(child == null || parent1 == null || parent2 == null)	
		{
			String msg = "Setting Parents ";
			if(child == null)
				msg += ": Child Missing";
			else
				msg += ": "+ child.getEntityName();
			if(parent1 == null)
				msg += ": Parent 1 Missing ";
			if(parent2 == null)
				msg += ": Parent 2 Missing";
			
				LogUtil.debug(msg);
			return;
		}
		
		if(parent1 instanceof String)
			parentChicken1 = findChickenChickensMod((String) parent1);
		else if (parent1 instanceof ChickensRegistryItem)
			parentChicken1 = (ChickensRegistryItem) parent1;
		
		if(parent2 instanceof String)
			parentChicken2 = findChickenChickensMod((String) parent2);
		else if (parent2 instanceof ChickensRegistryItem)
			parentChicken2 = (ChickensRegistryItem) parent2;
		
		if(parentChicken1 == null){
			LogUtil.error("Could not find Parent 1 for "+ child.getEntityName());
			return;
		}
		
		if(parentChicken2 == null){
			LogUtil.error("Could not find Parent 2 for "+ child.getEntityName());
			return;
		}
		
		child.setParentsNew(parentChicken1, parentChicken2);
		
	}

	// Looks for a chicken inside MoreChickens
    public static ChickensRegistryItem findChicken(Collection<ChickensRegistryItem> chickens, String name) 
    {

    		for (ChickensRegistryItem chicken : chickens) 
			{
			    if (chicken.getEntityName().compareToIgnoreCase(name) == 0) 
			    {
			        return chicken;
			    }
			}
			
			return findChickenChickensMod(name);
    }

    // Looks for a chicken inside Chickens mod
    public static ChickensRegistryItem findChickenChickensMod(String name) 
    {
    	for (ChickensRegistryItem chicken : ChickensRegistry.getItems()) 
    	{
    		if (chicken.getEntityName().compareToIgnoreCase(name) == 0) 
    		{
    			
    			return chicken;
    		}
    	}
    
        return null;
    }
	
	/**
	 * Will grab first ore OreDictionary itemstack <br>
	 * can be null. 
	 * @param oreID
	 * @return
	 */
	@Nullable
	public ItemStack getFirstOreDictionary(String oreID)
	{
		List<ItemStack> itemstacks = OreDictionary.getOres(oreID);
		return !itemstacks.isEmpty() ? itemstacks.get(0) : null;
	}
	
	
	// ChickenMod ID names
	
	public static String IronChicken = "IronChicken";
	public static String CoalChicken = "CoalChicken";
	public static String YellowChicken = "YellowChicken";
	public static String WhiteChicken = "WhiteChicken";
	public static String ClayChicken = "ClayChicken";
	public static String GreenChicken = "GreenChicken";
	public static String BlackChicken = "BlackChicken";
	public static String FlintChicken = "FlintChicken";
	public static String BrownChicken = "BrownChicken";
	public static String GoldChicken = "GoldChicken";
	public static String RedstoneChicken = "RedstoneChicken";
	public static String SandChicken = "SandChicken";
	public static String GhastChicken = "ghastchicken";
	public static String EnderChicken = "enderchicken";
	public static String GunpowderChicken = "GunpowderChicken";
	public static String BlazeChicken = "BlazeChicken";
	public static String NetherWartChicken = "netherwartchicken";
	public static String SlimeChicken = "slimechicken";
	public static String RedChicken = "RedChicken";
	public static String MagmaChicken = "magmachicken";
	public static String BlueChicken = "BlueChicken";
	public static String GlowstoneChicken = "GlowstoneChicken";
	public static String WaterChicken = "WaterChicken";
	public static String QuartzChicken = "quartzChicken";
	public static String EmeraldChicken = "emeraldchicken";
	public static String LavaChicken = "LavaChicken";
	public static String SnowballChicken = "SnowballChicken";
	public static String LogChicken = "LogChicken";
	public static String GrayChicken = "GrayChicken";
	public static String SilverDyeChicken = "SilverDyeChicken";
	public static String CyanChicken = "CyanChicken";
	public static String DiamondChicken = "DiamondChicken";
	public static String PurpleChicken = "PurpleChicken";
	public static String OrangeChicken = "OrangeChicken";
	public static String PinkChicken = "PinkChicken";
	
	public static String PCrystalChicken = "pCrystalChicken";
	public static String SoulSandChicken = "soulSandChicken";
	public static String ObsidianChicken = "obsidianChicken";
	public static String PShardChicken = "pShardChicken";
	
	public static String GlassChicken = "GlassChicken";
	

	
}
