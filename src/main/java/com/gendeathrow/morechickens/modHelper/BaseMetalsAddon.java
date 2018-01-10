package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.ItemStack;

public class BaseMetalsAddon extends BaseModAddon
{

	
	public BaseMetalsAddon() 
	{
		super("basemetals", "Base Metals", "textures/entity/basemetals/");
		this.setNeedsModPresent(false);
		this.setStartID(140);
	}
	
	public static ChickensRegistryItem brassChicken = null;
	public static ChickensRegistryItem cupronickelChicken = null; 
	public static ChickensRegistryItem electrumChicken = null;
	public static ChickensRegistryItem invarChicken = null;
	public static ChickensRegistryItem bronzeChicken = null;
	public static ChickensRegistryItem copperChicken = null;
	public static ChickensRegistryItem leadChicken = null;
	public static ChickensRegistryItem nickelChicken = null;
	public static ChickensRegistryItem platinumChicken = null;
	public static ChickensRegistryItem silverOreChicken = null;
	public static ChickensRegistryItem tinChicken = null;
	public static ChickensRegistryItem zincChicken = null;
	public static ChickensRegistryItem steelChicken = null;
	public static ChickensRegistryItem siliconChicken = null;
	public static ChickensRegistryItem sulfurChicken = null;
	public static ChickensRegistryItem saltpeterChicken = null;
	public static ChickensRegistryItem aluminumChicken = null;
	public static ChickensRegistryItem amberChicken = null;
	public static ChickensRegistryItem amethystChicken = null;
	public static ChickensRegistryItem malachiteChicken = null;
	public static ChickensRegistryItem peridotChicken = null;
	public static ChickensRegistryItem rubyChicken = null;
	public static ChickensRegistryItem sapphireChicken = null;
	public static ChickensRegistryItem tanzaniteChicken = null;
	public static ChickensRegistryItem topazChicken = null;
	public static ChickensRegistryItem garnetChicken = null;
	public static ChickensRegistryItem saltChicken = null;
	public static ChickensRegistryItem rubberChicken = null;
	

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		invarChicken = addChicken(allChickens, 
				"invarchicken", 
				this.nextID(), 
				"invar_chicken.png", 
				this.getFirstOreDictionary("ingotInvar"), 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		bronzeChicken = addChicken(allChickens, 
				"bronzechicken", 
				this.nextID(), 
				"bronze_chicken.png", 
				this.getFirstOreDictionary("ingotBronze"), 
				0x9a6731, 0xf6a44e, 
				SpawnType.NONE);
		
		zincChicken = addChicken(allChickens, 
				"zincchicken", 
				this.nextID(), 
				"zinc_chicken.png", 
				this.getFirstOreDictionary("ingotZinc"), 
				0xb7b7b7, 0x868686, 
				SpawnType.NONE);
		
		tinChicken = addChicken(allChickens, 
				"tinchicken", 
				this.nextID(), 
				"tin_chicken.png", 
				this.getFirstOreDictionary("ingotTin"), 
				0xfff7ee, 0xbbb1a7, 
				SpawnType.NONE);
		//TODO
		steelChicken = addChicken(allChickens, 
				"steelchicken", 
				this.nextID(), 
				"steel_chicken.png", 
				this.getFirstOreDictionary("ingotSteel"), 
				0xd3e1e3, 0x8e9799, 
				SpawnType.NONE);
		
		silverOreChicken = addChicken(allChickens, 
				"silverorechicken", 
				this.nextID(), 
				"silver_chicken.png", 
				this.getFirstOreDictionary("ingotSilver"), 
				0xbebebe, 0xffffff, 
				SpawnType.NONE);
		
		platinumChicken = addChicken(allChickens, 
				"platinumchicken", 
				this.nextID(), 
				"platinum_chicken.png", 
				this.getFirstOreDictionary("ingotPlatinum"), 
				0xffffff, 0x8d9a96, 
				SpawnType.NONE);
		
		nickelChicken = addChicken(allChickens, 
				"nickelchicken", 
				this.nextID(), 
				"nickel_chicken.png", 
				this.getFirstOreDictionary("ingotNickel"), 
				0xefffec, 0xa2b69f, 
				SpawnType.NONE);
		//TODO
		leadChicken = addChicken(allChickens, 
				"leadchicken", 
				this.nextID(), 
				"lead_chicken.png", 
				this.getFirstOreDictionary("ingotLead"), 
				0x777777, 0x383838, 
				SpawnType.NONE); 
		
		copperChicken = addChicken(allChickens, 
				"copperchicken", 
				this.nextID(), 
				"copper_chicken.png", 
				this.getFirstOreDictionary("ingotCopper"), 
				0xc06a48, 0xff9d76, 
				SpawnType.NONE); 
		
		brassChicken = addChicken(allChickens, 
				"brasschicken", 
				this.nextID(), 
				"brass_chicken.png", 
				this.getFirstOreDictionary("ingotBrass"), 
				0xa99340, 0xffe377, 
				SpawnType.NONE); 
		
		cupronickelChicken = addChicken(allChickens, 
				"cupronickelchicken", 
				this.nextID(), 
				"cupronickel_chicken.png", 
				this.getFirstOreDictionary("ingotCupronickel"), 
				0xd8ccb4, 0x98896c, 
				SpawnType.NONE); 
		
		electrumChicken = addChicken(allChickens, 
				"electrumchicken", 
				this.nextID(), 
				"electrum_chicken.png", 
				this.getFirstOreDictionary("ingotElectrum"), 
				0xfff2b1, 0xd4be50, 
				SpawnType.NONE); 
		
		siliconChicken =  addChicken(allChickens, 
				"siliconchicken", 
				this.nextID(), 
				"silicon_chicken.png", 
				this.getFirstOreDictionary("itemSilicon"), 
				0x5f706b, 0x424242, 
				SpawnType.NONE); 
		
		sulfurChicken =  addChicken(allChickens, 
				"sulfurchicken", 
				this.nextID(), 
				"sulfur_chicken.png", 
				this.getFirstOreDictionary("dustSulfur"), 
				0xFFE782, 0xAD9326, 
				SpawnType.NONE); 
		
		saltpeterChicken =  addChicken(allChickens, 
				"saltpeterchicken", 
				this.nextID(), 
				"saltpeter_chicken.png", 
				this.getFirstOreDictionary("dustSaltpeter"), 
				0xDDD6D6, 0xAC9E9D, 
				SpawnType.NONE); 
		
		ItemStack ingotAlu = this.getFirstOreDictionary("ingotAluminum");
		if(ingotAlu == null) ingotAlu = this.getFirstOreDictionary("ingotAluminium");

		aluminumChicken = addChicken(allChickens, 
				"aluminumChicken", 
				this.nextID(), 
				"aluminium_chicken.png", 
				ingotAlu, 
				0xd3dddc, 0xcbd7d6, 
				SpawnType.NONE);

		amberChicken = addChicken(allChickens, 
				"amberchicken", 
				this.nextID(), 
				"amber_chicken.png", 
				this.getFirstOreDictionary("gemAmber"), 
				0xFFAD21, 0x7F5113, 
				SpawnType.NONE);

		amethystChicken = addChicken(allChickens, 
				"amethystchicken", 
				this.nextID(), 
				"amethyst_chicken.png", 
				this.getFirstOreDictionary("gemAmethyst"), 
				0xE051ED, 0x841D8E, 
				SpawnType.NONE);

		malachiteChicken = addChicken(allChickens, 
				"malachitechicken", 
				this.nextID(), 
				"malachite_chicken.png", 
				this.getFirstOreDictionary("gemMalachite"), 
				0x29B17F, 0x085F50, 
				SpawnType.NONE);

		peridotChicken = addChicken(allChickens, 
				"peridotchicken", 
				this.nextID(), 
				"peridot_chicken.png", 
				this.getFirstOreDictionary("gemPeridot"), 
				0x6CA127, 0x29430B, 
				SpawnType.NONE);

		rubyChicken = addChicken(allChickens, 
				"rubychicken", 
				this.nextID(), 
				"ruby_chicken.png", 
				this.getFirstOreDictionary("gemRuby"), 
				0xB7002E, 0x5A0116, 
				SpawnType.NONE);

		sapphireChicken = addChicken(allChickens, 
				"sapphirechicken", 
				this.nextID(), 
				"sapphire_chicken.png", 
				this.getFirstOreDictionary("gemSapphire"), 
				0x19689A, 0x0D4565, 
				SpawnType.NONE);

		tanzaniteChicken = addChicken(allChickens, 
				"tanzanitechicken", 
				this.nextID(), 
				"tanzanite_chicken.png", 
				this.getFirstOreDictionary("gemTanzanite"), 
				0x7310C0, 0x5A007F, 
				SpawnType.NONE);

		topazChicken = addChicken(allChickens, 
				"topazchicken", 
				this.nextID(), 
				"topaz_chicken.png", 
				this.getFirstOreDictionary("gemTopaz"), 
				0xD64D00, 0x7C3400, 
				SpawnType.NONE);		
		
		ItemStack gemGarnet = this.getFirstOreDictionary("gemGarnet");
		if(gemGarnet == null) gemGarnet = this.getFirstOreDictionary("gemRedGarnet"); //TechReborn

		garnetChicken = addChicken(allChickens, 
				"garnetchicken", 
				this.nextID(), 
				"garnet_chicken.png", 
				gemGarnet, 
				0xA45962, 0x44171A, 
				SpawnType.NONE);

		ItemStack itemSalt = this.getFirstOreDictionary("itemSalt");
		if(itemSalt == null) itemSalt = this.getFirstOreDictionary("dustSalt");
		if(itemSalt == null) itemSalt = this.getFirstOreDictionary("foodSalt");

		saltChicken = addChicken(allChickens, 
				"saltchicken", 
				this.nextID(), 
				"salt_chicken.png", 
				itemSalt, 
				0xEAE8DA, 0xDBD9CC, 
				SpawnType.NONE);

		ItemStack itemRubber = this.getFirstOreDictionary("itemRubber");
		if(itemRubber == null) itemRubber = this.getFirstOreDictionary("materialRubber");

		rubberChicken = addChicken(allChickens, 
				"rubberchicken", 
				this.nextID(), 
				"rubber_chicken.png", 
				itemRubber, 
				0x895D02, 0x4E3209, 
				SpawnType.NONE);

		return allChickens;
	}


	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(brassChicken, copperChicken, zincChicken);
		setParents(bronzeChicken, copperChicken, tinChicken);
		setParents(invarChicken, IronChicken, nickelChicken);
		setParents(cupronickelChicken, copperChicken, nickelChicken);
		setParents(electrumChicken, silverOreChicken, GoldChicken);
		setParents(steelChicken, IronChicken, CoalChicken);
		setParents(copperChicken, YellowChicken, BrownChicken);
		setParents(leadChicken, IronChicken, CyanChicken);
		setParents(tinChicken, WhiteChicken, ClayChicken);
		setParents(nickelChicken, WhiteChicken, GreenChicken);
		setParents(zincChicken, WhiteChicken, ClayChicken);
		setParents(silverOreChicken, IronChicken, WhiteChicken);
		setParents(platinumChicken, nickelChicken, silverOreChicken);
		setParents(sulfurChicken, GunpowderChicken, FlintChicken);
		setParents(saltpeterChicken, sulfurChicken, RedstoneChicken);
		setParents(siliconChicken, ClayChicken, SandChicken);
		setParents(aluminumChicken, FlintChicken, IronChicken);	
		setParents(amberChicken, WaterChicken, LogChicken);
		setParents(amethystChicken, GhastChicken, PurpleChicken);
		if(this.getFirstOreDictionary("ingotCopper") != null)
			setParents(malachiteChicken, copperChicken, CoalChicken);
		else
			setParents(malachiteChicken, GreenChicken, CoalChicken);
		if(this.getFirstOreDictionary("itemSilicon") != null)
			setParents(peridotChicken, siliconChicken, GreenChicken);
		else
			setParents(peridotChicken, QuartzChicken, GreenChicken);
		if(this.getFirstOreDictionary("ingotAluminum") != null || this.getFirstOreDictionary("ingotAluminium") != null)
		{
			setParents(sapphireChicken, BlueChicken, aluminumChicken);
			setParents(rubyChicken, RedChicken, aluminumChicken);
		}
		else
		{
			setParents(sapphireChicken, BlueChicken, SnowballChicken);
			setParents(rubyChicken, RedChicken, SnowballChicken);
		}
		if(this.getFirstOreDictionary("gemRuby") != null && this.getFirstOreDictionary("gemSapphire") != null)
			setParents(garnetChicken, sapphireChicken, rubyChicken);
		else
			setParents(garnetChicken, IronChicken, RedChicken);
		setParents(tanzaniteChicken, QuartzChicken, PurpleChicken);
		setParents(topazChicken, QuartzChicken, OrangeChicken);
		setParents(saltChicken, WaterChicken, LavaChicken);
		setParents(rubberChicken, LogChicken, OrangeChicken);
	}



}
