package com.gendeathrow.morechickens.core;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import org.apache.logging.log4j.Level;

import com.gendeathrow.morechickens.core.proxies.CommonProxy;
import com.gendeathrow.morechickens.modHelper.BaseMetalsAddon;
import com.gendeathrow.morechickens.modHelper.BaseModAddon;
import com.gendeathrow.morechickens.modHelper.BotaniaAddon;
import com.gendeathrow.morechickens.modHelper.DraconicEvolutionAddon;
import com.gendeathrow.morechickens.modHelper.EnderIOAddon;
import com.gendeathrow.morechickens.modHelper.ExtremeReactorsAddon;
import com.gendeathrow.morechickens.modHelper.ImmersiveEngineeringAddon;
import com.gendeathrow.morechickens.modHelper.MekanismAddon;
import com.gendeathrow.morechickens.modHelper.MoreChickens;
import com.gendeathrow.morechickens.modHelper.SpecialChickens;
import com.gendeathrow.morechickens.modHelper.ThermalFoundationAddon;
import com.gendeathrow.morechickens.modHelper.TinkersConstructAddon;
import com.gendeathrow.morechickens.util.LogUtil;
import com.setycz.chickens.ChickensRegistry;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

@Mod(modid = ChickensMore.MODID, name=ChickensMore.NAME, version = ChickensMore.VERSION, dependencies=ChickensMore.dependencies)
public class ChickensMore 
{

		public static final String MODID = "morechickens";
	    public static final String VERSION = "1.1.6";
	    public static final String NAME = "More Chickens";
	    public static final String PROXY = "com.gendeathrow.morechickens.core.proxies";
	    public static final String CHANNELNAME = "morechickens";
	    
	    public static final String dependencies =  "required-after:chickens@[4.2.2,);"
	    		+ "after:Botania;"
	    		+ "after:basemetals;"
	    		+ "after:tconstruct;"
	    		+ "after:draconicevolution;"
	    		+ "after:immersiveengineering;"
	    		+ "after:mekanism;"
	    		+ "after:bigreactors;"
	    		+ "after:EnderIO;"
	    		+ "after:thermalfoundation";
	    
	    @Instance(MODID)
		public static ChickensMore instance;
	    
		@SidedProxy(clientSide = PROXY + ".ClientProxy", serverSide = PROXY + ".CommonProxy")
		public static CommonProxy proxy;

		public static SimpleNetworkWrapper network;
		 
		public static FMLEventChannel channel;

	    public static boolean isDev = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

	    File fileConfig;
	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {
	    	LogUtil.setup();
	    	
	    	//logger = LogUtil;	   
	    	LogUtil.log(Level.DEBUG, "is Dev "+ isDev);
	    	LogUtil.info("More Chickens PreInit...");
	    	ChickensMore.network = NetworkRegistry.INSTANCE.newSimpleChannel(ChickensMore.CHANNELNAME);
    	
	    	RegisterModAddons();
	    	
	    	proxy.preInit(event);
	    	fileConfig = event.getSuggestedConfigurationFile();
	    }
		
	    @EventHandler
	    public void init(FMLInitializationEvent event) throws IOException
	    {
	    	LogUtil.info("More Chickens Init...");
	    	
	    	proxy.init(event);
	    	
	    	ModItems.registerItems();
	    	
	    	loadConfiguration(fileConfig);
	    	
	    	proxy.registerEventHandlers();
	    	proxy.initRenderers();
	    	
	     }
	    
	    
	    
	    private void loadConfiguration(File configFile) 
	    {

	        Configuration configuration = new Configuration(configFile);

	        Collection<ChickensRegistryItem> allChickens = generateDefaultChickens();
	    	
	        configuration.addCustomCategoryComment("0", "It is Ideal to regenerate this file after updates as your config files may overwrite changes made to core.");
	    	
	        LogUtil.info("More Chickens Loading Config...");
	        for (ChickensRegistryItem chicken : allChickens) 
	        {
	        	
	        	
	            boolean enabled = configuration.getBoolean("enabled", chicken.getEntityName(), true, "Is chicken enabled?");
	            chicken.setEnabled(enabled);

	            float layCoefficient = configuration.getFloat("layCoefficient", chicken.getEntityName(), 1.0f, 0.01f, 100.f, "Scale time to lay an egg.");
	            chicken.setLayCoefficient(layCoefficient);

	            ItemStack itemStack = loadItemStack(configuration, chicken, "egg", chicken.createLayItem());
	            chicken.setLayItem(itemStack);

	            ItemStack dropItemStack = loadItemStack(configuration, chicken, "drop", chicken.createDropItem());
	            chicken.setDropItem(dropItemStack);

	            String parent1ID = getChickenParent(configuration, "parent1", allChickens, chicken, chicken.getParent1());
	            String parent2ID =  getChickenParent(configuration, "parent2", allChickens, chicken, chicken.getParent2());
	            
	            ChickensRegistryItem parent1 = findChicken(allChickens, parent1ID);
	            ChickensRegistryItem parent2 = findChicken(allChickens, parent2ID);
	            
	            if (parent1 != null && parent2 != null) {
	                chicken.setParentsNew(parent1, parent2);
	            } else {
	                chicken.setNoParents();
	            }

	            SpawnType spawnType = SpawnType.valueOf(configuration.getString("spawnType", chicken.getEntityName(), chicken.getSpawnType().toString(), "Chicken spawn type, can be: " + String.join(",", SpawnType.names())));
	            chicken.setSpawnType(spawnType);

	            ChickensRegistry.register(chicken);
	            
	            proxy.registerChicken(chicken);
	        }
	        
	        
	        for(ChickensRegistryItem specialChickens : SpecialChickens.init(new ArrayList<ChickensRegistryItem>()))
	        {
	        	allChickens.add(specialChickens);
	        	ChickensRegistry.register(specialChickens);
	        	proxy.registerChicken(specialChickens);
	        }
	
	        configuration.save();
	        
	    }
	    
	    
	    @SuppressWarnings("unused")
		private ItemStack loadItemStack(Configuration configuration, ChickensRegistryItem chicken, String prefix, ItemStack defaultItemStack) {
	        String itemName = configuration.getString(prefix + "ItemName", chicken.getEntityName(), defaultItemStack.getItem().getRegistryName().toString(), "Item name to be laid/dropped.");
	        int itemAmount = configuration.getInt(prefix + "ItemAmount", chicken.getEntityName(), defaultItemStack.stackSize, 1, 64, "Item amount to be laid/dropped.");
	        int itemMeta = configuration.getInt(prefix + "ItemMeta", chicken.getEntityName(), defaultItemStack.getMetadata(), Integer.MIN_VALUE, Integer.MAX_VALUE, "Item amount to be laid/dropped.");

	        ResourceLocation itemResourceLocation = new ResourceLocation(itemName);
	        Item item = Item.REGISTRY.getObject(itemResourceLocation);
	        if (item == null) 
	        {
	        	if(defaultItemStack != null) return defaultItemStack;	
	        	else throw new RuntimeException("Cannot find egg item with name: " + itemName);
	        }
	        return new ItemStack(item, itemAmount, itemMeta);
	    }
	    
	    @EventHandler
	    public void postInit(FMLPostInitializationEvent event)
	    {
	    	
	    	proxy.postInit(event);
	    }
	    
		@EventHandler
		public void serverStart(FMLServerStartingEvent event)
		{

		}
		
		public ArrayList<BaseModAddon> registeredModAddons = new ArrayList<BaseModAddon>();
		
		private void RegisterModAddons()
		{
			addModAddon(new MoreChickens());
			addModAddon(new BaseMetalsAddon());
			addModAddon(new BotaniaAddon());
			addModAddon(new DraconicEvolutionAddon());
			addModAddon(new EnderIOAddon());
			addModAddon(new ExtremeReactorsAddon());
			addModAddon(new ImmersiveEngineeringAddon());
			addModAddon(new MekanismAddon());
			addModAddon(new ThermalFoundationAddon());
			addModAddon(new TinkersConstructAddon());
			
		}
		
		public void addModAddon(BaseModAddon addon)
		{
			if(addon == null)
			{
				LogUtil.error("Tried to add null mod addon");
				return;
			}
			
			registeredModAddons.add(addon);
		}

	    private List<ChickensRegistryItem> generateDefaultChickens() 
	    {
	        List<ChickensRegistryItem> chickens = new ArrayList<ChickensRegistryItem>();

	        for(BaseModAddon addon : registeredModAddons)
	        {
	        	chickens = addon.tryRegisterChickens(chickens);
	        }
	        
	        //SetParents
	        
	        for(BaseModAddon addon : registeredModAddons)
	        {
	        	LogUtil.debug("Register "+ addon.getModName() + " Parents");
	        	addon.RegisterAllParents(chickens);
	        }	        
	        
	        return chickens;

	    }
	    
	    private String getChickenParent(Configuration configuration, String propertyName, Collection<ChickensRegistryItem> allChickens, ChickensRegistryItem chicken, ChickensRegistryItem parent) 
	    {
	        //String parentName = 
	        //return findChicken(allChickens, parentName);
	        
	        return configuration.getString(propertyName, chicken.getEntityName(), parent != null ? parent.getEntityName() : "", "First parent, empty if it's base chicken.");
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
	    
	}




