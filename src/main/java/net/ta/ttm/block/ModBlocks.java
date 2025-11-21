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
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block SILICON_BLOCK = registerBlock("silicon_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block METAL_LAMP = registerBlock("metal_lamp",
            new MetalLampBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .luminance(state -> state.get(MetalLampBlock.CLICKED) ? 15 : 0)));

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
