package net.ta.ttm;

import net.fabricmc.api.ModInitializer;

import net.ta.ttm.block.ModBlocks;
import net.ta.ttm.item.ModItemGroups;
import net.ta.ttm.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TTM implements ModInitializer {
	public static final String MOD_ID = "ttm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}