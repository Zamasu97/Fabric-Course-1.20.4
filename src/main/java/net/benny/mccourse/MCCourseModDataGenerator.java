package net.benny.mccourse;

import net.benny.mccourse.datagen.ModBlockLootTableGenerator;
import net.benny.mccourse.datagen.ModBlockTagProvider;
import net.benny.mccourse.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MCCourseModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockLootTableGenerator::new);
		pack.addProvider(ModBlockTagProvider::new);

	}
}
