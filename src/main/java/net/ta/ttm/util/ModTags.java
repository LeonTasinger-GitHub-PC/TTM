package net.ta.ttm.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TTM.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> DECAYABLE_METAL = createTag("decayable_metal");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TTM.MOD_ID, name));
        }
    }
}
