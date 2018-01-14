package com.gendeathrow.morechickens.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gendeathrow.morechickens.core.ChickensMore;

import net.minecraft.util.text.TextFormatting;

public class ChickenInformation 
{

	public static HashMap<String, ChickenInformation> TOOLTIPCHICKENS = new HashMap<String, ChickenInformation>();
	
	/*
	 * From Mod
	 */
	private String registeredMod;
	/**
	 * Creator of chicken
	 */
	private String author;
	/*
	 * Chickens mod ID for addon
	 */
	private String addon;
	
	public ChickenInformation(String registeredMod, String author, String registeredAddon)
	{
		this.registeredMod = registeredMod;
		this.author = author;
		this.addon = registeredAddon;
	}
	
	public List<String> getToolTip()
	{
		List<String> tip= new ArrayList<String>();

		if(this.addon != ChickensMore.NAME)
		{
			tip.add(TextFormatting.ITALIC +""+ TextFormatting.LIGHT_PURPLE + this.getRegisteredAddon());
		}
		
		tip.add(TextFormatting.BLUE +""+ TextFormatting.ITALIC + this.getRegisteredMod());
		//Arrays.asList(new String[]{, TextFormatting.BLUE +""+ TextFormatting.ITALIC + this.getRegisteredMod()})
		return tip;
	}
	
	
	public String getRegisteredMod()
	{
		return this.registeredMod;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public String getRegisteredAddon()
	{
		return this.addon;
	}
	
	
	
	
	public static void AddChickenInformation(String ChickenID, ChickenInformation info)
	{
		ChickenInformation.TOOLTIPCHICKENS.put(ChickenID, info);
	}
	
	
}
