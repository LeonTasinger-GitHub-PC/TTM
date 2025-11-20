package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;
import net.ta.ttm.block.ModBlocks;
import net.ta.ttm.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> OBSIDIANITE_SMELTABLES = List.of(ModItems.RAW_OBSIDIANITE);

        offerSmelting(recipeExporter, OBSIDIANITE_SMELTABLES, RecipeCategory.MISC, ModItems.OBSIDIANITE, 0.25f, 200, "obsidianite");
        offerBlasting(recipeExporter, OBSIDIANITE_SMELTABLES, RecipeCategory.MISC, ModItems.OBSIDIANITE, 0.25f, 200, "obsidianite");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIANITE, RecipeCategory.MISC, ModBlocks.OBSIDIANITE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_OBSIDIANITE, RecipeCategory.MISC, ModBlocks.RAW_OBSIDIANITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_OBSIDIANITE, 9)
                .pattern("AAA")
                .pattern("AOA")
                .pattern("AAA")
                .input('A', Items.IRON_INGOT)
                .input('O', Items.OBSIDIAN)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(recipeExporter, Identifier.of(TTM.MOD_ID, "raw_obsidianite_from_vanilla_material"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("OOO")
                .pattern("OAO")
                .pattern("OOO")
                .input('A', Items.ANCIENT_DEBRIS)
                .input('O', ModItems.OBSIDIANITE)
                .criterion(hasItem(ModItems.OBSIDIANITE), conditionsFromItem(ModItems.OBSIDIANITE))
                .offerTo(recipeExporter);

    }
}
