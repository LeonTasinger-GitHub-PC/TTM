package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
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
        List<ItemConvertible> SILICON_SMELTABLES = List.of(Items.QUARTZ,
                Items.NETHER_QUARTZ_ORE, ModBlocks.QUARTZ_ORE);


        //offerBlasting(recipeExporter, SILICON_SMELTABLES, RecipeCategory.MISC, ModItems.CRUDE_SILICON, 0.25f, 400, "silicon");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CRUDE_SILICON, RecipeCategory.MISC, ModBlocks.SILICON_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ALUMINIUM, RecipeCategory.MISC, ModBlocks.ALUMINIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.SILUMIN, RecipeCategory.MISC, ModBlocks.SILUMIN_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.GRAPHITE, RecipeCategory.MISC, ModBlocks.GRAPHITE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.STEEL, RecipeCategory.MISC, ModBlocks.STEEL_BLOCK);


    }
}
