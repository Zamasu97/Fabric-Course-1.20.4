package net.benny.mccourse.datagen;

import net.benny.mccourse.block.ModBlocks;
import net.benny.mccourse.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

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
                        ModBlocks.PINK_GARNET_PRESSURE_PLATE,
                        ModBlocks.PINK_GARNET_STAIRS,
                        ModBlocks.PINK_GARNET_WALL,
                        ModBlocks.PINK_GARNET_FENCE,
                        ModBlocks.PINK_GARNET_FENCE_GATE,
                        ModBlocks.PINK_GARNET_DOOR,
                        ModBlocks.PINK_GARNET_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_PINK_GARNET_ORE)
                .add(ModBlocks.END_STONE_PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.PINK_GARNET_WALL);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PINK_GARNET_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_5")))
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);
    }
}
