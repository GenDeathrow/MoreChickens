package com.gendeathrow.morechickens.core;

import com.gendeathrow.morechickens.items.SolidXp;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ModItems 
{

	public static Item solidXp = setUpItem(new SolidXp(), "solidXP");
	public static Item solidRf;
	
	
	public static IForgeRegistry<Item> itemRegistry;
	
	
	public static Item setUpItem(Item item, String name) {
		return item.setRegistryName(new ResourceLocation(ChickensMore.MODID, name)).setUnlocalizedName(ChickensMore.MODID+"."+ name);
	}
	
	@SubscribeEvent
	public static void itemRegistry(RegistryEvent.Register<Item> event) {
		itemRegistry = event.getRegistry();
		
		itemRegistry.register(solidXp);
		
	}

}
