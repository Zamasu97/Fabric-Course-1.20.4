package net.benny.mccourse.item;

import net.benny.mccourse.MCCourseMod;
import net.benny.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item((new FabricItemSettings())));

    /*
     public static void init() {
        PINK_GARNET = registerItem("pink_garnet", new Item(new FabricItemSettings()));
        RAW_PINK_GARNET = registerItem("raw_pink_garnet",
                new Item((new FabricItemSettings())));
    }
    */

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MCCourseMod.LOGGER.info("Registering mod items for " + MCCourseMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
