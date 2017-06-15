package com.gendeathrow.morechickens.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.gendeathrow.morechickens.util.ChickenInformation;
import com.setycz.chickens.ChickensRegistry;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;
import com.setycz.chickens.spawnEgg.ItemSpawnEgg;

public class EggTooltips 
{

	@SubscribeEvent
	public void renderToolTip(ItemTooltipEvent event)
	{
		if(!event.getEntity().world.isRemote) return;
		
		if(event.getItemStack().getItem() instanceof ItemSpawnEgg)
		{
			ChickensRegistryItem chicken = ChickensRegistry.getByRegistryName(ItemSpawnEgg.getTypeFromStack(event.getItemStack()));
			
			ItemStack layitem = chicken.createLayItem();
			
			if(layitem != null && layitem.getItem() != null)
				addLine(event, new TextComponentTranslation("text.morechickens.layitem", layitem.getDisplayName()).getFormattedText());
			else 
				addLine(event, new TextComponentTranslation("text.morechickens.nolayitem", layitem.getDisplayName()).getFormattedText());
			
			if(chicken.getSpawnType() != SpawnType.NONE)
			{
				TextFormatting format = chicken.getSpawnType() == SpawnType.NORMAL ? TextFormatting.GREEN : chicken.getSpawnType() == SpawnType.HELL ? TextFormatting.RED : chicken.getSpawnType() == SpawnType.SNOW ? TextFormatting.AQUA : TextFormatting.WHITE; 
				addLine(event, TextFormatting.AQUA + new TextComponentTranslation("text.morechickens.spawnType").getFormattedText() +": "+ TextFormatting.RESET + format + chicken.getSpawnType().toString());
			}
			
		
			if(!chicken.isBreedable())
				addLine(event, TextFormatting.RED + new TextComponentTranslation("text.morechickens.notbreedable").getFormattedText());
			else
			{    
			
				String parent1 = new TextComponentTranslation("entity." + chicken.getParent1().getEntityName() + ".name").getFormattedText();
				String parent2 = new TextComponentTranslation("entity." + chicken.getParent2().getEntityName() + ".name").getFormattedText();
				
				addLine(event, TextFormatting.YELLOW + new TextComponentTranslation("text.morechickens.breedable").getFormattedText() +": "+ 
								TextFormatting.RESET + TextFormatting.ITALIC + TextFormatting.GOLD + 
									parent1 + TextFormatting.RESET 
							+" & "+  
								TextFormatting.ITALIC + TextFormatting.GOLD + 
									parent2);
			}
			
			if(ChickenInformation.TOOLTIPCHICKENS.containsKey(event.getItemStack().getMetadata()))
			{
				ChickenInformation info = ChickenInformation.TOOLTIPCHICKENS.get(event.getItemStack().getMetadata());
				event.getToolTip().addAll(info.getToolTip());
			}
		}
	}
	
	
	private void addLine(ItemTooltipEvent event, String line)
	{
		event.getToolTip().add(line);
	}
}
