package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.ChickensMod;
import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;
import com.setycz.chickens.registry.LiquidEggRegistry;
import com.setycz.chickens.registry.LiquidEggRegistryItem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidChickensAddon extends BaseModAddon{


	
	public static ChickensRegistryItem oilFluidChicken = null;
		public static ItemStack oilEgg = ItemStack.EMPTY;

	
	public FluidChickensAddon() {
		super("miscfluidchickens", "Fluid Chickens", "textures/entity/fluids");
		this.setNeedsModPresent(false);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) {

		LiquidEggRegistry();
		
		if(!oilEgg.isEmpty())
			oilFluidChicken = addChicken(allChickens, 
				"oilchicken", 
				this.nextID(), 
				"oilchicken_chicken.png", 
				oilEgg, 
				0x989585, 0xd1ccb6, 
				SpawnType.NONE);
		
		
		
		return allChickens;
	}
	
	
	
	public void LiquidEggRegistry() {
		FluidHolder oilFluid = null;

		if(doesFluidExist("oil"))
			oilFluid = new FluidHolder(3, "oil", 0x2C2416); 
		else if(doesFluidExist("fluidoil"))
			oilFluid = new FluidHolder(3, "fluidoil", 0x2C2416); 
			
		if(oilFluid != null) { 
			LiquidEggRegistry.register(new LiquidEggRegistryItem(oilFluid.id, oilFluid.fluidBlock, oilFluid.color, oilFluid.fluid));
			oilEgg = new ItemStack(ChickensMod.liquidEgg, 1, 3);
		}
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) {
		
	}
	
	
	public boolean doesFluidExist(String fluidName) {
		if(FluidRegistry.isFluidRegistered(fluidName))
			return true;
		return false;
	}

	
	public class FluidHolder {
		public int id; 
		public Block fluidBlock;
		public Fluid fluid;
		public int color;
		
		FluidHolder(int idIn, String fluidName, int colorIn)
		{
			id = idIn;
			fluid = FluidRegistry.getFluid(fluidName);
			fluidBlock = fluid.getBlock();
			color = colorIn;
		}
		
		
	}
}

