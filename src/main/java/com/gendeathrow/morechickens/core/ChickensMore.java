package com.gendeathrow.morechickens.core;



import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

import com.gendeathrow.morechickens.core.proxies.CommonProxy;
import com.gendeathrow.morechickens.modHelper.BaseMetals;
import com.gendeathrow.morechickens.modHelper.Botania;
import com.gendeathrow.morechickens.modHelper.DraconicEvolution;
import com.gendeathrow.morechickens.modHelper.TinkersConstruct;
import com.setycz.chickens.ChickensRegistry;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

@Mod(modid = ChickensMore.MODID, name=ChickensMore.NAME, version = ChickensMore.VERSION, dependencies=ChickensMore.dependencies)
public class ChickensMore 
{

		public static final String MODID = "morechickens";
	    public static final String VERSION = "1.0.7";
	    public static final String NAME = "More Chickens";
	    public static final String PROXY = "com.gendeathrow.morechickens.core.proxies";
	    public static final String CHANNELNAME = "morechickens";
	    
	    public static final String dependencies =  "required-after:chickens@[4.1,);after:Botania;after:tconstruct;after:draconicevolution";
	    
	    @Instance(MODID)
		public static ChickensMore instance;
	    
		@SidedProxy(clientSide = PROXY + ".ClientProxy", serverSide = PROXY + ".CommonProxy")
		public static CommonProxy proxy;

		public static SimpleNetworkWrapper network;
		 
		public static FMLEventChannel channel;
		
	    public static org.apache.logging.log4j.Logger logger;

	    File fileConfig;
	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {
	    	logger = event.getModLog();

	    	logger.info("More Chickens PreInit...");
	    	
	    	ChickensMore.network = NetworkRegistry.INSTANCE.newSimpleChannel(ChickensMore.CHANNELNAME);
    	
	    	proxy.preInit(event);
	    	fileConfig = event.getSuggestedConfigurationFile();
	    	
	    }
		
	    @EventHandler
	    public void init(FMLInitializationEvent event) throws IOException
	    {
	    	logger.info("More Chickens Init...");
	    	
	    	proxy.init(event);
	    	
	    	ModItems.registerItems();
	    	
	    	loadConfiguration(fileConfig);
	    	
	    	proxy.registerEventHandlers();
	    	proxy.initRenderers();
	    	
	     }
	    
	    
	    
	    private void loadConfiguration(File configFile) 
	    {
	    	logger.info("More Chickens Loading Config...");
	        Configuration configuration = new Configuration(configFile);

	        Collection<ChickensRegistryItem> allChickens = generateDefaultChickens();
	
	        
	        for (ChickensRegistryItem chicken : allChickens) {
	            boolean enabled = configuration.getBoolean("enabled", chicken.getEntityName(), true, "Is chicken enabled?");
	            chicken.setEnabled(enabled);

	            float layCoefficient = configuration.getFloat("layCoefficient", chicken.getEntityName(), 1.0f, 0.01f, 100.f, "Scale time to lay an egg.");
	            chicken.setLayCoefficient(layCoefficient);

	            ItemStack itemStack = loadItemStack(configuration, chicken, "egg", chicken.createLayItem());
	            chicken.setLayItem(itemStack);

	            ItemStack dropItemStack = loadItemStack(configuration, chicken, "drop", chicken.createDropItem());
	            chicken.setDropItem(dropItemStack);

	            ChickensRegistryItem parent1 = getChickenParent(configuration, "parent1", allChickens, chicken, chicken.getParent1());
	            ChickensRegistryItem parent2 = getChickenParent(configuration, "parent2", allChickens, chicken, chicken.getParent2());
	            if (parent1 != null && parent2 != null) {
	                chicken.setParents(parent1, parent2);
	            } else {
	                chicken.setNoParents();
	            }

	            SpawnType spawnType = SpawnType.valueOf(configuration.getString("spawnType", chicken.getEntityName(), chicken.getSpawnType().toString(), "Chicken spawn type, can be: " + String.join(",", SpawnType.names())));
	            chicken.setSpawnType(spawnType);

	            ChickensRegistry.register(chicken);
	            
	            proxy.registerChicken(chicken);
	        }

	        configuration.save();
	        
	    }
	    
	    
	    private ItemStack loadItemStack(Configuration configuration, ChickensRegistryItem chicken, String prefix, ItemStack defaultItemStack) {
	        String itemName = configuration.getString(prefix + "ItemName", chicken.getEntityName(), defaultItemStack.getItem().getRegistryName().toString(), "Item name to be laid/dropped.");
	        int itemAmount = configuration.getInt(prefix + "ItemAmount", chicken.getEntityName(), defaultItemStack.stackSize, 1, 64, "Item amount to be laid/dropped.");
	        int itemMeta = configuration.getInt(prefix + "ItemMeta", chicken.getEntityName(), defaultItemStack.getMetadata(), Integer.MIN_VALUE, Integer.MAX_VALUE, "Item amount to be laid/dropped.");

	        ResourceLocation itemResourceLocation = new ResourceLocation(itemName);
	        Item item = Item.REGISTRY.getObject(itemResourceLocation);
	        if (item == null) {
	            throw new RuntimeException("Cannot find egg item with name: " + itemName);
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

	    private List<ChickensRegistryItem> generateDefaultChickens() 
	    {
	        List<ChickensRegistryItem> chickens = new ArrayList<ChickensRegistryItem>();

	        ChickensRegistryItem xpChicken = new ChickensRegistryItem(
	                500, "xpChicken", new ResourceLocation(ChickensMore.MODID, "textures/entity/XpChicken.png"),
	                new ItemStack(ModItems.solidXp, 1 , 0),
	                0x3dff1e, 0x3ff123).setSpawnType(SpawnType.NONE);
	        
	        xpChicken.setParents(findChicken(chickens, "emeraldchicken"), findChicken(chickens, "GreenChicken"));
	        chickens.add(xpChicken);
	        
	        //Prismarine shard        
	        ChickensRegistryItem pShardChicken = new ChickensRegistryItem(
	                501, "pShardChicken", new ResourceLocation(ChickensMore.MODID, "textures/entity/PShardChicken.png"),
	                new ItemStack(Items.PRISMARINE_SHARD, 1 , 0),
	                0x43806e, 0x9fcbbc).setSpawnType(SpawnType.NONE);
	        
	        pShardChicken.setParents(findChicken(chickens, "waterchicken"), findChicken(chickens, "bluechicken"));
	        chickens.add(pShardChicken);
	        
	        //Prismarine crystal        
	        ChickensRegistryItem pCrystalChicken = new ChickensRegistryItem(
	                502, "pCrystalChicken", new ResourceLocation(ChickensMore.MODID, "textures/entity/PCrystalChicken.png"),
	                new ItemStack(Items.PRISMARINE_CRYSTALS, 1 , 0),
	                0x4e6961, 0xdfe9dc).setSpawnType(SpawnType.NONE);
	        
	        pCrystalChicken.setParents(findChicken(chickens, "waterchicken"), findChicken(chickens, "emeraldchicken"));
	        chickens.add(pCrystalChicken);
	        
	        chickens = TinkersConstruct.tryRegisterChickens(chickens);
	        
	        chickens = DraconicEvolution.tryRegisterChickens(chickens);
	        
	        chickens = Botania.tryRegisterChickens(chickens);
	        
	        chickens = BaseMetals.tryRegisterChickens(chickens);
	        
	        //RF CHICKEN
	 
	        //RandomPotion
	        
	        //RandomEnchantedBook
	        
	        return chickens;

	    }
	    
	    private ChickensRegistryItem getChickenParent(Configuration configuration, String propertyName, Collection<ChickensRegistryItem> allChickens, ChickensRegistryItem chicken, ChickensRegistryItem parent) 
	    {
	        String parentName = configuration.getString(propertyName, chicken.getEntityName(), parent != null ? parent.getEntityName() : "", "First parent, empty if it's base chicken.");
	        return findChicken(allChickens, parentName);
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




