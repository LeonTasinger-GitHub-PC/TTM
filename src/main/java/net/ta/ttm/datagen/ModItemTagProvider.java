package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.ta.ttm.block.ModBlocks;
import net.ta.ttm.item.ModItems;
import net.ta.ttm.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ALUMINIUM_SWORD)
                .add(ModItems.SILUMIN_SWORD)
                .add(ModItems.STEEL_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ALUMINIUM_PICKAXE)
                .add(ModItems.SILUMIN_PICKAXE)
                .add(ModItems.STEEL_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ALUMINIUM_SHOVEL)
                .add(ModItems.SILUMIN_SHOVEL)
                .add(ModItems.STEEL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ALUMINIUM_AXE)
                .add(ModItems.SILUMIN_AXE)
                .add(ModItems.STEEL_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ALUMINIUM_HOE)
                .add(ModItems.SILUMIN_HOE)
                .add(ModItems.STEEL_HOE);

    }
}
