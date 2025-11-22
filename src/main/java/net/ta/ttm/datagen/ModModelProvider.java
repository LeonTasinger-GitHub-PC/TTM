package net.ta.ttm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.ta.ttm.block.ModBlocks;
import net.ta.ttm.block.custom.MetalLampBlock;
import net.ta.ttm.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Normal block
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUARTZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILICON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAUXITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILUMIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);

        //The lamp
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.METAL_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.METAL_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.METAL_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(MetalLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CRUDE_SILICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAUXITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALUMINIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILUMIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHITE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.ALUMINIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ALUMINIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILUMIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILUMIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILUMIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILUMIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILUMIN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);
    }
}
