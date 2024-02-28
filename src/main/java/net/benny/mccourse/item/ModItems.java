package net.benny.mccourse.item;

import net.benny.mccourse.MCCourseMod;
import net.benny.mccourse.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item((new FabricItemSettings())));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem((new FabricItemSettings().maxDamage(256))));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new FabricItemSettings().food((ModFoodComponents.CAULIFLOWER))));

    public static final Item BAKED_CAULIFLOWER = registerItem("baked_cauliflower",
            new Item(new FabricItemSettings().food((ModFoodComponents.BAKED_CAULIFLOWER))));

    public static final Item SALTED_CAULIFLOWER = registerItem("salted_cauliflower",
            new Item(new FabricItemSettings().food((ModFoodComponents.SALTED_CAULIFLOWER))));

    public static final Item PEAT_BRICK = registerItem("peat_brick",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MCCourseMod.LOGGER.info("Registering mod items for " + MCCourseMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
