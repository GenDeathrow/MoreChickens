package com.gendeathrow.morechickens.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SolidXp extends Item
{

	public SolidXp()
	{
		super();
		this.setRegistryName("solidxp");
		this.setUnlocalizedName("morechickens.solidxp");
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
    public boolean hasCustomEntity(ItemStack stack)
    {
        return true;
    }
    
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        return new EntityXPOrb(world, location.posX, location.posY, location.posZ, 25);
    }
}
