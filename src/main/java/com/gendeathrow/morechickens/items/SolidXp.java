package com.gendeathrow.morechickens.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SolidXp extends Item
{

	public SolidXp()
	{
		super();
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
    public boolean hasCustomEntity(ItemStack stack)
    {
        return true;
    }
    
    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        return new EntityXPOrb(world, location.posX, location.posY, location.posZ, 25*itemstack.getCount());
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	ItemStack itemStackIn = playerIn.getHeldItem(hand);
    	
        if (!playerIn.capabilities.isCreativeMode)
        {
            itemStackIn.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
    		EntityXPOrb entityexp = new EntityXPOrb(worldIn, playerIn.posX, playerIn.posY+1, playerIn.posZ, 25);
            worldIn.spawnEntity(entityexp);
    	}
        
        playerIn.addStat(StatList.getObjectUseStats(this));
    	return EnumActionResult.SUCCESS;
    }

}
