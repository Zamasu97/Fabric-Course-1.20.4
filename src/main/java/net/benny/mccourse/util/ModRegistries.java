package net.benny.mccourse.util;

import net.benny.mccourse.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
    }

    private static void registerFuels(){
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.PEAT_BRICK, 200);

    }
}
