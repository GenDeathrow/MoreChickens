package com.gendeathrow.morechickens.core;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Level;

import com.gendeathrow.morechickens.core.configs.ConfigHandler;
import com.gendeathrow.morechickens.core.proxies.CommonProxy;
import com.gendeathrow.morechickens.modHelper.ActuallyAdditionsAddon;
import com.gendeathrow.morechickens.modHelper.ArsMagica2Addon;
import com.gendeathrow.morechickens.modHelper.BaseMetalsAddon;
import com.gendeathrow.morechickens.modHelper.BaseModAddon;
import com.gendeathrow.morechickens.modHelper.BotaniaAddon;
import com.gendeathrow.morechickens.modHelper.DraconicEvolutionAddon;
import com.gendeathrow.morechickens.modHelper.EnderIOAddon;
import com.gendeathrow.morechickens.modHelper.EvilCraftAddon;
import com.gendeathrow.morechickens.modHelper.ExtraUtilitiesAddon;
import com.gendeathrow.morechickens.modHelper.ExtremeReactorsAddon;
import com.gendeathrow.morechickens.modHelper.FluidChickensAddon;
import com.gendeathrow.morechickens.modHelper.ImmersiveEngineeringAddon;
import com.gendeathrow.morechickens.modHelper.MekanismAddon;
import com.gendeathrow.morechickens.modHelper.MineFactoryReloadedAddon;
import com.gendeathrow.morechickens.modHelper.MoreChickens;
import com.gendeathrow.morechickens.modHelper.RefinedStorageAddon;
import com.gendeathrow.morechickens.modHelper.SpecialChickens;
import com.gendeathrow.morechickens.modHelper.TechRebornAddon;
import com.gendeathrow.morechickens.modHelper.ThermalFoundationAddon;
import com.gendeathrow.morechickens.modHelper.TinkersConstructAddon;
import com.gendeathrow.morechickens.util.LogUtil;
import com.setycz.chickens.registry.ChickensRegistry;
import com.setycz.chickens.registry.ChickensRegistryItem;

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

@Mod(modid = ChickensMore.MODID, name=ChickensMore.NAME, version = ChickensMore.VERSION, dependencies=ChickensMore.dependencies)
public class ChickensMore 
{

		public static final String MODID = "morechickens";
	    //public static final String VERSION = "3.0.0";
		public static final String VERSION = "@VERSION@";
	    public static final String NAME = "More Chickens";
	    public static final String PROXY = "com.gendeathrow.morechickens.core.proxies";
	    public static final String CHANNELNAME = "morechickens";
	    
	    //TODO required-after:chickens@[6.0.0,);
	    public static final String dependencies =  "required-after:chickens@[6.0.0,);"
	    		+ "after:botania;"
	    		+ "after:basemetals;"
	    		+ "after:tconstruct;"
	    		+ "after:draconicevolution;"
	    		+ "after:immersiveengineering;"
	    		+ "after:mekanism;"
	    		+ "after:bigreactors;"
	    		+ "after:enderio;"
	    		+ "after:thermalfoundation;"
	    		+ "after:arsmagica2;"
	    		+ "after:evilcraft;"
	    		+ "after:minefactoryreloaded;"
	    		+ "after:actuallyadditions;"
	    		+ "after:extrautils2;"
	    		+ "after:refinedstorage;"
	    		+ "after:techreborn";
	    
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
	        ConfigHandler.loadChickens(allChickens);

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
	    	String Category = chicken.getRegistryName().toString();
	    	
	        String itemName = configuration.getString(prefix + "ItemName", Category, defaultItemStack.getItem().getRegistryName().toString(), "Item name to be laid/dropped.");
	        int itemAmount = configuration.getInt(prefix + "ItemAmount", Category, defaultItemStack.getCount(), 1, 64, "Item amount to be laid/dropped.");
	        int itemMeta = configuration.getInt(prefix + "ItemMeta", Category, defaultItemStack.getMetadata(), Integer.MIN_VALUE, Integer.MAX_VALUE, "Item amount to be laid/dropped.");

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
			//addModAddon(new FluidChickensAddon());
			addModAddon(new BotaniaAddon());
			addModAddon(new DraconicEvolutionAddon());
			addModAddon(new EnderIOAddon());
			addModAddon(new ExtremeReactorsAddon());
			addModAddon(new ImmersiveEngineeringAddon());
			addModAddon(new MekanismAddon());
			addModAddon(new ThermalFoundationAddon());
			addModAddon(new TinkersConstructAddon());
			addModAddon(new ArsMagica2Addon());
			addModAddon(new EvilCraftAddon());
			addModAddon(new MineFactoryReloadedAddon());
			addModAddon(new ActuallyAdditionsAddon());
			addModAddon(new ExtraUtilitiesAddon());
			addModAddon(new RefinedStorageAddon());
			addModAddon(new TechRebornAddon());
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
	    	String Category = chicken.getRegistryName().toString();
	        return configuration.getString(propertyName, Category, parent != null ? parent.getEntityName() : "", "First parent, empty if it's base chicken.");
	    }
	    

	    
	}




