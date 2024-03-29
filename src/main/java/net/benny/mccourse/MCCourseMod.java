package net.benny.mccourse;

import net.benny.mccourse.block.ModBlocks;
import net.benny.mccourse.item.ModItemGroup;
import net.benny.mccourse.item.ModItems;
import net.benny.mccourse.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	//test comment
	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}