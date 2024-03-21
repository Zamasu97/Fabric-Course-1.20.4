package net.benny.mccourse.item;

import net.benny.mccourse.MCCourseMod;
import net.benny.mccourse.item.custom.MetalDetectorItem;
import net.benny.mccourse.item.custom.ModArmorItem;
import net.benny.mccourse.item.custom.ModPoisonSwordItem;
import net.benny.mccourse.item.custom.PaxelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
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
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterial.PINK_GARNET, 1, 5f,new FabricItemSettings()));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new ModPoisonSwordItem(ModToolMaterial.PINK_GARNET,5,5.0f,new FabricItemSettings().fireproof()));

    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterial.PINK_GARNET,1,0f,new FabricItemSettings()));

    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterial.PINK_GARNET,3,-5f, new FabricItemSettings()));

    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterial.PINK_GARNET,0,0.5f,new  FabricItemSettings()));

    public static final Item PINK_GARNET_PAXEL = registerItem("pink_garnet_paxel",
            new PaxelItem(ModToolMaterial.PINK_GARNET,0,0.5f,new  FabricItemSettings()));

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ArmorItem(ModArmorMaterials.PINK_GARNET,ArmorItem.Type.HELMET,new FabricItemSettings()));

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET,ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));

    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
            new ArmorItem(ModArmorMaterials.PINK_GARNET,ArmorItem.Type.LEGGINGS,new FabricItemSettings()));

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ArmorItem(ModArmorMaterials.PINK_GARNET,ArmorItem.Type.BOOTS,new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MCCourseMod.LOGGER.info("Registering mod items for " + MCCourseMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
