package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

public class TechRebornAddon extends BaseModAddon{

	// ingotChrome, ingotIridium, ingotTitanium, ingotTungsten, ingotTungstensteel, ingotRefinedIron, ingotAdvancedAlloy
	// gemRuby, gemSapphire, gemPeridot, gemRedGarnet, gemYellowGarnet
	public static ChickensRegistryItem chromeChicken = null;
	public static ChickensRegistryItem iridiumChicken = null;
	public static ChickensRegistryItem titaniumChicken = null;
	public static ChickensRegistryItem tungstenChicken = null;
	public static ChickensRegistryItem tungstensteelChicken = null;
	public static ChickensRegistryItem refinedIronChicken = null;
	
	//Gems
	public static ChickensRegistryItem rubyChicken = null;
	public static ChickensRegistryItem sapphireChicken = null;
	public static ChickensRegistryItem peridotChicken = null;
	public static ChickensRegistryItem redGarnetChicken = null;
	public static ChickensRegistryItem yelloGarnetChicken = null;

	public TechRebornAddon() {
		super("techreborn", "Tech Reborn", "textures/entity/techreborn");
		this.setNeedsModPresent(false);
	}
	
	//TODO egg colors and images
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) {
		
		// Gems
		rubyChicken = addChicken(allChickens, 
				"rubychicken", 
				this.nextID(), 
				"rubychicken_chicken.png", 
				this.getFirstOreDictionary("gemRuby"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		sapphireChicken = addChicken(allChickens, 
				"gemsapphirechicken", 
				this.nextID(), 
				"gemsapphire_chicken.png", 
				this.getFirstOreDictionary("gemSapphire"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		peridotChicken = addChicken(allChickens, 
				"peridotchicken", 
				this.nextID(), 
				"peridotchicken_chicken.png", 
				this.getFirstOreDictionary("gemPeridot"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		redGarnetChicken = addChicken(allChickens, 
				"redgarnetchicken", 
				this.nextID(), 
				"redgarnet_chicken.png", 
				this.getFirstOreDictionary("gemRedGarnet"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		yelloGarnetChicken = addChicken(allChickens, 
				"yellogarnetchicken", 
				this.nextID(), 
				"yellogarnet_chicken.png", 
				this.getFirstOreDictionary("gemYellowGarnet"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);

		//Ores
		chromeChicken = addChicken(allChickens, 
				"chromechicken", 
				this.nextID(), 
				"chrome_chicken.png", 
				this.getFirstOreDictionary("ingotChrome"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		iridiumChicken = addChicken(allChickens, 
				"iridiumchicken", 
				this.nextID(), 
				"iridium_chicken.png", 
				this.getFirstOreDictionary("ingotIridium"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		titaniumChicken = addChicken(allChickens, 
				"titaniumchicken", 
				this.nextID(), 
				"titanium_chicken.png", 
				this.getFirstOreDictionary("ingotTitanium"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		tungstenChicken = addChicken(allChickens, 
				"tungstenchicken", 
				this.nextID(), 
				"tungsten_chicken.png", 
				this.getFirstOreDictionary("ingotTungsten"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		tungstensteelChicken = addChicken(allChickens, 
				"tungstensteelchicken", 
				this.nextID(), 
				"tungstensteel_chicken.png", 
				this.getFirstOreDictionary("tungstensteelChicken"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		refinedIronChicken = addChicken(allChickens, 
				"refinedironchicken", 
				this.nextID(), 
				"refinedironchicken_chicken.png", 
				this.getFirstOreDictionary("ingotRefinedIron"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		
		return allChickens;
	}
	
	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) {

		setParents(refinedIronChicken, BaseModAddon.IronChicken, BaseModAddon.IronChicken);
		setParents(titaniumChicken, BaseModAddon.IronChicken, BaseMetalsAddon.aluminumChicken);
		setParents(iridiumChicken, BaseModAddon.FlintChicken, BaseMetalsAddon.platinumChicken);
		setParents(chromeChicken, BaseMetalsAddon.tinChicken, titaniumChicken);
		setParents(tungstenChicken, BaseModAddon.EnderChicken, refinedIronChicken);
		setParents(tungstensteelChicken, tungstenChicken, BaseMetalsAddon.steelChicken);
		
		
		setParents(rubyChicken, BaseModAddon.GlassChicken, BaseModAddon.RedChicken);
		setParents(sapphireChicken, BaseModAddon.GlassChicken, BaseModAddon.BlueChicken);
		setParents(peridotChicken, BaseModAddon.GlassChicken, BaseModAddon.EnderChicken);
		setParents(redGarnetChicken, BaseModAddon.GlassChicken, BaseModAddon.RedstoneChicken);
		setParents(yelloGarnetChicken, BaseModAddon.GlassChicken, BaseModAddon.GlowstoneChicken);
		

	}

	
	
}
