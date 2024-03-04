package net.benny.mccourse.datagen;

import net.benny.mccourse.block.ModBlocks;
import net.benny.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P',ModItems.PINK_GARNET)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PINK_GARNET) + "_"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PINK_GARNET_STAIRS)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .input('S',ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.PINK_GARNET_STAIRS) + "_"));


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.SALTED_CAULIFLOWER)
                .input(ModItems.BAKED_CAULIFLOWER)
                .input(Items.DRIED_KELP)
                .criterion(hasItem(ModItems.BAKED_CAULIFLOWER), conditionsFromItem(ModItems.BAKED_CAULIFLOWER))
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BAKED_CAULIFLOWER) + "_"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET,
                        ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE,
                        ModBlocks.END_STONE_PINK_GARNET_ORE),
                RecipeCategory.MISC,ModItems.PINK_GARNET,2.5f,200,"pink_garnet");

        offerFoodCookingRecipe(exporter, "furnace", CookingRecipeSerializer.SMELTING, SmeltingRecipe::new,100,ModItems.CAULIFLOWER,ModItems.BAKED_CAULIFLOWER,0.35f);

        offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE),
                RecipeCategory.MISC,ModItems.PINK_GARNET,2.5f,100,"pink_garnet");
    }
}
