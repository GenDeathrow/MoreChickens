package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class ImmersiveEngineeringAddon extends BaseModAddon
{

	public static ChickensRegistryItem uraniumChicken = null; 
	public static ChickensRegistryItem constantanChicken = null;
	public static ChickensRegistryItem bulletChicken = null;
	
	@GameRegistry.ObjectHolder("immersiveengineering:bullet")
	public static final Item bullet = null;
	
	public ImmersiveEngineeringAddon() 
	{
		super("immersiveengineering", "Immersive Engineering", "textures/entity/immersive_engineering/");
		this.setNeedsModPresent(false);
		this.setStartID(2001);
	}

	/**
	 * Textures Created by "MrAmericanMike"
	 */
	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{		
		uraniumChicken = addChicken(allChickens, 
				"uraniumChicken", 
				this.nextID(), 
				"uranium_chicken.png", 
				this.getFirstOreDictionary("ingotUranium"), 
				0x91d76d, 0x9ce26c, 
				SpawnType.NONE);
		
		constantanChicken = addChicken(allChickens, 
				"constantanChicken", 
				this.nextID(), 
				"consrtantan_chicken.png", 
				this.getFirstOreDictionary("ingotConstantan"), 
				0xf98669, 0x795851, 
				SpawnType.NONE);
		 
		if(bullet != null)
		{
			ItemStack bulletStack = new ItemStack(bullet, 3, 2);
		
				bulletChicken = addChicken(allChickens, 
						"bulletChicken", 
						this.nextID(), 
						"bullet_chicken.png", 
						bulletStack, 
						0xefb953, 0x545454, 
						SpawnType.NONE);
		
				if(bulletChicken != null) bulletChicken.setLayCoefficient(3);
		}
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(uraniumChicken, RedstoneChicken, EnderChicken);
		setParents(constantanChicken, BaseMetalsAddon.copperChicken, BaseMetalsAddon.nickelChicken);
		setParents(bulletChicken, GunpowderChicken, BaseMetalsAddon.leadChicken);
	}
}
