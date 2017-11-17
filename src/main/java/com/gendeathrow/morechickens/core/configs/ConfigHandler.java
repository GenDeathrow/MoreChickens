package com.gendeathrow.morechickens.core.configs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistry;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.ItemStack;

public class ConfigHandler {
	public static final File configDir = new File("config/chickens");
	public static final File moreChickensFile = new File(ConfigHandler.configDir, "morechickens.json");
	
	private static JsonConfig config;
	
	public static ArrayList<String> ErrorList = new ArrayList<String>();
	
	public static void loadChickens(Collection<ChickensRegistryItem> allChickens)
	{
		config = new JsonConfig(moreChickensFile);
		
		config.Load();
		
		
		// Add Comments
			String comment = "_Comment";
			
			config.getString(comment, "_Name", "Just a Reference to the old system naming. Changing does nothing.");
			config.getString(comment, "_Is Enabled", "Is chicken enabled?");
			config.getString(comment, "_Lay Item", "Item the chicken will Lay.               modid:itemid:metadata:amount #example: minecraft:log:2:3");
			config.getString(comment, "_Drop Item", "Item the chicken drops on death.        modid:itemid:metadata:amount #example: minecraft:bone");
			config.getString(comment, "_Spawn Type", "Chicken spawn type, can be: " + String.join(",", SpawnType.names()));
			config.getString(comment, "_Parent 1", "First parent, empty if it cant be breed. modid:chickenid #example: chickens:waterchicken");
			config.getString(comment, "_Parent 2", "Second parent, empty if it cant be breed. ");
		
        for (ChickensRegistryItem chicken : allChickens) 
        {
        	String registryName = chicken.getRegistryName().toString();
        	
        	config.getString(registryName, "Name", chicken.getEntityName());

        	boolean enabled = config.getBoolean(registryName, "Is Enabled", true);
        	chicken.setEnabled(enabled);
        	
        	float layCoefficient = config.getFloat(registryName, "Lay Coefficient", 1.0f, 0.01f, 100f);
        	chicken.setLayCoefficient(layCoefficient);
        	
        	chicken.setLayItem(loadItemStack(config, registryName, chicken, "Lay Item", chicken.createLayItem()));
        	chicken.setDropItem(loadItemStack(config, registryName, chicken, "Drop Item", chicken.createDropItem()));
        	
            SpawnType spawnType = SpawnType.valueOf(config.getString(registryName, "Spawn Type", chicken.getSpawnType().toString()));
            chicken.setSpawnType(spawnType);
            
            ChickensRegistry.register(chicken);
            
            ChickensMore.proxy.registerChicken(chicken);
        }
        
        // Set Parents after Chickens have been registered
        for (ChickensRegistryItem chicken : allChickens) 
        {
        	ChickensRegistryItem parent1 = ChickensRegistry.getByRegistryName(getChickenParent(config, "Parent 1", allChickens, chicken, chicken.getParent1()));
        	ChickensRegistryItem parent2 = ChickensRegistry.getByRegistryName(getChickenParent(config, "Parent 2", allChickens, chicken, chicken.getParent2()));
            
        	if (parent1 != null && parent2 != null) {
        		chicken.setParentsNew(parent1, parent2);
        	} else {
        		chicken.setNoParents();
        	}
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
	private static ItemStack loadItemStack(JsonConfig configuration, String Category, ChickensRegistryItem chicken, String prefix, ItemStack defaultItemStack) {

    	ItemStack stack = configuration.getItemStack(Category, prefix, defaultItemStack);
    	
        if (stack == null){
        	if(defaultItemStack != null) return defaultItemStack;	
        	else throw new RuntimeException("Cannot find "+prefix+" for "+ chicken.getRegistryName().toString());
        }
        
        return stack;
    }
    
}
