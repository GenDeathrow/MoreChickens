package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExtraUtilitiesAddon extends BaseModAddon
{
	@GameRegistry.ObjectHolder("extrautils2:decorativesolid")
	public static final Item decorativeSolid = null;

	@GameRegistry.ObjectHolder("extrautils2:decorativesolidwood")
	public static final Item decorativeSolidWood = null;

	public static ChickensRegistryItem redstoneCrystalChicken = null;
	public static ChickensRegistryItem stoneburntChicken = null;
	public static ChickensRegistryItem lunarReactiveDustChicken = null;
	public static ChickensRegistryItem moonstoneChicken = null;
	public static ChickensRegistryItem magicalWoodChicken = null;
	public static ChickensRegistryItem demonMetalChicken = null;

	public ExtraUtilitiesAddon()
	{
		super("extrautils2", "Extra Utilities 2","textures/entity/extrautils2/");
		this.setStartID(2120);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens)
	{

		redstoneCrystalChicken = addChicken(allChickens,
				"redstonecrystalchicken",
				this.nextID(),
				"redstone_crystal_chicken.png",
				this.getFirstOreDictionary("gemRedstone"),
				0xBF0000, 0x7E0000,
				SpawnType.NONE);

		ItemStack stoneburnt = new ItemStack(decorativeSolid, 1, 3);
		stoneburntChicken = addChicken(allChickens,
				"stoneburntchicken",
				this.nextID(),
				"stoneburnt_chicken.png",
				stoneburnt,
				0x555555, 0x202020,
				SpawnType.NONE);

		lunarReactiveDustChicken = addChicken(allChickens,
				"lunarreactivedustchicken",
				this.nextID(),
				"lunar_reactive_dust_chicken.png",
				this.getFirstOreDictionary("dustLunar"),
				0xF251D1, 0x87026B,
				SpawnType.NONE);

		moonstoneChicken = addChicken(allChickens,
				"moonstonechicken",
				this.nextID(),
				"moonstone_chicken.png",
				this.getFirstOreDictionary("gemMoon"),
				0xCDE6F7, 0x636F76,
				SpawnType.NONE);

		ItemStack magicalWood = new ItemStack(decorativeSolidWood, 1, 1);
		magicalWoodChicken = addChicken(allChickens,
				"magicalwoodchicken",
				this.nextID(),
				"magical_wood_chicken.png",
				magicalWood,
				0x9F844D, 0xEED83D,
				SpawnType.NONE);

		demonMetalChicken = addChicken(allChickens,
				"demonmetalchicken",
				this.nextID(),
				"demon_metal_chicken.png",
				this.getFirstOreDictionary("ingotDemonicMetal"),
				0xF00B00, 0xFFAA00,
				SpawnType.NONE);

		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens)
	{
		if(Loader.isModLoaded("EnderIO"))
		{
			setParents(redstoneCrystalChicken, EnderIOAddon.redstoneAlloyChicken, PCrystalChicken);
			setParents(stoneburntChicken, redstoneCrystalChicken, EnderIOAddon.darkSteelChicken);
			setParents(lunarReactiveDustChicken, redstoneCrystalChicken, BlueChicken);
			setParents(moonstoneChicken, lunarReactiveDustChicken, EnderIOAddon.vibrantAlloyChicken);
			setParents(magicalWoodChicken, LogChicken, MoreChickens.xpChicken);
			setParents(demonMetalChicken, magicalWoodChicken, moonstoneChicken);
		}
		else
		{
			setParents(redstoneCrystalChicken, RedstoneChicken, PCrystalChicken);
			setParents(stoneburntChicken, redstoneCrystalChicken, GoldChicken);
			setParents(lunarReactiveDustChicken, redstoneCrystalChicken, BlueChicken);
			setParents(moonstoneChicken, lunarReactiveDustChicken, BlazeChicken);
			setParents(magicalWoodChicken, LogChicken, MoreChickens.xpChicken);
			setParents(demonMetalChicken, magicalWoodChicken, moonstoneChicken);
		}
	}

}
