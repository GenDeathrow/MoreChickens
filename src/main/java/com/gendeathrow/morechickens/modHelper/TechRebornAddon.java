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
	public static ChickensRegistryItem redGarnetChicken = null;
	public static ChickensRegistryItem yelloGarnetChicken = null;

	public TechRebornAddon() {
		super("techreborn", "Tech Reborn", "textures/entity/techreborn/");
		this.setNeedsModPresent(false);
	}
	
	//TODO egg colors and images
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) {
		
//		if(BaseMetalsAddon.garnetChicken == null)
//		redGarnetChicken = addChicken(allChickens, 
//				"redgarnetchicken", 
//				this.nextID(), 
//				"redgarnet_chicken.png", 
//				this.getFirstOreDictionary("gemRedGarnet"), 
//				0x989585, 0xd1ccb6, 
//				SpawnType.NONE);
		
		yelloGarnetChicken = addChicken(allChickens, 
				"yellowgarnetchicken", 
				this.nextID(), 
				"yellowgarnet_chicken.png", 
				this.getFirstOreDictionary("gemYellowGarnet"), 
				0xa5a537, 0x414116, 
				SpawnType.NONE);

		//Ores
		chromeChicken = addChicken(allChickens, 
				"chromechicken", 
				this.nextID(), 
				"chrome_chicken.png", 
				this.getFirstOreDictionary("ingotChrome"), 
				0xa0a1a3, 0x454545, 
				SpawnType.NONE);
		
////		if(ThermalFoundationAddon.iridiumChicken == null)
//			iridiumChicken = addChicken(allChickens, 
//					"iridiumChicken", 
//					this.nextID(), 
//					"iridium_chicken.png", 
//					this.getFirstOreDictionary("ingotIridium"), 
//					0x989585, 0xd1ccb6, 
//					SpawnType.NONE);
		
		titaniumChicken = addChicken(allChickens, 
				"titaniumchicken", 
				this.nextID(), 
				"titanium_chicken.png", 
				this.getFirstOreDictionary("ingotTitanium"), 
				0xe2e2e2, 0x5f5959, 
				SpawnType.NONE);
		
		tungstenChicken = addChicken(allChickens, 
				"tungstenchicken", 
				this.nextID(), 
				"tungsten_chicken.png", 
				this.getFirstOreDictionary("ingotTungsten"), 
				0xc3bd89, 0xdee6a6, 
				SpawnType.NONE);
		
		tungstensteelChicken = addChicken(allChickens, 
				"tungstensteelchicken", 
				this.nextID(), 
				"tungstensteel_chicken.png", 
				this.getFirstOreDictionary("ingotTungstensteel"), 
				0x343536, 0x696d71, 
				SpawnType.NONE);
		
		refinedIronChicken = addChicken(allChickens, 
				"refinedironchicken", 
				this.nextID(), 
				"refinediron_chicken.png", 
				this.getFirstOreDictionary("ingotRefinedIron"), 
				0xb6c4d3, 0xb6c4d3, 
				SpawnType.NONE);
		
		
		return allChickens;
	}
	
	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) {
		setParents(refinedIronChicken, BaseModAddon.IronChicken, BaseModAddon.IronChicken);
		setParents(titaniumChicken, BaseModAddon.IronChicken, BaseMetalsAddon.aluminumChicken);

		// Incase thermalFoundation isn't added
		if(ThermalFoundationAddon.iridiumChicken != null && (ThermalFoundationAddon.iridiumChicken.getParent1() == null || ThermalFoundationAddon.iridiumChicken.getParent2() == null))
			setParents(ThermalFoundationAddon.iridiumChicken, BaseModAddon.FlintChicken, BaseMetalsAddon.platinumChicken);
		
		setParents(chromeChicken, BaseMetalsAddon.tinChicken, titaniumChicken);
		setParents(tungstenChicken, BaseModAddon.EnderChicken, refinedIronChicken);
		setParents(tungstensteelChicken, tungstenChicken, BaseMetalsAddon.steelChicken);
		setParents(redGarnetChicken, BaseModAddon.GlassChicken, BaseModAddon.RedstoneChicken);
		setParents(yelloGarnetChicken, BaseModAddon.GlassChicken, BaseModAddon.GlowstoneChicken);
	}

	
	
}
