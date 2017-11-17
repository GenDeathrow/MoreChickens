package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RefinedStorageAddon extends BaseModAddon{

	@GameRegistry.ObjectHolder("refinedstorage:quartz_enriched_iron")
	public static final Item quartzEnrichedIron = null;

	@GameRegistry.ObjectHolder("refinedstorage:processor")
	public static final Item processor = null;

	@GameRegistry.ObjectHolder("refinedstorage:cable")
	public static final Item cable = null;

	@GameRegistry.ObjectHolder("refinedstorage:core")
	public static final Item core = null;


	public static ChickensRegistryItem quartzEnrichedIronChicken = null;
	
//	public static ChickensRegistryItem cableChicken = null;
//	public static ChickensRegistryItem advancedProcessorChicken = null;
//	public static ChickensRegistryItem basicProcessorChicken = null;
//	public static ChickensRegistryItem improvedProcessorChicken = null;
//	public static ChickensRegistryItem constructionCoreChicken = null;
//	public static ChickensRegistryItem destructionCoreChicken = null;
	
	public RefinedStorageAddon()
	{
		super("refinedstorage", "Refined Storage", "textures/entity/refinedstorage/");
		setStartID(2090);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens)
	{
		ItemStack quartzEnrichedIronStack = new ItemStack(quartzEnrichedIron, 1, 0);
		quartzEnrichedIronChicken = addChicken(allChickens,
				"quartzenrichedironchicken",
				this.nextID(),
				"quartz_enriched_iron_chicken.png",
				quartzEnrichedIronStack,
				0xE1E0DC, 0x74716D,
				SpawnType.NONE);

//		ItemStack cableStack = new ItemStack(cable, 1, 0);
//		cableChicken = addChicken(allChickens,
//				"cablechicken",
//				this.nextID(),
//				"cable_chicken.png",
//				cableStack,
//				0x848484, 0x3B3B3B,
//				SpawnType.NONE);
//
//		ItemStack basicProcessor = new ItemStack(processor, 1, 3);
//		basicProcessorChicken = addChicken(allChickens,
//				"basicprocessorchicken",
//				this.nextID(),
//				"basic_processor_chicken.png",
//				basicProcessor,
//				0xA8A8A8, 0x808080,
//				SpawnType.NONE);
//
//		ItemStack improvedProcessor = new ItemStack(processor, 1, 4);
//		improvedProcessorChicken = addChicken(allChickens,
//				"improvedprocessorchicken",
//				this.nextID(),
//				"improved_processor_chicken.png",
//				improvedProcessor,
//				0xD7B32F, 0x808080,
//				SpawnType.NONE);
//
//		ItemStack advancedProcessor = new ItemStack(processor, 1, 5);
//		advancedProcessorChicken = addChicken(allChickens,
//				"advancedprocessorchicken",
//				this.nextID(),
//				"advanced_processor_chicken.png",
//				advancedProcessor,
//				0x01E8C8, 0x808080,
//				SpawnType.NONE);
//
//		ItemStack constructionCore = new ItemStack(core, 1, 0);
//		constructionCoreChicken = addChicken(allChickens,
//				"constructioncorechicken",
//				this.nextID(),
//				"construction_core_chicken.png",
//				constructionCore,
//				0x5ACADD, 0x808080,
//				SpawnType.NONE);
//
//		ItemStack destructionCore = new ItemStack(core, 1, 1);
//		destructionCoreChicken = addChicken(allChickens,
//				"destructioncorechicken",
//				this.nextID(),
//				"destruction_core_chicken.png",
//				destructionCore,
//				0xD94224, 0x808080,
//				SpawnType.NONE);
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens)
	{
		setParents(quartzEnrichedIronChicken, QuartzChicken, IronChicken);
//		setParents(cableChicken, BaseMetalsAddon.siliconChicken, quartzEnrichedIronChicken);
//		setParents(basicProcessorChicken, BaseMetalsAddon.siliconChicken, IronChicken);
//		setParents(improvedProcessorChicken, basicProcessorChicken, GoldChicken);
//		setParents(advancedProcessorChicken, improvedProcessorChicken, DiamondChicken);
//		setParents(destructionCoreChicken, basicProcessorChicken, QuartzChicken);
//		setParents(constructionCoreChicken, basicProcessorChicken, GlowstoneChicken);
	}

}
