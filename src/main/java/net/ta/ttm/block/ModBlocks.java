package net.ta.ttm.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.ta.ttm.TTM;
import net.ta.ttm.block.custom.MetalLampBlock;

public class ModBlocks {
    public static final Block QUARTZ_ORE = registerBlock("quartz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(8f, 8f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block SILICON_BLOCK = registerBlock("silicon_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f, 10f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block METAL_LAMP = registerBlock("metal_lamp",
            new MetalLampBlock(AbstractBlock.Settings.create()
                    .strength(2f, 2f)
                    .requiresTool()
                    .luminance(state -> state.get(MetalLampBlock.CLICKED) ? 15 : 0)));

    public static final Block BAUXITE_ORE = registerBlock("bauxite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3.5f, 4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block ALUMINIUM_BLOCK = registerBlock("aluminium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f, 5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block SILUMIN_BLOCK = registerBlock("silumin_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f, 10f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block GRAPHITE_BLOCK = registerBlock("graphite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.5f, 3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f, 10f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TTM.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TTM.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TTM.LOGGER.info("Registering Mod Blocks for " + TTM.MOD_ID);
    }
}
