package com.gendeathrow.morechickens.core.proxies;


import com.gendeathrow.morechickens.core.ModItems;
import com.gendeathrow.morechickens.handlers.EggTooltips;
import com.setycz.chickens.ChickensMod;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	
	
	@Override
	public boolean isClient()
	{
		return true;
	}
	
	@Override
	public boolean isOpenToLAN()
	{
		if (Minecraft.getMinecraft().isIntegratedServerRunning())
		{
			return Minecraft.getMinecraft().getIntegratedServer().getPublic();
		} else
		{
			return false;
		}
	}
	
	@Override
	public void registerTickHandlers()
	{
		super.registerTickHandlers();
	}
	
	@Override
	public void registerEventHandlers()
	{
		super.registerEventHandlers();
		
		MinecraftForge.EVENT_BUS.register(new EggTooltips());
		
//			GuiEventHandler guieventhandler = new GuiEventHandler();
//    		MinecraftForge.EVENT_BUS.register(guieventhandler);
//   
//    		FMLCommonHandler.instance().bus().register(new KeyBinds());
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		
	}
	
	@Override
	public void initRenderers()
	{
		registerItemModel(ModItems.solidXp);
	}
	
	
    @Override
    public void registerChicken(ChickensRegistryItem chicken) {
        super.registerChicken(chicken);

        //registerItemModel(ChickensMod.spawnEgg, chicken.getId());

        if (chicken.isDye()) {
            registerItemModel(ChickensMod.coloredEgg, chicken.getDyeMetadata());
        }
    }
    
    private void registerItemModel(Item item, int meta) {
        ModelResourceLocation resourceLocation = new ModelResourceLocation(ChickensMod.MODID + ":" + ChickensMod.getItemName(item), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resourceLocation);
    }
	@SideOnly(Side.CLIENT)
	public static void registerBlockModel(Block block)
	{
		registerBlockModel(block, 0, block.getRegistryName().toString());
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockModel(Block block, int meta, String name)
	{
		Item item = Item.getItemFromBlock(block);
		ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
		
		if(!name.equals(item.getRegistryName()))
		{
		    ModelBakery.registerItemVariants(item, model);
		}
		
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, model);
	}
	
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModel(Item item)
	{
		registerItemModel(item, 0, item.getRegistryName().toString());
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModel(Item item, int meta, String name)
	{
		ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
		
		if(!name.equals(item.getRegistryName()))
		{
		    ModelBakery.registerItemVariants(item, model);
		}
		
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, model);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	
	public void VoxelMenu()
	{
//		try
//		{
//
//			Class<? extends GuiMainMenu> ingameGuiClass = (Class<? extends GuiMainMenu>) Class.forName("com.thevoxelbox.voxelmenu.ingame.GuiIngameMenu");
//			Method mRegisterCustomScreen = ingameGuiClass.getDeclaredMethod("registerCustomScreen", String.class, Class.class, String.class);
//			
//			mRegisterCustomScreen.invoke(null, "", EM_Gui_Menu.class, StatCollector.translateToLocal("options.enviromine.menu.title"));
//		
//			boolean voxelMenuExists = true;
//		} catch (ClassNotFoundException ex) { // This means VoxelMenu does not
//			// 	exist
//			boolean voxelMenuExists = false;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
