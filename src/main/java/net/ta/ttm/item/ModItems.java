package net.ta.ttm.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;

public class ModItems {
    public static final Item OBSIDIANITE = registerItem("obsidianite", new Item(new Item.Settings()));
    public static final Item RAW_OBSIDIANITE = registerItem("raw_obsidianite", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TTM.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TTM.LOGGER.info("Registering Mod Items for" + TTM.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_OBSIDIANITE);
            entries.add(OBSIDIANITE);
        });
    }
}
