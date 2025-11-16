package net.ta.ttm.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;

public class ModBlocks {
    public static final Block OBSIDIANITE_BLOCK = registerBlock("obsidianite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(25f, 12f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block RAW_OBSIDIANITE_BLOCK = registerBlock("raw_obsidianite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(12f, 6f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.OBSIDIANITE_BLOCK);
            entries.add(ModBlocks.RAW_OBSIDIANITE_BLOCK);
        });
    }
}
