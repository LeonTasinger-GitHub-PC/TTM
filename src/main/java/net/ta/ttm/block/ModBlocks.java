package net.ta.ttm.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;

public class ModBlocks {
    public static final Block OBSIDIANITE_BLOCK = registerBlock("obsidianite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(10f)
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
