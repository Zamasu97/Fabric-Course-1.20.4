package net.benny.mccourse.block;

import net.benny.mccourse.MCCourseMod;
import net.benny.mccourse.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),FabricBlockSettings.copyOf(Blocks.NETHERRACK)));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON,10,FabricBlockSettings.copyOf(Blocks.STONE_BUTTON)));

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        MCCourseMod.LOGGER.info("Registering ModBlocks for " + MCCourseMod.MOD_ID);
    }
    }