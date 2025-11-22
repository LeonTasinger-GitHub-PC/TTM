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

        swordRecipeBuilder(ModItems.ALUMINIUM_SWORD, ModItems.ALUMINIUM, ModItems.ALUMINIUM, recipeExporter);
        swordRecipeBuilder(ModItems.SILUMIN_SWORD, ModItems.SILUMIN, ModItems.SILUMIN, recipeExporter);
        swordRecipeBuilder(ModItems.STEEL_SWORD, ModItems.STEEL, ModItems.STEEL, recipeExporter);

        pickaxeRecipeBuilder(ModItems.ALUMINIUM_PICKAXE, ModItems.ALUMINIUM, ModItems.ALUMINIUM, recipeExporter);
        pickaxeRecipeBuilder(ModItems.SILUMIN_PICKAXE, ModItems.SILUMIN, ModItems.SILUMIN, recipeExporter);
        pickaxeRecipeBuilder(ModItems.STEEL_PICKAXE, ModItems.STEEL, ModItems.STEEL, recipeExporter);

        shovelRecipeBuilder(ModItems.ALUMINIUM_SHOVEL, ModItems.ALUMINIUM, ModItems.ALUMINIUM, recipeExporter);
        shovelRecipeBuilder(ModItems.SILUMIN_SHOVEL, ModItems.SILUMIN, ModItems.SILUMIN, recipeExporter);
        shovelRecipeBuilder(ModItems.STEEL_SHOVEL, ModItems.STEEL, ModItems.STEEL, recipeExporter);

        axeRecipeBuilder(ModItems.ALUMINIUM_AXE, ModItems.ALUMINIUM, ModItems.ALUMINIUM, recipeExporter);
        axeRecipeBuilder(ModItems.SILUMIN_AXE, ModItems.SILUMIN, ModItems.SILUMIN, recipeExporter);
        axeRecipeBuilder(ModItems.STEEL_AXE, ModItems.STEEL, ModItems.STEEL, recipeExporter);

        hoeRecipeBuilder(ModItems.ALUMINIUM_HOE, ModItems.ALUMINIUM, ModItems.ALUMINIUM, recipeExporter);
        hoeRecipeBuilder(ModItems.SILUMIN_HOE, ModItems.SILUMIN, ModItems.SILUMIN, recipeExporter);
        hoeRecipeBuilder(ModItems.STEEL_HOE, ModItems.STEEL, ModItems.STEEL, recipeExporter);
    }
    private static void swordRecipeBuilder(ItemConvertible result, Item main, ItemConvertible requirement, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .input('I', main)
                .input('S', Items.STICK)
                .criterion(hasItem(requirement), conditionsFromItem(requirement))
                .offerTo(exporter);
    }

    private static void pickaxeRecipeBuilder(ItemConvertible result, Item main, ItemConvertible requirement, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("III")
                .pattern(" I ")
                .pattern(" S ")
                .input('I', main)
                .input('S', Items.STICK)
                .criterion(hasItem(requirement), conditionsFromItem(requirement))
                .offerTo(exporter);
    }

    private static void shovelRecipeBuilder(ItemConvertible result, Item main, ItemConvertible requirement, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .input('I', main)
                .input('S', Items.STICK)
                .criterion(hasItem(requirement), conditionsFromItem(requirement))
                .offerTo(exporter);
    }

    private static void axeRecipeBuilder(ItemConvertible result, Item main, ItemConvertible requirement, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("II")
                .pattern("SI")
                .pattern("S ")
                .input('I', main)
                .input('S', Items.STICK)
                .criterion(hasItem(requirement), conditionsFromItem(requirement))
                .offerTo(exporter);
    }

    private static void hoeRecipeBuilder(ItemConvertible result, Item main, ItemConvertible requirement, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("II")
                .pattern("S ")
                .pattern("S ")
                .input('I', main)
                .input('S', Items.STICK)
                .criterion(hasItem(requirement), conditionsFromItem(requirement))
                .offerTo(exporter);
    }
}
