package com.gendeathrow.morechickens.core.configs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.gendeathrow.morechickens.util.LogUtil;
import com.setycz.chickens.ChickensRegistry;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class ConfigHandler {
	public static final File configDir = new File("config/chickens");
	public static final File moreChickensFile = new File(ConfigHandler.configDir, "morechickens.json");
	
	private static JsonConfig config;
	
	public static ArrayList<String> ErrorList = new ArrayList<String>();
	
	public static void loadChickens(Collection<ChickensRegistryItem> allChickens)
	{
		config = new JsonConfig(moreChickensFile);
		
		config.Load();
		
        for (ChickensRegistryItem chicken : allChickens) 
        {
        	String registryName = chicken.getRegistryName().toString();
        	
        	config.getString(registryName, "Name", chicken.getEntityName());

        	boolean enabled = config.getBoolean(registryName, "is Enabled", true);
        	chicken.setEnabled(enabled);
        	
        	float layCoefficient = config.getFloat(registryName, "Lay Coefficient", 1.0f, 0.01f, 100f);
        	chicken.setLayCoefficient(layCoefficient);
        	
         	ItemStack layItem = loadItemStack(config, chicken, "Lay Item", chicken.createLayItem());
         	chicken.setLayItem(layItem);
         	
        	ItemStack dropItem = loadItemStack(config, chicken, "Drop Item", chicken.createDropItem());
        	chicken.setDropItem(dropItem);
        	
            ChickensRegistryItem parent1 = findChicken(allChickens, getChickenParent(config, "Parent 1", allChickens, chicken, chicken.getParent1()));
            ChickensRegistryItem parent2 = findChicken(allChickens, getChickenParent(config, "Parent 2", allChickens, chicken, chicken.getParent2()));
        	
            if (parent1 != null && parent2 != null) {
                chicken.setParentsNew(parent1, parent2);
            } else {
                chicken.setNoParents();
            }
            
            SpawnType spawnType = SpawnType.valueOf(config.getString(registryName, "Spawn Type", chicken.getSpawnType().toString()));
            chicken.setSpawnType(spawnType);
            
            ChickensRegistry.register(chicken);
            
            ChickensMore.proxy.registerChicken(chicken);
        }
		
        if(config.hasChanged)
        	config.Save();
	}
	
	
	
    private static String getChickenParent(JsonConfig configuration, String propertyName, Collection<ChickensRegistryItem> allChickens, ChickensRegistryItem chicken, ChickensRegistryItem parent) 
    {
    	String Category = chicken.getRegistryName().toString();
        return configuration.getString(Category, propertyName, parent != null ? parent.getRegistryName().toString() : "");
    }

    
    @SuppressWarnings("unused")
	private static ItemStack loadItemStack(JsonConfig configuration, ChickensRegistryItem chicken, String prefix, ItemStack defaultItemStack) {
    	String Category = chicken.getRegistryName().toString();

    	String itemID = getIDfromItemStack(defaultItemStack);
    	ItemStack stack = getItemStackFromID(config.getString(chicken.getRegistryName().toString(), prefix, itemID));
    	
        if (stack == null) 
        {
        	if(defaultItemStack != null) return defaultItemStack;	
        	else throw new RuntimeException("Cannot find item with name: " + itemID);
        }
        
        return stack;
    }
    
    
	private static ItemStack getItemStackFromID(String itemID){

		String[] args = itemID.split(":");

		ItemStack stack = null;
		Item item = null;
		int meta = 0;
		
		if(args.length == 3){
			try{
				meta = Integer.parseInt(args[2]);
				item = Item.getByNameOrId(args[0] +":"+ args[1]);		
			}catch(Exception e){
				item = Item.getByNameOrId(args[0] +":"+ args[1]);
			}
		}
		else{
			item = Item.getByNameOrId(args[0] +":"+ args[1]);
		}
		
		if(item != null){
			stack = new ItemStack(Item.getByNameOrId(args[0] +":"+ args[1]), 1, meta);
		}
		else{
			ErrorList.add(itemID);
			LogUtil.getLogger().error("Item could not be Found: "+ itemID);
		}

		return stack;
	}
	
	private static String getIDfromItemStack(ItemStack stack){
		return stack.getItem().getRegistryName() + (stack.getItemDamage() != 0 ? ":"+ stack.getItemDamage() : "");
	}
	
	
    
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
    
}
