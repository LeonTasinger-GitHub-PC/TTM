package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.ta.ttm.block.ModBlocks;
import net.ta.ttm.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.QUARTZ_ORE)
                .add(ModBlocks.SILICON_BLOCK)
                .add(ModBlocks.METAL_LAMP)
                .add(ModBlocks.BAUXITE_ORE)
                .add(ModBlocks.ALUMINIUM_BLOCK)
                .add(ModBlocks.SILUMIN_BLOCK)
                .add(ModBlocks.GRAPHITE_BLOCK)
                .add(ModBlocks.STEEL_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILICON_BLOCK)
                .add(ModBlocks.BAUXITE_ORE)
                .add(ModBlocks.ALUMINIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ALUMINIUM_TOOL)
                .add(ModBlocks.METAL_LAMP)
                .add(ModBlocks.GRAPHITE_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SILUMIN_TOOL)
                .add(ModBlocks.SILUMIN_BLOCK)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_STEEL_TOOL)
                .add(ModBlocks.QUARTZ_ORE)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
