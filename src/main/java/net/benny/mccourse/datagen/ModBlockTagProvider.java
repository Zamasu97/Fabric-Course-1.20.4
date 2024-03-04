package net.benny.mccourse.datagen;

import net.benny.mccourse.block.ModBlocks;
import net.benny.mccourse.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.RAW_PINK_GARNET_BLOCK,
                        ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.END_STONE_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE,
                        ModBlocks.PINK_GARNET_SLAB,
                        ModBlocks.PINK_GARNET_STAIRS);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_PINK_GARNET_ORE)
                .add(ModBlocks.END_STONE_PINK_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK);
    }
}
