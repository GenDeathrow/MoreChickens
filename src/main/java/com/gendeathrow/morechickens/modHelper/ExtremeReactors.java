package com.gendeathrow.morechickens.modHelper;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class ExtremeReactors
{
    private static String skinLocation = "textures/entity/extreme_reactors/";

    public static ChickensRegistryItem yelloriumChicken = null;

    public static ChickensRegistryItem cyaniteChicken = null;

    public static ChickensRegistryItem blutoniumChicken = null;

    public static ChickensRegistryItem ludicriteChicken = null;

    public static ChickensRegistryItem graphiteChicken = null;


    public static List<ChickensRegistryItem> tryRegisterChickens(List<ChickensRegistryItem> chickens)
    {

        ChickensMore.logger.info("Looking for Extreme Reactors addon...");
        if(!Loader.isModLoaded("bigreactors")) return chickens;
        ChickensMore.logger.info("Loading Extreme Reactors addon...");

        for (String x: OreDictionary.getOreNames()) {
            System.out.println(x);
        }

        chickens = registerChickens(chickens);

        return chickens;
    }

    public static List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> chickens)
    {
        List<ItemStack> ingotYellorium = OreDictionary.getOres("ingotYellorium");
        List<ItemStack> ingotCyanite =  OreDictionary.getOres("ingotCyanite");
        List<ItemStack> ingotGraphite =  OreDictionary.getOres("ingotGraphite");
        List<ItemStack> ingotBlutonium =  OreDictionary.getOres("ingotBlutonium");
        List<ItemStack> ingotLudicrite =  OreDictionary.getOres("ingotLudicrite");

        if(ingotYellorium.size() > 0)
        {
            yelloriumChicken = new ChickensRegistryItem(
                    2100,
                    "yelloriumChicken",
                    new ResourceLocation(ChickensMore.MODID, skinLocation + "yellorium_chicken.png"),
                    ingotYellorium.get(0).copy(),
                    0xA5B700,
                    0xD7EF00
            ).setSpawnType(SpawnType.NONE);
            chickens.add(yelloriumChicken);

            yelloriumChicken.setParents(
                    ChickensMore.findChickenChickensMod("GlowstoneChicken"),
                    ChickensMore.findChickenChickensMod("RedstoneChicken")
            );
        }

        if (ingotGraphite.size() > 0) {
            graphiteChicken = new ChickensRegistryItem(
                    2101,
                    "graphiteChicken",
                    new ResourceLocation(ChickensMore.MODID, skinLocation + "graphite_chicken.png"),
                    ingotGraphite.get(0).copy(),
                    0x41453F,
                    0x595959
            ).setSpawnType(SpawnType.NONE);
            chickens.add(graphiteChicken);

            graphiteChicken.setParents(
                    ChickensMore.findChickenChickensMod("CoalChicken"),
                    ChickensMore.findChickenChickensMod("BlackChicken")
            );
        }

        if (ingotCyanite.size() > 0) {
            cyaniteChicken = new ChickensRegistryItem(
                    2102,
                    "cyaniteChicken",
                    new ResourceLocation(ChickensMore.MODID, skinLocation + "cyanite_chicken.png"),
                    ingotCyanite.get(0).copy(),
                    0x0068B4,
                    0x5CAFDB
            ).setSpawnType(SpawnType.NONE);
            chickens.add(cyaniteChicken);

            cyaniteChicken.setParents(
                    yelloriumChicken,
                    ChickensMore.findChickenChickensMod("SandChicken")
            );
        }

        if (ingotBlutonium.size() > 0) {
            blutoniumChicken = new ChickensRegistryItem(
                    2103,
                    "blutoniumChicken",
                    new ResourceLocation(ChickensMore.MODID, skinLocation + "blutonium_chicken.png"),
                    ingotBlutonium.get(0).copy(),
                    0x4642D6,
                    0xf5fcf1
            ).setSpawnType(SpawnType.NONE);
            chickens.add(blutoniumChicken);

            blutoniumChicken.setParents(
                    cyaniteChicken,
                    ChickensMore.findChickenChickensMod("WaterChicken")
            );
        }

        //Should add Nether Star Chicken and make it an ingredient
        /*if (ingotLudicrite.size() > 0) {
            ludicriteChicken = new ChickensRegistryItem(
                    2104,
                    "ludicriteChicken",
                    new ResourceLocation(ChickensMore.MODID, skinLocation + "ludicrite_chicken.png"),
                    ingotLudicrite.get(0).copy(),
                    0xB600A2,
                    0xC95BDB
            ).setSpawnType(SpawnType.NONE);
            chickens.add(ludicriteChicken);

            ludicriteChicken.setParents(
                    blutoniumChicken,
                    cyaniteChicken //TODO: ChickensMore.findChicken("netherStarChicken")
            );
        }*/

        return chickens;
    }


}
