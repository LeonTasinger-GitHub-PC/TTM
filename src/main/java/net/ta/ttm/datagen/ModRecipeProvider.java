package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
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


        offerBlasting(recipeExporter, SILICON_SMELTABLES, RecipeCategory.MISC, ModItems.SILICON, 0.25f, 400, "silicon");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SILICON, RecipeCategory.MISC, ModBlocks.SILICON_BLOCK);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_OBSIDIANITE, 9)
//                .pattern("AAA")
//                .pattern("AOA")
//                .pattern("AAA")
//                .input('A', Items.IRON_INGOT)
//                .input('O', Items.OBSIDIAN)
//                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
//                .offerTo(recipeExporter, Identifier.of(TTM.MOD_ID, "raw_obsidianite_from_vanilla_material"));
    }
}
