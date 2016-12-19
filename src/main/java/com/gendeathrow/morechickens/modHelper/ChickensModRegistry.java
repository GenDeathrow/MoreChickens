package com.gendeathrow.morechickens.modHelper;

import java.util.Collection;
import java.util.List;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;

public abstract class ChickensModRegistry 
{
	public String modID;
	
	public abstract List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens);
		
	protected static ChickensRegistryItem findChicken(Collection<ChickensRegistryItem> chickens, String name) 
	{
		for (ChickensRegistryItem chicken : chickens) 
		{
			if (chicken.getEntityName().compareToIgnoreCase(name) == 0) 
			{
				return chicken;
			}
		}
				
				return ChickensMore.instance.findChicken(null, name);
	}
	    
	    
	public abstract void registerParents();
	
	
}
