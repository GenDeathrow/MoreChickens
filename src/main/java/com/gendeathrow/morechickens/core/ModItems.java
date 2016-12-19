package com.gendeathrow.morechickens.core;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.gendeathrow.morechickens.items.SolidRF;
import com.gendeathrow.morechickens.items.SolidXp;

public class ModItems 
{

	public static SolidXp solidXp;
	public static SolidRF solidRf;
	
	
	
	
	public static void registerItems()
	{
		solidXp = new SolidXp();
		
		GameRegistry.register(solidXp);
	}
}
